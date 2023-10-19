import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RicercaIndirizzoDialogComponent } from './ricerca-indirizzo-dialog.component';

describe('RicercaIndirizzoDialogComponent', () => {
  let component: RicercaIndirizzoDialogComponent;
  let fixture: ComponentFixture<RicercaIndirizzoDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RicercaIndirizzoDialogComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RicercaIndirizzoDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
