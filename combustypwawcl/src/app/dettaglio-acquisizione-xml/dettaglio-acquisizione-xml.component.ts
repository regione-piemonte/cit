import { Component, Inject, OnInit, AfterViewInit, ViewChild, HostListener } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { ImportDatiDistributore } from '../models/importazione-dati-distributore';
import { LogDatiFornitura } from '../models/log-dati-fornitura';
import { MatTableDataSource } from '@angular/material/table';
import { MatSort } from '@angular/material/sort';

@Component({
  selector: 'app-dettaglio-acquisizione-xml',
  templateUrl: './dettaglio-acquisizione-xml.component.html',
  styleUrls: ['./dettaglio-acquisizione-xml.component.scss']
})
export class DettaglioAcquisizioneXmlComponent implements OnInit, AfterViewInit {

  constructor(
    private dialogRef: MatDialogRef<DettaglioAcquisizioneXmlComponent>,
    @Inject(MAT_DIALOG_DATA) public importDatiDistributore: ImportDatiDistributore
  ) {}

  isMobile: boolean;
  displayedColumns: string[] = ['id_errore', 'msg_errore'];
  dataSource: MatTableDataSource<LogDatiFornitura>;
  @ViewChild(MatSort) sort: MatSort;

  ngOnInit(): void {
    this.isMobile = (window.innerWidth < 900);

    const errori: LogDatiFornitura[] = this.importDatiDistributore.datiFornitura
      .flatMap(f => f.logDatiFornitura)
      .filter(e => e && e.id_log_distrib !== null)
      .sort((a, b) => (a.id_log_distrib ?? 0) - (b.id_log_distrib ?? 0));

    this.dataSource = new MatTableDataSource(errori);

    this.dataSource.sortingDataAccessor = (item, property) => {
      switch (property) {
        case 'id_errore':
          return item.id_log_distrib ?? 0;
        case 'msg_errore':
          return item.msg_errore?.toLowerCase() ?? '';
        default:
          return '';
      }
    };
  }

  @HostListener('window:resize', ['$event'])
  onResize(event?) {
    this.isMobile = (event.target.innerWidth < 900);
  }

  ngAfterViewInit(): void {
    this.dataSource.sort = this.sort;
    this.sort.active = 'id_errore';
    this.sort.direction = 'asc';
    this.sort.sortChange.emit({ active: this.sort.active, direction: this.sort.direction });
  }

  close(): void {
    this.dialogRef.close();
  }
}
