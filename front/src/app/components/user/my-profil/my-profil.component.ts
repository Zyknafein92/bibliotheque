import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {UserService} from '../../../../services/user.service';
import {User} from '../../../../models/user';
import {TokenStorageService} from '../../../../services/security/token-storage.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-my-profil',
  templateUrl: './my-profil.component.html',
  styleUrls: ['./my-profil.component.css']
})
export class MyProfilComponent implements OnInit {

  forms: FormGroup;
  messageError: string;
  private user: User;


  constructor(private userService: UserService, private token: TokenStorageService,private router:Router) {
  }

  ngOnInit() {
    this.initProfil(this.token);
  }

  initProfil(token : TokenStorageService){
    this.userService.getProfil(this.token.getEmail()).subscribe(
      res => {
        this.user = res;
        console.log("user ", res.email)
      }
    );
  }

  refreshUser() {
    this.initProfil(this.token);
  }

  deleteUser(user: User) {
    this.userService.deleteUser(this.user.id).subscribe(
      response => {
        this.token.signOut();
        this.router.navigateByUrl("/");
      }),
      err => {
        console.log("error: ", err.error.message);
      };
  }
}


