import { Component, OnInit } from '@angular/core';
import { MyserviceService, Doctor } from '../myservice.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-list-employee',
  templateUrl: './listdoc.component.html',
  styleUrls: ['./listdoc.component.css']
})
export class ListdocComponent implements OnInit {
  message: string;
  employees: Doctor[];
  filteredEmployees:Doctor[]=[];
  searchText="";
  error=null;
  constructor(private myservice: MyserviceService, private router: Router) {
  }

  ngOnInit(): any {
     this.myservice.getDoctor().subscribe(
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
  updateDoc(updatedoctor: Doctor) {
    this.myservice.updateDoc(updatedoctor);
    this.router.navigate(['/updateemp']); //updating the employee
  }

  deleteDoc(deletedoctor: Doctor): any {
   var selction= confirm("Are you sure !!")
   if(selction==true){
    this.employees.splice(this.employees.indexOf(deletedoctor), 1);
    this.myservice.deleteDoc(deletedoctor.doctorId).subscribe(data => {
      alert(data);
    });}
    this.router.navigate(['/listdoc']);
  }
  searchKey(data: string) {
    this.searchText = data;
    this.search();
  }

  search() {
    this.filteredEmployees = this.searchText === ""? this.employees : this.employees.filter((element) => {
      return element.doctorName.toLowerCase() == this.searchText.toLowerCase();
    });
  }
}
//Observables,Promise   rxjs