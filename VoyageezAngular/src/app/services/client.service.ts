import { Client } from './../model/client';

import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AuthenticationService } from './authentication.service';

@Injectable({
  providedIn: 'root',
})
export class ClientService {
  private static URL: string = 'http://localhost:8080/voyageez/api/client';

  constructor(private http: HttpClient, private auth: AuthenticationService) {}

  public getAll(): Observable<Client[]> {
    return this.http.get<Client[]>(ClientService.URL);
  }

  public getById(id: number): Observable<Client> {
    return this.http.get<Client>(ClientService.URL + '/' + id);
  }

  public update(compte: Client): Observable<Client> {
    return this.http.put<Client>(ClientService.URL + '/' + compte.id, Client, {
      headers: this.auth.headers,
    });
  }

  private formatClientToJson(client: Client): Object {
    const o = {
      login: client.login,
      password: client.password,
      enabled: client.enabled,
      role: client.role,
      nom: client.nom,
      prenom: client.prenom,
      reservation: client.reservations,
    };
    if (!!client.id) {
      Object.assign(o, { id: client.id });
    }
    return o;
  }
  public create(client: Client): Observable<Client> {
    return this.http.post<Client>(
      ClientService.URL,
      this.formatClientToJson(client),
      { headers: this.auth.headers }
    );
  }

  public delete(id: number): Observable<void> {
    return this.http.delete<void>(ClientService.URL + '/' + id, {
      headers: this.auth.headers,
    });
  }
}
