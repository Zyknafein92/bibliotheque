import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';
import {FormGroup} from '@angular/forms';
import {Observable} from 'rxjs';
import {User} from '../models/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private userURL = 'http://localhost:9000/api/user/';

  constructor(private http: HttpClient) { }

  getUser(idUser: string) {
    return this.http.get<User>(this.userURL + '/getUser', {
      params: new HttpParams()
        .set('id', idUser),
    });
  }

  getUsers() {
    return this.http.get<User>(this.userURL + '/getAll');
  }

  saveUser(form: FormGroup): Observable<FormGroup> {
    return this.http.post<FormGroup>(this.userURL, form.value);
  }

  updateUser(form: FormGroup): Observable<User> {
    return this.http.put<User>(this.userURL + '/updateUser', form.value);
  }

  deleteUser(idUser: any): Observable<{}> {
    return this.http.delete<User>( this.userURL + '/deleteUser', {
      params: new HttpParams()
        .set('id', idUser)
    });
  }
}
