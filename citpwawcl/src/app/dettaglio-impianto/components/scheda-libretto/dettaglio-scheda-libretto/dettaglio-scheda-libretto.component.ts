import { BreakpointObserver } from '@angular/cdk/layout';
import { Component, ElementRef, HostListener, OnDestroy, OnInit, ViewChild } from '@angular/core';
import { FormArray, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, NavigationEnd, Router } from '@angular/router';
import { Subject } from 'rxjs';
import { takeUntil } from 'rxjs/operators';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { BackService } from 'src/app/services/back.service';
import { LibrettoService } from 'src/app/services/libretto.service';
import { EDIT_Q_PARAM, SharedService, VIEW_Q_PARAM } from 'src/app/services/shared.service';
import { SpinnerService } from 'src/app/services/spinner.service';
import { TitleService } from 'src/app/services/title.service';
import { ANIMATION_DO_FADE, RUOLI } from 'src/app/utils/constants';
import { validatePDR, validatePOD } from 'src/app/validators/custom.validator';
import { MessageService } from 'src/app/services/message.service';
import { Console } from 'console';

const DEFAULT_VALIDATORS = [
  { cName: 'l1_*_altro', validators: [] },
  { cName: 'head.fkTipoIntervento', validators: [Validators.required] },
  { cName: 'head.dataIntervento', validators: [Validators.required] },
  { cName: 'card1P2.l1_2_fk_categoria', validators: [Validators.required] }
];



@Component({
  selector: 'app-dettaglio-scheda-libretto',
  templateUrl: './dettaglio-scheda-libretto.component.html',
  styleUrls: ['./dettaglio-scheda-libretto.component.scss'],
  styles: [ANIMATION_DO_FADE]
})
export class DettaglioSchedaLibrettoComponent implements OnInit, OnDestroy {

  @ViewChild("wideScreen") wideScreenRef: ElementRef;

  schedaLibretto: Scheda1;
  categorie: any[] = [];
  tipiIntervento: any[] = [];
  isModifica: boolean = false;
  isSuccess: boolean = false;
  doFade: boolean = false;

  panelOpenState: boolean = false;
  enableAddDatiAggiuntivi: boolean = true;

  formDatiAggiuntiviChanged = new Subject();
  $destroy = new Subject();

  checkUnita: boolean = false;
  checkPotenze: boolean[] = [];
  checkFluido: boolean[] = [];
  checkGen: boolean[] = [];
  checkInteg: boolean[] = [];
  checkAltro: boolean[] = [];
  datiCatastali: DatiAggiuntivi[] = [];

  heightBreakpoint: number;
  formColBreakpoint: number;

  form: FormGroup;

  datiAggiuntiviHeightBreakpoint_1;

  onlyView: boolean = false;

  constructor(
    private titleService: TitleService,
    private backService: BackService,
    private router: Router,
    private fb: FormBuilder,
    private sharedService: SharedService,
    private librettoService: LibrettoService,
    private spinnerService: SpinnerService,
    private route: ActivatedRoute,
    private breakpointObserver: BreakpointObserver,
    private authService: AuthenticationService,
    private readonly messageService: MessageService
  ) {
    let utenteLoggato = authService.getCurrentUserFromSession();
    if (utenteLoggato.ruoloLoggato.ruolo === RUOLI.RUOLO_CONSULTATORE ||
      utenteLoggato.ruoloLoggato.ruolo === RUOLI.RUOLO_PROPRIETARIO ||
      utenteLoggato.ruoloLoggato.ruolo === RUOLI.RUOLO_PROPRIETARIO_IMPRESA
    ) {
      this.onlyView = true;
    }

  }

