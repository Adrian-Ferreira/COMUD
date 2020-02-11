import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditaUsuarioComponent } from './edita-usuario.component';

describe('EditaUsuarioComponent', () => {
  let component: EditaUsuarioComponent;
  let fixture: ComponentFixture<EditaUsuarioComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditaUsuarioComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditaUsuarioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
