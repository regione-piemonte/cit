import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RisultatoRicercaImpiantiComponent } from './risultato-ricerca-impianti.component';

describe('RisultatoRicercaImpiantiComponent', () => {
  let component: RisultatoRicercaImpiantiComponent;
  let fixture: ComponentFixture<RisultatoRicercaImpiantiComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RisultatoRicercaImpiantiComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RisultatoRicercaImpiantiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
