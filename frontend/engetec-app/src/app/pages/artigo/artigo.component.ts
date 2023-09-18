import { Router } from '@angular/router';
import { Component } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { AreaService } from 'src/app/_services/area/area.service';
import { Area } from 'src/app/_models/area';

@Component({
  selector: 'app-artigo',
  templateUrl: './artigo.component.html',
  styleUrls: ['./artigo.component.scss']
})
export class ArtigoComponent implements OnInit {

  areas: Area[] = [];

  constructor(
    private toast: ToastrService,
    private router: Router,
    private areaService: AreaService,
  ) { }

  artigoForm : FormGroup = new FormGroup({
    title: new FormControl('', [Validators.required]),
    group: new FormControl('', [Validators.required]),
    areas: new FormControl('', [Validators.required]),
  });

  ngOnInit(): void {
    this.getCategories();
  }

  enviar() {

  }

  getCategories() {
    this.areaService.getAreas()
      .subscribe(
        // areas => this.areas = areas,
        error => console.log("Get Areas - ", error),
      );
  }

}
