import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { MyserviceService, User } from './myservice.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {
  user:User=new User();
  constructor(private myService:MyserviceService,private router:Router){

  }
canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
  if (this.myService.isUserLoggedIn())
    return true;

  this.router.navigate(['login']);
  return false;

}
  }
  

