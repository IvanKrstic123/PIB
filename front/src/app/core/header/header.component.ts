import { SharedService } from './../../shared/services/shared.service';
import { Component} from '@angular/core';
import { AuthService } from 'src/app/shared/services/Auth.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss'],
})
export class HeaderComponent{
  logUser: any = false;
  counterShows: number = 0;
  
  constructor(private authService: AuthService, private sharedService: SharedService) {
      if(this.authService.currentUserValue) {
        this.logUser = true;
      }
  }
  
  ngOnInit(): void {
    //Called after the constructor, initializing input properties, and the first call to ngOnChanges.
    //Add 'implements OnInit' to the class.
    this.sharedService.manipulateShowSubject.subscribe(data => { 
        this.counterShows = data.length;
    })
  }
  

  logout() {
    this.authService.logout();
  }
}
