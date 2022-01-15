import { Component, OnInit } from '@angular/core';
import { Vaisseau } from 'src/app/model/vaisseau';
import { VaisseauService } from 'src/app/services/vaisseau.service';

@Component({
  selector: 'app-vaisseau',
  templateUrl: './vaisseau.component.html',
  styleUrls: ['./vaisseau.component.css'],
})
export class VaisseauComponent implements OnInit {
  vaisseaux: Vaisseau[] = [];
  constructor(private vaisseauService: VaisseauService) {}

  ngOnInit(): void {
    this.initVaisseaux();
  }

  initVaisseaux() {
    this.vaisseauService.getAll().subscribe((result) => {
      this.vaisseaux = result;
    });
  }
  delete(id: number) {
    this.vaisseauService.delete(id).subscribe((ok) => {
      this.initVaisseaux();
    });
  }
}
