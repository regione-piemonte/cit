import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ErrorComponent } from './components/error/error.component';
import { MainComponent } from './components/main/main.component';
import { DettaglioCgComponent } from './dettaglio-comp/components/pages/dettaglio-cg/dettaglio-cg.component';
import { DettaglioGfComponent } from './dettaglio-comp/components/pages/dettaglio-gf/dettaglio-gf.component';
import { DettaglioGtComponent } from './dettaglio-comp/components/pages/dettaglio-gt/dettaglio-gt.component';
import { DettaglioScComponent } from './dettaglio-comp/components/pages/dettaglio-sc/dettaglio-sc.component';
import { DettaglioNominaComponent } from './dettaglio-impianto/components/dettaglio-nomina/dettaglio-nomina.component';
import { AggiungiDocumentoContrattoComponent } from './dettaglio-impianto/components/documenti-contratto/aggiungi-documento-contratto/aggiungi-documento-contratto.component';
import { DocumentiContrattoComponent } from './dettaglio-impianto/components/documenti-contratto/documenti-contratto.component';
import { AggiungiDocumentiComponent } from './dettaglio-impianto/components/documenti-impianto/aggiungi-documenti/aggiungi-documenti.component';
import { DocumentiImpiantoComponent } from './dettaglio-impianto/components/documenti-impianto/documenti-impianto.component';
import { DettaglioImpiantoComponent } from './dettaglio-impianto/components/pages/dettaglio-impianto/dettaglio-impianto.component';
import { DettaglioSchedaLibrettoComponent } from './dettaglio-impianto/components/scheda-libretto/dettaglio-scheda-libretto/dettaglio-scheda-libretto.component';
import { ListaSchedaLibrettoComponent } from './dettaglio-impianto/components/scheda-libretto/lista-scheda-libretto/lista-scheda-libretto.component';
import { Scheda2TrattamentoAcquaComponent } from './dettaglio-impianto/components/scheda-libretto/scheda2-trattamento-acqua/scheda2-trattamento-acqua.component';
import { Scheda3TerzoResponsabileComponent } from './dettaglio-impianto/components/scheda-libretto/scheda3-terzo-responsabile/scheda3-terzo-responsabile.component';
import { DettaglioComponent } from './dettaglio-impianto/dettaglio/dettaglio.component';
import { DisponibilitaServizioComponent } from './disponibilita-servizio/disponibilita-servizio.component';
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
import { IspezioneAddComponent } from './ispezione/components/ispezione-add/ispezione-add.component';
import { IspezioneAssegnaImpiantoComponent } from './ispezione/components/ispezione-assegna-impianto/ispezione-assegna-impianto.component';
import { IspezioneAssegnaComponent } from './ispezione/components/ispezione-assegna/ispezione-assegna.component';
import { IspezioneAzioneAddComponent } from './ispezione/components/ispezione-azione-add/ispezione-azione-add.component';
import { IspezioneConcludiComponent } from './ispezione/components/ispezione-concludi/ispezione-concludi.component';
import { IspezioneDetailComponent } from './ispezione/components/ispezione-detail/ispezione-detail.component';
import { IspezioneListComponent } from './ispezione/components/ispezione-list/ispezione-list.component';
import { IspezioneSearchComponent } from './ispezione/components/ispezione-search/ispezione-search.component';
import { AggiungiManutenzioneComponent } from './nuovo-controllo/components/pages/aggiungi-manutenzione/aggiungi-manutenzione.component';
import { DettaglioTipo1BComponent } from './nuovo-controllo/components/pages/dettaglio-tipo1-b/dettaglio-tipo1-b.component';
import { DettaglioTipo1Component } from './nuovo-controllo/components/pages/dettaglio-tipo1/dettaglio-tipo1.component';
import { DettaglioTipo2Component } from './nuovo-controllo/components/pages/dettaglio-tipo2/dettaglio-tipo2.component';
import { DettaglioTipo3Component } from './nuovo-controllo/components/pages/dettaglio-tipo3/dettaglio-tipo3.component';
import { DettaglioTipo4Component } from './nuovo-controllo/components/pages/dettaglio-tipo4/dettaglio-tipo4.component';
import { RapprovaAddStep2Component } from './rapprova/components/rapprova-add-step2/rapprova-add-step2.component';
import { RapprovaAddStep3GfComponent } from './rapprova/components/rapprova-add-step3-gf/rapprova-add-step3-gf.component';
import { RapprovaAddStep3GtComponent } from './rapprova/components/rapprova-add-step3-gt/rapprova-add-step3-gt.component';
import { RapprovaAddStep3UploadComponent } from './rapprova/components/rapprova-add-step3-upload/rapprova-add-step3-upload.component';
import { RapprovaAddComponent } from './rapprova/components/rapprova-add/rapprova-add.component';
import { RapprovaEditGfComponent } from './rapprova/components/rapprova-edit-gf/rapprova-edit-gf.component';
import { RapprovaEditGtComponent } from './rapprova/components/rapprova-edit-gt/rapprova-edit-gt.component';
import { RolesComponent } from './ruolo/components/pages/roles/roles.component';
import { AzioneAddComponent } from './verifica/components/azione-add/azione-add.component';
import { IspezioneMassivaAddComponent } from './verifica/components/ispezione-massiva-add/ispezione-massiva-add.component';
import { VerificaAddComponent } from './verifica/components/verifica-add/verifica-add.component';
import { VerificaDetailComponent } from './verifica/components/verifica-detail/verifica-detail.component';
import { VerificaListComponent } from './verifica/components/verifica-list/verifica-list.component';
import { VerificaSearchComponent } from './verifica/components/verifica-search/verifica-search.component';
import { PodPdrDuplicatoComponent } from './inserisci-impianto/components/pages/pod-pdr-duplicato/pod-pdr-duplicato.component';

