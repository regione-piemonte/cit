import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AggiungiDocumentiComponent } from './aggiungi-documenti.component';

describe('AggiungiDocumentiComponent', () => {
  let component: AggiungiDocumentiComponent;
  let fixture: ComponentFixture<AggiungiDocumentiComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AggiungiDocumentiComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AggiungiDocumentiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
