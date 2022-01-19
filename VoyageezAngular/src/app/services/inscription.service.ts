import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class InscriptionService {
  constructor(private http: HttpClient) {}

  inscription(client: any): Observable<any> {
    return this.http.post(
      'http://localhost:8080/voyageez/api/client/inscription',
      client
    );
  }
}
