/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitwebn.business.manager;



import it.csi.csi.wrapper.UnrecoverableException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitDCategoriaDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitDCombustibileDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitDDettaglioVmDaoException;
//import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitDDm37_2008DaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitDFluidoDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitDMarcaDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitDRuoloAccredDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitDRuoloDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitDStatoImpDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitDStatoPgDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitDStatoRappDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitDTipoDocumentoDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitDTipoInterventoDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitDUnitaMisuraDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitExtDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitRComp4ManutDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitRImpRuoloPfpgDaoException;
//import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitRImpiantoContrattoDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitRPfPgDelegaDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitRPgPgNominaDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitRRuoloTipodocDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitTAllTxtDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitTAllegatoDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitTCodiceBollDaoException;
//import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitTCodiceImpDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitTComp4DaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitTCompAcDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitTCompAgDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitTCompBrRcDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitTCompCgDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitTCompCiDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitTCompCsDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitTCompGfDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitTCompGtDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitTCompPoDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitTCompRcDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitTCompRvDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitTCompScDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitTCompScxDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitTCompSrDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitTCompTeDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitTCompUtDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitTCompVmDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitTCompVrDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitTCompVxDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitTCompXDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitTCompXSempliceDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitTConsumo14_4DaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitTConsumoDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitTControlloLibrettoDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitTDocAggiuntivaDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitTImpiantoDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitTImportDistribDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitTLibTxtDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitTLibrettoDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitTLogDistribDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitTPersonaFisicaDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitTPersonaGiuridicaDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitTStoricoVarStatoPgDaoException;
//import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitTTransazioneBollDaoException;
//import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitTTransazioneImpDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitTTrattH2ODaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitTUnitaImmobiliareDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitTmpLibrettoDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitVAllegatiComponentiDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitVCompCgDettDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitVCompGfDettDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitVCompGtDettDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitVCompScDettDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitVPfPgDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitVPotenzaPrezzoDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitVRicerca3ResponsabileDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitVRicercaAllegatiDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitVRicercaCompDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitVRicercaImpiantiDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitVRicercaIspezioniDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitVSk4CgDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitVSk4GfDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitVSk4GtDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitVSk4ScDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitVTotImpiantoDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitWrkConfigDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitWrkRuoloFunzDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.AllegatiCompFilter;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.CodiceReaAndFiscaleAndDenomFilter;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.CodiceReaAndFiscaleFilter;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.CompFilter;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.ContrattoFilter;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.DelegaFilter;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.FiltroRicercaAllegati;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.ImpiantoFilter;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.ImportDistribFilter;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.ImportFilter;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.IspezioneFilter;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.LibrettoFilter;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.PersonaRuoloFilter;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.ResponsabileFilter;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.RicercaAvanzataImpiantoFilter;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.SubentroFilter;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.TransazioneFilter;
import it.csi.sigit.sigitwebn.business.manager.util.DbManagerException;
import it.csi.sigit.sigitwebn.business.manager.util.ManagerException;
import it.csi.sigit.sigitwebn.business.manager.util.Message;
import it.csi.sigit.sigitwebn.business.manager.util.ServiceException;
import it.csi.sigit.sigitwebn.business.manager.util.ValidationManagerException;
import it.csi.sigit.sigitwebn.dto.accesso.AbilitazioniRuoloFunz;
import it.csi.sigit.sigitwebn.dto.accesso.PersonaFisica;
import it.csi.sigit.sigitwebn.dto.accesso.PersonaGiuridica;
import it.csi.sigit.sigitwebn.dto.allegati.DettaglioAllegato;
import it.csi.sigit.sigitwebn.dto.allegati.FiltroControlloInserisciAllegato;
import it.csi.sigit.sigitwebn.dto.allegati.FiltroRicercaCodiciImpianto;
import it.csi.sigit.sigitwebn.dto.bollini.AcquistoBollini;
import it.csi.sigit.sigitwebn.dto.bollini.AcquistoBolliniQuantita;
import it.csi.sigit.sigitwebn.dto.bollini.TransazioneApp;
import it.csi.sigit.sigitwebn.dto.bollini.TransazioneBollini;
import it.csi.sigit.sigitwebn.dto.codici_impianto.AcquisizioneCodici;
import it.csi.sigit.sigitwebn.dto.common.CodeDescription;
import it.csi.sigit.sigitwebn.dto.delega.Delegato;
import it.csi.sigit.sigitwebn.dto.distributori.DettaglioImportDistributori;
import it.csi.sigit.sigitwebn.dto.impianto.Impianto;
import it.csi.sigit.sigitwebn.dto.impianto.Responsabile;
import it.csi.sigit.sigitwebn.dto.impianto.RisultatoRicManutentore;
import it.csi.sigit.sigitwebn.dto.impianto.RisultatoRicResponsabile;
import it.csi.sigit.sigitwebn.dto.impresa.RicercaImprese;
import it.csi.sigit.sigitwebn.dto.incarico.Incaricato;
import it.csi.sigit.sigitwebn.dto.ispezioni.DettaglioIspezione;
import it.csi.sigit.sigitwebn.dto.libretto.ComponenteAC;
import it.csi.sigit.sigitwebn.dto.libretto.ComponenteAG;
import it.csi.sigit.sigitwebn.dto.libretto.ComponenteCI;
import it.csi.sigit.sigitwebn.dto.libretto.ComponenteCS;
import it.csi.sigit.sigitwebn.dto.libretto.ComponentePO;
import it.csi.sigit.sigitwebn.dto.libretto.ComponenteRC;
import it.csi.sigit.sigitwebn.dto.libretto.ComponenteRV;
import it.csi.sigit.sigitwebn.dto.libretto.ComponenteSCX;
import it.csi.sigit.sigitwebn.dto.libretto.ComponenteSR;
import it.csi.sigit.sigitwebn.dto.libretto.ComponenteTE;
import it.csi.sigit.sigitwebn.dto.libretto.ComponenteUT;
import it.csi.sigit.sigitwebn.dto.libretto.ComponenteVM;
import it.csi.sigit.sigitwebn.dto.libretto.ComponenteVR;
import it.csi.sigit.sigitwebn.dto.libretto.Consumo;
import it.csi.sigit.sigitwebn.dto.libretto.ControlloLibretto;
import it.csi.sigit.sigitwebn.dto.libretto.DatiExtra;
import it.csi.sigit.sigitwebn.dto.libretto.PkTabellaEdit;
import it.csi.sigit.sigitwebn.dto.libretto.Scheda1;
import it.csi.sigit.sigitwebn.dto.main.UtenteLoggato;
import it.csi.sigit.sigitwebn.dto.subentro.Subentro;
import it.csi.sigit.sigitwebn.dto.terzoresponsabile.TerzoResponsabile;
import it.csi.sigit.sigitwebn.util.Constants;
import it.csi.sigit.sigitwebn.util.ConvertUtil;
import it.csi.sigit.sigitwebn.util.DateUtil;
import it.csi.sigit.sigitwebn.util.GenericUtil;
import it.csi.sigit.sigitwebn.util.MapDto;
import it.csi.sigit.sigitwebn.util.MapDtoImport;
import it.csi.sigit.sigitwebn.util.Messages;
import it.csi.sigit.sigitwebn.util.XmlBeanUtils;
import it.csi.sigit.sigitwebn.xml.allegato2.data.MODIIDocument;
import it.csi.sigit.sigitwebn.xml.allegato2.data.RowAllegatoIIDocument.RowAllegatoII;
import it.csi.sigit.sigitwebn.xml.allegato3.data.MODIIIDocument;
import it.csi.sigit.sigitwebn.xml.allegato3.data.RowAllegatoIIIDocument.RowAllegatoIII;
import it.csi.sigit.sigitwebn.xml.allegato4.data.MODIVDocument;
import it.csi.sigit.sigitwebn.xml.allegato4.data.RowAllegatoIVDocument.RowAllegatoIV;
import it.csi.sigit.sigitwebn.xml.allegato5.data.MODVDocument;
import it.csi.sigit.sigitwebn.xml.allegato5.data.RowAllegatoVDocument.RowAllegatoV;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L1SchedaIdentificativaDocument.L1SchedaIdentificativa;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L2TrattamentoAcquaDocument.L2TrattamentoAcqua;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L41GruppoTermicoSostituitoDocument.L41GruppoTermicoSostituito;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L42BruciatoreSostituitoDocument.L42BruciatoreSostituito;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L43RecuperatoreSostituitoDocument.L43RecuperatoreSostituito;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L44GruppoFrigoSostituitoDocument.L44GruppoFrigoSostituito;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L45ScambiatoreSostituitoDocument.L45ScambiatoreSostituito;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L46CogeneratoreSostituitoDocument.L46CogeneratoreSostituito;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L47CampoSolareTermicoSostituitoDocument.L47CampoSolareTermicoSostituito;
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
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L81AccumuloSostituitoDocument.L81AccumuloSostituito;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L8SistemiAccumuloDocument.L8SistemiAccumulo;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L8SistemiAccumuloDocument.L8SistemiAccumulo.L81AC;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L91TorreSostituitoDocument.L91TorreSostituito;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L92RaffreddatoreSostituitoDocument.L92RaffreddatoreSostituito;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L93ScambiatoreIntermedioSostituitoDocument.L93ScambiatoreIntermedioSostituito;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L94CircuitoSostituitoDocument.L94CircuitoSostituito;
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
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.LibrettoDocument;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L101VentilazioneMeccanicaSostituitoDocument.L101VentilazioneMeccanicaSostituito;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L10VentilazioneDocument.L10Ventilazione;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L10VentilazioneDocument.L10Ventilazione.L101VM;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L141DatiConsumoCombustibileDocument.L141DatiConsumoCombustibile;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L142DatiConsumoEnergiaElettricaDocument.L142DatiConsumoEnergiaElettrica;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L143DatiConsumoAcquaDocument.L143DatiConsumoAcqua;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L144DatiConsumoProdottiChimiciDocument.L144DatiConsumoProdottiChimici;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L14ConsumiDocument.L14Consumi;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L14ConsumiDocument.L14Consumi.L141ConsumoCombustibile;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L14ConsumiDocument.L14Consumi.L142ConsumoEnergiaElettrica;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L14ConsumiDocument.L14Consumi.L143ConsumoAcqua;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L14ConsumiDocument.L14Consumi.L144ConsumoProdottiChimici;
import it.csi.sigit.sigitwebn.xml.libretto.data.DatiAltriComponentiCIDocument.DatiAltriComponentiCI;
import it.csi.sigit.sigitwebn.xml.libretto.data.DatiAltriComponentiCIDocument.DatiAltriComponentiCI.SezCI;
import it.csi.sigit.sigitwebn.xml.libretto.data.DatiAltriComponentiRCDocument.DatiAltriComponentiRC;
import it.csi.sigit.sigitwebn.xml.libretto.data.DatiAltriComponentiRCDocument.DatiAltriComponentiRC.SezRC;
import it.csi.sigit.sigitwebn.xml.libretto.data.DatiAltriComponentiRVDocument.DatiAltriComponentiRV;
import it.csi.sigit.sigitwebn.xml.libretto.data.DatiAltriComponentiRVDocument.DatiAltriComponentiRV.SezRV;
import it.csi.sigit.sigitwebn.xml.libretto.data.DatiAltriComponentiSCDocument.DatiAltriComponentiSC;
import it.csi.sigit.sigitwebn.xml.libretto.data.DatiAltriComponentiSCDocument.DatiAltriComponentiSC.SezSC;
import it.csi.sigit.sigitwebn.xml.libretto.data.DatiAltriComponentiTEDocument.DatiAltriComponentiTE;
import it.csi.sigit.sigitwebn.xml.libretto.data.DatiAltriComponentiTEDocument.DatiAltriComponentiTE.SezTE;
import it.csi.sigit.sigitwebn.xml.libretto.data.DatiAltriComponentiUTDocument.DatiAltriComponentiUT;
import it.csi.sigit.sigitwebn.xml.libretto.data.DatiAltriComponentiUTDocument.DatiAltriComponentiUT.SezUT;
import it.csi.sigit.sigitwebn.xml.libretto.data.DatiConsumoCombuDocument.DatiConsumoCombu;
import it.csi.sigit.sigitwebn.xml.libretto.data.DatiConsumoCombuDocument.DatiConsumoCombu.SezCombu;
import it.csi.sigit.sigitwebn.xml.libretto.data.DatiConsumoEEDocument.DatiConsumoEE;
import it.csi.sigit.sigitwebn.xml.libretto.data.DatiConsumoEEDocument.DatiConsumoEE.SezConsumo;
import it.csi.sigit.sigitwebn.xml.libretto.data.DatiConsumoH2ODocument.DatiConsumoH2O;
import it.csi.sigit.sigitwebn.xml.libretto.data.DatiConsumoProdottiChimiciDocument.DatiConsumoProdottiChimici;
import it.csi.sigit.sigitwebn.xml.libretto.data.DatiPrecompilatiDocument.DatiPrecompilati;
import it.csi.sigit.sigitwebn.xml.libretto.data.DatiPrecompilatiDocument.DatiPrecompilati.SezNomine;
import it.csi.sigit.sigitwebn.xml.libretto.data.DatiSchedaAGDocument.DatiSchedaAG.SezAG;
import it.csi.sigit.sigitwebn.xml.libretto.data.DatiSchedaBRDocument.DatiSchedaBR.SezBR;
import it.csi.sigit.sigitwebn.xml.libretto.data.DatiSchedaGTDocument.DatiSchedaGT.SezGruppiTermici;
import it.csi.sigit.sigitwebn.xml.libretto.data.DatiSchedaIdentificativaImpDocument.DatiSchedaIdentificativaImp;
import it.csi.sigit.sigitwebn.xml.libretto.data.DatiSchedaSistemaACDocument.DatiSchedaSistemaAC;
import it.csi.sigit.sigitwebn.xml.libretto.data.DatiSchedaSistemaACDocument.DatiSchedaSistemaAC.SezAC;
import it.csi.sigit.sigitwebn.xml.libretto.data.DatiSchedaSistemaEmissioneDocument.DatiSchedaSistemaEmissione;
import it.csi.sigit.sigitwebn.xml.libretto.data.DatiSchedaSistemiDistribDocument.DatiSchedaSistemiDistrib;
import it.csi.sigit.sigitwebn.xml.libretto.data.DatiSchedaSistemiDistribDocument.DatiSchedaSistemiDistrib.SezPO;
import it.csi.sigit.sigitwebn.xml.libretto.data.DatiSchedaSistemiDistribDocument.DatiSchedaSistemiDistrib.SezVasi;
import it.csi.sigit.sigitwebn.xml.libretto.data.DatiSchedaSistemiRegolazDocument.DatiSchedaSistemiRegolaz;
import it.csi.sigit.sigitwebn.xml.libretto.data.DatiSchedaTrattH2ODocument.DatiSchedaTrattH2O;
import it.csi.sigit.sigitwebn.xml.libretto.data.DatiVentilazMeccanicaVMDocument.DatiVentilazMeccanicaVM;
import it.csi.sigit.sigitwebn.xml.libretto.data.DatiVentilazMeccanicaVMDocument.DatiVentilazMeccanicaVM.SezVM;
import it.csi.sigit.sigitwebn.xml.libretto.data.MODDocument;
import it.csi.sigit.sigitwebn.xml.libretto.data.RegolazionePrimariaDocument.RegolazionePrimaria;
import it.csi.sigit.sigitwebn.xml.libretto.data.RegolazionePrimariaDocument.RegolazionePrimaria.SezSR;
import it.csi.sigit.sigitwebn.xml.libretto.data.RegolazionePrimariaDocument.RegolazionePrimaria.SezVR;
import it.csi.sigit.sigitwebn.xml.libretto.data.RegolazioneSingoloAmbDocument.RegolazioneSingoloAmb;
import it.csi.sigit.sigitwebn.xml.libretto.data.RichiestaDocument.Richiesta;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowACDocument.RowAC;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowACDocument.RowAC.SezACsostituite;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowACsostDocument.RowACsost;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowAGDocument.RowAG;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowAGDocument.RowAG.SezAGsostituite;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowAGsostDocument.RowAGsost;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowBRDocument.RowBR;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowBRDocument.RowBR.SezBRsostituite;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowBRsostDocument.RowBRsost;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowCGDocument.RowCG;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowCGDocument.RowCG.SezCGsostituite;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowCGsostDocument.RowCGsost;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowCIDocument.RowCI;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowCIDocument.RowCI.SezCIsostituite;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowCIsostDocument.RowCIsost;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowCSDocument.RowCS;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowCSDocument.RowCS.SezCSvariate;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowCSvarDocument.RowCSvar;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowCombuDocument.RowCombu;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowConsumoDocument.RowConsumo;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowConsumoEEDocument.RowConsumoEE;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowConsumoH2ODocument.RowConsumoH2O;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowConsumoPRODDocument.RowConsumoPROD;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowGFDocument.RowGF;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowGFDocument.RowGF.SezGFsostituite;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowGFsostDocument.RowGFsost;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowGTDocument.RowGT;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowGTDocument.RowGT.SezGTsostituite;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowGTsostDocument.RowGTsost;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowPODocument.RowPO;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowPODocument.RowPO.SezPOsostituite;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowPOsostDocument.RowPOsost;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowRCDocument.RowRC;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowRCDocument.RowRC.SezRCsostituite;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowRCcalDocument.RowRCcal;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowRCcalsostDocument.RowRCcalsost;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowRCsostDocument.RowRCsost;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowRVDocument.RowRV;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowRVDocument.RowRV.SezRVsostituite;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowRVsostDocument.RowRVsost;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowSCDocument.RowSC;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowSCDocument.RowSC.SezSCsostituite;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowSCcalDocument.RowSCcal;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowSCcalsostDocument.RowSCcalsost;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowSCsostDocument.RowSCsost;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowSRDocument.RowSR;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowSRDocument.RowSR.SezSRsostituite;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowSRsostDocument.RowSRsost;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowTEDocument.RowTE;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowTEDocument.RowTE.SezTEsostituite;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowTEsostDocument.RowTEsost;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowUTDocument.RowUT;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowUTDocument.RowUT.SezUTsostituite;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowUTsostDocument.RowUTsost;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowVMDocument.RowVM;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowVMDocument.RowVM.SezVMsostituite;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowVMsostDocument.RowVMsost;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowVRDocument.RowVR;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowVRDocument.RowVR.SezVRsostituite;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowVRsostDocument.RowVRsost;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowVasiDocument.RowVasi;

