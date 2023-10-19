import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RicercaImpiantiComponent } from './ricerca-impianti.component';

describe('RicercaImpiantiComponent', () => {
  let component: RicercaImpiantiComponent;
  let fixture: ComponentFixture<RicercaImpiantiComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RicercaImpiantiComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RicercaImpiantiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
