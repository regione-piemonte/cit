import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-back',
  templateUrl: './back.component.html',
  styleUrls: ['./back.component.scss']
})
export class BackComponent implements OnInit {

  @Input()
  title:string;
  @Input()
  route:string;

  constructor(private router:Router) { }

  ngOnInit(): void {
  }

  back(){
    this.router.navigate([this.route]);
  }

}
