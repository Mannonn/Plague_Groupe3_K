import { Compte } from './compte';

export class Admin extends Compte {
  public constructor(
    _id?: number,
    _login?: any,
    _password?: any,
    _enabled?: boolean,
    _role?: 'admin'
  ) {
    super(_id, _login, _password, _enabled, 'admin');
  }
}
