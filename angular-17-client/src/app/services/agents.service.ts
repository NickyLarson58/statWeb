import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from './auth.service';

const API_URL = 'http://localhost:8080/api/agents';

@Injectable({
  providedIn: 'root'
})
export class AgentsService {
  constructor(private http: HttpClient) {}

  getAllAgents(): Observable<User[]> {
    return this.http.get<User[]>(API_URL);
  }

  getAgentById(id: number): Observable<User> {
    return this.http.get<User>(`${API_URL}/${id}`);
  }

  createAgent(agent: User): Observable<User> {
    return this.http.post<User>(API_URL, agent);
  }

  updateAgent(id: number, agent: User): Observable<User> {
    return this.http.put<User>(`${API_URL}/${id}`, agent);
  }

  deleteAgent(id: number): Observable<any> {
    return this.http.delete(`${API_URL}/${id}`);
  }

  deleteAllAgents(): Observable<any> {
    return this.http.delete(API_URL);
  }
}