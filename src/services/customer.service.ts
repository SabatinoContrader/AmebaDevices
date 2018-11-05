import { Injectable } from "@angular/core";
import { HttpClient, HttpParams } from "@angular/common/http";
import { Customer } from "src/models/Customer";
import { NewCustomer } from "src/models/NewCustomer";

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

    newCustomer(userRole:string, name:string, 
        surname:string, email:string, username:string, password:string ): Observable<NewCustomer>{
            const params = new HttpParams().set('userRole', userRole);
            params.set('name', name);
            params.set('surname', surname);
            params.set('email', email);
            params.set('username', username);
            params.set('password', password);
        
        return this.http.post<NewCustomer>('http://localhost:8080/Customer/new', params); 

    }

    readOne(customerId:string): Observable<Customer>{
        return this.http.get<Customer>('http://localhost:8080/Customer?customerId='+customerId);
    }
    
    delete(customerId:string):Observable<boolean>{
        return this.http.get<boolean>('http://localhost:8080/Customer/delete?customerId='+customerId);
    }


    updateCustomer(customerId:string, nome:string, 
        cognome:string, email:string, username:string): Observable<Customer>{
            const params = new HttpParams().set('customerId', customerId);
            params.set('nome', nome);
            params.set('cognome', cognome);
            params.set('email', email);
            params.set('username', username);
        
        return this.http.post<Customer>('http://localhost:8080/Customer/edit', params); 

    }




}