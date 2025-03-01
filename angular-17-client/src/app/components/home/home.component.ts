import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

interface WeatherData {
  main: {
    temp: number;
    humidity: number;
  };
  weather: Array<{
    main: string;
    description: string;
    icon: string;
  }>;
}

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent implements OnInit {
  time: string = '';
  date: string = '';
  weather: WeatherData | null = null;
  weatherIcon: string = '';
  temperature: number = 0;

  constructor(private http: HttpClient) {
    this.updateTime();
    setInterval(() => this.updateTime(), 1000);
  }

  ngOnInit() {
    this.getWeather();
    // Update weather every 30 minutes
    setInterval(() => this.getWeather(), 1800000);
  }

  updateTime() {
    const now = new Date();
    this.time = now.toLocaleTimeString('fr-FR', { hour: '2-digit', minute: '2-digit' });
    this.date = now.toLocaleDateString('fr-FR', { weekday: 'long', day: 'numeric', month: 'long', year: 'numeric' });
  }

  getWeather() {
    const API_KEY = '06aaccd26356164c786045bd4faa3813';
    const CITY = 'La Ciotat';
    const COUNTRY = 'FR';
    const url = `https://api.openweathermap.org/data/2.5/weather?q=${CITY},${COUNTRY}&appid=${API_KEY}&units=metric&lang=fr`;

    this.http.get<WeatherData>(url).subscribe(data => {
      this.weather = data;
      this.weatherIcon = `http://openweathermap.org/img/w/${data.weather[0].icon}.png`;
      this.temperature = Math.round(data.main.temp);
    });
  }
}
