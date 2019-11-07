import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateBorrowComponent } from './create-borrow.component';

describe('CreateBorrowComponent', () => {
  let component: CreateBorrowComponent;
  let fixture: ComponentFixture<CreateBorrowComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateBorrowComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateBorrowComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
