import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

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
