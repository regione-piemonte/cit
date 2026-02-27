import { AbstractControl, ValidationErrors, ValidatorFn } from '@angular/forms';

export function validateCFPIVA(): ValidatorFn {
  return (control: AbstractControl): ValidationErrors | null => {
    var valid = true;
    if (control.value && control.value.length > 0 && control.value.length < 12) {
      const pivaRegex: RegExp = new RegExp("^[0-9]{11,11}$");
      valid = pivaRegex.test(control.value);
    } else if (control.value && control.value.length > 11) {
      const pivaRegex: RegExp = new RegExp("^[A-Z]{6}\\d{2}[A-Z]\\d{2}[A-Z]\\d{3}[A-Z]$");
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



