import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RapprovaAddStep3UploadComponent } from './rapprova-add-step3-upload.component';

describe('RapprovaAddStep3UploadComponent', () => {
  let component: RapprovaAddStep3UploadComponent;
  let fixture: ComponentFixture<RapprovaAddStep3UploadComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RapprovaAddStep3UploadComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RapprovaAddStep3UploadComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
