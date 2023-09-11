import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { AuthService } from '../_services/auth/auth.service';
import { Router } from '@angular/router';
import { first } from 'rxjs/operators';
import { passwordMatchValidator } from '../_shared/password/password-match.directive'

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent {

  minPW = 6;

  constructor(
    private authService: AuthService,
    private router: Router
  ) { }

  registerForm: FormGroup = new FormGroup({
    name: new FormControl('', [Validators.required]),
    email: new FormControl('', [Validators.required, Validators.email]),
    password: new FormControl('', [Validators.required, Validators.minLength(this.minPW)]),
    passwordConfirm: new FormControl('', [Validators.required]),
    documentType: new FormControl('', [Validators.required]),
    document: new FormControl('', [Validators.required]),
  }, { validators: passwordMatchValidator });
  hide = true;
  error = '';

  onPasswordInput() {
    if (this.registerForm.controls['passwordConfirm']?.value == '')
      this.registerForm.controls['passwordConfirm']?.setErrors({required: true});
    else if (this.registerForm.hasError('passwordMismatch'))
      this.registerForm.controls['passwordConfirm']?.setErrors({'passwordMismatch': true});
    else
      this.registerForm.controls['passwordConfirm']?.setErrors(null);
  }

  get f() { return this.registerForm.controls; };

  register() {
    // Stop here if form is invalid
    if (this.registerForm.invalid) {
      return;
    }

    // this.router.navigate(['/dashboard']);
    let name = this.f['name'].value;
    let email = this.f['email'].value;
    let documentType = this.f['documentType'].value;
    let document = this.f['document'].value;
    let password = this.f['password'].value;

    this.authService.register(name, email, documentType, document, password)
      .pipe(first())
        .subscribe(
          data => {
            // Auto login after register
            this.authService.login(email, password)
              .pipe(first())
                .subscribe(
                  data => {
                    this.router.navigate(['/dashboard']);
                  },
                  error => {
                    this.error = error.message;
                    console.log("Login Error", this.error);
                  }
                );
          },
          error => {
            this.error = error.message;
            console.log("Register Error", this.error);
          }
        );
  }

}
