import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NuovoImpiantoComponent } from './nuovo-impianto.component';

describe('NuovoImpiantoComponent', () => {
  let component: NuovoImpiantoComponent;
  let fixture: ComponentFixture<NuovoImpiantoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NuovoImpiantoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NuovoImpiantoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
