import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Client } from 'src/app/model/client';
import { ClientService } from 'src/app/services/client.service';

@Component({
  selector: 'app-menu-client',
  templateUrl: './menu-client.component.html',
  styleUrls: ['./menu-client.component.css'],
})
export class MenuClientComponent implements OnInit {
  affichInfos: boolean = false;
  affichReservations: boolean = false;
  affichPassagers: boolean = false;
  client: Client = new Client();
  constructor(private clientService: ClientService) {}

  ngOnInit(): void {
    this.initClient();
  }

  initClient() {
    this.clientService
      .getById(+localStorage.getItem('id')!)
      .subscribe((result) => {
        this.client = result;
      });
  }
  clicSurBoutonInfos() {
    //alert('Voici vos infos');
    this.affichInfos = true;
    this.affichPassagers = false;
    this.affichReservations = false;
  }
  clicSurBoutonReservations() {
    //alert('Voici vos reservations');
    this.affichInfos = false;
    this.affichPassagers = false;
    this.affichReservations = true;
  }
  clicSurBoutonPassagers() {
    //alert('Voici vos passagers');
    this.affichInfos = false;
    this.affichPassagers = true;
    this.affichReservations = false;
  }
}
