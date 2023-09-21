import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
// import { PasswordService } from '../../services/password/password.service';
import { first } from 'rxjs/operators';
import { Router } from '@angular/router';
import { passwordMatchValidator } from 'src/app/_shared/password/password-match.directive';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-resetpass',
  templateUrl: './resetpass.component.html',
  styleUrls: ['./resetpass.component.scss']
})
export class ResetpassComponent {

  minPW = 6;

  constructor(
    // private toast: ToastrService,
    // private passwordService: PasswordService,
    private router: Router
  ) { }

  resetForm : FormGroup = new FormGroup({
    password: new FormControl('', [Validators.required, Validators.minLength(this.minPW)]),
    passwordConfirm: new FormControl('', [Validators.required]),
  }, { validators: passwordMatchValidator });
  hide = true;

  onPasswordInput() {
    if (this.resetForm.controls['passwordConfirm']?.value == '')
      this.resetForm.controls['passwordConfirm']?.setErrors({required: true});
    else if (this.resetForm.hasError('passwordMismatch') && this.resetForm.touched)
      this.resetForm.controls['passwordConfirm']?.setErrors({'passwordMismatch': true});
    else
      this.resetForm.controls['passwordConfirm']?.setErrors(null);
  }

  get f() { return this.resetForm.controls; };

  resetPass() {
    if(this.resetForm.invalid) {
      return;
    }

    this.router.navigate(['/login']);
    let password = this.f['password'].value

    // this.passwordService.reset(password).pipe(first()).subscribe(
    //   data => {
    //     this.router.navigate(['/login']);
    //   },
    //   error => {
    //    console.log("ResetPass Error", error);
    //    error.message.forEach((element: string | undefined) => {
    //      this.toast.error(element, 'ResetPass')
    //   }
    // )
  }

}
