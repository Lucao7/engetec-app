import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ForgotpassMessageComponent } from './forgotpass-message.component';

const routes: Routes = [{ path: '', component: ForgotpassMessageComponent }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ForgotpassMessageRoutingModule { }
