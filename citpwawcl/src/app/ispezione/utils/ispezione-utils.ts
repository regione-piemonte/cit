import { IspezioneDetail } from '../models/ispezione-detail.model';

export function getIndirizzo(ispezione: IspezioneDetail): string {
  const viaParts = [];

  if (ispezione.indirizzoSitad) {
    viaParts.push(ispezione.indirizzoSitad);
  }

  if (ispezione.indirizzoNonTrovato){
    viaParts.push(ispezione.indirizzoNonTrovato);
  }

  if (ispezione.civico) {
    viaParts.push(ispezione.civico);
  }

  const comuneParts = [];

  if (ispezione.denominazioneComune) {
    comuneParts.push(ispezione.denominazioneComune);
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
