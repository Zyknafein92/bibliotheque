import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormControl, FormGroup} from '@angular/forms';
import {UserService} from '../../../../services/user.service';
import {User} from '../../../../models/user';

@Component({
  selector: 'app-my-profil',
  templateUrl: './my-profil.component.html',
  styleUrls: ['./my-profil.component.css']
})
export class MyProfilComponent implements OnInit {

  forms: FormGroup;
  messageError: string;
  private user: User;
  private token: any;
  private router: any;

  constructor(private userService: UserService, private formBuilder: FormBuilder) {
  }

  ngOnInit() {
   // this.initForm(); // (this.token);
  }

}


