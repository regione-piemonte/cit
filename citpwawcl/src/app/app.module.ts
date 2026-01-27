import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { DEFAULT_CURRENCY_CODE, LOCALE_ID, NgModule } from '@angular/core';
import { MomentDateAdapter } from '@angular/material-moment-adapter';
import { MAT_CHECKBOX_DEFAULT_OPTIONS } from '@angular/material/checkbox';
import { MAT_RADIO_DEFAULT_OPTIONS } from '@angular/material/radio';

import { CommonModule, registerLocaleData } from '@angular/common';
import localeIt from '@angular/common/locales/it';
import { DateAdapter, MAT_DATE_FORMATS, MAT_DATE_LOCALE } from '@angular/material/core';
import { MAT_SNACK_BAR_DEFAULT_OPTIONS } from '@angular/material/snack-bar';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { RouteReuseStrategy } from '@angular/router';
import { ServiceWorkerModule } from '@angular/service-worker';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { NgxPermissionsModule } from 'ngx-permissions';
import { environment } from '../environments/environment';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CommonCompModule } from './common/common.module';
import { ErrorComponent } from './components/error/error.component';
import { LoadingDialogComponent } from './components/loading-dialog/loading-dialog.component';
import { MainComponent } from './components/main/main.component';
import { CustomReuseStrategy } from './custom-reuse-strategy';
import { DettaglioCompModule } from './dettaglio-comp/dettaglio-comp.module';
import { DettaglioImpiantoModule } from './dettaglio-impianto/dettaglio-impianto.module';
import { DisponibilitaServizioComponent } from './disponibilita-servizio/disponibilita-servizio.component';
import { ElencoControlliModule } from './elenco-controlli/elenco-controlli.module';
import { ImpiantoModule } from './impianto/impianto.module';
import { InserisciImpiantoModule } from './inserisci-impianto/inserisci-impianto.module';
import { CachingInterceptor } from './interceptors/caching.interceptor';
import { CustomHttpInterceptor } from './interceptors/custom-http.interceptor';
import { ErrorHandlingInterceptor } from './interceptors/error-handling.interceptor';
import { UrlInterceptor } from './interceptors/url.interceptor';
import { IspezioneAddComponent } from './ispezione/components/ispezione-add/ispezione-add.component';
import { IspezioneAssegnaImpiantoComponent } from './ispezione/components/ispezione-assegna-impianto/ispezione-assegna-impianto.component';
import { IspezioneAssegnaComponent } from './ispezione/components/ispezione-assegna/ispezione-assegna.component';
import { IspezioneAzioneAddComponent } from './ispezione/components/ispezione-azione-add/ispezione-azione-add.component';
import { IspezioneConcludiComponent } from './ispezione/components/ispezione-concludi/ispezione-concludi.component';
import { IspezioneDetailComponent } from './ispezione/components/ispezione-detail/ispezione-detail.component';
import { IspezioneListComponent } from './ispezione/components/ispezione-list/ispezione-list.component';
import { IspezioneSearchComponent } from './ispezione/components/ispezione-search/ispezione-search.component';
import { AffidamentoOccasionaleComponent } from './nomina-terzo-responsabile/components/pages/affidamento-occasionale/affidamento-occasionale.component';
import { NuovoControlloModule } from './nuovo-controllo/nuovo-controllo.module';
import { OrDashPipe } from './pipe/or-dash.pipe';
import { ZeroToNullPipe } from './pipe/zero-to-null.pipe';
import { RapprovaAddStep2Component } from './rapprova/components/rapprova-add-step2/rapprova-add-step2.component';
import { RapprovaAddStep3GfComponent } from './rapprova/components/rapprova-add-step3-gf/rapprova-add-step3-gf.component';
import { RapprovaAddStep3GtComponent } from './rapprova/components/rapprova-add-step3-gt/rapprova-add-step3-gt.component';
import { RapprovaAddStep3UploadComponent } from './rapprova/components/rapprova-add-step3-upload/rapprova-add-step3-upload.component';
import { RapprovaAddComponent } from './rapprova/components/rapprova-add/rapprova-add.component';
import { RapprovaEditGfComponent } from './rapprova/components/rapprova-edit-gf/rapprova-edit-gf.component';
import { RapprovaEditGtComponent } from './rapprova/components/rapprova-edit-gt/rapprova-edit-gt.component';
import { RapprovaUploadFirmatoDialogComponent } from './rapprova/components/rapprova-upload-firmato-dialog/rapprova-upload-firmato-dialog.component';
import { RuoloModule } from './ruolo/ruolo.module';
import { AzioneAddComponent } from './verifica/components/azione-add/azione-add.component';
import { IspezioneMassivaAddComponent } from './verifica/components/ispezione-massiva-add/ispezione-massiva-add.component';
import { VerificaAddComponent } from './verifica/components/verifica-add/verifica-add.component';
import { VerificaDetailComponent } from './verifica/components/verifica-detail/verifica-detail.component';
import { VerificaListComponent } from './verifica/components/verifica-list/verifica-list.component';
import { VerificaSearchComponent } from './verifica/components/verifica-search/verifica-search.component';

