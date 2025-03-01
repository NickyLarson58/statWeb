import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { tap } from 'rxjs/operators';

const AUTH_API = 'http://10.10.6.124:8080/api/auth/';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  constructor(private http: HttpClient) {}

  login(matricule: string, password: string): Observable<any> {
    return this.http.post(
      AUTH_API + 'signin',
      {
        matricule,
        password,
      }
    ).pipe(
      tap((response : any) => {
        if (response.accessToken) {
          localStorage.setItem('auth-token', response.accessToken);
          localStorage.setItem('user-info', JSON.stringify(response.user));
        }
      })
    );
  }

  logout(): void {
    localStorage.removeItem('auth-token');
    localStorage.removeItem('user-info');
  }

  getToken(): string | null {
    return localStorage.getItem('auth-token');
  }
}