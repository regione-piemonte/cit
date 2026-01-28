import { Injectable } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';

@Injectable({
  providedIn: 'root',
})
export class Message2Service {
  constructor(private snackBar: MatSnackBar) {}

  error(message: string) {
    this.snackBar.open(message, 'Chiudi', {
      panelClass: 'cit-warn-snackbar',
    });
  }
}
