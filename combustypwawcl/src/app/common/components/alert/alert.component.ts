import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-alert',
  templateUrl: './alert.component.html',
  styleUrls: ['./alert.component.scss'],
})
export class AlertComponent {
  @Input() title?: string;
  @Input() message: string;
  @Input() type: 'success' | 'warn' | 'error' | 'info';

  getIcon(): string {
    switch (this.type) {
      case 'success':
        return 'check_circle';
      case 'warn':
        return 'info';
      case 'error':
        return 'error';
      case 'info':
        return 'info';
    }
  }
}