  ngOnInit(): void {
    this.changeStyle(window.innerWidth);
    this.titleService.setTitle("Scheda identificativa impianto");
    this.backService.setBackTitle("Torna a scheda libretto");
    const urlOriginal = this.router.url;
    //fix devo togliere anche l'ultimo pezzo "scheda"
    const redirectUrl = urlOriginal.substring(0, urlOriginal.lastIndexOf('/'));
    this.backService.setRoute(redirectUrl.substring(0, redirectUrl.lastIndexOf('/')) + '/lista');
    this.sharedService.forceChangeContent.next();
    this.loadData();
    this.router.events.pipe(takeUntil(this.$destroy)).subscribe(event => {
      if (event instanceof NavigationEnd) {
        window.location.reload();
      }
    });
    this.formDatiAggiuntiviChanged.pipe(takeUntil(this.$destroy)).subscribe(() => {
      this.spinnerService.show();
      const formArrayDatiAggiuntivi = this.getFormArrayDatiAggiuntivi();
      const lastIndexDatiAgg = formArrayDatiAggiuntivi.length - 1;
      if (formArrayDatiAggiuntivi.length > 0) {
        const control = formArrayDatiAggiuntivi.controls[lastIndexDatiAgg];
        const { sezione, foglio, particella, subalterno } = control.value;
        const bodyError = { "aSoryuControl": true };
        const setErrorControl = (cName, body?) => {
          (<FormGroup>formArrayDatiAggiuntivi.controls[lastIndexDatiAgg]).get(cName).setErrors(body);
          this.enableAddDatiAggiuntivi = !body;
        }
        if (!!sezione || !!foglio || !!particella || !!subalterno) {
          if (!foglio) {
            setErrorControl('foglio', bodyError);
            return;
          }
          if (!particella) {
            setErrorControl('particella', bodyError);
            return;
          }
        }
        setErrorControl('foglio');
        setErrorControl('particella');
      } else {
        this.enableAddDatiAggiuntivi = true;
      }
    });
  }

  async loadData() {
    this.route.queryParamMap.subscribe(queryParams => {
      const qParamOp = queryParams.get('op');
      if (queryParams.get('isSuccess') == 'true') {
        this.sharedService.doMessageBoxEvent(this);
      }
      this.isModifica = !!qParamOp && qParamOp == EDIT_Q_PARAM;
      this.librettoService.getCategorie().subscribe(data => {
        this.categorie = data.sort((a, b) => a.idCategoria.localeCompare(b.idCategoria));
      }
      );
      this.librettoService.getTipoIntervento().subscribe(data => this.tipiIntervento = data);
      this.librettoService.getSchedaLibrettoJWT().subscribe((schedaLibretto: Scheda1) => {
        this.schedaLibretto = schedaLibretto;
        this.createForm();
      });
    });

  }

  @HostListener('window:resize', ['$event'])
  onResize(event?) {
    this.changeStyle(event.target.innerWidth);
  }

  changeStyle(width, additional = 325) {
    const lengthDatiAggiuntivi = this.form?.value.datiAggiuntivi?.length;
    console.log("LENGTH DATI: " + lengthDatiAggiuntivi);
    this.heightBreakpoint = ((width < 768) ? 3650 : 2200) + additional;
    this.formColBreakpoint = (width < 768) ? 1 : 2;
    this.datiAggiuntiviHeightBreakpoint_1 = ((width < 768) ? 340 : 320);
  }

  doModificaBottonEvent() {
    this.spinnerService.show();
    this.isModifica = !this.isModifica;
    this.updateQueryParam();
  }

  doChangeCheck(controlName, check) {
    const controlNameNoRequired = ['integrazione.potenzaUtile', 'integrazione.l1_5_altro_integr_pot_kw'];
    for (let cName of controlName.split('&')) {
      const control = this.form.get(cName);
      let validators = this.getDefaultValidator(cName);
      if (check) {
        if (!controlNameNoRequired.includes(cName)) {
          validators.push(Validators.required);
        }
        control.enable();
        control.markAsTouched();
      } else {
        control.markAsUntouched();
        control.setValue('');
        control.disable();
      }
      control.setValidators(validators);
      control.updateValueAndValidity();
    }
  }

