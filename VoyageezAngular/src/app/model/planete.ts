import { TypePlanete } from '../enum/type-planete';

export class Planete {
  public constructor(
    private _id?: number,
    private _nom?: string,
    private _typePlanete?: TypePlanete
  ) {}

  public get id(): number | undefined {
    return this._id;
  }

  public set id(value: number | undefined) {
    this._id = value;
  }

  public get typePlanete(): TypePlanete | undefined {
    return this._typePlanete;
  }

  public set race(value: TypePlanete | undefined) {
    this._typePlanete = value;
  }

  public get nom(): string | undefined {
    return this._nom;
  }

  public set nom(value: string | undefined) {
    this._nom = value;
  }
}
