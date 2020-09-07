import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { Component } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MaterialModule } from './material.module';
import {FlexLayoutModule} from '@angular/flex-layout';
import { ProductService } from './services/product.service';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { HomeComponent, ViewCarDialog } from './components/home/home.component';
import { ShoppingCartComponent, CheckOutDialog } from './components/shopping-cart/shopping-cart.component';
import { SharedService } from './services/shared.service';


@NgModule({
  declarations: [ 
    AppComponent,
    ShoppingCartComponent, 
    HomeComponent, ViewCarDialog,CheckOutDialog
  ],
  imports: [  
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MaterialModule,
    FlexLayoutModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [ProductService,SharedService],
  bootstrap: [AppComponent], 
  entryComponents: [ViewCarDialog,CheckOutDialog
  ]
})
export class AppModule { }
