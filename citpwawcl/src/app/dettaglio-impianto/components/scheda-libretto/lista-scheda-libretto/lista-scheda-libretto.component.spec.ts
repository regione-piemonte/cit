import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListaSchedaLibrettoComponent } from './lista-scheda-libretto.component';

describe('ListaSchedaLibrettoComponent', () => {
  let component: ListaSchedaLibrettoComponent;
  let fixture: ComponentFixture<ListaSchedaLibrettoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ListaSchedaLibrettoComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListaSchedaLibrettoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
