import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AvaliacaoRoutingModule } from './avaliacao-routing.module';
import { AvaliacaoComponent } from './avaliacao.component';


@NgModule({
  declarations: [
    AvaliacaoComponent
  ],
  imports: [
    CommonModule,
    AvaliacaoRoutingModule
  ]
})
export class AvaliacaoModule { }
