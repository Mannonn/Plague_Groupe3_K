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
  { path: '', redirectTo: 'home', pathMatch: 'full' },
];