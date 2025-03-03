import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { EquipageComponent } from './components/equipage/equipage.component';
import { MissionsComponent } from './components/missions/missions.component';
import { InterventionsComponent } from './components/interventions/interventions.component';
import { NotificationComponent } from './components/notification/notification.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    MissionsComponent,
    InterventionsComponent,
    NotificationComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    EquipageComponent
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
