import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Intervention {
  id?: number;
  nomInterventions: string;
}

export interface Address {
  id: number;
  nomadresse: string;
}

@Injectable({
  providedIn: 'root'
})
export class InterventionsService {
  private baseUrl = 'http://localhost:8080/api';

  constructor(private http: HttpClient) { }

  getAllInterventions(): Observable<Intervention[]> {
    return this.http.get<Intervention[]>(`${this.baseUrl}/interventions`);
  }

  getAllInfractions(): Observable<Intervention[]> {
    return this.http.get<Intervention[]>(`${this.baseUrl}/infractions`);
  }

  getAddresses(): Observable<Address[]> {
    return this.http.get<Address[]>(`${this.baseUrl}/adresses`);
  }

  createIntervention(intervention: Intervention): Observable<Intervention> {
    return this.http.post<Intervention>(`${this.baseUrl}/interventions`, intervention);
  }
}