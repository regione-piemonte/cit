import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RapprovaUploadFirmatoDialogComponent } from './rapprova-upload-firmato-dialog.component';

describe('RapprovaUploadFirmatoDialogComponent', () => {
  let component: RapprovaUploadFirmatoDialogComponent;
  let fixture: ComponentFixture<RapprovaUploadFirmatoDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RapprovaUploadFirmatoDialogComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RapprovaUploadFirmatoDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
