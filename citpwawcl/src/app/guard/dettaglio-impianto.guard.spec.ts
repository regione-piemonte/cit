import { TestBed } from '@angular/core/testing';

import { DettaglioImpiantoGuard } from './dettaglio-impianto.guard';

describe('DettaglioImpiantoGuard', () => {
  let guard: DettaglioImpiantoGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(DettaglioImpiantoGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
