import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NuovoIncaricoDelegaComponent } from './nuovo-incarico-delega.component';

describe('NuovoIncaricoDelegaComponent', () => {
  let component: NuovoIncaricoDelegaComponent;
  let fixture: ComponentFixture<NuovoIncaricoDelegaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NuovoIncaricoDelegaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NuovoIncaricoDelegaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
