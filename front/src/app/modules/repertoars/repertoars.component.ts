import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-repertoars',
  templateUrl: './repertoars.component.html',
  styleUrls: ['./repertoars.component.scss']
})
export class RepertoarsComponent implements OnInit {

  repositoryForm: FormGroup;
  isCollapse: boolean = false;

  constructor(private builder: FormBuilder) { }

  ngOnInit(): void {
    this.initForm();
  }

  private initForm() {
    this.repositoryForm = this.builder.group({
      title: [null, Validators.required],
      duration: [null, Validators.required],
      description: [null, Validators.required],
      writerName: [null, Validators.required],
      writerSurname: [null, Validators.required],
      writerDate: [null, Validators.required],
      type: [null, Validators.required]
    })
  }

  addRepository() {

  }

  toggle() {
    
    this.isCollapse = !this.isCollapse

    console.log(this.isCollapse)
  }
}
