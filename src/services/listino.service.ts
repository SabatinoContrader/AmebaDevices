import { Injectable } from "@angular/core";
import { Customer } from "src/models/Customer";
import { Observable } from "rxjs";
import { HttpParams, HttpClient } from "@angular/common/http";
import { Listino } from "src/models/Listino";


@Injectable({
    providedIn: 'root'
})

export class ListinoService{

    constructor(private http : HttpClient){}

    newListino(nomeListino:string, anno:string, idManufacturer:string):Observable<Listino>{
        const params = new HttpParams().set("nomeListino",nomeListino).set("anno",anno).set("idManufacturer",idManufacturer);
        return this.http.post<Listino>("http://localhost:8080/Listino/insert", params)
    }
    
}