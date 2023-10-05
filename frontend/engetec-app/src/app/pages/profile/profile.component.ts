import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { passwordMatchValidator } from '../../_shared/password/password-match.directive'
import { first } from 'rxjs/operators';
import { UserService } from 'src/app/_services/user/user.service';
import { ToastrService } from 'ngx-toastr';

import { MatDialog } from '@angular/material/dialog';
import { DeleteAccountDialog } from 'src/app/dialogs/delete-account/delete-account.dialog';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss']
})
export class ProfileComponent {

  minPW = 6;

  constructor(
    private toast: ToastrService,
    public dialog: MatDialog,
    private userService: UserService,
  ) { }

  profileForm: FormGroup = new FormGroup({
    name: new FormControl('', [Validators.required]),
    email: new FormControl({value: '', disabled: true}, [Validators.required, Validators.email]),
    document: new FormControl({value: '', disabled: true}, [Validators.required]),
  });

  passwordForm: FormGroup = new FormGroup({
    passwordOld: new FormControl('', [Validators.required]),
    password: new FormControl('', [Validators.required, Validators.minLength(this.minPW)]),
    passwordConfirm: new FormControl('', [Validators.required]),
  }, { validators: passwordMatchValidator });
  hideold = true;
  hide = true;

  onPasswordInput() {
    if (this.passwordForm.controls['passwordConfirm']?.value == '')
      this.passwordForm.controls['passwordConfirm']?.setErrors({required: true});
    else if (this.passwordForm.hasError('passwordMismatch') && this.passwordForm.touched)
      this.passwordForm.controls['passwordConfirm']?.setErrors({'passwordMismatch': true});
    else
      this.passwordForm.controls['passwordConfirm']?.setErrors(null);
  }

  get f() { return this.profileForm.controls; };

  get p() { return this.passwordForm.controls; };

  updateProfile() {
    if (this.profileForm.invalid) {
      return;
    }

  }

  changePassword() {
    if (this.passwordForm.invalid) {
      return;
    }

  }

  openDeleteAccountDialog() {
    this.dialog.open(DeleteAccountDialog);
  }

}
