import { catchError } from 'rxjs/operators';
import { BaseService } from './base.service';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Agenda } from '../domain/agenda';
import { Logger } from '../logger/logger.service';
import { NotificationService } from '../logger/notification.service';
import { Tipo } from '../domain/tipo';
import { Status } from '../domain/status';

@Injectable({
  providedIn: 'root'
})
export class DomainService extends BaseService {

  private serviceURLTipo = `${this.baseUrl}/tiposAgenda`;
  private serviceURLStatus = `${this.baseUrl}/statusAgenda`;

  constructor(protected http: HttpClient, protected logger: Logger,
              protected notifyService: NotificationService) {
    super(http, logger, notifyService);
  }

  /**
   * Retorna os tipos.
   */
  findAllTipos(): Observable<Tipo> {
      return this.http.get<Tipo>(`${this.serviceURLTipo}`).pipe(
          catchError(this.handleError('findTipo', 'Tipo'))
      );
  }

  /**
   * Retorna os status.
   */
  findAllStatus(): Observable<Status> {
    return this.http.get<Status>(`${this.serviceURLStatus}`).pipe(
        catchError(this.handleError('findStatus', 'Status'))
    );
}
}
