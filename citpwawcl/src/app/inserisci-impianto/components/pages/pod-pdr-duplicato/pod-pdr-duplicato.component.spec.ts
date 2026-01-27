import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PodPdrDuplicatoComponent } from './pod-pdr-duplicato.component';

describe('PodPdrDuplicatoComponent', () => {
  let component: PodPdrDuplicatoComponent;
  let fixture: ComponentFixture<PodPdrDuplicatoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PodPdrDuplicatoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PodPdrDuplicatoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
