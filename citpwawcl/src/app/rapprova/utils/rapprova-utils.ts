import { TITOLI } from "src/app/utils/constants";
import { Categoria } from "../models/categoria.model";

export const IMPIANTO_NON_CONFORME_DLGS_102_2014_TITLE = 'Attenzione';
export const IMPIANTO_NON_CONFORME_DLGS_102_2014_MESSAGE = 'L\'impianto centralizzato oggetto del presente rapporto di controllo, non è conforme all\'obbligo di installazione di un sistema di contabilizzazione / ripartizione ai sensi del dlgs 102/2014 e non risulta caricata nessuna relazione di deroga all\'obbligo';

export function forceArray(maybeArray: any): any[] {
  if (Array.isArray(maybeArray)) {
    return maybeArray;
  }

  return maybeArray ? [maybeArray] : [];
}

export function datiPrecompilatiToCatasto(datiPrecompilati: any): any {
  const catastoList = forceArray(datiPrecompilati.sezCatasto.rowCatasto);

  const sezione = catastoList.find(c => c.L1_2sezione !== null)?.L1_2sezione;
  const foglio = catastoList.find(c => c.L1_2foglio !== null)?.L1_2foglio;
  const particella = catastoList.find(c => c.L1_2particella !== null)?.L1_2particella;
  const sub = catastoList.find(c => c.L1_2sub !== null)?.L1_2sub;
  const pod = catastoList.find(c => c.L1_2pod !== null)?.L1_2pod;
  const pdr = catastoList.find(c => c.L1_2pdr !== null)?.L1_2pdr;

  return { sezione, foglio, particella, sub, pod, pdr };
}

export function datiPrecompilatiToResponsabile(datiPrecompilati: any): string {
  const now = new Date().getUTCMilliseconds();
  const nomineValide = forceArray(datiPrecompilati.sezNomine.rowNomine)
    .filter(n => n.L3dataValiditaContrattoDal < now && (!n.L3dataValiditaContrattoAl || n.L3dataValiditaContrattoAl > now));

  let descr;
  let qualita;

  if (nomineValide.length) {
    const primaNomina = nomineValide[0];

    descr = `${primaNomina.L3ragSocialeDitta} ${primaNomina.L3codiceFiscaleDitta} ${primaNomina.L3cciaa}`;
    qualita = primaNomina.L3flagAmministratore ? 'Amministratore' : (primaNomina.L3flagProprietario ? 'Proprietario' : 'Occupante');
  } else {
    const nominativo = datiPrecompilati.L1_6cognome && datiPrecompilati.L1_6nome && datiPrecompilati.L1_6cf
      ? `${datiPrecompilati.L1_6cognome} ${datiPrecompilati.L1_6nome} (${datiPrecompilati.L1_6cf})`
      : `${datiPrecompilati.L1_6ragSociale} ${datiPrecompilati.L1_6piva}`;

    descr = `${nominativo}, ${datiPrecompilati.L1_6indirizzo} ${datiPrecompilati.L1_6civico}, ${datiPrecompilati.L1_6provincia}`;
    qualita = TITOLI.find(t => t.id === datiPrecompilati.L1_6titolo)?.desc ?? '-';
  }

  return `${descr} in qualità di ${qualita}`;
}

export function datiSchedaIdentificativaImpToCategoriaEdificio(datiSchedaIdentificativaImp: any, categoriaList: Categoria[]): string {
  let num;

  if (datiSchedaIdentificativaImp.L1_2flagE1) {
    num = 1;
  } else if (datiSchedaIdentificativaImp.L1_2flagE2) {
    num = 2;
  } else if (datiSchedaIdentificativaImp.L1_2flagE3) {
    num = 3;
  } else if (datiSchedaIdentificativaImp.L1_2flagE4) {
    num = 4;
  } else if (datiSchedaIdentificativaImp.L1_2flagE5) {
    num = 5;
  } else if (datiSchedaIdentificativaImp.L1_2flagE6) {
    num = 6;
  } else if (datiSchedaIdentificativaImp.L1_2flagE7) {
    num = 7;
  } else if (datiSchedaIdentificativaImp.L1_2flagE8) {
    num = 8;
  }

  const categoria = categoriaList.find(c => c.idCategoria === `E.${num}`);

  return categoria ? `${categoria.idCategoria} - ${categoria.desCategoria}` : undefined;
}

