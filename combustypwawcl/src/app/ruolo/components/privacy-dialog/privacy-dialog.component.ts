import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from 'src/app/services/authentication.service';

@Component({
  selector: 'app-privacy-dialog',
  templateUrl: './privacy-dialog.component.html',
  styleUrls: ['./privacy-dialog.component.scss']
})
export class PrivacyDialogComponent implements OnInit {

  constructor(private readonly authService: AuthenticationService) { }

  ngOnInit(): void {
    //Not Implemented
  }

  rifiuta() {
      this.authService.ssoLogout();
  }
}