registerLocaleData(localeIt, 'it');

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
    MainComponent,
    DisponibilitaServizioComponent,
    VerificaListComponent,
    VerificaSearchComponent,
    VerificaAddComponent,
    VerificaDetailComponent,
    ErrorComponent,
    LoadingDialogComponent,
    AzioneAddComponent,
    OrDashPipe,
    ZeroToNullPipe,
    IspezioneSearchComponent,
    IspezioneListComponent,
    IspezioneDetailComponent,
    IspezioneAssegnaComponent,
    IspezioneAssegnaImpiantoComponent,
    IspezioneConcludiComponent,
    IspezioneAddComponent,
    IspezioneMassivaAddComponent,
    RapprovaAddComponent,
    RapprovaUploadFirmatoDialogComponent,
    AffidamentoOccasionaleComponent,
    IspezioneAzioneAddComponent,
    RapprovaAddStep2Component,
    RapprovaAddStep3UploadComponent,
    RapprovaAddStep3GtComponent,
    RapprovaAddStep3GfComponent,
    RapprovaEditGtComponent,
    RapprovaEditGfComponent
  ],
  imports: [
    CommonModule,
    CommonCompModule,
    HttpClientModule,
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    NgbModule,
    RuoloModule,
    DettaglioImpiantoModule,
    ImpiantoModule,
    InserisciImpiantoModule,
    DettaglioCompModule,
    ElencoControlliModule,
    NuovoControlloModule,
    NgxPermissionsModule.forRoot(),
    ServiceWorkerModule.register('ngsw-worker.js', {
      enabled: environment.production,
      registrationStrategy: 'registerWhenStable:30000'
    })
  ],
  providers: [
    { provide: LOCALE_ID, useValue: 'it' },
    { provide: DEFAULT_CURRENCY_CODE, useValue: 'EUR' },
    { provide: MAT_SNACK_BAR_DEFAULT_OPTIONS, useValue: { duration: 10000 } },
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
    }, {
      provide: HTTP_INTERCEPTORS,
      useClass: CachingInterceptor,
      multi: true
    }, {
      provide: HTTP_INTERCEPTORS,
      useClass: UrlInterceptor,
      multi: true
    }, {
      provide: HTTP_INTERCEPTORS,
      useClass: ErrorHandlingInterceptor,
      multi: true
    }, { provide: DateAdapter, useClass: MomentDateAdapter, deps: [MAT_DATE_LOCALE] },
    { provide: MAT_DATE_FORMATS, useValue: MY_DATE_FORMAT },
    { provide: MAT_DATE_LOCALE, useValue: "it-IT" },
    {
      provide: RouteReuseStrategy,
      useClass: CustomReuseStrategy
    },
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