export function datiSchedaIdentificativaImpToUsoImpianto(datiSchedaIdentificativaImp: any): string {
  const array = [];

  if (datiSchedaIdentificativaImp.L1_3potUtileACS) {
    array.push('Produzione ACS');
  }

  if (datiSchedaIdentificativaImp.L1_3potUtileClimaInv) {
    array.push('Riscaldamento ambienti');
  }

  return array.join(', ');
}

export function datiSchedaTrattH2OToInRiscaldamento(datiSchedaTrattH2O: any): string {
  if (datiSchedaTrattH2O == undefined || datiSchedaTrattH2O == null) {
    return null;
  }

  if (datiSchedaTrattH2O.L2_3flagAssenteH2Oclima) {
    return 'ASSENTE';
  }

  if (datiSchedaTrattH2O.L2_3flagFiltrazione) {
    return 'FILTRAZIONE';
  }

  if (datiSchedaTrattH2O.L2_3flagAddolcimento) {
    return 'ADDOLCIMENTO';
  }

  if (datiSchedaTrattH2O.L2_3flagCondizChimico) {
    return 'CONDIZ. CHIMICO';
  }

  return undefined;
}

export function datiSchedaTrattH2OToInProduzioneDiAcs(datiSchedaTrattH2O: any): string {
  if (datiSchedaTrattH2O == undefined || datiSchedaTrattH2O == null) {
    return null;
  }

  if (datiSchedaTrattH2O.L2_4flagAssente) {
    return 'ASSENTE';
  }

  if (datiSchedaTrattH2O.L2_4flagFiltrazione) {
    return 'FILTRAZIONE';
  }

  if (datiSchedaTrattH2O.L2_4flagAddolcimento) {
    return 'ADDOLCIMENTO';
  }

  if (datiSchedaTrattH2O.L2_4flagCondizChimico) {
    return 'CONDIZ. CHIMICO';
  }

  return undefined;
}

export function gfToSorgenteLatoEsterno(gf: any): string {
  if (gf.L4_4flagSorgARIA) {
    return 'Aria';
  }

  if (gf.L4_4flagSorgACQUA) {
    return 'Acqua';
  }

  return undefined;
}

export function gfToFluidoLatoUtenze(gf: any): string {
  if (gf.L4_4flagFluidoARIA) {
    return 'Aria';
  }

  if (gf.L4_4flagFluidoACQUA) {
    return 'Acqua';
  }

  return undefined;
}

export function gfToTipoMacchina(gf: any): string {
  if (gf.L4_4flagRecupCalore) {
    return 'Ad assorbimento per recupero di calore';
  }

  if (gf.L4_4flagFiammaDiretta) {
    return 'Ad assorbimento a fiamma diretta con combustibile';
  }

  if (gf.L4_4flagCicloCompress) {
    return 'A ciclo di compressione con motore elettrico o endotermico';
  }

  return undefined;
}

export function gtToTipologiaGruppoTermico(gt: any): string {
  if (gt.L4_1GTsingolo) {
    return 'Gruppo termico singolo';
  }

  if (gt.L4_1GTModulare) {
    return 'Gruppo termico modulare';
  }

  if (gt.L4_1tupoRadiante) {
    return 'Tubo/nastro radiante';
  }

  if (gt.L4_1GenAriaCalda) {
    return 'Generatore d\'aria calda';
  }

  return undefined;
}

export function datiRapProvaWebGtToSingoloTipo(datiRapProvaWebGt: any): string {
  if (datiRapProvaWebGt.s6iFlgTipoB) {
    return 'B';
  }

  if (datiRapProvaWebGt.s6iFlgTipoC) {
    return 'C';
  }

  return null;
}

export function moduloToPercentualeDi(modulo: any): string {
  if (modulo.s8dO2Perc) {
    return 'o2';
  }

  if (modulo.s8dCo2Perc) {
    return 'co2';
  }

  return null;
}
