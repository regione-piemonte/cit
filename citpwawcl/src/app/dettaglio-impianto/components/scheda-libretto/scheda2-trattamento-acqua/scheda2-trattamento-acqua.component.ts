import { ViewportScroller } from '@angular/common';
import { Component, HostListener, OnDestroy, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Subject } from 'rxjs';
import { distinctUntilChanged, startWith } from 'rxjs/operators';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { BackService } from 'src/app/services/back.service';
import { LibrettoService } from 'src/app/services/libretto.service';
import { MessageService } from 'src/app/services/message.service';
import { EDIT_Q_PARAM, SharedService, VIEW_Q_PARAM } from 'src/app/services/shared.service';
import { SpinnerService } from 'src/app/services/spinner.service';
import { TitleService } from 'src/app/services/title.service';
import { ANIMATION_DO_FADE, RUOLI } from 'src/app/utils/constants';
import * as xml2js from 'xml2js';

@Component({
    selector: 'app-scheda2-trattamento-acqua',
    templateUrl: './scheda2-trattamento-acqua.component.html',
    styleUrls: ['./scheda2-trattamento-acqua.component.scss'],
    styles: [ANIMATION_DO_FADE]
})
export class Scheda2TrattamentoAcquaComponent implements OnInit, OnDestroy {
    parser = new xml2js.Parser({
        tagNameProcessors: [(name) => name.replace(/^.+:/, '')],
        explicitArray: false
    });
    scheda2: Scheda2;
    isModifica: boolean = false;
    isSuccess: boolean = false;
    doFade: boolean = false;
    panelOpenState: boolean = false;
    $destroy = new Subject();
    heightBreakpoint: number;
    formColBreakpoint: number = 2
    form: FormGroup;
    onlyView: boolean = false;
    loaded = false;
    ruolo: string
    datiInseriti = false

    constructor(
        private scroller: ViewportScroller,
        private titleService: TitleService,
        private backService: BackService,
        private router: Router,
        private fb: FormBuilder,
        private sharedService: SharedService,
        private librettoService: LibrettoService,
        private spinnerService: SpinnerService,
        private route: ActivatedRoute,
        private authService: AuthenticationService,
        private readonly messageService: MessageService
    ) {
        this.ruolo = this.authService.getCurrentUserFromSession()?.ruoloLoggato?.ruolo;
    }

    modificaVisibile() {
        return ((this.ruolo == RUOLI.RUOLO_IMPRESA
            || this.ruolo == RUOLI.RUOLO_SUPER
            || this.ruolo == RUOLI.RUOLO_ISPETTORE
            || this.ruolo == RUOLI.RUOLO_VALIDATORE))
            // && this.datiInseriti)
            // || ((this.ruolo == RUOLI.RUOLO_IMPRESA
            //     || this.ruolo == RUOLI.RUOLO_SUPER
            //     || this.ruolo == RUOLI.RUOLO_ISPETTORE
            //     || this.ruolo == RUOLI.RUOLO_VALIDATORE
            //     || this.ruolo == RUOLI.RUOLO_RESPONSABILE
            //     || this.ruolo == RUOLI.RUOLO_PROPRIETARIO
            //     || this.ruolo == RUOLI.RUOLO_RESPONSABILE_IMPRESA
            //     || this.ruolo == RUOLI.RUOLO_PROPRIETARIO_IMPRESA
            //     || this.ruolo == RUOLI.RUOLO_3RESPONSABILE)
            //     && !this.datiInseriti)
    }

