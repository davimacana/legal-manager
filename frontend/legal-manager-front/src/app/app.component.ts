import { Component, OnInit } from '@angular/core';
import { DomainService } from './services/service/domain.service';
import { Tipo } from './services/domain/tipo';
import { Status } from './services/domain/status';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  title = 'Projeto Agenda';
  tipos: Tipo[] = [];

  constructor(private domainService: DomainService) { }

  ngOnInit(): void {
    this.domainService.findAllTipos().subscribe(
      (data: any)  => this.tipos = data,
      error => console.error(error)
    );
  }
}
