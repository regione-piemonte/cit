import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CercaControlliComponent } from './cerca-controlli.component';

describe('CercaControlliComponent', () => {
  let component: CercaControlliComponent;
  let fixture: ComponentFixture<CercaControlliComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CercaControlliComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CercaControlliComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
