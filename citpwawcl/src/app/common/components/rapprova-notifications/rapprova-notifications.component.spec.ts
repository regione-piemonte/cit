import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RapprovaNotificationsComponent } from './rapprova-notifications.component';

describe('RapprovaNotificationsComponent', () => {
  let component: RapprovaNotificationsComponent;
  let fixture: ComponentFixture<RapprovaNotificationsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RapprovaNotificationsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RapprovaNotificationsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
