import { DatePipe } from '@angular/common';
import { NgModule } from '@angular/core';
import { CommonCompModule } from '../common/common.module';
import { DettaglioCgComponent } from './components/pages/dettaglio-cg/dettaglio-cg.component';
import { DettaglioGfComponent } from './components/pages/dettaglio-gf/dettaglio-gf.component';
import { DettaglioGtComponent } from './components/pages/dettaglio-gt/dettaglio-gt.component';
import { DettaglioScComponent } from './components/pages/dettaglio-sc/dettaglio-sc.component';
import { RicercaPgDialogComponent } from './components/ricerca-pg-dialog/ricerca-pg-dialog.component';
import { RicercaPgResultComponent } from './components/ricerca-pg-result/ricerca-pg-result.component';

@NgModule({
  declarations: [
    DettaglioGtComponent,
    DettaglioGfComponent,
    DettaglioScComponent,
    DettaglioCgComponent,
    RicercaPgDialogComponent,
    RicercaPgResultComponent
  ],
  imports: [
    CommonCompModule
  ],
  exports:[
    DettaglioGtComponent,
    RicercaPgResultComponent
  ],
  providers: [DatePipe]
})
export class DettaglioCompModule { }
