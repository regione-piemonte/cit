import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GeneraTokenComponent } from './genera-token.component';

describe('GeneraTokenComponent', () => {
  let component: GeneraTokenComponent;
  let fixture: ComponentFixture<GeneraTokenComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GeneraTokenComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GeneraTokenComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
