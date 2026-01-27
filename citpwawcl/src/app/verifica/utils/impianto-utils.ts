export function getIndirizzo(impianto: any): string {
  const data = impianto.properties;

  const viaParts = [];

  if (data.Indirizzo) {
    viaParts.push(data.Indirizzo);
  }

  if (data.Civico) {
    viaParts.push(data.Civico);
  }

  const comuneParts = [];

  if (data.Comune) {
    comuneParts.push(data.Comune);
  }

  if (data.Provincia) {
    comuneParts.push(`(${data.Provincia})`);
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
