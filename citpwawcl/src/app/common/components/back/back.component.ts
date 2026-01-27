import { Location } from '@angular/common';
import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-back',
  templateUrl: './back.component.html',
  styleUrls: ['./back.component.scss']
})
export class BackComponent implements OnInit {

  @Input()
  title: string;
  @Input()
  route: string;
  @Input()
  queryParams: any;

  @Output()
  click: EventEmitter<any> = new EventEmitter();

  lastEmit = 0;

  constructor(
    private router: Router,
    private location: Location
  ) { }

  ngOnInit(): void {
    //Not Implemented
  }

  back($event) {
    if ((Date.now() - this.lastEmit) > 500) {
      if (this.click.observers.length === 0) {
        if (this.route) {
          if (this.queryParams) {
            this.router.navigate([this.route]);
          } else {
            this.router.navigate([this.route], { queryParams: this.queryParams });
          }
        } else {
          this.location.back();
        }
      } else {
        $event.preventDefault();
        this.click.emit("click");
      }
      this.lastEmit = Date.now();
    }
  }

}
