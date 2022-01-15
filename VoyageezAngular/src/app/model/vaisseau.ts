export class Vaisseau {
  public constructor(
    private _id?: number,
    private _nom?: string,
    private _capacite?: number,
    private _capitaine?: string
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

  public get capacite(): number | undefined {
    return this._capacite;
  }

  public set capacite(value: number | undefined) {
    this._capacite = value;
  }

  public get capitaine(): string | undefined {
    return this._capitaine;
  }

  public set capitaine(value: string | undefined) {
    this._capitaine = value;
  }
}
