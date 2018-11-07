import { Component, OnInit } from "@angular/core";
import { CustomerService } from "src/services/customer.service";
import { Router } from "@angular/router";
import { NgForm } from "@angular/forms";
import { NewCustomer } from "src/models/NewCustomer";
import { Customer } from "src/models/Customer";
import { identifierModuleUrl } from "@angular/compiler";

@Component({
    selector: 'app-updateCustomer',
    templateUrl: './updateCustomer.component.html',
    styleUrls: ['./updateCustomer.component.css']
})
export class UpdateCustomerComponent implements OnInit{
    public customers: Array<NewCustomer>;
    public customer: Customer;
    public field : string;
    public username : string;
    public newValue : string;
    constructor(private customerService: CustomerService, private router: Router){
        
    }
    ngOnInit() {
        this.customerService.readAll().subscribe((response) => {
            this.customers = response;
            console.log("la size è "+ this.customers.length);
        });
    }
    update(f:NgForm){
        console.log("l'username selezionato è "+f.value.usernameSelected);
        this.username=f.value.usernameSelected;
        console.log("il campo selezionato è "+f.value.fieldSelected);
       this.field=f.value.fieldSelected;
        console.log("il valore inserito è "+ f.value.value);
        this.newValue=f.value.value;
        this.customerService.readByUsername(this.username).subscribe((response) => {
            console.log("sono qua con "+ response.username);
            if (response != null) {
                if(this.field=="1"){
                   this.customerService.updateCustomer(this.newValue,null,null,null,this.username).subscribe((response) => {
                });
                }else if(this.field=="2"){
                    this.customerService.updateCustomer(null,this.newValue,null,null,this.username).subscribe((response) => {
                        console.log("ho fatto l'update");
                });
                }else if(this.field=="3"){
                    this.customerService.updateCustomer(null,null,this.newValue,null,this.username).subscribe((response) => {
                });
                }
                else{
                    this.customerService.updateCustomer(null,null,null,this.newValue,this.username).subscribe((response) => {
                    });
                }
             }
        });
        console.log("il customer selezionato è "+ this.customer.username);
    }
}