import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { AreaService } from 'src/app/_services/area/area.service';
import { Area } from 'src/app/_models/area';
import { FileValidator } from 'ngx-material-file-input';

@Component({
  selector: 'app-artigo',
  templateUrl: './artigo.component.html',
  styleUrls: ['./artigo.component.scss']
})
export class ArtigoComponent implements OnInit {

  // Sets the file max size to 5MB
  readonly MB = 5;
  readonly maxSize = this.MB * 2 ** 20;

  areas: Area[] = [];

  constructor(
    private toast: ToastrService,
    private router: Router,
    private areaService: AreaService,
  ) { }

  artigoForm : FormGroup = new FormGroup({
    title: new FormControl('', [Validators.required]),
    keywords: new FormControl('', [Validators.required]),
    group: new FormControl('', [Validators.required]),
    areas: new FormControl('', [Validators.required]),
    artigo: new FormControl(undefined, [Validators.required, FileValidator.maxContentSize(this.maxSize)]),
  });

  get f() { return this.artigoForm.controls; };

  ngOnInit(): void {
    this.getCategories();
  }

  onFileInput() {
    setTimeout(() => {
      if (this.f['artigo'].value._files[0].type != "application/vnd.openxmlformats-officedocument.wordprocessingml.document")
        this.artigoForm.controls['artigo']?.setErrors({invalid: true});
    }, 10);
  }

  enviar() {

  }

  getCategories() {
    // this.areaService.getAreas()
    //   .subscribe(
    //     areas => {
    //       this.areas = areas
    //     }
    //     error => {
    //       console.log("Get Areas error - ", error);
    //       error.message.forEach((element: string | undefined) => {
    //         this.toast.error(element, 'Login')
    //       });
    //     }
    //   );

    let area1 = {"id": 1, "name": "Análise e Desenvolvimento de Sistemas"};
    let area2 = {"id": 2, "name": "Recursos Humanos"};
    let area3 = {"id": 3, "name": "Comércio Exterior"};
    let area4 = {"id": 4, "name": "Desenvolvimento de Software Multiplataforma"};
    this.areas.push(area1);
    this.areas.push(area2);
    this.areas.push(area3);
    this.areas.push(area4);
  }

}
