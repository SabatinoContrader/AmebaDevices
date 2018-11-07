import { Injectable } from "@angular/core";
import { Observable, of } from "rxjs";
import { HttpClient, HttpParams } from "@angular/common/http";
import {NewCustomer} from "../models/NewCustomer";

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

    newInstaller(userRole:string, name:string, 
      surname:string, email:string, username:string, password:string ): Observable<NewCustomer>{
      
        const params = new HttpParams().set('userRole', userRole).
         set('name', name).set('surname', surname).set('email', email).set('username', username).set('password', password);
      
      return this.http.post<NewCustomer>('http://localhost:8080/Customer/new', params); 

      }

      readAll() : Observable<Array<NewCustomer>>{
        return this.http.get<Array<NewCustomer>>('http://localhost:8080/Customer/readInstaller');
        }

        update(nome:string, 
          cognome:string, email:string, username:string, oldUsername: string): Observable<NewCustomer>{
              console.log("in update "+ nome+"-"+ cognome+"-"+email+"-"+username);
              if(nome!="null"){
              const params = new HttpParams().set('nome', nome).set('oldUsername',oldUsername);
              return this.http.post<NewCustomer>('http://localhost:8080/Customer/edit', params); 
              }else if(cognome!="null"){
              const params= new HttpParams().set('cognome',cognome).set('oldUsername',oldUsername);
              return this.http.post<NewCustomer>('http://localhost:8080/Customer/edit', params); 
              }else if(email!=null){
              const params= new HttpParams().set('email',email).set('oldUsername',oldUsername);
              return this.http.post<NewCustomer>('http://localhost:8080/Customer/edit', params); 
              }else {
                  const params= new HttpParams().set('password',username).set('oldUsername',oldUsername);
                  return this.http.post<NewCustomer>('http://localhost:8080/Customer/edit', params); 
              }
  
      }
  }