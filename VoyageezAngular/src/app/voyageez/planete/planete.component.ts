import { PlaneteService } from './../../services/planete.service';
import { Component, OnInit } from '@angular/core';
import { Planete } from 'src/app/model/planete';
import { Observable } from 'rxjs';
import { Trajet } from 'src/app/model/trajet';
import { TrajetService } from 'src/app/services/trajet.service';

@Component({
  selector: 'app-planete',
  templateUrl: './planete.component.html',
  styleUrls: ['./planete.component.css'],
})
export class PlaneteComponent implements OnInit {
  planetes: Planete[] = [];
  trajets: Trajet[] = [];

  constructor(
    private planeteService: PlaneteService,
    private trajetService: TrajetService
  ) {}

  ngOnInit(): void {
    this.initPlanetes();
    this.initTrajets();
  }

  initPlanetes() {
    this.planeteService.getAll().subscribe((result) => {
      this.planetes = result;
    });
  }

  initTrajets() {
    this.trajetService.getAll().subscribe((result) => {
      this.trajets = result;
    });
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

  delete(id: number) {
    this.planeteService.delete(id).subscribe((ok) => {
      console.log(ok);
      this.initPlanetes();
    });
  }
}
