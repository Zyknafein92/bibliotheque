import { Component, OnInit } from '@angular/core';
import {Library} from '../../../../models/library';
import {LibraryService} from '../../../../services/library.service';
import {Router} from '@angular/router';
import {FormBuilder, FormControl, FormGroup} from '@angular/forms';

@Component({
  selector: 'app-view-librarys',
  templateUrl: './view-librarys.component.html',
  styleUrls: ['./view-librarys.component.css']
})
export class ViewLibrarysComponent implements OnInit {

  library: Library;
  fromLibrary: FormGroup;



  constructor(private libraryService: LibraryService, private router: Router, private formBuilder: FormBuilder) { }

  ngOnInit() {
    this.initformLibrary();
  }


  private initformLibrary() {
    this.fromLibrary = this.formBuilder.group({
      name : new FormControl(),
      address : new FormControl(),
      phone: new FormControl(),
    });
  }

}
