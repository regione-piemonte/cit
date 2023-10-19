import { TestBed } from '@angular/core/testing';

import { LibrettoService } from './libretto.service';

describe('LibrettoService', () => {
  let service: LibrettoService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(LibrettoService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
