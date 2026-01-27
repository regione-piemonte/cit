import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DisponibilitaServizioComponent } from './disponibilita-servizio.component';

describe('DisponibilitaServizioComponent', () => {
  let component: DisponibilitaServizioComponent;
  let fixture: ComponentFixture<DisponibilitaServizioComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DisponibilitaServizioComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DisponibilitaServizioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
