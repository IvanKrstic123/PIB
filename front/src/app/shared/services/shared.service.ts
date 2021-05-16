import { BehaviorSubject } from 'rxjs';
import { NotificationService } from 'src/app/shared/services/notification.service';
import { Injectable } from '@angular/core';
import { FormGroup } from '@angular/forms';

@Injectable({
  providedIn: 'root',
})
export class SharedService {
  public successfullRegistration = new BehaviorSubject<any>(null);
  public manipulateShowSubject = new BehaviorSubject<any>([]);

  constructor(private notificationService: NotificationService) {}

  public markInvalid(formGroup: FormGroup) {
    if (formGroup.invalid) {
      (Object as any).values(formGroup.controls).forEach((control: any) => {
        control.markAsTouched();
        if (control.controls) {
          this.markInvalid(control);
        }
      });
      this.notificationService.warning(
        'Please fill all required fields.',
        'Warning:'
      );
      return false;
    } else {
      (Object as any).values(formGroup.controls).forEach((control: any) => {
        control.markAsTouched();
        if (control.controls) {
          this.markInvalid(control);
        }
      });
      return true;
    }
  }
}