  doInputValidating(cName, affectedControlName, subAffectedControlName?) {
    const value = this.form.get(cName).value;
    const isValueExist = typeof value == 'boolean' ? value : !!value && value.toString().trim().length > 0;
    const control = this.form.get(affectedControlName);
    if (!!subAffectedControlName) {
      const subControl = this.form.get(subAffectedControlName);
      const isSubValueExist = !!subControl.value && subControl.value.toString().trim() !== '';
      if (isValueExist) {
        control.disable();
      } else {
        control.enable();
      }
      if (!isSubValueExist) {
        control.setValue(isValueExist);
        this.doChangeCheck(subAffectedControlName, isValueExist);
      }
    }
    const validators = this.getDefaultValidator(affectedControlName);
    if (isValueExist) {
      control.markAsTouched();
      validators.push(Validators.required);
    } else {
      control.markAsUntouched();
    }
    control.setValidators(validators);
    control.updateValueAndValidity();
  }

  handle2ChangeEvent(body1, body2) {
    this.doChangeCheck(body1.cName, body1.check);
    this.doInputValidating(body2.cName, body2.affectedCName);
  }

  removeDatiAggiuntivi(index) {
    this.getFormArrayDatiAggiuntivi().controls.splice(index, 1);
    this.getFormArrayDatiAggiuntivi().value.splice(index, 1);
    this.datiCatastali.splice(index, 1);
    // this.datiCatastali = this.getFormArrayDatiAggiuntivi().value;
    if (window.innerWidth < 768) {
      this.heightBreakpoint = this.heightBreakpoint - this.datiAggiuntiviHeightBreakpoint_1;
    } else {
      this.heightBreakpoint = this.heightBreakpoint - (this.datiCatastali.length % 2 == 0 ? this.datiAggiuntiviHeightBreakpoint_1 : 0);
    }
  }


  nuovoDatoCatastale(dato: DatiAggiuntivi, empty?: boolean, disabled?: boolean) {
    const { sezione, foglio, particella, subalterno, pod_elettrico, pdr_gas } = dato;
    const datoAggiuntivo = this.fb.group({
      sezione: [{ value: sezione || '', disabled: disabled }, this.getDefaultValidator('datiAggiuntivi.sezione')],
      foglio: [{ value: foglio || '', disabled: disabled }, this.getDefaultValidator('datiAggiuntivi.foglio')],
      particella: [{ value: particella || '', disabled: disabled }, this.getDefaultValidator('datiAggiuntivi.particella')],
      subalterno: [{ value: subalterno || '', disabled: disabled }, this.getDefaultValidator('datiAggiuntivi.subalterno')],
      pod_elettrico: [{ value: pod_elettrico || '', disabled: disabled }],
      pdr_gas: [{ value: pdr_gas || '', disabled: disabled }]
    });
    if (!!dato && !empty) {
      return datoAggiuntivo
    }
    if (!this.datiCatastali) {
      this.datiCatastali = [];
    }
    this.datiCatastali.push(datoAggiuntivo.value);
    this.getFormArrayDatiAggiuntivi().push(datoAggiuntivo);
    // this.getFormArrayDatiAggiuntivi().setValue(this.datiCatastali);


    // this.datiCatastali = this.getFormArrayDatiAggiuntivi().value;

    //Adatto l'altezza del form
    if (window.innerWidth < 768) {
      this.heightBreakpoint = this.heightBreakpoint + this.datiAggiuntiviHeightBreakpoint_1;
    }
    else {
      let mod = this.datiCatastali.length % 2;
      this.heightBreakpoint = this.heightBreakpoint + (mod != 0 ? this.datiAggiuntiviHeightBreakpoint_1 : 0);
    }
    return null;
  }



  changeFormPdr(i: number, value) {
    let control = this.getFormArrayDatiAggiuntivi().get(i.toString()).get('pdr_gas')
    if (control.value) {
      control.setValidators(validatePDR());
      control.updateValueAndValidity();
    } else {
      control.clearValidators();
      control.updateValueAndValidity();
    }
  }

