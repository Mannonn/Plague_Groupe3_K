export class Compte {
  public constructor(
    private _id?: number,
    private _login?: any,
    private _password?: any,
    private _enabled?: boolean,
    private _role?: string
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

  public get role(): string | undefined {
    return this._role;
  }

  public set role(value: string | undefined) {
    this._role = value;
  }
}
