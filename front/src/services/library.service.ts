import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';

import {FormGroup} from '@angular/forms';
import {Observable} from 'rxjs';
import {Library} from '../models/library';

@Injectable({
  providedIn: 'root'
})
export class LibraryService {

  private libraryURL = 'http://localhost:9030/api/library/';

  constructor(private http: HttpClient) { }

  getLibrary(idLibrary: string) {
    return this.http.get<Library>(this.libraryURL + '/getLibrary', {
      params: new HttpParams()
        .set('id', idLibrary),
    });
  }

  getLibrarys() {
    return this.http.get<Library>(this.libraryURL + '/getAll');
  }

  saveLibrary(form: FormGroup): Observable<FormGroup> {
    return this.http.post<FormGroup>(this.libraryURL, form.value);
  }

  updateLibrary(form: FormGroup): Observable<Library> {
    return this.http.put<Library>(this.libraryURL + '/updateLibrary', form.value);
  }

  deleteLibrary(idLibrary: any): Observable<{}> {
    return this.http.delete<Library>( this.libraryURL + '/deleteLibrary', {
      params: new HttpParams()
        .set('id', idLibrary)
    });
  }
}
