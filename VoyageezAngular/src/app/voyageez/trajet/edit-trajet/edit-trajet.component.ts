import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Planete } from 'src/app/model/planete';
import { Trajet } from 'src/app/model/trajet';
import { TrajetService } from 'src/app/services/trajet.service';

@Component({
  selector: 'app-edit-trajet',
  templateUrl: './edit-trajet.component.html',
  styleUrls: ['./edit-trajet.component.css'],
})
export class EditTrajetComponent implements OnInit {
  trajet: Trajet = new Trajet();
  constructor(
    private activatedRoute: ActivatedRoute,
    private trajetService: TrajetService,
    public planete: Planete,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params) => {
      if (!!params['id']) {
        this.trajetService.getById(params['id']).subscribe((result) => {
          this.trajet = result;
        });
      }
    });
  }

  save() {
    if (!!this.planete.id) {
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
