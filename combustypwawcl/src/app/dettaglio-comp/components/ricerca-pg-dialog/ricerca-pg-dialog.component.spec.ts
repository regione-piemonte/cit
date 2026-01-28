import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RicercaPgDialogComponent } from './ricerca-pg-dialog.component';

describe('RicercaPgDialogComponent', () => {
  let component: RicercaPgDialogComponent;
  let fixture: ComponentFixture<RicercaPgDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RicercaPgDialogComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RicercaPgDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
