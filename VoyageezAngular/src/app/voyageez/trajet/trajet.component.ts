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
import { FormBuilder, FormGroup } from '@angular/forms';
import { ClientService } from 'src/app/services/client.service';
import { Activite } from 'src/app/model/activite';

@Component({
  selector: 'app-trajet',
  templateUrl: './trajet.component.html',
  styleUrls: ['./trajet.component.css'],
})
export class TrajetComponent implements OnInit {
  trajets: Trajet[] = [];
  trajettemp: Trajet = new Trajet();
  reservations: Reservation[] = [];
  passagerTemp: Passager = new Passager();
  activiteTemp: Activite = new Activite();
  passagers: Passager[] = [];
  passagersChoix: Passager[] = [];
  activites: Activite[] = [];
  activitesChoix: Activite[] = [];
  client: Client = new Client();
  filtrePlaneteDep: string = '';
  filtrePlaneteArr: string = '';
  affichPassaActi: Boolean = false;
  affichvalider: Boolean = false;
  resaPossible: Boolean = true;

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
    this.initReservations();
    this.initClient();
    this.initActivites();
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
  initActivites() {
    this.activiteService.getAll().subscribe((result) => {
      this.activites = result;
    });
  }

  initpassagers() {
    this.passagerService.getAll().subscribe((result) => {
      this.passagers = result;
    });
  }
  initClient() {
    this.clientService
      .getById(+localStorage.getItem('id')!)
      .subscribe((result) => {
        for (let reservation of result.reservations!) {
          this.reservations.push(reservation);
        }
        this.client = result;
      });
  }

  validerReservation() {
    this.affichPassaActi = false;
    this.affichvalider = false;
    this.resaPossible = true;
    this.saveResa();
  }
  retour() {
    this.affichPassaActi = false;
    this.affichvalider = false;
    this.resaPossible = true;
  }
  affichSuiteResa(trajett: Trajet) {
    this.affichPassaActi = true;
    this.affichvalider = true;
    this.resaPossible = false;
    this.listPassagers();
    this.listactivitess(trajett.arrivee!);
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
        if (p.client?.id == 3) {
          this.passagers.push(p);
          console.log(p);
        }
      }
    }
  }

  listactivitess(plannete: Planete) {
    for (let actt of this.activites) {
      if (actt.planete == plannete) {
        this.activites.push(actt);
      }
    }
    console.log(this.activites);
  }

  planeteUtilise(planete: Planete): boolean {
    let utilise = false;
    for (let t of this.trajets) {
      console.log(t);
      if (planete.nom == t.depart!.nom || planete.nom == t.arrivee!.nom) {
        utilise = true;
      }
    }
    console.log(utilise);
    return utilise;
  }

  ajouterPass() {
    this.passagersChoix.push(this.passagerTemp);
    console.log(this.passagersChoix);
    /* this.passagerTemp = new Passager(); */
  }

  ajouterActi() {
    this.activitesChoix.push(this.activiteTemp);
    console.log(this.activitesChoix);
  }

  saveResa() {
    var nouvelleResa: Reservation = new Reservation();
    // recuperer id trajet choisis
    // recuperer id passagers selectionnés selon client
    // recuperer id actvites selon planete arrivee
    // recuperer id client
    // ==>creer une reservation
    nouvelleResa.client = this.client;
    nouvelleResa.activites = this.activitesChoix;
    nouvelleResa.passagers = this.passagersChoix;
    /*  nouvelleResa.aller= this.trajjet;
    nouvelleResa.dateReservation=date; */
    this.reservationService.create(nouvelleResa);

    /*  if (!!this.planete.id) {
      this.planeteService.update(this.planete).subscribe((ok) => {
        this.router.navigate(['/planete']);
      });
    } else {
      this.planeteService.create(this.planete).subscribe((ok) => {
        this.router.navigate(['/planete']);
      });
    } */
  }
}
