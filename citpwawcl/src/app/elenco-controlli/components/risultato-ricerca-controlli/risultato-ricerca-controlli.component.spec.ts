import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RisultatoRicercaControlliComponent } from './risultato-ricerca-controlli.component';

describe('RisultatoRicercaControlliComponent', () => {
  let component: RisultatoRicercaControlliComponent;
  let fixture: ComponentFixture<RisultatoRicercaControlliComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RisultatoRicercaControlliComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RisultatoRicercaControlliComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
