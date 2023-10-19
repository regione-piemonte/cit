import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MainComponent } from './components/main/main.component';
import { DettaglioCgComponent } from './dettaglio-comp/components/pages/dettaglio-cg/dettaglio-cg.component';
import { DettaglioGfComponent } from './dettaglio-comp/components/pages/dettaglio-gf/dettaglio-gf.component';
import { DettaglioGtComponent } from './dettaglio-comp/components/pages/dettaglio-gt/dettaglio-gt.component';
import { DettaglioScComponent } from './dettaglio-comp/components/pages/dettaglio-sc/dettaglio-sc.component';
import { DettaglioImpiantoComponent } from './dettaglio-impianto/components/pages/dettaglio-impianto/dettaglio-impianto.component';
import { DettaglioComponent } from './dettaglio-impianto/dettaglio/dettaglio.component';
import { CercaControlliComponent } from './elenco-controlli/components/pages/cerca-controlli/cerca-controlli.component';
import { ElencoControlliComponent } from './elenco-controlli/components/pages/elenco-controlli/elenco-controlli.component';
import { AuthenticationGuard } from './guard/authentication.guard';
import { DettaglioImpiantoGuard } from './guard/dettaglio-impianto.guard';
import { NuovoImpiantoGuard } from './guard/nuovo-impianto.guard';
import { RicercaImpiantoGuard } from './guard/ricerca-impianto.guard';
import { ImpiantoComponent } from './impianto/components/impianto/impianto.component';
import { RicercaImpiantiComponent } from './impianto/components/pages/ricerca-impianti/ricerca-impianti.component';
import { RisultatoRicercaImpiantiComponent } from './impianto/components/pages/risultato-ricerca-impianti/risultato-ricerca-impianti.component';
import { NuovoImpiantoComponent } from './inserisci-impianto/components/pages/nuovo-impianto/nuovo-impianto.component';
import { AggiungiManutenzioneComponent } from './nuovo-controllo/components/pages/aggiungi-manutenzione/aggiungi-manutenzione.component';
import { DettaglioTipo1BComponent } from './nuovo-controllo/components/pages/dettaglio-tipo1-b/dettaglio-tipo1-b.component';
import { DettaglioTipo1Component } from './nuovo-controllo/components/pages/dettaglio-tipo1/dettaglio-tipo1.component';
import { DettaglioTipo2Component } from './nuovo-controllo/components/pages/dettaglio-tipo2/dettaglio-tipo2.component';
import { DettaglioTipo3Component } from './nuovo-controllo/components/pages/dettaglio-tipo3/dettaglio-tipo3.component';
import { DettaglioTipo4Component } from './nuovo-controllo/components/pages/dettaglio-tipo4/dettaglio-tipo4.component';
import { RolesComponent } from './ruolo/components/pages/roles/roles.component';

const routes: Routes = [
  { path: '', redirectTo: 'ruoli', pathMatch: 'full' },
  {
    path: '', component: MainComponent, canActivate: [AuthenticationGuard], children: [
      { path: 'ruoli', component: RolesComponent },
      {
        path: 'impianto', component: ImpiantoComponent, canActivate: [RicercaImpiantoGuard], children: [
          { path: 'ricerca-impianti', component: RicercaImpiantiComponent },
          { path: 'risultato-ricerca', component: RisultatoRicercaImpiantiComponent },
          { path: 'dettaglio-impianto/:id_impianto', component: DettaglioImpiantoComponent, canActivate: [DettaglioImpiantoGuard] },
          { path: 'nuovo-impianto', component: NuovoImpiantoComponent, canActivate: [NuovoImpiantoGuard] },
          {
            path: 'dettaglio/:id_impianto', component: DettaglioComponent, canActivate: [DettaglioImpiantoGuard], children: [
              { path: 'dettaglio-gt/:progr', component: DettaglioGtComponent },
              { path: 'dettaglio-gt', component: DettaglioGtComponent },

              { path: 'dettaglio-gf/:progr', component: DettaglioGfComponent },
              { path: 'dettaglio-gf', component: DettaglioGfComponent },

              { path: 'dettaglio-sc/:progr', component: DettaglioScComponent },
              { path: 'dettaglio-sc', component: DettaglioScComponent },

              { path: 'dettaglio-cg/:progr', component: DettaglioCgComponent },
              { path: 'dettaglio-cg', component: DettaglioCgComponent },

              { path: 'elenco-controlli', component: ElencoControlliComponent },
              { path: 'elenco-controlli/cerca-controlli', component: CercaControlliComponent },
              { path: 'elenco-controlli/aggiungi-manutenzione', component: AggiungiManutenzioneComponent },
              { path: 'elenco-controlli/aggiungi-ree-tipo1', component: DettaglioTipo1Component },
              { path: 'elenco-controlli/aggiungi-ree-tipo1B', component: DettaglioTipo1BComponent },
              { path: 'elenco-controlli/aggiungi-ree-tipo2', component: DettaglioTipo2Component },
              { path: 'elenco-controlli/aggiungi-ree-tipo3', component: DettaglioTipo3Component },
              { path: 'elenco-controlli/aggiungi-ree-tipo4', component: DettaglioTipo4Component },
              { path: 'elenco-controlli/ree-tipo1/:id_allegato', component: DettaglioTipo1Component },
              { path: 'elenco-controlli/ree-tipo1B/:id_allegato', component: DettaglioTipo1BComponent },
              { path: 'elenco-controlli/ree-tipo2/:id_allegato', component: DettaglioTipo2Component },
              { path: 'elenco-controlli/ree-tipo3/:id_allegato', component: DettaglioTipo3Component },
              { path: 'elenco-controlli/ree-tipo4/:id_allegato', component: DettaglioTipo4Component }
            ]
          },
        ]
      },
    ]
  }];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
