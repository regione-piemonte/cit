import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatAutocompleteModule } from '@angular/material/autocomplete';
import { MatBadgeModule } from '@angular/material/badge';
import { MatBottomSheetModule } from '@angular/material/bottom-sheet';
import { MatButtonModule } from '@angular/material/button';
import { MatButtonToggleModule } from '@angular/material/button-toggle';
import { MatCardModule } from '@angular/material/card';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { MatChipsModule } from '@angular/material/chips';
import { MatNativeDateModule, MatRippleModule } from '@angular/material/core';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatDialogModule } from '@angular/material/dialog';
import { MatExpansionModule } from '@angular/material/expansion';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatGridListModule } from '@angular/material/grid-list';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatListModule } from '@angular/material/list';
import { MatMenuModule } from '@angular/material/menu';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';
import { MatRadioModule } from '@angular/material/radio';
import { MatSelectModule } from '@angular/material/select';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import { MatSliderModule } from '@angular/material/slider';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { MatStepperModule } from '@angular/material/stepper';
import { MatTabsModule } from '@angular/material/tabs';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatTooltipModule } from '@angular/material/tooltip';
import { RouterModule } from '@angular/router';
import { NgxPermissionsModule } from 'ngx-permissions';
import { MapValuePipe } from '../pipe/map-value.pipe';
import { NomeDocPipe } from '../pipe/nome-doc.pipe';
import { AlertDialogComponent } from './components/alert-dialog/alert-dialog.component';
import { AlertHookComponent } from './components/alert-hook/alert-hook.component';
import { AlertComponent } from './components/alert/alert.component';
import { BackComponent } from './components/back/back.component';
import { BreadcrumbComponent } from './components/breadcrumb/breadcrumb.component';
import { CardDocumentoComponent } from './components/card-documento/card-documento.component';
import { ConfirmDialogComponent } from './components/confirm-dialog/confirm-dialog.component';
import { DeleteDialogComponent } from './components/delete-dialog/delete-dialog.component';
import { StripWhenDirective } from './components/directives/strip-when.directive';
import { UpperDirective } from './components/directives/upper.directive';
import { Footer2Component } from './components/footer2/footer2.component';
import { HeaderComponent } from './components/header/header.component';
import { ImpiantoHeaderComponent } from './components/impianto-header/impianto-header.component';
import { ImpiantoInfoBoxComponent } from './components/impianto-info-box/impianto-info-box.component';
import { LoadingComponent } from './components/loading/loading.component';
import { MessageBoxComponent } from './components/message-box/message-box.component';
import { PageTitleComponent } from './components/page-title/page-title.component';
import { RoleHeaderComponent } from './components/role-header/role-header.component';
import { RoleInfoBoxComponent } from './components/role-info-box/role-info-box.component';
import { TitleComponent } from './components/title/title.component';
import { RapprovaNotificationsComponent } from './components/rapprova-notifications/rapprova-notifications.component';

@NgModule({
  declarations: [
    TitleComponent,
    MessageBoxComponent,
    LoadingComponent,
    HeaderComponent,
    RoleHeaderComponent,
    BackComponent,
    ImpiantoHeaderComponent,
    DeleteDialogComponent,
    RoleInfoBoxComponent,
    BreadcrumbComponent,
    ConfirmDialogComponent,
    AlertDialogComponent,
    UpperDirective,
    Footer2Component,
    PageTitleComponent,
    CardDocumentoComponent,
    NomeDocPipe,
    MapValuePipe,
    AlertComponent,
    AlertHookComponent,
    StripWhenDirective,
    ImpiantoInfoBoxComponent,
    RapprovaNotificationsComponent
  ],
  imports: [
    CommonModule,
    RouterModule,
    MatButtonModule,
    MatStepperModule,
    MatGridListModule,
    MatRadioModule,
    MatBottomSheetModule,
    MatSidenavModule,
    MatToolbarModule,
    MatButtonToggleModule,
    MatRippleModule,
    MatCardModule,
    MatListModule,
    MatMenuModule,
    MatIconModule,
    MatFormFieldModule,
    MatInputModule,
    ReactiveFormsModule,
    MatSelectModule,
    MatDialogModule,
    MatSliderModule,
    MatExpansionModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatSlideToggleModule,
    MatTabsModule,
    FormsModule,
    MatCheckboxModule,
    MatAutocompleteModule,
    MatProgressSpinnerModule,
    MatBadgeModule,
    MatSnackBarModule,
    MatTooltipModule,
    NgxPermissionsModule,
    MatChipsModule,
  ],
  exports: [
    CommonModule,
    TitleComponent,
    MessageBoxComponent,
    LoadingComponent,
    HeaderComponent,
    RoleHeaderComponent,
    BackComponent,
    ImpiantoHeaderComponent,
    RoleInfoBoxComponent,
    BreadcrumbComponent,
    MatButtonModule,
    MatStepperModule,
    MatGridListModule,
    MatRadioModule,
    MatBottomSheetModule,
    MatSidenavModule,
    MatToolbarModule,
    MatButtonToggleModule,
    MatRippleModule,
    MatCardModule,
    MatListModule,
    MatMenuModule,
    MatIconModule,
    MatTabsModule,
    MatFormFieldModule,
    MatInputModule,
    ReactiveFormsModule,
    MatSelectModule,
    MatDialogModule,
    MatSliderModule,
    MatExpansionModule,
    MatDatepickerModule,
    MatBadgeModule,
    MatNativeDateModule,
    MatSlideToggleModule,
    FormsModule,
    MatCheckboxModule,
    MatAutocompleteModule,
    MatProgressSpinnerModule,
    MatSnackBarModule,
    UpperDirective,
    StripWhenDirective,
    PageTitleComponent,
    CardDocumentoComponent,
    NomeDocPipe,
    MapValuePipe,
    AlertHookComponent,
    AlertComponent,
    ImpiantoInfoBoxComponent,
    MatChipsModule
  ]
})
export class CommonCompModule { }
