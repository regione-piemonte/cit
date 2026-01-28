import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RisultatoRicercaImpresaComponent } from './risultato-ricerca-impresa.component';

describe('RisultatoRicercaImpresaComponent', () => {
  let component: RisultatoRicercaImpresaComponent;
  let fixture: ComponentFixture<RisultatoRicercaImpresaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RisultatoRicercaImpresaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RisultatoRicercaImpresaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
