import { Component, OnInit } from '@angular/core';
import { Activite } from 'src/app/model/activite';
import { ActiviteService } from 'src/app/services/activite.service';

@Component({
  selector: 'app-activite',
  templateUrl: './activite.component.html',
  styleUrls: ['./activite.component.css'],
})
export class ActiviteComponent implements OnInit {
  activites: Activite[] = [];

  constructor(private activiteService: ActiviteService) {}

  ngOnInit(): void {
    this.initActivites();
  }

  initActivites() {
    this.activiteService.getAll().subscribe((result) => {
      this.activites = result;
    });
  }

  delete(id: number) {
    this.activiteService.delete(id).subscribe((ok) => {
      this.initActivites();
    });
  }

  contenu() {
    console.log(this.activites);
  }
}