  changeFormPod(i: number, value) {
    let control = this.getFormArrayDatiAggiuntivi().get(i.toString()).get('pod_elettrico')
    if (control.value) {
      control.setValidators(validatePOD());
      control.updateValueAndValidity();
    } else {
      control.clearValidators();
      control.updateValueAndValidity();
    }
  }

  onOpenExpansion() {
    this.panelOpenState = !this.panelOpenState;
    let additional = 0;
    if (this.panelOpenState) {
      additional = 325;
    }
    this.changeStyle(window.innerWidth, additional);
  }
  getFormArrayDatiAggiuntivi(): FormArray {
    return this.form.get('datiAggiuntivi') as FormArray;
  }

  salva() {
    const { value } = this.form;

    if(!value.card1P3?.l1_3_pot_h2o_kw && 
      !value.card1P3?.l1_3_pot_clima_inv_kw && 
      !value.card1P3?.l1_3_pot_clima_est_kw && 
      !value.card1P3?.l1_3_altro){
        console.log("Condizione verificata");
        this.messageService.setTitolo("Errore salvataggio modifiche");
        this.messageService.setDescrizione("Attenzione: almeno una delle voci 1.3 deve essere indicata");
        this.messageService.showMessaggioM();
        this.messageService.setType(2);
        return;
    }

    if(!value.card1P4?.l1_4_flg_h2o &&
      !value.card1P4?.l1_4_flg_aria &&
      !value.card1P4?.l1_4_altro){
      this.messageService.setTitolo("Errore salvataggio modifiche");
      this.messageService.setDescrizione("Attenzione: almeno una delle voci 1.4 deve essere indicata");
      this.messageService.showMessaggioM();
      this.messageService.setType(2);
      return;
    }

    if(!value.card1P5?.l1_5_flg_generatore &&
      !value.card1P5?.l1_5_flg_pompa &&
      !value.card1P5?.l1_5_flg_frigo &&
      !value.card1P5?.l1_5_flg_telerisc &&
      !value.card1P5?.l1_5_flg_teleraffr &&
      !value.card1P5?.l1_5_flg_cogeneratore &&
      !value.card1P5?.l1_5_altro
    ){
      this.messageService.setTitolo("Errore salvataggio modifiche");
      this.messageService.setDescrizione("Attenzione: almeno una delle voci 1.5 deve essere indicata");
      this.messageService.showMessaggioM();
      this.messageService.setType(2);
      return;
    }

    const body = {

      dataIntervento: value.head.dataIntervento,
      fkTipoIntervento: value.head.fkTipoIntervento,

      l1_2_flg_singola_unita: value.card1P2?.l1_2_flg_singola_unita ? 1 : 0,
      l1_2_fk_categoria: value.card1P2?.l1_2_fk_categoria,
      l1_2_vol_risc_m3: +value.card1P2?.l1_2_vol_risc_m3,
      l1_2_vol_raff_m3: +value.card1P2?.l1_2_vol_raff_m3,

      l1_3_pot_h2o_kw: +value.card1P3?.l1_3_pot_h2o_kw,
      l1_3_pot_clima_inv_kw: +value.card1P3?.l1_3_pot_clima_inv_kw,
      l1_3_pot_clima_est_kw: +value.card1P3?.l1_3_pot_clima_est_kw,
      l1_3_altro: value.card1P3?.l1_3_altro,

      l1_4_flg_h2o: value.card1P4?.l1_4_flg_h2o ? 1 : 0,
      l1_4_flg_aria: value.card1P4?.l1_4_flg_aria ? 1 : 0,
      l1_4_altro: value.card1P4?.l1_4_altro,

      l1_5_flg_generatore: value.card1P5?.l1_5_flg_generatore ? 1 : 0,
      l1_5_flg_pompa: value.card1P5?.l1_5_flg_pompa ? 1 : 0,
      l1_5_flg_frigo: value.card1P5?.l1_5_flg_frigo ? 1 : 0,
      l1_5_flg_telerisc: value.card1P5?.l1_5_flg_telerisc ? 1 : 0,
      l1_5_flg_teleraffr: value.card1P5?.l1_5_flg_teleraffr ? 1 : 0,
      l1_5_flg_cogeneratore: value.card1P5?.l1_5_flg_cogeneratore ? 1 : 0,
      l1_5_altro: value.card1P5?.l1_5_altro,

      l1_5_sup_pannelli_sol_m2: +value.integrazione?.l1_5_sup_pannelli_sol_m2,
      l1_5_altro_integrazione: value.integrazione?.l1_5_altro_integrazione,
      l1_5_altro_integr_pot_kw: +value.integrazione?.l1_5_altro_integr_pot_kw,
      l1_5_flg_altro_clima_inv: value.integrazione?.l1_5_flg_altro_clima_inv ? 1 : 0,
      l1_5_flg_altro_clima_estate: value.integrazione?.l1_5_flg_altro_clima_estate ? 1 : 0,
      l1_5_flg_altro_acs: value.integrazione?.l1_5_flg_altro_acs ? 1 : 0,
      l1_5_altro_desc: value.integrazione?.l1_5_altro_desc,

      datiAggiuntivi: this.datiCatastali || [],
    };

    // Object.keys(this.schedaLibretto).forEach(key => {
    //   if(isNaN(body[key]) || body[key] === undefined){
    //     delete body[key];
    //   }
    //   // if (body[key] !== 0 && !!body[key]) {
    //   //   body[key] = this.schedaLibretto[key];
    //   // }
    // });

    const filteredBody = this.removeNullProperties(body);

    this.isModifica = false;
    this.librettoService.setLibSch1IdImpianto(filteredBody)
      .subscribe(() => {
        this.doSuccessEvent()
        this.updateQueryParam(true);
      });
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
    window.location.reload();
  }

