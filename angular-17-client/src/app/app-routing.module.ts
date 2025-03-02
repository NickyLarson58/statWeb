import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { inject } from '@angular/core';
import { AuthService } from './services/auth.service';
import { Router } from '@angular/router';
import { EquipageComponent } from './components/equipage/equipage.component';
import { MissionsComponent } from './components/missions/missions.component';
import { InterventionsComponent } from './components/interventions/interventions.component';

export const authGuard = () => {
  const authService = inject(AuthService);
  const router = inject(Router);

  if (authService.getToken()) {
    return true;
  }

  return router.parseUrl('/login');
};

const routes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full' },
  { path: 'home', component: HomeComponent, canActivate: [authGuard] },
  { path: 'createEquip', component: EquipageComponent, canActivate: [authGuard] },
  { path: 'missions', component: MissionsComponent, canActivate: [authGuard] },
  { path: 'interventions', component: InterventionsComponent, canActivate: [authGuard] },
  { path: 'login', component: LoginComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
