import { Component, OnInit } from '@angular/core';
import { Trajet } from 'src/app/model/trajet';
import { TrajetService } from 'src/app/services/trajet.service';

@Component({
  selector: 'app-trajet',
  templateUrl: './trajet.component.html',
  styleUrls: ['./trajet.component.css'],
})
export class TrajetComponent implements OnInit {
  trajets: Trajet[] = [];

  constructor(private trajetService: TrajetService) {}

  ngOnInit(): void {
    this.initTrajets();
  }

  initTrajets() {
    this.trajetService.getAll().subscribe((result) => {
      this.trajets = result;
    });
  }

  delete(id: number) {
    this.trajetService.delete(id).subscribe((ok) => {
      this.initTrajets();
    });
  }

  contenu() {
    console.log(this.trajets);
  }
}