    ngOnInit(): void {
        this.datiInseriti = false

        this.form = this.fb.group({
            l21H2oClimam3: [null],
            l22DurezzaH2oFr: [null],
            l23FlgTrattClimaAssente: [null],
            l23FlgTrattClimaFiltr: [null],
            l23FlgTrattClimaAddolc: [null],
            l23DurezzaTotH2oFr: [null,],
            l23FlgTrattClimaChimico: [null],
            l23FlgTrattGeloAssente: [null],
            l23FlgTrattGeloGliEtil: [null],
            l23PercGliEtil: [null,],
            l23PhGliEtil: [null,],
            l23FlgTrattGeloGliProp: [null],
            l23PercGliProp: [null,],
            l23PhGliProp: [null,],
            l24FlgTrattAcsAssente: [null],
            l24FlgTrattAcsFiltr: [null],
            l24FlgTrattAcsAddolc: [null],
            l24DurezzaAddolcFr: [null],
            l24FlgTrattAcsChimico: [null],
            l25FlgTrattRaffAssente: [null],
            l25TipologiaTrattRaff: [null],
            l25TipologiaOrigineH2O: [null],
            l25TipologiaTrattH2OEsisFiltr: [null],
            l25TrattFAltro: [null],
            l25TipologiaTrattH2OEsisTrattH2O: [null],
            l25TrattTAltro: [null],
            l25TipologiaTrattCondChimico: [null],
            l25TrattCAltro: [null],
            l25FlgSpurgoAutom: [null],
            l25ConducH2oIng: [null],
            l25Taratura: [null],
        })

        this.form.controls.l23FlgTrattClimaAddolc.valueChanges
            .pipe(
                distinctUntilChanged(),
                startWith(this.form.controls.l23FlgTrattClimaAddolc.value))
            .subscribe((activated: boolean) => {
                this.form.controls.l23DurezzaTotH2oFr.setValue(null);
                if (activated)
                    this.form.controls.l23DurezzaTotH2oFr.setValidators(Validators.required)
                else
                    this.form.controls.l23DurezzaTotH2oFr.clearValidators()

                this.form.controls.l23DurezzaTotH2oFr.updateValueAndValidity()
            })

        this.form.controls.l23FlgTrattGeloGliEtil.valueChanges
            .pipe(
                distinctUntilChanged(),
                startWith(this.form.controls.l23FlgTrattGeloGliEtil.value))
            .subscribe((activated: boolean) => {
                this.form.controls.l23PercGliEtil.setValue(null);
                this.form.controls.l23PhGliEtil.setValue(null);
                if (activated) {
                    this.form.controls.l23PercGliEtil.setValidators([Validators.required, Validators.min(0), Validators.max(100)])
                    this.form.controls.l23PhGliEtil.setValidators([Validators.required, Validators.min(0), Validators.max(100)])
                } else {
                    this.form.controls.l23PercGliEtil.clearValidators()
                    this.form.controls.l23PhGliEtil.clearValidators()
                }

                this.form.controls.l23PercGliEtil.updateValueAndValidity()
                this.form.controls.l23PhGliEtil.updateValueAndValidity()
            })

        this.form.controls.l23FlgTrattGeloGliProp.valueChanges
            .pipe(
                startWith(this.form.controls.l23FlgTrattGeloGliProp.value),
                distinctUntilChanged())
            .subscribe((activated: boolean) => {
                this.form.controls.l23PercGliProp.setValue(null);
                this.form.controls.l23PhGliProp.setValue(null);
                if (activated) {
                    this.form.controls.l23PercGliProp.setValidators([Validators.required, Validators.min(0), Validators.max(100)])
                    this.form.controls.l23PhGliProp.setValidators([Validators.required, Validators.min(0), Validators.max(14)])
                } else {
                    this.form.controls.l23PercGliProp.clearValidators()
                    this.form.controls.l23PhGliProp.clearValidators()
                }

                this.form.controls.l23PercGliProp.updateValueAndValidity()
                this.form.controls.l23PhGliProp.updateValueAndValidity()
            })

        this.form.controls.l24FlgTrattAcsAddolc.valueChanges
            .pipe(
                distinctUntilChanged(),
                startWith(this.form.controls.l24FlgTrattAcsAddolc.value))
            .subscribe((activated: boolean) => {
                this.form.controls.l24DurezzaAddolcFr.setValue(null);
                if (activated)
                    this.form.controls.l24DurezzaAddolcFr.setValidators(Validators.required)
                else
                    this.form.controls.l24DurezzaAddolcFr.clearValidators()

                this.form.controls.l24DurezzaAddolcFr.updateValueAndValidity()
            })

        this.form.controls.l25TipologiaTrattH2OEsisFiltr.valueChanges
            .pipe(
                distinctUntilChanged(),
                startWith(this.form.controls.l25TipologiaTrattH2OEsisFiltr.value))
            .subscribe((id: number) => {
                this.form.controls.l25TrattFAltro.setValue(null);
                if (id === 3){
                    this.form.controls.l25TrattFAltro.setValidators(Validators.required)
                }else
                    this.form.controls.l25TrattFAltro.clearValidators()

                this.form.controls.l25TrattFAltro.updateValueAndValidity()
            })

        this.form.controls.l25TipologiaTrattH2OEsisTrattH2O.valueChanges
            .pipe(
                distinctUntilChanged(),
                startWith(this.form.controls.l25TipologiaTrattH2OEsisTrattH2O.value))
            .subscribe((id: number) => {
                this.form.controls.l25TrattTAltro.setValue(null);
                if (id === 4){
                    this.form.controls.l25TrattTAltro.setValidators(Validators.required)
                }
                else
                    this.form.controls.l25TrattTAltro.clearValidators()

                this.form.controls.l25TrattTAltro.updateValueAndValidity()
            })

        this.form.controls.l25TipologiaTrattCondChimico.valueChanges
            .pipe(
                distinctUntilChanged(),
                startWith(this.form.controls.l25TipologiaTrattCondChimico.value))
            .subscribe((id: number) => {
                this.form.controls.l25TrattCAltro.setValue(null);
                if (id === 5)
                    this.form.controls.l25TrattCAltro.setValidators(Validators.required)
                else
                    this.form.controls.l25TrattCAltro.clearValidators()

                this.form.controls.l25TrattCAltro.updateValueAndValidity()
            })

        this.changeStyle(window.innerWidth);
        this.titleService.setTitle("Trattamento Acqua");
        this.backService.setBackTitle("Torna a scheda libretto");
        const urlOriginal = this.router.url;
        //fix devo togliere anche l'ultimo pezzo "scheda"
        const redirectUrl = urlOriginal.substring(0, urlOriginal.lastIndexOf('/'));
        this.backService.setRoute(redirectUrl.substring(0, redirectUrl.lastIndexOf('/')) + '/lista');
        this.sharedService.forceChangeContent.next();
        this.route.queryParamMap.subscribe(queryParams => {
            const qParamOp = queryParams.get('op');
            if (queryParams.get('isSuccess') == 'true') {
                this.sharedService.doMessageBoxEvent(this);
            }
            console.log("query params")
            console.log(queryParams)
            this.isModifica = !!qParamOp && qParamOp == EDIT_Q_PARAM;
            const isSuccess = queryParams.get('isSuccess') == 'true';
            this.librettoService.getXmlLibrettoNowByCodice(this.sharedService.getCodiceImpiantoFromDatiPrecompilati(), !isSuccess)
                .subscribe(
                    (data) => {
                        console.log("####### getXmlLibrettoNowByCodice ########")
                        console.log(data)
                        console.log("####### getXmlLibrettoNowByCodice ########")
                        let decoded = atob(new TextDecoder().decode(data))
                        this.parser.parseString(decoded, (err, result) => {
                            if (err)
                                return;

                            this.scheda2 = new Scheda2(result?.MOD?.Richiesta?.datiSchedaTrattH2O)
                            this.datiInseriti = result?.MOD?.Richiesta?.datiSchedaTrattH2O !== null
                                && result?.MOD?.Richiesta?.datiSchedaTrattH2O !== undefined

                            this.sharedService.setLibrettoXmlNow(result);
                            this.loaded = true;
                            this.updateForm(this.scheda2, this.isModifica);
                        });
                    },
                    (_) => {
                        this.datiInseriti = false
                    }
                );
        });

        // this.router.events.pipe(takeUntil(this.$destroy)).subscribe(event => {
        //     if (event instanceof NavigationEnd) {
        //         window.location.reload();
        //     }
        // })
    }

