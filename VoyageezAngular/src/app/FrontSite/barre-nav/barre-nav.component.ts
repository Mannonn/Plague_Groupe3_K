import { Component, OnInit } from '@angular/core';
import { BanniereComponent } from '../banniere/banniere.component';
@Component({
  selector: 'app-barre-nav',
  templateUrl: './barre-nav.component.html',
  styleUrls: ['./barre-nav.component.css'],
})
export class BarreNavComponent implements OnInit {
  public visiteurIsChecked: boolean = false;
  public adminIsChecked: boolean = true;
  public clientIsChecked: boolean = false;
  constructor() {}

  ngOnInit(): void {}
}
