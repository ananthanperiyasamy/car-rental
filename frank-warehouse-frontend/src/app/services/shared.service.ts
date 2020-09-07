import { Injectable } from '@angular/core';
import { Subject } from 'rxjs/Subject';
import { Observable } from 'rxjs/Observable';
import { Product } from '../model/product.model';
import { Car } from '../model/car.model';

@Injectable()
export class SharedService { 

  private products : any[];
  filteredcars : Car;
  //private subject: Subject<Product> = new Subject<Product>();

  //getProducts$ = this.subject.asObservable();

  setProducts(products: Product): void {
    if(this.products == undefined){
      this.products =[];
    }
    this.products.push(products);
  }

  getProducts(): any[]{
    return this.products;
  }

  setCar(car : Car): void{
    this.filteredcars = car;
  }

  getCar() : Car{
    return this.filteredcars;
  }
  
}
