import { Component, OnInit, EventEmitter,Inject } from '@angular/core';

import { FormControl } from '@angular/forms';
import { Observable } from 'rxjs/Observable';
import { map, startWith } from 'rxjs/operators';
import { Product } from 'src/app/model/product.model';

import { AppComponent } from 'src/app/app.component';
import { Car } from 'src/app/model/car.model';
import { Vehicles } from 'src/app/model/Vehicles.model';
import { SharedService } from 'src/app/services/shared.service';
import { MatDialog,MatDialogConfig,MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-welcome',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  wareHouseList: string[] = [];
  params = new Map(); // To hold the parameter filtering
  public tabIndex = 0;
  products: Product[];
  filteredcars : Car;

  constructor(
    private productService: ProductService,
    private appComponent: AppComponent,
    private sharedService: SharedService,
    private dialog: MatDialog) { }

  ngOnInit(): void {
    this.retrieveProducts(); 
  }

  viewDetails(car){
    this.sharedService.setCar(car);
    const dialogRef = this.dialog.open(ViewCarDialog, {
      width: '250px',
      data: {make: car.make, model: car.model,year_model : car.year_model,price : car.price,warhouse : this.wareHouseList[this.tabIndex]}
    });    
  }

  private filter(value: string): string[] {
    const filterValue = value.toLowerCase();
    return this.wareHouseList.filter(option => option.toLowerCase().includes(filterValue));
  }
  
  getWareHouseList() {
    for(const product of this.products) {
      this.wareHouseList.push(product.name);
    }
  }

  retrieveProducts() {
    this.productService.getAll(this.params).subscribe(data => {
      this.products = data.entity;
      this.getWareHouseList();
      this.tabIndex = 0;
      this.filteredcars = this.products[this.tabIndex].cars; 
    },
      error => {
        console.log(error);
      }
    );
  }

  addToCart(product){
    this.sharedService.setProducts(product);
  }

  selectTab() {
      var temp = this.products.filter(product => product.name == this.wareHouseList[this.tabIndex]);
      this.filteredcars = temp[0].cars; 
  }
}

export interface DialogData {
  make: string;
  model: string;
  year_model : string;
  price : string;
  warhouse : string;
}

@Component({
  selector: 'view-car-details',
  templateUrl: 'view-car-details.html',
})
export class ViewCarDialog {

  constructor(
    public dialogRef: MatDialogRef<ViewCarDialog>,
    @Inject(MAT_DIALOG_DATA) public data: DialogData) {}

  onNoClick(): void {
    this.dialogRef.close();
  }

}
