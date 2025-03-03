import { Component, OnInit } from '@angular/core';
import { InterventionsService, Intervention, Address, CreatedStatIntervention } from '../../services/interventions.service';
import { Route, Router } from '@angular/router';
import { EquipageService } from '../../services/equipage.service';
import { NotificationService } from '../../services/notification.service';

@Component({
  selector: 'app-interventions',
  templateUrl: './interventions.component.html',
  styleUrl: './interventions.component.css'
})
export class InterventionsComponent implements OnInit {
  interventions: Intervention[] = [];
  addresses: Address[] = [];
  filteredAddresses: Address[] = [];
  infractions: any[] = [];
  filteredInfractions: any[] = [];
  mad: any[] = [];
  filteredMad: any[] = [];
  selectedIntervention: Intervention | null = null;
  addressInput: string = '';
  selectedAdress: Address | null = null;
  nombreIntervention: number = 0;
  detailsInfraction: string = '';
  detailsMad: string = '';
  dateIntervention: string = new Date().toISOString().split('T')[0];
  isValidAddress: boolean = false;
  isValidInfraction: boolean = false;
  isValidMad: boolean = false;
  selectedMad: any | null = null;
  selectedInfraction: any | null = null;

  constructor(private interventionsService: InterventionsService, private router: Router, private equipageService: EquipageService, private notificationService: NotificationService) {}

  ngOnInit(): void {
    this.loadInterventions();
    this.loadAddresses();
    this.loadInfractions();
    this.loadMad();
  }

  loadInfractions(): void {
    this.interventionsService.getAllInfractions().subscribe({
      next: (data) => {
        this.infractions = data;
      },
      error: (e) => console.error('Error loading infractions:', e)
    });
  }

  loadMad(): void {
    this.interventionsService.getAllMad().subscribe({
      next: (data) => {
        this.mad = data;
      },
      error: (e) => console.error('Error loading infractions:', e)
    });
  }

  loadInterventions(): void {
    this.interventionsService.getAllInterventions().subscribe({
      next: (data) => {
        this.interventions = data;
      },
      error: (e) => console.error('Error loading interventions:', e)
    });
  }

  loadAddresses(): void {
    this.interventionsService.getAddresses().subscribe({
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
      .slice(0, 5);
  }

  selectAddress(address: Address): void {
    this.addressInput = address.nomadresse;
    this.selectedAdress = address;
    this.filteredAddresses = [];
    this.isValidAddress = true;
  }

  onSubmit(): void {
    if (!this.selectedIntervention || !this.isValidAddress || this.nombreIntervention === undefined || !this.dateIntervention || !this.selectedAdress ||
        (this.selectedIntervention.nomInterventions === 'CODE DE LA ROUTE' && !this.isValidInfraction) ||
        (this.selectedIntervention.nomInterventions === 'MAD' && !this.isValidMad)) {
      this.notificationService.error('Veuillez sélectionner des valeurs valides dans les listes suggérées');
      return;
    }

    const createdStatIntervention: CreatedStatIntervention = {
      idIntervention: this.selectedIntervention.idInterventions!,
      dateIntervention: `${this.dateIntervention}T00:00:00`,
      nomInterventions: this.selectedIntervention.nomInterventions,
      nombreIntervention: this.nombreIntervention,
      idAdresse: this.selectedAdress.idadresse,
      agents: this.equipageService.getEquipage()
    };

    if(this.selectedIntervention.nomInterventions === 'CODE DE LA ROUTE'){
      createdStatIntervention.idInfraction = this.selectedInfraction.id_infraction;
    }else if(this.selectedIntervention.nomInterventions === 'MAD'){
      createdStatIntervention.idMad = this.selectedMad.id_mad;
    }
    this.interventionsService.createIntervention(createdStatIntervention).subscribe({
      next: () => {
        this.notificationService.success('Intervention enregistrée avec succès');
        this.resetForm();
        this.router.navigate(['/home']);
      },
      error: (e) => {
        console.error('Error creating intervention:', e);
        this.notificationService.error('Erreur lors de l\'enregistrement de l\'intervention');
      }
    });
  }

  resetForm(): void {
    this.selectedIntervention = null;
    this.addressInput = '';
    this.selectedAdress = null;
    this.nombreIntervention = 0;
    this.detailsInfraction = '';
    this.detailsMad = '';
    this.dateIntervention = new Date().toISOString().split('T')[0];
    this.filteredAddresses = [];
    this.isValidAddress = false;
    this.isValidInfraction = false;
    this.isValidMad = false;
    this.selectedInfraction = null;
    this.selectedMad = null;
  }

  filterInfractions(): void {
    this.filteredInfractions = [];
    this.isValidInfraction = false;
    
    if (!this.detailsInfraction || this.detailsInfraction.trim() === '') {
      return;
    }
    
    const searchTerm = this.detailsInfraction.toLowerCase().trim();
    this.filteredInfractions = this.infractions
      .filter(infraction =>
        infraction.libelle.toLowerCase().includes(searchTerm) || infraction.natinf == searchTerm
      )
      .slice(0, 5);
  }

  selectInfraction(infraction: any): void {
    this.detailsInfraction = infraction.libelle;
    this.selectedInfraction = infraction;
    this.filteredInfractions = [];
    this.isValidInfraction = true;
  }

  filterMad(): void {
    this.filteredMad = [];
    this.isValidMad = false;
    
    if (!this.detailsMad || this.detailsMad.trim() === '') {
      return;
    }
    
    const searchTerm = this.detailsMad.toLowerCase().trim();
    this.filteredMad = this.mad
      .filter(mad =>
        mad.libelle.toLowerCase().includes(searchTerm) || mad.natinf == searchTerm
      )
      .slice(0, 5);
  }

  selectMad(mad: any): void {
    this.detailsMad = mad.libelle;
    this.filteredMad = [];
    this.selectedMad = mad;
    this.isValidMad = true;
  }
}
