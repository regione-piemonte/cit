import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ElencoFornitureComponent } from './elenco-forniture.component';

describe('ElencoFornitureComponent', () => {
  let component: ElencoFornitureComponent;
  let fixture: ComponentFixture<ElencoFornitureComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ElencoFornitureComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ElencoFornitureComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
