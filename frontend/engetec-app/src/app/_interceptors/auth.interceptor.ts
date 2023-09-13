import {
  HTTP_INTERCEPTORS,
  HttpErrorResponse,
  HttpEvent,
  HttpHandler,
  HttpInterceptor,
  HttpRequest,
} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { tap } from 'rxjs/operators';

import { AuthService } from '../_services/auth/auth.service';
import { StorageService } from '../_services/storage/storage.service';

@Injectable()
export class AuthInterceptor implements HttpInterceptor {

  constructor(
    private storageService: StorageService,
    private authService: AuthService,
  ) {}

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    let token = this.storageService.getToken();

    if (token.token) {
      request = request.clone({ setHeaders: { Authorization: `Bearer ${token.token}` } });
    }
    return next.handle(request).pipe(tap(
      event => { },
      error => {
        if (error instanceof HttpErrorResponse) {
          if (error.status == 401) {
            console.log("Token expirado / inválido!");
            console.log("Deslogando usuário...");
            this.authService.logout();
          }
        }
      })
    );
  }
}

export const AuthInterceptorProvider = [
  {
    provide: HTTP_INTERCEPTORS,
    useClass: AuthInterceptor,
    multi: true
  },
];