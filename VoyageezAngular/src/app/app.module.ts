import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';

import { HomeComponent } from './home/home.component';
import { routes } from './routes';
import { FooterComponent } from './footer/footer.component';
import { HeaderComponent } from './header/header.component';
import { NavComponent } from './nav/nav.component';
import { NavigationParLeCodeComponent } from './navigation-par-le-code/navigation-par-le-code.component';
import { MissionsComponent } from './missions/missions.component';
import { FaqComponent } from './faq/faq.component';
import { ConnaitreComponent } from './connaitre/connaitre.component';
import { ActivitesComponent } from './activites/activites.component';
import { BanniereComponent } from './banniere/banniere.component';
import { ConnexionComponent } from './connexion/connexion.component';
import { ContactComponent } from './contact/contact.component';
import { InfosComponent } from './infos/infos.component';
import { InscriptionComponent } from './inscription/inscription.component';
import { MenuAdminComponent } from './menu-admin/menu-admin.component';
import { MenuClientComponent } from './menu-client/menu-client.component';
import { OffresComponent } from './offres/offres.component';
import { PaiementComponent } from './paiement/paiement.component';
import { PlanetesComponent } from './planetes/planetes.component';
import { VolsComponent } from './vols/vols.component';
import { BarreNavComponent } from './barre-nav/barre-nav.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    FooterComponent,
    HeaderComponent,
    NavComponent,
    NavigationParLeCodeComponent,
    MissionsComponent,
    FaqComponent,
    ConnaitreComponent,
    ActivitesComponent,
    BanniereComponent,
    ConnexionComponent,
    ContactComponent,
    InfosComponent,
    InscriptionComponent,
    MenuAdminComponent,
    MenuClientComponent,
    OffresComponent,
    PaiementComponent,
    PlanetesComponent,
    VolsComponent,
    BarreNavComponent,
  ],
  imports: [BrowserModule, FormsModule, RouterModule.forRoot(routes)],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
