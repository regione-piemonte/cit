import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ErrorComponent } from './components/error/error.component';
import { RolesComponent } from './ruolo/components/pages/roles/roles.component';
import { MainComponent } from './components/main/main.component';
import { RicercaImpresaComponent } from './ricerca-impresa/ricerca-impresa.component';
import { ElencoDatiInviatiComponent } from './elenco-dati-inviati/elenco-dati-inviati.component';
import { ImportazioneXmlComponent } from './importazione-xml/importazione-xml.component';
import { CercaDatiFornituraComponent } from './caricamento-manuale-semplificato/cerca-dati-fornitura/cerca-dati-fornitura.component';
import { ElencoFornitureComponent } from './caricamento-manuale-semplificato/elenco-forniture/elenco-forniture.component';
import { CaricamentoSemplificatoComponent } from './caricamento-manuale-semplificato/caricamento-semplificato/caricamento-semplificato.component';
import { RisultatoRicercaImpresaComponent } from './risultato-ricerca-impresa/risultato-ricerca-impresa.component';
import { DisponibilitaServizioComponent } from './disponibilita-servizio/disponibilita-servizio.component';
import { AuthenticationGuard } from './guard/authentication.guard';

const routes: Routes = [
  { path: 'error', component: ErrorComponent },
  { path: '', redirectTo: 'ruoli', pathMatch: 'full' },
  { 
    path: '', component: MainComponent, canActivate: [AuthenticationGuard],  children: [
      { path: 'ruoli', component: RolesComponent },
      { path: 'ricerca-impresa', component: RicercaImpresaComponent},
      { path: 'risultato-ricerca-impresa', component: RisultatoRicercaImpresaComponent},
      { path: 'elenco-dati-inviati', component: ElencoDatiInviatiComponent},
      { path: 'importazione-xml', component: ImportazioneXmlComponent},
      { path: 'accreditamento', loadChildren: () => import('./accreditamento/accreditamento.module').then(m => m.AccreditamentoModule) },
      { path: 'cerca-dati-fornitura', component: CercaDatiFornituraComponent},
      { path: 'elenco-forniture', component: ElencoFornitureComponent},
      { path: 'caricamento-semplificato', component: CaricamentoSemplificatoComponent},
      { path: 'disponibilita-servizio', component: DisponibilitaServizioComponent}
    ]
  }];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
