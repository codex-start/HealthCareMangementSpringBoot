import { Component, OnInit } from '@angular/core';
import { MyserviceService, Employees } from '../myservice.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-list-employee',
  templateUrl: './list-employee.component.html',
  styleUrls: ['./list-employee.component.css']
})
export class ListEmployeeComponent implements OnInit {
  message: string;
  employees: Employees[];
  filteredEmployees:Employees[]=[];
  searchText="";
  error=null;
  constructor(private myservice: MyserviceService, private router: Router) {
  }

  ngOnInit(): any {
     this.myservice.getEmployees().subscribe(
      response => this.handleSuccessfulResponse(response)
      ,
      error=>{this.error=error.message}
    );
    this.search();
   
  }

  handleSuccessfulResponse(response) {
    this.employees = JSON.parse(response);
    this.filteredEmployees=this.employees;
  }
  update(updateemployee: Employees) {
    this.myservice.update(updateemployee);
    this.router.navigate(['/updateemp']); //updating the employee
  }

  delete(deleteemployee: Employees): any {
   var selction= confirm("Are you sure !!")
   if(selction==true){
    this.employees.splice(this.employees.indexOf(deleteemployee), 1);
    this.myservice.delete(deleteemployee.patientId).subscribe(data => {
      alert(data);
    });}
    this.router.navigate(['/listemp']);
  }
  searchKey(data: string) {
    this.searchText = data;
    this.search();
  }

  search() {
    this.filteredEmployees = this.searchText === ""? this.employees : this.employees.filter((element) => {
      return element.patientName.toLowerCase() == this.searchText.toLowerCase();
    });
  }
}
//Observables,Promise   rxjs