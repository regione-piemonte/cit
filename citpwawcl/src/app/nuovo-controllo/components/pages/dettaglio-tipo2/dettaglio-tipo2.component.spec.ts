import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DettaglioTipo2Component } from './dettaglio-tipo2.component';

describe('DettaglioTipo2Component', () => {
  let component: DettaglioTipo2Component;
  let fixture: ComponentFixture<DettaglioTipo2Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DettaglioTipo2Component ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DettaglioTipo2Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
