import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { CommonWclCompModule } from '../common.module';
import { CardDatiImpresaComponent } from './card-dati-impresa/card-dati-impresa.component';
import { ConfirmDialog } from './confirm-dialog/confirm-dialog.component';



@NgModule({
  declarations: [
    CardDatiImpresaComponent,
    ConfirmDialog
  ],
  imports: [
    CommonModule,
    CommonWclCompModule
  ],
  exports:[
    CardDatiImpresaComponent
  ]
})
export class CommonWclComponentsModule { }
