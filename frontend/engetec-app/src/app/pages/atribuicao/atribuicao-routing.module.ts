import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AtribuicaoComponent } from './atribuicao.component';

const routes: Routes = [{ path: '', component: AtribuicaoComponent }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AtribuicaoRoutingModule { }
