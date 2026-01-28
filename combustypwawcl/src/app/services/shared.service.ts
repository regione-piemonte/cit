import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';

export const EDIT_Q_PARAM = 'edit';
export const VIEW_Q_PARAM = 'view';

export const EXISTING_SECOND_TIME = 4;

@Injectable({
    providedIn: 'root'
})
export class SharedService {

    forceChangeContent = new Subject();
    datiPrecompilati: any;


    getCodiceImpiantoFromDatiPrecompilati() {
        const datiPrecompilati = this.getDatiPrecompilati();
        if (!!datiPrecompilati) {
            return datiPrecompilati.codice_impianto;
        }
        return null;
    }

    getDatiPrecompilati() {
        const datiPrecompilati = localStorage.getItem("datiPrecompilati");
        if (!!datiPrecompilati) {
            return JSON.parse(datiPrecompilati);
        }
        return null;
    }


    async doMessageBoxEvent(comp) {
        comp.isSuccess = true;
        comp.wideScreenRef?.nativeElement.scrollIntoView({ behavior: 'smooth' });
        setTimeout(() => {
            console.log("WHAT? " + comp.isSuccess + " " + comp.doFade);
            comp.doFade = true;
        }, (EXISTING_SECOND_TIME - 1) * 1000);
        setTimeout(() => {
            console.log("WHAT??? " + comp.isSuccess + " " + comp.doFade);
            comp.isSuccess = false;
            comp.doFade = false;
        }, EXISTING_SECOND_TIME * 1000);
    }


    getUtenteLoggato() {
        return JSON.parse(sessionStorage.getItem("currentUser"));
    }

    setLibrettoXmlNow(xmlNow) {
        sessionStorage.setItem("xmlNow", JSON.stringify(xmlNow));
    }

    getLibrettoXmlNow(){
        return JSON.parse(sessionStorage.getItem("xmlNow"));
    }

    setImpresaSelected(impresa){
        sessionStorage.setItem("impresaSelected", JSON.stringify(impresa));
    }

    getImpresaSelected(){
        return JSON.parse(sessionStorage.getItem("impresaSelected"));
    }
}
