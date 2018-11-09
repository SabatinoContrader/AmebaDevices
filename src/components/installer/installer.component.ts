import { Component, OnInit } from "@angular/core";
import { InstallerService } from "src/services/installer.service";
import {Installer} from "../../models/Installer";

@Component({
    selector: 'app-installer',
    templateUrl: './installer.component.html',
    styleUrls: ['./installer.component.css']
  })
  export class InstallerComponent implements OnInit{
    constructor(private installerService: InstallerService ){
      
    }
    ngOnInit(){

    }
    
  }