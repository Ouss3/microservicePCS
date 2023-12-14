import {Component, OnInit} from '@angular/core';
import {HttpClient, HttpClientModule} from "@angular/common/http";
import {CommonModule, NgForOf, NgIf} from "@angular/common";

@Component({
  selector: 'app-sales',
  standalone: true,
  imports: [
    HttpClientModule, CommonModule,
    NgForOf,
    NgIf
  ],
  templateUrl: './sales.component.html',
  styleUrl: './sales.component.css'
})
export class SalesComponent implements OnInit{
  sales: any;
  constructor(private http: HttpClient) {
  }
   ngOnInit() {
      this.http.get('http://localhost:8888/SALE-SERVICE/sales').subscribe({
        next: data => {
          this.sales = data;
        },
        error: error => {
          console.error('There was an error!', error);
        }
      });
   }

}
