import { Doctor } from './../myservice.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MyserviceService } from '../myservice.service';

@Component({
  selector: 'app-contact-us',
  templateUrl: './contact-us.component.html',
  styleUrls: ['./contact-us.component.css']
})
export class ContactUSComponent implements OnInit {

  // constructor() { }

  // ngOnInit() {
  // }


  message: string;

  constructor(private myservice: MyserviceService,private router: Router) { }//dependency injection

  ngOnInit(): void {
  }
  onSubmit(adddoc:Doctor):any{
    console.log(adddoc);
     this.myservice.addDoc(adddoc).subscribe(data => {
      alert(data);
      this.router.navigate(['/listdoc']);
    });
  }

}
