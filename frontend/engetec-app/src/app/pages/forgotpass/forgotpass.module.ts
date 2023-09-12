import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AngularMaterialModule } from '../../angular-material/angular-material.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { ForgotpassRoutingModule } from './forgotpass-routing.module';
import { ForgotpassComponent } from './forgotpass.component';


@NgModule({
  declarations: [
    ForgotpassComponent
  ],
  imports: [
    CommonModule,
    ForgotpassRoutingModule,
    AngularMaterialModule,
    FormsModule,
    ReactiveFormsModule
  ]
})
export class ForgotpassModule { }
