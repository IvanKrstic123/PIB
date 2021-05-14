import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthService } from 'src/app/shared/services/Auth.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {

  registerForm: FormGroup;

  constructor(private builder: FormBuilder, private authService: AuthService) { }

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
    this.authService.signUp(this.registerForm.value).subscribe(
      res => console.log(res)
    );
  }
}
