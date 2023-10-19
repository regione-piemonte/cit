import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class BackService {
  constructor() { }

  backTitle: any;
  route: any;


  setBackTitle(elem: any) {
    this.backTitle = elem;
  }

  refreshBack() {
    this.backTitle = undefined;
    this.route = undefined;
  }

  getBack() {
    return this.backTitle;
  }

  setRoute(elem) {
    this.route = elem;
  }

  getRoute() {
    return this.route;
  }
}
