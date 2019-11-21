import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';
import {FormGroup} from '@angular/forms';
import {Observable} from 'rxjs';
import {Book} from '../models/book';

@Injectable({
  providedIn: 'root'
})

export class BookService {

  private bookURL = 'http://localhost:9000/api/book/';

  constructor(private http: HttpClient) {}

  getBook(idBook: string) {
    return this.http.get<Book>(this.bookURL + '/getBook', {
      params: new HttpParams()
        .set('id', idBook),
    });
  }

  getBooks() {
    return this.http.get<Book>(this.bookURL + '/getAll');
  }

  saveBook(form: FormGroup): Observable<FormGroup> {
    return this.http.post<FormGroup>(this.bookURL, form.value);
  }

  updateBook(form: FormGroup): Observable<Book> {
    return this.http.put<Book>(this.bookURL + '/updateBook', form.value);
  }

  deleteBook(idBook: any): Observable<{}> {
    return this.http.delete<Book>( this.bookURL + '/deleteBook', {
      params: new HttpParams()
        .set('id', idBook)
    });
  }

}
