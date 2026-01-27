import { NgModule } from '@angular/core';
import { AppRoutingModule } from '../app-routing.module';
import { CommonCompModule } from '../common/common.module';
import { IdentifyComponent } from '../map/identify/identify.component';
import { MapComponent } from '../map/map.component';
import { ImpiantoComponent } from './components/impianto/impianto.component';
import { RicercaImpiantiComponent } from './components/pages/ricerca-impianti/ricerca-impianti.component';
import { RisultatoRicercaImpiantiComponent } from './components/pages/risultato-ricerca-impianti/risultato-ricerca-impianti.component';
import { RicercaIndirizzoDialogComponent } from './components/ricerca-indirizzo-dialog/ricerca-indirizzo-dialog.component';
import { MatTooltipModule } from '@angular/material/tooltip';

@NgModule({
  declarations: [
    RicercaImpiantiComponent,
    RicercaIndirizzoDialogComponent,
    RisultatoRicercaImpiantiComponent,
    ImpiantoComponent,
    MapComponent,
    IdentifyComponent
  ],
  imports: [
    CommonCompModule,
    AppRoutingModule,
    MatTooltipModule
  ],
  exports:[
    RicercaImpiantiComponent,
    RicercaIndirizzoDialogComponent,
    RisultatoRicercaImpiantiComponent
  ]
})
export class ImpiantoModule { }
