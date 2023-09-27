import { UserService } from './../../_services/user/user.service';
import { Component } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { first } from 'rxjs/operators';
import { AvaliacaoService } from 'src/app/_services/avaliacao/avaliacao.service';

@Component({
  selector: 'app-avaliacao',
  templateUrl: './avaliacao.component.html',
  styleUrls: ['./avaliacao.component.scss']
})
export class AvaliacaoComponent {

  title: string = 'Artigo X';

  constructor(
    private toast: ToastrService,
    private avaliacaoService: AvaliacaoService,
    private userService: UserService
  ) { }

  avaliacaoForm : FormGroup = new FormGroup({
    group: new FormControl('', [Validators.required]),
    areas: new FormControl('', [Validators.required]),
  });

  get f() { return this.avaliacaoForm.controls; };

  enviar() {
    // stop here if form is invalid
    if (this.avaliacaoForm.invalid) {
      return;
    }

    // this.router.navigate(['/dashboard']);
    // let artigoID = this.idArtigo;
    // let avaliadorDocument = this.userService.getAvaliadorDocument();
    let nota = this.f['nota'].value;
    let razao = this.f['razao'].value;

  //   this.avaliacaoService.postAvaliacao(artigoID, avaliadorDocument, nota, razao)
  //     .pipe(first())
  //     .subscribe(
  //       error => {
  //         console.log("Login Error", error);
  //         error.message.forEach((element: string | undefined) => {
  //           this.toast.error(element, 'Login')
  //         });
  //       });
  }

}
