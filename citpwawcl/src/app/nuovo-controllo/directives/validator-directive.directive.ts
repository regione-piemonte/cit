import { Directive } from '@angular/core';
import { AbstractControl, ValidationErrors, ValidatorFn } from '@angular/forms';

export const checkboxCheck: ValidatorFn = (control: AbstractControl): ValidationErrors | null => {
  const clima = control.get('climaInvernale');
  const prod = control.get('prodAcs');
  return !(clima.value || prod.value) ? { checkboxCheck: true } : null;
};
export const checkboxCheck1B: ValidatorFn = (control: AbstractControl): ValidationErrors | null => {
  const clima = control.get('climaInvernale');
  const prod = control.get('prodAcs');
  const cucina = control.get('cucina');
  return !(clima.value || prod.value || cucina.value) ? { checkboxCheck: true } : null;
};
export const checkboxCheck2: ValidatorFn = (control: AbstractControl): ValidationErrors | null => {
  const clima = control.get('climatizInv');
  const prod = control.get('produzACS');
  return !(clima.value || prod.value) ? { checkboxCheck: true } : null;
};
@Directive({
  selector: '[appValidatorDirective]'
})
export class ValidatorDirectiveDirective {

  constructor() {
    //Not Implemented
   }


}
export function validateTrattamentoAcqua(val: string): ValidatorFn {
  return (control: AbstractControl): ValidationErrors | null => {
    const error = !val && control.value;
    return error ? { nonRichiesto: true } : null;
  };
}

export function rendimentoPercValidator(): ValidatorFn {
  return (control: AbstractControl): ValidationErrors | null => {
    return control.value > 120 ? { rendimento: true } : null;
  };
}
