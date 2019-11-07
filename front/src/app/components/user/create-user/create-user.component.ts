import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {User} from '../../../../models/user';
import {UserService} from '../../../../services/user.service';

@Component({
  selector: 'app-create-user',
  templateUrl: './create-user.component.html',
  styleUrls: ['./create-user.component.css']
})
export class CreateUserComponent implements OnInit {
  forms: FormGroup;
  user: User;
  private messageError: string;

  constructor(private formBuilder: FormBuilder, private userService: UserService) { }

  ngOnInit() {
    this.initform();
  }

  private initform() {
    this.forms = this.formBuilder.group(
      {
        firstName: new FormControl(),
        lastName: new FormControl(),
        birthDate: new FormControl(),
        email: new FormControl('', Validators.compose([
          Validators.required,
          Validators.pattern('^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+.[a-zA-Z0-9-.]+$')
        ])),
        phone: new FormControl('', Validators.compose([
          Validators.required,
          Validators.pattern('^[0-9]{10}$')
        ])),
        password: new FormControl(),
        address: new FormControl(),
      });
  }

  saveuser() {
    console.log(this.forms.value);
    this.userService.saveUser(this.forms)
      .subscribe(
        response => {
          console.log('response: ', response);
        },
        err => {
          console.log('Error: ', err.error.message);
          this.messageError = err.error.message;
        });
  }

}
