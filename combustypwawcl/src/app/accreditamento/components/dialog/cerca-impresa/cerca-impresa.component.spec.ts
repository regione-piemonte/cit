import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CercaImpresaComponent } from './cerca-impresa.component';

describe('CercaImpresaComponent', () => {
  let component: CercaImpresaComponent;
  let fixture: ComponentFixture<CercaImpresaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CercaImpresaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CercaImpresaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
