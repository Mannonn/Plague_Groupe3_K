import { EditPlaneteComponent } from './voyageez/planete/edit-planete/edit-planete.component';
import { ActivitesComponent } from './FrontSite/activites/activites.component';
import { HomeComponent } from './FrontSite/home/home.component';
import { Routes } from '@angular/router';
import { ConnaitreComponent } from './FrontSite/connaitre/connaitre.component';
import { ConnexionComponent } from './FrontSite/connexion/connexion.component';
import { ContactComponent } from './FrontSite/contact/contact.component';
import { FaqComponent } from './FrontSite/faq/faq.component';
import { InfosComponent } from './FrontSite/infos/infos.component';
import { OffresComponent } from './FrontSite/offres/offres.component';
import { PaiementComponent } from './FrontSite/paiement/paiement.component';
import { MissionsComponent } from './FrontSite/missions/missions.component';
import { InscriptionComponent } from './FrontSite/inscription/inscription.component';
import { MenuClientComponent } from './FrontSite/menu-client/menu-client.component';
import { PlanetesComponent } from './FrontSite/planetes/planetes.component';
import { VolsComponent } from './FrontSite/vols/vols.component';
import { MenuAdminComponent } from './FrontSite/menu-admin/menu-admin.component';
import { PlaneteComponent } from './voyageez/planete/planete.component';
import { ActiviteComponent } from './voyageez/activite/activite.component';
import { AdminComponent } from './voyageez/admin/admin.component';
import { ClientComponent } from './voyageez/client/client.component';
import { CompteComponent } from './voyageez/compte/compte.component';
import { PassagerComponent } from './voyageez/passager/passager.component';
import { ReservationComponent } from './voyageez/reservation/reservation.component';
import { TrajetComponent } from './voyageez/trajet/trajet.component';
import { VaisseauComponent } from './voyageez/vaisseau/vaisseau.component';
import { AuthentificationService } from './services/authentification.service';
import { EditActiviteComponent } from './voyageez/activite/edit-activite/edit-activite.component';
import { EditAdminComponent } from './voyageez/admin/edit-admin/edit-admin.component';
import { EditPassagerComponent } from './voyageez/passager/edit-passager/edit-passager.component';
import { EditClientComponent } from './voyageez/client/edit-client/edit-client.component';
import { EditReservationComponent } from './voyageez/reservation/edit-reservation/edit-reservation.component';
import { EditTrajetComponent } from './voyageez/trajet/edit-trajet/edit-trajet.component';

export const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'faq', component: FaqComponent },
  { path: 'infos', component: InfosComponent },
  { path: 'connaitre', component: ConnaitreComponent },
  { path: 'offres', component: OffresComponent },
  { path: 'paiement', component: PaiementComponent },
  { path: 'missions', component: MissionsComponent },
  { path: 'contact', component: ContactComponent },
  { path: 'connexion', component: ConnexionComponent },
  { path: 'inscription', component: InscriptionComponent },
  { path: 'menu_client', component: MenuClientComponent },
  { path: 'activites', component: ActivitesComponent },
  { path: 'planetes', component: PlanetesComponent },
  { path: 'vols', component: VolsComponent },
  { path: 'menu_admin', component: MenuAdminComponent },
  { path: 'planete', component: PlaneteComponent },
  { path: 'activite', component: ActiviteComponent },
  { path: 'admin', component: AdminComponent },
  { path: 'client', component: ClientComponent },
  { path: 'compte', component: CompteComponent },
  { path: 'passager', component: PassagerComponent },
  { path: 'reservation', component: ReservationComponent },
  { path: 'trajet', component: TrajetComponent },
  { path: 'vaisseau', component: VaisseauComponent },
  {
    path: 'planete/edit/:id',
    component: EditPlaneteComponent,
    /* canActivate: [AuthentificationService], */
  },
  {
    path: 'planete/edit',
    component: EditPlaneteComponent,
    /* canActivate: [AuthentificationService], */
  },
  {
    path: 'activite/edit/:id',
    component: EditActiviteComponent,
    canActivate: [AuthentificationService],
  },
  {
    path: 'activite/edit',
    component: EditActiviteComponent,
    canActivate: [AuthentificationService],
  },
  {
    path: 'admin/edit/:id',
    component: EditAdminComponent,
    canActivate: [AuthentificationService],
  },
  {
    path: 'admin/edit',
    component: EditAdminComponent,
    canActivate: [AuthentificationService],
  },
  {
    path: 'client/edit/:id',
    component: EditClientComponent,
    canActivate: [AuthentificationService],
  },
  {
    path: 'client/edit',
    component: EditClientComponent,
    canActivate: [AuthentificationService],
  },
  {
    path: 'passager/edit/:id',
    component: EditPassagerComponent,
    canActivate: [AuthentificationService],
  },
  {
    path: 'passager/edit',
    component: EditPassagerComponent,
    canActivate: [AuthentificationService],
  },
  {
    path: 'reservation/edit/:id',
    component: EditReservationComponent,
    canActivate: [AuthentificationService],
  },
  {
    path: 'reservation/edit',
    component: EditReservationComponent,
    canActivate: [AuthentificationService],
  },
  {
    path: 'trajet/edit/:id',
    component: EditTrajetComponent,
    canActivate: [AuthentificationService],
  },
  {
    path: 'trajet/edit',
    component: EditTrajetComponent,
    canActivate: [AuthentificationService],
  },
  {
    path: 'vaisseau/edit/:id',
    component: EditAdminComponent,
    canActivate: [AuthentificationService],
  },
  {
    path: 'vaisseau/edit',
    component: EditAdminComponent,
    canActivate: [AuthentificationService],
  },
  { path: '', redirectTo: 'home', pathMatch: 'full' },
];
