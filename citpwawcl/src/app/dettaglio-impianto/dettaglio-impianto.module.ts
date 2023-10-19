import { NgModule } from '@angular/core';
import { CommonCompModule } from '../common/common.module';
import { AggiungiComponenteDialogComponent } from './components/aggiungi-componente-dialog/aggiungi-componente-dialog.component';
import { NuovoResponsabileProprietarioComponent } from './components/nuovo-responsabile-proprietario/nuovo-responsabile-proprietario.component';
import { DettaglioImpiantoComponent } from './components/pages/dettaglio-impianto/dettaglio-impianto.component';
import { DettaglioComponent } from './dettaglio/dettaglio.component';



@NgModule({
  declarations: [
    DettaglioImpiantoComponent, 
    NuovoResponsabileProprietarioComponent, AggiungiComponenteDialogComponent, DettaglioComponent],
  imports: [
    CommonCompModule,
  ],
  exports: [
    DettaglioImpiantoComponent,
    NuovoResponsabileProprietarioComponent
  ]
})
export class DettaglioImpiantoModule { }
