import { Component, OnInit } from '@angular/core';
import { MissionsService, Mission, Address } from '../../services/missions.service';

@Component({
  selector: 'app-missions',
  templateUrl: './missions.component.html',
  styleUrl: './missions.component.css'
})
export class MissionsComponent implements OnInit {
  missions: Mission[] = [];
  addresses: Address[] = [];
  filteredAddresses: Address[] = [];
  
  selectedMission: Mission | null = null;
  addressInput: string = '';
  duration: number = 0;
  commerce: string = '';
  missionDate: string = new Date().toISOString().split('T')[0];

  constructor(private missionsService: MissionsService) {}

  ngOnInit(): void {
    this.loadMissions();
    this.loadAddresses();
  }

  loadMissions(): void {
    this.missionsService.getAllMissions().subscribe({
      next: (data) => {
        this.missions = data;
      },
      error: (e) => console.error('Error loading missions:', e)
    });
  }

  loadAddresses(): void {
    this.missionsService.getAddresses().subscribe({
      next: (data) => {
        this.addresses = data;
        this.filteredAddresses = [];
      },
      error: (e) => console.error('Error loading addresses:', e)
    });
  }

  filterAddresses(): void {
    this.filteredAddresses = [];
    
    if (!this.addressInput || this.addressInput.trim() === '') {
      return;
    }
    
    const searchTerm = this.addressInput.toLowerCase().trim();
    this.filteredAddresses = this.addresses
      .filter(address =>
        address.nomadresse.toLowerCase().includes(searchTerm)
      )
      .slice(0, 5); // Limit to 5 suggestions
  }

  selectAddress(address: Address): void {
    this.addressInput = `${address.nomadresse}`;
    this.filteredAddresses = [];
  }

  onSubmit(): void {
    if (!this.addressInput || !this.duration || !this.commerce) {
      alert('Please fill in all required fields');
      return;
    }

  }

  resetForm(): void {
    this.selectedMission = null;
    this.addressInput = '';
    this.duration = 0;
    this.commerce = '';
    this.filteredAddresses = [];
  }
}
