import { NgModule } from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {HomeComponent} from './components/home/home.component';
import {CreateUserComponent} from './components/user/create-user/create-user.component';
import {MyProfilComponent} from './components/user/my-profil/my-profil.component';
import {UpdateUserComponent} from './components/user/update-user/update-user.component';
import {SearchBookComponent} from './components/book/search-book/search-book.component';
import {ViewLibrarysComponent} from './components/library/view-librarys/view-librarys.component';
import {LoginComponent} from './components/auth/login/login.component';
import {LogoutComponent} from './components/auth/logout/logout.component';

const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'create-user', component: CreateUserComponent },
  { path:  'update-user', component: UpdateUserComponent},
  { path:  'my-profil', component: MyProfilComponent},
  { path:  'Logout', component: LogoutComponent},
  { path:  'Login', component: LoginComponent},
  { path:  'contacts', component: ViewLibrarysComponent},
  { path:  'search', component: SearchBookComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
