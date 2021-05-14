import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/shared/services/Auth.service';

@Component({
  selector: 'app-auth',
  templateUrl: './auth.component.html',
  styleUrls: ['./auth.component.scss']
})
export class AuthComponent implements OnInit {

  switcherState: boolean = false;

  constructor() {}

  ngOnInit(): void {
  }

  toggleSignUp() {
      this.switcherState = true;
  }
  
  toggleSignIn() {
    this.switcherState = false;
  }
}
