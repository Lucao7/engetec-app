import { AuthService } from 'src/app/_services/auth/auth.service';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment.development';
import { map } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(
    private http: HttpClient,
    private authService: AuthService,
  ) { }

  getUserDocument() {
    this.http.get(environment.getDocumentUrl)
    .pipe(map(document => {
      return document;
    }));
  }

  deleteAccount() {
    return this.http.delete(environment.userUrl)
    .pipe(map(() => {
      this.authService.logout();
    }))
  }
}
