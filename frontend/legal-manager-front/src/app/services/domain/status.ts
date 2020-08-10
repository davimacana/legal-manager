import { StringMap } from '@angular/compiler/src/compiler_facade_interface';

export class Status {

    id: string;
    nome: string;

    constructor(id: string,
                nome: string) {
                    this.id = id;
                    this.nome = nome;
    }
}
