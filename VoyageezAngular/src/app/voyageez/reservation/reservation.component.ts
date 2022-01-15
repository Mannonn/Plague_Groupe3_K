import { Component, OnInit } from '@angular/core';
import { Reservation } from 'src/app/model/reservation';
import { ReservationService } from 'src/app/services/reservation.service';

@Component({
  selector: 'app-reservation',
  templateUrl: './reservation.component.html',
  styleUrls: ['./reservation.component.css'],
})
export class ReservationComponent implements OnInit {
  reservations: Reservation[] = [];
  constructor(private reservationService: ReservationService) {}

  ngOnInit(): void {
    this.initReservations();
  }

  initReservations() {
    this.reservationService.getAll().subscribe((result) => {
      this.reservations = result;
    });
  }

  delete(id: number) {
    this.reservationService.delete(id).subscribe((ok) => {
      this.initReservations();
    });
  }
}
