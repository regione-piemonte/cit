import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DettaglioTokenComponent } from './dettaglio-token.component';

describe('DettaglioTokenComponent', () => {
  let component: DettaglioTokenComponent;
  let fixture: ComponentFixture<DettaglioTokenComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DettaglioTokenComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DettaglioTokenComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
