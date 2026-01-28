import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CommonWclAccreditamentoModule, CommonWclComponentsModule } from '@sigit/common-lib';
import { CommonCompModule } from '../common/common.module';
import { DettaglioCompModule } from '../dettaglio-comp/dettaglio-comp.module';
import { AccreditamentoGuard } from '../guard/accreditamento.guard';
import { CercaImpresaComponent } from './components/dialog/cerca-impresa/cerca-impresa.component';
import { ElencoImpresaComponent } from './components/pages/elenco-imprese/elenco-imprese.component';
import { GestioneDatiComponent } from './components/pages/gestione-dati/gestione-dati.component';
import { ImpresaComponent } from './components/pages/impresa/impresa.component';
import { NuovoIncaricoDelegaComponent } from './components/pages/nuovo-incarico-delega/nuovo-incarico-delega.component';
import { DettaglioTokenComponent } from './components/pages/dettaglio-token/dettaglio-token.component';

const routes: Routes = [
  { path: '', redirectTo: 'gestione-dati', pathMatch: 'full', canActivate: [AccreditamentoGuard] },
  { path: 'gestione-dati', component: GestioneDatiComponent },
  { path: 'dettaglio-impresa', component: ImpresaComponent },
  { path: 'nuova-impresa', component: ImpresaComponent },
  { path: 'nuovo-incarico', component: NuovoIncaricoDelegaComponent },
  { path: 'nuova-delega', component: NuovoIncaricoDelegaComponent },
  {
    path: 'elenco-imprese', component: ElencoImpresaComponent
  },
  { path: 'genera-token', component: DettaglioTokenComponent }
];

@NgModule({
  declarations: [
    GestioneDatiComponent,
    ImpresaComponent,
    NuovoIncaricoDelegaComponent,
    CercaImpresaComponent,
    ElencoImpresaComponent,
    DettaglioTokenComponent
  ],
  imports: [
    CommonCompModule,
    CommonWclAccreditamentoModule,
    CommonWclComponentsModule,
    DettaglioCompModule,
    RouterModule.forChild(routes)
  ],
  exports: [
  ]
})
export class AccreditamentoModule { }
