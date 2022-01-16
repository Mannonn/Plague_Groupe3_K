import { Client } from 'src/app/model/client';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Activite } from 'src/app/model/activite';

import { Reservation } from 'src/app/model/reservation';
import { Trajet } from 'src/app/model/trajet';
import { ReservationService } from 'src/app/services/reservation.service';

@Component({
  selector: 'app-edit-reservation',
  templateUrl: './edit-reservation.component.html',
  styleUrls: ['./edit-reservation.component.css'],
})
export class EditReservationComponent implements OnInit {
  reservation: Reservation = new Reservation();
  constructor(
    private activatedRoute: ActivatedRoute,
    private reservationService: ReservationService,
    public trajet: Trajet,
    public activite: Activite,
    public client: Client,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params) => {
      if (!!params['id']) {
        this.reservationService.getById(params['id']).subscribe((result) => {
          this.reservation = result;
        });
      }
    });
  }
}