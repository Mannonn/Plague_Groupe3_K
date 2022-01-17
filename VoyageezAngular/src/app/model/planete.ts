import { TypePlanete } from '../enum/type-planete';

export class Planete {
  public constructor(
    private _id?: number,
    private _nom?: string,
    private _type?: TypePlanete
  ) {}

  public get id(): number | undefined {
    return this._id;
  }

  public set id(value: number | undefined) {
    this._id = value;
  }

  public get type(): TypePlanete | undefined {
    return this._type;
  }

  public set type(value: TypePlanete | undefined) {
    this._type = value;
  }

  public get nom(): string | undefined {
    return this._nom;
  }

  public set nom(value: string | undefined) {
    this._nom = value;
  }
}
