import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';

import { HomeComponent } from './FrontSite/home/home.component';
import { routes } from './routes';
import { FooterComponent } from './FrontSite/footer/footer.component';
import { MissionsComponent } from './FrontSite/missions/missions.component';
import { FaqComponent } from './FrontSite/faq/faq.component';
import { ConnaitreComponent } from './FrontSite/connaitre/connaitre.component';
import { ActivitesComponent } from './FrontSite/activites/activites.component';
import { BanniereComponent } from './FrontSite/banniere/banniere.component';
import { ContactComponent } from './FrontSite/contact/contact.component';
import { InfosComponent } from './FrontSite/infos/infos.component';
import { MenuAdminComponent } from './FrontSite/menu-admin/menu-admin.component';
import { MenuClientComponent } from './FrontSite/menu-client/menu-client.component';
import { OffresComponent } from './FrontSite/offres/offres.component';
import { PaiementComponent } from './FrontSite/paiement/paiement.component';
import { PlanetesComponent } from './FrontSite/planetes/planetes.component';
import { VolsComponent } from './FrontSite/vols/vols.component';
import { BarreNavComponent } from './FrontSite/barre-nav/barre-nav.component';
import { PlaneteComponent } from './voyageez/planete/planete.component';

import { VaisseauComponent } from './voyageez/vaisseau/vaisseau.component';
import { EditPlaneteComponent } from './voyageez/planete/edit-planete/edit-planete.component';
import { ActiviteComponent } from './voyageez/activite/activite.component';
import { AdminComponent } from './voyageez/admin/admin.component';
import { ClientComponent } from './voyageez/client/client.component';
import { PassagerComponent } from './voyageez/passager/passager.component';
import { ReservationComponent } from './voyageez/reservation/reservation.component';
import { TrajetComponent } from './voyageez/trajet/trajet.component';
import { EditActiviteComponent } from './voyageez/activite/edit-activite/edit-activite.component';
import { EditAdminComponent } from './voyageez/admin/edit-admin/edit-admin.component';
import { EditClientComponent } from './voyageez/client/edit-client/edit-client.component';
import { EditPassagerComponent } from './voyageez/passager/edit-passager/edit-passager.component';
import { EditReservationComponent } from './voyageez/reservation/edit-reservation/edit-reservation.component';
import { EditTrajetComponent } from './voyageez/trajet/edit-trajet/edit-trajet.component';
import { EditVaisseauComponent } from './voyageez/vaisseau/edit-vaisseau/edit-vaisseau.component';
import { LoginComponent } from './voyageez/login/login.component';
import { InscriptionComponent } from './voyageez/inscription/inscription.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    FooterComponent,
    MissionsComponent,
    FaqComponent,
    ConnaitreComponent,
    ActivitesComponent,
    BanniereComponent,
    ContactComponent,
    InfosComponent,
    MenuAdminComponent,
    MenuClientComponent,
    OffresComponent,
    PaiementComponent,
    PlanetesComponent,
    VolsComponent,
    BarreNavComponent,
    PlaneteComponent,
    EditPlaneteComponent,
    VaisseauComponent,
    ActiviteComponent,
    AdminComponent,
    ClientComponent,
    PassagerComponent,
    ReservationComponent,
    TrajetComponent,
    EditActiviteComponent,
    EditAdminComponent,
    EditClientComponent,
    EditPassagerComponent,
    EditReservationComponent,
    EditTrajetComponent,
    EditVaisseauComponent,
    LoginComponent,
    InscriptionComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    RouterModule.forRoot(routes),
    HttpClientModule,
    ReactiveFormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
