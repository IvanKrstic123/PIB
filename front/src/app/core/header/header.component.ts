import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/shared/services/Auth.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss'],
})
export class HeaderComponent implements OnInit {
  logUser: any = false;
  constructor(private authService: AuthService, private router: Router) {}

  ngOnInit(): void {
    this.logUser = this.authService.getCurrentUser();  //header.ts
  }

  logout() {
    this.authService.logOutUser();
    this.router.navigate(['auth']);
  }
}
