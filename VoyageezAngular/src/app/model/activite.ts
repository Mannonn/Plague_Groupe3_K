import { Planete } from './planete';

export class Activite {
  public constructor(
    private _id?: number,
    private _nom?: string,
    private _prix?: number,
    private _planete?: Planete
  ) {}

  public get id(): number | undefined {
    return this._id;
  }

  public set id(value: number | undefined) {
    this._id = value;
  }

  public get nom(): string | undefined {
    return this._nom;
  }

  public set nom(value: string | undefined) {
    this._nom = value;
  }

  public get prix(): number | undefined {
    return this._prix;
  }

  public set prix(value: number | undefined) {
    this._prix = value;
  }

  public get planete(): Planete | undefined {
    return this._planete;
  }

  public set planete(value: Planete | undefined) {
    this._planete = value;
  }
}
