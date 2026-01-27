import { Pipe, PipeTransform } from '@angular/core';

export function zeroToNull(value: any): any {
  return value !== 0 ? value : null;
}

@Pipe({
  name: 'zeroToNull',
})
export class ZeroToNullPipe implements PipeTransform {
  transform(value: any): any {
    return zeroToNull(value);
  }
}
