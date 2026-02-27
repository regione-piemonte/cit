import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { CommonWclCompModule } from '../common/common.module';
import { CardImpresaComponent } from './components/card-impresa/card-impresa.component';
import { ElencoImpreseComponent } from './components/elenco-imprese/elenco-imprese.component';
import { GestioneDatiComponent } from './components/gestione-dati/gestione-dati.component';
import { AccreditamentoImpresaComponent } from './components/impresa/accreditamento-impresa.component';
import { NuovaDelegaComponent } from './components/nuova-delega/nuova-delega.component';
import { NuovoIncaricoComponent } from './components/nuovo-incarico/nuovo-incarico.component';
import { GeneraTokenComponent } from './components/genera-token/genera-token.component';



@NgModule({
  declarations: [
    GestioneDatiComponent,
    AccreditamentoImpresaComponent,
    NuovaDelegaComponent,
    NuovoIncaricoComponent,
    CardImpresaComponent,
    ElencoImpreseComponent,
    GeneraTokenComponent
  ],
  imports: [
    CommonModule,
    CommonWclCompModule
  ],
  exports: [
    GestioneDatiComponent,
    AccreditamentoImpresaComponent,
    NuovaDelegaComponent,
    NuovoIncaricoComponent,
    ElencoImpreseComponent,
    GeneraTokenComponent
  ]
})
export class CommonWclAccreditamentoModule { }
