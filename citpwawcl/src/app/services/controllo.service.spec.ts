import { TestBed } from '@angular/core/testing';

import { ControlloService } from './controllo.service';

describe('ControlloService', () => {
  let service: ControlloService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ControlloService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
