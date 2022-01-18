import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Activite } from 'src/app/model/activite';
import { Planete } from 'src/app/model/planete';
import { ActiviteService } from 'src/app/services/activite.service';
import { PlaneteService } from 'src/app/services/planete.service';

@Component({
  selector: 'app-edit-activite',
  templateUrl: './edit-activite.component.html',
  styleUrls: ['./edit-activite.component.css'],
})
export class EditActiviteComponent implements OnInit {
  activite: Activite = new Activite();
  planetes: Planete[] = [];
  indicePlanete: number = -1;
  planete: Planete = new Planete();
  constructor(
    private activatedRoute: ActivatedRoute,
    private activiteService: ActiviteService,
    private planeteService: PlaneteService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params) => {
      if (!!params['id']) {
        this.activiteService.getById(params['id']).subscribe((result) => {
          this.activite = result;
        });
      }
      this.planeteService.getAll().subscribe((result) => {
        this.planetes = result;
      });
    });
  }

  save() {
    if (!!this.activite.planete) {
      this.planete = this.activite.planete;
    } else {
      this.planete = this.planetes[0];
    }

    if (this.indicePlanete != -1) {
      this.activite.planete = this.planetes[this.indicePlanete];
    } else {
      this.activite.planete = this.planete;
    }
    if (!!this.activite.id) {
      this.activiteService.update(this.activite).subscribe((ok) => {
        this.router.navigate(['/activite']);
      });
    } else {
      this.activiteService.create(this.activite).subscribe((ok) => {
        this.router.navigate(['/activite']);
      });
    }
  }
}
