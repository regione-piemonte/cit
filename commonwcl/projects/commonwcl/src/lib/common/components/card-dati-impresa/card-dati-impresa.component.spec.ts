import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CardDatiImpresaComponent } from './card-dati-impresa.component';

describe('CardDatiImpresaComponent', () => {
  let component: CardDatiImpresaComponent;
  let fixture: ComponentFixture<CardDatiImpresaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CardDatiImpresaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CardDatiImpresaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
