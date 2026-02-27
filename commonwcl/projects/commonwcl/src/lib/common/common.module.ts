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
import { MatRadioModule } from '@angular/material/radio';
import { MatSelectModule } from '@angular/material/select';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import { MatSliderModule } from '@angular/material/slider';
import { MatStepperModule } from '@angular/material/stepper';
import { MatTabsModule } from '@angular/material/tabs';
import { MatToolbarModule } from '@angular/material/toolbar';
import { DynamicDatepickerDirective } from './directive/dynamic-date-picker';
import { UpperDirective } from './directive/upper.directive';
import { CustomDatePipe } from './pipe/date.pipe';
import { CommonWclTitleComponent } from './title/title.component';


@NgModule({
  declarations: [
    CommonWclTitleComponent,
    CustomDatePipe,
    DynamicDatepickerDirective,
    UpperDirective
  ],
  imports: [
    CommonModule,
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
  ],
  exports:[
    CommonModule,
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
    CommonWclTitleComponent,
    DynamicDatepickerDirective,
    CustomDatePipe,
    UpperDirective
  ]
})
export class CommonWclCompModule { }
