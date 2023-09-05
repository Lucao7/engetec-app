import { Component } from '@angular/core';
// import { AuthService } from './services/auth/auth.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'engetec-app';

  // private authService: AuthService;

  isDashboard() {
    var url = window.location.href;
    if (url != 'http://localhost:4200/dashboard')
      return false;
    return true;
  }

  isLogged() {
    // return this.authService.isLogged;
    return false
  }
}
