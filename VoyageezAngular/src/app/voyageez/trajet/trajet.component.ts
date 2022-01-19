import { PassagerService } from './../../services/passager.service';
import { Passager } from './../../model/passager';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Client } from 'src/app/model/client';
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
  passagers: Passager[] = [];
  filtrePlaneteDep: string = '';
  filtrePlaneteArr: string = '';
  affichPassaActi: Boolean = false;
  affichvalider: Boolean = false;
  resaPossible: Boolean = true;
  get role(): string | null {
    return localStorage.getItem('role');
  }

  constructor(
    private trajetService: TrajetService,
    private reservationService: ReservationService,
    private router: Router,
    private passagerService: PassagerService
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
  initpassagers() {
    this.passagerService.getAll().subscribe((result) => {
      this.passagers = result;
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

  get login(): string | null {
    return localStorage.getItem('login');
  }

  get loginID(): string | null {
    return localStorage.getItem('id');
  }

  get planeteFiltre(): Trajet[] {
    return this.trajets.filter((t) => {
      if (
        t.depart!.nom?.indexOf(this.filtrePlaneteDep) !== -1 ||
        t.arrivee!.nom?.indexOf(this.filtrePlaneteDep) !== -1
      ) {
        return true;
      } else {
        return false;
      }
    });
  }

  affichSuiteResa() {
    this.affichPassaActi = true;
    this.affichvalider = true;
    this.resaPossible = false;
  }

  listPassagers() {
    var list = new String('');
    let depp: number = 0;
    for (let passa of this.passagers) {
      if (depp == 0) {
        list = ' ' + passa.nom;
        depp++;
      } else {
        list = list + ', ' + passa.nom;
      }
    }
    if ((depp = 0)) {
      list = 'Aucun passager';
    }
    return list;
  }

  validerReservation() {
    this.affichPassaActi = false;
    this.affichvalider = false;
    this.resaPossible = true;
  }

  retour() {
    this.affichPassaActi = false;
    this.affichvalider = false;
    this.resaPossible = true;
  }
}
