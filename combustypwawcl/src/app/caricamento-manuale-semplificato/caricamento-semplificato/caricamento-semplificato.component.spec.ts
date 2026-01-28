import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CaricamentoSemplificatoComponent } from './caricamento-semplificato.component';

describe('CaricamentoSemplificatoComponent', () => {
  let component: CaricamentoSemplificatoComponent;
  let fixture: ComponentFixture<CaricamentoSemplificatoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CaricamentoSemplificatoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CaricamentoSemplificatoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
