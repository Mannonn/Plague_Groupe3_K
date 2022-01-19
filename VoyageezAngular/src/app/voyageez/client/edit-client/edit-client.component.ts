import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Client } from 'src/app/model/client';
import { Reservation } from 'src/app/model/reservation';
import { ClientService } from 'src/app/services/client.service';

@Component({
  selector: 'app-edit-client',
  templateUrl: './edit-client.component.html',
  styleUrls: ['./edit-client.component.css'],
})
export class EditClientComponent implements OnInit {
  client: Client = new Client();

  constructor(
    private activatedRoute: ActivatedRoute,
    private clientService: ClientService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params) => {
      if (!!params['id']) {
        this.clientService.getById(params['id']).subscribe((result) => {
          this.client = result;
        });
      }
    });
  }

  contenu() {
    console.log(this.client);
  }

  save() {
    this.clientService.create(this.client).subscribe((ok) => {
      this.router.navigate(['/menu-client']);
    });
  }
}
