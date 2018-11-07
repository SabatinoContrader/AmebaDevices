import { Injectable } from "@angular/core";
import { Observable, of } from "rxjs";
import { HttpClient, HttpParams } from "@angular/common/http";
import {Installer} from "../models/Installer";

@Injectable({
    providedIn: 'root'
  })
  export class InstallerService{
    constructor(private http: HttpClient) { }

    private handleError<T>(operation = 'operation', result?: T) {
      return (error: any): Observable<T> => {
        console.error(error);
        console.log('${operation} failed: ${error.message}');
        return of(result as T);
      };
    }
  }