import { VerificaDetail } from '../models/verifica-detail.model';
import { Verifica } from '../models/verifica.model';

export function siglaReeCompareFn(a: string, b: string): number {
  return a === 'RP' ? -1 : a?.localeCompare(b);
}

export function getCodiceRee(verifica: Verifica): string {
  const codiceReeParts = [];

  if (verifica.siglaBollino) {
    codiceReeParts.push(verifica.siglaBollino);
  }

  if (verifica.numeroBollino) {
    codiceReeParts.push(verifica.numeroBollino);
  }

  return codiceReeParts.join(' ');
}

export function getIndirizzo(verifica: VerificaDetail): string {
  const viaParts = [];

  if (verifica.indirizzoSitad) {
    viaParts.push(verifica.indirizzoSitad);
  }

  if (verifica.indirizzoNonTrovato){
    viaParts.push(verifica.indirizzoNonTrovato);
  }

  if (verifica.civico) {
    viaParts.push(verifica.civico);
  }

  const comuneParts = [];

  if (verifica.comune) {
    comuneParts.push(verifica.comune);
  }

  const indirizzoParts = [];

  if (viaParts.length) {
    indirizzoParts.push(viaParts.join(' '));
  }

  if (comuneParts.length) {
    indirizzoParts.push(comuneParts.join(' '));
  }

  return indirizzoParts.join(', ');
}
