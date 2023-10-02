import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
// import { PasswordService } from '../../services/password/password.service';
import { first } from 'rxjs/operators';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-forgotpass',
  templateUrl: './forgotpass.component.html',
  styleUrls: ['./forgotpass.component.scss']
})
export class ForgotpassComponent {

  constructor(
    // private toast: ToastrService,
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

    this.router.navigate(['/forgotpass-message']);
    let email = this.f['email'].value;

    // this.passwordService.forgot(email).pipe(first()).subscribe(
    //   data => {
    //     this.router.navigate(['/forgotpass-message']);
    //   },
    //   error => {
    //    console.log("Forgot Error", error);
    //    error.message.forEach((element: string | undefined) => {
    //      this.toast.error(element, 'Forgot')
    //    });
    //   }
    // )
  }

}
