import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RicercaImpresaComponent } from './ricerca-impresa.component';

describe('RicercaImpresaComponent', () => {
  let component: RicercaImpresaComponent;
  let fixture: ComponentFixture<RicercaImpresaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RicercaImpresaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RicercaImpresaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
