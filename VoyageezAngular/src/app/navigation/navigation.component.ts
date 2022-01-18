import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-navigation',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.css'],
})
export class NavigationComponent implements OnInit {
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
