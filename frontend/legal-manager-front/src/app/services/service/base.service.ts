import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Logger } from '../logger/logger.service';
import { NotificationService } from '../logger/notification.service';

@Injectable({
  providedIn: 'root'
})
export class BaseService {

  protected baseUrl = this.getBackendApiUrl();
  msgError = 'Ocorreu um erro no servidor, favor, entrar em contato com o administrador do sistema com o código: ';

  constructor(protected http: HttpClient, protected logger: Logger,
              protected notifyService: NotificationService) {}

  /**
   * Prepare an error handler for failed HTTP requests.
   * That handler extracts the error message and logs it.
   * It also adds the message to the errors$ observable to which the caller
   * may listen and react.
   * @param operation The name/description of the operation that failed
   * @param method The HTTP method for the failed HTTP request
   */
  protected handleError(operation: string, method: string) {
    return function errorHandler(res: HttpErrorResponse) {
        this.logger.error(res);
        const eMsg = res.message || '';
        const error = `${operation} Error${eMsg ? ': ' + eMsg : '' }`;
        if (res.error.code === 400) {
          this.notifyService.showWarning(res.error.error, method);
        } else if (res.error.code === 500) {
          this.notifyService.showError(this.msgError + res.error.codeErrorRandom, method);
          console.error(this.msgError + res.error.codeErrorRandom);
        } else {
          this.notify(error, method, true);
        }
        this.spinner.hide();
    }.bind(this);
  }

  /**
   * Show stick messages on client browser.
   *
   * @param message message to show.
   * @param method method called.
   * @param isError defines if the message is a error or not.
   */
  protected notify(message: string, method: string, isError: boolean = false) {
    if (isError) {
      this.notifyService.showError(message, method);
    } else {
      this.notifyService.showSuccess(message, method);
    }
  }

  /**
   * Recupera a url do backend de forma dinamica
   */
  protected getBackendApiUrl() {
    const protocol = window.location.protocol;
    const hostname = window.location.hostname;
    const port = window.location.port;
    const serverUrl = protocol + '//' + hostname + ':' + port;
    const apiPath = '/legal-api';
    const backendUrlLocal = 'http://localhost:8080' + apiPath;

    if (serverUrl.includes('localhost:4200')) {
      return backendUrlLocal;
    } else {
      return serverUrl + apiPath;
    }
  }
}
