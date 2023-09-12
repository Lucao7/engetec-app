import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AngularMaterialModule } from '../../angular-material/angular-material.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { ResetpassRoutingModule } from './resetpass-routing.module';
import { ResetpassComponent } from './resetpass.component';


@NgModule({
  declarations: [
    ResetpassComponent
  ],
  imports: [
    CommonModule,
    ResetpassRoutingModule,
    AngularMaterialModule,
    FormsModule,
    ReactiveFormsModule
  ]
})
export class ResetpassModule { }
