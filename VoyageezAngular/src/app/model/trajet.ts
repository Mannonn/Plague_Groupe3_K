import { DatePipe, Time } from '@angular/common';
import { Planete } from './planete';
import { Vaisseau } from './vaisseau';

export class Trajet {
  public constructor(
    private _id?: number,
    private _dateDepart?: DatePipe,
    private _heureDepart?: Time,
    private _dateArrivee?: DatePipe,
    private _heureArrivee?: Time,
    private _prix?: number,
    private _planeteDepart?: Planete,
    private _planeteArrivee?: Planete,
    private _vaisseau?: Vaisseau
  ) {}

  public get id(): number | undefined {
    return this._id;
  }

  public set id(value: number | undefined) {
    this._id = value;
  }

  public get dateDepart(): DatePipe | undefined {
    return this._dateDepart;
  }

  public set dateDepart(value: DatePipe | undefined) {
    this._dateDepart = value;
  }

  public get heureDepart(): Time | undefined {
    return this._heureDepart;
  }

  public set heureDepart(value: Time | undefined) {
    this._heureDepart = value;
  }

  public get dateArrivee(): DatePipe | undefined {
    return this._dateArrivee;
  }

  public set dateArrivee(value: DatePipe | undefined) {
    this._dateArrivee = value;
  }

  public get heureArrivee(): Time | undefined {
    return this._heureArrivee;
  }

  public set heureArrivee(value: Time | undefined) {
    this._heureArrivee = value;
  }

  public get prix(): number | undefined {
    return this._prix;
  }

  public set prix(value: number | undefined) {
    this._prix = value;
  }

  public get planeteDepart(): Planete | undefined {
    return this._planeteDepart;
  }

  public set planeteDepart(value: Planete | undefined) {
    this._planeteDepart = value;
  }

  public get planeteArrivee(): Planete | undefined {
    return this._planeteArrivee;
  }

  public set planeteArrivee(value: Planete | undefined) {
    this._planeteArrivee = value;
  }

  public get vaisseau(): Vaisseau | undefined {
    return this._vaisseau;
  }

  public set vaisseau(value: Vaisseau | undefined) {
    this._vaisseau = value;
  }
}