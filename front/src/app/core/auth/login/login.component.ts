import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/shared/services/Auth.service';
import { NotificationService } from 'src/app/shared/services/notification.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
})
export class LoginComponent implements OnInit {
  loginForm: FormGroup;

  constructor(
    private builder: FormBuilder,
    private authService: AuthService,
    private router: Router,
    private notificationService: NotificationService
  ) {}

  ngOnInit() {
    this.initForm();
  }

  private initForm() {
    this.loginForm = this.builder.group({
      username: [null, [Validators.required]],
      password: [null, [Validators.required, Validators.minLength(8)]],
    });
  }

  login() {
    this.authService.signIn(this.loginForm.value).subscribe((data) => {
      if (data) {
        this.notificationService.success('You loggin successfuly','Welcome')
        this.router.navigate(['dashboard']);
      }
    });
  }
}
