import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditaOngComponent } from './edita-ong.component';

describe('EditaOngComponent', () => {
  let component: EditaOngComponent;
  let fixture: ComponentFixture<EditaOngComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditaOngComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditaOngComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
