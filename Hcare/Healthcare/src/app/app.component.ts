import { Component } from '@angular/core';
import { MyserviceService } from './myservice.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  imagePath = './assets/java2learn.jpg';

constructor(public loginService:MyserviceService){}//dependency injection

//ng g s myservice

}
