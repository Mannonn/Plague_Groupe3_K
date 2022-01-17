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
  planetesNom: string[] = [];

  constructor(
    private activatedRoute: ActivatedRoute,
    private activiteService: ActiviteService,
    private planeteService: PlaneteService,
    public planete: Planete,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params) => {
      if (!!params['id']) {
        this.activiteService.getById(params['id']).subscribe((result) => {
          this.activite = result;
        });
      }
    });
    this.planeteService.getAll().subscribe((result) => {
      this.planetes = result;
    });
    for (let p of this.planetes) {
      this.planetesNom.push(p.nom!);
    }
    console.log(this.planetes);
  }

  save() {
    if (!!this.activite.id) {
      this.activiteService.update(this.activite).subscribe((ok) => {
        this.router.navigate(['/vaisseau']);
      });
    } else {
      this.activiteService.create(this.activite).subscribe((ok) => {
        this.router.navigate(['/vaisseau']);
      });
    }
  }
}
