import { HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class AuthentificationService {
  constructor() {}

  public getHeaders(): HttpHeaders {
    return new HttpHeaders({
      'Content-Type': 'application/json-schema',
      Authorization: 'Basic ' + btoa('voyageez:voyageez'),
    });
  }
}
