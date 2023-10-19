import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DettaglioGfComponent } from './dettaglio-gf.component';

describe('DettaglioGfComponent', () => {
  let component: DettaglioGfComponent;
  let fixture: ComponentFixture<DettaglioGfComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DettaglioGfComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DettaglioGfComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
