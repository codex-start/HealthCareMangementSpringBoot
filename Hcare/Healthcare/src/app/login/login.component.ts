import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MyserviceService, User } from '../myservice.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private myService:MyserviceService,private router:Router) { }
  user:User=new User();
  invalidLogin = false
  role:string;
  @Input() error: string ="";
  ngOnInit() {
  }
  login(loginForm) {
    this.role=loginForm.role;
    sessionStorage.setItem("role",this.role)
    alert("As :"+this.role);
      (this.myService.authenticate(loginForm.username, loginForm.password).subscribe(
        data => {
          this.router.navigate([''])
          this.invalidLogin = false
        },
        error => {
          this.invalidLogin = true
          this.error = error.message;
  
        }
      )
      );
  }
}
//Observable,Promise