import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HttpHeaders, HttpParams } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { tap, catchError } from 'rxjs/operators';
import { Customer } from '../models/Customer';
import { Building } from '../models/Building';


@Injectable()
export class BuildingService {
    baseUrl = 'http://localhost:8080/';

    constructor(private http: HttpClient) {}

    private handleError<T>(operation = 'operation', result?: T) {
        return (error: any): Observable<T> => {
          console.error(error);
          console.log('${operation} failed: ${error.message}');
          return of(result as T);
        };
    }

    getBuildingsByInstaller():Observable<Building[]> {
        //let installer: Customer = JSON.parse(sessionStorage.getItem('user'));
        let httpHeaders = new HttpHeaders().set('Accept', 'application/json');
        let httpParams = new HttpParams().set('installer', 'rinaldoinstaller');
        let url: string = this.baseUrl + 'Building/installer';
	
        return this.http.get<Building[]>(url, {
            headers: httpHeaders,
            params: httpParams, 
            responseType: 'json'
        })
        .pipe(
            tap(
                (response) => response,
                catchError(this.handleError("get all building by Installer Error", {}))
                )
            );
    }

}