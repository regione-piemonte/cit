import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DettaglioSchedaLibrettoComponent } from './dettaglio-scheda-libretto.component';

describe('DettaglioSchedaLibrettoComponent', () => {
  let component: DettaglioSchedaLibrettoComponent;
  let fixture: ComponentFixture<DettaglioSchedaLibrettoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DettaglioSchedaLibrettoComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DettaglioSchedaLibrettoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
