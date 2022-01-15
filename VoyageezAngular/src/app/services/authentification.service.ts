import { HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class AuthentificationService {
  constructor() {}

  public get headers(): HttpHeaders {
    return new HttpHeaders({
      'Content-Type': 'application/json',
      //'Access-Control-Allow-Origin': '*',
      //Authorization: 'Basic ' + btoa('olivier:olivier'),
    });
  }
}
