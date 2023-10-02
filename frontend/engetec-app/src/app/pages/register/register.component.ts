import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { AuthService } from '../../_services/auth/auth.service';
import { first } from 'rxjs/operators';
import { passwordMatchValidator } from '../../_shared/password/password-match.directive'
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent {

  minPW = 6;

  constructor(
    private toast: ToastrService,
    private authService: AuthService,
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

  onPasswordInput() {
    if (this.registerForm.controls['passwordConfirm']?.value == '')
      this.registerForm.controls['passwordConfirm']?.setErrors({required: true});
    else if (this.registerForm.hasError('passwordMismatch') && this.registerForm.touched)
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

    let name = this.f['name'].value;
    let email = this.f['email'].value;
    let documentType = this.f['documentType'].value;
    let document: number = +this.f['document'].value;
    let password = this.f['password'].value;

    this.authService.register(name, email, documentType, document, password)
      .pipe(first())
        .subscribe(
          data => {
            // Auto login after register
            this.authService.login(email, password)
              .pipe(first())
                .subscribe(
                  error => {
                    console.log("Login Error", error);
                    error.message.forEach((element: string | undefined) => {
                      this.toast.error(element, 'Register')
                    });
                  }
                );
          },
          error => {
            console.log("Register Error", error);
            error.message.forEach((element: string | undefined) => {
              this.toast.error(element, 'Register')
            });
          }
        );
  }

}
