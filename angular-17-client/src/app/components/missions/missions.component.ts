import { Component, OnInit } from '@angular/core';
import { MissionsService, Mission, Address } from '../../services/missions.service';
import { NotificationService } from '../../services/notification.service';
import { Router } from '@angular/router';
import { EquipageService } from '../../services/equipage.service';

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
  isValidAddress: boolean = false;
  selectedAddress: Address | null = null;

  constructor(private missionsService: MissionsService, private notificationService: NotificationService, private router: Router, private equipageService: EquipageService) {}

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
    this.isValidAddress = false;
    
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
    this.addressInput = address.nomadresse;
    this.selectedAddress = address;
    this.filteredAddresses = [];
    this.isValidAddress = true;
  }

  onSubmit(): void {
    if (!this.selectedMission || !this.isValidAddress || !this.selectedAddress || this.duration <= 0 || (this.selectedMission.nomMission === '' && !this.commerce)) {
      this.notificationService.error('Veuillez sélectionner des valeurs valides dans les listes suggérées et remplir tous les champs requis');
      return;
    }

    const missionData = {
      idMission: this.selectedMission.idMission,
      dateMission: `${this.missionDate}T00:00:00`,
      nomMission: this.selectedMission.nomMission,
      duree: this.duration,
      commerce: this.commerce,
      idAdresse: this.selectedAddress.idadresse,
      agents: this.equipageService.getEquipage()
    };
    
    this.missionsService.createMissionStat(missionData).subscribe({
      next: () => {
        this.notificationService.success('Mission enregistrée avec succès');
        this.resetForm();
        this.router.navigate(['/home']);
      },
      error: (e) => {
        console.error('Error creating mission:', e);
        this.notificationService.error('Erreur lors de l\'enregistrement de la mission');
      }
    });
  }

  resetForm(): void {
    this.selectedMission = null;
    this.addressInput = '';
    this.duration = 0;
    this.commerce = '';
    this.filteredAddresses = [];
    this.isValidAddress = false;
    this.selectedAddress = null;
  }
}
