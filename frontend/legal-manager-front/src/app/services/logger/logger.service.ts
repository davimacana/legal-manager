import { Injectable } from '@angular/core';

@Injectable({
    providedIn: 'root'
})
export class Logger {
    log(msg: string) {
        console.log(msg);
    }

    error(msg: string) {
        console.error(msg);
    }
}
