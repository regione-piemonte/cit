import { TestBed } from '@angular/core/testing';

import { DocumentiImpiantoService } from './documenti-impianto.service';

describe('DocumentiImpiantoService', () => {
  let service: DocumentiImpiantoService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DocumentiImpiantoService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
