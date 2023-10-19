export enum TipoDoc {
    REE_1 = '3',
    REE_2 = '4',
    REE_3 = '5',
    REE_4 = '6',
    REE_1B = '14',
    MANUT_GT = '10',
    MANUT_GF = '11',
    MANUT_SC = '12',
    MANUT_CG = '13'
}

export const tipiDocDesc = new Map<string, string>([
    [TipoDoc.REE_1, 'REE TIPO 1'],
    [TipoDoc.REE_2, 'REE TIPO 2'],
    [TipoDoc.REE_3, 'REE TIPO 3'],
    [TipoDoc.REE_4, 'REE TIPO 4'],
    [TipoDoc.REE_1B, 'REE TIPO 1B'],
    [TipoDoc.MANUT_GT, 'MANUTENZIONE GT'],
    [TipoDoc.MANUT_GF, 'MANUTENZIONE GF'],
    [TipoDoc.MANUT_SC, 'MANUTENZIONE SC'],
    [TipoDoc.MANUT_CG, 'MANUTENZIONE CG'],
]);