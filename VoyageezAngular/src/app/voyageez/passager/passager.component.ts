import { Component, OnInit } from '@angular/core';
import { Passager } from 'src/app/model/passager';
import { PassagerService } from 'src/app/services/passager.service';

@Component({
  selector: 'app-passager',
  templateUrl: './passager.component.html',
  styleUrls: ['./passager.component.css'],
})
export class PassagerComponent implements OnInit {
  passagers: Passager[] = [];
  constructor(private passagerService: PassagerService) {}

  ngOnInit(): void {
    this.initPassager();
  }

  initPassager() {
    this.passagerService.getAll().subscribe((result) => {
      this.passagers = result;
    });
  }

  delete(id: number) {
    this.passagerService.delete(id).subscribe((ok) => {
      this.initPassager();
    });
  }
}
