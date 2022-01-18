import { Client } from './../../model/client';
import { Compte } from 'src/app/model/compte';
/*import { Component, OnInit } from '@angular/core';
import { Roles } from 'src/app/Roles';
import { BanniereComponent } from '../banniere/banniere.component';
@Component({
  selector: 'app-barre-nav',
  templateUrl: './barre-nav.component.html',
  styleUrls: ['./barre-nav.component.css'],
})
export class BarreNavComponent implements OnInit {
  public rrole = Roles;
  constructor() {}

  ngOnInit(): void {}
}*/
import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { Admin } from 'src/app/model/admin';

@Component({
  selector: 'app-barre-nav',
  templateUrl: './barre-nav.component.html',
  styleUrls: ['./barre-nav.component.css'],
})
export class BarreNavComponent implements OnInit {
  get role(): string | null {
    return localStorage.getItem('role');
  }

  constructor(private router: Router) {}

  ngOnInit(): void {}

  get login(): string | null {
    return localStorage.getItem('login');
  }
}
