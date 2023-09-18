import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AngularMaterialModule } from '../../angular-material/angular-material.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { ArtigoRoutingModule } from './artigo-routing.module';
import { ArtigoComponent } from './artigo.component';


@NgModule({
  declarations: [
    ArtigoComponent
  ],
  imports: [
    CommonModule,
    ArtigoRoutingModule,
    AngularMaterialModule,
    FormsModule,
    ReactiveFormsModule
  ]
})
export class ArtigoModule { }
