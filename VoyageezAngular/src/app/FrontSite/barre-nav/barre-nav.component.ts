import { Component, OnInit } from '@angular/core';
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
}
