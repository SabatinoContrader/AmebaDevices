import { Component, OnInit } from "@angular/core";
import { CustomerService } from "src/services/customer.service";

@Component({
    selector: 'app-customer',
    templateUrl: './customer.component.html',
    styleUrls: ['./customer.component.css']
  })
  export class GestioneCustomerComponent implements OnInit{
    constructor(private customerService: CustomerService ){}
    ngOnInit(){}
  }
  