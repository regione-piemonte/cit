import { Component, OnInit } from '@angular/core';
import { ICONSURL, STRINGHE } from 'src/app/utils/constants';

@Component({
  selector: 'app-preview',
  templateUrl: './preview.component.html',
  styleUrls: ['./preview.component.scss']
})
export class PreviewComponent implements OnInit {

  csiLogo: string = ICONSURL + "previewIcon.png";
  backgroundClass: string = "preview1";
  colorClass: string = "preview1-color";
  pwaIcon: string = ICONSURL + "add-to-home.svg";
  descrizionePagina: string = STRINGHE.PAGINA_INIZIALE.PREVIEW1;
  selectedTab: number = 1;

  constructor() {
    //Not Implemented
  }

  ngOnInit(): void {
    //Not Implemented
  }

  prosegui() {
    if (this.selectedTab < 3) {
      this.selectedTab = this.selectedTab + 1;
    }

    switch (this.selectedTab) {
      case 1:
        this.backgroundClass = "preview1";
        this.colorClass = "preview1-color";
        break;
      case 2:
        this.backgroundClass = "preview2";
        this.colorClass = "preview2-color";
        break;
      case 3:
        this.backgroundClass = "preview3";
        this.colorClass = "preview3-color";
        break;
    }
  }

  public installPwa(): void {
    //Not Implemented
  }

  public salta(): void {
    //Not Implemented
  }
}
