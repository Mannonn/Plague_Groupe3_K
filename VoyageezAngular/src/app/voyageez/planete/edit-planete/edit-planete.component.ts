import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { TypePlanete } from 'src/app/enum/type-planete';

import { Planete } from 'src/app/model/planete';
import { PlaneteService } from 'src/app/services/planete.service';

@Component({
  selector: 'app-edit-planete',
  templateUrl: './edit-planete.component.html',
  styleUrls: ['./edit-planete.component.css'],
})
export class EditPlaneteComponent implements OnInit {
  planete: Planete = new Planete();
  type = TypePlanete;
  constructor(
    private activatedRoute: ActivatedRoute,
    private planeteService: PlaneteService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params) => {
      if (!!params['id']) {
        this.planeteService.getById(params['id']).subscribe((result) => {
          this.planete = result;
        });
      }
    });
  }
  save() {
    if (!!this.planete.id) {
      this.planeteService.update(this.planete).subscribe((ok) => {
        this.router.navigate(['/planete']);
      });
    } else {
      this.planeteService.create(this.planete).subscribe((ok) => {
        this.router.navigate(['/planete']);
      });
    }
  }
}
