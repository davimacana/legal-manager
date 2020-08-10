import { catchError } from 'rxjs/operators';
import { BaseService } from './base.service';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Agenda } from '../domain/agenda';
import { Logger } from '../logger/logger.service';
import { NotificationService } from '../logger/notification.service';

@Injectable({
  providedIn: 'root'
})
export class AgendaService extends BaseService {

  private serviceURL = `${this.baseUrl}/agenda`;

  constructor(protected http: HttpClient, protected logger: Logger,
              protected notifyService: NotificationService) {
    super(http, logger, notifyService);
  }

  /**
   * Retorna as agendas.
   */
  findAllPageable(page: string, size: string): Observable<Agenda> {
      return this.http.get<Agenda>(`${this.serviceURL}` + '?size=' + size + '&page=' + page).pipe(
          catchError(this.handleError('findAgenda', 'Agenda'))
      );
  }

  /**
   * Cadastrar Agenda.
   * @param agenda objeto a ser inserido no backend
   */
  addAgenda(agenda: Agenda): Observable<Agenda> {
    return this.http.post<Agenda>(this.serviceURL, agenda).pipe(
      catchError(
        this.handleError('addAgenda', 'Agenda')
      )
    );
  }
}
