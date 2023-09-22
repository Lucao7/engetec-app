import { Component } from '@angular/core';
import { AuthService } from 'src/app/_services/auth/auth.service';

@Component({
  selector: 'app-toolbar',
  templateUrl: './toolbar.component.html',
  styleUrls: ['./toolbar.component.scss']
})
export class ToolbarComponent {

  constructor (
    private authService: AuthService,
  ) { }

  logout() {
    this.authService.logout()
  }

}
