import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DettaglioAcquisizioneXmlComponent } from './dettaglio-acquisizione-xml.component';

describe('DettaglioAcquisizioneXmlComponent', () => {
  let component: DettaglioAcquisizioneXmlComponent;
  let fixture: ComponentFixture<DettaglioAcquisizioneXmlComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DettaglioAcquisizioneXmlComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DettaglioAcquisizioneXmlComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
