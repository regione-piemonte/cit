import { AbstractControl, ValidationErrors, ValidatorFn } from '@angular/forms';
import { MESSAGGIO_DECIMALE } from '../utils/constants';

export function validateCFPIVA(): ValidatorFn {
  return (control: AbstractControl): ValidationErrors | null => {
    var valid = true;
    if (control.value && control.value.length > 0 && control.value.length < 11) {
      const pivaRegex: RegExp = new RegExp("^[0-9]{11,11}$");
      valid = pivaRegex.test(control.value);
    } else if (control.value && control.value.length > 11) {
      const pivaRegex: RegExp = new RegExp("^[a-zA-Z0-9_]{16}$");
      valid = pivaRegex.test(control.value);
    }
    return !valid ? { invalidCFPIva: { value: control.value } } : null;
  };
}

export function validateNumbers(): ValidatorFn { 
  return (control: AbstractControl): ValidationErrors | null => {
    var valid = true;
    const pivaRegex: RegExp = new RegExp("^[0-9]*$");
    valid = pivaRegex.test(control.value);
    return !valid ? { invalidString: { value: control.value } } : null;
  };
}

export function validateAlphanumeric(): ValidatorFn {
  return (control: AbstractControl): ValidationErrors | null => {
    var valid = true;
    const pivaRegex: RegExp = new RegExp("^[a-zA-Z0-9_]*$");
    valid = pivaRegex.test(control.value);
    return !valid ? { invalidString: { value: control.value } } : null;
  };
}

export function validatePOD(): ValidatorFn {
  return (control: AbstractControl): ValidationErrors | null => {
    var valid = true;
    const regex: RegExp = new RegExp("IT[0-9]{3}[E]{1}[0-9]+");
    valid = regex.test(control.value.toUpperCase());
    return !valid ? { invalidString: { value: control.value } } : null;
  };
}

export function validatePDR(): ValidatorFn {
  return (control: AbstractControl): ValidationErrors | null => {
    var valid = true;
    const regex: RegExp = new RegExp(/^[0-9]{14}$/);
    valid = regex.test(control.value);
    return !valid ? { invalidString: { value: control.value } } : null;
  };
}

export function validateDateBefore(): ValidatorFn {
  return (control: AbstractControl): ValidationErrors | null => {
    var valid = control.value < new Date();
    return !valid ? { invalidString: { value: control.value } } : null;
  };
}

export function validateDateIstall(dataDismiss: Date): ValidatorFn {
  return (control: AbstractControl): ValidationErrors | null => {
    var valid = control.value > dataDismiss;
    return !valid ? { invalidString: { value: control.value } } : null;
  };
}

export function validateIndirizzo(): ValidatorFn {
  return (control: AbstractControl): ValidationErrors | null => {
    return typeof control.value === "string" ? { indirizzoNonSelezionato: true } : null;
  };
}

export function formatoDecimale(numberRegex: RegExp, interi: number, decimali: number): ValidatorFn {
  return (control: AbstractControl): ValidationErrors | null => {
    const valid = numberRegex.test(control.value);
    return control.value && !valid ? { erroreFormatoDecimale: { value: MESSAGGIO_DECIMALE.replace("{interi}", interi.toString()).replace("{decimali}", decimali.toString()) } } : null;
  };
}

