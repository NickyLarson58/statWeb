import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { User } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class EquipageService {
  currentEquipage: User[] | null = null;

  constructor(private http: HttpClient) {
    // Load equipage from localStorage if it exists
    const storedEquipage = localStorage.getItem('current-equipage');
    if (storedEquipage) {
      this.currentEquipage = JSON.parse(storedEquipage);
    }
  }

  createEquipage(users: User[]) {
    this.currentEquipage = users;
    // Store in localStorage
    localStorage.setItem('current-equipage', JSON.stringify(users));
  }

  getEquipage() {
    return this.currentEquipage;
  }

  clearEquipage() {
    this.currentEquipage = null;
    localStorage.removeItem('current-equipage');
  }
}