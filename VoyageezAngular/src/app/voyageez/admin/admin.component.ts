import { Component, OnInit } from '@angular/core';
import { Admin } from 'src/app/model/admin';
import { AdminService } from 'src/app/services/admin.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css'],
})
export class AdminComponent implements OnInit {
  admins: Admin[] = [];

  constructor(private adminService: AdminService) {}

  ngOnInit(): void {
    this.initAdmins();
  }

  initAdmins() {
    this.adminService.getAll().subscribe((result) => {
      this.admins = result;
    });
  }

  delete(id: number) {
    this.adminService.delete(id).subscribe((ok) => {
      this.initAdmins();
    });
  }
}
