import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { NgxPermissionsService } from 'ngx-permissions';
import { fromEvent, merge, of, Subscription } from 'rxjs';
import { map } from 'rxjs/operators';
import { UtenteLoggato } from './models/utente-loggato';
import { PERMS } from './perms';
import { RapprovaWorkerService } from './rapprova/services/rapprova-worker.service';
import { AuthenticationService } from './services/authentication.service';
import { SharedService } from './services/shared.service';
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

  constructor(
    private readonly authService: AuthenticationService,
    private readonly syncService: SyncServiceService,
    private router: Router,
    private sharedService: SharedService,
    private permissions: NgxPermissionsService,
    private rapprovaWorkerService: RapprovaWorkerService
  ) {}

  keepAliveintervalId;

  ngOnInit(): void {
    const datiPrecompilati = localStorage.getItem('datiPrecompilati');
    if(!!datiPrecompilati) {
      this.sharedService.datiPrecompilati = datiPrecompilati;
    }
    let user = this.authService.getCurrentUserFromSession();
    this.checkNetworkStatus();
    if (!user) {
      this.authService.getCurrentUser().subscribe(userLogged => {
        sessionStorage.setItem('currentUser', JSON.stringify(userLogged));
        this.permissions.loadPermissions(PERMS[userLogged.ruoloLoggato.ruolo] ?? []);
        this.syncService.sync();
        this.router.navigate(["/ruoli"]);
      });
    } else {
      this.permissions.loadPermissions(PERMS[user.ruoloLoggato.ruolo] ?? []);
    }

    this.keepAliveintervalId = setInterval(() => {
      this.keepAlive();
    }, 300000);

    this.rapprovaWorkerService.init();
  }

  ngOnDestroy(): void {
    this.networkStatus$.unsubscribe();
  }


  keepAlive(): void {
    this.authService.keepAlive().subscribe({
      next: (response: UtenteLoggato) => {
        //This is Intentional
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
