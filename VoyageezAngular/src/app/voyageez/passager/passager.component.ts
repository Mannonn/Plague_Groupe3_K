import { ReservationService } from './../../services/reservation.service';
import { Client } from './../../model/client';
import { Component, OnInit } from '@angular/core';
import { Passager } from 'src/app/model/passager';
import { PassagerService } from 'src/app/services/passager.service';
import { ClientService } from 'src/app/services/client.service';
import { Reservation } from 'src/app/model/reservation';
import { RouterLinkActive } from '@angular/router';

@Component({
  selector: 'app-passager',
  templateUrl: './passager.component.html',
  styleUrls: ['./passager.component.css'],
})
export class PassagerComponent implements OnInit {
  passagers: Passager[] = [];
  listPassa: Passager[] = [];
  client: Client = new Client();
  reservations: Reservation[] = [];
  affichOK: boolean = false;
  constructor(
    private passagerService: PassagerService,
    private clientService: ClientService,
    private reservationService: ReservationService
  ) {}

  ngOnInit(): void {
    this.initPassager();
    this.initClient();
  }

  initPassager() {
    this.passagerService.getAll().subscribe((result) => {
      this.passagers = result;
    });
  }

  initClient() {
    this.clientService
      .getById(+localStorage.getItem('id')!)
      .subscribe((result) => {
        this.client = result;
      });
  }

  listPassagers() {
    for (let r of this.reservations) {
      for (let p of r.passagers!) {
        if (this.client.id! == p.client?.id!) {
          console.log(p);
          this.listPassa.push(p);
        }
      }
    }
    this.affichOK = true;
  }

  affichTableau() {
    this.listPassagers();
  }

  delete(id: number) {
    this.passagerService.delete(id).subscribe((ok) => {
      this.initPassager();
    });
  }
}
