import { TestBed } from '@angular/core/testing';

import { RicercaImpiantoGuard } from './ricerca-impianto.guard';

describe('RicercaImpiantoGuard', () => {
  let guard: RicercaImpiantoGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(RicercaImpiantoGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
