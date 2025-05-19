import { Component } from '@angular/core';
import { ClientService } from '../../shared/services/client.service';
import { Router } from '@angular/router';
import { catchError, Observable, throwError } from 'rxjs';
import { Client } from '../../shared/models/client.model';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-client',
  imports: [CommonModule],
  standalone:true,
  templateUrl: './client.component.html',
  styleUrl: './client.component.css'
})
export class ClientComponent {

  constructor(private clientService: ClientService, private router:Router){

  }

  clients$: Observable<Client[]> | undefined;
  errorMessage: string | null = null;
  

  ngOnInit(): void {
    this.clients$ = this.clientService.getClients().pipe(
      catchError(err => {
        this.errorMessage = err?.message;
        return throwError(() => err);
      })
    );
  }

  
}
