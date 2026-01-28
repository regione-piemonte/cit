import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ElencoDatiInviatiComponent } from './elenco-dati-inviati.component';

describe('ElencoDatiInviatiComponent', () => {
  let component: ElencoDatiInviatiComponent;
  let fixture: ComponentFixture<ElencoDatiInviatiComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ElencoDatiInviatiComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ElencoDatiInviatiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
