import { Component, Inject, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { Esito } from 'src/app/models/esito';
import { Persona } from 'src/app/models/persona';
import { ComponenteService } from 'src/app/services/componente.service';
import { ImpiantoService } from 'src/app/services/impianto.service';
import { SpinnerService } from 'src/app/services/spinner.service';
import { ICONSURL, OK, TIPI_COMP } from 'src/app/utils/constants';
import { validateAlphanumeric, validateCFPIVA } from 'src/app/validators/custom.validator';

@Component({
  selector: 'app-ricerca-pg-dialog',
  templateUrl: './ricerca-pg-dialog.component.html',
  styleUrls: ['./ricerca-pg-dialog.component.scss']
})
export class RicercaPgDialogComponent implements OnInit {

  searchForm: FormGroup;
  closeGrigio: string = ICONSURL + "close-grigio.png";
  titoloErrore = "";
  descrizioneErrore = "";
  persone: Persona[] = undefined;


  constructor(public dialogRef: MatDialogRef<RicercaPgDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data,
    private fb: FormBuilder, private readonly impiantoService: ImpiantoService, readonly spinnerService: SpinnerService, private router: Router, private readonly componenteService: ComponenteService) {
    this.searchForm = fb.group({
      cf: ["", validateCFPIVA],
      siglaRea: ["", validateAlphanumeric],
      numeroRea: ["", Validators.pattern("[0-9]+")]
    });
  }

  ngOnInit(): void {
  }

  closeDialog() {
    this.dialogRef.close();
  }

  cercaPerCF() {
    this.persone = [];
    this.impiantoService.cercaResponsabileProprietario(1, this.searchForm.controls.cf.value).subscribe((elem: Persona[]) => {
      this.persone = elem;
    }, error => {
      if (error.status === 404) {
        this.persone = [];
      }
    });
  }

  cercaPerREA() {
    this.persone = [];
    this.impiantoService.cercaResponsabileProprietario(1, undefined, this.searchForm.controls.numeroRea.value, this.searchForm.controls.siglaRea.value).subscribe((elem: Persona[]) => {
      this.persone = elem;
    }, error => {
      if (error.status === 404) {
        this.persone = [];
      }
    });
  }

  inserisciComponente(persona: Persona) {
    switch (this.data.tipo) {
      case TIPI_COMP.GT:
        this.componenteService.updateGT(this.data.codiceImpianto, this.data.array, persona.idPersona).subscribe((elem: Esito) => {
          this.router.navigate(["impianto/dettaglio-impianto/" + this.data.codiceImpianto, { success: true }]);
          this.dialogRef.close(OK);
        }, (error: Esito) => {
          this.dialogRef.close(undefined);
        });
        break;
      case TIPI_COMP.GF:
        this.componenteService.updateGF(this.data.codiceImpianto, this.data.array, persona.idPersona).subscribe((elem: Esito) => {
          this.router.navigate(["impianto/dettaglio-impianto/" + this.data.codiceImpianto, { success: true }]);
          this.dialogRef.close(OK);
        }, (error: Esito) => {
          this.dialogRef.close(undefined);
        });
        break;
      case TIPI_COMP.SC:
        this.componenteService.updateSC(this.data.codiceImpianto, this.data.array, persona.idPersona).subscribe((elem: Esito) => {
          this.router.navigate(["impianto/dettaglio-impianto/" + this.data.codiceImpianto, { success: true }]);
          this.dialogRef.close(OK);
        }, (error: Esito) => {
          this.dialogRef.close(undefined);
        });
        break;
      case TIPI_COMP.CG:
        this.componenteService.updateCG(this.data.codiceImpianto, this.data.array, persona.idPersona).subscribe((elem: Esito) => {
          this.router.navigate(["impianto/dettaglio-impianto/" + this.data.codiceImpianto, { success: true }]);
          this.dialogRef.close(OK);
        }, (error: Esito) => {
          this.dialogRef.close(undefined);
        });
        break;
    }
  }
}
