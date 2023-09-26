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
      environment.apiUrl + 'nova-avaliacao',
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

  getAvaliacao(idavAliacao: number) {
    return this.http.get(environment.apiUrl + 'avaliacao/' + idavAliacao);
  }

  deleteAvaliacao(idavAliacao: number) {
    return this.http.delete(environment.apiUrl + 'avaliacao/' + idavAliacao);
  }

  getAvaliacoes(idArtigo: number) {
    return this.http.get(environment.apiUrl + 'avaliacoes/' + idArtigo);
  }
}
