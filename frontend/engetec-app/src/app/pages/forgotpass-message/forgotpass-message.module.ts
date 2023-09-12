import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AngularMaterialModule } from '../../angular-material/angular-material.module';

import { ForgotpassMessageRoutingModule } from './forgotpass-message-routing.module';
import { ForgotpassMessageComponent } from './forgotpass-message.component';


@NgModule({
  declarations: [
    ForgotpassMessageComponent
  ],
  imports: [
    CommonModule,
    ForgotpassMessageRoutingModule,
    AngularMaterialModule
  ]
})
export class ForgotpassMessageModule { }
