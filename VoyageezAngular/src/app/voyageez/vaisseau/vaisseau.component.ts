import { TrajetService } from './../../services/trajet.service';
import { Component, OnInit } from '@angular/core';
import { Vaisseau } from 'src/app/model/vaisseau';
import { VaisseauService } from 'src/app/services/vaisseau.service';
import { Trajet } from 'src/app/model/trajet';

@Component({
  selector: 'app-vaisseau',
  templateUrl: './vaisseau.component.html',
  styleUrls: ['./vaisseau.component.css'],
})
export class VaisseauComponent implements OnInit {
  vaisseaux: Vaisseau[] = [];
  trajets: Trajet[] = [];
  constructor(
    private vaisseauService: VaisseauService,
    private trajetService: TrajetService
  ) {}

  ngOnInit(): void {
    this.initVaisseaux();
    this.initTrajets();
  }

  initVaisseaux() {
    this.vaisseauService.getAll().subscribe((result) => {
      this.vaisseaux = result;
    });
  }
  initTrajets() {
    this.trajetService.getAll().subscribe((result) => {
      this.trajets = result;
    });
  }

  vaisseauUtilise(vaisseau: Vaisseau): boolean {
    let utilise = false;
    for (let t of this.trajets) {
      console.log(t);
      if (vaisseau.nom == t.vaisseau!.nom) {
        utilise = true;
      }
    }
    console.log(utilise);
    return utilise;
  }

  delete(id: number) {
    this.vaisseauService.delete(id).subscribe((ok) => {
      this.initVaisseaux();
    });
  }
  contenu() {
    console.log(this.vaisseaux);
  }
}
