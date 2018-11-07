import { Component, OnInit } from "@angular/core";
import { InstallerService } from "src/services/installer.service";
import { Router } from "@angular/router";
import { NewCustomer } from "src/models/NewCustomer";
import { NgForm } from "@angular/forms";

@Component({
    selector: 'app-updateInstaller',
    templateUrl: './updateInstaller.component.html',
    styleUrls: ['./updateInstaller.component.css']
  })
  export class UpdateinstallerComponent implements OnInit{
      public installers: Array<NewCustomer>
      public username:string
      public field:string
      public value:string
    constructor(private installerService: InstallerService, private router:  Router ){
      
    }
    ngOnInit(){
      
    }  
    update(f:NgForm){
        this.username=f.value.usernameSelected;
        this.field=f.value.selected;
        this.value=f.value.value;
        this.router.navigateByUrl("/installerManager")
    }
}