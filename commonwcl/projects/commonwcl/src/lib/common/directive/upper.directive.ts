import { Directive, ElementRef, HostListener, OnInit } from '@angular/core';
import { NgControl } from '@angular/forms';

@Directive({
  selector: 'input[appUpper],textarea[appUpper]',
})
export class UpperDirective implements OnInit {
  constructor(private el: ElementRef<HTMLInputElement>, private control: NgControl) {}

  private updateValue() {
    const value = this.el.nativeElement.value?.toUpperCase();
    this.el.nativeElement.value = value;
    this.control.control.setValue(value);
  }

  ngOnInit() {
    this.updateValue();
  }

  @HostListener('input')
  @HostListener('blur')
  onInputOrBlur() {
    this.updateValue();
  }
}
