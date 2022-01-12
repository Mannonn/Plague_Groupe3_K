import { NavComponent } from './nav/nav.component';
import { NavigationParLeCodeComponent } from './navigation-par-le-code/navigation-par-le-code.component';
import { HomeComponent } from './home/home.component';
import { Routes } from '@angular/router';

export const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'nav', component: NavigationParLeCodeComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full' },
];
