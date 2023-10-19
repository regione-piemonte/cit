export class Mod {
    richiesta: Richiesta;
}

export class Richiesta {
    datiManutentore: DatiManutentore;
    datiIntestazione: DatiIntestazione;
    datiAllegato: datiAllegato;
}

export class DatiManutentore {
    siglaREA: string;
    numeroREA: string;
    codiceFiscale: string;
}

export class DatiIntestazione {
    codiceBollino: string;
    codiceCatasto: string;
    dataControllo: string;
}

export class datiAllegato {
    datiIdentificativi: DatiIdentificativi;
    documentazioneTecnica: DocumentazioneTecnica;
    trattamentoAcqua: TrattamentoAcqua;
    controlloImpianto: ControlloImpianto;
    checkList: CheckList;
    datiTecnico: DatiTecnico;
    allegato: Allegato;
}

export class DatiIdentificativi {
    potenzaTermicaNomTotMax: number;
}

export class DocumentazioneTecnica {
    flagDichiarazConf: boolean;
    flagManutGen: boolean;
    flagLibrettoImp: boolean;
    flagLibrettoComp: boolean;
}

export class TrattamentoAcqua {
    flagTrattH2ONR: boolean;
    flagTrattAcsNR: boolean;
    tabAcquaReintegro: TabAcquaReintegro;
}

export class ControlloImpianto {
    flagInterno: number;
    flagCanaleFumo: number;
    flagEsterno: number;
    flagSistRegolaz: number;
    flagAperture: number;
    flagPerdite: number;
    flagDimensioni: number;
    flagTenuta: number;
    flagPuliziaCamino: number;
    //tipo2
    flagLocaleIdoneo: number;
    flagLineeIdonee: number;
    flagCoibenIdonee: number;
    //tipo3
    flagLuogoIdoneo: number;
    flagStatoCoiben: number;
    //tipo4
    flagCapsulaInso: number;
    flagTenutaIdraulica: number;
    flagTenutaOlio: number;
    flagTenutaAlimentaz: number;
    flagFunzionalita: number;
}

export class CheckList {
    flagValvole: boolean;
    flagIsolamento: boolean;
    flagSistTrattACS: boolean;
    flagSistRegolaz: boolean;
    osservazioni: string;
    raccomandazioni: string;
    prescrizioni: string;
    //tipo2
    flagSostGen1: boolean;
    flagSostGen2: boolean;
    flagIsolamentoRete: boolean;
    flagIsolamentoCanali: boolean;
    //tipo3
    flagCurvaClim: boolean;
    flagPerditaH2O: boolean;
    flagInvolucro: boolean;
}

export class DatiTecnico {
    flagFunzImp: boolean;
    dataIntervento: string;
    orarioArrivo: string;
    orarioPartenza: string;
    nomeTecnico: string;
    cognomeTecnico: string;
    firmaTecnico: string;
    firmaResp: string;
}

export class Allegato {
    rowAllegato: RowAllegato[];
}

export class RowAllegato {
    num: number;
    tabFumi: TabFumi;
    controlloVerificaEnergetica: ControlloVerificaEnergetica;
    tabCombustibile: TabCombustibile;
}

export class TabFumi {
    rowFumi: RowFumi[];
}

export class RowFumi {
    tempFumi: number;
    tempAria: number;
    o2: number;
    co2: number;
    bacharach1: number;
    bacharach2: number;
    bacharach3: number;
    cOcorretto: number;
    rendimCombu: number;
    rendimentoLegge: number;
    nox: number;
    moduloTermico: number;
    portataCombu: string;
    valorePortata: number;
    coFumiSecchi: number;
    rispettoIndBacharach: boolean;
    minimo: boolean;
    //tipo1B
    particolato: number;
    noxUM: string;
    //tipo2
    surrisc: number;
    sottoRaffr: number;
    condens: number;
    evaporaz: number;
    ingLatoEst: number;
    uscLatoEst: number;
    ingLatoUtenze: number;
    uscLatoUtenze: number;
    numCircuito: number;
    tuscFluido: number;
    tbulboUmido: number;
    tingFluidoSorg: number;
    tuscFluidoSorg: number;
    tingFluidoMacc: number;
    tuscFluidoMacc: number;
    potenzaAss: number;
    filtriPuliti: boolean;
    verifica: boolean;
    dataRipristino: string;
    //tipo3
    tempEst: number;
    tempMandPrim: number;
    tempRitPrim: number;
    potenzaTerm: number;
    portataFluido: number;
    tempMandSecond: number;
    tempRitSecond: number;
    //tipo4
    tempAriaCombur: number;
    tempAcquaUsc: number;
    tempAcquaIng: number;
    potenzaMorsetti: number;
    tempH2Omotore: number;
    tempFumiAvalle: number;
    tempFumiAmonte: number;
    sovraFreqSoglia1: number;
    sovraFreqSoglia2: number;
    sovraFreqSoglia3: number;
    sovraFreqTempo1: number;
    sovraFreqTempo2: number;
    sovraFreqTempo3: number;
    sottoFreqSoglia1: number;
    sottoFreqSoglia2: number;
    sottoFreqSoglia3: number;
    sottoFreqTempo1: number;
    sottoFreqTempo2: number;
    sottoFreqTempo3: number;
    sovraTensSoglia1: number;
    sovraTensSoglia2: number;
    sovraTensSoglia3: number;
    sovraTensTempo1: number;
    sovraTensTempo2: number;
    sovraTensTempo3: number;
    sottoTensSoglia1: number;
    sottoTensSoglia2: number;
    sottoTensSoglia3: number;
    sottoTensTempo1: number;
    sottoTensTempo2: number;
    sottoTensTempo3: number;

}

export class ControlloVerificaEnergetica {
    potenzaFocolare: number;
    flagClimatizInv: boolean;
    flagProduzACS: boolean;
    flagDispComando: boolean;
    flagDispSicu: boolean;
    flagValvSicu: boolean;
    flagScambiatore: boolean;
    flagRiflusso: boolean;
    flagRisultati: boolean;
    altroRifNormativo: string;
    flagEvacFumi: string;
    depressCanaleFumo: number;
    //tipo1B
    flagCaldaia: boolean;
    flagStufa: boolean;
    flagStufaAccumulo: boolean;
    flagTermocucina: boolean;
    flagCaminoAperto: boolean;
    flagCaminoChiuso: boolean;
    flagInsertoCamino: boolean;
    flagStufaAssemblata: boolean;
    flagStufaPellet: boolean;
    stelle: number;
    apparecchiatura: number;
    flagCucina: boolean;
    flagMarcaturaCEE: boolean;
    flagPlaccaCamino: boolean;
    ariaComburente: number;
    controlloAria: number;
    carcaCombu: number;
    //tipo2
    flagModalita: string;
    flagPerdite: number;
    flagRilevFugheDiretta: number;
    flagRilevFugheInDiretta: number;
    flagScambPuliti: number;
    //tipo3
    combustibile: string;
    fluidoVett: string;
    flagPotComp: number;
    flagStatoCoiben: number;
    flagDispReg: number;
    //tipo4
    potenzaAssorbita: number;
    potenzaTermByPass: number;
}

export class TabAcquaReintegro {
    rowAcquaReintegro: RowAcquaReintegro[];
}

export class TabCombustibile {
    rowCombustibile: RowCombustibile[];
}

export class RowAcquaReintegro {
    unitaMisura: number;
    esercizio: number;
    letturaIniziale: number;
    letturaFinale: number;
    consumoTotale: number;
}

export class RowCombustibile {
    unitaMisura: number;
    esercizio: number;
    consumoAnnuo: number;
}
