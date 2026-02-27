import { Pipe, PipeTransform } from "@angular/core";

@Pipe({ name: 'customDatePipe' })
export class CustomDatePipe implements PipeTransform {
  transform(value:string): string  {
    let splits = value.split("[");
    if(splits.length > 1) {
      return splits[0];
    } else {
      return null;
    }
  }
}
