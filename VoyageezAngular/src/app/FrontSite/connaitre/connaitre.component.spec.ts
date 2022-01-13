import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ConnaitreComponent } from './connaitre.component';

describe('ConnaitreComponent', () => {
  let component: ConnaitreComponent;
  let fixture: ComponentFixture<ConnaitreComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ConnaitreComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ConnaitreComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
