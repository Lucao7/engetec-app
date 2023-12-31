import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment.development';

@Injectable({
  providedIn: 'root'
})
export class AreaService {

  constructor(
    private http: HttpClient,
  ) { }

  getAreas() {
    return this.http.get(environment.areasUrl);
  }
}
