import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Planete } from 'src/app/model/planete';
import { Trajet } from 'src/app/model/trajet';
import { Vaisseau } from 'src/app/model/vaisseau';
import { PlaneteService } from 'src/app/services/planete.service';
import { TrajetService } from 'src/app/services/trajet.service';
import { VaisseauService } from 'src/app/services/vaisseau.service';

@Component({
  selector: 'app-edit-trajet',
  templateUrl: './edit-trajet.component.html',
  styleUrls: ['./edit-trajet.component.css'],
})
export class EditTrajetComponent implements OnInit {
  trajet: Trajet = new Trajet();
  planetes: Planete[] = [];
  vaisseaux: Vaisseau[] = [];
  indicePlaneteDepart: number = -1;
  indicePlaneteArrivee: number = -1;
  indiceVaisseau: number = -1;
  depart: Planete = new Planete();
  arrivee: Planete = new Planete();
  vaisseau: Vaisseau = new Vaisseau();
  constructor(
    private activatedRoute: ActivatedRoute,
    private trajetService: TrajetService,
    private planeteService: PlaneteService,
    private vaisseauService: VaisseauService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params) => {
      if (!!params['id']) {
        this.trajetService.getById(params['id']).subscribe((result) => {
          this.trajet = result;
        });
      }
      this.planeteService.getAll().subscribe((result) => {
        this.planetes = result;
      });
      this.vaisseauService.getAll().subscribe((result) => {
        this.vaisseaux = result;
      });
    });
  }

  save() {
    if (!!this.trajet.depart && !!this.trajet.arrivee) {
      this.depart = this.trajet.depart;
      this.arrivee = this.trajet.arrivee;
    } else {
      this.depart = this.planetes[0];
      this.arrivee = this.planetes[1];
    }
    if (!!this.trajet.vaisseau) {
      this.vaisseau = this.trajet.vaisseau;
    } else {
      this.vaisseau = this.vaisseaux[0];
    }
    if (this.indicePlaneteDepart != -1) {
      this.trajet.depart = this.planetes[this.indicePlaneteDepart];
    } else {
      this.trajet.depart = this.depart;
    }
    if (this.indicePlaneteArrivee != -1) {
      this.trajet.arrivee = this.planetes[this.indicePlaneteArrivee];
    } else {
      this.trajet.arrivee = this.arrivee;
    }
    if (this.indiceVaisseau != -1) {
      this.trajet.vaisseau = this.vaisseaux[this.indiceVaisseau];
    } else {
      this.trajet.vaisseau = this.vaisseau;
    }

    if (!!this.trajet.id) {
      this.trajetService.update(this.trajet).subscribe((ok) => {
        this.router.navigate(['/trajet']);
      });
    } else {
      this.trajetService.create(this.trajet).subscribe((ok) => {
        this.router.navigate(['/trajet']);
      });
    }
  }
}
