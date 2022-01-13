import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-menu-client',
  templateUrl: './menu-client.component.html',
  styleUrls: ['./menu-client.component.css'],
})
export class MenuClientComponent implements OnInit {
  private affich: boolean = false;
  constructor() {}

  ngOnInit(): void {}
  clicSurBoutonInfos() {
    alert('Voici vos infos');
    this.affich = true;
  }
  clicSurBoutonReservations() {
    alert('Voici vos reservations');
    this.affich = true;
  }
  clicSurBoutonPassagers() {
    alert('Voici vos passagers');
    this.affich = true;
  }
}
