import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators';
@Injectable({
  providedIn: 'root'
})
export class MyserviceService {
  updateemployee: Employees;
  updatedoctor:Doctor;
  user:User;
  role:string;
  token=null;

  constructor(private httpService: HttpClient) { }
  
  authenticate(username:any, password:any) {
    return this.httpService
      .post<any>("http://localhost:5000/authenticate", { username, password })
      .pipe(
        map(userData => {
          console.log(userData.token)
          sessionStorage.setItem("username", username);
          let tokenStr = "Bearer " + userData.token;
          sessionStorage.setItem("token", tokenStr);
          console.log("token",sessionStorage.getItem("token"))
          return userData;
        })
      );
  }


  register(username:any, password:any,role:any) {
    alert("Registering as "+role)
    return this.httpService
      .post<any>("http://localhost:5000/register", { username, password,role })
      .pipe(
        map(userData => {
          return userData;
        })
      );
  }
//roles applicant,ustaffadmin,admcommitemember
  isUserLoggedIn() {
    let user = sessionStorage.getItem("username");
    console.log(user);
    console.log(!(user === null));//=,==,===
    return !(user === null);
  }
  isAdmin()
  {
    let role=sessionStorage.getItem("role");
    console.log("ROLE  ..."+role);
    return true
  }
  logOut() {
    sessionStorage.removeItem("username");
    sessionStorage.removeItem("role");
    sessionStorage.clear();
  }
  public getEmployees() {
    console.log("ins service get employees");//headers
      return this.httpService.get<Employees>("http://localhost:5000/patients/getAll");
    }
    ////////////////////////////////////////////////////////////////////
    public getDoctor() {
      console.log("ins service get employees");//headers
        return this.httpService.get<Doctor>("http://localhost:5000/doctors/getAll");
      }
      /////////////////////////////////////////////////////////////////
  public addEmp(addemp: Employees) {
    console.log("ins service add");
    console.log(addemp);
    return this.httpService.post("http://localhost:5000/patients/insert", addemp);
  }
  /////////////////////////////////////////////////////////////////
  public addDoc(adddoc: Doctor) {
    console.log("ins service add");
    console.log(adddoc);
    return this.httpService.post("http://localhost:5000/doctors/insert", adddoc);
  }
  ////////////////////////////////////////////////////////////////////
  public update(updateemployee: Employees) {
    this.updateemployee = updateemployee;
  }
  public updateMethod() {
    return this.updateemployee;
  }
  
  public onUpdate(updatemp: Employees) {
    console.log("ins service update");

    return this.httpService.put("http://localhost:5000/patients/update", updatemp);
  }


///////////////////////////////////////////////////////////////////////
public updateDoc(updatedoctor: Doctor) {
  this.updatedoctor = updatedoctor;
}
public updateMethodDoc() {
  return this.updatedoctor;
}
public onUpdateDoc(updatDoc: Doctor) {
  console.log("ins service update");

  return this.httpService.put("http://localhost:5000/doctors/update", updatDoc);
}

///////////////////////////////////////////////////////////////////



  delete(id: number) {
    console.log("ins service delete");
    return this.httpService.delete("http://localhost:5000/patients/delete/" + id);
  }
  deleteDoc(id: number) {
    console.log("ins service delete");
    return this.httpService.delete("http://localhost:5000/doctors/delete/" + id);
  }
}//Promise,Observable(Operators)rxjs
export class Employees{
   patientId:number;
  patientName:string;
	 patientAge:number;
	 patientDesc:string;
	 patientAddr:string;
	 appointDoc: string;
}
export class User {
username:string;
password:string;
role:string;
}
export class Doctor{
  doctorId : number;
  doctorName: string;
  doctorDesc: string;
}
