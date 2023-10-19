import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { MomentDateAdapter } from '@angular/material-moment-adapter';
import { MAT_CHECKBOX_DEFAULT_OPTIONS } from '@angular/material/checkbox';
import { MAT_RADIO_DEFAULT_OPTIONS } from '@angular/material/radio';

import { DateAdapter, MAT_DATE_FORMATS, MAT_DATE_LOCALE } from '@angular/material/core';
import { ServiceWorkerModule } from '@angular/service-worker';
import { environment } from '../environments/environment';
import { AppComponent } from './app.component';
import { CommonCompModule } from './common/common.module';
import { MainComponent } from './components/main/main.component';
import { DettaglioCompModule } from './dettaglio-comp/dettaglio-comp.module';
import { DettaglioImpiantoModule } from './dettaglio-impianto/dettaglio-impianto.module';
import { ElencoControlliModule } from './elenco-controlli/elenco-controlli.module';
import { ImpiantoModule } from './impianto/impianto.module';
import { InserisciImpiantoModule } from './inserisci-impianto/inserisci-impianto.module';
import { CustomHttpInterceptor } from './interceptors/custom-http.interceptor';
import { NuovoControlloModule } from './nuovo-controllo/nuovo-controllo.module';
import { RuoloModule } from './ruolo/ruolo.module';

const MY_DATE_FORMAT = {
  parse: {
    dateInput: 'DD/MM/YYYY', // this is how your date will be parsed from Input
  },
  display: {
    dateInput: 'DD/MM/YYYY', // this is how your date will get displayed on the Input
    monthYearLabel: 'MMMM YYYY',
    dateA11yLabel: 'LL',
    monthYearA11yLabel: 'MMMM YYYY'
  }
};
@NgModule({
  declarations: [
    AppComponent,
    MainComponent
  ],
  imports: [
    CommonCompModule,
    RuoloModule,
    DettaglioImpiantoModule,
    ImpiantoModule,
    InserisciImpiantoModule,
    DettaglioCompModule,
    ElencoControlliModule,
    NuovoControlloModule,
    ServiceWorkerModule.register('ngsw-worker.js', {
      enabled: environment.production,
      registrationStrategy: 'registerWhenStable:30000'
    })
  ],
  providers: [
    {
      provide: MAT_RADIO_DEFAULT_OPTIONS,
      useValue: { color: 'primary' },
    }, {
      provide: MAT_CHECKBOX_DEFAULT_OPTIONS,
      useValue: { color: 'primary' },
    }, {
      provide: HTTP_INTERCEPTORS,
      useClass: CustomHttpInterceptor,
      multi: true
    }, { provide: DateAdapter, useClass: MomentDateAdapter, deps: [MAT_DATE_LOCALE] },
    { provide: MAT_DATE_FORMATS, useValue: MY_DATE_FORMAT },
    { provide: MAT_DATE_LOCALE, useValue: "it-IT" }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
