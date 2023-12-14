import {Component, OnInit} from '@angular/core';
import {HttpClient, HttpClientModule} from "@angular/common/http";
import {CommonModule} from "@angular/common";

@Component({
  selector: 'app-clients',
  standalone: true,
  imports: [HttpClientModule, CommonModule],
  templateUrl: './clients.component.html',
  styleUrl: './clients.component.css'
})
export class ClientsComponent  implements OnInit{
  clients: any;
  constructor(private http: HttpClient) {
  }
   ngOnInit() {
    this.http.get('http://localhost:8888/CLIENT-SERVICE/clients').subscribe({
      next: data => {
        this.clients = data;

      },
      error: error => {
        console.error('There was an error!', error);
      }
    }  );
   }
}
