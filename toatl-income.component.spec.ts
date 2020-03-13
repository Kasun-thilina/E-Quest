import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ToatlIncomeComponent } from './toatl-income.component';

describe('ToatlIncomeComponent', () => {
  let component: ToatlIncomeComponent;
  let fixture: ComponentFixture<ToatlIncomeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ToatlIncomeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ToatlIncomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