  createForm() {
    this.form = null;
    const {
      dataIntervento,
      fkTipoIntervento,

      l1_2_flg_singola_unita,
      l1_2_fk_categoria,
      l1_2_vol_risc_m3,
      l1_2_vol_raff_m3,

      l1_3_pot_h2o_kw,
      l1_3_pot_clima_inv_kw,
      l1_3_pot_clima_est_kw,
      l1_3_altro,

      l1_4_flg_h2o,
      l1_4_flg_aria,
      l1_4_altro,

      l1_5_flg_generatore,
      l1_5_flg_pompa,
      l1_5_flg_frigo,
      l1_5_flg_telerisc,
      l1_5_flg_teleraffr,
      l1_5_flg_cogeneratore,
      l1_5_altro,

      l1_5_sup_pannelli_sol_m2,
      l1_5_altro_integrazione,
      l1_5_altro_integr_pot_kw,
      l1_5_flg_altro_clima_inv,
      l1_5_flg_altro_clima_estate,
      l1_5_flg_altro_acs,
      l1_5_altro_desc,

      datiAggiuntivi,
    } = this.schedaLibretto;
    const listDatiAggiuntiviForm: FormGroup[] = [];
    // this.datiCatastali = datiAggiuntivi;
    if (!!datiAggiuntivi && datiAggiuntivi.length > 0) {
      for (let dato of datiAggiuntivi) {
        const datoAggiuntivo = this.nuovoDatoCatastale(dato, false, true);
        listDatiAggiuntiviForm.push(datoAggiuntivo);
      }
    }
    this.form = this.fb.group({
      head: this.fb.group({
        dataIntervento: [{ value: dataIntervento ? new Date(dataIntervento.substring(0, dataIntervento.indexOf('T'))) : new Date(), disabled: this.getDisabledValuesForm() }, this.getDefaultValidator('head.dataIntervento')],
        fkTipoIntervento: [{ value: fkTipoIntervento.toString(), disabled: this.getDisabledValuesForm() }, this.getDefaultValidator('head.tipoIntervento')]
      }),
      card1P2: this.fb.group({
        l1_2_flg_singola_unita: [{ value: this.getBooleanForm(l1_2_flg_singola_unita), disabled: this.getDisabledValuesForm() }, this.getDefaultValidator('card1P2.l1_2_flg_singola_unita')],
        l1_2_fk_categoria: [{ value: l1_2_fk_categoria || "", disabled: this.getDisabledValuesForm() }, this.getDefaultValidator('card1P2.l1_2_fk_categoria')],
        l1_2_vol_risc_m3: [{ value: l1_2_vol_risc_m3 || "", disabled: this.getDisabledValuesForm() }, this.getDefaultValidator('card1P2.l1_2_vol_risc_m3', !!l1_3_pot_clima_inv_kw)],
        l1_2_vol_raff_m3: [{ value: l1_2_vol_raff_m3 || "", disabled: this.getDisabledValuesForm() }, this.getDefaultValidator('card1P2.l1_2_vol_raff_m3', !!l1_3_pot_clima_est_kw)],
      }),
      card1P3: this.fb.group({
        acquaCalda: [{ value: this.getBooleanForm(!!l1_3_pot_h2o_kw, this.checkPotenze), disabled: this.getDisabledValuesForm() }, this.getDefaultValidator('card1P3.acquaCalda')],
        l1_3_pot_h2o_kw: [{ value: l1_3_pot_h2o_kw || "", disabled: this.getDisabledValuesForm(!l1_3_pot_h2o_kw) }, this.getDefaultValidator('card1P3.l1_3_pot_h2o_kw')],
        climatizatoreInv: [{ value: this.getBooleanForm(!!l1_3_pot_clima_inv_kw, this.checkPotenze), disabled: this.getDisabledValuesForm(!!l1_2_vol_risc_m3) }, this.getDefaultValidator('card1P3.climatizatoreInv')],
        l1_3_pot_clima_inv_kw: [{ value: l1_3_pot_clima_inv_kw || "", disabled: this.getDisabledValuesForm(!l1_3_pot_clima_inv_kw) }, this.getDefaultValidator('card1P3.l1_3_pot_clima_inv_kw', !!l1_2_vol_risc_m3)],
        climatizatoreEst: [{ value: this.getBooleanForm(!!l1_3_pot_clima_est_kw, this.checkPotenze), disabled: this.getDisabledValuesForm(!!l1_2_vol_raff_m3) }, this.getDefaultValidator('card1P3.climatizatoreEst')],
        l1_3_pot_clima_est_kw: [{ value: l1_3_pot_clima_est_kw || "", disabled: this.getDisabledValuesForm(!l1_3_pot_clima_est_kw) }, this.getDefaultValidator('card1P3.l1_3_pot_clima_est_kw', !!l1_2_vol_raff_m3)],
        altro: [{ value: this.getBooleanForm(!!l1_3_altro, this.checkAltro), disabled: this.getDisabledValuesForm() }, this.getDefaultValidator('card1P3.altro')],
        l1_3_altro: [{ value: l1_3_altro || "", disabled: this.getDisabledValuesForm(!l1_3_altro) }, this.getDefaultValidator('card1P3.l1_3_altro')],
      }),
      card1P4: this.fb.group({
        l1_4_flg_h2o: [{ value: this.getBooleanForm(l1_4_flg_h2o, this.checkFluido), disabled: this.getDisabledValuesForm() }, this.getDefaultValidator('card1P4.l1_4_flg_h2o')],
        l1_4_flg_aria: [{ value: this.getBooleanForm(l1_4_flg_aria, this.checkFluido), disabled: this.getDisabledValuesForm() }, this.getDefaultValidator('card1P4.l1_4_flg_aria')],
        altro: [{ value: this.getBooleanForm(!!l1_4_altro, this.checkAltro), disabled: this.getDisabledValuesForm() }, this.getDefaultValidator('card1P4.altro')],
        l1_4_altro: [{ value: l1_4_altro || "", disabled: this.getDisabledValuesForm(!l1_4_altro) }, this.getDefaultValidator('card1P4.l1_4_altro')],
      }),
      card1P5: this.fb.group({
        l1_5_flg_generatore: [{ value: this.getBooleanForm(l1_5_flg_generatore, this.checkGen), disabled: this.getDisabledValuesForm() }, this.getDefaultValidator('card1P5.l1_5_flg_generatore')],
        l1_5_flg_pompa: [{ value: this.getBooleanForm(l1_5_flg_pompa, this.checkGen), disabled: this.getDisabledValuesForm() }, this.getDefaultValidator('card1P5.l1_5_flg_pompa')],
        l1_5_flg_frigo: [{ value: this.getBooleanForm(l1_5_flg_frigo, this.checkGen), disabled: this.getDisabledValuesForm() }, this.getDefaultValidator('card1P5.l1_5_flg_frigo')],
        l1_5_flg_telerisc: [{ value: this.getBooleanForm(l1_5_flg_telerisc, this.checkGen), disabled: this.getDisabledValuesForm() }, this.getDefaultValidator('card1P5.l1_5_flg_telerisc')],
        l1_5_flg_teleraffr: [{ value: this.getBooleanForm(l1_5_flg_teleraffr, this.checkGen), disabled: this.getDisabledValuesForm() }, this.getDefaultValidator('card1P5.l1_5_flg_teleraffr')],
        l1_5_flg_cogeneratore: [{ value: this.getBooleanForm(l1_5_flg_cogeneratore, this.checkGen), disabled: this.getDisabledValuesForm() }, this.getDefaultValidator('card1P5.l1_5_flg_cogeneratore')],
        altro: [{ value: this.getBooleanForm(!!l1_5_altro, this.checkAltro), disabled: this.getDisabledValuesForm() }, this.getDefaultValidator('card1P5.altro')],
        l1_5_altro: [{ value: l1_5_altro || "", disabled: this.getDisabledValuesForm(!l1_5_altro) }, this.getDefaultValidator('card1P5.l1_5_altro')]
      }),
      integrazione: this.fb.group({
        pannelliSolari: [{ value: this.getBooleanForm(!!l1_5_sup_pannelli_sol_m2, this.checkInteg), disabled: this.getDisabledValuesForm() }, this.getDefaultValidator('integrazione.pannelliSolari')],
        l1_5_sup_pannelli_sol_m2: [{ value: l1_5_sup_pannelli_sol_m2 || "", disabled: this.getDisabledValuesForm(!l1_5_sup_pannelli_sol_m2) }, /*this.getDefaultValidator('integrazione.l1_5_sup_pannelli_sol_m2')*/[]],
        altroS: [{ value: this.getBooleanForm(!!l1_5_altro_integrazione, this.checkAltro), disabled: this.getDisabledValuesForm() }, this.getDefaultValidator('integrazione.altroS')],
        l1_5_altro_integrazione: [{ value: l1_5_altro_integrazione || "", disabled: this.getDisabledValuesForm(!l1_5_altro_integrazione) }, this.getDefaultValidator('integrazione.l1_5_altro_integrazione')],
        l1_5_altro_integr_pot_kw: [{ value: l1_5_altro_integr_pot_kw || "", disabled: this.getDisabledValuesForm(!l1_5_altro_integr_pot_kw) }, /*this.getDefaultValidator('integrazione.l1_5_altro_integr_pot_kw')*/[]],
        l1_5_flg_altro_clima_inv: [{ value: this.getBooleanForm(l1_5_flg_altro_clima_inv, this.checkInteg), disabled: this.getDisabledValuesForm() }, this.getDefaultValidator('integrazione.l1_5_flg_altro_clima_inv')],
        l1_5_flg_altro_clima_estate: [{ value: this.getBooleanForm(l1_5_flg_altro_clima_estate, this.checkInteg), disabled: this.getDisabledValuesForm() }, this.getDefaultValidator('integrazione.l1_5_flg_altro_clima_estate')],
        l1_5_flg_altro_acs: [{ value: this.getBooleanForm(l1_5_flg_altro_acs, this.checkInteg), disabled: this.getDisabledValuesForm() }, this.getDefaultValidator('integrazione.l1_5_flg_altro_acs')],
        altroC: [{ value: this.getBooleanForm(!!l1_5_altro_desc, this.checkAltro), disabled: this.getDisabledValuesForm() }, this.getDefaultValidator('integrazione.altroC')],
        l1_5_altro_desc: [{ value: l1_5_altro_desc || "", disabled: this.getDisabledValuesForm(!l1_5_altro_desc) }, this.getDefaultValidator('integrazione.l1_5_altro_desc')],
      }),
      datiAggiuntivi: this.fb.array(listDatiAggiuntiviForm)
    });
    this.datiCatastali = datiAggiuntivi;
    console.log(!listDatiAggiuntiviForm);
  }

