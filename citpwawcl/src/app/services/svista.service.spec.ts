import { TestBed } from '@angular/core/testing';

import { SvistaService } from './svista.service';

describe('SvistaService', () => {
  let service: SvistaService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SvistaService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
