import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
// import { PasswordService } from '../../services/password/password.service';
import { first } from 'rxjs/operators';
import { Router } from '@angular/router';

@Component({
  selector: 'app-forgotpass',
  templateUrl: './forgotpass.component.html',
  styleUrls: ['./forgotpass.component.scss']
})
export class ForgotpassComponent {

  constructor(
    // private passwordService: PasswordService,
    private router: Router
  ) { }

  forgotForm : FormGroup = new FormGroup({
    email: new FormControl('', [Validators.required, Validators.email]),
  });
  error = '';

  get f() { return this.forgotForm.controls; };

  forgotPass() {
    if(this.forgotForm.invalid) {
      return;
    }

    this.router.navigate(['/forgotpassmessage']);
    let email = this.f['email'].value;

    // this.passwordService.forgot(email).pipe(first()).subscribe(
    //   data => {
    //     this.router.navigate(['/forgotpassmessage']);
    //   },
    //   error => {
    //     this.error = error;
    //     console.log("Forgot page error", this.error)
    //   }
    // )
  }

}
