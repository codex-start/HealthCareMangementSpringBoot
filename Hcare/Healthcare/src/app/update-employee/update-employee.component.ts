import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MyserviceService, Employees } from '../myservice.service';

@Component({
  selector: 'app-update-employee',
  templateUrl: './update-employee.component.html',
  styleUrls: ['./update-employee.component.css']
})
export class UpdateEmployeeComponent implements OnInit {
  obj1: any;
  employees: Employees[];
  message: string;
  constructor(private myservice: MyserviceService, private router: Router) {
    this.obj1 = this.myservice.updateMethod();
  }
  onUpdate(updatemp: Employees): any {
    return this.myservice.onUpdate(updatemp).subscribe(data => {
      alert(data)
      this.router.navigate(['/listemp'])
    });
  }
  ngOnInit(): void {
  }

}
