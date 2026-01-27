import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-error',
  templateUrl: './error.component.html',
})
export class ErrorComponent implements OnInit {
  message = 'Errore generico';
  dump: string;

  ngOnInit() {
    const state = history.state;

    if (state) {
      this.message = state['message'];
      this.dump = state['dump'];
    }
  }
}
