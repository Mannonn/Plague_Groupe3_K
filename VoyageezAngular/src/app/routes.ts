import { EditPlaneteComponent } from './voyageez/planete/edit-planete/edit-planete.component';
import { ActivitesComponent } from './FrontSite/activites/activites.component';
import { HomeComponent } from './FrontSite/home/home.component';
import { Routes } from '@angular/router';
import { ConnaitreComponent } from './FrontSite/connaitre/connaitre.component';
import { ContactComponent } from './FrontSite/contact/contact.component';
import { FaqComponent } from './FrontSite/faq/faq.component';
import { InfosComponent } from './FrontSite/infos/infos.component';
import { OffresComponent } from './FrontSite/offres/offres.component';
import { PaiementComponent } from './FrontSite/paiement/paiement.component';
import { MissionsComponent } from './FrontSite/missions/missions.component';

import { MenuClientComponent } from './FrontSite/menu-client/menu-client.component';
import { PlanetesComponent } from './FrontSite/planetes/planetes.component';
import { VolsComponent } from './FrontSite/vols/vols.component';
import { MenuAdminComponent } from './FrontSite/menu-admin/menu-admin.component';
import { PlaneteComponent } from './voyageez/planete/planete.component';
import { ActiviteComponent } from './voyageez/activite/activite.component';
import { AdminComponent } from './voyageez/admin/admin.component';
import { ClientComponent } from './voyageez/client/client.component';
import { PassagerComponent } from './voyageez/passager/passager.component';
import { ReservationComponent } from './voyageez/reservation/reservation.component';
import { TrajetComponent } from './voyageez/trajet/trajet.component';
import { VaisseauComponent } from './voyageez/vaisseau/vaisseau.component';
import { AuthenticationService } from './services/authentication.service';
import { EditActiviteComponent } from './voyageez/activite/edit-activite/edit-activite.component';
import { EditAdminComponent } from './voyageez/admin/edit-admin/edit-admin.component';
import { EditPassagerComponent } from './voyageez/passager/edit-passager/edit-passager.component';
import { EditClientComponent } from './voyageez/client/edit-client/edit-client.component';
import { EditReservationComponent } from './voyageez/reservation/edit-reservation/edit-reservation.component';
import { EditTrajetComponent } from './voyageez/trajet/edit-trajet/edit-trajet.component';
import { EditVaisseauComponent } from './voyageez/vaisseau/edit-vaisseau/edit-vaisseau.component';
import { InscriptionComponent } from './voyageez/inscription/inscription.component';
import { LoginComponent } from './voyageez/login/login.component';
import { AuthenticationClientService } from './services/authentication-client.service';
import { AuthenticationAdminService } from './services/authentication-admin.service';

export const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'faq', component: FaqComponent },
  { path: 'infos', component: InfosComponent },
  { path: 'connaitre', component: ConnaitreComponent },
  { path: 'offres', component: OffresComponent },
  { path: 'paiement', component: PaiementComponent },
  { path: 'missions', component: MissionsComponent },
  { path: 'contact', component: ContactComponent },
  { path: 'inscription', component: InscriptionComponent },
  {
    path: 'menu_client',
    component: MenuClientComponent,
    canActivate: [AuthenticationClientService],
  },
  { path: 'activites', component: ActivitesComponent },
  { path: 'planetes', component: PlanetesComponent },
  { path: 'vols', component: VolsComponent },
  {
    path: 'menu_admin',
    component: MenuAdminComponent,
    canActivate: [AuthenticationAdminService],
  },
  {
    path: 'planete',
    component: PlaneteComponent,
    canActivate: [AuthenticationAdminService],
  },
  {
    path: 'activite',
    component: ActiviteComponent,
    canActivate: [AuthenticationAdminService],
  },
  {
    path: 'admin',
    component: AdminComponent,
    canActivate: [AuthenticationAdminService],
  },
  {
    path: 'client',
    component: ClientComponent,
    canActivate: [AuthenticationService],
  },
  {
    path: 'passager',
    component: PassagerComponent,
    canActivate: [AuthenticationClientService],
  },
  {
    path: 'reservation',
    component: ReservationComponent,
    canActivate: [AuthenticationClientService],
  },
  {
    path: 'trajet',
    component: TrajetComponent,
    canActivate: [AuthenticationAdminService],
  },
  {
    path: 'vaisseau',
    component: VaisseauComponent,
    canActivate: [AuthenticationAdminService],
  },
  { path: 'login', component: LoginComponent },
  {
    path: 'planete/edit/:id',
    component: EditPlaneteComponent,
    canActivate: [AuthenticationAdminService],
  },
  {
    path: 'planete/edit',
    component: EditPlaneteComponent,
    canActivate: [AuthenticationAdminService],
  },
  {
    path: 'activite/edit/:id',
    component: EditActiviteComponent,
    canActivate: [AuthenticationAdminService],
  },
  {
    path: 'activite/edit',
    component: EditActiviteComponent,
    canActivate: [AuthenticationAdminService],
  },
  {
    path: 'admin/edit/:id',
    component: EditAdminComponent,
    canActivate: [AuthenticationAdminService],
  },
  {
    path: 'admin/edit',
    component: EditAdminComponent,
    canActivate: [AuthenticationAdminService],
  },
  {
    path: 'client/edit/:id',
    component: EditClientComponent,
    canActivate: [AuthenticationClientService],
  },
  {
    path: 'client/edit',
    component: EditClientComponent,
    canActivate: [AuthenticationClientService],
  },
  {
    path: 'passager/edit/:id',
    component: EditPassagerComponent,
    canActivate: [AuthenticationClientService],
  },
  {
    path: 'passager/edit',
    component: EditPassagerComponent,
    canActivate: [AuthenticationClientService],
  },
  {
    path: 'reservation/edit/:id',
    component: EditReservationComponent,
    canActivate: [AuthenticationClientService],
  },
  {
    path: 'reservation/edit',
    component: EditReservationComponent,
    canActivate: [AuthenticationClientService],
  },
  {
    path: 'trajet/edit/:id',
    component: EditTrajetComponent,
    canActivate: [AuthenticationAdminService],
  },
  {
    path: 'trajet/edit',
    component: EditTrajetComponent,
    canActivate: [AuthenticationAdminService],
  },
  {
    path: 'vaisseau/edit/:id',
    component: EditVaisseauComponent,
    canActivate: [AuthenticationAdminService],
  },
  {
    path: 'vaisseau/edit',
    component: EditVaisseauComponent,
    canActivate: [AuthenticationAdminService],
  },
  { path: '', redirectTo: 'home', pathMatch: 'full' },
];
