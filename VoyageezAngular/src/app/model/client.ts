import { Compte } from './compte';
import { Passager } from './passager';
import { Reservation } from './reservation';

export class Client extends Compte {
  public constructor(
    protected _login?: any,
    protected _password?: any,
    private _nom?: string,
    private _prenom?: string,
    private _reservations?: Array<Reservation>
  ) {
    super(login, password);
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
}
