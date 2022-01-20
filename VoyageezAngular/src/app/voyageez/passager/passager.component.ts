import { Client } from 'src/app/model/client';
import { Component, Input, OnInit } from '@angular/core';
import { Passager } from 'src/app/model/passager';
import { PassagerService } from 'src/app/services/passager.service';

@Component({
  selector: 'app-passager',
  templateUrl: './passager.component.html',
  styleUrls: ['./passager.component.css'],
})
export class PassagerComponent implements OnInit {
  @Input()
  clientEnvoi!: Client;
  passagers: Passager[] = [];
  passager: Passager = new Passager();
  visible: boolean = true;
  constructor(private passagerService: PassagerService) {}

  ngOnInit(): void {
    this.listPassagers();
  }

  listPassagers() {
    let doublon = false;
    for (let r of this.clientEnvoi.reservations!) {
      for (let p of r.passagers!) {
        doublon = false;
        for (let pass of this.passagers) {
          if (pass.nom == p.nom && pass.prenom == p.prenom) {
            doublon = true;
            break;
          }
        }
        if (!doublon) {
          this.passagers.push(p);
        }
      }
    }
  }

  visibilite() {
    this.visible = !this.visible;
  }

  ajouter() {
    this.passagers.push(this.passager);
    this.passager = new Passager();
    this.visibilite();
  }

  delete(id: number) {
    this.passagerService.delete(id).subscribe((ok) => {
      //this.initPassager();
    });
  }
}
