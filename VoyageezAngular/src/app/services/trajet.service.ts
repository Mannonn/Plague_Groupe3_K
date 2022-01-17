import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Trajet } from '../model/trajet';
import { AuthenticationService } from './authentication.service';

@Injectable({
  providedIn: 'root',
})
export class TrajetService {
  private static URL: string = 'http://localhost:8080/voyageez/api/trajet';

  constructor(private http: HttpClient, private auth: AuthenticationService) {}

  public getAll(): Observable<Trajet[]> {
    return this.http.get<Trajet[]>(TrajetService.URL, {
      headers: this.auth.headers,
    });
  }

  public getById(id: number): Observable<Trajet> {
    return this.http.get<Trajet>(TrajetService.URL + '/' + id, {
      headers: this.auth.headers,
    });
  }

  public update(trajet: Trajet): Observable<Trajet> {
    return this.http.put<Trajet>(TrajetService.URL + '/' + trajet.id, trajet, {
      headers: this.auth.headers,
    });
  }

  public create(trajet: Trajet): Observable<Trajet> {
    const o = {
      dateDepart: trajet.dateDepart,
      heureDepart: trajet.heureDepart,
      dateArrivee: trajet.dateArrivee,
      heureArrivee: trajet.heureArrivee,
      prix: trajet.prix,
      depart: trajet.depart,
      arrivee: trajet.arrivee,
      vaisseau: trajet.vaisseau,
    };
    return this.http.post<Trajet>(TrajetService.URL, o, {
      headers: this.auth.headers,
    });
  }

  public delete(id: number): Observable<void> {
    return this.http.delete<void>(TrajetService.URL + '/' + id, {
      headers: this.auth.headers,
    });
  }
}
