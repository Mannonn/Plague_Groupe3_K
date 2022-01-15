import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Activite } from '../model/activite';
import { AuthentificationService } from './authentification.service';

@Injectable({
  providedIn: 'root',
})
export class ActiviteService {
  private static URL: string = 'http://localhost:8080/voyageez/api/activite';

  constructor(
    private http: HttpClient,
    private auth: AuthentificationService
  ) {}

  public getAll(): Observable<Activite[]> {
    return this.http.get<Activite[]>(ActiviteService.URL, {
      headers: this.auth.headers,
    });
  }

  public getById(id: number): Observable<Activite> {
    return this.http.get<Activite>(ActiviteService.URL + '/' + id, {
      headers: this.auth.headers,
    });
  }

  public update(activite: Activite): Observable<Activite> {
    return this.http.put<Activite>(
      ActiviteService.URL + '/' + activite.id,
      activite,
      {
        headers: this.auth.headers,
      }
    );
  }

  public create(activite: Activite): Observable<Activite> {
    const o = {
      nom: activite.nom,
      prix: activite.prix,
      planete: activite.planete,
    };
    return this.http.post<Activite>(ActiviteService.URL, o, {
      headers: this.auth.headers,
    });
  }

  public delete(id: number): Observable<void> {
    return this.http.delete<void>(ActiviteService.URL + '/' + id, {
      headers: this.auth.headers,
    });
  }
}
