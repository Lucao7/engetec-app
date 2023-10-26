import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { AuthService } from '../../_services/auth/auth.service';
import { first } from 'rxjs/operators';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {

  minPW = 6;

  constructor(
    private toast: ToastrService,
    private authService: AuthService,
  ) { }

  loginForm : FormGroup = new FormGroup({
    email: new FormControl('', [Validators.required, Validators.email]),
    password: new FormControl('', [Validators.required, Validators.minLength(this.minPW)]),
  });
  hide = true;
  error = '';

  get f() { return this.loginForm.controls; };

  login() {
    // stop here if form is invalid
    if (this.loginForm.invalid) {
      return;
    }

    // this.router.navigate(['/dashboard']);
    let email = this.f['email'].value;
    let password = this.f['password'].value;

    this.authService.login(email, password)
      .pipe(first())
      .subscribe(
        error => {
          if(error) {
            console.log("Login Error", error);
            error.message.forEach((element: string | undefined) => {
              this.toast.error(element, 'Login')
            });
          }
        });
  }
}
