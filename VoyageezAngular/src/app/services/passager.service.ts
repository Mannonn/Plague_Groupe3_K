import { Passager } from './../model/passager';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AuthentificationService } from './authentification.service';

@Injectable({
  providedIn: 'root',
})
export class PassagerService {
  private static URL: string = 'http://localhost:8080/voyageez/api/passager';

  constructor(
    private http: HttpClient,
    private auth: AuthentificationService
  ) {}

  public getAll(): Observable<Passager[]> {
    return this.http.get<Passager[]>(PassagerService.URL, {
      headers: this.auth.headers,
    });
  }

  public getById(id: number): Observable<Passager> {
    return this.http.get<Passager>(PassagerService.URL + '/' + id, {
      headers: this.auth.headers,
    });
  }

  public update(passager: Passager): Observable<Passager> {
    return this.http.put<Passager>(
      PassagerService.URL + '/' + passager.id,
      passager,
      {
        headers: this.auth.headers,
      }
    );
  }

  public create(passager: Passager): Observable<Passager> {
    const o = {
      nom: passager.nom,
      prenom: passager.prenom,
      client: passager.client,
    };
    return this.http.post<Passager>(PassagerService.URL, o, {
      headers: this.auth.headers,
    });
  }

  public delete(id: number): Observable<void> {
    return this.http.delete<void>(PassagerService.URL + '/' + id, {
      headers: this.auth.headers,
    });
  }
}
