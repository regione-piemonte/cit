import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatAutocompleteModule } from '@angular/material/autocomplete';
import { MatBadgeModule } from '@angular/material/badge';
import { MatBottomSheetModule } from '@angular/material/bottom-sheet';
import { MatButtonModule } from '@angular/material/button';
import { MatButtonToggleModule } from '@angular/material/button-toggle';
import { MatCardModule } from '@angular/material/card';
import { MatCheckboxModule } from '@angular/material/checkbox';
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
import { MatStepperModule } from '@angular/material/stepper';
import { MatTabsModule } from '@angular/material/tabs';
import { MatToolbarModule } from '@angular/material/toolbar';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppRoutingModule } from '../app-routing.module';
import { BackComponent } from './components/back/back.component';
import { DeleteDialogComponent } from './components/delete-dialog/delete-dialog.component';
import { FooterComponent } from './components/footer/footer.component';
import { HeaderComponent } from './components/header/header.component';
import { ImpiantoHeaderComponent } from './components/impianto-header/impianto-header.component';
import { LoadingComponent } from './components/loading/loading.component';
import { MessageBoxComponent } from './components/message-box/message-box.component';
import { RoleHeaderComponent } from './components/role-header/role-header.component';
import { TitleComponent } from './components/title/title.component';

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
    TitleComponent,
    FooterComponent,
    MessageBoxComponent,
    LoadingComponent,
    HeaderComponent,
    RoleHeaderComponent,
    BackComponent,
    ImpiantoHeaderComponent,
    DeleteDialogComponent
  ],
  imports: [
    CommonModule,
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
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
    HttpClientModule,
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
    MatBadgeModule
  ],
  exports: [
    TitleComponent,
    FooterComponent,
    MessageBoxComponent,
    LoadingComponent,
    HeaderComponent,
    RoleHeaderComponent,
    BackComponent,
    ImpiantoHeaderComponent,
    CommonModule,
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
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
    HttpClientModule,
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
  ]
})
export class CommonCompModule { }
