import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AnnullaAcquisizioneComponent } from './annulla-acquisizione.component';

describe('AnnullaAcquisizioneComponent', () => {
  let component: AnnullaAcquisizioneComponent;
  let fixture: ComponentFixture<AnnullaAcquisizioneComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AnnullaAcquisizioneComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AnnullaAcquisizioneComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
