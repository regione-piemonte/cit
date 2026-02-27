import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DatiImpresa } from '../../../models/dati-impresa';
import { ICONSURL } from '../../../utils/constants';

@Component({
  selector: 'commonwcl-card-dati-impresa',
  templateUrl: './card-dati-impresa.component.html',
  styleUrls: ['./card-dati-impresa.component.scss']
})
export class CardDatiImpresaComponent implements OnInit {

  pgRed: string = ICONSURL + "impresa_red.svg";
  @Input() impresa: DatiImpresa = {};

  constructor(private router: Router) {

  }

  ngOnInit(): void {
    // if (this.impresa == null) {
    //   this.impresa = {};
    // }
    // this.router.navigate(['/']);
    console.log("CardDati " + this.impresa)
  }

}
