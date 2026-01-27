import { Component, HostListener } from '@angular/core';
import { AlertService } from 'src/app/services/alert.service';

@Component({
  selector: 'app-alert-hook',
  templateUrl: './alert-hook.component.html',
})
export class AlertHookComponent {
  showOfflineAlert: boolean;

  constructor(public alert: AlertService) {
    this.onOnlineOrOffline();
  }

  @HostListener('window:online')
  @HostListener('window:offline')
  onOnlineOrOffline(): void {
    this.showOfflineAlert = !navigator.onLine;
  }
}
