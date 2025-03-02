import { Component, OnInit } from '@angular/core';
import { InterventionsService, Intervention, Address } from '../../services/interventions.service';

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
  selectedIntervention: Intervention | null = null;
  addressInput: string = '';
  nombreIntervention: number = 0;
  details: string = '';
  dateIntervention: string = new Date().toISOString().split('T')[0];

  constructor(private interventionsService: InterventionsService) {}

  ngOnInit(): void {
    this.loadInterventions();
    this.loadAddresses();
    this.loadInfractions();
  }

  loadInfractions(): void {
    this.interventionsService.getAllInfractions().subscribe({
      next: (data) => {
        this.infractions = data;
        console.log('Infractions loaded:', data);
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
    this.filteredAddresses = [];
  }

  onSubmit(): void {
    if (!this.selectedIntervention || !this.addressInput || !this.nombreIntervention) {
      alert('Veuillez remplir tous les champs obligatoires');
      return;
    }

    const intervention: Intervention = {
      nomInterventions: this.selectedIntervention.nomInterventions
    };

    this.interventionsService.createIntervention(intervention).subscribe({
      next: () => {
        alert('Intervention enregistrée avec succès');
        this.resetForm();
      },
      error: (e) => {
        console.error('Error creating intervention:', e);
        alert('Erreur lors de l\'enregistrement de l\'intervention');
      }
    });
  }

  resetForm(): void {
    this.selectedIntervention = null;
    this.addressInput = '';
    this.nombreIntervention = 0;
    this.details = '';
    this.dateIntervention = new Date().toISOString().split('T')[0];
    this.filteredAddresses = [];
  }

  showDetailsField(): boolean {
    return this.selectedIntervention?.nomInterventions === 'MAD' || 
           this.selectedIntervention?.nomInterventions === 'CODE DE LA ROUTE';
  }
}
