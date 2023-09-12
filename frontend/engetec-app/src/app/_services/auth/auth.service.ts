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

  private _isLoggedIn = new BehaviorSubject<boolean>(false);

  constructor(
    private http: HttpClient,
    private storageService: StorageService
  ) {}

  get isLoggedIn() {
    return this._isLoggedIn.asObservable();
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
      let token = { token: data};
      this.storageService.setToken(token);
    }));
  }

  register(name: string, email: string, documentType: string, document: string, password: string): Observable<any> {
    return this.http.post(
      environment.authUrl + 'register',
      {
        name,
        email,
        documentType,
        document,
        password,
      },
      httpOptions
    );
  }

  logout(): Observable<any> {
    return this.http.post(environment.authUrl + 'logout', { }, httpOptions).pipe(map(data => {
      this._isLoggedIn.next(false);
      this.storageService.clean();
    }));
  }
}
