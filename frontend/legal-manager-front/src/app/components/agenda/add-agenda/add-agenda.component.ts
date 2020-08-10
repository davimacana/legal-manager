import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { NgbModal, NgbModalConfig, ModalDismissReasons, NgbDateStruct, NgbCalendar, NgbDate, NgbDatepicker } from '@ng-bootstrap/ng-bootstrap';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { NotificationService } from 'src/app/services/logger/notification.service';
import { Tipo } from 'src/app/services/domain/tipo';
import { Status } from 'src/app/services/domain/status';
import { AgendaService } from 'src/app/services/service/agenda.service';
import { Agenda } from 'src/app/services/domain/agenda';

@Component({
  selector: 'app-add-agenda',
  templateUrl: './add-agenda.component.html',
  styleUrls: ['./add-agenda.component.css']
})
export class AddAgendaComponent implements OnInit {

  @Input() tipos: Tipo[] = [];
  @Input() status: Status[] = [];
  @Output() atualizaPai = new EventEmitter();

  closeResult: string;
  agendaForm: FormGroup;

  constructor(private modalService: NgbModal,
              private formBuilder: FormBuilder,
              private notify: NotificationService,
              config: NgbModalConfig,
              private agendaService: AgendaService) {
                config.backdrop = 'static';
                config.keyboard = false;
              }

  ngOnInit(): void {
    this.agendaForm = this.formBuilder.group({
      tipoAgenda: [null, [Validators.required]],
      descricao: ['', [Validators.required, Validators.maxLength(250)]],
      dataAgenda: ['', [Validators.required]]
    });
  }

  get f() {
    return this.agendaForm.controls;
  }

  open(content) {
    this.modalService.open(content).result.then((result) => {
        this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
        this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
    });
  }

  private getDismissReason(reason: any): string {
    if (reason === ModalDismissReasons.ESC) {
        return 'by pressing ESC';
    } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
        return 'by clicking on a backdrop';
    } else {
        return `with: ${reason}`;
    }
  }

  onSubmit() {
    if (this.agendaForm.invalid) {
      return;
    } else {
      const date = this.f.dataAgenda.value.day + '/' + this.f.dataAgenda.value.month + '/' + this.f.dataAgenda.value.year;
      const agenda = new Agenda(null, this.f.tipoAgenda.value, this.f.descricao.value, null, date, null);
      this.agendaService.addAgenda(agenda).subscribe(
        (data: any) => {
          this.atualizaPai.emit(JSON.stringify(data));
          this.notify.showSuccess('Agenda incluída com sucesso.', 'Agenda');
          this.modalService.dismissAll(1);
        }
      );
    }
  }

  changeDropDownTipo = (tipo: any) => this.f.tipoAgenda.setValue(tipo);

  dropDownTipo = () => {
    if (this.f.tipoAgenda.value != null) {
      return this.f.tipoAgenda.value.nome;
    }
    return 'Selecione o tipo da agenda';
  }
}
