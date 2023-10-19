import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DettaglioTipo1BComponent } from './dettaglio-tipo1-b.component';

describe('DettaglioTipo1BComponent', () => {
  let component: DettaglioTipo1BComponent;
  let fixture: ComponentFixture<DettaglioTipo1BComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DettaglioTipo1BComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DettaglioTipo1BComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
