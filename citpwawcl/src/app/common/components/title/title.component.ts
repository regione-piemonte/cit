import { Component, Input, OnInit } from '@angular/core';
import { ICONSURL } from 'src/app/utils/constants';

@Component({
  selector: 'app-title',
  templateUrl: './title.component.html',
  styleUrls: ['./title.component.scss']
})
export class TitleComponent implements OnInit {

  @Input()
  title: string="";
  @Input()
  subtitle: string="";
  @Input()
  class: string="";

  titlePng:string=ICONSURL+"titolo.png";

  constructor() {
    //Not Implemented
   }

  ngOnInit(): void {
    //Not Implemented
  }

}
