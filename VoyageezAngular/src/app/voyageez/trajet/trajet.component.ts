import { Component, OnInit } from '@angular/core';
import { Reservation } from 'src/app/model/reservation';
import { Trajet } from 'src/app/model/trajet';
import { ReservationService } from 'src/app/services/reservation.service';
import { TrajetService } from 'src/app/services/trajet.service';

@Component({
  selector: 'app-trajet',
  templateUrl: './trajet.component.html',
  styleUrls: ['./trajet.component.css'],
})
export class TrajetComponent implements OnInit {
  trajets: Trajet[] = [];
  reservations: Reservation[] = [];

  constructor(
    private trajetService: TrajetService,
    private reservationService: ReservationService
  ) {}

  ngOnInit(): void {
    this.initTrajets();
    this.initReservations();
  }

  initTrajets() {
    this.trajetService.getAll().subscribe((result) => {
      this.trajets = result;
    });
  }
  initReservations() {
    this.reservationService.getAll().subscribe((result) => {
      this.reservations = result;
    });
  }
  trajetUtilise(trajet: Trajet): boolean {
    for (let r of this.reservations) {
      if (r.aller!.id == trajet.id) {
        return true;
      } else if (!!r.retour) {
        if (r.retour!.id == trajet.id) {
          return true;
        }
      }
    }
    return false;
  }

  delete(id: number) {
    this.trajetService.delete(id).subscribe((ok) => {
      this.initTrajets();
    });
  }
}
