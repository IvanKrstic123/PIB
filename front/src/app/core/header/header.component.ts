import { Component} from '@angular/core';
import { AuthService } from 'src/app/shared/services/Auth.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss'],
})
export class HeaderComponent{
  logUser: any = false;
  
  constructor(private authService: AuthService) {
      if(this.authService.currentUserValue) {
        this.logUser = true;
      }
  }
  
  

  logout() {
    this.authService.logout();
  }
}
