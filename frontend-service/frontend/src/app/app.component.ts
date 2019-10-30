import { Component } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  rockets: Rocket[] = [];

  constructor(
    private http: HttpClient){}

  startRocket(): void {
    console.log('Starting new rocker ...')
    this.http.get<Rocket[]>('api').subscribe(rockets => {this.rockets=rockets.reverse();});
  }
}

class Rocket{
  constructor(private id: String,
     private host: String,
      private timestamp: String){}
}
