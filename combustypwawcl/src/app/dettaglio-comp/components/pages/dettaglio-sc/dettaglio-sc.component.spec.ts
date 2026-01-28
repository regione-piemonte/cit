import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DettaglioScComponent } from './dettaglio-sc.component';

describe('DettaglioScComponent', () => {
  let component: DettaglioScComponent;
  let fixture: ComponentFixture<DettaglioScComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DettaglioScComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DettaglioScComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
