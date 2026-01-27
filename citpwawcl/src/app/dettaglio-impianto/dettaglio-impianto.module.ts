import { NgModule } from '@angular/core';
import { MatTooltipModule } from '@angular/material/tooltip';
import { AppRoutingModule } from '../app-routing.module';
import { CommonCompModule } from '../common/common.module';
import { AggiungiComponenteDialogComponent } from './components/aggiungi-componente-dialog/aggiungi-componente-dialog.component';
import { DettaglioNominaComponent } from './components/dettaglio-nomina/dettaglio-nomina.component';
import { AggiungiDocumentoContrattoComponent } from './components/documenti-contratto/aggiungi-documento-contratto/aggiungi-documento-contratto.component';
import { DocumentiContrattoComponent } from './components/documenti-contratto/documenti-contratto.component';
import { AggiungiDocumentiComponent } from './components/documenti-impianto/aggiungi-documenti/aggiungi-documenti.component';
import { DocumentiImpiantoComponent } from './components/documenti-impianto/documenti-impianto.component';
import { NuovoResponsabileProprietarioComponent } from './components/nuovo-responsabile-proprietario/nuovo-responsabile-proprietario.component';
import { DettaglioImpiantoComponent } from './components/pages/dettaglio-impianto/dettaglio-impianto.component';
import { DettaglioSchedaLibrettoComponent } from './components/scheda-libretto/dettaglio-scheda-libretto/dettaglio-scheda-libretto.component';
import { ListaSchedaLibrettoComponent } from './components/scheda-libretto/lista-scheda-libretto/lista-scheda-libretto.component';
import { Scheda3TerzoResponsabileComponent } from './components/scheda-libretto/scheda3-terzo-responsabile/scheda3-terzo-responsabile.component';
import { DettaglioComponent } from './dettaglio/dettaglio.component';
import { Scheda2TrattamentoAcquaComponent } from './components/scheda-libretto/scheda2-trattamento-acqua/scheda2-trattamento-acqua.component';



@NgModule({
  declarations: [
    DettaglioImpiantoComponent,
    ListaSchedaLibrettoComponent,
    DettaglioSchedaLibrettoComponent,
    NuovoResponsabileProprietarioComponent,
    AggiungiComponenteDialogComponent,
    DettaglioComponent,
    DocumentiImpiantoComponent,
    AggiungiDocumentiComponent,
    Scheda2TrattamentoAcquaComponent,
    Scheda3TerzoResponsabileComponent,
    DettaglioNominaComponent,
    DocumentiContrattoComponent,
    AggiungiDocumentoContrattoComponent
  ],
  imports: [
    CommonCompModule,
    AppRoutingModule,
    MatTooltipModule],
  exports: [
    DettaglioImpiantoComponent,
    ListaSchedaLibrettoComponent,
    DettaglioSchedaLibrettoComponent,
    NuovoResponsabileProprietarioComponent,
    Scheda2TrattamentoAcquaComponent,
    Scheda3TerzoResponsabileComponent,
    DettaglioNominaComponent,
    DocumentiContrattoComponent,
    AggiungiDocumentoContrattoComponent
  ]
})
export class DettaglioImpiantoModule { }
