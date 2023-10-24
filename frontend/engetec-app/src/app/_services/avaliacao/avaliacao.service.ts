import { Observable, map } from 'rxjs';
import { Router } from '@angular/router';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment.development';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class AvaliacaoService {

  constructor(
    private http: HttpClient,
    private router: Router
  ) { }

  postAvaliacao(idArtigo: number, avaliadorDocument: number, nota: number, razao: string): Observable<any> {
    return this.http.post(
      environment.avaliacaoUrl,
      {
        idArtigo,
        avaliadorDocument,
        nota,
        razao,
      },
      httpOptions
    ).pipe(map(() => {
      this.router.navigate(['/dashboard']);
    }));
  }

  getAvaliacao(idAvaliacao: number) {
    return this.http.get(environment.avaliacaoUrl + `/${idAvaliacao}`);
  }

  deleteAvaliacao(idAvaliacao: number) {
    return this.http.delete(environment.avaliacaoUrl + `/${idAvaliacao}`);
  }

  getAvaliacoes(idArtigo: number) {
    return this.http.get(environment.avaliacaoUrl + `/${idArtigo}`);
  }
}
