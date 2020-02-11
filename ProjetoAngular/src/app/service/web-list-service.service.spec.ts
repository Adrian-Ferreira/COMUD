import { TestBed } from '@angular/core/testing';

import { WebListServiceService } from './web-list-service.service';

describe('WebListServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: WebListServiceService = TestBed.get(WebListServiceService);
    expect(service).toBeTruthy();
  });
});
