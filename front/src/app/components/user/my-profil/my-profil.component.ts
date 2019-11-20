import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
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

  // refreshUser() {
  //   this.initProfil(this.token);
  // }
  //
  // deleteUser(user: User) {
  //   this.userService.deleteUser(this.user.id).subscribe(
  //     response => {
  //       this.token.signOut();
  //       this.router.navigateByUrl("/");
  //     }),
  //     err => {
  //       console.log("error: ", err.error.message);
  //     };
  // }
}


