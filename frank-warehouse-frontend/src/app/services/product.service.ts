import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Product } from '../model/product.model';
import { Observable, of } from 'rxjs';

const baseUrl = 'http://localhost:8888/api/products';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private http: HttpClient) { }

  getAll(params): Observable<Product[]>  {  
    return this.http.get<Product[]>(baseUrl);
  }

  get(id) {
    return this.http.get(`${baseUrl}/${id}`);
  }
  
}
