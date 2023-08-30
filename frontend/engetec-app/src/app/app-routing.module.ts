import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: '/login' },
  { path: 'login', loadChildren: () => import('./login/login.module').then(m => m.LoginModule) },
  { path: 'register', loadChildren: () => import('./register/register.module').then(m => m.RegisterModule) },
  { path: 'forgotpass', loadChildren: () => import('./forgotpass/forgotpass.module').then(m => m.ForgotpassModule) },
  { path: 'resetpass', loadChildren: () => import('./resetpass/resetpass.module').then(m => m.ResetpassModule) },
  { path: 'dashboard', loadChildren: () => import('./dashboard/dashboard.module').then(m => m.DashboardModule) },
  { path: 'novo-artigo', loadChildren: () => import('./artigo/artigo.module').then(m => m.ArtigoModule) },
  { path: 'atribuir', loadChildren: () => import('./atribuicao/atribuicao.module').then(m => m.AtribuicaoModule) },
  { path: 'avaliar', loadChildren: () => import('./avaliacao/avaliacao.module').then(m => m.AvaliacaoModule) }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
