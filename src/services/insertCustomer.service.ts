import { Injectable } from "@angular/core";
import { Observable, of } from "rxjs";
import { HttpClient, HttpParams } from "@angular/common/http";
import { NewCustomer } from "src/models/NewCustomer";

@Injectable({
    providedIn: 'root'
  })
  export class InsertCustomerService{
    constructor(private http: HttpClient) { }

    private handleError<T>(operation = 'operation', result?: T) {
      return (error: any): Observable<T> => {
        console.error(error);
        console.log('${operation} failed: ${error.message}');
        return of(result as T);
      };
    }
    newCustomer(userRole:string, name:string, 
      surname:string, email:string, username:string, password:string ): Observable<NewCustomer>{
        console.log("inserisco nuovo customer con "+ name+ "- "+surname+ "-"+email+"-"+username+"-"+password);

        const params = new HttpParams().set('userRole', userRole).
         set('name', name).set('surname', surname).set('email', email).set('username', username).set('password', password);
      
      return this.http.post<NewCustomer>('http://localhost:8080/Customer/new', params); 

  }

  }