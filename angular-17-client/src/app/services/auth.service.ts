import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, BehaviorSubject } from 'rxjs';
import { tap } from 'rxjs/operators';
import { EquipageService } from './equipage.service';

const AUTH_API = 'http://localhost:8080/api/auth/';

export interface User {
  matricule: number;
  nomAgent: string;
  prenomAgent: string;
  pouvoir: string;
  secteur: string;
  brigade: string;
}

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private currentUserSubject = new BehaviorSubject<User | null>(null);
  public currentUser$ = this.currentUserSubject.asObservable();
  constructor(private http: HttpClient, private equipageService: EquipageService) {
    const storedUser = localStorage.getItem('user-info');
    if (storedUser) {
      this.currentUserSubject.next(JSON.parse(storedUser));
    }
  }
  login(matricule: string, password: string): Observable<any> {
    // Clear any existing equipage data before login
    this.equipageService.clearEquipage();
    return this.http.post(
      AUTH_API + 'login',
      {
        matricule,
        password,
      }
    ).pipe(
      tap((response: any) => {
        this.currentUserSubject.next(response);
        localStorage.setItem('user-info', JSON.stringify(response));
      })
    );
  }

  logout(): void {
    localStorage.removeItem('user-info');
    this.currentUserSubject.next(null);
    // Clear equipage data when logging out
    this.equipageService.clearEquipage();
  }
  
  getToken(): string | null {
    const user = localStorage.getItem('user-info');
    return user ? 'true' : null;
  }
  getCurrentUser(): User | null {
    return this.currentUserSubject.value;
  }
  isAdmin(): boolean {
    const user = this.getCurrentUser();
    return user ? user.pouvoir === 'admin' : false;
  }
}
