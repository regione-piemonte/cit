import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ImportazioneXmlComponent } from './importazione-xml.component';

describe('ImportazioneXmlComponent', () => {
  let component: ImportazioneXmlComponent;
  let fixture: ComponentFixture<ImportazioneXmlComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ImportazioneXmlComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ImportazioneXmlComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
