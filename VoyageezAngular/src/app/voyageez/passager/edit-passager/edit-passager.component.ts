import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Client } from 'src/app/model/client';
import { Passager } from 'src/app/model/passager';
import { PassagerService } from 'src/app/services/passager.service';

@Component({
  selector: 'app-edit-passager',
  templateUrl: './edit-passager.component.html',
  styleUrls: ['./edit-passager.component.css'],
})
export class EditPassagerComponent implements OnInit {
  passager: Passager = new Passager();
  constructor(
    private activatedRoute: ActivatedRoute,
    private passagerService: PassagerService,
    public client: Client,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params) => {
      if (!!params['id']) {
        this.passagerService.getById(params['id']).subscribe((result) => {
          this.passager = result;
        });
      }
    });
  }

  save() {
    if (!!this.passager.id) {
      this.passagerService.update(this.passager).subscribe((ok) => {
        this.router.navigate(['/passager']);
      });
    } else {
      this.passagerService.create(this.passager).subscribe((ok) => {
        this.router.navigate(['/passager']);
      });
    }
  }
}
