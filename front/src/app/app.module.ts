import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { CreateBorrowComponent } from './components/borrow/create-borrow/create-borrow.component';
import { SearchBookComponent } from './components/book/search-book/search-book.component';
import { CreateUserComponent } from './components/user/create-user/create-user.component';
import { UpdateUserComponent } from './components/user/update-user/update-user.component';
import { MyProfilComponent } from './components/user/my-profil/my-profil.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {RouterModule} from '@angular/router';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatButtonModule, MatCardModule, MatIconModule, MatMenuModule} from '@angular/material';
import { HttpClientModule } from '@angular/common/http';
import { HomeComponent } from './components/home/home.component';
import { AppRoutingModule } from './app-routing.module';
import { ViewBookComponent } from './components/book/view-book/view-book.component';
import { ViewLibrarysComponent } from './components/library/view-librarys/view-librarys.component';
import { LoginComponent } from './components/auth/login/login.component';
import { LogoutComponent } from './components/auth/logout/logout.component';

@NgModule({
  declarations: [
    AppComponent,
    CreateBorrowComponent,
    SearchBookComponent,
    CreateUserComponent,
    UpdateUserComponent,
    MyProfilComponent,
    HomeComponent,
    ViewBookComponent,
    ViewLibrarysComponent,
    LoginComponent,
    LogoutComponent
  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    RouterModule,
    BrowserAnimationsModule,
    MatMenuModule,
    MatIconModule,
    MatCardModule,
    MatButtonModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
