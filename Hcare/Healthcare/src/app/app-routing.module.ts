import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ListEmployeeComponent } from './list-employee/list-employee.component';
import { UpdateEmployeeComponent } from './update-employee/update-employee.component';
import { AddEmployeeComponent } from './add-employee/add-employee.component';
import { HomepageComponent } from './homepage/homepage.component';
import { ContactUSComponent } from './contact-us/contact-us.component';
import { GalleryComponent } from './gallery/gallery.component';
import { LoginComponent } from './login/login.component';
import { AuthGuard } from './auth.guard';
import { LogoutComponent } from './logout/logout.component';
import { RegisterComponent } from './register/register.component';
import { ListdocComponent } from './listdoc/listdoc.component';

const routes: Routes = [
  { path: 'listemp', 
  component: ListEmployeeComponent,
  canActivate:[AuthGuard]
 },
{ path: 'addemp', component: AddEmployeeComponent, canActivate:[AuthGuard]},
{ path: '', component: HomepageComponent },
{ path: 'updateemp', component: UpdateEmployeeComponent },
{ path: 'homepage', component: HomepageComponent },
{ path: 'contact', component: ContactUSComponent },
{ path: 'aboutus', component: GalleryComponent },
{ path: 'login', component: LoginComponent },
{ path: 'logout', component: LogoutComponent },
{path:'register',component:RegisterComponent},
{ path: 'listdoc', 
  component: ListdocComponent,
  canActivate:[AuthGuard]
 },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