    @HostListener('window:resize', ['$event'])
    onResize(event?) {
        this.changeStyle(event.target.innerWidth);
    }

    changeStyle(width, additional = 325) {
        this.heightBreakpoint = ((width < 768) ? 3650 : 2200) + additional;
        this.formColBreakpoint = (width < 768) ? 1 : 2;
    }

    doModificaBottonEvent() {
        this.spinnerService.show();
        this.isModifica = !this.isModifica;
        this.updateQueryParam();
    }

    salva() {
        this.isModifica = false;

        var l25FlgTrattRaffNoRt = 0, l25FlgTrattRaffRtp = 0, l25FlgTrattRaffRtt = 0
        switch (this.form.controls.l25TipologiaTrattRaff?.value) {
            case 0:
                l25FlgTrattRaffNoRt = 1
                break
            case 1:
                l25FlgTrattRaffRtp = 1
                break
            case 2:
                l25FlgTrattRaffRtt = 1
                break
        }

        var l25FlgTrattRaffAcq = 0, l25FlgTrattRaffPzz = 0, l25FlgTrattRaffH2oSup = 0;
        switch (this.form.controls.l25TipologiaOrigineH2O?.value) {
            case 0:
                l25FlgTrattRaffAcq = 1
                break
            case 1:
                l25FlgTrattRaffPzz = 1
                break
            case 2:
                l25FlgTrattRaffH2oSup = 1
                break
        }

        var l25FlgTrattFFiltSic = 0, l25FlgTrattFFiltmas = 0, l25FlgTrattFNoTratt = 0;
        switch (this.form.controls.l25TipologiaTrattH2OEsisFiltr?.value) {
            case 0:
                l25FlgTrattFFiltSic = 1
                break
            case 1:
                l25FlgTrattFFiltmas = 1
                break
            case 2:
                l25FlgTrattFNoTratt = 1
                break
        }

        var l25FlgTrattTAddolc = 0, l25FlgTrattTOsmosi = 0, l25FlgTrattTDemin = 0, l25FlgTrattTNoTratt = 0;
        switch (this.form.controls.l25TipologiaTrattH2OEsisTrattH2O?.value) {
            case 0:
                l25FlgTrattTAddolc = 1
                break
            case 1:
                l25FlgTrattTOsmosi = 1
                break
            case 2:
                l25FlgTrattTDemin = 1
                break
            case 3:
                l25FlgTrattTNoTratt = 1
                break
        }


        var l25FlgTrattCPaantincro = 0, l25FlgTrattCPaanticorr = 0, l25FlgTrattCAaa = 0, l25FlgTrattCBiocida = 0, l25FlgTrattCNoTratt = 0;
        switch (this.form.controls.l25TipologiaTrattCondChimico?.value) {
            case 0:
                l25FlgTrattCPaantincro = 1
                break
            case 1:
                l25FlgTrattCPaanticorr = 1
                break
            case 2:
                l25FlgTrattCAaa = 1
                break
            case 3:
                l25FlgTrattCBiocida = 1
                break
            case 4:
                l25FlgTrattCNoTratt = 1
                break
        }

        const data = {
            'codiceImpianto': this.sharedService.getCodiceImpiantoFromDatiPrecompilati(),
            "l21H2oClimam3": this.form.controls.l21H2oClimam3?.value,
            "l22DurezzaH2oFr": this.form.controls.l22DurezzaH2oFr?.value,
            "l23FlgTrattClimaAssente": Number(this.form.controls.l23FlgTrattClimaAssente?.value),
            "l23FlgTrattClimaFiltr": Number(this.form.controls.l23FlgTrattClimaFiltr?.value),
            "l23FlgTrattClimaAddolc": Number(this.form.controls.l23FlgTrattClimaAddolc?.value),
            "l23DurezzaTotH2oFr": this.form.controls.l23DurezzaTotH2oFr?.value ?? null,
            "l23FlgTrattClimaChimico": Number(this.form.controls.l23FlgTrattClimaChimico?.value),
            "l23FlgTrattGeloAssente": Number(this.form.controls.l23FlgTrattGeloAssente?.value),
            "l23FlgTrattGeloGliEtil": Number(this.form.controls.l23FlgTrattGeloGliEtil?.value),
            "l23PercGliEtil": this.form.controls.l23PercGliEtil?.value,
            "l23PhGliEtil": this.form.controls.l23PhGliEtil?.value,
            "l23FlgTrattGeloGliProp": Number(this.form.controls.l23FlgTrattGeloGliProp?.value),
            "l23PercGliProp": this.form.controls.l23PercGliProp?.value,
            "l23PhGliProp": this.form.controls.l23PhGliProp?.value,
            "l24FlgTrattAcsAssente": Number(this.form.controls.l24FlgTrattAcsAssente?.value),
            "l24FlgTrattAcsFiltr": Number(this.form.controls.l24FlgTrattAcsFiltr?.value),
            "l24FlgTrattAcsAddolc": Number(this.form.controls.l24FlgTrattAcsAddolc?.value),
            "l24DurezzaAddolcFr": this.form.controls.l24DurezzaAddolcFr?.value,
            "l24FlgTrattAcsChimico": Number(this.form.controls.l24FlgTrattAcsChimico?.value),
            "l25FlgTrattRaffAssente": Number(this.form.controls.l25FlgTrattRaffAssente?.value),
            "l25FlgTrattRaffNoRt": l25FlgTrattRaffNoRt,
            "l25FlgTrattRaffRtp": l25FlgTrattRaffRtp,
            "l25FlgTrattRaffRtt": l25FlgTrattRaffRtt,
            "l25FlgTrattRaffAcq": l25FlgTrattRaffAcq,
            "l25FlgTrattRaffPzz": l25FlgTrattRaffPzz,
            "l25FlgTrattRaffH2oSup": l25FlgTrattRaffH2oSup,
            "l25FlgTrattFFiltSic": l25FlgTrattFFiltSic,
            "l25FlgTrattFFiltmas": l25FlgTrattFFiltmas,
            "l25FlgTrattFNoTratt": l25FlgTrattFNoTratt,
            "l25TrattFAltro": this.form.controls.l25TrattFAltro?.value,
            "l25FlgTrattTAddolc": l25FlgTrattTAddolc,
            "l25FlgTrattTOsmosi": l25FlgTrattTOsmosi,
            "l25FlgTrattTDemin": l25FlgTrattTDemin,
            "l25FlgTrattTNoTratt": l25FlgTrattTNoTratt,
            "l25TrattTAltro": this.form.controls.l25TrattTAltro?.value,
            "l25FlgTrattCPaantincro": l25FlgTrattCPaantincro,
            "l25FlgTrattCPaanticorr": l25FlgTrattCPaanticorr,
            "l25FlgTrattCAaa": l25FlgTrattCAaa,
            "l25FlgTrattCBiocida": l25FlgTrattCBiocida,
            "l25FlgTrattCNoTratt": l25FlgTrattCNoTratt,
            "l25TrattCAltro": this.form.controls.l25TrattCAltro?.value,
            "l25FlgSpurgoAutom": Number(this.form.controls.l25FlgSpurgoAutom?.value),
            "l25ConducH2oIng": this.form.controls.l25ConducH2oIng?.value,
            "l25Taratura": this.form.controls.l25Taratura?.value,
        }
        console.log("###### SCHEDA #####")
        console.log(data)
        console.log("###### SCHEDA #####")

        this.librettoService.setLibSch2IdImpianto(data).subscribe(() => {
            this.doSuccessEvent()
            this.updateQueryParam(true);
            this.scroller.scrollToAnchor('targetRed')
            this.isSuccess = true;
        });

        this.form.disable()
    }

