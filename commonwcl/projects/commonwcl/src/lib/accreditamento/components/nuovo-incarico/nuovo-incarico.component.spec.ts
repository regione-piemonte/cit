import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NuovoIncaricoComponent } from './nuovo-incarico.component';

describe('NuovoIncaricoComponent', () => {
  let component: NuovoIncaricoComponent;
  let fixture: ComponentFixture<NuovoIncaricoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NuovoIncaricoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NuovoIncaricoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
