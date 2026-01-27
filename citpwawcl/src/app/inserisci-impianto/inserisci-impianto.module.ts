import { NgModule } from '@angular/core';
import { CommonCompModule } from '../common/common.module';
import { NuovoImpiantoComponent } from './components/pages/nuovo-impianto/nuovo-impianto.component';
import { PodPdrDuplicatoComponent } from './components/pages/pod-pdr-duplicato/pod-pdr-duplicato.component';
import { MatTooltipModule } from '@angular/material/tooltip';

@NgModule({
  declarations: [
    NuovoImpiantoComponent,
    PodPdrDuplicatoComponent
  ],
  imports: [
    CommonCompModule,
    MatTooltipModule
  ],
  exports: [
    NuovoImpiantoComponent
  ]
})
export class InserisciImpiantoModule { }
