import { Component, OnInit } from '@angular/core';
import { Activite } from 'src/app/model/activite';
import { Reservation } from 'src/app/model/reservation';
import { ActiviteService } from 'src/app/services/activite.service';
import { ReservationService } from 'src/app/services/reservation.service';

@Component({
  selector: 'app-activite',
  templateUrl: './activite.component.html',
  styleUrls: ['./activite.component.css'],
})
export class ActiviteComponent implements OnInit {
  activites: Activite[] = [];
  reservations: Reservation[] = [];

  constructor(
    private activiteService: ActiviteService,
    private reservationService: ReservationService
  ) {}

  ngOnInit(): void {
    this.initActivites();
    this.initReservations();
  }

  initActivites() {
    this.activiteService.getAll().subscribe((result) => {
      this.activites = result;
    });
  }
  initReservations() {
    this.reservationService.getAll().subscribe((result) => {
      this.reservations = result;
    });
  }
  compt: number = 0;
  activiteUtilise(activite: Activite): boolean {
    for (let r of this.reservations) {
      if (r.activites != null) {
        {
          for (let a of r.activites) {
            if (activite.nom == a.nom) {
              return true;
            }
          }
        }
      }
    }
    return false;
  }

  delete(id: number) {
    this.activiteService.delete(id).subscribe((ok) => {
      this.initActivites();
    });
  }
}
