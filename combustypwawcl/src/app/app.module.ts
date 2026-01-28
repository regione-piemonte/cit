import { DEFAULT_CURRENCY_CODE, LOCALE_ID, NgModule } from '@angular/core';
import { MomentDateAdapter } from '@angular/material-moment-adapter';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ErrorComponent } from './components/error/error.component';
import { MainComponent } from './components/main/main.component';
import { CommonCompModule } from "./common/common.module";
import { NgxPermissionsModule } from 'ngx-permissions';
import { environment } from 'src/environments/environment';
import { ServiceWorkerModule } from '@angular/service-worker';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { MAT_SNACK_BAR_DEFAULT_OPTIONS } from '@angular/material/snack-bar';
import { MAT_RADIO_DEFAULT_OPTIONS } from '@angular/material/radio';
import { MAT_CHECKBOX_DEFAULT_OPTIONS } from '@angular/material/checkbox';
import { DateAdapter, MAT_DATE_FORMATS, MAT_DATE_LOCALE } from '@angular/material/core';
import { DatePipe, registerLocaleData } from '@angular/common';
import localeIt from '@angular/common/locales/it';
import { CachingInterceptor } from './interceptors/caching.interceptor';
import { CustomHttpInterceptor } from './interceptors/custom-http.interceptor';
import { ErrorHandlingInterceptor } from './interceptors/error-handling.interceptor';
import { UrlInterceptor } from './interceptors/url.interceptor';
import { RouteReuseStrategy } from '@angular/router';
import { CustomReuseStrategy } from './custom-reuse-strategy';
import { PrivacyDialogComponent } from './ruolo/components/privacy-dialog/privacy-dialog.component';
import { RuoloModule } from './ruolo/ruolo.module';
import { RicercaImpresaComponent } from './ricerca-impresa/ricerca-impresa.component';
import { ElencoDatiInviatiComponent } from './elenco-dati-inviati/elenco-dati-inviati.component';
import { ImportazioneXmlComponent } from './importazione-xml/importazione-xml.component';
import { FileDragNDropDirective } from './importazione-xml/file-drag-n-drop.directive';
import { CercaDatiFornituraComponent } from './caricamento-manuale-semplificato/cerca-dati-fornitura/cerca-dati-fornitura.component';
import { ElencoFornitureComponent } from './caricamento-manuale-semplificato/elenco-forniture/elenco-forniture.component';
import { CaricamentoSemplificatoComponent } from './caricamento-manuale-semplificato/caricamento-semplificato/caricamento-semplificato.component';
import { RisultatoRicercaImpresaComponent } from './risultato-ricerca-impresa/risultato-ricerca-impresa.component';
import { DettaglioAcquisizioneXmlComponent } from './dettaglio-acquisizione-xml/dettaglio-acquisizione-xml.component';
import { MatDialogModule } from '@angular/material/dialog';
import { MatTableModule } from '@angular/material/table';
import { MatSortModule } from '@angular/material/sort';
import { AnnullaAcquisizioneComponent } from './annulla-acquisizione/annulla-acquisizione.component';
import { DisponibilitaServizioComponent } from './disponibilita-servizio/disponibilita-servizio.component';
import { ZXingScannerModule } from '@zxing/ngx-scanner';

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
    ErrorComponent,
    MainComponent,
    RicercaImpresaComponent,
    ElencoDatiInviatiComponent,
    ImportazioneXmlComponent,
    FileDragNDropDirective,
    CercaDatiFornituraComponent,
    ElencoFornitureComponent,
    CaricamentoSemplificatoComponent,
    RisultatoRicercaImpresaComponent,
    DettaglioAcquisizioneXmlComponent,
    AnnullaAcquisizioneComponent,
    DisponibilitaServizioComponent
  ],
  imports: [
    MatDialogModule,
    MatTableModule,
    MatSortModule,
    CommonCompModule,
    HttpClientModule,
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    RuoloModule,
    NgxPermissionsModule.forRoot(),
    ServiceWorkerModule.register('ngsw-worker.js', {
      enabled: environment.production,
      registrationStrategy: 'registerWhenStable:30000'
    }),
    ZXingScannerModule,
    ServiceWorkerModule.register('ngsw-worker.js', {
      enabled: environment.production,
      // Register the ServiceWorker as soon as the application is stable
      // or after 30 seconds (whichever comes first).
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
    { provide: DatePipe },
    {
      provide: RouteReuseStrategy,
      useClass: CustomReuseStrategy
    },
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
