import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
// import { AuthService } from '../services/auth/auth.service';
import { Router } from '@angular/router';
import { first } from 'rxjs/operators';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {

  minPW = 6;

  constructor(
    // private authService: AuthService,
    private router: Router,
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

    this.router.navigate(['/dashboard']);

    // this.authService.login(this.f['email'].value, this.f['password'].value)
    //   .pipe(first())
    //   .subscribe(
    //     data => {
    //       this.router.navigate(['/dashboard']);
    //     },
    //     error => {
    //       this.error = error;
    //       console.log("LoginPage Error", this.error);
    //     });
  }
}