import java.math.BigDecimal;
import java.security.UnrecoverableEntryException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.postgresql.util.PSQLException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

/**
 * Manager del DB
 * 
 * @author 70140
 */
public class DbMgrImport {

	protected static Logger log = Logger.getLogger(Constants.APPLICATION_CODE + ".business.manager");

	/**
	 * Verifica del manager
	 */
	public void test() {
		log.debug("DBManager RAGGIUNTO CORRETTAMENTE");
	}

	// INIZIO METODI DI BUSINESS

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


	///////////////////////////////////////////////////////////
	// NEW DB - BEPPE
	///////////////////////////////////////////////////////////	

	public void insertImportLibretto(String codImpianto, String xml, String cfUtente) throws DbManagerException
	{
		log.debug("[DbMgrImport:::insertImportLibretto] START");
		try{
			SigitTImportXmlLibDto dto = new SigitTImportXmlLibDto();

			dto.setCodiceImpianto(ConvertUtil.convertToBigDecimal(codImpianto));
			dto.setXmlLibretto(xml);
			dto.setDataUltMod(DateUtil.getSqlCurrentDate());
			dto.setUtenteUltMod(cfUtente);

			getDbMgr().getSigitTImportXmlLibDao().insert(dto);
		} catch (Exception e) {
			log.error("Errore: ",e);
			throw new DbManagerException(new Message(Messages.ERROR_INSERT_DB));
		}
		finally
		{
			log.debug("[DbMgrImport:::insertImportLibretto] END");
		}
	}

