import { Directive, ElementRef, EventEmitter, HostListener, Inject, Input, Output } from '@angular/core';
import { MatDatepicker } from '@angular/material/datepicker';

@Directive({
  selector: '[dynamicDatepicker]',
})
export class DynamicDatepickerDirective {
  @Input() datepickerId: string; // Input to receive the datepicker ID
  @Output() dateChange: EventEmitter<Date> = new EventEmitter<Date>(); // Output to emit date change events


  constructor(private elRef: ElementRef, @Inject(MatDatepicker) private datepicker: MatDatepicker<any>) {} // Inject MatDatepicker


  @HostListener('click')
  onClick() {
    // Get the input element within the directive's scope
    const inputElement = this.elRef.nativeElement.querySelector('input');
      // Open the datepicker using the provided ID
    // const datepicker = document.getElementById(this.datepickerId) as HTMLInputElement;
    this.datepicker.open();

    // Listen for date change events from the datepicker
  }
}
