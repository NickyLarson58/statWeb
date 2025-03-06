import { Component } from '@angular/core';
import { AgentsService } from '../../services/agents.service';
import { User, AuthService } from '../../services/auth.service';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { debounceTime, distinctUntilChanged } from 'rxjs/operators';
import { EquipageService } from '../../services/equipage.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-equipage',
  templateUrl: './equipage.component.html',
  styleUrl: './equipage.component.css',
  imports: [FormsModule, CommonModule],
  standalone: true
})
export class EquipageComponent {
  agents: User[] = [];
  filteredAgents: User[] = [];
  selectedAgents: (User | null)[] = [null, null, null, null];
  searchTerm: string = '';

  constructor(
    private agentsService: AgentsService, 
    private equipageService: EquipageService, 
    private route: Router,
    private authService: AuthService
  ) { 
    // Récupérer l'utilisateur connecté
    let currentUser: User | null = null;
    this.authService.currentUser$.subscribe(user => {
      currentUser = user;
    });

    this.agentsService.getAllAgents().subscribe(
      (data) => {
        this.agents = this.sortAgents(data);
        this.filteredAgents = [...this.agents].sort((a, b) => 
          a.nomAgent.localeCompare(b.nomAgent)
        );
        
        // Sélectionner automatiquement l'agent connecté dans le premier menu déroulant
        if (currentUser) {
          const connectedAgent = this.filteredAgents.find(agent => 
            agent.nomAgent === currentUser?.nomAgent && 
            agent.prenomAgent === currentUser?.prenomAgent
          );
          
          if (connectedAgent) {
            this.selectedAgents[0] = connectedAgent;
          }
        }
      }
    );
  }

  private sortAgents(agents: User[]): User[] {
    return agents.sort((a, b) => {
      if (a.matricule < b.matricule) return -1;
      if (a.matricule > b.matricule) return 1;
      return 0;
    });
  }

  getAvailableAgents(currentIndex: number): User[] {
    return this.filteredAgents.filter(agent => 
      !this.selectedAgents.some((selected, index) => 
        index !== currentIndex && selected?.matricule === agent.matricule
      )
    );
  }

  onAgentSelect(index: number, agent: User | null): void {
    this.selectedAgents[index] = agent;
  }

  isEquipageValid(): boolean {
    return this.selectedAgents.filter(agent => agent !== null).length >= 1;
  }

  createEquipage(): void {
    if (this.isEquipageValid()) {
      const validAgents = this.selectedAgents.filter((agent): agent is User => agent !== null);
      // TODO: Implement the actual team creation logic here
      this.equipageService.createEquipage(validAgents);
      this.route.navigate(['/home']);
    }
  }
}
