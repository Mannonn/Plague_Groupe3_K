import { Compte } from './compte';

export class Admin extends Compte {
  public constructor(protected _login?: any, protected _password?: any) {
    super(login, password);
  }
}
