import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DocumentiImpiantoComponent } from './documenti-impianto.component';

describe('DocumentiImpiantoComponent', () => {
  let component: DocumentiImpiantoComponent;
  let fixture: ComponentFixture<DocumentiImpiantoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DocumentiImpiantoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DocumentiImpiantoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
