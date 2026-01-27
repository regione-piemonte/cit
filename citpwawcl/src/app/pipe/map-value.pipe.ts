import { Pipe, PipeTransform } from '@angular/core';

@Pipe({ name: 'mapValue' })
export class MapValuePipe implements PipeTransform {
    transform(map: any[]): any {
        let ret = [];

        map.forEach((obj) => {
            const keys = Object.keys(obj);
            const values = Object.values(obj);
            ret.push({ key: keys[0], value: values[0] });
        });

        return ret;
    }
}
