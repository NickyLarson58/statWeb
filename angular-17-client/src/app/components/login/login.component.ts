import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  standalone: true,
  imports: [FormsModule]
})
export class LoginComponent {
  matricule: string = '';
  password: string = '';

  constructor(private router: Router) {}

  onSubmit() {
    // TODO: Implement authentication logic
    console.log('Login attempt with:', { matricule: this.matricule, password: this.password });
  }
}