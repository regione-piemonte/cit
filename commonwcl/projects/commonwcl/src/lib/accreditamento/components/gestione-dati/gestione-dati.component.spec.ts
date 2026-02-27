import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GestioneDatiComponent } from './gestione-dati.component';

describe('GestioneDatiComponent', () => {
  let component: GestioneDatiComponent;
  let fixture: ComponentFixture<GestioneDatiComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GestioneDatiComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(GestioneDatiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