	public void consolidaLibrettoImport(LibrettoDocument librettoImport, BigDecimal codiceImpianto, Integer idPersonaGiuridica, String cfUtente) throws DbManagerException
	{
		log.debug("[DbMgrImport::consolidaLibrettoImport] start");

		try
		{
			LibrettoCatasto librettoCat = librettoImport.getLibretto().getLibrettoCatasto();

			SigitTImpiantoDto datiImpianto = consolidaScheda1LibrettoImp(codiceImpianto, librettoCat.getL1SchedaIdentificativa(), cfUtente);

			L2TrattamentoAcqua l2TrattamentoAcqua = librettoCat.getL2TrattamentoAcqua();

			if (l2TrattamentoAcqua != null)
			{
				consolidaTrattamentoH2oImp(codiceImpianto, l2TrattamentoAcqua);
			}



			L4Generatori l4Generatori = librettoCat.getL4Generatori();

			if (l4Generatori != null)
			{
				consolidaGTImp(codiceImpianto, l4Generatori.getL41GTList(), idPersonaGiuridica, cfUtente);
				consolidaBRImp(codiceImpianto, l4Generatori.getL42BRList(), l4Generatori.getL41GTList(), cfUtente);
				consolidaRCImp(codiceImpianto, l4Generatori.getL43RCList(), l4Generatori.getL41GTList(), cfUtente);
				consolidaGFImp(codiceImpianto, l4Generatori.getL44GFList(), idPersonaGiuridica, cfUtente);
				consolidaSCImp(codiceImpianto, l4Generatori.getL45SCList(), idPersonaGiuridica, cfUtente);
				consolidaCGImp(codiceImpianto, l4Generatori.getL46CGList(), idPersonaGiuridica, cfUtente);
				consolidaCSImp(codiceImpianto, l4Generatori.getL47CSList(), cfUtente);
				consolidaAGImp(codiceImpianto, l4Generatori.getL48AGList(), cfUtente);
			}

			L5SistemiRegolazioneContabilizzazione l5SistRegCont = librettoCat.getL5SistemiRegolazioneContabilizzazione();

			consolidaSistemiRegolazioneContabilizzazione(librettoCat, datiImpianto.getCodiceImpianto(), cfUtente);

			L8SistemiAccumulo l8SistAcc = librettoCat.getL8SistemiAccumulo();

			if (l8SistAcc != null && l8SistAcc.getL81ACList() != null && l8SistAcc.getL81ACList().size() > 0)
			{
				consolidaACImp(l8SistAcc.getL81ACList(), datiImpianto.getCodiceImpianto(), cfUtente);

			}

			L9AltriComponenti l9AltriComponenti = librettoCat.getL9AltriComponenti();

			if (l9AltriComponenti != null)
			{
				consolidaTEImp(l9AltriComponenti.getL91TEList(), datiImpianto.getCodiceImpianto(), cfUtente);
				consolidaRVImp(l9AltriComponenti.getL92RVList(), datiImpianto.getCodiceImpianto(), cfUtente);
				consolidaSCXImp(l9AltriComponenti.getL93SCXList(), datiImpianto.getCodiceImpianto(), cfUtente);
				consolidaCIImp(l9AltriComponenti.getL94CIList(), datiImpianto.getCodiceImpianto(), cfUtente);
				consolidaUTImp(l9AltriComponenti.getL95UTList(), datiImpianto.getCodiceImpianto(), cfUtente);
				consolidaRCImp(l9AltriComponenti.getL96RCXList(), datiImpianto.getCodiceImpianto(), cfUtente);

			}

			L10Ventilazione l10Ventilazione = librettoCat.getL10Ventilazione();
			if (l10Ventilazione != null)
			{
				consolidaVMImp(l10Ventilazione.getL101VMList(), datiImpianto.getCodiceImpianto(), cfUtente);
			}

			L14Consumi l14Consumi = librettoCat.getL14Consumi();

			if (l14Consumi != null)
			{
				consolidaConsumoCombustibileImp(l14Consumi.getL141ConsumoCombustibileList(), datiImpianto.getCodiceImpianto(), cfUtente);
				consolidaConsumoEnergiaImp(l14Consumi.getL142ConsumoEnergiaElettrica(), datiImpianto.getCodiceImpianto(), cfUtente);
				consolidaConsumoH2OImp(l14Consumi.getL143ConsumoAcqua(), datiImpianto.getCodiceImpianto(), cfUtente);
				consolidaConsumoProdottiChimici(l14Consumi.getL144ConsumoProdottiChimici(), datiImpianto.getCodiceImpianto(), cfUtente);
			}
		} catch (DbManagerException e1) {
			throw new DbManagerException(e1, new Message(Messages.ERROR_UPDATE_DB));
		} catch (Exception e1) {
			throw new DbManagerException(e1, new Message(Messages.ERROR_UPDATE_DB));
		}

		log.debug("[DbMgrImport::consolidaLibrettoImport] end");

	}

