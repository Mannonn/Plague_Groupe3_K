import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Vaisseau } from '../model/vaisseau';
import { AuthenticationService } from './authentication.service';

@Injectable({
  providedIn: 'root',
})
export class VaisseauService {
  private static URL: string = 'http://localhost:8080/voyageez/api/vaisseau';

  constructor(private http: HttpClient, private auth: AuthenticationService) {}

  public getAll(): Observable<Vaisseau[]> {
    return this.http.get<Vaisseau[]>(VaisseauService.URL, {
      headers: this.auth.headers,
    });
  }

  public getById(id: number): Observable<Vaisseau> {
    return this.http.get<Vaisseau>(VaisseauService.URL + '/' + id, {
      headers: this.auth.headers,
    });
  }

  public update(vaisseau: Vaisseau): Observable<Vaisseau> {
    return this.http.put<Vaisseau>(
      VaisseauService.URL + '/' + vaisseau.id,
      vaisseau,
      {
        headers: this.auth.headers,
      }
    );
  }

  public create(vaisseau: Vaisseau): Observable<Vaisseau> {
    const o = {
      nom: vaisseau.nom,
      capacite: vaisseau.capacite,
      capitaine: vaisseau.capitaine,
    };
    return this.http.post<Vaisseau>(VaisseauService.URL, o, {
      headers: this.auth.headers,
    });
  }

  public delete(id: number): Observable<void> {
    return this.http.delete<void>(VaisseauService.URL + '/' + id, {
      headers: this.auth.headers,
    });
  }
}
