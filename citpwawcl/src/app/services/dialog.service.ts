import { Injectable } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Observable } from 'rxjs';
import { AlertDialogComponent } from '../common/components/alert-dialog/alert-dialog.component';
import { ConfirmDialogComponent } from '../common/components/confirm-dialog/confirm-dialog.component';

const DEFAULT_WIDTH = '300px';

@Injectable({
  providedIn: 'root',
})
export class DialogService {
  constructor(private dialog: MatDialog) {}

  confirm(title: string, message: string): Observable<boolean> {
    return this.dialog
      .open(ConfirmDialogComponent, {
        width: DEFAULT_WIDTH,
        data: {
          title,
          message,
        },
      })
      .afterClosed();
  }

  alert(title: string, message: string) {
    return this.dialog.open(AlertDialogComponent, {
      width: DEFAULT_WIDTH,
      data: {
        title,
        message,
      },
    });
  }
}
