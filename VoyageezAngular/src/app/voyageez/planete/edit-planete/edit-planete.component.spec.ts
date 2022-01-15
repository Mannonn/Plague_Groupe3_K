import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditPlaneteComponent } from './edit-planete.component';

describe('EditPlaneteComponent', () => {
  let component: EditPlaneteComponent;
  let fixture: ComponentFixture<EditPlaneteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditPlaneteComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EditPlaneteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
