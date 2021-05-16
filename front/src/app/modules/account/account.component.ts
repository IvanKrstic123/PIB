import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.scss'],
})
export class AccountComponent implements OnInit {
  accountForm: FormGroup;

  constructor(private builder: FormBuilder) {}

  ngOnInit(): void {
    this.initForm();
    const user = JSON.parse(localStorage.getItem('USER_DATA'));
    if(user) {
      this.accountForm.patchValue({
        username: user.username,
        email: user.email,
        password: ''
      })
    }
  }

  private initForm() {
    this.accountForm = this.builder.group({
      username: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      password: ['', Validators.required, Validators.minLength(6)],
    });
  }

  update() {

  }
}
