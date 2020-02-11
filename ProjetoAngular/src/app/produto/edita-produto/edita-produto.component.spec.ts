import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditaProdutoComponent } from './edita-produto.component';

describe('EditaProdutoComponent', () => {
  let component: EditaProdutoComponent;
  let fixture: ComponentFixture<EditaProdutoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditaProdutoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditaProdutoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
