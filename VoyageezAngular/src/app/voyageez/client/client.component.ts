import { Component, OnInit } from '@angular/core';
import { Client } from 'src/app/model/client';
import { ClientService } from 'src/app/services/client.service';

@Component({
  selector: 'app-client',
  templateUrl: './client.component.html',
  styleUrls: ['./client.component.css'],
})
export class ClientComponent implements OnInit {
  clients: Client[] = [];

  constructor(private clientService: ClientService) {}

  ngOnInit(): void {}

  initClients() {
    this.clientService.getAll().subscribe((result) => {
      this.clients = result;
    });
  }

  delete(id: number) {
    this.clientService.delete(id).subscribe((ok) => {
      this.initClients();
    });
  }
}
