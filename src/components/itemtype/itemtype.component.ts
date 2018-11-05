import { Component, OnInit } from "@angular/core";
import { ItemtypeService } from "src/services/itemtype.service";

@Component({
    selector: 'app-itemtype',
    templateUrl: './itemtype.component.html',
    styleUrls: ['./itemtype.component.css']
  })
  export class ItemtypemanagerComponent implements OnInit{
    constructor(private itemtypeService: ItemtypeService ){

    }
    ngOnInit(){

    }
    
  }