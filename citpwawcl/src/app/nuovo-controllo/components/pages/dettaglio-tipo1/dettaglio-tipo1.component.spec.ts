import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DettaglioTipo1Component } from './dettaglio-tipo1.component';

describe('DettaglioTipo1Component', () => {
  let component: DettaglioTipo1Component;
  let fixture: ComponentFixture<DettaglioTipo1Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DettaglioTipo1Component ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DettaglioTipo1Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
