import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RapprovaAddStep2Component } from './rapprova-add-step2.component';

describe('RapprovaAddStep2Component', () => {
  let component: RapprovaAddStep2Component;
  let fixture: ComponentFixture<RapprovaAddStep2Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RapprovaAddStep2Component ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RapprovaAddStep2Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
