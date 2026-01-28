import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CercaDatiFornituraComponent } from './cerca-dati-fornitura.component';

describe('CercaDatiFornituraComponent', () => {
  let component: CercaDatiFornituraComponent;
  let fixture: ComponentFixture<CercaDatiFornituraComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CercaDatiFornituraComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CercaDatiFornituraComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
