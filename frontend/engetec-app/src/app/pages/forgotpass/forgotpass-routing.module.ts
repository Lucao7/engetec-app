import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ForgotpassComponent } from './forgotpass.component';

const routes: Routes = [{ path: '', component: ForgotpassComponent }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ForgotpassRoutingModule { }
