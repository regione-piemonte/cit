import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AggiungiComponenteDialogComponent } from './aggiungi-componente-dialog.component';

describe('AggiungiComponenteDialogComponent', () => {
  let component: AggiungiComponenteDialogComponent;
  let fixture: ComponentFixture<AggiungiComponenteDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AggiungiComponenteDialogComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AggiungiComponenteDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
