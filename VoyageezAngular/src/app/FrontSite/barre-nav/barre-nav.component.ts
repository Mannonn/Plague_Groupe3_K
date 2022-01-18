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
import { Roles } from 'src/app/Roles';
@Component({
  selector: 'app-barre-nav',
  templateUrl: './barre-nav.component.html',
  styleUrls: ['./barre-nav.component.css'],
})
export class BarreNavComponent implements OnInit {
  public rrole = Roles;
  constructor(private router: Router) {}

  ngOnInit(): void {}

  get login(): string | null {
    return localStorage.getItem('login');
  }
}
