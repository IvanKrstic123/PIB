import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Config } from 'protractor';
import { AuthService } from 'src/app/shared/services/Auth.service';
import { NotificationService } from 'src/app/shared/services/notification.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {

  registerForm: FormGroup;
  messageRegistration?: any = null;

  constructor(private builder: FormBuilder, private authService: AuthService, private notificationService: NotificationService) { }

  ngOnInit() {
    this.initForm();
  }

  private initForm() {
    this.registerForm = this.builder.group({
      username: [null, Validators.required],
      email: [null, [Validators.required,Validators.email]],
      password: [null, [Validators.required, Validators.minLength(8)]]
    })
  }

  register(){
    const user = {
      username: this.registerForm.get('username').value,
      email: this.registerForm.get('email').value,
      role: [],
      password: this.registerForm.get('password').value,
    }
    this.authService.signUp(user).subscribe(
      res => {
        this.messageRegistration = res
        if(this.messageRegistration.message === 'User registered successfully!'){
          this.notificationService.success('User registered successfully!')
        }
      }
    );
    
  }
}
