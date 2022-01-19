import { Router } from '@angular/router';
import { InscriptionService } from './../../services/inscription.service';
import {
  AbstractControl,
  AsyncValidatorFn,
  FormControl,
  FormGroup,
  ValidationErrors,
  Validators,
} from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import { map, Observable } from 'rxjs';
import { ClientService } from 'src/app/services/client.service';
import { Client } from 'src/app/model/client';

@Component({
  selector: 'app-inscription',
  templateUrl: './inscription.component.html',
  styleUrls: ['./inscription.component.css'],
})
export class InscriptionComponent implements OnInit {
  form: FormGroup;
  client: Client = new Client();

  constructor(
    private inscriptionService: InscriptionService,
    private clientService: ClientService,
    private router: Router
  ) {
    this.form = new FormGroup({
      login: new FormControl('', Validators.required, this.checkLogin()),
      passwordGroup: new FormGroup(
        {
          password: new FormControl('', Validators.required),
          confirm: new FormControl(''),
        },
        this.checkEquals
      ),
    });
  }

  checkEquals(group: AbstractControl): ValidationErrors | null {
    let formGroup: FormGroup = group as FormGroup;
    return formGroup.controls['password'].value !=
      formGroup.controls['confirm'].value
      ? { checkequals: true }
      : null;
  }

  checkLogin(): AsyncValidatorFn {
    return (control: AbstractControl): Observable<ValidationErrors | null> => {
      return this.clientService.check(control.value).pipe(
        map((result) => {
          return result ? { error: true } : null;
        })
      );
    };
  }

  ngOnInit(): void {}

  validate() {
    let group = this.form.controls['passwordGroup'] as FormGroup;
    let client = {
      login: this.form.controls['login'].value,
      password: group.controls['password'].value,
    };
    this.inscriptionService.inscription(client).subscribe((ok) => {
      this.router.navigate(['/login']);
    });
  }

  createClient() {
    this.clientService.create(this.client).subscribe((ok) => {
      this.router.navigate(['/client']);
    });
  }
}
