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
import { HeaderComponent } from './components/header/header.component';
import { Footer2Component } from './components/footer2/footer2.component';
import { TitleComponent } from './components/title/title.component';
import { AlertHookComponent } from './components/alert-hook/alert-hook.component';
import { AlertComponent } from './components/alert/alert.component';
import { MessageBoxComponent } from './components/message-box/message-box.component';
import { NgxPermissionsModule } from 'ngx-permissions';
import { LoadingComponent } from './components/loading/loading.component';
import { RoleHeaderComponent } from './components/role-header/role-header.component';
import { BackComponent } from './components/back/back.component';
import { RoleInfoBoxComponent } from './components/role-info-box/role-info-box.component';


@NgModule({
  declarations: [
    HeaderComponent,
    Footer2Component,
    TitleComponent,
    AlertHookComponent,
    AlertComponent,
    MessageBoxComponent,
    LoadingComponent,
    RoleHeaderComponent,
    BackComponent,
    RoleInfoBoxComponent,
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
    //ImpiantoHeaderComponent,
    //RoleInfoBoxComponent,
    //BreadcrumbComponent,
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
    //UpperDirective,
    //StripWhenDirective,
    //PageTitleComponent,
    //CardDocumentoComponent,
    //NomeDocPipe,
    //MapValuePipe,
    AlertHookComponent,
    AlertComponent,
    //ImpiantoInfoBoxComponent,
    MatChipsModule
  ]
})
export class CommonCompModule { }
