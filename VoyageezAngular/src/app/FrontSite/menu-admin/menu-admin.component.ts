import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-menu-admin',
  templateUrl: './menu-admin.component.html',
  styleUrls: ['./menu-admin.component.css'],
})
export class MenuAdminComponent implements OnInit {
  constructor() {}
  private affich: boolean = false;
  ngOnInit(): void {}
  clicSurBoutonInfos() {
    alert('Voici vos infos');
    this.affich = true;
  }

  clicSurBoutonCompte() {
    alert('Modifier les comptes');
    this.affich = true;
  }

  clicSurBoutonReservations() {
    alert('Modifier les reservations');
    this.affich = true;
  }
  clicSurBoutonPassagers() {
    alert('Modifier les passagers');
    this.affich = true;
  }
  clicSurBoutonPlanetes() {
    alert('Modifier les planetes');
    this.affich = true;
  }

  clicSurBoutonVols() {
    alert('Modifier les vols');
    this.affich = true;
  }

  clicSurBoutonTrajets() {
    alert('Modifier les trajets');
    this.affich = true;
  }

  clicSurBoutonActivites() {
    alert('Modifier les activites');
    this.affich = true;
  }

  clicSurBoutonVaisseaux() {
    alert('Modifier les vaisseaux');
    this.affich = true;
  }
}
