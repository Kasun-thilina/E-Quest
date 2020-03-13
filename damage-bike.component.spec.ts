import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DamageBikeComponent } from './damage-bike.component';

describe('DamageBikeComponent', () => {
  let component: DamageBikeComponent;
  let fixture: ComponentFixture<DamageBikeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DamageBikeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DamageBikeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
