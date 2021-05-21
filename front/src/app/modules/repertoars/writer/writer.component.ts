import { NotificationService } from './../../../shared/services/notification.service';
import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-writer',
  templateUrl: './writer.component.html',
  styleUrls: ['./writer.component.scss']
})
export class WriterComponent implements OnInit {

  writerForm: FormGroup;
  @Output() writerEmit = new EventEmitter<any>();

  constructor(private builder: FormBuilder, private notificationService: NotificationService) { }

  ngOnInit() {
    this.initForm();
  }

  private initForm() {
    this.writerForm = this.builder.group({
      name: ['', [Validators.required, Validators.minLength(3)]],
      surname: ['', [Validators.required, Validators.minLength(5)]],
      birthdayDate: ['', Validators.required]
    })
  }

  preskoci() {
    this.writerForm.clearValidators();
    this.writerEmit.emit(1);
  }

  addWriter() {
    if(this.writerForm.invalid) {
      this.notificationService.error('Proverite jos jednom unos podataka...')
      return;
    }
    this.writerEmit.emit(this.writerForm.value)
  }
}
