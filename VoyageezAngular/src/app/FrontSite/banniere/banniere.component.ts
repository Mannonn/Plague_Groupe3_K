import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-banniere',
  templateUrl: './banniere.component.html',
  styleUrls: ['./banniere.component.css'],
})
export class BanniereComponent implements OnInit {
  public visiteurIsChecked: boolean = false;
  public adminIsChecked: boolean = false;
  public clientIsChecked: boolean = true;
  constructor() {}

  ngOnInit(): void {}
}
