import { Client } from './../model/client';

import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AuthentificationService } from './authentification.service';

@Injectable({
  providedIn: 'root',
})
export class ClientService {
  private static URL: string = 'http://localhost:8080/voyageez/api/client';

  constructor(
    private http: HttpClient,
    private auth: AuthentificationService
  ) {}

  public getAll(): Observable<Client[]> {
    return this.http.get<Client[]>(ClientService.URL, {
      headers: this.auth.headers,
    });
  }

  public getById(id: number): Observable<Client> {
    return this.http.get<Client>(ClientService.URL + '/' + id, {
      headers: this.auth.headers,
    });
  }

  public update(compte: Client): Observable<Client> {
    return this.http.put<Client>(
      ClientService.URL + '/' + /*Client.id,*/ Client,
      {
        headers: this.auth.headers,
      }
    );
  }

  public create(client: Client): Observable<Client> {
    const o = {
      login: client.login,
      password: client.password,
      enabled: client.enabled,
      nom: client.nom,
      prenom: client.prenom,
      reservation: client.reservations,
    };
    return this.http.post<Client>(ClientService.URL, o, {
      headers: this.auth.headers,
    });
  }

  public delete(id: number): Observable<void> {
    return this.http.delete<void>(ClientService.URL + '/' + id, {
      headers: this.auth.headers,
    });
  }
}