	public SigitTImpiantoDto consolidaScheda1LibrettoImp(BigDecimal codImpianto, L1SchedaIdentificativa l1SchedaIdentificativa, String cfUtente) throws DbManagerException
	{
		log.debug("[DbMgrImport::consolidaScheda1LibrettoImp] start");

		try
		{
			SigitTImpiantoDto datiImpianto = getDbMgr().getSigitTImpiantoDao().findByPrimaryKey(new SigitTImpiantoPk(codImpianto));

			datiImpianto = MapDtoImport.mapToSigitTImpiantoImp(l1SchedaIdentificativa, datiImpianto, cfUtente);

			getDbMgr().getSigitTImpiantoDao().update(datiImpianto);

			List<SigitTUnitaImmobiliareDto> unitaPrincipaleList = getDbMgr().getSigitTUnitaImmobiliareDao().findUnitaPrincipaleImpianto(ConvertUtil.convertToInteger(codImpianto));
			SigitTUnitaImmobiliareDto uiPrincipale = new SigitTUnitaImmobiliareDto();
			if(unitaPrincipaleList != null && !unitaPrincipaleList.isEmpty())
			{
				uiPrincipale = unitaPrincipaleList.get(0);
			}

			uiPrincipale = MapDtoImport.mapTosigitTUnitaImmobiliareImp(l1SchedaIdentificativa, uiPrincipale, cfUtente);

			getDbMgr().getSigitTUnitaImmobiliareDao().update(uiPrincipale);

			return datiImpianto;

		} catch (SigitTImpiantoDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_UPDATE_DB));
		} catch (SigitTUnitaImmobiliareDaoException e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_UPDATE_DB));
		} 
		finally
		{
			log.debug("[DbMgrImport::consolidaScheda1LibrettoImp] end");
		}
	}

	public void consolidaTrattamentoH2oImp(BigDecimal codImpianto, L2TrattamentoAcqua datiH) throws DbManagerException
	{
		log.debug("[DbMgrImport::consolidaTrattamentoH2oImp] start");

		try
		{

			SigitTTrattH2ODto dto =  MapDtoImport.getSigitTTrattH2oNew(codImpianto, datiH);

			getDbMgr().getSigitTTrattH2oDao().insert(dto);

		} catch (Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_UPDATE_DB));
		} 
		finally
		{
			log.debug("[DbMgrImport::consolidaTrattamentoH2oImp] end");
		}
	}


	public void consolidaGTImp(BigDecimal codImpianto, List<L41GT> listGt, Integer idPersonaGiuridica, String cfUtente) throws DbManagerException
	{
		log.debug("[DbMgrImport::consolidaGTImp] start");

		try {

			String GT = "GT";
			for (L41GT rowGT : listGt) {
				SigitTComp4Dto comp4 = MapDtoImport.getSigitTComp4New(codImpianto, rowGT);
				BigDecimal progressivo = comp4.getProgressivo();
				SigitTCompGtDto compGt = MapDtoImport.mapToRowGTNew(codImpianto, rowGT.getL41GruppoTermico(), progressivo, cfUtente);
				if(GenericUtil.isNullOrEmpty(compGt.getDataInstall()))
					continue;

				log.debug("progressivo: " + progressivo);

				SigitTCompGtPk pkCompGt = new SigitTCompGtPk();
				pkCompGt.setCodiceImpianto(codImpianto);
				pkCompGt.setDataInstall(compGt.getDataInstall());
				pkCompGt.setIdTipoComponente(GT);
				pkCompGt.setProgressivo(progressivo);

				SigitTComp4Pk pkComp4 = new SigitTComp4Pk();
				pkComp4.setCodiceImpianto(pkCompGt.getCodiceImpianto());
				pkComp4.setIdTipoComponente(pkCompGt.getIdTipoComponente());
				pkComp4.setProgressivo(pkCompGt.getProgressivo());

				getDbMgr().getSigitTComp4Dao().insert(comp4);

				log.debug("inserisco GT");
				getDbMgr().getSigittCompGtDao().insert(compGt);

				SigitRComp4ManutDto comp4ManutFilter = new SigitRComp4ManutDto();
				comp4ManutFilter.setCodiceImpianto(pkCompGt.getCodiceImpianto());
				comp4ManutFilter.setIdTipoComponente(pkCompGt.getIdTipoComponente());
				comp4ManutFilter.setProgressivo(pkCompGt.getProgressivo());


				List<SigitRComp4ManutDto> comp4ManutList = getDbMgr().getSigitRComp4ManutDao().findAttiviByFilter(comp4ManutFilter);

				log.debug("STAMPO comp4ManutList: "+comp4ManutList);

				if(comp4ManutList == null || comp4ManutList.size() == 0)
				{
					SigitRComp4ManutDto comp4Manut = MapDtoImport.getSigitRComp4ManutNew(codImpianto, rowGT.getL41GruppoTermico(), idPersonaGiuridica, it.csi.sigit.sigitwebn.business.dao.util.Constants.ID_RUOLO_MANUTENTORE_ALL_1, progressivo, cfUtente);
					getDbMgr().getSigitRComp4ManutDao().insert(comp4Manut);
				}

				List<String> dateInstallazione = new ArrayList<String>();
				dateInstallazione.add(ConvertUtil.convertToString(compGt.getDataInstall()));
				List<L41GruppoTermicoSostituito> gtSostituiteList = rowGT.getL41GruppoTermicoSostituitoList();
				log.debug("consolodamento GT sotituite");
				if(gtSostituiteList!=null)
					for (L41GruppoTermicoSostituito rowGTSost : gtSostituiteList) {

						SigitTCompGtDto compGtSost = MapDtoImport.mapToRowGTSostNew(codImpianto, rowGTSost, progressivo, cfUtente);

						log.debug("inserisco gt sost");
						getDbMgr().getSigittCompGtDao().insert(compGtSost);
					}
			}
		} catch (Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_UPDATE_DB));
		} 

		log.debug("[DbMgrImport::consolidaGTImp] end");

	}

	private L41GT getGtFromList(List<L41GT> gt, String progressivo)
	{
		log.debug("getGtFromList");

		log.debug("progressivo: "+progressivo);

		for (L41GT rowGT : gt) {
			log.debug("rowGT.getL41Numero(): "+rowGT.getL41Numero());

			if(progressivo.equals(ConvertUtil.convertToString(rowGT.getL41Numero())))
				return rowGT;
		}
		return null;
	}

	public void consolidaBRImp(BigDecimal codImpianto, List<L42BR> listBr, List<L41GT> listGt, String cfUtente) throws DbManagerException
	{
		log.debug("[DbMgrImport::consolidaBRImp] start");
		try {
			String BR = "BR";
			List<String> progressivi = new ArrayList<String>();
			for (L42BR rowBR : listBr) {
				String progressivoGt = null;
				try
				{
					progressivoGt = ConvertUtil.convertToString(rowBR.getL42GtCollegato());
				}catch (Exception e) {continue;}

				log.debug("progressivoGt: "+progressivoGt);

				L41GT gt = getGtFromList(listGt, progressivoGt);
				if(gt==null)
				{
					log.error("Non trovato il GT "+ progressivoGt + " per il BR");
					throw new DbManagerException(new Message("Si e' verificato un errore "));
				}
				SigitTCompBrRcDto compBr = MapDtoImport.getSigitTCompBrRcNew(rowBR.getL42Bruciatore(), rowBR.getL42Numero(), codImpianto, gt);
				if(GenericUtil.isNullOrEmpty(compBr.getDataInstall()))
					continue;
				BigDecimal progressivoBr = compBr.getProgressivoBrRc();
				progressivi.add(progressivoBr.toString());
				log.debug("progressivo BR: " + progressivoBr+", data inst: " + ConvertUtil.convertToString(compBr.getDataInstall()));

				log.debug("inserisco nuovo BR");
				getDbMgr().getSigitTCompBrRcDao().insert(compBr);

				List<L42BruciatoreSostituito> brSostituiteList = rowBR.getL42BruciatoreSostituitoList();
				log.debug("consolidamento BR sostituite");
				if(brSostituiteList!=null)
					for (L42BruciatoreSostituito rowBRSost : brSostituiteList) {
						SigitTCompBrRcDto compBrSost = MapDtoImport.getSigitTCompBrRcSostNew(rowBRSost, progressivoBr, codImpianto, gt);
						log.debug("data install: " + ConvertUtil.convertToString(compBrSost.getDataInstall()));

						log.debug("inserisco br sost");
						getDbMgr().getSigitTCompBrRcDao().insert(compBrSost);
					}
				log.debug("Controllo sezioni BR sost eliminate");
			}

		} catch (Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_UPDATE_DB));
		} 

		log.debug("[DbMgrImport::consolidaBRImp] end");

	}

	public void consolidaRCImp(BigDecimal codImpianto, List<L43RC> listRc, List<L41GT> listGt, String cfUtente) throws DbManagerException
	{
		log.debug("[DbMgrImport::consolidaRCImp] start");
		try {
			String RC = "RC";
			List<String> progressivi = new ArrayList<String>();
			for (L43RC rowRc : listRc) {
				String progressivoGt = null;
				try
				{
					progressivoGt = ConvertUtil.convertToString(rowRc.getL43GtCollegato());
				}
				catch(Exception e){
					continue;
				}
				L41GT gt = getGtFromList(listGt, progressivoGt);
				if(gt==null)
				{
					log.error("Non trovato il GT "+ progressivoGt + " per RC");
					throw new DbManagerException(new Message("Si e' verificato un errore "));
				}
				SigitTCompBrRcDto compRc = MapDtoImport.getSigitTCompBrRcNew(rowRc.getL43Recuperatore(), rowRc.getL43Numero(), codImpianto, gt);
				if(GenericUtil.isNullOrEmpty(compRc.getDataInstall()))
					continue;
				BigDecimal progressivoBr = compRc.getProgressivoBrRc();
				progressivi.add(progressivoBr.toString());
				log.debug("progressivo RC: " + progressivoBr+", data inst: " + ConvertUtil.convertToString(compRc.getDataInstall()));

				log.debug("inserisco nuovo RC");
				getDbMgr().getSigitTCompBrRcDao().insert(compRc);

				List<L43RecuperatoreSostituito> rcSostituiteList = rowRc.getL43RecuperatoreSostituitoList();
				log.debug("consolidamento RC sotituite");
				if(rcSostituiteList!=null)
					for (L43RecuperatoreSostituito rowRCSost : rcSostituiteList) {
						SigitTCompBrRcDto compBrSost = MapDtoImport.getSigitTCompBrRcSostNew(rowRCSost, progressivoBr, codImpianto, gt);
						log.debug("data install: " + ConvertUtil.convertToString(compBrSost.getDataInstall()));

						log.debug("inserisco RC sost");
						getDbMgr().getSigitTCompBrRcDao().insert(compBrSost);
					}
			}

		} catch (Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_UPDATE_DB));
		} 

		log.debug("[DbMgrImport::consolidaRCImp] end");

	}

	public void consolidaGFImp(BigDecimal codImpianto, List<L44GF> listGf, Integer idPersonaGiuridica, String cfUtente) throws DbManagerException
	{
		log.debug("[DbMgrImport::consolidaGFImp] start");
		List<String> progressivi = new ArrayList<String>();
		try {

			String GF = "GF";
			for (L44GF rowGF : listGf) {

				SigitTComp4Dto comp4 = MapDtoImport.getSigitTComp4New(codImpianto, rowGF);
				BigDecimal progressivo = comp4.getProgressivo();
				SigitTCompGfDto compGf = MapDtoImport.mapToRowGFNew(codImpianto, rowGF.getL44GruppoFrigo(), progressivo, cfUtente);
				if(GenericUtil.isNullOrEmpty(compGf.getDataInstall()))
					continue;


				getDbMgr().getSigitTComp4Dao().insert(comp4);

				log.debug("inserisco GF");
				getDbMgr().getSigitTCompGfDao().insert(compGf);

				SigitRComp4ManutDto comp4Manut = MapDtoImport.getSigitRComp4ManutNew(codImpianto, rowGF.getL44GruppoFrigo(), idPersonaGiuridica, it.csi.sigit.sigitwebn.business.dao.util.Constants.ID_RUOLO_MANUTENTORE_ALL_2, progressivo, cfUtente);
				getDbMgr().getSigitRComp4ManutDao().insert(comp4Manut);


				List<L44GruppoFrigoSostituito> gfSostituiteList = rowGF.getL44GruppoFrigoSostituitoList();
				log.debug("consolodamento GF sotituite");
				if(gfSostituiteList!=null)
					for (L44GruppoFrigoSostituito rowGFSost : gfSostituiteList) {

						SigitTCompGfDto compGfSost = MapDtoImport.mapToRowGFSostNew(codImpianto, rowGFSost, progressivo, cfUtente);
						log.debug("inserisco GF sost");

						getDbMgr().getSigitTCompGfDao().insert(compGfSost);
					}
				log.debug("Controllo sezioni GF sost eliminate");
			}
		} catch (Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_UPDATE_DB));
		} 

		log.debug("[DbMgrImport::consolidaGFImp] end");
	}

	public void consolidaSCImp(BigDecimal codImpianto, List<L45SC> listSc, Integer idPersonaGiuridica, String cfUtente) throws DbManagerException
	{
		log.debug("[DbMgrImport::consolidaSCImp] start");
		List<String> progressivi = new ArrayList<String>();
		try {

			String SC = "SC";
			for (L45SC rowSC : listSc) {

				SigitTComp4Dto comp4 = MapDtoImport.getSigitTComp4New(codImpianto, rowSC);
				BigDecimal progressivo = comp4.getProgressivo();
				SigitTCompScDto compScDto = MapDtoImport.mapToRowSCNew(codImpianto, rowSC.getL45Scambiatore(), progressivo, cfUtente);
				if(GenericUtil.isNullOrEmpty(compScDto.getDataInstall()))
					continue;

				log.debug("progressivo: " + progressivo + ", data inst: " + ConvertUtil.convertToString(compScDto.getDataInstall()));

				getDbMgr().getSigitTComp4Dao().insert(comp4);
				log.debug("inserisco SC");
				getDbMgr().getSigitTCompScDao().insert(compScDto);
				SigitRComp4ManutDto comp4Manut = MapDtoImport.getSigitRComp4ManutNew(codImpianto, rowSC.getL45Scambiatore(), idPersonaGiuridica, it.csi.sigit.sigitwebn.business.dao.util.Constants.ID_RUOLO_MANUTENTORE_ALL_3, progressivo, cfUtente);
				getDbMgr().getSigitRComp4ManutDao().insert(comp4Manut);

				List<L45ScambiatoreSostituito> scSostituiteList = rowSC.getL45ScambiatoreSostituitoList();

				log.debug("consolodamento SC sotituite");
				if(scSostituiteList!=null)
					for (L45ScambiatoreSostituito rowSCSost : scSostituiteList) {

						SigitTCompScDto compSCSost = MapDtoImport.mapToRowSCSostNew(codImpianto, rowSCSost, progressivo, cfUtente);
						log.debug("inserisco SC sost");

						getDbMgr().getSigitTCompScDao().insert(compSCSost);
					}
			}
		} catch (Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_UPDATE_DB));
		} 
		log.debug("[DbMgrImport::consolidaSCImp] end");

	}

	public void consolidaCGImp(BigDecimal codImpianto, List<L46CG> listCg, Integer idPersonaGiuridica, String cfUtente) throws DbManagerException
	{
		log.debug("[DbMgrImport::consolidaCGImp] start");
		List<String> progressivi = new ArrayList<String>();
		try {

			String CG = "CG";
			for (L46CG rowCG : listCg) {

				SigitTComp4Dto comp4 = MapDtoImport.getSigitTComp4New(codImpianto, rowCG);
				BigDecimal progressivo = comp4.getProgressivo();
				SigitTCompCgDto compCg = MapDtoImport.getSigitTCompCgNew(codImpianto, rowCG.getL46Cogeneratore(), progressivo, cfUtente);
				if(GenericUtil.isNullOrEmpty(compCg.getDataInstall()))
					continue;

				log.debug("progressivo: " + progressivo+", data inst: "+ConvertUtil.convertToString(compCg.getDataInstall()));
				getDbMgr().getSigitTComp4Dao().insert(comp4);

				log.debug("inserisco CG");
				getDbMgr().getSigitTCompCgDao().insert(compCg);

				SigitRComp4ManutDto comp4Manut = MapDtoImport.getSigitRComp4ManutNew(codImpianto, rowCG.getL46Cogeneratore(), idPersonaGiuridica, it.csi.sigit.sigitwebn.business.dao.util.Constants.ID_RUOLO_MANUTENTORE_ALL_4, progressivo, cfUtente);
				getDbMgr().getSigitRComp4ManutDao().insert(comp4Manut);

				List<L46CogeneratoreSostituito> gfSostituiteList = rowCG.getL46CogeneratoreSostituitoList();

				log.debug("consolodamento CG sotituite");
				if(gfSostituiteList!=null)
					for (L46CogeneratoreSostituito rowCGSost : gfSostituiteList) {


						SigitTCompCgDto compCgSost = MapDtoImport.getSigitTCompCgSostNew(codImpianto, rowCGSost, progressivo, cfUtente);

						log.debug("inserisco CG sost");

						getDbMgr().getSigitTCompCgDao().insert(compCgSost);
					}
			}
		} catch (Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_UPDATE_DB));
		} 
		log.debug("[DbMgrImport::consolidaCGImp] end");

	}

	public void consolidaCSImp(BigDecimal codImpianto, List<L47CS> listCs, String cfUtente) throws DbManagerException
	{
		log.debug("[DbMgrImport::consolidaCSImp] start");
		List<String> progressivi = new ArrayList<String>();

		try {
			String CS = "CS";

			for (L47CS rowCS : listCs) {

				BigDecimal progressivo = ConvertUtil.convertToBigDecimal(rowCS.getL47Numero());

				SigitTCompCsDto compCsDto = MapDtoImport.getSigitTCompCsDtoNew(codImpianto, rowCS.getL47CampoSolareTermico(), progressivo, cfUtente);

				if(GenericUtil.isNullOrEmpty(compCsDto.getDataInstall()))
					continue;
				progressivi.add(progressivo.toString());


				log.debug("progressivo: " + progressivo);

				SigitTComp4Dto comp4 = MapDtoImport.getSigitTComp4New(codImpianto, rowCS);
				getDbMgr().getSigitTComp4Dao().insert(comp4);

				log.debug("inserisco CS");
				getDbMgr().getSigitTCompCsDao().insert(compCsDto);

				List<L47CampoSolareTermicoSostituito> csSostituiteList = rowCS.getL47CampoSolareTermicoSostituitoList();

				if(csSostituiteList!=null)
				{
					for(L47CampoSolareTermicoSostituito csVar : csSostituiteList)
					{
						SigitTCompCsDto csVarDto = MapDtoImport.getSigitTCompCsDtoSostNew(codImpianto, csVar, progressivo, cfUtente);
						log.debug("inserisco CS sost");

						getDbMgr().getSigitTCompCsDao().insert(csVarDto);
					}

				}
				else
					log.debug("Nessuna variazione CS");
			}
		} catch (Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_UPDATE_DB));
		} 
		log.debug("[DbMgrImport::consolidaCSImp] end");

	}

	public void consolidaAGImp(BigDecimal codImpianto, List<L48AG> listAg, String cfUtente) throws DbManagerException
	{
		log.debug("[DbMgrImport::consolidaAGImp] start");
		List<String> progressivi = new ArrayList<String>();

		try {
			String AG = "AG";

			for (L48AG rowAG : listAg) {

				BigDecimal progressivo = ConvertUtil.convertToBigDecimal(rowAG.getL48Numero());
				SigitTCompAgDto compAgDto = MapDtoImport.getSigitTCompAgNew(codImpianto, rowAG.getL48AltroGeneratore(), progressivo, cfUtente);

				if(GenericUtil.isNullOrEmpty(compAgDto.getDataInstall()))
					continue;

				log.debug("progressivo: " + progressivo);

				SigitTComp4Dto comp4 = MapDtoImport.getSigitTComp4New(codImpianto, rowAG);
				getDbMgr().getSigitTComp4Dao().insert(comp4);

				log.debug("inserisco AG");
				getDbMgr().getSigitTCompAgDao().insert(compAgDto);

				List<L48AltroGeneratoreSostituito> agSostituiteList = rowAG.getL48AltroGeneratoreSostituitoList();

				log.debug("consolodamento AG sotituite");
				if(agSostituiteList!=null)
					for (L48AltroGeneratoreSostituito rowAGSost : agSostituiteList) {

						SigitTCompAgDto compAGSost = MapDtoImport.getSigitTCompAgSostNew(codImpianto, rowAGSost, progressivo, cfUtente);

						getDbMgr().getSigitTCompAgDao().insert(compAGSost);

					}
			}

		} catch (Exception e) {
			throw new DbManagerException(e, new Message(Messages.ERROR_UPDATE_DB));
		} 

		log.debug("[DbMgrImport::consolidaAGImp] end");

	}

	private void consolidaSRImp(List<L51SR> srList, BigDecimal codImpianto, String cfUtente) throws SigitTCompSrDaoException, SigitTCompXDaoException
	{
		log.debug("[DbMgrImport::consolidaSRImp] start");

		getDbMgr().getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp_sr", "codice_impianto="+codImpianto));

		getDbMgr().getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp_x", "codice_impianto="+codImpianto+"&tipo_componente=SR"));

		if(srList!=null)
		{
			log.debug("Consolidamento scheda 5: regolazione primaria - SR");

			if(srList!=null)
				for (L51SR rowSR : srList) {
					SigitTCompXDto compX = MapDtoImport.getSigitTCompXNew(rowSR.getL51SistemaRegolazione(), codImpianto, rowSR.getL51Numero(), cfUtente);
					if(compX !=null && compX.getDataInstall()!=null)
					{
						log.debug("Inserimento COMP SR");
						SigitTCompSrDto compSr = MapDtoImport.getSigitTCompSRNew(rowSR.getL51SistemaRegolazione(), codImpianto, rowSR.getL51Numero());

						getDbMgr().getSigitTCompXDao().insert(compX);
						getDbMgr().getSigitTCompSrDao().insert(compSr);
					}
					log.debug("Inserimento sezione sostituite");
					List<L51SistemaRegolazioneSostituito> rowSRsostList = rowSR.getL51SistemaRegolazioneSostituitoList();
					if(rowSRsostList!=null)
						for (L51SistemaRegolazioneSostituito rowSRsost : rowSRsostList) {
							SigitTCompXDto xSostDto = MapDtoImport.getSigitTCompXNew(rowSRsost, codImpianto, rowSR.getL51Numero(), cfUtente);
							SigitTCompSrDto xSrDto = MapDtoImport.getSigitTCompSRNew(rowSRsost, codImpianto, rowSR.getL51Numero());

							getDbMgr().getSigitTCompXDao().insert(xSostDto);
							getDbMgr().getSigitTCompSrDao().insert(xSrDto);
						}
				}
		}

		log.debug("[DbMgrImport::consolidaSRImp] end");

	}

	private void consolidaVRImp(List<L51VR> vrList, BigDecimal codImpianto, String cfUtente) throws SigitTCompXDaoException, SigitTCompVrDaoException
	{
		log.debug("[DbMgrImport::consolidaTrattamentoH2oImp] start");

		getDbMgr().getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp_vr", "codice_impianto="+codImpianto));

		getDbMgr().getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp_x", "codice_impianto="+codImpianto+"&tipo_componente=VR"));

		if(vrList!=null)
		{
			log.debug("Consolidamento scheda 5: regolazione primaria - VR");

			if(vrList!=null)
				for (L51VR rowVR : vrList) {
					SigitTCompXDto compX = MapDtoImport.getSigitTCompXNew(rowVR.getL51ValvolaRegolazione(), codImpianto, rowVR.getL51Numero(), cfUtente);
					if(compX !=null && compX.getDataInstall()!=null)
					{
						log.debug("Inserimento COMP VR");
						SigitTCompVrDto compVr = MapDtoImport.getSigitTCompVRNew(rowVR.getL51ValvolaRegolazione(), codImpianto, rowVR.getL51Numero());

						getDbMgr().getSigitTCompXDao().insert(compX);
						getDbMgr().getSigitTCompVrDao().insert(compVr);
					}

					log.debug("Inserimento sezione sostituite");
					List<L51ValvolaRegolazioneSostituito> rowVRsostList = rowVR.getL51ValvolaRegolazioneSostituitoList();

					if(rowVRsostList!=null)
						for (L51ValvolaRegolazioneSostituito rowVRsost : rowVRsostList) {
							SigitTCompXDto xSostDto = MapDtoImport.getSigitTCompXNew(rowVRsost, codImpianto, rowVR.getL51Numero(), cfUtente);
							SigitTCompVrDto xVrDto = MapDtoImport.getSigitTCompVRNew(rowVRsost, codImpianto, rowVR.getL51Numero());

							getDbMgr().getSigitTCompXDao().insert(xSostDto);
							getDbMgr().getSigitTCompVrDao().insert(xVrDto);
						}
				}
		}

		log.debug("[DbMgrImport::consolidaVRImp] end");
	}

	public void consolidaSistemiRegolazioneContabilizzazione(LibrettoCatasto librettoCat, BigDecimal codImpianto, String cfUtente) throws DbManagerException {
		log.debug("[DbMgrImport::consolidaSistemiRegolazione] START");
		try
		{
			log.debug("cancellazione sigit_t_compx_semplice");

			getDbMgr().getSigitTCompXSempliceDao().customDeleterByCodImpianto(new Integer(codImpianto.intValue()));
			getDbMgr().getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_compx_semplice", "codice_impianto="+codImpianto));

			L5SistemiRegolazioneContabilizzazione datiSchedaSistemiRegolaz = librettoCat.getL5SistemiRegolazioneContabilizzazione();
			if(datiSchedaSistemiRegolaz!=null)
			{
				log.debug("Consolidamento scheda 5");

				SigitTCompXSempliceDto dtoXsemplice = new SigitTCompXSempliceDto(); 

				log.debug("Consolidamento scheda 5: regolazione primaria");
				boolean isValvoleRegolazione = false;
				
				if (datiSchedaSistemiRegolaz.getL51VRList() != null && datiSchedaSistemiRegolaz.getL51VRList().size() > 0)
				{
					isValvoleRegolazione = true;
				}
				
				dtoXsemplice = MapDtoImport.getSigitTCompxSempliceNew(datiSchedaSistemiRegolaz, isValvoleRegolazione, cfUtente);

				consolidaSRImp(datiSchedaSistemiRegolaz.getL51SRList(), codImpianto, cfUtente);
				consolidaVRImp(datiSchedaSistemiRegolaz.getL51VRList(), codImpianto, cfUtente);

				dtoXsemplice.setCodiceImpianto(codImpianto);


				log.debug("Consolidamento scheda 5: regolazione singolo ambiente di zona");
				MapDtoImport.getSigitTCompxSempliceNew(datiSchedaSistemiRegolaz, dtoXsemplice);


				L6SistemiDistribuzione datiSchedaSistemiDistrib = librettoCat.getL6SistemiDistribuzione();
				if(datiSchedaSistemiDistrib!=null)
				{
					log.debug("Consolidamento scheda 6: sistemi di distribuzione");
					MapDtoImport.getSigitTCompXSempliceNew(dtoXsemplice , datiSchedaSistemiDistrib);

					consolidaVXImp(datiSchedaSistemiDistrib.getL63VXList(), codImpianto, cfUtente);
					consolidaPOImp(datiSchedaSistemiDistrib.getL64POList(), codImpianto, cfUtente);
				}

				L7SistemiEmissione datiSchedaSistemaEmissione = librettoCat.getL7SistemiEmissione();

				if(datiSchedaSistemaEmissione!=null)
				{
					log.debug("Consolidamento scheda 7: sistema emissione");
					MapDtoImport.getSigitTCompxSempliceNew(datiSchedaSistemaEmissione, dtoXsemplice);
				}
				log.debug("inserimento compx_semplice");
				getDbMgr().getSigitTCompXSempliceDao().insert(dtoXsemplice);
			}
		} catch (Exception e) {
			log.error("Errore ", e);
			throw new DbManagerException(e, new Message(Messages.ERROR_UPDATE_DB));
		}
		finally{
			log.debug("[DbMgrImport::consolidaSistemiRegolazione] END");
		}

	}

	private void consolidaVXImp(List<L63VX> srList, BigDecimal codImpianto, String cfUtente) throws SigitTCompXDaoException, SigitTCompVxDaoException {

		log.debug("[DbMgrImport::consolidaVXImp] start");

		getDbMgr().getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp_vx", "codice_impianto="+codImpianto));

		getDbMgr().getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp_x", "codice_impianto="+codImpianto+"&tipo_componente=VX"));

		if(srList!=null)
		{
			log.debug("Consolidamento scheda 6: vasi - VX");

			if(srList!=null)
				for (L63VX rowVX : srList) {
					SigitTCompXDto compX = MapDtoImport.getSigitTCompXNew(rowVX.getL63VasoEspansione(), codImpianto, rowVX.getL63Numero(), cfUtente);
					if(compX !=null && compX.getProgressivo()!=null)
					{
						log.debug("Inserimento COMP VX");
						SigitTCompVxDto compVx = MapDtoImport.getSigitTCompVXNew(rowVX.getL63VasoEspansione(), codImpianto, rowVX.getL63Numero());

						getDbMgr().getSigitTCompXDao().insert(compX);
						getDbMgr().getSigitTCompVxDao().insert(compVx);
					}
				}
		}

		log.debug("[DbMgrImport::consolidaVXImp] end");

	}

	private void consolidaPOImp(List<L64PO> srList, BigDecimal codImpianto, String cfUtente) throws SigitTCompPoDaoException, SigitTCompXDaoException
	{

		log.debug("[DbMgrImport::consolidaPOImp] start");

		getDbMgr().getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp_po", "codice_impianto="+codImpianto));

		getDbMgr().getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp_x", "codice_impianto="+codImpianto+"&tipo_componente=SR"));

		if(srList!=null)
		{
			log.debug("Consolidamento scheda 6: regolazione primaria - PO");

			if(srList!=null)
				for (L64PO rowPO : srList) {
					SigitTCompXDto compX = MapDtoImport.getSigitTCompXNew(rowPO.getL64Pompa(), codImpianto, rowPO.getL64Numero(), cfUtente);

					if(compX !=null && compX.getDataInstall()!=null)
					{
						log.debug("Inserimento COMP PO");
						SigitTCompPoDto compVr = MapDtoImport.getSigitTCompPONew(rowPO.getL64Pompa(), codImpianto, rowPO.getL64Numero());

						getDbMgr().getSigitTCompXDao().insert(compX);
						getDbMgr().getSigitTCompPoDao().insert(compVr);
					}

					List<L64PompaSostituito> rowPOsostList = rowPO.getL64PompaSostituitoList();

					if(rowPOsostList!=null)
					{
						log.debug("Inserimento sezione sostituite");

						if(rowPOsostList!=null)
							for (L64PompaSostituito rowVRsost : rowPOsostList) {

								SigitTCompXDto xSostDto = MapDtoImport.getSigitTCompXNew(rowVRsost, codImpianto, rowPO.getL64Numero(), cfUtente);
								SigitTCompPoDto xPoDto = MapDtoImport.getSigitTCompPONew(rowVRsost, codImpianto, rowPO.getL64Numero());

								getDbMgr().getSigitTCompXDao().insert(xSostDto);
								getDbMgr().getSigitTCompPoDao().insert(xPoDto);
							}
					}
				}
		}

		log.debug("[DbMgrImport::consolidaPOImp] end");

	}

	public void consolidaACImp(List<L81AC> acList, BigDecimal codImpianto, String cfUtente) throws SigitTCompAcDaoException, SigitTCompXDaoException {

		log.debug("[DbMgrImport::consolidaACImp] start");

		getDbMgr().getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp_ac", "codice_impianto="+codImpianto));

		getDbMgr().getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp_x", "codice_impianto="+codImpianto+"&tipo_componente=AC"));

		if(acList !=null )
		{
			if(acList!=null)
			{
				log.debug("Consolidamento scheda 8: AC");
				if(acList!=null)
					for (L81AC rowAC : acList) {
						SigitTCompXDto compX = MapDtoImport.getSigitTCompXNew(rowAC.getL81Accumulo(), codImpianto, rowAC.getL81Numero(), cfUtente);
						if(compX !=null && compX.getDataInstall()!=null)
						{
							log.debug("Inserimento COMP AC");
							//salvataggio
							SigitTCompAcDto compAc = MapDtoImport.getSigitTCompACNew(rowAC.getL81Accumulo(), codImpianto, rowAC.getL81Numero());
							getDbMgr().getSigitTCompXDao().insert(compX);
							getDbMgr().getSigitTCompAcDao().insert(compAc);
						}

						log.debug("Inserimento sezione sostituite");
						List<L81AccumuloSostituito> rowACsostList = rowAC.getL81AccumuloSostituitoList();
						if(rowACsostList!=null)
							for (L81AccumuloSostituito rowACsost : rowACsostList) {
								String progressivo = ConvertUtil.convertToString(rowAC.getL81Numero());
								SigitTCompXDto xSostDto = MapDtoImport.getSigitTCompXNew(rowACsost, codImpianto, progressivo, cfUtente);
								SigitTCompAcDto xAcDto = MapDtoImport.getSigitTCompACNew(rowACsost, codImpianto, progressivo);

								getDbMgr().getSigitTCompXDao().insert(xSostDto);
								getDbMgr().getSigitTCompAcDao().insert(xAcDto);
							}
					}
			}
		}
		log.debug("[DbMgrImport::consolidaACImp] end");
	}

	public void consolidaTEImp(List<L91TE> acList, BigDecimal codImpianto, String cfUtente) throws SigitTCompXDaoException, SigitTCompTeDaoException {

		log.debug("[DbMgrImport::consolidaTEImp] start");

		getDbMgr().getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp_te", "codice_impianto="+codImpianto));

		getDbMgr().getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp_x", "codice_impianto="+codImpianto+"&tipo_componente=TE"));

		if(acList !=null )
		{
			if(acList!=null)
			{
				log.debug("Consolidamento scheda 9: TE");
				if(acList!=null)
					for (L91TE rowTE : acList) {
						SigitTCompXDto compX = MapDtoImport.getSigitTCompXNew(rowTE.getL91Torre(), codImpianto, rowTE.getL91Numero(), cfUtente);
						if(compX !=null && compX.getDataInstall()!=null)
						{
							log.debug("Inserimento COMP TE");
							//salvataggio
							SigitTCompTeDto compTe = MapDtoImport.getSigitTCompTENew(rowTE.getL91Torre(), codImpianto, rowTE.getL91Numero());

							getDbMgr().getSigitTCompXDao().insert(compX);
							getDbMgr().getSigitTCompTeDao().insert(compTe);
						}
						log.debug("Inserimento sezione sostituite");
						List<L91TorreSostituito> rowTEsostList = rowTE.getL91TorreSostituitoList();
						if(rowTEsostList!=null)
							for (L91TorreSostituito rowTEsost : rowTEsostList) {
								String progressivo = ConvertUtil.convertToString(rowTE.getL91Numero());
								SigitTCompXDto xSostDto = MapDtoImport.getSigitTCompXNew(rowTEsost, codImpianto, progressivo, cfUtente);
								SigitTCompTeDto xTeDto = MapDtoImport.getSigitTCompTENew(rowTEsost, codImpianto, progressivo);

								getDbMgr().getSigitTCompXDao().insert(xSostDto);
								getDbMgr().getSigitTCompTeDao().insert(xTeDto);
							}
					}
			}
		}

		log.debug("[DbMgrImport::consolidaTEImp] end");

	}

	public void consolidaRVImp(List<L92RV> acList, BigDecimal codImpianto, String cfUtente) throws SigitTCompRvDaoException, SigitTCompXDaoException {

		log.debug("[DbMgrImport::consolidaRVImp] start");

		getDbMgr().getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp_rv", "codice_impianto="+codImpianto));

		getDbMgr().getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp_x", "codice_impianto="+codImpianto+"&tipo_componente=RV"));
		if(acList !=null )
		{
			if(acList!=null)
			{
				log.debug("Consolidamento scheda 9: RV");

				if(acList!=null)
					for (L92RV rowRV : acList) {
						SigitTCompXDto compX = MapDtoImport.getSigitTCompXNew(rowRV.getL92Raffreddatore(), codImpianto, rowRV.getL92Numero(), cfUtente);
						if(compX !=null && compX.getDataInstall()!=null)
						{
							log.debug("Inserimento COMP RV");
							//salvataggio
							SigitTCompRvDto compTe = MapDtoImport.getSigitTCompRVNew(rowRV.getL92Raffreddatore(), codImpianto, rowRV.getL92Numero());

							getDbMgr().getSigitTCompXDao().insert(compX);
							getDbMgr().getSigitTCompRvDao().insert(compTe);
						}

						log.debug("Inserimento sezione sostituite");
						List<L92RaffreddatoreSostituito> rowRVsostList = rowRV.getL92RaffreddatoreSostituitoList();
						if(rowRVsostList!=null)
							for (L92RaffreddatoreSostituito rowRVsost : rowRVsostList) {
								String progressivo = ConvertUtil.convertToString(rowRV.getL92Numero());
								SigitTCompXDto xSostDto = MapDtoImport.getSigitTCompXNew(rowRVsost, codImpianto, progressivo, cfUtente);
								SigitTCompRvDto xTeDto = MapDtoImport.getSigitTCompRVNew(rowRVsost, codImpianto, progressivo);

								getDbMgr().getSigitTCompXDao().insert(xSostDto);
								getDbMgr().getSigitTCompRvDao().insert(xTeDto);
							}
					}
			}
		}

		log.debug("[DbMgrImport::consolidaRVImp] end");

	}

	public void consolidaSCXImp(List<L93SCX> acList, BigDecimal codImpianto, String cfUtente) throws SigitTCompScxDaoException, SigitTCompXDaoException {

		log.debug("[DbMgrImport::consolidaSCXImp] start");

		getDbMgr().getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp_scx", "codice_impianto="+codImpianto));

		getDbMgr().getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp_x", "codice_impianto="+codImpianto+"&tipo_componente=SCX"));

		if(acList !=null )
		{
			if(acList!=null)
			{
				log.debug("Consolidamento scheda 9: SC");

				for (L93SCX rowSC : acList) {
					SigitTCompXDto compX = MapDtoImport.getSigitTCompXNew(rowSC.getL93ScambiatoreIntermedio(), codImpianto, rowSC.getL93Numero(), cfUtente);
					if(compX !=null && compX.getDataInstall()!=null)
					{
						log.debug("Inserimento COMP SC");
						//salvataggio
						SigitTCompScxDto compSc = MapDtoImport.getSigitTCompSCXNew(rowSC.getL93ScambiatoreIntermedio(), codImpianto, rowSC.getL93Numero());

						getDbMgr().getSigitTCompXDao().insert(compX);
						getDbMgr().getSigitTCompScxDao().insert(compSc);
					}

					log.debug("Inserimento sezione sostituite");
					List<L93ScambiatoreIntermedioSostituito> rowSCsostList = rowSC.getL93ScambiatoreIntermedioSostituitoList();
					if(rowSCsostList!=null)
						for (L93ScambiatoreIntermedioSostituito rowSCsost : rowSCsostList) {
							String progressivo = ConvertUtil.convertToString(rowSC.getL93Numero());
							SigitTCompXDto xSostDto = MapDtoImport.getSigitTCompXNew(rowSCsost, codImpianto, progressivo, cfUtente);
							SigitTCompScxDto xScDto = MapDtoImport.getSigitTCompSCXNew(rowSCsost, codImpianto, progressivo);

							getDbMgr().getSigitTCompXDao().insert(xSostDto);
							getDbMgr().getSigitTCompScxDao().insert(xScDto);
						}
				}
			}
		}	

		log.debug("[DbMgrImport::consolidaSCXImp] end");

	}

	public void consolidaCIImp(List<L94CI> acList, BigDecimal codImpianto, String cfUtente) throws SigitTCompCiDaoException, SigitTCompXDaoException{

		log.debug("[DbMgrImport::consolidaCIImp] start");

		getDbMgr().getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp_ci", "codice_impianto="+codImpianto));

		getDbMgr().getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp_x", "codice_impianto="+codImpianto+"&tipo_componente=CI"));
		if(acList !=null)
		{
			if(acList!=null)
			{
				log.debug("Consolidamento scheda 9: CI");

				if(acList!=null)
					for (L94CI rowSC : acList) {
						SigitTCompXDto compX = MapDtoImport.getSigitTCompXNew(rowSC.getL94Circuito(), codImpianto, rowSC.getL94Numero(), cfUtente);
						if(compX !=null && compX.getDataInstall()!=null)
						{
							log.debug("Inserimento COMP CI");
							//salvataggio
							SigitTCompCiDto compCi = MapDtoImport.getSigitTCompCINew(rowSC.getL94Circuito(), codImpianto, rowSC.getL94Numero());

							getDbMgr().getSigitTCompXDao().insert(compX);
							getDbMgr().getSigitTCompCiDao().insert(compCi);
						}

						log.debug("Inserimento sezione sostituite");
						List<L94CircuitoSostituito> rowCIsostList = rowSC.getL94CircuitoSostituitoList();
						if(rowCIsostList!=null)
						{
							for (L94CircuitoSostituito rowCIsost : rowCIsostList) {
								String progressivo = ConvertUtil.convertToString(rowSC.getL94Numero());
								SigitTCompXDto xSostDto = MapDtoImport.getSigitTCompXNew(rowCIsost, codImpianto, progressivo, cfUtente);
								SigitTCompCiDto xCiDto = MapDtoImport.getSigitTCompCINew(rowCIsost, codImpianto, progressivo);
								getDbMgr().getSigitTCompXDao().insert(xSostDto);
								getDbMgr().getSigitTCompCiDao().insert(xCiDto);
							}
						}
					}
			}
		}	

		log.debug("[DbMgrImport::consolidaCIImp] end");

	}

	public void consolidaUTImp(List<L95UT> acList, BigDecimal codImpianto, String cfUtente) throws SigitTCompXDaoException, SigitTCompUtDaoException {

		log.debug("[DbMgrImport::consolidaUTImp] start");

		getDbMgr().getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp_ut", "codice_impianto="+codImpianto));

		getDbMgr().getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp_x", "codice_impianto="+codImpianto+"&tipo_componente=UT"));
		if(acList !=null)
		{
			if(acList!=null)
			{
				log.debug("Consolidamento scheda 9: UT");
				if(acList!=null)
					for (L95UT rowUT : acList) {
						SigitTCompXDto compX = MapDtoImport.getSigitTCompXNew(rowUT.getL95UnitaTrattAria(), codImpianto, rowUT.getL95Numero(), cfUtente);
						if(compX !=null && compX.getDataInstall()!=null)
						{
							log.debug("Inserimento COMP UT");
							SigitTCompUtDto compUt = MapDtoImport.getSigitTCompUTNew(rowUT.getL95UnitaTrattAria(), codImpianto, rowUT.getL95Numero());

							getDbMgr().getSigitTCompXDao().insert(compX);
							getDbMgr().getSigitTCompUtDao().insert(compUt);
						}
						log.debug("Inserimento sezione sostituite");
						List<L95UnitaTrattAriaSostituito> rowCIsostList = rowUT.getL95UnitaTrattAriaSostituitoList();
						if(rowCIsostList!=null)
							for (L95UnitaTrattAriaSostituito rowUTsost : rowCIsostList) {
								String progressivo = ConvertUtil.convertToString(rowUT.getL95Numero());
								SigitTCompXDto xSostDto = MapDtoImport.getSigitTCompXNew(rowUTsost, codImpianto, progressivo, cfUtente);
								SigitTCompUtDto xUtDto = MapDtoImport.getSigitTCompUTNew(rowUTsost, codImpianto, progressivo);

								getDbMgr().getSigitTCompXDao().insert(xSostDto);
								getDbMgr().getSigitTCompUtDao().insert(xUtDto);
							}
					}
			}
		}	

		log.debug("[DbMgrImport::consolidaUTImp] end");

	}

	public void consolidaRCImp(List<L96RCX> rowRCList, BigDecimal codImpianto, String cfUtente) throws SigitTCompXDaoException, SigitTCompRcDaoException {

		log.debug("[DbMgrImport::consolidaRCImp] start");

		getDbMgr().getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp_rc", "codice_impianto="+codImpianto));

		getDbMgr().getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp_x", "codice_impianto="+codImpianto+"&tipo_componente=RC"));

		if(rowRCList !=null)
		{
			if(rowRCList!=null)
			{
				log.debug("Consolidamento scheda 9: RC");

				if(rowRCList!=null)
					for (L96RCX rowRC : rowRCList) {
						SigitTCompXDto compX = MapDtoImport.getSigitTCompXNew(rowRC.getL96RecuperatoreAriaAmb(), codImpianto, rowRC.getL96Numero(), cfUtente);
						if(compX !=null && compX.getDataInstall()!=null)
						{
							log.debug("Inserimento COMP RC");
							SigitTCompRcDto compRc = MapDtoImport.getSigitTCompRCNew(rowRC.getL96RecuperatoreAriaAmb(), codImpianto, rowRC.getL96Numero());

							getDbMgr().getSigitTCompXDao().insert(compX);
							getDbMgr().getSigitTCompRcDao().insert(compRc);
						}

						log.debug("Inserimento sezione sostituite");
						List<L96RecuperatoreAriaAmbSostituito> rowRCsostList = rowRC.getL96RecuperatoreAriaAmbSostituitoList();
						if(rowRCsostList!=null)
							for (L96RecuperatoreAriaAmbSostituito rowRCsost : rowRCsostList) {
								String progressivo = ConvertUtil.convertToString(rowRC.getL96Numero());
								SigitTCompXDto xSostDto = MapDtoImport.getSigitTCompXNew(rowRCsost, codImpianto, progressivo, cfUtente);
								SigitTCompRcDto xRcDto = MapDtoImport.getSigitTCompRCNew(rowRCsost, codImpianto, progressivo);

								getDbMgr().getSigitTCompXDao().insert(xSostDto);
								getDbMgr().getSigitTCompRcDao().insert(xRcDto);
							}
					}
			}
		}	

		log.debug("[DbMgrImport::consolidaTrattamentoH2oImp] end");

	}

	public void consolidaVMImp(List<L101VM> rowVMList, BigDecimal codImpianto, String cfUtente) throws SigitTCompXDaoException, SigitTCompVmDaoException {

		log.debug("[DbMgrImport::consolidaVMImp] start");

		getDbMgr().getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp_vm", "codice_impianto="+codImpianto));

		getDbMgr().getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_comp_x", "codice_impianto="+codImpianto+"&tipo_componente=VM"));
		if(rowVMList !=null)
		{

			if(rowVMList!=null)
			{
				log.debug("Consolidamento scheda 10: VM");

				if(rowVMList!=null)
					for (L101VM rowVM : rowVMList) {
						SigitTCompXDto compX = MapDtoImport.getSigitTCompXNew(rowVM.getL101VentilazioneMeccanica(), codImpianto, rowVM.getL101Numero(), cfUtente);
						if(compX !=null && compX.getDataInstall()!=null)
						{
							log.debug("Inserimento COMP VM");
							SigitTCompVmDto compVm = MapDtoImport.getSigitTCompVMNew(rowVM.getL101VentilazioneMeccanica(), codImpianto, rowVM.getL101Numero());

							getDbMgr().getSigitTCompXDao().insert(compX);
							getDbMgr().getSigitTCompVmDao().insert(compVm);
						}

						log.debug("Inserimento sezione sostituite");
						List<L101VentilazioneMeccanicaSostituito> rowVMsostList = rowVM.getL101VentilazioneMeccanicaSostituitoList();
						if(rowVMsostList!=null)
							for (L101VentilazioneMeccanicaSostituito rowVMsost : rowVMsostList) {
								String progressivo = ConvertUtil.convertToString(rowVM.getL101Numero());
								SigitTCompXDto xSostDto = MapDtoImport.getSigitTCompXNew(rowVMsost, codImpianto, progressivo, cfUtente);
								SigitTCompVmDto xVmDto = MapDtoImport.getSigitTCompVMNew(rowVMsost, codImpianto, progressivo);

								getDbMgr().getSigitTCompXDao().insert(xSostDto);
								getDbMgr().getSigitTCompVmDao().insert(xVmDto);
							}
					}
			}
		}

		log.debug("[DbMgrImport::consolidaVMImp] end");

	}

	public void consolidaConsumoCombustibileImp(List<L141ConsumoCombustibile> rowCombuList, BigDecimal codImpianto, String cfUtente) throws SigitTConsumoDaoException {
		log.debug("[DbMgrImport::consolidaConsumoCombustibileImp] start");

		getDbMgr().getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_consumo", "codice_impianto="+codImpianto+"&tipo_consumo=14.1(CB)"));
		if(rowCombuList !=null)
		{

			if(rowCombuList!=null)
			{
				log.debug("Consolidamento scheda 14.1 : combustibile");

				if(rowCombuList!=null)
					for (L141ConsumoCombustibile rowCombu : rowCombuList) {
						BigDecimal tipoCombustibile = null;
						BigDecimal unitaMisura = null;

						try{tipoCombustibile = ConvertUtil.convertToBigDecimal(rowCombu.getL141Combustibile());}catch(Exception e){}

						try{unitaMisura = ConvertUtil.convertToBigDecimal(rowCombu.getL141UnitaMisura());}catch(Exception e){}

						List<L141DatiConsumoCombustibile> rowConsumoList = rowCombu.getL141DatiConsumoCombustibileList();
						if(rowConsumoList!=null)
							for (L141DatiConsumoCombustibile rowConsumo : rowConsumoList) {
								SigitTConsumoDto dto = MapDtoImport.getSigitTConsumoNew(rowConsumo, codImpianto, tipoCombustibile, unitaMisura, cfUtente);

								if (dto != null)
								{
									log.debug("Inserimento CONSUMO CB");
									getDbMgr().getSigitTConsumoDao().insert(dto);
								}
							}
					}
			}
		}	
		log.debug("[DbMgrImport::consolidaConsumoCombustibileImp] end");
	}

	public void consolidaConsumoEnergiaImp(L142ConsumoEnergiaElettrica rowEnergia, BigDecimal codImpianto, String cfUtente) throws SigitTConsumoDaoException {

		log.debug("[DbMgrImport::consolidaConsumoEnergiaImp] start");

		getDbMgr().getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_consumo", "codice_impianto="+codImpianto+"&tipo_consumo=14.2(EE)"));
		if(rowEnergia !=null)
		{

			log.debug("Consolidamento scheda 14.2 : energia elettrica");
			List<L142DatiConsumoEnergiaElettrica> rowEnergiaList = rowEnergia.getL142DatiConsumoEnergiaElettricaList();
			if(rowEnergiaList!=null)
				for (L142DatiConsumoEnergiaElettrica rowEE : rowEnergiaList) {
					SigitTConsumoDto dto = MapDtoImport.getSigitTConsumoNew(rowEE, codImpianto, cfUtente);
					if(GenericUtil.isNotNullOrEmpty(dto.getEsercizioDa()) || GenericUtil.isNotNullOrEmpty(dto.getEsercizioA()) 
							|| GenericUtil.isNotNullOrEmpty(dto.getConsumo())
							|| GenericUtil.isNotNullOrEmpty(dto.getLetturaFinale())
							|| GenericUtil.isNotNullOrEmpty(dto.getLetturaIniziale()))
					{
						log.debug("Inserimento CONSUMO EE");
						getDbMgr().getSigitTConsumoDao().insert(dto);
					}
				}
		}

		log.debug("[DbMgrImport::consolidaConsumoEnergiaImp] end");
	}

	public void consolidaConsumoH2OImp(L143ConsumoAcqua sezH2O, BigDecimal codImpianto, String cfUtente) throws SigitTConsumoDaoException {

		log.debug("[DbMgrImport::consolidaConsumoH2OImp] start");

		getDbMgr().getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_consumo", "codice_impianto="+codImpianto+"&tipo_consumo=14.3(H2O)"));
		if(sezH2O !=null)
		{
			String unitaMisura = ConvertUtil.convertToString(sezH2O.getL143UnitaMisura()); 

			if(sezH2O!=null)
			{
				log.debug("Consolidamento scheda 14.3 : acqua");
				List<L143DatiConsumoAcqua> rowH2OList = sezH2O.getL143DatiConsumoAcquaList();
				if(rowH2OList!=null)
					for (L143DatiConsumoAcqua rowH2O : rowH2OList) {
						SigitTConsumoDto dto = MapDtoImport.getSigitTConsumoNew(rowH2O, codImpianto, unitaMisura, cfUtente);
						if(GenericUtil.isNotNullOrEmpty(dto.getEsercizioDa()) || GenericUtil.isNotNullOrEmpty(dto.getEsercizioA()) 
								|| GenericUtil.isNotNullOrEmpty(dto.getConsumo())
								|| GenericUtil.isNotNullOrEmpty(dto.getLetturaFinale())
								|| GenericUtil.isNotNullOrEmpty(dto.getLetturaIniziale()))
						{
							log.debug("Inserimento CONSUMO H2O");
							getDbMgr().getSigitTConsumoDao().insert(dto);
						}
					}
			}
		}

		log.debug("[DbMgrImport::consolidaConsumoH2OImp] end");

	}

	public void consolidaConsumoProdottiChimici(L144ConsumoProdottiChimici sezPC, BigDecimal codImpianto, String cfUtente) throws SigitTConsumo14_4DaoException {

		log.debug("[DbMgrImport::consolidaConsumoProdottiChimici] start");

		getDbMgr().getSigitWrkLogDao().insert(MapDto.mapToSigitWrkLogDto(cfUtente, "sigit_t_consumo_14_4", "codice_impianto="+codImpianto));

		if(sezPC!=null)
		{
			log.debug("Consolidamento scheda 14.4 : prodotti chimici");
			List<L144DatiConsumoProdottiChimici> rowPCList = sezPC.getL144DatiConsumoProdottiChimiciList();
			if(rowPCList!=null)
				for (L144DatiConsumoProdottiChimici rowPC : rowPCList) {
					SigitTConsumo14_4Dto dto = MapDtoImport.getSigitTConsumo144New(rowPC, codImpianto, cfUtente);
					if(GenericUtil.isNotNullOrEmpty(dto.getEsercizioDa()) || 
							GenericUtil.isNotNullOrEmpty(dto.getEsercizioA()) 
							|| GenericUtil.isNotNullOrEmpty(dto.getNomeProdotto())
							|| GenericUtil.isNotNullOrEmpty(dto.getQtaConsumata())
							|| GenericUtil.isNotNullOrEmpty(dto.getFlgAca())
							|| GenericUtil.isNotNullOrEmpty(dto.getFlgCircuitoAcs())
							|| GenericUtil.isNotNullOrEmpty(dto.getFlgCircuitoIt()))
					{
						log.debug("Inserimento CONSUMO prod chimici");
						getDbMgr().getSigitTConsumo144Dao().insert(dto);
					}
				}
		}
		log.debug("[DbMgrImport::consolidaConsumoProdottiChimici] end");
	}



}

