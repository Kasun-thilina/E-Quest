import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ManageGuestComponent } from './manage-guest.component';

//manage guest component

describe('ManageGuestComponent', () => {
  let component: ManageGuestComponent;
  let fixture: ComponentFixture<ManageGuestComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ManageGuestComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ManageGuestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
