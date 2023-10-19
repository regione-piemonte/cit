import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { fromEvent, merge, of, Subscription } from 'rxjs';
import { map } from 'rxjs/operators';
import { UtenteLoggato } from './models/utente-loggato';
import { AuthenticationService } from './services/authentication.service';
import { SyncServiceService } from './services/sync-service.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'CITPWAWCL';

  networkStatus: boolean = false;
  networkStatus$: Subscription = Subscription.EMPTY;

  constructor(private readonly authService: AuthenticationService, private readonly syncService: SyncServiceService, private router: Router) {

  }

  keepAliveintervalId;

  ngOnInit(): void {
    let user = this.authService.getCurrentUserFromSession();
    this.checkNetworkStatus();
    if (!user) {
      this.authService.getCurrentUser().subscribe(user => {
        sessionStorage.setItem('currentUser', JSON.stringify(user));
        this.syncService.sync();
        this.router.navigate(["/ruoli"]);
      });
    }

    this.keepAliveintervalId = setInterval(() => {
      this.keepAlive();
    }, 300000);
  }

  ngOnDestroy(): void {
    this.networkStatus$.unsubscribe();
  }


  keepAlive(): void {
    this.authService.keepAlive().subscribe({
      next: (response: UtenteLoggato) => {
      }
    });

  }

  checkNetworkStatus() {
    this.networkStatus = navigator.onLine;
    this.networkStatus$ = merge(
      of(null),
      fromEvent(window, 'online'),
      fromEvent(window, 'offline')
    )
      .pipe(map(() => navigator.onLine))
      .subscribe(status => {
        if (status) {
          this.authService.keepAlive().subscribe(elem => {
            this.syncService.setOnlineSubject(true);
            this.syncService.sync();
          }, error => {
            this.syncService.setOnlineSubject(false);
          });
        } else {
          this.syncService.setOnlineSubject(false);
        }
        this.networkStatus = status;
      });
  }
}
