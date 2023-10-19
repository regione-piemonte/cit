import { Component, Input, OnInit } from '@angular/core';
import { ICONSURL } from 'src/app/utils/constants';

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

  descrizioni: string[] = [];

  constructor() { }

  ngOnInit(): void {
  }

  fillDescrizione(): string[] {
    this.descrizione = this.descrizione ? this.descrizione.replace(/<\/?[^>]+(>|$)/g, "\n") : "";
    this.descrizioni = this.descrizione ? this.descrizione.split("\n") : [];
    return this.descrizioni;
  }

}
