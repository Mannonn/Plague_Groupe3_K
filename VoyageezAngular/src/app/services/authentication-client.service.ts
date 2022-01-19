import { Injectable } from '@angular/core';
import { CanActivate } from '@angular/router';

@Injectable({
  providedIn: 'root',
})
export class AuthenticationClientService implements CanActivate {
  get role(): string | null {
    return localStorage.getItem('role');
  }
  constructor() {}

  canActivate(): boolean {
    if (localStorage.getItem('token') != null && this.role == 'client') {
      return true;
    } else {
      return false;
    }
  }
}
