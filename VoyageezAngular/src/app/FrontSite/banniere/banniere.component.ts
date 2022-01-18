import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-banniere',
  templateUrl: './banniere.component.html',
  styleUrls: ['./banniere.component.css'],
})
export class BanniereComponent implements OnInit {
  get role(): string | null {
    return localStorage.getItem('role');
  }

  constructor(private router: Router) {}

  ngOnInit(): void {}

  logoff() {
    localStorage.clear();
    this.router.navigate(['/home']);
  }

  get login(): string | null {
    return localStorage.getItem('login');
  }
}