const routes: Routes = [
  { path: 'error', component: ErrorComponent },
  { path: '', redirectTo: 'ruoli', pathMatch: 'full' },
  {
    path: '', component: MainComponent, canActivate: [AuthenticationGuard], children: [
      { path: 'ruoli', component: RolesComponent },
      { path: 'disponibilita-servizio', component: DisponibilitaServizioComponent },
      { path: 'cerca-verifiche', component: VerificaSearchComponent, data: { reusable: true } },
      { path: 'lista-verifiche', component: VerificaListComponent, data: { reusable: true } },
      { path: 'nuova-verifica', component: VerificaAddComponent },
      { path: 'nuova-ispezione-massiva', component: IspezioneMassivaAddComponent },
      { path: 'dettaglio-verifica/:id', component: VerificaDetailComponent },
      { path: 'dettaglio-verifica/:id/nuova-azione', component: AzioneAddComponent },
      { path: 'dettaglio-verifica/:id/nuova-ispezione', component: IspezioneAddComponent },
      { path: 'dettaglio-verifica/:id/:edit', component: VerificaDetailComponent },
      { path: 'cerca-ispezioni', component: IspezioneSearchComponent, data: { reusable: true } },
      { path: 'lista-ispezioni', component: IspezioneListComponent, data: { reusable: true } },
      { path: 'dettaglio-ispezione/:id', component: IspezioneDetailComponent },
      { path: 'dettaglio-ispezione/:id/assegna', component: IspezioneAssegnaComponent },
      { path: 'dettaglio-ispezione/:id/assegna-impianto', component: IspezioneAssegnaImpiantoComponent },
      { path: 'dettaglio-ispezione/:id/concludi', component: IspezioneConcludiComponent },
      { path: 'dettaglio-ispezione/:id/nuova-azione', component: IspezioneAzioneAddComponent },
      { path: 'dettaglio-ispezione/:id/nuovo-rapprova/step-1', component: RapprovaAddComponent },
      { path: 'dettaglio-ispezione/:id/nuovo-rapprova/step-2', component: RapprovaAddStep2Component },
      { path: 'dettaglio-ispezione/:id/nuovo-rapprova/step-3-upload', component: RapprovaAddStep3UploadComponent },
      { path: 'dettaglio-ispezione/:id/nuovo-rapprova/step-3-gt', component: RapprovaAddStep3GtComponent },
      { path: 'dettaglio-ispezione/:id/nuovo-rapprova/step-3-gf', component: RapprovaAddStep3GfComponent },
      { path: 'dettaglio-ispezione/:id/rapprova-gt/:idAllegato/edit', component: RapprovaEditGtComponent },
      { path: 'dettaglio-ispezione/:id/rapprova-gf/:idAllegato/edit', component: RapprovaEditGfComponent },
      { path: 'dettaglio-ispezione/:id/:edit', component: IspezioneDetailComponent },
      {
        path: 'impianto', component: ImpiantoComponent, canActivate: [RicercaImpiantoGuard], children: [
          { path: 'ricerca-impianti', component: RicercaImpiantiComponent },
          { path: 'risultato-ricerca', component: RisultatoRicercaImpiantiComponent },
          {
            path: 'dettaglio-impianto/:id_impianto',
            canActivate: [DettaglioImpiantoGuard],
            children: [
              { path: '', component: DettaglioImpiantoComponent },
              { path: 'lista', component: ListaSchedaLibrettoComponent },
              { path: 'scheda/3', component: Scheda3TerzoResponsabileComponent },
              { path: 'scheda/2', component: Scheda2TrattamentoAcquaComponent },
              { path: 'scheda/1', component: DettaglioSchedaLibrettoComponent },
              { path: 'documenti', component: DocumentiImpiantoComponent },
              { path: 'documenti/nuovo', component: AggiungiDocumentiComponent },
              {
                path: 'dettaglio-nomina', component: DettaglioNominaComponent
              },
              { path: 'documenti-contratto', component: DocumentiContrattoComponent },
              { path: 'documenti-contratto/nuovo', component: AggiungiDocumentoContrattoComponent }
            ]
          },
          { path: 'nuovo-impianto', component: NuovoImpiantoComponent, canActivate: [NuovoImpiantoGuard] },
          { path: 'pod-pdr-duplicato', component: PodPdrDuplicatoComponent },
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
      { path: 'accreditamento', loadChildren: () => import('./accreditamento/accreditamento.module').then(m => m.AccreditamentoModule) },
      {
        path: 'nomina', loadChildren: () => import('./nomina-terzo-responsabile/nomina-terzo-responsabile.module').then(m => m.NominaTerzoResponsabileModule)
      }
    ]
  }];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

