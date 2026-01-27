import { Directive, ElementRef, HostListener, Input, OnInit } from '@angular/core';

@Directive({
  selector: 'input[appStripWhen],textarea[appStripWhen]'
})
export class StripWhenDirective implements OnInit {
  @Input()
  public appStripWhen: string;

  constructor(private el: ElementRef<HTMLInputElement | HTMLTextAreaElement>) {}

  private updateValue() {
    const regExp = new RegExp(this.appStripWhen);
    const value = this.el.nativeElement.value?.replace(regExp, '');
    this.el.nativeElement.value = value;
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
