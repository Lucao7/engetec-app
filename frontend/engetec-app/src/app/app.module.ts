import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { LoginComponent } from './pages/login/login.component';
import { RegisterComponent } from './pages/register/register.component';
import { ForgotpassComponent } from './pages/forgotpass/forgotpass.component';
import { ResetpassComponent } from './pages/resetpass/resetpass.component';
import { DashboardComponent } from './pages/dashboard/dashboard.component';
import { ArtigoComponent } from './pages/artigo/artigo.component';
import { AtribuicaoComponent } from './pages/atribuicao/atribuicao.component';
import { AvaliacaoComponent } from './pages/avaliacao/avaliacao.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    ForgotpassComponent,
    ResetpassComponent,
    DashboardComponent,
    ArtigoComponent,
    AtribuicaoComponent,
    AvaliacaoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