    removeNullProperties(obj: any): any {
        const result = {};
        for (const [key, value] of Object.entries(obj)) {
            if (value !== null && value !== undefined
                && !(typeof obj[key] === 'number' && isNaN(obj[key]))
            ) {
                result[key] = value;
            }
        }
        return result;
    }

    async doSuccessEvent() {
        this.sharedService.doMessageBoxEvent(this);
    }

    updateQueryParam(success?: boolean) {
        let queryParams;
        if (this.isModifica) {
            queryParams = { op: EDIT_Q_PARAM, isSuccess: undefined };
        } else {
            if (success) {
                queryParams = { op: VIEW_Q_PARAM, isSuccess: true };
            } else {
                queryParams = { op: VIEW_Q_PARAM, isSuccess: undefined };
            }
        }
        this.router.navigate([], {
            relativeTo: this.route,
            queryParams,
            queryParamsHandling: 'merge'
        });
        //window.location.reload();
    }

    updateForm(scheda: Scheda2, isModifica: boolean) {
        // 2.1
        this.form.controls.l21H2oClimam3.setValue(scheda.l21H2oClimam3)
        // 2.2
        this.form.controls.l22DurezzaH2oFr.setValue(scheda.l22DurezzaH2oFr)
        // 2.3
        this.form.controls.l23FlgTrattClimaAssente.setValue(scheda.l23FlgTrattClimaAssente)
        this.form.controls.l23FlgTrattClimaFiltr.setValue(scheda.l23FlgTrattClimaFiltr)
        this.form.controls.l23FlgTrattClimaAddolc.setValue(scheda.l23FlgTrattClimaAddolc)
        this.form.controls.l23DurezzaTotH2oFr.setValue(scheda.l23DurezzaTotH2oFr)
        this.form.controls.l23FlgTrattClimaChimico.setValue(scheda.l23FlgTrattClimaChimico)
        this.form.controls.l23FlgTrattGeloAssente.setValue(scheda.l23FlgTrattGeloAssente)
        this.form.controls.l23FlgTrattGeloGliEtil.setValue(scheda.l23FlgTrattGeloGliEtil)
        this.form.controls.l23PercGliEtil.setValue(scheda.l23PercGliEtil)
        this.form.controls.l23PhGliEtil.setValue(scheda.l23PhGliEtil)
        this.form.controls.l23FlgTrattGeloGliProp.setValue(scheda.l23FlgTrattGeloGliProp)
        this.form.controls.l23PercGliProp.setValue(scheda.l23PercGliProp)
        this.form.controls.l23PhGliProp.setValue(scheda.l23PhGliProp)
        // 2.4
        this.form.controls.l24FlgTrattAcsAssente.setValue(scheda.l24FlgTrattAcsAssente)
        this.form.controls.l24FlgTrattAcsFiltr.setValue(scheda.l24FlgTrattAcsFiltr)
        this.form.controls.l24FlgTrattAcsAddolc.setValue(scheda.l24FlgTrattAcsAddolc)
        this.form.controls.l24DurezzaAddolcFr.setValue(scheda.l24DurezzaAddolcFr)
        this.form.controls.l24FlgTrattAcsChimico.setValue(scheda.l24FlgTrattAcsChimico)
        // 2.5
        this.form.controls.l25FlgTrattRaffAssente.setValue(scheda.l25FlgTrattRaffAssente)
        if (scheda.l25FlgTrattRaffNoRt)
            this.form.controls.l25TipologiaTrattRaff.setValue(0)
        else if (scheda.l25FlgTrattRaffRtp)
            this.form.controls.l25TipologiaTrattRaff.setValue(1)
        else if (scheda.l25FlgTrattRaffRtt)
            this.form.controls.l25TipologiaTrattRaff.setValue(2)
        if (scheda.l25FlgTrattRaffAcq)
            this.form.controls.l25TipologiaOrigineH2O.setValue(0)
        else if (scheda.l25FlgTrattRaffPzz)
            this.form.controls.l25TipologiaOrigineH2O.setValue(1)
        else if (scheda.l25FlgTrattRaffH2oSup)
            this.form.controls.l25TipologiaOrigineH2O.setValue(2)

        if(scheda.l25FlgTrattFFiltSic){
            this.form.controls.l25TipologiaTrattH2OEsisFiltr.setValue(0);
        }else if(scheda.l25FlgTrattFFiltmas){
            this.form.controls.l25TipologiaTrattH2OEsisFiltr.setValue(1);
        }else if(scheda.l25FlgTrattFNoTratt){
            this.form.controls.l25TipologiaTrattH2OEsisFiltr.setValue(2);
        }else {
            this.form.controls.l25TipologiaTrattH2OEsisFiltr.setValue(3);
            this.form.controls.l25TrattFAltro.setValue(scheda.l25TrattFAltro);
        }

        if(scheda.l25FlgTrattTAddolc){
            this.form.controls.l25TipologiaTrattH2OEsisTrattH2O.setValue(0);
        }else if(scheda.l25FlgTrattTOsmosi){
            this.form.controls.l25TipologiaTrattH2OEsisTrattH2O.setValue(1);
        }else if(scheda.l25FlgTrattTDemin){
            this.form.controls.l25TipologiaTrattH2OEsisTrattH2O.setValue(2);
        }else if(scheda.l25FlgTrattTNoTratt){
            this.form.controls.l25TipologiaTrattH2OEsisTrattH2O.setValue(3);
        }else {
            this.form.controls.l25TipologiaTrattH2OEsisTrattH2O.setValue(4);
            this.form.controls.l25TrattTAltro.setValue(scheda.l25TrattTAltro);
        }

        if (scheda.l25FlgTrattCPaantincro)
            this.form.controls.l25TipologiaTrattCondChimico.setValue(0)
        else if (scheda.l25FlgTrattCPaanticorr)
            this.form.controls.l25TipologiaTrattCondChimico.setValue(1)
        else if (scheda.l25FlgTrattCAaa)
            this.form.controls.l25TipologiaTrattCondChimico.setValue(2)
        else if (scheda.l25FlgTrattCBiocida)
            this.form.controls.l25TipologiaTrattCondChimico.setValue(3)
        else if (scheda.l25FlgTrattCNoTratt)
            this.form.controls.l25TipologiaTrattCondChimico.setValue(4)
        else {
            this.form.controls.l25TipologiaTrattCondChimico.setValue(5)
            this.form.controls.l25TrattCAltro.setValue(scheda.l25TrattCAltro);
        }

        this.form.controls.l25FlgSpurgoAutom.setValue(scheda.l25FlgSpurgoAutom)
        this.form.controls.l25ConducH2oIng.setValue(scheda.l25ConducH2oIng)
        this.form.controls.l25Taratura.setValue(scheda.l25Taratura)

        if (isModifica)
            this.form.enable()
        else
            this.form.disable()

    }

