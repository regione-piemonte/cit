import { TestBed } from '@angular/core/testing';

import { DatiDistributoreService } from './dati-distributore.service';

describe('DatiDistributoreService', () => {
  let service: DatiDistributoreService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DatiDistributoreService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
