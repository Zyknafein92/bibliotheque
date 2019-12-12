import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';

import {JwtResponse} from './JwtReponse';
import {AuthLoginInfo} from './login-info';
import {FormGroup} from '@angular/forms';


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private loginUrl = 'http://localhost:9000/api/security/login';
  private addUser = 'http://localhost:9000/api/security/addUser';

  constructor(private http: HttpClient) {
  }

  attemptAuth(credentials: AuthLoginInfo): Observable<JwtResponse> {
    return this.http.post<JwtResponse>(this.loginUrl, credentials, httpOptions);
  }

  saveUser(form: FormGroup): Observable<FormGroup> {
    return this.http.post<FormGroup>(this.addUser, form.value);
  }

}
