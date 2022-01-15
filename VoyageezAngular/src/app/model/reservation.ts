import { DatePipe } from '@angular/common';
import { Activite } from './activite';
import { Client } from './client';
import { Passager } from './passager';
import { Trajet } from './trajet';

export class Reservation {
  public constructor(
    private _id?: number,
    private _dateReservation?: DatePipe,
    private _passager?: Array<Passager>,
    private _aller?: Trajet,
    private _retour?: Trajet,
    private _activite?: Array<Activite>,
    private _client?: Client
  ) {}

  public get id(): number | undefined {
    return this._id;
  }

  public set id(value: number | undefined) {
    this._id = value;
  }

  public get dateReservation(): DatePipe | undefined {
    return this._dateReservation;
  }

  public set dateReservation(value: DatePipe | undefined) {
    this._dateReservation = value;
  }

  public get passager(): Array<Passager> | undefined {
    return this._passager;
  }

  public set passager(value: Array<Passager> | undefined) {
    this._passager = value;
  }

  public get aller(): Trajet | undefined {
    return this._aller;
  }

  public set aller(value: Trajet | undefined) {
    this._aller = value;
  }

  public get retour(): Trajet | undefined {
    return this._aller;
  }

  public set retour(value: Trajet | undefined) {
    this._retour = value;
  }

  public get activite(): Array<Activite> | undefined {
    return this._activite;
  }

  public set activite(value: Array<Activite> | undefined) {
    this._activite = value;
  }

  public get client(): Client | undefined {
    return this._client;
  }

  public set client(value: Client | undefined) {
    this._client = value;
  }
}
