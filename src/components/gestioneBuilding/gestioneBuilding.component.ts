import { Component, OnInit } from "@angular/core";
import { BuildingService } from "src/services/building.service";
import { Router } from "@angular/router";
import { NgForm } from "@angular/forms";

@Component({
    selector:'app-gestioneBuilding',
    templateUrl: './gestioneBuilding.component.html',
    styleUrls: ['./gestioneBuilding.component.css']
})

export class GestioneBuildingComponent implements OnInit{

    constructor(private buildingService:BuildingService, private router:Router){

    }

    ngOnInit(){
        //inizializzo variabili
    }
}


