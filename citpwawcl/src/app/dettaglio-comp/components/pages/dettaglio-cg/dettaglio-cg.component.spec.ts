import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DettaglioCgComponent } from './dettaglio-cg.component';

describe('DettaglioCgComponent', () => {
  let component: DettaglioCgComponent;
  let fixture: ComponentFixture<DettaglioCgComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DettaglioCgComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DettaglioCgComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
