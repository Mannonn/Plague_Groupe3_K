import { Planete } from './../model/planete';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AuthentificationService } from './authentification.service';

@Injectable({
  providedIn: 'root',
})
export class PlaneteService {
  private static URL: string = 'http://localhost:8080/voyageez/api/planete';

  constructor(
    private http: HttpClient,
    private auth: AuthentificationService
  ) {}

  public getAll(): Observable<Planete[]> {
    return this.http.get<Planete[]>(PlaneteService.URL, {
      headers: this.auth.headers,
    });
  }

  public getById(id: number): Observable<Planete> {
    return this.http.get<Planete>(PlaneteService.URL + '/' + id, {
      headers: this.auth.headers,
    });
  }

  public update(planete: Planete): Observable<Planete> {
    return this.http.put<Planete>(
      PlaneteService.URL + '/' + planete.id,
      planete,
      {
        headers: this.auth.headers,
      }
    );
  }

  public create(planete: Planete): Observable<Planete> {
    const o = {
      nom: planete.nom,
      race: planete.typePlanete,
    };
    return this.http.post<Planete>(PlaneteService.URL, o, {
      headers: this.auth.headers,
    });
  }

  public delete(id: number): Observable<void> {
    return this.http.delete<void>(PlaneteService.URL + '/' + id, {
      headers: this.auth.headers,
    });
  }
}
