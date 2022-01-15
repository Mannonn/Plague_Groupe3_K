export class Compte {
  public constructor(
    protected _id?: number,
    protected _login?: any,
    protected _password?: any,
    protected _enabled?: boolean
  ) {}

  public get id(): number | undefined {
    return this._id;
  }

  public set id(value: number | undefined) {
    this._id = value;
  }

  public get login(): any | undefined {
    return this._login;
  }

  public set login(value: any | undefined) {
    this._login = value;
  }

  public get password(): any | undefined {
    return this._password;
  }

  public set password(value: any | undefined) {
    this._password = value;
  }

  public get enabled(): boolean | undefined {
    return this._enabled;
  }

  public set enabled(value: boolean | undefined) {
    this._enabled = value;
  }
}
