import { Component, OnInit } from '@angular/core';
import { Compte } from 'src/app/model/compte';
import { CompteService } from 'src/app/services/compte.service';

@Component({
  selector: 'app-compte',
  templateUrl: './compte.component.html',
  styleUrls: ['./compte.component.css'],
})
export class CompteComponent implements OnInit {
  comptes: Compte[] = [];
  constructor(private compteService: CompteService) {}

  ngOnInit(): void {
    this.initComptes();
  }

  initComptes() {
    this.compteService.getAll().subscribe((result) => {
      this.comptes = result;
    });
  }

  delete(id: number) {
    this.compteService.delete(id).subscribe((ok) => {
      this.initComptes();
    });
  }
}
