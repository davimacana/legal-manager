import { StringMap } from '@angular/compiler/src/compiler_facade_interface';
import { StringDecoder } from 'string_decoder';

export class Tipo {

    id: string;
    nome: string;

    constructor(id: string,
                nome: string) {
                    this.id = id;
                    this.nome = nome;
    }
}
