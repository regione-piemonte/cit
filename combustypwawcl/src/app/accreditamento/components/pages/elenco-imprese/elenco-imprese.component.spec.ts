import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ElencoImpreseComponent } from './elenco-imprese.component';

describe('ElencoImpreseComponent', () => {
  let component: ElencoImpreseComponent;
  let fixture: ComponentFixture<ElencoImpreseComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ElencoImpreseComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ElencoImpreseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
