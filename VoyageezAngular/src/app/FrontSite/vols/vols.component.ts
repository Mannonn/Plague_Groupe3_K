import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-vols',
  templateUrl: './vols.component.html',
  styleUrls: ['./vols.component.css'],
})
export class VolsComponent implements OnInit {
  get role(): string | null {
    return localStorage.getItem('role');
  }
  constructor(private router: Router) {}

  ngOnInit(): void {}

  get login(): string | null {
    return localStorage.getItem('login');
  }
}
