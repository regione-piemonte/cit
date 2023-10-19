import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DettaglioTipo4Component } from './dettaglio-tipo4.component';

describe('DettaglioTipo4Component', () => {
  let component: DettaglioTipo4Component;
  let fixture: ComponentFixture<DettaglioTipo4Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DettaglioTipo4Component ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DettaglioTipo4Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
