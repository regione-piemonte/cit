import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { UtenteLoggato } from '../models/utente-loggato';
import { AuthenticationService } from '../services/authentication.service';

@Injectable({
  providedIn: 'root'
})
export class DettaglioImpiantoGuard implements CanActivate {
  constructor(authService: AuthenticationService) {
    let item = sessionStorage.getItem('currentUser');
    if (item == null) {
      authService.getCurrentUser().subscribe((elem: UtenteLoggato) => {
        sessionStorage.setItem('currentUser', JSON.stringify(elem));
      });
    }
  }
  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    return true;
  }

}
