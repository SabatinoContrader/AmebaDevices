import { Component, OnInit } from "@angular/core";
import { InsertCustomerService } from "src/services/insertCustomer.service";
import { NgForm } from "@angular/forms";
import { Router } from "@angular/router";

@Component({
    selector: 'app-insertCustomer',
    templateUrl: './insertCustomer.component.html',
    styleUrls: ['./insertCustomer.component.css']
  })
  export class InsertCustomerComponent implements OnInit{
    constructor(private insertCustomerService: InsertCustomerService , private router:  Router){

    }
    ngOnInit(){

    }
    register(f:NgForm){
   
      this.insertCustomerService.newCustomer("2",f.value.nome,f.value.cognome,f.value.email,f.value.username,f.value.password).subscribe((response) => {
        if (response != null) {
         console.log(response.username);
this.router.navigateByUrl("/gestioneCustomer");
        }
        
    });
  
    }
  }