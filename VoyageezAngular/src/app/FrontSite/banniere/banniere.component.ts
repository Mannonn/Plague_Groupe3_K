import { Component, OnInit } from '@angular/core';
import { Roles } from 'src/app/Roles';

@Component({
  selector: 'app-banniere',
  templateUrl: './banniere.component.html',
  styleUrls: ['./banniere.component.css'],
})
export class BanniereComponent implements OnInit {
  public rrole = Roles;
  constructor() {}

  ngOnInit(): void {}
}
