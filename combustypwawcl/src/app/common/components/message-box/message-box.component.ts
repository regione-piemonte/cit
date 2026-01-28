import { Component, EventEmitter, Input, OnInit, Output, SimpleChanges } from '@angular/core';
import { ICONSURL } from 'src/app/utils/constants';

export const WARNING_TYPE = 1;
export const ERROR_TYPE = 2;
export const INFO_TYPE = 3;
export const CONFIRM_TYPE = 4;

export function getDefaultTitleByType(type: number): string {
  switch (type) {
    case WARNING_TYPE: return 'Attenzione!';
    case ERROR_TYPE: return 'Errore durante l\'operazione!';
    case INFO_TYPE: return '';
    case CONFIRM_TYPE: return 'Successo!';
    default: return null;
  }
}

@Component({
  selector: 'app-message-box',
  templateUrl: './message-box.component.html',
  styleUrls: ['./message-box.component.scss']
})
export class MessageBoxComponent implements OnInit {

  warnIcon: string = ICONSURL + "alert.svg";
  errorIcon: string = ICONSURL + "error.svg";
  infoIcon: string = ICONSURL + "info.svg";
  confirmIcon: string = ICONSURL + "confirm.png";

  @Input()
  type: number = 0;
  @Input()
  titolo: string = "";
  @Input()
  descrizione: string = "";
  @Input()
  mainClass: string;
  @Input()
  timeout?: number;
  @Output()
  onClose = new EventEmitter<void>();

  descrizioni: string[] = [];
  visible: boolean = true;

  constructor() {
    //Not Implemented
   }

  ngOnInit(): void {
    if(!!this.mainClass) {
      this.mainClass = "wide-screen";
    }

    if (this.timeout && this.timeout > 0) {
      setTimeout(() => {
        this.visible = false;
        this.onClose.emit();
      }, this.timeout);
    }
  }

  ngOnChanges(changes: SimpleChanges) {
    if (changes['titolo']) {
      const prev = changes['titolo'].previousValue;
      const curr = changes['titolo'].currentValue;

      if (curr && curr !== '' && prev !== curr) {
        window.scrollTo({ top: 0, behavior: 'smooth' });
      }
    }
  }

  fillDescrizione(): string[] {
    this.descrizione = this.descrizione ? this.descrizione.replace(/<\/?[^>]+(>|$)/g, "\n") : "";
    this.descrizioni = this.descrizione ? this.descrizione.split("\n") : [];
    return this.descrizioni;
  }

  getType(): 'success' | 'warn' | 'error' | 'info' {
    switch (this.type) {
      case 4:
        return 'success';
      case 1:
        return 'warn';
      case 2:
        return 'error';
      default:
        return 'info';
    }
  }

}
