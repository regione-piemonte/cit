import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ImpiantoComponent } from './impianto.component';

describe('ImpiantoComponent', () => {
  let component: ImpiantoComponent;
  let fixture: ComponentFixture<ImpiantoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ImpiantoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ImpiantoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
