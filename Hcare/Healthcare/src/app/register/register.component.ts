import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MyserviceService, User } from '../myservice.service';

@Component({
  selector: 'register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  constructor(private myService:MyserviceService,private router:Router) { }
  user:User=new User();
  invalidLogin = false
  
  @Input() error: string ="";
  ngOnInit() {
  }
  register(registerForm) {
      (this.myService.register(registerForm.username, registerForm.password,registerForm.role).subscribe(
        data => {
          alert("Registered Successfully  : "+data.username+" As "+data.role)
          this.router.navigate(['login'])
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
