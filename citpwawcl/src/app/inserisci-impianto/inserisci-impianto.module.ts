import { NgModule } from '@angular/core';
import { CommonCompModule } from '../common/common.module';
import { NuovoImpiantoComponent } from './components/pages/nuovo-impianto/nuovo-impianto.component';



@NgModule({
  declarations: [
    NuovoImpiantoComponent
  ],
  imports: [
    CommonCompModule,
  ],
  exports: [
    NuovoImpiantoComponent
  ]
})
export class InserisciImpiantoModule { }
