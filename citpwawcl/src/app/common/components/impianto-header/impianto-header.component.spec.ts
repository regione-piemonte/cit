import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ImpiantoHeaderComponent } from './impianto-header.component';

describe('ImpiantoHeaderComponent', () => {
  let component: ImpiantoHeaderComponent;
  let fixture: ComponentFixture<ImpiantoHeaderComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ImpiantoHeaderComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ImpiantoHeaderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
