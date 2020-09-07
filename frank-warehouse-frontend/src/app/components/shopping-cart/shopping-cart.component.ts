import { Component, OnInit, OnDestroy, Inject } from '@angular/core';
import { Observable } from 'rxjs';
import { DataSource } from '@angular/cdk/table';
import { Product } from 'src/app/model/product.model';
import { AppComponent } from 'src/app/app.component';
import { SharedService } from 'src/app/services/shared.service';
import { MatDialogRef, MAT_DIALOG_DATA, MatDialog} from '@angular/material/dialog';



@Component({
  selector: 'app-shopping-cart',
  templateUrl: './shopping-cart.component.html',
  styleUrls: ['./shopping-cart.component.css'] 
})
export class ShoppingCartComponent implements OnInit, OnDestroy {

  cartProducts : any[];
  totalprice: number = 0;

  constructor( private appComponent: AppComponent,
    private sharedService: SharedService,
    private dialog: MatDialog) { } 
  //public event: EventEmitter<any> = new EventEmitter();
  
  ngOnInit(): void {
    this.cartProducts = this.sharedService.getProducts();
    this.cartProducts.forEach( (element) => {
      this.totalprice = this.totalprice + parseInt(element.price);
  });
  }

  ngOnDestroy(): void { 
  }
  checkout() : void{
    const dialogRef = this.dialog.open(CheckOutDialog, {
      width: '250px',
      data: {total: this.totalprice}
    });
  }
  step = 0;
  setStep(index: number) {
    this.step = index;
  }
}

export interface DialogData {
  total: string;
}

@Component({
  selector: 'check-out-details',
  templateUrl: 'check-out-details.html',
})
export class CheckOutDialog { 

  constructor(
    public dialogRef: MatDialogRef<CheckOutDialog>,
    @Inject(MAT_DIALOG_DATA) public data: DialogData) {}

  onNoClick(): void {
    this.dialogRef.close();
  }

}

