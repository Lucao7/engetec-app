import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { AuthInterceptorProvider } from './_interceptors/auth.interceptor';
import { AutoFocus } from './_shared/auto-focus/auto-focus.directive';
import { AngularMaterialModule } from './angular-material/angular-material.module';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ToastrModule } from 'ngx-toastr';
import { ToolbarComponent } from './components/toolbar/toolbar.component';

@NgModule({
  declarations: [
    AppComponent,
    AutoFocus,
    ToolbarComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    AngularMaterialModule,
    HttpClientModule,
    ToastrModule.forRoot({
      timeOut: 10000,
      closeButton: true,
      progressBar: true
    })
  ],
  providers: [AuthInterceptorProvider],
  bootstrap: [AppComponent]
})
export class AppModule { }
