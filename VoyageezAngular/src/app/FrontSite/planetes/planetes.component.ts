import { Planete } from './../../model/planete';
import { Observable } from 'rxjs';
import { Component, OnInit } from '@angular/core';
import { PlaneteService } from 'src/app/services/planete.service';

@Component({
  selector: 'app-planetes',
  templateUrl: './planetes.component.html',
  styleUrls: ['./planetes.component.css'],
})
export class PlanetesComponent implements OnInit {
  planetes: Observable<Planete[]> | null = null;
  constructor(private planeteService: PlaneteService) {}

  ngOnInit(): void {
    this.planetes = this.planeteService.getAll();
  }
  delete(id: number) {
    this.planeteService.delete(id).subscribe((ok) => {
      this.planetes = this.planeteService.getAll();
    });
  }

  /*  //compagnons: Compagnon[] = [];
 compagnons: Observable<Compagnon[]> | null = null;
 constructor(private compagnonService: CompagnonService) {}

 ngOnInit(): void {
   // this.compagnonService.getAll().subscribe((result) => {
   //   this.compagnons = result;
   // });

   this.compagnons = this.compagnonService.getAll();
 }

 delete(id: number) {
   this.compagnonService.delete(id).subscribe((ok) => {
     this.compagnons = this.compagnonService.getAll();
   });
 }
 */
}
