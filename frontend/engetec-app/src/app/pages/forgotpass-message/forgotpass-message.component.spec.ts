import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ForgotpassMessageComponent } from './forgotpass-message.component';

describe('ForgotpassMessageComponent', () => {
  let component: ForgotpassMessageComponent;
  let fixture: ComponentFixture<ForgotpassMessageComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ForgotpassMessageComponent]
    });
    fixture = TestBed.createComponent(ForgotpassMessageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
