import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-type-performance',
  templateUrl: './type-performance.component.html',
  styleUrls: ['./type-performance.component.scss'],
})
export class TypePerformanceComponent implements OnInit {
  typeForm: FormGroup;
  @Output() typeEmit = new EventEmitter<any>();

  constructor(private builder: FormBuilder) {}

  ngOnInit() {
    this.initForm();
  }

  private initForm() {
    this.typeForm = this.builder.group({
      type: ['', Validators.required],
    });
  }

  back() {
    this.typeEmit.emit(0);
  }

  preskoci() {
    this.typeEmit.emit(2);
  }

  addType() {
    this.typeEmit.emit(this.typeForm.value);
  }
}
