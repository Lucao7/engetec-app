import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
// import { ForgotPassService } from '../../services/forgot/forgot-pass.service';
import { first } from 'rxjs/operators';
import { Router } from '@angular/router';

@Component({
  selector: 'app-forgotpass',
  templateUrl: './forgotpass.component.html',
  styleUrls: ['./forgotpass.component.scss']
})
export class ForgotpassComponent {

  constructor(
    // private forgotService: ForgotPassService,
    private router: Router
  ) { }

  forgotForm : FormGroup = new FormGroup({
    email: new FormControl('', [Validators.required, Validators.email]),
  });
  error = '';

  get f() { return this.forgotForm.controls; };

  forgotPass() {
    if(this.forgotForm.invalid) {
      console.log('Deu ruim!');
      return;
    }

    console.log('Deu bom!');

    // this.forgotService.forgot(this.f.email.value).pipe(first()).subscribe(
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
