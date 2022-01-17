import { Activite } from './../../model/activite';
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { ActiviteService } from 'src/app/services/activite.service';

@Component({
  selector: 'app-activites',
  templateUrl: './activites.component.html',
  styleUrls: ['./activites.component.css'],
})
export class ActivitesComponent implements OnInit {
  activites: Observable<Activite[]> | null = null;
  constructor(private activiteService: ActiviteService) {}

  ngOnInit(): void {
    this.activites = this.activiteService.getAll();
  }
}
