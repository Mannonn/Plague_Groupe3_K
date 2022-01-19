import { Compte } from './compte';
import { Passager } from './passager';

import { Reservation } from './reservation';

export class Client extends Compte {
  public constructor(
    _id?: number,
    _login?: any,
    _password?: any,
    _enabled?: boolean,
    _role?: 'client',
    private _nom?: string,
    private _prenom?: string,
    private _reservations?: Array<Reservation>,
    private _passagers?: Array<Passager>
  ) {
    super(_id, _login, _password, _enabled, 'client');
  }
  public get nom(): string | undefined {
    return this._nom;
  }

  public set nom(value: string | undefined) {
    this._nom = value;
  }

  public get prenom(): string | undefined {
    return this._prenom;
  }

  public set prenom(value: string | undefined) {
    this._prenom = value;
  }

  public get reservations(): Array<Reservation> | undefined {
    return this._reservations;
  }

  public set reservations(value: Array<Reservation> | undefined) {
    this._reservations = value;
  }

  public get passagers(): Array<Passager> | undefined {
    return this._passagers;
  }

  public set passagers(value: Array<Passager> | undefined) {
    this._passagers = value;
  }
}
