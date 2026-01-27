export interface GroupChip {
  num: number;
  fabbricante: string;
  modello: string;
  tipologia: 'frigo' | 'termici';
  dataInstall: number;
  combustibile?: string;
}
