import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Reservation } from '../model/reservation';

import { AuthentificationService } from './authentification.service';

@Injectable({
  providedIn: 'root',
})
export class ReservationService {
  private static URL: string = 'http://localhost:8080/voyageez/api/reservation';

  constructor(
    private http: HttpClient,
    private auth: AuthentificationService
  ) {}

  public getAll(): Observable<Reservation[]> {
    return this.http.get<Reservation[]>(ReservationService.URL, {
      headers: this.auth.headers,
    });
  }

  public getById(id: number): Observable<Reservation> {
    return this.http.get<Reservation>(ReservationService.URL + '/' + id, {
      headers: this.auth.headers,
    });
  }

  public update(reservation: Reservation): Observable<Reservation> {
    return this.http.put<Reservation>(
      ReservationService.URL + '/' + reservation.id,
      reservation,
      {
        headers: this.auth.headers,
      }
    );
  }

  public create(reservation: Reservation): Observable<Reservation> {
    const o = {
      dateReservation: reservation.dateReservation,
      passager: reservation.passager,
      aller: reservation.aller,
      retour: reservation.retour,
      activite: reservation.activite,
      client: reservation.client,
    };
    return this.http.post<Reservation>(ReservationService.URL, o, {
      headers: this.auth.headers,
    });
  }

  public delete(id: number): Observable<void> {
    return this.http.delete<void>(ReservationService.URL + '/' + id, {
      headers: this.auth.headers,
    });
  }
}
