import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ModalCadComponent } from './modal-cad.component';

describe('ModalCadComponent', () => {
  let component: ModalCadComponent;
  let fixture: ComponentFixture<ModalCadComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ModalCadComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ModalCadComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
