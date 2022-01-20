import { DatePipe, DATE_PIPE_DEFAULT_TIMEZONE } from '@angular/common';
import { ActiviteService } from './../../services/activite.service';
import { Planete } from './../../model/planete';
import { PassagerService } from './../../services/passager.service';
import { Passager } from './../../model/passager';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Client } from 'src/app/model/client';
import { Reservation } from 'src/app/model/reservation';
import { Trajet } from 'src/app/model/trajet';
import { ReservationService } from 'src/app/services/reservation.service';
import { TrajetService } from 'src/app/services/trajet.service';
import { ClientService } from 'src/app/services/client.service';
import { Activite } from 'src/app/model/activite';

@Component({
  selector: 'app-trajet',
  templateUrl: './trajet.component.html',
  styleUrls: ['./trajet.component.css'],
})
export class TrajetComponent implements OnInit {
  activites: Activite[] = [];
  activitestris: Activite[] = [];
  activitesChoix: Activite[] = [];
  indexActivite: number = -1;

  client: Client = new Client();

  affichPassaActi: Boolean = false;
  affichvalider: Boolean = false;
  resaPossible: Boolean = true;

  trajets: Trajet[] = [];
  trajet: Trajet = new Trajet();
  idTrajet: number = -1;

  reservations: Reservation[] = [];

  indexPassager: number = -1;
  passagers: Passager[] = [];
  passagersChoix: Passager[] = [];

  filtrePlaneteDep: string = '';
  filtrePlaneteArr: string = '';
  idArrivee: number = -1;

  visible: boolean = false;

  constructor(
    private trajetService: TrajetService,
    private reservationService: ReservationService,
    private router: Router,
    private passagerService: PassagerService,
    private clientService: ClientService,
    private activiteService: ActiviteService
  ) {}

  get role(): string | null {
    return localStorage.getItem('role');
  }
  get login(): string | null {
    return localStorage.getItem('login');
  }

  get loginID(): string | null {
    return localStorage.getItem('id');
  }

  ngOnInit(): void {
    this.initTrajets();
    this.initClient();
    this.initActivites();
  }
  initTrajets() {
    this.trajetService.getAll().subscribe((result) => {
      this.trajets = result;
    });
  }

  visibilite() {
    this.visible = !this.visible;
  }

  initActivites() {
    this.activiteService.getAll().subscribe((result) => {
      this.activites = result;
    });
  }

  initClient() {
    this.clientService
      .getById(+localStorage.getItem('id')!)
      .subscribe((result) => {
        this.client = result;
        for (let reservation of result.reservations!) {
          this.reservations.push(reservation);
        }
      });
  }

  validerReservation() {
    this.affichPassaActi = false;
    this.affichvalider = false;
    this.resaPossible = true;
    this.saveResa();
    this.idTrajet = -1;
    this.idArrivee = -1;
    this.passagersChoix = [];
    this.activitesChoix = [];
    this.activitestris = [];
  }
  retour() {
    this.affichPassaActi = false;
    this.affichvalider = false;
    this.resaPossible = true;
  }
  affichSuiteResa(trajett: Trajet) {
    console.log(this.client);
    this.trajet = trajett;
    this.affichPassaActi = true;
    this.affichvalider = true;
    this.resaPossible = false;
    this.idArrivee = trajett.arrivee!.id!;
    this.idTrajet = trajett.id!;
    this.listPassagers();
    this.listactivitess();
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

  listPassagers() {
    for (let r of this.reservations) {
      for (let p of r.passagers!) {
        this.passagers.push(p);
      }
    }
  }

  listactivitess() {
    console.log(this.activites);
    for (let actt of this.activites) {
      if (this.trajet.arrivee!.id == actt.planete!.id) {
        this.activitestris.push(actt);
      }
    }
    console.log(this.activitestris);
  }

  ajouterPass() {
    this.passagersChoix.push(this.passagers[this.indexPassager]);
    this.indexPassager = -1;
  }

  ajouterActi() {
    this.activitesChoix.push(this.activitestris[this.indexActivite]);
    this.indexActivite = -1;
    console.log(this.activitesChoix);
  }

  saveResa() {
    var nouvelleResa: Reservation = new Reservation();
    nouvelleResa.client = this.client;
    nouvelleResa.aller = this.trajet;
    nouvelleResa.activites = this.activitesChoix;
    nouvelleResa.passagers = this.passagersChoix;
    this.reservationService.create(nouvelleResa);

    this.reservationService.create(nouvelleResa).subscribe((ok) => {
      this.router.navigate(['/menu_client']);
    });
  }
}
