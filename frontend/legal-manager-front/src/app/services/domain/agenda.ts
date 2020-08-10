import { StringMap } from '@angular/compiler/src/compiler_facade_interface';
import { Tipo } from './tipo';
import { Status } from './status';

export class Agenda {

    id: string;
    tipo: Tipo;
    descricao: string;
    dataInicio: string;
    dataAgenda: string;
    status: Status;

    constructor(id: string,
                tipo: Tipo,
                descricao: string,
                dataInicio: string,
                dataAgenda: string,
                status: Status) {
                    this.id = id;
                    this.tipo = tipo;
                    this.descricao = descricao;
                    this.dataInicio = dataInicio;
                    this.dataAgenda = dataAgenda;
                    this.status = status;
    }
}
