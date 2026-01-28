import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class MessageService {

  titolo: string;
  descrizione: string;
  type: number;
  showMessaggio: boolean = false;

  constructor() { this.showMessaggio = false }

  getTitolo() {
    return this.titolo;
  }
  setTitolo(elem: string) {
    this.titolo = elem;
    this.showMessaggio = false;
  }

  getDescrizione() {
    return this.descrizione;
  }
  setDescrizione(elem: string) {
    this.descrizione = elem;
    this.showMessaggio = false;
  }
  getType() {
    return this.type;
  }
  setType(elem: number) {
    this.type = elem;
  }
  getShowMessaggio() {
    return this.showMessaggio;
  }

  showMessaggioM() {
    window.scroll({
      top: 0,
      left: 0,
      behavior: 'smooth'
    });
    var id = window.setTimeout(function () {
      //This is intentional
    }, 0);
    while (id--) {
      window.clearTimeout(id);
    }
    this.showMessaggio = true;
    setTimeout(() => {
      this.showMessaggio = false;
      this.titolo = "";
      this.type = undefined;
      this.descrizione = "";
    }, 10000);
  }
}
