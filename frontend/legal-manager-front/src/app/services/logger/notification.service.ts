import { Injectable } from '@angular/core';
import { ToastrService } from 'ngx-toastr';

@Injectable({
  providedIn: 'root'
})
export class NotificationService {

  constructor(private toastr: ToastrService) { }

  showSuccess(message: string, title: string) {
    this.toastr.success(message, title,  {
      timeOut: 3000
    });
  }

  showError(message: string, title: string) {
    this.toastr.error(message, title,  {
      disableTimeOut: true,
      closeButton: true,
      tapToDismiss: false
    });
  }

  showWarning(message: string, title: string) {
    this.toastr.warning(message, title, {
      disableTimeOut: true,
      closeButton: true,
      tapToDismiss: false
    });
  }

  showInfo(message: string, title: string) {
    this.toastr.info(message, title, {
      timeOut: 3000
    });
  }

}
