import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AggiungiManutenzioneComponent } from './aggiungi-manutenzione.component';

describe('AggiungiManutenzioneComponent', () => {
  let component: AggiungiManutenzioneComponent;
  let fixture: ComponentFixture<AggiungiManutenzioneComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AggiungiManutenzioneComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AggiungiManutenzioneComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
