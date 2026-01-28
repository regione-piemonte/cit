/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitwebn.business.manager;


import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.apache.log4j.Logger;

import it.csi.sigit.sigitwebn.business.back_office.CPBECpGestSubentroMassivo;
//import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTCodiceImpByCodiceImpiantoDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitDDettaglioGfDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitDDettaglioGtDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitTCodiceBollDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitTContratto2019DaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitTPersonaGiuridicaDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitTRappIspezGfDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitTRappIspezGtDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.ContrattoFilter;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.ImportDistribFilter;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.ImportFilter;
import it.csi.sigit.sigitwebn.business.elenco_ispezioni_impianti.CPBECpDettaglioIspezione2018;
import it.csi.sigit.sigitwebn.business.elenco_ispezioni_impianti.CPBECpRicercaIspezioni2018;
import it.csi.sigit.sigitwebn.business.gestisci_accertamento.CPBECpDettaglioAccertamentoConf;
import it.csi.sigit.sigitwebn.business.gestisci_accertamento.CPBECpDettaglioAccertamentoConf.RicercaCampoAccertamentoEnum;
import it.csi.sigit.sigitwebn.business.gestisci_accertamento.CPBECpGestAccertamento;
import it.csi.sigit.sigitwebn.business.gestisci_azioni.CPBECpElencoSveglie;
import it.csi.sigit.sigitwebn.business.gestisci_azioni.CPBECpSveglia;
import it.csi.sigit.sigitwebn.business.gestisci_impianto.CPBECpGestImpianto;
import it.csi.sigit.sigitwebn.business.gestisci_libretto_scheda3.CPBECpDettaglio3Resp;
import it.csi.sigit.sigitwebn.business.gestisci_libretto_scheda3.CPBECpGestLibScheda3;
import it.csi.sigit.sigitwebn.business.gestisci_libretto_scheda4.CPBECpGestLibScheda4Impresa;
import it.csi.sigit.sigitwebn.business.gestisci_rapprova.CPBECpGestRapProvaTipo1;
import it.csi.sigit.sigitwebn.business.gestisci_rapprova.CPBECpGestRapProvaTipo1Dett;
import it.csi.sigit.sigitwebn.business.gestisci_rapprova.CPBECpGestRapProvaTipo2;
import it.csi.sigit.sigitwebn.business.gestisci_rapprova.CPBECpGestRapProvaTipo2Dett;
import it.csi.sigit.sigitwebn.business.gestisci_rapprova.CPBECpInitRapProva;
import it.csi.sigit.sigitwebn.business.gestisci_sanzioni.CPBECpDettaglioSanzione;
import it.csi.sigit.sigitwebn.business.gestisci_sanzioni.CPBECpInserisciNotificaSanzione;
import it.csi.sigit.sigitwebn.business.gestisci_sanzioni.CPBECpRicercaSanzione;
import it.csi.sigit.sigitwebn.business.gestisci_verifica.CPBECpGestVerifica;
import it.csi.sigit.sigitwebn.business.gestisci_verifica.CPBECpGestVerifica.RicercaCampoVerificaEnum;
import it.csi.sigit.sigitwebn.business.gestisci_verifica.CPBECpGestVerifica.TipoVerificaEnum;
import it.csi.sigit.sigitwebn.business.manager.util.DbManagerException;
import it.csi.sigit.sigitwebn.business.manager.util.ManagerException;
import it.csi.sigit.sigitwebn.business.manager.util.Message;
import it.csi.sigit.sigitwebn.business.manager.util.ValidationManagerException;
import it.csi.sigit.sigitwebn.business.ricerca_accertamenti.CPBECpRicercaAccertamenti;
import it.csi.sigit.sigitwebn.business.ricerca_verifiche.CPBECpRicercaVerifiche;
import it.csi.sigit.sigitwebn.dto.ExecResults;
import it.csi.sigit.sigitwebn.dto.accertamento.Accertamento;
import it.csi.sigit.sigitwebn.dto.accertamento.RicercaAccertamento;
import it.csi.sigit.sigitwebn.dto.accesso.PersonaGiuridica;
import it.csi.sigit.sigitwebn.dto.accesso.Ruolo;
import it.csi.sigit.sigitwebn.dto.allegati.DettaglioAllegato;
import it.csi.sigit.sigitwebn.dto.allegati.ElencoAllegati;
import it.csi.sigit.sigitwebn.dto.allegati.RicercaAllegati;
import it.csi.sigit.sigitwebn.dto.azioni.RicercaSveglie;
import it.csi.sigit.sigitwebn.dto.azioni.Sveglia;
import it.csi.sigit.sigitwebn.dto.back_office.Abilitazione;
import it.csi.sigit.sigitwebn.dto.bollini.AcquistoBollini;
import it.csi.sigit.sigitwebn.dto.bollini.AcquistoBolliniQuantita;
import it.csi.sigit.sigitwebn.dto.bollini.DatiPagamento;
import it.csi.sigit.sigitwebn.dto.codici_impianto.AcquisizioneCodici;
import it.csi.sigit.sigitwebn.dto.common.CodeDescription;
import it.csi.sigit.sigitwebn.dto.common.UDTPositiveInteger;
import it.csi.sigit.sigitwebn.dto.delega.Delegato;
import it.csi.sigit.sigitwebn.dto.distributori.DettaglioImportDistributori;
import it.csi.sigit.sigitwebn.dto.distributori.DistributoreMan;
import it.csi.sigit.sigitwebn.dto.documentazione.Documento;
import it.csi.sigit.sigitwebn.dto.impianto.Impianto;
import it.csi.sigit.sigitwebn.dto.impianto.Proprietario;
import it.csi.sigit.sigitwebn.dto.impianto.Responsabile;
import it.csi.sigit.sigitwebn.dto.impianto.RicercaAvanzataImpianti;
import it.csi.sigit.sigitwebn.dto.impianto.RicercaImpianti;
import it.csi.sigit.sigitwebn.dto.impianto.RisultatoRicImpianto;
import it.csi.sigit.sigitwebn.dto.impianto.RisultatoRicResponsabile;
import it.csi.sigit.sigitwebn.dto.impresa.RicercaImprese;
import it.csi.sigit.sigitwebn.dto.incarico.Incaricato;
import it.csi.sigit.sigitwebn.dto.ispezioni.ConclusioneIspezione2018;
import it.csi.sigit.sigitwebn.dto.ispezioni.DettaglioIspezione;
import it.csi.sigit.sigitwebn.dto.ispezioni.Ispezione2018;
import it.csi.sigit.sigitwebn.dto.ispezioni.RicercaApparecchiatureRappProva;
import it.csi.sigit.sigitwebn.dto.ispezioni.RicercaIspezioni2018;
import it.csi.sigit.sigitwebn.dto.libretto.ComponenteAC;
import it.csi.sigit.sigitwebn.dto.libretto.ComponenteAG;
import it.csi.sigit.sigitwebn.dto.libretto.ComponenteBRRC;
import it.csi.sigit.sigitwebn.dto.libretto.ComponenteCG;
import it.csi.sigit.sigitwebn.dto.libretto.ComponenteCI;
import it.csi.sigit.sigitwebn.dto.libretto.ComponenteCS;
import it.csi.sigit.sigitwebn.dto.libretto.ComponenteGF;
import it.csi.sigit.sigitwebn.dto.libretto.ComponenteGT;
import it.csi.sigit.sigitwebn.dto.libretto.ComponentePO;
import it.csi.sigit.sigitwebn.dto.libretto.ComponenteRC;
import it.csi.sigit.sigitwebn.dto.libretto.ComponenteRV;
import it.csi.sigit.sigitwebn.dto.libretto.ComponenteSC;
import it.csi.sigit.sigitwebn.dto.libretto.ComponenteSCX;
import it.csi.sigit.sigitwebn.dto.libretto.ComponenteSR;
import it.csi.sigit.sigitwebn.dto.libretto.ComponenteTE;
import it.csi.sigit.sigitwebn.dto.libretto.ComponenteUT;
import it.csi.sigit.sigitwebn.dto.libretto.ComponenteVM;
import it.csi.sigit.sigitwebn.dto.libretto.ComponenteVR;
import it.csi.sigit.sigitwebn.dto.libretto.ComponenteVX;
import it.csi.sigit.sigitwebn.dto.libretto.Consumo;
import it.csi.sigit.sigitwebn.dto.libretto.ConsumoAcqua;
import it.csi.sigit.sigitwebn.dto.libretto.ControlloLibretto;
import it.csi.sigit.sigitwebn.dto.libretto.DatiExtra;
import it.csi.sigit.sigitwebn.dto.libretto.DettaglioManutenzione;
import it.csi.sigit.sigitwebn.dto.libretto.Scheda1;
import it.csi.sigit.sigitwebn.dto.libretto.SistemaEmissione;
import it.csi.sigit.sigitwebn.dto.libretto.SistemiDistribuzione;
import it.csi.sigit.sigitwebn.dto.libretto.SistemiRegolazioneContabilizzazione;
import it.csi.sigit.sigitwebn.dto.libretto.TrattamentoAcqua;
import it.csi.sigit.sigitwebn.dto.main.RicercaTransazione;
import it.csi.sigit.sigitwebn.dto.main.UtenteLoggato;
import it.csi.sigit.sigitwebn.dto.rappprova.TipoGF;
import it.csi.sigit.sigitwebn.dto.rappprova.TipoGFDett;
import it.csi.sigit.sigitwebn.dto.rappprova.TipoGFDettCircuito;
import it.csi.sigit.sigitwebn.dto.rappprova.TipoGT;
import it.csi.sigit.sigitwebn.dto.rappprova.TipoGTDett;
import it.csi.sigit.sigitwebn.dto.rappprova.TipoGTDettModulo;
import it.csi.sigit.sigitwebn.dto.ree.Tipo1;
import it.csi.sigit.sigitwebn.dto.ree.Tipo1Consumo;
import it.csi.sigit.sigitwebn.dto.ree.Tipo1Dett;
import it.csi.sigit.sigitwebn.dto.ree.Tipo1DettModulo;
import it.csi.sigit.sigitwebn.dto.ree.Tipo2;
import it.csi.sigit.sigitwebn.dto.ree.Tipo2Dett;
import it.csi.sigit.sigitwebn.dto.ree.Tipo2DettCircuito;
import it.csi.sigit.sigitwebn.dto.ree.Tipo3;
import it.csi.sigit.sigitwebn.dto.ree.Tipo3Dett;
import it.csi.sigit.sigitwebn.dto.ree.Tipo4;
import it.csi.sigit.sigitwebn.dto.ree.Tipo4Dett;
import it.csi.sigit.sigitwebn.dto.sanzioni.DatiInserimentoSanzione;
import it.csi.sigit.sigitwebn.dto.sanzioni.RicercaSanzioni;
import it.csi.sigit.sigitwebn.dto.subentro.Subentro;
import it.csi.sigit.sigitwebn.dto.terzoresponsabile.CessazioneTerzaResponsabilita;
import it.csi.sigit.sigitwebn.dto.terzoresponsabile.DettaglioTerzoResponsabile;
import it.csi.sigit.sigitwebn.dto.terzoresponsabile.ProrogaTerzoResponsabile;
import it.csi.sigit.sigitwebn.dto.terzoresponsabile.TerzoResponsabile;
import it.csi.sigit.sigitwebn.dto.userws.UserWs;
import it.csi.sigit.sigitwebn.dto.verifica.InserimentoIspezioniMassive;
import it.csi.sigit.sigitwebn.dto.verifica.RicercaVerifica;
import it.csi.sigit.sigitwebn.dto.verifica.Verifica;
import it.csi.sigit.sigitwebn.util.ComparatorDto;
import it.csi.sigit.sigitwebn.util.ComparatorUtil;
import it.csi.sigit.sigitwebn.util.Constants;
import it.csi.sigit.sigitwebn.util.ConstantsField;
import it.csi.sigit.sigitwebn.util.ConvertUtil;
import it.csi.sigit.sigitwebn.util.DateUtil;
import it.csi.sigit.sigitwebn.util.GenericUtil;
import it.csi.sigit.sigitwebn.util.MapDto;
import it.csi.sigit.sigitwebn.util.Messages;
import it.csi.sigit.sigitwebn.util.ReplaceSpecialCharUtils;
import it.csi.sigit.sigitwebn.util.XmlBeanUtils;
import it.csi.sigit.sigitwebn.util.XmlValidator;
import it.csi.sigit.sigitwebn.util.XmlValidatorException;
import it.csi.sigit.sigitwebn.util.enumutil.EditabilitaComp4Enum;
import it.csi.sigit.sigitwebn.util.enumutil.SiNoEnum;
import it.csi.sigit.sigitwebn.util.enumutil.TrattamentiAcquaCondizionamentoChimicoEnum;
import it.csi.sigit.sigitwebn.util.enumutil.TrattamentiAcquaFiltrazioneEnum;
import it.csi.sigit.sigitwebn.util.enumutil.TrattamentiAcquaTrattamentoEnum;
import it.csi.sigit.sigitwebn.xml.importmassivo.allegato2.data.DatiManutentoreDocument.DatiManutentore;
import it.csi.sigit.sigitwebn.xml.importmassivo.allegato2.data.RowAllegatoIIDocument.RowAllegatoII;
import it.csi.sigit.sigitwebn.xml.importmassivo.allegato3.data.RowAllegatoIIIDocument.RowAllegatoIII;
import it.csi.sigit.sigitwebn.xml.importmassivo.allegato4.data.RowAllegatoIVDocument.RowAllegatoIV;
import it.csi.sigit.sigitwebn.xml.importmassivo.allegato5.data.RowAllegatoVDocument.RowAllegatoV;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L101VentilazioneMeccanicaDocument.L101VentilazioneMeccanica;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L101VentilazioneMeccanicaSostituitoDocument.L101VentilazioneMeccanicaSostituito;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L10VentilazioneDocument.L10Ventilazione;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L10VentilazioneDocument.L10Ventilazione.L101VM;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L144DatiConsumoProdottiChimiciDocument.L144DatiConsumoProdottiChimici;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L14ConsumiDocument.L14Consumi;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L14ConsumiDocument.L14Consumi.L141ConsumoCombustibile;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L1SchedaIdentificativaDocument.L1SchedaIdentificativa;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L41GruppoTermicoDocument.L41GruppoTermico;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L41GruppoTermicoSostituitoDocument.L41GruppoTermicoSostituito;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L42BruciatoreDocument.L42Bruciatore;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L42BruciatoreSostituitoDocument.L42BruciatoreSostituito;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L43RecuperatoreDocument.L43Recuperatore;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L43RecuperatoreSostituitoDocument.L43RecuperatoreSostituito;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L44GruppoFrigoDocument.L44GruppoFrigo;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L44GruppoFrigoSostituitoDocument.L44GruppoFrigoSostituito;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L45ScambiatoreDocument.L45Scambiatore;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L45ScambiatoreSostituitoDocument.L45ScambiatoreSostituito;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L46CogeneratoreDocument.L46Cogeneratore;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L46CogeneratoreSostituitoDocument.L46CogeneratoreSostituito;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L47CampoSolareTermicoDocument.L47CampoSolareTermico;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L47CampoSolareTermicoSostituitoDocument.L47CampoSolareTermicoSostituito;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L48AltroGeneratoreDocument.L48AltroGeneratore;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L48AltroGeneratoreSostituitoDocument.L48AltroGeneratoreSostituito;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L4GeneratoriDocument.L4Generatori;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L4GeneratoriDocument.L4Generatori.L41GT;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L4GeneratoriDocument.L4Generatori.L42BR;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L4GeneratoriDocument.L4Generatori.L43RC;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L4GeneratoriDocument.L4Generatori.L44GF;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L4GeneratoriDocument.L4Generatori.L45SC;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L4GeneratoriDocument.L4Generatori.L46CG;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L4GeneratoriDocument.L4Generatori.L47CS;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L4GeneratoriDocument.L4Generatori.L48AG;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L51SistemaRegolazioneDocument.L51SistemaRegolazione;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L51SistemaRegolazioneSostituitoDocument.L51SistemaRegolazioneSostituito;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L51ValvolaRegolazioneDocument.L51ValvolaRegolazione;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L51ValvolaRegolazioneSostituitoDocument.L51ValvolaRegolazioneSostituito;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L5SistemiRegolazioneContabilizzazioneDocument.L5SistemiRegolazioneContabilizzazione;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L5SistemiRegolazioneContabilizzazioneDocument.L5SistemiRegolazioneContabilizzazione.L51SR;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L5SistemiRegolazioneContabilizzazioneDocument.L5SistemiRegolazioneContabilizzazione.L51VR;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L64PompaDocument.L64Pompa;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L64PompaSostituitoDocument.L64PompaSostituito;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L6SistemiDistribuzioneDocument.L6SistemiDistribuzione;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L6SistemiDistribuzioneDocument.L6SistemiDistribuzione.L63VX;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L6SistemiDistribuzioneDocument.L6SistemiDistribuzione.L64PO;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L7SistemiEmissioneDocument.L7SistemiEmissione;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L81AccumuloDocument.L81Accumulo;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L81AccumuloSostituitoDocument.L81AccumuloSostituito;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L8SistemiAccumuloDocument.L8SistemiAccumulo;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L8SistemiAccumuloDocument.L8SistemiAccumulo.L81AC;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L91TorreDocument.L91Torre;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L91TorreSostituitoDocument.L91TorreSostituito;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L92RaffreddatoreDocument.L92Raffreddatore;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L92RaffreddatoreSostituitoDocument.L92RaffreddatoreSostituito;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L93ScambiatoreIntermedioDocument.L93ScambiatoreIntermedio;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L93ScambiatoreIntermedioSostituitoDocument.L93ScambiatoreIntermedioSostituito;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L94CircuitoDocument.L94Circuito;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L94CircuitoSostituitoDocument.L94CircuitoSostituito;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L95UnitaTrattAriaDocument.L95UnitaTrattAria;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L95UnitaTrattAriaSostituitoDocument.L95UnitaTrattAriaSostituito;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L96RecuperatoreAriaAmbDocument.L96RecuperatoreAriaAmb;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L96RecuperatoreAriaAmbSostituitoDocument.L96RecuperatoreAriaAmbSostituito;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L9AltriComponentiDocument.L9AltriComponenti;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L9AltriComponentiDocument.L9AltriComponenti.L91TE;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L9AltriComponentiDocument.L9AltriComponenti.L92RV;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L9AltriComponentiDocument.L9AltriComponenti.L93SCX;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L9AltriComponentiDocument.L9AltriComponenti.L94CI;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L9AltriComponentiDocument.L9AltriComponenti.L95UT;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L9AltriComponentiDocument.L9AltriComponenti.L96RCX;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.LibrettoCatastoDocument.LibrettoCatasto;

public class ValidationMgr {

	protected static Logger log = Logger.getLogger(Constants.APPLICATION_CODE + ".business.manager");


	private boolean check1900 (String dataDaValidare, String dateField) throws ValidationManagerException {

		if (!StringUtils.isEmpty(dateField)) {
			ValidationManagerException ex;
			Date dataCampo;
			Date data1900;
			try {
				dataCampo = ConvertUtil.convertToDate(dataDaValidare);
				data1900 = ConvertUtil.convertToDate("01/01/1900");
			} catch (Exception e) {
				return false;
			}

			if (!DateUtil.checkDateOrder(data1900, dataCampo, true)) {
				ex = new ValidationManagerException(new Message(Messages.ERROR_DATA_1900));
				ex.addField(dateField);
				throw ex;
			}
		}

		return true;
	}
	protected SigitMgr sigitMgr;



	public SigitMgr getSigitMgr() {
		return sigitMgr;
	}

	public void setSigitMgr(SigitMgr sigitMgr) {
		this.sigitMgr = sigitMgr;
	}
	/**
	 * Manager del DB
	 */
	protected DbMgr dbMgr;

	/**
	 * Restituisce il manager del DB
	 *
	 * @return Manager del DB
	 */
	public DbMgr getDbMgr() {
		return dbMgr;
	}

	/**
	 * Imposta i manager del DB
	 *
	 * @param serviziMgr Manager del DB
	 */
	public void setDbMgr(DbMgr dbMgr) {
		this.dbMgr = dbMgr;
	}


	/**
	 * @param per il controllo del codice fiscale
	 */
	private static char carattere[] = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
		'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U',
		'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7',
		'8', '9' };
	private static int valore_pari[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11,
		12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 0, 1, 2, 3,
		4, 5, 6, 7, 8, 9 };
	private static int valore_dispari[] = { 1, 0, 5, 7, 9, 13, 15, 17, 19, 21,
		2, 4, 18, 20, 11, 3, 6, 8, 12, 14, 16, 10, 22, 25, 24, 23, 1, 0, 5,
		7, 9, 13, 15, 17, 19, 21 };

	private static final char carattere_di_controllo[] = { 'A', 'B', 'C', 'D',
		'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q',
		'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

	private static final String DATA_CONTROLLO_OBBLIGATORIETA_REE_TIPO_1B = "20/09/2021";

	public void checkPopolamentoListaGT(List<CodeDescription> anyList, String tipoComponenteBRRC) throws ValidationManagerException {
		if (anyList == null || anyList.isEmpty()) {
			Message msg = null;
			if (Constants.TIPO_COMPONENTE_BR.equals(tipoComponenteBRRC)) {
				msg = new Message(Messages.S224, "bruciatore");
			} else {
				msg = new Message(Messages.S224, "recuperatore");
			}

			throw new ValidationManagerException(msg);
		}
	}

	public void checkSelezioneElemento(String elementoSelezionato) throws ValidationManagerException {

		if (GenericUtil.isNullOrEmpty(elementoSelezionato))
		{
			throw new ValidationManagerException(new Message(Messages.S007));
		}
	}

	public void checkSelezioneElemento(Integer elementoSelezionato) throws ValidationManagerException {

		if (GenericUtil.isNullOrEmpty(elementoSelezionato))
		{
			throw new ValidationManagerException(new Message(Messages.S007));
		}

	}

	public void checkSelezioneElemento(ArrayList<Integer> elementiSelezionati) throws ValidationManagerException {

		if (elementiSelezionati == null || elementiSelezionati.size() == 0)
		{
			throw new ValidationManagerException(new Message(Messages.S007));
		}

	}

	public void validazioneFormaleRicercaCodImpianto(RicercaTransazione ricercaCodImp) throws ValidationManagerException {

		boolean codiceFiscaleEmpty;
		boolean codiceImpiantoEmpty;
		boolean siglaReaEmpty;
		boolean numeroReaEmpty;
		boolean dataAcquisizioneDa;
		boolean dataAcquisizioneA;

		if(ricercaCodImp != null) {
			codiceFiscaleEmpty = GenericUtil.isNullOrEmpty(ricercaCodImp.getCodiceFiscale());
			codiceImpiantoEmpty = GenericUtil.isNullOrEmpty(ricercaCodImp.getCodiceImpianto());
			siglaReaEmpty = GenericUtil.isNullOrEmpty(ricercaCodImp.getIdSiglaRea());
			numeroReaEmpty = GenericUtil.isNullOrEmpty(ricercaCodImp.getNumeroRea());
			dataAcquisizioneDa = GenericUtil.isNullOrEmpty(ricercaCodImp.getDataAcquisizioneDa());
			dataAcquisizioneA = GenericUtil.isNullOrEmpty(ricercaCodImp.getDataAcquisizioneA());


			if(codiceFiscaleEmpty && codiceImpiantoEmpty && siglaReaEmpty && numeroReaEmpty && dataAcquisizioneDa && dataAcquisizioneA) {
				// Non e' stato impostato nessun paramentro
				throw new ValidationManagerException(new Message(Messages.S010));
			}
			else
			{
				// Se e' stato inserita la sigla REA deve essere compilato anche il
				// numero REA e viceversa
				checkSiglaAndNumeroRea(ricercaCodImp.getIdSiglaRea(), ricercaCodImp.getNumeroRea(), ConstantsField.RICERCA_CODICI_ID_SIGLA_REA,
						ConstantsField.RICERCA_CODICI_NUMERO_REA);

				checkCodiceFiscalePartitaIva(ricercaCodImp.getCodiceFiscale(), ConstantsField.RICERCA_CODICI_CF);
				if(ricercaCodImp.getCodiceImpianto()!=null)
					checkNumber(""+ricercaCodImp.getCodiceImpianto(),Constants.MAX_CODICE_IMPIANTO_LEN, ConstantsField.RICERCA_CODICI_COD_IMPIANTO);
				if(ricercaCodImp.getNumeroRea()!=null)
					checkNumber(""+ricercaCodImp.getNumeroRea(),Constants.MAX_CODICE_IMPIANTO_LEN, ConstantsField.RICERCA_CODICI_NUMERO_REA);
			}
		}
		else {
			// Non e' stato inserito alcun criterio di ricerca
			throw new ValidationManagerException(new Message(Messages.S010));
		}

	}

	public void validazioneFormaleDatiAllegato(DettaglioAllegato allegato) throws ValidationManagerException {


		ValidationManagerException ex = null;

		validazioneFormaleDatiAllegatoCerca(allegato);

		//Message message = new Message(Messages.ERROR_CAMPO_ABBIGATORIO);
		//message.replacePlaceholder("");
		ex = new ValidationManagerException();

		GenericUtil.eliminaCampoVuoto(allegato.getIdApparecchiature());

		if (GenericUtil.isNullOrEmpty(allegato.getIdApparecchiature()) || allegato.getIdApparecchiature().size() == 0) {
			ex.addFieldRequired(ConstantsField.DATI_ALLEGATO_ID_APPARECCHIATURE);

		}

		/*
		if (GenericUtil.isNullOrEmpty(allegato.getNumeroBollinoVerde())) {
			ex.addFieldRequired(ConstantsField.DATI_ALLEGATO_NUMERO_BOLLINO);

		}
		*/

		if (ex.getFieldList().size() > 0)
		{
				throw ex;
		}
	}

	public void validazioneFormaleDatiManutenzione(DettaglioManutenzione allegato) throws ValidationManagerException {


		preparaToValidate(allegato);

		ValidationManagerException ex = null;

		validazioneFormaleDatiManutenzioneCerca(allegato);

		//Message message = new Message(Messages.ERROR_CAMPO_ABBIGATORIO);
		//message.replacePlaceholder("");
		ex = new ValidationManagerException();

		GenericUtil.eliminaCampoVuoto(allegato.getIdApparecchiature());

		if (GenericUtil.isNullOrEmpty(allegato.getIdApparecchiature()) || allegato.getIdApparecchiature().size() == 0) {
			ex.addFieldRequired(ConstantsField.DATI_MANUTENZIONE_ID_APPARECCHIATURE);

		}

		if (GenericUtil.isNullOrEmpty(allegato.getIdTipoIntervento())) {
			ex.addFieldRequired(ConstantsField.DATI_MANUTENZIONE_ID_TIPO_INTERVENTO);

		}
		else if (allegato.getIdTipoIntervento() == Constants.ID_TIPO_MANUTENZIONE_ALTRO &&
				GenericUtil.isNullOrEmpty(allegato.getAltro())) {
			ex.addFieldRequired(ConstantsField.DATI_MANUTENZIONE_ALTRO);
		}

		if (GenericUtil.isNullOrEmpty(allegato.getInterventoEntro())) {
			ex.addFieldRequired(ConstantsField.DATI_MANUTENZIONE_INTERVENTO_ENTRO);
		}

		if (GenericUtil.isNullOrEmpty(allegato.getDenominazTecnico())) {
			ex.addFieldRequired(ConstantsField.DATI_MANUTENZIONE_DENOMINAZIONE_TECNICO);
		}


		if (ex.getFieldList().size() > 0)
		{
			throw ex;
		}

		checkAsciiStringMaxLength(allegato.getOsservazioni(), 1000, ConstantsField.DATI_MANUTENZIONE_OSSERVAZIONI, null);
		checkAsciiStringMaxLength(allegato.getRaccomandazioni(), 1000, ConstantsField.DATI_MANUTENZIONE_RACCOMANDAZIONI, null);
		checkAsciiStringMaxLength(allegato.getPrescrizioni(), 1000, ConstantsField.DATI_MANUTENZIONE_PRESCRIZIONI, null);

		if (!DateUtil.checkDateOrder(allegato.getDataManut(), allegato.getInterventoEntro(), false))
		{
			throw new ValidationManagerException(new Message(Messages.S174_1));
		}

		verificaManutentoreUnivoco(allegato);

		// Devo verificare che le componenti seleizonate siano verificate
		List<SigitTComp4Dto> compNonControllate = null;
		try
		{

			compNonControllate = getSigitMgr().getTComp4NonControllate(allegato);

		} catch (ManagerException e) {
			throw new ValidationManagerException(new Message(Messages.ERROR_RECUPERO_DB));
		}

		if (compNonControllate != null && compNonControllate.size() > 0)
		{
			String elencoComp = GenericUtil.getDescComponentiNonComp(compNonControllate);
			throw new ValidationManagerException(new Message(Messages.ERROR_LIBRETTO_COMP_NON_CONTROLLATE, elencoComp));
		}

		try
		{
			if (getDbMgr().cercaResponsabileAttivoByCodImpianto(
					ConvertUtil.convertToInteger(allegato.getCodiceImpianto())) == null) {
				// Vuol dire che non c'e' un respansabile attivo alla sysdate, non riuscirei a creare il libretto
				throw new ValidationManagerException(new Message(Messages.ERROR_RESPONSABILE_ASSENTE));
			}
		} catch (DbManagerException e) {
			throw new ValidationManagerException(new Message(Messages.ERROR_RECUPERO_DB));
		}
	}

	public void validazioneFormaleRevocaTerzoResponsabile(RisultatoRicImpianto impSelez, Integer idContrattoSelez, ArrayList<DettaglioTerzoResponsabile> elenco3Resp, UtenteLoggato utente) throws ValidationManagerException {

		checkSelezioneElemento(idContrattoSelez);

		if (GenericUtil.isNullOrEmpty(impSelez.getDenomResponsabile()))
		{
			// Vuol dire che non c'e' un responsabile attivo, non lo faccio proseguire, perche' non potrebbe ricreare il libretto senza un responsabile
			throw new ValidationManagerException(new Message(Messages.ERROR_RESPONSABILE_ASSENTE));
		}

		//dcosta: manca la creazione dell'errore 088
		if (elenco3Resp == null || elenco3Resp.isEmpty()) {
			throw new ValidationManagerException(new Message(Messages.S088));
		}

		String descrizioneRuolo = utente.getRuolo().getDescRuolo();
		String cfUtente = utente.getRuolo().getCodiceFiscale();


		for (DettaglioTerzoResponsabile dettaglioTerzoResponsabile : elenco3Resp) {

			if (dettaglioTerzoResponsabile.getIdContratto().intValue() == idContrattoSelez.intValue())
			{
				if (descrizioneRuolo.equalsIgnoreCase(Constants.RUOLO_3RESPONSABILE) &&
						!cfUtente.equalsIgnoreCase(dettaglioTerzoResponsabile.getCodiceFiscale()))
				{
					throw new ValidationManagerException(new Message(Messages.ERROR_CONTRATTO_NO_COMPETENZA));
				}

				if (GenericUtil.isNotNullOrEmpty(dettaglioTerzoResponsabile.getDataRevoca()))
				{
					throw new ValidationManagerException(new Message(Messages.S148));
				}
			}
		}

	}

	public void validazioneFormaleDettaglioNominaTerzoResponsabile (Integer idContrattoSelez) throws ValidationManagerException {
		checkSelezioneElemento(idContrattoSelez);
	}

	public void verificaDatiAllegato(DettaglioAllegato allegato, Integer fkManutentore) throws ValidationManagerException {


		/*
			ValidationManagerException ex = null;

			validazioneFormaleDatiAllegatoCerca(allegato);

			//Message message = new Message(Messages.ERROR_CAMPO_ABBIGATORIO);
			//message.replacePlaceholder("");
			ex = new ValidationManagerException();

	//		if (GenericUtil.isNullOrEmpty(dettaglio.getDataControllo())) {
	//			ex.addFieldRequired(ConstantsField.DATI_ALLEGATO_DATA_CONTROLLO);
	//
	//		}
	//
	//		if (GenericUtil.isNullOrEmpty(dettaglio.getIdTipoAllegato())) {
	//			ex.addFieldRequired(ConstantsField.DATI_ALLEGATO_TIPO_DOCUMENTO);
	//
	//		}


			GenericUtil.eliminaCampoVuoto(allegato.getIdApparecchiature());




			if (GenericUtil.isNullOrEmpty(allegato.getIdApparecchiature()) || allegato.getIdApparecchiature().size() == 0) {
				ex.addFieldRequired(ConstantsField.DATI_ALLEGATO_ID_APPARECCHIATURE);

			}

			if (GenericUtil.isNullOrEmpty(allegato.getNumeroBollinoVerde())) {
				ex.addFieldRequired(ConstantsField.DATI_ALLEGATO_NUMERO_BOLLINO);

			}

			if (ex.getFieldList().size() > 0)
			{
					throw ex;
			}
	*/

		// Devo verificare che le componenti seleizonate siano verificate
		List<SigitTComp4Dto> compNonControllate = null;
		try
		{

			compNonControllate = getSigitMgr().getTComp4NonControllate(allegato);

		} catch (ManagerException e) {
			throw new ValidationManagerException(new Message(Messages.ERROR_RECUPERO_DB));
		}

		if (compNonControllate != null && compNonControllate.size() > 0)
		{
			String elencoComp = GenericUtil.getDescComponentiNonComp(compNonControllate);
			throw new ValidationManagerException(new Message(Messages.ERROR_LIBRETTO_COMP_NON_CONTROLLATE, elencoComp));
		}

			verificaManutentoreUnivoco(allegato);


	//		checkDate(allegato.getDataControllo(), ConstantsField.DATI_ALLEGATO_DATA_CONTROLLO);
	//
	//		isDataFutura(allegato.getDataControllo(), ConstantsField.DATI_ALLEGATO_DATA_CONTROLLO);

			// Beppe - adesso c'� l'assegnazione automatica
			//isVerificaCodiceBollValidoDataControllo(Constants.SIGLA_BOLLINO_RP, allegato.getNumeroBollinoVerde(), allegato.getDataControllo());

//			Date dataControllo = null;
//			try
//			{
//					dataControllo = ConvertUtil.convertToDate(allegato.getDataControllo());
//			}
//			catch (Exception e) {
//				// La data controllo e' sicuramente corretta, e' stata fatta la verifica precedentemente
//			}
//
//			log.debug("Inserimento nuovo allegato tipo "
//					+ allegato.getIdTipoAllegato());
			//controllo se per il tipo documento selezionato, esistono componenti attivi in data controllo selezionata
			// Questo controllo non serve piu', ho gia' selezionato le componenti attive
			/*
			if (Constants.ALLEGATO_TIPO_1.equals(allegato
					.getIdTipoAllegato())) {
				List<SigitVCompGtDettDto> listGt = getDbMgr()
						.getCompGtAttiviInData(
								allegato.getCodiceImpianto(),
								ConvertUtil
										.convertToDate(allegato
												.getDataControllo()));
				if (listGt == null || listGt.isEmpty())
					throw new ManagerException(
							new Message(
									Messages.ERROR_COMPONENTI_NON_ATTIVI_IN_DATA,
									Constants.TIPO_COMPONENTE_GT,
									allegato
											.getDataControllo()));
			}
			if (Constants.ALLEGATO_TIPO_2.equals(allegato
					.getIdTipoAllegato())) {
				List<SigitVCompGfDettDto> listGf = getDbMgr()
						.getCompGfAttiviInData(
								allegato.getCodiceImpianto(),
								ConvertUtil
										.convertToDate(allegato
												.getDataControllo()));
				if (listGf == null || listGf.isEmpty())
					throw new ManagerException(
							new Message(
									Messages.ERROR_COMPONENTI_NON_ATTIVI_IN_DATA,
									Constants.TIPO_COMPONENTE_GF,
									allegato
											.getDataControllo()));
			}
			if (Constants.ALLEGATO_TIPO_3.equals(allegato
					.getIdTipoAllegato())) {


				List<SigitVCompScDettDto> listSc = getDbMgr()
						.getCompScAttiviInData(
								allegato.getCodiceImpianto(),
								ConvertUtil
										.convertToDate(allegato
												.getDataControllo()));

				if (listSc == null || listSc.isEmpty())
					throw new ManagerException(
							new Message(
									Messages.ERROR_COMPONENTI_NON_ATTIVI_IN_DATA,
									Constants.TIPO_COMPONENTE_SC,
									allegato
											.getDataControllo()));
			}
			if (Constants.ALLEGATO_TIPO_4.equals(allegato
					.getIdTipoAllegato())) {
				List<SigitVCompCgDettDto> listCg = getDbMgr()
						.getCompCgAttiviInData(
								allegato.getCodiceImpianto(),
								ConvertUtil
										.convertToDate(allegato
												.getDataControllo()));
				if (listCg == null || listCg.isEmpty())
					throw new ManagerException(
							new Message(
									Messages.ERROR_COMPONENTI_NON_ATTIVI_IN_DATA,
									Constants.TIPO_COMPONENTE_CG,
									allegato
											.getDataControllo()));
			}
			*/


			/*
			* Beppe - adesso c'� l'assegnazione automatica
			try
			{
			if (GenericUtil.isNotNullOrEmpty(allegato
					.getNumeroBollinoVerde())) {
				//controllo se il numero bollino indicato non sia stato assegnato a ad altro impianto
				isBollinoAssegnatoAltroImpianto(
						allegato.getNumeroBollinoVerde(),
						allegato.getIdAllegato());

				//verifico che il bollino comprato sia ancora utilizzabile
				isBollinoUtilizzabile(
						ConvertUtil.convertToInteger(allegato
								.getNumeroBollinoVerde()),
						allegato.getSiglaBollino());

				//controllo se abbiano inserito il numero bollino che non e' obbligatorio
				if (GenericUtil.isNotNullOrEmpty(allegato
						.getNumeroBollinoVerde())) {
					BigDecimal idTransazione = getDbMgr()
							.cercaIdTransazioneCodBollinoAssegnatoAdUtente(
									ConvertUtil.convertToInteger(allegato
											.getNumeroBollinoVerde()),
											fkManutentore,
											allegato.getSiglaBollino());
					if (idTransazione == null) {
						//lancio l'eccezione perche' vuol dire che il numero bollino cercato non corrisponde all'utente loggato
						throw new ValidationManagerException(new Message(Messages.S049));

					}

				}
			}
			} catch (ManagerException e) {
				throw new ValidationManagerException(new Message(Messages.ERROR_RECUPERO_DB));
			}
			*/

	}



	public void validazioneFormaleConfRespingiAllegato(ElencoAllegati allegato) throws ValidationManagerException {


		ValidationManagerException ex = null;

		ex = new ValidationManagerException();


		if (GenericUtil.isNullOrEmpty(allegato.getMotivo())) {
			ex.addField(ConstantsField.DATI_ALLEGATO_MOTIVO_RESPINTO);
		}

		if (ex.getFieldList().size() > 0)
		{
				//ex.setMsg(message);
				throw ex;
		}

		checkStringMaxLenght(allegato.getMotivo(), 500, ConstantsField.DATI_ALLEGATO_MOTIVO_RESPINTO);

	}

	public void validazioneFormaleDatiRapProva(DettaglioAllegato allegato, boolean isUpdoad) throws ValidationManagerException {

		ValidationManagerException ex = new ValidationManagerException();

		GenericUtil.eliminaCampoVuoto(allegato.getIdApparecchiature());

		if (GenericUtil.isNullOrEmpty(allegato.getIdApparecchiature()) || allegato.getIdApparecchiature().size() == 0) {
			ex.addFieldRequired(ConstantsField.DATI_ALLEGATO_ISP_ID_APPARECCHIATURE);

		}

		if (ex.getFieldList().size() > 0)
		{
			throw ex;
		}

		//per ogni apparecchiatura scelta bisogna controllare che alla data di rapporto esista un responsabile/terzo responsabile attivo
		if (isNessunResponsabileByCodImpiantoApp(allegato.getCodiceImpianto(), allegato.getDataControllo(), allegato.getIdTipoAllegato(), allegato.getIdApparecchiature()))
		{
			throw new ValidationManagerException(new Message(Messages.ERROR_RESPONSABILE_DATA_RAPP_ASSENTE));
		}

		if (!isUpdoad)
		{
			// Devo verificare che le componenti seleizonate siano verificate
			List<SigitTComp4Dto> compNonControllate = null;
			try
			{

				compNonControllate = getSigitMgr().getTComp4NonControllate(allegato);

			} catch (ManagerException e) {
				throw new ValidationManagerException(new Message(Messages.ERROR_RECUPERO_DB));
			}

			if (compNonControllate != null && compNonControllate.size() > 0)
			{
				String elencoComp = GenericUtil.getDescComponentiNonComp(compNonControllate);
				throw new ValidationManagerException(new Message(Messages.ERROR_LIBRETTO_COMP_NON_CONTROLLATE, elencoComp));
			}
		}

	}

	public void validazioneFormaleDatiAllegatoIsp(DettaglioAllegato allegato) throws ValidationManagerException {


		validazioneFormaleDatiAllegatoIspCercaOLD(allegato);

		ValidationManagerException ex = null;

		ex = new ValidationManagerException();

		GenericUtil.eliminaCampoVuoto(allegato.getIdApparecchiature());

		if (GenericUtil.isNullOrEmpty(allegato.getIdApparecchiature()) || allegato.getIdApparecchiature().size() == 0) {
			ex.addFieldRequired(ConstantsField.DATI_ALLEGATO_ISP_ID_APPARECCHIATURE);

		}

		if (ex.getFieldList().size() > 0)
		{
			throw ex;
		}


		//controllo se l'impresa e' cessata o meno, se e' cessata devo andare a fare i controlli sulla data di controllo
		/*
		verificaDataCessazioneAttivita(
				allegato.getDataControllo(),
				personaGiuridica.getDataCessazione());
		*/
	}


	public void validazioneFormaleDatiAllegatoCerca(DettaglioAllegato allegato) throws ValidationManagerException {

		ValidationManagerException ex = null;

		//Message message = new Message(Messages.ERROR_CAMPO_ABBIGATORIO);
		//message.replacePlaceholder("");
		ex = new ValidationManagerException();

		if (GenericUtil.isNullOrEmpty(allegato.getDataControllo())) {
			ex.addFieldRequired(ConstantsField.DATI_ALLEGATO_DATA_CONTROLLO);

		}

		if (GenericUtil.isNullOrEmpty(allegato.getIdTipoAllegato())) {
			ex.addFieldRequired(ConstantsField.DATI_ALLEGATO_TIPO_DOCUMENTO);

		}

		if (ex.getFieldList().size() > 0)
		{
				throw ex;
		}

		checkDate(allegato.getDataControllo(), ConstantsField.DATI_ALLEGATO_DATA_CONTROLLO);

		isDataFutura(allegato.getDataControllo(), ConstantsField.DATI_ALLEGATO_DATA_CONTROLLO);

	}


	public void validazioneFormaleDatiManutenzioneCerca(DettaglioManutenzione allegato) throws ValidationManagerException {

		ValidationManagerException ex = null;

		//Message message = new Message(Messages.ERROR_CAMPO_ABBIGATORIO);
		//message.replacePlaceholder("");
		ex = new ValidationManagerException();

		if (GenericUtil.isNullOrEmpty(allegato.getDataManut())) {
			ex.addFieldRequired(ConstantsField.DATI_MANUTENZIONE_DATA_MANUT);

		}

		if (GenericUtil.isNullOrEmpty(allegato.getIdTipoManut())) {
			ex.addFieldRequired(ConstantsField.DATI_MANUTENZIONE_TIPO_MANUT);

		}

		if (ex.getFieldList().size() > 0)
		{
				throw ex;
		}

		checkDate(allegato.getDataManut(), ConstantsField.DATI_MANUTENZIONE_DATA_MANUT);

		isDataFutura(allegato.getDataManut(), ConstantsField.DATI_MANUTENZIONE_DATA_MANUT);


	}

	public void validazioneFormaleDatiAllegatoIspCercaOLD(DettaglioAllegato allegato) throws ValidationManagerException {

		ValidationManagerException ex = null;

		//Message message = new Message(Messages.ERROR_CAMPO_ABBIGATORIO);
		//message.replacePlaceholder("");
		ex = new ValidationManagerException();

		if (GenericUtil.isNullOrEmpty(allegato.getDataControllo())) {
			ex.addFieldRequired(ConstantsField.DATI_ALLEGATO_ISP_DATA_CONTROLLO);

		}

		if (GenericUtil.isNullOrEmpty(allegato.getIdTipoAllegato())) {
			ex.addFieldRequired(ConstantsField.DATI_ALLEGATO_ISP_TIPO_DOCUMENTO);

		}

		if (ex.getFieldList().size() > 0)
		{
				throw ex;
		}

		checkDate(allegato.getDataControllo(), ConstantsField.DATI_ALLEGATO_ISP_DATA_CONTROLLO);

		isDataFutura(allegato.getDataControllo(), ConstantsField.DATI_ALLEGATO_ISP_DATA_CONTROLLO);

		// controllo che esista un responsabile attivo alla data di controllo
		// Devo verificare che esista un responsabile alla data rapporto
		if (isNessunResponsabileByCodImpiantoApp(allegato.getCodiceImpianto(), allegato.getDataControllo(), allegato.getIdTipoAllegato(), allegato.getIdApparecchiature()))
		{
			throw new ValidationManagerException(new Message(Messages.ERROR_RESPONSABILE_DATA_RAPP_ASSENTE));
		}

	}

	public void validazioneFormaleConsolidaIspezione(DettaglioIspezione ispezione) throws ValidationManagerException {

		try
		{
			if (ispezione.getIdStatoIspezione() != Constants.ID_STATO_ISPEZIONE_BOZZA) {

				throw new ValidationManagerException(new Message(
						Messages.S115));

			}

			List<SigitTLibrettoDto> librettoList = getDbMgr().cercaLibrettoByStato(ispezione.getCodiceImpianto(),  Constants.ID_STATO_LIBRETTO_BOZZA);

			if (librettoList != null && librettoList.size() > 0)
			{
				throw new ValidationManagerException(new Message(
						Messages.S055));
			}


			if (GenericUtil.isNotNullOrEmpty(ispezione.getIdAllegato()))
			{
				DettaglioAllegato allegato = getDbMgr()
						.getDettaglioAllegatoById(
								ispezione.getIdAllegato());

				//vuol dire che e' in stato BOZZA, controllo il flag sulla tabella sigit_t_allegato e' stato ceccato
				if (allegato.getFlagControlloBozza() != Constants.FLAG_CONTROLLO_BOZZA_ALLEGATO_TRUE) {
					throw new ValidationManagerException(new Message(
							Messages.S065));
				} else if (isNessunResponsabileByCodImpiantoApp(ispezione.getCodiceImpianto(), allegato.getDataControllo(), ispezione.getIdTipoAllegato(), null))
				{
					// controllo che esista un responsabile attivo alla data di controllo
					// Devo verificare che esista un responsabile alla data rapporto
					throw new ValidationManagerException(new Message(Messages.ERROR_RESPONSABILE_DATA_RAPP_ASSENTE));
				}
			}

		} catch (DbManagerException e) {
			throw new ValidationManagerException(new Message(Messages.ERROR_RECUPERO_DB));
		}

	}

	public void validazioneFormaleDatiIspezione(DettaglioIspezione dettaglio) throws ValidationManagerException {


		if (GenericUtil.isNullOrEmpty(dettaglio.getIspettoreId())) {
			throw new ValidationManagerException(new Message(Messages.S119));
		}

		ValidationManagerException ex = null;

		ex = new ValidationManagerException();

		if (GenericUtil.isNullOrEmpty(dettaglio.getDataIspezione())) {
			ex.addFieldRequired(ConstantsField.DATI_ISPEZIONE_DATA_ISPEZIONE);

		}

		if (GenericUtil.isNullOrEmpty(dettaglio.getEnteCompetente())) {
			ex.addFieldRequired(ConstantsField.DATI_ISPEZIONE_ENTE_COMPETENTE);

		}

		if (GenericUtil.isNullOrEmpty(dettaglio.getEsitoIspezione())) {
			ex.addFieldRequired(ConstantsField.DATI_ISPEZIONE_ESITO_ISPEZIONE);

		}

		if (ex.getFieldList().size() > 0)
		{
				throw ex;
		}

		checkDate(dettaglio.getDataIspezione(), ConstantsField.DATI_ISPEZIONE_DATA_ISPEZIONE);

		isDataFutura(dettaglio.getDataIspezione(), ConstantsField.DATI_ISPEZIONE_DATA_ISPEZIONE);


	}


	/*
	 * public void checkDataCessazioneImpresa(String dataCessazione) throws ValidationManagerException {
		ValidationManagerException ex = null;
			String dataSistema = ConvertUtil.convertToString(DateUtil.getSqlDataCorrente());

			log.debug("DATA cessazione IMPRESA stringa: "+dataCessazione);
			log.debug("DATA sistema stringa: "+dataSistema);
			boolean flag = DateUtil.checkDateOrder(dataCessazione, dataSistema, false);
			log.debug(" FLAG: "+flag);

			//Controllo se risulta maggiore o minore della data di sistema
			if(flag){
				throw new ValidationManagerException(new Message(Messages.S014,dataCessazione));
			}
	}
	 */

	public void validazioneFormaleRicercaCampiVerifiche (Verifica verifica, CPBECpGestVerifica.RicercaCampoVerificaEnum tipoRicerca)  throws ValidationManagerException  {
		preparaToValidate(verifica);

		ValidationManagerException ex = new ValidationManagerException();

		if(RicercaCampoVerificaEnum.RICERCA_IMPIANTO.equals(tipoRicerca) && GenericUtil.isNullOrEmpty(verifica.getCodiceImpianto())) {
			ex.addFieldRequired(CPBECpGestVerifica.APPDATA_VERIFICA_CODE + ".codiceImpianto");
		}

		if (RicercaCampoVerificaEnum.RICERCA_BOLLINO.equals(tipoRicerca) && GenericUtil.isNullOrEmpty(verifica.getSiglaBollino()) && GenericUtil.isNullOrEmpty(verifica.getNumeroBollino())) {
			ex.addFieldRequired(CPBECpGestVerifica.APPDATA_VERIFICA_CODE + ".siglaBollino");
			ex.addFieldRequired(CPBECpGestVerifica.APPDATA_VERIFICA_CODE + ".numeroBollino");
		}

		if (RicercaCampoVerificaEnum.RICERCA_DISTRIBUTORE.equals(tipoRicerca) && GenericUtil.isNullOrEmpty(verifica.getIdDatoDistributore())) {
			ex.addFieldRequired(CPBECpGestVerifica.APPDATA_VERIFICA_CODE + ".idDatoDistributore");
		}

		if (ex.getFieldList().size() > 0)
		{
			throw ex;
		}

	}

	public void validazioneFormaleConfermaAccertamentoCampiVerifiche (Accertamento accertamento, CPBECpDettaglioAccertamentoConf.RicercaCampoAccertamentoEnum tipoRicerca)  throws ValidationManagerException  {
		preparaToValidate(accertamento);

		ValidationManagerException ex = new ValidationManagerException();

		if(RicercaCampoAccertamentoEnum.RICERCA_IMPIANTO.equals(tipoRicerca) && GenericUtil.isNullOrEmpty(accertamento.getCodiceImpiantoNew())) {
			ex.addFieldRequired(CPBECpDettaglioAccertamentoConf.APPDATA_ACCERTAMENTO_CODE + ".codiceImpiantoNew");
		}

		/*
		if (RicercaCampoVerificaEnum.RICERCA_BOLLINO.equals(tipoRicerca) && GenericUtil.isNullOrEmpty(verifica.getSiglaBollino()) && GenericUtil.isNullOrEmpty(verifica.getNumeroBollino())) {
			ex.addFieldRequired(CPBECpGestVerifica.APPDATA_VERIFICA_CODE + ".siglaBollino");
			ex.addFieldRequired(CPBECpGestVerifica.APPDATA_VERIFICA_CODE + ".numeroBollino");
		}

		if (RicercaCampoVerificaEnum.RICERCA_DISTRIBUTORE.equals(tipoRicerca) && GenericUtil.isNullOrEmpty(verifica.getIdDatoDistributore())) {
			ex.addFieldRequired(CPBECpGestVerifica.APPDATA_VERIFICA_CODE + ".idDatoDistributore");
		}
		*/
		if (ex.getFieldList().size() > 0)
		{
			throw ex;
		}

	}

	public void validazioneEliminaVerifica (String idVerificaSelezionata) throws ValidationManagerException {
		Integer filtroVerifica = ConvertUtil.convertToInteger(idVerificaSelezionata);
		try {

			//VALIDAZIONE SULLA SVEGLIA + ACCERTAMENTI + ISPEZIONI
			SigitExtVerificaDto verificaDaDb = getSigitMgr().getDbVerificaMgr().getVerificaById(filtroVerifica);
			if (verificaDaDb != null && verificaDaDb.getDtSveglia() != null) {
				throw new ValidationManagerException(new Message(Messages.ERRORE_DEL_VERIFICA_SVEGLIA));
			} else if (verificaDaDb != null && verificaDaDb.getFkAccertamento() != null) {
				throw new ValidationManagerException(new Message(Messages.ERRORE_DEL_VERIFICA_ACCERTAMENTO));
			} else if (verificaDaDb != null && verificaDaDb.getFkIspezione() != null) {
				throw new ValidationManagerException(new Message(Messages.ERRORE_DEL_VERIFICA_ISPEZIONE));
			}

			//VALIDAZIONE SULLA PRESENZA DI AZIONI
			SigitTAzioneDto azioneFilter = new SigitTAzioneDto();
			azioneFilter.setFkVerifica(filtroVerifica);
			List<SigitTAzioneDto> azioniVerifica = getSigitMgr().getDbAzioneMgr().cercaAzione(azioneFilter);
			if (azioniVerifica != null && azioniVerifica.size() > 0) {
				throw new ValidationManagerException(new Message(Messages.ERRORE_DEL_VERIFICA_AZIONE));
			}



		} catch (DbManagerException e) {
			throw new ValidationManagerException(e.getMsg());
		}

	}

	public void validazioneFormaleSveglia (Sveglia verifica) throws ValidationManagerException {
		/**
		 * METODO DI VALIDAZIONE DELLA SVEGLIA: LA DECRIZIONE E' OBBLIGATORIA
		 * LA DATA E' OBBLIGATORIA E DEVE ESSERE FUTURA
		 */
		preparaToValidate(verifica);
		ValidationManagerException ex = new ValidationManagerException();
		if (GenericUtil.isNullOrEmpty(verifica.getDataSveglia())) {
			ex.addFieldRequired(CPBECpSveglia.APPDATA_SVEGLIA_CODE + ".dataSveglia");
		} else {
			isDataPassata(verifica.getDataSveglia(), CPBECpSveglia.APPDATA_SVEGLIA_CODE + ".dataSveglia", ex);
		}

		if (GenericUtil.isNullOrEmpty(verifica.getNoteSveglia())) {
			ex.addFieldRequired(CPBECpSveglia.APPDATA_SVEGLIA_CODE + ".noteSveglia");
		} else {
			checkAsciiStringMaxLength(verifica.getNoteSveglia(), 500, CPBECpSveglia.APPDATA_SVEGLIA_CODE + ".noteSveglia", ex);
		}

		if(!ex.getFieldList().isEmpty()){
			throw ex;
		}


	}

	public void validazioneFormaleVerifica (Verifica verifica, TipoVerificaEnum tipoVerifica) throws ValidationManagerException, ManagerException {
		preparaToValidate(verifica);

		ValidationManagerException ex = new ValidationManagerException();
		if (GenericUtil.isNullOrEmpty(verifica.getTipoVerifica())) {
			ex.addFieldRequired(CPBECpGestVerifica.APPDATA_VERIFICA_CODE + ".tipoVerifica");
		} else {
			boolean codiceImpiantoObbligatorio = false;
			boolean bollinoObbligatorio = false;
			boolean datoDistributoreObbligatorio = false;

			ex.setMsg(new Message(Messages.ERRORE_RICERCA));

			if (TipoVerificaEnum.IMPIANTO.equals(tipoVerifica) || TipoVerificaEnum.RELAZIONE.equals(tipoVerifica)
					|| TipoVerificaEnum.DECADENZA3R.equals(tipoVerifica)) {
				codiceImpiantoObbligatorio = true;
			}

			if (TipoVerificaEnum.REE.equals(tipoVerifica)) {
				bollinoObbligatorio = true;
			}

			if (TipoVerificaEnum.DATO_DISTRIBUTORE.equals(tipoVerifica)) {
				datoDistributoreObbligatorio = true;
			}

			if (codiceImpiantoObbligatorio && GenericUtil.isNullOrEmpty(verifica.getRisultatoImpianto())) {
				ex.addFieldRequired(CPBECpGestVerifica.APPDATA_VERIFICA_CODE + ".codiceImpianto");
			}

			if (bollinoObbligatorio && GenericUtil.isNullOrEmpty(verifica.getRisultatoBollinoExtended())) {
				ex.addFieldRequired(CPBECpGestVerifica.APPDATA_VERIFICA_CODE + ".siglaBollino");
				ex.addFieldRequired(CPBECpGestVerifica.APPDATA_VERIFICA_CODE + ".numeroBollino");
			}

			// Il codice impianto non e' obbligatorio, ma se lo indica lo deve cercare
			if (GenericUtil.isNotNullOrEmpty(verifica.getCodiceImpianto()) && GenericUtil.isNullOrEmpty(verifica.getRisultatoImpianto()))
			{
				ex.addFieldRequired(CPBECpGestVerifica.APPDATA_VERIFICA_CODE + ".codiceImpianto");
			}


			if (datoDistributoreObbligatorio && GenericUtil.isNullOrEmpty(verifica.getRisultatoDatoDistributore())) {
				ex.addFieldRequired(CPBECpGestVerifica.APPDATA_VERIFICA_CODE + ".idDatoDistributore");
			}
		}

		if(!ex.getFieldList().isEmpty()){
			throw ex;
		}

		/* rimosso automatismo sulla ricerca

		//SE VALORIZZATO CODICE IMPIANTO E NON E' STATA ESEGUITA LA RICERCA...
		if (!GenericUtil.isNullOrEmpty(verifica.getCodiceImpianto()) && GenericUtil.isNullOrEmpty(verifica.getRisultatoImpianto())) {
			//RIESEGUE LA RICERCA
			getSigitMgr().ricercaImpiantoPerVerifica(verifica, false);
		}

		if ((!GenericUtil.isNullOrEmpty(verifica.getSiglaBollino()) || !GenericUtil.isNullOrEmpty(verifica.getNumeroBollino()))
				&& GenericUtil.isNullOrEmpty(verifica.getRisultatoBollino())) {
			//RIESEGUE LA RICERCA
			getSigitMgr().ricercaBollinoPerVerifica(verifica, false);
		}

		if (!GenericUtil.isNullOrEmpty(verifica.getIdDatoDistributore()) && GenericUtil.isNullOrEmpty(verifica.getRisultatoDatoDistributore())) {
			//RIESEGUE LA RICERCA
			getSigitMgr().ricercaDistributorePerVerifica(verifica, false);

		} */

	}

	public void validazioneFormaleRicercaVerifiche (RicercaVerifica ricercaVerifiche) throws ValidationManagerException {
		preparaToValidate(ricercaVerifiche);

		ValidationManagerException ex = new ValidationManagerException();

		//verifica sulla presenza di almeno un criterio di ricerca
		if (	!GenericUtil.isObjPopulate(ricercaVerifiche) ){
			// Non e' stato impostato nessun paramentro
			throw new ValidationManagerException(new Message(Messages.S010));
		}

		//CONTROLLO SULLA VALIDITA' DELLE DATE
		if (!StringUtils.isEmpty(ricercaVerifiche.getDataCreazioneA())) {
			checkDate(ricercaVerifiche.getDataCreazioneA(), CPBECpRicercaVerifiche.APPDATA_RICERCAVERIFICA_CODE + ".dataCreazioneA", ex);
		}

		if (!StringUtils.isEmpty(ricercaVerifiche.getDataCreazioneDA())) {
			checkDate(ricercaVerifiche.getDataCreazioneDA(), CPBECpRicercaVerifiche.APPDATA_RICERCAVERIFICA_CODE + ".dataCreazioneDA", ex);
		}

//		checkCodiceFiscalePartitaIva(ricercaVerifiche.getCfUtente(), CPBECpRicercaVerifiche.APPDATA_RICERCAVERIFICA_CODE + ".cfUtente", ex);

		//CONTROLLO NUM+CODICE BOLLINO
		Boolean siglaBollinoEmpty = GenericUtil.isNullOrEmpty(ricercaVerifiche.getSiglaBollino());
		Boolean numeroBollinoEmpty = GenericUtil.isNullOrEmpty(ricercaVerifiche.getNumeroBollino());

		if (!siglaBollinoEmpty.equals(numeroBollinoEmpty)) {
			ex.setMsg(new Message(Messages.S011_bis));
			ex.addField( CPBECpRicercaVerifiche.APPDATA_RICERCAVERIFICA_CODE + ".siglaBollino");
			ex.addField( CPBECpRicercaVerifiche.APPDATA_RICERCAVERIFICA_CODE + ".numeroBollino");
			throw ex;
		}

	}


	public void validazioneFormaleRicercaSanzioni (RicercaSanzioni ricercaSanzioni) throws ValidationManagerException {
		preparaToValidate(ricercaSanzioni);

		ValidationManagerException ex = new ValidationManagerException();

		//verifica sulla presenza di almeno un criterio di ricerca
		if (	!GenericUtil.isObjPopulate(ricercaSanzioni) ){
			// Non e' stato impostato nessun paramentro
			throw new ValidationManagerException(new Message(Messages.S010));
		}

		//CONTROLLO SULLA VALIDITA' DELLE DATE
		if (!StringUtils.isEmpty(ricercaSanzioni.getDataAnnullamentoA())) {
			checkDate(ricercaSanzioni.getDataAnnullamentoA(), CPBECpRicercaSanzione.APPDATA_RICERCASANZIONI_CODE + ".dataAnnullamentoA", ex);
		}

		if (!StringUtils.isEmpty(ricercaSanzioni.getDataAnnullamentoDa())) {
			checkDate(ricercaSanzioni.getDataAnnullamentoDa(), CPBECpRicercaSanzione.APPDATA_RICERCASANZIONI_CODE + ".dataAnnullamentoDa", ex);
		}

		if (!StringUtils.isEmpty(ricercaSanzioni.getDataComunicazioneA())) {
			checkDate(ricercaSanzioni.getDataComunicazioneA(), CPBECpRicercaSanzione.APPDATA_RICERCASANZIONI_CODE + ".dataComunicazioneA", ex);
		}

		if (!StringUtils.isEmpty(ricercaSanzioni.getDataComunicazioneDa())) {
			checkDate(ricercaSanzioni.getDataComunicazioneDa(), CPBECpRicercaSanzione.APPDATA_RICERCASANZIONI_CODE + ".dataComunicazioneDa", ex);
		}

		if (!StringUtils.isEmpty(ricercaSanzioni.getDataCreazioneA())) {
			checkDate(ricercaSanzioni.getDataCreazioneA(), CPBECpRicercaSanzione.APPDATA_RICERCASANZIONI_CODE + ".dataCreazioneA", ex);
		}

		if (!StringUtils.isEmpty(ricercaSanzioni.getDataCreazioneDa())) {
			checkDate(ricercaSanzioni.getDataCreazioneDa(), CPBECpRicercaSanzione.APPDATA_RICERCASANZIONI_CODE + ".dataCreazioneDa", ex);
		}

		if (!StringUtils.isEmpty(ricercaSanzioni.getDataPagamentoA())) {
			checkDate(ricercaSanzioni.getDataPagamentoA(), CPBECpRicercaSanzione.APPDATA_RICERCASANZIONI_CODE + ".dataPagamentoA", ex);
		}

		if (!StringUtils.isEmpty(ricercaSanzioni.getDataPagamentoDa())) {
			checkDate(ricercaSanzioni.getDataPagamentoDa(), CPBECpRicercaSanzione.APPDATA_RICERCASANZIONI_CODE + ".dataPagamentoDa", ex);
		}

		//controllo sulla lunghezza del campo motivo
		if (!StringUtils.isEmpty(ricercaSanzioni.getMotivo()) && ricercaSanzioni.getMotivo().length()<3) {
			ex.addField(CPBECpRicercaSanzione.APPDATA_RICERCASANZIONI_CODE + ".motivo", "Indicare almeno 3 caratteri");
		}

		if(!ex.getFieldList().isEmpty()){
			throw ex;
		}

	}

	public void validazioneFormaleRicercaIspezioni (RicercaIspezioni2018 ricercaIspezioni) throws ValidationManagerException {
		preparaToValidate(ricercaIspezioni);

		ValidationManagerException ex = new ValidationManagerException();

		//verifica sulla presenza di almeno un criterio di ricerca
		if (	!GenericUtil.isObjPopulate(ricercaIspezioni) ){
			// Non e' stato impostato nessun paramentro
			throw new ValidationManagerException(new Message(Messages.S010));
		}

		//CONTROLLO SULLA VALIDITA' DELLE DATE
		if (!StringUtils.isEmpty(ricercaIspezioni.getDataConclusioneA())) {
			checkDate(ricercaIspezioni.getDataConclusioneA(), CPBECpRicercaIspezioni2018.APPDATA_RICERCAISPEZIONI2018_CODE + ".dataConclusioneA", ex);
		}

		if (!StringUtils.isEmpty(ricercaIspezioni.getDataConclusioneDa())) {
			checkDate(ricercaIspezioni.getDataConclusioneDa(), CPBECpRicercaIspezioni2018.APPDATA_RICERCAISPEZIONI2018_CODE + ".dataConclusioneDa", ex);
		}

		if (!StringUtils.isEmpty(ricercaIspezioni.getDataCreazioneA())) {
			checkDate(ricercaIspezioni.getDataCreazioneA(), CPBECpRicercaIspezioni2018.APPDATA_RICERCAISPEZIONI2018_CODE + ".dataCreazioneA", ex);
		}

		if (!StringUtils.isEmpty(ricercaIspezioni.getDataCreazioneDa())) {
			checkDate(ricercaIspezioni.getDataCreazioneDa(), CPBECpRicercaIspezioni2018.APPDATA_RICERCAISPEZIONI2018_CODE + ".dataCreazioneDa", ex);
		}

		if(!ex.getFieldList().isEmpty()){
			throw ex;
		}

	}

	public void validazioneFormaleRicercaAccertamenti (RicercaAccertamento ricercaAccertamenti) throws ValidationManagerException {
		preparaToValidate(ricercaAccertamenti);

		ValidationManagerException ex = new ValidationManagerException();

		//verifica sulla presenza di almeno un criterio di ricerca
		if (	!GenericUtil.isObjPopulate(ricercaAccertamenti) ){
			// Non e' stato impostato nessun paramentro
			throw new ValidationManagerException(new Message(Messages.S010));
		}

		//CONTROLLO SULLA VALIDITA' DELLE DATE
		if (!StringUtils.isEmpty(ricercaAccertamenti.getDataCreazioneA())) {
			checkDate(ricercaAccertamenti.getDataCreazioneA(), CPBECpRicercaAccertamenti.APPDATA_RICERCAACCERTAMENTO_CODE + ".dataCreazioneA", ex);
		}

		if (!StringUtils.isEmpty(ricercaAccertamenti.getDataCreazioneDA())) {
			checkDate(ricercaAccertamenti.getDataCreazioneDA(), CPBECpRicercaAccertamenti.APPDATA_RICERCAACCERTAMENTO_CODE + ".dataCreazioneDA", ex);
		}

		if (!StringUtils.isEmpty(ricercaAccertamenti.getDataConclusioneA())) {
			checkDate(ricercaAccertamenti.getDataConclusioneA(), CPBECpRicercaAccertamenti.APPDATA_RICERCAACCERTAMENTO_CODE + ".dataConclusioneA", ex);
		}

		if (!StringUtils.isEmpty(ricercaAccertamenti.getDataConclusioneDA())) {
			checkDate(ricercaAccertamenti.getDataConclusioneDA(), CPBECpRicercaAccertamenti.APPDATA_RICERCAACCERTAMENTO_CODE + ".dataConclusioneDA", ex);
		}

//		checkCodiceFiscalePartitaIva(ricercaAccertamenti.getCfUtente(), CPBECpRicercaAccertamenti.APPDATA_RICERCAACCERTAMENTO_CODE + ".cfUtente", ex);


	}

	public void validazioneFormaleAccertamento (Accertamento accertamento) throws ValidationManagerException, ManagerException {
		preparaToValidate(accertamento);

		ValidationManagerException ex = new ValidationManagerException();
		if (GenericUtil.isNullOrEmpty(accertamento.getIdTipoAnomalia())) {
			ex.addFieldRequired(CPBECpGestAccertamento.APPDATA_ACCERTAMENTO_CODE + ".idTipoAnomalia");
		}

		if(!ex.getFieldList().isEmpty()){
			throw ex;
		}

		ex = null;
		checkAsciiStringMaxLength(accertamento.getNote(), 1000, CPBECpGestAccertamento.APPDATA_ACCERTAMENTO_CODE + ".note", ex);

	}

	public void validazioneAnnullaIspezione (Ispezione2018 ispezione) throws ValidationManagerException {

		Integer idIspezione = ConvertUtil.convertToInteger(ispezione.getIdentificativoIspezione());
		try {
			//VALIDAZIONE SULLA PRESENZA DI SANZIONI
			List<SigitTSanzioneDto> sanzioni = getDbMgr().cercaSanzioneValidaByIdIspezione(idIspezione);
			log.debug("validazioneAnnullaIspezione - sanzioni: "+sanzioni);
			if (sanzioni != null && sanzioni.size() > 0) {
				throw new ValidationManagerException(new Message(Messages.ERRORE_DEL_ISPEZIONE_SANZIONE));
			}

//			//VALIDAZIONE SULLA SVEGLIA. eliminata
//			log.debug("validazioneAnnullaIspezione - sveglie: "+ispezione.getDescrizioneSveglia());
//			if (GenericUtil.isNotNullOrEmpty(ispezione.getDescrizioneSveglia())) {
//				throw new ValidationManagerException(new Message(Messages.ERRORE_DEL_ISPEZIONE_SVEGLIA));
//			}

		} catch (DbManagerException e) {

			log.error(e);

			throw new ValidationManagerException(e.getMsg());
		}



	}

	public void validazioneAnnullaAccertamento (Accertamento accertamento) throws ValidationManagerException {
		Integer filtroVerifica = ConvertUtil.convertToInteger(accertamento.getIdentificativo());
		try {

			log.debug("validazioneAnnullaAccertamento - PASSO1");

			if (GenericUtil.isNullOrEmpty(accertamento.getAssegnatario()))
			{
				throw new ValidationManagerException(new Message(Messages.ERRORE_ACCERTAMENTO_SENZA_ASSEGNATARIO));
			}

			//VALIDAZIONE SULLA PRESENZA DI ISPEZIONI
			List<SigitTIspezione2018Dto> ispezioniVerifica = getDbMgr().cercaIspezione2018ValidaByIdAccertamento(filtroVerifica);
			log.debug("validazioneAnnullaAccertamento - ispezioniVerifica: "+ispezioniVerifica);
			if (ispezioniVerifica != null && ispezioniVerifica.size() > 0) {
				throw new ValidationManagerException(new Message(Messages.ERRORE_DEL_ACCERTAMENTO_ISPEZIONE));
			}

			//VALIDAZIONE SULLA PRESENZA DI SANZIONI
			List<SigitTSanzioneDto> sanzioniVerifica = getDbMgr().cercaSanzioneValidaByIdAccertamento(filtroVerifica);
			log.debug("validazioneAnnullaAccertamento - sanzioniVerifica: "+sanzioniVerifica);
			if (sanzioniVerifica != null && sanzioniVerifica.size() > 0) {
				throw new ValidationManagerException(new Message(Messages.ERRORE_DEL_ACCERTAMENTO_SANZIONE));
			}

			//VALIDAZIONE SULLA SVEGLIA
			SigitTVerificaDto verificaDaDb = getSigitMgr().getDbVerificaMgr().getVerificaById(ConvertUtil.convertToInteger(accertamento.getIdVerifica()));
			log.debug("validazioneAnnullaAccertamento - verificaDaDb: "+verificaDaDb);
			if (verificaDaDb != null && verificaDaDb.getDtSveglia() != null) {
				throw new ValidationManagerException(new Message(Messages.ERRORE_DEL_ACCERTAMENTO_SVEGLIA));
			}
			log.debug("validazioneAnnullaAccertamento - PASSO2");

		} catch (DbManagerException e) {

			log.error(e);

			throw new ValidationManagerException(e.getMsg());
		}

	}


	public void validazioneConcludiAccertamento (Accertamento accertamento) throws ValidationManagerException {
		try {


			log.debug("#### accertamento.getIdTipoAnomalia(): "+accertamento.getIdTipoAnomalia());
			if (GenericUtil.isNullOrEmpty(accertamento.getIdTipoAnomalia()) ||
					ConvertUtil.convertToInteger(accertamento.getIdTipoAnomalia()).intValue() == Constants.DATO_NON_DISPONIBILE)
			{
				ValidationManagerException ex = new ValidationManagerException(new Message(Messages.ERRORE_ACCERTAMENTO_SENZA_ANOMALIA));
				ex.addFieldRequired(CPBECpDettaglioAccertamentoConf.APPDATA_ACCERTAMENTO_CODE + ".idTipoAnomalia");
				throw ex;
			}

			if (GenericUtil.isNullOrEmpty(accertamento.getAssegnatario()))
			{
				throw new ValidationManagerException(new Message(Messages.ERRORE_ACCERTAMENTO_SENZA_ASSEGNATARIO));
			}

			if (accertamento.getIdStatoAccertamento() != Constants.ID_STATO_ACCERTAMENTO_IN_CORSO)
			{
				throw new ValidationManagerException(new Message(Messages.ERRORE_DEL_ACCERTAMENTO_GIA_CHIUSO));
			}

			//VALIDAZIONE SULLA PRESENZA DI ISPEZIONI
			List<SigitTIspezione2018Dto> ispezioniVerifica = getDbMgr().cercaIspezione2018BozzaByIdAccertamento(ConvertUtil.convertToInteger(accertamento.getIdentificativo()));
			if (ispezioniVerifica != null && ispezioniVerifica.size() > 0) {
				throw new ValidationManagerException(new Message(Messages.ERRORE_DEL_ACCERTAMENTO_ISPEZIONE));
			}

		} catch (DbManagerException e) {
			throw new ValidationManagerException(e.getMsg());
		}

	}

	public void validazioneSalvaIspezione (Ispezione2018 ispezione) throws ValidationManagerException {

		ValidationManagerException ex = new ValidationManagerException();

		//validazione dei campi stringa
		checkAsciiStringMaxLength(ispezione.getNote(), 1000, CPBECpDettaglioIspezione2018.APPDATA_ISPEZIONE2018_CODE + ".note", ex);


		if(!ex.getFieldList().isEmpty()){
			throw ex;
		}

	}


	public void validazionePraparaConcludiIspezione (Ispezione2018 ispezione, List<DettaglioAllegato> listaAllegati) throws ValidationManagerException {

		//l'ispezione deve avere un codice impianto
		if (GenericUtil.isNullOrEmpty(ispezione.getCodiceImpianto())) {
			throw new ValidationManagerException(new Message(Messages.ERRORE_ISPEZIONE_NO_IMPIANTO));
		}

		//l'ispezione non puo' avere uno stato diverso da quello iniziale
		if (ConvertUtil.convertToInteger(ispezione.getIdStatoIspezione()) != Constants.ID_STATO_ISPEZIONE_BOZZA)
		{
			throw new ValidationManagerException(new Message(Messages.ERRORE_ISPEZIONE_GIA_CHIUSA));
		}

		if (GenericUtil.isNullOrEmpty(ispezione.getIdIspezIspet())) {
			throw new ValidationManagerException(new Message(Messages.ERRORE_ISPEZIONE_NO_ISPETTORE_AZIONE, "concludere l'ispezione"));
		}

		//eliminazione dei rapporti di prova tipo bozza
		if (listaAllegati != null && !listaAllegati.isEmpty()) {
			for (DettaglioAllegato allegato : listaAllegati) {
				if (Constants.DESC_STATO_RAPPORTO_BOZZA.equalsIgnoreCase(allegato.getStatoAllegato())) {
					throw new ValidationManagerException(new Message(Messages.ERRORE_CONCLUDI_ISPEZIONE_RAPPORTI));
				}
			}
		}

	}

	public void validazioneConfermaConcludiIspezione (ConclusioneIspezione2018 conclusioneIspezione) throws ValidationManagerException, ManagerException {
		preparaToValidate(conclusioneIspezione);

		ValidationManagerException ex = new ValidationManagerException();

		//validazione dei campi stringa

		if (GenericUtil.isNullOrEmpty(conclusioneIspezione.getEnteCompetente())) {
			ex.addFieldRequired(CPBECpDettaglioIspezione2018.APPDATA_CONCLUSIONEISPEZIONE2018_CODE + ".enteCompetente");
		}

		if (GenericUtil.isNullOrEmpty(conclusioneIspezione.getFlgEsito())) {
			ex.addFieldRequired(CPBECpDettaglioIspezione2018.APPDATA_CONCLUSIONEISPEZIONE2018_CODE + ".flgEsito");
		}

		checkAsciiStringMaxLength(conclusioneIspezione.getNote(), 1000, CPBECpDettaglioIspezione2018.APPDATA_CONCLUSIONEISPEZIONE2018_CODE + ".note", ex);

		if(!ex.getFieldList().isEmpty()){
			throw ex;
		}

	}

	public void validazioneCercaApparecchiaturePerRapProva (RicercaApparecchiatureRappProva input) throws ValidationManagerException {
		ValidationManagerException ex = new ValidationManagerException();

		if (GenericUtil.isNullOrEmpty(input.getDataIspezione())) {
			ex.addFieldRequired(CPBECpInitRapProva.APPDATA_RICERCAAPPARECCHIATURERAPPPROVA_CODE + ".dataIspezione");
		}

		if (GenericUtil.isNullOrEmpty(input.getOraIspezione())) {
			ex.addFieldRequired(CPBECpInitRapProva.APPDATA_RICERCAAPPARECCHIATURERAPPPROVA_CODE + ".oraIspezione");
		}

		if (GenericUtil.isNullOrEmpty(input.getIdTipoAllegato())) {
			ex.addFieldRequired(CPBECpInitRapProva.APPDATA_RICERCAAPPARECCHIATURERAPPPROVA_CODE + ".idTipoAllegato");
		}

		if(!ex.getFieldList().isEmpty()){
			throw ex;
		}
	}


	public void validazioneSbloccaNomina3R (Accertamento accertamento) throws ValidationManagerException {
		try {

			if (GenericUtil.isNotNullOrEmpty(accertamento.getCodiceImpianto()))
			{
				SigitTImpiantoDto impianto = getDbMgr().cercaImpiantoDtoById(accertamento.getCodiceImpianto());

				if (!ConvertUtil.convertToBooleanAllways(impianto.getFlgBloccoNomina3r()))
				{
					throw new ValidationManagerException(new Message(Messages.ERRORE_DEL_ACCERTAMENTO_3R_NO_BLOCCATO));
				}
			}
			else
			{
				throw new ValidationManagerException(new Message(Messages.ERRORE_DEL_ACCERTAMENTO_NO_IMPIANTO));

			}

		} catch (DbManagerException e) {
			throw new ValidationManagerException(e.getMsg());
		}

	}

	public void validazioneFormaleConcludiAccertamento (Accertamento accertamento) throws ValidationManagerException, ManagerException {
		preparaToValidate(accertamento);

		ValidationManagerException ex = new ValidationManagerException();

		if (GenericUtil.isNullOrEmpty(accertamento.getCodiceImpianto()) && GenericUtil.isNullOrEmpty(accertamento.getCodiceImpiantoNew())) {
			ex.addFieldRequired(CPBECpDettaglioAccertamentoConf.APPDATA_ACCERTAMENTO_CODE + ".codiceImpiantoNew");
		}

		if (GenericUtil.isNullOrEmpty(accertamento.getIdTipoConclusione())) {
			ex.addFieldRequired(CPBECpDettaglioAccertamentoConf.APPDATA_ACCERTAMENTO_CODE + ".idTipoConclusione");
		}

		if(!ex.getFieldList().isEmpty()){
			throw ex;
		}

		if (GenericUtil.isNullOrEmpty(accertamento.getIdTipoAnomalia())) {
			throw new ValidationManagerException(new Message(Messages.ERRORE_ACCERTAMENTO_SENZA_ANOMALIA));
		}

	}

	public void validazioneFormaleAssociaAccertamento (Accertamento accertamento) throws ValidationManagerException, ManagerException {
		preparaToValidate(accertamento);

		if (log.isDebugEnabled())
			GenericUtil.stampa(accertamento, true, 3);

		ValidationManagerException ex = new ValidationManagerException();
		if (GenericUtil.isNullOrEmpty(accertamento.getIdValidatore())) {
			ex.addFieldRequired(CPBECpDettaglioAccertamentoConf.APPDATA_ACCERTAMENTO_CODE + ".idValidatore");
		}

		if(!ex.getFieldList().isEmpty()){
			throw ex;
		}

	}

	public void validazioneFormaleAssociaCodiceImpiantoAccertamento (it.csi.sigit.sigitwebn.dto.accertamento.RicercaImpiantoDaAssociare accertamento) throws ValidationManagerException, ManagerException {
		preparaToValidate(accertamento);

		if (log.isDebugEnabled())
			GenericUtil.stampa(accertamento, true, 3);

		ValidationManagerException ex = new ValidationManagerException();
		if (GenericUtil.isNullOrEmpty(
				accertamento.getCodiceImpianto())) {
			ex.addFieldRequired(
					CPBECpDettaglioAccertamentoConf.APPDATA_RICERCAIMPIANTODAASSOCIAREACCERTAMENTO_CODE
							+ ".codiceImpianto");
		}

		if(!ex.getFieldList().isEmpty()){
			throw ex;
		}

	}

	public void validazioneFormaleAssociaCodiceImpiantoIspezione (it.csi.sigit.sigitwebn.dto.ispezioni.RicercaImpiantoDaAssociare ispezione) throws ValidationManagerException, ManagerException {
		preparaToValidate(ispezione);

		if (log.isDebugEnabled())
			GenericUtil.stampa(ispezione, true, 3);

		ValidationManagerException ex = new ValidationManagerException();
		if (GenericUtil.isNullOrEmpty(
				ispezione.getCodiceImpianto())) {
			ex.addFieldRequired(
					CPBECpDettaglioIspezione2018.APPDATA_RICERCAIMPIANTODAASSOCIARE_CODE
							+ ".codiceImpianto");
		}

		if(!ex.getFieldList().isEmpty()){
			throw ex;
		}

	}
	public void validazioneFormaleCercaUtenteElencoSveglie (RicercaSveglie ricercaSveglie) throws ValidationManagerException {
		preparaToValidate(ricercaSveglie);

		ValidationManagerException ex = new ValidationManagerException();

		if (GenericUtil.isNullOrEmpty(ricercaSveglie.getCfUtente())) {
			ex.addFieldRequired(CPBECpElencoSveglie.APPDATA_RICERCASVEGLIE_CODE + ".cfUtente");
		}

		if(!ex.getFieldList().isEmpty()){
			throw ex;
		}

		checkCodiceFiscalePartitaIva(ricercaSveglie.getCfUtente(), CPBECpElencoSveglie.APPDATA_RICERCASVEGLIE_CODE + ".cfUtente", null);

	}

	public void validazioneFormaleRicercaAlleagti(RicercaAllegati ricercaAllegati) throws ValidationManagerException {

		boolean idStatoAlleagtoEmpty;
		boolean idTipoAlleagtoEmpty;
		boolean dataControlloDaEmpty;
		boolean dataControlloAEmpty;

		boolean sicurezzaImpiantiEmpty;
		boolean isConOsservazioniEmpty;
		boolean isConRaccomandazioniEmpty;
		boolean isConPrescrizioniEmpty;

		boolean dataInterventoDaEmpty;
		boolean dataInterventoAEmpty;

		boolean idSiglaBollinoEmpty;
		boolean numeroBollinoEmpty;

		boolean codiceFiscaleEmpty;
		boolean siglaReaEmpty;
		boolean numeroReaEmpty;

		Date dataControlloDa = null;
		Date dataControlloA = null;
		Date dataInterventoDa = null;
		Date dataInterventoA = null;

		if(ricercaAllegati != null) {
			log.debug("FRAAAAAAAAAAAAAAAAA DENTRO LA VALIDAZIONE ");

			idStatoAlleagtoEmpty = GenericUtil.isNullOrEmpty(ricercaAllegati.getIdStatoAllegato());
			idTipoAlleagtoEmpty = GenericUtil.isNullOrEmpty(ricercaAllegati.getIdTipoDocumento());
			dataControlloDaEmpty = GenericUtil.isNullOrEmpty(ricercaAllegati.getDataControlloDa());
			dataControlloAEmpty = GenericUtil.isNullOrEmpty(ricercaAllegati.getDataControlloA());

			sicurezzaImpiantiEmpty = GenericUtil.isNullOrEmpty(ricercaAllegati.getSicurezzaImpianti());
//			flagSoloImpiantiNonFunzionantiEmpty = !GenericUtil.isChecked(ricercaAllegati.getImpiantiNonFunzionanti());
//			GenericUtil.isNullOrEmpty(ricercaAllegati.getSicurezzaImpianti()) &&
//
			isConOsservazioniEmpty = !ricercaAllegati.getConOsservazioni();
			isConRaccomandazioniEmpty = !ricercaAllegati.getConRaccomandazioni();
			isConPrescrizioniEmpty = !ricercaAllegati.getConPrescrizioni();

			//!ric.getSicurezzaImpianti() &&
//			!ricercaAllegati.getConOsservazioni() &&
//			!ricercaAllegati.getConRaccomandazioni() &&
//			!ricercaAllegati.getConPrescrizioni() &&

			dataInterventoDaEmpty = GenericUtil.isNullOrEmpty(ricercaAllegati.getInterventoDa());
			dataInterventoAEmpty = GenericUtil.isNullOrEmpty(ricercaAllegati.getInterventoA());

			idSiglaBollinoEmpty = GenericUtil.isNullOrEmpty(ricercaAllegati.getIdBollinoSigla());
			numeroBollinoEmpty =  GenericUtil.isNullOrEmpty(ricercaAllegati.getNumeroBollino());

			siglaReaEmpty = GenericUtil.isNullOrEmpty(ricercaAllegati.getIdReaSigla());
			numeroReaEmpty = GenericUtil.isNullOrEmpty(ricercaAllegati.getNumeroRea());
			codiceFiscaleEmpty = GenericUtil.isNullOrEmpty(ricercaAllegati.getCodiceFiscale());

			log.debug("1  idStatoAlleagtoEmpty: "+idStatoAlleagtoEmpty);
			log.debug("2  idTipoAlleagtoEmpty: "+idTipoAlleagtoEmpty);
			log.debug("3  dataControlloDaEmpty: "+dataControlloDaEmpty);
			log.debug("4  dataControlloAEmpty: "+dataControlloAEmpty);
			log.debug("5  dataControlloAEmpty: "+dataControlloAEmpty);
			log.debug("6  sicurezzaImpiantiEmpty: "+sicurezzaImpiantiEmpty);

			log.debug("7  isConOsservazioniEmpty: "+isConOsservazioniEmpty);
			log.debug("8  isConRaccomandazioniEmpty: "+isConRaccomandazioniEmpty);
			log.debug("9  isConPrescrizioniEmpty: "+isConPrescrizioniEmpty);

			log.debug("10  dataInterventoDaEmpty: "+dataInterventoDaEmpty);
			log.debug("11  dataInterventoAEmpty: "+dataInterventoAEmpty);
			log.debug("12  idSiglaBollinoEmpty: "+idSiglaBollinoEmpty);
			log.debug("13  numeroBollinoEmpty: "+numeroBollinoEmpty);
			log.debug("14  siglaReaEmpty: "+siglaReaEmpty);
			log.debug("15  numeroReaEmpty: "+numeroReaEmpty);
			log.debug("16  codiceFiscaleEmpty: "+codiceFiscaleEmpty);


			if(idStatoAlleagtoEmpty && idTipoAlleagtoEmpty && dataControlloDaEmpty && dataControlloAEmpty
					&& sicurezzaImpiantiEmpty && isConOsservazioniEmpty && isConRaccomandazioniEmpty && isConPrescrizioniEmpty
					&& dataInterventoDaEmpty && dataInterventoAEmpty
					&& idSiglaBollinoEmpty && numeroBollinoEmpty
					&& siglaReaEmpty && numeroReaEmpty && codiceFiscaleEmpty){
				// Non e' stato impostato nessun paramentro
				throw new ValidationManagerException(new Message(Messages.S010));
			}
			else
			{
				log.debug(" PASSATO IL CONTROLLO DI TUTTI I CAMPI NULLI ");
				//validita' formale delle date
				if(!dataControlloDaEmpty){
					checkDate(ricercaAllegati.getDataControlloDa(), ConstantsField.RICERCA_ALLEGATI_DATA_CONTROLLO_DA);
				}

				if(!dataControlloAEmpty){
					checkDate(ricercaAllegati.getDataControlloA(), ConstantsField.RICERCA_ALLEGATI_DATA_CONTROLLO_A);
				}

				if(!dataInterventoDaEmpty){
					checkDate(ricercaAllegati.getInterventoDa(), ConstantsField.RICERCA_ALLEGATI_DATA_INTERVENTO_DA);
				}

				if(!dataInterventoAEmpty){
					checkDate(ricercaAllegati.getInterventoA(), ConstantsField.RICERCA_ALLEGATI_DATA_INTERVENTO_A);
				}

				//cosecutio temporis per le date
				if(!dataControlloDaEmpty && !dataControlloAEmpty){
					try {
						dataControlloDa = ConvertUtil.convertToDate(ricercaAllegati.getDataControlloDa());
						dataControlloA = ConvertUtil.convertToDate(ricercaAllegati.getDataControlloA());
					} catch (Exception e) {
						// Le date sono sicuramente corrette (v. controlli precedenti)
					}
					checkIntervallo(dataControlloDa, dataControlloA, ConstantsField.RICERCA_ALLEGATI_DATA_CONTROLLO_DA, ConstantsField.RICERCA_ALLEGATI_DATA_CONTROLLO_A);
				}

				if(!dataInterventoDaEmpty && !dataInterventoAEmpty){
					try {
						dataInterventoDa = ConvertUtil.convertToDate(ricercaAllegati.getInterventoDa());
						dataInterventoA = ConvertUtil.convertToDate(ricercaAllegati.getInterventoA());
					} catch (Exception e) {
						// Le date sono sicuramente corrette (v. controlli precedenti)
					}
					checkIntervallo(dataInterventoDa, dataInterventoA, ConstantsField.RICERCA_ALLEGATI_DATA_INTERVENTO_DA, ConstantsField.RICERCA_ALLEGATI_DATA_INTERVENTO_A);
				}


				// Se e' stato inserita la sigla REA deve essere compilato anche il numero REA e viceversa
				checkSiglaAndNumeroRea(ricercaAllegati.getIdReaSigla(), ricercaAllegati.getNumeroRea(), ConstantsField.RICERCA_ALLEGATI_ID_SIGLA_REA,
						ConstantsField.RICERCA_ALLEGATI_NUMERO_REA);

				checkCodiceFiscalePartitaIva(ricercaAllegati.getCodiceFiscale(), ConstantsField.RICERCA_ALLEGATI_CF);
				//checkNumeroIntero(ricercaAllegati.getNumeroBollino(), ConstantsField.RICERCA_ALLEGATI_NUMERO_BOLLINO, Constants.MAX_NUMERO_BOLLINO_LEN);
			}
		}
		else {
			// Non e' stato inserito alcun criterio di ricerca
			throw new ValidationManagerException(new Message(Messages.S010));
		}

	}

	public void validazioneFormaleInviaAllegato(DettaglioAllegato dettaglioAllegato, Ruolo ruoloUtente) throws ValidationManagerException {

		try
		{
			if (dettaglioAllegato.getIdStatoPg().intValue() == Constants.ID_STATO_IMPRESA_SOSPESA
					|| dettaglioAllegato.getIdStatoPg().intValue() == Constants.ID_STATO_IMPRESA_RADIATA) {
				throw new ValidationManagerException(new Message(Messages.S147, dettaglioAllegato.getCodiceReaPg(),
						dettaglioAllegato.getCodiceFiscalePg()));
			} else if (dettaglioAllegato.getIdStatoPg().intValue() == Constants.ID_STATO_IMPRESA_CESSATA) {
				PersonaGiuridica personaGiuridica = getDbMgr()
						.cercaPersonaGiuridicaById(dettaglioAllegato.getIdPersonaGiuridica());

				//controllo se il manutentore loggato non abbia l'attivita' cessata
				verificaDataCessazioneAttivita(dettaglioAllegato.getDataControllo(),
						personaGiuridica.getDataCessazione());
			}

			if (dettaglioAllegato.getRuoloFunzionale().equalsIgnoreCase(Constants.RUOLO_ISPETTORE)) {
				throw new ValidationManagerException(new Message(Messages.S122));
			}

			List<SigitTLibrettoDto> librettoList = getDbMgr().cercaLibrettoByStato(dettaglioAllegato.getCodiceImpianto(),  Constants.ID_STATO_LIBRETTO_BOZZA);

			if (librettoList != null && librettoList.size() > 0)
			{
				throw new ValidationManagerException(new Message(
						Messages.S055));
			}

			//		else if (getSigitMgr().isPresenteLibrettoBozza(dettaglioAllegato.getCodiceImpianto())) {
			//			throw new ValidationManagerException(new Message(Messages.S055));
			//		} else {
			//controllo se l'allegato e' stato creato dal manutentore o installatore loggati
			if (ruoloUtente.getDescRuolo().equalsIgnoreCase(Constants.RUOLO_IMPRESA)) {
				//conosco l'idPersonaGiuridica dell'utente la confronto con quella legata all'allegato
				verificaSeAllegatoModificabile(dettaglioAllegato.getIdPersonaGiuridica(),
						ruoloUtente.getIdPersonaGiuridica(), Messages.S044);

			}

			if (Constants.DESC_STATO_RAPPORTO_INVIATO.equalsIgnoreCase(dettaglioAllegato.getStatoAllegato())
					|| Constants.DESC_STATO_RAPPORTO_RESPINTO
					.equalsIgnoreCase(dettaglioAllegato.getStatoAllegato())) {

				throw new ValidationManagerException(new Message(Messages.S040));
				//result.getGlobalErrors().add(Messages.S040);
				//result.setResultCode(INVIAALLEGATOPERIMPIANTO_OUTCOME_CODE__KO);

			} else {
				//						//vuol dire che e' in stato BOZZA, controllo il flag sulla tabella sigit_t_allegato e' stato ceccato
				//						if (dettaglioAllegato.getFlagControlloBozza() != Constants.FLAG_CONTROLLO_BOZZA_ALLEGATO_TRUE) {
				//							result.getGlobalErrors().add(Messages.S065);
				//							result.setResultCode(INVIAALLEGATOPERIMPIANTO_OUTCOME_CODE__KO);
				//						}

				isAllegatoInviabile(dettaglioAllegato.getIdAllegato());

				//				if (errori != null) {
				//					// Vuol dire che ci sono deglie rrori, quindi non si puo' inviare 'allegato
				//					result.getGlobalErrors().add(errori);
				//					result.setResultCode(INVIAALLEGATOPERIMPIANTO_OUTCOME_CODE__KO);
				//				} else
				if (isNessunResponsabileByCodImpiantoApp(
						dettaglioAllegato.getCodiceImpianto(), dettaglioAllegato.getDataControllo(),
						dettaglioAllegato.getIdTipoAllegato(), dettaglioAllegato.getIdApparecchiature())) {
					throw new ValidationManagerException(
							new Message(Messages.ERROR_RESPONSABILE_DATA_RAPP_ASSENTE));
				} else if (getDbMgr().cercaResponsabileAttivoByCodImpianto(
						ConvertUtil.convertToInteger(dettaglioAllegato.getCodiceImpianto())) == null) {
					// Vuol dire che non c'e' un respansabile attivo alla sysdate, non riuscirei a creare il libretto
					throw new ValidationManagerException(new Message(Messages.ERROR_RESPONSABILE_ASSENTE));
				}
				/*
				// Beppe - escluso controllo per bollino automatico
				else if (!isVerificaCodiceBollValidoDataControllo(
						dettaglioAllegato.getSiglaBollino(), dettaglioAllegato.getNumeroBollinoVerde(),
						dettaglioAllegato.getDataControllo())) {
					// Ho gia' rilanciato l'eccezione (dentro il metodo di controllo)
				}
				*/
			}
		}
		catch(DbManagerException e) {
			throw new ValidationManagerException(e, e.getMsg());
		}
		//}
	}

	public void checkDataCessazioneImpresa(String dataCessazione) throws ValidationManagerException {
			String dataSistema = ConvertUtil.convertToString(DateUtil.getSqlDataCorrente());

			log.debug("DATA cessazione IMPRESA stringa: "+dataCessazione);
			log.debug("DATA sistema stringa: "+dataSistema);
			boolean flag = DateUtil.checkDateOrder(dataCessazione, dataSistema, false);
			log.debug(" FLAG: "+flag);

			//Controllo se risulta maggiore o minore della data di sistema
			if(flag){
				throw new ValidationManagerException(new Message(Messages.S014,dataCessazione));
			}
	}


	public void validazioneFormaleRicercaBollini(RicercaTransazione ricercaCodImp) throws ValidationManagerException {

		boolean codiceFiscaleEmpty;
		boolean codiceImpiantoEmpty;
		boolean numeroBollinoEmpty;
		boolean siglaReaEmpty;
		boolean numeroReaEmpty;
		boolean siglaBollino;
		boolean dataAcquisizioneDa;
		boolean dataAcquisizioneA;

		if(ricercaCodImp != null) {
			codiceFiscaleEmpty = GenericUtil.isNullOrEmpty(ricercaCodImp.getCodiceFiscale());
			numeroBollinoEmpty = GenericUtil.isNullOrEmpty(ricercaCodImp.getNumeroBollino());
			codiceImpiantoEmpty = GenericUtil.isNullOrEmpty(ricercaCodImp.getCodiceImpianto());
			siglaReaEmpty = GenericUtil.isNullOrEmpty(ricercaCodImp.getIdSiglaRea());
			numeroReaEmpty = GenericUtil.isNullOrEmpty(ricercaCodImp.getNumeroRea());
			siglaBollino = GenericUtil.isNullOrEmpty(ricercaCodImp.getSiglaBollino());
			dataAcquisizioneDa = GenericUtil.isNullOrEmpty(ricercaCodImp.getDataAcquisizioneDa());
			dataAcquisizioneA = GenericUtil.isNullOrEmpty(ricercaCodImp.getDataAcquisizioneA());

			if(codiceFiscaleEmpty && numeroBollinoEmpty && codiceImpiantoEmpty && siglaReaEmpty && numeroReaEmpty && siglaBollino && dataAcquisizioneDa && dataAcquisizioneA) {
				// Non e' stato impostato nessun paramentro
				throw new ValidationManagerException(new Message(Messages.S010));
			}
			else
			{

				// Se e' stato inserita la sigla REA deve essere compilato anche il
				// numero REA e viceversa
				checkSiglaAndNumeroRea(ricercaCodImp.getIdSiglaRea(), ricercaCodImp.getNumeroRea(), ConstantsField.RICERCA_BOLLINI_ID_SIGLA_REA,
						ConstantsField.RICERCA_BOLLINI_NUMERO_REA);

				checkCodiceFiscalePartitaIva(ricercaCodImp.getCodiceFiscale(), ConstantsField.RICERCA_BOLLINI_CF);
			}
		}
		else {
			// Non e' stato inserito alcun criterio di ricerca
			throw new ValidationManagerException(new Message(Messages.S010));
		}

	}

	public void validazioneFormaleRicercaImpianti(RicercaImpianti ricercaImp) throws ValidationManagerException {

		boolean codiceImpiantoEmpty;
		boolean idProvinciaEmpty;
		boolean idComuneEmpty;
		boolean descComuneEmpty;
		boolean indirizzoEmpty;
		boolean civicoEmpty;
		boolean cfResponsabileEmpty;
		boolean cf3ResponsabileEmpty;
		boolean cfProprietarioEmpty;
		boolean matricolaApparecchiaturaEmpty;
//		boolean idSiglaBollinoEmpty;
//		boolean numeroBollinoEmpty;
		boolean idSiglaReaEmpty;
		boolean numeroReaEmpty;
		boolean cfImpresaEmpty;
		boolean podEmpty;
		boolean pdrEmpty;
		boolean statoImpiantoEmpty;

		if(ricercaImp != null) {

			codiceImpiantoEmpty = GenericUtil.isNullOrEmpty(ricercaImp.getCodiceImpianto());
			idProvinciaEmpty = GenericUtil.isNullOrEmpty(ricercaImp.getIdProvincia());
			idComuneEmpty = GenericUtil.isNullOrEmpty(ricercaImp.getIdComune());
			descComuneEmpty = GenericUtil.isNullOrEmpty(ricercaImp.getDescComune());
			indirizzoEmpty = GenericUtil.isNullOrEmpty(ricercaImp.getIndirizzo());
			civicoEmpty = GenericUtil.isNullOrEmpty(ricercaImp.getCivico());
			cfResponsabileEmpty = GenericUtil.isNullOrEmpty(ricercaImp.getCfResponsabile());
			cfProprietarioEmpty = GenericUtil.isNullOrEmpty(ricercaImp.getCfProprietario());
			cf3ResponsabileEmpty = GenericUtil.isNullOrEmpty(ricercaImp.getCf3Responsabile());
			matricolaApparecchiaturaEmpty = GenericUtil.isNullOrEmpty(ricercaImp.getMatricolaApparecchiatura());
//			idSiglaBollinoEmpty = GenericUtil.isNullOrEmpty(ricercaImp.getIdSiglaBollino());
//			numeroBollinoEmpty = GenericUtil.isNullOrEmpty(ricercaImp.getNumeroBollino());
			idSiglaReaEmpty = GenericUtil.isNullOrEmpty(ricercaImp.getIdSiglaRea());
			numeroReaEmpty = GenericUtil.isNullOrEmpty(ricercaImp.getNumeroRea());
			cfImpresaEmpty = GenericUtil.isNullOrEmpty(ricercaImp.getCfImpresa());

			podEmpty = GenericUtil.isNullOrEmpty(ricercaImp.getPod());
			pdrEmpty = GenericUtil.isNullOrEmpty(ricercaImp.getPdr());
			statoImpiantoEmpty = GenericUtil.isNullOrEmpty(ricercaImp.getIdStatoImp());

			log.debug("STAMPO codiceImpiantoEmpty: "+codiceImpiantoEmpty);
			log.debug("STAMPO idProvinciaEmpty: "+idProvinciaEmpty);
			log.debug("STAMPO idComuneEmpty: "+idComuneEmpty);
			log.debug("STAMPO indirizzoEmpty: "+indirizzoEmpty);
			log.debug("STAMPO cfResponsabileEmpty: "+cfResponsabileEmpty);
			log.debug("STAMPO cf3ResponsabileEmpty: "+cf3ResponsabileEmpty);
			log.debug("STAMPO matricolaApparecchiaturaEmpty: "+matricolaApparecchiaturaEmpty);
			log.debug("STAMPO idSiglaReaEmpty: "+idSiglaReaEmpty);
			log.debug("STAMPO numeroReaEmpty: "+numeroReaEmpty);
			log.debug("STAMPO cfImpresaEmpty: "+cfImpresaEmpty);

			if(codiceImpiantoEmpty && idProvinciaEmpty && idComuneEmpty && descComuneEmpty && indirizzoEmpty &&
					cfResponsabileEmpty && cfProprietarioEmpty && cf3ResponsabileEmpty && matricolaApparecchiaturaEmpty &&
					idSiglaReaEmpty && numeroReaEmpty && cfImpresaEmpty && podEmpty && pdrEmpty && statoImpiantoEmpty) {
				// Non e' stato impostato nessun paramentro
				throw new ValidationManagerException(new Message(Messages.S010));
			}
			else
			{
//				if (statoImpiantoEmpty) {
//					ValidationManagerException ex = new ValidationManagerException();
//					ex.addFieldRequired(ConstantsField.RICERCA_IMPIANTI_ID_STATO_IMP);
//					throw ex;
//				}

				if (idProvinciaEmpty) {
					ValidationManagerException ex = new ValidationManagerException();
					ex.addFieldRequired(ConstantsField.RICERCA_IMPIANTI_ID_PROVINCIA);
					throw ex;
				}

				if (!descComuneEmpty)
				{
					checkAlphanumericStringMinLenght(ricercaImp.getDescComune(), Constants.MIN_DES_COMUNE_LEN, ConstantsField.RICERCA_IMPIANTI_DESC_COMUNE);
				}

				//checkNumeroIntero(ricercaImp.getCodiceImpianto(), ConstantsField.RICERCA_IMPIANTI_COD_IMPIANTO, Constants.MAX_CODICE_IMPIANTO_LEN);
				if (!civicoEmpty && indirizzoEmpty)
				{
					// Se compila il campo civico deve compialre anche l'indirizzo
					ValidationManagerException ex = new ValidationManagerException();
					ex.addFieldRequired(ConstantsField.RICERCA_IMPIANTI_INDIRIZZO);
					throw ex;
				}
				else if (!indirizzoEmpty)
				{
					checkRicercaIndirizzo(ricercaImp.getIdComune(), ricercaImp.getIdProvincia(), ConstantsField.RICERCA_IMPIANTI_ID_COMUNE, ConstantsField.RICERCA_IMPIANTI_ID_PROVINCIA);
					checkAlphanumericStringMinLenght(ricercaImp.getIndirizzo(), Constants.MIN_INDIRIZZO_LEN, ConstantsField.RICERCA_IMPIANTI_INDIRIZZO);
				}

				checkCodiceFiscalePartitaIva(ricercaImp.getCfResponsabile(), ConstantsField.RICERCA_IMPIANTI_CF_RESPONSABILE);

				checkCodiceFiscalePartitaIva(ricercaImp.getCf3Responsabile(), ConstantsField.RICERCA_IMPIANTI_CF_3RESPONSABILE);

				//checkAlphanumericStringMinLenght(ricercaImp.getMatricolaApparecchiatura(), Constants.MIN_MATRICOLA_LEN, ConstantsField.RICERCA_IMPIANTI_MATRICOLA_APP);

//				checkSiglaAndNumeroBollino(ricercaImp.getIdSiglaBollino(), ricercaImp.getNumeroBollino(), ConstantsField.RICERCA_IMPIANTI_ID_SIGLA_BOLLINO,
//						ConstantsField.RICERCA_IMPIANTI_NUMERO_BOLLINO);

				// Se e' stato inserita la sigla REA deve essere compilato anche il
				// numero REA e viceversa
				checkSiglaAndNumeroRea(ricercaImp.getIdSiglaRea(), ricercaImp.getNumeroRea(), ConstantsField.RICERCA_IMPIANTI_ID_SIGLA_REA,
						ConstantsField.RICERCA_IMPIANTI_NUMERO_REA);

				checkCodiceFiscalePartitaIva(ricercaImp.getCfImpresa(), ConstantsField.RICERCA_IMPIANTI_CF_IMPRESA);

			}
		}
		else {
			// Non e' stato inserito alcun criterio di ricerca
			throw new ValidationManagerException(new Message(Messages.S010));
		}

	}

	public void validazioneFormaleRicercaCompletaImpianti(RicercaImpianti ricercaImp) throws ValidationManagerException {

		boolean codiceImpiantoEmpty;
		boolean idProvinciaEmpty;
		boolean idComuneEmpty;
		boolean descComuneEmpty;
		boolean indirizzoEmpty;
		boolean civicoEmpty;
		boolean cfResponsabileEmpty;
		boolean cf3ResponsabileEmpty;
		boolean cfProprietarioEmpty;
		boolean podEmpty;
		boolean pdrEmpty;

		if(ricercaImp != null) {


			codiceImpiantoEmpty = GenericUtil.isNullOrEmpty(ricercaImp.getCodiceImpianto());
			idProvinciaEmpty = GenericUtil.isNullOrEmpty(ricercaImp.getIdProvincia());
			idComuneEmpty = GenericUtil.isNullOrEmpty(ricercaImp.getIdComune());
			descComuneEmpty = GenericUtil.isNullOrEmpty(ricercaImp.getDescComune());
			indirizzoEmpty = GenericUtil.isNullOrEmpty(ricercaImp.getIndirizzo());
			civicoEmpty = GenericUtil.isNullOrEmpty(ricercaImp.getCivico());
			cfResponsabileEmpty = GenericUtil.isNullOrEmpty(ricercaImp.getCfResponsabile());
			cfProprietarioEmpty = GenericUtil.isNullOrEmpty(ricercaImp.getCfProprietario());
			cf3ResponsabileEmpty = GenericUtil.isNullOrEmpty(ricercaImp.getCf3Responsabile());
			podEmpty = GenericUtil.isNullOrEmpty(ricercaImp.getPod());
			pdrEmpty = GenericUtil.isNullOrEmpty(ricercaImp.getPdr());


			log.debug("STAMPO codiceImpiantoEmpty: "+codiceImpiantoEmpty);
			log.debug("STAMPO idProvinciaEmpty: "+idProvinciaEmpty);
			log.debug("STAMPO idComuneEmpty: "+idComuneEmpty);
			log.debug("STAMPO descComuneEmpty: "+descComuneEmpty);
			log.debug("STAMPO indirizzoEmpty: "+indirizzoEmpty);
			log.debug("STAMPO civicoEmpty: "+civicoEmpty);
			log.debug("STAMPO cfProprietarioEmpty: "+cfProprietarioEmpty);
			log.debug("STAMPO cfResponsabileEmpty: "+cfResponsabileEmpty);
			log.debug("STAMPO cf3ResponsabileEmpty: "+cf3ResponsabileEmpty);
			log.debug("STAMPO podEmpty: "+podEmpty);
			log.debug("STAMPO pdrEmpty: "+pdrEmpty);


			if(codiceImpiantoEmpty && idProvinciaEmpty && idComuneEmpty && indirizzoEmpty &&
					cfResponsabileEmpty && cf3ResponsabileEmpty && cfProprietarioEmpty) {
				// Non e' stato impostato nessun paramentro
				throw new ValidationManagerException(new Message(Messages.S010));
			}
			else
			{
				if (!descComuneEmpty)
				{
					checkAlphanumericStringMinLenght(ricercaImp.getDescComune(), Constants.MIN_DES_COMUNE_LEN, ConstantsField.RICERCA_IMPIANTI_DESC_COMUNE);
				}

				//checkNumeroIntero(ricercaImp.getCodiceImpianto(), ConstantsField.RICERCA_IMPIANTI_COD_IMPIANTO, Constants.MAX_CODICE_IMPIANTO_LEN);

				if (!civicoEmpty && indirizzoEmpty)
				{
					// Se compila il campo civico deve compialre anche l'indirizzo
					ValidationManagerException ex = new ValidationManagerException();
					ex.addFieldRequired(ConstantsField.RICERCA_IMPIANTI_INDIRIZZO);
					throw ex;
				}
				else if (!indirizzoEmpty)
				{
					checkRicercaIndirizzo(ricercaImp.getIdComune(), ricercaImp.getIdProvincia(), ConstantsField.RICERCA_IMPIANTI_ID_COMUNE, ConstantsField.RICERCA_IMPIANTI_ID_PROVINCIA);
					checkAlphanumericStringMinLenght(ricercaImp.getIndirizzo(), Constants.MIN_INDIRIZZO_LEN, ConstantsField.RICERCA_IMPIANTI_INDIRIZZO);
				}


				checkCodiceFiscalePartitaIva(ricercaImp.getCfResponsabile(), ConstantsField.RICERCA_IMPIANTI_CF_RESPONSABILE);

				checkCodiceFiscalePartitaIva(ricercaImp.getCf3Responsabile(), ConstantsField.RICERCA_IMPIANTI_CF_3RESPONSABILE);

				//checkAlphanumericStringMinLenght(ricercaImp.getMatricolaApparecchiatura(), Constants.MIN_MATRICOLA_LEN, ConstantsField.RICERCA_IMPIANTI_MATRICOLA_APP);

//				checkSiglaAndNumeroBollino(ricercaImp.getIdSiglaBollino(), ricercaImp.getNumeroBollino(), ConstantsField.RICERCA_IMPIANTI_ID_SIGLA_BOLLINO,
//						ConstantsField.RICERCA_IMPIANTI_NUMERO_BOLLINO);

			}
		}
		else {
			// Non e' stato inserito alcun criterio di ricerca
			throw new ValidationManagerException(new Message(Messages.S010));
		}

	}

	public void validazioneFormaleSalvaImpianto(Impianto impianto, boolean isImpiantoResp, String ruoloUtente) throws ValidationManagerException {
		validazioneFormaleSalvaImpianto(impianto, isImpiantoResp, ruoloUtente, null);
	}

	public void validazioneFormaleSalvaImpianto(Impianto impianto, boolean isImpiantoResp, String ruoloUtente, Integer idPgRuoloUtente) throws ValidationManagerException {

		// Non verifico l'installatore, perche' se sono in questo punto l'ho gia' cercato!

//		boolean idStatoImpEmpty = GenericUtil.isNullOrEmpty(impianto.getImpIdStatoImp());
//		boolean indirizzoEmpty = GenericUtil.isNullOrEmpty(impianto.getImpLocIdIndirizzo()) && GenericUtil.isNullOrEmpty(impianto.getImpLocIndirizzoNoStrad());

		ValidationManagerException ex = null;

		//Message message = new Message(Messages.ERROR_CAMPO_ABBIGATORIO);
		//message.replacePlaceholder("");
		ex = new ValidationManagerException();

		if (GenericUtil.isNullOrEmpty(impianto.getImpIdStatoImp())) {
			ex.addFieldRequired(ConstantsField.GESTISCI_IMPIANTO_ID_STATO_IMP);
		}
		else
		{
			try
			{
				checkAlphanumericStringMaxLenght(impianto.getImpIdStatoImp(), 20, ConstantsField.GESTISCI_IMPIANTO_ID_STATO_IMP);
			}
			catch(ValidationManagerException e){
				ex.addField(ConstantsField.GESTISCI_IMPIANTO_ID_STATO_IMP, Messages.ERROR_FIELD_FORMAL_ERROR);
			}
		}

		if (!(ruoloUtente.equalsIgnoreCase(Constants.RUOLO_ISPETTORE) ||
				ruoloUtente.equalsIgnoreCase(Constants.RUOLO_SUPER)  ||
				ruoloUtente.equalsIgnoreCase(Constants.RUOLO_VALIDATORE))) {

			if (GenericUtil.isNullOrEmpty(impianto.getImpTipoImpianto())) {
				ex.addFieldRequired(ConstantsField.GESTISCI_IMPIANTO_TIPO_IMPIANTO);
			}

			log.debug("impianto.getImpFlgAppareccUiExt(): "+impianto.getImpFlgAppareccUiExt());
			if (GenericUtil.isNullOrEmpty(impianto.getImpFlgAppareccUiExt())) {
				ex.addFieldRequired(ConstantsField.GESTISCI_IMPIANTO_FLG_APPARECC_UI_EXT);
			}
		}
		
		if(GenericUtil.isNullOrEmpty(impianto.getImpFlgMedioCivile()))
		{
			ex.addFieldRequired(ConstantsField.GESTISCI_IMPIANTO_FLG_MEDIO_IMPIANTO_CIVILE);
		}

		if (GenericUtil.isNotNullOrEmpty(impianto.getImpTipoImpianto()) &&
				impianto.getImpTipoImpianto().equalsIgnoreCase(Constants.COD_TIPO_IMPIANTO_CENTRALIZZATO) &&
				GenericUtil.isNullOrEmpty(impianto.getImpFlgContabilizzatore())) {
			ex.addFieldRequired(ConstantsField.GESTISCI_IMPIANTO_FLG_CONTABILIZZATORE);
		}

		if (GenericUtil.isNullOrEmpty(impianto.getImpLocIdProvincia())) {
			ex.addFieldRequired(ConstantsField.GESTISCI_IMPIANTO_LOC_ID_PROVINCIA);
		}

		if (GenericUtil.isNullOrEmpty(impianto.getImpLocIdComune())) {
			ex.addFieldRequired(ConstantsField.GESTISCI_IMPIANTO_LOC_ID_COMUNE);
		}

		if (GenericUtil.isNullOrEmpty(impianto.getImpLocIdIndirizzo()) && GenericUtil.isNullOrEmpty(impianto.getImpLocIndirizzoNoStrad())) {
			ex.addFieldRequired(ConstantsField.GESTISCI_IMPIANTO_LOC_INDIRIZZO);
			ex.addFieldRequired(ConstantsField.GESTISCI_IMPIANTO_LOC_ID_INDIRIZZO);
			ex.addFieldRequired(ConstantsField.GESTISCI_IMPIANTO_LOC_INDIRIZZO_NON_TROVATO);
		}

		if (GenericUtil.isNullOrEmpty(impianto.getImpLocCivico())) {
			ex.addFieldRequired(ConstantsField.GESTISCI_IMPIANTO_LOC_CIVICO);
		}
//		else
//		{
//			try
//			{
//				checkAlphanumericStringMaxLenght(impianto.getImpLocCivico(), 20, ConstantsField.GESTISCI_IMPIANTO_LOC_CIVICO);
//			}
//			catch(ValidationManagerException e){
//				ex.addField(ConstantsField.GESTISCI_IMPIANTO_LOC_CIVICO, Messages.ERROR_FIELD_FORMAL_ERROR);
//			}
//		}

		/*
		if (GenericUtil.isNullOrEmpty(impianto.getImpLocFoglio())) {
			ex.addFieldRequired(ConstantsField.GESTISCI_IMPIANTO_LOC_FOGLIO);
		}
		else
		{
			try
			{
				checkAlphanumericStringMaxLenght(impianto.getImpLocFoglio(), 20, ConstantsField.GESTISCI_IMPIANTO_LOC_FOGLIO);
			}
			catch(ValidationManagerException e){
				ex.addField(ConstantsField.GESTISCI_IMPIANTO_LOC_FOGLIO, Messages.ERROR_FIELD_FORMAL_ERROR);
			}
		}

		if (GenericUtil.isNullOrEmpty(impianto.getImpLocParticella())) {
			ex.addFieldRequired(ConstantsField.GESTISCI_IMPIANTO_LOC_PARTICELLA);
		}
		else
		{
			try
			{
				checkAlphanumericStringMaxLenght(impianto.getImpLocParticella(), 20, ConstantsField.GESTISCI_IMPIANTO_LOC_PARTICELLA);
			}
			catch(ValidationManagerException e){
				ex.addField(ConstantsField.GESTISCI_IMPIANTO_LOC_PARTICELLA, Messages.ERROR_FIELD_FORMAL_ERROR);
			}
		}
		*/

		if (GenericUtil.isNotNullOrEmpty(impianto.getImpLocFoglio())) {
			try
			{
				checkAlphanumericStringMaxLenght(impianto.getImpLocFoglio(), 20, ConstantsField.GESTISCI_IMPIANTO_LOC_FOGLIO);
			}
			catch(ValidationManagerException e){
				ex.addField(ConstantsField.GESTISCI_IMPIANTO_LOC_FOGLIO, Messages.ERROR_FIELD_FORMAL_ERROR);
			}
		}

		if (GenericUtil.isNotNullOrEmpty(impianto.getImpLocParticella())) {
			try
			{
				checkAlphanumericStringMaxLenght(impianto.getImpLocParticella(), 20, ConstantsField.GESTISCI_IMPIANTO_LOC_PARTICELLA);
			}
			catch(ValidationManagerException e){
				ex.addField(ConstantsField.GESTISCI_IMPIANTO_LOC_PARTICELLA, Messages.ERROR_FIELD_FORMAL_ERROR);
			}
		}

		if (!(ruoloUtente.equalsIgnoreCase(Constants.RUOLO_ISPETTORE) ||
				ruoloUtente.equalsIgnoreCase(Constants.RUOLO_SUPER)  ||
				ruoloUtente.equalsIgnoreCase(Constants.RUOLO_VALIDATORE)) &&
				GenericUtil.isNullOrEmpty(impianto.getImpLocPod())) {
				ex.addFieldRequired(ConstantsField.GESTISCI_IMPIANTO_LOC_POD);
		}

		if (GenericUtil.isNotNullOrEmpty(impianto.getImpLocPod()))
		{
			try
			{
				log.debug("PRIMA DI checkPOD: "+impianto.getImpLocPod());
				impianto.setImpLocPod(checkPOD(impianto.getImpLocPod(), ConstantsField.GESTISCI_IMPIANTO_LOC_POD));
				log.debug("DOPO DI checkPOD");
			}
			catch(ValidationManagerException e){
				ex.addField(ConstantsField.GESTISCI_IMPIANTO_LOC_POD, Messages.ERROR_FIELD_FORMAL_ERROR);
			}
		}

		if (GenericUtil.isNotNullOrEmpty(impianto.getImpLocPdr()))
		{
			try
			{
				log.debug("PRIMA DI checkPDR: "+impianto.getImpLocPdr());
				checkPDR(impianto.getImpLocPdr(), ConstantsField.GESTISCI_IMPIANTO_LOC_PDR);
				log.debug("DOPO DI checkPDR");
			}
			catch(ValidationManagerException e){
				ex.addField(ConstantsField.GESTISCI_IMPIANTO_LOC_PDR, Messages.ERROR_FIELD_FORMAL_ERROR);

			}
		}


		try
		{
			checkAlphanumericStringMaxLenght(impianto.getImpLocScala(), 20, ConstantsField.GESTISCI_IMPIANTO_LOC_SCALA);
		}
		catch(ValidationManagerException e){
			ex.addField(ConstantsField.GESTISCI_IMPIANTO_LOC_SCALA, Messages.ERROR_FIELD_FORMAL_ERROR);
		}

		try
		{
			checkAlphanumericStringMaxLenght(impianto.getImpLocPalazzo(), 20, ConstantsField.GESTISCI_IMPIANTO_LOC_PALAZZO);
		}
		catch(ValidationManagerException e){
			ex.addField(ConstantsField.GESTISCI_IMPIANTO_LOC_PALAZZO, Messages.ERROR_FIELD_FORMAL_ERROR);
		}

		try
		{
			checkAlphanumericStringMaxLenght(impianto.getImpLocSezione(), 20, ConstantsField.GESTISCI_IMPIANTO_LOC_SEZIONE);
		}
		catch(ValidationManagerException e){
			ex.addField(ConstantsField.GESTISCI_IMPIANTO_LOC_SEZIONE, Messages.ERROR_FIELD_FORMAL_ERROR);
		}

		if (GenericUtil.isNullOrEmpty(impianto.getImpDataDismissione())) {
			ex.addField(ConstantsField.GESTISCI_IMPIANTO_DATA_DISM);
		}

		if (GenericUtil.isNullOrEmpty(impianto.getImpMotivazione())) {
			ex.addField(ConstantsField.GESTISCI_IMPIANTO_MOTIVAZIONE);
		}

		checkStringMaxLenght(impianto.getImpMotivazione(), Constants.MAX_MOTIVAZIONE_IMPIANTO_LEN, ConstantsField.GESTISCI_IMPIANTO_MOTIVAZIONE);

		log.debug("STAMPO LE NOTE: "+impianto.getImpLocNote());
		/*
		if (GenericUtil.isNotNullOrEmpty(impianto.getImpLocNote())) {
			try
			{
				checkAlphanumericStringMaxLenght(impianto.getImpLocNote(), 1000, ConstantsField.GESTISCI_IMPIANTO_LOC_NOTE);
			}
			catch(ValidationManagerException e){

				log.debug("SONO NEll'ECCEZIONE DELLE NOTE");

				ex.addField(ConstantsField.GESTISCI_IMPIANTO_LOC_NOTE, Messages.ERROR_FIELD_FORMAL_ERROR);
			}
		}
		*/

		if (ex.getFieldList().size() > 0)
		{
				//ex.setMsg(message);
				throw ex;
		}

		/*
		try
		{

			// Sono in inserimento
			String dataCessazioneInst = getDbMgr().cercaPersonaGiuridicaById(impianto.getInstId()).getDataCessazione();

			if (GenericUtil.isNotNullOrEmpty(dataCessazioneInst))
			{

				// Verifico che la data assegnazione impianto sia precedente alla data dismissione installatore
				checkDateOrderMesDataSucc(impianto.getImpDataAssegnazione(), dataCessazioneInst, true,
						ConstantsField.GESTISCI_IMPIANTO_DATA_ASS, ConstantsField.GESTISCI_IMPIANTO_DATA_ASS, new Message(Messages.ERROR_INSTALLATORE_CESSATO));


			}
		}
		catch(DbManagerException e) {
			throw new ValidationManagerException(e, e.getMsg());
		}
		*/

		/*
		if (!ConvertUtil.convertToBooleanAllways(impianto.getImpLocEdifNonAcc()))
		{
			if (GenericUtil.isNullOrEmpty(impianto.getImpLocParticella())) {
				ex.addFieldRequired(ConstantsField.GESTISCI_IMPIANTO_LOC_PARTICELLA);
			}

			if (GenericUtil.isNullOrEmpty(impianto.getImpLocFoglio())) {
				ex.addFieldRequired(ConstantsField.GESTISCI_IMPIANTO_LOC_FOGLIO);
			}

			if (ex.getFieldList() != null && ex.getFieldList().size() > 0)
			{
				ex.addFieldRequired(ConstantsField.GESTISCI_IMPIANTO_LOC_EDIF_NON_ACCATASTATO);
				throw ex;
			}
		}
		*/
		if (!(ruoloUtente.equalsIgnoreCase(Constants.RUOLO_ISPETTORE) ||
				ruoloUtente.equalsIgnoreCase(Constants.RUOLO_SUPER)  ||
				ruoloUtente.equalsIgnoreCase(Constants.RUOLO_VALIDATORE)) &&
				GenericUtil.isNullOrEmpty(impianto.getImpLocPdr()) &&
				!ConvertUtil.convertToBooleanAllways(impianto.getImpLocPdrNonPres())) {
				ex = new ValidationManagerException(new Message(Messages.ERROR_PDR_OBBLIGATORIO));
				ex.addField(ConstantsField.GESTISCI_IMPIANTO_LOC_PDR);
				ex.addField(ConstantsField.GESTISCI_IMPIANTO_LOC_PDR_NON_PRES);
				throw ex;
		}

		if (GenericUtil.isNotNullOrEmpty(impianto.getImpLocCap()))
		{
			checkCAP(impianto.getImpLocCap(), ConstantsField.GESTISCI_IMPIANTO_LOC_CAP);
		}

		if (GenericUtil.isNotNullOrEmpty(impianto.getImpLocNote())) {
			checkStringMaxLenght(impianto.getImpLocNote(), 1000, ConstantsField.GESTISCI_IMPIANTO_LOC_NOTE);
		}

		//verificaCodiceImpiantoIdentificazione(impianto);
		/*
		if (GenericUtil.isNotNullOrEmpty(impianto.getImpDataDismissione()))
		{
			checkDate(impianto.getImpDataDismissione(), ConstantsField.GESTISCI_IMPIANTO_DATA_DISM);

			if (!DateUtil.checkDateOrder(impianto.getImpDataAssegnazione(), impianto.getImpDataDismissione(), true))
			{
				throw new ValidationManagerException(new Message(Messages.S025));
			}
		}
		*/

		checkDate(impianto.getImpDataDismissione(), ConstantsField.GESTISCI_IMPIANTO_DATA_DISM);

		if (impianto.getImpId() != null)
		{
			// SONO IN MODIFICA - DA FARE (26/02/2016 - per ora decidiamo di non implementarlo perche' lo stato dell'impianto puo' variare continuamente, per gestione ispezioni/accertamenti)
//			Se siamo in modifica dell'impianto (Caso B) verificare che la data di dismissione impianto indicata risulti successiva o uguale a tutte le date di installazione delle componenti dell'impianto (SIGIT_T_COMP4.data_install, SIGIT_T_COMP5..)
//			Se siamo in modifica dell'impianto (Caso B) verificare che la data di dismissione impianto indicata risulti successiva o uguale a tutte le date di dismissione delle componenti dell'impianto (SIGIT_T_COMP4.data_dismiss, SIGIT_T_COMP5..)

		}

		/*
		if (!isImpiantoResp)
		{
			PersonaGiuridica personaG = null;
			try {
				personaG = getDbMgr().cercaPersonaGiuridicaById(impianto.getInstId());
			} catch (DbManagerException e) {
				throw new ValidationManagerException(e, e.getMsg());
			}

			if (personaG != null)
			{
				// Se l'installatore ha data cessazione valorizzata, non puo' essere precendente alla data installazione
				if (!DateUtil.checkDateOrderIsPresents(impianto.getImpDataAssegnazione(), personaG.getDataCessazione(), true))
				{
					Message mess = new Message(Messages.S026);
					mess.replacePlaceholder(personaG.getDataCessazione());
					throw new ValidationManagerException(mess);
				}

				if (impianto.getImpId() == null)
				{
					// Se l'installatore ha data cessazione valorizzata, non puo'essere precendente alla data dismissione
					if (!DateUtil.checkDateOrderIsPresents(impianto.getImpDataDismissione(), personaG.getDataCessazione(), true))
					{
						Message mess = new Message(Messages.S026);
						mess.replacePlaceholder(personaG.getDataCessazione());
						throw new ValidationManagerException(mess);
					}
				}
				else
				{
					if (!(ruoloUtente.equalsIgnoreCase(Constants.RUOLO_ISPETTORE) ||
									ruoloUtente.equalsIgnoreCase(Constants.RUOLO_SUPER)  ||
									ruoloUtente.equalsIgnoreCase(Constants.RUOLO_VALIDATORE))) {

						PersonaGiuridica personaGRuoloUtente = null;
						try {
							personaGRuoloUtente = getDbMgr().cercaPersonaGiuridicaById(idPgRuoloUtente);
						} catch (DbManagerException e) {
							throw new ValidationManagerException(e, e.getMsg());
						}

						// Verifico che l'eventuale data dismissione dell'utente LOGGATO sia successiva alla data dismissione impianto
						if (!DateUtil.checkDateOrderIsPresents(impianto.getImpDataDismissione(), personaGRuoloUtente.getDataCessazione(), true))
						{
							Message mess = new Message(Messages.S026);
							mess.replacePlaceholder(personaGRuoloUtente.getDataCessazione());
							throw new ValidationManagerException(mess);
						}
					}
				}
			}
		}
			*/

		//checkAlphanumericStringMaxLenght(impianto.getImpMotivazione(), Constants.MAX_MOTIVAZIONE_IMPIANTO_LEN, ConstantsField.GESTISCI_IMPIANTO_MOTIVAZIONE);


	}

	public void validazioneModificaImpresa(PersonaGiuridica pg) throws ValidationManagerException
	{
		ValidationManagerException ex = new ValidationManagerException();

		boolean isSoloAmministratore = false;
		if(pg.getFlgAmministratore() && !pg.getFlgDm37LetteraC() && !pg.getFlgTerzoResponsabile() && !pg.getFlgDistributore() && !pg.getFlgCat())
		{
			isSoloAmministratore = true;
		}

//		if(!pg.getFlgAmministratore() && !pg.getFlgSoggIncaricato()) {
//			ex.addField(ConstantsField.GESTISCI_IMPRESALAG_AMMINISTRATORE, Messages.ERROR_SELEZIONE_ADMIN_SOGG_INCARICATO);
//			ex.addField(ConstantsField.GESTISCI_IMPRESALAG_SOGG_INCARICATO, Messages.ERROR_SELEZIONE_ADMIN_SOGG_INCARICATO);
//		}

		if(pg.getFlgSoggIncaricato() && GenericUtil.isNullOrEmpty(pg.getDelegaSoggIncaricato())) {
			ex.addField(ConstantsField.GESTISCI_IMPRESALAG_DELEGA_SOGG_INCARICATO, Messages.ERROR_SELEZIONE_SOGG_INCARICATO);
		}

//		if (GenericUtil.isNullOrEmpty(pg.getSiglaRea())) {
//			ex.addFieldRequired(ConstantsField.GESTISCI_IMPRESA_SIGLA_REA);
//		}
//
//		if (GenericUtil.isNullOrEmpty(pg.getNumeroRea())) {
//			ex.addFieldRequired(ConstantsField.GESTISCI_IMPRESA_NUMERO_REA);
//		}

		if (GenericUtil.isNullOrEmpty(pg.getDenominazione())) {
			ex.addFieldRequired(ConstantsField.GESTISCI_IMPRESA_DENOMINAZIONE);
		}

		if (GenericUtil.isNullOrEmpty(pg.getCodiceFiscale())) {
			ex.addFieldRequired(ConstantsField.GESTISCI_IMPRESA_CODICE_FISCALE);
		}
//		else if(!(pg.getCodiceFiscale().length()==11 || pg.getCodiceFiscale().length()==16))
//		{
//			ex.addField(ConstantsField.GESTISCI_IMPRESA_CODICE_FISCALE, Messages.ERROR_LUNGHEZZA_CODICE_FISCALE);
//		}

		if (!isSoloAmministratore)
		{
			if (GenericUtil.isNullOrEmpty(pg.getDataInizioAttivita())) {
				ex.addFieldRequired(ConstantsField.GESTISCI_IMPRESA_DATA_INIZIO_ATTIVITA);
			}
		}

		if (GenericUtil.isNotNullOrEmpty(pg.getIdStatoPg())
				&& pg.getIdStatoPg().intValue() != pg.getIdStatoPgOld().intValue())
		{
			// E' cambiato lo stato quindi e' obbligatorio impostare la Data variazione e il motivo

			if (GenericUtil.isNullOrEmpty(pg.getDataVariazione())) {
				ex.addFieldRequired(ConstantsField.GESTISCI_IMPRESA_DATA_VARIAZIONE);
			}

			if (GenericUtil.isNullOrEmpty(pg.getMotivoVariazione())) {
				ex.addFieldRequired(ConstantsField.GESTISCI_IMPRESA_MOTIVO_VARIAZIONE);
			}

			checkStringMaxLenght(pg.getMotivoVariazione(), 500, ConstantsField.GESTISCI_IMPRESA_MOTIVO_VARIAZIONE);
		}

		if (pg.getFlgIndirizzoEst())
		{
			if (GenericUtil.isNullOrEmpty(pg.getEstStato())) {
				ex.addFieldRequired(ConstantsField.GESTISCI_IMPRESA_EST_STATO);
			}

			if (GenericUtil.isNullOrEmpty(pg.getEstCitta())) {
				ex.addFieldRequired(ConstantsField.GESTISCI_IMPRESA_EST_CITTA);
			}

			if (GenericUtil.isNullOrEmpty(pg.getEstIndirizzo())) {
				ex.addFieldRequired(ConstantsField.GESTISCI_IMPRESA_EST_INDIRIZZO);
			}
		}
		else
		{
			if (GenericUtil.isNullOrEmpty(pg.getIdProvinciaSelez())) {
				ex.addFieldRequired(ConstantsField.GESTISCI_IMPRESA_ID_PROVINCIA);

			}

			if (GenericUtil.isNullOrEmpty(pg.getIdComuneSelez())) {
				ex.addFieldRequired(ConstantsField.GESTISCI_IMPRESA_ID_COMUNE);

			}

			if (GenericUtil.isNullOrEmpty(pg.getIdIndirizzoSel()) && GenericUtil.isNullOrEmpty(pg.getIndirizzoNonTrovato())) {
				ex.addFieldRequired(ConstantsField.GESTISCI_IMPRESA_INDIRIZZO);
				ex.addFieldRequired(ConstantsField.GESTISCI_IMPRESA_ID_IND_SELEZ);
				ex.addFieldRequired(ConstantsField.GESTISCI_IMPRESA_IND_NON_TROVATO);
			}

		}


//		else
//		{
//			try
//			{
//				//checkFormatoData(pg.getDataInizioAttivita());
//				try {
//					if(DateUtil.getDate(pg.getDataInizioAttivita()).after(new Date()))
//					{
//						ex.addField(ConstantsField.GESTISCI_IMPRESA_DATA_INIZIO_ATTIVITA, Messages.ERROR_DATA_FUTURA);
//					}
//				} catch (ParseException e) {//non dovrebbe verificarsi, la data e' stata controllata sopra
//				}
//			} catch (ValidationManagerException e) {
//				ex.addField(ConstantsField.GESTISCI_IMPRESA_DATA_INIZIO_ATTIVITA, Messages.ERROR_FORMATO_DATA_ERRATO);
//			}
//		}
//
//		if (GenericUtil.isNonNullOrEmpty(pg.getDataCessazione())) {
//			try
//			{
//				//checkFormatoData(pg.getDataCessazione());
//				//check con data inizio attivita'
//				if(GenericUtil.isNonNullOrEmpty(pg.getDataInizioAttivita()) &&
//						DateUtil.getDate(pg.getDataCessazione()).before(DateUtil.getDate(pg.getDataInizioAttivita())))
//				{
//					ex.addField(ConstantsField.GESTISCI_IMPRESA_DATA_CESSAZIONE, Messages.ERROR_DATA_CESSAZIONE);
//				}
//				else
//					try {
//							if(DateUtil.getDate(pg.getDataCessazione()).after(new Date()))
//							{
//								ex.addField(ConstantsField.GESTISCI_IMPRESA_DATA_CESSAZIONE, Messages.ERROR_DATA_FUTURA);
//							}
//						} catch (ParseException e) {//non dovrebbe verificarsi, la data e' stata controllata sopra
//					}
//			} catch (ValidationManagerException e) {
//				ex.addField(ConstantsField.GESTISCI_IMPRESA_DATA_CESSAZIONE, Messages.ERROR_FORMATO_DATA_ERRATO);
//			} catch (ParseException e) {//ingorato perche' viene lanciato da DateUtil che viene chiamato quando la data e' stata gia' validata
//			}
//		}


		if (!isSoloAmministratore)
		{

			if (GenericUtil.isNullOrEmpty(pg.getEmail())) {
				ex.addFieldRequired(ConstantsField.GESTISCI_IMPRESA_EMAIL);
			}
		}

		if(GenericUtil.isNotNullOrEmpty(pg.getEmail()) && !GenericUtil.checkValideEmail(pg.getEmail()))
		{
			ex.addField(ConstantsField.GESTISCI_IMPRESA_EMAIL,Messages.ERROR_EMAIL_FORMAT);
		}

		if (GenericUtil.isNotNullOrEmpty(pg.getPec()) && !GenericUtil.checkValideEmail(pg.getPec())) {
			ex.addField(ConstantsField.GESTISCI_IMPRESA_PEC,Messages.ERROR_EMAIL_FORMAT);
		}

		if (GenericUtil.isNotNullOrEmpty(pg.getTelefono()) && !GenericUtil.checkValideNumberTrim(pg.getTelefono())) {
			ex.addField(ConstantsField.GESTISCI_IMPRESA_PEC,Messages.ERROR_NUMERO_NON_CORRETTO);
		}

//		if(pg.getCodiceFiscale()!=null && pg.getCodiceFiscale().length()==16)
//		{
//			if(!GenericUtil.checkValidCF(pg.getCodiceFiscale()))
//			{
//				ex.addField(ConstantsField.GESTISCI_IMPRESA_CODICE_FISCALE, Messages.ERROR_CODICE_FISCALE_FORMAT);
//			}
//		}

//		if(GenericUtil.isNullOrEmpty(pg.getIdRuoloAccred()))
//		{
//			ex.addFieldRequired(ConstantsField.GESTISCI_IMPRESA_ID_RUOLO_ACC);
//		}

//		if ((pg.getFlgAmministratore() || pg.getFlgManutentore() || pg.getFlgInstallatore() || pg.getFlgTerzoResponsabile()) && GenericUtil.isNullOrEmpty(pg.getIdTipoDm()))
//		{
//			ex.addFieldRequired(ConstantsField.GESTISCI_IMPRESA_TIPO_DM);
//		}


//		if(!pg.getFlgAmministratore() && !pg.getFlgManutentore() && !pg.getFlgInstallatore() && !pg.getFlg3Responsabile() && pg.getFlgDistributore())
//		{
//			// Non devo fare niente, ha selezionato solo flgDistributore
//		}
//		else if(GenericUtil.isNullOrEmpty(pg.getTipoDm()))
//		{
//			ex.addFieldRequired(ConstantsField.GESTISCI_IMPRESA_TIPO_DM);
//		}

//		if(!pg.getFlgAmministratore() && !pg.getFlgManutentore() && !pg.getFlgInstallatore() && !pg.getFlgTerzoResponsabile() && !pg.getFlgDistributore() && !pg.getFlgCat())
//		{
//			ex.addField(ConstantsField.GESTISCI_IMPRESALAG_AMMINISTRATORE, Messages.ERROR_FLAG_MAN_INS_AMM);
//			ex.addField(ConstantsField.GESTISCI_IMPRESALAG_MANUTENTORE, Messages.ERROR_FLAG_MAN_INS_AMM);
//			ex.addField(ConstantsField.GESTISCI_IMPRESALAG_INSTALLATORE, Messages.ERROR_FLAG_MAN_INS_AMM);
//			ex.addField(ConstantsField.GESTISCI_IMPRESALAG_3RESPONSABILE, Messages.ERROR_FLAG_MAN_INS_AMM);
//			ex.addField(ConstantsField.GESTISCI_IMPRESALAG_DISTRIBUTORE, Messages.ERROR_FLAG_MAN_INS_AMM);
//			ex.addField(ConstantsField.GESTISCI_IMPRESALAG_CAT, Messages.ERROR_FLAG_MAN_INS_AMM);
//		}

		if (ex.getFieldList().size() > 0)
		{
				//ex.setMsg(message);
				throw ex;
		}

		checkCodiceFiscalePartitaIva(pg.getCodiceFiscale(), ConstantsField.GESTISCI_IMPRESA_CODICE_FISCALE);

		//checkDate(pg.getDataInizioAttivita(), ConstantsField.GESTISCI_IMPRESA_DATA_INIZIO_ATTIVITA);

		// Recupero lo storico variazioni
		List<SigitTStoricoVarStatoPgDto> storVarStatoPgList = null;

		if (GenericUtil.isNotNullOrEmpty(pg.getDataInizioAttivita()))
		{
			isDataFutura(pg.getDataInizioAttivita(), ConstantsField.GESTISCI_IMPRESA_DATA_INIZIO_ATTIVITA);

			try
			{
				storVarStatoPgList = getDbMgr().cercaUltimoStoricoVarStatoPg(pg.getIdPersonaGiuridica());
			} catch (DbManagerException e) {
				throw new ValidationManagerException(e, e.getMsg());
			}

			if (storVarStatoPgList != null && storVarStatoPgList.size() > 0)
			{
				log.debug("## CONTROLLO IL PROBLEMA");
				// Devo verificare che la data inizio attivita' sia precedente a tutte le date variazioni presenti sul DB
				if (!DateUtil.checkDateOrder(pg.getDataInizioAttivita(), ConvertUtil.convertToString(storVarStatoPgList.get(storVarStatoPgList.size()-1).getDtInizioVariazione()), true))
				{
					throw new ValidationManagerException(new Message(Messages.S139));
				}
			}
		}

		//checkDate(pg.getDataCessazione(), ConstantsField.GESTISCI_IMPRESA_DATA_CESSAZIONE);

		if (GenericUtil.isNotNullOrEmpty(pg.getDataVariazione()))
		{
			if (GenericUtil.isNullOrEmpty(pg.getDataInizioAttivita())) {
				throw new ValidationManagerException(new Message(Messages.S138));
			}


			isDataFutura(pg.getDataVariazione(), ConstantsField.GESTISCI_IMPRESA_DATA_VARIAZIONE);


			if (!DateUtil.checkDateOrder(pg.getDataInizioAttivita(), pg.getDataVariazione(), true))
			{
				throw new ValidationManagerException(new Message(Messages.S138));
			}

			if (storVarStatoPgList != null && storVarStatoPgList.size() > 0)
			{
				// Devo verificare che la data variazione sia successiva a tutte le date variazioni presenti sul DB
				if (!DateUtil.checkDateOrder(ConvertUtil.convertToString(storVarStatoPgList.get(0).getDtInizioVariazione()), pg.getDataVariazione(), true))
				{
					throw new ValidationManagerException(new Message(Messages.S140));
				}
			}
		}

		if(GenericUtil.isNotNullOrEmpty(pg.getCap()))
		{
			checkCAP(pg.getCap(), ConstantsField.GESTISCI_IMPRESA_CAP);
		}

	}


	public void validazioneFormaleSalvaResponsabile(Responsabile responsabile, boolean isResponsabile) throws ValidationManagerException {

		// Non verifico l'installatore, perche' se sono in questo punto l'ho gia' cercato!

//		boolean idStatoImpEmpty = GenericUtil.isNullOrEmpty(impianto.getImpIdStatoImp());
//		boolean indirizzoEmpty = GenericUtil.isNullOrEmpty(impianto.getImpLocIdIndirizzo()) && GenericUtil.isNullOrEmpty(impianto.getImpLocIndirizzoNoStrad());

		ValidationManagerException ex = null;

		//Message message = new Message(Messages.ERROR_CAMPO_ABBIGATORIO);
		//message.replacePlaceholder("");
		ex = new ValidationManagerException();

		if(GenericUtil.isNotNullOrEmpty(responsabile.getPec()) && !GenericUtil.checkValideEmail(responsabile.getPec())){
			ex = new ValidationManagerException(new Message(Messages.ERROR_EMAIL_FORMAT));
			ex.addField(ConstantsField.GESTISCI_RESPONSABILE_PEC);
		}

		if(GenericUtil.isNotNullOrEmpty(responsabile.getTelefono()) && !GenericUtil.checkValideNumber(responsabile.getTelefono())){
			ex = new ValidationManagerException(new Message(Messages.ERROR_NUMERO_NON_CORRETTO));
			ex.addField(ConstantsField.GESTISCI_RESPONSABILE_TELEFONO);
		}

		if (isResponsabile && GenericUtil.isNullOrEmpty(responsabile.getIdTitolo())) {
			ex.addFieldRequired(ConstantsField.GESTISCI_RESPONSABILE_ID_TITOLO);

		}

		if (GenericUtil.isNullOrEmpty(responsabile.getFlgImpresa())) {
			ex.addFieldRequired(ConstantsField.GESTISCI_RESPONSABILE_FLG_IMPRESA);

		}

		if(!(responsabile.getFlgImpresa()) && GenericUtil.isNullOrEmpty(responsabile.getNome())){
			ex.addFieldRequired(ConstantsField.GESTISCI_RESPONSABILE_NOME);
		}

		checkSiglaAndNumeroRea(responsabile.getIdSiglaRea(), responsabile.getNumeroRea(), ConstantsField.GESTISCI_RESPONSABILE_ID_SIGLA_REA, ConstantsField.GESTISCI_RESPONSABILE_NUMERO_REA);


		if (GenericUtil.isNullOrEmpty(responsabile.getCodiceFiscale())) {
			ex.addFieldRequired(ConstantsField.GESTISCI_RESPONSABILE_CF);

		}

		if (GenericUtil.isNullOrEmpty(responsabile.getCognome())) {
			ex.addFieldRequired(ConstantsField.GESTISCI_RESPONSABILE_COGNOME);

		}

		if (responsabile.getFlgIndirizzoEst())
		{
			if (GenericUtil.isNullOrEmpty(responsabile.getEstStato())) {
				ex.addFieldRequired(ConstantsField.GESTISCI_RESPONSABILE_EST_STATO);
			}

			if (GenericUtil.isNullOrEmpty(responsabile.getEstCitta())) {
				ex.addFieldRequired(ConstantsField.GESTISCI_RESPONSABILE_EST_CITTA);
			}

			if (GenericUtil.isNullOrEmpty(responsabile.getEstIndirizzo())) {
				ex.addFieldRequired(ConstantsField.GESTISCI_RESPONSABILE_EST_INDIRIZZO);
			}
		}
		else
		{
			if (GenericUtil.isNullOrEmpty(responsabile.getIdProvincia())) {
				ex.addFieldRequired(ConstantsField.GESTISCI_RESPONSABILE_ID_PROVINCIA);

			}

			if (GenericUtil.isNullOrEmpty(responsabile.getIdComune())) {
				ex.addFieldRequired(ConstantsField.GESTISCI_RESPONSABILE_ID_COMUNE);

			}

			if (GenericUtil.isNullOrEmpty(responsabile.getIdIndirizzo()) && GenericUtil.isNullOrEmpty(responsabile.getIndirizzoNoStrad())) {
				ex.addFieldRequired(ConstantsField.GESTISCI_RESPONSABILE_INDIRIZZO);
				ex.addFieldRequired(ConstantsField.GESTISCI_RESPONSABILE_ID_INDIRIZZO);
				ex.addFieldRequired(ConstantsField.GESTISCI_RESPONSABILE_INDIRIZZO_NON_TROVATO);
			}

		}



		if (GenericUtil.isNullOrEmpty(responsabile.getDataInizioResp())) {
			ex.addFieldRequired(ConstantsField.GESTISCI_RESPONSABILE_DATA_INIZIO);

		}

		if (ex.getFieldList().size() > 0)
		{
				//ex.setMsg(message);
				throw ex;
		}

		isDataFutura(responsabile.getDataInizioResp(), ConstantsField.GESTISCI_RESPONSABILE_DATA_INIZIO);

		checkDate(responsabile.getDataInizioResp(), ConstantsField.GESTISCI_RESPONSABILE_DATA_INIZIO);

//		if (!DateUtil.checkDateOrder(impianto.getDataInizioResp(), responsabile.getDataInizioResp(), true))
//		{
//			throw new ValidationManagerException(new Message(Messages.ERROR_DATA_RESPONSABILE));
//		}

		if (GenericUtil.isNotNullOrEmpty(responsabile.getDataFineResp()))
		{
			isDataFutura(responsabile.getDataFineResp(), ConstantsField.GESTISCI_RESPONSABILE_DATA_FINE);

			if (!DateUtil.checkDateOrder(responsabile.getDataInizioResp(), responsabile.getDataFineResp(), true))
			{
				throw new ValidationManagerException(new Message(Messages.ERROR_DATA_RESPONSABILE));
			}
		}

		if (!responsabile.getFlgIndirizzoEst())
		{
			if (GenericUtil.isNotNullOrEmpty(responsabile.getCap()))
			{
				checkCAP(responsabile.getCap(), ConstantsField.GESTISCI_RESPONSABILE_CAP);
			}
		}


		if (responsabile.getFlgImpresa())
		{
			checkCodiceFiscalePartitaIva(responsabile.getCodiceFiscale(), ConstantsField.GESTISCI_RESPONSABILE_CF);
		}
		else
		{
			controlloCf(responsabile.getCodiceFiscale(), ConstantsField.GESTISCI_RESPONSABILE_CF);
		}


//		if (responsabile.getCodiceFiscale().length() == Constants.PARTITA_IVA_LEN)
//		{
//			controlloPIVA(responsabile.getCodiceFiscale(), ConstantsField.GESTISCI_RESPONSABILE_CF);
//		}
//		else
//		{
//			controlloCf(responsabile.getCodiceFiscale(), ConstantsField.GESTISCI_RESPONSABILE_CF);
//		}

		if (responsabile.getIdResponsabile() == null)
		{
			ArrayList<SigitVPfPgDto> listResp = null;

			String message = null;
			try {
				if (GenericUtil.isNotNullOrEmpty(responsabile.getIdSiglaRea()) && GenericUtil.isNotNullOrEmpty(responsabile.getNumeroRea()))
				{
					listResp = getDbMgr().cercaPersonaByCodiceReaAndFiscale(responsabile.getIdSiglaRea(), ConvertUtil.convertToBigDecimal(responsabile.getNumeroRea()), responsabile.getCodiceFiscale(), responsabile.getFlgImpresa());
					message = Messages.ERROR_CODICE_REA_NON_CERCATO;

				}
				else if(GenericUtil.isNotNullOrEmpty(responsabile.getCodiceFiscale()))
				{
					listResp = getDbMgr().cercaPersonaByCodiceFiscale(responsabile.getCodiceFiscale(), responsabile.getFlgImpresa());
					message = Messages.ERROR_CF_NON_CERCATO;
				}

			} catch (DbManagerException e) {
				throw new ValidationManagerException(e, e.getMsg());
			}

			if (listResp != null && listResp.size() > 0)
			{
				throw new ValidationManagerException(new Message(message));
			}
		}


	}

	public void validazioneFormaleCaricaDocumento(Documento documento) throws ValidationManagerException {

		ValidationManagerException ex = null;

		ex = new ValidationManagerException();

		if (GenericUtil.isNullOrEmpty(documento.getIdTipoDocumento())) {
			ex.addFieldRequired(ConstantsField.GESTISCI_DOCUMENTO_ID_TIPO_DOC);

		}
		else if (documento.getIdTipoDocumento().intValue() == Constants.ID_TIPO_DOC_ALTRO_DOC ||
				documento.getIdTipoDocumento().intValue() == Constants.ID_TIPO_DOC_ALTRO_DOC_ISPEZIONI)
		{
			if (GenericUtil.isNullOrEmpty(documento.getDescAltroDoc())) {
				ex.addFieldRequired(ConstantsField.GESTISCI_DOCUMENTO_DESC_ALTRO_DOC);

			}
		}

		if (ex.getFieldList().size() > 0)
		{
				throw ex;
		}
	}

	public void validazioneFormaleCaricaDocumentoRee(Documento documento) throws ValidationManagerException {

		ValidationManagerException ex = null;

		ex = new ValidationManagerException();

		if (GenericUtil.isNullOrEmpty(documento.getDescAltroDoc())) {
			ex.addFieldRequired(ConstantsField.GESTISCI_DOCUMENTO_REE_DESC_DOC);

		}

		if (ex.getFieldList().size() > 0)
		{
				throw ex;
		}
	}


	public boolean checkMimeTypeDocumento(String mimeType) {
		boolean out = false;
		try {
			if (mimeType != null) {

				log.debug("Stampo il mimeType del documento: "+mimeType);

				String param = getDbMgr().cercaConfigValueCarattere(Constants.FORMATI_DOCUMENTI_REE_AMMESSI);
				String[] ends = param.split(",");

				for (int i = 0; i < ends.length; i++) {

					log.debug("Stampo il mimeType del DB: "+ends[i]);

					if (mimeType.equals(ends[i])) {
						out = true;
						break;
					}
				}
			}
		} catch (Exception e) {
			log.warn("", e);
		}
		return out;
	}

	public void validazioneFormaleAcquisizioneCodici(AcquisizioneCodici acquisizioneCodici) throws ValidationManagerException {

		boolean idInstallatoreEmpty = GenericUtil.isNullOrEmpty(acquisizioneCodici.getIdInstallatore());
		boolean quantitaEmpty = GenericUtil.isNullOrEmpty(acquisizioneCodici.getQuantita());

		try {

			if (idInstallatoreEmpty)
			{
				throw new ValidationManagerException(new Message(Messages.S030));

			}else{
				SigitTPersonaGiuridicaPk pk = new SigitTPersonaGiuridicaPk();
				pk.setIdPersonaGiuridica(new BigDecimal(ConvertUtil.convertToString(acquisizioneCodici.getIdInstallatore())));
				//devo verificare che l'impresa non sia cessata
				SigitTPersonaGiuridicaDto personaGiuridica = this.getDbMgr().getSigitTPersonaGiuridicaDao().findByPrimaryKey(pk);

				if (personaGiuridica.getFkStatoPg().intValue() == Constants.ID_STATO_IMPRESA_SOSPESA
						|| personaGiuridica.getFkStatoPg().intValue() == Constants.ID_STATO_IMPRESA_RADIATA) {
					throw new ValidationManagerException(
							new Message(Messages.S147, MapDto.getCodiceRea(personaGiuridica.getSiglaRea(), personaGiuridica.getNumeroRea()), personaGiuridica
									.getCodiceFiscale()));
				}

				if(personaGiuridica.getDataCessazione()!=null){
					throw new ValidationManagerException(new Message(Messages.S014,ConvertUtil.convertToString(personaGiuridica.getDataCessazione())));
				}
			}


			ValidationManagerException ex = null;


			if (quantitaEmpty)
			{
				ex = new ValidationManagerException();
				ex.addFieldRequired(ConstantsField.ACQUISISCI_CODICE_QUANTITA);
				throw ex;
			}



			Integer quantita = acquisizioneCodici.getQuantita();
			Integer maxAcquisto;
			Integer multiploAcquisto;

			if(quantita>0){
				maxAcquisto = getDbMgr().cercaConfigValueNumerico(Constants.MAX_QUANTITA_ACUISIZIONE_CODICI);


				if (quantita.intValue() > maxAcquisto.intValue())
				{
					throw new ValidationManagerException(new Message(Messages.S015, ConvertUtil.convertToString(maxAcquisto)));
				}

				multiploAcquisto = getDbMgr().cercaConfigValueNumerico(Constants.MULTIPLO_QUANTITA_ACUISIZIONE_CODICI);


				if (!GenericUtil.checkNumeroMultiplo(quantita, multiploAcquisto))
				{
					throw new ValidationManagerException(new Message(Messages.S016, ConvertUtil.convertToString(multiploAcquisto)));
				}
			}else{
				throw new ValidationManagerException(new Message(Messages.S018, ConvertUtil.convertToString(quantita)));
			}


		} catch (DbManagerException e) {
			throw new ValidationManagerException(e, e.getMsg());
		} catch (SigitTPersonaGiuridicaDaoException e) {
			throw new ValidationManagerException(new Message(Messages.ERROR_RECUPERO_PERSONA_GIURIDICA));
		}
	}

	public void validazioneFormaleAcquistoBollini(ArrayList<AcquistoBolliniQuantita> acquistoBollList, AcquistoBollini acquistoBoll) throws ValidationManagerException {

		boolean idInstallatoreEmpty = GenericUtil.isNullOrEmpty(acquistoBoll.getIdInstallatore());
		try {

			if (idInstallatoreEmpty)
			{
				throw new ValidationManagerException(new Message(Messages.S030));

			}else{
				SigitTPersonaGiuridicaPk pk = new SigitTPersonaGiuridicaPk();
				pk.setIdPersonaGiuridica(new BigDecimal(ConvertUtil.convertToString(acquistoBoll.getIdInstallatore())));
				//qui da fare il controllo se l'impresa e' cessata
				SigitTPersonaGiuridicaDto personaGiuridica = this.getDbMgr().getSigitTPersonaGiuridicaDao().findByPrimaryKey(pk);

				if (personaGiuridica.getFkStatoPg().intValue() == Constants.ID_STATO_IMPRESA_SOSPESA
						|| personaGiuridica.getFkStatoPg().intValue() == Constants.ID_STATO_IMPRESA_RADIATA) {
					throw new ValidationManagerException(
							new Message(Messages.S147, MapDto.getCodiceRea(personaGiuridica.getSiglaRea(), personaGiuridica.getNumeroRea()), personaGiuridica
									.getCodiceFiscale()));
				}

				if(personaGiuridica.getDataCessazione()!=null){
					throw new ValidationManagerException(new Message(Messages.S0100, ConvertUtil.convertToString(personaGiuridica.getDataCessazione())));
				}
			}

			Integer maxAcquisto = getDbMgr().cercaConfigValueNumerico(Constants.MAX_QTA_BOLLINO_X_TUTTE_FASCE);

			Integer quantitaTot = 0;
			Message msg = new Message(Messages.S015, ConvertUtil.convertToString(maxAcquisto));
			ValidationManagerException ex = new ValidationManagerException(msg);

			for (AcquistoBolliniQuantita acqBolliniQta : acquistoBollList) {

				Integer quantita = acqBolliniQta.getQuantita();

				if (GenericUtil.isNotNullOrEmpty(quantita))
				{
					if(quantita>0){
						quantitaTot += acqBolliniQta.getQuantita();

						if (acqBolliniQta.getQuantita().intValue() > maxAcquisto.intValue())
						{
							throw ex;
						}
					}else{
						ValidationManagerException ex1 = new ValidationManagerException(new Message(Messages.S033));
						throw ex1;
					}

				}
			}
			if (quantitaTot.intValue() == 0)
			{
				throw new ValidationManagerException(new Message(Messages.S034));
			}

		} catch (DbManagerException e) {
			throw new ValidationManagerException(e, e.getMsg());
		} catch (SigitTPersonaGiuridicaDaoException e) {
			throw new ValidationManagerException(new Message(Messages.ERROR_RECUPERO_PERSONA_GIURIDICA));
		}
	}

	public void validazioneFormalePagaBollini(DatiPagamento dpaga) throws ValidationManagerException {

		if (GenericUtil.isNullOrEmpty(dpaga.getIdGestorePagamento()))
		{
			throw new ValidationManagerException(new Message(Messages.ERROR_METODO_PAGAMENTO_OBBLIGATORIO));

		}
	}

	public void validazioneFormaleStampaRicevutaAllegato(Integer idAllegato, String ruoloUtente, Integer idPersonaGiuridicaUtente) throws ValidationManagerException {

		try
		{
			//SigitVRicercaAllegatiDto allegato = getDbMgr().cercaSigitVRicercaAllegatiByIdAllegato(idAllegato);
			DettaglioAllegato allegato = this.getDbMgr()
					.getDettaglioAllegatoById(idAllegato);

			if (allegato.getIdStatoRapporto().intValue() != Constants.ID_STATO_RAPPORTO_INVIATO &&
					allegato.getIdStatoRapporto().intValue() != Constants.ID_STATO_RAPPORTO_RESPINTO)
			{
				throw new ValidationManagerException(new Message(Messages.S047));
			}
			else if (ruoloUtente.equalsIgnoreCase(Constants.RUOLO_IMPRESA))
			{

				if (idPersonaGiuridicaUtente.intValue() != allegato.getIdPersonaGiuridica().intValue())
				{
					// Devo verificare che il rapporto sia il suo!!!!
					throw new ValidationManagerException(new Message(Messages.S044));

				}
			}
		} catch (DbManagerException e) {
			throw new ValidationManagerException(new Message(Messages.ERROR_RECUPERO_DB));
		}
	}

	public void validazioneFormaleRespingiAllegato(String idAllegato) throws ValidationManagerException {

		try
		{
			SigitVRicercaAllegatiDto allegato = getDbMgr().cercaSigitVRicercaAllegatiByIdAllegato(idAllegato);

			if (allegato.getRuoloFunz().equalsIgnoreCase(Constants.RUOLO_ISPETTORE)) {
				throw new ValidationManagerException(new Message(
						Messages.S122));
			}
			else if (allegato.getFkStatoRapp().intValue() != Constants.ID_STATO_RAPPORTO_INVIATO)
			{
				throw new ValidationManagerException(new Message(Messages.S046));
			}

			if (getDbMgr().cercaResponsabileAttivoByCodImpianto(
					ConvertUtil.convertToInteger(allegato.getCodiceImpianto())) == null) {
				// Vuol dire che non c'e' un respansabile attivo alla sysdate, non riuscirei a creare il libretto
				throw new ValidationManagerException(new Message(Messages.ERROR_RESPONSABILE_ASSENTE));
			}

		} catch (DbManagerException e) {
			throw new ValidationManagerException(new Message(Messages.ERROR_RECUPERO_DB));
		}

	}

	public void validazioneFormaleEliminaAllegato(Integer idAllegato, String ruoloUtente, Integer idPersonaGiuridicaUtente) throws ValidationManagerException {

		try
		{
			//SigitVRicercaAllegatiDto allegato = getDbMgr().cercaSigitVRicercaAllegatiByIdAllegato(idAllegato);
			DettaglioAllegato dettaglioAllegato = this.getDbMgr()
					.getDettaglioAllegatoById(idAllegato);

			if (dettaglioAllegato.getRuoloFunzionale().equalsIgnoreCase(Constants.RUOLO_ISPETTORE)) {
				throw new ValidationManagerException(new Message(
						Messages.S122));
			}
			else if (dettaglioAllegato.getIdStatoRapporto().intValue() != Constants.ID_STATO_RAPPORTO_BOZZA)
			{
				throw new ValidationManagerException(new Message(Messages.S045));
			}
			else if (ruoloUtente.equalsIgnoreCase(Constants.RUOLO_IMPRESA))
			{
				//SigitRImpRuoloPfpgDto impRuolo = getDbMgr().cercaSigitRImpRuoloPfpgById(allegato.getFkImpRuoloPfpg());

				log.debug("####### STAMPO idPersonaGiuridicaUtente: "+idPersonaGiuridicaUtente);
				log.debug("####### STAMPO dettaglioAllegato.getIdPersonaGiuridica(): "+dettaglioAllegato.getIdPersonaGiuridica());

				if (idPersonaGiuridicaUtente.intValue() != dettaglioAllegato.getIdPersonaGiuridica().intValue())
				{
					// Devo verificare che il rapporto sia il suo!!!!
					throw new ValidationManagerException(new Message(Messages.S044));
				}
			}
		} catch (DbManagerException e) {
			throw new ValidationManagerException(new Message(Messages.ERROR_RECUPERO_DB));
		}
	}

	public void validazioneFormaleAnnullaManutenzione(String idAllegato, String ruoloUtente, Integer idPersonaGiuridicaUtente) throws ValidationManagerException {

		try
		{
			//SigitVRicercaAllegatiDto allegato = getDbMgr().cercaSigitVRicercaAllegatiByIdAllegato(idAllegato);
			DettaglioManutenzione dettaglioAllegato = getSigitMgr().cercaDettaglioManutenzioneById(idAllegato);

			if (!(dettaglioAllegato.getIdTipoManut() == Constants.MANUTENZIONE_GT ||
					dettaglioAllegato.getIdTipoManut() == Constants.MANUTENZIONE_GF ||
					dettaglioAllegato.getIdTipoManut() == Constants.MANUTENZIONE_SC ||
					dettaglioAllegato.getIdTipoManut() == Constants.MANUTENZIONE_CG))
			{
				// Si possono annullare solo le munutenzioni
				throw new ValidationManagerException(new Message(Messages.S179));

			}

			if (dettaglioAllegato.getIdStatoManut().intValue() != Constants.ID_STATO_RAPPORTO_INVIATO)
			{
				throw new ValidationManagerException(new Message(Messages.S178));
			}
			else if (ruoloUtente.equalsIgnoreCase(Constants.RUOLO_IMPRESA))
			{
				//SigitRImpRuoloPfpgDto impRuolo = getDbMgr().cercaSigitRImpRuoloPfpgById(allegato.getFkImpRuoloPfpg());

				log.debug("####### STAMPO idPersonaGiuridicaUtente: "+idPersonaGiuridicaUtente);
				log.debug("####### STAMPO dettaglioAllegato.getIdPersonaGiuridica(): "+dettaglioAllegato.getIdPersonaGiuridica());

				if (idPersonaGiuridicaUtente.intValue() != dettaglioAllegato.getIdPersonaGiuridica().intValue())
				{
					// Devo verificare che il rapporto sia il suo!!!!
					throw new ValidationManagerException(new Message(Messages.S044));
				}
			}

			if (getDbMgr().cercaResponsabileAttivoByCodImpianto(
					ConvertUtil.convertToInteger(dettaglioAllegato.getCodiceImpianto())) == null) {
				// Vuol dire che non c'e' un respansabile attivo alla sysdate, non riuscirei a creare il libretto
				throw new ValidationManagerException(new Message(Messages.ERROR_RESPONSABILE_ASSENTE));
			}
		} catch (DbManagerException e) {
			throw new ValidationManagerException(new Message(Messages.ERROR_RECUPERO_DB));
		}
	}

	public void validazioneFormaleEliminaDocumento(Integer idDocumento, String ruoloUtente) throws ValidationManagerException {

		try
		{
			SigitTDocAggiuntivaDto documentoDto = getDbMgr().cercaDocumentoAggById(idDocumento);

			/*
			if (GenericUtil.isNotNullOrEmpty(documentoDto.getFkImpRuoloPfpg()) &&
					!(ruoloUtente.equalsIgnoreCase(Constants.RUOLO_ISPETTORE) ||
					ruoloUtente.equalsIgnoreCase(Constants.RUOLO_SUPER))) {
				throw new ValidationManagerException(new Message(
						Messages.S155));
			}
			*/

		} catch (DbManagerException e) {
			throw new ValidationManagerException(new Message(Messages.ERROR_RECUPERO_DB));
		}
	}

	public void validazioneFormaleDocumentazioneAllegato(Integer idAllegato, Ruolo ruoloUtente) throws ValidationManagerException {

		try
		{
			String descRuoloUtente = ruoloUtente.getDescRuolo();

			DettaglioAllegato allegato = this.getDbMgr()
					.getDettaglioAllegatoById(idAllegato);

				if (descRuoloUtente.equalsIgnoreCase(Constants.RUOLO_IMPRESA))
				{

					if (ruoloUtente.getIdPersonaGiuridica().intValue() != allegato.getIdPersonaGiuridica().intValue())
					{
						// Devo verificare che il rapporto sia il suo!!!!
						throw new ValidationManagerException(new Message(Messages.S044));
					}
				}



		} catch (DbManagerException e) {
			throw new ValidationManagerException(new Message(Messages.ERROR_RECUPERO_DB));
		}
	}

	public void validazioneFormaleDettaglioAllegato(Integer idAllegato, Ruolo ruoloUtente) throws ValidationManagerException {
		validazioneFormaleDettaglioAllegato(idAllegato, ruoloUtente, false);
	}

	public void validazioneFormaleDettaglioAllegato(Integer idAllegato, Ruolo ruoloUtente, boolean storico) throws ValidationManagerException {

		try
		{
			String descRuoloUtente = ruoloUtente.getDescRuolo();

			//SigitVRicercaAllegatiDto allegato = getDbMgr().cercaSigitVRicercaAllegatiByIdAllegato(ConvertUtil.convertToString(idAllegato));
			DettaglioAllegato allegato = this.getDbMgr().getDettaglioAllegatoById(idAllegato, storico);

			BigDecimal codiceImpianto = ConvertUtil.convertToBigDecimal(allegato.getCodiceImpianto());

			if (allegato.getIdStatoRapporto().intValue() == Constants.ID_STATO_RAPPORTO_BOZZA)
			{
				throw new ValidationManagerException(new Message(Messages.S041));
			}
			else if (allegato.getIdStatoRapporto().intValue() == Constants.ID_STATO_RAPPORTO_INVIATO ||
					allegato.getIdStatoRapporto().intValue() == Constants.ID_STATO_RAPPORTO_RESPINTO)
			{
//				boolean isUtenteAttivo = false;
				if (descRuoloUtente.equalsIgnoreCase(Constants.RUOLO_IMPRESA))
				{

					//SigitRImpRuoloPfpgDto impRuolo = getDbMgr().cercaSigitRImpRuoloPfpgById(allegato.getFkImpRuoloPfpg());

					if (ruoloUtente.getIdPersonaGiuridica().intValue() != allegato.getIdPersonaGiuridica().intValue())
					{
						// Devo verificare che il rapporto sia il suo!!!!
						throw new ValidationManagerException(new Message(Messages.S044));
					}
//					else{
//						isUtenteAttivo = true;
//					}
				}
				else if (descRuoloUtente.equalsIgnoreCase(Constants.RUOLO_RESPONSABILE_IMPRESA)
						|| descRuoloUtente.equalsIgnoreCase(Constants.RUOLO_PROPRIETARIO_IMPRESA)
						|| descRuoloUtente.equalsIgnoreCase(Constants.RUOLO_RESPONSABILE)
						|| descRuoloUtente.equalsIgnoreCase(Constants.RUOLO_PROPRIETARIO))
				{
					List<SigitRImpRuoloPfpgDto> impRuoloList = null;
					if (descRuoloUtente.equalsIgnoreCase(Constants.RUOLO_RESPONSABILE_IMPRESA)
						|| descRuoloUtente.equalsIgnoreCase(Constants.RUOLO_PROPRIETARIO_IMPRESA))
					{
						impRuoloList = getDbMgr().cercaSigitRImpRuoloPfpgByRuoloFunzCodImpianto(codiceImpianto, ruoloUtente.getIdPersonaGiuridica(), null, descRuoloUtente);
					}
					else if (descRuoloUtente.equalsIgnoreCase(Constants.RUOLO_RESPONSABILE)
							|| descRuoloUtente.equalsIgnoreCase(Constants.RUOLO_PROPRIETARIO))
					{
						impRuoloList = getDbMgr().cercaSigitRImpRuoloPfpgByRuoloFunzCodImpianto(codiceImpianto, null, ruoloUtente.getCodiceFiscale(), descRuoloUtente);
					}

					if (impRuoloList == null || impRuoloList.size() == 0)
					{
						// l'allegato NON appartiene ad un impianto su cui l'utente ha un ruolo attivo
						throw new ValidationManagerException(new Message(Messages.S044));
					}
//					isUtenteAttivo = impRuoloList!=null&&impRuoloList.size()>0;
				}
				else if (descRuoloUtente.equalsIgnoreCase(Constants.RUOLO_3RESPONSABILE))
				{
//					List<SigitVAllegatiComponentiDto> tRespList = getDbMgr().cercaAllegatoByIdAllegato(ConvertUtil.convertToBigDecimal(allegato.getIdAllegato()));
//
//					boolean isCorrect = false;
//
//
//					if (tRespList != null && tRespList.size() > 0)
//					{
//						for (SigitVAllegatiComponentiDto sigitVAllegatiComponentiDto : tRespList) {
//
//							BigDecimal idContratto = sigitVAllegatiComponentiDto.getFkContratto();
//
//							if (idContratto != null)
//							{
//								SigitTContratto2019Dto tContratto = getDbMgr().cercaContrattoById(idContratto);
//
//								if (tContratto.getFkPg3Resp().intValue() == ruoloUtente.getIdPersonaGiuridica().intValue())
//								{
//									isCorrect = true;
//									break;
//								}
//							}
//						}
//					}
//
//					if (!isCorrect)
//					{
//						// l'allegato selezionato NON e' stato compilato dal terzo responsabile
//						// l'allegato NON appartiene ad un impianto su cui l'utente ha un ruolo attivo
//						throw new ValidationManagerException(new Message(Messages.S044));
//					}

					List<SigitTContratto2019Dto> contratti3Resp = getDbMgr().cercaContrattiAttiviByCodImpAndIdPg3Resp(codiceImpianto, ConvertUtil.convertToBigDecimal(ruoloUtente.getIdPersonaGiuridica()));

					if (contratti3Resp == null || contratti3Resp.isEmpty()) {
						throw new ValidationManagerException(new Message(Messages.S044));
					}
				}


			}
		} catch (DbManagerException e) {
			throw new ValidationManagerException(new Message(Messages.ERROR_RECUPERO_DB));
		}
	}

	public void validazioneFormaleStatoLibretto(String codiceImpianto) throws ValidationManagerException {

		if (GenericUtil.isNullOrEmpty(codiceImpianto))
		{
			try {
				List<SigitTLibrettoDto> lista = dbMgr.getListaLibrettiByCodiceImpianto(ConvertUtil.convertToInteger(codiceImpianto));
				if(lista!=null && lista.size()>0){
					SigitTLibrettoDto dto = lista.get(0);
					if(dto.getFkStato()!=null){
						if(Constants.ID_STATO_LIBRETTO_CONSOLIDATO!=ConvertUtil.convertToInteger(dto.getFkStato())){
							throw new ValidationManagerException(new Message(Messages.S055));
						}
					}
				}

			} catch (DbManagerException e) {
				throw new ValidationManagerException(new Message(Messages.ERROR_RECUPERO_DB));
			}


		}else{
			throw new ValidationManagerException(new Message(Messages.ERROR_FORMALE_RECUPERO_CODICE_IMPIANTO));
		}
	}

	public void verificaRicercaIndirizzoIdentificazioneImpianto(Impianto dto) throws ValidationManagerException {
		log.debug("[ValidationMgr::verificaRicercaIndirizzoIdentificazioneImpianto] BEGIN");

		checkRicercaIndirizzo(dto.getImpLocIdComune(), dto.getImpLocIdProvincia(),
				ConstantsField.GESTISCI_IMPIANTO_LOC_ID_COMUNE, ConstantsField.GESTISCI_IMPIANTO_LOC_ID_PROVINCIA);

		log.debug("VERIFICO L'INDIRIZZO IMPIANTO: "+GenericUtil.isNullOrEmpty(dto.getImpLocIndirizzo()));

		if (GenericUtil.isNullOrEmpty(dto.getImpLocIndirizzo()))
		{
			ValidationManagerException ex =  new ValidationManagerException();
			ex.addFieldRequired(ConstantsField.GESTISCI_IMPIANTO_LOC_INDIRIZZO);
			throw ex;
		}

		checkAlphanumericStringMinLenght(dto.getImpLocIndirizzo(), Constants.MIN_INDIRIZZO_LEN, ConstantsField.GESTISCI_IMPIANTO_LOC_INDIRIZZO);

		log.debug("[ValidationMgr::verificaRicercaIndirizzoIdentificazioneImpianto] END");
	}

	public void verificaRicercaIndirizzoResponsabile(Responsabile dto) throws ValidationManagerException {
		log.debug("[ValidationMgr::verificaRicercaIndirizzoResponsabile] BEGIN");
		checkRicercaIndirizzo(dto.getIdComune(), dto.getIdProvincia(),
				ConstantsField.GESTISCI_RESPONSABILE_ID_COMUNE, ConstantsField.GESTISCI_RESPONSABILE_ID_PROVINCIA);

		log.debug("VERIFICO L'INDIRIZZO RESPONSABILE: "+GenericUtil.isNullOrEmpty(dto.getIndirizzo()));

		if (GenericUtil.isNullOrEmpty(dto.getIndirizzo()))
		{
			ValidationManagerException ex =  new ValidationManagerException();
			ex.addFieldRequired(ConstantsField.GESTISCI_RESPONSABILE_INDIRIZZO);
			throw ex;
		}

		checkAlphanumericStringMinLenght(dto.getIndirizzo(), Constants.MIN_INDIRIZZO_LEN, ConstantsField.GESTISCI_RESPONSABILE_INDIRIZZO);
		log.debug("[ValidationMgr::verificaRicercaIndirizzoResponsabile] END");
	}

	public void verificaRicercaIndirizzoImpresa(PersonaGiuridica dto) throws ValidationManagerException {
		log.debug("[ValidationMgr::verificaRicercaIndirizzoImpresa] BEGIN");
		checkRicercaIndirizzo(dto.getIdComuneSelez(), dto.getIdProvinciaSelez(),
				ConstantsField.GESTISCI_IMPRESA_ID_COMUNE, ConstantsField.GESTISCI_IMPRESA_ID_PROVINCIA);

		log.debug("VERIFICO L'INDIRIZZO RESPONSABILE: "+GenericUtil.isNullOrEmpty(dto.getIndirizzo()));

		if (GenericUtil.isNullOrEmpty(dto.getIndirizzo()))
		{
			ValidationManagerException ex =  new ValidationManagerException();
			ex.addFieldRequired(ConstantsField.GESTISCI_RESPONSABILE_INDIRIZZO);
			throw ex;
		}

		checkAlphanumericStringMinLenght(dto.getIndirizzo(), Constants.MIN_INDIRIZZO_LEN, ConstantsField.GESTISCI_IMPRESA_INDIRIZZO);
		log.debug("[ValidationMgr::verificaRicercaIndirizzoImpresa] END");
	}


	public void verificaRicercaIndirizzoSubentro(Subentro dto) throws ValidationManagerException {
		log.debug("[ValidationMgr::verificaRicercaIndirizzoSubentro] BEGIN");

		checkRicercaIndirizzo(dto.getImpLocIdComune(), dto.getImpLocIdProvincia(),
				ConstantsField.GESTISCI_SUBENTRO_LOC_ID_COMUNE, ConstantsField.GESTISCI_SUBENTRO_LOC_ID_PROVINCIA);

		log.debug("VERIFICO L'INDIRIZZO SUBENTRO: "+GenericUtil.isNullOrEmpty(dto.getImpLocIndirizzo()));

		if (GenericUtil.isNullOrEmpty(dto.getImpLocIndirizzo()))
		{
			ValidationManagerException ex =  new ValidationManagerException();
			ex.addFieldRequired(ConstantsField.GESTISCI_SUBENTRO_LOC_INDIRIZZO);
			throw ex;
		}

		checkAlphanumericStringMinLenght(dto.getImpLocIndirizzo(), Constants.MIN_INDIRIZZO_LEN, ConstantsField.GESTISCI_SUBENTRO_LOC_INDIRIZZO);

		log.debug("[ValidationMgr::verificaRicercaIndirizzoSubentro] END");
	}

	public void verificaRicercaIndirizzo3Responsabile(TerzoResponsabile dto) throws ValidationManagerException {
		log.debug("[ValidationMgr::verificaRicercaIndirizzo3Responsabile] BEGIN");

		checkRicercaIndirizzo(dto.getImpLocIdComune(), dto.getImpLocIdProvincia(),
				ConstantsField.GESTISCI_3_RESPONSABILE_LOC_ID_COMUNE, ConstantsField.GESTISCI_3_RESPONSABILE_LOC_ID_PROVINCIA);

		if (GenericUtil.isNullOrEmpty(dto.getImpLocIndirizzo()))
		{
			ValidationManagerException ex =  new ValidationManagerException();
			ex.addFieldRequired(ConstantsField.GESTISCI_3_RESPONSABILE_LOC_INDIRIZZO);
			throw ex;
		}

		checkAlphanumericStringMinLenght(dto.getImpLocIndirizzo(), Constants.MIN_INDIRIZZO_LEN, ConstantsField.GESTISCI_3_RESPONSABILE_LOC_INDIRIZZO);

		log.debug("[ValidationMgr::verificaRicercaIndirizzo3Responsabile] END");
	}




	public void verificaCessaProprietario(Proprietario proprietario) throws ValidationManagerException {
		log.debug("[ValidationMgr::verificaCessaProprietario] BEGIN");

		ValidationManagerException ex = new ValidationManagerException();

		if(GenericUtil.isNullOrEmpty(proprietario.getDataFine()))
		{
			ex.addFieldRequired(CPBECpGestImpianto.APPDATA_IMPIANTO_CODE + ".proprietario.dataFine");
		} else if (!DateUtil.checkValideDate(proprietario.getDataFine())) {
			ex.addField(CPBECpGestImpianto.APPDATA_IMPIANTO_CODE + ".proprietario.dataFine", Messages.ERROR_FORMALE_DATA);
		}

		if(ex.getFieldList()!=null && !ex.getFieldList().isEmpty()) {
			throw ex;
		}

		isDataFutura(proprietario.getDataFine(), CPBECpGestImpianto.APPDATA_IMPIANTO_CODE + ".proprietario.dataFine");

		if (!DateUtil.checkDateOrderIsPresents(proprietario.getDataInizio(), proprietario.getDataFine(), false))
		{
			throw new ValidationManagerException(new Message(Messages.ERROR_DATA_FINE_AFTER_INIZIO));
		}

		log.debug("[ValidationMgr::verificaCessaProprietario] END");

	}
	/*
	public void verificaCessaProprietario(Proprietario dto) throws ValidationManagerException {
		log.debug("[ValidationMgr::verificaCessaProprietario] BEGIN");

		xx

		checkRicercaIndirizzo(dto.getImpLocIdComune(), dto.getImpLocIdProvincia(),
				ConstantsField.GESTISCI_IMPIANTO_LOC_ID_COMUNE, ConstantsField.GESTISCI_IMPIANTO_LOC_ID_PROVINCIA);

		log.debug("VERIFICO L'INDIRIZZO IMPIANTO: "+GenericUtil.isNullOrEmpty(dto.getImpLocIndirizzo()));

		if (GenericUtil.isNullOrEmpty(dto.getImpLocIndirizzo()))
		{
			ValidationManagerException ex =  new ValidationManagerException();
			ex.addFieldRequired(ConstantsField.GESTISCI_IMPIANTO_LOC_INDIRIZZO);
			throw ex;
		}

		checkAlphanumericStringMinLenght(dto.getImpLocIndirizzo(), Constants.MIN_INDIRIZZO_LEN, ConstantsField.GESTISCI_IMPIANTO_LOC_INDIRIZZO);

	}
	*/






	public void verificaExportXml(String listCodImp) throws ValidationManagerException {
		log.debug("[ValidationMgr::verificaExportXml] BEGIN");

		if (GenericUtil.isNullOrEmpty(listCodImp))
		{
			ValidationManagerException ex =  new ValidationManagerException();
			ex.addFieldRequired(ConstantsField.GESTISCI_EXPORT_XML);
			throw ex;
		}

		// verifico che siano tutti numeri

		int posDoppiaVirgola = listCodImp.indexOf(",,");

		if (posDoppiaVirgola >= 0)
		{
			// L'utente ha inserito una doppia virgola, questo non e' ammesso
			throw new ValidationManagerException(new Message(Messages.ERROR_CODICE_IMPIANTO_NON_CORRETTO, ",,"));

		}

		StringTokenizer tok = new StringTokenizer(listCodImp, ",");

		String codImp = null;
		while (tok.hasMoreTokens()) {
			codImp = tok.nextToken();

			log.debug("------");
			log.debug("Stampo il token: *"+codImp+"*");
			log.debug("Stampo il validate: *"+(!GenericUtil.checkValideNumber(codImp))+"*");
			log.debug("------");


			if (!GenericUtil.checkValideNumberTrim(codImp))
			{
				throw new ValidationManagerException(new Message(Messages.ERROR_CODICE_IMPIANTO_NON_CORRETTO, codImp));

			}
		}

		log.debug("[ValidationMgr::verificaExportXml] END");
	}

	/**
	 * Verifica che il filtro per la ricerca di un manutentore sia corretto.
	 * ALGORITMO 4 - Controllo validita' manutentore
	 *
	 * @param codiceFiscale Codice fiscale
	 * @param siglaRea Sigla REA
	 * @param numeroRea Numero REA
	 * @param codiceFiscaleField Campo associato al codice fiscale
	 * @param siglaReaField Campo associato alla sigla REA
	 * @param numeroReaField Campo associato al numero REA
	 * @return Nome della ditta del manutentore
	 * @throws ValidationManagerException Il filtro per la ricerca di un
	 *             manutentore non e' corretto
	 */
	public void verificaManutentore(String codiceFiscale, String siglaRea, UDTPositiveInteger numeroRea, String codiceFiscaleField,
			String siglaReaField, String numeroReaField) throws ValidationManagerException {
//		Message message = null;
//		SigitTManutentoreDto dto = null;
		boolean codiceFiscaleEmpty;
		boolean siglaReaEmpty;
		boolean numeroReaEmpty;

		codiceFiscaleEmpty = GenericUtil.isNullOrEmpty(codiceFiscale);
		siglaReaEmpty = GenericUtil.isNullOrEmpty(siglaRea);
		numeroReaEmpty = GenericUtil.isNullOrEmpty(numeroRea);
		// CHK21
		//if((codiceFiscaleEmpty && siglaReaEmpty && numeroReaEmpty) || (codiceFiscaleEmpty && (siglaReaEmpty != numeroReaEmpty))) {
		if (codiceFiscaleEmpty && siglaReaEmpty && numeroReaEmpty) {
			throw new ValidationManagerException(new Message(Messages.ERROR_CODICE_REA_CF_MANCANTE));
		}

		checkCodiceFiscalePartitaIva(codiceFiscale, codiceFiscaleField);

		checkSiglaAndNumeroRea(siglaRea, numeroRea, siglaReaField, numeroReaField);

//		// CHK22
		//PersonaGiuridica installatore = getDbMgr().cercaPersonaGiuridica(codiceFiscale, siglaRea, codiceFiscaleField);
//		dto = getSigitMgr().cercaInstallatore(impianto);
//		if(dto != null) {
//			/*
//			if(dto.getDataCessazione() != null) {
//				message = msgMgr.getMessage(WebMsgCodeEnum.S007);
//				message.replacePlaceholder(dto.getDataCessazione());
//				throw new ValidationManagerException(message);
//			}
//			*/
//		}
//		else {
//			throw new ValidationManagerException(msgMgr.getMessage(WebMsgCodeEnum.S025));
//		}
		//return dto;

	}

	/**
	 * Verifica che il filtro per la ricerca di un ispettore sia corretto.
	 *
	 * @param codiceFiscale Codice fiscale
	 * @return ispettore
	 * @throws ValidationManagerException Il filtro per la ricerca di un
	 *             ispettore non e' corretto
	 */
	public void verificaIspettore(String codiceFiscale) throws ValidationManagerException {

		if (GenericUtil.isNullOrEmpty(codiceFiscale))
		{
			ValidationManagerException ex =  new ValidationManagerException();
			ex.addFieldRequired(ConstantsField.DATI_ISPEZIONE_CF_ISPETTORE);
			throw ex;
		}


		checkCodiceFiscalePartitaIva(codiceFiscale, ConstantsField.DATI_ISPEZIONE_CF_ISPETTORE);

	}

	/**
	 * Verifica che le date del resposnabile non si accavallino con le date dei responsabili gia' presenti
	 *
	 * @param responsabile Resonsabile da verificare
	 * @param responsabiliList responsabili gia' presenti
	 * @throws ValidationManagerException C'e' un'incongruenza nelle date
	 */
	public void verificaDateResponsabile(Responsabile responsabile, ArrayList<RisultatoRicResponsabile> responsabiliList, String codImp) throws ManagerException {

		//boolean dataFineEmpty = GenericUtil.isNullOrEmpty(responsabile.getDataFineResp());

		String dataInizio = responsabile.getDataInizioResp();

		String dataFine = responsabile.getDataFineResp();

		boolean isCorrect = false;

		//Mario Rossi		01/01/2013		31/12/2013
		//Giovanni Verdi	01/07/2013

		if(responsabiliList!=null)//potrebbero non esserci responsabili (es: al primo caricamento)
		{
			for (RisultatoRicResponsabile risultatoRicResponsabile : responsabiliList) {

				isCorrect = false;

				log.debug("STAMPA dataInizio: "+dataInizio);
				log.debug("STAMPA dataFine: "+dataFine);

				if (log.isDebugEnabled())
					GenericUtil.stampa(risultatoRicResponsabile, true, 3);

				// Se sono in modifica (idImpResp != null) non devo confrontare il responsabile con se stesso
				if (responsabile.getIdImpResp() == null || responsabile.getIdImpResp().intValue() != risultatoRicResponsabile.getIdImpResp().intValue() )
				{
					if (GenericUtil.isNullOrEmpty(risultatoRicResponsabile.getDataRespAl()))
					{
						// Il responsabile sul DB non ha la data fine
						if (DateUtil.checkDateOrder(dataInizio, risultatoRicResponsabile.getDataRespDal(),  false) &&
								DateUtil.checkDateOrder(dataFine, risultatoRicResponsabile.getDataRespDal(), false))
						{
							// Vuol dire che o la data inizio o la data fine non e' precedente alla data inizio del responsabile sul DB (visto che non ha la data fine questo non e' ammesso)
							isCorrect = true;
						}
					}
					else
					{
						// Il responsabile sul DB ha la data fine
						if (DateUtil.checkDateOrder(risultatoRicResponsabile.getDataRespAl(), dataInizio, false))
						{
							isCorrect = true;
						}
						else if (DateUtil.checkDateOrder(dataFine, risultatoRicResponsabile.getDataRespDal(), false))
						{
							// Vuol dire che o la data inizio o la data fine non e' precedente alla data inizio del responsabile sul DB (visto che non ha la data fine questo non e' ammesso)
							isCorrect = true;
						}

					}

					if (!isCorrect)
					{
						throw new ValidationManagerException(new Message(Messages.S057));
					}
				}

			}
		}


		// devo verificare che 		per quel codice impianto e l'idImpRuoloPfPg (riga selezionata)
		// vado a ricercare r_allegato_compxx se c'e' quel idPfP...e cod impianto
		// li prendo tutti, prendo la data piu' bassa e la data maggiore della data controllo
		if (GenericUtil.isNotNullOrEmpty(responsabile.getIdImpResp()))
		{
			// Sono in modifica
			List<SigitVAllegatiComponentiDto> listAllegati = getDbMgr().cercaAllegatiByFilterAttivoByCodImpianto(codImp, responsabile.getIdImpResp());

			if (listAllegati != null && listAllegati.size() > 0)
			{
				// prendo la data piu' bassa e la data maggiore della data controllo

				// devo verificare che la data inizio sia precedente alla prima data rapporto, e che (l'eventuale) data fine sia successiva all'ultima data rapporto

				if (!DateUtil.checkDateOrder(dataInizio, ConvertUtil.convertToString(listAllegati.get(0).getDataControllo()), true) ||
						!DateUtil.checkDateOrderIsPresents(ConvertUtil.convertToString(listAllegati.get(listAllegati.size()-1).getDataControllo()), dataFine, true))
				{
					throw new ValidationManagerException(new Message(Messages.S162));
				}
			}

			// devo verificare che la data inizio resp deve essere precente o uguale alla data inizio contratto min
			// e data fine resp deve essere successiva o uguale alla data inizio contratto max
			// ATTENZIONE: potenziale baco, quando lo stesso responsabile presente piu' volte nell r_imp_ruolo_pfpg e contratti di terza resp dichiarati piu' volte temporalmente

			//SigitRImpRuoloPfpgDto impRuoloPfpg = getDbMgr().cercaSigitRImpRuoloPfpgById(ConvertUtil.convertToBigDecimal(responsabile.getIdImpResp()));

			if (responsabile.getIdImpResp() != null)
			{

				List<SigitTContratto2019Dto> listaContratti = getDbMgr().cercaContrattiByImpRuoloPfpg(codImp, responsabile.getIdImpResp());

				if (listaContratti != null && listaContratti.size() > 0)
				{
					if (!DateUtil.checkDateOrder(dataInizio, ConvertUtil.convertToString(listaContratti.get(0).getDataInizio()), true) ||
							!DateUtil.checkDateOrderIsPresents(ConvertUtil.convertToString(listaContratti.get(listaContratti.size()-1).getDataInizio()), dataFine, true))
					{
						throw new ValidationManagerException(new Message(Messages.S092));
					}
				}

			}
		}




		// devo verificare che la data inizio sia <= alla data fine responsabilita' appena modificata
		// devo verificare che la data inizio sia <= alla data inizio responsabilita' appena modificata
		/*
		List<SigitVRicerca3ResponsabileDto> list3Resp = getDbMgr().cerca3ResponsabileByPfPgDataFine(responsabile.getIdResponsabile(), codImp, responsabile.getFlgImpresa(), dataInizio, dataFine);
		if (list3Resp != null && list3Resp.size() > 0)
		{
			throw new ValidationManagerException(new Message(Messages.S092));
		}
		*/
					/*
		if (GenericUtil.isNotNullOrEmpty(responsabile.getIdResponsabile()) && GenericUtil.isNotNullOrEmpty(dataFine))
		{
			// devo verificare che la data inizio sia <= alla data fine responsabilita' appena modificata

			List<SigitVRicerca3ResponsabileDto> list3Resp = getDbMgr().cerca3ResponsabileByPfPgDataFine(responsabile.getIdResponsabile(), codImp, responsabile.getFlgImpresa(), dataInizio, dataFine);
			if (list3Resp != null && list3Resp.size() > 0)
			{
				throw new ValidationManagerException(new Message(Messages.S092));
			}

		}
		*/



	}

	/**
	 * Verifica che le date del resposnabile non si accavallino con le date dei responsabili gia' presenti
	 *
	 * @param responsabile Resonsabile da verificare
	 * @throws ValidationManagerException C'e' un'incongruenza nelle date
	 */
	public void verificaDateResponsabile(Responsabile responsabile, String codImp) throws ManagerException {

		//boolean dataFineEmpty = GenericUtil.isNullOrEmpty(responsabile.getDataFineResp());

		String dataInizio = responsabile.getDataInizioResp();

		String dataFine = responsabile.getDataFineResp();

		// devo verificare che 		per quel codice impianto e l'idImpRuoloPfPg (riga selezionata)
		// vado a ricercare r_allegato_compxx se c'e' quel idPfP...e cod impianto
		// li prendo tutti, prendo la data piu' bassa e la data maggiore della data controllo
		if (GenericUtil.isNotNullOrEmpty(responsabile.getIdImpResp()))
		{
			// Sono in modifica
			List<SigitVAllegatiComponentiDto> listAllegati = getDbMgr().cercaAllegatiByFilterAttivoByCodImpianto(codImp, responsabile.getIdImpResp());

			if (listAllegati != null && listAllegati.size() > 0)
			{
				// prendo la data piu' bassa e la data maggiore della data controllo

				// devo verificare che la data inizio sia precedente alla prima data rapporto, e che (l'eventuale) data fine sia successiva all'ultima data rapporto

				if (!DateUtil.checkDateOrder(dataInizio, ConvertUtil.convertToString(listAllegati.get(0).getDataControllo()), true) ||
						!DateUtil.checkDateOrderIsPresents(ConvertUtil.convertToString(listAllegati.get(listAllegati.size()-1).getDataControllo()), dataFine, true))
				{
					throw new ValidationManagerException(new Message(Messages.S162));
				}
			}

			// devo verificare che la data inizio resp deve essere precente o uguale alla data inizio contratto min
			// e data fine resp deve essere successiva o uguale alla data inizio contratto max
			// ATTENZIONE: potenziale baco, quando lo stesso responsabile presente piu' volte nell r_imp_ruolo_pfpg e contratti di terza resp dichiarati piu' volte temporalmente

			//SigitRImpRuoloPfpgDto impRuoloPfpg = getDbMgr().cercaSigitRImpRuoloPfpgById(ConvertUtil.convertToBigDecimal(responsabile.getIdImpResp()));

			if (responsabile.getIdImpResp() != null)
			{

				List<SigitTContratto2019Dto> listaContratti = getDbMgr().cercaContrattiByImpRuoloPfpg(codImp, responsabile.getIdImpResp());

				if (listaContratti != null && listaContratti.size() > 0)
				{
					if (!DateUtil.checkDateOrder(dataInizio, ConvertUtil.convertToString(listaContratti.get(0).getDataInizio()), true) ||
							!DateUtil.checkDateOrderIsPresents(ConvertUtil.convertToString(listaContratti.get(listaContratti.size()-1).getDataInizio()), dataFine, true))
					{
						throw new ValidationManagerException(new Message(Messages.S092));
					}
				}

			}
		}
	}

	public void validazioneFormaleInserimentoSanzione(DatiInserimentoSanzione dto) throws ValidationManagerException {
		log.debug("[ValidationMgr::validazioneFormaleInserimentoSanzione] BEGIN");
		preparaToValidate(dto);

		ValidationManagerException ex = new ValidationManagerException();

		if (log.isDebugEnabled())
			GenericUtil.stampa(dto, true, 3);


		// se l'id sanzione e' valorizzato devo verificare che l'utente abbia indicato motivo e valore sanzione
		if (dto.getIdSanzione() != null) {

			if (GenericUtil.isNullOrEmpty(dto.getMotivoSanzione())) {
				ex.addFieldRequired(CPBECpInserisciNotificaSanzione.APPDATA_DATIINSERIMENTOSANZIONE_CODE+".motivoSanzione");
			}

			if (GenericUtil.isNullOrEmpty(dto.getValore())) {
				ex.addFieldRequired(CPBECpInserisciNotificaSanzione.APPDATA_DATIINSERIMENTOSANZIONE_CODE+".valore");
			}
		}

		if (dto.getFlgEnteImpresa() == null) {
			ex.addFieldRequired(CPBECpInserisciNotificaSanzione.APPDATA_DATIINSERIMENTOSANZIONE_CODE+".flgEnteImpresa");
		}

		if (GenericUtil.isNullOrEmpty(dto.getCodiceFiscale())) {
			ex.addFieldRequired(CPBECpInserisciNotificaSanzione.APPDATA_DATIINSERIMENTOSANZIONE_CODE+".codiceFiscale");
		}

		if (GenericUtil.isNullOrEmpty(dto.getDenominazione())) {
			ex.addFieldRequired(CPBECpInserisciNotificaSanzione.APPDATA_DATIINSERIMENTOSANZIONE_CODE+".denominazione");
		}

		if (dto.getFlgIndirizzoEstero() == null) {
			ex.addFieldRequired(CPBECpInserisciNotificaSanzione.APPDATA_DATIINSERIMENTOSANZIONE_CODE+".flgIndirizzoEstero");
		} else if (dto.getFlgIndirizzoEstero()) {
			//controlli sui dati dell'indirizzo estero
			if (GenericUtil.isNullOrEmpty(dto.getStatoEstero())) {
				ex.addFieldRequired(CPBECpInserisciNotificaSanzione.APPDATA_DATIINSERIMENTOSANZIONE_CODE+".statoEstero");
			}

			if (GenericUtil.isNullOrEmpty(dto.getComuneEstero())) {
				ex.addFieldRequired(CPBECpInserisciNotificaSanzione.APPDATA_DATIINSERIMENTOSANZIONE_CODE+".comuneEstero");
			}

			if (GenericUtil.isNullOrEmpty(dto.getIndirizzoEstero())) {
				ex.addFieldRequired(CPBECpInserisciNotificaSanzione.APPDATA_DATIINSERIMENTOSANZIONE_CODE+".indirizzoEstero");
			}

			if (GenericUtil.isNullOrEmpty(dto.getCivicoEstero())) {
				ex.addFieldRequired(CPBECpInserisciNotificaSanzione.APPDATA_DATIINSERIMENTOSANZIONE_CODE+".civicoEstero");
			}

			if (GenericUtil.isNullOrEmpty(dto.getCapEstero())) {
				ex.addFieldRequired(CPBECpInserisciNotificaSanzione.APPDATA_DATIINSERIMENTOSANZIONE_CODE+".capEstero");
			}

		} else {
			if (GenericUtil.isNullOrEmpty(dto.getIdProvincia())) {
				ex.addFieldRequired(CPBECpInserisciNotificaSanzione.APPDATA_DATIINSERIMENTOSANZIONE_CODE+".idProvincia");
			}

			if (GenericUtil.isNullOrEmpty(dto.getIdComune())) {
				ex.addFieldRequired(CPBECpInserisciNotificaSanzione.APPDATA_DATIINSERIMENTOSANZIONE_CODE+".idComune");
			}

			if (GenericUtil.isNullOrEmpty(dto.getIdIndirizzo()) && GenericUtil.isNullOrEmpty(dto.getIndirizzoNoStradario())) {
				ex.addFieldRequired(CPBECpInserisciNotificaSanzione.APPDATA_DATIINSERIMENTOSANZIONE_CODE+".idIndirizzo");
				ex.addFieldRequired(CPBECpInserisciNotificaSanzione.APPDATA_DATIINSERIMENTOSANZIONE_CODE+".indirizzoNoStradario");
			}
		}

		//validazione dei campi stringa
		checkAsciiStringMaxLength(dto.getNote(), 1000, CPBECpInserisciNotificaSanzione.APPDATA_DATIINSERIMENTOSANZIONE_CODE + ".note", ex);
		checkAsciiStringMaxLength(dto.getMotivoSanzione(), 1000, CPBECpInserisciNotificaSanzione.APPDATA_DATIINSERIMENTOSANZIONE_CODE + ".motivoSanzione", ex);

		//validazione valore
		checkNumero(dto.getValore(), CPBECpInserisciNotificaSanzione.APPDATA_DATIINSERIMENTOSANZIONE_CODE + ".valore", 7, 2, ex, true);

		if(!ex.getFieldList().isEmpty()){
			throw ex;
		}

	}


	public void verificaRicercaIndirizzoSanzionato(DatiInserimentoSanzione dto) throws ValidationManagerException {
		log.debug("[ValidationMgr::verificaRicercaIndirizzoSanzionato] BEGIN");
		checkRicercaIndirizzo(dto.getIdComune(), dto.getIdProvincia(),
				CPBECpInserisciNotificaSanzione.APPDATA_DATIINSERIMENTOSANZIONE_CODE+".idComune", CPBECpInserisciNotificaSanzione.APPDATA_DATIINSERIMENTOSANZIONE_CODE+".idProvincia");

		if (GenericUtil.isNullOrEmpty(dto.getIndirizzo()))
		{
			ValidationManagerException ex =  new ValidationManagerException();
			ex.addFieldRequired(CPBECpInserisciNotificaSanzione.APPDATA_DATIINSERIMENTOSANZIONE_CODE + ".indirizzo");
			throw ex;
		}

		checkAlphanumericStringMinLenght(dto.getIndirizzo(), Constants.MIN_INDIRIZZO_LEN, CPBECpInserisciNotificaSanzione.APPDATA_DATIINSERIMENTOSANZIONE_CODE + ".indirizzo");
		log.debug("[ValidationMgr::verificaRicercaIndirizzoSanzionato] END");
	}

	public void verificaRicercaSanzionata(DatiInserimentoSanzione dto) throws ManagerException {
		log.debug("[ValidationMgr::verificaRicercaSanzionata] BEGIN");

		boolean flgImpresaEmpty = GenericUtil.isNullOrEmpty(dto.getFlgEnteImpresa());

		log.debug("Stampo flgImpresaEmpty: "+flgImpresaEmpty);

		if (flgImpresaEmpty)
		{
			ValidationManagerException ex = new ValidationManagerException(new Message(Messages.ERROR_IS_IMPRESA_MANCANTE));
			ex.addFieldRequired(CPBECpInserisciNotificaSanzione.APPDATA_DATIINSERIMENTOSANZIONE_CODE+".flgEnteImpresa");
			throw ex;

		}

		boolean codiceFiscaleEmpty = GenericUtil.isNullOrEmpty(dto.getCodiceFiscale());
		boolean denominazioneEmpty = GenericUtil.isNullOrEmpty(dto.getDenominazione());

		if (!codiceFiscaleEmpty)
		{
			if (dto.getFlgEnteImpresa())
			{
				checkCodiceFiscalePartitaIva(dto.getCodiceFiscale(), CPBECpInserisciNotificaSanzione.APPDATA_DATIINSERIMENTOSANZIONE_CODE+".codiceFiscale");
			}
			else
			{
				controlloCf(dto.getCodiceFiscale(), CPBECpInserisciNotificaSanzione.APPDATA_DATIINSERIMENTOSANZIONE_CODE+".codiceFiscale");
			}
		}

		if (codiceFiscaleEmpty && denominazioneEmpty)
		{
			throw new ValidationManagerException(new Message(Messages.ERROR_DENOMINAZIONE_CF_MANCANTE));
		}
	}

	public void verificaRicercaResponsabile(Responsabile dto) throws ManagerException {
		log.debug("[ValidationMgr::verificaRicercaResponsabile] BEGIN");

		//ValidationManagerException ex;
		boolean flgImpresaEmpty = GenericUtil.isNullOrEmpty(dto.getFlgImpresa());

		log.debug("Stampo flgImpresaEmpty: "+flgImpresaEmpty);

		if (flgImpresaEmpty)
		{
			ValidationManagerException ex = new ValidationManagerException(new Message(Messages.ERROR_IS_IMPRESA_MANCANTE));
			ex.addFieldRequired(ConstantsField.GESTISCI_RESPONSABILE_FLG_IMPRESA);
			throw ex;
		}

		boolean codiceFiscaleEmpty = GenericUtil.isNullOrEmpty(dto.getCodiceFiscale());
		boolean denominazioneEmpty = GenericUtil.isNullOrEmpty(dto.getCognome());

		log.debug("Stampo codiceFiscaleEmpty: "+codiceFiscaleEmpty);
		log.debug("Stampo denominazioneEmpty: "+denominazioneEmpty);


		boolean siglaReaEmpty = GenericUtil.isNullOrEmpty(dto.getIdSiglaRea());
		boolean numeroReaEmpty = GenericUtil.isNullOrEmpty(dto.getNumeroRea());

		log.debug("Stampo siglaReaEmpty: "+siglaReaEmpty);
		log.debug("Stampo numeroReaEmpty: "+numeroReaEmpty);

		checkSiglaAndNumeroRea(dto.getIdSiglaRea(), dto.getNumeroRea(), ConstantsField.GESTISCI_RESPONSABILE_ID_SIGLA_REA, ConstantsField.GESTISCI_RESPONSABILE_NUMERO_REA);

		boolean codReaEmpty = siglaReaEmpty && numeroReaEmpty;

		log.debug("Stampo codReaEmpty: "+codReaEmpty);

		if (!codiceFiscaleEmpty)
		{
			if (dto.getFlgImpresa())
			{
				checkCodiceFiscalePartitaIva(dto.getCodiceFiscale(), ConstantsField.GESTISCI_RESPONSABILE_CF);
			}
			else
			{
				controlloCf(dto.getCodiceFiscale(), ConstantsField.GESTISCI_RESPONSABILE_CF);
			}
		}

		if (codiceFiscaleEmpty && denominazioneEmpty && codReaEmpty)
		{
			if (dto.getFlgImpresa())
			{
				throw new ValidationManagerException(new Message(Messages.ERROR_CODICE_REA_DENOMINAZIONE_CF_MANCANTE));
			}
			else
			{
				throw new ValidationManagerException(new Message(Messages.ERROR_DENOMINAZIONE_CF_MANCANTE));
			}

		}


		log.debug("[ValidationMgr::verificaRicercaResponsabile] END");
	}

	public void verificaRicercaImpresa(RicercaImprese ricImpresa) throws ManagerException {
		log.debug("[ValidationMgr::verificaRicercaImpresa] BEGIN");


		boolean codiceFiscaleEmpty = GenericUtil.isNullOrEmpty(ricImpresa.getCodiceFiscale());
		boolean denominazioneEmpty = GenericUtil.isNullOrEmpty(ricImpresa.getDenominazione());
		boolean siglaReaEmpty = GenericUtil.isNullOrEmpty(ricImpresa.getSiglaRea());
		boolean numeroReaEmpty = GenericUtil.isNullOrEmpty(ricImpresa.getNumeroRea());

		boolean ruoloEmpty = GenericUtil.isNullOrEmpty(ricImpresa.getDescRuolo());
		boolean idStatoPgEmpty = GenericUtil.isNullOrEmpty(ricImpresa.getIdStatoPg());

		log.debug("Stampo codiceFiscaleEmpty: "+codiceFiscaleEmpty);
		log.debug("Stampo denominazioneEmpty: "+denominazioneEmpty);
		log.debug("Stampo siglaReaEmpty: "+siglaReaEmpty);
		log.debug("Stampo numeroReaEmpty: "+numeroReaEmpty);
		log.debug("Stampo ruoloEmpty: "+ruoloEmpty);
		log.debug("Stampo idStatoPgEmpty: "+idStatoPgEmpty);

		if (codiceFiscaleEmpty && denominazioneEmpty && siglaReaEmpty && numeroReaEmpty && ruoloEmpty && idStatoPgEmpty)
		{
			throw new ValidationManagerException(new Message(Messages.S010));
		}

		if (!siglaReaEmpty)
		{
			checkAlphanumericStringMaxLenght(ricImpresa.getSiglaRea(), 2, ConstantsField.GESTISCI_IMPRESA_RIC_SIGLA_REA);
		}

		if (!numeroReaEmpty)
		{
			checkAlphanumericStringMaxLenght(ConvertUtil.convertToString(ricImpresa.getNumeroRea()), 15, ConstantsField.GESTISCI_IMPRESA_RIC_NUMERO_REA);
		}



//		if (!codiceReaEmpty)
//		{
//			checkSiglaAndNumeroRea(ricImpresa.getSiglaRea(), ricImpresa.getNumeroRea(), ConstantsField.GESTISCI_IMPRESA_RIC_SIGLA_REA, ConstantsField.GESTISCI_IMPRESA_RIC_NUMERO_REA);
//		}

		if (!codiceFiscaleEmpty)
		{

				checkCodiceFiscalePartitaIva(ricImpresa.getCodiceFiscale(), ConstantsField.GESTISCI_IMPRESA_RIC_CF);

		}

		if (!denominazioneEmpty)
		{
			checkAlphanumericStringMinLenght(ricImpresa.getDenominazione(), Constants.MIN_DENOMINAZIONE_LEN, ConstantsField.GESTISCI_IMPRESA_RIC_DENOMINAZIONE);
		}

		log.debug("[ValidationMgr::verificaRicercaImpresa] END");
	}

	public void verificaRicercaImpresaScheda4(RicercaImprese ricImpresa) throws ManagerException {


		log.debug("[ValidationMgr::verificaRicercaImpresaScheda4] BEGIN");

		preparaToValidate(ricImpresa);

		//verifica sulla presenza di almeno un criterio di ricerca
		if (	!GenericUtil.isObjPopulate(ricImpresa) ){
			// Non e' stato impostato nessun paramentro
			throw new ValidationManagerException(new Message(Messages.S010));
		}

		// Se e' stato inserita la sigla REA deve essere compilato anche il
		// numero REA e viceversa
		checkSiglaAndNumeroRea(ricImpresa.getSiglaRea(), ricImpresa.getNumeroRea(), CPBECpGestLibScheda4Impresa.APPDATA_RICERCAIMPRESE_CODE + ".siglaRea",
				CPBECpGestLibScheda4Impresa.APPDATA_RICERCAIMPRESE_CODE + ".numeroRea");

		checkCodiceFiscalePartitaIva(ricImpresa.getCodiceFiscale(), CPBECpGestLibScheda4Impresa.APPDATA_RICERCAIMPRESE_CODE + ".codiceFiscale");


		log.debug("[ValidationMgr::verificaRicercaImpresaScheda4] END");
	}

	public void verificaRicercaDelegatiPotenziali(Delegato dto) throws ManagerException {
		log.debug("[ValidationMgr::verificaRicercaDelegatiPotenziali] BEGIN");

		boolean codiceFiscaleEmpty = GenericUtil.isNullOrEmpty(dto.getCodiceFiscale());
		boolean cognomeEmpty = GenericUtil.isNullOrEmpty(dto.getCognome());

		log.debug("Stampo codiceFiscaleEmpty: "+codiceFiscaleEmpty);
		log.debug("Stampo cognomeEmpty: "+cognomeEmpty);


		if (!codiceFiscaleEmpty)
		{
			checkCodiceFiscalePartitaIva(dto.getCodiceFiscale(), ConstantsField.GESTISCI_DELEGA_CF);
		}

		if (codiceFiscaleEmpty && cognomeEmpty)
		{
			throw new ValidationManagerException(new Message(Messages.ERROR_DENOMINAZIONE_CF_MANCANTE_DELEGATO));
		}


		log.debug("[ValidationMgr::verificaRicercaDelegatiPotenziali] END");
	}

	public void verificaLibrettoControllato(String idImpianto) throws ManagerException {
		log.debug("[ValidationMgr::verificaLibrettoControllato] BEGIN");

		List<SigitTLibrettoDto> librettoList = getDbMgr().cercaLibrettoByStato(idImpianto,  Constants.ID_STATO_LIBRETTO_BOZZA);

		if (librettoList == null || librettoList.size() == 0 || librettoList.size() > 1)
		{
			throw new ValidationManagerException(new Message(Messages.ERROR_RECUPERO_SERVIZIO));
		}
		else if (!ConvertUtil.convertToBooleanAllways(librettoList.get(0).getFlgControlloBozza()))
		{
			throw new ValidationManagerException(new Message(Messages.S065));
		}


		log.debug("[ValidationMgr::verificaLibrettoControllato] END");
	}

	public void verificaLibrettoPerRapportiProva(String codiceImpianto) throws ManagerException {
		log.debug("[ValidationMgr::verificaLibrettoPerRapportiProva] BEGIN");

		try {
			//si verifica se esiste almento una versione del libretto consolidato
			SigitTLibrettoDto  librettoConsolidato = getDbMgr().cercaSigitTLibrettoConsolidatoByCodImpianto(codiceImpianto);
			if (librettoConsolidato == null) {
				throw new ValidationManagerException(new Message(Messages.S056_BIS));
			}

			/*
			try {
				// 13/11/19 Beppe - commentata questa porzione di codice
				// per renderla uniforme rispetto ai REE
				//si verifica se risultano checkati i controlli 1/5/6/7
				//SigitTControlloLibrettoDto controlloLibDto = getDbMgr().findControlloLibretto(codiceImpianto);
				//verificaControlloLibretto(codiceImpianto, controlloLibDto);


				// Questa parte l'ho spastato nella parte successiva, quando l'utente selezione le varie componenti
				// cosi' posso dire se sono state controllate solo le componenti selezionate
				//si verifica il controllo web sulle componenti di tipo GT/GF
				CompFilter filtroGTGF = new CompFilter(codiceImpianto);
				filtroGTGF.setCheckControllate(Boolean.TRUE);
				filtroGTGF.setListTipiComponente(Arrays.asList(Constants.TIPO_COMPONENTE_GF, Constants.TIPO_COMPONENTE_GT));

				List<SigitTComp4Dto> componentiControllate = null;
				try {
					componentiControllate = getDbMgr().getSigitTComp4Dao().findByFilter(filtroGTGF);
				} catch (SigitTComp4DaoException e) {
					throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
				}

				if (componentiControllate == null || componentiControllate.isEmpty()) {
					throw new ValidationManagerException(new Message(Messages.ERROR_LIBRETTO_NON_CONTROLLATO));
				}
			} catch ( ValidationManagerException err1) {
				throw new ValidationManagerException(new Message(Messages.ERROR_LIBRETTO_NON_CONTROLLATO_RAP_PROVA));
			}
			*/

//			List<SigitTComp4Dto> compNonControllate = getDbMgr().cercaTComp4NonControllateByCodImp(codiceImpianto);
//			if (compNonControllate != null && compNonControllate.size() > 0)
//			{
//				String elencoComp = GenericUtil.getDescComponentiNonComp(compNonControllate);
//				throw new ValidationManagerException(new Message(Messages.ERROR_LIBRETTO_NON_CONTROLLATO_RAP_PROVA + Messages.ERROR_LIBRETTO_COMP_NON_CONTROLLATE, elencoComp));
//			}

			//verifica presenza responsabili attivi
			List<SigitVTotImpiantoDto> listaResponsabiliAttivi = getDbMgr().cercaResponsabiliAttiviAllaDataByCodImpianto(codiceImpianto, DateUtil.getDataCorrenteFormat());
			if (listaResponsabiliAttivi == null || listaResponsabiliAttivi.isEmpty()) {
				throw new ValidationManagerException(new Message(Messages.ERROR_NO_RESP_ATTIVO_RAP_PROVA));

			}

			if (!isImpiantoTipoImpiantoValorizzato(ConvertUtil.convertToBigDecimal(codiceImpianto))) {
					log.debug("Dati impianto non aggiornati");
					throw new ValidationManagerException(new Message(Messages.S158));
			}


		} finally
		{
			log.debug("[ValidationMgr::verificaLibrettoPerRapportiProva] END");
		}
	}

	private void verificaControlloLibretto (String codiceImpianto, SigitTControlloLibrettoDto controlloLibDto) throws ManagerException {

		if (controlloLibDto == null ||
				!ConvertUtil.convertToBooleanAllways(controlloLibDto.getFlgL1Controlloweb()) ||
				!ConvertUtil.convertToBooleanAllways(controlloLibDto.getFlgL5Controlloweb()) ||
				!ConvertUtil.convertToBooleanAllways(controlloLibDto.getFlgL6Controlloweb()) ||
				!ConvertUtil.convertToBooleanAllways(controlloLibDto.getFlgL7Controlloweb())) {
			throw new ValidationManagerException(new Message(Messages.ERROR_LIBRETTO_NON_CONTROLLATO));
		}

	}

	public void verificaLibrettoWeb(String codiceImpianto) throws ManagerException {
		log.debug("[ValidationMgr::verificaLibrettoWeb] BEGIN");

		try
		{
			verificaControlloLibretto(codiceImpianto, getDbMgr().findControlloLibretto(codiceImpianto));

			List<SigitTComp4Dto> compNonControllate = getDbMgr().cercaTComp4NonControllateByCodImp(codiceImpianto);

			if (compNonControllate != null && compNonControllate.size() > 0)
			{
				String elencoComp = GenericUtil.getDescComponentiNonComp(compNonControllate);
				throw new ValidationManagerException(new Message(Messages.ERROR_LIBRETTO_COMP_NON_CONTROLLATE, elencoComp));
			}
			//  Controllare che tutte le compoenti di questo impianto su SigitTComp4Dto
			// where codice_impianto =
			// abbiano la dt_controlloweb valorizzata, altrimenti Messages.ERROR_LIBRETTO_NON_CONTROLLATO
			// Da ggiungere su "Aggiornamenti libretto" l'elenco delle componenti non validati:
			// Aggiungere: Componenti scheda 4 non validati: 'GT-1, GF2, ecc'
		}

		finally
		{
			log.debug("[ValidationMgr::verificaLibrettoWeb] END");
		}
	}

	/*
	public void verificaCodiceImpianto(Impianto dto) throws ManagerException {

		log.debug("[ValidationMgr::verificaCodiceImpiantoIdentificazione] BEGIN");
		try {
			//dto = MapDto.mapToIdentificazioneInfo(dto);
			verificaCodiceImpiantoIdentificazione(dto);

		}
		finally {
			log.debug("[ValidationMgr::verificaCodiceImpiantoIdentificazione] END");
		}
	}
	*/

	/**
	 * Verifica la validita' dell'inserimento dell'identificazione di un impianto
	 *
	 * @param identificazioneInfo Informazioni sull'identificazione di un
	 *            impianto
	 * @throws ValidationManagerException L'inserimento non e' valido
	 */
	public void verificaCodiceImpiantoIdentificazione(String codImpianto) throws ValidationManagerException {
		log.debug("[ValidationMgr::verificaCodiceImpiantoIdentificazione] BEGIN");

		ValidationManagerException ex = null;

		/*
		if(impianto != null) {

			if (GenericUtil.isNotNullOrEmpty(impianto.getInstId())) {

				boolean codiceImpiantoEmpty = GenericUtil.isNullOrEmpty(impianto.getImpCodImpianto());
				if(codiceImpiantoEmpty) {

					ex = new ValidationManagerException(new Message(Messages.ERROR_CAMPO_ABBIGATORIO));

					if(codiceImpiantoEmpty) {
						ex.addField(ConstantsField.GESTISCI_IMPIANTO_COD_IMP);
					}

					throw ex;

				}

				// Controlli formali

				checkNumeroIntero(impianto.getImpCodImpianto().toString(), ConstantsField.GESTISCI_IMPIANTO_COD_IMP, Constants.MAX_CODICE_IMPIANTO_LEN);

				verificaInserimentoCodiceImpianto(impianto);
			}
			else
			{
				throw new ValidationManagerException(new Message(Messages.ERROR_INSTALLATORE_OBBLIGATORIO));
			}
		}
		*/

		if(codImpianto != null) {


			checkNumeroIntero(codImpianto, ConstantsField.GESTISCI_IMPIANTO_COD_IMP, Constants.MAX_CODICE_IMPIANTO_LEN);

			verificaInserimentoCodiceImpianto(codImpianto);
		}



		log.debug("[ValidationMgr::verificaCodiceImpiantoIdentificazione] END");
	}

	/**
	 * Verifica la validita' dell'inserimento dell'identificazione di un impianto (responsabile)
	 *
	 * @param identificazioneInfo Informazioni sull'identificazione di un
	 *            impianto
	 * @throws ValidationManagerException L'inserimento non e' valido
	 */
	public void verificaCodiceImpiantoIdentificazioneResp(Impianto impianto) throws ValidationManagerException {
		log.debug("[ValidationMgr::verificaCodiceImpiantoIdentificazioneResp] BEGIN");
		//validazioneFormaleImpiantoIdentificazione(identificazioneInfo, true, null, null, null, null, null);

		ValidationManagerException ex = null;
		if(impianto != null) {

			boolean codiceImpiantoEmpty = GenericUtil.isNullOrEmpty(impianto.getImpCodImpianto());

			// Campi obbligatori
			if(codiceImpiantoEmpty) {

				ex = new ValidationManagerException(new Message(Messages.ERROR_CAMPO_ABBIGATORIO));

				if(codiceImpiantoEmpty) {
					// ex.addField(fieldIndirizzo);
					ex.addField(ConstantsField.GESTISCI_IMPIANTO_COD_IMP);

					//ex.addField(IMPIANTI_IDENTIFICAZIONE_CODICE_IMPIANTO);
				}

				//log.error("CAMPI OBBLIGATORI MANCANTI: "+ex.getFieldList());
				//ex.setMsg(message);
				throw ex;

			}
			// Controlli formali

			checkNumeroIntero(impianto.getImpCodImpianto().toString(), ConstantsField.GESTISCI_IMPIANTO_COD_IMP, Constants.MAX_CODICE_IMPIANTO_LEN);

			//verificaInserimentoCodiceImpianto(impianto);

//			List<SigitTCodiceImpByCodiceImpiantoDto> codiceList = null;
			ValidationManagerException validationException = null;
//			Message m = null;


			// Sicuramente ce ne solo 1
			//SigitTCodiceImpByCodiceImpiantoDto codice = codiceList.get(0);

			try
			{
				if(getDbMgr().cercaImpiantoDtoById(impianto.getImpCodImpianto()) != null) {
					validationException = new ValidationManagerException(new Message(Messages.S024));
					validationException.addField(ConstantsField.GESTISCI_IMPIANTO_COD_IMP);
					throw validationException;
				}


			}
			catch(DbManagerException e) {
				throw new ValidationManagerException(e, e.getMsg());
			}


		}

		log.debug("[ValidationMgr::verificaCodiceImpiantoIdentificazioneResp] END");
	}

	/**
	 * Verifica la validita' dei dati dell'impresa per il subentro
	 *
	 * @param subentro Informazioni del subentro
	 *
	 * @throws ValidationManagerException La verifica non e' valida
	 */
	public String verificaImpiantoSubentro(Subentro subentro, String descRuolo) throws ValidationManagerException {
		log.debug("[ValidationMgr::verificaImpiantoSubentro] BEGIN");

		String msgOK = null;

		ValidationManagerException ex = new ValidationManagerException();

		try
		{

			if (GenericUtil.isNullOrEmpty(subentro.getImpCodImpianto()))
			{
				ex.addFieldRequired(ConstantsField.GESTISCI_SUBENTRO_COD_IMP);
			}

			if (GenericUtil.isNullOrEmpty(subentro.getImpLocIdIndirizzo()) && GenericUtil.isNullOrEmpty(subentro.getImpLocIndirizzoNoStrad())) {
				ex.addFieldRequired(ConstantsField.GESTISCI_SUBENTRO_LOC_INDIRIZZO);
				ex.addFieldRequired(ConstantsField.GESTISCI_SUBENTRO_LOC_ID_INDIRIZZO);
				ex.addFieldRequired(ConstantsField.GESTISCI_SUBENTRO_LOC_INDIRIZZO_NON_TROVATO);
			}

			if (ex.getFieldList().size() > 0)
			{
				//ex.setMsg(message);
				throw ex;
			}

			checkNumeroIntero(subentro.getImpCodImpianto().toString(), ConstantsField.GESTISCI_SUBENTRO_COD_IMP, Constants.MAX_CODICE_IMPIANTO_LEN);


			if (getDbMgr().cercaImpiantoDtoById(subentro.getImpCodImpianto()) == null)
			{

//				if (getDbMgr().cercaSigitTCodiceImpById(ConvertUtil.convertToBigDecimal(subentro.getImpCodImpianto())) == null)
//				{
//					throw new ValidationManagerException(new Message(Messages.S077));
//				}
//				else
//				{
					if (descRuolo.equalsIgnoreCase(Constants.RUOLO_SUPER) ||
							descRuolo.equalsIgnoreCase(Constants.RUOLO_VALIDATORE) ||
							descRuolo.equalsIgnoreCase(Constants.RUOLO_IMPRESA))
					{
						msgOK = Messages.INFO_COD_IMPIANTO_VERIFICATO_NON_USATO;
					}
					else
					{
						throw new ValidationManagerException(new Message(Messages.S070));
					}
//				}
//
//				if (descRuolo.equalsIgnoreCase(Constants.RUOLO_SUPER) ||
//						descRuolo.equalsIgnoreCase(Constants.RUOLO_VALIDATORE) ||
//						descRuolo.equalsIgnoreCase(Constants.RUOLO_INSTALLATORE) ||
//						descRuolo.equalsIgnoreCase(Constants.RUOLO_MANUTENTORE))
//				{
//
//					if (getDbMgr().cercaSigitTCodiceImpById(ConvertUtil.convertToBigDecimal(subentro.getImpCodImpianto())) == null)
//					{
//						throw new ValidationManagerException(new Message(Messages.S077));
//					}
//					else
//					{
//						msgOK = Messages.INFO_COD_IMPIANTO_VERIFICATO_NON_USATO;
//					}
//				}
//				else
//				{
//					throw new ValidationManagerException(new Message(Messages.S070));
//				}

			}
			else
			{
				List<SigitTUnitaImmobiliareDto> unitaImmobiliareDtoList = getDbMgr().cercaSigitTUnitaImmobiliareByFiltro(subentro);

				if (unitaImmobiliareDtoList == null || unitaImmobiliareDtoList.size() == 0)
				{
					throw new ValidationManagerException(new Message(Messages.S070));
				}
				else if (unitaImmobiliareDtoList.size() > 1)
				{
					throw new ValidationManagerException(new Message(Messages.S071));
				}
				else
				{
					msgOK = Messages.INFO_COD_IMPIANTO_VERIFICATO;
				}

			}
		}
		catch(DbManagerException e) {
			throw new ValidationManagerException(e, e.getMsg());
		}

		log.debug("[ValidationMgr::verificaImpiantoSubentro] END");

		return msgOK;
	}

	public String verificaImpianto3Responsabile(TerzoResponsabile terzoResponsabile, String descRuolo) throws ValidationManagerException {
		log.debug("[ValidationMgr::verificaImpianto3Responsabile] BEGIN");

		String msgOK = null;
		ValidationManagerException ex = new ValidationManagerException();

		try
		{
			if (GenericUtil.isNullOrEmpty(terzoResponsabile.getImpCodImpianto()))
			{
				ex.addFieldRequired(ConstantsField.GESTISCI_3_RESPONSABILE_COD_IMP);
			}

			if (GenericUtil.isNullOrEmpty(terzoResponsabile.getImpLocIdIndirizzo()) && GenericUtil.isNullOrEmpty(terzoResponsabile.getImpLocIndirizzoNoStrad())) {
				ex.addFieldRequired(ConstantsField.GESTISCI_3_RESPONSABILE_LOC_INDIRIZZO);
				ex.addFieldRequired(ConstantsField.GESTISCI_3_RESPONSABILE_LOC_ID_INDIRIZZO);
				ex.addFieldRequired(ConstantsField.GESTISCI_3_RESPONSABILE_LOC_INDIRIZZO_NON_TROVATO);
			}

			if (ex.getFieldList().size() > 0)
			{
				//ex.setMsg(message);
				throw ex;
			}

			checkNumeroIntero(terzoResponsabile.getImpCodImpianto().toString(), ConstantsField.GESTISCI_3_RESPONSABILE_COD_IMP, Constants.MAX_CODICE_IMPIANTO_LEN);

			SigitTImpiantoDto impiantoDto = getDbMgr().cercaImpiantoDtoById(terzoResponsabile.getImpCodImpianto());

			if (impiantoDto == null)
			{
				throw new ValidationManagerException(new Message(Messages.ERROR_CODICE_IMPIANTO_NON_ESISTE));
			}
			else
			{
				terzoResponsabile.setImpFlgBloccoNomina(ConvertUtil.convertToBooleanAllways(impiantoDto.getFlgBloccoNomina3r()));

				List<SigitTUnitaImmobiliareDto> unitaImmobiliareDtoList = getDbMgr().cercaSigitTUnitaImmobiliareByFiltro(terzoResponsabile);

				if (unitaImmobiliareDtoList == null || unitaImmobiliareDtoList.size() == 0)
				{
					throw new ValidationManagerException(new Message(Messages.S070));
				}
				else if (unitaImmobiliareDtoList.size() > 1)
				{
					throw new ValidationManagerException(new Message(Messages.S071));
				}
				else
				{
					log.debug("Impianto trovato all'indirizzo specificato");
					terzoResponsabile.setImpLocCivico(unitaImmobiliareDtoList.get(0).getCivico());
					msgOK = Messages.INFO_COD_IMPIANTO_VERIFICATO;
				}
			}
		}
		catch(DbManagerException e) {
			throw new ValidationManagerException(e, e.getMsg());
		}
		log.debug("[ValidationMgr::verificaImpianto3Responsabile] END");
		return msgOK;
	}

	/**
	 * Verifica che esite il codice impianto nella tabella sigit_t_codice_imp
	 *
	 * @param subentro Informazioni del subentro
	 *
	 * @throws ValidationManagerException La verifica non e' valida
	 */
	/*
	public boolean verificaCodImpiantoPresente(Subentro subentro, String descRuolo) throws ValidationManagerException {
		log.debug("[ValidationMgr::verificaCodImpiantoPresente] BEGIN");

		boolean isPresente = false;
		ValidationManagerException ex = new ValidationManagerException();

		try
		{

			// Algoritmo A014_4 passo 4 e 5
			if ((descRuolo.equalsIgnoreCase(Constants.RUOLO_SUPER) ||
					descRuolo.equalsIgnoreCase(Constants.RUOLO_VALIDATORE) ||
					descRuolo.equalsIgnoreCase(Constants.RUOLO_INSTALLATORE) ||
					descRuolo.equalsIgnoreCase(Constants.RUOLO_MANUTENTORE)) &&
					(getDbMgr().cercaImpiantoDtoById(subentro.getImpCodImpianto()) != null))
			{
						isPresente = true;
			}

		}
		catch(DbManagerException e) {
			throw new ValidationManagerException(e, e.getMsg());
		}

		log.debug("[ValidationMgr::verificaCodImpiantoPresente] END");

		return isPresente;
	}
	*/

	/**
	 * Verifica la validita' dei dati dell'impresa per il subentro
	 *
	 * @param subentro Informazioni del subentro
	 *
	 * @throws ValidationManagerException La verifica non e' valida
	 */
	public void validazioneFormaleSubentro(Subentro subentro, String descRuolo) throws ValidationManagerException {
		log.debug("[ValidationMgr::validazioneFormaleSubentro] BEGIN");

		ValidationManagerException ex = new ValidationManagerException();

		GenericUtil.eliminaCampoVuoto(subentro.getIdApparecchiature());


//		try
//		{

			if (GenericUtil.isNullOrEmpty(subentro.getRespImpId()))
			{
				throw new ValidationManagerException(new Message(Messages.S030));
			}

			if (GenericUtil.isNullOrEmpty(subentro.getIdTipoSubentro()))
			{
				ex.addFieldRequired(ConstantsField.GESTISCI_SUBENTRO_ID_TIPO);
				throw ex;
			}
			else
			{
				if (subentro.getIdTipoSubentro().intValue() == Constants.ID_RUOLO_MANUTENTORE_ALL_1 ||
						subentro.getIdTipoSubentro().intValue() == Constants.ID_RUOLO_MANUTENTORE_ALL_2 ||
						subentro.getIdTipoSubentro().intValue() == Constants.ID_RUOLO_MANUTENTORE_ALL_3 ||
						subentro.getIdTipoSubentro().intValue() == Constants.ID_RUOLO_MANUTENTORE_ALL_4)
				{
					if (GenericUtil.isNullOrEmpty(subentro.getIdApparecchiature()) || subentro.getIdApparecchiature().size() == 0) {
						ex.addFieldRequired(ConstantsField.GESTISCI_SUBENTRO_ID_APPARECCHIATURE);
						throw ex;

					}
				}
			}

			verificaImpiantoSubentro(subentro, descRuolo);

//			SigitTImpiantoDto impianto = getDbMgr().cercaImpiantoDtoById(subentro.getImpCodImpianto());
//
//			// L'impianto esiste gia'
//			if (impianto != null)
//			{
//
//				if (descRuolo.equalsIgnoreCase(Constants.RUOLO_SUPER) ||
//						descRuolo.equalsIgnoreCase(Constants.RUOLO_VALIDATORE) ||
//						descRuolo.equalsIgnoreCase(Constants.RUOLO_IMPRESA))
//				{
//					PersonaGiuridica impresa = getDbMgr().cercaPersonaGiuridicaById(subentro.getRespImpId());
//
//					log.debug("STAMPO DATA ASSEGNAZIONE: "+impianto.getDataAssegnazione());
//					log.debug("STAMPO DATA CESSAZIONE: "+impresa.getDataCessazione());
//
//					if (!DateUtil.checkDateOrderIsPresents(ConvertUtil.convertToString(impianto.getDataAssegnazione()), impresa.getDataCessazione(), false))
//					{
//						throw new ValidationManagerException(new Message(Messages.S082,impresa.getDataCessazione()));
//					}
//				}



					/*
					if (subentro.getIdTipoSubentro().equalsIgnoreCase(Constants.RUOLO_AMMINISTRATORE) ||
							subentro.getIdTipoSubentro().equalsIgnoreCase(Constants.RUOLO_PROPRIETARIO) ||
							subentro.getIdTipoSubentro().equalsIgnoreCase(Constants.RUOLO_OCCUPANTE))
					{
						if (descRuolo.equalsIgnoreCase(Constants.RUOLO_RESPONSABILE_IMPRESA))
						{

						}
						else if (descRuolo.equalsIgnoreCase(Constants.RUOLO_RESPONSABILE))
						{

						}
					}
					else if (subentro.getIdTipoSubentro().equalsIgnoreCase(Constants.RUOLO_INSTALLATORE))
					{

					}
					else if (subentro.getIdTipoSubentro().equalsIgnoreCase(Constants.RUOLO_MANUTENTORE_ALL_1) ||
							subentro.getIdTipoSubentro().equalsIgnoreCase(Constants.RUOLO_MANUTENTORE_ALL_2) ||
							subentro.getIdTipoSubentro().equalsIgnoreCase(Constants.RUOLO_MANUTENTORE_ALL_3) ||
							subentro.getIdTipoSubentro().equalsIgnoreCase(Constants.RUOLO_MANUTENTORE_ALL_4))
					{

					}
					*/


				// BEPPE - VERIFICARE
				/*
					List<SigitRImpRuoloPfpgDto> impRuoloPfpgDtoList = null;

					if (subentro.getIdTipoSubentro().intValue() == Constants.ID_RUOLO_MANUTENTORE_ALL_1 ||
							subentro.getIdTipoSubentro().intValue() == Constants.ID_RUOLO_MANUTENTORE_ALL_2 ||
							subentro.getIdTipoSubentro().intValue() == Constants.ID_RUOLO_MANUTENTORE_ALL_3 ||
							subentro.getIdTipoSubentro().intValue() == Constants.ID_RUOLO_MANUTENTORE_ALL_4)
					{
						impRuoloPfpgDtoList = getDbMgr().cercaSigitRImpRuoloByRuoloCodImpianto(subentro.getImpCodImpianto(), subentro.getIdTipoSubentro());

						if (impRuoloPfpgDtoList == null || impRuoloPfpgDtoList.size() == 0)
						{
							throw new ValidationManagerException(new Message(Messages.S074));
						}
					}


					impRuoloPfpgDtoList = getDbMgr().cercaSigitRImpRuoloPfpgBySubentro(subentro, descRuolo);

					if (impRuoloPfpgDtoList != null && impRuoloPfpgDtoList.size() > 0)
					{
						throw new ValidationManagerException(new Message(Messages.S075));
					}
				*/
//			}
//
//		}
//		catch(DbManagerException e) {
//			throw new ValidationManagerException(e, e.getMsg());
//		}

		log.debug("[ValidationMgr::validazioneFormaleSubentro] END");
	}

	public void verificaAllegatiSysdateSubentro(Subentro subentro) throws ValidationManagerException {
		log.debug("[ValidationMgr::verificaAllegatiSysdateSubentro] BEGIN");

		//ValidationManagerException ex = new ValidationManagerException();

		//GenericUtil.eliminaCampoVuoto(subentro.getIdApparecchiature());

		try
		{

			List<SigitVAllegatiComponentiDto> dtoList = getDbMgr().cercaAllegatiCompSysdateByFilter(subentro);

			if (dtoList != null && dtoList.size() > 0)
			{
				throw new ValidationManagerException(new Message(Messages.S082_1));
			}

		}
		catch(DbManagerException e) {
			throw new ValidationManagerException(e, e.getMsg());
		}

		log.debug("[ValidationMgr::verificaAllegatiSysdateSubentro] END");
	}

	public void verificaContrattiSysdateSubentro(String codImpianto) throws ValidationManagerException {
		log.debug("[ValidationMgr::verificaContrattiSysdateSubentro] BEGIN");

		//ValidationManagerException ex = new ValidationManagerException();

		//GenericUtil.eliminaCampoVuoto(subentro.getIdApparecchiature());

		try
		{

			List<SigitTContratto2019Dto> dtoList = getDbMgr().cercaContrattiSysdateByCodImpiantoFilter(codImpianto);

			if (dtoList != null && dtoList.size() > 0)
			{
				throw new ValidationManagerException(new Message(Messages.S082_2));
			}

		}
		catch(DbManagerException e) {
			throw new ValidationManagerException(e, e.getMsg());
		}

		log.debug("[ValidationMgr::verificaContrattiSysdateSubentro] END");
	}


	/**
	 * Verifica la validita' dei dati del delegato
	 *
	 * @param delegato Informazioni del delegato
	 *
	 * @throws ValidationManagerException La verifica non e' valida
	 */
	public void validazioneFormaleSalvaDelega(Integer idPersonaG, String idPersonaF) throws ValidationManagerException {
		log.debug("[ValidationMgr::validazioneFormaleSalvaDelega] BEGIN");

		try
		{

			if (GenericUtil.isNullOrEmpty(idPersonaF))
			{
				throw new ValidationManagerException(new Message(Messages.S078));
			}

			SigitRPfPgDelegaDto filter = new SigitRPfPgDelegaDto();
			filter.setIdPersonaGiuridica(ConvertUtil.convertToBigDecimal(idPersonaG));
			filter.setIdPersonaFisica(ConvertUtil.convertToBigDecimal(idPersonaF));

			ArrayList<SigitRPfPgDelegaDto> listPfPgDelega = getDbMgr().cercaSigitRPfPgDelegaAttByFilter(filter);
			if (listPfPgDelega != null && listPfPgDelega.size() > 0)
			{
				throw new ValidationManagerException(new Message(Messages.S079));
			}

			if (getDbMgr().cercaSigitRPfPgDelegaById(idPersonaG, idPersonaF) != null)
			{
				throw new ValidationManagerException(new Message(Messages.S083));
			}

		}
		catch(DbManagerException e) {
			throw new ValidationManagerException(e, e.getMsg());
		}

		log.debug("[ValidationMgr::validazioneFormaleSalvaDelega] END");
	}


	public void validazioneFormaleCessaDelega(Delegato delegato, String ruoloUtente) throws ValidationManagerException {


		if (GenericUtil.isNotNullOrEmpty(delegato.getDataDelegaAl()))
		{
			throw new ValidationManagerException(new Message(Messages.S080));
		}

		if (delegato.getIdTipoLegame().equalsIgnoreCase(Constants.FLAG_ACCREDITATO_A) &&
				!ruoloUtente.equalsIgnoreCase(Constants.RUOLO_SUPER) &&
				!ruoloUtente.equalsIgnoreCase(Constants.RUOLO_VALIDATORE))
		{
			throw new ValidationManagerException(new Message(Messages.S081));
		}

	}

	/**
	 * Verifica la validita' dei dati del incaricato
	 *
	 * @param delegato Informazioni del incaricato
	 *
	 * @throws ValidationManagerException La verifica non e' valida
	 */
	public void validazioneFormaleSalvaIncarico(Integer idPersonaGImp, String idPersonaGCat) throws ValidationManagerException {
		log.debug("[ValidationMgr::validazioneFormaleSalvaIncarico] BEGIN");

		try
		{
			ValidationManagerException ex = new ValidationManagerException();
			if (GenericUtil.isNullOrEmpty(idPersonaGCat))
			{
					ex.addFieldRequired(ConstantsField.GESTISCI_INCARICO_ID_CAT);
					throw ex;
			}

			ArrayList<SigitRPgPgNominaDto> listPgPgNomina = getDbMgr().cercaSigitRPgPgIncaricoAttByIdPersonaGiuridicaImpGiuridicaCat(idPersonaGImp, idPersonaGCat);
			if (listPgPgNomina != null && listPgPgNomina.size() > 0)
			{
				throw new ValidationManagerException(new Message(Messages.S128));
			}

			if (getDbMgr().cercaSigitRPgPgNominaById(idPersonaGImp, idPersonaGCat) != null)
			{
				throw new ValidationManagerException(new Message(Messages.S083));
			}

		}
		catch(DbManagerException e) {
			throw new ValidationManagerException(e, e.getMsg());
		}

		log.debug("[ValidationMgr::validazioneFormaleSalvaIncarico] END");
	}

	public void validazioneFormaleCessaIncarico(Incaricato incaricato) throws ValidationManagerException {


		if (GenericUtil.isNotNullOrEmpty(incaricato.getDataIncaricoAl()))
		{
			throw new ValidationManagerException(new Message(Messages.S080));
		}
	}

	public void verificaEliminaImpianto(String codImpianto) throws ManagerException {
		log.debug("[ValidationMgr::verificaEliminaImpianto] BEGIN");

		List<SigitVRicercaAllegatiDto> ricercaAllegatiDtoList = getDbMgr().cercaElencoAllegatiPerCancImpianto(codImpianto);

		if (ricercaAllegatiDtoList != null && ricercaAllegatiDtoList.size() > 0)
		{
			throw new ValidationManagerException(new Message(Messages.S019));
		}

		List<SigitVRicercaAllegatiStoricoDto> ricercaStoricoAllegatiDtoList = getDbMgr().cercaElencoStoricoAllegatiPerImpianto(codImpianto);

		if (ricercaStoricoAllegatiDtoList != null && ricercaStoricoAllegatiDtoList.size() > 0)
		{
			throw new ValidationManagerException(new Message(Messages.S019));
		}

		List<SigitTLibrettoDto> librettoDtoList = getDbMgr().cercaLibrettoByStato(codImpianto, Constants.ID_STATO_LIBRETTO_CONSOLIDATO);

		if (librettoDtoList != null && librettoDtoList.size() > 0)
		{
			throw new ValidationManagerException(new Message(Messages.S020));
		}

		List<SigitVRicercaIspezioniDto> elencoIspezioni = getDbMgr().cercaElencoIspezioniPerImpianto(ConvertUtil.convertToInteger(codImpianto));

		if (elencoIspezioni != null && elencoIspezioni.size() > 0)
		{
			throw new ValidationManagerException(new Message(Messages.S123));
		}

//		List<SigitRComp4ContrattoDto> elencoContratti = getDbMgr().cercaElencoContrattiPerImpianto(ConvertUtil.convertToInteger(codImpianto));
		ContrattoFilter filtroPerImpianto = new ContrattoFilter();
		filtroPerImpianto.setCodiceImpianto(ConvertUtil.convertToBigDecimal(codImpianto));

		try {
			List<SigitTContratto2019Dto> elencoContratti = getDbMgr().getSigitTContratto2019Dao().findByFilter(filtroPerImpianto);

			if (elencoContratti != null && elencoContratti.size() > 0)
			{
				throw new ValidationManagerException(new Message(Messages.S150));
			}

		} catch (SigitTContratto2019DaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_RECUPERO_DB));
		}



		log.debug("[ValidationMgr::verificaEliminaImpianto] END");
	}

	/**
	 * Verifica la validita' dell'inserimento di un codice impianto
	 *
	 * @param identificazioneInfo Informazioni sull'identificazione di un
	 *            impianto
	 * @throws ValidationManagerException L'inserimento del codice impianto non
	 *             e' valido
	 */

	private void verificaInserimentoCodiceImpianto(String codImpianto) throws ValidationManagerException {
		log.debug("[ValidationMgr::verificaInserimentoCodiceImpianto] BEGIN");
		//List<SigitTCodiceImpByCodiceImpiantoDto> codiceList = null;
		ValidationManagerException validationException = null;
//		Message m = null;

		try {

			// Modificato per associazione automatica codice impianto
			/*
			codiceList = getDbMgr().cercaCodiceImpianto(ConvertUtil.convertToInteger(codImpianto));

			if (log.isDebugEnabled())
				GenericUtil.stampa(codiceList, true, 2);

			if (impianto.getLogicaVisual().getCaso() != Constants.COD_CASO_E)
			{
				if(codiceList == null || codiceList.size() == 0 ||
						codiceList.get(0).getIdPersonaGiuridica().intValue() != impianto.getInstId().intValue()) {
					validationException = new ValidationManagerException(new Message(Messages.S022));
					validationException.addField(ConstantsField.GESTISCI_IMPIANTO_COD_IMP);
					throw validationException;
				}
			}
			*/

			if(getDbMgr().cercaImpiantoDtoById(codImpianto) != null) {
				validationException = new ValidationManagerException(new Message(Messages.S024));
				validationException.addField(ConstantsField.GESTISCI_IMPIANTO_COD_IMP);
				throw validationException;
			}

			// Devo verificare che il cod impianto inserito dall'utente non sia superiore al numero della sequence, per evitare che inseriscano numeri assuri
			if (ConvertUtil.convertToInteger(codImpianto) > getDbMgr().getMaxIdSeqCodiceImpianto())
			{
				validationException = new ValidationManagerException(new Message(Messages.S024_1));
				validationException.addField(ConstantsField.GESTISCI_IMPIANTO_COD_IMP);
				throw validationException;
			}
		}
		catch(DbManagerException ex) {
			throw new ValidationManagerException(ex, ex.getMsg());
		}
		log.debug("[ValidationMgr::verificaInserimentoCodiceImpianto] END");
	}

	/**
	 * Verifica se l'utente ha modificato l'ubicazione dell'impianto, verificare la presenza di almeno un libretto in stato CONSOLIDATO.
	 *
	 * @param identificazioneInfo Informazioni sull'identificazione di un
	 *            impianto
	 * @throws ValidationManagerException L'inserimento non e' valido
	 */
	public void verificaModificaUbicazioneImpiantoIdentificazione(Impianto impianto) throws ValidationManagerException {
		log.debug("[ValidationMgr::verificaModificaUbicazioneImpiantoIdentificazione] BEGIN");
		//validazioneFormaleImpiantoIdentificazione(identificazioneInfo, true, null, null, null, null, null);


		if(impianto != null) {

			try
			{
				List<SigitTLibrettoDto> librettoList = getDbMgr().cercaLibrettoByStato(impianto.getImpCodImpianto(), Constants.ID_STATO_LIBRETTO_CONSOLIDATO);

				if (librettoList != null && librettoList.size() > 0)
				{
					// Esiste almeno un libretto in stato CONSOLIDATO

					// Ricerco l'ubicazione sul DB
					SigitTUnitaImmobiliareDto unitaImmobiliareDB = getDbMgr().cercaSigitTUnitaImmobiliareByCodImpianto(impianto.getImpCodImpianto());
					SigitTImpiantoDto impiantoDB = getDbMgr().cercaImpiantoDtoById(impianto.getImpCodImpianto());

					if (!(
							StringUtils.trimToEmpty(impiantoDB.getSiglaProvincia()).equalsIgnoreCase(StringUtils.trimToEmpty(impianto.getImpLocIdProvincia())) &&
							StringUtils.trimToEmpty(impiantoDB.getIstatComune()).equalsIgnoreCase(StringUtils.trimToEmpty(impianto.getImpLocIdComune())) &&
							//StringUtils.trimToEmpty(ConvertUtil.convertToString(unitaImmobiliareDB.getFkL2())).equalsIgnoreCase(StringUtils.trimToEmpty(impianto.getImpLocIdIndirizzo())) &&
							StringUtils.trimToEmpty(unitaImmobiliareDB.getIndirizzoSitad()).equalsIgnoreCase(StringUtils.trimToEmpty(impianto.getImpLocIndirizzoSitad())) &&
							StringUtils.trimToEmpty(unitaImmobiliareDB.getIndirizzoNonTrovato()).equalsIgnoreCase(StringUtils.trimToEmpty(impianto.getImpLocIndirizzoNoStrad()))
							))
					{
						// Ha modificato qualche dato

						// Risetto i vecchi dati
						impianto.setImpLocIdProvincia(impiantoDB.getSiglaProvincia());
						impianto.setImpLocIdComune(impiantoDB.getIstatComune());
						impianto.setImpLocIdIndirizzo(ConvertUtil.convertToString(unitaImmobiliareDB.getFkL2()));
						impianto.setImpLocIndirizzoSitad(unitaImmobiliareDB.getIndirizzoSitad());
						impianto.setImpLocIndirizzoNoStrad(unitaImmobiliareDB.getIndirizzoNonTrovato());

						if (GenericUtil.isNotNullOrEmpty(unitaImmobiliareDB.getIndirizzoSitad()))
						{
							impianto.setImpLocIndirizzo(unitaImmobiliareDB.getIndirizzoSitad());
						}
						else
						{
							impianto.setImpLocIndirizzo(unitaImmobiliareDB.getIndirizzoNonTrovato());
						}

						throw new ValidationManagerException(new Message(Messages.S027));

					}


				}
			}
			catch(DbManagerException e) {
				throw new ValidationManagerException(e, e.getMsg());
			}

		}



		log.debug("[ValidationMgr::verificaModificaUbicazioneImpiantoIdentificazione] END");
	}

	/**
	 * Verifica l'ordine di due date
	 *
	 * @param dataPrec Data che si presume precedente
	 * @param dataSucc Data che si presume successiva
	 * @param canBeEqual True se le date possono essere uguali, false altrimenti
	 * @param dataPrecField Campo associato alla data precedente
	 * @param dataSuccField Campo associato alla data successiva
	 * @param dataPrecLabel Etichetta associata alla data precedente
	 * @param dataSuccLabel Etichetta associata alla data successiva
	 * @param m Messaggio d'errore da utilizzare
	 * @throws ValidationManagerException La prima data non precede la seconda
	 */
	protected void checkDateOrderMesDataSucc(String dataPrec, String dataSucc, boolean canBeEqual, String dataPrecField, String dataSuccField,
			Message m) throws ValidationManagerException {

		checkDate(dataPrec, dataPrecField);
		checkDate(dataSucc, dataSuccField);
		if(!DateUtil.checkDateOrder(dataPrec, dataSucc, canBeEqual)) {

			m.replacePlaceholder(dataSucc);

			ValidationManagerException ex = new ValidationManagerException();
			ex.addField(dataPrecField);
			ex.addField(dataSuccField);
			ex.setMsg(m);
			throw ex;
		}
	}

	/**
	 * Verifica se un numero e' in formato intero. CHK9
	 *
	 * @param numeroDaVerificare Numero da verificare
	 * @param numberField Campo associato al nome
	 * @return Numero convertito in intero
	 * @throws ValidationManagerException Il numero non e' informato intero
	 */
	protected void checkNumeroIntero(String numeroDaVerificare, String numberField) throws ValidationManagerException {
		ValidationManagerException ex = null;

		if (GenericUtil.isNotNullOrEmpty(numeroDaVerificare))
		{
				if (!GenericUtil.checkValideNumber(numeroDaVerificare))
				{
					ex = new ValidationManagerException();
					ex.addField(numberField, Messages.S012);
					throw ex;
				}
		}

	}

	/**
	 * Verifica se un numero e' in formato intero. CHK9
	 *
	 * @param numeroDaVerificare Numero da verificare
	 * @param numberField Campo associato al nome
	 * @return Numero convertito in intero
	 * @throws ValidationManagerException Il numero non e' informato intero
	 */
	protected void checkNumeroIntero(String numeroDaVerificare, String numberField, int maxLenght) throws ValidationManagerException {
		ValidationManagerException ex = null;
		if (GenericUtil.isNotNullOrEmpty(numeroDaVerificare))
		{
			if (!GenericUtil.checkValideMaxLenghtNumber(numeroDaVerificare, maxLenght))
			{
				ex = new ValidationManagerException();
				ex.addField(numberField, Messages.S012);
				throw ex;
			}
		}

	}

	public static boolean checkNumero(String numeroDaVerificare, String numberField, Integer maxInteger, Integer maxDecimal, ValidationManagerException ex, boolean checkPositive) throws ValidationManagerException {
		Message message =  checkNumero(numeroDaVerificare, maxInteger, maxDecimal, checkPositive);
		boolean throwEx = false;
		if (ex == null) { //se non viene passata l'eccezione da arricchire allora ci si limita a crearne una e a sollevarla (come e' stato fatto finora)
			//in questo modo si da la possibilita' di arricchire eccezioni pre-invocazione
			ex = new ValidationManagerException();
			throwEx = true;
		}
		if (message != null) {
			ex.addField(numberField, message.getText());

			if (throwEx) {
				throw ex;
			}
			return false; //si errore
		}

		return true; //noErrore

	}

	protected boolean checkNumero(String numeroDaVerificare, String numberField, Integer maxInteger, Integer maxDecimal, Integer maxLength, ValidationManagerException ex, boolean checkPositive) throws ValidationManagerException {
		Message message =  checkNumero(numeroDaVerificare, maxInteger, maxDecimal, maxLength, checkPositive);
		boolean throwEx = false;
		if (ex == null) { //se non viene passata l'eccezione da arricchire allora ci si limita a crearne una e a sollevarla (come e' stato fatto finora)
			//in questo modo si da la possibilita' di arricchire eccezioni pre-invocazione
			ex = new ValidationManagerException();
			throwEx = true;
		}
		if (message != null) {
			ex.addField(numberField, message.getText());

			if (throwEx) {
				throw ex;
			}
			return false; //si errore
		}

		return true; //noErrore

	}

	/**
	 * metodo di validazione che si preoccupa di costruire il messaggio di errore
	 * @param numeroDaVerificare
	 * @param maxInteger
	 * @param maxDecimal
	 * @return
	 */
	protected static Message checkNumero(String numeroDaVerificare, Integer maxInteger, Integer maxDecimal, boolean checkPositive){

		Message message = null;
		if (GenericUtil.isNotNullOrEmpty(numeroDaVerificare))
		{
			// Se il numero ha la virgola, si sostituisce l'eventuale punto con
			// la virgola
			numeroDaVerificare = numeroDaVerificare.replace(",", ".");

			if (!GenericUtil.isNumeroDecimaleValido(numeroDaVerificare, maxInteger, maxDecimal, checkPositive))
			{
				return createNumberErrorMessage(numeroDaVerificare, maxInteger, maxDecimal, null, checkPositive);
			}
		}
		return message;
	}

	protected Message checkNumero(String numeroDaVerificare, Integer maxInteger, Integer maxDecimal, Integer maxLength, boolean checkPositive){

		Message message = null;
		if (GenericUtil.isNotNullOrEmpty(numeroDaVerificare))
		{
			// Se il numero ha la virgola, si sostituisce l'eventuale punto con
			// la virgola
			numeroDaVerificare = numeroDaVerificare.replace(",", ".");

			if (!GenericUtil.isNumeroDecimaleValido(numeroDaVerificare, maxInteger, maxDecimal, checkPositive, maxLength))
			{
				return createNumberErrorMessage(numeroDaVerificare, maxInteger, maxDecimal, maxLength, checkPositive);
			}
		}
		return message;
	}

	private static Message createNumberErrorMessage (String numeroDaVerificare, Integer maxInteger, Integer maxDecimal, Integer maxLength, boolean checkPositive) {
		Message message = null;

		if (numeroDaVerificare.startsWith("-") && checkPositive) {
			message = new Message(Messages.ERROR_DEVE_ESSERE_NUMERICO_POSITIVO);
		} else if (maxInteger != null ) {
			if (maxDecimal != null) { //se si valutano sia i maxInteri che i maxDecimali non ha senso valutare la lunghezza massima
				message = new Message(Messages.ERROR_NUMERO_NON_CORRETTO);
				message.replacePlaceholder(maxInteger.toString(), maxDecimal.toString());
			} else {
				if (maxLength != null) {
					message = new Message(Messages.ERROR_DEVE_ESSERE_NUMERICO_TOT_CARATTERI_DI_CUI_INTERI);
					message.replacePlaceholder(maxLength.toString(), maxInteger.toString());
				} else {
					message = new Message(Messages.ERROR_DEVE_ESSERE_NUMERICO_TOT_CARATTERI);
					message.replacePlaceholder(maxInteger);
				}
			}
		} else if (maxDecimal != null && maxLength != null) {
			message = new Message(Messages.ERROR_DEVE_ESSERE_NUMERICO_TOT_CARATTERI_DI_CUI_DECIMALI);
			message.replacePlaceholder(maxDecimal.toString(), maxLength.toString());
		} else if (maxLength != null) {
			message = new Message(Messages.ERROR_DEVE_ESSERE_NUMERICO_TOT_CARATTERI);
			message.replacePlaceholder(maxLength);
		} else {
			message = new Message(Messages.ERROR_DEVE_ESSERE_NUMERICO);
		}

		return message;
	}


	/**
	 * Verifica se una data rispetta il formato richiesto e se e' valida
	 *
	 * @param dateToCheck Data da controllare
	 * @param dateField Campo associato alla data
	 * @return Data parsificata
	 * @throws ValidationManagerException Errore durante la verifica
	 */
	public Date checkDate(String dateToCheck, String dateField) throws ValidationManagerException {
		ValidationManagerException ex = null;
		Date dateParsed = null;

		if(!DateUtil.checkValideDate(dateToCheck)) {
				ex = new ValidationManagerException(new Message(Messages.ERROR_FORMALE_DATA));
				ex.addField(dateField);
				throw ex;
		}
		else
		{
			try {
				dateParsed = ConvertUtil.convertToDate(dateToCheck);
			}
			catch(Exception e) {
				ex = new ValidationManagerException(new Message(Messages.ERROR_FORMALE_DATA));
				ex.addField(dateField, Messages.ERROR_FORMALE_DATA);
				throw ex;
			}
		}
		return dateParsed;
	}

	public Date checkDate(String dateToCheck, String dateField, ValidationManagerException ex) {
		try {
			return checkDate (dateToCheck, dateField) ;
		} catch (ValidationManagerException e) {
			ex.addField(dateField, e.getMessage());
			return null;
		}
	}


	/**
	 * Verifica se la sigla e il numero REA sono entrambi valorizzati o non
	 * valorizzati. CHK2
	 *
	 * @param siglaRea Sigla REA
	 * @param numeroRea Numero REA
	 * @param siglaReaField Campo associato alla sigla REA
	 * @param numeroReaField Campo associato al numero REA
	 * @throws ValidationManagerException E' valorizzata la sigla, ma non il
	 *             numero o il numero, ma non la sigla
	 */
	private void checkSiglaAndNumeroRea(String siglaRea, UDTPositiveInteger numeroRea, String siglaReaField, String numeroReaField)
			throws ValidationManagerException {
		String  numeroReaString = null;
		try{
			numeroReaString = numeroRea.getValue().toString();
		}catch(Exception e){

		}
		checkSiglaAndNumeroRea(siglaRea, numeroReaString, siglaReaField, numeroReaField);
	}

	private void checkSiglaAndNumeroRea(String siglaRea, String numeroRea, String siglaReaField, String numeroReaField)
			throws ValidationManagerException {
		ValidationManagerException ex = null;
		boolean siglaReaEmpty;
		boolean numeroReaEmpty;

		checkAlphanumericStringMaxLenght(siglaRea, 2, siglaReaField);
		checkAlphanumericStringMaxLenght(numeroRea, 15, numeroReaField);

		siglaReaEmpty = GenericUtil.isNullOrEmpty(siglaRea);
		numeroReaEmpty = GenericUtil.isNullOrEmpty(numeroRea);
		if(siglaReaEmpty != numeroReaEmpty) {

			ex = new ValidationManagerException(new Message(Messages.S011));
			ex.addField(siglaReaField);
			ex.addField(numeroReaField);
			throw ex;
		}
	}


	/**
	 * Verifica se un valore e' numerico
	 *
	 * @param number Numero da verificare
	 * @param maxLength Numero massimo di cifre ammesse
	 * @param numberField Campo associato al nome
	 * @return Restituisce il numero convertito in long
	 * @throws ValidationManagerException Il valore non e' un numero
	 */
	/*
	private long checkNumeroDecimale(String number, int maxLength, String numberField) throws ValidationManagerException {
		ValidationManagerException ex = null;
		long value;

		value = 0;
		if(StringUtils.isNotBlank(number)) {
			if(!StringUtils.isNumeric(number)) {
				ex = new ValidationManagerException(msgMgr.getMessage(WebMsgCodeEnum.S011));
				ex.addField(numberField);
				throw ex;
			}
			checkNumeroIntero(number, numberField);
			if(number.length() > maxLength) {
				ex = new ValidationManagerException(msgMgr.getMessage(WebMsgCodeEnum.S011));
				ex.addField(numberField);
				throw ex;
			}
			value = new BigDecimal(number).longValue();
			if(value < 0) {
				ex = new ValidationManagerException(msgMgr.getMessage(WebMsgCodeEnum.S011));
				ex.addField(numberField);
				throw ex;
			}
		}
		return value;
	}
	*/

	/**
	 * Verifica se un codice fiscale e' formalmente valido
	 *
	 * @param codiceFiscale Il codice fiscale da verificare
	 * @param codiceFiscaleField Campo associato al codice fiscale
	 * @throws ValidationManagerException Il codice fiscale non e' formalmente
	 *             valido
	 */

	private void checkCodiceFiscalePartitaIva(String codiceFiscale, String codiceFiscaleField) throws ValidationManagerException {
//		ValidationManagerException ex = null;

		if (GenericUtil.isNotNullOrEmpty(codiceFiscale))
		{

			if (codiceFiscale.length() == Constants.PARTITA_IVA_LEN)
			{
				controlloPIVA(codiceFiscale, codiceFiscaleField);
			}
			else
			{
				controlloCf(codiceFiscale, codiceFiscaleField);
			}


//			if(codiceFiscale.length() > Constants.CODICE_FISCALE_LEN) {
//				ex = new ValidationManagerException(new Message(Messages.ERROR_FORMALE_CODICE_FISCALE));
//				ex.addField(codiceFiscaleField);
//				throw ex;
//			}

		}
	}


	protected void checkCodiceFiscalePartitaIva(String codiceFiscale, String codiceFiscaleField, ValidationManagerException ex) throws ValidationManagerException {
		try {
			checkCodiceFiscalePartitaIva(codiceFiscale, codiceFiscaleField);
		} catch (ValidationManagerException e) {
			if (ex != null) {
				ex.addField(codiceFiscaleField, e.getMessage());
			} else {
				throw e;
			}
		}
	}


	/**
	 * Verifica se oltre all'indirizzo e' stato selezionato anche il comune
	 *
	 * @param indirizzo Indirizzo
	 * @param idComune Comune
	 * @param fieldProvincia Il campo della provincia
	 * @param fieldIndirizzo Il campo dell'indirizzo
	 * @param fieldComune Il campo del comune
	 */
	private void checkRicercaIndirizzo(String idComune, String idProvincia, String fieldComune, String fieldProvincia)
	throws ValidationManagerException {
		if(GenericUtil.isNullOrEmpty(idProvincia)) {
			ValidationManagerException ex = new ValidationManagerException(new Message(Messages.ERROR_SELEZIONARE_PROVINCIA));
			ex.addFieldRequired(fieldProvincia);
			throw ex;
		}

		if(GenericUtil.isNullOrEmpty(idComune)) {
			ValidationManagerException ex = new ValidationManagerException(new Message(Messages.ERROR_SELEZIONARE_COMUNE));
			// ex.addField(fieldIndirizzo);
			ex.addFieldRequired(fieldComune);
			throw ex;
		}
	}

	/*
	private void checkRicercaIndirizzo(String idComune, Integer idProvincia, String fieldComune, String fieldProvincia)
			throws ValidationManagerException {
		if(GenericUtil.isNullOrEmpty(idProvincia)) {
			ValidationManagerException ex = new ValidationManagerException(new Message(Messages.ERROR_SELEZIONARE_PROVINCIA));
			ex.addFieldRequired(fieldProvincia);
			throw ex;
		}

		if(GenericUtil.isNullOrEmpty(idComune)) {
			ValidationManagerException ex = new ValidationManagerException(new Message(Messages.ERROR_SELEZIONARE_COMUNE));
			// ex.addField(fieldIndirizzo);
			ex.addFieldRequired(fieldComune);
			throw ex;
		}
	}
	*/

	/**
	 * Verifica se una stringa e' alfanumerica e la lunghezza minima di caratteri
	 *
	 * @param s La stringa da verificare
	 * @param minLenght La lunghezza minima
	 * @param field Campo associato alla stringa
	 * @throws ValidationManagerException La stringa non e' valida
	 */
	private void checkAlphanumericStringMinLenght(String s, int minLenght, String field) throws ValidationManagerException {

		s = GenericUtil.getStringValid(s);;
		if (GenericUtil.isNotNullOrEmpty(s))
		{
			if (!StringUtils.isAlphanumericSpace(s) || s.length() < minLenght) {
				Message message = new Message(Messages.ERROR_LUNGHEZZA_MINIMA);
				message.replacePlaceholder(minLenght);
				ValidationManagerException ex = new ValidationManagerException(message);
				ex.addField(field, message.getText());
				throw ex;
			}
		}
	}

	/**
	 * Verifica se una stringa e' alfanumerica e la lunghezza minima di caratteri
	 *
	 * @param s La stringa da verificare
	 * @param minLenght La lunghezza minima
	 * @param field Campo associato alla stringa
	 * @throws ValidationManagerException La stringa non e' valida
	 */
	private String checkAlphanumericStringMaxLenght(String s, int maxLenght, String field) throws ValidationManagerException {

		log.debug("PASSO 1");

		s = GenericUtil.getStringValid(s);;

		log.debug("PASSO 2: "+s);

		if (GenericUtil.isNotNullOrEmpty(s))
		{
			log.debug("PASSO 3");
			log.debug("PASSO 3.1 Stampo la lunghezza: "+s.length());
			log.debug("PASSO 3.2 Stampo la StringUtils.isAlphanumericSpace(s): "+StringUtils.isAlphanumericSpace(s));

			if(!StringUtils.isAlphanumericSpace(s) || s.length() > maxLenght) {

				log.debug("PASSO 4");

				Message message = new Message(Messages.ERROR_LUNGHEZZA_MASSIMA);
				message.replacePlaceholder(maxLenght);
				ValidationManagerException ex = new ValidationManagerException(message);
				if (field != null)
					ex.addField(field, message.getText());
				throw ex;
			}
		}
		return s;
	}

	public static String checkAsciiStringMaxLength (String s, int maxLenght, String field, ValidationManagerException ex) throws ValidationManagerException {
		log.debug("PASSO 1");

		s = GenericUtil.getStringValid(s);

		log.debug("PASSO 2: "+s);

		if (GenericUtil.isNotNullOrEmpty(s))
		{
			log.debug("PASSO 3");
			log.debug("PASSO 3.1 Stampo la lunghezza: "+s.length());
			log.debug("PASSO 3.2 Stampo la StringUtils.isAlphanumericSpace(s) (non usato): "+StringUtils.isAlphanumericSpace(s));
			log.debug("PASSO 3.2 Stampo la StringUtils.isAsciiPrintable(s): "+StringUtils.isAsciiPrintable(s));

			if(!StringUtils.isAsciiPrintable(s) || s.length() > maxLenght) {

				log.debug("PASSO 4");
				Message message = null;
				if(!StringUtils.isAsciiPrintable(s))
				{
					message = new Message(Messages.ERROR_CARATTERI_SPECIALI);
				}
				else if (s.length() > maxLenght)
				{
					message = new Message(Messages.ERROR_LUNGHEZZA_MASSIMA);
					message.replacePlaceholder(maxLenght);
				}

				boolean throwEx = false;
				if (ex == null) {
					ex = new ValidationManagerException();
					throwEx = true;
				}

				if (field == null) {
					ex.setMsg(message);
				} else {
					ex.addField(field, message.getText());
				}

				if (throwEx) {
					throw ex;
				}
			}
		}

		return s;
	}

	/**
	 * Verifica se una stringa e' alfanumerica e la lunghezza minima di caratteri
	 *
	 * @param s La stringa da verificare
	 * @param minLenght La lunghezza minima
	 * @param field Campo associato alla stringa
	 * @throws ValidationManagerException La stringa non e' valida
	 */
	private void checkStringMaxLenght(String s, int maxLenght, String field) throws ValidationManagerException {

		log.debug("PASSO 1");

		s = GenericUtil.getStringValid(s);

		log.debug("PASSO 2: "+s);

		if (GenericUtil.isNotNullOrEmpty(s))
		{
			log.debug("PASSO 3");
			log.debug("PASSO 3.1 Stampo la lunghezza: "+s.length());

			if(s.length() > maxLenght) {

				log.debug("PASSO 4");

				Message message = new Message(Messages.ERROR_LUNGHEZZA_MASSIMA);
				message.replacePlaceholder(maxLenght);
				ValidationManagerException ex = new ValidationManagerException(message);
				ex.addField(field, message.getText());
				throw ex;
			}
		}
	}

	/**
	 * Verifica se la sigla e il numero di bollino sono entrambi valorizzati o
	 * non valorizzati. CHK3
	 *
	 * @param siglaBollino Sigla bollino
	 * @param numeroBollino Numero bollino
	 * @param fieldSiglaBollino Campo associato alla sigla bollino
	 * @param fieldNumeroBollino Campo associato al numero bollino
	 * @throws ValidationManagerException E' valorizzata la sigla, ma non il
	 *             numero o il numero, ma non la sigla
	 */
	protected void checkSiglaAndNumeroBollino(String siglaBollino, String numeroBollino, String fieldSiglaBollino, String fieldNumeroBollino)
			throws ValidationManagerException {
		ValidationManagerException ex = null;
		boolean siglaBollinoEmpty;
		boolean numeroBollinoEmpty;

		siglaBollinoEmpty = GenericUtil.isNullOrEmpty(siglaBollino);
		numeroBollinoEmpty = GenericUtil.isNullOrEmpty(numeroBollino);
		if(siglaBollinoEmpty != numeroBollinoEmpty) {
			ex = new ValidationManagerException(new Message(Messages.ERROR_SIGLA_NUMERO_BOLLINO));
			ex.addField(fieldSiglaBollino);
			ex.addField(fieldNumeroBollino);
			throw ex;
		}

		checkNumeroIntero(numeroBollino, fieldNumeroBollino, Constants.MAX_NUMERO_BOLLINO_LEN);

	}

	/**
	 * Verifica se il CAP e' della lunghezza corretta
	 *
	 * @param cap Il String da verificare
	 * @param field Campo associato alla stringa
	 * @throws ValidationManagerException La stringa non e' un CAP valido
	 */
	private void checkCAP(String cap, String field) throws ValidationManagerException {

		log.debug("STAMPO IL CAP: "+cap);
		if(GenericUtil.isNotNullOrEmpty(cap)) {

			log.debug("SONO ENTRATO");
			ValidationManagerException ex;
			if (!GenericUtil.isStringValid(cap, Constants.CAP))
			{
				log.debug("ERRORE CAP");
				ex = new ValidationManagerException(new Message(Messages.ERROR_FORMALE_CAP));
				ex.addField(field);
				throw ex;
			}
		}
	}

	/**
	 * Verifica se il POD e' formalmente corretto
	 *
	 * @param pod Il String da verificare
	 * @param field Campo associato alla stringa
	 * @throws ValidationManagerException La stringa non e' un POD valido
	 */
	private String checkPOD(String pod, String field) throws ValidationManagerException {
		pod = GenericUtil.getStringValid(pod);
		if(GenericUtil.isNotNullOrEmpty(pod)) {
			ValidationManagerException ex;
			if (!GenericUtil.isStringValid(pod.toUpperCase(), Constants.POD))//IT[0-9]{3}[a-zA-Z]{1}[0-9]+
			{
				ex = new ValidationManagerException(new Message(Messages.ERROR_FORMALE_POD));
				if (field != null)
					ex.addField(field);
				throw ex;
			}
		}
		return pod.toUpperCase();
	}

	/**
	 * Verifica se il PDR e' formalmente corretto
	 *
	 * @param pdr Il String da verificare
	 * @param field Campo associato alla stringa
	 * @throws ValidationManagerException La stringa non e' un PDR valido
	 */
	public String checkPDR(String pdr, String field) throws ValidationManagerException {
		pdr = GenericUtil.getStringValid(pdr);
		if(GenericUtil.isNotNullOrEmpty(pdr)) {
			ValidationManagerException ex;
			if (!GenericUtil.isStringValid(pdr, Constants.PDR))
			{
				ex = new ValidationManagerException(new Message(Messages.ERROR_FORMALE_PDR));
				if (field != null)
					ex.addField(field);
				throw ex;
			}
		}
		return pdr;
	}

	/**
	 * Verifica la validita' di un intervallo
	 *
	 * @param from Valore di inizio intervallo
	 * @param to Valore di fine intervallo
	 * @param fromField Campo associato all'inizio dell'intervallo
	 * @param toField Campo associato alla fine dell'intervallo
	 * @throws ValidationManagerException L'intervallo non e' valido
	 */
	private void checkIntervallo(Date from, Date to, String fromField, String toField) throws ValidationManagerException {
		ValidationManagerException ex = null;

		if(from.after(to)) {
			ex = new ValidationManagerException(new Message(Messages.A001));
			ex.addField(fromField);
			ex.addField(toField);
			throw ex;
		}
	}

	private void controlloCf(String codFiscale, String codiceFiscaleField) throws ValidationManagerException{
		ValidationManagerException ex = null;
		char caratt;
		boolean ok = false;
		int controllo = -1;
		int resto;
		int sum_pari = 0;
		int sum_dispari = 0;
		// per l'ulteriore controllo del carattere finale
		int restoTwo = 0;
		String codiceFiscale = null;

		if ((codFiscale != null) && (codFiscale.length() == 16)) {
			codiceFiscale = codFiscale.toUpperCase();
			codFiscale = codFiscale.toUpperCase();
			for (int i = 1; i <= 15; i++) {
				int row;
				caratt = codFiscale.charAt(0);
				codFiscale = codFiscale.substring(1);

				for (row = 1; row <= 36; row++) {
					if (carattere[row - 1] == caratt) {
						if ((i / 2) * 2 == i) {
							sum_pari = sum_pari + valore_pari[row - 1];
							break;
						} else {
							sum_dispari = sum_dispari + valore_dispari[row - 1];
							break;
						}
					}
				}
				// Occorre controllare se l'utente ha inserito caratteri non
				// alfanumerici,
				// perche' in alcuni casi, con probabilita' minima ma non nulla,
				// il metodo
				// potrebbe non restituire il messaggio di errore
				if (row > 36) {
					// Il carattere non corrisponde a nessun valore salvato
					// nell'array
					// 'carattere', per cui viene creato il messaggio di errore
					// e si
					// forza l'uscita dal metodo, per non eseguire altro codice
					// a questo
					// punto inutile
					ex = new ValidationManagerException(new Message(Messages.ERROR_FORMALE_CODICE_FISCALE));
					ex.addField(codiceFiscaleField);
					throw ex;
				}
			}

			resto = (sum_pari + sum_dispari) - ((sum_pari + sum_dispari) / 26)
					* 26;
			caratt = codFiscale.charAt(0);

			for (int row = 1; row <= 36; row++) {
				if (carattere[row - 1] == caratt) {
					controllo = valore_pari[row - 1];
					break;
				}
			}
			/**
			 * ci sono alcuni casi in cui fare affidamemto al controllo di
			 * seguito non e' sufficiente per il corretto controllo del codice
			 * fiscale allora aggiungo io un controllo utilizzando il carattere
			 * di controllo finale del codice fiscale
			 */
			if (controllo == resto)
				ok = true;

			/**
			 * a questo punto visto che questo controllo non e' molto preciso
			 * vado a fare il controllo dell'ultimo carattere ma fuori allora
			 * devo prendere il resto che e' stato trovato precedentemente
			 */
			restoTwo = resto;

			if (ok) {
				/**
				 * agginta di francesca in data 17/01/2006 perche' non funziona il
				 * controllo sopra per il codice fiscale: mrlmfsc97s20c351 faccio
				 * l'ulteriore controllo del carattere finale di controllo
				 */

				if (carattere_di_controllo[restoTwo] == codiceFiscale.charAt(15))
					ok = true;
				else
					ok = false;
			}
		}

		if (!ok) {
			ex = new ValidationManagerException(new Message(Messages.ERROR_FORMALE_CODICE_FISCALE));
			ex.addField(codiceFiscaleField);
			throw ex;
		}
	}


	private void controlloPIVA(String partitaIva, String partitaIvaField) throws ValidationManagerException {
		boolean ok = false;
		int somma = 0;
		ValidationManagerException ex = null;
		if (validateCurrency(partitaIva, partitaIvaField) == null)
			return;

		if ((partitaIva != null) && (partitaIva.length() == 11)) {
			for (int i = 0; i <= 8; i += 2) {
				somma += partitaIva.charAt(i) - '0';
			}

			for (int i = 1; i <= 9; i += 2) {
				int temp = (partitaIva.charAt(i) - '0') * 2;
				if (temp > 9)
					temp -= 9;
				somma += temp;
			}

			if ((10 - somma % 10) % 10 == partitaIva.charAt(10) - '0') {
				ok = true;
			}
		}

		if (!ok)
		{
			ex = new ValidationManagerException(new Message(Messages.ERROR_PARTITA_IVA));
			ex.addField(partitaIvaField);
			throw ex;
		}
	}


	public Double validateCurrency(String field, String partitaIvaField) throws ValidationManagerException{
		ValidationManagerException ex = null;
		if (field == null || field.length() == 0)
			return null;
		try {
			double value = Double.parseDouble(field);
			return new Double(value);
		} catch (NumberFormatException nfEx) {
			ex = new ValidationManagerException(new Message(Messages.ERROR_SOLO_NUMERICI));
			ex.addField(partitaIvaField);
			throw ex;
		}
	}

	/**
	 * Verifica se un valore e' numerico
	 *
	 * @param number Numero da verificare
	 * @param maxLength Numero massimo di cifre ammesse
	 * @param numberField Campo associato al nome
	 * @return Restituisce il numero convertito in long
	 * @throws ValidationManagerException Il valore non e' un numero
	 */
	protected long checkNumber(String number, int maxLength, String numberField) throws ValidationManagerException {
		ValidationManagerException ex = null;
		long value;

		value = 0;
		if(StringUtils.isNotBlank(number)) {

			if(!StringUtils.isNumeric(number)) {
				ex = new ValidationManagerException(new Message(Messages.S012));
				ex.addField(numberField);
				throw ex;
			}
			checkNumeroIntero(number, numberField);
			if(number.length() > maxLength) {
				ex = new ValidationManagerException(new Message(Messages.S012));
				ex.addField(numberField);
				throw ex;
			}
			value = new BigDecimal(number).longValue();
			if(value < 0) {
				ex = new ValidationManagerException(new Message(Messages.S012));
				ex.addField(numberField);
				throw ex;
			}
		}

		return value;
	}


	/**
	 * Controllo che il numero Bollino non sia stato assegnato ad un altro impianto
	  * @param number Numero da verificare
	   * @throws ValidationManagerException il numero bollino e' gia' stato assegnato
	 */
	public void isBollinoAssegnatoAltroImpianto(String numeroBollino, String idAllegato) throws ValidationManagerException {
		try {
			List<SigitTAllegatoControlloBollinoAssegnatoAltroImpiantoDto> lista = this.getDbMgr().controlloBollinoAssegnatoAltroImpianto(numeroBollino, idAllegato);
			if(lista!=null && lista.size()>0){
				//ho trovato un allegato con quel numero bollino quindi blocco
				throw new ValidationManagerException(new Message(Messages.S048));
			}
		} catch (DbManagerException e) {
			throw new ValidationManagerException(new Message(Messages.ERROR_RECUPERO_DB));
		}

	}


	public boolean isNessunResponsabileByCodImpiantoApp(String codImpianto, String dataRapporto, String idTipoAllegato, ArrayList<String> listaProgressivi) throws ValidationManagerException {

		try {

			Integer contaResponsabile = this.getDbMgr().cercaPrimoResponsabileAttivoAllaDataByCodImpiantoApp(codImpianto, dataRapporto, listaProgressivi);

			return contaResponsabile == null || contaResponsabile.intValue() == 0;

		} catch (DbManagerException e) {
			throw new ValidationManagerException(new Message(Messages.ERROR_RECUPERO_DB));
		}

	}

	/**
	 * Controllo che la data di controllo o assegnazione  Bollino sia uguale o successiva alla data di ritiro dei bollini
	  * @param String dataTransazione/ritiro
	  * @param String dataControllo
	  * @throws ValidationManagerException la data di controllo e' precedende a quella di ritiro
	 */
	public void verificaDataAssegnazioneBollino(String dataTransazione, String dataControllo) throws ValidationManagerException {
		boolean flag = DateUtil.checkDateOrder(dataTransazione, dataControllo, true);
		if(!flag){
			throw new ValidationManagerException(new Message(Messages.S050,dataTransazione));
		}
	}

	/**
	 * Controllo che il codice bollino sia in corso di valida' alla data controllo
	  * @param String siglaBollino
	  * @param String numeroBollino
	  * @param String dataControllo
	  * @throws ValidationManagerException il codice bollino non e' valido alla data controllo
	 */
	public boolean isVerificaCodiceBollValidoDataControllo(String siglaBollino, String numeroBollino, String dataControllo) throws ValidationManagerException {
		boolean isValido = false;
		try {
			List<SigitTCodiceBollDto> list = getDbMgr().getCodiceBollInDataControllo(siglaBollino, numeroBollino, dataControllo);
			if (list == null || list.size() == 0)
			{
				throw new ValidationManagerException(new Message(Messages.S124));
			}
			else
			{
				isValido = true;
			}
		} catch (DbManagerException e) {
			throw new ValidationManagerException(new Message(Messages.ERROR_RECUPERO_DB));
		}

		return isValido;
	}

	public boolean verificaManutentoreUnivoco(DettaglioAllegato allegato) throws ValidationManagerException {
		boolean isUnivoco = true;


		ArrayList<String> listaProgressivi = allegato.getIdApparecchiature();
		GenericUtil.eliminaCampoVuoto(listaProgressivi);

		ValidationManagerException ex = null;

		if (GenericUtil.isNullOrEmpty(listaProgressivi) || listaProgressivi.size() == 0) {
			ex = new ValidationManagerException();
			ex.addFieldRequired(ConstantsField.DATI_ALLEGATO_ID_APPARECCHIATURE);
			throw ex;
		}

		// Devo ripulire l'id della combo apparecchiature (e' comp4mnaut#fKManut#progressivo), devo recupero il progressivo
		ArrayList<String> elencoProgressivi = GenericUtil
				.recuperaProgressivo(allegato
						.getIdApparecchiature());

		// Questo controllo e' stato spostato qui perche' ogni app puo' avere un diverso 3 responsabile
		// controllo che esista un responsabile attivo alla data di controllo
		// Devo verificare che esista un responsabile alla data rapporto
		if (isNessunResponsabileByCodImpiantoApp(allegato.getCodiceImpianto(), allegato.getDataControllo(), allegato.getIdTipoAllegato(), elencoProgressivi))
		{
			throw new ValidationManagerException(new Message(Messages.ERROR_RESPONSABILE_DATA_RAPP_ASSENTE));
		}

		log.debug("GenericUtil.isNullOrEmpty(listaProgressivi): "+GenericUtil.isNullOrEmpty(listaProgressivi));
		log.debug("listaProgressivi.size(): "+listaProgressivi.size());

		String fkManut = null;
		for (String manutProgres : listaProgressivi) {

			String fkManutNew = GenericUtil.getFkManutentore(manutProgres);

			if (fkManut == null)
			{
				fkManut = fkManutNew;
			}
			else if (!fkManut.equals(fkManutNew))
			{
				throw new ValidationManagerException(new Message(Messages.S126));
			}
		}


		return isUnivoco;
	}

	public boolean verificaManutentoreUnivoco(DettaglioManutenzione allegato) throws ValidationManagerException {
		boolean isUnivoco = true;


		ArrayList<String> listaProgressivi = allegato.getIdApparecchiature();
		GenericUtil.eliminaCampoVuoto(listaProgressivi);

		ValidationManagerException ex = null;

		if (GenericUtil.isNullOrEmpty(listaProgressivi) || listaProgressivi.size() == 0) {
			ex = new ValidationManagerException();
			ex.addFieldRequired(ConstantsField.DATI_MANUTENZIONE_ID_APPARECCHIATURE);
			throw ex;
		}

		// Devo ripulire l'id della combo apparecchiature (e' comp4mnaut#fKManut#progressivo), devo recupero il progressivo
		ArrayList<String> elencoProgressivi = GenericUtil
				.recuperaProgressivo(allegato
						.getIdApparecchiature());

		// Questo controllo e' stato spostato qui perche' ogni app puo' avere un diverso 3 responsabile
		// controllo che esista un responsabile attivo alla data di controllo
		// Devo verificare che esista un responsabile alla data rapporto
		if (isNessunResponsabileByCodImpiantoApp(allegato.getCodiceImpianto(), allegato.getDataManut(), allegato.getIdTipoAllegato(), elencoProgressivi))
		{
			throw new ValidationManagerException(new Message(Messages.ERROR_RESPONSABILE_DATA_RAPP_ASSENTE));
		}

		log.debug("GenericUtil.isNullOrEmpty(listaProgressivi): "+GenericUtil.isNullOrEmpty(listaProgressivi));
		log.debug("listaProgressivi.size(): "+listaProgressivi.size());

		String fkManut = null;
		for (String manutProgres : listaProgressivi) {

			String fkManutNew = GenericUtil.getFkManutentore(manutProgres);

			if (fkManut == null)
			{
				fkManut = fkManutNew;
			}
			else if (!fkManut.equals(fkManutNew))
			{
				throw new ValidationManagerException(new Message(Messages.S126));
			}
		}


		return isUnivoco;
	}

	/**
	 * Controllo che in caso di manutentore con attivita' cessata, la data di controllo non sia successiva alla data di cessata attivita'
	  * @param Integer idPersonaGiuridica
	  * @param String dataControllo
	  * @throws ValidationManagerException la data di controllo e' precedende a quella di ritiro
	 */
//	public void verificaDataCessazioneAttivita(String dataControllo, Integer idPersonaGiuridica) throws ValidationManagerException {
//
//			//cerco l'eventuale data cessazione dell'attivita' del manutentore
//		try {
//			PersonaGiuridica personaGiuridica = getDbMgr().cercaPersonaGiuridicaById(idPersonaGiuridica);
//			if(GenericUtil.isNotNullOrEmpty(personaGiuridica.getDataCessazione())){
//				//vuol dire che la ditta ha cessato l'attivita
//				boolean flag = DateUtil.checkDateOrder(personaGiuridica.getDataCessazione(),dataControllo, true);
//
//				if(flag){
//					throw new ValidationManagerException(new Message(Messages.S052,personaGiuridica.getDataCessazione()));
//				}
//			}
//		} catch (DbManagerException e) {
//			throw new ValidationManagerException(new Message(Messages.ERROR_RECUPERO_DB));
//		}
//
//	}

	/**
	 * Controllo che in caso di manutentore con attivita' cessata, la data di controllo non sia successiva alla data di cessata attivita'
	  * @param String dataControllo
	  * @param String dataCessazione
	  * @throws ValidationManagerException la data di controllo e' precedende a quella di ritiro
	 */
	public void verificaDataCessazioneAttivita(String dataControllo, String dataCessazione) throws ValidationManagerException {

		//cerco l'eventuale data cessazione dell'attivita' del manutentore

		//PersonaGiuridica personaGiuridica = getDbMgr().cercaPersonaGiuridicaById(idPersonaGiuridica);
		if(GenericUtil.isNotNullOrEmpty(dataCessazione)){
			//vuol dire che la ditta ha cessato l'attivita
			boolean flag = DateUtil.checkDateOrder(dataCessazione, dataControllo, true);

			if(flag){
				throw new ValidationManagerException(new Message(Messages.S052,dataCessazione));
			}
		}
	}

//	public void verificaDataAssegnazioneREE(String codiceImpianto, String dataControllo) throws ValidationManagerException {
//
//		//verifico che la data controllo sia successiva alla data assegnazione del numero REE
//		try
//		{
//			String dataAssegnazione = getDbMgr().getDataAssegnazioneCodiceImpianto(codiceImpianto);
//			if(dataAssegnazione!=null){
//				boolean flagData = DateUtil.checkDateOrder(dataAssegnazione, dataControllo, true);
//				if(!flagData){
//
//					throw new ValidationManagerException(new Message(Messages.S051,dataAssegnazione));
//				}
//			}
//		}
//		catch (DbManagerException e) {
//			throw new ValidationManagerException(new Message(Messages.ERROR_RECUPERO_DB));
//		}
//	}

	/**
	 * Controllo se l'allegato che sto per modificare e' stato inserito o modificato dall'utente corrente
	  * @param Integer idPersonaGiuridica
	  * @param Integer idImpiantoRuoloPfPg
	  * @throws ValidationManagerException
	 */
//	public Integer verificaSeAllegatoModificabile(Integer idImpiantoRuoloPfPg, Integer idPersonaGiuridica, boolean isInvia) throws ValidationManagerException {
//
//		Integer value= null;
//		try {
//			 SigitRImpRuoloPfpgPk pk = new SigitRImpRuoloPfpgPk();
//			 pk.setIdImpRuoloPfpg(new BigDecimal(ConvertUtil.convertToString(idImpiantoRuoloPfPg)));
//			 SigitRImpRuoloPfpgDto dettaglio = getDbMgr().getSigitRImpRuoloPfpgDao().findByPrimaryKey(pk );
//			 if(dettaglio.getFkPersonaGiuridica()!=null){
//				 value = ConvertUtil.convertToInteger(dettaglio.getCodiceImpianto());
//				 if(!ConvertUtil.convertToString(idPersonaGiuridica).equalsIgnoreCase(ConvertUtil.convertToString(dettaglio.getFkPersonaGiuridica()))){
//					 if(!isInvia)
//						 throw new ValidationManagerException(new Message(Messages.S040));
//					 else
//						 throw new ValidationManagerException(new Message(Messages.S044));
//				 }
//			 }else{
//				 throw new ValidationManagerException(new Message(Messages.ERROR_RECUPERO_PERSONA_GIURIDICA));
//			 }
//
//		} catch (SigitRImpRuoloPfpgDaoException e) {
//			throw new ValidationManagerException(new Message(Messages.ERROR_RECUPERO_DB));
//		}
//		return value;
//	}

	/**
	 * Controllo se l'allegato che sto per modificare e' stato inserito o modificato dall'utente corrente
	  * @param Integer idPgAllegato
	  * @param Integer idPgUtente
	  * @throws ValidationManagerException
	 */
	public void verificaSeAllegatoModificabile(Integer idPgAllegato, Integer idPgUtente, String codMsg) throws ValidationManagerException {

		if(GenericUtil.isNotNullOrEmpty(idPgAllegato))
		{
			if(idPgAllegato.intValue() != idPgUtente.intValue())
			{

					throw new ValidationManagerException(new Message(codMsg));

			}
		}else{
			throw new ValidationManagerException(new Message(Messages.ERROR_RECUPERO_PERSONA_GIURIDICA));
		}
	}


	/**
	 * Controllo se l'impianto e' privo di valcole termostatiche
	  * @param Integer idPgAllegato
	  * @param Integer idPgUtente
	  * @throws ValidationManagerException
	 */

	public boolean isImpiantoSenzaValvoleTermostatiche(String dataControllo, BigDecimal codImpianto, boolean isIspezione) throws ValidationManagerException {

		try
		{
			SigitTImpiantoDto impianto = getDbMgr().cercaImpiantoDtoById(ConvertUtil.convertToString(codImpianto));
			List<SigitTDocAggiuntivaDto> docAgg = getDbMgr().cercaDocumentoAggDerogaByCodImpianto(codImpianto);
			boolean isDeroga = (docAgg != null && docAgg.size() > 0);

			String dataMaxValvole = getDbMgr().cercaConfigValueCarattere(
					Constants.DATA_MAX_INST_VALVOLE);
			//nel caso delle ispezioni non e' stato richiesto alcun controllo sulla data max valvole
			if (GenericUtil.isNotNullOrEmpty(impianto.getFlgTipoImpianto()) &&
					impianto.getFlgTipoImpianto().equalsIgnoreCase(Constants.COD_TIPO_IMPIANTO_CENTRALIZZATO) &&
					(isIspezione || DateUtil.checkDateOrder(dataMaxValvole, dataControllo, false)) &&
					!ConvertUtil.convertToBooleanAllways(impianto.getFlgContabilizzazione()) &&
					!isDeroga)
			{
				log.debug("RETURN TRUE");
				return true;
			}
			else
			{
				log.debug("RETURN FALSE");
				return false;
			}
		}
		catch (DbManagerException e) {
			throw new ValidationManagerException(new Message(Messages.ERROR_RECUPERO_DB));
		}

	}

	/**
	 * Controllo se l'impianto e' privo di valcole termostatiche
	  * @param Integer idPgAllegato
	  * @param Integer idPgUtente
	  * @throws ValidationManagerException
	 */

	public boolean isImpiantoTipoImpiantoValorizzato(BigDecimal codImpianto) throws ValidationManagerException {

		try
		{
			SigitTImpiantoDto impianto = getDbMgr().cercaImpiantoDtoById(ConvertUtil.convertToString(codImpianto));

			if (impianto != null && GenericUtil.isNotNullOrEmpty(impianto.getFlgTipoImpianto()))
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		catch (DbManagerException e) {
			throw new ValidationManagerException(new Message(Messages.ERROR_RECUPERO_DB));
		}

	}

	/**
	 * Controllo se IL BOLLINO PUO ANCORA ESSERE UTILIZZATO
	  * @param Integer numeroBollino
	  * @param String siglaBollino
	  * @throws ValidationManagerException
	 */
	public void isBollinoUtilizzabile(Integer numeroBollino, String siglaBollino) throws ValidationManagerException {

		try {
			 SigitTCodiceBollDto input =  new SigitTCodiceBollDto();
			 input.setNumeroBollino(new BigDecimal(ConvertUtil.convertToString(numeroBollino)));
			 input.setSiglaBollino(siglaBollino);

			 List<SigitTCodiceBollByNumeroBollinoPerPotenzaPrezzoDto> lista =
					this.getDbMgr().getSigitTCodiceBollDao().findByNumeroBollinoPerPotenzaPrezzo(input);

			 if(GenericUtil.isNullOrEmpty(lista)){
				 throw new ValidationManagerException(new Message(Messages.S064));
			 }


		} catch (SigitTCodiceBollDaoException e) {
			throw new ValidationManagerException(new Message(Messages.ERROR_RECUPERO_DB));
		}

	}

	protected void isDataFutura(String dateToCheck, String dateField) throws ValidationManagerException {
		ValidationManagerException ex = null;
		Date convertedDate = null;

		convertedDate = checkDate(dateToCheck, dateField);
		if(convertedDate.getTime() > System.currentTimeMillis()) {

			ex = new ValidationManagerException(new Message(Messages.ERROR_DATA_FUTURA));
			ex.addField(dateField);
			throw ex;
		}
	}

	protected void isDataPassata(String dateToCheck, String dateField) throws ValidationManagerException {
		ValidationManagerException ex = null;
		Date convertedDate = null;

		convertedDate = checkDate(dateToCheck, dateField);
		if(convertedDate.getTime() <= System.currentTimeMillis()) {

			ex = new ValidationManagerException(new Message(Messages.ERROR_DATA_PASSATA));
			ex.addField(dateField);
			throw ex;
		}
	}

	protected void isDataPassata(String dateToCheck, String dateField, ValidationManagerException ex) {
		try {
			isDataPassata(dateToCheck, dateField);
		} catch (ValidationManagerException e) {
			ex.addField(dateField, e.getMessage());
		}
	}

	protected void isDataFutura(String dateToCheck, String dateField, ValidationManagerException ex) {
		try {
			isDataFutura(dateToCheck, dateField);
		} catch (ValidationManagerException e) {
			ex.addField(dateField, e.getMessage());
		}
	}

	public void validazioneFormaleRicercaAvanzataImpianto(RicercaAvanzataImpianti ric) throws ValidationManagerException {
		ValidationManagerException ex = null;

		log.debug("Stampo RicercaAvanzataImpianti: "+ric);

		if (log.isDebugEnabled())
		{
			if (ric != null)
			{
				GenericUtil.stampa(ric, true, 3);
			}
		}

		if(GenericUtil.isNullOrEmpty(ric.getCodiceImpianto()) &&
				GenericUtil.isNullOrEmpty(ric.getIdProvincia()) &&
				GenericUtil.isNullOrEmpty(ric.getIdComune()) &&
				GenericUtil.isNullOrEmpty(ric.getDescComune()) &&
				GenericUtil.isNullOrEmpty(ric.getIndirizzo()) &&
				GenericUtil.isNullOrEmpty(ric.getCfResponsabile()) &&
				GenericUtil.isNullOrEmpty(ric.getIdSiglaRea()) &&
				GenericUtil.isNullOrEmpty(ric.getNumeroRea()) &&
				GenericUtil.isNullOrEmpty(ric.getCfImpresa()) &&
				GenericUtil.isNullOrEmpty(ric.getTipoRapporto()) &&
				GenericUtil.isNullOrEmpty(ric.getSezione()) &&
				GenericUtil.isNullOrEmpty(ric.getParticella()) &&
				GenericUtil.isNullOrEmpty(ric.getFoglio()) &&
				GenericUtil.isNullOrEmpty(ric.getSubalterno()) &&
				GenericUtil.isNullOrEmpty(ric.getPod()) &&
				GenericUtil.isNullOrEmpty(ric.getPdr()) &&
				GenericUtil.isNullOrEmpty(ric.getPotenzaAcsDa()) &&
				GenericUtil.isNullOrEmpty(ric.getPotenzaAcsA()) &&
				GenericUtil.isNullOrEmpty(ric.getPotenzaClimaEstDa()) &&
				GenericUtil.isNullOrEmpty(ric.getPotenzaClimaEstA()) &&
				GenericUtil.isNullOrEmpty(ric.getPotenzaClimaInvDa()) &&
				GenericUtil.isNullOrEmpty(ric.getPotenzaClimaInvA()) &&
				GenericUtil.isNullOrEmpty(ric.getStatoImpianto()) &&
				!ric.getSenzaPdr() &&
				GenericUtil.isNullOrEmpty(ric.getSicurezzaImpianti()) &&

				GenericUtil.isNullOrEmpty(ric.getTipoImpianto()) &&
				GenericUtil.isNullOrEmpty(ric.getFlgAppareccUiExt()) &&
				GenericUtil.isNullOrEmpty(ric.getFlgContabilizzatore()) &&

				//!ric.getSicurezzaImpianti() &&
				!ConvertUtil.convertToBooleanAllways(ric.getConOsservazioni()) &&
				!ConvertUtil.convertToBooleanAllways(ric.getConRaccomandazioni()) &&
				!ConvertUtil.convertToBooleanAllways(ric.getConPrescrizioni()) &&

				GenericUtil.isNullOrEmpty(ric.getIdTipoDocumento()) &&


				GenericUtil.isNullOrEmpty(ric.getTipoComponente()) &&
				GenericUtil.isNullOrEmpty(ric.getMarca()) &&
				GenericUtil.isNullOrEmpty(ric.getCombustibile()) &&
				GenericUtil.isNullOrEmpty(ric.getRendimentoPercDa()) &&
				GenericUtil.isNullOrEmpty(ric.getRendimentoPercA()) &&
				GenericUtil.isNullOrEmpty(ric.getPotenzaTermicaDa()) &&
				GenericUtil.isNullOrEmpty(ric.getPotenzaTermicaA()) &&
				GenericUtil.isNullOrEmpty(ric.getDataInstallazioneDa()) &&
				GenericUtil.isNullOrEmpty(ric.getDataInstallazioneA()) &&

				GenericUtil.isNullOrEmpty(ric.getDataControlloDa()) &&
				GenericUtil.isNullOrEmpty(ric.getDataControlloA()) &&
				GenericUtil.isNullOrEmpty(ric.getInterventoManutentivoDa()) &&
				GenericUtil.isNullOrEmpty(ric.getInterventoManutentivoA()) &&

				GenericUtil.isNullOrEmpty(ric.getNoxDa()) &&
				GenericUtil.isNullOrEmpty(ric.getNoxA()) &&

				GenericUtil.isNullOrEmpty(ric.getSiglaBollino()) &&
				GenericUtil.isNullOrEmpty(ric.getNumeroBollino()) &&

				GenericUtil.isNullOrEmpty(ric.getIdIncaricato()) &&

				GenericUtil.isNullOrEmpty(ric.getCf3Responsabile()) &&
				GenericUtil.isNullOrEmpty(ric.getGgInserimentoContratto()) &&
				GenericUtil.isNullOrEmpty(ric.getGgRevoca()) &&
				GenericUtil.isNullOrEmpty(ric.getDataInizioContrattoDa()) &&
				GenericUtil.isNullOrEmpty(ric.getDataInizioContrattoA()) &&
				GenericUtil.isNullOrEmpty(ric.getDataFineContrattoDa()) &&
				GenericUtil.isNullOrEmpty(ric.getDataFineContrattoA()) &&
				GenericUtil.isNullOrEmpty(ric.getNumGiorniInviatoDopoDataControllo())) {
			ex = new ValidationManagerException(new Message(Messages.S010));
			throw ex;
		}
		else
		{
			if ((GenericUtil.isNotNullOrEmpty(ric.getNoxDa()) || GenericUtil.isNotNullOrEmpty(ric.getNoxA())) &&
					Constants.ALLEGATO_TIPO_1.equals(ric.getTipoRapporto()) && GenericUtil.isNullOrEmpty(ric.getIdTipoUnitaMisura()))
			{
				ex = new ValidationManagerException();

				ex.addFieldRequired(ConstantsField.RICERCA_AVANZ_IMPIANTI_ID_TIPO_UNITA_MISURA);
				throw ex;
			}

			if (!GenericUtil.isNullOrEmpty(ric.getDescComune()))
			{
				checkAlphanumericStringMinLenght(ric.getDescComune(), Constants.MIN_DES_COMUNE_LEN, ConstantsField.RICERCA_AVANZ_IMPIANTI_DESC_COMUNE);
			}
		}
	}

	public void validazioneFormaleProrogaPre( DettaglioTerzoResponsabile dett3Resp, UtenteLoggato utente) throws ValidationManagerException {
		log.debug("[ValidationMgr::validazioneFormaleProrogaPre] BEGIN");

		if (utente.getRuolo().getDescRuolo().equalsIgnoreCase(Constants.RUOLO_3RESPONSABILE) &&
				!utente.getRuolo().getCodiceFiscale().equalsIgnoreCase(dett3Resp.getCodiceFiscale()))
		{
			throw new ValidationManagerException(new Message(Messages.ERROR_CONTRATTO_NO_COMPETENZA));
		}

		if (dett3Resp.getFlgTacitoRinnovo()) {
			throw new ValidationManagerException(new Message(Messages.ERROR_DATA_PROROGA_CONTRATTO_TACITO_RINNOVO));
		}

		if (dett3Resp.getDataRevoca() != null) {
			throw new ValidationManagerException(new Message(Messages.ERROR_DATA_PROROGA_CONTRATTO_CESSATO));
		}

		log.debug("[ValidationMgr::validazioneFormaleProrogaPre] END");

	}

	public void validazioneFormaleProrogaPost(ProrogaTerzoResponsabile datiProroga, DettaglioTerzoResponsabile dett3Resp) throws ValidationManagerException {
		log.debug("[ValidationMgr::validazioneFormaleProroga3Responsabile] BEGIN");

		ValidationManagerException ex = new ValidationManagerException();

		if(GenericUtil.isNullOrEmpty(datiProroga.getDataFineContratto()))
		{
			ex.addFieldRequired(CPBECpDettaglio3Resp.APPDATA_PROROGATERZORESPONSABILE_CODE + ".dataFineContratto");
		} else if (!DateUtil.checkValideDate(datiProroga.getDataFineContratto())) {
			ex.addField(CPBECpDettaglio3Resp.APPDATA_PROROGATERZORESPONSABILE_CODE + ".dataFineContratto", Messages.ERROR_FORMALE_DATA);
		} else {
			try {
				if (ConvertUtil.convertToDate(dett3Resp.getDataFineContratto()).after(ConvertUtil.convertToDate(datiProroga.getDataFineContratto()))) {
					ex.addField(CPBECpDettaglio3Resp.APPDATA_PROROGATERZORESPONSABILE_CODE + ".dataFineContratto", Messages.ERROR_DATA_PROROGA_CONTRATTO);
				}
			} catch (Exception e) {
			}
		}

		if(ex.getFieldList()!=null && !ex.getFieldList().isEmpty()) {
			throw ex;
		}


	}

	public void validazioneFormale3Responsabile(TerzoResponsabile responsabile) throws ValidationManagerException
	{
		log.debug("[ValidationMgr::validazioneFormale3Responsabile] BEGIN");

		ValidationManagerException ex = new ValidationManagerException();

		if(GenericUtil.isNullOrEmpty(responsabile.getDataInizioContratto()))
		{
			ex.addFieldRequired(ConstantsField.GESTISCI_3_RESPONSABILE_DATA_INIZIO);
		}
		else
		{
			if(!DateUtil.checkValideDate(responsabile.getDataInizioContratto()))
				ex.addField(ConstantsField.GESTISCI_3_RESPONSABILE_DATA_INIZIO, Messages.ERROR_FORMALE_DATA);
			else
				try {
					if(ConvertUtil.convertToDate(responsabile.getDataInizioContratto()).after(new Date()))
						ex.addField(ConstantsField.GESTISCI_3_RESPONSABILE_DATA_INIZIO, Messages.ERROR_DATA_FUTURA);
				} catch (Exception e) {
				}
		}

		if(GenericUtil.isNullOrEmpty(responsabile.getDataFineContratto()))
		{
			ex.addFieldRequired(ConstantsField.GESTISCI_3_RESPONSABILE_DATA_FINE);
		}
		else if(!DateUtil.checkValideDate(responsabile.getDataFineContratto()))
		{
			ex.addField(ConstantsField.GESTISCI_3_RESPONSABILE_DATA_FINE, Messages.ERROR_FORMALE_DATA);
		}

		if(GenericUtil.isNotNullOrEmpty(responsabile.getDataFineContratto()) && GenericUtil.isNotNullOrEmpty(responsabile.getDataInizioContratto()))
		{
			try {
				if(ConvertUtil.convertToDate(responsabile.getDataFineContratto()).before(ConvertUtil.convertToDate(responsabile.getDataInizioContratto())))
				{
					ex.addField(ConstantsField.GESTISCI_3_RESPONSABILE_DATA_FINE, Messages.ERROR_DATA_FINE_AFTER_INIZIO);
				}
			} catch (Exception e) {
				ex.addField(ConstantsField.GESTISCI_3_RESPONSABILE_DATA_FINE, Messages.ERROR_FIELD_FORMAL_ERROR);
			}
		}

		if (log.isDebugEnabled())
		{
			log.debug("IsImpLocIndConfermato - validazioneFormale3Responsabile: "+(responsabile.getIsImpCodImpiantoConfermato()));
			log.debug("IsImpLocIndConfermato - validazioneFormale3Responsabile==null: "+(responsabile.getIsImpCodImpiantoConfermato()==null));
			log.debug("IsImpLocIndConfermato - validazioneFormale3Responsabile==false: "+(responsabile.getIsImpCodImpiantoConfermato()==false));
		}

		if(responsabile.getIsImpCodImpiantoConfermato()==null || ConvertUtil.convertToBooleanAllways(responsabile.getIsImpCodImpiantoConfermato())==false)
		{
			ex.addField(ConstantsField.GESTISCI_3_RESPONSABILE_COD_IMP, Messages.S086);
		}

		if(ex.getFieldList()!=null && !ex.getFieldList().isEmpty())
			throw ex;
	}



	public void validazioneFormaleDataRevocaResponsabile(CessazioneTerzaResponsabilita datiRevoca) throws ValidationManagerException
	{
		log.debug("[ValidationMgr::validazioneFormaleDataRevocaResponsabile] BEGIN");

		ValidationManagerException ex = new ValidationManagerException();

		if(GenericUtil.isNullOrEmpty(datiRevoca.getDataCessazione()))
		{
			ex.addFieldRequired(CPBECpGestLibScheda3.APPDATA_DATIREVOCARESPONSABILE_CODE + ".dataCessazione");
		}
		else
		{
			if(!DateUtil.checkValideDate(datiRevoca.getDataCessazione()))
				ex.addField(CPBECpGestLibScheda3.APPDATA_DATIREVOCARESPONSABILE_CODE + ".dataCessazione", Messages.ERROR_FORMALE_DATA);

		}

		isDataFutura(datiRevoca.getDataCessazione(), CPBECpGestLibScheda3.APPDATA_DATIREVOCARESPONSABILE_CODE + ".dataCessazione", ex);

		//validazione tipo cessazione
		if (GenericUtil.isNullOrEmpty(datiRevoca.getIdTipoCessazione())) {
			ex.addFieldRequired(CPBECpGestLibScheda3.APPDATA_DATIREVOCARESPONSABILE_CODE + ".idTipoCessazione");
		}

		if (GenericUtil.isNullOrEmpty(datiRevoca.getMotivoCessazione())) {
			ex.addFieldRequired(CPBECpGestLibScheda3.APPDATA_DATIREVOCARESPONSABILE_CODE + ".motivoCessazione");
		} else {
			checkAsciiStringMaxLength(datiRevoca.getMotivoCessazione(), 100, CPBECpGestLibScheda3.APPDATA_DATIREVOCARESPONSABILE_CODE + ".motivoCessazione", ex);
		}

		if(ex.getFieldList()!=null && !ex.getFieldList().isEmpty())
			throw ex;

	}

	public ImportFilter validazioneXmlImport(String fileName, FileReader fileReader, byte[] theXml, UtenteLoggato utente) throws ValidationManagerException
	{
		log.debug("validazioneXmlImport START");

		// BEPPE - NEW

		log.debug("nome file: " + fileName);
		try{
			//FileReader fileReader = new FileReader(file);
			//log.debug("fileReader ok");
			//String readFile = XmlBeanUtils.readFile(new FileReader(file));
			//String readFile = XmlBeanUtils.readFile(fileReader);

			String codiceImpianto;
			String siglaRea;
			String numeroRea;
			String codiceFiscale;
			Calendar dataControllo;
			Integer idRuolo;
			String tipoAllegato="";
			String idTipoAllegato;
			//String codiceBollino = null;
			ArrayList<String> listaProgressivi = new ArrayList<String>();
			ArrayList<String> listaIdCom4Manut = new ArrayList<String>();

			List<RowAllegatoII> listaRowII = null;
			List<RowAllegatoIII> listaRowIII = null;
			List<RowAllegatoIV> listaRowIV = null;
			List<RowAllegatoV> listaRowV = null;

			//byte[] theXml = null;
			if(fileName.toLowerCase().startsWith(Constants.PREFIX_NOME_XSD_IMPORT_ALL_II.toLowerCase()))
			{
				log.debug("lettura xml dell'allegato 2");
				InputStreamReader xmlSchemaReader = new InputStreamReader(GenericUtil.getFileInClassPath(Constants.XML_IMPORT_ALLEGATO_II_SCHEMA_DIR));

//				if (log.isDebugEnabled())
//				{
//					log.debug("Stampo xmlSchemaReader: "+xmlSchemaReader);
//					log.debug("Stampo fileReader: "+fileReader);
//
//				}

				XmlValidator.validate(fileReader, xmlSchemaReader);
				//theXml = XmlBeanUtils.readString(readFile);
				log.debug("xml as byte[] readed");
				it.csi.sigit.sigitwebn.xml.importmassivo.allegato2.data.MODIIDocument document = MapDto.mapToImportMODIIDocument(theXml);
				log.debug("convertito xml in java");
				it.csi.sigit.sigitwebn.xml.importmassivo.allegato2.data.RichiestaDocument.Richiesta richiesta = document.getMODII().getRichiesta();
				codiceImpianto = richiesta.getDatiIntestazione().getCodiceCatasto();
				DatiManutentore manutentore = richiesta.getDatiManutentore();
				siglaRea = manutentore.getSiglaREA();
				numeroRea = manutentore.getNumeroREA();
				codiceFiscale = manutentore.getCodiceFiscale();
				dataControllo = richiesta.getDatiIntestazione().getAFDataControllo();
				//codiceBollino = richiesta.getDatiIntestazione().getCodiceBollino();
				listaRowII = richiesta.getDatiAllegato().getAllegatoII().getRowAllegatoIIList();

				idRuolo = Constants.ID_RUOLO_MANUTENTORE_ALL_1;
				tipoAllegato = Constants.DES_DOC_TIPO_1;
				idTipoAllegato = Constants.ALLEGATO_TIPO_1;

			}
			else if(fileName.toLowerCase().startsWith(Constants.PREFIX_NOME_XSD_IMPORT_ALL_III.toLowerCase()))
			{
				log.debug("lettura xml dell'allegato 3");
				XmlValidator.validate(fileReader, new InputStreamReader(GenericUtil.getFileInClassPath(Constants.XML_IMPORT_ALLEGATO_III_SCHEMA_DIR)));
				//theXml = XmlBeanUtils.readString(readFile);
				it.csi.sigit.sigitwebn.xml.importmassivo.allegato3.data.MODIIIDocument document = MapDto.mapToImportMODIIIDocument(theXml);
				it.csi.sigit.sigitwebn.xml.importmassivo.allegato3.data.RichiestaDocument.Richiesta richiesta = document.getMODIII().getRichiesta();
				codiceImpianto = richiesta.getDatiIntestazione().getCodiceCatasto();
				it.csi.sigit.sigitwebn.xml.importmassivo.allegato3.data.DatiManutentoreDocument.DatiManutentore manutentore = richiesta.getDatiManutentore();
				siglaRea = manutentore.getSiglaREA();
				numeroRea = manutentore.getNumeroREA();
				codiceFiscale = manutentore.getCodiceFiscale();
				dataControllo = richiesta.getDatiIntestazione().getAFDataControllo();
				//codiceBollino = richiesta.getDatiIntestazione().getCodiceBollino();
				listaRowIII = richiesta.getDatiAllegato().getAllegatoIII().getRowAllegatoIIIList();

				idRuolo = Constants.ID_RUOLO_MANUTENTORE_ALL_2;
				tipoAllegato = Constants.DES_DOC_TIPO_2;
				idTipoAllegato = Constants.ALLEGATO_TIPO_2;

			}
			else if(fileName.toLowerCase().startsWith(Constants.PREFIX_NOME_XSD_IMPORT_ALL_IV.toLowerCase()))
			{
				log.debug("lettura xml dell'allegato 4");
				XmlValidator.validate(fileReader, new InputStreamReader(GenericUtil.getFileInClassPath(Constants.XML_IMPORT_ALLEGATO_IV_SCHEMA_DIR)));
				//theXml = XmlBeanUtils.readString(readFile);
				it.csi.sigit.sigitwebn.xml.importmassivo.allegato4.data.MODIVDocument document = MapDto.mapToImportMODIVDocument(theXml);
				it.csi.sigit.sigitwebn.xml.importmassivo.allegato4.data.RichiestaDocument.Richiesta richiesta = document.getMODIV().getRichiesta();
				codiceImpianto = richiesta.getDatiIntestazione().getCodiceCatasto();
				it.csi.sigit.sigitwebn.xml.importmassivo.allegato4.data.DatiManutentoreDocument.DatiManutentore manutentore = richiesta.getDatiManutentore();
				siglaRea = manutentore.getSiglaREA();
				numeroRea = manutentore.getNumeroREA();
				codiceFiscale = manutentore.getCodiceFiscale();
				dataControllo = richiesta.getDatiIntestazione().getAFDataControllo();
				//codiceBollino = richiesta.getDatiIntestazione().getCodiceBollino();
				listaRowIV = richiesta.getDatiAllegato().getAllegatoIV().getRowAllegatoIVList();

				idRuolo = Constants.ID_RUOLO_MANUTENTORE_ALL_3;
				tipoAllegato = Constants.DES_DOC_TIPO_3;
				idTipoAllegato = Constants.ALLEGATO_TIPO_3;

			}
			else if(fileName.toLowerCase().startsWith(Constants.PREFIX_NOME_XSD_IMPORT_ALL_V.toLowerCase()))
			{
				log.debug("lettura xml dell'allegato 5");
				XmlValidator.validate(fileReader, new InputStreamReader(GenericUtil.getFileInClassPath(Constants.XML_IMPORT_ALLEGATO_V_SCHEMA_DIR)));
				//theXml = XmlBeanUtils.readString(readFile);
				it.csi.sigit.sigitwebn.xml.importmassivo.allegato5.data.MODVDocument document = MapDto.mapToImportMODVDocument(theXml);
				it.csi.sigit.sigitwebn.xml.importmassivo.allegato5.data.RichiestaDocument.Richiesta richiesta = document.getMODV().getRichiesta();
				codiceImpianto = richiesta.getDatiIntestazione().getCodiceCatasto();
				it.csi.sigit.sigitwebn.xml.importmassivo.allegato5.data.DatiManutentoreDocument.DatiManutentore manutentore = richiesta.getDatiManutentore();
				siglaRea = manutentore.getSiglaREA();
				numeroRea = manutentore.getNumeroREA();
				codiceFiscale = manutentore.getCodiceFiscale();
				dataControllo = richiesta.getDatiIntestazione().getAFDataControllo();
				//codiceBollino = richiesta.getDatiIntestazione().getCodiceBollino();
				listaRowV = richiesta.getDatiAllegato().getAllegatoV().getRowAllegatoVList();

				idRuolo = Constants.ID_RUOLO_MANUTENTORE_ALL_4;
				tipoAllegato = Constants.DES_DOC_TIPO_4;
				idTipoAllegato = Constants.ALLEGATO_TIPO_4;

			}
			else
			{
				log.debug("Nome file non conosciuto");
				throw new ValidationManagerException(new Message(Messages.S097));
			}
			log.debug("tipo allegato: " + tipoAllegato);

			if (!isImpiantoTipoImpiantoValorizzato(ConvertUtil.convertToBigDecimal(codiceImpianto)))
			{
				log.debug("Dati impianto non aggiornati");
				throw new ValidationManagerException(new Message(Messages.S157, codiceImpianto));
			}

			// Nel caso di IMPRESA o SOGG. DELEGATO per IMPRESA devo
			// verificare che il manutentore indicato (tag siglaREA, numeroREA, codiceFiscale) sia l'IMPRESA loggata (che nonc arichi REE di un altro manutentore)
			if (utente.getRuolo().getDescRuolo().equalsIgnoreCase(Constants.RUOLO_IMPRESA) ||
					utente.getRuolo().getDescRuolo().equalsIgnoreCase(Constants.CAT_RUOLO_IMPRESA))
			{
				if (!(utente.getRuolo().getSiglaRea().equalsIgnoreCase(siglaRea) &&
						ConvertUtil.convertToString(utente.getRuolo().getNumeroRea()).equalsIgnoreCase(numeroRea) &&
						utente.getRuolo().getCodiceFiscale().equalsIgnoreCase(codiceFiscale)))
				{
					log.debug("L'impresa indicata nell'xml e' diversa da quella loggata");
					throw new ValidationManagerException(new Message(Messages.S044));

				}
			}

			//controllo validita' dati sul db
			//Verificare che per il codice impianto esista un libretto (SIGIT_T_LIBRETTO) in stato consolidato.
			List<SigitTLibrettoDto> librettoConsolidato = getDbMgr().cercaLibrettoByStato(codiceImpianto, Constants.ID_STATO_LIBRETTO_CONSOLIDATO);
			if(librettoConsolidato==null || librettoConsolidato.isEmpty())
			{
				log.debug("Libretto consolidato non trovato");
				throw new ValidationManagerException(new Message(Messages.S099, codiceImpianto));
			}

			log.debug("[ValidationMgr::verificaXmlAllegato] Step 3.2.2 � data controllo futura");
			// Verifico che la data controllo non sia futura
			if (ConvertUtil.convertToDate(dataControllo).getTime() > System.currentTimeMillis()) {
				throw new ValidationManagerException(new Message(Messages.S102, ConvertUtil.convertToString(dataControllo)));

			}

			// FORSE LA POSSO FARE DOPO
			/*
			log.debug("[ValidationMgr::verificaXmlAllegato] Step 3.2.3 � data intervento minore di data controllo");
			verificaDataIntervento(ConvertUtil.convertToString(dataControllo),
					ConvertUtil.convertToString(dataIntervento));
			*/


//			Verificare che il manutentore indicato (tag siglaREA, numeroREA, codiceFiscale) esista su SIGIT_T_PERSONA_GIURIDICA
			List<SigitTPersonaGiuridicaDto> pgList = getDbMgr().cercaPersonaGiuridica(codiceFiscale, siglaRea, ConvertUtil.convertToBigDecimal(numeroRea), false);
			SigitTPersonaGiuridicaDto pg = null;
			if(pgList==null || pgList.isEmpty())
			{
				log.debug("Persona giuridica non trovata");
				throw new ValidationManagerException(new Message(Messages.S100, MapDto.getCodiceRea(siglaRea, ConvertUtil.convertToInteger(numeroRea))));
			}


			// Setto la PersonaGiuridica
			pg = pgList.get(0);

			if (pg.getFkStatoPg().intValue() == Constants.ID_STATO_IMPRESA_SOSPESA
					|| pg.getFkStatoPg().intValue() == Constants.ID_STATO_IMPRESA_RADIATA) {
				throw new ValidationManagerException(
						new Message(Messages.S147, MapDto.getCodiceRea(pg.getSiglaRea(), pg.getNumeroRea()), pg
								.getCodiceFiscale()));
			}

			//controllo se il manutentore indicato non abbia l'attivita' cessata
			verificaDataCessazioneAttivita(ConvertUtil.convertToString(dataControllo),
					ConvertUtil.convertToString(pgList.get(0).getDataCessazione()));


//			Verificare che il manutentore indicato (tag siglaREA, numeroREA, codiceFiscale) abbia una associazione attiva alla data
//			del controllo (tag A_F_dataControllo) su SIGIT_R_IMP_RUOLO_PFPG per il codice impianto indicato (tag codiceCatasto) e per il tipo allegato indicato
//			ImpiantoFilter filter = new ImpiantoFilter();
//			filter.setCodiceImpianto(ConvertUtil.convertToInteger(codiceImpianto));
//			filter.setRuolo(idRuolo);
//			filter.setIdPersonaGiuridica(pg.get(0).getIdPersonaGiuridica());
//			filter.setDataControllo(dataControllo.getTime());
//			List<SigitVTotImpiantoDto> manAttivoAllData = getDbMgr().cercaAttiviAllDataByRuolo(filter);



			//verifico che la data controllo sia successiva alla data assegnazione del numero REE
			//verificaDataAssegnazioneREE(codiceImpianto, ConvertUtil.convertToString(dataControllo));

			//verificaCodiceBollino(codiceBollino);



			DettaglioAllegato allegato = new DettaglioAllegato();
			allegato.setCodiceImpianto(codiceImpianto);
			allegato.setDataControllo(ConvertUtil.convertToString(dataControllo));
			allegato.setIdTipoAllegato(idTipoAllegato);
			//allegato.setSiglaBollino(codiceBollino.substring(0,2));
			//allegato.setNumeroBollinoVerde(codiceBollino.substring(3));
			allegato.setIdPersonaGiuridica(ConvertUtil.convertToInteger(pg.getIdPersonaGiuridica()));
			//allegato.setIdCom4Manut(listaIdCom4Manut);


/*
			// Beppe - escluso controllo per bollino automatico
			isVerificaCodiceBollValidoDataControllo(Constants.SIGLA_BOLLINO_RP, allegato.getNumeroBollinoVerde(), allegato.getDataControllo());
*/

//			try
//			{

			/*
			if (GenericUtil.isNotNullOrEmpty(allegato
					.getNumeroBollinoVerde())) {
				//controllo se il numero bollino indicato non sia stato assegnato a ad altro impianto
				isBollinoAssegnatoAltroImpianto(
						allegato.getNumeroBollinoVerde(),
						allegato.getIdAllegato());

				//verifico che il bollino comprato sia ancora utilizzabile

				isBollinoUtilizzabile(
						ConvertUtil.convertToInteger(allegato
								.getNumeroBollinoVerde()),
						allegato.getSiglaBollino());


				//controllo se abbiano inserito il numero bollino che non e' obbligatorio
				if (GenericUtil.isNotNullOrEmpty(allegato
						.getNumeroBollinoVerde())) {

					BigDecimal idTransazione = getDbMgr()
							.cercaIdTransazioneCodBollinoAssegnatoAdUtente(
									ConvertUtil.convertToInteger(allegato
											.getNumeroBollinoVerde()),
											ConvertUtil.convertToInteger(pg.getIdPersonaGiuridica()),
											allegato.getSiglaBollino());
					if (idTransazione == null) {
						//lancio l'eccezione perche' vuol dire che il numero bollino cercato non corrisponde all'utente loggato
						throw new ValidationManagerException(new Message(Messages.S049));

					}

				}

			}
			*/
//			} catch (ManagerException e) {
//				throw new ValidationManagerException(new Message(Messages.ERROR_RECUPERO_DB));
//			}


			/*
			// Punto 3.6
			if (!isCodiceBollinoDelManutentore(codiceBollino, pg.getIdPersonaGiuridica()))
			{
				log.debug("[ValidationMgr::validazioneXmlImport] Step 3.6 � Verifica se codice bollino e' del manutentore");

				throw new ValidationManagerException(new Message(Messages.S103, codiceBollino, MapDto.getCodiceRea(siglaRea, ConvertUtil.convertToInteger(numeroRea))));
			}
			*/

			/*
			// Punto 3.7
			if (!isCodiceBollinoLibero(codiceBollino))
			{
				log.debug("[ValidationMgr::validazioneXmlImport] Step 3.7 � Verifica se codice bollino libero");

				throw new ValidationManagerException(new Message(Messages.S104, codiceBollino));
			}
			*/

			if (tipoAllegato.equals(Constants.DES_DOC_TIPO_1))
			{
				ArrayList<BigInteger> moduliTermiciList = new ArrayList<BigInteger>();

				List<SigitVSk4GtDto> listGt = getDbMgr().getCompGtAttiviInDataByIdPg(codiceImpianto, ConvertUtil.convertToDate(dataControllo), pg.getIdPersonaGiuridica());

				if (listaRowII == null || listGt == null)
				{
					throw new ValidationManagerException(new Message(Messages.S105, "rowAllegatoII"));
				}

				for (int i = 0; i < listaRowII.size(); i++) {
					RowAllegatoII rowAllegatoII = listaRowII.get(i);
					SigitVSk4GtDto gt = null;

					moduliTermiciList.clear();

					boolean isTrovato = false;

					for (int z = 0; z < listGt.size(); z++) {
						gt = listGt.get(z);
						if (rowAllegatoII.getAENumGT().intValue() == gt.getProgressivo().intValue())
						{
							// Vuol dire che go trovato la riga anche sul DB
							isTrovato = true;

							// Aggiungo il rpogressivo alla lista, mi serve per verificare se esiste il responsabile/3responsabile
							listaProgressivi.add(ConvertUtil.convertToString(rowAllegatoII.getAENumGT()));

							break;
						}
					}

					if (!isTrovato)
					{
						// Il numero del GT non � corretto, non risulta associato al manutentore
						throw new ValidationManagerException(new Message(Messages.S106, GenericUtil.getDescSezioneComp(Constants.TIPO_COMPONENTE_GT, rowAllegatoII.getAENumGT()), MapDto.getCodiceRea(pg.getSiglaRea(), ConvertUtil.convertToInteger(pg.getNumeroRea()))));
						// La componente GT rowAllegatoII.getAENumGT() non risulta associato al manutentore pg.getSiglaRea() + NumRFea
					}

					List<it.csi.sigit.sigitwebn.xml.importmassivo.allegato2.data.RowFumiDocument.RowFumi> listFumi = rowAllegatoII.getTabFumi().getRowFumiList();

					int nModuliDb = GenericUtil.isNotNullOrEmpty(gt.getNModuli())?gt.getNModuli().intValue() : 1;

					if (listFumi.size() != nModuliDb)
					{
						log.debug("[ValidationMgr::validazioneXmlImport] Step 3.10 � Il numero dei row fumi XML non corrisponde con il numero di row fumi del DB");

						// Non corrispondono le righe
						throw new ValidationManagerException(new Message(Messages.S107_GT, codiceImpianto));
					}

					for (int j = 0; j < listFumi.size(); j++) {
						it.csi.sigit.sigitwebn.xml.importmassivo.allegato2.data.RowFumiDocument.RowFumi rowFumi = listFumi.get(j);



						if (moduliTermiciList.contains(rowFumi.getAEModuloTermico()))
						{
							// Il numero del modulo non � corretto, � gi� presente lo stesso numero A_E_moduloTermico
							throw new ValidationManagerException(new Message(Messages.S105, "A_E_moduloTermico"));
						}
						else
						{
							moduliTermiciList.add(rowFumi.getAEModuloTermico());
						}
					}

					for (int j = 1; j <= nModuliDb; j++) {

						if (!moduliTermiciList.contains(new BigInteger(ConvertUtil.convertToString(j))))
						{
							// l'utente ha inserito un numero modulo non corretto, ad es: sul db c'� rolo 1 numero modulo, l'utente ci ha passato 1 solo rowFumi ma come numero ha settato 2
							throw new ValidationManagerException(new Message(Messages.S107_GT, codiceImpianto));
						}
					}
				}
			}
			else if (tipoAllegato.equals(Constants.DES_DOC_TIPO_2))
			{

				List<SigitVSk4GfDto> listGf = getDbMgr()
						.getCompGfAttiviInDataByIdPg(codiceImpianto, ConvertUtil.convertToDate(dataControllo), pg.getIdPersonaGiuridica());


				if (listaRowIII == null || listGf == null)
				{
					// Ci vuole unS MSG specifico?
					throw new ValidationManagerException(new Message(Messages.S105, "rowAllegatoIII"));
				}

				ArrayList<BigInteger> numCircuitoList = new ArrayList<BigInteger>();
				//ArrayList<String> listaProgressivi = new ArrayList<String>();

				for (int i = 0; i < listaRowIII.size(); i++) {
					RowAllegatoIII rowAllegatoIII = listaRowIII.get(i);

					numCircuitoList.clear();

					boolean isTrovato = false;
					SigitVSk4GfDto gf = null;
					for (int z = 0; z < listGf.size(); z++) {
						gf = listGf.get(z);
						if (rowAllegatoIII.getAENumGF().intValue() == gf.getProgressivo().intValue())
						{
							isTrovato = true;

							// Aggiungo il progressivo alla lista, mi serve per verificare se esiste il responsabile/3responsabile
							listaProgressivi.add(ConvertUtil.convertToString(rowAllegatoIII.getAENumGF()));

							break;
						}
					}

					if (!isTrovato)
					{
						// Il numero del GF non � corretto, non risulta associato al manutentore
						throw new ValidationManagerException(new Message(Messages.S106, GenericUtil.getDescSezioneComp(Constants.TIPO_COMPONENTE_GF, rowAllegatoIII.getAENumGF()), MapDto.getCodiceRea(pg.getSiglaRea(), ConvertUtil.convertToInteger(pg.getNumeroRea()))));

					}

					List<it.csi.sigit.sigitwebn.xml.importmassivo.allegato3.data.RowFumiDocument.RowFumi> listFumi = rowAllegatoIII.getTabFumi().getRowFumiList();

					int nCircuitiDb = GenericUtil.isNotNullOrEmpty(gf.getNCircuiti())?gf.getNCircuiti().intValue() : 1;

					if (listFumi.size() != nCircuitiDb)
					{
						log.debug("[ValidationMgr::validazioneXmlImport] Step 3.10 � Il numero dei row fumi XML non corrisponde con il numero di row circuito del DB");

						// Non corrispondono le righe
						throw new ValidationManagerException(new Message(Messages.S107_GF, codiceImpianto));
					}


					for (int j = 0; j < listFumi.size(); j++) {
						it.csi.sigit.sigitwebn.xml.importmassivo.allegato3.data.RowFumiDocument.RowFumi rowFumi = listFumi.get(j);


						if (numCircuitoList.contains(rowFumi.getAENumCircuito()))
						{
							// Il numero del modulo non � corretto, � gi� presente lo stesso numero A_E_numCircuito
							throw new ValidationManagerException(new Message(Messages.S105, "A_E_numCircuito"));
						}
						else
						{
							numCircuitoList.add(rowFumi.getAENumCircuito());
						}
					}

					for (int j = 1; j <= nCircuitiDb; j++) {

						if (!numCircuitoList.contains(new BigInteger(ConvertUtil.convertToString(j))))
						{
							// l'utente ha inserito un numero modulo non corretto, ad es: sul db c'� rolo 1 numero circuito, l'utente ci ha passato 1 solo rowFumi ma come numero ha settato 2
							throw new ValidationManagerException(new Message(Messages.S107_GF, codiceImpianto));
						}
					}

					//it.csi.sigit.sigitwebn.xml.importmassivo.allegato3.data.ControlloVerificaEnergeticaDocument.ControlloVerificaEnergetica controlloVEner = rowAllegatoIII.getControlloVerificaEnergetica();
				}

			}
			else if (tipoAllegato.equals(Constants.DES_DOC_TIPO_3))
			{
				List<SigitVSk4ScDto> listSc = getDbMgr().getCompScAttiviInDataByIdPg(codiceImpianto, ConvertUtil.convertToDate(dataControllo), pg.getIdPersonaGiuridica());


				if (listaRowIV == null || listSc == null)
				{
					// Ci vuole unS MSG specifico?
					throw new ValidationManagerException(new Message(Messages.S105, "rowAllegatoIV"));
				}
				/*
				else if (listaRow.size() != listSc.size())
				{

					log.debug("[ValidationMgr::validazioneXmlImport] Step 3.8 � Il numero dei row XML non corrisponde con il numero dei SC sul DB");

					// Non corrispondono le righe
					throw new ValidationManagerException(new Message(Messages.S106, codImpianto));
				}
				*/

				//ArrayList<String> listaProgressivi = new ArrayList<String>();

				for (int i = 0; i < listaRowIV.size(); i++) {
					RowAllegatoIV rowAllegatoIV = listaRowIV.get(i);

					SigitVSk4ScDto sc = null;

					boolean isTrovato = false;
					for (int z = 0; z < listSc.size(); z++) {
						sc = listSc.get(z);
						if (rowAllegatoIV.getAENumSC().intValue() == sc.getProgressivo().intValue())
						{
							isTrovato = true;

							// Aggiungo il rpogressivo alla lista, mi serve per verificare se esiste ilr esponsabile/3responsabile
							listaProgressivi.add(ConvertUtil.convertToString(rowAllegatoIV.getAENumSC()));

							break;
						}
					}

					if (!isTrovato)
					{
						// Il numero del SC non � corretto, non risulta associato al manutentore
						throw new ValidationManagerException(new Message(Messages.S106, GenericUtil.getDescSezioneComp(Constants.TIPO_COMPONENTE_SC, rowAllegatoIV.getAENumSC()), MapDto.getCodiceRea(pg.getSiglaRea(), ConvertUtil.convertToInteger(pg.getNumeroRea()))));

					}

					it.csi.sigit.sigitwebn.xml.importmassivo.allegato4.data.ControlloVerificaEnergeticaDocument.ControlloVerificaEnergetica controlloVEner = rowAllegatoIV.getControlloVerificaEnergetica();


					if (!GenericUtil.checkValideNumber(controlloVEner.getAECombustibile()) ||
							getDbMgr().getFluidoById(ConvertUtil.convertToInteger(controlloVEner.getAECombustibile())) == null)
					{
						// Il codice fluido � inesistente
						throw new ValidationManagerException(new Message(Messages.S105, "A_E_combustibile"));

					}

					if (!GenericUtil.checkValideNumber(controlloVEner.getAEFluidoVett()) ||
							getDbMgr().getFluidoById(ConvertUtil.convertToInteger(controlloVEner.getAEFluidoVett())) == null)
					{
						// Il codice fluido � inesistente
						throw new ValidationManagerException(new Message(Messages.S105, "A_E_fluidoVett"));

					}
				}
			}
			else if (tipoAllegato.equals(Constants.DES_DOC_TIPO_4))
			{
				//List<RowAllegatoV> listaRow = richiesta.getDatiAllegato().getAllegatoV().getRowAllegatoVList();
				List<SigitVSk4CgDto> listCg = getDbMgr().getCompCgAttiviInDataByIdPg(codiceImpianto, ConvertUtil.convertToDate(dataControllo), pg.getIdPersonaGiuridica());

				if (listaRowV == null || listCg == null)
				{
					// Ci vuole unS MSG specifico?
					throw new ValidationManagerException(new Message(Messages.S105, "rowAllegatoV"));
				}
				/*
				else if (listaRow.size() != listCg.size())
				{

					log.debug("[ValidationMgr::validazioneXmlImport] Step 3.8 � Il numero dei row XML non corrisponde con il numero dei CG sul DB");

					// Non corrispondono le righe
					throw new ValidationManagerException(new Message(Messages.S106, codImpianto));
				}
				*/

				//ArrayList<String> listaProgressivi = new ArrayList<String>();

				for (int i = 0; i < listaRowV.size(); i++) {
					RowAllegatoV rowAllegatoV = listaRowV.get(i);

					SigitVSk4CgDto cg = null;

					boolean isTrovato = false;
					for (int z = 0; z < listCg.size(); z++) {
						cg = listCg.get(z);
						if (rowAllegatoV.getAENumCG().intValue() == cg.getProgressivo().intValue())
						{
							isTrovato = true;

							// Aggiungo il rpogressivo alla lista, mi serve per verificare se esiste ilr esponsabile/3responsabile
							listaProgressivi.add(ConvertUtil.convertToString(rowAllegatoV.getAENumCG()));

							break;
						}
					}

					if (!isTrovato)
					{
						// Il numero del CG non � corretto, non risulta associato al manutentore
						throw new ValidationManagerException(new Message(Messages.S106, GenericUtil.getDescSezioneComp(Constants.TIPO_COMPONENTE_CG, rowAllegatoV.getAENumCG()), MapDto.getCodiceRea(pg.getSiglaRea(), ConvertUtil.convertToInteger(pg.getNumeroRea()))));

					}

					it.csi.sigit.sigitwebn.xml.importmassivo.allegato5.data.ControlloVerificaEnergeticaDocument.ControlloVerificaEnergetica controlloVEner = rowAllegatoV.getControlloVerificaEnergetica();

					if (!GenericUtil.checkValideNumber(controlloVEner.getAEFluidoVett()) ||
							getDbMgr().getFluidoById(ConvertUtil.convertToInteger(controlloVEner.getAEFluidoVett())) == null)
					{
						// Il codice fluido � inesistente
						throw new ValidationManagerException(new Message(Messages.S105, "A_E_fluidoVett"));

					}


				}
			}



//			Verificare che il manutentore indicato (tag siglaREA, numeroREA, codiceFiscale) abbia una associazione attiva alla data attuale
//			su SIGIT_R_IMP_RUOLO_PFPG per il codice impianto indicato (tag codiceCatasto) e per il tipo allegato indicato
			List<SigitRComp4ManutDto> manAttivoAttuale = getDbMgr().cercaAttualiByRuolo(codiceImpianto, pg.getIdPersonaGiuridica(), idRuolo, listaProgressivi);

			if(manAttivoAttuale==null || manAttivoAttuale.isEmpty())
			{
				log.debug("Manutentore non attivo alla data attuale");
				String msg = Messages.S101.replaceFirst("##valueCodImpianto##", codiceImpianto)
						//.replaceFirst("##valueDataControllo##", ConvertUtil.convertToString(dataControllo))
						.replaceFirst("##valueTipoAllegato##", tipoAllegato);
				throw new ValidationManagerException(new Message(msg, MapDto.getCodiceRea(siglaRea, ConvertUtil.convertToInteger(numeroRea))));
			}

			for (SigitRComp4ManutDto sigitRComp4ManutDto : manAttivoAttuale) {
				listaIdCom4Manut.add(ConvertUtil.convertToString(sigitRComp4ManutDto.getIdRComp4Manut()));
			}

			// Devo verificare che esista un responsabile alla data rapporto
			if (isNessunResponsabileByCodImpiantoApp(allegato.getCodiceImpianto(), allegato.getDataControllo(), allegato.getIdTipoAllegato(), listaProgressivi))
			{
				throw new ValidationManagerException(new Message(Messages.ERROR_RESPONSABILE_DATA_RAPP_ASSENTE));
			}


			allegato.setIdApparecchiatureFunz(listaProgressivi);

			allegato.setIdCom4Manut(listaIdCom4Manut);


			ImportFilter data = new ImportFilter();
			data.setCodiceImpianto(codiceImpianto);
			data.setDataInizio(DateUtil.getSqlDataCorrente());
			data.setNomeFile(fileName);
			data.setDatiXml(theXml);
			data.setDettaglioAllegato(allegato);
			return data;
//		} catch (IOException e) {
//			log.error("Errore: ",e);
//			throw new ValidationManagerException(new Message(Messages.S096, Constants.ESTENSIONE_XML));
		} catch (XmlValidatorException e) {
			log.debug("errore validazione xml", e);
			throw new ValidationManagerException(new Message(Messages.S098, fileName));
		} catch (DbManagerException e) {
			log.error("Errore: ", e);
			throw new ValidationManagerException(new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally
		{
			log.debug("validazioneXmlImport END");
		}
	}


	public ImportFilter validazioneXmlImportOLD(File file, String fileName) throws ValidationManagerException
	{
		log.debug("validazioneXmlImport START");
		String schemasDir = "schemaorg_apache_xmlbeans/src/src/adobe/Schemas/";
		String all2Schema = schemasDir + "Import-AllegatoII-1.0.0.xsd";
		String all3Schema = schemasDir + "Import-AllegatoIII-1.0.0.xsd";
		String all4Schema = schemasDir + "Import-AllegatoIV-1.0.0.xsd";
		String all5Schema = schemasDir + "Import-AllegatoV-1.0.0.xsd";


		log.debug("nome file: " + fileName);
		try{
			FileReader fileReader = new FileReader(file);
			log.debug("fileReader ok");
			String readFile = XmlBeanUtils.readFile(new FileReader(file));

			String codiceImpianto;
			String siglaRea;
			String numeroRea;
			String codiceFiscale;
			Calendar dataControllo;
			Integer idRuolo;
			String tipoAllegato="";

			byte[] theXml = null;
			if(fileName.toLowerCase().startsWith(Constants.PREFIX_NOME_XSD_IMPORT_ALL_II.toLowerCase()))
			{
				log.debug("lettura xml dell'allegato 2");
				InputStreamReader xmlSchemaReader = new InputStreamReader(GenericUtil.getFileInClassPath(all2Schema));
				XmlValidator.validate(fileReader, xmlSchemaReader);
				theXml = XmlBeanUtils.readString(readFile);
				log.debug("xml as byte[] readed");
				it.csi.sigit.sigitwebn.xml.importmassivo.allegato2.data.MODIIDocument document = MapDto.mapToImportMODIIDocument(theXml);
				log.debug("convertito xml in java");
				it.csi.sigit.sigitwebn.xml.importmassivo.allegato2.data.RichiestaDocument.Richiesta richiesta = document.getMODII().getRichiesta();
				codiceImpianto = richiesta.getDatiIntestazione().getCodiceCatasto();
				DatiManutentore manutentore = richiesta.getDatiManutentore();
				siglaRea = manutentore.getSiglaREA();
				numeroRea = manutentore.getNumeroREA();
				codiceFiscale = manutentore.getCodiceFiscale();
				dataControllo = richiesta.getDatiIntestazione().getAFDataControllo();
				idRuolo = Constants.ID_RUOLO_MANUTENTORE_ALL_1;
				tipoAllegato = Constants.DES_DOC_TIPO_1;
			}
			else if(fileName.toLowerCase().startsWith(Constants.PREFIX_NOME_XSD_IMPORT_ALL_III.toLowerCase()))
			{
				log.debug("lettura xml dell'allegato 3");
				XmlValidator.validate(fileReader, new InputStreamReader(GenericUtil.getFileInClassPath(all3Schema)));
				theXml = XmlBeanUtils.readString(readFile);
				it.csi.sigit.sigitwebn.xml.importmassivo.allegato3.data.MODIIIDocument document = MapDto.mapToImportMODIIIDocument(theXml);
				it.csi.sigit.sigitwebn.xml.importmassivo.allegato3.data.RichiestaDocument.Richiesta richiesta = document.getMODIII().getRichiesta();
				codiceImpianto = richiesta.getDatiIntestazione().getCodiceCatasto();
				it.csi.sigit.sigitwebn.xml.importmassivo.allegato3.data.DatiManutentoreDocument.DatiManutentore manutentore = richiesta.getDatiManutentore();
				siglaRea = manutentore.getSiglaREA();
				numeroRea = manutentore.getNumeroREA();
				codiceFiscale = manutentore.getCodiceFiscale();
				dataControllo = richiesta.getDatiIntestazione().getAFDataControllo();
				idRuolo = Constants.ID_RUOLO_MANUTENTORE_ALL_2;
				tipoAllegato = Constants.DES_DOC_TIPO_2;
			}
			else if(fileName.toLowerCase().startsWith(Constants.PREFIX_NOME_XSD_IMPORT_ALL_IV.toLowerCase()))
			{
				log.debug("lettura xml dell'allegato 4");
				XmlValidator.validate(fileReader, new InputStreamReader(GenericUtil.getFileInClassPath(all4Schema)));
				theXml = XmlBeanUtils.readString(readFile);
				it.csi.sigit.sigitwebn.xml.importmassivo.allegato4.data.MODIVDocument document = MapDto.mapToImportMODIVDocument(theXml);
				it.csi.sigit.sigitwebn.xml.importmassivo.allegato4.data.RichiestaDocument.Richiesta richiesta = document.getMODIV().getRichiesta();
				codiceImpianto = richiesta.getDatiIntestazione().getCodiceCatasto();
				it.csi.sigit.sigitwebn.xml.importmassivo.allegato4.data.DatiManutentoreDocument.DatiManutentore manutentore = richiesta.getDatiManutentore();
				siglaRea = manutentore.getSiglaREA();
				numeroRea = manutentore.getNumeroREA();
				codiceFiscale = manutentore.getCodiceFiscale();
				dataControllo = richiesta.getDatiIntestazione().getAFDataControllo();
				idRuolo = Constants.ID_RUOLO_MANUTENTORE_ALL_3;
				tipoAllegato = Constants.DES_DOC_TIPO_3;
			}
			else if(fileName.toLowerCase().startsWith(Constants.PREFIX_NOME_XSD_IMPORT_ALL_V.toLowerCase()))
			{
				log.debug("lettura xml dell'allegato 5");
				XmlValidator.validate(fileReader, new InputStreamReader(GenericUtil.getFileInClassPath(all5Schema)));
				theXml = XmlBeanUtils.readString(readFile);
				it.csi.sigit.sigitwebn.xml.importmassivo.allegato5.data.MODVDocument document = MapDto.mapToImportMODVDocument(theXml);
				it.csi.sigit.sigitwebn.xml.importmassivo.allegato5.data.RichiestaDocument.Richiesta richiesta = document.getMODV().getRichiesta();
				codiceImpianto = richiesta.getDatiIntestazione().getCodiceCatasto();
				it.csi.sigit.sigitwebn.xml.importmassivo.allegato5.data.DatiManutentoreDocument.DatiManutentore manutentore = richiesta.getDatiManutentore();
				siglaRea = manutentore.getSiglaREA();
				numeroRea = manutentore.getNumeroREA();
				codiceFiscale = manutentore.getCodiceFiscale();
				dataControllo = richiesta.getDatiIntestazione().getAFDataControllo();
				idRuolo = Constants.ID_RUOLO_MANUTENTORE_ALL_4;
				tipoAllegato = Constants.DES_DOC_TIPO_4;
			}
			else
			{
				log.debug("Nome file non conosciuto");
				throw new ValidationManagerException(new Message(Messages.S097, fileName));
			}
			log.debug("tipo allegato: " + tipoAllegato);

			if (!isImpiantoTipoImpiantoValorizzato(ConvertUtil.convertToBigDecimal(codiceImpianto)))
			{
				log.debug("Dati impianto non aggiornati");
				throw new ValidationManagerException(new Message(Messages.S157, fileName, codiceImpianto));
			}


			//controllo validita' dati sul db
			//Verificare che per il codice impianto esista un libretto (SIGIT_T_LIBRETTO) in stato consolidato.
			List<SigitTLibrettoDto> librettoConsolidato = getDbMgr().cercaLibrettoByStato(codiceImpianto, Constants.ID_STATO_LIBRETTO_CONSOLIDATO);
			if(librettoConsolidato==null || librettoConsolidato.isEmpty())
			{
				log.debug("Libretto consolidato non trovato");
				throw new ValidationManagerException(new Message(Messages.S099, fileName, codiceImpianto));
			}
//			Verificare che il manutentore indicato (tag siglaREA, numeroREA, codiceFiscale) esista su SIGIT_T_PERSONA_GIURIDICA
			List<SigitTPersonaGiuridicaDto> pgList = getDbMgr().cercaPersonaGiuridica(codiceFiscale, siglaRea, ConvertUtil.convertToBigDecimal(numeroRea), false);
			SigitTPersonaGiuridicaDto pg = null;
			if(pgList==null || pgList.isEmpty())
			{
				log.debug("Persona giuridica non trovata");
				throw new ValidationManagerException(new Message(Messages.S100, fileName, MapDto.getCodiceRea(siglaRea, ConvertUtil.convertToInteger(numeroRea))));
			}

			// Setto la PersonaGiuridica
			pg = pgList.get(0);

			if (pg.getFkStatoPg().intValue() == Constants.ID_STATO_IMPRESA_SOSPESA
					|| pg.getFkStatoPg().intValue() == Constants.ID_STATO_IMPRESA_RADIATA) {
				throw new ValidationManagerException(
						new Message(Messages.S147, MapDto.getCodiceRea(pg.getSiglaRea(), pg.getNumeroRea()), pg
								.getCodiceFiscale()));
			}


			//controllo se il manutentore indicato non abbia l'attivita' cessata
			verificaDataCessazioneAttivita(ConvertUtil.convertToString(dataControllo),
					ConvertUtil.convertToString(pgList.get(0).getDataCessazione()));


//			Verificare che il manutentore indicato (tag siglaREA, numeroREA, codiceFiscale) abbia una associazione attiva alla data
//			del controllo (tag A_F_dataControllo) su SIGIT_R_IMP_RUOLO_PFPG per il codice impianto indicato (tag codiceCatasto) e per il tipo allegato indicato
//			ImpiantoFilter filter = new ImpiantoFilter();
//			filter.setCodiceImpianto(ConvertUtil.convertToInteger(codiceImpianto));
//			filter.setRuolo(idRuolo);
//			filter.setIdPersonaGiuridica(pg.get(0).getIdPersonaGiuridica());
//			filter.setDataControllo(dataControllo.getTime());
//			List<SigitVTotImpiantoDto> manAttivoAllData = getDbMgr().cercaAttiviAllDataByRuolo(filter);


//			Verificare che il manutentore indicato (tag siglaREA, numeroREA, codiceFiscale) abbia una associazione attiva alla data attuale
//			su SIGIT_R_IMP_RUOLO_PFPG per il codice impianto indicato (tag codiceCatasto) e per il tipo allegato indicato
			List<SigitRComp4ManutDto> manAttivoAttuale = getDbMgr().cercaAttualiByRuolo(codiceImpianto, pgList.get(0).getIdPersonaGiuridica(), idRuolo);

			if(manAttivoAttuale==null || manAttivoAttuale.isEmpty())
			{
				log.debug("Manutentore non attivo alla data attuale");
				String msg = Messages.S101.replaceFirst("##valueCodImpianto##", codiceImpianto)
						//.replaceFirst("##valueDataControllo##", ConvertUtil.convertToString(dataControllo))
						.replaceFirst("##valueTipoAllegato##", tipoAllegato);
				throw new ValidationManagerException(new Message(msg, fileName, MapDto.getCodiceRea(siglaRea, ConvertUtil.convertToInteger(numeroRea))));
			}

			ImportFilter data = new ImportFilter();
			data.setCodiceImpianto(codiceImpianto);
			data.setDataInizio(DateUtil.getSqlDataCorrente());
			data.setNomeFile(fileName);
			data.setDatiXml(theXml);
			return data;
		} catch (IOException e) {
			log.error("Errore: ",e);
			throw new ValidationManagerException(new Message(Messages.S096, Constants.ESTENSIONE_XML));
		} catch (XmlValidatorException e) {
			log.debug("errore validazione xml", e);
			throw new ValidationManagerException(new Message(Messages.S098, fileName));
		} catch (DbManagerException e) {
			log.error("Errore: ", e);
			throw new ValidationManagerException(new Message(Messages.ERROR_RECUPERO_DB));
		}
		finally
		{
			log.debug("validazioneXmlImport END");
		}
	}


	private boolean verificaCodiceBollino(String codiceBollino) throws ValidationManagerException
	{
		boolean isCorrect = false;

		if (GenericUtil.isNotNullOrEmpty(codiceBollino))
		{

			if (codiceBollino.toUpperCase().startsWith(Constants.SIGLA_BOLLINO_RP+Constants.INTERVAL_SEP))
			{
				String numeroBollino = codiceBollino.substring(3);

				isCorrect = GenericUtil.isNumero(numeroBollino);

			}
		}

		if (isCorrect)
		{
			return isCorrect;
		}
		else
		{
			throw new ValidationManagerException(new Message(Messages.S103, codiceBollino));

		}
	}

	/*
	private boolean isCodiceBollinoLibero(String codiceBollino) throws ValidationManagerException
	{
		log.debug("[ValidationMgr::isCodiceBollinoLibero] BEGIN");

		boolean isLibero = false;
		try
		{
			if (GenericUtil.isNotNullOrEmpty(codiceBollino))
			{
				//int index = codiceBollino.indexOf(Constants.SIGLA_BOLLINO_RP+Constants.INTERVAL_SEP);

				//System.out.println("Stampo index: "+index);

				String siglaBollino = codiceBollino.substring(0,2);
				String numeroBollino = codiceBollino.substring(3);

				List<SigitTAllegatoDto> dtoList = getDbMgr().cercaAllegatoByCodiceBollino(siglaBollino, new ConvertUtil().convertToInteger(numeroBollino));

				isLibero = (dtoList == null || dtoList.size() == 0);

			}
		}
		catch (DbManagerException e) {
			log.error("Errore: ", e);
			throw new ValidationManagerException(new Message(Messages.ERROR_RECUPERO_DB));
		}

		log.debug("[ValidationMgr::isCodiceBollinoLibero] BEGIN");

		return isLibero;
	}
	*/

	/*
	public LibrettoDocument validazioneXmlImportLibretto(File file, String fileName) throws ValidationManagerException
	{
		log.debug("validazioneXmlImport START");
		String schemasDir = "schemaorg_apache_xmlbeans/src/src/adobe/Schemas/";
		String librettoSchema = schemasDir + "Import-Libretto-1.0.0.xsd";

		log.debug("nome file: " + fileName);
		try{
			FileReader fileReader = new FileReader(file);
			log.debug("fileReader ok");
			String readFile = XmlBeanUtils.readFile(new FileReader(file));

			log.debug("Stampo il readFile: "+readFile);

			byte[] theXml = null;
			LibrettoDocument document = null;
			LibrettoCatasto richiesta = null;
//			if(fileName.toLowerCase().startsWith(Constants.PREFIX_NOME_XSD_IMPORT_LIBRETTO.toLowerCase()))
//			{
				log.debug("lettura xml del libretto");

				InputStreamReader xmlSchemaReader = new InputStreamReader(GenericUtil.getFileInClassPath(librettoSchema));
				XmlValidator.validate(fileReader, xmlSchemaReader);
				theXml = XmlBeanUtils.readString(readFile);
				log.debug("xml as byte[] readed");
				document = MapDto.mapToLibrettoDocument(theXml);
				log.debug("convertito xml in java");
				richiesta = document.getLibretto().getLibrettoCatasto();

//			}
//			else
//			{
//				log.debug("Nome file non conosciuto");
//				throw new ValidationManagerException(new Message(Messages.S097, fileName));
//			}

			validazioneL1SchedaIdentificativa(richiesta);
			validazioneL4Generatori(richiesta);
			validazioneL5SistemiRegolazioneContabilizzazione(richiesta);
			validazioneL6Pompa(richiesta);
			validazioneL7SistemiEmissione(richiesta);
			validazioneL8Accumulo(richiesta);
			validazioneL9TeRvScxCiUtRcx(richiesta);
			validazioneL10VentilazioneMeccanica(richiesta);

			// Verifico i valori delle combo, non validati nei punti successivi
			validazioneComboXml(richiesta);

			log.debug("STAMPO IL DOCUMENT IMPORTATO - ordinato:");
			log.debug(document);

			return document;
		} catch (IOException e) {
			log.error("Errore: ",e);
			throw new ValidationManagerException(new Message(Messages.S096, Constants.ESTENSIONE_XML));
		} catch (XmlValidatorException e) {
			log.debug("errore validazione xml", e);
			throw new ValidationManagerException(new Message(Messages.S098, fileName));
		} catch (ValidationManagerException e) {
			log.debug("errore validazione xml", e);
			throw e;
		} catch (Exception e) {
			log.debug("errore validazione xml", e);
			throw new ValidationManagerException(new Message(Messages.ERROR_GENERICO, fileName));
		}


//		catch (DbManagerException e) {
//			log.error("Errore: ", e);
//			throw new ValidationManagerException(new Message(Messages.ERROR_RECUPERO_DB));
//		}
		finally
		{
			log.debug("validazioneXmlImport END");
		}
	}
	*/

	private void validazioneComboXml(LibrettoCatasto richiesta) throws ValidationManagerException
	{

		L14Consumi l14Consumi = richiesta.getL14Consumi();

		if (l14Consumi != null)
		{
			List<L141ConsumoCombustibile> l141ConCombList = l14Consumi.getL141ConsumoCombustibileList();

			for (L141ConsumoCombustibile l141ConsumoCombustibile : l141ConCombList) {

				validazioneCombustibile(l141ConsumoCombustibile.getL141Combustibile());

				validazioneUnitaMisura(l141ConsumoCombustibile.getL141UnitaMisura());

			}


			if (l14Consumi.getL143ConsumoAcqua() != null)
			{
				validazioneUnitaMisura(l14Consumi.getL143ConsumoAcqua().getL143UnitaMisura());

			}


			/*
			List<L143ConsumoAcqua> l143ConsumoAcquaList = l14Consumi.getL143ConsumoAcquaList();
			for (L143ConsumoAcqua l143ConsumoAcqua : l143ConsumoAcquaList) {

				validazioneUnitaMisura(l143ConsumoAcqua.getL143UnitaMisura());

			}
			*/

			if (l14Consumi.getL144ConsumoProdottiChimici() != null)
			{
				List<L144DatiConsumoProdottiChimici> l144DatiConsumoProdChimiciList = l14Consumi.getL144ConsumoProdottiChimici().getL144DatiConsumoProdottiChimiciList();
				for (L144DatiConsumoProdottiChimici l144DatiConsumoProdChimici : l144DatiConsumoProdChimiciList) {

					validazioneUnitaMisura(l144DatiConsumoProdChimici.getL144UnitaMisura());

				}
			}
		}
	}

	/*
	private void valadazioneDataInstDataDismisSePresImpLib(String componente, Calendar dataInstallazione, Calendar dataDismissione) throws ValidationManagerException
	{
		boolean check = DateUtil.checkDateOrderIsPresents(dataInstallazione, dataDismissione, true);

		if (!check)
		{
			throw new ValidationManagerException(new Message(Messages.S130, componente, ConvertUtil.convertToString(dataInstallazione)));
		}
	}


	private void valadazioneDataInstDataDismisImpLib(String componente, Calendar dataInstallazione, Calendar dataDismissione) throws ValidationManagerException
	{
		boolean check = DateUtil.checkDateOrder(dataInstallazione, dataDismissione, true);

		if (!check)
		{
			throw new ValidationManagerException(new Message(Messages.S130, componente, ConvertUtil.convertToString(dataInstallazione)));
		}
	}
	*/

	/*
	private void valadazioneDataInstSuccDataDismisImpLib(String componente, Calendar dataInstallazione, Calendar dataDismissione) throws ValidationManagerException
	{
		boolean check = DateUtil.checkDateOrder(dataInstallazione, dataDismissione, false);

		if (!check)
		{
			throw new ValidationManagerException(new Message(Messages.S131, componente, ConvertUtil.convertToString(dataInstallazione), ConvertUtil.convertToString(dataDismissione)));
		}
	}
	*/

	private void validazioneL1SchedaIdentificativa(LibrettoCatasto richiesta) throws ValidationManagerException
	{
		L1SchedaIdentificativa l1SchedaIdent = richiesta.getL1SchedaIdentificativa();

		/*
		if ((l1SchedaIdent.getL13ServizioACS() == null || l1SchedaIdent.getL13ServizioACS().getFlgDecimaleType() == null || !l1SchedaIdent.getL13ServizioACS().getFlgDecimaleType().getFlg()) &&
				(l1SchedaIdent.getL13ServizioClimaInv() == null || l1SchedaIdent.getL13ServizioClimaInv().getFlgDecimaleType() == null || !l1SchedaIdent.getL13ServizioClimaInv().getFlgDecimaleType().getFlg()) &&
				(l1SchedaIdent.getL13ServizioClimaEst() == null || l1SchedaIdent.getL13ServizioClimaEst().getFlgDecimaleType() == null || !l1SchedaIdent.getL13ServizioClimaEst().getFlgDecimaleType().getFlg()) &&
				(l1SchedaIdent.getL13ServizioAltro() == null || l1SchedaIdent.getL13ServizioAltro().getFlgDescrizioneType() == null || !l1SchedaIdent.getL13ServizioAltro().getFlgDescrizioneType().getFlg()))
		{
			throw new ValidationManagerException(new Message(Messages.S137, "L1_3"));
		}


		if (l1SchedaIdent.getL13ServizioACS() != null &&
				l1SchedaIdent.getL13ServizioACS().getFlgDecimaleType() != null &&
				l1SchedaIdent.getL13ServizioACS().getFlgDecimaleType().getFlg() &&
				GenericUtil.isNullOrEmpty(l1SchedaIdent.getL13ServizioACS().getFlgDecimaleType().getDecimale()))
		{
			throw new ValidationManagerException(new Message(Messages.S136, "L1_3servizioACS"));
		}

		if (l1SchedaIdent.getL13ServizioClimaInv() != null &&
				l1SchedaIdent.getL13ServizioClimaInv().getFlgDecimaleType() != null &&
				l1SchedaIdent.getL13ServizioClimaInv().getFlgDecimaleType().getFlg() &&
				GenericUtil.isNullOrEmpty(l1SchedaIdent.getL13ServizioClimaInv().getFlgDecimaleType().getDecimale()))
		{
			throw new ValidationManagerException(new Message(Messages.S136, "L1_3servizioClimaInv"));
		}

		if (l1SchedaIdent.getL13ServizioClimaEst() != null &&
				l1SchedaIdent.getL13ServizioClimaEst().getFlgDecimaleType() != null &&
				l1SchedaIdent.getL13ServizioClimaEst().getFlgDecimaleType().getFlg() &&
				GenericUtil.isNullOrEmpty(l1SchedaIdent.getL13ServizioClimaEst().getFlgDecimaleType().getDecimale()))
		{
			throw new ValidationManagerException(new Message(Messages.S136, "L1_3servizioClimaEst"));
		}


		if (l1SchedaIdent.getL13ServizioAltro() != null &&
				l1SchedaIdent.getL13ServizioAltro().getFlgDescrizioneType() != null &&
				l1SchedaIdent.getL13ServizioAltro().getFlgDescrizioneType().getFlg() &&
				GenericUtil.isNullOrEmpty(l1SchedaIdent.getL13ServizioAltro().getFlgDescrizioneType().getDescrizione()))
		{
			throw new ValidationManagerException(new Message(Messages.S135, "L1_3servizioAltro"));
		}
		*/

		if (!l1SchedaIdent.getL14FluidoAcqua() && !l1SchedaIdent.getL14FluidoAria() && GenericUtil.isNullOrEmpty(l1SchedaIdent.getL14FluidoAltro()))
		{
			throw new ValidationManagerException(new Message(Messages.S137, "1.4"));
		}

		if (!l1SchedaIdent.getL15TipoGeneratore()  && !l1SchedaIdent.getL15TipoPompa() &&
				!l1SchedaIdent.getL15TipoFrigo()  && !l1SchedaIdent.getL15TipoTelerisc() &&
				!l1SchedaIdent.getL15TipoTeleraff()  && !l1SchedaIdent.getL15TipoCogen() &&
				GenericUtil.isNullOrEmpty(l1SchedaIdent.getL15TipoAltro()))
		{
			throw new ValidationManagerException(new Message(Messages.S137, "1.5"));
		}

//		if (l1SchedaIdent.getL15TipoIntegrazioneAltro() != null &&
//				l1SchedaIdent.getL15TipoIntegrazioneAltro().getFlgDescrizioneDecimaleType() != null &&
//				l1SchedaIdent.getL15TipoIntegrazioneAltro().getFlgDescrizioneDecimaleType().getFlg() &&
//				GenericUtil.isNullOrEmpty(l1SchedaIdent.getL15TipoIntegrazioneAltro().getFlgDescrizioneDecimaleType().getDescrizione()))
//		{
//			throw new ValidationManagerException(new Message(Messages.S135));
//		}

	}

	private void validazioneL4Generatori(LibrettoCatasto richiesta) throws ValidationManagerException
	{
		L4Generatori l4Generatori = richiesta.getL4Generatori();

		// L4_1GT - L4_2BR - L4_3RC
		validazioneL4GtBrRc(l4Generatori);

		validazioneL4GfScCgCsAg(l4Generatori);
	}

	private void validazioneL4GtBrRc(L4Generatori l4Generatori) throws ValidationManagerException
	{
		// Devo verificare le date
		// devo ordinare le sostituite per data installazione

		// L4_generatori

		if (l4Generatori != null)
		{

			List<L41GT> l41GTList = l4Generatori.getL41GTList();
			List<L42BR> l42BRList = l4Generatori.getL42BRList();
			List<L43RC> l43RCList = l4Generatori.getL43RCList();

			String numComponente = null;
			List<ComparatorDto> compList = new ArrayList<ComparatorDto>();

			// Devo verificare che gli elementi BR E RC abbiano come riferimento un GT presente nel'xml

			boolean isPresente = false;
			int gtCollegato = 0;
			int numeroComp = 0;
			if (l42BRList != null && l42BRList.size() > 0)
			{
				for (L42BR l42BR : l42BRList) {

					numeroComp = l42BR.getL42Numero().intValue();

					// Recupero il GT collegato
					gtCollegato = l42BR.getL42GtCollegato().intValue();

					// Ciclo per tutti i GT, per cercare quello collegato
					for (L41GT l41GT : l41GTList) {
						if (gtCollegato == l41GT.getL41Numero().intValue())
						{
							isPresente = true;
							break;
						}
					}

					if (!isPresente)
					{
						throw new ValidationManagerException(new Message(Messages.S132, Constants.TIPO_COMPONENTE_BR, ConvertUtil.convertToString(numeroComp), ConvertUtil.convertToString(gtCollegato)));
					}
				}
			}


			if (l43RCList != null && l43RCList.size() > 0)
			{
				isPresente = false;
				gtCollegato = 0;
				numeroComp = 0;

				for (L43RC l43RC : l43RCList) {

					numeroComp = l43RC.getL43Numero().intValue();

					// Recupero il GT collegato
					gtCollegato = l43RC.getL43GtCollegato().intValue();

					// Ciclo per tutti i GT, per cercare quello collegato
					for (L41GT l41GT : l41GTList) {
						if (gtCollegato == l41GT.getL41Numero().intValue())
						{
							isPresente = true;
							break;
						}
					}

					if (!isPresente)
					{
						throw new ValidationManagerException(new Message(Messages.S132, Constants.TIPO_COMPONENTE_RC, ConvertUtil.convertToString(numeroComp), ConvertUtil.convertToString(gtCollegato)));
					}
				}
			}

			// Verificao che ci siano delle GT
			if (l41GTList != null && l41GTList.size() > 0)
			{
				for (L41GT l41Gt : l41GTList)
				{

					numComponente = ConvertUtil.convertToString(l41Gt.getL41Numero());

					L41GruppoTermico l41GruppoTermico =l41Gt.getL41GruppoTermico();

					validazioneDataInstDataDismisSePresImpLib(Constants.TIPO_COMPONENTE_GT, numComponente, l41GruppoTermico.getL41DataInstallazione(), l41GruppoTermico.getL41DataDismissione());

					// Verifico i valori delle combo
					validazioneMarca(l41GruppoTermico.getL41Fabbricante());
					validazioneCombustibile(l41GruppoTermico.getL41Combustibile());
					validazioneFluido(l41GruppoTermico.getL41Fluido());

					/*
					if (!l1SchedaIdent.getL15TipoGeneratore()  && !l1SchedaIdent.getL15TipoPompa() &&
							!l1SchedaIdent.getL15TipoFrigo()  && !l1SchedaIdent.getL15TipoTelerisc() &&
							!l1SchedaIdent.getL15TipoTeleraff()  && !l1SchedaIdent.getL15TipoCogen() &&
							(l1SchedaIdent.getL15TipoAltro() == null || l1SchedaIdent.getL15TipoAltro().getFlgDescrizioneType() == null || !l1SchedaIdent.getL15TipoAltro().getFlgDescrizioneType().getFlg()))
					{
						throw new ValidationManagerException(new Message(Messages.S137, "L1_5"));
					}
					*/

					List<L41GruppoTermicoSostituito> l41GruppoTermicoSostListOrig = l41Gt.getL41GruppoTermicoSostituitoList();

					// Verificao che ci siano delle sostituzioni
					if (l41GruppoTermicoSostListOrig != null && l41GruppoTermicoSostListOrig.size() > 0)
					{

						compList.clear();

						// Mi creo una lista specifica per fare l'ordinamento, perche' l'ordinamento con l'oggetto L51SistemaRegolazioneSostituito non funziona
						for (int i = 0; i < l41GruppoTermicoSostListOrig.size(); i++)
						{
							compList.add(new ComparatorDto(i, ConvertUtil.convertToDate(l41GruppoTermicoSostListOrig.get(i).getL41DataInstallazione())));
						}

						// ordino per dataInstallazione la lista
						Collections.sort(compList, ComparatorUtil.compareCamparatorDtoByData());

						// Dopo aver ordinato per la dataInstallazione devo ricostruire la lista di L51SistemaRegolazioneSostituito ordinati
						L41GruppoTermicoSostituito[] l41GruppoTermicoSostArray = new L41GruppoTermicoSostituito[compList.size()];

						for (int i = 0; i < compList.size(); i++) {
							l41GruppoTermicoSostArray[i] = l41GruppoTermicoSostListOrig.get(compList.get(i).getIdData());

						}

						//Risetto l'array ordinato
						l41Gt.setL41GruppoTermicoSostituitoArray(l41GruppoTermicoSostArray);



						// Recupero l'oggetto (ho notato che se riusavo l'array avevo dei problemi)
						List<L41GruppoTermicoSostituito> l41GruppoTermicoSostListNew = l41Gt.getL41GruppoTermicoSostituitoList();

						int listSize = l41GruppoTermicoSostListNew.size();

						for (int i = 0; i < listSize; i++) {

							L41GruppoTermicoSostituito l41GruppoTermicoSost = l41GruppoTermicoSostListNew.get(i);

							if (i == 0)
							{
								// Adesso che ho ordinato verifico che la dataDismissione del primo elemento (quindi quello piu' recente - l'elemento 0) sia precedente alla dataInstallazione dell'elemento attuale
								validazioneDataInstSuccDataDismisSostImpLib(Constants.TIPO_COMPONENTE_GT, numComponente, l41GruppoTermicoSost.getL41DataDismissione(), l41GruppoTermico.getL41DataInstallazione());
							}

							// Adesso che ho ordinato le date devo verificarle, sia tra dataInizio -> dataFine, che la data inizio dell'ultima sia successiva alla data fine di quella precedente
							validazioneDataInstDataDismisImpLib(Constants.TIPO_COMPONENTE_GT, numComponente, l41GruppoTermicoSost.getL41DataInstallazione(), l41GruppoTermicoSost.getL41DataDismissione());
							//DateUtil.checkDateOrder(l51SistRegSost.getL51DataInstallazione(), l51SistRegSost.getL51DataDismissione(), true);

							if (i != listSize-1)
							{
								// Esistono ancora elementi successivi, quindi controllo la data fine attuale con la data inizio successiva
								validazioneDataInstSuccDataDismisImpLib(Constants.TIPO_COMPONENTE_GT, numComponente, l41GruppoTermicoSostListNew.get(i+1).getL41DataInstallazione(), l41GruppoTermicoSost.getL41DataDismissione());

								validazioneDataInstSuccDataInstImpLib(Constants.TIPO_COMPONENTE_GT, numComponente, l41GruppoTermicoSostListNew.get(i+1).getL41DataInstallazione(), l41GruppoTermicoSost.getL41DataInstallazione());
								validazioneDataDismisSuccDataDismisImpLib(Constants.TIPO_COMPONENTE_GT, numComponente, l41GruppoTermicoSostListNew.get(i+1).getL41DataDismissione(), l41GruppoTermicoSost.getL41DataDismissione());

							}

							// Verifico i valori delle combo
							validazioneMarca(l41GruppoTermicoSost.getL41Fabbricante());
							validazioneCombustibile(l41GruppoTermicoSost.getL41Combustibile());
							validazioneFluido(l41GruppoTermicoSost.getL41Fluido());
						}


					}
				}

				// Pulisco la lista
				compList.clear();


				// DEVO CONSIDERARE CHE GLI ELEMENTI BR E RC HANNO DEI PUNTAMENTI CON IL GT (quindi devo verificare che il numero dei BR e RC sia corrispondente ad uno presente nei GT)

				// Mi creo una lista specifica per fare l'ordinamento, perche' l'ordinamento con l'oggetto L41GruppoTermicoSostituito non funziona
				for (int j = 0; j < l41GTList.size(); j++) {
					compList.add(new ComparatorDto(j, l41GTList.get(j).getL41Numero()));
				}

				// ordino per progressivo la lista
				Collections.sort(compList, ComparatorUtil.compareCamparatorDtoByProgressivo());

				// Dopo aver ordinato per la progressivo devo ricostruire la lista di L41GT ordinati
				L41GT[] l41GTArray = new L41GT[compList.size()];

				for (int i = 0; i < compList.size(); i++) {
					l41GTArray[i] = l41GTList.get(compList.get(i).getIdData());

				}

				//Risetto l'array ordinato
				l4Generatori.setL41GTArray(l41GTArray);

				// Recupero l'oggetto (ho notato che se riusavo l'array avevo dei problemi)
				List<L41GT> l41GTListNew = l4Generatori.getL41GTList();


				// Devo rinominare il progressivo (L41Numero), in modo che sia 1,2,3,ecc. Perche' l'utente potrebbe aver inserito numeri a caso...
				// Devo rinominare anche le componenti BR e RC collegate al GT che sto rinominando
				int count = 1;
				int numeroCompGtOld = 0;
				for (L41GT l51Sr : l41GTListNew) {
					numeroCompGtOld = l51Sr.getL41Numero().intValue();

					for (L42BR l42Br : l42BRList) {

						if (l42Br.getL42GtCollegato().intValue() == numeroCompGtOld)
						{
							l42Br.setL42GtCollegato(ConvertUtil.convertToBigInteger(count));
						}
					}

					for (L43RC l43Rc : l43RCList) {

						if (l43Rc.getL43GtCollegato().intValue() == numeroCompGtOld)
						{
							l43Rc.setL43GtCollegato(ConvertUtil.convertToBigInteger(count));
						}
					}

					l51Sr.setL41Numero(ConvertUtil.convertToBigInteger(count++));
				}

			}


			// Verificao che ci siano delle BR
			if (l42BRList != null && l42BRList.size() > 0)
			{
				for (L42BR l42Br : l42BRList)
				{

					numComponente = ConvertUtil.convertToString(l42Br.getL42Numero());

					L42Bruciatore l42Bruciatore =l42Br.getL42Bruciatore();

					validazioneDataInstDataDismisSePresImpLib(Constants.TIPO_COMPONENTE_BR, numComponente, l42Bruciatore.getL42DataInstallazione(), l42Bruciatore.getL42DataDismissione());

					// Verifico i valori delle combo
					validazioneMarca(l42Bruciatore.getL42Fabbricante());
					validazioneCombustibile(l42Bruciatore.getL42Combustibile());

					List<L42BruciatoreSostituito> l42BruciatoreSostListOrig = l42Br.getL42BruciatoreSostituitoList();

					// Verificao che ci siano delle sostituzioni
					if (l42BruciatoreSostListOrig != null && l42BruciatoreSostListOrig.size() > 0)
					{

						compList.clear();

						// Mi creo una lista specifica per fare l'ordinamento, perche' l'ordinamento con l'oggetto Array[] non funziona
						for (int i = 0; i < l42BruciatoreSostListOrig.size(); i++)
						{
							compList.add(new ComparatorDto(i, ConvertUtil.convertToDate(l42BruciatoreSostListOrig.get(i).getL42DataInstallazione())));
						}

						// ordino per dataInstallazione la lista
						Collections.sort(compList, ComparatorUtil.compareCamparatorDtoByData());


						// Dopo aver ordinato per la dataInstallazione devo ricostruire la lista di oggetti ordinati
						L42BruciatoreSostituito[] l42BruciatoreSostArray = new L42BruciatoreSostituito[compList.size()];

						for (int i = 0; i < compList.size(); i++) {
							l42BruciatoreSostArray[i] = l42BruciatoreSostListOrig.get(compList.get(i).getIdData());

						}

						//Risetto l'array ordinato
						l42Br.setL42BruciatoreSostituitoArray(l42BruciatoreSostArray);



						// Recupero l'oggetto (ho notato che se riusavo l'array avevo dei problemi)
						List<L42BruciatoreSostituito> l42BruciatoreSostListNew = l42Br.getL42BruciatoreSostituitoList();

						int listSize = l42BruciatoreSostListNew.size();

						for (int i = 0; i < listSize; i++) {

							L42BruciatoreSostituito l42BruciatoreSost = l42BruciatoreSostListNew.get(i);

							if (i == 0)
							{
								// Adesso che ho ordinato verifico che la dataDismissione del primo elemento (quindi quello piu' recente - l'elemento 0) sia precedente alla dataInstallazione dell'elemento attuale
								validazioneDataInstSuccDataDismisSostImpLib(Constants.TIPO_COMPONENTE_BR, numComponente, l42BruciatoreSost.getL42DataDismissione(), l42Bruciatore.getL42DataInstallazione());
							}

							// Adesso che ho ordinato le date devo verificarle, sia tra dataInizio -> dataFine, che la data inizio dell'ultima sia successiva alla data fine di quella precedente
							validazioneDataInstDataDismisImpLib(Constants.TIPO_COMPONENTE_BR, numComponente, l42BruciatoreSost.getL42DataInstallazione(), l42BruciatoreSost.getL42DataDismissione());
							//DateUtil.checkDateOrder(l51SistRegSost.getL51DataInstallazione(), l51SistRegSost.getL51DataDismissione(), true);

							if (i != listSize-1)
							{
								// Esistono ancora elementi successivi, quindi controllo la data fine attuale con la data inizio successiva
								validazioneDataInstSuccDataDismisImpLib(Constants.TIPO_COMPONENTE_BR, numComponente, l42BruciatoreSostListNew.get(i+1).getL42DataInstallazione(), l42BruciatoreSost.getL42DataDismissione());

								validazioneDataInstSuccDataInstImpLib(Constants.TIPO_COMPONENTE_BR, numComponente, l42BruciatoreSostListNew.get(i+1).getL42DataInstallazione(), l42BruciatoreSost.getL42DataInstallazione());
								validazioneDataDismisSuccDataDismisImpLib(Constants.TIPO_COMPONENTE_BR, numComponente, l42BruciatoreSostListNew.get(i+1).getL42DataDismissione(), l42BruciatoreSost.getL42DataDismissione());

							}

							// Verifico i valori delle combo
							validazioneMarca(l42BruciatoreSost.getL42Fabbricante());
							validazioneCombustibile(l42BruciatoreSost.getL42Combustibile());
						}
					}
				}

				// Pulisco la lista
				compList.clear();


				// Mi creo una lista specifica per fare l'ordinamento, perche' l'ordinamento con l'oggetto L42BruciatoreSostituito non funziona
				for (int j = 0; j < l42BRList.size(); j++) {
					compList.add(new ComparatorDto(j, l42BRList.get(j).getL42Numero()));
				}

				// ordino per progressivo la lista
				Collections.sort(compList, ComparatorUtil.compareCamparatorDtoByProgressivo());

				// Dopo aver ordinato per la progressivo devo ricostruire la lista di L42BR ordinati
				L42BR[] l42BRArray = new L42BR[compList.size()];

				for (int i = 0; i < compList.size(); i++) {
					l42BRArray[i] = l42BRList.get(compList.get(i).getIdData());

				}

				//Risetto l'array ordinato
				l4Generatori.setL42BRArray(l42BRArray);


				// Recupero l'oggetto (ho notato che se riusavo l'array avevo dei problemi)
				List<L42BR> l42BRListNew = l4Generatori.getL42BRList();


				// Devo rinominare il progressivo (L42Numero), in modo che sia 1,2,3,ecc. Perche' l'utente potrebbe aver inserito numeri a caso...
				int count = 1;
				for (L42BR l42Br : l42BRListNew) {

					l42Br.setL42Numero(ConvertUtil.convertToBigInteger(count++));
				}
			}


			// Verificao che ci siano delle RC
			if (l43RCList != null && l43RCList.size() > 0)
			{
				for (L43RC l43Rc : l43RCList)
				{

					numComponente = ConvertUtil.convertToString(l43Rc.getL43Numero());

					L43Recuperatore l43Recuperatore =l43Rc.getL43Recuperatore();

					validazioneDataInstDataDismisSePresImpLib(Constants.TIPO_COMPONENTE_RC, numComponente, l43Recuperatore.getL43DataInstallazione(), l43Recuperatore.getL43DataDismissione());

					// Verifico i valori delle combo
					validazioneMarca(l43Recuperatore.getL43Fabbricante());

					List<L43RecuperatoreSostituito> l43RecuperatoreSostListOrig = l43Rc.getL43RecuperatoreSostituitoList();

					// Verificao che ci siano delle sostituzioni
					if (l43RecuperatoreSostListOrig != null && l43RecuperatoreSostListOrig.size() > 0)
					{

						compList.clear();

						// Mi creo una lista specifica per fare l'ordinamento, perche' l'ordinamento con l'oggetto L43RecuperatoreSostituito non funziona
						for (int i = 0; i < l43RecuperatoreSostListOrig.size(); i++)
						{
							compList.add(new ComparatorDto(i, ConvertUtil.convertToDate(l43RecuperatoreSostListOrig.get(i).getL43DataInstallazione())));
						}



						// ordino per dataInstallazione la lista
						Collections.sort(compList, ComparatorUtil.compareCamparatorDtoByData());

						// Dopo aver ordinato per la dataInstallazione devo ricostruire la lista di L51SistemaRegolazioneSostituito ordinati
						L43RecuperatoreSostituito[] l43RecuperatoreSostArray = new L43RecuperatoreSostituito[compList.size()];

						for (int i = 0; i < compList.size(); i++) {
							l43RecuperatoreSostArray[i] = l43RecuperatoreSostListOrig.get(compList.get(i).getIdData());

						}

						//Risetto l'array ordinato
						l43Rc.setL43RecuperatoreSostituitoArray(l43RecuperatoreSostArray);



						// Recupero l'oggetto (ho notato che se riusavo l'array avevo dei problemi)
						List<L43RecuperatoreSostituito> l43RecuperatoreSostListNew = l43Rc.getL43RecuperatoreSostituitoList();




						int listSize = l43RecuperatoreSostListNew.size();

						for (int i = 0; i < listSize; i++) {

							L43RecuperatoreSostituito l43RecuperatoreSost = l43RecuperatoreSostListNew.get(i);

							if (i == 0)
							{
								// Adesso che ho ordinato verifico che la dataDismissione del primo elemento (quindi quello piu' recente - l'elemento 0) sia precedente alla dataInstallazione dell'elemento attuale
								validazioneDataInstSuccDataDismisSostImpLib(Constants.TIPO_COMPONENTE_RC, numComponente, l43RecuperatoreSost.getL43DataDismissione(), l43Recuperatore.getL43DataInstallazione());
							}

							// Adesso che ho ordinato le date devo verificarle, sia tra dataInizio -> dataFine, che la data inizio dell'ultima sia successiva alla data fine di quella precedente
							validazioneDataInstDataDismisImpLib(Constants.TIPO_COMPONENTE_RC, numComponente, l43RecuperatoreSost.getL43DataInstallazione(), l43RecuperatoreSost.getL43DataDismissione());
							//DateUtil.checkDateOrder(l51SistRegSost.getL51DataInstallazione(), l51SistRegSost.getL51DataDismissione(), true);

							if (i != listSize-1)
							{
								// Esistono ancora elementi successivi, quindi controllo la data fine attuale con la data inizio successiva
								validazioneDataInstSuccDataDismisImpLib(Constants.TIPO_COMPONENTE_RC, numComponente, l43RecuperatoreSostListNew.get(i+1).getL43DataInstallazione(), l43RecuperatoreSost.getL43DataDismissione());

								validazioneDataInstSuccDataInstImpLib(Constants.TIPO_COMPONENTE_RC, numComponente, l43RecuperatoreSostListNew.get(i+1).getL43DataInstallazione(), l43RecuperatoreSost.getL43DataInstallazione());
								validazioneDataDismisSuccDataDismisImpLib(Constants.TIPO_COMPONENTE_RC, numComponente, l43RecuperatoreSostListNew.get(i+1).getL43DataDismissione(), l43RecuperatoreSost.getL43DataDismissione());

							}

							// Verifico i valori delle combo
							validazioneMarca(l43RecuperatoreSost.getL43Fabbricante());

						}


					}
				}

				// Pulisco la lista
				compList.clear();


				// DEVO CONSIDERARE CHE GLI ELEMENTI BR E RC HANNO DEI PUNTAMENTI CON IL GT (quindi devo verificare che il numero dei BR e RC sia corrispondente ad uno presente nei GT)

				// Mi creo una lista specifica per fare l'ordinamento, perche' l'ordinamento con l'oggetto L51SistemaRegolazioneSostituito non funziona
				for (int j = 0; j < l43RCList.size(); j++) {
					compList.add(new ComparatorDto(j, l43RCList.get(j).getL43Numero()));
				}

				// ordino per progressivo la lista
				Collections.sort(compList, ComparatorUtil.compareCamparatorDtoByProgressivo());

				// Dopo aver ordinato per la progressivo devo ricostruire la lista di L51SR ordinati
				L43RC[] l43RCArray = new L43RC[compList.size()];

				for (int i = 0; i < compList.size(); i++) {
					l43RCArray[i] = l43RCList.get(compList.get(i).getIdData());

				}

				//Risetto l'array ordinato
				l4Generatori.setL43RCArray(l43RCArray);

				// Recupero l'oggetto (ho notato che se riusavo l'array avevo dei problemi)
				List<L43RC> l43RCListNew = l4Generatori.getL43RCList();


				// Devo rinominare il progressivo (L51Numero), in modo che sia 1,2,3,ecc. Perche' l'utente potrebbe aver inserito numeri a caso...
				int count = 1;
				for (L43RC l43Rc : l43RCListNew) {

					l43Rc.setL43Numero(ConvertUtil.convertToBigInteger(count++));
				}

			}
		}
	}

	private void validazioneL4GfScCgCsAg(L4Generatori l4Generatori) throws ValidationManagerException
	{
		// Devo verificare le date
		// devo ordinare le sostituite per data installazione

		// L4_generatori

		if (l4Generatori != null)
		{

			List<L44GF> l44GFList = l4Generatori.getL44GFList();
			List<L45SC> l45SCList = l4Generatori.getL45SCList();
			List<L46CG> l46CGList = l4Generatori.getL46CGList();
			List<L47CS> l47CSList = l4Generatori.getL47CSList();
			List<L48AG> l48AGList = l4Generatori.getL48AGList();

			String numComponente = null;
			List<ComparatorDto> compList = new ArrayList<ComparatorDto>();

			// Verificao che ci siano delle GF
			if (l44GFList != null && l44GFList.size() > 0)
			{
				for (L44GF l44Gf : l44GFList)
				{

					numComponente = ConvertUtil.convertToString(l44Gf.getL44Numero());

					L44GruppoFrigo l44GruppoFrigo =l44Gf.getL44GruppoFrigo();

					validazioneDataInstDataDismisSePresImpLib(Constants.TIPO_COMPONENTE_GF, numComponente, l44GruppoFrigo.getL44DataInstallazione(), l44GruppoFrigo.getL44DataDismissione());

					// Verifico i valori delle combo
					validazioneMarca(l44GruppoFrigo.getL44Fabbricante());


					if (l44GruppoFrigo.getL44CombustibileAssorbimentoFiammaDiretta() != 0)
					{
						validazioneCombustibile(l44GruppoFrigo.getL44CombustibileAssorbimentoFiammaDiretta());
					}


					List<L44GruppoFrigoSostituito> l44GruppoFrigoSostListOrig = l44Gf.getL44GruppoFrigoSostituitoList();

					// Verificao che ci siano delle sostituzioni
					if (l44GruppoFrigoSostListOrig != null && l44GruppoFrigoSostListOrig.size() > 0)
					{

						compList.clear();

						// Mi creo una lista specifica per fare l'ordinamento, perche' l'ordinamento con l'oggetto Array[] non funziona
						for (int i = 0; i < l44GruppoFrigoSostListOrig.size(); i++)
						{
							compList.add(new ComparatorDto(i, ConvertUtil.convertToDate(l44GruppoFrigoSostListOrig.get(i).getL44DataInstallazione())));
						}

						// ordino per dataInstallazione la lista
						Collections.sort(compList, ComparatorUtil.compareCamparatorDtoByData());


						// Dopo aver ordinato per la dataInstallazione devo ricostruire la lista di oggetti ordinati
						L44GruppoFrigoSostituito[] l44GruppoFrigoSostArray = new L44GruppoFrigoSostituito[compList.size()];

						for (int i = 0; i < compList.size(); i++) {
							l44GruppoFrigoSostArray[i] = l44GruppoFrigoSostListOrig.get(compList.get(i).getIdData());

						}

						//Risetto l'array ordinato
						l44Gf.setL44GruppoFrigoSostituitoArray(l44GruppoFrigoSostArray);



						// Recupero l'oggetto (ho notato che se riusavo l'array avevo dei problemi)
						List<L44GruppoFrigoSostituito> l44GruppoFrigoSostListNew = l44Gf.getL44GruppoFrigoSostituitoList();

						int listSize = l44GruppoFrigoSostListNew.size();

						for (int i = 0; i < listSize; i++) {

							L44GruppoFrigoSostituito l44GruppoFrigoSost = l44GruppoFrigoSostListNew.get(i);

							if (i == 0)
							{
								// Adesso che ho ordinato verifico che la dataDismissione del primo elemento (quindi quello piu' recente - l'elemento 0) sia precedente alla dataInstallazione dell'elemento attuale
								validazioneDataInstSuccDataDismisSostImpLib(Constants.TIPO_COMPONENTE_GF, numComponente, l44GruppoFrigoSost.getL44DataDismissione(), l44GruppoFrigo.getL44DataInstallazione());
							}

							// Adesso che ho ordinato le date devo verificarle, sia tra dataInizio -> dataFine, che la data inizio dell'ultima sia successiva alla data fine di quella precedente
							validazioneDataInstDataDismisImpLib(Constants.TIPO_COMPONENTE_GF, numComponente, l44GruppoFrigoSost.getL44DataInstallazione(), l44GruppoFrigoSost.getL44DataDismissione());
							//DateUtil.checkDateOrder(l51SistRegSost.getL51DataInstallazione(), l51SistRegSost.getL51DataDismissione(), true);

							if (i != listSize-1)
							{
								// Esistono ancora elementi successivi, quindi controllo la data fine attuale con la data inizio successiva
								validazioneDataInstSuccDataDismisImpLib(Constants.TIPO_COMPONENTE_GF, numComponente, l44GruppoFrigoSostListNew.get(i+1).getL44DataInstallazione(), l44GruppoFrigoSost.getL44DataDismissione());

								validazioneDataInstSuccDataInstImpLib(Constants.TIPO_COMPONENTE_GF, numComponente, l44GruppoFrigoSostListNew.get(i+1).getL44DataInstallazione(), l44GruppoFrigoSost.getL44DataInstallazione());
								validazioneDataDismisSuccDataDismisImpLib(Constants.TIPO_COMPONENTE_GF, numComponente, l44GruppoFrigoSostListNew.get(i+1).getL44DataDismissione(), l44GruppoFrigoSost.getL44DataDismissione());

							}

							// Verifico i valori delle combo
							validazioneMarca(l44GruppoFrigoSost.getL44Fabbricante());

							if (l44GruppoFrigoSost.getL44CombustibileAssorbimentoFiammaDiretta() != 0)
							{
								validazioneCombustibile(l44GruppoFrigoSost.getL44CombustibileAssorbimentoFiammaDiretta());
							}
						}
					}
				}

				// Pulisco la lista
				compList.clear();


				// Mi creo una lista specifica per fare l'ordinamento, perche' l'ordinamento con l'oggetto L44GruppoFrigoSostituito non funziona
				for (int j = 0; j < l44GFList.size(); j++) {
					compList.add(new ComparatorDto(j, l44GFList.get(j).getL44Numero()));
				}

				// ordino per progressivo la lista
				Collections.sort(compList, ComparatorUtil.compareCamparatorDtoByProgressivo());

				// Dopo aver ordinato per la progressivo devo ricostruire la lista di L44GF ordinati
				L44GF[] l44GFArray = new L44GF[compList.size()];

				for (int i = 0; i < compList.size(); i++) {
					l44GFArray[i] = l44GFList.get(compList.get(i).getIdData());

				}

				//Risetto l'array ordinato
				l4Generatori.setL44GFArray(l44GFArray);


				// Recupero l'oggetto (ho notato che se riusavo l'array avevo dei problemi)
				List<L44GF> l44GFListNew = l4Generatori.getL44GFList();


				// Devo rinominare il progressivo (L42Numero), in modo che sia 1,2,3,ecc. Perche' l'utente potrebbe aver inserito numeri a caso...
				int count = 1;
				for (L44GF l44Gf : l44GFListNew) {

					l44Gf.setL44Numero(ConvertUtil.convertToBigInteger(count++));
				}
			}


			// Verificao che ci siano delle SC
			if (l45SCList != null && l45SCList.size() > 0)
			{
				for (L45SC l45Sc : l45SCList)
				{

					numComponente = ConvertUtil.convertToString(l45Sc.getL45Numero());

					L45Scambiatore l45Scambiatore =l45Sc.getL45Scambiatore();

					validazioneDataInstDataDismisSePresImpLib(Constants.TIPO_COMPONENTE_SC, numComponente, l45Scambiatore.getL45DataInstallazione(), l45Scambiatore.getL45DataDismissione());

					// Verifico i valori delle combo
					validazioneMarca(l45Scambiatore.getL45Fabbricante());

					List<L45ScambiatoreSostituito> l45ScambiatoreSostListOrig = l45Sc.getL45ScambiatoreSostituitoList();

					// Verificao che ci siano delle sostituzioni
					if (l45ScambiatoreSostListOrig != null && l45ScambiatoreSostListOrig.size() > 0)
					{

						compList.clear();

						// Mi creo una lista specifica per fare l'ordinamento, perche' l'ordinamento con l'oggetto Array[] non funziona
						for (int i = 0; i < l45ScambiatoreSostListOrig.size(); i++)
						{
							compList.add(new ComparatorDto(i, ConvertUtil.convertToDate(l45ScambiatoreSostListOrig.get(i).getL45DataInstallazione())));
						}

						// ordino per dataInstallazione la lista
						Collections.sort(compList, ComparatorUtil.compareCamparatorDtoByData());


						// Dopo aver ordinato per la dataInstallazione devo ricostruire la lista di oggetti ordinati
						L45ScambiatoreSostituito[] l45ScambiatoreSostArray = new L45ScambiatoreSostituito[compList.size()];

						for (int i = 0; i < compList.size(); i++) {
							l45ScambiatoreSostArray[i] = l45ScambiatoreSostListOrig.get(compList.get(i).getIdData());

						}

						//Risetto l'array ordinato
						l45Sc.setL45ScambiatoreSostituitoArray(l45ScambiatoreSostArray);



						// Recupero l'oggetto (ho notato che se riusavo l'array avevo dei problemi)
						List<L45ScambiatoreSostituito> l45ScambiatoreSostListNew = l45Sc.getL45ScambiatoreSostituitoList();

						int listSize = l45ScambiatoreSostListNew.size();

						for (int i = 0; i < listSize; i++) {

							L45ScambiatoreSostituito l45ScambiatoreSost = l45ScambiatoreSostListNew.get(i);

							if (i == 0)
							{
								// Adesso che ho ordinato verifico che la dataDismissione del primo elemento (quindi quello piu' recente - l'elemento 0) sia precedente alla dataInstallazione dell'elemento attuale
								validazioneDataInstSuccDataDismisSostImpLib(Constants.TIPO_COMPONENTE_SC, numComponente, l45ScambiatoreSost.getL45DataDismissione(), l45Scambiatore.getL45DataInstallazione());
							}

							// Adesso che ho ordinato le date devo verificarle, sia tra dataInizio -> dataFine, che la data inizio dell'ultima sia successiva alla data fine di quella precedente
							validazioneDataInstDataDismisImpLib(Constants.TIPO_COMPONENTE_SC, numComponente, l45ScambiatoreSost.getL45DataInstallazione(), l45ScambiatoreSost.getL45DataDismissione());
							//DateUtil.checkDateOrder(l51SistRegSost.getL51DataInstallazione(), l51SistRegSost.getL51DataDismissione(), true);

							if (i != listSize-1)
							{
								// Esistono ancora elementi successivi, quindi controllo la data fine attuale con la data inizio successiva
								validazioneDataInstSuccDataDismisImpLib(Constants.TIPO_COMPONENTE_SC, numComponente, l45ScambiatoreSostListNew.get(i+1).getL45DataInstallazione(), l45ScambiatoreSost.getL45DataDismissione());

								validazioneDataInstSuccDataInstImpLib(Constants.TIPO_COMPONENTE_SC, numComponente, l45ScambiatoreSostListNew.get(i+1).getL45DataInstallazione(), l45ScambiatoreSost.getL45DataInstallazione());
								validazioneDataDismisSuccDataDismisImpLib(Constants.TIPO_COMPONENTE_SC, numComponente, l45ScambiatoreSostListNew.get(i+1).getL45DataDismissione(), l45ScambiatoreSost.getL45DataDismissione());

							}

							// Verifico i valori delle combo
							validazioneMarca(l45ScambiatoreSost.getL45Fabbricante());

						}
					}
				}

				// Pulisco la lista
				compList.clear();


				// Mi creo una lista specifica per fare l'ordinamento, perche' l'ordinamento con l'oggetto L45ScambiatoreSostituito non funziona
				for (int j = 0; j < l45SCList.size(); j++) {
					compList.add(new ComparatorDto(j, l45SCList.get(j).getL45Numero()));
				}

				// ordino per progressivo la lista
				Collections.sort(compList, ComparatorUtil.compareCamparatorDtoByProgressivo());

				// Dopo aver ordinato per la progressivo devo ricostruire la lista di L42BR ordinati
				L45SC[] l45SCArray = new L45SC[compList.size()];

				for (int i = 0; i < compList.size(); i++) {
					l45SCArray[i] = l45SCList.get(compList.get(i).getIdData());

				}

				//Risetto l'array ordinato
				l4Generatori.setL45SCArray(l45SCArray);


				// Recupero l'oggetto (ho notato che se riusavo l'array avevo dei problemi)
				List<L45SC> l45SCListNew = l4Generatori.getL45SCList();


				// Devo rinominare il progressivo (L42Numero), in modo che sia 1,2,3,ecc. Perche' l'utente potrebbe aver inserito numeri a caso...
				int count = 1;
				for (L45SC l45Sc : l45SCListNew) {

					l45Sc.setL45Numero(ConvertUtil.convertToBigInteger(count++));
				}
			}

			// Verificao che ci siano delle CG
			if (l46CGList != null && l46CGList.size() > 0)
			{
				for (L46CG l46Cg : l46CGList)
				{

					numComponente = ConvertUtil.convertToString(l46Cg.getL46Numero());

					L46Cogeneratore l46Cogeneratore =l46Cg.getL46Cogeneratore();

					validazioneDataInstDataDismisSePresImpLib(Constants.TIPO_COMPONENTE_CG, numComponente, l46Cogeneratore.getL46DataInstallazione(), l46Cogeneratore.getL46DataDismissione());

					// Verifico i valori delle combo
					validazioneMarca(l46Cogeneratore.getL46Fabbricante());
					validazioneCombustibile(l46Cogeneratore.getL46Alimentazione());


					List<L46CogeneratoreSostituito> l46CogeneratoreSostListOrig = l46Cg.getL46CogeneratoreSostituitoList();

					// Verificao che ci siano delle sostituzioni
					if (l46CogeneratoreSostListOrig != null && l46CogeneratoreSostListOrig.size() > 0)
					{

						compList.clear();

						// Mi creo una lista specifica per fare l'ordinamento, perche' l'ordinamento con l'oggetto Array[] non funziona
						for (int i = 0; i < l46CogeneratoreSostListOrig.size(); i++)
						{
							compList.add(new ComparatorDto(i, ConvertUtil.convertToDate(l46CogeneratoreSostListOrig.get(i).getL46DataInstallazione())));
						}

						// ordino per dataInstallazione la lista
						Collections.sort(compList, ComparatorUtil.compareCamparatorDtoByData());


						// Dopo aver ordinato per la dataInstallazione devo ricostruire la lista di oggetti ordinati
						L46CogeneratoreSostituito[] l46CogeneratoreSostArray = new L46CogeneratoreSostituito[compList.size()];

						for (int i = 0; i < compList.size(); i++) {
							l46CogeneratoreSostArray[i] = l46CogeneratoreSostListOrig.get(compList.get(i).getIdData());

						}

						//Risetto l'array ordinato
						l46Cg.setL46CogeneratoreSostituitoArray(l46CogeneratoreSostArray);



						// Recupero l'oggetto (ho notato che se riusavo l'array avevo dei problemi)
						List<L46CogeneratoreSostituito> l46CogeneratoreSostListNew = l46Cg.getL46CogeneratoreSostituitoList();

						int listSize = l46CogeneratoreSostListNew.size();

						for (int i = 0; i < listSize; i++) {

							L46CogeneratoreSostituito l46CogeneratoreSost = l46CogeneratoreSostListNew.get(i);

							if (i == 0)
							{
								// Adesso che ho ordinato verifico che la dataDismissione del primo elemento (quindi quello piu' recente - l'elemento 0) sia precedente alla dataInstallazione dell'elemento attuale
								validazioneDataInstSuccDataDismisSostImpLib(Constants.TIPO_COMPONENTE_CG, numComponente, l46CogeneratoreSost.getL46DataDismissione(), l46Cogeneratore.getL46DataInstallazione());
							}

							// Adesso che ho ordinato le date devo verificarle, sia tra dataInizio -> dataFine, che la data inizio dell'ultima sia successiva alla data fine di quella precedente
							validazioneDataInstDataDismisImpLib(Constants.TIPO_COMPONENTE_CG, numComponente, l46CogeneratoreSost.getL46DataInstallazione(), l46CogeneratoreSost.getL46DataDismissione());
							//DateUtil.checkDateOrder(l51SistRegSost.getL51DataInstallazione(), l51SistRegSost.getL51DataDismissione(), true);

							if (i != listSize-1)
							{
								// Esistono ancora elementi successivi, quindi controllo la data fine attuale con la data inizio successiva
								validazioneDataInstSuccDataDismisImpLib(Constants.TIPO_COMPONENTE_CG, numComponente, l46CogeneratoreSostListNew.get(i+1).getL46DataInstallazione(), l46CogeneratoreSost.getL46DataDismissione());

								validazioneDataInstSuccDataInstImpLib(Constants.TIPO_COMPONENTE_CG, numComponente, l46CogeneratoreSostListNew.get(i+1).getL46DataInstallazione(), l46CogeneratoreSost.getL46DataInstallazione());
								validazioneDataDismisSuccDataDismisImpLib(Constants.TIPO_COMPONENTE_CG, numComponente, l46CogeneratoreSostListNew.get(i+1).getL46DataDismissione(), l46CogeneratoreSost.getL46DataDismissione());

							}

							// Verifico i valori delle combo
							validazioneMarca(l46CogeneratoreSost.getL46Fabbricante());
							validazioneCombustibile(l46CogeneratoreSost.getL46Alimentazione());
						}
					}
				}

				// Pulisco la lista
				compList.clear();


				// Mi creo una lista specifica per fare l'ordinamento, perche' l'ordinamento con l'oggetto L46CogeneratoreSostituito non funziona
				for (int j = 0; j < l46CGList.size(); j++) {
					compList.add(new ComparatorDto(j, l46CGList.get(j).getL46Numero()));
				}

				// ordino per progressivo la lista
				Collections.sort(compList, ComparatorUtil.compareCamparatorDtoByProgressivo());

				// Dopo aver ordinato per la progressivo devo ricostruire la lista di L46CG ordinati
				L46CG[] l46CGArray = new L46CG[compList.size()];

				for (int i = 0; i < compList.size(); i++) {
					l46CGArray[i] = l46CGList.get(compList.get(i).getIdData());

				}

				//Risetto l'array ordinato
				l4Generatori.setL46CGArray(l46CGArray);


				// Recupero l'oggetto (ho notato che se riusavo l'array avevo dei problemi)
				List<L46CG> l46CGListNew = l4Generatori.getL46CGList();


				// Devo rinominare il progressivo (L46Numero), in modo che sia 1,2,3,ecc. Perche' l'utente potrebbe aver inserito numeri a caso...
				int count = 1;
				for (L46CG l46Cg : l46CGListNew) {

					l46Cg.setL46Numero(ConvertUtil.convertToBigInteger(count++));
				}
			}


			// Verificao che ci siano delle CS
			if (l47CSList != null && l47CSList.size() > 0)
			{
				for (L47CS l47Cs : l47CSList)
				{

					numComponente = ConvertUtil.convertToString(l47Cs.getL47Numero());

					L47CampoSolareTermico l47CamSolTer =l47Cs.getL47CampoSolareTermico();

					validazioneDataInstDataDismisSePresImpLib(Constants.TIPO_COMPONENTE_CS, numComponente, l47CamSolTer.getL47DataInstallazione(), l47CamSolTer.getL47DataDismissione());

					// Verifico i valori delle combo
					validazioneMarca(l47CamSolTer.getL47Fabbricante());

					List<L47CampoSolareTermicoSostituito> l47CamSolTerSostListOrig = l47Cs.getL47CampoSolareTermicoSostituitoList();

					// Verificao che ci siano delle sostituzioni
					if (l47CamSolTerSostListOrig != null && l47CamSolTerSostListOrig.size() > 0)
					{

						compList.clear();

						// Mi creo una lista specifica per fare l'ordinamento, perche' l'ordinamento con l'oggetto Array[] non funziona
						for (int i = 0; i < l47CamSolTerSostListOrig.size(); i++)
						{
							compList.add(new ComparatorDto(i, ConvertUtil.convertToDate(l47CamSolTerSostListOrig.get(i).getL47DataInstallazione())));
						}

						// ordino per dataInstallazione la lista
						Collections.sort(compList, ComparatorUtil.compareCamparatorDtoByData());


						// Dopo aver ordinato per la dataInstallazione devo ricostruire la lista di oggetti ordinati
						L47CampoSolareTermicoSostituito[] l47CamSolTerSostArray = new L47CampoSolareTermicoSostituito[compList.size()];

						for (int i = 0; i < compList.size(); i++) {
							l47CamSolTerSostArray[i] = l47CamSolTerSostListOrig.get(compList.get(i).getIdData());

						}

						//Risetto l'array ordinato
						l47Cs.setL47CampoSolareTermicoSostituitoArray(l47CamSolTerSostArray);



						// Recupero l'oggetto (ho notato che se riusavo l'array avevo dei problemi)
						List<L47CampoSolareTermicoSostituito> l47CamSolTerSostListNew = l47Cs.getL47CampoSolareTermicoSostituitoList();

						int listSize = l47CamSolTerSostListNew.size();

						for (int i = 0; i < listSize; i++) {

							L47CampoSolareTermicoSostituito l47CamSolTerSost = l47CamSolTerSostListNew.get(i);

							if (i == 0)
							{
								// Adesso che ho ordinato verifico che la dataDismissione del primo elemento (quindi quello piu' recente - l'elemento 0) sia precedente alla dataInstallazione dell'elemento attuale
								validazioneDataInstSuccDataDismisSostImpLib(Constants.TIPO_COMPONENTE_CS, numComponente, l47CamSolTerSost.getL47DataDismissione(), l47CamSolTer.getL47DataInstallazione());
							}

							// Adesso che ho ordinato le date devo verificarle, sia tra dataInizio -> dataFine, che la data inizio dell'ultima sia successiva alla data fine di quella precedente
							validazioneDataInstDataDismisImpLib(Constants.TIPO_COMPONENTE_CS, numComponente, l47CamSolTerSost.getL47DataInstallazione(), l47CamSolTerSost.getL47DataDismissione());
							//DateUtil.checkDateOrder(l51SistRegSost.getL51DataInstallazione(), l51SistRegSost.getL51DataDismissione(), true);

							if (i != listSize-1)
							{
								// Esistono ancora elementi successivi, quindi controllo la data fine attuale con la data inizio successiva
								validazioneDataInstSuccDataDismisImpLib(Constants.TIPO_COMPONENTE_CS, numComponente, l47CamSolTerSostListNew.get(i+1).getL47DataInstallazione(), l47CamSolTerSost.getL47DataDismissione());

								validazioneDataInstSuccDataInstImpLib(Constants.TIPO_COMPONENTE_CS, numComponente, l47CamSolTerSostListNew.get(i+1).getL47DataInstallazione(), l47CamSolTerSost.getL47DataInstallazione());
								validazioneDataDismisSuccDataDismisImpLib(Constants.TIPO_COMPONENTE_CS, numComponente, l47CamSolTerSostListNew.get(i+1).getL47DataDismissione(), l47CamSolTerSost.getL47DataDismissione());

							}

							// Verifico i valori delle combo
							validazioneMarca(l47CamSolTerSost.getL47Fabbricante());
						}
					}
				}

				// Pulisco la lista
				compList.clear();


				// Mi creo una lista specifica per fare l'ordinamento, perche' l'ordinamento con l'oggetto L47CampoSolareTerSostituito non funziona
				for (int j = 0; j < l47CSList.size(); j++) {
					compList.add(new ComparatorDto(j, l47CSList.get(j).getL47Numero()));
				}

				// ordino per progressivo la lista
				Collections.sort(compList, ComparatorUtil.compareCamparatorDtoByProgressivo());

				// Dopo aver ordinato per la progressivo devo ricostruire la lista di L42BR ordinati
				L47CS[] l47CSArray = new L47CS[compList.size()];

				for (int i = 0; i < compList.size(); i++) {
					l47CSArray[i] = l47CSList.get(compList.get(i).getIdData());

				}

				//Risetto l'array ordinato
				l4Generatori.setL47CSArray(l47CSArray);


				// Recupero l'oggetto (ho notato che se riusavo l'array avevo dei problemi)
				List<L47CS> l47CSListNew = l4Generatori.getL47CSList();


				// Devo rinominare il progressivo (L42Numero), in modo che sia 1,2,3,ecc. Perche' l'utente potrebbe aver inserito numeri a caso...
				int count = 1;
				for (L47CS l47Cs : l47CSListNew) {

					l47Cs.setL47Numero(ConvertUtil.convertToBigInteger(count++));
				}
			}


			// Verificao che ci siano delle AG
			if (l48AGList != null && l48AGList.size() > 0)
			{
				for (L48AG l49Ag : l48AGList)
				{

					numComponente = ConvertUtil.convertToString(l49Ag.getL48Numero());

					L48AltroGeneratore l48AltroGeneratore =l49Ag.getL48AltroGeneratore();

					validazioneDataInstDataDismisSePresImpLib(Constants.TIPO_COMPONENTE_AG, numComponente, l48AltroGeneratore.getL48DataInstallazione(), l48AltroGeneratore.getL48DataDismissione());

					// Verifico i valori delle combo
					validazioneMarca(l48AltroGeneratore.getL48Fabbricante());

					List<L48AltroGeneratoreSostituito> l48AltroGeneratoreSostListOrig = l49Ag.getL48AltroGeneratoreSostituitoList();

					// Verificao che ci siano delle sostituzioni
					if (l48AltroGeneratoreSostListOrig != null && l48AltroGeneratoreSostListOrig.size() > 0)
					{

						compList.clear();

						// Mi creo una lista specifica per fare l'ordinamento, perche' l'ordinamento con l'oggetto Array[] non funziona
						for (int i = 0; i < l48AltroGeneratoreSostListOrig.size(); i++)
						{
							compList.add(new ComparatorDto(i, ConvertUtil.convertToDate(l48AltroGeneratoreSostListOrig.get(i).getL48DataInstallazione())));
						}

						// ordino per dataInstallazione la lista
						Collections.sort(compList, ComparatorUtil.compareCamparatorDtoByData());


						// Dopo aver ordinato per la dataInstallazione devo ricostruire la lista di oggetti ordinati
						L48AltroGeneratoreSostituito[] l48AltroGeneratoreSostArray = new L48AltroGeneratoreSostituito[compList.size()];

						for (int i = 0; i < compList.size(); i++) {
							l48AltroGeneratoreSostArray[i] = l48AltroGeneratoreSostListOrig.get(compList.get(i).getIdData());

						}

						//Risetto l'array ordinato
						l49Ag.setL48AltroGeneratoreSostituitoArray(l48AltroGeneratoreSostArray);



						// Recupero l'oggetto (ho notato che se riusavo l'array avevo dei problemi)
						List<L48AltroGeneratoreSostituito> l48AltroGeneratoreSostListNew = l49Ag.getL48AltroGeneratoreSostituitoList();

						int listSize = l48AltroGeneratoreSostListNew.size();

						for (int i = 0; i < listSize; i++) {

							L48AltroGeneratoreSostituito l48AltroGeneratoreSost = l48AltroGeneratoreSostListNew.get(i);

							if (i == 0)
							{
								// Adesso che ho ordinato verifico che la dataDismissione del primo elemento (quindi quello piu' recente - l'elemento 0) sia precedente alla dataInstallazione dell'elemento attuale
								validazioneDataInstSuccDataDismisSostImpLib(Constants.TIPO_COMPONENTE_AG, numComponente, l48AltroGeneratoreSost.getL48DataDismissione(), l48AltroGeneratore.getL48DataInstallazione());
							}

							// Adesso che ho ordinato le date devo verificarle, sia tra dataInizio -> dataFine, che la data inizio dell'ultima sia successiva alla data fine di quella precedente
							validazioneDataInstDataDismisImpLib(Constants.TIPO_COMPONENTE_AG, numComponente, l48AltroGeneratoreSost.getL48DataInstallazione(), l48AltroGeneratoreSost.getL48DataDismissione());
							//DateUtil.checkDateOrder(l51SistRegSost.getL51DataInstallazione(), l51SistRegSost.getL51DataDismissione(), true);

							if (i != listSize-1)
							{
								// Esistono ancora elementi successivi, quindi controllo la data fine attuale con la data inizio successiva
								validazioneDataInstSuccDataDismisImpLib(Constants.TIPO_COMPONENTE_AG, numComponente, l48AltroGeneratoreSostListNew.get(i+1).getL48DataInstallazione(), l48AltroGeneratoreSost.getL48DataDismissione());

								validazioneDataInstSuccDataInstImpLib(Constants.TIPO_COMPONENTE_AG, numComponente, l48AltroGeneratoreSostListNew.get(i+1).getL48DataInstallazione(), l48AltroGeneratoreSost.getL48DataInstallazione());
								validazioneDataDismisSuccDataDismisImpLib(Constants.TIPO_COMPONENTE_AG, numComponente, l48AltroGeneratoreSostListNew.get(i+1).getL48DataDismissione(), l48AltroGeneratoreSost.getL48DataDismissione());

							}

							// Verifico i valori delle combo
							validazioneMarca(l48AltroGeneratoreSost.getL48Fabbricante());

						}
					}
				}

				// Pulisco la lista
				compList.clear();


				// Mi creo una lista specifica per fare l'ordinamento, perche' l'ordinamento con l'oggetto L48AltroGeneratoreSostituito non funziona
				for (int j = 0; j < l48AGList.size(); j++) {
					compList.add(new ComparatorDto(j, l48AGList.get(j).getL48Numero()));
				}

				// ordino per progressivo la lista
				Collections.sort(compList, ComparatorUtil.compareCamparatorDtoByProgressivo());

				// Dopo aver ordinato per la progressivo devo ricostruire la lista di L48AG ordinati
				L48AG[] l48AGArray = new L48AG[compList.size()];

				for (int i = 0; i < compList.size(); i++) {
					l48AGArray[i] = l48AGList.get(compList.get(i).getIdData());

				}

				//Risetto l'array ordinato
				l4Generatori.setL48AGArray(l48AGArray);


				// Recupero l'oggetto (ho notato che se riusavo l'array avevo dei problemi)
				List<L48AG> l48AGListNew = l4Generatori.getL48AGList();


				// Devo rinominare il progressivo (L42Numero), in modo che sia 1,2,3,ecc. Perche' l'utente potrebbe aver inserito numeri a caso...
				int count = 1;
				for (L48AG l48Ag : l48AGListNew) {

					l48Ag.setL48Numero(ConvertUtil.convertToBigInteger(count++));
				}
			}
		}
	}



	private void validazioneL5SistemiRegolazioneContabilizzazione(LibrettoCatasto richiesta) throws ValidationManagerException
	{
		// Devo verificare le date
		// devo ordinare le sostituite per data installazione

		// L5_sistemiRegolazioneContabilizzazione

		// L5_1sistemaRegolazioneSostituito
		// L5_1valvolaRegolazioneSostituito

		L5SistemiRegolazioneContabilizzazione l5SistRegCont = richiesta.getL5SistemiRegolazioneContabilizzazione();

		if (l5SistRegCont != null)
		{

			List<L51SR> l51SRList = l5SistRegCont.getL51SRList();
			List<L51VR> l51VRList = l5SistRegCont.getL51VRList();

			String numComponente = null;
			List<ComparatorDto> compList = new ArrayList<ComparatorDto>();

			// Verificao che ci siano delle SR
			if (l51SRList != null && l51SRList.size() > 0)
			{
				for (L51SR l51sr : l51SRList)
				{

					numComponente = ConvertUtil.convertToString(l51sr.getL51Numero());

					L51SistemaRegolazione l51SistReg =l51sr.getL51SistemaRegolazione();

					validazioneDataInstDataDismisSePresImpLib(Constants.TIPO_COMPONENTE_SR, numComponente, l51SistReg.getL51DataInstallazione(), l51SistReg.getL51DataDismissione());

					// Verifico i valori delle combo
					validazioneMarca(l51SistReg.getL51Fabbricante());


					List<L51SistemaRegolazioneSostituito> l51SistRegSostListOrig = l51sr.getL51SistemaRegolazioneSostituitoList();

					// Verificao che ci siano delle sostituzioni
					if (l51SistRegSostListOrig != null && l51SistRegSostListOrig.size() > 0)
					{

						//compList = new ArrayList<ComparatorDto>();

						compList.clear();

						// Mi creo una lista specifica per fare l'ordinamento, perche' l'ordinamento con l'oggetto L51SistemaRegolazioneSostituito non funziona
						for (int i = 0; i < l51SistRegSostListOrig.size(); i++)
						{
							compList.add(new ComparatorDto(i, ConvertUtil.convertToDate(l51SistRegSostListOrig.get(i).getL51DataInstallazione())));
						}

						// ordino per dataInstallazione la lista
						Collections.sort(compList, ComparatorUtil.compareCamparatorDtoByData());

						// Dopo aver ordinato per la dataInstallazione devo ricostruire la lista di L51SistemaRegolazioneSostituito ordinati
						L51SistemaRegolazioneSostituito[] l51SistRegSostArray = new L51SistemaRegolazioneSostituito[compList.size()];

						for (int i = 0; i < compList.size(); i++) {
							l51SistRegSostArray[i] = l51SistRegSostListOrig.get(compList.get(i).getIdData());

						}

						//Risetto l'array ordinato
						l51sr.setL51SistemaRegolazioneSostituitoArray(l51SistRegSostArray);

						// Recupero l'oggetto (ho notato che se riusavo l'array avevo dei problemi
						List<L51SistemaRegolazioneSostituito> l51SistRegSostListNew = l51sr.getL51SistemaRegolazioneSostituitoList();

						int listSize = l51SistRegSostListNew.size();

						for (int i = 0; i < listSize; i++) {

							L51SistemaRegolazioneSostituito l51SistRegSost = l51SistRegSostListNew.get(i);

							if (i == 0)
							{
								// Adesso che ho ordinato verifico che la dataDismissione del primo elemento (quindi quello piu' recente - l'elemento 0) sia precedente alla dataInstallazione dell'elemento attuale
								validazioneDataInstSuccDataDismisSostImpLib(Constants.TIPO_COMPONENTE_SR, numComponente, l51SistRegSost.getL51DataDismissione(), l51SistReg.getL51DataInstallazione());
							}

							// Adesso che ho ordinato le date devo verificarle, sia tra dataInizio -> dataFine, che la data inizio dell'ultima sia successiva alla data fine di quella precedente
							validazioneDataInstDataDismisImpLib(Constants.TIPO_COMPONENTE_SR, numComponente, l51SistRegSost.getL51DataInstallazione(), l51SistRegSost.getL51DataDismissione());
							//DateUtil.checkDateOrder(l51SistRegSost.getL51DataInstallazione(), l51SistRegSost.getL51DataDismissione(), true);

							if (i != listSize-1)
							{
								// Esistono ancora elementi successivi, quindi controllo la data fine attuale con la data inizio successiva
								validazioneDataInstSuccDataDismisImpLib(Constants.TIPO_COMPONENTE_SR, numComponente, l51SistRegSostListNew.get(i+1).getL51DataInstallazione(), l51SistRegSost.getL51DataDismissione());

								validazioneDataInstSuccDataInstImpLib(Constants.TIPO_COMPONENTE_SR, numComponente, l51SistRegSostListNew.get(i+1).getL51DataInstallazione(), l51SistRegSost.getL51DataInstallazione());
								validazioneDataDismisSuccDataDismisImpLib(Constants.TIPO_COMPONENTE_SR, numComponente, l51SistRegSostListNew.get(i+1).getL51DataDismissione(), l51SistRegSost.getL51DataDismissione());

							}

							// Verifico i valori delle combo
							validazioneMarca(l51SistRegSost.getL51Fabbricante());

						}


					}
				}

				// Pulisco la lista
				compList.clear();


				// Mi creo una lista specifica per fare l'ordinamento, perche' l'ordinamento con l'oggetto L51SistemaRegolazioneSostituito non funziona
				for (int j = 0; j < l51SRList.size(); j++) {
					compList.add(new ComparatorDto(j, l51SRList.get(j).getL51Numero()));
				}

				// ordino per progressivo la lista
				Collections.sort(compList, ComparatorUtil.compareCamparatorDtoByProgressivo());

				// Dopo aver ordinato per la progressivo devo ricostruire la lista di L51SR ordinati
				L51SR[] l51SRArray = new L51SR[compList.size()];

				for (int i = 0; i < compList.size(); i++) {
					l51SRArray[i] = l51SRList.get(compList.get(i).getIdData());

				}

				//Risetto l'array ordinato
				l5SistRegCont.setL51SRArray(l51SRArray);


				// Recupero l'oggetto (ho notato che se riusavo l'array avevo dei problemi)
				List<L51SR> l51SRListNew = l5SistRegCont.getL51SRList();


				// Devo rinominare il progressivo (L51Numero), in modo che sia 1,2,3,ecc. Perche' l'utente potrebbe aver inserito numeri a caso...
				int count = 1;
				for (L51SR l51Sr : l51SRListNew) {

					l51Sr.setL51Numero(ConvertUtil.convertToBigInteger(count++));
				}

			}


			// Verificao che ci siano delle SR
			if (l51VRList != null && l51VRList.size() > 0)
			{
				for (L51VR l51vr : l51VRList)
				{

					numComponente = ConvertUtil.convertToString(l51vr.getL51Numero());

					L51ValvolaRegolazione l51ValvReg =l51vr.getL51ValvolaRegolazione();

					validazioneDataInstDataDismisSePresImpLib(Constants.TIPO_COMPONENTE_VR, numComponente, l51ValvReg.getL51DataInstallazione(), l51ValvReg.getL51DataDismissione());

					// Verifico i valori delle combo
					validazioneMarca(l51ValvReg.getL51Fabbricante());


					List<L51ValvolaRegolazioneSostituito> l51ValvRegSostListOrig = l51vr.getL51ValvolaRegolazioneSostituitoList();

					// Verificao che ci siano delle sostituzioni
					if (l51ValvRegSostListOrig != null && l51ValvRegSostListOrig.size() > 0)
					{

						compList.clear();

						// Mi creo una lista specifica per fare l'ordinamento, perche' l'ordinamento con l'oggetto L51SistemaRegolazioneSostituito non funziona
						for (int i = 0; i < l51ValvRegSostListOrig.size(); i++)
						{
							compList.add(new ComparatorDto(i, ConvertUtil.convertToDate(l51ValvRegSostListOrig.get(i).getL51DataInstallazione())));
						}

						// ordino per dataInstallazione la lista
						Collections.sort(compList, ComparatorUtil.compareCamparatorDtoByData());


						// Dopo aver ordinato per la dataInstallazione devo ricostruire la lista di L51SistemaRegolazioneSostituito ordinati
						L51ValvolaRegolazioneSostituito[] l51ValvRegSostArray = new L51ValvolaRegolazioneSostituito[compList.size()];

						for (int i = 0; i < compList.size(); i++) {
							l51ValvRegSostArray[i] = l51ValvRegSostListOrig.get(compList.get(i).getIdData());

						}

						//Risetto l'array ordinato
						l51vr.setL51ValvolaRegolazioneSostituitoArray(l51ValvRegSostArray);



						// Recupero l'oggetto (ho notato che se riusavo l'array avevo dei problemi
						List<L51ValvolaRegolazioneSostituito> l51ValvRegSostListNew = l51vr.getL51ValvolaRegolazioneSostituitoList();

						int listSize = l51ValvRegSostListNew.size();

						for (int i = 0; i < listSize; i++) {

							L51ValvolaRegolazioneSostituito l51ValvRegSost = l51ValvRegSostListNew.get(i);

							if (i == 0)
							{
								// Adesso che ho ordinato verifico che la dataDismissione del primo elemento (quindi quello piu' recente - l'elemento 0) sia precedente alla dataInstallazione dell'elemento attuale
								validazioneDataInstSuccDataDismisSostImpLib(Constants.TIPO_COMPONENTE_VR, numComponente, l51ValvRegSost.getL51DataDismissione(), l51ValvReg.getL51DataInstallazione());
							}

							// Adesso che ho ordinato le date devo verificarle, sia tra dataInizio -> dataFine, che la data inizio dell'ultima sia successiva alla data fine di quella precedente
							validazioneDataInstDataDismisImpLib(Constants.TIPO_COMPONENTE_VR, numComponente, l51ValvRegSost.getL51DataInstallazione(), l51ValvRegSost.getL51DataDismissione());
							//DateUtil.checkDateOrder(l51SistRegSost.getL51DataInstallazione(), l51SistRegSost.getL51DataDismissione(), true);

							if (i != listSize-1)
							{
								// Esistono ancora elementi successivi, quindi controllo la data fine attuale con la data inizio successiva
								validazioneDataInstSuccDataDismisImpLib(Constants.TIPO_COMPONENTE_VR, numComponente, l51ValvRegSostListNew.get(i+1).getL51DataInstallazione(), l51ValvRegSost.getL51DataDismissione());

								validazioneDataInstSuccDataInstImpLib(Constants.TIPO_COMPONENTE_VR, numComponente, l51ValvRegSostListNew.get(i+1).getL51DataInstallazione(), l51ValvRegSost.getL51DataInstallazione());
								validazioneDataDismisSuccDataDismisImpLib(Constants.TIPO_COMPONENTE_VR, numComponente, l51ValvRegSostListNew.get(i+1).getL51DataDismissione(), l51ValvRegSost.getL51DataDismissione());

							}

							// Verifico i valori delle combo
							validazioneMarca(l51ValvRegSost.getL51Fabbricante());

						}
					}
				}

				// Pulisco la lista
				compList.clear();


				// Mi creo una lista specifica per fare l'ordinamento, perche' l'ordinamento con l'oggetto L51SistemaRegolazioneSostituito non funziona
				for (int j = 0; j < l51VRList.size(); j++) {
					compList.add(new ComparatorDto(j, l51VRList.get(j).getL51Numero()));
				}

				// ordino per progressivo la lista
				Collections.sort(compList, ComparatorUtil.compareCamparatorDtoByProgressivo());

				// Dopo aver ordinato per la progressivo devo ricostruire la lista di L51SR ordinati
				L51VR[] l51VRArray = new L51VR[compList.size()];

				for (int i = 0; i < compList.size(); i++) {
					l51VRArray[i] = l51VRList.get(compList.get(i).getIdData());

				}

				//Risetto l'array ordinato
				l5SistRegCont.setL51VRArray(l51VRArray);


				// Recupero l'oggetto (ho notato che se riusavo l'array avevo dei problemi)
				List<L51VR> l51VRListNew = l5SistRegCont.getL51VRList();


				// Devo rinominare il progressivo (L51Numero), in modo che sia 1,2,3,ecc. Perche' l'utente potrebbe aver inserito numeri a caso...
				int count = 1;
				for (L51VR l51Vr : l51VRListNew) {

					l51Vr.setL51Numero(ConvertUtil.convertToBigInteger(count++));
				}
			}
		}
	}

	private void validazioneL6Pompa(LibrettoCatasto richiesta) throws ValidationManagerException
	{
		L6SistemiDistribuzione l6SistDistrib = richiesta.getL6SistemiDistribuzione();

		if (l6SistDistrib != null)
		{
			List<ComparatorDto> compList = new ArrayList<ComparatorDto>();

			List<L63VX> l63VXList = l6SistDistrib.getL63VXList();

			// Verificao che ci siano delle VX
			if (l63VXList != null && l63VXList.size() > 0)
			{
				// Mi creo una lista specifica per fare l'ordinamento, perche' l'ordinamento con l'oggetto L64PompaSostituito non funziona
				for (int j = 0; j < l63VXList.size(); j++) {
					compList.add(new ComparatorDto(j, l63VXList.get(j).getL63Numero()));
				}

				// ordino per progressivo la lista
				Collections.sort(compList, ComparatorUtil.compareCamparatorDtoByProgressivo());

				// Dopo aver ordinato per la progressivo devo ricostruire la lista di L63VX ordinati
				L63VX[] l63VXArray = new L63VX[compList.size()];

				for (int i = 0; i < compList.size(); i++) {
					l63VXArray[i] = l63VXList.get(compList.get(i).getIdData());

				}

				//Risetto l'array ordinato
				l6SistDistrib.setL63VXArray(l63VXArray);


				// Recupero l'oggetto (ho notato che se riusavo l'array avevo dei problemi)
				List<L63VX> l63VXListNew = l6SistDistrib.getL63VXList();


				// Devo rinominare il progressivo (L63Numero), in modo che sia 1,2,3,ecc. Perche' l'utente potrebbe aver inserito numeri a caso...
				int count = 1;
				for (L63VX l63Vx : l63VXListNew) {

					l63Vx.setL63Numero(ConvertUtil.convertToBigInteger(count++));
				}
			}

			List<L64PO> l64POList = l6SistDistrib.getL64POList();

			// Verificao che ci siano delle PO
			if (l64POList != null && l64POList.size() > 0)
			{
				for (L64PO l64Po : l64POList)
				{

					String numComponente = ConvertUtil.convertToString(l64Po.getL64Numero());

					L64Pompa l64Pompa =l64Po.getL64Pompa();

					validazioneDataInstDataDismisSePresImpLib(Constants.TIPO_COMPONENTE_PO, numComponente, l64Pompa.getL64DataInstallazione(), l64Pompa.getL64DataDismissione());

					if(l64Pompa.getL64Fabbricante() > 0)
					{
						validazioneMarca(l64Pompa.getL64Fabbricante());
					}

					List<L64PompaSostituito> l64PompaSostListOrig = l64Po.getL64PompaSostituitoList();

					// Verificao che ci siano delle sostituzioni
					if (l64PompaSostListOrig != null && l64PompaSostListOrig.size() > 0)
					{

						// Pulisco la lista
						compList.clear();

						// Mi creo una lista specifica per fare l'ordinamento, perche' l'ordinamento con l'oggetto Array[] non funziona
						for (int i = 0; i < l64PompaSostListOrig.size(); i++)
						{
							compList.add(new ComparatorDto(i, ConvertUtil.convertToDate(l64PompaSostListOrig.get(i).getL64DataInstallazione())));
						}

						// ordino per dataInstallazione la lista
						Collections.sort(compList, ComparatorUtil.compareCamparatorDtoByData());


						// Dopo aver ordinato per la dataInstallazione devo ricostruire la lista di oggetti ordinati
						L64PompaSostituito[] l64PompaSostArray = new L64PompaSostituito[compList.size()];

						for (int i = 0; i < compList.size(); i++) {
							l64PompaSostArray[i] = l64PompaSostListOrig.get(compList.get(i).getIdData());

						}

						//Risetto l'array ordinato
						l64Po.setL64PompaSostituitoArray(l64PompaSostArray);



						// Recupero l'oggetto (ho notato che se riusavo l'array avevo dei problemi)
						List<L64PompaSostituito> l64PompaSostListNew = l64Po.getL64PompaSostituitoList();

						int listSize = l64PompaSostListNew.size();

						for (int i = 0; i < listSize; i++) {

							L64PompaSostituito l64PompaSost = l64PompaSostListNew.get(i);

							if (i == 0)
							{
								// Adesso che ho ordinato verifico che la dataDismissione del primo elemento (quindi quello piu' recente - l'elemento 0) sia precedente alla dataInstallazione dell'elemento attuale
								validazioneDataInstSuccDataDismisSostImpLib(Constants.TIPO_COMPONENTE_PO, numComponente, l64PompaSost.getL64DataDismissione(), l64Pompa.getL64DataInstallazione());
							}

							// Adesso che ho ordinato le date devo verificarle, sia tra dataInizio -> dataFine, che la data inizio dell'ultima sia successiva alla data fine di quella precedente
							validazioneDataInstDataDismisImpLib(Constants.TIPO_COMPONENTE_PO, numComponente, l64PompaSost.getL64DataInstallazione(), l64PompaSost.getL64DataDismissione());

							if (i != listSize-1)
							{
								// Esistono ancora elementi successivi, quindi controllo la data fine attuale con la data inizio successiva
								validazioneDataInstSuccDataDismisImpLib(Constants.TIPO_COMPONENTE_PO, numComponente, l64PompaSostListNew.get(i+1).getL64DataInstallazione(), l64PompaSost.getL64DataDismissione());

								validazioneDataInstSuccDataInstImpLib(Constants.TIPO_COMPONENTE_PO, numComponente, l64PompaSostListNew.get(i+1).getL64DataInstallazione(), l64PompaSost.getL64DataInstallazione());
								validazioneDataDismisSuccDataDismisImpLib(Constants.TIPO_COMPONENTE_PO, numComponente, l64PompaSostListNew.get(i+1).getL64DataDismissione(), l64PompaSost.getL64DataDismissione());

							}

							if(l64PompaSost.getL64Fabbricante() > 0)
							{
								validazioneMarca(l64PompaSost.getL64Fabbricante());
							}

						}
					}
				}

				// Pulisco la lista
				compList.clear();


				// Mi creo una lista specifica per fare l'ordinamento, perche' l'ordinamento con l'oggetto L64PompaSostituito non funziona
				for (int j = 0; j < l64POList.size(); j++) {
					compList.add(new ComparatorDto(j, l64POList.get(j).getL64Numero()));
				}

				// ordino per progressivo la lista
				Collections.sort(compList, ComparatorUtil.compareCamparatorDtoByProgressivo());

				// Dopo aver ordinato per la progressivo devo ricostruire la lista di L64PO ordinati
				L64PO[] l64POArray = new L64PO[compList.size()];

				for (int i = 0; i < compList.size(); i++) {
					l64POArray[i] = l64POList.get(compList.get(i).getIdData());

				}

				//Risetto l'array ordinato
				l6SistDistrib.setL64POArray(l64POArray);


				// Recupero l'oggetto (ho notato che se riusavo l'array avevo dei problemi)
				List<L64PO> l64POListNew = l6SistDistrib.getL64POList();


				// Devo rinominare il progressivo (L64Numero), in modo che sia 1,2,3,ecc. Perche' l'utente potrebbe aver inserito numeri a caso...
				int count = 1;
				for (L64PO l64Po : l64POListNew) {

					l64Po.setL64Numero(ConvertUtil.convertToBigInteger(count++));
				}
			}
		}
	}

	private void validazioneL7SistemiEmissione(LibrettoCatasto richiesta) throws ValidationManagerException
	{
		L7SistemiEmissione L7SistemiEmissione = richiesta.getL7SistemiEmissione();


		if (!L7SistemiEmissione.getL71Radiatori() && !L7SistemiEmissione.getL71Termoconvettori() &&
				!L7SistemiEmissione.getL71Ventilconvettori() && !L7SistemiEmissione.getL71PanelliRadianti() &&
				!L7SistemiEmissione.getL71Bocchette() && !L7SistemiEmissione.getL71StrisceRadianti() &&
				!L7SistemiEmissione.getL71TraviFredde() &&
				GenericUtil.isNullOrEmpty(L7SistemiEmissione.getL71Altro()))
		{
			throw new ValidationManagerException(new Message(Messages.S137, "7.1"));
		}

	}

	private void validazioneL8Accumulo(LibrettoCatasto richiesta) throws ValidationManagerException
	{
		L8SistemiAccumulo l8SistAccumulo = richiesta.getL8SistemiAccumulo();

		if (l8SistAccumulo != null)
		{

			List<L81AC> l81ACList = l8SistAccumulo.getL81ACList();

			List<ComparatorDto> compList = new ArrayList<ComparatorDto>();
			// Verificao che ci siano delle AC
			if (l81ACList != null && l81ACList.size() > 0)
			{
				for (L81AC l81Ac : l81ACList)
				{

					String numComponente = ConvertUtil.convertToString(l81Ac.getL81Numero());

					L81Accumulo l81Accumulo =l81Ac.getL81Accumulo();

					validazioneDataInstDataDismisSePresImpLib(Constants.TIPO_COMPONENTE_AC, numComponente, l81Accumulo.getL81DataInstallazione(), l81Accumulo.getL81DataDismissione());

					if(l81Accumulo.getL81Fabbricante() > 0)
					{
						validazioneMarca(l81Accumulo.getL81Fabbricante());
					}

					List<L81AccumuloSostituito> l81AccumuloSostListOrig = l81Ac.getL81AccumuloSostituitoList();

					// Verificao che ci siano delle sostituzioni
					if (l81AccumuloSostListOrig != null && l81AccumuloSostListOrig.size() > 0)
					{

						compList.clear();

						// Mi creo una lista specifica per fare l'ordinamento, perche' l'ordinamento con l'oggetto Array[] non funziona
						for (int i = 0; i < l81AccumuloSostListOrig.size(); i++)
						{
							compList.add(new ComparatorDto(i, ConvertUtil.convertToDate(l81AccumuloSostListOrig.get(i).getL81DataInstallazione())));
						}

						// ordino per dataInstallazione la lista
						Collections.sort(compList, ComparatorUtil.compareCamparatorDtoByData());


						// Dopo aver ordinato per la dataInstallazione devo ricostruire la lista di oggetti ordinati
						L81AccumuloSostituito[] l81AccumuloSostArray = new L81AccumuloSostituito[compList.size()];

						for (int i = 0; i < compList.size(); i++) {
							l81AccumuloSostArray[i] = l81AccumuloSostListOrig.get(compList.get(i).getIdData());

						}

						//Risetto l'array ordinato
						l81Ac.setL81AccumuloSostituitoArray(l81AccumuloSostArray);



						// Recupero l'oggetto (ho notato che se riusavo l'array avevo dei problemi)
						List<L81AccumuloSostituito> l81AccumuloSostListNew = l81Ac.getL81AccumuloSostituitoList();

						int listSize = l81AccumuloSostListNew.size();

						for (int i = 0; i < listSize; i++) {

							L81AccumuloSostituito l81AccumuloSost = l81AccumuloSostListNew.get(i);

							if (i == 0)
							{
								// Adesso che ho ordinato verifico che la dataDismissione del primo elemento (quindi quello piu' recente - l'elemento 0) sia precedente alla dataInstallazione dell'elemento attuale
								validazioneDataInstSuccDataDismisSostImpLib(Constants.TIPO_COMPONENTE_AC, numComponente, l81AccumuloSost.getL81DataDismissione(), l81Accumulo.getL81DataInstallazione());
							}

							// Adesso che ho ordinato le date devo verificarle, sia tra dataInizio -> dataFine, che la data inizio dell'ultima sia successiva alla data fine di quella precedente
							validazioneDataInstDataDismisImpLib(Constants.TIPO_COMPONENTE_AC, numComponente, l81AccumuloSost.getL81DataInstallazione(), l81AccumuloSost.getL81DataDismissione());

							if (i != listSize-1)
							{
								// Esistono ancora elementi successivi, quindi controllo la data fine attuale con la data inizio successiva
								validazioneDataInstSuccDataDismisImpLib(Constants.TIPO_COMPONENTE_AC, numComponente, l81AccumuloSostListNew.get(i+1).getL81DataInstallazione(), l81AccumuloSost.getL81DataDismissione());

								validazioneDataInstSuccDataInstImpLib(Constants.TIPO_COMPONENTE_AC, numComponente, l81AccumuloSostListNew.get(i+1).getL81DataInstallazione(), l81AccumuloSost.getL81DataInstallazione());
								validazioneDataDismisSuccDataDismisImpLib(Constants.TIPO_COMPONENTE_AC, numComponente, l81AccumuloSostListNew.get(i+1).getL81DataDismissione(), l81AccumuloSost.getL81DataDismissione());

							}

							if(l81AccumuloSost.getL81Fabbricante() > 0)
							{
								validazioneMarca(l81AccumuloSost.getL81Fabbricante());
							}

						}
					}
				}

				// Pulisco la lista
				compList.clear();


				// Mi creo una lista specifica per fare l'ordinamento, perche' l'ordinamento con l'oggetto L81AccumuloSostituito non funziona
				for (int j = 0; j < l81ACList.size(); j++) {
					compList.add(new ComparatorDto(j, l81ACList.get(j).getL81Numero()));
				}

				// ordino per progressivo la lista
				Collections.sort(compList, ComparatorUtil.compareCamparatorDtoByProgressivo());

				// Dopo aver ordinato per la progressivo devo ricostruire la lista di L81AC ordinati
				L81AC[] l81ACArray = new L81AC[compList.size()];

				for (int i = 0; i < compList.size(); i++) {
					l81ACArray[i] = l81ACList.get(compList.get(i).getIdData());

				}

				//Risetto l'array ordinato
				l8SistAccumulo.setL81ACArray(l81ACArray);


				// Recupero l'oggetto (ho notato che se riusavo l'array avevo dei problemi)
				List<L81AC> l81ACListNew = l8SistAccumulo.getL81ACList();


				// Devo rinominare il progressivo (L64Numero), in modo che sia 1,2,3,ecc. Perche' l'utente potrebbe aver inserito numeri a caso...
				int count = 1;
				for (L81AC l81Ac : l81ACListNew) {

					l81Ac.setL81Numero(ConvertUtil.convertToBigInteger(count++));
				}
			}
		}
	}



	private void validazioneL9TeRvScxCiUtRcx(LibrettoCatasto richiesta) throws ValidationManagerException
	{
		L9AltriComponenti l9AltriComp = richiesta.getL9AltriComponenti();

		if (l9AltriComp != null)
		{
			List<L91TE> l91TEList = l9AltriComp.getL91TEList();
			List<L92RV> l92RVList = l9AltriComp.getL92RVList();
			List<L93SCX> l93SCXList = l9AltriComp.getL93SCXList();

			List<L94CI> l94CIList = l9AltriComp.getL94CIList();
			List<L95UT> l95UTList = l9AltriComp.getL95UTList();
			List<L96RCX> l96RCXList = l9AltriComp.getL96RCXList();

			List<ComparatorDto> compList = new ArrayList<ComparatorDto>();

			String numComponente = null;

			// Verificao che ci siano delle PO
			if (l91TEList != null && l91TEList.size() > 0)
			{
				for (L91TE l91Te : l91TEList)
				{

					numComponente = ConvertUtil.convertToString(l91Te.getL91Numero());

					L91Torre l91Torre =l91Te.getL91Torre();

					validazioneDataInstDataDismisSePresImpLib(Constants.TIPO_COMPONENTE_TE, numComponente, l91Torre.getL91DataInstallazione(), l91Torre.getL91DataDismissione());

					if(l91Torre.getL91Fabbricante() > 0)
					{
						validazioneMarca(l91Torre.getL91Fabbricante());
					}

					List<L91TorreSostituito> l91TorreSostListOrig = l91Te.getL91TorreSostituitoList();

					// Verificao che ci siano delle sostituzioni
					if (l91TorreSostListOrig != null && l91TorreSostListOrig.size() > 0)
					{

						compList.clear();

						// Mi creo una lista specifica per fare l'ordinamento, perche' l'ordinamento con l'oggetto Array[] non funziona
						for (int i = 0; i < l91TorreSostListOrig.size(); i++)
						{
							compList.add(new ComparatorDto(i, ConvertUtil.convertToDate(l91TorreSostListOrig.get(i).getL91DataInstallazione())));
						}

						// ordino per dataInstallazione la lista
						Collections.sort(compList, ComparatorUtil.compareCamparatorDtoByData());


						// Dopo aver ordinato per la dataInstallazione devo ricostruire la lista di oggetti ordinati
						L91TorreSostituito[] l91TorreSostArray = new L91TorreSostituito[compList.size()];

						for (int i = 0; i < compList.size(); i++) {
							l91TorreSostArray[i] = l91TorreSostListOrig.get(compList.get(i).getIdData());

						}

						//Risetto l'array ordinato
						l91Te.setL91TorreSostituitoArray(l91TorreSostArray);



						// Recupero l'oggetto (ho notato che se riusavo l'array avevo dei problemi)
						List<L91TorreSostituito> l91TorreSostListNew = l91Te.getL91TorreSostituitoList();

						int listSize = l91TorreSostListNew.size();

						for (int i = 0; i < listSize; i++) {

							L91TorreSostituito l91TorreSost = l91TorreSostListNew.get(i);

							if (i == 0)
							{
								// Adesso che ho ordinato verifico che la dataDismissione del primo elemento (quindi quello piu' recente - l'elemento 0) sia precedente alla dataInstallazione dell'elemento attuale
								validazioneDataInstSuccDataDismisSostImpLib(Constants.TIPO_COMPONENTE_TE, numComponente, l91TorreSost.getL91DataDismissione(), l91Torre.getL91DataInstallazione());
							}

							// Adesso che ho ordinato le date devo verificarle, sia tra dataInizio -> dataFine, che la data inizio dell'ultima sia successiva alla data fine di quella precedente
							validazioneDataInstDataDismisImpLib(Constants.TIPO_COMPONENTE_TE, numComponente, l91TorreSost.getL91DataInstallazione(), l91TorreSost.getL91DataDismissione());

							if (i != listSize-1)
							{
								// Esistono ancora elementi successivi, quindi controllo la data fine attuale con la data inizio successiva
								validazioneDataInstSuccDataDismisImpLib(Constants.TIPO_COMPONENTE_TE, numComponente, l91TorreSostListNew.get(i+1).getL91DataInstallazione(), l91TorreSost.getL91DataDismissione());

								validazioneDataInstSuccDataInstImpLib(Constants.TIPO_COMPONENTE_TE, numComponente, l91TorreSostListNew.get(i+1).getL91DataInstallazione(), l91TorreSost.getL91DataInstallazione());
								validazioneDataDismisSuccDataDismisImpLib(Constants.TIPO_COMPONENTE_TE, numComponente, l91TorreSostListNew.get(i+1).getL91DataDismissione(), l91TorreSost.getL91DataDismissione());

							}

							if(l91TorreSost.getL91Fabbricante() > 0)
							{
								validazioneMarca(l91TorreSost.getL91Fabbricante());
							}

						}
					}
				}

				// Pulisco la lista
				compList.clear();


				// Mi creo una lista specifica per fare l'ordinamento, perche' l'ordinamento con l'oggetto L91TorreSostituito non funziona
				for (int j = 0; j < l91TEList.size(); j++) {
					compList.add(new ComparatorDto(j, l91TEList.get(j).getL91Numero()));
				}

				// ordino per progressivo la lista
				Collections.sort(compList, ComparatorUtil.compareCamparatorDtoByProgressivo());

				// Dopo aver ordinato per la progressivo devo ricostruire la lista di L91PO ordinati
				L91TE[] l91TEArray = new L91TE[compList.size()];

				for (int i = 0; i < compList.size(); i++) {
					l91TEArray[i] = l91TEList.get(compList.get(i).getIdData());

				}

				//Risetto l'array ordinato
				l9AltriComp.setL91TEArray(l91TEArray);


				// Recupero l'oggetto (ho notato che se riusavo l'array avevo dei problemi)
				List<L91TE> l91TEListNew = l9AltriComp.getL91TEList();


				// Devo rinominare il progressivo (L91Numero), in modo che sia 1,2,3,ecc. Perche' l'utente potrebbe aver inserito numeri a caso...
				int count = 1;
				for (L91TE l91Te : l91TEListNew) {

					l91Te.setL91Numero(ConvertUtil.convertToBigInteger(count++));
				}
			}



			// Verificao che ci siano delle RV
			if (l92RVList != null && l92RVList.size() > 0)
			{
				for (L92RV l92Rv : l92RVList)
				{

					numComponente = ConvertUtil.convertToString(l92Rv.getL92Numero());

					L92Raffreddatore l92Raffreddatore =l92Rv.getL92Raffreddatore();

					validazioneDataInstDataDismisSePresImpLib(Constants.TIPO_COMPONENTE_RV, numComponente, l92Raffreddatore.getL92DataInstallazione(), l92Raffreddatore.getL92DataDismissione());

					if(l92Raffreddatore.getL92Fabbricante() > 0)
					{
						validazioneMarca(l92Raffreddatore.getL92Fabbricante());
					}

					List<L92RaffreddatoreSostituito> l92RaffreddatoreSostListOrig = l92Rv.getL92RaffreddatoreSostituitoList();

					// Verificao che ci siano delle sostituzioni
					if (l92RaffreddatoreSostListOrig != null && l92RaffreddatoreSostListOrig.size() > 0)
					{

						compList.clear();

						// Mi creo una lista specifica per fare l'ordinamento, perche' l'ordinamento con l'oggetto Array[] non funziona
						for (int i = 0; i < l92RaffreddatoreSostListOrig.size(); i++)
						{
							compList.add(new ComparatorDto(i, ConvertUtil.convertToDate(l92RaffreddatoreSostListOrig.get(i).getL92DataInstallazione())));
						}

						// ordino per dataInstallazione la lista
						Collections.sort(compList, ComparatorUtil.compareCamparatorDtoByData());


						// Dopo aver ordinato per la dataInstallazione devo ricostruire la lista di oggetti ordinati
						L92RaffreddatoreSostituito[] l92RaffreddatoreSostArray = new L92RaffreddatoreSostituito[compList.size()];

						for (int i = 0; i < compList.size(); i++) {
							l92RaffreddatoreSostArray[i] = l92RaffreddatoreSostListOrig.get(compList.get(i).getIdData());

						}

						//Risetto l'array ordinato
						l92Rv.setL92RaffreddatoreSostituitoArray(l92RaffreddatoreSostArray);



						// Recupero l'oggetto (ho notato che se riusavo l'array avevo dei problemi)
						List<L92RaffreddatoreSostituito> l92RaffreddatoreSostListNew = l92Rv.getL92RaffreddatoreSostituitoList();

						int listSize = l92RaffreddatoreSostListNew.size();

						for (int i = 0; i < listSize; i++) {

							L92RaffreddatoreSostituito l92RaffreddatoreSost = l92RaffreddatoreSostListNew.get(i);

							if (i == 0)
							{
								// Adesso che ho ordinato verifico che la dataDismissione del primo elemento (quindi quello piu' recente - l'elemento 0) sia precedente alla dataInstallazione dell'elemento attuale
								validazioneDataInstSuccDataDismisSostImpLib(Constants.TIPO_COMPONENTE_RV, numComponente, l92RaffreddatoreSost.getL92DataDismissione(), l92Raffreddatore.getL92DataInstallazione());
							}

							// Adesso che ho ordinato le date devo verificarle, sia tra dataInizio -> dataFine, che la data inizio dell'ultima sia successiva alla data fine di quella precedente
							validazioneDataInstDataDismisImpLib(Constants.TIPO_COMPONENTE_RV, numComponente, l92RaffreddatoreSost.getL92DataInstallazione(), l92RaffreddatoreSost.getL92DataDismissione());
							//DateUtil.checkDateOrder(l51SistRegSost.getL51DataInstallazione(), l51SistRegSost.getL51DataDismissione(), true);

							if (i != listSize-1)
							{
								// Esistono ancora elementi successivi, quindi controllo la data fine attuale con la data inizio successiva
								validazioneDataInstSuccDataDismisImpLib(Constants.TIPO_COMPONENTE_RV, numComponente, l92RaffreddatoreSostListNew.get(i+1).getL92DataInstallazione(), l92RaffreddatoreSost.getL92DataDismissione());
								//DateUtil.checkDateOrder(l51SistRegSostList.get(i+1).getL51DataInstallazione(), l51SistRegSost.getL51DataDismissione(), false);

								validazioneDataInstSuccDataInstImpLib(Constants.TIPO_COMPONENTE_RV, numComponente, l92RaffreddatoreSostListNew.get(i+1).getL92DataInstallazione(), l92RaffreddatoreSost.getL92DataInstallazione());
								validazioneDataDismisSuccDataDismisImpLib(Constants.TIPO_COMPONENTE_RV, numComponente, l92RaffreddatoreSostListNew.get(i+1).getL92DataDismissione(), l92RaffreddatoreSost.getL92DataDismissione());

							}

							if(l92RaffreddatoreSost.getL92Fabbricante() > 0)
							{
								validazioneMarca(l92RaffreddatoreSost.getL92Fabbricante());
							}

						}
					}
				}

				// Pulisco la lista
				compList.clear();


				// Mi creo una lista specifica per fare l'ordinamento, perche' l'ordinamento con l'oggetto L92RaffreddatoreSostituito non funziona
				for (int j = 0; j < l92RVList.size(); j++) {
					compList.add(new ComparatorDto(j, l92RVList.get(j).getL92Numero()));
				}

				// ordino per progressivo la lista
				Collections.sort(compList, ComparatorUtil.compareCamparatorDtoByProgressivo());

				// Dopo aver ordinato per la progressivo devo ricostruire la lista di L92RV ordinati
				L92RV[] l92RVArray = new L92RV[compList.size()];

				for (int i = 0; i < compList.size(); i++) {
					l92RVArray[i] = l92RVList.get(compList.get(i).getIdData());

				}

				//Risetto l'array ordinato
				l9AltriComp.setL92RVArray(l92RVArray);


				// Recupero l'oggetto (ho notato che se riusavo l'array avevo dei problemi)
				List<L92RV> l92RVListNew = l9AltriComp.getL92RVList();


				// Devo rinominare il progressivo (L42Numero), in modo che sia 1,2,3,ecc. Perche' l'utente potrebbe aver inserito numeri a caso...
				int count = 1;
				for (L92RV l92Rv : l92RVListNew) {

					l92Rv.setL92Numero(ConvertUtil.convertToBigInteger(count++));
				}
			}


			// Verificao che ci siano delle SCX
			if (l93SCXList != null && l93SCXList.size() > 0)
			{
				for (L93SCX l93Scx : l93SCXList)
				{

					numComponente = ConvertUtil.convertToString(l93Scx.getL93Numero());

					L93ScambiatoreIntermedio l93ScambInter =l93Scx.getL93ScambiatoreIntermedio();

					validazioneDataInstDataDismisSePresImpLib(Constants.TIPO_COMPONENTE_SCX, numComponente, l93ScambInter.getL93DataInstallazione(), l93ScambInter.getL93DataDismissione());

					if(l93ScambInter.getL93Fabbricante() > 0)
					{
						validazioneMarca(l93ScambInter.getL93Fabbricante());
					}

					List<L93ScambiatoreIntermedioSostituito> l93ScambInterSostListOrig = l93Scx.getL93ScambiatoreIntermedioSostituitoList();

					// Verificao che ci siano delle sostituzioni
					if (l93ScambInterSostListOrig != null && l93ScambInterSostListOrig.size() > 0)
					{

						compList.clear();

						// Mi creo una lista specifica per fare l'ordinamento, perche' l'ordinamento con l'oggetto Array[] non funziona
						for (int i = 0; i < l93ScambInterSostListOrig.size(); i++)
						{
							compList.add(new ComparatorDto(i, ConvertUtil.convertToDate(l93ScambInterSostListOrig.get(i).getL93DataInstallazione())));
						}

						// ordino per dataInstallazione la lista
						Collections.sort(compList, ComparatorUtil.compareCamparatorDtoByData());


						// Dopo aver ordinato per la dataInstallazione devo ricostruire la lista di oggetti ordinati
						L93ScambiatoreIntermedioSostituito[] l93ScambInterSostArray = new L93ScambiatoreIntermedioSostituito[compList.size()];

						for (int i = 0; i < compList.size(); i++) {
							l93ScambInterSostArray[i] = l93ScambInterSostListOrig.get(compList.get(i).getIdData());

						}

						//Risetto l'array ordinato
						l93Scx.setL93ScambiatoreIntermedioSostituitoArray(l93ScambInterSostArray);



						// Recupero l'oggetto (ho notato che se riusavo l'array avevo dei problemi)
						List<L93ScambiatoreIntermedioSostituito> l93ScambInterSostListNew = l93Scx.getL93ScambiatoreIntermedioSostituitoList();

						int listSize = l93ScambInterSostListNew.size();

						for (int i = 0; i < listSize; i++) {

							L93ScambiatoreIntermedioSostituito l93ScambInterSost = l93ScambInterSostListNew.get(i);

							if (i == 0)
							{
								// Adesso che ho ordinato verifico che la dataDismissione del primo elemento (quindi quello piu' recente - l'elemento 0) sia precedente alla dataInstallazione dell'elemento attuale
								validazioneDataInstSuccDataDismisSostImpLib(Constants.TIPO_COMPONENTE_SCX, numComponente, l93ScambInterSost.getL93DataDismissione(), l93ScambInter.getL93DataInstallazione());
							}

							// Adesso che ho ordinato le date devo verificarle, sia tra dataInizio -> dataFine, che la data inizio dell'ultima sia successiva alla data fine di quella precedente
							validazioneDataInstDataDismisImpLib(Constants.TIPO_COMPONENTE_SCX, numComponente, l93ScambInterSost.getL93DataInstallazione(), l93ScambInterSost.getL93DataDismissione());

							if (i != listSize-1)
							{
								// Esistono ancora elementi successivi, quindi controllo la data fine attuale con la data inizio successiva
								validazioneDataInstSuccDataDismisImpLib(Constants.TIPO_COMPONENTE_SCX, numComponente, l93ScambInterSostListNew.get(i+1).getL93DataInstallazione(), l93ScambInterSost.getL93DataDismissione());

								validazioneDataInstSuccDataInstImpLib(Constants.TIPO_COMPONENTE_SCX, numComponente, l93ScambInterSostListNew.get(i+1).getL93DataInstallazione(), l93ScambInterSost.getL93DataInstallazione());
								validazioneDataDismisSuccDataDismisImpLib(Constants.TIPO_COMPONENTE_SCX, numComponente, l93ScambInterSostListNew.get(i+1).getL93DataDismissione(), l93ScambInterSost.getL93DataDismissione());

							}

							if(l93ScambInterSost.getL93Fabbricante() > 0)
							{
								validazioneMarca(l93ScambInterSost.getL93Fabbricante());
							}

						}
					}
				}

				// Pulisco la lista
				compList.clear();


				// Mi creo una lista specifica per fare l'ordinamento, perche' l'ordinamento con l'oggetto L93ScambInterSostituito non funziona
				for (int j = 0; j < l93SCXList.size(); j++) {
					compList.add(new ComparatorDto(j, l93SCXList.get(j).getL93Numero()));
				}

				// ordino per progressivo la lista
				Collections.sort(compList, ComparatorUtil.compareCamparatorDtoByProgressivo());

				// Dopo aver ordinato per la progressivo devo ricostruire la lista di L93SCX ordinati
				L93SCX[] l93SCXArray = new L93SCX[compList.size()];

				for (int i = 0; i < compList.size(); i++) {
					l93SCXArray[i] = l93SCXList.get(compList.get(i).getIdData());

				}

				//Risetto l'array ordinato
				l9AltriComp.setL93SCXArray(l93SCXArray);


				// Recupero l'oggetto (ho notato che se riusavo l'array avevo dei problemi)
				List<L93SCX> l93SCXListNew = l9AltriComp.getL93SCXList();


				// Devo rinominare il progressivo (L93Numero), in modo che sia 1,2,3,ecc. Perche' l'utente potrebbe aver inserito numeri a caso...
				int count = 1;
				for (L93SCX l93Scx : l93SCXListNew) {

					l93Scx.setL93Numero(ConvertUtil.convertToBigInteger(count++));
				}
			}


			// Verificao che ci siano delle CI
			if (l94CIList != null && l94CIList.size() > 0)
			{
				for (L94CI l94Ci : l94CIList)
				{

					numComponente = ConvertUtil.convertToString(l94Ci.getL94Numero());

					L94Circuito l94Circuito =l94Ci.getL94Circuito();

					validazioneDataInstDataDismisSePresImpLib(Constants.TIPO_COMPONENTE_CI, numComponente, l94Circuito.getL94DataInstallazione(), l94Circuito.getL94DataDismissione());

					List<L94CircuitoSostituito> l94CircuitoSostListOrig = l94Ci.getL94CircuitoSostituitoList();

					// Verificao che ci siano delle sostituzioni
					if (l94CircuitoSostListOrig != null && l94CircuitoSostListOrig.size() > 0)
					{

						compList.clear();

						// Mi creo una lista specifica per fare l'ordinamento, perche' l'ordinamento con l'oggetto Array[] non funziona
						for (int i = 0; i < l94CircuitoSostListOrig.size(); i++)
						{
							compList.add(new ComparatorDto(i, ConvertUtil.convertToDate(l94CircuitoSostListOrig.get(i).getL94DataInstallazione())));
						}

						// ordino per dataInstallazione la lista
						Collections.sort(compList, ComparatorUtil.compareCamparatorDtoByData());


						// Dopo aver ordinato per la dataInstallazione devo ricostruire la lista di oggetti ordinati
						L94CircuitoSostituito[] l94CircuitoSostArray = new L94CircuitoSostituito[compList.size()];

						for (int i = 0; i < compList.size(); i++) {
							l94CircuitoSostArray[i] = l94CircuitoSostListOrig.get(compList.get(i).getIdData());

						}

						//Risetto l'array ordinato
						l94Ci.setL94CircuitoSostituitoArray(l94CircuitoSostArray);



						// Recupero l'oggetto (ho notato che se riusavo l'array avevo dei problemi)
						List<L94CircuitoSostituito> l94CircuitoSostListNew = l94Ci.getL94CircuitoSostituitoList();

						int listSize = l94CircuitoSostListNew.size();

						for (int i = 0; i < listSize; i++) {

							L94CircuitoSostituito l94CircuitoSost = l94CircuitoSostListNew.get(i);

							if (i == 0)
							{
								// Adesso che ho ordinato verifico che la dataDismissione del primo elemento (quindi quello piu' recente - l'elemento 0) sia precedente alla dataInstallazione dell'elemento attuale
								validazioneDataInstSuccDataDismisSostImpLib(Constants.TIPO_COMPONENTE_CI, numComponente, l94CircuitoSost.getL94DataDismissione(), l94Circuito.getL94DataInstallazione());
							}

							// Adesso che ho ordinato le date devo verificarle, sia tra dataInizio -> dataFine, che la data inizio dell'ultima sia successiva alla data fine di quella precedente
							validazioneDataInstDataDismisImpLib(Constants.TIPO_COMPONENTE_CI, numComponente, l94CircuitoSost.getL94DataInstallazione(), l94CircuitoSost.getL94DataDismissione());

							if (i != listSize-1)
							{
								// Esistono ancora elementi successivi, quindi controllo la data fine attuale con la data inizio successiva
								validazioneDataInstSuccDataDismisImpLib(Constants.TIPO_COMPONENTE_CI, numComponente, l94CircuitoSostListNew.get(i+1).getL94DataInstallazione(), l94CircuitoSost.getL94DataDismissione());

								validazioneDataInstSuccDataInstImpLib(Constants.TIPO_COMPONENTE_CI, numComponente, l94CircuitoSostListNew.get(i+1).getL94DataInstallazione(), l94CircuitoSost.getL94DataInstallazione());
								validazioneDataDismisSuccDataDismisImpLib(Constants.TIPO_COMPONENTE_CI, numComponente, l94CircuitoSostListNew.get(i+1).getL94DataDismissione(), l94CircuitoSost.getL94DataDismissione());

							}
						}
					}
				}

				// Pulisco la lista
				compList.clear();


				// Mi creo una lista specifica per fare l'ordinamento, perche' l'ordinamento con l'oggetto L94CircuitoSostituito non funziona
				for (int j = 0; j < l94CIList.size(); j++) {
					compList.add(new ComparatorDto(j, l94CIList.get(j).getL94Numero()));
				}

				// ordino per progressivo la lista
				Collections.sort(compList, ComparatorUtil.compareCamparatorDtoByProgressivo());

				// Dopo aver ordinato per la progressivo devo ricostruire la lista di L94CI ordinati
				L94CI[] l94CIArray = new L94CI[compList.size()];

				for (int i = 0; i < compList.size(); i++) {
					l94CIArray[i] = l94CIList.get(compList.get(i).getIdData());

				}

				//Risetto l'array ordinato
				l9AltriComp.setL94CIArray(l94CIArray);


				// Recupero l'oggetto (ho notato che se riusavo l'array avevo dei problemi)
				List<L94CI> l94CIListNew = l9AltriComp.getL94CIList();


				// Devo rinominare il progressivo (L94Numero), in modo che sia 1,2,3,ecc. Perche' l'utente potrebbe aver inserito numeri a caso...
				int count = 1;
				for (L94CI l94Ci : l94CIListNew) {

					l94Ci.setL94Numero(ConvertUtil.convertToBigInteger(count++));
				}
			}



			// Verificao che ci siano delle UT
			if (l95UTList != null && l95UTList.size() > 0)
			{
				for (L95UT l95Ut : l95UTList)
				{

					numComponente = ConvertUtil.convertToString(l95Ut.getL95Numero());

					L95UnitaTrattAria l95UnitaTrattAria =l95Ut.getL95UnitaTrattAria();

					validazioneDataInstDataDismisSePresImpLib(Constants.TIPO_COMPONENTE_UT, numComponente, l95UnitaTrattAria.getL95DataInstallazione(), l95UnitaTrattAria.getL95DataDismissione());

					if(l95UnitaTrattAria.getL95Fabbricante() > 0)
					{
						validazioneMarca(l95UnitaTrattAria.getL95Fabbricante());
					}

					List<L95UnitaTrattAriaSostituito> l95UnitaTrattAriaSostListOrig = l95Ut.getL95UnitaTrattAriaSostituitoList();

					// Verificao che ci siano delle sostituzioni
					if (l95UnitaTrattAriaSostListOrig != null && l95UnitaTrattAriaSostListOrig.size() > 0)
					{

						compList.clear();

						// Mi creo una lista specifica per fare l'ordinamento, perche' l'ordinamento con l'oggetto Array[] non funziona
						for (int i = 0; i < l95UnitaTrattAriaSostListOrig.size(); i++)
						{
							compList.add(new ComparatorDto(i, ConvertUtil.convertToDate(l95UnitaTrattAriaSostListOrig.get(i).getL95DataInstallazione())));
						}

						// ordino per dataInstallazione la lista
						Collections.sort(compList, ComparatorUtil.compareCamparatorDtoByData());


						// Dopo aver ordinato per la dataInstallazione devo ricostruire la lista di oggetti ordinati
						L95UnitaTrattAriaSostituito[] l95UnitaTrattAriaSostArray = new L95UnitaTrattAriaSostituito[compList.size()];

						for (int i = 0; i < compList.size(); i++) {
							l95UnitaTrattAriaSostArray[i] = l95UnitaTrattAriaSostListOrig.get(compList.get(i).getIdData());

						}

						//Risetto l'array ordinato
						l95Ut.setL95UnitaTrattAriaSostituitoArray(l95UnitaTrattAriaSostArray);



						// Recupero l'oggetto (ho notato che se riusavo l'array avevo dei problemi)
						List<L95UnitaTrattAriaSostituito> l95UnitaTrattAriaSostListNew = l95Ut.getL95UnitaTrattAriaSostituitoList();

						int listSize = l95UnitaTrattAriaSostListNew.size();

						for (int i = 0; i < listSize; i++) {

							L95UnitaTrattAriaSostituito l95UnitaTrattAriaSost = l95UnitaTrattAriaSostListNew.get(i);

							if (i == 0)
							{
								// Adesso che ho ordinato verifico che la dataDismissione del primo elemento (quindi quello piu' recente - l'elemento 0) sia precedente alla dataInstallazione dell'elemento attuale
								validazioneDataInstSuccDataDismisSostImpLib(Constants.TIPO_COMPONENTE_UT, numComponente, l95UnitaTrattAriaSost.getL95DataDismissione(), l95UnitaTrattAria.getL95DataInstallazione());
							}

							// Adesso che ho ordinato le date devo verificarle, sia tra dataInizio -> dataFine, che la data inizio dell'ultima sia successiva alla data fine di quella precedente
							validazioneDataInstDataDismisImpLib(Constants.TIPO_COMPONENTE_UT, numComponente, l95UnitaTrattAriaSost.getL95DataInstallazione(), l95UnitaTrattAriaSost.getL95DataDismissione());

							if (i != listSize-1)
							{
								// Esistono ancora elementi successivi, quindi controllo la data fine attuale con la data inizio successiva
								validazioneDataInstSuccDataDismisImpLib(Constants.TIPO_COMPONENTE_UT, numComponente, l95UnitaTrattAriaSostListNew.get(i+1).getL95DataInstallazione(), l95UnitaTrattAriaSost.getL95DataDismissione());

								validazioneDataInstSuccDataInstImpLib(Constants.TIPO_COMPONENTE_UT, numComponente, l95UnitaTrattAriaSostListNew.get(i+1).getL95DataInstallazione(), l95UnitaTrattAriaSost.getL95DataInstallazione());
								validazioneDataDismisSuccDataDismisImpLib(Constants.TIPO_COMPONENTE_UT, numComponente, l95UnitaTrattAriaSostListNew.get(i+1).getL95DataDismissione(), l95UnitaTrattAriaSost.getL95DataDismissione());

							}

							if(l95UnitaTrattAriaSost.getL95Fabbricante() > 0)
							{
								validazioneMarca(l95UnitaTrattAriaSost.getL95Fabbricante());
							}

						}
					}
				}

				// Pulisco la lista
				compList.clear();


				// Mi creo una lista specifica per fare l'ordinamento, perche' l'ordinamento con l'oggetto L95UnitaTrattAriaSostituito non funziona
				for (int j = 0; j < l95UTList.size(); j++) {
					compList.add(new ComparatorDto(j, l95UTList.get(j).getL95Numero()));
				}

				// ordino per progressivo la lista
				Collections.sort(compList, ComparatorUtil.compareCamparatorDtoByProgressivo());

				// Dopo aver ordinato per la progressivo devo ricostruire la lista di L95UT ordinati
				L95UT[] l95UTArray = new L95UT[compList.size()];

				for (int i = 0; i < compList.size(); i++) {
					l95UTArray[i] = l95UTList.get(compList.get(i).getIdData());

				}

				//Risetto l'array ordinato
				l9AltriComp.setL95UTArray(l95UTArray);


				// Recupero l'oggetto (ho notato che se riusavo l'array avevo dei problemi)
				List<L95UT> l95UTListNew = l9AltriComp.getL95UTList();


				// Devo rinominare il progressivo (L95Numero), in modo che sia 1,2,3,ecc. Perche' l'utente potrebbe aver inserito numeri a caso...
				int count = 1;
				for (L95UT l95Ut : l95UTListNew) {

					l95Ut.setL95Numero(ConvertUtil.convertToBigInteger(count++));
				}
			}



			// Verificao che ci siano delle RCX
			if (l96RCXList != null && l96RCXList.size() > 0)
			{
				for (L96RCX l96Rcx : l96RCXList)
				{

					numComponente = ConvertUtil.convertToString(l96Rcx.getL96Numero());

					L96RecuperatoreAriaAmb l96RecAriaAmb =l96Rcx.getL96RecuperatoreAriaAmb();

					validazioneDataInstDataDismisSePresImpLib(Constants.TIPO_COMPONENTE_RCX, numComponente, l96RecAriaAmb.getL96DataInstallazione(), l96RecAriaAmb.getL96DataDismissione());

					List<L96RecuperatoreAriaAmbSostituito> l96RecAriaAmbSostListOrig = l96Rcx.getL96RecuperatoreAriaAmbSostituitoList();

					// Verificao che ci siano delle sostituzioni
					if (l96RecAriaAmbSostListOrig != null && l96RecAriaAmbSostListOrig.size() > 0)
					{

						compList.clear();

						// Mi creo una lista specifica per fare l'ordinamento, perche' l'ordinamento con l'oggetto Array[] non funziona
						for (int i = 0; i < l96RecAriaAmbSostListOrig.size(); i++)
						{
							compList.add(new ComparatorDto(i, ConvertUtil.convertToDate(l96RecAriaAmbSostListOrig.get(i).getL96DataInstallazione())));
						}

						// ordino per dataInstallazione la lista
						Collections.sort(compList, ComparatorUtil.compareCamparatorDtoByData());


						// Dopo aver ordinato per la dataInstallazione devo ricostruire la lista di oggetti ordinati
						L96RecuperatoreAriaAmbSostituito[] l96RecAriaAmbSostArray = new L96RecuperatoreAriaAmbSostituito[compList.size()];

						for (int i = 0; i < compList.size(); i++) {
							l96RecAriaAmbSostArray[i] = l96RecAriaAmbSostListOrig.get(compList.get(i).getIdData());

						}

						//Risetto l'array ordinato
						l96Rcx.setL96RecuperatoreAriaAmbSostituitoArray(l96RecAriaAmbSostArray);



						// Recupero l'oggetto (ho notato che se riusavo l'array avevo dei problemi)
						List<L96RecuperatoreAriaAmbSostituito> l96RecAriaAmbSostListNew = l96Rcx.getL96RecuperatoreAriaAmbSostituitoList();

						int listSize = l96RecAriaAmbSostListNew.size();

						for (int i = 0; i < listSize; i++) {

							L96RecuperatoreAriaAmbSostituito l96RecAriaAmbSost = l96RecAriaAmbSostListNew.get(i);

							if (i == 0)
							{
								// Adesso che ho ordinato verifico che la dataDismissione del primo elemento (quindi quello piu' recente - l'elemento 0) sia precedente alla dataInstallazione dell'elemento attuale
								validazioneDataInstSuccDataDismisSostImpLib(Constants.TIPO_COMPONENTE_RCX, numComponente, l96RecAriaAmbSost.getL96DataDismissione(), l96RecAriaAmb.getL96DataInstallazione());
							}

							// Adesso che ho ordinato le date devo verificarle, sia tra dataInizio -> dataFine, che la data inizio dell'ultima sia successiva alla data fine di quella precedente
							validazioneDataInstDataDismisImpLib(Constants.TIPO_COMPONENTE_RCX, numComponente, l96RecAriaAmbSost.getL96DataInstallazione(), l96RecAriaAmbSost.getL96DataDismissione());

							if (i != listSize-1)
							{
								// Esistono ancora elementi successivi, quindi controllo la data fine attuale con la data inizio successiva
								validazioneDataInstSuccDataDismisImpLib(Constants.TIPO_COMPONENTE_RCX, numComponente, l96RecAriaAmbSostListNew.get(i+1).getL96DataInstallazione(), l96RecAriaAmbSost.getL96DataDismissione());

								validazioneDataInstSuccDataInstImpLib(Constants.TIPO_COMPONENTE_RCX, numComponente, l96RecAriaAmbSostListNew.get(i+1).getL96DataInstallazione(), l96RecAriaAmbSost.getL96DataInstallazione());
								validazioneDataDismisSuccDataDismisImpLib(Constants.TIPO_COMPONENTE_RCX, numComponente, l96RecAriaAmbSostListNew.get(i+1).getL96DataDismissione(), l96RecAriaAmbSost.getL96DataDismissione());

							}
						}
					}
				}

				// Pulisco la lista
				compList.clear();


				// Mi creo una lista specifica per fare l'ordinamento, perche' l'ordinamento con l'oggetto L96RecuperatoreAriaAmbSostituito non funziona
				for (int j = 0; j < l96RCXList.size(); j++) {
					compList.add(new ComparatorDto(j, l96RCXList.get(j).getL96Numero()));
				}

				// ordino per progressivo la lista
				Collections.sort(compList, ComparatorUtil.compareCamparatorDtoByProgressivo());

				// Dopo aver ordinato per la progressivo devo ricostruire la lista di L96RCX ordinati
				L96RCX[] l96RCXArray = new L96RCX[compList.size()];

				for (int i = 0; i < compList.size(); i++) {
					l96RCXArray[i] = l96RCXList.get(compList.get(i).getIdData());

				}

				//Risetto l'array ordinato
				l9AltriComp.setL96RCXArray(l96RCXArray);


				// Recupero l'oggetto (ho notato che se riusavo l'array avevo dei problemi)
				List<L96RCX> l96RCXListNew = l9AltriComp.getL96RCXList();


				// Devo rinominare il progressivo (L96Numero), in modo che sia 1,2,3,ecc. Perche' l'utente potrebbe aver inserito numeri a caso...
				int count = 1;
				for (L96RCX l96Rcx : l96RCXListNew) {

					l96Rcx.setL96Numero(ConvertUtil.convertToBigInteger(count++));
				}
			}
		}

	}

	private void validazioneL10VentilazioneMeccanica(LibrettoCatasto richiesta) throws ValidationManagerException
	{
		L10Ventilazione l8SistAccumulo = richiesta.getL10Ventilazione();

		if (l8SistAccumulo != null)
		{

			List<L101VM> l101VMList = l8SistAccumulo.getL101VMList();

			List<ComparatorDto> compList = new ArrayList<ComparatorDto>();
			// Verificao che ci siano delle AC
			if (l101VMList != null && l101VMList.size() > 0)
			{
				for (L101VM l101Vm : l101VMList)
				{

					String numComponente = ConvertUtil.convertToString(l101Vm.getL101Numero());

					L101VentilazioneMeccanica l101VentMeccanica =l101Vm.getL101VentilazioneMeccanica();

					validazioneDataInstDataDismisSePresImpLib(Constants.TIPO_COMPONENTE_VM, numComponente, l101VentMeccanica.getL101DataInstallazione(), l101VentMeccanica.getL101DataDismissione());

					validazioneMarca(l101VentMeccanica.getL101Fabbricante());

					List<L101VentilazioneMeccanicaSostituito> l101VentMeccanicaSostListOrig = l101Vm.getL101VentilazioneMeccanicaSostituitoList();

					// Verificao che ci siano delle sostituzioni
					if (l101VentMeccanicaSostListOrig != null && l101VentMeccanicaSostListOrig.size() > 0)
					{

						compList.clear();

						// Mi creo una lista specifica per fare l'ordinamento, perche' l'ordinamento con l'oggetto Array[] non funziona
						for (int i = 0; i < l101VentMeccanicaSostListOrig.size(); i++)
						{
							compList.add(new ComparatorDto(i, ConvertUtil.convertToDate(l101VentMeccanicaSostListOrig.get(i).getL101DataInstallazione())));
						}

						// ordino per dataInstallazione la lista
						Collections.sort(compList, ComparatorUtil.compareCamparatorDtoByData());


						// Dopo aver ordinato per la dataInstallazione devo ricostruire la lista di oggetti ordinati
						L101VentilazioneMeccanicaSostituito[] l101VentMeccanicaSostArray = new L101VentilazioneMeccanicaSostituito[compList.size()];

						for (int i = 0; i < compList.size(); i++) {
							l101VentMeccanicaSostArray[i] = l101VentMeccanicaSostListOrig.get(compList.get(i).getIdData());

						}

						//Risetto l'array ordinato
						l101Vm.setL101VentilazioneMeccanicaSostituitoArray(l101VentMeccanicaSostArray);



						// Recupero l'oggetto (ho notato che se riusavo l'array avevo dei problemi)
						List<L101VentilazioneMeccanicaSostituito> l101VentMeccanicaSostListNew = l101Vm.getL101VentilazioneMeccanicaSostituitoList();

						int listSize = l101VentMeccanicaSostListNew.size();

						for (int i = 0; i < listSize; i++) {

							L101VentilazioneMeccanicaSostituito l101VentMeccanicaSost = l101VentMeccanicaSostListNew.get(i);

							if (i == 0)
							{
								// Adesso che ho ordinato verifico che la dataDismissione del primo elemento (quindi quello piu' recente - l'elemento 0) sia precedente alla dataInstallazione dell'elemento attuale
								validazioneDataInstSuccDataDismisSostImpLib(Constants.TIPO_COMPONENTE_VM, numComponente, l101VentMeccanicaSost.getL101DataDismissione(), l101VentMeccanica.getL101DataInstallazione());
							}

							// Adesso che ho ordinato le date devo verificarle, sia tra dataInizio -> dataFine, che la data inizio dell'ultima sia successiva alla data fine di quella precedente
							validazioneDataInstDataDismisImpLib(Constants.TIPO_COMPONENTE_VM, numComponente, l101VentMeccanicaSost.getL101DataInstallazione(), l101VentMeccanicaSost.getL101DataDismissione());

							if (i != listSize-1)
							{
								// Esistono ancora elementi successivi, quindi controllo la data fine attuale con la data inizio successiva
								validazioneDataInstSuccDataDismisImpLib(Constants.TIPO_COMPONENTE_VM, numComponente, l101VentMeccanicaSostListNew.get(i+1).getL101DataInstallazione(), l101VentMeccanicaSost.getL101DataDismissione());

								validazioneDataInstSuccDataInstImpLib(Constants.TIPO_COMPONENTE_VM, numComponente, l101VentMeccanicaSostListNew.get(i+1).getL101DataInstallazione(), l101VentMeccanicaSost.getL101DataInstallazione());
								validazioneDataDismisSuccDataDismisImpLib(Constants.TIPO_COMPONENTE_VM, numComponente, l101VentMeccanicaSostListNew.get(i+1).getL101DataDismissione(), l101VentMeccanicaSost.getL101DataDismissione());

							}

							validazioneMarca(l101VentMeccanicaSost.getL101Fabbricante());

						}
					}
				}

				// Pulisco la lista
				compList.clear();


				// Mi creo una lista specifica per fare l'ordinamento, perche' l'ordinamento con l'oggetto L101VentMeccanicaSostituito non funziona
				for (int j = 0; j < l101VMList.size(); j++) {
					compList.add(new ComparatorDto(j, l101VMList.get(j).getL101Numero()));
				}

				// ordino per progressivo la lista
				Collections.sort(compList, ComparatorUtil.compareCamparatorDtoByProgressivo());

				// Dopo aver ordinato per la progressivo devo ricostruire la lista di L101VM ordinati
				L101VM[] l101VMArray = new L101VM[compList.size()];

				for (int i = 0; i < compList.size(); i++) {
					l101VMArray[i] = l101VMList.get(compList.get(i).getIdData());

				}

				//Risetto l'array ordinato
				l8SistAccumulo.setL101VMArray(l101VMArray);


				// Recupero l'oggetto (ho notato che se riusavo l'array avevo dei problemi)
				List<L101VM> l101VMListNew = l8SistAccumulo.getL101VMList();


				// Devo rinominare il progressivo (L64Numero), in modo che sia 1,2,3,ecc. Perche' l'utente potrebbe aver inserito numeri a caso...
				int count = 1;
				for (L101VM l101Ac : l101VMListNew) {

					l101Ac.setL101Numero(ConvertUtil.convertToBigInteger(count++));
				}
			}
		}
	}

	private static void validazioneDataInstDataDismisSePresImpLib(String tipoComp, String componente, Calendar dataInstallazione, Calendar dataDismissione) throws ValidationManagerException
	{
		boolean check = false;

		// verifico la data installazione che non sia futura
		check = DateUtil.checkDateFuture(dataInstallazione);
		if (!check)
		{
			throw new ValidationManagerException(new Message(Messages.S134, tipoComp, componente, ConvertUtil.convertToString(dataInstallazione)));
		}

		// verifico la data dismissione (se presente) che non sia futura
		check = DateUtil.checkDateFutureIsPresents(dataDismissione);
		if (!check)
		{
			throw new ValidationManagerException(new Message(Messages.S134, tipoComp, componente, ConvertUtil.convertToString(dataDismissione)));
		}

		check = DateUtil.checkDateOrderIsPresents(dataInstallazione, dataDismissione, true);

		if (!check)
		{
			throw new ValidationManagerException(new Message(Messages.S130, tipoComp, componente, ConvertUtil.convertToString(dataInstallazione)));
		}
	}

	private static void validazioneDataInstDataDismisImpLib(String tipoComp, String componente, Calendar dataInstallazione, Calendar dataDismissione) throws ValidationManagerException
	{
		boolean check = DateUtil.checkDateOrder(dataInstallazione, dataDismissione, true);

		if (!check)
		{
			throw new ValidationManagerException(new Message(Messages.S130, tipoComp, componente, ConvertUtil.convertToString(dataInstallazione)));
		}
	}

	private static void validazioneDataInstSuccDataDismisImpLib(String tipoComp, String componente, Calendar dataInstallazione, Calendar dataDismissione) throws ValidationManagerException
	{

		boolean check = DateUtil.checkDateOrder(dataInstallazione, dataDismissione, false);

		if (!check)
		{
			throw new ValidationManagerException(new Message(Messages.S131, tipoComp, componente, ConvertUtil.convertToString(dataInstallazione), ConvertUtil.convertToString(dataDismissione)));
		}
	}

	private static void validazioneDataInstSuccDataDismisSostImpLib(String tipoComp, String componente, Calendar dataInstallazione, Calendar dataDismissione) throws ValidationManagerException
	{

		boolean check = DateUtil.checkDateOrder(dataInstallazione, dataDismissione, false);

		if (!check)
		{
			throw new ValidationManagerException(new Message(Messages.S131, tipoComp, componente, ConvertUtil.convertToString(dataDismissione), ConvertUtil.convertToString(dataInstallazione)));
		}
	}

	private static void validazioneDataInstSuccDataInstImpLib(String tipoComp, String componente, Calendar dataInstallazionePrec, Calendar dataInstallazione) throws ValidationManagerException
	{

		boolean check = DateUtil.checkDateOrder(dataInstallazionePrec, dataInstallazione, false);

		if (!check)
		{
			throw new ValidationManagerException(new Message(Messages.S142, tipoComp, componente, ConvertUtil.convertToString(dataInstallazionePrec), ConvertUtil.convertToString(dataInstallazione)));
		}
	}


	private static void validazioneDataDismisSuccDataDismisImpLib(String tipoComp, String componente, Calendar dataDismissionePrec, Calendar dataDismissione) throws ValidationManagerException
	{

		boolean check = DateUtil.checkDateOrder(dataDismissionePrec, dataDismissione, false);

		if (!check)
		{
			throw new ValidationManagerException(new Message(Messages.S143, tipoComp, componente, ConvertUtil.convertToString(dataDismissionePrec), ConvertUtil.convertToString(dataDismissione)));
		}
	}


	private void validazioneCombustibile(int idCombustibile) throws ValidationManagerException
	{

		try
		{
			if (getDbMgr().getCombustibileById(idCombustibile) == null)
			{
				throw new ValidationManagerException(new Message(Messages.S133, Constants.DESC_TABELLA_COMBUSTIBILE, ConvertUtil.convertToString(idCombustibile)));
			}
		} catch (DbManagerException e) {
			throw new ValidationManagerException(new Message(Messages.ERROR_RECUPERO_SERVIZIO));
		}
	}

	private void validazioneUnitaMisura(int idUnitaMisura) throws ValidationManagerException
	{

		try
		{
			if (getDbMgr().getUnitaMisuraById(idUnitaMisura) == null)
			{
				throw new ValidationManagerException(new Message(Messages.S133, Constants.DESC_TABELLA_UNITA_MISURA, ConvertUtil.convertToString(idUnitaMisura)));
			}
		} catch (DbManagerException e) {
			throw new ValidationManagerException(new Message(Messages.ERROR_RECUPERO_SERVIZIO));
		}
	}

	private void validazioneMarca(int idMarca) throws ValidationManagerException
	{

		try
		{
			if (getDbMgr().getMarcaById(idMarca) == null)
			{
				throw new ValidationManagerException(new Message(Messages.S133, Constants.DESC_TABELLA_MARCA, ConvertUtil.convertToString(idMarca)));
			}
		} catch (DbManagerException e) {
			//System.out.println("Errore: "+e);
			throw new ValidationManagerException(new Message(Messages.ERROR_RECUPERO_SERVIZIO));
		}
	}

	private void validazioneFluido(int idFluido) throws ValidationManagerException
	{
		try
		{
			if (getDbMgr().getFluidoById(idFluido) == null)
			{
				throw new ValidationManagerException(new Message(Messages.S133, Constants.DESC_TABELLA_FLUIDO, ConvertUtil.convertToString(idFluido)));
			}
		} catch (DbManagerException e) {
			//System.out.println("Errore: "+e);
			throw new ValidationManagerException(new Message(Messages.ERROR_RECUPERO_SERVIZIO));
		}
	}

	public ImportDistribFilter validazioneXmlImportDistributore(File file, String fileName) throws ValidationManagerException
	{

		log.debug("nome file: " + fileName);
		try
		{
			String error = null;
			Integer annoVerifica = null;
			if (file == null
					|| !fileName.toUpperCase().endsWith(".XML"))
			{
				error = fileName + " " + Messages.S096.replaceFirst("##value##", Constants.ESTENSIONE_XML);

				//throw new ValidationManagerException(new Message(fileName + " " + Messages.S096+ "<br/>\n"));

			}
			else if (fileName.length() > Constants.MAX_NOME_FILE_LEN)
			{
				error = fileName + " " + Messages.S160.replaceFirst("##value##", ConvertUtil.convertToString(Constants.MAX_NOME_FILE_LEN));

			}
			else
			{
				boolean isError = false;
				int delim = fileName.indexOf("_");
				if (delim > 0)
				{
					String anno = fileName.substring(0, delim);

					log.debug("Stampo l'anno recuperato: "+anno);

					if (ConvertUtil.checkValideFourNumber(anno))
					{

						annoVerifica = ConvertUtil.convertToInteger(anno);
						int annoCorrente = DateUtil.getAnnoCorrente();

						log.debug("Stampo l'anno corrente: "+annoCorrente);

						if (annoVerifica.intValue() < 2000 || annoVerifica.intValue() > annoCorrente)
						{
							isError = true;
						}
					}
					else
					{
						isError = true;
					}
				}
				else
				{
					isError = true;
				}

				if (isError)
				{

					error = Messages.S097.replaceFirst("##value##", fileName);

				}
			}

			if (GenericUtil.isNotNullOrEmpty(error))
			{
				throw new ValidationManagerException(new Message(error+ "<br/>\n"));
			}

			ImportDistribFilter filter = new ImportDistribFilter();
			filter.setAnnoRiferimento(annoVerifica);
			filter.setNomeFile(fileName);
			filter.setDataInizio(DateUtil.getSqlDataCorrente());
			filter.setFile(file);
//			ImportFilter data = new ImportFilter();
//			data.setCodiceImpianto(codiceImpianto);
//			data.setDataInizio(DateUtil.getSqlDataCorrente());
//			data.setNomeFile(fileName);
//			data.setDatiXml(theXml);
			return filter;
		}
		catch (ValidationManagerException e) {
			log.error("Errore: ",e);
			throw e;
		}
		catch (Exception e) {
			log.error("Errore: ",e);
			throw new ValidationManagerException(new Message(Messages.S096));
		}
		finally
		{
			log.debug("validazioneXmlImportDistributore END");
		}
	}


	public void checkEmail(String emailField, String email, ServiziMgr mgr) throws ValidationManagerException {
		ValidationManagerException ex = null;

		if (!GenericUtil.checkValideEmail(email))
		{
			ex = new ValidationManagerException(new Message(Messages.ERROR_EMAIL_FORMAT));
			ex.addField(emailField);
			throw ex;
		}
	}


	public void validazioneFormaleLibrettoScheda1(Scheda1 scheda1) throws ValidationManagerException {
		preparaToValidate(scheda1);

		ValidationManagerException validationException = new ValidationManagerException();

		//throw new ValidationManagerException(new Message(Messages.S131, tipoComp, componente, ConvertUtil.convertToString(dataInstallazione), ConvertUtil.convertToString(dataDismissione)));
		if (GenericUtil.isNullOrEmpty(scheda1.getDataIntervento())) {
			validationException.addFieldRequired("appDatascheda1.dataIntervento");
		}

		if (GenericUtil.isNullOrEmpty(scheda1.getIdTipoIntervento())) {
			validationException.addFieldRequired("appDatascheda1.idTipoIntervento");
		}

		//1.2
		if (GenericUtil.isNullOrEmpty(scheda1.getCategoria())) {
			validationException.addFieldRequired("appDatascheda1.categoria");
		}

		/////////////////////////////////////////////////1.3/////////////////////////////////////////////////
		//d.costa: automatismo su Produzione di acqua calda sanitaria (acs)=> se il campo e' vuoto ma la checkbox risulta flaggata, viene dato errore
		//di obbligatorieta'. Se invece il campo non e' vuoto viene fatto il controllo sul suo contenuto. La checkbox eredita il contenuto del campo collegato (automatismo)
		if (GenericUtil.isNullOrEmpty(scheda1.getPotenzaUtileProduzioneACS())) {
			if (scheda1.getFlagPotenzaUtileProduzioneACS()) {
				validationException.addField("appDatascheda1.potenzaUtileProduzioneACS",Messages.S168);
			}
		} else {
			scheda1.setFlagPotenzaUtileProduzioneACS(true);
			checkNumero(scheda1.getPotenzaUtileProduzioneACS(), "appDatascheda1.potenzaUtileProduzioneACS", 6, 2, validationException, true);
		}

		//Climatizzazione Invernale (se viene riempito uno dei valori in potenza utile e volume riscaldato, la checkbox viene autoselezionata)
		//se viene popolato uno dei due campi, l'automatismo sulla checkbox condiziona l'obbligatorieta' dell'altro campo se vuoto
		boolean potenzaUtileClimaInvEmpty = StringUtils.isBlank(scheda1.getPotenzaUtileClimatInvernale());
		boolean volumeLordoRiscaldatoEmpty = StringUtils.isBlank(scheda1.getVolumeLordoRiscaldato());
		//se non � stato scritto niente in potenzaUtileClimaInv
		if (potenzaUtileClimaInvEmpty) {
			//se la checkbox relativa � stata selezionata o se � stato scritto qualcosa nel volumeRiscaldato
			if (scheda1.getFlagPotenzaUtileClimatInvernale() || !volumeLordoRiscaldatoEmpty) {
				//potenzaUtileClimaInv diventa obbligatorio
				validationException.addField("appDatascheda1.potenzaUtileClimatInvernale",Messages.S168);
			}
		} else {
			checkNumero(scheda1.getPotenzaUtileClimatInvernale(), "appDatascheda1.potenzaUtileClimatInvernale", 6, 2, validationException, true);
		}
		//se non e' stato scritto niente nel volume riscaldato
		if (volumeLordoRiscaldatoEmpty) {
			//se la checkbox relativa e' stata selezionata o e' stato scritto qualcosa nella potenza utile invernale
			if (scheda1.getFlagPotenzaUtileClimatInvernale() || !potenzaUtileClimaInvEmpty) {
				validationException.addField("appDatascheda1.volumeLordoRiscaldato",Messages.S168_VOLUME_RISCALDATO);
			}
		} else {
			checkNumero(scheda1.getVolumeLordoRiscaldato(), "appDatascheda1.volumeLordoRiscaldato", 7, 2, validationException, true);
		}
		//automatismo: la checkbox viene selezionata se almeno uno dei due campi sono stati popolati
		if (!scheda1.getFlagPotenzaUtileClimatInvernale()) {
			scheda1.setFlagPotenzaUtileClimatInvernale(!potenzaUtileClimaInvEmpty || !volumeLordoRiscaldatoEmpty); //basta che sia settato uno dei due per poter settare checkare il flag
		}

		//lo stesso ragionamento del FlagPotenzaUtileClimatInvernale si riproduce per FlagPotenzaUtileClimatEstiva
		boolean potenzaUtileClimaEstEmpty = StringUtils.isBlank(scheda1.getPotenzaUtileClimatEstiva());
		boolean volumeLordoRaffrescatoEmpty = StringUtils.isBlank(scheda1.getVolumeLordoRaffrescato());

		if (potenzaUtileClimaEstEmpty) {
			if (scheda1.getFlagPotenzaUtileClimatEstiva() || !volumeLordoRaffrescatoEmpty) {
				validationException.addField("appDatascheda1.potenzaUtileClimatEstiva",Messages.S168);
			}
		} else {
			checkNumero(scheda1.getPotenzaUtileClimatEstiva(), "appDatascheda1.potenzaUtileClimatEstiva", 6, 2, validationException, true);
		}
		if (volumeLordoRaffrescatoEmpty) {
			if (scheda1.getFlagPotenzaUtileClimatEstiva() || !potenzaUtileClimaEstEmpty) {
				validationException.addField("appDatascheda1.volumeLordoRaffrescato",Messages.S168_VOLUME_RAFFRESCATO);
			}
		} else {
			checkNumero(scheda1.getVolumeLordoRaffrescato(), "appDatascheda1.volumeLordoRaffrescato", 7, 2, validationException, true);
		}
		//automatismo: la checkbox viene selezionata se almeno uno dei due campi sono stati popolati
		if (!scheda1.getFlagPotenzaUtileClimatEstiva()) {
			scheda1.setFlagPotenzaUtileClimatEstiva(!potenzaUtileClimaEstEmpty || !volumeLordoRaffrescatoEmpty); //basta che sia settato uno dei due per poter settare checkare il flag
		}


		//Altro
		if (GenericUtil.isNullOrEmpty(scheda1.getPotenzaUtileAltro())){
			if (scheda1.getFlagPotenzaUtileAltro()) {
				validationException.addField("appDatascheda1.potenzaUtileAltro",Messages.S169);
			}
		} else {
			checkAsciiStringMaxLength(scheda1.getPotenzaUtileAltro(), 100, "appDatascheda1.potenzaUtileAltro", validationException);
			scheda1.setFlagPotenzaUtileAltro(true);
		}

		if (!scheda1.getFlagPotenzaUtileProduzioneACS() && !scheda1.getFlagPotenzaUtileClimatInvernale() && !scheda1.getFlagPotenzaUtileClimatEstiva() && !scheda1.getFlagPotenzaUtileAltro()) {
			ValidationManagerException validationException13 = new ValidationManagerException(new Message(Messages.S167));
			throw validationException13;
		}

		//1.4
		if (GenericUtil.isNullOrEmpty(scheda1.getTipologiaFluidoAltro())) {
			if (scheda1.getFlagTipologiaFluidoAltro()) {
				validationException.addField("appDatascheda1.tipologiaFluidoAltro",Messages.S169);
			}
		} else {
			checkAsciiStringMaxLength(scheda1.getTipologiaFluidoAltro(), 100, "appDatascheda1.tipologiaFluidoAltro", validationException);
			scheda1.setFlagTipologiaFluidoAltro(true);
		}

		if (!scheda1.getFlagTipologiaFluidoAria() && !scheda1.getFlagTipologiaFluidoAcqua() &&
				!scheda1.getFlagTipologiaFluidoAltro()) {
						ValidationManagerException validationException14 = new ValidationManagerException(new Message(Messages.S170));
						throw validationException14;
					}

		//1.5
		if (GenericUtil.isNullOrEmpty(scheda1.getAltroTipoGeneratori())) {
			if (scheda1.getFlagAltroTipoGeneratori()) {
				validationException.addField("appDatascheda1.altroTipoGeneratori",Messages.S169);
			}
		} else {
			checkAsciiStringMaxLength(scheda1.getAltroTipoGeneratori(), 100, "appDatascheda1.altroTipoGeneratori", validationException);
			scheda1.setFlagAltroTipoGeneratori(true);
		}

		if (GenericUtil.isNullOrEmpty(scheda1.getAltroTipologiaGeneratori())) {
			if (scheda1.getFlagAltroTipologiaGeneratori()) {
				validationException.addField("appDatascheda1.altroTipologiaGeneratori",Messages.S169);
			}
		} else {
			checkAsciiStringMaxLength(scheda1.getAltroTipologiaGeneratori(), 100, "appDatascheda1.altroTipologiaGeneratori", validationException);
			scheda1.setFlagAltroTipologiaGeneratori(true);
		}

		boolean superficieLordaEmpty = StringUtils.isBlank(scheda1.getTotaleSuperficieLorda());
		if (scheda1.getFlagPannelliSolari() != null && scheda1.getFlagPannelliSolari()) {
			if (superficieLordaEmpty) {
				validationException.addFieldRequired("appDatascheda1.totaleSuperficieLorda");
			}
		} else {
			scheda1.setFlagPannelliSolari(!superficieLordaEmpty);
		}

		checkNumero(scheda1.getTotaleSuperficieLorda(), "appDatascheda1.totaleSuperficieLorda", 4, 2, validationException, true);
		checkNumero(scheda1.getPotenzaUtileAltraIntegrazione(), "appDatascheda1.potenzaUtileAltraIntegrazione", 5, 2, validationException, true);
		checkAsciiStringMaxLength(scheda1.getAltraIntegrazione(), 100, "appDatascheda1.altraIntegrazione", validationException);

		if (!scheda1.getFlagGeneratoreCombustione() && !scheda1.getFlagPompaDiCalore() && !scheda1.getFlagGeneratoreMacchinaFrigorifera() &&
				!scheda1.getFlagGeneratoreTeleriscaldamento() && !scheda1.getFlagGeneratoreTeleraffrescamento() &&
				!scheda1.getFlagCogenerazioneTrigenerazione() && !scheda1.getFlagAltroTipoGeneratori()) {
			ValidationManagerException validationException15 = new ValidationManagerException(new Message(Messages.S171));
			throw validationException15;
		}

		isDataFutura(scheda1.getDataIntervento(), "appDatascheda1.dataIntervento");

		if(!validationException.getFieldList().isEmpty()){
			throw validationException;
		}

	}


	public void validazioneFormaleLibrettoScheda1_extra(ArrayList<DatiExtra> listaDatiExtra, ExecResults result) throws ValidationManagerException {
		if (listaDatiExtra != null) {
			for (DatiExtra dato : listaDatiExtra) {
				preparaToValidate(dato);
			}
		}

		ValidationManagerException validationException = new ValidationManagerException();
		int riga = 0;
		for(DatiExtra temp : listaDatiExtra){
			riga++;

			// Se e' stato valorizzato un campo tra Sezione, Foglio, Particella e Subalterno, allora ci deve essere anche Foglio e Particella
			if ((GenericUtil.isNotNullOrEmpty(temp.getSezione()) ||
					GenericUtil.isNotNullOrEmpty(temp.getFoglio()) ||
					GenericUtil.isNotNullOrEmpty(temp.getParticella()) ||
					GenericUtil.isNotNullOrEmpty(temp.getSubalterno())) &&
					(GenericUtil.isNullOrEmpty(temp.getFoglio()) ||
							GenericUtil.isNullOrEmpty(temp.getParticella())))
			{
				result.getGlobalErrors().add("Nella riga " + riga + " nel caso di valorizzazione catastale, sono obbligatori Foglio e Particella");

			}

			if (GenericUtil.isNotNullOrEmpty(temp.getSezione())) {
				try
				{
					temp.setSezione(checkAlphanumericStringMaxLenght(temp.getSezione(), 20, null));

				}
				catch(ValidationManagerException e){

					result.getGlobalErrors().add(creaMsgTabellaEdit(riga,"Sezione", Messages.ERROR_CAMPO_NON_CORRETTO));
				}
			}

			if (GenericUtil.isNotNullOrEmpty(temp.getFoglio())) {
				try
				{
					temp.setFoglio(checkAlphanumericStringMaxLenght(temp.getFoglio(), 20, null));
				}
				catch(ValidationManagerException e){
					result.getGlobalErrors().add(creaMsgTabellaEdit(riga,"Foglio", Messages.ERROR_CAMPO_NON_CORRETTO));
				}
			}

			if (GenericUtil.isNotNullOrEmpty(temp.getParticella())) {
				try
				{
					temp.setParticella(checkAlphanumericStringMaxLenght(temp.getParticella(), 20, null));
				}
				catch(ValidationManagerException e){
					result.getGlobalErrors().add(creaMsgTabellaEdit(riga,"Particella", Messages.ERROR_CAMPO_NON_CORRETTO));
				}
			}

			if (GenericUtil.isNotNullOrEmpty(temp.getSubalterno())) {
				try
				{
					temp.setSubalterno(checkAlphanumericStringMaxLenght(temp.getSubalterno(), 20, null));
				}
				catch(ValidationManagerException e){
					result.getGlobalErrors().add(creaMsgTabellaEdit(riga,"Subalterno", Messages.ERROR_CAMPO_NON_CORRETTO));
				}
			}

			if (GenericUtil.isNotNullOrEmpty(temp.getPod())) {

				try
				{
					log.debug("PRIMA DI checkPOD: "+temp.getPod());
					temp.setPod(checkPOD(temp.getPod(), null));
					log.debug("DOPO DI checkPOD");
				}
				catch(ValidationManagerException e){
					result.getGlobalErrors().add(creaMsgTabellaEdit(riga,"POD", Messages.ERROR_CAMPO_NON_CORRETTO));
				}
			}

			if (GenericUtil.isNotNullOrEmpty(temp.getPdr()))
			{
				try
				{
					log.debug("PRIMA DI checkPDR: "+temp.getPdr());
					temp.setPdr(checkPDR(temp.getPdr(), null));
					log.debug("DOPO DI checkPDR");
				}
				catch(ValidationManagerException e){
					result.getGlobalErrors().add(creaMsgTabellaEdit(riga,"PDR", Messages.ERROR_CAMPO_NON_CORRETTO));
				}
			}

		}

		if(!result.getGlobalErrors().isEmpty()){
			throw validationException;
		}
		//}

	}


	public void validazioneFormaleLibrettoScheda4_6Dett(ComponenteCG componente, ArrayList<ComponenteCG> compList, boolean isDataDismisObb, EditabilitaComp4Enum editabilita) throws ValidationManagerException {
		preparaToValidate(componente);

		if (compList != null) {
			for (ComponenteCG comp : compList) {
				preparaToValidate(comp);
			}
		}


		ValidationManagerException ex = new ValidationManagerException();

		final String APP_DATA_NAME = "appDatacomponenteCG.";

		boolean checkDateOrder = true;

		/*
		 * NB: SE editabilita = COMP_MODIFICABILE la validazione e' su tutto
		 * NB: SE editabilita = COMP_NON_MODIFICABILE la validazione non viene invocata
		 * NB: SE editabilita = COMP_REE_NON_MODIFICABILE la validazione avviene solo sul campo note e la data di dismissione
		 * NB: SE editabilita = COMP_REE_MODIFICABILE la validazione avviene solo sui campi non chiave
		 */
		EnumSet< EditabilitaComp4Enum> listaEnumEditabili = EnumSet.of(EditabilitaComp4Enum.COMP_MODIFICABILE, EditabilitaComp4Enum.COMP_REE_MODIFICABILE, EditabilitaComp4Enum.COMP_REE_NON_MODIFICABILE);

		if (listaEnumEditabili.contains(editabilita)) {

			if (EditabilitaComp4Enum.COMP_MODIFICABILE.equals(editabilita)) {
				if (GenericUtil.isNullOrEmpty(componente.getDataInstallazione())) {
					ex.addFieldRequired(APP_DATA_NAME + "dataInstallazione");
					checkDateOrder = false;
				} else {
					isDataFutura(componente.getDataInstallazione(), APP_DATA_NAME + "dataInstallazione");
					check1900(componente.getDataInstallazione(), APP_DATA_NAME + "dataInstallazione");
				}
			}

			if (!EditabilitaComp4Enum.COMP_REE_NON_MODIFICABILE.equals(editabilita)) {

				if (GenericUtil.isNullOrEmpty(componente.getFabbricante())) {
					ex.addFieldRequired(APP_DATA_NAME + "fabbricante");

				}

				if (GenericUtil.isNullOrEmpty(componente.getAlimentazione())) {
					ex.addFieldRequired(APP_DATA_NAME + "alimentazione");

				}

				if (GenericUtil.isNullOrEmpty(componente.getModello())) {
					ex.addFieldRequired(APP_DATA_NAME + "modello");
				} else {
					checkAsciiStringMaxLength(componente.getModello(), 33, APP_DATA_NAME + "modello", ex);
				}

				if (GenericUtil.isNullOrEmpty(componente.getMatricola())) {
					ex.addFieldRequired(APP_DATA_NAME + "matricola");
				} else {
					checkAsciiStringMaxLength(componente.getMatricola(), 30, APP_DATA_NAME + "matricola", ex);
				}

				if (GenericUtil.isNullOrEmpty(componente.getTipologia())) {
					ex.addFieldRequired(APP_DATA_NAME + "tipologia");
				} else {
					checkAsciiStringMaxLength(componente.getTipologia(), 33, APP_DATA_NAME + "tipologia", ex);
				}

				if (GenericUtil.isNullOrEmpty(componente.getPotenzaTermicaKw())) {
					ex.addFieldRequired(APP_DATA_NAME + "potenzaTermicaKw");
				} else {
					checkNumero(componente.getPotenzaTermicaKw(), APP_DATA_NAME + "potenzaTermicaKw", 6, 2, ex, true);
				}

				if (GenericUtil.isNullOrEmpty(componente.getPotenzaElettricaKw())) {
					ex.addFieldRequired(APP_DATA_NAME + "potenzaElettricaKw");
				} else {
					checkNumero(componente.getPotenzaElettricaKw(), APP_DATA_NAME + "potenzaElettricaKw", 6, 2, ex, true);
				}

				if (GenericUtil.isNullOrEmpty(componente.getTempoManutenzione())) {
					ex.addFieldRequired(APP_DATA_NAME + "tempoManutenzione");
				} else {
					checkNumero(componente.getTempoManutenzione(), APP_DATA_NAME + "tempoManutenzione", 1, 1, ex, true);
				}

				//controlli su valori max/min
				checkNumero(componente.getTemperaturaFumiMonteMax(), APP_DATA_NAME + "temperaturaFumiMonteMax", null, 2, 4, ex, true);
				checkNumero(componente.getTemperaturaFumiMonteMin(), APP_DATA_NAME + "temperaturaFumiMonteMin", null, 2, 4, ex, true);
				checkNumero(componente.getTemperaturaFumiValleMax(), APP_DATA_NAME + "temperaturaFumiValleMax", null, 2, 4, ex, true);
				checkNumero(componente.getTemperaturaFumiValleMin(), APP_DATA_NAME + "temperaturaFumiValleMin", null, 2, 4, ex, true);
				checkNumero(componente.getTemperaturaH2OIngressoMax(), APP_DATA_NAME + "temperaturaH2OIngressoMax", null, 2, 4, ex, true);
				checkNumero(componente.getTemperaturaH2OIngressoMin(), APP_DATA_NAME + "temperaturaH2OIngressoMin", null, 2, 4, ex, true);
				checkNumero(componente.getTemperaturaH2OMotoreMax(), APP_DATA_NAME + "temperaturaH2OMotoreMax", null, 2, 4, ex, true);
				checkNumero(componente.getTemperaturaH2OMotoreMin(), APP_DATA_NAME + "temperaturaH2OMotoreMin", null, 2, 4, ex, true);
				checkNumero(componente.getTemperaturaH2OUscitaMax(), APP_DATA_NAME + "temperaturaH2OUscitaMax", null, 2, 4, ex, true);
				checkNumero(componente.getTemperaturaH2OUscitaMin(), APP_DATA_NAME + "temperaturaH2OUscitaMin", null, 2, 4, ex, true);
				checkNumero(componente.getCoMax(), APP_DATA_NAME + "coMax", null, 2, 4, ex, true);
				checkNumero(componente.getCoMin(), APP_DATA_NAME + "coMin", null, 2, 4, ex, true);
			}

			checkAsciiStringMaxLength(componente.getNote(), 1000, APP_DATA_NAME + "note", ex);

			if (GenericUtil.isNullOrEmpty(componente.getDataDismissione())) {
				checkDateOrder = false;
				if (isDataDismisObb) {
					ex.addFieldRequired(APP_DATA_NAME + "dataDismissione");
				}
			} else {
				isDataFutura(componente.getDataDismissione(), APP_DATA_NAME + "dataDismissione");
				checkDate(componente.getDataDismissione(), APP_DATA_NAME + "dataDismissione", ex);

			}

			if (compList != null && compList.size() > 0)
			{
				ComponenteCG componenteSost = compList.get(0);

				if (!DateUtil.checkDateOrder(componenteSost.getDataDismissione(), componente.getDataInstallazione(), false))
				{
					throw new ValidationManagerException(new Message(Messages.ERROR_DATA_INSTALL_DISMISS_DISM));
				}
			}

			if (checkDateOrder && !DateUtil.checkDateOrder(componente.getDataInstallazione(), componente.getDataDismissione(), true)) {
				throw new ValidationManagerException(new Message(Messages.ERROR_DATA_INSTALL_DISMISS));
			}

			if(!ex.getFieldList().isEmpty()){
				throw ex;
			}

		}

	}

	public void validazioneFormaleLibrettoScheda4_5Dett(ComponenteSC componente, ArrayList<ComponenteSC> compList, boolean isDataDismisObb, EditabilitaComp4Enum editabilita) throws ValidationManagerException {
		preparaToValidate(componente);

		if (compList != null) {
			for (ComponenteSC comp : compList) {
				preparaToValidate(comp);
			}
		}

		ValidationManagerException ex = new ValidationManagerException();

		final String APP_DATA_NAME = "appDatacomponenteSC.";

		boolean checkDateOrder = true;

		/*
		 * NB: SE editabilita = COMP_MODIFICABILE la validazione e' su tutto
		 * NB: SE editabilita = COMP_NON_MODIFICABILE la validazione non viene invocata
		 * NB: SE editabilita = COMP_REE_NON_MODIFICABILE la validazione avviene solo sul campo note e la data di dismissione
		 * NB: SE editabilita = COMP_REE_MODIFICABILE la validazione avviene solo sui campi non chiave
		 */
		EnumSet< EditabilitaComp4Enum> listaEnumEditabili = EnumSet.of(EditabilitaComp4Enum.COMP_MODIFICABILE, EditabilitaComp4Enum.COMP_REE_MODIFICABILE, EditabilitaComp4Enum.COMP_REE_NON_MODIFICABILE);

		if (listaEnumEditabili.contains(editabilita)) {

			if (EditabilitaComp4Enum.COMP_MODIFICABILE.equals(editabilita)) {

				if (GenericUtil.isNullOrEmpty(componente.getDataInstallazione())) {
					ex.addFieldRequired(APP_DATA_NAME + "dataInstallazione");
					checkDateOrder = false;
				} else {
					isDataFutura(componente.getDataInstallazione(), APP_DATA_NAME + "dataInstallazione");
					check1900(componente.getDataInstallazione(), APP_DATA_NAME + "dataInstallazione");
				}
			}

			if (!EditabilitaComp4Enum.COMP_REE_NON_MODIFICABILE.equals(editabilita)) {

				if (GenericUtil.isNullOrEmpty(componente.getFabbricante())) {
					ex.addFieldRequired(APP_DATA_NAME + "fabbricante");

				}

				if (GenericUtil.isNullOrEmpty(componente.getModello())) {
					ex.addFieldRequired(APP_DATA_NAME + "modello");
				} else {
					checkAsciiStringMaxLength(componente.getModello(), 33, APP_DATA_NAME + "modello", ex);
				}

				if (GenericUtil.isNullOrEmpty(componente.getMatricola())) {
					ex.addFieldRequired(APP_DATA_NAME + "matricola");
				} else {
					checkAsciiStringMaxLength(componente.getMatricola(), 30, APP_DATA_NAME + "matricola", ex);
				}

				if (GenericUtil.isNullOrEmpty(componente.getPotenzaTermicaKw())) {
					ex.addFieldRequired(APP_DATA_NAME + "potenzaTermicaKw");
				} else {
					checkNumero(componente.getPotenzaTermicaKw(), APP_DATA_NAME + "potenzaTermicaKw", 6, 2, ex, true);
				}

				if (GenericUtil.isNullOrEmpty(componente.getTempoManutenzione())) {
					ex.addFieldRequired(APP_DATA_NAME + "tempoManutenzione");
				} else {
					checkNumero(componente.getTempoManutenzione(), APP_DATA_NAME + "tempoManutenzione", 1, 1, ex, true);
				}
			}

			if (GenericUtil.isNullOrEmpty(componente.getDenominazioneProp())) {
				ex.addFieldRequired(APP_DATA_NAME + "denominazioneProp");
			} else {
				checkAsciiStringMaxLength(componente.getMatricola(), 50, APP_DATA_NAME + "denominazioneProp", ex);
			}

			if (!GenericUtil.isNullOrEmpty(componente.getCfProp())) {
				checkCodiceFiscalePartitaIva(componente.getCfProp(), APP_DATA_NAME + "cfProp", ex);
			}


			checkAsciiStringMaxLength(componente.getNote(), 1000, APP_DATA_NAME + "note", ex);

			if (GenericUtil.isNullOrEmpty(componente.getDataDismissione())) {
				checkDateOrder = false;
				if (isDataDismisObb) {
					ex.addFieldRequired(APP_DATA_NAME + "dataDismissione");
				}
			} else {
				isDataFutura(componente.getDataDismissione(), APP_DATA_NAME + "dataDismissione");
				checkDate(componente.getDataDismissione(), APP_DATA_NAME + "dataDismissione", ex);

			}

			if (compList != null && compList.size() > 0)
			{
				ComponenteSC componenteSost = compList.get(0);

				if (!DateUtil.checkDateOrder(componenteSost.getDataDismissione(), componente.getDataInstallazione(), false))
				{
					throw new ValidationManagerException(new Message(Messages.ERROR_DATA_INSTALL_DISMISS_DISM));
				}
			}

			if (checkDateOrder && !DateUtil.checkDateOrder(componente.getDataInstallazione(), componente.getDataDismissione(), true)) {
				throw new ValidationManagerException(new Message(Messages.ERROR_DATA_INSTALL_DISMISS));
			}

			if(!ex.getFieldList().isEmpty()){
				throw ex;
			}

		}

	}

	public void validazioneFormaleLibrettoScheda4_4Dett(ComponenteGF componente, ArrayList<ComponenteGF> compList, boolean isDataDismisObb, EditabilitaComp4Enum editabilita) throws ValidationManagerException, SigitDDettaglioGfDaoException {
		preparaToValidate(componente);

		if (compList != null) {
			for (ComponenteGF comp : compList) {
				preparaToValidate(comp);
			}
		}

		ValidationManagerException ex = new ValidationManagerException();

		final String APP_DATA_NAME = "appDatacomponenteGF.";

		boolean checkDateOrder = true;

		/*
		 * NB: SE editabilita = COMP_MODIFICABILE la validazione e' su tutto
		 * NB: SE editabilita = COMP_NON_MODIFICABILE la validazione non viene invocata
		 * NB: SE editabilita = COMP_REE_NON_MODIFICABILE la validazione avviene solo sul campo note e la data di dismissione
		 * NB: SE editabilita = COMP_REE_MODIFICABILE la validazione avviene solo sui campi non chiave
		 */
		EnumSet< EditabilitaComp4Enum> listaEnumEditabili = EnumSet.of(EditabilitaComp4Enum.COMP_MODIFICABILE, EditabilitaComp4Enum.COMP_REE_MODIFICABILE, EditabilitaComp4Enum.COMP_REE_NON_MODIFICABILE);

		if (listaEnumEditabili.contains(editabilita)) {

			if (EditabilitaComp4Enum.COMP_MODIFICABILE.equals(editabilita)) {

				//unico caso in cui la data installazione e' modificabile
				if (GenericUtil.isNullOrEmpty(componente.getDataInstallazione())) {
					ex.addFieldRequired(APP_DATA_NAME + "dataInstallazione");
					checkDateOrder = false;
				} else {
					isDataFutura(componente.getDataInstallazione(), APP_DATA_NAME + "dataInstallazione");
					check1900(componente.getDataInstallazione(), APP_DATA_NAME + "dataInstallazione");
				}

			}

			if (!EditabilitaComp4Enum.COMP_REE_NON_MODIFICABILE.equals(editabilita)) {

				//validazione attuata solo in caso di componente MODIFICABILE o REE_MODIFICABILE
				if (GenericUtil.isNullOrEmpty(componente.getFabbricante())) {
					ex.addFieldRequired(APP_DATA_NAME + "fabbricante");
				}

				if (GenericUtil.isNullOrEmpty(componente.getModello())) {
					ex.addFieldRequired(APP_DATA_NAME + "modello");
				} else {
					checkAsciiStringMaxLength(componente.getModello(), 33, APP_DATA_NAME + "modello", ex);
				}

				if (GenericUtil.isNullOrEmpty(componente.getMatricola())) {
					ex.addFieldRequired(APP_DATA_NAME + "matricola");
				} else {
					checkAsciiStringMaxLength(componente.getMatricola(), 30, APP_DATA_NAME + "matricola", ex);
				}

				if (GenericUtil.isNullOrEmpty(componente.getFluidoFrigorigeno())) {
					ex.addFieldRequired(APP_DATA_NAME + "fluidoFrigorigeno");
				} else {
					checkAsciiStringMaxLength(componente.getFluidoFrigorigeno(), 30, APP_DATA_NAME + "fluidoFrigorigeno", ex);
				}

//				if (GenericUtil.isNullOrEmpty(componente.getSorgenteLatoEsterno())) {
//					ex.addFieldRequired(APP_DATA_NAME + "sorgenteLatoEsterno");
//				}

				if (GenericUtil.isNullOrEmpty(componente.getFluidoLatoUtenze())) {
					ex.addFieldRequired(APP_DATA_NAME + "fluidoLatoUtenze");
				}

				boolean combustibileObbl = false;
				if (GenericUtil.isNullOrEmpty(componente.getTipologia())) {
					ex.addFieldRequired(APP_DATA_NAME + "tipologia");
				} else {
					List<SigitDDettaglioGfDto> listaDettagli = getDbMgr().getSigitDDettaglioGfDao().findAll();
					if (listaDettagli != null && !listaDettagli.isEmpty()) {
						for (SigitDDettaglioGfDto dettaglio : listaDettagli) {
							if(dettaglio.getIdDettaglioGf().equals(ConvertUtil.convertToBigDecimal(componente.getTipologia()))
									&& dettaglio.getDesDettaglioGf().equals("Ad assorbimento a fiamma diretta con combustibile"))
							{
								combustibileObbl = true;
								//CONDIZIONE NECESSARIA PER RENDERE IL COMBUSTIBILE OBBLIGATORIO
								break;
							}
						}
					}
				}

				if (combustibileObbl) {
					if (GenericUtil.isNullOrEmpty(componente.getCombustibile())) {
						ex.addFieldRequired(APP_DATA_NAME + "combustibile");
					}
				} else {
					//segnalazione libretto 132: quando la tipologia non e' "Ad assorbimento a fiamma diretta con combustibe" il dato non viene persistito
					componente.setCombustibile(null);
				}

				if (GenericUtil.isNullOrEmpty(componente.getNumCircuiti())) {
					ex.addFieldRequired(APP_DATA_NAME + "numCircuiti");
				} else {
					checkNumeroIntero(componente.getNumCircuiti(), APP_DATA_NAME + "numCircuiti", 3);
				}

				if (GenericUtil.isNullOrEmpty(componente.getTempoManutenzione())) {
					ex.addFieldRequired(APP_DATA_NAME + "tempoManutenzione");
				} else {
					checkNumero(componente.getTempoManutenzione(), APP_DATA_NAME + "tempoManutenzione", 1, 1, ex, true);
				}

				if (GenericUtil.isNullOrEmpty(componente.getFonteEnergiaSfruttata())) {
					ex.addFieldRequired(APP_DATA_NAME + "fonteEnergiaSfruttata");
				}

			}


			if (GenericUtil.isNullOrEmpty(componente.getRaffPotenzaKw())) {
				ex.addFieldRequired(APP_DATA_NAME + "raffPotenzaKw");
			} else {
				checkNumero(componente.getRaffPotenzaKw(), APP_DATA_NAME + "raffPotenzaKw", 6, 2, ex, true);
			}

			checkAsciiStringMaxLength(componente.getNote(), 1000, APP_DATA_NAME + "note", ex);
			checkNumero(componente.getEer(), APP_DATA_NAME + "eer", 5, 4, ex, true);
			checkNumero(componente.getRaffPotenzaAssorbita(), APP_DATA_NAME + "raffPotenzaAssorbita", 6, 2, ex, true);
			checkNumero(componente.getCop(), APP_DATA_NAME + "cop", 5, 4, ex, true);
			checkNumero(componente.getRiscPotenzaAssorbita(), APP_DATA_NAME + "riscPotenzaAssorbita", 6, 2, ex, true);
			checkNumero(componente.getRiscPotenzaKw(), APP_DATA_NAME + "riscPotenzaKw", 6, 2, ex, true);

			if (GenericUtil.isNullOrEmpty(componente.getDataDismissione())) {
				checkDateOrder = false;
				if (isDataDismisObb) {
					ex.addFieldRequired(APP_DATA_NAME + "dataDismissione");
				}
			} else {
				isDataFutura(componente.getDataDismissione(), APP_DATA_NAME + "dataDismissione");
				checkDate(componente.getDataDismissione(), APP_DATA_NAME + "dataDismissione", ex);

			}

			if (compList != null && compList.size() > 0)
			{
				ComponenteGF componenteSost = compList.get(0);

				if (!DateUtil.checkDateOrder(componenteSost.getDataDismissione(), componente.getDataInstallazione(), false))
				{
					throw new ValidationManagerException(new Message(Messages.ERROR_DATA_INSTALL_DISMISS_DISM));
				}
			}

			if (checkDateOrder && !DateUtil.checkDateOrder(componente.getDataInstallazione(), componente.getDataDismissione(), true)) {
				throw new ValidationManagerException(new Message(Messages.ERROR_DATA_INSTALL_DISMISS));
			}

			if(!ex.getFieldList().isEmpty()){
				throw ex;
			}

		}

	}


	public void validazioneFormaleLibrettoScheda4_1Dett(ComponenteGT componente, ArrayList<ComponenteGT> compList, boolean isDataDismisObb, EditabilitaComp4Enum editabilita) throws ValidationManagerException, SigitDDettaglioGtDaoException {
		preparaToValidate(componente);

		if (compList != null) {
			for (ComponenteGT comp : compList) {
				preparaToValidate(comp);
			}
		}


		ValidationManagerException ex = new ValidationManagerException();

		final String APP_DATA_NAME = "appDatacomponenteGT.";

		boolean checkDateOrder = true;

		/*
		 * NB: SE editabilita = COMP_MODIFICABILE la validazione e' su tutto
		 * NB: SE editabilita = COMP_NON_MODIFICABILE la validazione non viene invocata
		 * NB: SE editabilita = COMP_REE_NON_MODIFICABILE la validazione avviene solo sul campo note e la data di dismissione
		 * NB: SE editabilita = COMP_REE_MODIFICABILE la validazione avviene solo sui campi non chiave
		 */
		EnumSet< EditabilitaComp4Enum> listaEnumEditabili = EnumSet.of(EditabilitaComp4Enum.COMP_MODIFICABILE, EditabilitaComp4Enum.COMP_REE_MODIFICABILE, EditabilitaComp4Enum.COMP_REE_NON_MODIFICABILE);

		if (listaEnumEditabili.contains(editabilita)) {

			//i campi editabili solo in caso di COMP_MODIFICABILE (i campi chiave)
			if (EditabilitaComp4Enum.COMP_MODIFICABILE.equals(editabilita)) {
				if (GenericUtil.isNullOrEmpty(componente.getDataInstallazione())) {
					ex.addFieldRequired(APP_DATA_NAME + "dataInstallazione");
					checkDateOrder = false;
				} else {
					isDataFutura(componente.getDataInstallazione(), APP_DATA_NAME + "dataInstallazione");
					check1900(componente.getDataInstallazione(), APP_DATA_NAME + "dataInstallazione");
				}
			}

			//vengono validati i campi editabili in caso di ree modificabile e in caso di editabilita' totale
			if (!EditabilitaComp4Enum.COMP_REE_NON_MODIFICABILE.equals(editabilita) ) {

				if (GenericUtil.isNullOrEmpty(componente.getFabbricante())) {
					ex.addFieldRequired(APP_DATA_NAME + "fabbricante");

				}

				if (GenericUtil.isNullOrEmpty(componente.getCombustibile())) {
					ex.addFieldRequired(APP_DATA_NAME + "combustibile");
				}

				if (GenericUtil.isNullOrEmpty(componente.getFluido())) {
					ex.addFieldRequired(APP_DATA_NAME + "fluido");
				}

				if (GenericUtil.isNullOrEmpty(componente.getModello())) {
					ex.addFieldRequired(APP_DATA_NAME + "modello");
				} else {
					checkAsciiStringMaxLength(componente.getModello(), 33, APP_DATA_NAME + "modello", ex);
				}

				if (GenericUtil.isNullOrEmpty(componente.getMatricola())) {
					ex.addFieldRequired(APP_DATA_NAME + "matricola");
				} else {
					checkAsciiStringMaxLength(componente.getMatricola(), 30, APP_DATA_NAME + "matricola", ex);
				}

				boolean nModuliObbl = false;
				if (GenericUtil.isNullOrEmpty(componente.getTipologia())) {
					ex.addFieldRequired(APP_DATA_NAME + "tipologia");
				} else {
					List<SigitDDettaglioGtDto> listaDettagli = getDbMgr().getSigitDDettaglioGtDao().findAll();
					if (listaDettagli != null && !listaDettagli.isEmpty()) {
						for (SigitDDettaglioGtDto dettaglio : listaDettagli) {
							if(dettaglio.getIdDettaglioGt().equals(ConvertUtil.convertToBigDecimal(componente.getTipologia()))
									&& dettaglio.getDesDettaglioGt().equals("Gruppo termico modulare"))
							{
								nModuliObbl = true;
								//CONDIZIONE NECESSARIA PER RENDERE IL NUMERO MODULI OBBLIGATORIO
								break;
							}
						}
					}
				}

				if (GenericUtil.isNullOrEmpty(componente.getNumModuli())) {
					if (nModuliObbl) {
						ex.addFieldRequired(APP_DATA_NAME + "numModuli");
					}
				} else {
					if (nModuliObbl) {
						checkNumeroIntero(componente.getNumModuli(), APP_DATA_NAME + "numModuli", 3);
						//se settato e con gruppo termico modulare il valore di n Moduli deve essere > 0
						if (Integer.valueOf(componente.getNumModuli()).intValue() <= 0) {
							ex.addField(APP_DATA_NAME + "numModuli", new Message(Messages.ERROR_VALORE_MINIMO, "0").getText());
						}
					} else {
						//viene sovrascritto il valore con null
						componente.setNumModuli(null);
					}
				}

				if (GenericUtil.isNullOrEmpty(componente.getPotenzaTermicaKw())) {
					ex.addFieldRequired(APP_DATA_NAME + "potenzaTermicaKw");
				} else {
					checkNumero(componente.getPotenzaTermicaKw(), APP_DATA_NAME + "potenzaTermicaKw", 6, 2, ex, true);
				}

				if (GenericUtil.isNullOrEmpty(componente.getRendimentoPerc())) {
					ex.addFieldRequired(APP_DATA_NAME + "rendimentoPerc");
				} else if (checkNumero(componente.getRendimentoPerc(), APP_DATA_NAME + "rendimentoPerc", 3, 2, ex, true) && Double.valueOf(componente.getRendimentoPerc().replace(',', '.')).doubleValue() > 120) {
					ex.addField(APP_DATA_NAME + "rendimentoPerc", new Message(Messages.ERROR_VALORE_MASSIMO, "120").getText());
				}

				if (GenericUtil.isNullOrEmpty(componente.getTempoManutenzione())) {
					ex.addFieldRequired(APP_DATA_NAME + "tempoManutenzione");
				} else {
					checkNumero(componente.getTempoManutenzione(), APP_DATA_NAME + "tempoManutenzione", 1, 1, ex, true);
				}

				if (GenericUtil.isNullOrEmpty(componente.getCannaFumaria()) /* || (!GenericUtil.isNullOrEmpty(componente.getCannaFumaria()) && dbMgr.getSigitDTipoCannaFumariaDao().findByPrimaryKey(componente.getCannaFumaria()))*/ ) {
					ex.addFieldRequired(APP_DATA_NAME + "cannaFumaria");
				}

				checkNumero(componente.getOreOperative(), APP_DATA_NAME + "oreOperative", 8, 2, ex, true);

			}

			//il campo data dismissione viene validato sempre purche' ci sia editabilita'
			if (GenericUtil.isNullOrEmpty(componente.getDataDismissione())) {
				checkDateOrder = false;
				if (isDataDismisObb) {
					ex.addFieldRequired(APP_DATA_NAME + "dataDismissione");
				}
			} else {
				isDataFutura(componente.getDataDismissione(), APP_DATA_NAME + "dataDismissione");
				checkDate(componente.getDataDismissione(), APP_DATA_NAME + "dataDismissione", ex);
			}

			if (compList != null && compList.size() > 0)
			{
				ComponenteGT componenteSost = compList.get(0);

				if (!DateUtil.checkDateOrder(componenteSost.getDataDismissione(), componente.getDataInstallazione(), false))
				{
					throw new ValidationManagerException(new Message(Messages.ERROR_DATA_INSTALL_DISMISS_DISM));
				}
			}

			if (checkDateOrder && !DateUtil.checkDateOrder(componente.getDataInstallazione(), componente.getDataDismissione(), true)) {
				throw new ValidationManagerException(new Message(Messages.ERROR_DATA_INSTALL_DISMISS));
			}

			//il campo note viene validato sempre purche' ci sia editabilita'
			checkAsciiStringMaxLength(componente.getNote(), 1000, APP_DATA_NAME + "note", ex);

			if(!ex.getFieldList().isEmpty()){
				throw ex;
			}
		}


	}


	public void validazioneFormaleLibrettoScheda4_2_4_3Dett(ComponenteBRRC componente, ArrayList<ComponenteBRRC> compList, boolean isDataDismisObb, String tipoComponente, ExecResults result) throws ValidationManagerException {
		preparaToValidate(componente);

		if (compList != null) {
			for (ComponenteBRRC comp : compList) {
				preparaToValidate(comp);
			}
		}
		ValidationManagerException ex = new ValidationManagerException();

		final String APP_DATA_NAME = "appDatacomponenteBRRC.";

		boolean checkDateOrder = true;

		if (GenericUtil.isNullOrEmpty(componente.getDataInstallazione())) {
			ex.addFieldRequired(APP_DATA_NAME + "dataInstallazione");
			checkDateOrder = false;
		} else {
			isDataFutura(componente.getDataInstallazione(), APP_DATA_NAME + "dataInstallazione");
			check1900(componente.getDataInstallazione(), APP_DATA_NAME + "dataInstallazione");
		}

		if (GenericUtil.isNullOrEmpty(componente.getFabbricante())) {
			ex.addFieldRequired(APP_DATA_NAME + "fabbricante");

		}

		if (GenericUtil.isNullOrEmpty(componente.getDataDismissione())) {
			checkDateOrder = false;
			if (isDataDismisObb) {
				ex.addFieldRequired(APP_DATA_NAME + "dataDismissione");
			}
		} else {
			isDataFutura(componente.getDataDismissione(), APP_DATA_NAME + "dataDismissione");
			checkDate(componente.getDataDismissione(), APP_DATA_NAME + "dataDismissione", ex);
		}

		if (compList != null && compList.size() > 0)
		{
			ComponenteBRRC componenteSost = compList.get(0);

			if (!DateUtil.checkDateOrder(componenteSost.getDataDismissione(), componente.getDataInstallazione(), false))
			{
				throw new ValidationManagerException(new Message(Messages.ERROR_DATA_INSTALL_DISMISS_DISM));
			}
		}

		if (checkDateOrder && !DateUtil.checkDateOrder(componente.getDataInstallazione(), componente.getDataDismissione(), true)) {
			throw new ValidationManagerException(new Message(Messages.ERROR_DATA_INSTALL_DISMISS));
		}

		if (GenericUtil.isNullOrEmpty(componente.getGtCollegato())) {
			ex.addFieldRequired(APP_DATA_NAME + "gtCollegato");
		}

		if (GenericUtil.isNullOrEmpty(componente.getModello())) {
			ex.addFieldRequired(APP_DATA_NAME + "modello");
		} else {
			checkAsciiStringMaxLength(componente.getModello(), 33, APP_DATA_NAME + "modello", ex);
		}

		if (GenericUtil.isNullOrEmpty(componente.getMatricola())) {
			ex.addFieldRequired(APP_DATA_NAME + "matricola");
		} else {
			checkAsciiStringMaxLength(componente.getMatricola(), 30, APP_DATA_NAME + "matricola", ex);
		}

		if (GenericUtil.isNullOrEmpty(componente.getPortataMax())) {
			ex.addFieldRequired(APP_DATA_NAME + "portataMax");
		} else {
			checkNumero(componente.getPortataMax(), APP_DATA_NAME + "portataMax", 6, 2, ex, true);
		}

		if (Constants.TIPO_COMPONENTE_BR.equals(tipoComponente)) {
			if (GenericUtil.isNullOrEmpty(componente.getTipologia())) {
				ex.addFieldRequired(APP_DATA_NAME + "tipologia");
			} else {
				checkAsciiStringMaxLength(componente.getTipologia(), 33, APP_DATA_NAME + "tipologia", ex);
			}

			if (GenericUtil.isNullOrEmpty(componente.getCombustibile())) {
				ex.addFieldRequired(APP_DATA_NAME + "combustibile");
			}

			if (GenericUtil.isNullOrEmpty(componente.getPortataMin())) {
				ex.addFieldRequired(APP_DATA_NAME + "portataMin");
			} else {
				checkNumero(componente.getPortataMin(), APP_DATA_NAME + "portataMin", 6, 2, ex, true);
			}
		}

		if(!ex.getFieldList().isEmpty()){
			throw ex;
		}

	}

	public void validazioneFormaleLibrettoScheda4_7Dett(ComponenteCS componente, ArrayList<ComponenteCS> compList, boolean isDataDismisObb) throws ValidationManagerException {
		preparaToValidate(componente);

		if (compList != null) {
			for (ComponenteCS comp : compList) {
				preparaToValidate(comp);
			}
		}

		ValidationManagerException ex = new ValidationManagerException();


		if (GenericUtil.isNullOrEmpty(componente.getDataInstallazione())) {
			ex.addFieldRequired(ConstantsField.GESTISCI_LIBRETTO4_7_DATA_INSTALLAZIONE);

		}

		if (GenericUtil.isNullOrEmpty(componente.getIdFabbricante())) {
			ex.addFieldRequired(ConstantsField.GESTISCI_LIBRETTO4_7_ID_FABBRICANTE);

		}

		if (GenericUtil.isNullOrEmpty(componente.getCollettori())) {
			ex.addFieldRequired(ConstantsField.GESTISCI_LIBRETTO4_7_COLLETTORI);
		} else {
			checkNumero(componente.getCollettori(), ConstantsField.GESTISCI_LIBRETTO4_7_COLLETTORI, 5, null, ex, true);
		}

		if (GenericUtil.isNullOrEmpty(componente.getSupTotAp())) {
			ex.addFieldRequired(ConstantsField.GESTISCI_LIBRETTO4_7_SUP_TOT_AP);
		} else {
			checkNumero(componente.getSupTotAp(), ConstantsField.GESTISCI_LIBRETTO4_7_SUP_TOT_AP, 5, 2, ex, true);
		}

		if (isDataDismisObb && GenericUtil.isNullOrEmpty(componente.getDataDismissione()))
		{
			ex.addFieldRequired(ConstantsField.GESTISCI_LIBRETTO4_7_DATA_DISMISSIONE);
		}

		if (ex.getFieldList().size() > 0)
		{
				//ex.setMsg(message);
				throw ex;
		}

		isDataFutura(componente.getDataInstallazione(), ConstantsField.GESTISCI_LIBRETTO4_7_DATA_INSTALLAZIONE);
		check1900(componente.getDataInstallazione(), ConstantsField.GESTISCI_LIBRETTO4_7_DATA_INSTALLAZIONE);

		checkDate(componente.getDataInstallazione(), ConstantsField.GESTISCI_LIBRETTO4_7_DATA_INSTALLAZIONE);


//		if (!DateUtil.checkDateOrder(impianto.getDataInizioResp(), responsabile.getDataInizioResp(), true))
//		{
//			throw new ValidationManagerException(new Message(Messages.ERROR_DATA_RESPONSABILE));
//		}

		if (GenericUtil.isNotNullOrEmpty(componente.getDataDismissione()))
		{

			isDataFutura(componente.getDataDismissione(), ConstantsField.GESTISCI_LIBRETTO4_7_DATA_DISMISSIONE);

			if (!DateUtil.checkDateOrder(componente.getDataInstallazione(), componente.getDataDismissione(), true))
			{
				throw new ValidationManagerException(new Message(Messages.ERROR_DATA_INSTALL_DISMISS));
			}


		}

		// Vevo verificare che la data installazione sia successiva all'ultima data dismissio dei sostituiti

		if (compList != null && compList.size() > 0)
		{
			ComponenteCS componenteSost = compList.get(0);

			if (!DateUtil.checkDateOrder(componenteSost.getDataDismissione(), componente.getDataInstallazione(), false))
			{
				throw new ValidationManagerException(new Message(Messages.ERROR_DATA_INSTALL_DISMISS_DISM));

			}

		}

	}

	public void validazioneFormaleLibrettoScheda4_8Dett(ComponenteAG componente, ArrayList<ComponenteAG> compList, boolean isDataDismisObb) throws ValidationManagerException {
		preparaToValidate(componente);

		if (compList != null) {
			for (ComponenteAG comp : compList) {
				preparaToValidate(comp);
			}
		}

		ValidationManagerException ex = new ValidationManagerException();


		if (GenericUtil.isNullOrEmpty(componente.getDataInstallazione())) {
			ex.addFieldRequired(ConstantsField.GESTISCI_LIBRETTO4_8_DATA_INSTALLAZIONE);

		}

		if (GenericUtil.isNullOrEmpty(componente.getIdFabbricante())) {
			ex.addFieldRequired(ConstantsField.GESTISCI_LIBRETTO4_8_ID_FABBRICANTE);

		}

		if (GenericUtil.isNullOrEmpty(componente.getModello())) {
			ex.addFieldRequired(ConstantsField.GESTISCI_LIBRETTO4_8_MODELLO);
		} else {
			checkAsciiStringMaxLength(componente.getModello(), 33, ConstantsField.GESTISCI_LIBRETTO4_8_MODELLO, ex);
		}

		if (GenericUtil.isNullOrEmpty(componente.getMatricola())) {
			ex.addFieldRequired(ConstantsField.GESTISCI_LIBRETTO4_8_MATRICOLA);
		} else {
			checkAsciiStringMaxLength(componente.getMatricola(), 30, ConstantsField.GESTISCI_LIBRETTO4_8_MATRICOLA, ex);
		}

		if (GenericUtil.isNullOrEmpty(componente.getTipologia())) {
			ex.addFieldRequired(ConstantsField.GESTISCI_LIBRETTO4_8_TIPOLOGIA);
		} else {
			checkAsciiStringMaxLength(componente.getTipologia(), 33, ConstantsField.GESTISCI_LIBRETTO4_8_TIPOLOGIA, ex);
		}

		if (GenericUtil.isNullOrEmpty(componente.getPotenza())) {
			ex.addFieldRequired(ConstantsField.GESTISCI_LIBRETTO4_8_POTENZA);
		} else {
			checkNumero(componente.getPotenza(), ConstantsField.GESTISCI_LIBRETTO4_8_POTENZA, 6,2, ex, true);
		}

		if (isDataDismisObb && GenericUtil.isNullOrEmpty(componente.getDataDismissione()))
		{
			ex.addFieldRequired(ConstantsField.GESTISCI_LIBRETTO4_8_DATA_DISMISSIONE);
		}

		if (ex.getFieldList().size() > 0)
		{
				//ex.setMsg(message);
				throw ex;
		}

		isDataFutura(componente.getDataInstallazione(), ConstantsField.GESTISCI_LIBRETTO4_8_DATA_INSTALLAZIONE);
		check1900(componente.getDataInstallazione(), ConstantsField.GESTISCI_LIBRETTO4_8_DATA_INSTALLAZIONE);
		checkDate(componente.getDataInstallazione(), ConstantsField.GESTISCI_LIBRETTO4_8_DATA_INSTALLAZIONE);


//		if (!DateUtil.checkDateOrder(impianto.getDataInizioResp(), responsabile.getDataInizioResp(), true))
//		{
//			throw new ValidationManagerException(new Message(Messages.ERROR_DATA_RESPONSABILE));
//		}

		if (GenericUtil.isNotNullOrEmpty(componente.getDataDismissione()))
		{

			isDataFutura(componente.getDataDismissione(), ConstantsField.GESTISCI_LIBRETTO4_8_DATA_DISMISSIONE);

			if (!DateUtil.checkDateOrder(componente.getDataInstallazione(), componente.getDataDismissione(), true))
			{
				throw new ValidationManagerException(new Message(Messages.ERROR_DATA_INSTALL_DISMISS));
			}


		}


		// Vevo verificare che la data installazione sia successiva all'ultima data dismissio dei sostituiti

		if (compList != null && compList.size() > 0)
		{
			ComponenteAG componenteSost = compList.get(0);

			if (!DateUtil.checkDateOrder(componenteSost.getDataDismissione(), componente.getDataInstallazione(), false))
			{
				throw new ValidationManagerException(new Message(Messages.ERROR_DATA_INSTALL_DISMISS_DISM));

			}

		}

	}

	public void validazioneFormaleLibrettoScheda5_1SRDett(ComponenteSR componente, ArrayList<ComponenteSR> compList, boolean isDataDismisObb) throws ValidationManagerException {
		preparaToValidate(componente);

		if (compList != null) {
			for (ComponenteSR comp : compList) {
				preparaToValidate(comp);
			}
		}
		ValidationManagerException ex = new ValidationManagerException();


		if (GenericUtil.isNullOrEmpty(componente.getDataInstallazione())) {
			ex.addFieldRequired(ConstantsField.GESTISCI_LIBRETTO5_1SR_DATA_INSTALLAZIONE);

		}

		if (GenericUtil.isNullOrEmpty(componente.getIdFabbricante())) {
			ex.addFieldRequired(ConstantsField.GESTISCI_LIBRETTO5_1SR_ID_FABBRICANTE);

		}

		if (GenericUtil.isNullOrEmpty(componente.getModello())) {
			ex.addFieldRequired(ConstantsField.GESTISCI_LIBRETTO5_1SR_MODELLO);
		} else {
			checkAsciiStringMaxLength(componente.getModello(), 33, ConstantsField.GESTISCI_LIBRETTO5_1SR_MODELLO, ex);
		}

		if (GenericUtil.isNullOrEmpty(componente.getNumPunti())) {
			ex.addFieldRequired(ConstantsField.GESTISCI_LIBRETTO5_1SR_NUM_PUNTI);
		} else {
			checkNumero(componente.getNumPunti(), ConstantsField.GESTISCI_LIBRETTO5_1SR_NUM_PUNTI, 4, null, ex, true);
		}

		if (GenericUtil.isNullOrEmpty(componente.getNumLivelli())) {
			ex.addFieldRequired(ConstantsField.GESTISCI_LIBRETTO5_1SR_NUM_LIVELLI);
		} else {
			checkNumero(componente.getNumLivelli(), ConstantsField.GESTISCI_LIBRETTO5_1SR_NUM_LIVELLI, 3, null, ex, true);
		}

		if (isDataDismisObb && GenericUtil.isNullOrEmpty(componente.getDataDismissione()))
		{
			ex.addFieldRequired(ConstantsField.GESTISCI_LIBRETTO5_1SR_DATA_DISMISSIONE);
		}

		if (ex.getFieldList().size() > 0)
		{
				//ex.setMsg(message);
				throw ex;
		}

		isDataFutura(componente.getDataInstallazione(), ConstantsField.GESTISCI_LIBRETTO5_1SR_DATA_INSTALLAZIONE);

		checkDate(componente.getDataInstallazione(), ConstantsField.GESTISCI_LIBRETTO5_1SR_DATA_INSTALLAZIONE);


//		if (!DateUtil.checkDateOrder(impianto.getDataInizioResp(), responsabile.getDataInizioResp(), true))
//		{
//			throw new ValidationManagerException(new Message(Messages.ERROR_DATA_RESPONSABILE));
//		}

		if (GenericUtil.isNotNullOrEmpty(componente.getDataDismissione()))
		{

			isDataFutura(componente.getDataDismissione(), ConstantsField.GESTISCI_LIBRETTO5_1SR_DATA_DISMISSIONE);

			if (!DateUtil.checkDateOrder(componente.getDataInstallazione(), componente.getDataDismissione(), true))
			{
				throw new ValidationManagerException(new Message(Messages.ERROR_DATA_INSTALL_DISMISS));
			}


		}

		// Vevo verificare che la data installazione sia successiva all'ultima data dismissio dei sostituiti

		if (compList != null && compList.size() > 0)
		{
			ComponenteSR componenteSost = compList.get(0);

			if (!DateUtil.checkDateOrder(componenteSost.getDataDismissione(), componente.getDataInstallazione(), false))
			{
				throw new ValidationManagerException(new Message(Messages.ERROR_DATA_INSTALL_DISMISS_DISM));

			}

		}

	}

	public void validazioneFormaleLibrettoScheda5_1VRDett(ComponenteVR componente, ArrayList<ComponenteVR> compList, boolean isDataDismisObb) throws ValidationManagerException {
		preparaToValidate(componente);

		if (compList != null) {
			for (ComponenteVR comp : compList) {
				preparaToValidate(comp);
			}
		}
		ValidationManagerException ex = new ValidationManagerException();


		if (GenericUtil.isNullOrEmpty(componente.getDataInstallazione())) {
			ex.addFieldRequired(ConstantsField.GESTISCI_LIBRETTO5_1VR_DATA_INSTALLAZIONE);

		}

		if (GenericUtil.isNullOrEmpty(componente.getIdFabbricante())) {
			ex.addFieldRequired(ConstantsField.GESTISCI_LIBRETTO5_1VR_ID_FABBRICANTE);

		}

		if (GenericUtil.isNullOrEmpty(componente.getModello())) {
			ex.addFieldRequired(ConstantsField.GESTISCI_LIBRETTO5_1VR_MODELLO);
		} else {
			checkAsciiStringMaxLength(componente.getModello(), 33, ConstantsField.GESTISCI_LIBRETTO5_1VR_MODELLO, ex);
		}

		if (GenericUtil.isNullOrEmpty(componente.getNumVie())) {
			ex.addFieldRequired(ConstantsField.GESTISCI_LIBRETTO5_1VR_NUM_VIE);
		} else {
			checkNumeroIntero(componente.getNumVie(), ConstantsField.GESTISCI_LIBRETTO5_1VR_NUM_VIE);
		}

		if (GenericUtil.isNullOrEmpty(componente.getServomotore())) {
			ex.addFieldRequired(ConstantsField.GESTISCI_LIBRETTO5_1VR_SERVOMOTORE);
		} else {
			checkAsciiStringMaxLength(componente.getServomotore(), 100, ConstantsField.GESTISCI_LIBRETTO5_1VR_SERVOMOTORE, ex);
		}

		if (isDataDismisObb && GenericUtil.isNullOrEmpty(componente.getDataDismissione()))
		{
			ex.addFieldRequired(ConstantsField.GESTISCI_LIBRETTO5_1VR_DATA_DISMISSIONE);
		}

		if (ex.getFieldList().size() > 0)
		{
				//ex.setMsg(message);
				throw ex;
		}

		isDataFutura(componente.getDataInstallazione(), ConstantsField.GESTISCI_LIBRETTO5_1VR_DATA_INSTALLAZIONE);

		checkDate(componente.getDataInstallazione(), ConstantsField.GESTISCI_LIBRETTO5_1VR_DATA_INSTALLAZIONE);


//		if (!DateUtil.checkDateOrder(impianto.getDataInizioResp(), responsabile.getDataInizioResp(), true))
//		{
//			throw new ValidationManagerException(new Message(Messages.ERROR_DATA_RESPONSABILE));
//		}

		if (GenericUtil.isNotNullOrEmpty(componente.getDataDismissione()))
		{

			isDataFutura(componente.getDataDismissione(), ConstantsField.GESTISCI_LIBRETTO5_1VR_DATA_DISMISSIONE);

			if (!DateUtil.checkDateOrder(componente.getDataInstallazione(), componente.getDataDismissione(), true))
			{
				throw new ValidationManagerException(new Message(Messages.ERROR_DATA_INSTALL_DISMISS));
			}


		}



		// Vevo verificare che la data installazione sia successiva all'ultima data dismissio dei sostituiti

		if (compList != null && compList.size() > 0)
		{
			ComponenteVR componenteSost = compList.get(0);

			if (!DateUtil.checkDateOrder(componenteSost.getDataDismissione(), componente.getDataInstallazione(), false))
			{
				throw new ValidationManagerException(new Message(Messages.ERROR_DATA_INSTALL_DISMISS_DISM));

			}

		}

	}

	public void validazioneFormaleLibrettoScheda6(SistemiDistribuzione sistemaDistribuzione, List<ComponenteVX> componenti, ExecResults result) throws ValidationManagerException {
		preparaToValidate(sistemaDistribuzione);

		if (componenti != null) {
			for (ComponenteVX comp : componenti) {
				preparaToValidate(comp);
			}
		}

		ValidationManagerException validationException = new ValidationManagerException();


		//6.1
		if (GenericUtil.isNullOrEmpty(sistemaDistribuzione.getL6_1Altro())) {
			if (sistemaDistribuzione.getL6_1flagAltro()) {
				validationException.addField("appDatasistemaDistribuzione.l6_1Altro",Messages.S169);
			}
		} else {
			checkAsciiStringMaxLength(sistemaDistribuzione.getL6_1Altro(), 5000, "appDatasistemaDistribuzione.l6_1Altro", validationException);
			sistemaDistribuzione.setL6_1flagAltro(true);
		}

		/*
		//selezione da combo: no automatismo.
		if (TipoDistribuzioneEnum.ALTRO.name().equals(sistemaDistribuzione.getL61TipoDistribuzione())) {
			if (StringUtils.isBlank(sistemaDistribuzione.getL61Altro())) {
				validationException.addFieldRequired("appDatasistemaDistribuzione.l61Altro");
			} else {
				checkAsciiStringMaxLength(sistemaDistribuzione.getL61Altro(), 93, "appDatasistemaDistribuzione.l61Altro", validationException);
			}
		} else {
			sistemaDistribuzione.setL61Altro(null);
		}
		*/

		if (GenericUtil.isNullOrEmpty(sistemaDistribuzione.getL6_2Coibent()))
		{
			validationException.addFieldRequired("appDatasistemaDistribuzione.l6_2Coibent");
		}

		if (!StringUtils.isBlank(sistemaDistribuzione.getL6_2Note())) {
			checkAsciiStringMaxLength(sistemaDistribuzione.getL6_2Note(), 1000, "appDatasistemaDistribuzione.l6_2Note", validationException);
		}

		//validazione sulla lista dei componenti
		if (componenti != null && !componenti.isEmpty()) {
			int riga = 1;
			for (ComponenteVX componente : componenti) {
				String msg = null;
				if (StringUtils.isBlank(componente.getCapacita())) {
					msg =  Messages.ERROR_CAMPO_OBBLIGATORIO;
				} else {
					Message message = checkNumero(componente.getCapacita(), 6, 2, true);
					if (message != null ) {
						msg = message.getText();
					}
				}

				if (msg != null) {
					result.getGlobalErrors().add(creaMsgTabellaEdit(riga, "Capacita'", msg));
				}

				if (StringUtils.isBlank(componente.getVaso())) {
					result.getGlobalErrors().add(creaMsgTabellaEdit(riga, "Tipo", Messages.ERROR_CAMPO_OBBLIGATORIO));
				}

				Message message = checkNumero(componente.getPressioneBar(), 5, 2, true);
				if (message != null ) {
					result.getGlobalErrors().add(creaMsgTabellaEdit(riga, "Pressione", message.getText()));
				}

				riga++;
			}
		}

		if ((result.getGlobalErrors() != null && !result.getGlobalErrors().isEmpty()) || !validationException.getFieldList().isEmpty() || validationException.getMessage() != null) {
			throw validationException;
		}

	}

	public void validazioneFormaleLibrettoScheda6_4Dett(ComponentePO componente, ArrayList<ComponentePO> compList, boolean isDataDismisObb) throws ValidationManagerException {
		preparaToValidate(componente);

		if (compList != null) {
			for (ComponentePO comp : compList) {
				preparaToValidate(comp);
			}
		}
		ValidationManagerException ex = new ValidationManagerException();


		if (GenericUtil.isNullOrEmpty(componente.getDataInstallazione())) {
			ex.addFieldRequired(ConstantsField.GESTISCI_LIBRETTO6_4_DATA_INSTALLAZIONE);

		}

		if (GenericUtil.isNullOrEmpty(componente.getIdFabbricante())) {
			ex.addFieldRequired(ConstantsField.GESTISCI_LIBRETTO6_4_ID_FABBRICANTE);

		}

		if (GenericUtil.isNullOrEmpty(componente.getModello())) {
			ex.addFieldRequired(ConstantsField.GESTISCI_LIBRETTO6_4_MODELLO);

		} else {
			checkAsciiStringMaxLength(componente.getModello(), 33, ConstantsField.GESTISCI_LIBRETTO6_4_MODELLO, ex);
		}


		if (GenericUtil.isNullOrEmpty(componente.getFlgGiriVariabili())) {
			ex.addFieldRequired(ConstantsField.GESTISCI_LIBRETTO6_4_FLG_GIRI_VARIABILI);

		}

		/*
		if (GenericUtil.isNullOrEmpty(componente.getPotenza())) {
			ex.addFieldRequired(ConstantsField.GESTISCI_LIBRETTO6_4_POTENZA);

		}
		*/

		if (isDataDismisObb && GenericUtil.isNullOrEmpty(componente.getDataDismissione()))
		{
			ex.addFieldRequired(ConstantsField.GESTISCI_LIBRETTO6_4_DATA_DISMISSIONE);
		}

		if (ex.getFieldList().size() > 0)
		{
				//ex.setMsg(message);
				throw ex;
		}

		isDataFutura(componente.getDataInstallazione(), ConstantsField.GESTISCI_LIBRETTO6_4_DATA_INSTALLAZIONE);

		checkDate(componente.getDataInstallazione(), ConstantsField.GESTISCI_LIBRETTO6_4_DATA_INSTALLAZIONE);


//		if (!DateUtil.checkDateOrder(impianto.getDataInizioResp(), responsabile.getDataInizioResp(), true))
//		{
//			throw new ValidationManagerException(new Message(Messages.ERROR_DATA_RESPONSABILE));
//		}

		if (GenericUtil.isNotNullOrEmpty(componente.getDataDismissione()))
		{

			isDataFutura(componente.getDataDismissione(), ConstantsField.GESTISCI_LIBRETTO6_4_DATA_DISMISSIONE);

			if (!DateUtil.checkDateOrder(componente.getDataInstallazione(), componente.getDataDismissione(), true))
			{
				throw new ValidationManagerException(new Message(Messages.ERROR_DATA_INSTALL_DISMISS));
			}


		}

		checkNumero(componente.getPotenza(), ConstantsField.GESTISCI_LIBRETTO6_4_POTENZA, 6,2, null, true);

		// Vevo verificare che la data installazione sia successiva all'ultima data dismissio dei sostituiti

		if (compList != null && compList.size() > 0)
		{
			ComponentePO componenteSost = compList.get(0);

			if (!DateUtil.checkDateOrder(componenteSost.getDataDismissione(), componente.getDataInstallazione(), false))
			{
				throw new ValidationManagerException(new Message(Messages.ERROR_DATA_INSTALL_DISMISS_DISM));

			}

		}

	}


	public void validazioneFormaleLibrettoScheda8Dett(ComponenteAC componente, ArrayList<ComponenteAC> compList, boolean isDataDismisObb) throws ValidationManagerException {
		preparaToValidate(componente);

		if (compList != null) {
			for (ComponenteAC comp : compList) {
				preparaToValidate(comp);
			}
		}
		ValidationManagerException ex = new ValidationManagerException();


		if (GenericUtil.isNullOrEmpty(componente.getDataInstallazione())) {
			ex.addFieldRequired(ConstantsField.GESTISCI_LIBRETTO8_DATA_INSTALLAZIONE);

		}

		if (GenericUtil.isNullOrEmpty(componente.getIdFabbricante())) {
			ex.addFieldRequired(ConstantsField.GESTISCI_LIBRETTO8_ID_FABBRICANTE);

		}

		if (GenericUtil.isNullOrEmpty(componente.getModello())) {
			ex.addFieldRequired(ConstantsField.GESTISCI_LIBRETTO8_MODELLO);

		} else {
			checkAsciiStringMaxLength(componente.getModello(), 33, ConstantsField.GESTISCI_LIBRETTO8_MODELLO, ex);
		}

		if (GenericUtil.isNullOrEmpty(componente.getMatricola())) {
			ex.addFieldRequired(ConstantsField.GESTISCI_LIBRETTO8_MATRICOLA);

		} else {
			checkAsciiStringMaxLength(componente.getMatricola(), 30, ConstantsField.GESTISCI_LIBRETTO8_MATRICOLA, ex);
		}

		if (GenericUtil.isNullOrEmpty(componente.getCapacita())) {
			ex.addFieldRequired(ConstantsField.GESTISCI_LIBRETTO8_CAPACITA);

		} else {
			checkNumero(componente.getCapacita(), ConstantsField.GESTISCI_LIBRETTO8_CAPACITA, 6, 2, ex, true);
		}

		if (GenericUtil.isNullOrEmpty(componente.getCoibentazione())) {
			ex.addFieldRequired(ConstantsField.GESTISCI_LIBRETTO8_COIBENTAZIONE);

		}


		if (isDataDismisObb && GenericUtil.isNullOrEmpty(componente.getDataDismissione()))
		{
			ex.addFieldRequired(ConstantsField.GESTISCI_LIBRETTO8_DATA_DISMISSIONE);
		}

		if (ex.getFieldList().size() > 0)
		{
				//ex.setMsg(message);
				throw ex;
		}

		isDataFutura(componente.getDataInstallazione(), ConstantsField.GESTISCI_LIBRETTO8_DATA_INSTALLAZIONE);

		checkDate(componente.getDataInstallazione(), ConstantsField.GESTISCI_LIBRETTO8_DATA_INSTALLAZIONE);

//		if (!DateUtil.checkDateOrder(impianto.getDataInizioResp(), responsabile.getDataInizioResp(), true))
//		{
//			throw new ValidationManagerException(new Message(Messages.ERROR_DATA_RESPONSABILE));
//		}

		if (GenericUtil.isNotNullOrEmpty(componente.getDataDismissione()))
		{

			isDataFutura(componente.getDataDismissione(), ConstantsField.GESTISCI_LIBRETTO8_DATA_DISMISSIONE);

			if (!DateUtil.checkDateOrder(componente.getDataInstallazione(), componente.getDataDismissione(), true))
			{
				throw new ValidationManagerException(new Message(Messages.ERROR_DATA_INSTALL_DISMISS));
			}


		}


		// Vevo verificare che la data installazione sia successiva all'ultima data dismissio dei sostituiti

		if (compList != null && compList.size() > 0)
		{
			ComponenteAC componenteSost = compList.get(0);

			if (!DateUtil.checkDateOrder(componenteSost.getDataDismissione(), componente.getDataInstallazione(), false))
			{
				throw new ValidationManagerException(new Message(Messages.ERROR_DATA_INSTALL_DISMISS_DISM));

			}

		}

	}

	public void validazioneFormaleLibrettoScheda9_1Dett(ComponenteTE componente, ArrayList<ComponenteTE> compList, boolean isDataDismisObb) throws ValidationManagerException {
		preparaToValidate(componente);

		if (compList != null) {
			for (ComponenteTE comp : compList) {
				preparaToValidate(comp);
			}
		}
		ValidationManagerException ex = new ValidationManagerException();


		if (GenericUtil.isNullOrEmpty(componente.getDataInstallazione())) {
			ex.addFieldRequired(ConstantsField.GESTISCI_LIBRETTO9_1_DATA_INSTALLAZIONE);

		}

		if (GenericUtil.isNullOrEmpty(componente.getIdFabbricante())) {
			ex.addFieldRequired(ConstantsField.GESTISCI_LIBRETTO9_1_ID_FABBRICANTE);

		}

		if (GenericUtil.isNullOrEmpty(componente.getModello())) {
			ex.addFieldRequired(ConstantsField.GESTISCI_LIBRETTO9_1_MODELLO);
		} else {
			checkAsciiStringMaxLength(componente.getModello(), 33, ConstantsField.GESTISCI_LIBRETTO9_1_MODELLO, ex);
		}

		if (GenericUtil.isNullOrEmpty(componente.getMatricola())) {
			ex.addFieldRequired(ConstantsField.GESTISCI_LIBRETTO9_1_MATRICOLA);

		}

		if (GenericUtil.isNullOrEmpty(componente.getCapacita())) {
			ex.addFieldRequired(ConstantsField.GESTISCI_LIBRETTO9_1_CAPACITA);

		}

		if (isDataDismisObb && GenericUtil.isNullOrEmpty(componente.getDataDismissione()))
		{
			ex.addFieldRequired(ConstantsField.GESTISCI_LIBRETTO9_1_DATA_DISMISSIONE);
		}

		if (ex.getFieldList().size() > 0)
		{
				//ex.setMsg(message);
				throw ex;
		}

		isDataFutura(componente.getDataInstallazione(), ConstantsField.GESTISCI_LIBRETTO9_1_DATA_INSTALLAZIONE);

		checkDate(componente.getDataInstallazione(), ConstantsField.GESTISCI_LIBRETTO9_1_DATA_INSTALLAZIONE);


//		if (!DateUtil.checkDateOrder(impianto.getDataInizioResp(), responsabile.getDataInizioResp(), true))
//		{
//			throw new ValidationManagerException(new Message(Messages.ERROR_DATA_RESPONSABILE));
//		}

		if (GenericUtil.isNotNullOrEmpty(componente.getDataDismissione()))
		{

			isDataFutura(componente.getDataDismissione(), ConstantsField.GESTISCI_LIBRETTO9_1_DATA_DISMISSIONE);

			if (!DateUtil.checkDateOrder(componente.getDataInstallazione(), componente.getDataDismissione(), true))
			{
				throw new ValidationManagerException(new Message(Messages.ERROR_DATA_INSTALL_DISMISS));
			}


		}

		checkNumero(componente.getCapacita(), ConstantsField.GESTISCI_LIBRETTO9_1_CAPACITA, 6,2, null, true);

		checkNumeroIntero(componente.getNumVentilatori(), ConstantsField.GESTISCI_LIBRETTO9_1_NUM_VENTILATORI);

		// Vevo verificare che la data installazione sia successiva all'ultima data dismissio dei sostituiti

		if (compList != null && compList.size() > 0)
		{
			ComponenteTE componenteSost = compList.get(0);

			if (!DateUtil.checkDateOrder(componenteSost.getDataDismissione(), componente.getDataInstallazione(), false))
			{
				throw new ValidationManagerException(new Message(Messages.ERROR_DATA_INSTALL_DISMISS_DISM));

			}

		}

	}

	public void validazioneFormaleLibrettoScheda9_2Dett(ComponenteRV componente, ArrayList<ComponenteRV> compList, boolean isDataDismisObb) throws ValidationManagerException {
		preparaToValidate(componente);

		if (compList != null) {
			for (ComponenteRV comp : compList) {
				preparaToValidate(comp);
			}
		}

		ValidationManagerException ex = new ValidationManagerException();


		if (GenericUtil.isNullOrEmpty(componente.getDataInstallazione())) {
			ex.addFieldRequired(ConstantsField.GESTISCI_LIBRETTO9_2_DATA_INSTALLAZIONE);

		}

		if (GenericUtil.isNullOrEmpty(componente.getIdFabbricante())) {
			ex.addFieldRequired(ConstantsField.GESTISCI_LIBRETTO9_2_ID_FABBRICANTE);

		}

		if (GenericUtil.isNullOrEmpty(componente.getModello())) {
			ex.addFieldRequired(ConstantsField.GESTISCI_LIBRETTO9_2_MODELLO);
		} else {
			checkAsciiStringMaxLength(componente.getModello(), 33, ConstantsField.GESTISCI_LIBRETTO9_2_MODELLO, ex);
		}

		if (GenericUtil.isNullOrEmpty(componente.getMatricola())) {
			ex.addFieldRequired(ConstantsField.GESTISCI_LIBRETTO9_2_MATRICOLA);

		}

		if (isDataDismisObb && GenericUtil.isNullOrEmpty(componente.getDataDismissione()))
		{
			ex.addFieldRequired(ConstantsField.GESTISCI_LIBRETTO9_2_DATA_DISMISSIONE);
		}

		if (ex.getFieldList().size() > 0)
		{
				//ex.setMsg(message);
				throw ex;
		}

		isDataFutura(componente.getDataInstallazione(), ConstantsField.GESTISCI_LIBRETTO9_2_DATA_INSTALLAZIONE);

		checkDate(componente.getDataInstallazione(), ConstantsField.GESTISCI_LIBRETTO9_2_DATA_INSTALLAZIONE);


//		if (!DateUtil.checkDateOrder(impianto.getDataInizioResp(), responsabile.getDataInizioResp(), true))
//		{
//			throw new ValidationManagerException(new Message(Messages.ERROR_DATA_RESPONSABILE));
//		}

		if (GenericUtil.isNotNullOrEmpty(componente.getDataDismissione()))
		{

			isDataFutura(componente.getDataDismissione(), ConstantsField.GESTISCI_LIBRETTO9_2_DATA_DISMISSIONE);

			if (!DateUtil.checkDateOrder(componente.getDataInstallazione(), componente.getDataDismissione(), true))
			{
				throw new ValidationManagerException(new Message(Messages.ERROR_DATA_INSTALL_DISMISS));
			}


		}

		checkNumeroIntero(componente.getNumVentilatori(), ConstantsField.GESTISCI_LIBRETTO9_2_NUM_VENTILATORI);

		// Vevo verificare che la data installazione sia successiva all'ultima data dismissio dei sostituiti

		if (compList != null && compList.size() > 0)
		{
			ComponenteRV componenteSost = compList.get(0);

			if (!DateUtil.checkDateOrder(componenteSost.getDataDismissione(), componente.getDataInstallazione(), false))
			{
				throw new ValidationManagerException(new Message(Messages.ERROR_DATA_INSTALL_DISMISS_DISM));

			}

		}

	}

	public void validazioneFormaleLibrettoScheda9_3Dett(ComponenteSCX componente, ArrayList<ComponenteSCX> compList, boolean isDataDismisObb) throws ValidationManagerException {
		preparaToValidate(componente);

		if (compList != null) {
			for (ComponenteSCX comp : compList) {
				preparaToValidate(comp);
			}
		}
		ValidationManagerException ex = new ValidationManagerException();


		if (GenericUtil.isNullOrEmpty(componente.getDataInstallazione())) {
			ex.addFieldRequired(ConstantsField.GESTISCI_LIBRETTO9_3_DATA_INSTALLAZIONE);

		}

		if (GenericUtil.isNullOrEmpty(componente.getIdFabbricante())) {
			ex.addFieldRequired(ConstantsField.GESTISCI_LIBRETTO9_3_ID_FABBRICANTE);

		}

		if (GenericUtil.isNullOrEmpty(componente.getModello())) {
			ex.addFieldRequired(ConstantsField.GESTISCI_LIBRETTO9_3_MODELLO);
		} else {
			checkAsciiStringMaxLength(componente.getModello(), 33, ConstantsField.GESTISCI_LIBRETTO9_3_MODELLO, ex);
		}


		if (isDataDismisObb && GenericUtil.isNullOrEmpty(componente.getDataDismissione()))
		{
			ex.addFieldRequired(ConstantsField.GESTISCI_LIBRETTO9_3_DATA_DISMISSIONE);
		}

		if (ex.getFieldList().size() > 0)
		{
				//ex.setMsg(message);
				throw ex;
		}

		isDataFutura(componente.getDataInstallazione(), ConstantsField.GESTISCI_LIBRETTO9_3_DATA_INSTALLAZIONE);

		checkDate(componente.getDataInstallazione(), ConstantsField.GESTISCI_LIBRETTO9_3_DATA_INSTALLAZIONE);


//		if (!DateUtil.checkDateOrder(impianto.getDataInizioResp(), responsabile.getDataInizioResp(), true))
//		{
//			throw new ValidationManagerException(new Message(Messages.ERROR_DATA_RESPONSABILE));
//		}

		if (GenericUtil.isNotNullOrEmpty(componente.getDataDismissione()))
		{

			isDataFutura(componente.getDataDismissione(), ConstantsField.GESTISCI_LIBRETTO9_3_DATA_DISMISSIONE);

			if (!DateUtil.checkDateOrder(componente.getDataInstallazione(), componente.getDataDismissione(), true))
			{
				throw new ValidationManagerException(new Message(Messages.ERROR_DATA_INSTALL_DISMISS));
			}


		}


		// Vevo verificare che la data installazione sia successiva all'ultima data dismissio dei sostituiti

		if (compList != null && compList.size() > 0)
		{
			ComponenteSCX componenteSost = compList.get(0);

			if (!DateUtil.checkDateOrder(componenteSost.getDataDismissione(), componente.getDataInstallazione(), false))
			{
				throw new ValidationManagerException(new Message(Messages.ERROR_DATA_INSTALL_DISMISS_DISM));

			}

		}

	}

	public void validazioneFormaleLibrettoScheda9_4Dett(ComponenteCI componente, ArrayList<ComponenteCI> compList, boolean isDataDismisObb) throws ValidationManagerException {
		preparaToValidate(componente);

		if (compList != null) {
			for (ComponenteCI comp : compList) {
				preparaToValidate(comp);
			}
		}
		ValidationManagerException ex = new ValidationManagerException();


		if (GenericUtil.isNullOrEmpty(componente.getDataInstallazione())) {
			ex.addFieldRequired(ConstantsField.GESTISCI_LIBRETTO9_4_DATA_INSTALLAZIONE);

		}

		if (GenericUtil.isNullOrEmpty(componente.getLungCircuito())) {
			ex.addFieldRequired(ConstantsField.GESTISCI_LIBRETTO9_4_LUNG_CIRCUITO);

		} else {
			checkNumero(componente.getLungCircuito(), ConstantsField.GESTISCI_LIBRETTO9_4_LUNG_CIRCUITO, 6, 2, ex, true);
		}

		if (GenericUtil.isNullOrEmpty(componente.getSupScambiatore())) {
			ex.addFieldRequired(ConstantsField.GESTISCI_LIBRETTO9_4_SUP_SCAMBIATORE);
		} else {
			checkNumero(componente.getSupScambiatore(), ConstantsField.GESTISCI_LIBRETTO9_4_SUP_SCAMBIATORE, 6, 2, ex, true);
		}

		if (GenericUtil.isNullOrEmpty(componente.getProfInstallaz())) {
			ex.addFieldRequired(ConstantsField.GESTISCI_LIBRETTO9_4_PROF_INSTALLAZ);
		} else {
			checkNumero(componente.getProfInstallaz(), ConstantsField.GESTISCI_LIBRETTO9_4_PROF_INSTALLAZ, 6, 2, ex, true);
		}

		if (isDataDismisObb && GenericUtil.isNullOrEmpty(componente.getDataDismissione()))
		{
			ex.addFieldRequired(ConstantsField.GESTISCI_LIBRETTO9_4_DATA_DISMISSIONE);
		}


		if (ex.getFieldList().size() > 0)
		{
				//ex.setMsg(message);
				throw ex;
		}

		isDataFutura(componente.getDataInstallazione(), ConstantsField.GESTISCI_LIBRETTO9_4_DATA_INSTALLAZIONE);

		checkDate(componente.getDataInstallazione(), ConstantsField.GESTISCI_LIBRETTO9_4_DATA_INSTALLAZIONE);


//		if (!DateUtil.checkDateOrder(impianto.getDataInizioResp(), responsabile.getDataInizioResp(), true))
//		{
//			throw new ValidationManagerException(new Message(Messages.ERROR_DATA_RESPONSABILE));
//		}

		if (GenericUtil.isNotNullOrEmpty(componente.getDataDismissione()))
		{

			isDataFutura(componente.getDataDismissione(), ConstantsField.GESTISCI_LIBRETTO9_4_DATA_DISMISSIONE);

			if (!DateUtil.checkDateOrder(componente.getDataInstallazione(), componente.getDataDismissione(), true))
			{
				throw new ValidationManagerException(new Message(Messages.ERROR_DATA_INSTALL_DISMISS));
			}


		}

		// Vevo verificare che la data installazione sia successiva all'ultima data dismissio dei sostituiti

		if (compList != null && compList.size() > 0)
		{
			ComponenteCI componenteSost = compList.get(0);

			if (!DateUtil.checkDateOrder(componenteSost.getDataDismissione(), componente.getDataInstallazione(), false))
			{
				throw new ValidationManagerException(new Message(Messages.ERROR_DATA_INSTALL_DISMISS_DISM));

			}

		}

	}

	public void validazioneFormaleLibrettoScheda9_5Dett(ComponenteUT componente, ArrayList<ComponenteUT> compList, boolean isDataDismisObb) throws ValidationManagerException {
		preparaToValidate(componente);

		if (compList != null) {
			for (ComponenteUT comp : compList) {
				preparaToValidate(comp);
			}
		}
		ValidationManagerException ex = new ValidationManagerException();


		if (GenericUtil.isNullOrEmpty(componente.getDataInstallazione())) {
			ex.addFieldRequired(ConstantsField.GESTISCI_LIBRETTO9_5_DATA_INSTALLAZIONE);

		}

		if (GenericUtil.isNullOrEmpty(componente.getIdFabbricante())) {
			ex.addFieldRequired(ConstantsField.GESTISCI_LIBRETTO9_5_ID_FABBRICANTE);

		}

		if (GenericUtil.isNullOrEmpty(componente.getModello())) {
			ex.addFieldRequired(ConstantsField.GESTISCI_LIBRETTO9_5_MODELLO);
		} else {
			checkAsciiStringMaxLength(componente.getModello(), 33, ConstantsField.GESTISCI_LIBRETTO9_5_MODELLO, ex);
		}

		if (GenericUtil.isNullOrEmpty(componente.getMatricola())) {
			ex.addFieldRequired(ConstantsField.GESTISCI_LIBRETTO9_5_MATRICOLA);

		}


		if (isDataDismisObb && GenericUtil.isNullOrEmpty(componente.getDataDismissione()))
		{
			ex.addFieldRequired(ConstantsField.GESTISCI_LIBRETTO9_5_DATA_DISMISSIONE);
		}

		if (GenericUtil.isNullOrEmpty(componente.getPortVentMandLs())) {
			ex.addFieldRequired(ConstantsField.GESTISCI_LIBRETTO9_5_PORT_VENT_MAND_LS);

		} else {
			checkNumero(componente.getPortVentMandLs(), ConstantsField.GESTISCI_LIBRETTO9_5_PORT_VENT_MAND_LS, 5, 2, ex, true);
		}

		if (GenericUtil.isNullOrEmpty(componente.getPortVentMandKw())) {
			ex.addFieldRequired(ConstantsField.GESTISCI_LIBRETTO9_5_PORT_VENT_MAND_KW);

		} else {
			checkNumero(componente.getPortVentMandKw(), ConstantsField.GESTISCI_LIBRETTO9_5_PORT_VENT_MAND_KW, 5, 2, ex, true);
		}

		if (GenericUtil.isNullOrEmpty(componente.getPortVentRipresaLs())) {
			ex.addFieldRequired(ConstantsField.GESTISCI_LIBRETTO9_5_PORT_VENT_RIPRESA_LS);

		} else {
			checkNumero(componente.getPortVentRipresaLs(), ConstantsField.GESTISCI_LIBRETTO9_5_PORT_VENT_RIPRESA_LS, 6, 2, ex, true);
		}

		if (GenericUtil.isNullOrEmpty(componente.getPortVentRipresaKw())) {
			ex.addFieldRequired(ConstantsField.GESTISCI_LIBRETTO9_5_PORT_VENT_RIPRESA_KW);

		} else {
			checkNumero(componente.getPortVentRipresaKw(), ConstantsField.GESTISCI_LIBRETTO9_5_PORT_VENT_RIPRESA_KW, 6, 2, ex, true);
		}


		if (ex.getFieldList().size() > 0)
		{
				//ex.setMsg(message);
				throw ex;
		}

		isDataFutura(componente.getDataInstallazione(), ConstantsField.GESTISCI_LIBRETTO9_5_DATA_INSTALLAZIONE);

		checkDate(componente.getDataInstallazione(), ConstantsField.GESTISCI_LIBRETTO9_5_DATA_INSTALLAZIONE);


//		if (!DateUtil.checkDateOrder(impianto.getDataInizioResp(), responsabile.getDataInizioResp(), true))
//		{
//			throw new ValidationManagerException(new Message(Messages.ERROR_DATA_RESPONSABILE));
//		}

		if (GenericUtil.isNotNullOrEmpty(componente.getDataDismissione()))
		{

			isDataFutura(componente.getDataDismissione(), ConstantsField.GESTISCI_LIBRETTO9_5_DATA_DISMISSIONE);

			if (!DateUtil.checkDateOrder(componente.getDataInstallazione(), componente.getDataDismissione(), true))
			{
				throw new ValidationManagerException(new Message(Messages.ERROR_DATA_INSTALL_DISMISS));
			}


		}

		// Vevo verificare che la data installazione sia successiva all'ultima data dismissio dei sostituiti

		if (compList != null && compList.size() > 0)
		{
			ComponenteUT componenteSost = compList.get(0);

			if (!DateUtil.checkDateOrder(componenteSost.getDataDismissione(), componente.getDataInstallazione(), false))
			{
				throw new ValidationManagerException(new Message(Messages.ERROR_DATA_INSTALL_DISMISS_DISM));

			}

		}

	}

	public void validazioneFormaleLibrettoScheda9_6Dett(ComponenteRC componente, ArrayList<ComponenteRC> compList, boolean isDataDismisObb) throws ValidationManagerException {
		preparaToValidate(componente);

		if (compList != null) {
			for (ComponenteRC comp : compList) {
				preparaToValidate(comp);
			}
		}
		ValidationManagerException ex = new ValidationManagerException();


		if (GenericUtil.isNullOrEmpty(componente.getDataInstallazione())) {
			ex.addFieldRequired(ConstantsField.GESTISCI_LIBRETTO9_6_DATA_INSTALLAZIONE);

		}

		if (GenericUtil.isNullOrEmpty(componente.getTipologia())) {
			ex.addFieldRequired(ConstantsField.GESTISCI_LIBRETTO9_6_TIPOLOGIA);
		}  else {
			checkAsciiStringMaxLength(componente.getTipologia(), 33, ConstantsField.GESTISCI_LIBRETTO9_6_TIPOLOGIA, ex);
		}

		if (GenericUtil.isNullOrEmpty(componente.getTipoInstall())) {
			ex.addFieldRequired(ConstantsField.GESTISCI_LIBRETTO9_6_INSTALLAZIONE);
		}

		if (isDataDismisObb && GenericUtil.isNullOrEmpty(componente.getDataDismissione()))
		{
			ex.addFieldRequired(ConstantsField.GESTISCI_LIBRETTO9_6_DATA_DISMISSIONE);
		}

		checkNumero(componente.getPortVentMandLs(), ConstantsField.GESTISCI_LIBRETTO9_6_PORT_VENT_MAND_LS, 5, 2, null, true);
		checkNumero(componente.getPortVentMandKw(), ConstantsField.GESTISCI_LIBRETTO9_6_PORT_VENT_MAND_KW, 5, 2, null, true);
		checkNumero(componente.getPortVentRipresaLs(), ConstantsField.GESTISCI_LIBRETTO9_6_PORT_VENT_RIPRESA_LS, 6, 2, null, true);
		checkNumero(componente.getPortVentRipresaKw(), ConstantsField.GESTISCI_LIBRETTO9_6_PORT_VENT_RIPRESA_KW, 6, 2, null, true);

		if (ex.getFieldList().size() > 0)
		{
				//ex.setMsg(message);
				throw ex;
		}

		isDataFutura(componente.getDataInstallazione(), ConstantsField.GESTISCI_LIBRETTO9_6_DATA_INSTALLAZIONE);

		checkDate(componente.getDataInstallazione(), ConstantsField.GESTISCI_LIBRETTO9_6_DATA_INSTALLAZIONE);


//		if (!DateUtil.checkDateOrder(impianto.getDataInizioResp(), responsabile.getDataInizioResp(), true))
//		{
//			throw new ValidationManagerException(new Message(Messages.ERROR_DATA_RESPONSABILE));
//		}

		if (GenericUtil.isNotNullOrEmpty(componente.getDataDismissione()))
		{

			isDataFutura(componente.getDataDismissione(), ConstantsField.GESTISCI_LIBRETTO9_6_DATA_DISMISSIONE);

			if (!DateUtil.checkDateOrder(componente.getDataInstallazione(), componente.getDataDismissione(), true))
			{
				throw new ValidationManagerException(new Message(Messages.ERROR_DATA_INSTALL_DISMISS));
			}
		}

		// Vevo verificare che la data installazione sia successiva all'ultima data dismissio dei sostituiti

		if (compList != null && compList.size() > 0)
		{
			ComponenteRC componenteSost = compList.get(0);

			if (!DateUtil.checkDateOrder(componenteSost.getDataDismissione(), componente.getDataInstallazione(), false))
			{
				throw new ValidationManagerException(new Message(Messages.ERROR_DATA_INSTALL_DISMISS_DISM));

			}

		}
	}

	public void validazioneFormaleLibrettoScheda10Dett(ComponenteVM componente, ArrayList<ComponenteVM> compList, boolean isDataDismisObb) throws ValidationManagerException {
		preparaToValidate(componente);

		if (compList != null) {
			for (ComponenteVM comp : compList) {
				preparaToValidate(comp);
			}
		}

		ValidationManagerException ex = new ValidationManagerException();


		if (GenericUtil.isNullOrEmpty(componente.getDataInstallazione())) {
			ex.addFieldRequired(ConstantsField.GESTISCI_LIBRETTO10_1_DATA_INSTALLAZIONE);

		}

		if (GenericUtil.isNullOrEmpty(componente.getIdFabbricante())) {
			ex.addFieldRequired(ConstantsField.GESTISCI_LIBRETTO10_1_ID_FABBRICANTE);

		}

		if (GenericUtil.isNullOrEmpty(componente.getModello())) {
			ex.addFieldRequired(ConstantsField.GESTISCI_LIBRETTO10_1_MODELLO);

		}

		if (GenericUtil.isNullOrEmpty(componente.getPortMassima())) {
			ex.addFieldRequired(ConstantsField.GESTISCI_LIBRETTO10_1_PORT_MAX);
		} else {
			checkNumero(componente.getPortMassima(), ConstantsField.GESTISCI_LIBRETTO10_1_PORT_MAX, 5, 2, ex, true);
		}

		if (GenericUtil.isNullOrEmpty(componente.getIdDettVm())) {
			ex.addFieldRequired(ConstantsField.GESTISCI_LIBRETTO10_1_TIPOLOGIA);
		}
		String idDettaglioAltro = null;
		try {
			List<SigitDDettaglioVmDto> listaDettagli = getDbMgr().getElencoDettaglioVmByDescrizione("ALTRO");
			if (listaDettagli != null && !listaDettagli.isEmpty()) {
				idDettaglioAltro = ConvertUtil.convertToString(listaDettagli.get(0).getIdDettaglioVm());
			}
		} catch (DbManagerException e) {
			e.printStackTrace();
		}
		if (idDettaglioAltro != null) {
			componente.setDescAltro(idDettaglioAltro.equals(componente.getIdDettVm()) ? componente.getDescAltro() : null);
			if(componente.getIdDettVm().equals(idDettaglioAltro)
					&& GenericUtil.isNullOrEmpty(componente.getDescAltro())) {
				ex.addFieldRequired(ConstantsField.GESTISCI_LIBRETTO10_1_DESC_ALTRO);
					}
		}

		if (GenericUtil.isNotNullOrEmpty(componente.getIdDettVm()) && componente.getIdDettVm().equals(Constants.ID_ALTRO)
				&& GenericUtil.isNullOrEmpty(componente.getDescAltro())) {
					ex.addFieldRequired(ConstantsField.GESTISCI_LIBRETTO10_1_DESC_ALTRO);
		}

		if (GenericUtil.isNullOrEmpty(componente.getRendimentoRec())) {
			ex.addFieldRequired(ConstantsField.GESTISCI_LIBRETTO10_1_REND_REC);
		} else {
			checkNumero(componente.getRendimentoRec(), ConstantsField.GESTISCI_LIBRETTO10_1_REND_REC, 5, 2, ex, true);
		}

		if (isDataDismisObb && GenericUtil.isNullOrEmpty(componente.getDataDismissione()))
		{
			ex.addFieldRequired(ConstantsField.GESTISCI_LIBRETTO10_1_DATA_DISMISSIONE);
		}

		if (ex.getFieldList().size() > 0)
		{
				//ex.setMsg(message);
				throw ex;
		}

		isDataFutura(componente.getDataInstallazione(), ConstantsField.GESTISCI_LIBRETTO10_1_DATA_INSTALLAZIONE);

		checkDate(componente.getDataInstallazione(), ConstantsField.GESTISCI_LIBRETTO10_1_DATA_INSTALLAZIONE);

//		if (!DateUtil.checkDateOrder(impianto.getDataInizioResp(), responsabile.getDataInizioResp(), true))
//		{
//			throw new ValidationManagerException(new Message(Messages.ERROR_DATA_RESPONSABILE));
//		}

		if (GenericUtil.isNotNullOrEmpty(componente.getDataDismissione()))
		{

			isDataFutura(componente.getDataDismissione(), ConstantsField.GESTISCI_LIBRETTO10_1_DATA_DISMISSIONE);

			if (!DateUtil.checkDateOrder(componente.getDataInstallazione(), componente.getDataDismissione(), true))
			{
				throw new ValidationManagerException(new Message(Messages.ERROR_DATA_INSTALL_DISMISS));
			}
		}


		// Vevo verificare che la data installazione sia successiva all'ultima data dismissio dei sostituiti

		if (compList != null && compList.size() > 0)
		{
			ComponenteVM componenteSost = compList.get(0);

			if (!DateUtil.checkDateOrder(componenteSost.getDataDismissione(), componente.getDataInstallazione(), false))
			{
				throw new ValidationManagerException(new Message(Messages.ERROR_DATA_INSTALL_DISMISS_DISM));

			}

		}

	}

	public void validazioneFormaleLibrettoScheda14_1(ArrayList<Consumo> listaConsumi, ControlloLibretto controlloLib, ExecResults result) throws ValidationManagerException {
		if (listaConsumi != null) {
			for (Consumo cons : listaConsumi) {
				preparaToValidate(cons);
			}
		}

		ValidationManagerException validationException = new ValidationManagerException();
		int riga = 0;
		boolean esercizioDaVal = false;
		boolean esercizioAVal = false;

		if (ConvertUtil.convertToBooleanAllways(controlloLib.getFlgControlloScheda1()))
		{
			int currentYear = Calendar.getInstance().get(Calendar.YEAR);
			for(Consumo temp : listaConsumi){
				riga++;

				esercizioDaVal = false;
				esercizioAVal = false;

				if (GenericUtil.isNullOrEmpty(temp.getEsercizioDa())) {
					result.getGlobalErrors().add(creaMsgTabellaEdit(riga,"Esercizio Da", Messages.ERROR_CAMPO_OBBLIGATORIO));
				}
				else if (GenericUtil.checkIsValidYear(temp.getEsercizioDa())) {
					result.getGlobalErrors().add(creaMsgTabellaEdit(riga,"Esercizio Da", Messages.ERROR_DEVE_ESSERE_ANNO));
				} else if (currentYear < Integer.parseInt(temp.getEsercizioDa())) {
					result.getGlobalErrors().add(creaMsgTabellaEdit(riga,"Esercizio Da", Messages.ERROR_ANNO_FUTURO));
				}
				else
				{
					esercizioDaVal = true;
				}

				if (GenericUtil.isNullOrEmpty(temp.getEsercizioA())) {
					result.getGlobalErrors().add(creaMsgTabellaEdit(riga,"Esercizio A", Messages.ERROR_CAMPO_OBBLIGATORIO));
				}
				else if (GenericUtil.checkIsValidYear(temp.getEsercizioA())) {
					result.getGlobalErrors().add(creaMsgTabellaEdit(riga,"Esercizio A", Messages.ERROR_DEVE_ESSERE_ANNO));
				} else if (currentYear < Integer.parseInt(temp.getEsercizioA())) {
					result.getGlobalErrors().add(creaMsgTabellaEdit(riga,"Esercizio A", Messages.ERROR_ANNO_FUTURO));
				}
				else
				{
					esercizioAVal = true;
				}

				// Se esercizioDaVal e esercizioAVal sono valorizzati allora controllo che esercizioDaVal sia minore o uguale a esercizioAVal
				if (esercizioDaVal && esercizioAVal &&
						Integer.parseInt(temp.getEsercizioDa()) > Integer.parseInt(temp.getEsercizioA())) {
					result.getGlobalErrors().add(creaMsgTabellaEdit(riga,"Esercizio Da", " deve essere minore o uguale al campo <i>Esercizio A</i>"));
				}

				if (GenericUtil.isNullOrEmpty(temp.getCombustibile())) {
					result.getGlobalErrors().add(creaMsgTabellaEdit(riga,"Tipo Combustibile", Messages.ERROR_CAMPO_OBBLIGATORIO));
				}

				if (GenericUtil.isNullOrEmpty(temp.getUnitaMisura())) {
					result.getGlobalErrors().add(creaMsgTabellaEdit(riga,"Unita' di misura", Messages.ERROR_CAMPO_OBBLIGATORIO));
				}

				if (GenericUtil.isNotNullOrEmpty(temp.getLetturaIniziale()))
				{
					if (!GenericUtil.isDecimalNumber(temp.getLetturaIniziale())) {
						result.getGlobalErrors().add(creaMsgTabellaEdit(riga,"Lettura Iniziale", Messages.ERROR_DEVE_ESSERE_NUMERICO));
					}
					else if (!GenericUtil.isNumeroDecimaleValidoMaxDec(temp.getLetturaIniziale(), Constants.NUMERO_DECIMALI)) {
						result.getGlobalErrors().add(creaMsgTabellaEdit(riga,"Lettura Iniziale", Messages.ERROR_DECIMALI_NON_CORRETTI));
					}
				}

				if (GenericUtil.isNotNullOrEmpty(temp.getLetturaFinale()))
				{
					if (!GenericUtil.isDecimalNumber(temp.getLetturaFinale())) {
						result.getGlobalErrors().add(creaMsgTabellaEdit(riga,"Lettura Finale", Messages.ERROR_DEVE_ESSERE_NUMERICO));
					}
					else if (!GenericUtil.isNumeroDecimaleValidoMaxDec(temp.getLetturaFinale(), Constants.NUMERO_DECIMALI)) {
						result.getGlobalErrors().add(creaMsgTabellaEdit(riga,"Lettura Finale", Messages.ERROR_DECIMALI_NON_CORRETTI));
					}
				}

				if (GenericUtil.isNullOrEmpty(temp.getConsumo())) {
					result.getGlobalErrors().add(creaMsgTabellaEdit(riga,"Consumo", Messages.ERROR_CAMPO_OBBLIGATORIO));
				}
				else if (!GenericUtil.isDecimalNumber(temp.getConsumo())) {
					result.getGlobalErrors().add(creaMsgTabellaEdit(riga,"Consumo", Messages.ERROR_DEVE_ESSERE_NUMERICO));
				} else if (!GenericUtil.isNumeroDecimaleValidoMaxDec(temp.getConsumo(), Constants.NUMERO_DECIMALI)) {
					result.getGlobalErrors().add(creaMsgTabellaEdit(riga,"Consumo", Messages.ERROR_DECIMALI_NON_CORRETTI));
				}
			}
		}
		else
		{
			// Vuol dire che l'utente hoh ha ancora salvato la Scheda1, quindi non puo' proseguire
			result.getGlobalErrors().add(Messages.ERROR_LIBRETTO_SCHEDA1_NON_SALVATA);
		}

		if(!result.getGlobalErrors().isEmpty()){
			throw validationException;
		}
		//}

	}

	public void validazioneFormaleLibrettoScheda14_2(ArrayList<Consumo> listaConsumi, ControlloLibretto controlloLib, ExecResults result) throws ValidationManagerException {
		if (listaConsumi != null) {
			for (Consumo cons : listaConsumi) {
				preparaToValidate(cons);
			}
		}

		ValidationManagerException validationException = new ValidationManagerException();
		int riga = 0;

		if (ConvertUtil.convertToBooleanAllways(controlloLib.getFlgControlloScheda1()))
		{

			int currentYear = Calendar.getInstance().get(Calendar.YEAR);
			for(Consumo temp : listaConsumi){
				riga++;

				boolean esercizioDaVal = false;
				boolean esercizioAVal = false;

				if (GenericUtil.isNullOrEmpty(temp.getEsercizioDa())) {
					result.getGlobalErrors().add(creaMsgTabellaEdit(riga,"Esercizio Da", Messages.ERROR_CAMPO_OBBLIGATORIO));
				} else if (GenericUtil.checkIsValidYear(temp.getEsercizioDa())) {
					result.getGlobalErrors().add(creaMsgTabellaEdit(riga,"Esercizio Da", Messages.ERROR_DEVE_ESSERE_ANNO));
				} else if (currentYear < Integer.parseInt(temp.getEsercizioDa())) {
					result.getGlobalErrors().add(creaMsgTabellaEdit(riga,"Esercizio Da", Messages.ERROR_ANNO_FUTURO));
				} else {
					esercizioDaVal = true;
				}

				if (GenericUtil.isNullOrEmpty(temp.getEsercizioA())) {
					result.getGlobalErrors().add(creaMsgTabellaEdit(riga,"Esercizio A", Messages.ERROR_CAMPO_OBBLIGATORIO));
				} else if (GenericUtil.checkIsValidYear(temp.getEsercizioA())) {
					result.getGlobalErrors().add(creaMsgTabellaEdit(riga,"Esercizio A", Messages.ERROR_DEVE_ESSERE_ANNO));
				} else if (currentYear < Integer.parseInt(temp.getEsercizioA())) {
					result.getGlobalErrors().add(creaMsgTabellaEdit(riga,"Esercizio A", Messages.ERROR_ANNO_FUTURO));
				} else {
					esercizioAVal = true;
				}

				if (esercizioDaVal && esercizioAVal &&
						Integer.parseInt(temp.getEsercizioDa())>Integer.parseInt(temp.getEsercizioA())) {
					result.getGlobalErrors().add(creaMsgTabellaEdit(riga,"Esercizio Da", " deve essere minore o uguale al campo <i>Esercizio A</i>"));
				}


				if (GenericUtil.isNotNullOrEmpty(temp.getLetturaIniziale()))
				{
					if (!GenericUtil.isDecimalNumber(temp.getLetturaIniziale())) {
						result.getGlobalErrors().add(creaMsgTabellaEdit(riga,"Lettura Iniziale", Messages.ERROR_DEVE_ESSERE_NUMERICO));
					}
					else if (!GenericUtil.isNumeroDecimaleValidoMaxDec(temp.getLetturaIniziale(), Constants.NUMERO_DECIMALI)) {
						result.getGlobalErrors().add(creaMsgTabellaEdit(riga,"Lettura Iniziale", Messages.ERROR_DECIMALI_NON_CORRETTI));
					}
				}

				if (GenericUtil.isNotNullOrEmpty(temp.getLetturaFinale()))
				{
					if (!GenericUtil.isDecimalNumber(temp.getLetturaFinale())) {
						result.getGlobalErrors().add(creaMsgTabellaEdit(riga,"Lettura Finale", Messages.ERROR_DEVE_ESSERE_NUMERICO));
					}
					else if (!GenericUtil.isNumeroDecimaleValidoMaxDec(temp.getLetturaFinale(), Constants.NUMERO_DECIMALI)) {
						result.getGlobalErrors().add(creaMsgTabellaEdit(riga,"Lettura Finale", Messages.ERROR_DECIMALI_NON_CORRETTI));
					}
				}

				if (GenericUtil.isNullOrEmpty(temp.getConsumo())) {
					result.getGlobalErrors().add(creaMsgTabellaEdit(riga,"Consumo", Messages.ERROR_CAMPO_OBBLIGATORIO));
				} else if (!GenericUtil.isDecimalNumber(temp.getConsumo())) {
					result.getGlobalErrors().add(creaMsgTabellaEdit(riga,"Consumo", Messages.ERROR_DEVE_ESSERE_NUMERICO));
				} else if (!GenericUtil.isNumeroDecimaleValidoMaxDec(temp.getConsumo(), Constants.NUMERO_DECIMALI)) {
					result.getGlobalErrors().add(creaMsgTabellaEdit(riga,"Consumo", Messages.ERROR_DECIMALI_NON_CORRETTI));
				}
			}
		}
		else
		{
			// Vuol dire che l'utente hoh ha ancora salvato la Scheda1, quindi non puo' proseguire
			result.getGlobalErrors().add(Messages.ERROR_LIBRETTO_SCHEDA1_NON_SALVATA);
		}

		if(!result.getGlobalErrors().isEmpty()){
			throw validationException;
		}
		//}

	}

	public void validazioneFormaleLibrettoScheda14_3(ConsumoAcqua consumoAcqua, ControlloLibretto controlloLib, ExecResults result) throws ValidationManagerException {
		List<Consumo> listaConsumi = consumoAcqua.getListaConsumi();

		if (listaConsumi != null) {
			for (Consumo cons : listaConsumi) {
				preparaToValidate(cons);
			}
		}

		ValidationManagerException validationException = new ValidationManagerException();
		int riga = 0;

		if (ConvertUtil.convertToBooleanAllways(controlloLib.getFlgControlloScheda1()))
		{

			int currentYear = Calendar.getInstance().get(Calendar.YEAR);

			if (GenericUtil.isNullOrEmpty(consumoAcqua.getUnitaMisura())) {
				validationException.addFieldRequired("appDataconsumoAcqua.unitaMisura");
			}

			for(Consumo temp : listaConsumi){
				riga++;

				boolean esercizioDaVal = false;
				boolean esercizioAVal = false;

				if (GenericUtil.isNullOrEmpty(temp.getEsercizioDa())) {
					result.getGlobalErrors().add(creaMsgTabellaEdit(riga,"Esercizio Da", Messages.ERROR_CAMPO_OBBLIGATORIO));
				} else if (GenericUtil.checkIsValidYear(temp.getEsercizioDa())) {
					result.getGlobalErrors().add(creaMsgTabellaEdit(riga,"Esercizio Da", Messages.ERROR_DEVE_ESSERE_ANNO));
				} else if (currentYear < Integer.parseInt(temp.getEsercizioDa())) {
					result.getGlobalErrors().add(creaMsgTabellaEdit(riga,"Esercizio Da", Messages.ERROR_ANNO_FUTURO));
				} else {
					esercizioDaVal = true;
				}

				if (GenericUtil.isNullOrEmpty(temp.getEsercizioA())) {
					result.getGlobalErrors().add(creaMsgTabellaEdit(riga,"Esercizio A", Messages.ERROR_CAMPO_OBBLIGATORIO));
				} else if (GenericUtil.checkIsValidYear(temp.getEsercizioA())) {
					result.getGlobalErrors().add(creaMsgTabellaEdit(riga,"Esercizio A", Messages.ERROR_DEVE_ESSERE_ANNO));
				} else if (currentYear < Integer.parseInt(temp.getEsercizioA())) {
					result.getGlobalErrors().add(creaMsgTabellaEdit(riga,"Esercizio A", Messages.ERROR_ANNO_FUTURO));
				} else {
					esercizioAVal = true;
				}

				if (esercizioDaVal && esercizioAVal &&
						Integer.parseInt(temp.getEsercizioDa())>Integer.parseInt(temp.getEsercizioA())) {
					result.getGlobalErrors().add(creaMsgTabellaEdit(riga,"Esercizio Da", " deve essere minore o uguale al campo <i>Esercizio A</i>"));
				}

				if (GenericUtil.isNotNullOrEmpty(temp.getLetturaIniziale()))
				{
					if (!GenericUtil.isDecimalNumber(temp.getLetturaIniziale())) {
						result.getGlobalErrors().add(creaMsgTabellaEdit(riga,"Lettura Iniziale", Messages.ERROR_DEVE_ESSERE_NUMERICO));
					}
					else if (!GenericUtil.isNumeroDecimaleValidoMaxDec(temp.getLetturaIniziale(), Constants.NUMERO_DECIMALI)) {
						result.getGlobalErrors().add(creaMsgTabellaEdit(riga,"Lettura Iniziale", Messages.ERROR_DECIMALI_NON_CORRETTI));
					}
				}

				if (GenericUtil.isNotNullOrEmpty(temp.getLetturaFinale()))
				{
					if (!GenericUtil.isDecimalNumber(temp.getLetturaFinale())) {
						result.getGlobalErrors().add(creaMsgTabellaEdit(riga,"Lettura Finale", Messages.ERROR_DEVE_ESSERE_NUMERICO));
					}
					else if (!GenericUtil.isNumeroDecimaleValidoMaxDec(temp.getLetturaFinale(), Constants.NUMERO_DECIMALI)) {
						result.getGlobalErrors().add(creaMsgTabellaEdit(riga,"Lettura Finale", Messages.ERROR_DECIMALI_NON_CORRETTI));
					}
				}

				if (GenericUtil.isNullOrEmpty(temp.getConsumo())) {
					result.getGlobalErrors().add(creaMsgTabellaEdit(riga,"Consumo", Messages.ERROR_CAMPO_OBBLIGATORIO));
				}
				else if (!GenericUtil.isDecimalNumber(temp.getConsumo())) {
					result.getGlobalErrors().add(creaMsgTabellaEdit(riga,"Consumo", Messages.ERROR_DEVE_ESSERE_NUMERICO));
				}
				else if (!GenericUtil.isNumeroDecimaleValidoMaxDec(temp.getConsumo(), Constants.NUMERO_DECIMALI)) {
					result.getGlobalErrors().add(creaMsgTabellaEdit(riga,"Consumo", Messages.ERROR_DECIMALI_NON_CORRETTI));
				}
			}

		}
		else
		{
			// Vuol dire che l'utente hoh ha ancora salvato la Scheda1, quindi non puo' proseguire
			result.getGlobalErrors().add(Messages.ERROR_LIBRETTO_SCHEDA1_NON_SALVATA);
		}

		if(!result.getGlobalErrors().isEmpty() || !validationException.getFieldList().isEmpty()){
			throw validationException;
		}
		//}

	}

	public void validazioneFormaleLibrettoScheda14_4(ArrayList<Consumo> listaConsumi, ControlloLibretto controlloLib, ExecResults result) throws ValidationManagerException {
		if (listaConsumi != null) {
			for (Consumo cons : listaConsumi) {
				preparaToValidate(cons);
			}
		}

		ValidationManagerException validationException = new ValidationManagerException();
		int riga = 0;

		if (ConvertUtil.convertToBooleanAllways(controlloLib.getFlgControlloScheda1()))
		{

			int currentYear = Calendar.getInstance().get(Calendar.YEAR);
			for(Consumo temp : listaConsumi){
				riga++;
				boolean esercizioDaVal = false;
				boolean esercizioAVal = false;

					/*
			if (GenericUtil.isNullOrEmpty(temp.getAcquisti())) {
				validationException.addFieldRequired("appDatalistaConsumiTrovati.acquisti");
			}*/
				if (GenericUtil.isNullOrEmpty(temp.getEsercizioDa())) {
					result.getGlobalErrors().add(creaMsgTabellaEdit(riga,"Esercizio Da", Messages.ERROR_CAMPO_OBBLIGATORIO));
				} else if (GenericUtil.checkIsValidYear(temp.getEsercizioDa())) {
					result.getGlobalErrors().add(creaMsgTabellaEdit(riga,"Esercizio Da", Messages.ERROR_DEVE_ESSERE_ANNO));
				} else if (currentYear < Integer.parseInt(temp.getEsercizioDa())) {
					result.getGlobalErrors().add(creaMsgTabellaEdit(riga,"Esercizio Da", Messages.ERROR_ANNO_FUTURO));
				} else {
					esercizioDaVal = true;
				}


				if (GenericUtil.isNullOrEmpty(temp.getEsercizioA())) {
					result.getGlobalErrors().add(creaMsgTabellaEdit(riga,"Esercizio A", Messages.ERROR_CAMPO_OBBLIGATORIO));
				} else if (GenericUtil.checkIsValidYear(temp.getEsercizioA())) {
					result.getGlobalErrors().add(creaMsgTabellaEdit(riga,"Esercizio A", Messages.ERROR_DEVE_ESSERE_ANNO));
				} else if (currentYear < Integer.parseInt(temp.getEsercizioA())) {
					result.getGlobalErrors().add(creaMsgTabellaEdit(riga,"Esercizio A", Messages.ERROR_ANNO_FUTURO));
				} else {
					esercizioAVal = true;
				}

				if (esercizioDaVal && esercizioAVal &&
						Integer.parseInt(temp.getEsercizioDa())>Integer.parseInt(temp.getEsercizioA())) {
					result.getGlobalErrors().add(creaMsgTabellaEdit(riga,"Esercizio Da", " deve essere minore o uguale al campo <i>Esercizio A</i>"));
				}

				if (GenericUtil.isNullOrEmpty(temp.getUnitaMisura())) {
					result.getGlobalErrors().add(creaMsgTabellaEdit(riga,"Unita' di misura", Messages.ERROR_CAMPO_OBBLIGATORIO));
				}

				if (GenericUtil.isNullOrEmpty(temp.getNomeProdotto())) {
					result.getGlobalErrors().add(creaMsgTabellaEdit(riga,"Nome prodotto", Messages.ERROR_CAMPO_OBBLIGATORIO));
				}

				String quantitaValida = GenericUtil.getStringValid(temp.getConsumo());

				if (GenericUtil.isNullOrEmpty(quantitaValida)) {
					result.getGlobalErrors().add(creaMsgTabellaEdit(riga,"Quantita' consumata", Messages.ERROR_CAMPO_OBBLIGATORIO));
				}
				else if (!GenericUtil.isDecimalNumber(quantitaValida)) {
					result.getGlobalErrors().add(creaMsgTabellaEdit(riga,"Quantita' consumata", Messages.ERROR_DEVE_ESSERE_NUMERICO));
				}
				else if (!GenericUtil.isNumeroDecimaleValidoMaxDec(quantitaValida, Constants.NUMERO_DECIMALI)) {
					result.getGlobalErrors().add(creaMsgTabellaEdit(riga,"Quantita' consumata", Messages.ERROR_DECIMALI_NON_CORRETTI));
				}
			}

		}
		else
		{
			// Vuol dire che l'utente hoh ha ancora salvato la Scheda1, quindi non puo' proseguire
			result.getGlobalErrors().add(Messages.ERROR_LIBRETTO_SCHEDA1_NON_SALVATA);
		}

		if(!result.getGlobalErrors().isEmpty()){
			throw validationException;
		}
		//}

	}


	public void validazioneFormaleLibrettoScheda7(SistemaEmissione sistemaEmissione) throws ValidationManagerException {
		preparaToValidate(sistemaEmissione);
		ValidationManagerException validationException = new ValidationManagerException();

		if (GenericUtil.isNullOrEmpty(sistemaEmissione.getAltro())) {
			if (sistemaEmissione.getFlagAltro()) {
				validationException.addFieldRequired("appDatasistemaEmissione.altro");
			}
		} else {
			sistemaEmissione.setFlagAltro(true);
			checkAsciiStringMaxLength(sistemaEmissione.getAltro(), 2000, "appDatasistemaEmissione.altro", validationException);
		}

		if (!sistemaEmissione.getFlagAltro() && !sistemaEmissione.getFlagBocchette() && !sistemaEmissione.getFlagPannelliRadianti()
				&& !sistemaEmissione.getFlagRadiatori() && !sistemaEmissione.getFlagStrisceRadianti() && !sistemaEmissione.getFlagTermoconvettori()
				&& !sistemaEmissione.getFlagTraviFredde() && !sistemaEmissione.getFlagVentilconvettori())
		{

			throw new ValidationManagerException(new Message(Messages.S711, "7.1"));

		}

		if(!validationException.getFieldList().isEmpty()){
			throw validationException;
		}

	}

	public void validazioneFormaleLibrettoScheda5_2(SistemiRegolazioneContabilizzazione sistema) throws ValidationManagerException {
		preparaToValidate(sistema);
		ValidationManagerException validationException = new ValidationManagerException();

		boolean descrizioneEmpty = StringUtils.isBlank(sistema.getL5_1flgSrDescrizione());
		if (StringUtils.isBlank(sistema.getL5_1flgSrDescrizione())) {
			if (sistema.getL5_1flgSrAltri()) {
				validationException.addFieldRequired("appDatasistemiRegolazioneContabilizzazione.l5_1flgSrDescrizione");
			}
		} else {
			sistema.setL5_1flgSrAltri(true);
			checkAsciiStringMaxLength(sistema.getL5_1flgSrDescrizione(), 500, "appDatasistemiRegolazioneContabilizzazione.l5_1flgSrDescrizione", validationException);
		}

		if (StringUtils.isBlank(sistema.getL5_2flgValvoleTermo())) {
			validationException.addFieldRequired("appDatasistemiRegolazioneContabilizzazione.l5_2flgValvoleTermo");
		}

		if (StringUtils.isBlank(sistema.getL5_2flgValvole2())) {
			validationException.addFieldRequired("appDatasistemiRegolazioneContabilizzazione.l5_2flgValvole2");
		}

		if (StringUtils.isBlank(sistema.getL5_2flgValvole3())) {
			validationException.addFieldRequired("appDatasistemiRegolazioneContabilizzazione.l5_2flgValvole3");
		}

		if (!StringUtils.isBlank(sistema.getL5_2note())) {
			checkAsciiStringMaxLength(sistema.getL5_2note(), 1000, "appDatasistemiRegolazioneContabilizzazione.l5_2note", validationException);
		}

		if (StringUtils.isBlank(sistema.getL5_3flgTelelettura())) {
			validationException.addFieldRequired("appDatasistemiRegolazioneContabilizzazione.l5_3flgTelelettura");
		}

		if (StringUtils.isBlank(sistema.getL5_3flgTelegestione())) {
			validationException.addFieldRequired("appDatasistemiRegolazioneContabilizzazione.l5_3flgTelegestione");
		}

		if (!StringUtils.isBlank(sistema.getL5_3desSistemaInstallaz())) {
			checkAsciiStringMaxLength(sistema.getL5_3desSistemaInstallaz(), 1000, "appDatasistemiRegolazioneContabilizzazione.l5_3desSistemaInstallaz", validationException);
		}

		if (!StringUtils.isBlank(sistema.getL5_3desSistemaSostituz())) {
			checkAsciiStringMaxLength(sistema.getL5_3desSistemaSostituz(), 1000, "appDatasistemiRegolazioneContabilizzazione.l5_3desSistemaSostituz", validationException);
		}

		boolean atLeastOneSelected = sistema.getL5_4flgAcs() || sistema.getL5_4flgRaff() || sistema.getL5_4flgRisc();
		if (StringUtils.isBlank(sistema.getL5_4flgUic())) {
			validationException.addFieldRequired("appDatasistemiRegolazioneContabilizzazione.l5_4flgUic");
		} else if (SiNoEnum.SI_1.getCodice().equals(sistema.getL5_4flgUic())){
			if (!atLeastOneSelected) {
				validationException.setMsg(new Message(Messages.S711, "di contabilizzazione"));
				validationException.addField("appDatasistemiRegolazioneContabilizzazione.l5_4flgAcs");
				validationException.addField("appDatasistemiRegolazioneContabilizzazione.l5_4flgRaff");
				validationException.addField("appDatasistemiRegolazioneContabilizzazione.l5_4flgRisc");
			}
		} else if (atLeastOneSelected) {
			sistema.setL5_4flgUic(SiNoEnum.SI_1.getCodice());
		}

		if (!StringUtils.isBlank(sistema.getL5_4desSistemaInstallaz())) {
			checkAsciiStringMaxLength(sistema.getL5_4desSistemaInstallaz(), 1000, "appDatasistemiRegolazioneContabilizzazione.l5_4desSistemaInstallaz", validationException);
		}

		if (!StringUtils.isBlank(sistema.getL5_4desSistemaSostituz())) {
			checkAsciiStringMaxLength(sistema.getL5_4desSistemaSostituz(), 1000, "appDatasistemiRegolazioneContabilizzazione.l5_4desSistemaSostituz", validationException);
		}

		if(!validationException.getFieldList().isEmpty()){
			throw validationException;
		}

	}


	public void validazioneFormaleLibrettoScheda2(TrattamentoAcqua trattamentoAcqua) throws ValidationManagerException {
		preparaToValidate(trattamentoAcqua);

		ValidationManagerException validationException = new ValidationManagerException();
		checkNumero(trattamentoAcqua.getL21H2oClimaM3(), "appDatatrattamentoAcqua.l21H2oClimaM3", 5, 4, validationException, true);
		checkNumero(trattamentoAcqua.getL22DurezzaH2oFr(), "appDatatrattamentoAcqua.l22DurezzaH2oFr", 2, 2, validationException, true);
		checkNumero(trattamentoAcqua.getL25ConducH2oIng(), "appDatatrattamentoAcqua.l25ConducH2oIng", 7, 2, validationException, true);
		checkNumero(trattamentoAcqua.getL25Taratura(), "appDatatrattamentoAcqua.l25Taratura", 7, 2, validationException, true);

		boolean l23DurezzaTotH2oFrEmpty = StringUtils.isBlank(trattamentoAcqua.getL23DurezzaTotH2oFr());
		checkNumero(trattamentoAcqua.getL23DurezzaTotH2oFr(), "appDatatrattamentoAcqua.l23DurezzaTotH2oFr", 2, 2, validationException, true);
		if (trattamentoAcqua.getL23FlgTrattClimaAddolc()) {
			if (l23DurezzaTotH2oFrEmpty) {
				validationException.addFieldRequired("appDatatrattamentoAcqua.l23DurezzaTotH2oFr");
			}
		} else {
			trattamentoAcqua.setL23FlgTrattClimaAddolc(!l23DurezzaTotH2oFrEmpty);
		}

		boolean l24DurezzaAddolcFrEmpty = StringUtils.isBlank(trattamentoAcqua.getL24DurezzaAddolcFr());
		checkNumero(trattamentoAcqua.getL24DurezzaAddolcFr(), "appDatatrattamentoAcqua.l24DurezzaAddolcFr", 2, 2, validationException, true);
		if (trattamentoAcqua.getL24FlgTrattAcsAddolc()) {
			if (l24DurezzaAddolcFrEmpty) {
				validationException.addFieldRequired("appDatatrattamentoAcqua.l24DurezzaAddolcFr");
			}
		} else {
			trattamentoAcqua.setL24FlgTrattAcsAddolc(!l24DurezzaAddolcFrEmpty);
		}

		if (TrattamentiAcquaFiltrazioneEnum.ALTRO.name().equals(trattamentoAcqua.getL25FlgTrattF())) {
			if (StringUtils.isBlank(trattamentoAcqua.getL25TrattFAltro())) {
				validationException.addFieldRequired("appDatatrattamentoAcqua.l25TrattFAltro");
			} else {
				checkAsciiStringMaxLength(trattamentoAcqua.getL25TrattFAltro(), 100, "appDatatrattamentoAcqua.l25TrattFAltro", validationException);
			}
		} else {
			trattamentoAcqua.setL25TrattFAltro(null);
		}

		if (TrattamentiAcquaTrattamentoEnum.ALTRO.name().equals(trattamentoAcqua.getL25FlgTrattT())) {
			if (StringUtils.isBlank(trattamentoAcqua.getL25TrattTAltro())) {
				validationException.addFieldRequired("appDatatrattamentoAcqua.l25TrattTAltro");
			} else {
				checkAsciiStringMaxLength(trattamentoAcqua.getL25TrattTAltro(), 100, "appDatatrattamentoAcqua.l25TrattTAltro", validationException);
			}
		} else {
			trattamentoAcqua.setL25TrattTAltro(null);
		}

		if (TrattamentiAcquaCondizionamentoChimicoEnum.ALTRO.name().equals(trattamentoAcqua.getL25FlgTrattC())) {
			if (StringUtils.isBlank(trattamentoAcqua.getL25TrattCAltro())) {
				validationException.addFieldRequired("appDatatrattamentoAcqua.l25TrattCAltro");
			} else {
				checkAsciiStringMaxLength(trattamentoAcqua.getL25TrattCAltro(), 100, "appDatatrattamentoAcqua.l25TrattCAltro", validationException);
			}
		} else {
			trattamentoAcqua.setL25TrattCAltro(null);
		}

		boolean errorOnMaxValue = false;

		boolean l23PhGliEtilEmpty = StringUtils.isBlank(trattamentoAcqua.getL23PhGliEtil());
		boolean l23PercGliEtilEmpty = StringUtils.isBlank(trattamentoAcqua.getL23PercGliEtil());

		//se non � stato scritto niente in ph
		if (l23PhGliEtilEmpty) {
			//se la checkbox relativa � stata selezionata o se � stato scritto qualcosa nel campo perc
			if (trattamentoAcqua.getL23FlgTrattGeloGliEtil() || !l23PercGliEtilEmpty) {
				//ph diventa obbligatorio
				validationException.addFieldRequired("appDatatrattamentoAcqua.l23PhGliEtil");
			}
		} else if (checkNumero(trattamentoAcqua.getL23PhGliEtil(), "appDatatrattamentoAcqua.l23PhGliEtil", 2, 2, validationException, true) && Double.valueOf(trattamentoAcqua.getL23PhGliEtil().replace(',', '.')).doubleValue() > 14) {
			errorOnMaxValue = true;
			validationException.addField("appDatatrattamentoAcqua.l23PhGliEtil", new Message(Messages.ERROR_VALORE_MASSIMO, "14").getText());
		}
		if (l23PercGliEtilEmpty) {
			if (trattamentoAcqua.getL23FlgTrattGeloGliEtil() || !l23PhGliEtilEmpty) {
				validationException.addFieldRequired("appDatatrattamentoAcqua.l23PercGliEtil");
			}
		} else if (checkNumero(trattamentoAcqua.getL23PercGliEtil(), "appDatatrattamentoAcqua.l23PercGliEtil", 3, 2, validationException, true) && Double.valueOf(trattamentoAcqua.getL23PercGliEtil().replace(',', '.')).doubleValue() > 100) {
			errorOnMaxValue = true;
			validationException.addField("appDatatrattamentoAcqua.l23PercGliEtil", new Message(Messages.ERROR_VALORE_MASSIMO, "100").getText());
		}
		if (!trattamentoAcqua.getL23FlgTrattGeloGliEtil()) {
			trattamentoAcqua.setL23FlgTrattGeloGliEtil(!l23PhGliEtilEmpty || !l23PercGliEtilEmpty); //basta che sia settato uno dei due per poter settare checkare il flag
		}

		boolean l23PhGliPropEmpty = StringUtils.isBlank(trattamentoAcqua.getL23PhGliProp());
		boolean l23PercGliPropEmpty = StringUtils.isBlank(trattamentoAcqua.getL23PercGliProp());

		if (l23PhGliPropEmpty) {
			if (trattamentoAcqua.getL23FlgTrattGeloGliProp() || !l23PercGliPropEmpty) {
				validationException.addFieldRequired("appDatatrattamentoAcqua.l23PhGliProp");
			}
		} else if (checkNumero(trattamentoAcqua.getL23PhGliProp(), "appDatatrattamentoAcqua.l23PhGliProp", 2, 2, validationException, true) && Double.valueOf(trattamentoAcqua.getL23PhGliProp().replace(',', '.')).doubleValue() > 14) {
			errorOnMaxValue = true;
			validationException.addField("appDatatrattamentoAcqua.l23PhGliProp", new Message(Messages.ERROR_VALORE_MASSIMO, "14").getText());
		}
		if (l23PercGliPropEmpty) {
			if (trattamentoAcqua.getL23FlgTrattGeloGliProp() || !l23PhGliPropEmpty) {
				validationException.addFieldRequired("appDatatrattamentoAcqua.l23PercGliProp");
			}
		} else if (checkNumero(trattamentoAcqua.getL23PercGliProp(), "appDatatrattamentoAcqua.l23PercGliProp", 3, 2, validationException, true) && Double.valueOf(trattamentoAcqua.getL23PercGliProp().replace(',', '.')).doubleValue() > 100) {
			errorOnMaxValue = true;
			validationException.addField("appDatatrattamentoAcqua.l23PercGliProp", new Message(Messages.ERROR_VALORE_MASSIMO, "100").getText());
		}
		if (!trattamentoAcqua.getL23FlgTrattGeloGliProp()) {
			trattamentoAcqua.setL23FlgTrattGeloGliProp(!l23PhGliPropEmpty || !l23PercGliPropEmpty); //basta che sia settato uno dei due per poter settare checkare il flag
		}

		if (errorOnMaxValue) {
			validationException.setMsg(new Message(Messages.S223));
		}

		if(!validationException.getFieldList().isEmpty()){
			throw validationException;
		}

	}

	public void validaFlgTrattRapportiProva(String codiceImpianto, String idAllegato, String tipoRapportoProva) throws ValidationManagerException {
		try
		{
			BigDecimal idAllegatoBD = ConvertUtil.convertToBigDecimal(idAllegato);
			SigitTTrattH2ODto dettaglioTrattAcqua = this.getDbMgr().cercaSigitTTrattH2OByCodImpianto(ConvertUtil.convertToBigDecimal(codiceImpianto));
			Integer SI = new Integer(1);
			if (Constants.RAPP_PROVA_ALLEGATO_TIPO_1.equals(tipoRapportoProva)) {
				SigitTRappIspezGtDto rappIspezGt = getDbMgr().getSigitTRappIspezGtDao().findByPrimaryKey(new SigitTRappIspezGtPk(idAllegatoBD));
				if (!SI.equals(ConvertUtil.convertToInteger(rappIspezGt.getS2fFlgTrattClimaNonRich())) && isReeFlgTrattClimaNonRichObbligatorio(dettaglioTrattAcqua)) {
					throw new ValidationManagerException(new Message("in assenza di trattamento sul libretto, il trattamento clima va impostato a SI"));
				}
				if (!SI.equals(ConvertUtil.convertToInteger(rappIspezGt.getS2fFlgTrattAcsNonRich())) && isReeFlgTrattAcsNonRichObbligatorio(dettaglioTrattAcqua)) {
					throw new ValidationManagerException(new Message("in assenza di trattamento sul libretto, il trattamento acs va impostato a SI"));
				}
			}

			if (Constants.RAPP_PROVA_ALLEGATO_TIPO_2.equals(tipoRapportoProva)) {
				SigitTRappIspezGfDto rappIspezGf = getDbMgr().getSigitTRappIspezGfDao().findByPrimaryKey(new SigitTRappIspezGfPk(idAllegatoBD));

				if (!SI.equals(ConvertUtil.convertToInteger(rappIspezGf.getS2eFlgTrattH2oNonRich())) && isReeFlgTrattClimaNonRichObbligatorio(dettaglioTrattAcqua)) {
					throw new ValidationManagerException(new Message("in assenza di trattamento sul libretto, il trattamento H2O va impostato a SI"));
				}
			}
		} catch (DbManagerException e) {
			throw new ValidationManagerException(new Message(Messages.ERROR_RECUPERO_DB));
		} catch (SigitTRappIspezGtDaoException e) {
			throw new ValidationManagerException(new Message(Messages.ERROR_RECUPERO_DB));
		} catch (SigitTRappIspezGfDaoException e) {
			throw new ValidationManagerException(new Message(Messages.ERROR_RECUPERO_DB));
		}

	}

	public void validazioneFormaleRappProvaGF (DettaglioAllegato dettAllegato, TipoGF tipoGF, String codiceImpianto) throws ValidationManagerException {
		preparaToValidate(tipoGF);

		ValidationManagerException validationException = new ValidationManagerException();

		if (GenericUtil.isNullOrEmpty(tipoGF.getS1cFlgReeInviato())) {
			validationException.addFieldRequired(CPBECpGestRapProvaTipo2.APPDATA_TIPOGF_CODE + ".s1cFlgReeInviato");
		}

		if (GenericUtil.isNullOrEmpty(tipoGF.getS1cFlgReeBollino())) {
			validationException.addFieldRequired(CPBECpGestRapProvaTipo2.APPDATA_TIPOGF_CODE + ".s1cFlgReeBollino");
		} else if (ConvertUtil.convertToBooleanAllways(tipoGF.getS1cFlgReeBollino())) {
			if (GenericUtil.isNullOrEmpty(tipoGF.getS1cSiglaBollino())) {
				validationException.addFieldRequired(CPBECpGestRapProvaTipo2.APPDATA_TIPOGF_CODE + ".s1cSiglaBollino");
			}

			if (GenericUtil.isNullOrEmpty(tipoGF.getS1cNumBollino())) {
				validationException.addFieldRequired(CPBECpGestRapProvaTipo2.APPDATA_TIPOGF_CODE + ".s1cNumBollino");
			}

			if (GenericUtil.isNullOrEmpty(tipoGF.getS1cDataRee())) {
				validationException.addFieldRequired(CPBECpGestRapProvaTipo2.APPDATA_TIPOGF_CODE + ".s1cDataRee");
			}
		}

		if (GenericUtil.isNullOrEmpty(tipoGF.getS1ePotTermicaMaxKw())) {
			validationException.addFieldRequired(CPBECpGestRapProvaTipo2.APPDATA_TIPOGF_CODE + ".s1ePotTermicaMaxKw");
		} else {
			checkNumero(tipoGF.getS1ePotTermicaMaxKw(), CPBECpGestRapProvaTipo2.APPDATA_TIPOGF_CODE + ".s1ePotTermicaMaxKw", 9, 2, 9, validationException, true);
		}

		SigitTTrattH2ODto dettaglioTrattAcqua = null;
		try {

			dettaglioTrattAcqua = this.getDbMgr().cercaSigitTTrattH2OByCodImpianto(ConvertUtil.convertToBigDecimal(codiceImpianto));

		} catch (DbManagerException e) {
			throw new ValidationManagerException(new Message(Messages.ERROR_RECUPERO_DB));
		}

		Integer SI = new Integer(1);
		if (!SI.equals(tipoGF.getS2eFlgTrattH2ONonRich()) && isReeFlgTrattClimaNonRichObbligatorio(dettaglioTrattAcqua)) {
			validationException.addField(CPBECpGestRapProvaTipo2.APPDATA_TIPOGF_CODE + ".s2eFlgTrattH2ONonRich", new Message(Messages.ERROR_ALLEGATO_REE_VALORE_FLG_SI).getText());
		}

		if (GenericUtil.isNullOrEmpty(tipoGF.getS3aFlgLocaleIntIdoneo())) {
			validationException.addFieldRequired(CPBECpGestRapProvaTipo2.APPDATA_TIPOGF_CODE + ".s3aFlgLocaleIntIdoneo");
		}

		if (GenericUtil.isNullOrEmpty(tipoGF.getS3bFlgLineeElettrIdonee())) {
			validationException.addFieldRequired(CPBECpGestRapProvaTipo2.APPDATA_TIPOGF_CODE + ".s3bFlgLineeElettrIdonee");
		}

		if (GenericUtil.isNullOrEmpty(tipoGF.getS3cFlgVentilazAdeguate())) {
			validationException.addFieldRequired(CPBECpGestRapProvaTipo2.APPDATA_TIPOGF_CODE + ".s3cFlgVentilazAdeguate");
		}

		if (GenericUtil.isNullOrEmpty(tipoGF.getS3dFlgCoibentazioniIdonee())) {
			validationException.addFieldRequired(CPBECpGestRapProvaTipo2.APPDATA_TIPOGF_CODE + ".s3dFlgCoibentazioniIdonee");
		}

		if (GenericUtil.isNullOrEmpty(tipoGF.getS4aFlgLibImpPresente())) {
			validationException.addFieldRequired(CPBECpGestRapProvaTipo2.APPDATA_TIPOGF_CODE + ".s4aFlgLibImpPresente");
		}

		if (GenericUtil.isNullOrEmpty(tipoGF.getS4bFlgLibCompilato())) {
			validationException.addFieldRequired(CPBECpGestRapProvaTipo2.APPDATA_TIPOGF_CODE + ".s4bFlgLibCompilato");
		}

		if (GenericUtil.isNullOrEmpty(tipoGF.getS4cFlgConformitaPresente())) {
			validationException.addFieldRequired(CPBECpGestRapProvaTipo2.APPDATA_TIPOGF_CODE + ".s4cFlgConformitaPresente");
		}

		if (GenericUtil.isNullOrEmpty(tipoGF.getS4dFlgLibUsoPresente())) {
			validationException.addFieldRequired(CPBECpGestRapProvaTipo2.APPDATA_TIPOGF_CODE + ".s4dFlgLibUsoPresente");
		}

		checkAsciiStringMaxLength(tipoGF.getS5bMotivoRelazNonEseg(), 100, CPBECpGestRapProvaTipo2.APPDATA_TIPOGF_CODE + ".s5bMotivoRelazNonEseg", validationException);

		checkAsciiStringMaxLength(dettAllegato.getOsservazioni(), 1000, CPBECpGestRapProvaTipo2.APPDATA_ALLEGATOISP_CODE + ".osservazioni", validationException);
		checkAsciiStringMaxLength(dettAllegato.getPrescrizioni(), 1000, CPBECpGestRapProvaTipo2.APPDATA_ALLEGATOISP_CODE + ".prescrizioni", validationException);
		checkAsciiStringMaxLength(dettAllegato.getRaccomandazioni(), 1000, CPBECpGestRapProvaTipo2.APPDATA_ALLEGATOISP_CODE + ".raccomandazioni", validationException);

		checkNumero(tipoGF.getS1cNumBollino(), CPBECpGestRapProvaTipo2.APPDATA_TIPOGF_CODE + ".s1cNumBollino", 11, null, validationException, true);

		if(!validationException.getFieldList().isEmpty()){
			throw validationException;
		}

	}

	public void validazioneFormaleRappProvaGT (DettaglioAllegato dettAllegato, TipoGT tipoGT, String codiceImpianto) throws ValidationManagerException {
		preparaToValidate(tipoGT);
		SigitTTrattH2ODto dettaglioTrattAcqua = null;
		try {

			dettaglioTrattAcqua = this.getDbMgr().cercaSigitTTrattH2OByCodImpianto(ConvertUtil.convertToBigDecimal(codiceImpianto));

		} catch (DbManagerException e) {
			throw new ValidationManagerException(new Message(Messages.ERROR_RECUPERO_DB));
		}

		ValidationManagerException validationException = new ValidationManagerException();

		if (GenericUtil.isNullOrEmpty(tipoGT.getS1cFlgReeInviato())) {
			validationException.addFieldRequired(CPBECpGestRapProvaTipo1.APPDATA_TIPOGT_CODE + ".s1cFlgReeInviato");
		}

		if (GenericUtil.isNullOrEmpty(tipoGT.getS1cFlgReeBollino())) {
			validationException.addFieldRequired(CPBECpGestRapProvaTipo1.APPDATA_TIPOGT_CODE + ".s1cFlgReeBollino");
		} else if (ConvertUtil.convertToBooleanAllways(tipoGT.getS1cFlgReeBollino())) {
			if (GenericUtil.isNullOrEmpty(tipoGT.getS1cSiglaBollino())) {
				validationException.addFieldRequired(CPBECpGestRapProvaTipo1.APPDATA_TIPOGT_CODE + ".s1cSiglaBollino");
			}

			if (GenericUtil.isNullOrEmpty(tipoGT.getS1cNumBollino())) {
				validationException.addFieldRequired(CPBECpGestRapProvaTipo1.APPDATA_TIPOGT_CODE + ".s1cNumBollino");
			}

			if (GenericUtil.isNullOrEmpty(tipoGT.getS1cDataRee())) {
				validationException.addFieldRequired(CPBECpGestRapProvaTipo1.APPDATA_TIPOGT_CODE + ".s1cDataRee");
			}
		}

		if (GenericUtil.isNullOrEmpty(tipoGT.getS1ePotFocolareKw())) {
			validationException.addFieldRequired(CPBECpGestRapProvaTipo1.APPDATA_TIPOGT_CODE + ".s1ePotFocolareKw");
		}

		if (GenericUtil.isNullOrEmpty(tipoGT.getS1ePotUtileKw())) {
			validationException.addFieldRequired(CPBECpGestRapProvaTipo1.APPDATA_TIPOGT_CODE + ".s1ePotUtileKw");
		}

		checkAsciiStringMaxLength(tipoGT.getS1lDenomDelegat(), 50, (CPBECpGestRapProvaTipo1.APPDATA_TIPOGT_CODE + ".s1lDenomDelegat"), validationException);

		if (GenericUtil.isNullOrEmpty(tipoGT.getS2b1FlgTermoContab())) {
			validationException.addFieldRequired(CPBECpGestRapProvaTipo1.APPDATA_TIPOGT_CODE + ".s2b1FlgTermoContab");
		}

		if (GenericUtil.isNullOrEmpty(tipoGT.getS2b1FlgUni10200())) {
			validationException.addFieldRequired(CPBECpGestRapProvaTipo1.APPDATA_TIPOGT_CODE + ".s2b1FlgUni10200");
		}

		Integer SI = new Integer(1);
		if (!SI.equals(tipoGT.getS2fFlgTrattClimaNonRich()) && isReeFlgTrattClimaNonRichObbligatorio(dettaglioTrattAcqua)) {
			validationException.addField(CPBECpGestRapProvaTipo1.APPDATA_TIPOGT_CODE + ".s2fFlgTrattClimaNonRich", new Message(Messages.ERROR_ALLEGATO_REE_VALORE_FLG_SI).getText());
		}

		if (!SI.equals(tipoGT.getS2fFlgTrattAcsNonRich()) && isReeFlgTrattAcsNonRichObbligatorio(dettaglioTrattAcqua)) {
			validationException.addField(CPBECpGestRapProvaTipo1.APPDATA_TIPOGT_CODE + ".s2fFlgTrattAcsNonRich", new Message(Messages.ERROR_ALLEGATO_REE_VALORE_FLG_SI).getText());
		}

		if (GenericUtil.isNullOrEmpty(tipoGT.getS3aFlgLocaleIntIdoneo())) {
			validationException.addFieldRequired(CPBECpGestRapProvaTipo1.APPDATA_TIPOGT_CODE + ".s3aFlgLocaleIntIdoneo");
		}

		if (GenericUtil.isNullOrEmpty(tipoGT.getS3bFlgGenExtIdoneo())) {
			validationException.addFieldRequired(CPBECpGestRapProvaTipo1.APPDATA_TIPOGT_CODE + ".s3bFlgGenExtIdoneo");
		}

		if (GenericUtil.isNullOrEmpty(tipoGT.getS3cFlgVentilazSuff())) {
			validationException.addFieldRequired(CPBECpGestRapProvaTipo1.APPDATA_TIPOGT_CODE + ".s3cFlgVentilazSuff");
		}

		if (GenericUtil.isNullOrEmpty(tipoGT.getS3dFlgEvacFumiIdoneo())) {
			validationException.addFieldRequired(CPBECpGestRapProvaTipo1.APPDATA_TIPOGT_CODE + ".s3dFlgEvacFumiIdoneo");
		}

		if (GenericUtil.isNullOrEmpty(tipoGT.getS3eFlgCartelliPresenti())) {
			validationException.addFieldRequired(CPBECpGestRapProvaTipo1.APPDATA_TIPOGT_CODE + ".s3eFlgCartelliPresenti");
		}

		if (GenericUtil.isNullOrEmpty(tipoGT.getS3fFlgEstinzPresenti())) {
			validationException.addFieldRequired(CPBECpGestRapProvaTipo1.APPDATA_TIPOGT_CODE + ".s3fFlgEstinzPresenti");
		}

		if (GenericUtil.isNullOrEmpty(tipoGT.getS3gFlgInterrGenPresenti())) {
			validationException.addFieldRequired(CPBECpGestRapProvaTipo1.APPDATA_TIPOGT_CODE + ".s3gFlgInterrGenPresenti");
		}

		if (GenericUtil.isNullOrEmpty(tipoGT.getS3hFlgRubinPresente())) {
			validationException.addFieldRequired(CPBECpGestRapProvaTipo1.APPDATA_TIPOGT_CODE + ".s3hFlgRubinPresente");
		}

		if (GenericUtil.isNullOrEmpty(tipoGT.getS3iFlgAssenzaPerdComb())) {
			validationException.addFieldRequired(CPBECpGestRapProvaTipo1.APPDATA_TIPOGT_CODE + ".s3iFlgAssenzaPerdComb");
		}

		if (GenericUtil.isNullOrEmpty(tipoGT.getS3jFlgTempAmbFunz())) {
			validationException.addFieldRequired(CPBECpGestRapProvaTipo1.APPDATA_TIPOGT_CODE + ".s3jFlgTempAmbFunz");
		}
		if (GenericUtil.isNullOrEmpty(tipoGT.getS3kFlgDm_1_12_1975())) {
			validationException.addFieldRequired(CPBECpGestRapProvaTipo1.APPDATA_TIPOGT_CODE + ".s3kFlgDm_1_12_1975");
		}

		if (GenericUtil.isNullOrEmpty(tipoGT.getS4aFlgLibImpPresente())) {
			validationException.addFieldRequired(CPBECpGestRapProvaTipo1.APPDATA_TIPOGT_CODE + ".s4aFlgLibImpPresente");
		}

		if (GenericUtil.isNullOrEmpty(tipoGT.getS4bFlgLibCompilato())) {
			validationException.addFieldRequired(CPBECpGestRapProvaTipo1.APPDATA_TIPOGT_CODE + ".s4bFlgLibCompilato");
		}

		if (GenericUtil.isNullOrEmpty(tipoGT.getS4cFlgConformitaPresente())) {
			validationException.addFieldRequired(CPBECpGestRapProvaTipo1.APPDATA_TIPOGT_CODE + ".s4cFlgConformitaPresente");
		}

		if (GenericUtil.isNullOrEmpty(tipoGT.getS4dFlgLibUsoPresente())) {
			validationException.addFieldRequired(CPBECpGestRapProvaTipo1.APPDATA_TIPOGT_CODE + ".s4dFlgLibUsoPresente");
		}

		if (GenericUtil.isNullOrEmpty(tipoGT.getS4eFlgPraticaVvfPresente())) {
			validationException.addFieldRequired(CPBECpGestRapProvaTipo1.APPDATA_TIPOGT_CODE + ".s4eFlgPraticaVvfPresente");
		}

		if (GenericUtil.isNullOrEmpty(tipoGT.getS4fFlgPraticaInailPresente())) {
			validationException.addFieldRequired(CPBECpGestRapProvaTipo1.APPDATA_TIPOGT_CODE + ".s4fFlgPraticaInailPresente");
		}

		if (GenericUtil.isNullOrEmpty(tipoGT.getS4gFlgDm12_1975())) {
			validationException.addFieldRequired(CPBECpGestRapProvaTipo1.APPDATA_TIPOGT_CODE + ".s4gFlgDm12_1975");
		} else if (SI.equals(tipoGT.getS4gFlgDm12_1975()) && GenericUtil.isNullOrEmpty(tipoGT.getS4gMatricolaDm_1_12_1975())) {
			validationException.addFieldRequired(CPBECpGestRapProvaTipo1.APPDATA_TIPOGT_CODE + ".s4gMatricolaDm_1_12_1975");
		}

		checkAsciiStringMaxLength(tipoGT.getS4gMatricolaDm_1_12_1975(), 10, CPBECpGestRapProvaTipo1.APPDATA_TIPOGT_CODE + ".s4gMatricolaDm_1_12_1975", validationException);


		checkNumero(tipoGT.getS1cNumBollino(), CPBECpGestRapProvaTipo1.APPDATA_TIPOGT_CODE + ".s1cNumBollino", 11, null, validationException, true);
		checkNumero(tipoGT.getS1ePotFocolareKw(), CPBECpGestRapProvaTipo1.APPDATA_TIPOGT_CODE + ".s1ePotFocolareKw", 9, 2, 9, validationException, true);
		checkNumero(tipoGT.getS1ePotUtileKw(), CPBECpGestRapProvaTipo1.APPDATA_TIPOGT_CODE + ".s1ePotUtileKw", 9, 2, 9, validationException, true);
		checkAsciiStringMaxLength(dettAllegato.getOsservazioni(), 1000, CPBECpGestRapProvaTipo1.APPDATA_ALLEGATOISP_CODE + ".osservazioni", validationException);
		checkAsciiStringMaxLength(dettAllegato.getPrescrizioni(), 1000, CPBECpGestRapProvaTipo1.APPDATA_ALLEGATOISP_CODE + ".prescrizioni", validationException);
		checkAsciiStringMaxLength(dettAllegato.getRaccomandazioni(), 1000, CPBECpGestRapProvaTipo1.APPDATA_ALLEGATOISP_CODE + ".raccomandazioni", validationException);

		if(!validationException.getFieldList().isEmpty()){
			throw validationException;
		}





	}

	public void validazioneFormaleReeTipo1(Tipo1 tipo1, DettaglioAllegato dettaglioAllegato, ExecResults result) throws ValidationManagerException {

		try
		{
			String codiceImpianto = dettaglioAllegato.getCodiceImpianto();

			String dataControllo = dettaglioAllegato.getDataControllo();

			String idTipoAllegato = dettaglioAllegato.getIdTipoAllegato();

			preparaToValidate(tipo1);

			//SEZIONE C. Trattamento dell'acqua
			SigitTTrattH2ODto dettaglioTrattAcqua = this.getDbMgr().cercaSigitTTrattH2OByCodImpianto(ConvertUtil.convertToBigDecimal(codiceImpianto));


			ValidationManagerException validationException = new ValidationManagerException();

			if (GenericUtil.isNullOrEmpty(tipo1.getDenominazTecnico())) {
				validationException.addFieldRequired("appDatareeTipo1.denominazTecnico");
			}

			// B. Documentazione tecnica a corredo
			if (GenericUtil.isNullOrEmpty(tipo1.getPotenzaTermicaNomMax())) {
				validationException.addFieldRequired("appDatareeTipo1.potenzaTermicaNomMax");
			}
			else
			{
				checkNumero(tipo1.getPotenzaTermicaNomMax(), "appDatareeTipo1.potenzaTermicaNomMax", 6, 2, validationException, true);
			}

			if (GenericUtil.isNullOrEmpty(tipo1.getFlgDichiarConform())) {
				validationException.addFieldRequired("appDatareeTipo1.flgDichiarConform");
			}

			if (GenericUtil.isNullOrEmpty(tipo1.getFlgLibImp())) {
				validationException.addFieldRequired("appDatareeTipo1.flgLibImp");
			}

			if (GenericUtil.isNullOrEmpty(tipo1.getFlgLibrettoUso())) {
				validationException.addFieldRequired("appDatareeTipo1.flgLibrettoUso");
			}

			if (GenericUtil.isNullOrEmpty(tipo1.getFlgLibCompl())) {
				validationException.addFieldRequired("appDatareeTipo1.flgLibCompl");
			}

			// VEDI ANALISI se solo se...
			// C. Trattamento dell'acqua
			Integer SI = new Integer(1);

			if (!SI.equals(tipo1.getFlgTrattClimaNonRich()) && isReeFlgTrattClimaNonRichObbligatorio(dettaglioTrattAcqua)) {
//				validationException.addFieldRequired("appDatareeTipo1.flgTrattClimaNonRich");
				validationException.addField("appDatareeTipo1.flgTrattClimaNonRich", new Message(Messages.ERROR_ALLEGATO_REE_VALORE_FLG_SI).getText());
			}

			if (!SI.equals(tipo1.getFlgTrattAcsNonRichiesto()) && isReeFlgTrattAcsNonRichObbligatorio(dettaglioTrattAcqua)) {
				validationException.addField("appDatareeTipo1.flgTrattAcsNonRichiesto", new Message(Messages.ERROR_ALLEGATO_REE_VALORE_FLG_SI).getText());
//				validationException.addFieldRequired("appDatareeTipo1.flgTrattAcsNonRichiesto");
			}

			/*
			if (dettaglioTrattAcqua == null &&
					!ConvertUtil.convertToBooleanAllways(tipo1.getFlgTrattClimaNonRich()))
			{
				validationException.addFieldRequired("appDatareeTipo1.flgTrattClimaNonRich");

			}
			else if (!ConvertUtil.convertToBooleanAllways(dettaglioTrattAcqua.getL23FlgTrattClimaAssente()) &&
					!ConvertUtil.convertToBooleanAllways(dettaglioTrattAcqua.getL23FlgTrattClimaFiltr()) &&
					!ConvertUtil.convertToBooleanAllways(dettaglioTrattAcqua.getL23FlgTrattClimaAddolc()) &&
					!ConvertUtil.convertToBooleanAllways(dettaglioTrattAcqua.getL23FlgTrattClimaChimico()) &&
					!ConvertUtil.convertToBooleanAllways(tipo1.getFlgTrattClimaNonRich()))
			{
				validationException.addFieldRequired("appDatareeTipo1.flgTrattClimaNonRich");
			}

			if (dettaglioTrattAcqua == null &&
					!ConvertUtil.convertToBooleanAllways(tipo1.getFlgTrattAcsNonRichiesto()))
			{
				validationException.addFieldRequired("appDatareeTipo1.flgTrattAcsNonRichiesto");
			}
			else if (!ConvertUtil.convertToBooleanAllways(dettaglioTrattAcqua.getL24FlgTrattAcsAssente()) &&
					!ConvertUtil.convertToBooleanAllways(dettaglioTrattAcqua.getL24FlgTrattAcsFiltr()) &&
					!ConvertUtil.convertToBooleanAllways(dettaglioTrattAcqua.getL24FlgTrattAcsAddolc()) &&
					!ConvertUtil.convertToBooleanAllways(dettaglioTrattAcqua.getL24FlgTrattAcsChimico()) &&
					!ConvertUtil.convertToBooleanAllways(tipo1.getFlgTrattAcsNonRichiesto()))
			{
				validationException.addFieldRequired("appDatareeTipo1.flgTrattAcsNonRichiesto");
			}
			*/

			// D. Controllo dell'impianto

			if (GenericUtil.isNullOrEmpty(tipo1.getFlgLocaleIntIdoneo())) {
				validationException.addFieldRequired("appDatareeTipo1.flgLocaleIntIdoneo");
			}

			if (GenericUtil.isNullOrEmpty(tipo1.getFlgGenExtIdoneo())) {
				validationException.addFieldRequired("appDatareeTipo1.flgGenExtIdoneo");
			}

			if (GenericUtil.isNullOrEmpty(tipo1.getFlgApertureLibere())) {
				validationException.addFieldRequired("appDatareeTipo1.flgApertureLibere");
			}

			if (GenericUtil.isNullOrEmpty(tipo1.getFlgApertureAdeguate())) {
				validationException.addFieldRequired("appDatareeTipo1.flgApertureAdeguate");
			}

			if (GenericUtil.isNullOrEmpty(tipo1.getFlgScaricoIdoneo())) {
				validationException.addFieldRequired("appDatareeTipo1.flgScaricoIdoneo");
			}

			if (GenericUtil.isNullOrEmpty(tipo1.getFlgTempAmbFunz())) {
				validationException.addFieldRequired("appDatareeTipo1.flgTempAmbFunz");
			}

			if (idTipoAllegato.equals(Constants.ALLEGATO_TIPO_1) && GenericUtil.isNullOrEmpty(tipo1.getFlgAssenzaPerdComb())) {
				validationException.addFieldRequired("appDatareeTipo1.flgAssenzaPerdComb");
			}

			if (idTipoAllegato.equals(Constants.ALLEGATO_TIPO_1B) && GenericUtil.isNullOrEmpty(tipo1.getFlgPuliziaCamino())) {
				validationException.addFieldRequired("appDatareeTipo1.flgPuliziaCamino");
			}

			if (GenericUtil.isNullOrEmpty(tipo1.getFlgIdoTenImpInt())) {
				validationException.addFieldRequired("appDatareeTipo1.flgIdoTenImpInt");
			}

			// F. Check-list
			if (GenericUtil.isNullOrEmpty(tipo1.getFlgPuoFunzionare())) {
				validationException.addFieldRequired("appDatareeTipo1.flgPuoFunzionare");
			}

			if (GenericUtil.isNullOrEmpty(tipo1.getInterventoEntro())) {
				validationException.addFieldRequired("appDatareeTipo1.interventoEntro");
			}

			validazioneFormaleConsumiTipo1B(tipo1.getConsumi(), result);

			if(!validationException.getFieldList().isEmpty()){
				throw validationException;
			}

			if (!DateUtil.checkDateOrder(dataControllo, tipo1.getInterventoEntro(), false))
			{
				throw new ValidationManagerException(new Message(Messages.S174));
			}

			checkAsciiStringMaxLength(tipo1.getOsservazioni(), 1000, "appDatareeTipo1.osservazioni", null);
			checkAsciiStringMaxLength(tipo1.getRaccomandazioni(), 1000, "appDatareeTipo1.raccomandazioni", null);
			checkAsciiStringMaxLength(tipo1.getPrescrizioni(), 1000, "appDatareeTipo1.prescrizioni", null);

		} catch (DbManagerException e) {
			throw new ValidationManagerException(new Message(Messages.ERROR_RECUPERO_DB));
		}
	}

	private void validazioneFormaleConsumiTipo1B(ArrayList<Tipo1Consumo> listaConsumi, ExecResults result) {

		if (listaConsumi != null) {
			for (Tipo1Consumo cons : listaConsumi) {
				preparaToValidate(cons);
			}
		}

		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		int riga = 0;

		for (Tipo1Consumo tipo1consumo : listaConsumi){
			riga++;

			if (GenericUtil.isNullOrEmpty(tipo1consumo.getEsercizio())) {
				result.getGlobalErrors().add(creaMsgTabellaEdit(riga,"Esercizio", Messages.ERROR_CAMPO_OBBLIGATORIO));
			}
			else if (GenericUtil.checkIsValidYear(tipo1consumo.getEsercizio())) {
				result.getGlobalErrors().add(creaMsgTabellaEdit(riga,"Esercizio", Messages.ERROR_DEVE_ESSERE_ANNO));
			} else if (currentYear < Integer.parseInt(tipo1consumo.getEsercizio())) {
				result.getGlobalErrors().add(creaMsgTabellaEdit(riga,"Esercizio", Messages.ERROR_ANNO_FUTURO));
			}

			if (GenericUtil.isNotNullOrEmpty(tipo1consumo.getLetturaIniziale()))
			{
				if (!GenericUtil.isDecimalNumber(tipo1consumo.getLetturaIniziale())) {
					result.getGlobalErrors().add(creaMsgTabellaEdit(riga,"Lettura Iniziale", Messages.ERROR_DEVE_ESSERE_NUMERICO));
				}
				else if (!GenericUtil.isNumeroDecimaleValidoMaxDec(tipo1consumo.getLetturaIniziale(), Constants.NUMERO_DECIMALI)) {
					result.getGlobalErrors().add(creaMsgTabellaEdit(riga,"Lettura Iniziale", Messages.ERROR_DECIMALI_NON_CORRETTI));
				}
			}

			if (GenericUtil.isNotNullOrEmpty(tipo1consumo.getLetturaFinale())) {
				if (!GenericUtil.isDecimalNumber(tipo1consumo.getLetturaFinale())) {
					result.getGlobalErrors().add(creaMsgTabellaEdit(riga,"Lettura Finale", Messages.ERROR_DEVE_ESSERE_NUMERICO));
				}
				else if (!GenericUtil.isNumeroDecimaleValidoMaxDec(tipo1consumo.getLetturaFinale(), Constants.NUMERO_DECIMALI)) {
					result.getGlobalErrors().add(creaMsgTabellaEdit(riga,"Lettura Finale", Messages.ERROR_DECIMALI_NON_CORRETTI));
				}
			}

			if (GenericUtil.isNullOrEmpty(tipo1consumo.getConsumoFinale())) {
				result.getGlobalErrors().add(creaMsgTabellaEdit(riga,"Consumo Finale", Messages.ERROR_CAMPO_OBBLIGATORIO));
			}
			else if (!GenericUtil.isDecimalNumber(tipo1consumo.getConsumoFinale())) {
				result.getGlobalErrors().add(creaMsgTabellaEdit(riga,"Consumo Finale", Messages.ERROR_DEVE_ESSERE_NUMERICO));
			} else if (!GenericUtil.isNumeroDecimaleValidoMaxDec(tipo1consumo.getConsumoFinale(), Constants.NUMERO_DECIMALI)) {
				result.getGlobalErrors().add(creaMsgTabellaEdit(riga,"Consumo Finale", Messages.ERROR_DECIMALI_NON_CORRETTI));
			}

			if (GenericUtil.isNullOrEmpty(tipo1consumo.getIdUnitaMisura())) {
				result.getGlobalErrors().add(creaMsgTabellaEdit(riga,"Unit� di misura", Messages.ERROR_CAMPO_OBBLIGATORIO));
			}
		}
	}


	public void validazioneFormaleReeTipo1Dett(Tipo1Dett tipo1Dett, String idTipoAllegato, ExecResults result) throws ValidationManagerException {

		preparaToValidate(tipo1Dett);

			ValidationManagerException validationException = new ValidationManagerException();

			// Questa e' la parte generica
			if (idTipoAllegato.equals(Constants.ALLEGATO_TIPO_1B)) {
				if (!ConvertUtil.convertToBooleanAllways(tipo1Dett.getFlgClimaInverno()) &&
						!ConvertUtil.convertToBooleanAllways(tipo1Dett.getFlgProduzAcs()) &&
						!ConvertUtil.convertToBooleanAllways(tipo1Dett.getFlgCucina())) {
					validationException.addFieldRequired("appDatareeTipo1Dett.flgClimaInverno");
					validationException.addFieldRequired("appDatareeTipo1Dett.flgProduzAcs");
					validationException.addFieldRequired("appDatareeTipo1Dett.flgCucina");
				}

				if (GenericUtil.isNullOrEmpty(tipo1Dett.getFlgUni10389_2())) {
					validationException.addFieldRequired("appDatareeTipo1Dett.flgUni10389_2");
				}
			} else {
				if (!ConvertUtil.convertToBooleanAllways(tipo1Dett.getFlgClimaInverno()) &&
						!ConvertUtil.convertToBooleanAllways(tipo1Dett.getFlgProduzAcs())) {
					validationException.addFieldRequired("appDatareeTipo1Dett.flgClimaInverno");
					validationException.addFieldRequired("appDatareeTipo1Dett.flgProduzAcs");
				}

				if (GenericUtil.isNullOrEmpty(tipo1Dett.getFlgUni10389_1())) {
					validationException.addFieldRequired("appDatareeTipo1Dett.flgUni10389_1");
				}

				if (GenericUtil.isNullOrEmpty(tipo1Dett.getPotTermFocolKw())) {
					validationException.addFieldRequired("appDatareeTipo1Dett.potTermFocolKw");
				}
				else
				{
					checkNumero(tipo1Dett.getPotTermFocolKw(), "appDatareeTipo1Dett.potTermFocolKw", 6, 2, validationException, true);
				}
			}

			if (GenericUtil.isNullOrEmpty(tipo1Dett.getFlgEvacuFumi())) {
				validationException.addFieldRequired("appDatareeTipo1Dett.flgEvacuFumi");
			} else {
				if ("N".equalsIgnoreCase(tipo1Dett.getFlgEvacuFumi()) && GenericUtil.isNullOrEmpty(tipo1Dett.getDeprCanaleFumoPa())) {
					validationException.addFieldRequired("appDatareeTipo1Dett.deprCanaleFumoPa");
				}
			}

//			if (GenericUtil.isNullOrEmpty(tipo1Dett.getDeprCanaleFumoPa())) {
//			validationException.addFieldRequired("appDatareeTipo1Dett.deprCanaleFumoPa");
//			}
//			else
//			{
//			}
			checkNumero(tipo1Dett.getDeprCanaleFumoPa(), "appDatareeTipo1Dett.deprCanaleFumoPa", 5, 2, validationException, false);

			if (GenericUtil.isNullOrEmpty(tipo1Dett.getFlgDisposComando())) {
				validationException.addFieldRequired("appDatareeTipo1Dett.flgDisposComando");
			}

			if (GenericUtil.isNullOrEmpty(tipo1Dett.getFlgDisposSicurezza())) {
				validationException.addFieldRequired("appDatareeTipo1Dett.flgDisposSicurezza");
			}

			if (GenericUtil.isNullOrEmpty(tipo1Dett.getFlgValvolaSicurezza())) {
				validationException.addFieldRequired("appDatareeTipo1Dett.flgValvolaSicurezza");
			}

			if (GenericUtil.isNullOrEmpty(tipo1Dett.getFlgScambiatoreFumi())) {
				validationException.addFieldRequired("appDatareeTipo1Dett.flgScambiatoreFumi");
			}

			if (GenericUtil.isNullOrEmpty(tipo1Dett.getFlgRiflusso())) {
				validationException.addFieldRequired("appDatareeTipo1Dett.flgRiflusso");
			}

			validazioneFormaleConsumiTipo1B(tipo1Dett.getConsumiCombustibile(), result);

			if(!validationException.getFieldList().isEmpty()){
				throw validationException;
			}

			checkStringMaxLenght(tipo1Dett.getAltroRiferimento(), 500, "appDatareeTipo1Dett.altroRiferimento");

	}

	public void validazioneFormaleReeTipo1DettModulo(Tipo1DettModulo tipo1DettModulo, String idCombustibile , String idTipoAllegato, List<SigitVSk4GtDto> compGtAllegatoList) throws ValidationManagerException {

		ArrayList<Integer> combustibiliSaltaControllo = new ArrayList<Integer>(Arrays.asList(5,6,7,9,96,97));
		boolean checkObbligatorieta = !combustibiliSaltaControllo.contains(Integer.valueOf(idCombustibile)) && idTipoAllegato.equals(Constants.ALLEGATO_TIPO_1);
		boolean checkObbligatorietaTipo1B = false;

		if (idTipoAllegato.equals(Constants.ALLEGATO_TIPO_1B) && compGtAllegatoList != null) {

			Date dataObbligatorietaREETipo1B;
			try {
				dataObbligatorietaREETipo1B = ConvertUtil.convertToDate(DATA_CONTROLLO_OBBLIGATORIETA_REE_TIPO_1B);
				for (SigitVSk4GtDto comp : compGtAllegatoList) {
					if (comp.getDataInstall().after(dataObbligatorietaREETipo1B)) {
						checkObbligatorietaTipo1B = true;
						break;
					}

				}
			} catch (Exception e) {
				log.error("Impossibile inizializzare data per controllo obbligatoriet� campi dettaglio REE Tipo 1B");
			}

		}

		preparaToValidate(tipo1DettModulo);

		ValidationManagerException validationException = new ValidationManagerException();

		// Questa e' la parte del modulo
		if (checkObbligatorieta && GenericUtil.isNullOrEmpty(tipo1DettModulo.getTempFumiC())) {
			validationException.addFieldRequired("appDatareeTipo1DettModulo.tempFumiC");
		}
		else
		{
			checkNumero(tipo1DettModulo.getTempFumiC(), "appDatareeTipo1DettModulo.tempFumiC", 4, 2, validationException, false);
		}

		if (checkObbligatorieta && GenericUtil.isNullOrEmpty(tipo1DettModulo.getTempAriaC())) {
			validationException.addFieldRequired("appDatareeTipo1DettModulo.tempAriaC");
		}
		else
		{
			checkNumero(tipo1DettModulo.getTempAriaC(), "appDatareeTipo1DettModulo.tempAriaC", 4, 2, validationException, false);
		}

		if (checkObbligatorieta && GenericUtil.isNullOrEmpty(tipo1DettModulo.getO2Perc())) {
			validationException.addFieldRequired("appDatareeTipo1DettModulo.o2Perc");
		}
		else
		{
			checkNumero(tipo1DettModulo.getO2Perc(), "appDatareeTipo1DettModulo.o2Perc", 3, 2, validationException, true);
		}

		if (checkObbligatorieta && GenericUtil.isNullOrEmpty(tipo1DettModulo.getCo2Perc())) {
			validationException.addFieldRequired("appDatareeTipo1DettModulo.co2Perc");
		}
		else
		{
			checkNumero(tipo1DettModulo.getCo2Perc(), "appDatareeTipo1DettModulo.co2Perc", 3, 2, validationException, true);
		}

		if (checkObbligatorieta && GenericUtil.isNullOrEmpty(tipo1DettModulo.getRendMinLeggePerc())) {
			validationException.addFieldRequired("appDatareeTipo1DettModulo.rendMinLeggePerc");
		}
		else
		{
			checkNumero(tipo1DettModulo.getRendMinLeggePerc(), "appDatareeTipo1DettModulo.rendMinLeggePerc", 3, 2, validationException, true);
		}

		if (idTipoAllegato.equals(Constants.ALLEGATO_TIPO_1)) {
			checkNumero(tipo1DettModulo.getBacharachMin(), "appDatareeTipo1DettModulo.bacharachMin", 4, 2, validationException, true);
			checkNumero(tipo1DettModulo.getBacharachMed(), "appDatareeTipo1DettModulo.bacharachMed", 4, 2, validationException, true);
			checkNumero(tipo1DettModulo.getBacharachMax(), "appDatareeTipo1DettModulo.bacharachMax", 4, 2, validationException, true);

			checkNumero(tipo1DettModulo.getPortataComb(), "appDatareeTipo1DettModulo.portataComb", 4, 2, validationException, true);

			checkNumero(tipo1DettModulo.getCoNoAriaPpm(), "appDatareeTipo1DettModulo.coNoAriaPpm", 3, 2, validationException, true);

			if (checkObbligatorieta && GenericUtil.isNullOrEmpty(tipo1DettModulo.getCoCorrettoPpm())) {
				validationException.addFieldRequired("appDatareeTipo1DettModulo.coCorrettoPpm");
			}
			else
			{
				checkNumero(tipo1DettModulo.getCoCorrettoPpm(), "appDatareeTipo1DettModulo.coCorrettoPpm", 7, 2, validationException, true);
			}

			if (checkObbligatorieta && GenericUtil.isNullOrEmpty(tipo1DettModulo.getNoxPpm())) {
				validationException.addFieldRequired("appDatareeTipo1DettModulo.noxPpm");
			}
			else
			{
				checkNumero(tipo1DettModulo.getNoxPpm(), "appDatareeTipo1DettModulo.noxPpm", 7, 2, validationException, true);
			}

			if (checkObbligatorieta && GenericUtil.isNullOrEmpty(tipo1DettModulo.getRendCombPerc())) {
				validationException.addFieldRequired("appDatareeTipo1DettModulo.rendCombPerc");
			}
			else
			{
				checkNumero(tipo1DettModulo.getRendCombPerc(), "appDatareeTipo1DettModulo.rendCombPerc", 3, 2, validationException, true);
			}

			if (checkObbligatorieta && ((GenericUtil.isNullOrEmpty(tipo1DettModulo.getPortataCombUm()) && GenericUtil.isNotNullOrEmpty(tipo1DettModulo.getPortataComb())) ||
					(GenericUtil.isNotNullOrEmpty(tipo1DettModulo.getPortataCombUm()) && GenericUtil.isNullOrEmpty(tipo1DettModulo.getPortataComb()))))
			{
				validationException = new ValidationManagerException(new Message(Messages.S175));
				validationException.addField("appDatareeTipo1DettModulo.portataCombUm");
				validationException.addField("appDatareeTipo1DettModulo.portataComb");
				throw validationException;

			}
		} else {

			if (checkObbligatorietaTipo1B && GenericUtil.isNullOrEmpty(tipo1DettModulo.getCoCorrettoPpm())) {
				validationException.addFieldRequired("appDatareeTipo1DettModulo.coCorrettoPpm");
			}
			else
			{
				checkNumero(tipo1DettModulo.getCoCorrettoPpm(), "appDatareeTipo1DettModulo.coCorrettoPpm", 7, 2, validationException, true);
			}

			if (GenericUtil.isNullOrEmpty(tipo1DettModulo.getNoxMgNm3())) {
				if (checkObbligatorietaTipo1B && GenericUtil.isNullOrEmpty(tipo1DettModulo.getNoxPpm())) {
					validationException.addFieldRequired("appDatareeTipo1DettModulo.noxPpm");
				} else {
					checkNumero(tipo1DettModulo.getNoxPpm(), "appDatareeTipo1DettModulo.noxPpm", 7, 2, validationException, true);
				}
			} else if (!GenericUtil.isNullOrEmpty(tipo1DettModulo.getNoxPpm())) {
				validationException.addFieldRequired("appDatareeTipo1DettModulo.noxPpm");
			}

			if (GenericUtil.isNullOrEmpty(tipo1DettModulo.getNoxPpm())) {
				if (checkObbligatorietaTipo1B && GenericUtil.isNullOrEmpty(tipo1DettModulo.getNoxMgNm3())) {
					validationException.addFieldRequired("appDatareeTipo1DettModulo.noxMgNm3");
				} else {
					checkNumero(tipo1DettModulo.getNoxMgNm3(), "appDatareeTipo1DettModulo.noxMgNm3", 7, 2, validationException, true);
				}
			} else if (!GenericUtil.isNullOrEmpty(tipo1DettModulo.getNoxMgNm3())) {
				validationException.addFieldRequired("appDatareeTipo1DettModulo.noxMgNm3");
			}

			if (checkObbligatorietaTipo1B && GenericUtil.isNullOrEmpty(tipo1DettModulo.getRendCombPerc())) {
				validationException.addFieldRequired("appDatareeTipo1DettModulo.rendCombPerc");
			}
			else
			{
				checkNumero(tipo1DettModulo.getRendCombPerc(), "appDatareeTipo1DettModulo.rendCombPerc", 3, 2, validationException, true);
			}

			if (checkObbligatorietaTipo1B && GenericUtil.isNullOrEmpty(tipo1DettModulo.getParticolatoPrimarioMgM3())) {
				validationException.addFieldRequired("appDatareeTipo1DettModulo.particolatoPrimarioMgM3");
			} else {
				checkNumero(tipo1DettModulo.getParticolatoPrimarioMgM3(), "appDatareeTipo1DettModulo.particolatoPrimarioMgM3", 4, 2, validationException, true);
			}
		}

		if(!validationException.getFieldList().isEmpty()){
			throw validationException;
		}


	}

	public void validazioneFormaleReeTipo2(Tipo2 tipo2, String codiceImpianto, String dataControllo) throws ValidationManagerException {
		try
		{
			preparaToValidate(tipo2);

			//SEZIONE C. Trattamento dell'acqua
			SigitTTrattH2ODto dettaglioTrattAcqua = this.getDbMgr().cercaSigitTTrattH2OByCodImpianto(ConvertUtil.convertToBigDecimal(codiceImpianto));


			ValidationManagerException validationException = new ValidationManagerException();

			if (GenericUtil.isNullOrEmpty(tipo2.getDenominazTecnico())) {
				validationException.addFieldRequired("appDatareeTipo2.denominazTecnico");
			}

			// B. Documentazione tecnica a corredo
			if (GenericUtil.isNullOrEmpty(tipo2.getPotenzaTermicaNomMax())) {
				validationException.addFieldRequired("appDatareeTipo2.potenzaTermicaNomMax");
			}
			else
			{
				checkNumero(tipo2.getPotenzaTermicaNomMax(), "appDatareeTipo2.potenzaTermicaNomMax", 6, 2, validationException, true);
			}

			if (GenericUtil.isNullOrEmpty(tipo2.getFlgDichiarConform())) {
				validationException.addFieldRequired("appDatareeTipo2.flgDichiarConform");
			}

			if (GenericUtil.isNullOrEmpty(tipo2.getFlgLibImp())) {
				validationException.addFieldRequired("appDatareeTipo2.flgLibImp");
			}

			if (GenericUtil.isNullOrEmpty(tipo2.getFlgLibrettoUso())) {
				validationException.addFieldRequired("appDatareeTipo2.flgLibrettoUso");
			}

			if (GenericUtil.isNullOrEmpty(tipo2.getFlgLibCompl())) {
				validationException.addFieldRequired("appDatareeTipo2.flgLibCompl");
			}

			// VEDI ANALISI se solo se...
			// C. Trattamento dell'acqua

			/*
			if (dettaglioTrattAcqua == null &&
					!ConvertUtil.convertToBooleanAllways(tipo2.getFlgTrattClimaNonRich()))
			{
				validationException.addFieldRequired("appDatareeTipo2.flgTrattClimaNonRich");

			}
			else if (!ConvertUtil.convertToBooleanAllways(dettaglioTrattAcqua.getL23FlgTrattClimaAssente()) &&
					!ConvertUtil.convertToBooleanAllways(dettaglioTrattAcqua.getL23FlgTrattClimaFiltr()) &&
					!ConvertUtil.convertToBooleanAllways(dettaglioTrattAcqua.getL23FlgTrattClimaAddolc()) &&
					!ConvertUtil.convertToBooleanAllways(dettaglioTrattAcqua.getL23FlgTrattClimaChimico()) &&
					!ConvertUtil.convertToBooleanAllways(tipo2.getFlgTrattClimaNonRich()))
			{
				validationException.addFieldRequired("appDatareeTipo2.flgTrattClimaNonRich");
			}
			*/

			Integer SI = new Integer(1);

			if (!SI.equals(tipo2.getFlgTrattClimaNonRich()) && isReeFlgTrattClimaNonRichObbligatorio(dettaglioTrattAcqua)) {
				validationException.addField("appDatareeTipo2.flgTrattClimaNonRich", new Message(Messages.ERROR_ALLEGATO_REE_VALORE_FLG_SI).getText());
			}

//			if (GenericUtil.isNullOrEmpty(tipo2.getFlgTrattClimaNonRich()) &&
//					!ConvertUtil.convertToBooleanAllways(tipo2.getFlgTrattClimaNonRich()) &&
//					!ConvertUtil.convertToBooleanAllways(dettaglioTrattAcqua.getL23FlgTrattClimaAssente()) &&
//					!ConvertUtil.convertToBooleanAllways(dettaglioTrattAcqua.getL23FlgTrattClimaFiltr()) &&
//					!ConvertUtil.convertToBooleanAllways(dettaglioTrattAcqua.getL23FlgTrattClimaAddolc()) &&
//					!ConvertUtil.convertToBooleanAllways(dettaglioTrattAcqua.getL23FlgTrattClimaChimico()))
//			{
//				validationException.addFieldRequired("appDatareeTipo2.flgTrattClimaNonRich");
//			}


			// D. Controllo dell'impianto

			if (GenericUtil.isNullOrEmpty(tipo2.getFlgLocaleIntIdoneo())) {
				validationException.addFieldRequired("appDatareeTipo2.flgLocaleIntIdoneo");
			}

			if (GenericUtil.isNullOrEmpty(tipo2.getFlgApertureLibere())) {
				validationException.addFieldRequired("appDatareeTipo2.flgApertureLibere");
			}

			if (GenericUtil.isNullOrEmpty(tipo2.getFlgApertureAdeguate())) {
				validationException.addFieldRequired("appDatareeTipo2.flgApertureAdeguate");
			}

			if (GenericUtil.isNullOrEmpty(tipo2.getFlgLineaElettIdonea())) {
				validationException.addFieldRequired("appDatareeTipo2.flgLineaElettIdonea");
			}

			if (GenericUtil.isNullOrEmpty(tipo2.getFlgCoibentIdonea())) {
				validationException.addFieldRequired("appDatareeTipo2.flgCoibentIdonea");
			}

			// F. Check-list
			if (GenericUtil.isNullOrEmpty(tipo2.getFlgPuoFunzionare())) {
				validationException.addFieldRequired("appDatareeTipo2.flgPuoFunzionare");
			}

			if (GenericUtil.isNullOrEmpty(tipo2.getInterventoEntro())) {
				validationException.addFieldRequired("appDatareeTipo2.interventoEntro");
			}


			if(!validationException.getFieldList().isEmpty()){
				throw validationException;
			}

			if (!DateUtil.checkDateOrder(dataControllo, tipo2.getInterventoEntro(), false))
			{
				throw new ValidationManagerException(new Message(Messages.S174));
			}

			checkAsciiStringMaxLength(tipo2.getOsservazioni(), 1000, "appDatareeTipo2.osservazioni", null);
			checkAsciiStringMaxLength(tipo2.getRaccomandazioni(), 1000, "appDatareeTipo2.raccomandazioni", null);
			checkAsciiStringMaxLength(tipo2.getPrescrizioni(), 1000, "appDatareeTipo2.prescrizioni", null);

		} catch (DbManagerException e) {
			throw new ValidationManagerException(new Message(Messages.ERROR_RECUPERO_DB));
		}
	}

	public void validazioneFormaleReeTipo2Dett(Tipo2Dett tipo2Dett) throws ValidationManagerException {

		preparaToValidate(tipo2Dett);

		ValidationManagerException validationException = new ValidationManagerException();

		if (GenericUtil.isNullOrEmpty(tipo2Dett.getFlgModProva())) {
			validationException.addFieldRequired("appDatareeTipo2Dett.flgModProva");
		}

		if (GenericUtil.isNullOrEmpty(tipo2Dett.getFlgPerditaGas())) {
			validationException.addFieldRequired("appDatareeTipo2Dett.flgPerditaGas");
		}

		if (GenericUtil.isNullOrEmpty(tipo2Dett.getFlgLeakDirector())) {
			validationException.addFieldRequired("appDatareeTipo2Dett.flgLeakDirector");
		}

		if (GenericUtil.isNullOrEmpty(tipo2Dett.getFlgParamTermodinam())) {
			validationException.addFieldRequired("appDatareeTipo2Dett.flgParamTermodinam");
		}

		if (GenericUtil.isNullOrEmpty(tipo2Dett.getFlgIncrostazioni())) {
			validationException.addFieldRequired("appDatareeTipo2Dett.flgIncrostazioni");
		}

		if(!validationException.getFieldList().isEmpty()){
			throw validationException;
		}

	}

	public void validazioneFormaleReeTipo2DettCircuito(Tipo2DettCircuito tipo2DettCircuito, String dataControllo) throws ValidationManagerException {

		preparaToValidate(tipo2DettCircuito);

		ValidationManagerException validationException = new ValidationManagerException();

		// Questa e' la parte del circuito
		if (GenericUtil.isNullOrEmpty(tipo2DettCircuito.getSurrisc())) {
			validationException.addFieldRequired("appDatareeTipo2DettCircuito.surrisc");
		}
		else
		{
			checkNumero(tipo2DettCircuito.getSurrisc(), "appDatareeTipo2DettCircuito.surrisc", 5, 2, validationException, false);
		}

		if (GenericUtil.isNullOrEmpty(tipo2DettCircuito.getSottoraffredd())) {
			validationException.addFieldRequired("appDatareeTipo2DettCircuito.sottoraffredd");
		}
		else
		{
			checkNumero(tipo2DettCircuito.getSottoraffredd(), "appDatareeTipo2DettCircuito.sottoraffredd", 5, 2, validationException, false);
		}



		if (GenericUtil.isNullOrEmpty(tipo2DettCircuito.getCondensazione())) {
			validationException.addFieldRequired("appDatareeTipo2DettCircuito.condensazione");
		}
		else
		{
			checkNumero(tipo2DettCircuito.getCondensazione(), "appDatareeTipo2DettCircuito.condensazione", 5, 2, validationException, false);
		}

		if (GenericUtil.isNullOrEmpty(tipo2DettCircuito.getEvaporazione())) {
			validationException.addFieldRequired("appDatareeTipo2DettCircuito.evaporazione");
		}
		else
		{
			checkNumero(tipo2DettCircuito.getEvaporazione(), "appDatareeTipo2DettCircuito.evaporazione", 5, 2, validationException, false);
		}




		if (GenericUtil.isNullOrEmpty(tipo2DettCircuito.getInLatoEst())) {
			validationException.addFieldRequired("appDatareeTipo2DettCircuito.inLatoEst");
		}
		else
		{
			checkNumero(tipo2DettCircuito.getInLatoEst(), "appDatareeTipo2DettCircuito.inLatoEst", 5, 2, validationException, false);
		}

		if (GenericUtil.isNullOrEmpty(tipo2DettCircuito.getOutLatoEst())) {
			validationException.addFieldRequired("appDatareeTipo2DettCircuito.outLatoEst");
		}
		else
		{
			checkNumero(tipo2DettCircuito.getOutLatoEst(), "appDatareeTipo2DettCircuito.outLatoEst", 5, 2, validationException, false);
		}

		if (GenericUtil.isNullOrEmpty(tipo2DettCircuito.getInLatoUtenze())) {
			validationException.addFieldRequired("appDatareeTipo2DettCircuito.inLatoUtenze");
		}
		else
		{
			checkNumero(tipo2DettCircuito.getInLatoUtenze(), "appDatareeTipo2DettCircuito.inLatoUtenze", 5, 2, validationException, false);
		}

		if (GenericUtil.isNullOrEmpty(tipo2DettCircuito.getOutLatoUtenze())) {
			validationException.addFieldRequired("appDatareeTipo2DettCircuito.outLatoUtenze");
		}
		else
		{
			checkNumero(tipo2DettCircuito.getOutLatoUtenze(), "appDatareeTipo2DettCircuito.outLatoUtenze", 5, 2, validationException, false);
		}

		checkNumero(tipo2DettCircuito.getTorreOutFluido(), "appDatareeTipo2DettCircuito.torreOutFluido", 5, 2, validationException, false);
		checkNumero(tipo2DettCircuito.getTorreBulboUmido(), "appDatareeTipo2DettCircuito.torreBulboUmido", 5, 2, validationException, false);
		checkNumero(tipo2DettCircuito.getScambiatoreInExt(), "appDatareeTipo2DettCircuito.scambiatoreInExt", 5, 2, validationException, false);

		checkNumero(tipo2DettCircuito.getScambiatoreOutExt(), "appDatareeTipo2DettCircuito.scambiatoreOutExt", 5, 2, validationException, false);
		checkNumero(tipo2DettCircuito.getScambiatoreInMacchina(), "appDatareeTipo2DettCircuito.scambiatoreInMacchina", 5, 2, validationException, false);
		checkNumero(tipo2DettCircuito.getScambiatoreOutMacchina(), "appDatareeTipo2DettCircuito.scambiatoreOutMacchina", 5, 2, validationException, false);
		checkNumero(tipo2DettCircuito.getPotenzaAssorbitaKw(), "appDatareeTipo2DettCircuito.potenzaAssorbitaKw", 5, 2, validationException, true);

		if (GenericUtil.isNullOrEmpty(tipo2DettCircuito.getFlgVerificaSuperata())) {
			validationException.addFieldRequired("appDatareeTipo2DettCircuito.flgVerificaSuperata");
		}
		else if (!tipo2DettCircuito.getFlgVerificaSuperata() && GenericUtil.isNullOrEmpty(tipo2DettCircuito.getDataRipristino()))
		{
			validationException.addFieldRequired("appDatareeTipo2DettCircuito.dataRipristino");
		}

		if (!GenericUtil.isNullOrEmpty(tipo2DettCircuito.getDataRipristino()) && !DateUtil.checkDateOrder(dataControllo, tipo2DettCircuito.getDataRipristino(), false))
		{
			throw new ValidationManagerException(new Message(Messages.S177));
		}


		if (tipo2DettCircuito.getFlgVerificaSuperata() != null && !tipo2DettCircuito.getFlgVerificaSuperata())
		{
			if (GenericUtil.isNullOrEmpty(tipo2DettCircuito.getDataRipristino())) {
				validationException.addFieldRequired("appDatareeTipo2DettCircuito.dataRipristino");
			} else if (!DateUtil.checkDateOrder(dataControllo, tipo2DettCircuito.getDataRipristino(), false)){
				throw new ValidationManagerException(new Message(Messages.S177));
			}
		}

		if(!validationException.getFieldList().isEmpty()){
			throw validationException;
		}

	}

	public void validazioneFormaleReeTipo3(Tipo3 tipo3, String codiceImpianto, String dataControllo) throws ValidationManagerException {
		preparaToValidate(tipo3);
		ValidationManagerException validationException = new ValidationManagerException();

		if (GenericUtil.isNullOrEmpty(tipo3.getDenominazTecnico())) {
			validationException.addFieldRequired("appDatareeTipo3.denominazTecnico");
		}

		Integer SI = new Integer(1);

		// B. Documentazione tecnica a corredo
		if (GenericUtil.isNullOrEmpty(tipo3.getPotenzaTermicaNomMax())) {
			validationException.addFieldRequired("appDatareeTipo3.potenzaTermicaNomMax");
		}
		else
		{
			checkNumero(tipo3.getPotenzaTermicaNomMax(), "appDatareeTipo3.potenzaTermicaNomMax", 6, 2, validationException, true);
		}

		if (GenericUtil.isNullOrEmpty(tipo3.getFlgDichiarConform())) {
			validationException.addFieldRequired("appDatareeTipo3.flgDichiarConform");
		}

		if (GenericUtil.isNullOrEmpty(tipo3.getFlgLibImp())) {
			validationException.addFieldRequired("appDatareeTipo3.flgLibImp");
		}

		if (GenericUtil.isNullOrEmpty(tipo3.getFlgLibrettoUso())) {
			validationException.addFieldRequired("appDatareeTipo3.flgLibrettoUso");
		}

		if (GenericUtil.isNullOrEmpty(tipo3.getFlgLibCompl())) {
			validationException.addFieldRequired("appDatareeTipo3.flgLibCompl");
		}

		try {
			SigitTTrattH2ODto dettaglioTrattAcqua = this.getDbMgr().cercaSigitTTrattH2OByCodImpianto(ConvertUtil.convertToBigDecimal(codiceImpianto));
			//se il valore � non richiesto allora il radio button deve essere impostato a si

			if (!SI.equals(tipo3.getFlgTrattClimaNonRich()) && isReeFlgTrattClimaNonRichObbligatorio(dettaglioTrattAcqua)) {
//				validationException.addFieldRequired("appDatareeTipo3.flgTrattClimaNonRich");
				validationException.addField("appDatareeTipo3.flgTrattClimaNonRich", new Message(Messages.ERROR_ALLEGATO_REE_VALORE_FLG_SI).getText());
			}

			if (!SI.equals(tipo3.getFlgTrattAcsNonRichiesto()) && isReeFlgTrattAcsNonRichObbligatorio(dettaglioTrattAcqua)) {
				validationException.addField("appDatareeTipo3.flgTrattAcsNonRichiesto", new Message(Messages.ERROR_ALLEGATO_REE_VALORE_FLG_SI).getText());
//				validationException.addFieldRequired("appDatareeTipo3.flgTrattAcsNonRichiesto");
			}

		} catch (DbManagerException e) {
			throw new ValidationManagerException(new Message(Messages.ERROR_RECUPERO_DB));
		}

		if (GenericUtil.isNullOrEmpty(tipo3.getFlgLocaleIntIdoneo())) {
			validationException.addFieldRequired("appDatareeTipo3.flgLocaleIntIdoneo");
		}

		if (GenericUtil.isNullOrEmpty(tipo3.getFlgLineaElettIdonea())) {
			validationException.addFieldRequired("appDatareeTipo3.flgLineaElettIdonea");
		}

		if (GenericUtil.isNullOrEmpty(tipo3.getFlgCoibentIdonea())) {
			validationException.addFieldRequired("appDatareeTipo3.flgCoibentIdonea");
		}

		if (GenericUtil.isNullOrEmpty(tipo3.getFlgAssenzaPerdite())) {
			validationException.addFieldRequired("appDatareeTipo3.flgAssenzaPerdite");
		}

		if (GenericUtil.isNullOrEmpty(tipo3.getFlgPuoFunzionare())) {
			validationException.addFieldRequired("appDatareeTipo3.flgPuoFunzionare");
		}

		if (GenericUtil.isNullOrEmpty(tipo3.getInterventoEntro())) {
			validationException.addFieldRequired("appDatareeTipo3.interventoEntro");
		} else if(!DateUtil.checkDateOrder(dataControllo, tipo3.getInterventoEntro(), false)){
			throw new ValidationManagerException(new Message(Messages.S174));
		}

		checkAsciiStringMaxLength(tipo3.getOsservazioni(), 1000, "appDatareeTipo3.osservazioni", null);
		checkAsciiStringMaxLength(tipo3.getRaccomandazioni(), 1000, "appDatareeTipo3.raccomandazioni", null);
		checkAsciiStringMaxLength(tipo3.getPrescrizioni(), 1000, "appDatareeTipo3.prescrizioni", null);

		if(!validationException.getFieldList().isEmpty()){
			throw validationException;
		}
	}


	private boolean isReeFlgTrattClimaNonRichObbligatorio(SigitTTrattH2ODto dettaglioTrattAcqua) {
		return (dettaglioTrattAcqua == null || (!ConvertUtil.convertToBooleanAllways(dettaglioTrattAcqua.getL23FlgTrattClimaAssente())
				&& !ConvertUtil.convertToBooleanAllways(dettaglioTrattAcqua.getL23FlgTrattClimaFiltr())
				&& !ConvertUtil.convertToBooleanAllways(dettaglioTrattAcqua.getL23FlgTrattClimaAddolc())
				&& !ConvertUtil.convertToBooleanAllways(dettaglioTrattAcqua.getL23FlgTrattClimaChimico())));

	}

	private boolean isReeFlgTrattAcsNonRichObbligatorio(SigitTTrattH2ODto dettaglioTrattAcqua) {
		return (dettaglioTrattAcqua == null || (!ConvertUtil.convertToBooleanAllways(dettaglioTrattAcqua.getL24FlgTrattAcsAssente())
				&& !ConvertUtil.convertToBooleanAllways(dettaglioTrattAcqua.getL24FlgTrattAcsFiltr())
				&& !ConvertUtil.convertToBooleanAllways(dettaglioTrattAcqua.getL24FlgTrattAcsAddolc())
				&& !ConvertUtil.convertToBooleanAllways(dettaglioTrattAcqua.getL24FlgTrattAcsChimico())));

	}


	public void validazioneFormaleReeTipo4(Tipo4 tipo4, String codiceImpianto, String dataControllo) throws ValidationManagerException {

		try
		{
			preparaToValidate(tipo4);

			//SEZIONE C. Trattamento dell'acqua
			SigitTTrattH2ODto dettaglioTrattAcqua = this.getDbMgr().cercaSigitTTrattH2OByCodImpianto(ConvertUtil.convertToBigDecimal(codiceImpianto));


			ValidationManagerException validationException = new ValidationManagerException();

			if (GenericUtil.isNullOrEmpty(tipo4.getDenominazTecnico())) {
				validationException.addFieldRequired("appDatareeTipo4.denominazTecnico");
			}

			// B. Documentazione tecnica a corredo
			if (GenericUtil.isNullOrEmpty(tipo4.getPotenzaTermicaNomMax())) {
				validationException.addFieldRequired("appDatareeTipo4.potenzaTermicaNomMax");
			}
			else
			{
				checkNumero(tipo4.getPotenzaTermicaNomMax(), "appDatareeTipo4.potenzaTermicaNomMax", 6, 2, validationException, true);
			}

			if (GenericUtil.isNullOrEmpty(tipo4.getFlgDichiarConform())) {
				validationException.addFieldRequired("appDatareeTipo4.flgDichiarConform");
			}

			if (GenericUtil.isNullOrEmpty(tipo4.getFlgLibImp())) {
				validationException.addFieldRequired("appDatareeTipo4.flgLibImp");
			}

			if (GenericUtil.isNullOrEmpty(tipo4.getFlgLibrettoUso())) {
				validationException.addFieldRequired("appDatareeTipo4.flgLibrettoUso");
			}

			if (GenericUtil.isNullOrEmpty(tipo4.getFlgLibCompl())) {
				validationException.addFieldRequired("appDatareeTipo4.flgLibCompl");
			}

			// VEDI ANALISI se solo se...
			// C. Trattamento dell'acqua
			Integer SI = new Integer(1);

			//se il valore � non richiesto allora il radio button deve essere impostato a si
			if (!SI.equals(tipo4.getFlgTrattClimaNonRich()) && isReeFlgTrattClimaNonRichObbligatorio(dettaglioTrattAcqua)) {
//				validationException.addFieldRequired("appDatareeTipo3.flgTrattClimaNonRich");
				validationException.addField("appDatareeTipo4.flgTrattClimaNonRich", new Message(Messages.ERROR_ALLEGATO_REE_VALORE_FLG_SI).getText());
			}

			/*
			if (GenericUtil.isNullOrEmpty(tipo4.getFlgTrattClimaNonRich()) &&
					!ConvertUtil.convertToBooleanAllways(ConvertUtil.convertToBigDecimal(tipo4.getFlgTrattClimaNonRich())) &&
					!ConvertUtil.convertToBooleanAllways(dettaglioTrattAcqua.getL23FlgTrattClimaAssente()) &&
					!ConvertUtil.convertToBooleanAllways(dettaglioTrattAcqua.getL23FlgTrattClimaFiltr()) &&
					!ConvertUtil.convertToBooleanAllways(dettaglioTrattAcqua.getL23FlgTrattClimaAddolc()) &&
					!ConvertUtil.convertToBooleanAllways(dettaglioTrattAcqua.getL23FlgTrattClimaChimico()))
			{
				validationException.addFieldRequired("appDatareeTipo4.flgTrattClimaNonRich");
			}
			*/

			// D. Controllo dell'impianto

			if (GenericUtil.isNullOrEmpty(tipo4.getFlgLuogoIdoneo())) {
				validationException.addFieldRequired("appDatareeTipo4.flgLuogoIdoneo");
			}

			if (GenericUtil.isNullOrEmpty(tipo4.getFlgVentilazAdeg())) {
				validationException.addFieldRequired("appDatareeTipo4.flgVentilazAdeg");
			}

			if (GenericUtil.isNullOrEmpty(tipo4.getFlgVentilazLibera())) {
				validationException.addFieldRequired("appDatareeTipo4.flgVentilazLibera");
			}

			if (GenericUtil.isNullOrEmpty(tipo4.getFlgLineaElettIdonea())) {
				validationException.addFieldRequired("appDatareeTipo4.flgLineaElettIdonea");
			}

			if (GenericUtil.isNullOrEmpty(tipo4.getFlgCaminoIdoneo())) {
				validationException.addFieldRequired("appDatareeTipo4.flgCaminoIdoneo");
			}

			if (GenericUtil.isNullOrEmpty(tipo4.getFlgCapsulaIdonea())) {
				validationException.addFieldRequired("appDatareeTipo4.flgCapsulaIdonea");
			}

			if (GenericUtil.isNullOrEmpty(tipo4.getFlgCircIdrIdoneo())) {
				validationException.addFieldRequired("appDatareeTipo4.flgCircIdrIdoneo");
			}

			if (GenericUtil.isNullOrEmpty(tipo4.getFlgCircOlioIdoneo())) {
				validationException.addFieldRequired("appDatareeTipo4.flgCircOlioIdoneo");
			}

			if (GenericUtil.isNullOrEmpty(tipo4.getFlgCircCombIdoneo())) {
				validationException.addFieldRequired("appDatareeTipo4.flgCircCombIdoneo");
			}

			if (GenericUtil.isNullOrEmpty(tipo4.getFlgFunzScambIdonea())) {
				validationException.addFieldRequired("appDatareeTipo4.flgFunzScambIdonea");
			}


			// F. Check-list
			if (GenericUtil.isNullOrEmpty(tipo4.getFlgPuoFunzionare())) {
				validationException.addFieldRequired("appDatareeTipo4.flgPuoFunzionare");
			}

			if (GenericUtil.isNullOrEmpty(tipo4.getInterventoEntro())) {
				validationException.addFieldRequired("appDatareeTipo4.interventoEntro");
			}


			if(!validationException.getFieldList().isEmpty()){
				throw validationException;
			}

			if (!DateUtil.checkDateOrder(dataControllo, tipo4.getInterventoEntro(), false))
			{
				throw new ValidationManagerException(new Message(Messages.S174));
			}

			checkAsciiStringMaxLength(tipo4.getOsservazioni(), 1000, "appDatareeTipo4.osservazioni", null);
			checkAsciiStringMaxLength(tipo4.getRaccomandazioni(), 1000, "appDatareeTipo4.raccomandazioni", null);
			checkAsciiStringMaxLength(tipo4.getPrescrizioni(), 1000, "appDatareeTipo4.prescrizioni", null);

		} catch (DbManagerException e) {
			throw new ValidationManagerException(new Message(Messages.ERROR_RECUPERO_DB));
		}
	}

	public void validazioneFormaleReeTipo3Dett(Tipo3Dett tipo3Dett) throws ValidationManagerException {
		preparaToValidate(tipo3Dett);

		ValidationManagerException validationException = new ValidationManagerException();

		if (GenericUtil.isNullOrEmpty(tipo3Dett.getIdFluido())) {
			validationException.addFieldRequired("appDatareeTipo3Dett.idFluido");
		}

		if (GenericUtil.isNullOrEmpty(tipo3Dett.getFluidoAlimentazione())) {
			validationException.addFieldRequired("appDatareeTipo3Dett.fluidoAlimentazione");
		}

		if (!tipo3Dett.getFlgClimaInverno() && !tipo3Dett.getFlgProduzAcs()) {
			//almeno uno tra clima e acs deve essere valorizzato
			validationException.setMsg(new Message(Messages.S711, "tra Climatizzazione invernale e Produzione acs"));
			validationException.addField("appDatareeTipo3Dett.flgClimaInverno");
			validationException.addField("appDatareeTipo3Dett.flgProduzAcs");
		}

		if (GenericUtil.isNullOrEmpty(tipo3Dett.getFlgPotenzaCompatibile())) {
			validationException.addFieldRequired("appDatareeTipo3Dett.flgPotenzaCompatibile");
		}

		if (GenericUtil.isNullOrEmpty(tipo3Dett.getFlgCoibIdonea())) {
			validationException.addFieldRequired("appDatareeTipo3Dett.flgCoibIdonea");
		}

		if (GenericUtil.isNullOrEmpty(tipo3Dett.getFlgDispFunzionanti())) {
			validationException.addFieldRequired("appDatareeTipo3Dett.flgDispFunzionanti");
		}

		if (GenericUtil.isNullOrEmpty(tipo3Dett.getTempExt())) {
			validationException.addFieldRequired("appDatareeTipo3Dett.tempExt");
		} else {
			checkNumero(tipo3Dett.getTempExt(), "appDatareeTipo3Dett.tempExt", 4, 2, validationException, false);
		}

		if (GenericUtil.isNullOrEmpty(tipo3Dett.getTempMandPrimario())) {
			validationException.addFieldRequired("appDatareeTipo3Dett.tempMandPrimario");
		} else {
			checkNumero(tipo3Dett.getTempMandPrimario(), "appDatareeTipo3Dett.tempMandPrimario", 4, 2, validationException, false);
		}

		if (GenericUtil.isNullOrEmpty(tipo3Dett.getTempRitorPrimario())) {
			validationException.addFieldRequired("appDatareeTipo3Dett.tempRitorPrimario");
		} else {
			checkNumero(tipo3Dett.getTempRitorPrimario(), "appDatareeTipo3Dett.tempRitorPrimario", 4, 2, validationException, false);
		}

		if (GenericUtil.isNullOrEmpty(tipo3Dett.getPotenzaTermKw())) {
			validationException.addFieldRequired("appDatareeTipo3Dett.potenzaTermKw");
		} else {
			checkNumero(tipo3Dett.getPotenzaTermKw(), "appDatareeTipo3Dett.potenzaTermKw", 4, 2, validationException, true);
		}

		if (GenericUtil.isNullOrEmpty(tipo3Dett.getPortFluidoM3())) {
			validationException.addFieldRequired("appDatareeTipo3Dett.portFluidoM3");
		} else {
			checkNumero(tipo3Dett.getPortFluidoM3(), "appDatareeTipo3Dett.portFluidoM3", 4, 2, validationException, true);
		}

		if (GenericUtil.isNullOrEmpty(tipo3Dett.getTempMandSecondario())) {
			validationException.addFieldRequired("appDatareeTipo3Dett.tempMandSecondario");
		} else {
			checkNumero(tipo3Dett.getTempMandSecondario(), "appDatareeTipo3Dett.tempMandSecondario", 4, 2, validationException, false);
		}

		if (GenericUtil.isNullOrEmpty(tipo3Dett.getTempRitSecondario())) {
			validationException.addFieldRequired("appDatareeTipo3Dett.tempRitSecondario");
		} else {
			checkNumero(tipo3Dett.getTempRitSecondario(), "appDatareeTipo3Dett.tempRitSecondario", 4, 2, validationException, false);
		}

		if(!validationException.getFieldList().isEmpty()){
			throw validationException;
		}

	}

	public void validazioneFormaleReeTipo4Dett(Tipo4Dett tipo4Dett) throws ValidationManagerException {

		preparaToValidate(tipo4Dett);

		ValidationManagerException validationException = new ValidationManagerException();

		if (GenericUtil.isNullOrEmpty(tipo4Dett.getIdFluido())) {
			validationException.addFieldRequired("appDatareeTipo4Dett.idFluido");
		}

		checkNumero(tipo4Dett.getPotenzaAssorbCombKw(), "appDatareeTipo4Dett.potenzaAssorbCombKw", 6, 2, validationException, true);


		checkNumero(tipo4Dett.getPotenzaTermBypassKw(), "appDatareeTipo4Dett.potenzaTermBypassKw", 6, 2, validationException, true);



		// Prova fumi

		if (GenericUtil.isNullOrEmpty(tipo4Dett.getTempAriaC())) {
			validationException.addFieldRequired("appDatareeTipo4Dett.tempAriaC");
		}
		else
		{
			checkNumero(tipo4Dett.getTempAriaC(), "appDatareeTipo4Dett.tempAriaC", 4, 2, validationException, false);
		}

		if (GenericUtil.isNullOrEmpty(tipo4Dett.getTempH2oOutC())) {
			validationException.addFieldRequired("appDatareeTipo4Dett.tempH2oOutC");
		}
		else
		{
			checkNumero(tipo4Dett.getTempH2oOutC(), "appDatareeTipo4Dett.tempH2oOutC", 4, 2, validationException, false);
		}

		if (GenericUtil.isNullOrEmpty(tipo4Dett.getTempH2oInC())) {
			validationException.addFieldRequired("appDatareeTipo4Dett.tempH2oInC");
		}
		else
		{
			checkNumero(tipo4Dett.getTempH2oInC(), "appDatareeTipo4Dett.tempH2oInC", 4, 2, validationException, false);
		}

		if (GenericUtil.isNullOrEmpty(tipo4Dett.getPotenzaMorsettiKw())) {
			validationException.addFieldRequired("appDatareeTipo4Dett.potenzaMorsettiKw");
		}
		else
		{
			checkNumero(tipo4Dett.getPotenzaMorsettiKw(), "appDatareeTipo4Dett.potenzaMorsettiKw", 4, 2, validationException, true);
		}

		if (GenericUtil.isNullOrEmpty(tipo4Dett.getTempH2oMotoreC())) {
			validationException.addFieldRequired("appDatareeTipo4Dett.tempH2oMotoreC");
		}
		else
		{
			checkNumero(tipo4Dett.getTempH2oMotoreC(), "appDatareeTipo4Dett.tempH2oMotoreC", 4, 2, validationException, false);
		}

		if (GenericUtil.isNullOrEmpty(tipo4Dett.getTempFumiValleC())) {
			validationException.addFieldRequired("appDatareeTipo4Dett.tempFumiValleC");
		}
		else
		{
			checkNumero(tipo4Dett.getTempFumiValleC(), "appDatareeTipo4Dett.tempFumiValleC", 4, 2, validationException, false);
		}

		if (GenericUtil.isNullOrEmpty(tipo4Dett.getTempFumiMonteC())) {
			validationException.addFieldRequired("appDatareeTipo4Dett.tempFumiMonteC");
		}
		else
		{
			checkNumero(tipo4Dett.getTempFumiMonteC(), "appDatareeTipo4Dett.tempFumiMonteC", 4, 2, validationException, false);
		}


		checkNumero(tipo4Dett.getSovrafreqSogliaHzMin(), "appDatareeTipo4Dett.sovrafreqSogliaHzMin", 3, 2, validationException, true);
		checkNumero(tipo4Dett.getSovrafreqSogliaHzMed(), "appDatareeTipo4Dett.sovrafreqSogliaHzMed", 3, 2, validationException, true);
		checkNumero(tipo4Dett.getSovrafreqSogliaHzMax(), "appDatareeTipo4Dett.sovrafreqSogliaHzMax", 3, 2, validationException, true);

		checkNumero(tipo4Dett.getSovrafreqTempoSMin(), "appDatareeTipo4Dett.sovrafreqTempoSMin", 3, 2, validationException, true);
		checkNumero(tipo4Dett.getSovrafreqTempoSMed(), "appDatareeTipo4Dett.sovrafreqTempoSMed", 3, 2, validationException, true);
		checkNumero(tipo4Dett.getSovrafreqTempoSMax(), "appDatareeTipo4Dett.sovrafreqTempoSMax", 3, 2, validationException, true);

		checkNumero(tipo4Dett.getSottofreqSogliaHzMin(), "appDatareeTipo4Dett.sottofreqSogliaHzMin", 3, 2, validationException, true);
		checkNumero(tipo4Dett.getSottofreqSogliaHzMed(), "appDatareeTipo4Dett.sottofreqSogliaHzMed", 3, 2, validationException, true);
		checkNumero(tipo4Dett.getSottofreqSogliaHzMax(), "appDatareeTipo4Dett.sottofreqSogliaHzMax", 3, 2, validationException, true);

		checkNumero(tipo4Dett.getSottofreqTempoSMin(), "appDatareeTipo4Dett.sottofreqTempoSMin", 3, 2, validationException, true);
		checkNumero(tipo4Dett.getSottofreqTempoSMed(), "appDatareeTipo4Dett.sottofreqTempoSMed", 3, 2, validationException, true);
		checkNumero(tipo4Dett.getSottofreqTempoSMax(), "appDatareeTipo4Dett.sottofreqTempoSMax", 3, 2, validationException, true);

		checkNumero(tipo4Dett.getSovratensSogliaVMin(), "appDatareeTipo4Dett.sovratensSogliaVMin", 3, 2, validationException, true);
		checkNumero(tipo4Dett.getSovratensSogliaVMed(), "appDatareeTipo4Dett.sovratensSogliaVMed", 3, 2, validationException, true);
		checkNumero(tipo4Dett.getSovratensSogliaVMax(), "appDatareeTipo4Dett.sovratensSogliaVMax", 3, 2, validationException, true);

		checkNumero(tipo4Dett.getSovratensTempoSMin(), "appDatareeTipo4Dett.sovratensTempoSMin", 3, 2, validationException, true);
		checkNumero(tipo4Dett.getSovratensTempoSMed(), "appDatareeTipo4Dett.sovratensTempoSMed", 3, 2, validationException, true);
		checkNumero(tipo4Dett.getSovratensTempoSMax(), "appDatareeTipo4Dett.sovratensTempoSMax", 3, 2, validationException, true);

		checkNumero(tipo4Dett.getSottotensSogliaVMin(), "appDatareeTipo4Dett.sottotensSogliaVMin", 3, 2, validationException, true);
		checkNumero(tipo4Dett.getSottotensSogliaVMed(), "appDatareeTipo4Dett.sottotensSogliaVMed", 3, 2, validationException, true);
		checkNumero(tipo4Dett.getSottotensSogliaVMax(), "appDatareeTipo4Dett.sottotensSogliaVMax", 3, 2, validationException, true);

		checkNumero(tipo4Dett.getSottotensTempoSMin(), "appDatareeTipo4Dett.sottotensTempoSMin", 3, 2, validationException, true);
		checkNumero(tipo4Dett.getSottotensTempoSMed(), "appDatareeTipo4Dett.sottotensTempoSMed", 3, 2, validationException, true);
		checkNumero(tipo4Dett.getSottotensTempoSMax(), "appDatareeTipo4Dett.sottotensTempoSMax", 3, 2, validationException, true);

		if(!validationException.getFieldList().isEmpty()){
			throw validationException;
		}
	}

	/**
	 * Controllo che l'allegato sia inviabile
	  * @param String idAllegato
	  * @throws ValidationManagerException non tutto il lirbetto � stato verificaco
	 */
	public void isAllegatoInviabile(String idAllegato) throws ValidationManagerException {
		String errori = null;
		try {

			String erroriSez = null;

			SigitTAllegatoDto allegato = getDbMgr().cercaSigitTAllegatoById(ConvertUtil.convertToBigDecimal(idAllegato));
			if (allegato == null || allegato.getAbcdfControlloweb() == null)
			{
				erroriSez = Constants.LABEL_SEZIONE_ABCDF;
			}

			StringBuffer erroriSezE = new StringBuffer();
			List<SigitTDettTipo1Dto> dettTipo1List = getDbMgr().getDettTipo1(null, null, idAllegato);

			if (dettTipo1List != null && dettTipo1List.size() > 0)
			{
				for (SigitTDettTipo1Dto sigitTDettTipo1Dto : dettTipo1List)
				{
					if (sigitTDettTipo1Dto.getEControlloweb() == null)
					{
						erroriSezE.append(GenericUtil.getDescSezioneEComp(Constants.TIPO_COMPONENTE_GT, ConvertUtil.convertToString(sigitTDettTipo1Dto.getProgressivo())));

						erroriSezE.append(" (modulo "+sigitTDettTipo1Dto.getENModuloTermico()+")");
						erroriSezE.append(Constants.VALUE_ENTER_HTML);
					}
				}
			}



//			prima di inviare l'allegato occorre compilare tutti i campi obbligatori delle seguenti sezioni:
//			Sezione ABCDF
//			Sez E- GT-XX

			List<SigitTDettTipo2Dto> dettTipo2List = getDbMgr().getDettTipo2(null, null, idAllegato);

			if (dettTipo2List != null && dettTipo2List.size() > 0)
			{
				for (SigitTDettTipo2Dto sigitTDettTipo2Dto : dettTipo2List)
				{
					if (sigitTDettTipo2Dto.getEControlloweb() == null)
					{
						erroriSezE.append(GenericUtil.getDescSezioneEComp(Constants.TIPO_COMPONENTE_GF,  ConvertUtil.convertToString(sigitTDettTipo2Dto.getProgressivo())));
						erroriSezE.append(" (circuito "+sigitTDettTipo2Dto.getENCircuito()+")");
						erroriSezE.append(Constants.VALUE_ENTER_HTML);

					}
				}
			}

			List<SigitTDettTipo3Dto> dettTipo3List = getDbMgr().getDettTipo3(null, null, idAllegato);

			if (dettTipo3List != null && dettTipo3List.size() > 0)
			{
				for (SigitTDettTipo3Dto sigitTDettTipo3Dto : dettTipo3List)
				{
					if (sigitTDettTipo3Dto.getEControlloweb() == null)
					{
						erroriSezE.append(GenericUtil.getDescSezioneEComp(Constants.TIPO_COMPONENTE_SC,  ConvertUtil.convertToString(sigitTDettTipo3Dto.getProgressivo())));
						erroriSezE.append(Constants.VALUE_ENTER_HTML);

					}
				}
			}

			List<SigitTDettTipo4Dto> dettTipo4List = getDbMgr().getDettTipo4(null, null, idAllegato);

			if (dettTipo4List != null && dettTipo4List.size() > 0)
			{
				for (SigitTDettTipo4Dto sigitTDettTipo4Dto : dettTipo4List)
				{
					if (sigitTDettTipo4Dto.getEControlloweb() == null)
					{
						erroriSezE.append(GenericUtil.getDescSezioneEComp(Constants.TIPO_COMPONENTE_CG, ConvertUtil.convertToString(sigitTDettTipo4Dto.getProgressivo())));
						erroriSezE.append(Constants.VALUE_ENTER_HTML);
					}
				}
			}

			StringBuffer erroriDett =new StringBuffer();
			if (erroriSez != null || erroriSezE.length() > 0)
			{
				erroriDett.append("prima di inviare il REE occorre compilare tutti i campi obbligatori delle seguenti sezioni:");

				if (erroriSez != null)
				{
					erroriDett.append(Constants.VALUE_ENTER_HTML+erroriSez);
				}

				if (erroriSezE != null)
				{
					erroriDett.append(Constants.VALUE_ENTER_HTML+erroriSezE);
				}

				errori = erroriDett.toString();
			}

			if (errori != null)
			{
				throw new ValidationManagerException(
						new Message(errori));
			}

		} catch (DbManagerException e) {
			throw new ValidationManagerException(new Message(Messages.ERROR_RECUPERO_DB));
		}

	}

	public void isAllegatoRapportoProvaInviabile(String idAllegato) throws ValidationManagerException {
		String errori = null;
		try {

			String erroriSez = null;

			SigitTAllegatoDto allegato = getDbMgr().cercaSigitTAllegatoById(ConvertUtil.convertToBigDecimal(idAllegato));
			if (allegato == null || allegato.getAbcdfControlloweb() == null)
			{
				erroriSez = Constants.LABEL_SEZIONE_RP_GEN;
			}

			StringBuffer erroriSezE = new StringBuffer();
			List<SigitTDettIspezGtDto> dettGtList = getDbMgr().getDettRappProvaGT(null, null, idAllegato);

			if (dettGtList != null && dettGtList.size() > 0)
			{
				for (SigitTDettIspezGtDto sigitTDett : dettGtList)
				{
					if (sigitTDett.getControlloweb() == null )
					{
						erroriSezE.append(GenericUtil.getDescSezioneRPComp(Constants.TIPO_COMPONENTE_GT, ConvertUtil.convertToString(sigitTDett.getProgressivo())));
						erroriSezE.append( " modulo " + sigitTDett.getS8aNModuloTermico());
						erroriSezE.append(Constants.VALUE_ENTER_HTML);
					}
				}
			}

			List<SigitTDettIspezGfDto> dettGfList = getDbMgr().getDettRappProvaGF(null, null, idAllegato);
			if (dettGfList != null && dettGfList.size() > 0)
			{
				for (SigitTDettIspezGfDto sigitTDett : dettGfList)
				{
					if (sigitTDett.getControlloweb() == null) //aggiungere controlloweb
					{
						erroriSezE.append(GenericUtil.getDescSezioneRPComp(Constants.TIPO_COMPONENTE_GF, ConvertUtil.convertToString(sigitTDett.getProgressivo())));
						erroriSezE.append( " circuito " + sigitTDett.getS8aNCircuito());
						erroriSezE.append(Constants.VALUE_ENTER_HTML);
					}
				}
			}


			StringBuffer erroriDett =new StringBuffer();
			if (erroriSez != null || erroriSezE.length() > 0)
			{
				erroriDett.append("prima di inviare il Rapporto di prova occorre compilare tutti i campi obbligatori delle seguenti sezioni:");

				if (erroriSez != null)
				{
					erroriDett.append(Constants.VALUE_ENTER_HTML+erroriSez);
				}

				if (erroriSezE != null)
				{
					erroriDett.append(Constants.VALUE_ENTER_HTML+erroriSezE);
				}

				errori = erroriDett.toString();
			}

			if (errori != null)
			{
				throw new ValidationManagerException(
						new Message(errori));
			}

		} catch (DbManagerException e) {
			throw new ValidationManagerException(new Message(Messages.ERROR_RECUPERO_DB));
		}

	}


	private static String creaMsgTabellaEdit(int riga, String nomeCampo, String msgError)
	{
		return "Nella riga " + riga + " il campo " + " <i>" + nomeCampo + "</i> " + msgError;
	}

	public void verificaRicercaIndirizzoDistributoreFornitura(DistributoreMan dto) throws ValidationManagerException {
		log.debug("[ValidationMgr::verificaRicercaIndirizzoIdentificazioneImpianto] BEGIN");

		checkRicercaIndirizzo(dto.getIdComuneForn(), dto.getIdProvinciaForn(),
				ConstantsField.GESTISCI_DISTRIBUTORE_ID_COMUNE_FORN, ConstantsField.GESTISCI_DISTRIBUTORE_ID_PROVINCIA_FORN);

		log.debug("VERIFICO L'INDIRIZZO FORNITURA: "+GenericUtil.isNullOrEmpty(dto.getIndirizzoForn()));

		if (GenericUtil.isNullOrEmpty(dto.getIndirizzoForn()))
		{
			ValidationManagerException ex =  new ValidationManagerException();
			ex.addFieldRequired(ConstantsField.GESTISCI_DISTRIBUTORE_INDIRIZZO_FORN);
			throw ex;
		}

		checkAlphanumericStringMinLenght(dto.getIndirizzoForn(), Constants.MIN_INDIRIZZO_LEN, ConstantsField.GESTISCI_DISTRIBUTORE_INDIRIZZO_FORN);

		log.debug("[ValidationMgr::verificaRicercaIndirizzoIdentificazioneImpianto] END");
	}

	public void verificaRicercaIndirizzoDistributoreFatturazione(DistributoreMan dto) throws ValidationManagerException {
		log.debug("[ValidationMgr::verificaRicercaIndirizzoDistributoreFatturazione] BEGIN");

		checkRicercaIndirizzo(dto.getIdComuneFatt(), dto.getIdProvinciaFatt(),
				ConstantsField.GESTISCI_DISTRIBUTORE_ID_COMUNE_FATT, ConstantsField.GESTISCI_DISTRIBUTORE_ID_PROVINCIA_FATT);

		log.debug("VERIFICO L'INDIRIZZO FATTURAZIONE: "+GenericUtil.isNullOrEmpty(dto.getIndirizzoFatt()));

		if (GenericUtil.isNullOrEmpty(dto.getIndirizzoFatt()))
		{
			ValidationManagerException ex =  new ValidationManagerException();
			ex.addFieldRequired(ConstantsField.GESTISCI_DISTRIBUTORE_INDIRIZZO_FATT);
			throw ex;
		}

		checkAlphanumericStringMinLenght(dto.getIndirizzoForn(), Constants.MIN_INDIRIZZO_LEN, ConstantsField.GESTISCI_DISTRIBUTORE_INDIRIZZO_FATT);

		log.debug("[ValidationMgr::verificaRicercaIndirizzoDistributoreFatturazione] END");
	}

	public void validazioneFormaleSalvaDistributore(DistributoreMan distributore) throws ValidationManagerException {

		preparaToValidate(distributore);

		ValidationManagerException validationException = new ValidationManagerException();

		if (GenericUtil.isNullOrEmpty(distributore.getFlgImpresaForn())) {
			validationException.addFieldRequired("appDatadistributoreManuale.flgImpresaForn");
		}

		if (GenericUtil.isNullOrEmpty(distributore.getCognomeForn())) {
			validationException.addFieldRequired("appDatadistributoreManuale.cognomeForn");
		}

		if (GenericUtil.isNullOrEmpty(distributore.getCfPivaForn())) {
			validationException.addFieldRequired("appDatadistributoreManuale.cfPivaForn");
		}

		if (GenericUtil.isNullOrEmpty(distributore.getIdProvinciaForn())) {
			validationException.addFieldRequired("appDatadistributoreManuale.idProvinciaForn");
		}

		if (GenericUtil.isNullOrEmpty(distributore.getIdComuneForn())) {
			validationException.addFieldRequired("appDatadistributoreManuale.idComuneForn");
		}

		if (GenericUtil.isNullOrEmpty(distributore.getIdIndirizzoForn()) && GenericUtil.isNullOrEmpty(distributore.getIndirizzoNoStradForn())) {
			validationException.addFieldRequired("appDatadistributoreManuale.indirizzoForn");
			validationException.addFieldRequired("appDatadistributoreManuale.idIndirizzoForn");
			validationException.addFieldRequired("appDatadistributoreManuale.indirizzoNoStradForn");

		}

		if (GenericUtil.isNullOrEmpty(distributore.getIndirizzoCivicoForn())) {
			validationException.addFieldRequired("appDatadistributoreManuale.indirizzoCivicoForn");
		}


		if (GenericUtil.isNullOrEmpty(distributore.getAnnoRiferimento())) {
			validationException.addFieldRequired("appDatadistributoreManuale.annoRiferimento");
		}

		if (GenericUtil.isNullOrEmpty(distributore.getNumMesiFatt())) {
			validationException.addFieldRequired("appDatadistributoreManuale.numMesiFatt");
		}

		if (GenericUtil.isNullOrEmpty(distributore.getIdTipoContratto())) {
			validationException.addFieldRequired("appDatadistributoreManuale.idTipoContratto");
		}

		if (GenericUtil.isNullOrEmpty(distributore.getIdCategoria())) {
			validationException.addFieldRequired("appDatadistributoreManuale.idCategoria");
		}

		if (GenericUtil.isNullOrEmpty(distributore.getIdCombustibile())) {
			validationException.addFieldRequired("appDatadistributoreManuale.idCombustibile");
		}

		if (GenericUtil.isNullOrEmpty(distributore.getConsumoAnnuo())) {
			validationException.addFieldRequired("appDatadistributoreManuale.consumoAnnuo");
		}

		if (GenericUtil.isNullOrEmpty(distributore.getIdUnitaMisuraConsumo())) {
			validationException.addFieldRequired("appDatadistributoreManuale.idUnitaMisuraConsumo");
		}

		if (!ConvertUtil.convertToBooleanAllways(distributore.getFlgFatturazioneUguale()))
		{
			// L'indirizzo fatturazione e' diverso da quello della fornitura

			if (GenericUtil.isNullOrEmpty(distributore.getFlgImpresaFatt())) {
				validationException.addFieldRequired("appDatadistributoreManuale.flgImpresaFatt");
			}

			if (GenericUtil.isNullOrEmpty(distributore.getCognomeFatt())) {
				validationException.addFieldRequired("appDatadistributoreManuale.cognomeFatt");
			}

			if (GenericUtil.isNullOrEmpty(distributore.getCfPivaFatt())) {
				validationException.addFieldRequired("appDatadistributoreManuale.cfPivaFatt");
			}

			if (ConvertUtil.convertToBooleanAllways(distributore.getFlgIndirizzoFattEstero()))
			{
				if (GenericUtil.isNullOrEmpty(distributore.getIndirizzoNoStradFatt())) {
					validationException.addFieldRequired("appDatadistributoreManuale.indirizzoNoStradFatt");
				}

			}
			else
			{
				if (GenericUtil.isNullOrEmpty(distributore.getIdProvinciaFatt())) {
					validationException.addFieldRequired("appDatadistributoreManuale.idProvinciaFatt");
				}

				if (GenericUtil.isNullOrEmpty(distributore.getIdComuneFatt())) {
					validationException.addFieldRequired("appDatadistributoreManuale.idComuneFatt");
				}

				if (GenericUtil.isNullOrEmpty(distributore.getIdIndirizzoFatt()) && GenericUtil.isNullOrEmpty(distributore.getIndirizzoNoStradFatt())) {
					validationException.addFieldRequired("appDatadistributoreManuale.indirizzoFatt");
					validationException.addFieldRequired("appDatadistributoreManuale.idIndirizzoFatt");
					validationException.addFieldRequired("appDatadistributoreManuale.indirizzoNoStradFatt");

				}

			}


			if (GenericUtil.isNullOrEmpty(distributore.getIndirizzoCivicoFatt())) {
				validationException.addFieldRequired("appDatadistributoreManuale.indirizzoCivicoFatt");
			}

		}

		if (validationException.getFieldList().size() > 0)
		{
			log.debug("Eccezione controlli obbligatorieta: "+validationException.getFieldList().size());

			if (log.isDebugEnabled())
				GenericUtil.stampa(validationException.getFieldList(), true, 3);

			for (int i = 0; i < validationException.getFieldList().size(); i++) {
				log.debug("STAMPO: "+validationException.getFieldList().get(i));
			}

			throw validationException;
		}


		if (GenericUtil.isNullOrEmpty(distributore.getIdIndirizzoForn())
				&& GenericUtil.isNotNullOrEmpty(distributore.getIndirizzoNoStradForn())
				&& !GenericUtil.isIndirizzoCompleto(distributore.getIndirizzoNoStradForn()))
		{


			validationException = new ValidationManagerException(new Message(Messages.ERROR_INDIRIZZO_INCOMPLETO));
			//validationException.addField("appDatadistributoreManuale.idIndirizzoForn");
			validationException.addField("appDatadistributoreManuale.indirizzoNoStradForn");

			log.debug("Eccezione controlli formali - indirizzo fornitura");

			throw validationException;
		}

		if (distributore.getFlgImpresaForn())
		{
			log.debug("Eccezione controlli formali - checkCodiceFiscalePartitaIva");

			checkCodiceFiscalePartitaIva(distributore.getCfPivaForn(), "appDatadistributoreManuale.cfPivaForn");
		}
		else
		{
			log.debug("Eccezione controlli formali - controlloCf");

			controlloCf(distributore.getCfPivaForn(), "appDatadistributoreManuale.cfPivaForn");
		}

		// Devo fare i controlli formali
		if (GenericUtil.isNotNullOrEmpty(distributore.getIndirizzoCapForn()))
		{
			log.debug("Eccezione controlli formali - checkCAP");

			checkCAP(distributore.getIndirizzoCapForn(), "appDatadistributoreManuale.indirizzoCapForn");
		}


		if (GenericUtil.checkIsValidYear(distributore.getAnnoRiferimento()))
		{
			log.debug("Eccezione controlli formali - checkIsValidYear");

			validationException = new ValidationManagerException(new Message(Messages.ERROR_FIELD_FORMAL_ERROR));
			validationException.addField("appDatadistributoreManuale.annoRiferimento");
			throw validationException;

		} else if (DateUtil.getAnnoCorrente() < ConvertUtil.convertToInteger(distributore.getAnnoRiferimento()))
		{
			validationException = new ValidationManagerException(new Message(Messages.ERROR_ANNO_FUTURO));
			validationException.addField("appDatadistributoreManuale.annoRiferimento");
			throw validationException;

		}

		if (GenericUtil.isNotNullOrEmpty(distributore.getCodicePdrPod()))
		{

			if (!GenericUtil.isStringValid(distributore.getCodicePdrPod().toUpperCase(), Constants.POD) &&
					!GenericUtil.isStringValid(distributore.getCodicePdrPod(), Constants.PDR))

			{

				log.debug("Eccezione controlli formali - getCodicePdrPod");

				validationException = new ValidationManagerException(new Message(Messages.ERROR_FIELD_FORMAL_ERROR));
				validationException.addField("appDatadistributoreManuale.codicePdrPod");
				throw validationException;

			}

		}

		if (GenericUtil.isNotNullOrEmpty(distributore.getConsumoAnnuo())) {
			log.debug("Eccezione controlli formali - getConsumoAnnuo");

			checkNumero(distributore.getConsumoAnnuo(), "appDatadistributoreManuale.consumoAnnuo", 11, 2, null, true);
		}

		if (GenericUtil.isNotNullOrEmpty(distributore.getVolumetriaRiscaldata())) {
			log.debug("Eccezione controlli formali - getVolumetriaRiscaldata");

			checkNumero(distributore.getVolumetriaRiscaldata(), "appDatadistributoreManuale.volumetriaRiscaldata", 11, 2, null, true);
		}

		if (!ConvertUtil.convertToBooleanAllways(distributore.getFlgFatturazioneUguale()))
		{
			// L'indirizzo fatturazione e' diverso da quello della fornitura

			if (GenericUtil.isNullOrEmpty(distributore.getIdIndirizzoFatt())
					&& GenericUtil.isNotNullOrEmpty(distributore.getIndirizzoNoStradFatt())
					&& !GenericUtil.isIndirizzoCompleto(distributore.getIndirizzoNoStradFatt()))
			{
				validationException = new ValidationManagerException(new Message(Messages.ERROR_INDIRIZZO_INCOMPLETO));
				//validationException.addField("appDatadistributoreManuale.idIndirizzoFatt");
				validationException.addField("appDatadistributoreManuale.indirizzoNoStradFatt");

				log.debug("Eccezione controlli formali - indirizzo fatturazione");

				throw validationException;

			}

			if (distributore.getFlgImpresaFatt())
			{
				log.debug("Eccezione controlli formali - checkCodiceFiscalePartitaIvaFatt");

				checkCodiceFiscalePartitaIva(distributore.getCfPivaFatt(), "appDatadistributoreManuale.cfPivaFornFatt");
			}
			else
			{
				log.debug("Eccezione controlli formali - controlloCfFatt");

				controlloCf(distributore.getCfPivaFatt(), "appDatadistributoreManuale.cfPivaFornFatt");
			}

			// Devo fare i controlli formali
			if (GenericUtil.isNotNullOrEmpty(distributore.getIndirizzoCapFatt()))
			{
				log.debug("Eccezione controlli formali - checkCAPFatt");

				checkCAP(distributore.getIndirizzoCapFatt(), "appDatadistributoreManuale.indirizzoCapFatt");
			}

		}


	}

	public static void main(String[] args) throws Exception {

		/*
		it.csi.sigit.sigitwebn.xml.importmassivo.allegato2.data.MODIIDocument d = it.csi.sigit.sigitwebn.xml.importmassivo.allegato2.data.MODIIDocument.Factory.newInstance();
		d.addNewMODII().addNewRichiesta();
		Richiesta r = d.getMODII().getRichiesta();
		DatiIntestazione di = r.addNewDatiIntestazione();
		di.setCodiceCatasto("1141912");
		di.setCodiceBollino("RP-8090");
		di.setAFDataControllo(ConvertUtil.convertDateToXmlCalendar(ConvertUtil.convertToDate("01/01/2015")));
		DatiManutentore dm = r.addNewDatiManutentore();
		dm.setSiglaREA("BI");
		dm.setCodiceFiscale("CLZGRL74A12A859H");
		dm.setNumeroREA("179982");
		DatiAllegato da = r.addNewDatiAllegato();
		DatiIdentificativi did = da.addNewDatiIdentificativi();
		did.setAAPotenzaTermicaNomTotMax(new BigDecimal("332"));
		CheckList cl = da.addNewCheckList();
		cl.setAFFlagIsolamento(true);
		cl.setAFFlagSistRegolaz(false);
		cl.setAFFlagSistTrattACS(false);
		cl.setAFFlagValvole(true);
		cl.setAFOsservazioni("osservazioni");
		cl.setAFPrescrizioni("prescr");
		cl.setAFRaccomandazioni("racco");
		ControlloImpianto ci = da.addNewControlloImpianto();
		ci.setADFlagAperture(new BigInteger("432"));
		ci.setADFlagInterno(new BigInteger("33"));
		ci.setADFlagCanaleFumo(new BigInteger("1"));
		ci.setADFlagDimensioni(new BigInteger("2"));
		ci.setADFlagEsterno(new BigInteger("3"));
		ci.setADFlagPerdite(new BigInteger("4"));
		ci.setADFlagSistRegolaz(new BigInteger("5"));
		ci.setADFlagTenuta(new BigInteger("6"));
		DatiTecnico dt = da.addNewDatiTecnico();
		dt.setAFCognomeTecnico("Rossi");
		dt.setAFNomeTecnico("Franco");
		dt.setAFDataIntervento(ConvertUtil.convertDateToXmlCalendar(new Date()));
		dt.setAFFirmaResp("firma res");
		dt.setAFFirmaTecnico("firma tec");
		dt.setAFFlagFunzImp(true);
		dt.setAFOrarioArrivo("09:00");
		dt.setAFOrarioPartenza("11:00");
		DocumentazioneTecnica docT = da.addNewDocumentazioneTecnica();
		docT.setABFlagDichiarazConf(false);
		docT.setABFlagLibrettoComp(true);
		docT.setABFlagLibrettoImp(false);
		docT.setABFlagManutGen(true);
		TrattamentoAcqua ta = da.addNewTrattamentoAcqua();
		ta.setACFlagTrattAcsNR(false);
		ta.setACFlagTrattH2ONR(false);
		RowAllegatoII a = da.addNewAllegatoII().addNewRowAllegatoII();
		a.setAENumGT(new BigInteger("1"));
		ControlloVerificaEnergetica ve = a.addNewControlloVerificaEnergetica();
		ve.setAEAltroRifNormativo("dl 30");
		ve.setAEDepressCanaleFumo(new BigDecimal("9"));
		ve.setAEFlagClimatizInv(false);
		ve.setAEFlagDispComando(true);
		ve.setAEFlagDispSicu(false);
		ve.setAEFlagEvacFumi("aa");
		ve.setAEFlagProduzACS(true);
		ve.setAEFlagRiflusso(false);
		ve.setAEFlagRisultati(false);
		ve.setAEFlagScambiatore(true);
		ve.setAEFlagValvSicu(true);
		ve.setAEPotenzaFocolare(new BigDecimal("323"));
		TabFumi tf = a.addNewTabFumi();
		RowFumi rf = RowFumi.Factory.newInstance();
		rf.setAEBacharach1(new BigDecimal("22"));
		rf.setAEBacharach2(new BigDecimal("22"));
		rf.setAEBacharach3(new BigDecimal("22"));
		rf.setAECO2(new BigDecimal("22"));
		rf.setAECOcorretto(new BigDecimal("22"));
		rf.setAECOfumiSecchi(new BigDecimal("22"));
		rf.setAEMinimo(false);
		rf.setAEModuloTermico(new BigDecimal("22"));
		rf.setAENox(new BigDecimal("22"));
		rf.setAEO2(new BigDecimal("22"));
		rf.setAEPortataCombu("33");
		rf.setAERendimCombu(new BigDecimal("22"));
		rf.setAERendimentoLegge(new BigDecimal("22"));
		rf.setAERispettoIndBacharach(false);
		rf.setAETempAria(new BigDecimal("22"));
		rf.setAETempFumi(new BigDecimal("22"));
		rf.setAEValorePortata(new BigDecimal("22"));
		tf.setRowFumiArray(new RowFumi[]{rf});

		 */
/*
		MODIIIDocument d = MODIIIDocument.Factory.newInstance();
		it.csi.sigit.sigitwebn.xml.importmassivo.allegato3.data.RichiestaDocument.Richiesta richiesta = d.addNewMODIII().addNewRichiesta();
		it.csi.sigit.sigitwebn.xml.importmassivo.allegato3.data.DatiIntestazioneDocument.DatiIntestazione di = richiesta.addNewDatiIntestazione();
		di.setCodiceCatasto("1141912");
		di.setCodiceBollino("RP-8090");
		di.setAFDataControllo(ConvertUtil.convertDateToXmlCalendar(ConvertUtil.convertToDate("01/01/2015")));;
		it.csi.sigit.sigitwebn.xml.importmassivo.allegato3.data.DatiManutentoreDocument.DatiManutentore dm = richiesta.addNewDatiManutentore();
		dm.setSiglaREA("BI");
		dm.setCodiceFiscale("CLZGRL74A12A859H");
		dm.setNumeroREA("179982");
		it.csi.sigit.sigitwebn.xml.importmassivo.allegato3.data.DatiAllegatoDocument.DatiAllegato da = richiesta.addNewDatiAllegato();
		it.csi.sigit.sigitwebn.xml.importmassivo.allegato3.data.DatiIdentificativiDocument.DatiIdentificativi did = da.addNewDatiIdentificativi();
		did.setAAPotenzaTermicaNomTotMax(new BigDecimal("332"));
		it.csi.sigit.sigitwebn.xml.importmassivo.allegato3.data.CheckListDocument.CheckList cl = da.addNewCheckList();
		cl.setAFOsservazioni("osservazioni");
		cl.setAFPrescrizioni("prescr");
		cl.setAFRaccomandazioni("racco");
		cl.setAFFlagIsolamentoCanali(false);
		cl.setAFFlagIsolamentoRete(false);
		cl.setAFFlagSostGen1(true);
		cl.setAFFlagSostGen2(false);
		it.csi.sigit.sigitwebn.xml.importmassivo.allegato3.data.ControlloImpiantoDocument.ControlloImpianto ci = da.addNewControlloImpianto();
		ci.setADFlagAperture(new BigInteger("432"));
		ci.setADFlagCoibenIdonee(new BigInteger("33"));
		ci.setADFlagDimensioni(new BigInteger("3344"));
		ci.setADFlagLineeIdonee(new BigInteger("3343"));
		ci.setADFlagLocaleIdoneo(new BigInteger("3383"));
		it.csi.sigit.sigitwebn.xml.importmassivo.allegato3.data.DatiTecnicoDocument.DatiTecnico dt = da.addNewDatiTecnico();
		dt.setAFCognomeTecnico("Rossi");
		dt.setAFNomeTecnico("Franco");
		dt.setAFDataIntervento(ConvertUtil.convertDateToXmlCalendar(new Date()));
		dt.setAFFirmaResp("firma res");
		dt.setAFFirmaTecnico("firma tec");
		dt.setAFFlagFunzImp(true);
		dt.setAFOrarioArrivo("09:00");
		dt.setAFOrarioPartenza("11:00");
		it.csi.sigit.sigitwebn.xml.importmassivo.allegato3.data.DocumentazioneTecnicaDocument.DocumentazioneTecnica docT = da.addNewDocumentazioneTecnica();
		docT.setABFlagDichiarazConf(false);
		docT.setABFlagLibrettoComp(true);
		docT.setABFlagLibrettoImp(false);
		docT.setABFlagManutGen(true);
		it.csi.sigit.sigitwebn.xml.importmassivo.allegato3.data.TrattamentoAcquaDocument.TrattamentoAcqua ta = da.addNewTrattamentoAcqua();
		ta.setACFlagTrattH2ONR(false);
		RowAllegatoIII a = da.addNewAllegatoIII().addNewRowAllegatoIII();
		a.setAENumGF(new BigInteger("1"));
		it.csi.sigit.sigitwebn.xml.importmassivo.allegato3.data.ControlloVerificaEnergeticaDocument.ControlloVerificaEnergetica ve = a.addNewControlloVerificaEnergetica();
		ve.setAEFlagModalita("open");
		ve.setAEFlagPerdite(new BigInteger("1"));
		ve.setAEFlagRilevFugheDiretta(new BigInteger("3"));
		ve.setAEFlagRilevFugheInDiretta(new BigInteger("2"));
		ve.setAEFlagScambPuliti(new BigInteger("2"));
		it.csi.sigit.sigitwebn.xml.importmassivo.allegato3.data.RowAllegatoIIIDocument.RowAllegatoIII.TabFumi tf = a.addNewTabFumi();
		it.csi.sigit.sigitwebn.xml.importmassivo.allegato3.data.RowFumiDocument.RowFumi rf = it.csi.sigit.sigitwebn.xml.importmassivo.allegato3.data.RowFumiDocument.RowFumi.Factory.newInstance();
		rf.setAECondens(new BigDecimal("4"));
		rf.setAEDataRipristino(ConvertUtil.convertDateToXmlCalendar(new Date()));
		rf.setAEFiltriPuliti(false);
		rf.setAEEvaporaz(new BigDecimal("55"));
		rf.setAEIngLatoEst(new BigDecimal("43"));
		rf.setAEIngLatoUtenze(new BigDecimal("243"));
		rf.setAENumCircuito(new BigInteger("1"));
		rf.setAEPotenzaAss(new BigDecimal("243"));
		rf.setAESottoRaffr(new BigDecimal("6"));
		rf.setAESurrisc(new BigDecimal("6"));
		rf.setAETbulboUmido(new BigDecimal("6"));
		rf.setAETingFluidoMacc(new BigDecimal("6"));
		rf.setAETingFluidoSorg(new BigDecimal("6"));
		rf.setAETuscFluido(new BigDecimal("6"));
		rf.setAETuscFluidoMacc(new BigDecimal("6"));
		rf.setAETuscFluidoSorg(new BigDecimal("6"));
		rf.setAEUscLatoEst(new BigDecimal("6"));
		rf.setAEUscLatoUtenze(new BigDecimal("6"));
		rf.setAEVerifica(true);
		tf.setRowFumiArray(new RowFumiDocument.RowFumi[]{rf});
		*/

		/*MODIVDocument d = MODIVDocument.Factory.newInstance();
		it.csi.sigit.sigitwebn.xml.importmassivo.allegato4.data.RichiestaDocument.Richiesta richiesta = d.addNewMODIV().addNewRichiesta();
		it.csi.sigit.sigitwebn.xml.importmassivo.allegato4.data.DatiIntestazioneDocument.DatiIntestazione di = richiesta.addNewDatiIntestazione();
		di.setCodiceCatasto("1495622");
		di.setCodiceBollino("RP-50573");
		di.setAFDataControllo(ConvertUtil.convertDateToXmlCalendar(ConvertUtil.convertToDate("01/01/2015")));;
		it.csi.sigit.sigitwebn.xml.importmassivo.allegato4.data.DatiManutentoreDocument.DatiManutentore dm = richiesta.addNewDatiManutentore();
		dm.setSiglaREA("AL");
		dm.setCodiceFiscale("MNGRRT74L05A182L");
		dm.setNumeroREA("250513");
		it.csi.sigit.sigitwebn.xml.importmassivo.allegato4.data.DatiAllegatoDocument.DatiAllegato da = richiesta.addNewDatiAllegato();
		it.csi.sigit.sigitwebn.xml.importmassivo.allegato4.data.DatiIdentificativiDocument.DatiIdentificativi did = da.addNewDatiIdentificativi();
		did.setAAPotenzaTermicaNomTotMax(new BigDecimal("332"));
		it.csi.sigit.sigitwebn.xml.importmassivo.allegato4.data.CheckListDocument.CheckList cl = da.addNewCheckList();
		cl.setAFOsservazioni("osservazioni");
		cl.setAFPrescrizioni("prescr");
		cl.setAFRaccomandazioni("racco");
		cl.setAFFlagCurvaClim(false);
		cl.setAFFlagInvolucro(true);
		cl.setAFFlagPerditaH2O(false);
		cl.setAFFlagValvole(false);
		it.csi.sigit.sigitwebn.xml.importmassivo.allegato4.data.ControlloImpiantoDocument.ControlloImpianto ci = da.addNewControlloImpianto();
		ci.setADFlagLineeIdonee(new BigInteger("1"));
		ci.setADFlagLuogoIdoneo(new BigInteger("2"));
		ci.setADFlagPerdite(new BigInteger("0"));
		ci.setADFlagStatoCoiben(new BigInteger("0"));
		it.csi.sigit.sigitwebn.xml.importmassivo.allegato4.data.DatiTecnicoDocument.DatiTecnico dt = da.addNewDatiTecnico();
		dt.setAFCognomeTecnico("Rossi");
		dt.setAFNomeTecnico("Franco");
		dt.setAFDataIntervento(ConvertUtil.convertDateToXmlCalendar(new Date()));
		dt.setAFFirmaResp("firma res");
		dt.setAFFirmaTecnico("firma tec");
		dt.setAFFlagFunzImp(true);
		dt.setAFOrarioArrivo("09:00");
		dt.setAFOrarioPartenza("11:00");
		it.csi.sigit.sigitwebn.xml.importmassivo.allegato4.data.DocumentazioneTecnicaDocument.DocumentazioneTecnica docT = da.addNewDocumentazioneTecnica();
		docT.setABFlagDichiarazConf(false);
		docT.setABFlagLibrettoComp(true);
		docT.setABFlagLibrettoImp(false);
		docT.setABFlagManutGen(true);
		it.csi.sigit.sigitwebn.xml.importmassivo.allegato4.data.TrattamentoAcquaDocument.TrattamentoAcqua ta = da.addNewTrattamentoAcqua();
		ta.setACFlagTrattH2ONR(false);
		ta.setACFlagTrattAcsNR(false);
		RowAllegatoIV a = da.addNewAllegatoIV().addNewRowAllegatoIV();
		a.setAENumSC(new BigInteger("1"));
		it.csi.sigit.sigitwebn.xml.importmassivo.allegato4.data.ControlloVerificaEnergeticaDocument.ControlloVerificaEnergetica ve = a.addNewControlloVerificaEnergetica();
		ve.setAECombustibile("gas");
		ve.setAEFlagClimatizInv(false);
		ve.setAEFlagDispReg(new BigInteger("1"));
		ve.setAEFlagPotComp(new BigInteger("1"));
		ve.setAEFlagProduzACS(true);
		ve.setAEFlagStatoCoiben(new BigInteger("1"));
		ve.setAEFluidoVett("acqua");
		it.csi.sigit.sigitwebn.xml.importmassivo.allegato4.data.RowAllegatoIVDocument.RowAllegatoIV.TabFumi tf = a.addNewTabFumi();
		it.csi.sigit.sigitwebn.xml.importmassivo.allegato4.data.RowFumiDocument.RowFumi rf = tf.addNewRowFumi();
		rf.setAEPortataFluido(new BigDecimal("232"));
		rf.setAEPotenzaTerm(new BigDecimal("656"));
		rf.setAETempEst(new BigDecimal("23"));
		rf.setAETempMandPrim(new BigDecimal("1"));
		rf.setAETempMandSecond(new BigDecimal("2"));
		rf.setAETempRitPrim(new BigDecimal("11"));
		rf.setAETempRitSecond(new BigDecimal("22"));
		*/
		/*
		MODVDocument d = MODVDocument.Factory.newInstance();
		it.csi.sigit.sigitwebn.xml.importmassivo.allegato5.data.RichiestaDocument.Richiesta richiesta = d.addNewMODV().addNewRichiesta();
		it.csi.sigit.sigitwebn.xml.importmassivo.allegato5.data.DatiIntestazioneDocument.DatiIntestazione di = richiesta.addNewDatiIntestazione();
		di.setCodiceCatasto("1495622");
		di.setCodiceBollino("RP-50574");
		di.setAFDataControllo(ConvertUtil.convertDateToXmlCalendar(ConvertUtil.convertToDate("14/01/2015")));;
		it.csi.sigit.sigitwebn.xml.importmassivo.allegato5.data.DatiManutentoreDocument.DatiManutentore dm = richiesta.addNewDatiManutentore();
		dm.setSiglaREA("AL");
		dm.setCodiceFiscale("MNGRRT74L05A182L");
		dm.setNumeroREA("250513");
		it.csi.sigit.sigitwebn.xml.importmassivo.allegato5.data.DatiAllegatoDocument.DatiAllegato da = richiesta.addNewDatiAllegato();
		it.csi.sigit.sigitwebn.xml.importmassivo.allegato5.data.DatiIdentificativiDocument.DatiIdentificativi did = da.addNewDatiIdentificativi();
		did.setAAPotenzaTermicaNomTotMax(new BigDecimal("332"));
		it.csi.sigit.sigitwebn.xml.importmassivo.allegato5.data.CheckListDocument.CheckList cl = da.addNewCheckList();
		cl.setAFOsservazioni("osservazioni");
		cl.setAFPrescrizioni("prescr");
		cl.setAFRaccomandazioni("racco");
		cl.setAFFlagIsolamento(false);
		cl.setAFFlagSistRegolaz(false);
		cl.setAFFlagSistTrattACS(true);
		cl.setAFFlagValvole(false);
		it.csi.sigit.sigitwebn.xml.importmassivo.allegato5.data.ControlloImpiantoDocument.ControlloImpianto ci = da.addNewControlloImpianto();
		ci.setADFlagLineeIdonee(new BigInteger("1"));
		ci.setADFlagLuogoIdoneo(new BigInteger("0"));
		ci.setADFlagAperture(new BigInteger("2"));
		ci.setADFlagCanaleFumo(new BigInteger("1"));
		ci.setADFlagCapsulaInso(new BigInteger("0"));
		ci.setADFlagDimensioni(new BigInteger("1"));
		ci.setADFlagFunzionalita(new BigInteger("2"));
		ci.setADFlagTenutaAlimentaz(new BigInteger("2"));
		ci.setADFlagTenutaIdraulica(new BigInteger("0"));
		ci.setADFlagTenutaOlio(new BigInteger("0"));
		it.csi.sigit.sigitwebn.xml.importmassivo.allegato5.data.DatiTecnicoDocument.DatiTecnico dt = da.addNewDatiTecnico();
		dt.setAFCognomeTecnico("Rossi");
		dt.setAFNomeTecnico("Franco");
		dt.setAFDataIntervento(ConvertUtil.convertDateToXmlCalendar(new Date()));
		dt.setAFFirmaResp("firma res");
		dt.setAFFirmaTecnico("firma tec");
		dt.setAFFlagFunzImp(true);
		dt.setAFOrarioArrivo("09:00");
		dt.setAFOrarioPartenza("11:00");
		it.csi.sigit.sigitwebn.xml.importmassivo.allegato5.data.DocumentazioneTecnicaDocument.DocumentazioneTecnica docT = da.addNewDocumentazioneTecnica();
		docT.setABFlagDichiarazConf(false);
		docT.setABFlagLibrettoComp(true);
		docT.setABFlagLibrettoImp(false);
		docT.setABFlagManutGen(true);
		it.csi.sigit.sigitwebn.xml.importmassivo.allegato5.data.TrattamentoAcquaDocument.TrattamentoAcqua ta = da.addNewTrattamentoAcqua();
		ta.setACFlagTrattH2ONR(false);
		RowAllegatoV a = da.addNewAllegatoV().addNewRowAllegatoV();
		a.setAENumCG(new BigInteger("1"));
		it.csi.sigit.sigitwebn.xml.importmassivo.allegato5.data.ControlloVerificaEnergeticaDocument.ControlloVerificaEnergetica ve = a.addNewControlloVerificaEnergetica();
		ve.setAEFluidoVett("acqua");
		ve.setAEPotenzaAssorbita(new BigDecimal(223));
		ve.setAEPotenzaTermByPass(new BigDecimal(776));
		it.csi.sigit.sigitwebn.xml.importmassivo.allegato5.data.RowAllegatoVDocument.RowAllegatoV.TabFumi tf = a.addNewTabFumi();
		it.csi.sigit.sigitwebn.xml.importmassivo.allegato5.data.RowFumiDocument.RowFumi rf = tf.addNewRowFumi();
		rf.setAEPotenzaMorsetti(new BigDecimal("1"));
		rf.setAESottoFreqSoglia1(new BigDecimal("1"));
		rf.setAESottoFreqSoglia2(new BigDecimal("1"));
		rf.setAESottoFreqSoglia3(new BigDecimal("1"));
		rf.setAESottoFreqTempo1(new BigDecimal("1"));
		rf.setAESottoFreqTempo2(new BigDecimal("1"));
		rf.setAESottoFreqTempo3(new BigDecimal("1"));
		rf.setAESottoTensSoglia1(new BigDecimal("1"));
		rf.setAESottoTensSoglia2(new BigDecimal("1"));
		rf.setAESottoTensSoglia3(new BigDecimal("1"));
		rf.setAESottoTensTempo1(new BigDecimal("1"));
		rf.setAESottoTensTempo2(new BigDecimal("1"));
		rf.setAESottoTensTempo3(new BigDecimal("1"));
		rf.setAESovraFreqSoglia1(new BigDecimal("1"));
		rf.setAESovraFreqSoglia2(new BigDecimal("1"));
		rf.setAESovraFreqSoglia3(new BigDecimal("1"));
		rf.setAESovraFreqTempo1(new BigDecimal("1"));
		rf.setAESovraFreqTempo2(new BigDecimal("1"));
		rf.setAESovraFreqTempo3(new BigDecimal("1"));
		rf.setAESovraTensSoglia1(new BigDecimal("1"));
		rf.setAESovraTensSoglia2(new BigDecimal("1"));
		rf.setAESovraTensSoglia3(new BigDecimal("1"));
		rf.setAESovraTensTempo1(new BigDecimal("1"));
		rf.setAESovraTensTempo2(new BigDecimal("1"));
		rf.setAESovraTensTempo3(new BigDecimal("1"));
		rf.setAETempAcquaIng(new BigDecimal("1"));
		rf.setAETempAcquaUsc(new BigDecimal("1"));
		rf.setAETempAriaCombur(new BigDecimal("1"));
		rf.setAETempFumiAmonte(new BigDecimal("1"));
		rf.setAETempFumiAvalle(new BigDecimal("1"));
		rf.setAETempH2Omotore(new BigDecimal("1"));

		System.out.println(d);
		FileWriter fw = new FileWriter("C:/Users/Olsi/Desktop/5_1495622_ok.xml");
		fw.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
		fw.write(d.toString());
		fw.close();
		*/
	}


	public void preparaToValidate(Object o1) {
		//METODO CHE PRENDE IN INPUT UN OGGETTO E PULISCE TUTTI GLI ATTRIBUTI STRINGA ELIMINANDO GLI SPAZI INIZIALI E FINALI
		BeanInfo bi;
		try {
			// l'accesso agli oggetti avviene mediante introspection
			bi = Introspector.getBeanInfo(o1.getClass());
		} catch (IntrospectionException e) { //NOSONAR  Reason:dubbia classificazione severity
			throw new IllegalArgumentException("errore in lettura campi di " + o1.getClass() + ":" + e);
		}
		PropertyDescriptor[] pds = bi.getPropertyDescriptors();
		for (int i = 0; i < pds.length; i++) {
			PropertyDescriptor currPD = pds[i];

			Method getter = currPD.getReadMethod();
			Method setter = currPD.getWriteMethod();
			if (getter != null && setter != null) {
				// se la property non e' read only..
				try {
					// valore della property nell'oggetto 1
					Object v1 = getter.invoke(o1, new Object[]{});
					if (v1 instanceof String) {
						String v2 = GenericUtil.getStringValid((String) v1);
						setter.invoke(o1, v2);
					}

				} catch (IllegalAccessException e) { //NOSONAR  Reason:dubbia classificazione severity
					throw new IllegalArgumentException("errore in lettura campi di " + o1.getClass() + ":" + e);
				} catch (InvocationTargetException e) { //NOSONAR  Reason:dubbia classificazione severity
					throw new IllegalArgumentException("errore in lettura campi di " + o1.getClass() + ":" + e);
				}
			}
		}
	}

	public void isRappProvaInviabile (Integer idAllegatoSelezionato) throws ValidationManagerException {
		try {
			DettaglioAllegato allegato = getDbMgr().getDettaglioAllegatoById(idAllegatoSelezionato);

			//se impianto ha il flag tipo impianto = null --> errore
			if (!isImpiantoTipoImpiantoValorizzato(
					ConvertUtil.convertToBigDecimal(allegato.getCodiceImpianto()))) {
				throw new ValidationManagerException(new Message(Messages.S158));
			}

			//se l'allegato ha stato inviato/respinto --> errore
			if (!allegato.getIdStatoRapporto().equals(Constants.ID_STATO_RAPPORTO_BOZZA)) {
				throw new ValidationManagerException(new Message(Messages.S040_RAPP_PROVA));
			}

			isAllegatoRapportoProvaInviabile(allegato.getIdAllegato());

			//se non c'� responsabile attivo alla data controllo e sysdate --> errore
			if (isNessunResponsabileByCodImpiantoApp(allegato.getCodiceImpianto(),
					allegato.getDataControllo(), allegato.getIdTipoAllegato(), allegato.getIdApparecchiature())) {
				throw new ValidationManagerException(new Message(Messages.ERROR_RESPONSABILE_DATA_RAPP_ASSENTE));
			} else if (getDbMgr().cercaResponsabileAttivoByCodImpianto(
					ConvertUtil.convertToInteger(allegato.getCodiceImpianto())) == null) {
				// Vuol dire che non c'e' un respansabile attivo alla sysdate, non riuscirei a creare il libretto
				throw new ValidationManagerException(new Message(Messages.ERROR_RESPONSABILE_ASSENTE));
			} else {
				//controllo obbligatorieta' campi
				validaFlgTrattRapportiProva(allegato.getCodiceImpianto(),
						allegato.getIdAllegato(), allegato.getTipoAllegato());
			}

		} catch (DbManagerException e) {
			throw new ValidationManagerException(new Message(Messages.ERROR_RECUPERO_DB));
		}



	}


	public void validazioneFormaleRapProvaGFDett(TipoGFDett dett, Map<Integer, String> mappaFrequenza) throws ValidationManagerException {
		ValidationManagerException validationException = new ValidationManagerException();

		preparaToValidate(dett);

		if (GenericUtil.isNullOrEmpty(dett.getS7aFkFrequenzaManut())) {
			validationException
					.addFieldRequired(CPBECpGestRapProvaTipo2Dett.APPDATA_TIPOGFDETT_CODE + ".s7aFkFrequenzaManut");
		} else {
			String frequenzaScelta = mappaFrequenza.get(ConvertUtil.convertToInteger(dett.getS7aFkFrequenzaManut()));
			if ("ALTRO".equalsIgnoreCase(frequenzaScelta)) {
				if (GenericUtil.isNullOrEmpty(dett.getS7aFrequenzaManutAltro())) {
					validationException.addFieldRequired(
							CPBECpGestRapProvaTipo2Dett.APPDATA_TIPOGFDETT_CODE + ".s7aFrequenzaManutAltro");
				} else {
					ValidationMgr.checkAsciiStringMaxLength(dett.getS7aFrequenzaManutAltro(), 50,
							CPBECpGestRapProvaTipo2Dett.APPDATA_TIPOGFDETT_CODE  + ".s7aFrequenzaManutAltro",
							validationException);
				}
			}
		}

		Integer SI = new Integer(1);
		if (GenericUtil.isNullOrEmpty(dett.getS7FlgManutEffettuata())) {
			validationException
					.addFieldRequired(CPBECpGestRapProvaTipo2Dett.APPDATA_TIPOGFDETT_CODE + ".s7FlgManutEffettuata");
		} else if (SI.equals(dett.getS7FlgManutEffettuata())
				&& GenericUtil.isNullOrEmpty(dett.getS7aDataUltimaManut())) {
			validationException
					.addFieldRequired(CPBECpGestRapProvaTipo2Dett.APPDATA_TIPOGFDETT_CODE + ".s7aDataUltimaManut");
		}

		if (GenericUtil.isNullOrEmpty(dett.getS7cFlgReePresente())) {
			validationException
					.addFieldRequired(CPBECpGestRapProvaTipo2Dett.APPDATA_TIPOGFDETT_CODE + ".s7cFlgReePresente");
		} else if (SI.equals(dett.getS7cFlgReePresente()) && GenericUtil.isNullOrEmpty(dett.getS7bDataRee())) {
			validationException.addFieldRequired(CPBECpGestRapProvaTipo2Dett.APPDATA_TIPOGFDETT_CODE + ".s7bDataRee");
		}

		if (!validationException.getFieldList().isEmpty()) {
			throw validationException;
		}

	}

	public void validazioneFormaleRapProvaGFDettCircuito (TipoGFDettCircuito circuito) throws ValidationManagerException {

		preparaToValidate(circuito);

		ValidationManagerException validationException = new ValidationManagerException();

		//almeno uno tra raffrescamento e riscaldamento e' obbligatorio
		if (GenericUtil.isNullOrEmpty(circuito.getS8bFlgProveRaffrescamento())
				&& GenericUtil.isNullOrEmpty(circuito.getS8bFlgProveRiscaldamento())) {
			validationException.addField(CPBECpGestRapProvaTipo2Dett.APPDATA_TIPOGFDETTCIRCUITO_CODE + ".s8bFlgProveRiscaldamento",
					new Message(Messages.ERROR_ALMENO_UN_FLG, "Riscaldamento/Raffrescamento").getText());
			validationException.addField(CPBECpGestRapProvaTipo2Dett.APPDATA_TIPOGFDETTCIRCUITO_CODE + ".s8bFlgProveRaffrescamento",
					new Message(Messages.ERROR_ALMENO_UN_FLG, "Riscaldamento/Raffrescamento").getText());

		}

		if (GenericUtil.isNullOrEmpty(circuito.getS8cFlgFiltriPuliti())) {
			validationException.addFieldRequired(CPBECpGestRapProvaTipo2Dett.APPDATA_TIPOGFDETTCIRCUITO_CODE + ".s8cFlgFiltriPuliti");
		}

		if (GenericUtil.isNullOrEmpty(circuito.getS8dFlgAssenzaPerditeGas())) {
			validationException.addFieldRequired(CPBECpGestRapProvaTipo2Dett.APPDATA_TIPOGFDETTCIRCUITO_CODE + ".s8dFlgAssenzaPerditeGas");
		}

		checkAsciiStringMaxLength(circuito.getS8cMarcaStrumMisura(), 100, CPBECpGestRapProvaTipo2Dett.APPDATA_TIPOGFDETTCIRCUITO_CODE + ".s8cMarcaStrumMisura", validationException);
		checkAsciiStringMaxLength(circuito.getS8cMatricolaStrumMisura(), 30, CPBECpGestRapProvaTipo2Dett.APPDATA_TIPOGFDETTCIRCUITO_CODE + ".s8cMatricolaStrumMisura", validationException);
		checkAsciiStringMaxLength(circuito.getS8cModelloStrumMisura(), 100, CPBECpGestRapProvaTipo2Dett.APPDATA_TIPOGFDETTCIRCUITO_CODE + ".s8cModelloStrumMisura", validationException);

		checkNumero(circuito.getS8fPotAssorbitaKw(), CPBECpGestRapProvaTipo2Dett.APPDATA_TIPOGFDETTCIRCUITO_CODE + ".s8fPotAssorbitaKw", 6, 2, 9, validationException, true);
		checkNumero(circuito.getS8jSottoraffreddamentoK(), CPBECpGestRapProvaTipo2Dett.APPDATA_TIPOGFDETTCIRCUITO_CODE + ".s8jSottoraffreddamentoK", null, null, validationException, true);
		checkNumero(circuito.getS8jSurriscaldamentok(), CPBECpGestRapProvaTipo2Dett.APPDATA_TIPOGFDETTCIRCUITO_CODE + ".s8jSurriscaldamentok", null, null, validationException, true);
		checkNumero(circuito.getS8jTempCondensazioneC(), CPBECpGestRapProvaTipo2Dett.APPDATA_TIPOGFDETTCIRCUITO_CODE + ".s8jTempCondensazioneC", null, null, validationException, true);
		checkNumero(circuito.getS8jTempEvaporazioneC(), CPBECpGestRapProvaTipo2Dett.APPDATA_TIPOGFDETTCIRCUITO_CODE + ".s8jTempEvaporazioneC", null, null, validationException, true);
		checkNumero(circuito.getS8jTempIngressoFluidoC(), CPBECpGestRapProvaTipo2Dett.APPDATA_TIPOGFDETTCIRCUITO_CODE + ".s8jTempIngressoFluidoC", null, null, validationException, true);
		checkNumero(circuito.getS8jTempSorgIngressoC(), CPBECpGestRapProvaTipo2Dett.APPDATA_TIPOGFDETTCIRCUITO_CODE + ".s8jTempSorgIngressoC", null, null, validationException, true);
		checkNumero(circuito.getS8jTempSorgUscitaC(), CPBECpGestRapProvaTipo2Dett.APPDATA_TIPOGFDETTCIRCUITO_CODE + ".s8jTempSorgUscitaC", null, null, validationException, true);
		checkNumero(circuito.getS8jTempUscitaFluidoC(), CPBECpGestRapProvaTipo2Dett.APPDATA_TIPOGFDETTCIRCUITO_CODE + ".s8jTempUscitaFluidoC", null, null, validationException, true);


		if (!validationException.getFieldList().isEmpty()) {
			throw validationException;
		}
	}


	public void validazioneFormaleRapProvaGTDettModulo(TipoGTDettModulo modulo) throws ValidationManagerException {
		preparaToValidate(modulo);

		ValidationManagerException validationException = new ValidationManagerException();

		if (GenericUtil.isNullOrEmpty(modulo.getS8cMarcaStrumMisura())) {
			validationException.addFieldRequired(CPBECpGestRapProvaTipo1Dett.APPDATA_TIPOGTDETTMODULO_CODE + ".s8cMarcaStrumMisura");
		} else {
			ValidationMgr.checkAsciiStringMaxLength(modulo.getS8cMarcaStrumMisura(), 100,CPBECpGestRapProvaTipo1Dett.APPDATA_TIPOGTDETTMODULO_CODE + ".s8cMarcaStrumMisura",validationException);
		}

		if (GenericUtil.isNullOrEmpty(modulo.getS8cMatricolaStrumMisura())) {
			validationException.addFieldRequired(CPBECpGestRapProvaTipo1Dett.APPDATA_TIPOGTDETTMODULO_CODE + ".s8cMatricolaStrumMisura");
		} else {
			ValidationMgr.checkAsciiStringMaxLength(modulo.getS8cMatricolaStrumMisura(), 30,CPBECpGestRapProvaTipo1Dett.APPDATA_TIPOGTDETTMODULO_CODE + ".s8cMatricolaStrumMisura",validationException);
		}

		if (GenericUtil.isNullOrEmpty(modulo.getS8cModelloStrumMisura())) {
			validationException.addFieldRequired(CPBECpGestRapProvaTipo1Dett.APPDATA_TIPOGTDETTMODULO_CODE + ".s8cModelloStrumMisura");
		} else {
			ValidationMgr.checkAsciiStringMaxLength(modulo.getS8cModelloStrumMisura(), 100,CPBECpGestRapProvaTipo1Dett.APPDATA_TIPOGTDETTMODULO_CODE + ".s8cModelloStrumMisura",validationException);
		}

		if (GenericUtil.isNullOrEmpty(modulo.getS8dTempFluidoMandataC())) {
			validationException.addFieldRequired(CPBECpGestRapProvaTipo1Dett.APPDATA_TIPOGTDETTMODULO_CODE + ".s8dTempFluidoMandataC");
		}
		if (GenericUtil.isNullOrEmpty(modulo.getS8dTempAria_c())) {
			validationException.addFieldRequired(CPBECpGestRapProvaTipo1Dett.APPDATA_TIPOGTDETTMODULO_CODE + ".s8dTempAria_c");

		}
		if (GenericUtil.isNullOrEmpty(modulo.getS8dTempFumiC())) {
			validationException.addFieldRequired(CPBECpGestRapProvaTipo1Dett.APPDATA_TIPOGTDETTMODULO_CODE + ".s8dTempFumiC");
		}
		if (GenericUtil.isNullOrEmpty(modulo.getS8dSceltaPerc())) {
			validationException.addFieldRequired(CPBECpGestRapProvaTipo1Dett.APPDATA_TIPOGTDETTMODULO_CODE + ".s8dSceltaPerc");
		} else if (GenericUtil.isNullOrEmpty(modulo.getS8dPerc())) {
			validationException.addFieldRequired(CPBECpGestRapProvaTipo1Dett.APPDATA_TIPOGTDETTMODULO_CODE + ".s8dPerc");
		}

		if (GenericUtil.isNullOrEmpty(modulo.getS8dCoFumiSecchiPpm())) {
			validationException.addFieldRequired(CPBECpGestRapProvaTipo1Dett.APPDATA_TIPOGTDETTMODULO_CODE + ".s8dCoFumiSecchiPpm");
		}

		if (GenericUtil.isNullOrEmpty(modulo.getS8dNoMgKwH())) {
			validationException.addFieldRequired(CPBECpGestRapProvaTipo1Dett.APPDATA_TIPOGTDETTMODULO_CODE + ".s8dNoMgKwH");
		}

		if (GenericUtil.isNullOrEmpty(modulo.getS8eIndiceAria())) {
			validationException.addFieldRequired(CPBECpGestRapProvaTipo1Dett.APPDATA_TIPOGTDETTMODULO_CODE + ".s8eIndiceAria");
		}

		if (GenericUtil.isNullOrEmpty(modulo.getS8eFumiSecchiNoAriaPpm())) {
			validationException.addFieldRequired(CPBECpGestRapProvaTipo1Dett.APPDATA_TIPOGTDETTMODULO_CODE + ".s8eFumiSecchiNoAriaPpm");
		}

		if (GenericUtil.isNullOrEmpty(modulo.getS8eQsPerc())) {
			validationException.addFieldRequired(CPBECpGestRapProvaTipo1Dett.APPDATA_TIPOGTDETTMODULO_CODE + ".s8eQsPerc");
		}

		if (GenericUtil.isNullOrEmpty(modulo.getS8eEtPerc())) {
			validationException.addFieldRequired(CPBECpGestRapProvaTipo1Dett.APPDATA_TIPOGTDETTMODULO_CODE + ".s8eEtPerc");
		}

		if (GenericUtil.isNullOrEmpty(modulo.getS8eRendCombPerc())) {
			validationException.addFieldRequired(CPBECpGestRapProvaTipo1Dett.APPDATA_TIPOGTDETTMODULO_CODE + ".s8eRendCombPerc");
		}

		if (GenericUtil.isNullOrEmpty(modulo.getS8eNoxMgKwH())) {
			validationException.addFieldRequired(CPBECpGestRapProvaTipo1Dett.APPDATA_TIPOGTDETTMODULO_CODE + ".s8eNoxMgKwH");
		}

		if (GenericUtil.isNullOrEmpty(modulo.getS9bFlgFumosita())) {
			validationException.addFieldRequired(CPBECpGestRapProvaTipo1Dett.APPDATA_TIPOGTDETTMODULO_CODE + ".s9bFlgFumosita");
		}

		if (GenericUtil.isNullOrEmpty(modulo.getS9cRendMinCombustPerc())) {
			validationException.addFieldRequired(CPBECpGestRapProvaTipo1Dett.APPDATA_TIPOGTDETTMODULO_CODE + ".s9cRendMinCombustPerc");
		}

		if (GenericUtil.isNullOrEmpty(modulo.getS9dOssidiAzotoLimMgKwH())) {
			validationException.addFieldRequired(CPBECpGestRapProvaTipo1Dett.APPDATA_TIPOGTDETTMODULO_CODE + ".s9dOssidiAzotoLimMgKwH");
		}


		if (GenericUtil.isNotNullOrEmpty(modulo.getS9cRendMinCombustPerc()) && checkNumero(modulo.getS9cRendMinCombustPerc(), CPBECpGestRapProvaTipo1Dett.APPDATA_TIPOGTDETTMODULO_CODE + ".s9cRendMinCombustPerc", 3, 2, 6, validationException, true)
				&& Double.valueOf(modulo.getS9cRendMinCombustPerc().replace(',', '.')).doubleValue() > 100) {
			validationException.addField(CPBECpGestRapProvaTipo1Dett.APPDATA_TIPOGTDETTMODULO_CODE + ".s9cRendMinCombustPerc", new Message(Messages.ERROR_VALORE_MASSIMO, "100").getText());
		}

		checkNumero(modulo.getS9dOssidiAzotoLimMgKwH(), CPBECpGestRapProvaTipo1Dett.APPDATA_TIPOGTDETTMODULO_CODE + ".s9dOssidiAzotoLimMgKwH", 7, 2, 10, validationException, true);

		checkNumero(modulo.getS8bFumoMis1(),CPBECpGestRapProvaTipo1Dett.APPDATA_TIPOGTDETTMODULO_CODE + ".s8bFumoMis1", 6, 2, 9, validationException, true);
		checkNumero(modulo.getS8bFumoMis2(),CPBECpGestRapProvaTipo1Dett.APPDATA_TIPOGTDETTMODULO_CODE + ".s8bFumoMis2", 6, 2, 9,validationException, true);
		checkNumero(modulo.getS8bFumoMis3(),CPBECpGestRapProvaTipo1Dett.APPDATA_TIPOGTDETTMODULO_CODE + ".s8bFumoMis3", 6, 2, 9,validationException, true);
		checkNumero(modulo.getS8dTempFluidoMandataC(),CPBECpGestRapProvaTipo1Dett.APPDATA_TIPOGTDETTMODULO_CODE + ".s8dTempFluidoMandataC", 4, 2, 7,validationException, true);
		checkNumero(modulo.getS8dTempAria_c(),CPBECpGestRapProvaTipo1Dett.APPDATA_TIPOGTDETTMODULO_CODE + ".s8dTempAria_c", 4, 2, 7,validationException, true);
		checkNumero(modulo.getS8dTempFumiC(),CPBECpGestRapProvaTipo1Dett.APPDATA_TIPOGTDETTMODULO_CODE + ".s8dTempFumiC", 4, 2, 7,validationException, true);

		if (GenericUtil.isNotNullOrEmpty(modulo.getS8dPerc()) && checkNumero(modulo.getS8dPerc(), CPBECpGestRapProvaTipo1Dett.APPDATA_TIPOGTDETTMODULO_CODE + ".s8dPerc", 3, 2, 6, validationException, true)
				&& Double.valueOf(modulo.getS8dPerc().replace(',', '.')).doubleValue() > 100) {
			validationException.addField(CPBECpGestRapProvaTipo1Dett.APPDATA_TIPOGTDETTMODULO_CODE + ".s8dPerc", new Message(Messages.ERROR_VALORE_MASSIMO, "100").getText());
		}

		checkNumero(modulo.getS8dCoFumiSecchiPpm(),CPBECpGestRapProvaTipo1Dett.APPDATA_TIPOGTDETTMODULO_CODE + ".s8dCoFumiSecchiPpm", 7, 2, 10,validationException, true);
		checkNumero(modulo.getS8dNoMgKwH(),CPBECpGestRapProvaTipo1Dett.APPDATA_TIPOGTDETTMODULO_CODE + ".s8dNoMgKwH", 7, 2, 10,validationException, true);
		if (GenericUtil.isNotNullOrEmpty(modulo.getS8eEtPerc()) && checkNumero(modulo.getS8eEtPerc(), CPBECpGestRapProvaTipo1Dett.APPDATA_TIPOGTDETTMODULO_CODE + ".s8eEtPerc", 3, 2, 6, validationException, true)
				&&  Double.valueOf(modulo.getS8eEtPerc().replace(',', '.')).doubleValue() > 100) {
			validationException.addField(CPBECpGestRapProvaTipo1Dett.APPDATA_TIPOGTDETTMODULO_CODE + ".s8eEtPerc", new Message(Messages.ERROR_VALORE_MASSIMO, "100").getText());
		}


		checkNumero(modulo.getS8eFumiSecchiNoAriaPpm(),CPBECpGestRapProvaTipo1Dett.APPDATA_TIPOGTDETTMODULO_CODE + ".s8eFumiSecchiNoAriaPpm",  7, 2, 10,validationException, true);
		checkNumero(modulo.getS8eIndiceAria(),CPBECpGestRapProvaTipo1Dett.APPDATA_TIPOGTDETTMODULO_CODE + ".s8eIndiceAria", null, null,validationException, true);
		checkNumero(modulo.getS8eNoxMgKwH(),CPBECpGestRapProvaTipo1Dett.APPDATA_TIPOGTDETTMODULO_CODE + ".s8eNoxMgKwH", 7, 2, 10,validationException, true);
		if (GenericUtil.isNotNullOrEmpty(modulo.getS8eQsPerc()) && checkNumero(modulo.getS8eQsPerc(), CPBECpGestRapProvaTipo1Dett.APPDATA_TIPOGTDETTMODULO_CODE + ".s8eQsPerc", 3, 2, 6, validationException, true)
				&&  Double.valueOf(modulo.getS8eQsPerc().replace(',', '.')).doubleValue() > 100) {
			validationException.addField(CPBECpGestRapProvaTipo1Dett.APPDATA_TIPOGTDETTMODULO_CODE + ".s8eQsPerc", new Message(Messages.ERROR_VALORE_MASSIMO, "100").getText());
		}

		if (GenericUtil.isNotNullOrEmpty(modulo.getS8eRendCombPerc()) && checkNumero(modulo.getS8eRendCombPerc(), CPBECpGestRapProvaTipo1Dett.APPDATA_TIPOGTDETTMODULO_CODE + ".s8eRendCombPerc", 3, 2, 6, validationException, true)
				&&  Double.valueOf(modulo.getS8eRendCombPerc().replace(',', '.')).doubleValue() > 100) {
			validationException.addField(CPBECpGestRapProvaTipo1Dett.APPDATA_TIPOGTDETTMODULO_CODE + ".s8eRendCombPerc", new Message(Messages.ERROR_VALORE_MASSIMO, "100").getText());
		}

		if (!validationException.getFieldList().isEmpty()) {
			throw validationException;
		}

	}



	public void validazioneFormaleRapProvaGTDett(TipoGTDett dett, Map<Integer, String> mappaFrequenza)
			throws ValidationManagerException {

		ValidationManagerException validationException = new ValidationManagerException();

		preparaToValidate(dett);

		//combo modalita evaq
		if (GenericUtil.isNullOrEmpty(dett.getS6dFlgEvacuFumi())) {
			validationException
					.addFieldRequired(CPBECpGestRapProvaTipo1Dett.APPDATA_TIPOGTDETT_CODE + ".s6dFlgEvacuFumi");
		}

		//potenza termica
		if (GenericUtil.isNullOrEmpty(dett.getS6kPotTermFocolKw())) {
			validationException
					.addFieldRequired(CPBECpGestRapProvaTipo1Dett.APPDATA_TIPOGTDETT_CODE + ".s6kPotTermFocolKw");
		}

		if (GenericUtil.isNullOrEmpty(dett.getS7aFkFrequenzaManut())) {
			validationException
					.addFieldRequired(CPBECpGestRapProvaTipo1Dett.APPDATA_TIPOGTDETT_CODE + ".s7aFkFrequenzaManut");
		} else {
			String frequenzaScelta = mappaFrequenza.get(ConvertUtil.convertToInteger(dett.getS7aFkFrequenzaManut()));
			if ("ALTRO".equalsIgnoreCase(frequenzaScelta)) {
				if (GenericUtil.isNullOrEmpty(dett.getS7aFrequenzaManutAltro())) {
					validationException.addFieldRequired(
							CPBECpGestRapProvaTipo1Dett.APPDATA_TIPOGTDETT_CODE + ".s7aFrequenzaManutAltro");
				} else {
					ValidationMgr.checkAsciiStringMaxLength(dett.getS7aFrequenzaManutAltro(), 50,
							CPBECpGestRapProvaTipo1Dett.APPDATA_TIPOGTDETT_CODE + ".s7aFrequenzaManutAltro",
							validationException);
				}
			}
		}
		Integer SI = new Integer(1);

		if (GenericUtil.isNullOrEmpty(dett.getS7aFlgManutEffettuata())) {
			validationException
					.addFieldRequired(CPBECpGestRapProvaTipo1Dett.APPDATA_TIPOGTDETT_CODE + ".s7aFlgManutEffettuata");
		} else if (SI.equals(dett.getS7aFlgManutEffettuata())
				&& GenericUtil.isNullOrEmpty(dett.getS7aDataUltimaManut())) {
			validationException
					.addFieldRequired(CPBECpGestRapProvaTipo1Dett.APPDATA_TIPOGTDETT_CODE + ".s7aDataUltimaManut");
		}

		if (GenericUtil.isNullOrEmpty(dett.getS7bFlgReePresente())) {
			validationException
					.addFieldRequired(CPBECpGestRapProvaTipo1Dett.APPDATA_TIPOGTDETT_CODE + ".s7bFlgReePresente");
		} else if (SI.equals(dett.getS7bFlgReePresente()) && GenericUtil.isNullOrEmpty(dett.getS7bDataRee())) {
			validationException.addFieldRequired(CPBECpGestRapProvaTipo1Dett.APPDATA_TIPOGTDETT_CODE + ".s7bDataRee");
		}

		boolean bruciatoreDaValorizzato = false;
		boolean bruciatoreAValorizzato = false;
		boolean bruciatoreDaCorretto = false;
		boolean bruciatoreACorretto = false;
		if (GenericUtil.isNotNullOrEmpty(dett.getS6kBruciatoreDaKw())) {
			bruciatoreDaCorretto = checkNumero(dett.getS6kBruciatoreDaKw(),
					CPBECpGestRapProvaTipo1Dett.APPDATA_TIPOGTDETT_CODE + ".s6kBruciatoreDaKw", 6, 2, 9,
					validationException, true);
			bruciatoreDaValorizzato = true;
		}

		if (GenericUtil.isNotNullOrEmpty(dett.getS6kBruciatoreAKw())) {
			bruciatoreACorretto = checkNumero(dett.getS6kBruciatoreAKw(),
					CPBECpGestRapProvaTipo1Dett.APPDATA_TIPOGTDETT_CODE + ".s6kBruciatoreAKw", 6, 2, 9,
					validationException, true);
			bruciatoreAValorizzato = true;
		}

		if (bruciatoreAValorizzato && bruciatoreDaValorizzato && bruciatoreACorretto && bruciatoreDaCorretto) {
			BigDecimal a = ConvertUtil.convertToBigDecimal(dett.getS6kBruciatoreAKw());
			BigDecimal da = ConvertUtil.convertToBigDecimal(dett.getS6kBruciatoreDaKw());

			if (da.compareTo(a) > 0) {
				validationException.addField(CPBECpGestRapProvaTipo1Dett.APPDATA_TIPOGTDETT_CODE + ".s6kBruciatoreDaKw",
						new Message(Messages.ERROR_CONFRONTO_VALORI, "da", "a").getText());
				validationException.addField(CPBECpGestRapProvaTipo1Dett.APPDATA_TIPOGTDETT_CODE + ".s6kBruciatoreAKw",
						new Message(Messages.ERROR_CONFRONTO_VALORI, "da", "a").getText());
			}
		}

		checkNumero(dett.getS6kPotTermFocolKw(),
				CPBECpGestRapProvaTipo1Dett.APPDATA_TIPOGTDETT_CODE + ".s6kPotTermFocolKw", 6, 2, 9,
				validationException, true);
		checkNumero(dett.getS6lPortataCombKgH(),
				CPBECpGestRapProvaTipo1Dett.APPDATA_TIPOGTDETT_CODE + ".s6lPortataCombKgH", 6, 2, 9,
				validationException, true);
		checkNumero(dett.getS6lPortataCombM3H(),
				CPBECpGestRapProvaTipo1Dett.APPDATA_TIPOGTDETT_CODE + ".s6lPortataCombM3H", 6, 2, 9,
				validationException, true);
		checkNumero(dett.getS6lPotTermFocolKw(),
				CPBECpGestRapProvaTipo1Dett.APPDATA_TIPOGTDETT_CODE + ".s6lPotTermFocolKw", 6, 2, 9,
				validationException, true);

		if (!validationException.getFieldList().isEmpty()) {
			throw validationException;
		}

	}

	public void validaPagamentoSanzione (String dataPagamento, String dataComunicazione) throws ValidationManagerException {

		ValidationManagerException valEx = new ValidationManagerException();
		if (GenericUtil.isNullOrEmpty(dataPagamento)) {
			valEx.addFieldRequired(CPBECpDettaglioSanzione.APPDATA_DATAPAGAMENTO_CODE);
			throw valEx;
		} else  {
			isDataFutura(dataPagamento, CPBECpDettaglioSanzione.APPDATA_DATAPAGAMENTO_CODE);

			Date dataNotifica = null;
			Date dataPag = null;
			try {
				dataNotifica = ConvertUtil.convertToDate(dataComunicazione);
				dataPag = ConvertUtil.convertToDate(dataPagamento);

				if (dataPag.getTime() < dataNotifica.getTime()) {
					valEx.addField(CPBECpDettaglioSanzione.APPDATA_DATAPAGAMENTO_CODE, "Errore: la data di pagamento non puo' precedere la data di notifica");
					throw valEx;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void validazioneFormaleAggMailGruppo(String mailGruppo) throws ValidationManagerException {
		log.debug("[ValidationMgr::validazioneFormaleAggMailGruppo] BEGIN");


		ValidationManagerException ex = new ValidationManagerException();

		if(GenericUtil.isNullOrEmpty(mailGruppo) )
		{
			ex.addFieldRequired("appDatanewMail");
			throw ex;
		}
		else if(!GenericUtil.checkValideEmail(mailGruppo))
		{
			ex.addField("appDatanewMail",Messages.ERROR_EMAIL_FORMAT);
			throw ex;
		}


		log.debug("[ValidationMgr::validazioneFormaleAggMailGruppo] END");
	}


	public void validazioneFormaleAbilitazione(Abilitazione abilitazione) throws ValidationManagerException {

		log.debug("[ValidationMgr::validazioneFormaleAbilitazione] BEGIN");

		preparaToValidate(abilitazione);


		ValidationManagerException ex = new ValidationManagerException();

		final String APP_DATA_NAME = "appDataabilitazione.";


		if (GenericUtil.isNullOrEmpty(abilitazione.getIdRuoloPa())) {
			ex.addFieldRequired(APP_DATA_NAME + "idRuoloPa");

		}

		if (GenericUtil.isNullOrEmpty(abilitazione.getIdPersonaFisica())) {
			ex.addFieldRequired(APP_DATA_NAME + "idPersonaFisica");

		}

		if (GenericUtil.isNullOrEmpty(abilitazione.getIstatAbilitazione())) {
			ex.addFieldRequired(APP_DATA_NAME + "istatAbilitazione");
		} else {
			checkNumeroIntero(abilitazione.getIstatAbilitazione(), APP_DATA_NAME + "istatAbilitazione", 6);

			if (abilitazione.getIstatAbilitazione().length() != 2 &&
					abilitazione.getIstatAbilitazione().length() != 3 &&
					abilitazione.getIstatAbilitazione().length() != 6)
			{
				ex.addField(APP_DATA_NAME + "istatAbilitazione", Messages.ERROR_VALORE_FORMALE);
			}
		}

		checkAsciiStringMaxLength(abilitazione.getNote(), 500, APP_DATA_NAME + "note", ex);

		checkUnivocitaAbilitazione(abilitazione);

		if(!ex.getFieldList().isEmpty()){
			throw ex;
		}

		log.debug("[ValidationMgr::validazioneFormaleAbilitazione] END");


	}

	public void validazioneFormaleUpdateFile(File file, String nomeFile, String contType) throws ValidationManagerException {

		log.debug("[ValidationMgr::validazioneFormaleUpdateFile] BEGIN");

		try
		{
			String mimeTypeFile = getSigitMgr().getMimeTypeFile(file);
			if (!checkMimeTypeDocumento(mimeTypeFile)) {
				throw new ValidationManagerException(new Message(Messages.S095));
			}

			validazioneNomeFile(nomeFile);

			validazioneDimensioneFile(file);
		}
		catch (ValidationManagerException ex) {
			throw ex;
		}
		catch (DbManagerException ex) {
			throw new ValidationManagerException(new Message(Messages.ERROR_RECUPERO_DB));
		}
		catch (ManagerException ex) {
			throw new ValidationManagerException(new Message(Messages.ERROR_RECUPERO_SERVIZIO));
		}

		log.debug("[ValidationMgr::validazioneFormaleUpdateFile] END");


	}

	public void validazioneFormaleFileRappProvaFirmato(File file, String nomeFile, String contType) throws ValidationManagerException {

		log.debug("[ValidationMgr::validazioneFormaleUpdateFile] BEGIN");

		try
		{
			validazioneEstensioneRappProvaFirmato(nomeFile);

			validazioneNomeFile(nomeFile);

			validazioneDimensioneFile(file);
		}
		catch (ValidationManagerException ex) {
			throw ex;
		}
		catch (DbManagerException ex) {
			throw new ValidationManagerException(new Message(Messages.ERROR_RECUPERO_DB));
		}
		catch (ManagerException ex) {
			throw new ValidationManagerException(new Message(Messages.ERROR_RECUPERO_SERVIZIO));
		}

		log.debug("[ValidationMgr::validazioneFormaleUpdateFile] END");


	}


	private void validazioneNomeFile(String nomeFile) throws ValidationManagerException {
		if (nomeFile.length() > Constants.MAX_NOME_FILE_LEN) {
			throw new ValidationManagerException(new Message(Messages.S160,
					ConvertUtil.convertToString(Constants.MAX_NOME_FILE_LEN)));
		}
	}

	private void validazioneDimensioneFile(File file) throws DbManagerException, ValidationManagerException {
		Integer maxMB = getDbMgr().cercaConfigValueNumerico(Constants.MAX_MB_DOC);
		Integer maxByte = GenericUtil.getByteToMb(maxMB);

		if (file.length() > maxByte) {
			throw new ValidationManagerException(
					new Message(Messages.S156, ConvertUtil.convertToString(maxMB)));
		}
	}

	private void validazioneEstensioneRappProvaFirmato(String nomeFile) throws ManagerException {
		String estensioneFile = FilenameUtils.getExtension(nomeFile);

		if (!Arrays.stream(Constants.ESTENSIONI_PERMESSE_FILE_RAPP_PROVA_FIRMATO).anyMatch(estensioneFilePermessa -> estensioneFilePermessa.equalsIgnoreCase(estensioneFile))) {
			throw new ValidationManagerException(new Message(Messages.S095));
		}
	}

	public void verificaRicercaImpresaAttuale(PersonaGiuridica impresa) throws ManagerException {


		log.debug("[ValidationMgr::verificaRicercaImpresaAttuale] BEGIN");

		preparaToValidate(impresa);

		//verifica sulla presenza di almeno un criterio di ricerca
		if (	!GenericUtil.isObjPopulate(impresa) ){
			// Non e' stato impostato nessun paramentro
			throw new ValidationManagerException(new Message(Messages.S010));
		}

		// Se e' stato inserita la sigla REA deve essere compilato anche il
		// numero REA e viceversa
		checkSiglaAndNumeroRea(impresa.getSiglaRea(), impresa.getNumeroRea(), CPBECpGestSubentroMassivo.APPDATA_IMPRESAATTUALE_CODE + ".siglaRea",
				CPBECpGestSubentroMassivo.APPDATA_IMPRESAATTUALE_CODE + ".numeroRea");

		checkCodiceFiscalePartitaIva(impresa.getCodiceFiscale(), CPBECpGestSubentroMassivo.APPDATA_IMPRESAATTUALE_CODE + ".codiceFiscale");


		log.debug("[ValidationMgr::verificaRicercaImpresaAttuale] END");
	}

	public void verificaRicercaImpresaSubentro(PersonaGiuridica impresa) throws ManagerException {


		log.debug("[ValidationMgr::verificaRicercaImpresaSubentro] BEGIN");

		preparaToValidate(impresa);

		//verifica sulla presenza di almeno un criterio di ricerca
		if (	!GenericUtil.isObjPopulate(impresa) ){
			// Non e' stato impostato nessun paramentro
			throw new ValidationManagerException(new Message(Messages.S010));
		}

		// Se e' stato inserita la sigla REA deve essere compilato anche il
		// numero REA e viceversa
		checkSiglaAndNumeroRea(impresa.getSiglaRea(), impresa.getNumeroRea(), CPBECpGestSubentroMassivo.APPDATA_IMPRESASUBENTRO_CODE + ".siglaRea",
				CPBECpGestSubentroMassivo.APPDATA_IMPRESASUBENTRO_CODE + ".numeroRea");

		checkCodiceFiscalePartitaIva(impresa.getCodiceFiscale(), CPBECpGestSubentroMassivo.APPDATA_IMPRESASUBENTRO_CODE + ".codiceFiscale");


		log.debug("[ValidationMgr::verificaRicercaImpresaSubentro] END");
	}

	public void verificaSubentroMassivo(Integer idPgAttuale, Integer idPgSubentro, Integer idTipoSubentro) throws ManagerException {


		log.debug("[ValidationMgr::verificaSubentroMassivo] BEGIN");


		ValidationManagerException ex = new ValidationManagerException();

		if (GenericUtil.isNullOrEmpty(idPgAttuale)) {
			ex.addFieldRequired(CPBECpGestSubentroMassivo.APPDATA_IMPRESAATTUALE_CODE + ".idPersonaGiuridica");
		}

		if (GenericUtil.isNullOrEmpty(idPgSubentro)) {
			ex.addFieldRequired(CPBECpGestSubentroMassivo.APPDATA_IMPRESASUBENTRO_CODE + ".idPersonaGiuridica");
		}

		if (GenericUtil.isNullOrEmpty(idTipoSubentro)) {
			ex.addFieldRequired(CPBECpGestSubentroMassivo.APPDATA_IDTIPOSUBENTRO_CODE);
		}

		if(!ex.getFieldList().isEmpty()){
			throw ex;
		}

		if (idPgAttuale.intValue() == idPgSubentro.intValue())
		{
			ex = new ValidationManagerException(new Message("le due imprese non possono coincidere"));
			ex.addField(CPBECpGestSubentroMassivo.APPDATA_IMPRESAATTUALE_CODE + ".idPersonaGiuridica");
			ex.addField(CPBECpGestSubentroMassivo.APPDATA_IMPRESASUBENTRO_CODE + ".idPersonaGiuridica");
			throw ex;
		}


		log.debug("[ValidationMgr::verificaSubentroMassivo] END");
	}

	public void checkElaboratoUltimoAnno(Integer elementoSelezionato, List<DettaglioImportDistributori> listImport, String message) throws Exception {
		DettaglioImportDistributori dettaglioTemp = null;
		for(DettaglioImportDistributori dettaglio : listImport) {
			if(dettaglio.getIdFileInviato().equals(elementoSelezionato)) {
				dettaglioTemp = dettaglio;
				break;
			}
		}
		if(dettaglioTemp != null && !checkDataElaborataUltimoAnno(dettaglioTemp.getDataInizioElab()))
			throw new ValidationManagerException(new Message(message));
	}

	public boolean checkDataElaborataUltimoAnno(String dataInizioElab) throws Exception{
		Date dataControllo = ConvertUtil.convertToDate(dataInizioElab);
		dataControllo = DateUtils.addYears(dataControllo, 1);
		return dataControllo.getTime() > System.currentTimeMillis();
	}

	private void checkUnivocitaAbilitazione(Abilitazione abilitazione) throws ValidationManagerException {

		String istatAbilitazione = GenericUtil.aggiungiCodIstatPiemonteAIstatAbilitazione(abilitazione.getIstatAbilitazione());

		SigitRPfRuoloPaDto filter = new SigitRPfRuoloPaDto();
		filter.setIdPersonaFisica(ConvertUtil.convertToBigDecimal(abilitazione.getIdPersonaFisica()));
		filter.setIdRuoloPa(abilitazione.getIdRuoloPa());
		filter.setIstatAbilitazione(ReplaceSpecialCharUtils.sanitize(istatAbilitazione));

		try {
			List<SigitRPfRuoloPaAllActiveDto> abilitazioniRuoloPa = getDbMgr().getElencoAbilitazioniAttiveByFilter(filter);

			if (abilitazioniRuoloPa != null && abilitazioniRuoloPa.size() > 0) {
				throw new ValidationManagerException(new Message(Messages.ABILITAZIONE_RUOLO_PA_NON_UNIVOCA));
			}
		} catch (DbManagerException e) {
			throw new ValidationManagerException(new Message(Messages.ERROR_RECUPERO_DB));
		}

	}

	public void verificaDataScadenzaToken(UserWs userWs) throws ValidationManagerException {
		log.debug("[ValidationMgr::verificaDataScadenzaToken] BEGIN");

		ValidationManagerException ex = new ValidationManagerException();

		if (userWs.getIdUserWs() == null) {
			ex.addFieldRequired(ConstantsField.USER_WS_TOKEN_ID_USER_WS_SELECTED);
		}

		isDataPassata(userWs.getDtScadenzaToken(), ConstantsField.USER_WS_TOKEN_DATA_SCADENZA, ex);

		if(!ex.getFieldList().isEmpty()){
			throw ex;
		}

		log.debug("[ValidationMgr::verificaDataScadenzaToken] END");

	}

	public void verificaDatiInserimentoIspezioniMassive(InserimentoIspezioniMassive datiInsIspMas) throws ValidationManagerException {
		log.debug("[ValidationMgr::verificaDatiInserimentoIspezioniMassive] BEGIN");

		ValidationManagerException ex = new ValidationManagerException();

		if (GenericUtil.isNullOrEmpty(datiInsIspMas.getIdTipoVerifica())) {
			ex.addFieldRequired(ConstantsField.INSERIMENTO_ISPEZIONI_MASSIVE_ID_TIPO_VERIFICA);
		}

		if (GenericUtil.isNullOrEmpty(datiInsIspMas.getElencoValori())) {
			ex.addFieldRequired(ConstantsField.INSERIMENTO_ISPEZIONI_MASSIVE_ELENCO_VALORI);
		}

		if(!ex.getFieldList().isEmpty()){
			throw ex;
		}

		log.debug("[ValidationMgr::verificaDatiInserimentoIspezioniMassive] END");
	}


	public List<String> verificaCodiciImpianto(List<String> codiciImpianto) {

		List<String> codiciImpiantoNonValidi = new ArrayList<String>();

		for (String codiceImpianto : codiciImpianto) {

			try {
				SigitTImpiantoPk impiantoPK = new SigitTImpiantoPk(ConvertUtil.convertToBigDecimal(codiceImpianto));

				SigitTImpiantoDto impianto = getDbMgr().getSigitTImpiantoDao().findByPrimaryKey(impiantoPK);

				if (impianto == null) {
					codiciImpiantoNonValidi.add(codiceImpianto);
				}

			} catch (Exception e) {
				log.error(e);
				codiciImpiantoNonValidi.add(codiceImpianto);
			}

		}

		codiciImpianto.removeAll(codiciImpiantoNonValidi);

		return codiciImpiantoNonValidi;
	}

	public List<String> verificaIdDatiDistributore(List<String> idDatiDistributore) {

		List<String> idDatiDistributoreNonValidi = new ArrayList<String>();

		for (String idDatoDistributore : idDatiDistributoreNonValidi) {

			try {
				SigitTDatoDistribPk datoDistributorePK = new SigitTDatoDistribPk(ConvertUtil.convertToInteger(idDatoDistributore));

				SigitTDatoDistribDto datoDistributore = getDbMgr().getSigitTDatoDistribDao().findByPrimaryKey(datoDistributorePK);

				if (datoDistributore == null) {
					idDatiDistributoreNonValidi.add(idDatoDistributore);
				}

			} catch (Exception e) {
				log.error(e);
				idDatiDistributoreNonValidi.add(idDatoDistributore);
			}

		}

		idDatiDistributore.removeAll(idDatiDistributoreNonValidi);

		return idDatiDistributoreNonValidi;
	}
}

