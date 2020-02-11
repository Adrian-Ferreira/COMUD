import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CadOngComponent } from './cad-ong.component';

describe('CadOngComponent', () => {
  let component: CadOngComponent;
  let fixture: ComponentFixture<CadOngComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CadOngComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CadOngComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
