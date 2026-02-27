import { TestBed } from '@angular/core/testing';

import { AccreditamentoService } from './accreditamento.service';

describe('AccreditamentoService', () => {
  let service: AccreditamentoService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AccreditamentoService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
