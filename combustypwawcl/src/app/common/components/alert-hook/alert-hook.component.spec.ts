import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AlertHookComponent } from './alert-hook.component';

describe('AlertHookComponent', () => {
  let component: AlertHookComponent;
  let fixture: ComponentFixture<AlertHookComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AlertHookComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AlertHookComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
