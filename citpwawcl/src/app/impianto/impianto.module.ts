import { NgModule } from '@angular/core';
import { CommonCompModule } from '../common/common.module';
import { RicercaImpiantiComponent } from './components/pages/ricerca-impianti/ricerca-impianti.component';
import { RisultatoRicercaImpiantiComponent } from './components/pages/risultato-ricerca-impianti/risultato-ricerca-impianti.component';
import { RicercaIndirizzoDialogComponent } from './components/ricerca-indirizzo-dialog/ricerca-indirizzo-dialog.component';
import { ImpiantoComponent } from './components/impianto/impianto.component';


@NgModule({
  declarations: [   
    RicercaImpiantiComponent,
    RicercaIndirizzoDialogComponent,
    RisultatoRicercaImpiantiComponent,
    ImpiantoComponent
  ],
  imports: [
    CommonCompModule,
  ],
  exports:[
    RicercaImpiantiComponent,
    RicercaIndirizzoDialogComponent,
    RisultatoRicercaImpiantiComponent
  ]
})
export class ImpiantoModule { }
