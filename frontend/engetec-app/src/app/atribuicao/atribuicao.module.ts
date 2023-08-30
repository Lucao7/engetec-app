import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AtribuicaoRoutingModule } from './atribuicao-routing.module';
import { AtribuicaoComponent } from './atribuicao.component';


@NgModule({
  declarations: [
    AtribuicaoComponent
  ],
  imports: [
    CommonModule,
    AtribuicaoRoutingModule
  ]
})
export class AtribuicaoModule { }