    ngOnDestroy(): void {
        this.$destroy.next();
    }
}

class Scheda2 {
    codiceImpianto: number;
    // 2.1
    l21H2oClimam3: number | null;
    // 2.2
    l22DurezzaH2oFr: number | null;
    // 2.3
    l23FlgTrattClimaAssente: boolean;
    l23FlgTrattClimaFiltr: boolean;
    l23FlgTrattClimaAddolc: boolean;
    l23DurezzaTotH2oFr: number;
    l23FlgTrattClimaChimico: boolean;
    // 2.3 Gelo
    l23FlgTrattGeloAssente: boolean;
    l23FlgTrattGeloGliEtil: boolean;
    l23PercGliEtil: number;
    l23PhGliEtil: number;
    l23FlgTrattGeloGliProp: boolean;
    l23PercGliProp: number;
    l23PhGliProp: number;
    // 2.4
    l24FlgTrattAcsAssente: boolean;
    l24FlgTrattAcsFiltr: boolean;
    l24FlgTrattAcsAddolc: boolean;
    l24DurezzaAddolcFr: number;
    l24FlgTrattAcsChimico: boolean;
    // 2.5
    l25FlgTrattRaffAssente: boolean;
    l25FlgTrattRaffNoRt: boolean;
    l25FlgTrattRaffRtp: boolean;
    l25FlgTrattRaffRtt: boolean;
    l25FlgTrattRaffAcq: boolean;
    l25FlgTrattRaffPzz: boolean;
    l25FlgTrattRaffH2oSup: boolean;
    l25FlgTrattFFiltSic: boolean;
    l25FlgTrattFFiltmas: boolean;
    l25FlgTrattFNoTratt: boolean;
    l25TrattFAltro: string;
    l25FlgTrattTAddolc: boolean;
    l25FlgTrattTOsmosi: boolean;
    l25FlgTrattTDemin: boolean;
    l25FlgTrattTNoTratt: boolean;
    l25TrattTAltro: string;
    l25FlgTrattCPaantincro: boolean;
    l25FlgTrattCPaanticorr: boolean;
    l25FlgTrattCAaa: boolean;
    l25FlgTrattCBiocida: boolean;
    l25FlgTrattCNoTratt: boolean;
    l25TrattCAltro: string;
    l25FlgSpurgoAutom: boolean;
    l25ConducH2oIng: number | null;
    l25Taratura: number | null;

