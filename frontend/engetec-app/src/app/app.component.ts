import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'engetec-app';

  isDashboard() {
    var url = window.location.href;
    if (url != 'http://localhost:3001/dashboard')
      return false;
    return true;
  }
}
