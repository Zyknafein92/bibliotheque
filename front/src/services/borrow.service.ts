import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';
import {Borrow} from '../models/borrow';
import {FormGroup} from '@angular/forms';
import {Observable} from 'rxjs';


@Injectable({
  providedIn: 'root'
})

export class BorrowService {

  private borrowURL = 'http://localhost:9000/api/borrow/';

  constructor(private http: HttpClient) { }

  getBorrows() {
    return this.http.get<Borrow>(this.borrowURL + '/getAll');
  }

  getBorrow(idBorrow: string) {
    return this.http.get<Borrow>(this.borrowURL + '/getBorrow', {
      params: new HttpParams()
        .set('id', idBorrow),
    });
  }

  saveBorrow(form: FormGroup): Observable<FormGroup> {
    return this.http.post<FormGroup>(this.borrowURL, form.value);
  }

  updateBorrow(form: FormGroup): Observable<Borrow> {
    return this.http.put<Borrow>(this.borrowURL + '/updateBorrow', form.value);
  }

  extendBorrow(idBorrow: string): Observable<Borrow> {
    return this.http.put<Borrow>(this.borrowURL + '/extendBorrow', {
      params: new HttpParams()
        .set('id', idBorrow)
    });
  }

  deleteBorrow(idBorrow: any): Observable<{}> {
    return this.http.delete<Borrow>( this.borrowURL + '/deleteBorrow', {
      params: new HttpParams()
        .set('id', idBorrow)
    });
  }
}
