import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FormFaqComponent } from './form-faq.component';

describe('FormFaqComponent', () => {
  let component: FormFaqComponent;
  let fixture: ComponentFixture<FormFaqComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FormFaqComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FormFaqComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