  getDisabledValuesForm(condition?: boolean) {
    if (!this.isModifica) {
      return true;
    }
    return !!condition;
  }

  getBooleanForm(value: any, array?) {
    value = (typeof value == "boolean") ? value : value == 1;
    if (!array) {
      this.checkUnita = value;
    } else {
      array.push(value);
    }
    return value;
  }

  getDefaultValidator(cName: string, checkRequiredRequired?: boolean) {
    const validators = checkRequiredRequired ? [Validators.required] : [];
    for (let el of DEFAULT_VALIDATORS) {
      const split = el.cName.split('*');
      if ((split.length > 1 && cName.includes(split[0]) && cName.endsWith(split[1]))
        || (el.cName == cName)) {
        return [...el.validators, ...validators];
      }
    }
    return validators;
  }


  ngOnDestroy(): void {
    this.$destroy.next();
  }

  isRequired(...args) {
    let result = false;
    for (let arg of args) {
      if (arg) {
        result = true;
      }
    }
    return result;
  }

  // updateFormValidity(index: number) {
  //   let array: FormGroup = this.getFormArrayDatiAggiuntivi().get(index.toString()) as FormGroup;
  //   console.log(array);
  // }
}

class Scheda1 {
  dataIntervento;
  fkTipoIntervento;

