import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { BackService } from 'src/app/services/back.service';
import { MessageService } from 'src/app/services/message.service';
import { SpinnerService } from 'src/app/services/spinner.service';
import { TitleService } from 'src/app/services/title.service';

@Component({
  selector: 'app-impianto',
  templateUrl: './impianto.component.html',
  styleUrls: ['./impianto.component.scss']
})
export class ImpiantoComponent implements OnInit {

  title: string = "";
  subtitle: string = "";
  backTitile: string = "";
  route: string = "";
  titoloMessaggio: string = "";
  descrzioneMessaggio: string = "";
  tipomessaggio: number = 0;
  showMessaggio: boolean = false;

  constructor(readonly titoloService: TitleService, readonly backService: BackService, readonly messageService: MessageService, readonly spinnerService: SpinnerService, private cdref: ChangeDetectorRef) { }

  ngOnInit(): void {
  }

  ngAfterContentChecked() {
    this.title = this.titoloService.getTitle();
    this.subtitle = this.titoloService.getsubtitle();
    this.backTitile = this.backService.getBack();
    this.route = this.backService.getRoute();
    this.titoloMessaggio = this.messageService.getTitolo();
    this.descrzioneMessaggio = this.messageService.getDescrizione();
    this.tipomessaggio = this.messageService.getType();
    this.showMessaggio = this.messageService.getShowMessaggio();
    this.cdref.detectChanges();
  }
}
