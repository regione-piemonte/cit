import { Component, OnInit } from '@angular/core';
import { IMAGESURL } from 'src/app/utils/constants';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.scss']
})
export class FooterComponent implements OnInit {

  privacy: string = "Note legali e privacy";
  cookie: string = "Cookie policy";
  accessibilita: string = "Accessibilità"
  logo: string = IMAGESURL + "logo-csi-footer.png";
  servizi: string = IMAGESURL + "logo-servizi.png";
  regione: string = IMAGESURL + "logo-regione.png";

  constructor() { }

  ngOnInit(): void {
  }

  navigate(url: string) {
    window.location.href = url;
  }
}
