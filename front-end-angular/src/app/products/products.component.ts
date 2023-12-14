import {Component, OnInit} from '@angular/core';
import {CommonModule, NgForOf, NgIf} from "@angular/common";
import {HttpClient, HttpClientModule} from "@angular/common/http";

@Component({
  selector: 'app-products',
  standalone: true,
    imports: [HttpClientModule, CommonModule,
        NgForOf,
        NgIf
    ],
  templateUrl: './products.component.html',
  styleUrl: './products.component.css'
})
export class ProductsComponent implements OnInit{
  products: any;
  constructor(private http: HttpClient) {
  }
   ngOnInit() {
     this.http.get('http://localhost:8888/PRODUCT-SERVICE/products').subscribe({
       next: data => {
         this.products = data;

       },
       error: error => {
         console.error('There was an error!', error);
       }
     });
   }

}
