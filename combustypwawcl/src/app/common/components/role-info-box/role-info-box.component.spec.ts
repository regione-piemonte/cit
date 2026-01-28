import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RoleInfoBoxComponent } from './role-info-box.component';

describe('RoleInfoBoxComponent', () => {
  let component: RoleInfoBoxComponent;
  let fixture: ComponentFixture<RoleInfoBoxComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RoleInfoBoxComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RoleInfoBoxComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
