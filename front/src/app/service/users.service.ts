import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Users } from '../models/users';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UsersService {

  userURL = 'http://localhost:8090/user/';
  constructor(private httpClient:HttpClient){}
  public lista(): Observable<Users[]>{
    return this.httpClient.get<Users[]>(this.userURL + 'lists');
  }

  public detail(id: number): Observable<Users> {
    return this.httpClient.get<Users>(this.userURL + `detail/${id}`);
  }

  public detailName(nombre: string): Observable<Users> {
    return this.httpClient.get<Users>(this.userURL + `detailname/${nombre}`);
  }

  public save(user: Users): Observable<any> {
    return this.httpClient.post<any>(this.userURL + 'create', user);
  }

  public update(id: number, user: Users): Observable<any> {
    return this.httpClient.put<any>(this.userURL + `update/${id}`, user);
  }

  public delete(id: number): Observable<any> {
    return this.httpClient.delete<any>(this.userURL + `delete/${id}`);
  }
}
