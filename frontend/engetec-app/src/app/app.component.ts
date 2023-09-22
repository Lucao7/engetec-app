import { Component } from '@angular/core';
import { AuthService } from './_services/auth/auth.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'engetec-app';

  constructor (
    private authService: AuthService,
  ) {}

  isLogged() {
    return this.authService.isLoggedIn;
  }
}
