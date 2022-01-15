import { PlaneteService } from './../../services/planete.service';
import { Component, OnInit } from '@angular/core';
import { Planete } from 'src/app/model/planete';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-planete',
  templateUrl: './planete.component.html',
  styleUrls: ['./planete.component.css'],
})
export class PlaneteComponent implements OnInit {
  planetes: Planete[] = [];

  constructor(private planeteService: PlaneteService) {}

  ngOnInit(): void {
    this.initPlanetes();
  }

  initPlanetes() {
    this.planeteService.getAll().subscribe((result) => {
      this.planetes = result;
    });
  }

  delete(id: number) {
    this.planeteService.delete(id).subscribe((ok) => {
      this.initPlanetes();
    });
  }
}
