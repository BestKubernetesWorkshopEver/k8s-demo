import { Component, ViewChild, ElementRef } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  rockets: Rocket[] = [];
  user: string;
  password: string;

  @ViewChild('alert', { static: true }) alert: ElementRef;

    constructor(
    private http: HttpClient){}

  startRocket(): void {
    console.log('Starting new rocker ...')
    console.log(this.user+' '+this.password)

    let headers = new HttpHeaders();
    headers = headers.append("Authorization", "Basic " + btoa(this.user+':'+this.password));
    const httpOptions = {
      headers: headers
      }
    
    this.alert.nativeElement.classList.remove('show');
    this.http.get<Rocket[]>('api', httpOptions).subscribe(
      rockets => {
                this.rockets=rockets.reverse();
                }, 
      error => { console.log('Error happend');
                this.alert.nativeElement.classList.add('show');
                });
  }

  closeAlert() {
    this.alert.nativeElement.classList.remove('show');
  }
}

class Rocket{
  constructor(private id: String,
     private host: String,
      private timestamp: String){}
}
