import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RicercaPgResultComponent } from './ricerca-pg-result.component';

describe('RicercaPgResultComponent', () => {
  let component: RicercaPgResultComponent;
  let fixture: ComponentFixture<RicercaPgResultComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RicercaPgResultComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RicercaPgResultComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
