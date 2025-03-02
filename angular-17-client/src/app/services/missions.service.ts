import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Mission {
  id: number;
  nomMission: string;
}

export interface Address {
  id: number;
  nomadresse: string;
}

@Injectable({
  providedIn: 'root'
})
export class MissionsService {
  private baseUrl = 'http://localhost:8080/api';

  constructor(private http: HttpClient) {}

  getAllMissions(): Observable<Mission[]> {
    return this.http.get<Mission[]>(`${this.baseUrl}/missions`);
  }

  getAddresses(): Observable<Address[]> {
    return this.http.get<Address[]>(`${this.baseUrl}/adresses`);
  }

  createMission(mission: Omit<Mission, 'id'>): Observable<Mission> {
    return this.http.post<Mission>(`${this.baseUrl}/missions`, mission);
  }

  updateMission(id: number, mission: Omit<Mission, 'id'>): Observable<Mission> {
    return this.http.put<Mission>(`${this.baseUrl}/missions/${id}`, mission);
  }

  deleteMission(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/missions/${id}`);
  }
}