import { NgModule } from '@angular/core';
import { CommonCompModule } from '../common/common.module';
import { RolesComponent } from './components/pages/roles/roles.component';
import { PreviewComponent } from './components/preview/preview.component';
import { PrivacyDialogComponent } from './components/privacy-dialog/privacy-dialog.component';



@NgModule({
  declarations: [
    PreviewComponent,
    RolesComponent,
    PrivacyDialogComponent
  ],
  imports: [
    CommonCompModule,
  ],
  exports: [
    PreviewComponent,
    RolesComponent,
    PrivacyDialogComponent
  ]
})
export class RuoloModule { }
