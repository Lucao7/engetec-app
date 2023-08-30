import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ResetpassRoutingModule } from './resetpass-routing.module';
import { ResetpassComponent } from './resetpass.component';


@NgModule({
  declarations: [
    ResetpassComponent
  ],
  imports: [
    CommonModule,
    ResetpassRoutingModule
  ]
})
export class ResetpassModule { }
