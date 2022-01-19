import { Component, OnInit } from '@angular/core';
import { Client } from 'src/app/model/client';
import { ClientService } from 'src/app/services/client.service';

@Component({
  selector: 'app-client',
  templateUrl: './client.component.html',
  styleUrls: ['./client.component.css'],
})
export class ClientComponent implements OnInit {
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

  delete(id: number) {
    this.clientService.delete(id).subscribe((ok) => {
      this.initClient();
    });
  }
  contenu() {
    console.log(this.client);
  }
}
