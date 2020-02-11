import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FaleconoscoComponent } from './faleconosco.component';

describe('FaleconoscoComponent', () => {
  let component: FaleconoscoComponent;
  let fixture: ComponentFixture<FaleconoscoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FaleconoscoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FaleconoscoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
