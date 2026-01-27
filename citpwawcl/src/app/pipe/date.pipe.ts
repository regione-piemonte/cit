import { Pipe, PipeTransform } from "@angular/core";

@Pipe({ name: 'customDatePipe' })
export class CustomDatePipe implements PipeTransform {
  transform(value: string | any): string {
    if (value == null) { return null; }
    let splits = value.split("[");
    if (splits.length > 1) {
      return splits[0];
    } else {
      return null;
    }
  }
}
