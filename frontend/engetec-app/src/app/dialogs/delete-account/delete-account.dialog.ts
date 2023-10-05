import { first } from 'rxjs/operators';
import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AngularMaterialModule } from 'src/app/angular-material/angular-material.module';
import { UserService } from 'src/app/_services/user/user.service';
import { ToastrService } from 'ngx-toastr';

@Component({
  standalone: true,
  imports: [
    CommonModule,
    AngularMaterialModule,
  ],
  templateUrl: './delete-account.dialog.html',
  styleUrls: ['./delete-account.dialog.scss']
})
export class DeleteAccountDialog {

  constructor(
    private userService: UserService,
    private toast: ToastrService,
  ) { }

  deleteAccount() {
    this.userService.deleteAccount()
    .pipe(first())
    .subscribe(
      success => {
        this.toast.success('Conta deletada com sucesso', 'Ok');
      },
      error => {
        this.toast.error('Algo deu errado', 'Ok');
      }
    );
  }

}
