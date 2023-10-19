import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NuovoResponsabileProprietarioComponent } from './nuovo-responsabile-proprietario.component';

describe('NuovoResponsabileProprietarioComponent', () => {
  let component: NuovoResponsabileProprietarioComponent;
  let fixture: ComponentFixture<NuovoResponsabileProprietarioComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NuovoResponsabileProprietarioComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NuovoResponsabileProprietarioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
