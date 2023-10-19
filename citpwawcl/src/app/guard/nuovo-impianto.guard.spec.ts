import { TestBed } from '@angular/core/testing';

import { NuovoImpiantoGuard } from './nuovo-impianto.guard';

describe('NuovoImpiantoGuard', () => {
  let guard: NuovoImpiantoGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(NuovoImpiantoGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