  l1_2_flg_singola_unita;
  l1_2_fk_categoria;
  l1_2_vol_risc_m3;
  l1_2_vol_raff_m3;

  l1_3_pot_h2o_kw;
  l1_3_pot_clima_inv_kw;
  l1_3_pot_clima_est_kw;
  l1_3_altro;

  l1_4_flg_h2o;
  l1_4_flg_aria;
  l1_4_altro;

  l1_5_flg_generatore;
  l1_5_flg_pompa;
  l1_5_flg_frigo;
  l1_5_flg_telerisc;
  l1_5_flg_teleraffr;
  l1_5_flg_cogeneratore;
  l1_5_altro;

  l1_5_sup_pannelli_sol_m2;
  l1_5_altro_integrazione;
  l1_5_altro_integr_pot_kw;
  l1_5_flg_altro_clima_inv;
  l1_5_flg_altro_clima_estate;
  l1_5_flg_altro_acs;
  l1_5_altro_desc;

  datiAggiuntivi: DatiAggiuntivi[] = [];
}

/*
static final long serialVersionUID = 1L;
private String sezione;
private String foglio;
private String particella;
private String subalterno;
private String pod_elettrico;
private String pdr_gas;

*/
class DatiAggiuntivi {
  sezione?: string;
  foglio?: string;
  particella?: string;
  subalterno?: string;
  pod_elettrico?: string;
  pdr_gas?: string;
}


