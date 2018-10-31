import { Injectable } from "@angular/core";
import { HttpClient, HttpParams } from "@angular/common/http";
import { Customer } from "src/models/Customer";
import { tap, catchError } from 'rxjs/operators';
import {Observable, of, BehaviorSubject} from 'rxjs';

@Injectable({ providedIn: 'root'}) 
export class CustomerService{
    constructor( private http : HttpClient){}

    private handleError<T>(operation = 'operation', result?: T) {
        return (error: any): Observable<T> => {
            console.log(result);
            console.error(error);
            console.log('${operation} failed: ${error.message}');
            return of(result as T);
        };
    }
    login(username:string, password:string):Observable<Customer>{
        const params = new HttpParams().set('username', username).set('password', password);
        return this.http.post<Customer>('http://localhost:8080/user/login',params).
        pipe(tap((response) => console.log("Utente"), catchError(this.handleError("login error", {})))
        );
    }
}