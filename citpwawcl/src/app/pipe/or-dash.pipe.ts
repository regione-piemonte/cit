import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'orDash',
})
export class OrDashPipe implements PipeTransform {
  transform(value: any): any {
    return value ?? '-';
  }
}
