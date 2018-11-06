import { Injectable } from "@angular/core";
import { Observable, of } from "rxjs";
import { HttpClient, HttpParams } from "@angular/common/http";
import {ItemType} from "../models/ItemType";

@Injectable({
    providedIn: 'root'
  })
  export class ItemtypeService{
    constructor(private http: HttpClient) { }

    private handleError<T>(operation = 'operation', result?: T) {
      return (error: any): Observable<T> => {
        console.error(error);
        console.log('${operation} failed: ${error.message}');
        return of(result as T);
      };
    }

    MyitemTypeList(itemTypeId:number): Observable<any>{
    return this.http.get<any>('http://localhost:8080/ItemType?itemTypeId='+itemTypeId);
    }

    deleteItemType(itemTypeId: number): Observable<any>{
      return this.http.delete<boolean>('http://localhost:8080/ItemType/delete?itemTypeId='+itemTypeId);
    }

    addNewItemType(categoria:string,modello:string,marca:string,descrizione:string):  Observable<ItemType>{
      var item = new ItemType(0,categoria,modello,marca,descrizione);
      return this.http.post<ItemType>('http://localhost:8080/ItemType/new', item);
    }

    updateItemType(categoria:string,modello:string,marca:string,descrizione:string): Observable<ItemType>{
      var item: ItemType = new ItemType(0,categoria,modello,marca,descrizione);
      return this.http.post<ItemType>('http://localhost:8080/ItemType/edit', item);
    }
  }