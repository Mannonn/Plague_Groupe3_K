import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BarreNavComponent } from './barre-nav.component';

describe('BarreNavComponent', () => {
  let component: BarreNavComponent;
  let fixture: ComponentFixture<BarreNavComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BarreNavComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BarreNavComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
