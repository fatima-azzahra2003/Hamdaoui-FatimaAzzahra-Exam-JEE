import { Routes } from '@angular/router';
import { NavbarComponent } from './components/navbar/navbar.component';
import { ClientComponent } from './components/client/client.component';
import { RemboursementComponent } from './components/remboursement/remboursement.component';
import { PersonnelComponent } from './components/personnel/personnel.component';
import { ProfessionnelComponent } from './components/professionnel/professionnel.component';
import { ImmobilierComponent } from './components/immobilier/immobilier.component';

export const routes: Routes = [
    {
        path: 'clients',
        title: 'Clients',
        component: ClientComponent,
    },
    {
        path: 'remboursements',
        title: 'Remboursements',
        component: RemboursementComponent,
    },
    {
        path: 'personnels',
        title: 'Personnels',
        component: PersonnelComponent,
    },
    {
        path: 'professionnels',
        title: 'Professionnels',
        component: ProfessionnelComponent,
    },
    {
        path: 'immobiliers',
        title: 'Immobiliers',
        component: ImmobilierComponent,
    }
];
