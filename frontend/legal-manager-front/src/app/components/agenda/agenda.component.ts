import { Component, OnInit } from '@angular/core';
import { AgendaService } from 'src/app/services/service/agenda.service';
import { Pageable } from 'src/app/services/domain/pageable';

@Component({
  selector: 'app-agenda',
  templateUrl: './agenda.component.html',
  styleUrls: ['./agenda.component.css']
})
export class AgendaComponent implements OnInit {
  // Paginação
  page: any;
  size: any;
  previousPage: any;
  collectionSize: any;
  advancedPagination: number;
  pageable: Pageable = new Pageable();

  constructor(private agendaService: AgendaService) {
                this.advancedPagination = 1;
                this.page = 0;
                this.size = 5;
   }

  ngOnInit(): void {
    this.pageChange(1);
  }

  pageChange(page: number) {
    if (page !== this.previousPage) {
      this.previousPage = page;
      this.filtrarAlunos(page - 1);
    }
  }

  filtrarAlunos(pagina: any) {
    this.agendaService.findAllPageable(pagina, this.size).subscribe(
      (data: any) => {
        this.pageable = data;
        this.collectionSize = this.pageable.totalElements;
      },
      error => console.error(error)
    );
  }

  /**
   * TODO: Lembrar de implementar @Output
   */
  updateAgenda() {
  }

}
