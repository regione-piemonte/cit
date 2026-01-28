import { Component, OnInit } from '@angular/core';
import { ICONSURL } from 'src/app/utils/constants';

@Component({
  selector: 'app-footer2',
  templateUrl: './footer2.component.html',
  styleUrls: ['./footer2.component.scss']
})
export class Footer2Component implements OnInit {

  regione_piemonte: string = ICONSURL + "regione_piemonte.svg";
  servizi_online: string = ICONSURL + "servizi_online.svg";
  csi_digital_partner: string = ICONSURL + "csi_digital_partner.svg";

  constructor() { }

  ngOnInit(): void {
  }

}
