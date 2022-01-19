import { PassagerService } from './../../services/passager.service';
import { Client } from './../../model/client';
import { Passager } from './../../model/passager';
import { Component, OnInit } from '@angular/core';
import { Reservation } from 'src/app/model/reservation';
import { ReservationService } from 'src/app/services/reservation.service';
import { min } from 'rxjs/operators';
import { ClientService } from 'src/app/services/client.service';

@Component({
  selector: 'app-reservation',
  templateUrl: './reservation.component.html',
  styleUrls: ['./reservation.component.css'],
})
export class ReservationComponent implements OnInit {
  reservations: Reservation[] = [];
  client: Client = new Client();

  constructor(
    private clientService: ClientService,
    private reservationService: ReservationService
  ) {}

  ngOnInit(): void {
    this.initClient();
  }

  initClient() {
    this.clientService
      .getById(+localStorage.getItem('id')!)
      .subscribe((result) => {
        for (let reservation of result.reservations!) {
          this.reservations.push(reservation);
        }
      });
  }

  contenu() {
    console.log(this.client);
  }

  affichActivites(resa: Reservation) {
    var list = new String('');
    let depp: number = 0;
    for (let actt of resa.activites!) {
      if (depp == 0) {
        list = ' ' + actt.nom;
        depp++;
      } else {
        list = list + ', ' + actt.nom;
      }
    }
    if ((depp = 0)) {
      list = 'Aucune activité';
    }
    return list;
  }

  affichPassagers(resa: Reservation) {
    var list = new String('');
    let depp: number = 0;
    for (let actt of resa.passagers!) {
      if (depp == 0) {
        list = ' ' + actt.nom;
        depp++;
      } else {
        list = list + ', ' + actt.nom;
      }
    }
    if ((depp = 0)) {
      list = 'Aucun passager';
    }
    return list;
  }

  delete(id: number) {
    this.reservationService.delete(id).subscribe((ok) => {
      this.initClient();
    });
  }
}
