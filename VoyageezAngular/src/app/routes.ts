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
  { path: 'planete/edit/:id', component: EditPlaneteComponent, canActivate: [AuthenticationService] },
  { path: 'activite/edit/:id', component: EditActiviteComponent, canActivate: [AuthenticationService] },
  { path: 'admin/edit/:id', component: EditAdminComponent, canActivate: [AuthenticationService] },
  { path: 'client/edit/:id', component: EditClientComponent, canActivate: [AuthenticationService] },
  { path: 'passager/edit/:id', component: EditPassagerComponent, canActivate: [AuthenticationService] },
  { path: 'reservation/edit/:id', component: EditReservationComponent, canActivate: [AuthenticationService] },
  { path: 'trajet/edit/:id', component: EditTrajetComponent, canActivate: [AuthenticationService] },
  { path: 'vaisseau/edit/:id', component: EditAdminComponent, canActivate: [AuthenticationService] },
  { path: '', redirectTo: 'home', pathMatch: 'full' },
];
