import { Router } from '@angular/router';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, map, Observable } from 'rxjs';
import { environment } from 'src/environments/environment.development';

import { StorageService } from '../storage/storage.service';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root',
})
export class AuthService {

  private _isLoggedIn = new BehaviorSubject<boolean>(this.storageService.isLoggedIn());

  constructor(
    private http: HttpClient,
    private storageService: StorageService,
    private router: Router
  ) {}

  get isLoggedIn() {
    return this._isLoggedIn['_value'];
  }

  login(email: string, password: string): Observable<any> {
    return this.http.post(
      environment.authUrl + 'login',
      {
        email,
        password,
      },
      httpOptions
    ).pipe(map(data => {
      this._isLoggedIn.next(true);
      this.storageService.setToken(data);
      this.router.navigate(['/dashboard']);
    }));
  }

  register(name: string, email: string, documentType: string, document: number, password: string): Observable<any> {
    return this.http.post(
      environment.alunoUrl,
      {
        "ra": document,
        "email": email,
        "nome": name,
        "senha": password,
      },
      httpOptions
    );
  }

  logout()/*: Observable<any>*/ {
    // return this.http.post(environment.authUrl + '/logout', { }, httpOptions).pipe(map(data => {
      this._isLoggedIn.next(false);
      this.storageService.clean();
      this.router.navigate(['/login']);
    // }));
  }
}
