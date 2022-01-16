import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Activite } from 'src/app/model/activite';
import { Planete } from 'src/app/model/planete';
import { ActiviteService } from 'src/app/services/activite.service';

@Component({
  selector: 'app-edit-activite',
  templateUrl: './edit-activite.component.html',
  styleUrls: ['./edit-activite.component.css'],
})
export class EditActiviteComponent implements OnInit {
  activite: Activite = new Activite();
  constructor(
    private activatedRoute: ActivatedRoute,
    private activiteService: ActiviteService,
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
  }
}
