import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DettaglioGtComponent } from './dettaglio-gt.component';

describe('DettaglioGtComponent', () => {
  let component: DettaglioGtComponent;
  let fixture: ComponentFixture<DettaglioGtComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DettaglioGtComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DettaglioGtComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
