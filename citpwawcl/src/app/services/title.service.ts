import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class TitleService {
  constructor() {
    //Not Implemented
   }

  title: string = "";
  subtitle: string = "";

  setTitle(elem: string) {
    this.title = elem;
    this.subtitle = "";
  }
  getTitle() {
    return this.title;
  }

  setSubtitle(elem: string) {
    this.subtitle = elem;
  }
  getsubtitle() {
    return this.subtitle;
  }
}
