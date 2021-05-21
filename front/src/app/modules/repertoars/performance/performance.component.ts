import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Component, EventEmitter, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-performance',
  templateUrl: './performance.component.html',
  styleUrls: ['./performance.component.scss']
})
export class PerformanceComponent implements OnInit {

  @Output() perfromancEmit = new EventEmitter<any>();

  performanceForm: FormGroup;

  writerGroup: any = [{
    id: 1,
    name: 'Kuzma'
  }, {
    id: 2,
    name: 'Pile'
  }];

  typeGroup: any = [{
    id: 1,
    name: 'Komedija'
  }, {
    id: 2,
    name: 'Drama'
  }]

  typeModel: any = null;
  writerModel: any = null;

  constructor(private builder: FormBuilder) { }

  ngOnInit() {
    this.initForm();
  }

  private initForm() {
    this.performanceForm = this.builder.group({
      title: ['', Validators.required],
      description: ['', Validators.required],
      duration: ['', Validators.required],
      type: ['', Validators.required],
      writer: ['', Validators.required]
    })
  }

  onSelectWriter($event) {
      this.performanceForm.get('writer').patchValue($event)
      console.log(this.performanceForm.get('writer').value)
  }

  onSelectType($event) {
    this.performanceForm.get('type').patchValue($event)
    console.log(this.performanceForm.get('type').value)
  }

  back() {
    this.perfromancEmit.emit(1)
  }

  addPerformance() {
    this.perfromancEmit.emit(this.performanceForm.value);
  }

}
