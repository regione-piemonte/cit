import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CommonCompModule } from '../common/common.module';
import { AuthenticationGuard } from '../guard/authentication.guard';
import { AffidamentoOccasionaleComponent } from './components/pages/affidamento-occasionale/affidamento-occasionale.component';
import { CessazioneComponent } from './components/pages/cessazione/cessazione.component';
import { NominaComponent } from './components/pages/nomina/nomina.component';
import { ProrogaComponent } from './components/pages/proroga/proroga.component';
import { RicercaIndirizzoComponent } from './components/pages/ricerca-indirizzo/ricerca-indirizzo.component';
import { SelezionaSubentroComponent } from './components/pages/seleziona-subentro/seleziona-subentro.component';

// Import any other necessary modules or components here

const routes: Routes = [
    { path: '', redirectTo: 'ricerca-indirizzo', pathMatch: 'full', canActivate: [AuthenticationGuard] },
    { path: 'ricerca-indirizzo', component: RicercaIndirizzoComponent },
    { path: 'seleziona-subentro', component: SelezionaSubentroComponent },
    { path: 'effettua-subentro', component: SelezionaSubentroComponent },
    { path: 'seleziona-affidamento', component: AffidamentoOccasionaleComponent },
    { path: 'effettua-affidamento', component: AffidamentoOccasionaleComponent },
    { path: 'nomina', component: NominaComponent },
    { path: 'cessazione', component: CessazioneComponent },
    { path: 'proroga', component: ProrogaComponent }

    // { path: 'cerca-impresa', component: CercaImpresaComponent }
];

@NgModule({
    declarations: [
        // Declare any components, directives, or pipes used in this module
        RicercaIndirizzoComponent,
        SelezionaSubentroComponent,
        NominaComponent,
        CessazioneComponent,
        ProrogaComponent
    ],
    imports: [
        CommonModule,
        CommonCompModule,
        // Add any other imported modules here
        RouterModule.forChild(routes)
    ],
    exports: [
        // Export any components, directives, or pipes that need to be used outside of this module
    ],
})
export class NominaTerzoResponsabileModule { }
