import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-navigation',
  templateUrl: './navigation.component.html',
  styleUrl: './navigation.component.css'
})
export class NavigationComponent {
  constructor(private authService: AuthService, private router: Router) {}

  get isLoginPage(): boolean {
    return this.router.url === '/login';
  }

  logout(): void {
    // Clear user data and crew information
    this.authService.logout();
    this.router.navigate(['/login']);
  }
}