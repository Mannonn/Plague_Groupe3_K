import { Compte } from './../model/compte';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AuthentificationService } from './authentification.service';

@Injectable({
  providedIn: 'root',
})
export class CompteService {
  private static URL: string = 'http://localhost:8080/voyageez/api/compte';

  constructor(
    private http: HttpClient,
    private auth: AuthentificationService
  ) {}

  public getAll(): Observable<Compte[]> {
    return this.http.get<Compte[]>(CompteService.URL, {
      headers: this.auth.headers,
    });
  }

  public getById(id: number): Observable<Compte> {
    return this.http.get<Compte>(CompteService.URL + '/' + id, {
      headers: this.auth.headers,
    });
  }

  public update(compte: Compte): Observable<Compte> {
    return this.http.put<Compte>(CompteService.URL + '/' + compte.id, compte, {
      headers: this.auth.headers,
    });
  }

  public create(compte: Compte): Observable<Compte> {
    const o = {
      login: compte.login,
      password: compte.password,
    };
    return this.http.post<Compte>(CompteService.URL, o, {
      headers: this.auth.headers,
    });
  }

  public delete(id: number): Observable<void> {
    return this.http.delete<void>(CompteService.URL + '/' + id, {
      headers: this.auth.headers,
    });
  }
}
