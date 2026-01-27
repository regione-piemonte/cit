import { Component, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';

@Component({
  selector: 'app-alert-dialog',
  templateUrl: './alert-dialog.component.html',
  styleUrls: ['./alert-dialog.component.scss']
})
export class AlertDialogComponent {

  title: string;
  text: string;


  constructor(
    public dialogRef: MatDialogRef<AlertDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data,
  ) {
    console.log("DATA:", data);

    const { title, text } = data;
    this.title = title;
    this.text = text;
  }

  closeDialog() {
    this.dialogRef.close();
  }


}
