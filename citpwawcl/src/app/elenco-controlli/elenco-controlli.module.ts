import { CommonModule, DatePipe } from '@angular/common';
import { NgModule } from '@angular/core';
import { CommonCompModule } from '../common/common.module';
import { CercaControlliComponent } from './components/pages/cerca-controlli/cerca-controlli.component';
import { ElencoControlliComponent } from './components/pages/elenco-controlli/elenco-controlli.component';
import { RisultatoRicercaControlliComponent } from './components/risultato-ricerca-controlli/risultato-ricerca-controlli.component';
import { UploadFileDialogComponent } from './components/upload-file-dialog/upload-file-dialog.component';



@NgModule({
  declarations: [ElencoControlliComponent, CercaControlliComponent, RisultatoRicercaControlliComponent, UploadFileDialogComponent],
  imports: [
    CommonModule,
    CommonCompModule
  ],
  exports: [
    ElencoControlliComponent
  ],
  providers: [DatePipe]
})
export class ElencoControlliModule { }
