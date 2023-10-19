import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ElencoControlliComponent } from './elenco-controlli.component';

describe('ElencoControlliComponent', () => {
  let component: ElencoControlliComponent;
  let fixture: ComponentFixture<ElencoControlliComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ElencoControlliComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ElencoControlliComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
