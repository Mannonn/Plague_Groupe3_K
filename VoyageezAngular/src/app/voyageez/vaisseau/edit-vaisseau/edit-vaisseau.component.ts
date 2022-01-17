import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Vaisseau } from 'src/app/model/vaisseau';
import { VaisseauService } from 'src/app/services/vaisseau.service';

@Component({
  selector: 'app-edit-vaisseau',
  templateUrl: './edit-vaisseau.component.html',
  styleUrls: ['./edit-vaisseau.component.css'],
})
export class EditVaisseauComponent implements OnInit {
  vaisseau: Vaisseau = new Vaisseau();
  constructor(
    private activatedRoute: ActivatedRoute,
    private vaisseauService: VaisseauService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params) => {
      if (!!params['id']) {
        this.vaisseauService.getById(params['id']).subscribe((result) => {
          this.vaisseau = result;
        });
      }
    });
  }
  save() {
    if (!!this.vaisseau.id) {
      this.vaisseauService.update(this.vaisseau).subscribe((ok) => {
        this.router.navigate(['/vaisseau']);
      });
    } else {
      this.vaisseauService.create(this.vaisseau).subscribe((ok) => {
        this.router.navigate(['/vaisseau']);
      });
    }
  }
}
