import { Component, OnInit } from "@angular/core";
import { CustomerService } from "src/services/customer.service";

@Component({
    selector: 'app-gestioneCustomer',
    templateUrl: './gestioneCustomer.component.html',
    styleUrls: ['./gestioneCustomer.component.css']
  })
  export class GestioneCustomerComponent implements OnInit{
    constructor(private customerService: CustomerService ){}
    ngOnInit(){
      console.log("sono qua!");
    }
    goToInsert(){
      console.log("sono in insert!");
    }
    goToRead(){
      console.log("leggo");
    }
    goToUpdate(){
      console.log("updato");
    }
    goToDelete(){
      console.log("delitto");
    }
  }
  