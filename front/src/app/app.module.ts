import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { CreateBorrowComponent } from './components/borrow/create-borrow/create-borrow.component';
import { SearchBookComponent } from './components/book/search-book/search-book.component';
import { CreateUserComponent } from './components/user/create-user/create-user.component';
import { UpdateUserComponent } from './components/user/update-user/update-user.component';
import { MyProfilComponent } from './components/user/my-profil/my-profil.component';
import {ReactiveFormsModule} from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    CreateBorrowComponent,
    SearchBookComponent,
    CreateUserComponent,
    UpdateUserComponent,
    MyProfilComponent
  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
