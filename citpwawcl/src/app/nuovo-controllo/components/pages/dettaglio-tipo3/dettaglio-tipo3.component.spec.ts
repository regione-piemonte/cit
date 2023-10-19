import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DettaglioTipo3Component } from './dettaglio-tipo3.component';

describe('DettaglioTipo3Component', () => {
  let component: DettaglioTipo3Component;
  let fixture: ComponentFixture<DettaglioTipo3Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DettaglioTipo3Component ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DettaglioTipo3Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
