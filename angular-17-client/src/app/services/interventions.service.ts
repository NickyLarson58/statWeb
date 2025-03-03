import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from './auth.service';

export interface Intervention {
    idInterventions?: number;
    nomInterventions: string;
  }

export interface CreatedStatIntervention {
  idIntervention: number;
  dateIntervention: string;
  nomInterventions: string;
  nombreIntervention: number;
  idAdresse: number;
  idMad?: number;
  idInfraction?: number;
  agents: User[] | null;
}

export interface Address {
  idadresse: number;
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

  getAllInfractions(): Observable<any[]> {
    return this.http.get<any[]>(`${this.baseUrl}/infractions`);
  }

  getAllMad(): Observable<any[]> {
    return this.http.get<any[]>(`${this.baseUrl}/mad`);
  }

  getAddresses(): Observable<Address[]> {
    return this.http.get<Address[]>(`${this.baseUrl}/adresses`);
  }

  createIntervention(createdStatIntervention: CreatedStatIntervention): Observable<Intervention> {
    return this.http.post<Intervention>(`${this.baseUrl}/interventions`, createdStatIntervention);
  }
}