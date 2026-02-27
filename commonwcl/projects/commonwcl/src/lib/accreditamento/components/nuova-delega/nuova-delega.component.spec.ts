import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NuovaDelegaComponent } from './nuova-delega.component';

describe('NuovaDelegaComponent', () => {
  let component: NuovaDelegaComponent;
  let fixture: ComponentFixture<NuovaDelegaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NuovaDelegaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NuovaDelegaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
