import { Admin } from './../model/admin';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AuthenticationService } from './authentication.service';

@Injectable({
  providedIn: 'root',
})
export class AdminService {
  private static URL: string = 'http://localhost:8080/voyageez/api/admin';

  constructor(private http: HttpClient, private auth: AuthenticationService) {}

  public getAll(): Observable<Admin[]> {
    return this.http.get<Admin[]>(AdminService.URL, {
      headers: this.auth.headers,
    });
  }

  public getById(id: number): Observable<Admin> {
    return this.http.get<Admin>(AdminService.URL + '/' + id, {
      headers: this.auth.headers,
    });
  }

  public update(admin: Admin): Observable<Admin> {
    return this.http.put<Admin>(AdminService.URL + '/' + admin.id, admin, {
      headers: this.auth.headers,
    });
  }

  public create(admin: Admin): Observable<Admin> {
    const o = {
      login: admin.login,
      password: admin.password,
      enabled: admin.enabled,
    };
    return this.http.post<Admin>(AdminService.URL, o, {
      headers: this.auth.headers,
    });
  }

  public delete(id: number): Observable<void> {
    return this.http.delete<void>(AdminService.URL + '/' + id, {
      headers: this.auth.headers,
    });
  }
}
