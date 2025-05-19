import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Client } from '../models/client.model';


@Injectable({
  providedIn: 'root'
})
export class ClientService {

  private readonly url = 'http://localhost:8087/clients';
  constructor(private http:HttpClient) { }

  public getClients():Observable<Client[]>{
    return this.http.get<Client[]>(this.url);
  }
}
