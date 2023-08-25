import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { LoginComponent } from './pages/login/login.component';
import { RegisterComponent } from './pages/register/register.component';
import { ForgotpassComponent } from './pages/forgotpass/forgotpass.component';
import { ResetpassComponent } from './pages/resetpass/resetpass.component';
import { DashboardComponent } from './pages/dashboard/dashboard.component';
import { ArtigoComponent } from './pages/artigo/artigo.component';
import { AtribuicaoComponent } from './pages/atribuicao/atribuicao.component';
import { AvaliacaoComponent } from './pages/avaliacao/avaliacao.component';

const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'home', component: DashboardComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'forgotpass', component: ForgotpassComponent },
  { path: 'resetpass/:token', component: ResetpassComponent },
  { path: 'dashboard', /*canActivate: [AuthGuard],*/ component: DashboardComponent },
  { path: 'novo-artigo', /*canActivate: [AuthGuard],*/ component: ArtigoComponent },
  { path: 'atribuir-avaliadores', /*canActivate: [AuthGuard],*/ component: AtribuicaoComponent },
  { path: 'avaliacao', /*canActivate: [AuthGuard],*/ component: AvaliacaoComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