    constructor(datiXml: any) {
        // 2.1
        this.l21H2oClimam3 = typeof datiXml?.L2_1contenutoH2OimpClima === "string" ? datiXml?.L2_1contenutoH2OimpClima : null
        // 2.2
        this.l22DurezzaH2oFr = typeof datiXml?.L2_2durezzaTotaleH2O === "string" ? datiXml?.L2_2durezzaTotaleH2O : null
        // 2.3 Trattamento dell’acqua dell’impianto di climatizzazione (Rif. UNI 8065)
        this.l23FlgTrattClimaAssente = this.toBool(+datiXml?.L2_3flagAssenteH2Oclima)
        this.l23FlgTrattClimaFiltr = this.toBool(+datiXml?.L2_3flagFiltrazione)
        this.l23FlgTrattClimaAddolc = this.toBool(+datiXml?.L2_3flagAddolcimento)
        this.l23DurezzaTotH2oFr = +datiXml?.L2_3durezzaTotaleH2O
        this.l23FlgTrattClimaChimico = this.toBool(+datiXml?.L2_3flagCondizChimico)
        // 2.3 Protezione del gelo:
        this.l23FlgTrattGeloAssente = this.toBool(+datiXml?.L2_3flagAssenteProtGelo)
        this.l23FlgTrattGeloGliEtil = this.toBool(+datiXml?.L2_3flagGlicoleEtilenic)
        this.l23PercGliEtil = +datiXml?.L2_3percConcentrazEtilenic
        this.l23PhGliEtil = +datiXml?.L2_3PHconcentrazEtilenic
        this.l23FlgTrattGeloGliProp = this.toBool(+datiXml?.L2_3flagGlicolePropLenic)
        this.l23PercGliProp = +datiXml?.L2_3percConcentrazPropLenic
        this.l23PhGliProp = +datiXml?.L2_3PHconcentrazPropLenic
        // 2.4 Trattamento dell’acqua calda sanitaria (Rif. UNI 8065)
        this.l24FlgTrattAcsAssente = this.toBool(+datiXml?.L2_4flagAssente)
        this.l24FlgTrattAcsFiltr = this.toBool(+datiXml?.L2_4flagFiltrazione)
        this.l24FlgTrattAcsAddolc = this.toBool(+datiXml?.L2_4flagAddolcimento)
        this.l24DurezzaAddolcFr = +datiXml?.L2_4durezzaTotaleAddolcit
        this.l24FlgTrattAcsChimico = this.toBool(+datiXml?.L2_4flagCondizChimico)
        // 2.5 Trattamento dell’acqua di raffreddamento dell’impianto di climatizzazione estiva
        this.l25FlgTrattRaffAssente = this.toBool(+datiXml?.L2_5flagAssente)
        this.l25FlgTrattRaffNoRt = this.toBool(+datiXml?.L2_5flagSenzaRecupTerm)
        this.l25FlgTrattRaffRtp = this.toBool(+datiXml?.L2_5flagRecupTermParz)
        this.l25FlgTrattRaffRtt = this.toBool(+datiXml?.L2_5flagRecupTermTot)
        this.l25FlgTrattRaffAcq = this.toBool(+datiXml?.L2_5flagAcquedotto)
        this.l25FlgTrattRaffPzz = this.toBool(+datiXml?.L2_5flagPozzo)
        this.l25FlgTrattRaffH2oSup = this.toBool(+datiXml?.L2_5flagAcquaSuperficiale)
        this.l25FlgTrattFFiltSic = this.toBool(+datiXml?.L2_5flagFiltrazSicurezza)
        this.l25FlgTrattFFiltmas = this.toBool(+datiXml?.L2_5flagFiltrazMasse)
        this.l25FlgTrattFNoTratt = this.toBool(+datiXml?.L2_5flagFiltrazNoTrattam)
        this.l25TrattFAltro = typeof datiXml?.L2_5filtrazioneAltro === "string" ? datiXml?.L2_5filtrazioneAltro : ''
        this.l25FlgTrattTAddolc = this.toBool(+datiXml?.L2_5flagTrattAddolcim)
        this.l25FlgTrattTOsmosi = this.toBool(+datiXml?.L2_5flagTrattOsmosi)
        this.l25FlgTrattTDemin = this.toBool(+datiXml?.L2_5flagTrattDemineralizz)
        this.l25FlgTrattTNoTratt = this.toBool(+datiXml?.L2_5flagTrattNoTrattam)
        this.l25TrattTAltro = typeof datiXml?.L2_5trattamentoAltro === "string" ? datiXml?.L2_5trattamentoAltro : ''
        this.l25FlgTrattCPaantincro = this.toBool(+datiXml?.L2_5flagCondChimAnticrosta)
        this.l25FlgTrattCPaanticorr = this.toBool(+datiXml?.L2_5flagCondChimAnticorr)
        this.l25FlgTrattCAaa = this.toBool(+datiXml?.L2_5flagCondChimAnticrostaAntiCorr)
        this.l25FlgTrattCBiocida = this.toBool(+datiXml?.L2_5flagCondChimBiocida)
        this.l25FlgTrattCNoTratt = this.toBool(+datiXml?.L2_5flagTrattNoTrattam)
        this.l25TrattCAltro = typeof datiXml?.L2_5condChimAltro === "string" ? datiXml?.L2_5condChimAltro : ''
        this.l25FlgSpurgoAutom = this.toBool(+datiXml?.L2_5flagPrefSpurgoAutom)
        this.l25ConducH2oIng = typeof datiXml?.L2_5conducibH2Oingresso === "string" ? +datiXml?.L2_5conducibH2Oingresso : null
        this.l25Taratura = typeof datiXml?.L2_5taraturaSpurgo === "string" ? +datiXml?.L2_5taraturaSpurgo : null
    }

    toBool(a: any) {
        return Boolean(a).valueOf();
    }
}
