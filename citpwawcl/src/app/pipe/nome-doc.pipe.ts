import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'nomeDocPipe'
})
export class NomeDocPipe implements PipeTransform {

  transform(value: string, maxLength: number): string {
    if(value.length > maxLength) {
      const dots = '...';
      const extension = value.substring(value.lastIndexOf('.'));
      const nome = value.substring(0, value.length - extension.length);
      return `${nome.substring(0, maxLength - extension.length - dots.length)}${dots}${extension}`
    }
    return value;
  }

}
