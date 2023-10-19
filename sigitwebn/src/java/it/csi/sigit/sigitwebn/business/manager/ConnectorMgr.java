/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitwebn.business.manager;


import it.csi.csi.wrapper.SystemException;
import it.csi.csi.wrapper.UserException;
//import it.csi.modolxp.modolxppdfgensrv.dto.Utente;
//import it.csi.modolxp.modolxppdfgensrv.dto.pdfa.PdfAInputRequest;
//import it.csi.modolxp.modolxppdfgensrv.dto.pdfstatic.PdfStaticInputRequest;
//import it.csi.modolxp.modolxppdfgensrv.exception.ModolPdfGeneratorSrvException;
//import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitRImpiantoContrattoDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.DaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitDCombustibileDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitDTipoDocAggDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitExtDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitRComp4ManutDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitRImpRuoloPfpgDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitRRuoloTipodocDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitTAllegatoDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitTCodiceBollDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitTComp4DaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitTCompCgDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitTCompVxDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitTConsumo14_4DaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitTConsumoDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitTControlloLibrettoDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitTImpiantoDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitTPersonaGiuridicaDaoException;
//import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitTTransazioneBollDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitVCompAcDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitVCompAgDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitVCompCiDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitVCompCsDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitVCompPoDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitVCompRcDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitVCompRvDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitVCompScxDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitVCompSrDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitVCompTeDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitVCompUtDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitVCompVmDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitVCompVrDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitVRicercaAllegatiDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.CompFilter;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.FiltroRicercaAllegati;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.ImpiantoFilter;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.ImportDistribFilter;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.ImportDocumentoFilter;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.RicercaAvanzataImpiantoFilter;import it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.RicercaVerificaFilter;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.TransazioneFilter;
import it.csi.sigit.sigitwebn.business.manager.util.DbManagerException;
import it.csi.sigit.sigitwebn.business.manager.util.ManagerException;
import it.csi.sigit.sigitwebn.business.manager.util.Message;
import it.csi.sigit.sigitwebn.business.manager.util.ServiceException;
import it.csi.sigit.sigitwebn.business.manager.util.ValidationManagerException;
import it.csi.sigit.sigitwebn.dto.ExecResults;
import it.csi.sigit.sigitwebn.dto.accertamento.Accertamento;
import it.csi.sigit.sigitwebn.dto.accesso.PersonaFisica;
import it.csi.sigit.sigitwebn.dto.accesso.PersonaGiuridica;
import it.csi.sigit.sigitwebn.dto.accesso.Ruolo;
import it.csi.sigit.sigitwebn.dto.allegati.AllegatiPerImpianto;
import it.csi.sigit.sigitwebn.dto.allegati.DettaglioAllegato;
import it.csi.sigit.sigitwebn.dto.allegati.ElencoAllegati;
import it.csi.sigit.sigitwebn.dto.allegati.FiltroControlloInserisciAllegato;
import it.csi.sigit.sigitwebn.dto.allegati.FiltroRicercaCodiciImpianto;
import it.csi.sigit.sigitwebn.dto.allegati.FiltroRicercaNumeriBollino;
import it.csi.sigit.sigitwebn.dto.allegati.RicercaAllegati;
import it.csi.sigit.sigitwebn.dto.bollini.AcquistoBollini;
import it.csi.sigit.sigitwebn.dto.bollini.AcquistoBolliniQuantita;
import it.csi.sigit.sigitwebn.dto.codici_impianto.RisultatoRicCodImpiantoLib;
import it.csi.sigit.sigitwebn.dto.common.CodeDescription;
import it.csi.sigit.sigitwebn.dto.common.UDTPositiveInteger;
import it.csi.sigit.sigitwebn.dto.delega.Delegato;
import it.csi.sigit.sigitwebn.dto.distributori.DettaglioErrore;
import it.csi.sigit.sigitwebn.dto.documentazione.Documento;
import it.csi.sigit.sigitwebn.dto.impianto.IdentificativoImpianto;
import it.csi.sigit.sigitwebn.dto.impianto.Impianto;
import it.csi.sigit.sigitwebn.dto.impianto.Responsabile;
import it.csi.sigit.sigitwebn.dto.impianto.RicercaAvanzataImpianti;
import it.csi.sigit.sigitwebn.dto.impianto.RicercaImpianti;
import it.csi.sigit.sigitwebn.dto.impianto.RisultatoRicImpianto;
import it.csi.sigit.sigitwebn.dto.impianto.RisultatoRicResponsabile;
import it.csi.sigit.sigitwebn.dto.impresa.Impresa;
import it.csi.sigit.sigitwebn.dto.impresa.LabelValue;
import it.csi.sigit.sigitwebn.dto.impresa.RicercaImprese;
import it.csi.sigit.sigitwebn.dto.index.DettaglioDocumento;
import it.csi.sigit.sigitwebn.dto.index.DettaglioDocumentoMultiplo;
import it.csi.sigit.sigitwebn.dto.index.Metadati;
import it.csi.sigit.sigitwebn.dto.ispezioni.ConclusioneIspezione2018;
import it.csi.sigit.sigitwebn.dto.ispezioni.DettaglioIspezione;
import it.csi.sigit.sigitwebn.dto.ispezioni.Ispezione2018;
import it.csi.sigit.sigitwebn.dto.ispezioni.IspezioniPerImpianto;
import it.csi.sigit.sigitwebn.dto.ispezioni.RapProvaDatiGenerali;
import it.csi.sigit.sigitwebn.dto.libretto.Componente;
import it.csi.sigit.sigitwebn.dto.libretto.ComponenteBRRC;
import it.csi.sigit.sigitwebn.dto.libretto.ComponenteCG;
import it.csi.sigit.sigitwebn.dto.libretto.ComponenteGF;
import it.csi.sigit.sigitwebn.dto.libretto.ComponenteGT;
import it.csi.sigit.sigitwebn.dto.libretto.ComponenteSC;
import it.csi.sigit.sigitwebn.dto.libretto.ComponenteVX;
import it.csi.sigit.sigitwebn.dto.libretto.Consumo;
import it.csi.sigit.sigitwebn.dto.libretto.ConsumoAcqua;
import it.csi.sigit.sigitwebn.dto.libretto.ControlloLibretto;
import it.csi.sigit.sigitwebn.dto.libretto.DatiExtra;
import it.csi.sigit.sigitwebn.dto.libretto.DettaglioManutenzione;
import it.csi.sigit.sigitwebn.dto.libretto.LibrettoDett;
import it.csi.sigit.sigitwebn.dto.libretto.PkTabellaEdit;
import it.csi.sigit.sigitwebn.dto.libretto.RisultatiCombustibile;
import it.csi.sigit.sigitwebn.dto.libretto.RisultatiConsumo;
import it.csi.sigit.sigitwebn.dto.libretto.Scheda1;
import it.csi.sigit.sigitwebn.dto.libretto.Scheda11;
import it.csi.sigit.sigitwebn.dto.libretto.Scheda11Intest;
import it.csi.sigit.sigitwebn.dto.libretto.Scheda12;
import it.csi.sigit.sigitwebn.dto.libretto.SistemaEmissione;
import it.csi.sigit.sigitwebn.dto.libretto.SistemiDistribuzione;
import it.csi.sigit.sigitwebn.dto.libretto.SistemiRegolazioneContabilizzazione;
import it.csi.sigit.sigitwebn.dto.libretto.TrattamentoAcqua;
import it.csi.sigit.sigitwebn.dto.main.RicercaTransazione;
import it.csi.sigit.sigitwebn.dto.main.RisultatoRicTransazione;
import it.csi.sigit.sigitwebn.dto.main.UtenteLoggato;
import it.csi.sigit.sigitwebn.dto.ree.Tipo1;
import it.csi.sigit.sigitwebn.dto.ree.Tipo1Dett;
import it.csi.sigit.sigitwebn.dto.ree.Tipo1DettModulo;
import it.csi.sigit.sigitwebn.dto.ree.Tipo2;
import it.csi.sigit.sigitwebn.dto.ree.Tipo2Dett;
import it.csi.sigit.sigitwebn.dto.ree.Tipo2DettCircuito;
import it.csi.sigit.sigitwebn.dto.ree.Tipo3;
import it.csi.sigit.sigitwebn.dto.ree.Tipo3Dett;
import it.csi.sigit.sigitwebn.dto.ree.Tipo4;
import it.csi.sigit.sigitwebn.dto.ree.Tipo4Dett;
import it.csi.sigit.sigitwebn.dto.subentro.Subentro;
import it.csi.sigit.sigitwebn.dto.terzoresponsabile.CessazioneTerzaResponsabilita;
import it.csi.sigit.sigitwebn.dto.terzoresponsabile.DettaglioTerzoResponsabile;
import it.csi.sigit.sigitwebn.dto.terzoresponsabile.ProrogaTerzoResponsabile;
import it.csi.sigit.sigitwebn.dto.terzoresponsabile.TerzoResponsabile;
import it.csi.sigit.sigitwebn.dto.verifica.Verifica;
import it.csi.sigit.sigitwebn.util.Constants;
import it.csi.sigit.sigitwebn.util.ConvertUtil;
import it.csi.sigit.sigitwebn.util.DateUtil;
import it.csi.sigit.sigitwebn.util.GenericUtil;
import it.csi.sigit.sigitwebn.util.MapDto;
import it.csi.sigit.sigitwebn.util.Messages;
import it.csi.sigit.sigitwebn.util.ReeSuperDto;
import it.csi.sigit.sigitwebn.util.XmlBeanUtils;
import it.csi.sigit.sigitwebn.util.mail.ResultInvioMail;
import it.csi.sigit.sigitwebn.xml.allegato2.data.CheckListDocument.CheckList;
import it.csi.sigit.sigitwebn.xml.allegato2.data.ControlloImpiantoDocument.ControlloImpianto;
import it.csi.sigit.sigitwebn.xml.allegato2.data.ControlloVerificaEnergeticaDocument.ControlloVerificaEnergetica;
import it.csi.sigit.sigitwebn.xml.allegato2.data.DatiTecnicoDocument.DatiTecnico;
import it.csi.sigit.sigitwebn.xml.allegato2.data.DocumentazioneTecnicaDocument.DocumentazioneTecnica;
import it.csi.sigit.sigitwebn.xml.allegato2.data.MODIIDocument;
import it.csi.sigit.sigitwebn.xml.allegato2.data.RowAllegatoIIDocument.RowAllegatoII;
import it.csi.sigit.sigitwebn.xml.allegato2.data.RowAllegatoIIDocument.RowAllegatoII.TabFumi;
import it.csi.sigit.sigitwebn.xml.allegato2.data.RowFumiDocument.RowFumi;
import it.csi.sigit.sigitwebn.xml.allegato3.data.MODIIIDocument;
import it.csi.sigit.sigitwebn.xml.allegato3.data.RowAllegatoIIIDocument.RowAllegatoIII;
import it.csi.sigit.sigitwebn.xml.allegato4.data.MODIVDocument;
import it.csi.sigit.sigitwebn.xml.allegato4.data.RowAllegatoIVDocument.RowAllegatoIV;
import it.csi.sigit.sigitwebn.xml.allegato5.data.MODVDocument;
import it.csi.sigit.sigitwebn.xml.allegato5.data.RowAllegatoVDocument.RowAllegatoV;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.LibrettoDocument;
import it.csi.sigit.sigitwebn.xml.libretto.data.MODDocument;
import it.csi.sigit.sigitwebn.xml.libretto.data.DatiPrecompilatiDocument.DatiPrecompilati;
import it.csi.sigit.sigitwebn.xml.libretto.data.RichiestaDocument.Richiesta;
import it.csi.sigit.sigitwebn.xml.libretto.data.RowGTDocument.RowGT;
//import it.doqui.index.ecmengine.dto.OperationContext;















import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.util.HSSFColor.AQUA;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

/**
 * Manager specifico del sigit, questo manager è stato creato per risolvere un problema sulla transazione, infatti un metodo non transazionale 
 * se chiama al suo interno 2 metodi transazionali, la transazionalita' non funziona.
 * Quindi e' stato creato questa classe che contiene metodi NON transazionali che richiamano metodi transazionali (dentro sigitMgr)
 * 
 */
public class ConnectorMgr {

	
	protected static Logger log = Logger.getLogger(Constants.APPLICATION_CODE + ".business.manager");
	
	private SigitMgr sigitMgr;
	private DbMgr dbMgr;
	private ServiziMgr serviziMgr;

	public SigitMgr getSigitMgr() {
		return sigitMgr;
	}

	public void setSigitMgr(SigitMgr sigitMgr) {
		this.sigitMgr = sigitMgr;
	}

	public DbMgr getDbMgr() {
		return dbMgr;
	}

	public void setDbMgr(DbMgr dbMgr) {
		this.dbMgr = dbMgr;
	}
	
	public ServiziMgr getServiziMgr() {
		return serviziMgr;
	}

	public void setServiziMgr(ServiziMgr serviziMgr) {
		this.serviziMgr = serviziMgr;
	}
	
	public ResultInvioMail inviaAllegatoTrans(DettaglioAllegato dettaglio, Integer idPgCat, UtenteLoggato utenteLoggato)throws ManagerException {
		log.debug("[ConnectorMgr::inviaAllegatoTrans] START");
		ResultInvioMail resultInvioMail = null;
		try {
			resultInvioMail = getSigitMgr().inviaAllegatoNow(dettaglio, utenteLoggato.getCodiceFiscale(), idPgCat);
			
			getSigitMgr().inviaAllegatoLibretto(dettaglio.getCodiceImpianto(), dettaglio.getIdPersonaGiuridica(), Constants.ID_MOTIVO_CONSOLIDAMENTO_INVIO_RAPP_CONTROLLO, utenteLoggato, false);
		}
		catch (ManagerException e) {
			
			throw e;
		} finally {			
			log.debug("[ConnectorMgr::inviaAllegatoTrans] END");
		}
		
		return resultInvioMail;
		

	}

	public void inviaRappProvaTrans(DettaglioAllegato dettaglio, Integer idPgCat, String cfUtenteLoggato)throws ManagerException {
		log.debug("[ConnectorMgr::inviaRappProvaTrans] START");
		try {
			getSigitMgr().inviaRappProvaNow(dettaglio, cfUtenteLoggato, idPgCat);
			
			//getSigitMgr().inviaAllegatoLibretto(dettaglio.getCodiceImpianto(), dettaglio.getIdPersonaGiuridica(), Constants.ID_MOTIVO_CONSOLIDAMENTO_INVIO_RAPP_CONTROLLO, cfUtenteLoggato, isIspezione);
		}
		catch (ManagerException e) {
			
			throw e;
		}
		log.debug("[ConnectorMgr::inviaRappProvaTrans] END");

	}

	public ResultInvioMail respingiAllegato(String idAllegato, UtenteLoggato utenteLoggato, String motivoRespinto) throws ManagerException {
		log.debug("[ConnectorMgr::respingiAllegato] BEGIN");
		ResultInvioMail resultInvioMail = null;
		try
		{
			getSigitMgr().respingiAllegato(ConvertUtil.convertToBigDecimal(idAllegato), utenteLoggato.getCodiceFiscale(), motivoRespinto);
			
			resultInvioMail = getSigitMgr().respingiAllegatoLibretto(idAllegato, utenteLoggato);

		}
		catch (Exception e) {

			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_SERVIZIO));
		}
		finally {
			log.debug("[ConnectorMgr::respingiAllegato] END");
		}
		return resultInvioMail;
	}
	
	
	public String diventa3Responsabile2019(TerzoResponsabile resp, UtenteLoggato utente, List<Integer> elencoAutodichiarazioni)throws ManagerException {
		log.debug("[ConnectorMgr::diventa3Responsabile] START");
		try {
			//inserimento nuovo contratto piu' autodichiarazioni
			getSigitMgr().diventa3ResponsabileNow2019(resp, utente, elencoAutodichiarazioni);
			
			return getSigitMgr().diventa3ResponsabileLibretto(resp, null, utente);
		}
		catch (ManagerException e) {
			
			throw e;
		}
		finally
		{
			log.debug("[ConnectorMgr::diventa3Responsabile] END");
		}

	}
	
	public void concludiIspezione2018(Ispezione2018 ispezione, ConclusioneIspezione2018 datiConclusione, UtenteLoggato utente, List<DettaglioAllegato> listaAllegati) throws ManagerException {
		log.debug("[ConnectorMgr::concludiIspezione2018] START");
		try {
			//viene richiamato il metodo per il salvataggio delle info sul db
			getSigitMgr().concludiIspezionePrimaParte(ispezione, datiConclusione, utente, listaAllegati);
			
			//viene richiamato il metodo per consolidare il libretto e inviare la mail
			getSigitMgr().concludiIspezioneSecondaParte(ispezione, datiConclusione, utente);
		} catch (ManagerException e) {
			throw e;
		}
		finally
		{
			log.debug("[ConnectorMgr::concludiIspezione2018] END");
		}
	}
	
	public void annullaIspezione2018(Ispezione2018 ispezione, UtenteLoggato utente, List<DettaglioAllegato> listaAllegati) throws ManagerException {
		log.debug("[ConnectorMgr::annullaIspezione2018] START");
		try {
			//viene richiamato il metodo per il salvataggio delle info sul db
			getSigitMgr().annullaIspezionePrimaParte(ispezione, utente, listaAllegati);
			
			//viene richiamato il metodo per consolidare il libretto e inviare la mail
			getSigitMgr().annullaIspezioneSecondaParte(ispezione, utente);
		} catch (ManagerException e) {
			throw e;
		}
		finally
		{
			log.debug("[ConnectorMgr::annullaIspezione2018] END");
		}
	}
	
	
	public String proroga3Responsabile2019(DettaglioTerzoResponsabile terzoResponsabile, ProrogaTerzoResponsabile proroga, UtenteLoggato utente) throws ManagerException {
		log.debug("[ConnectorMgr::proroga3Responsabile2019] START");
		try {
			//invocato metodo per persistere dati sul db
			getSigitMgr().proroga3ResponsabileNow2019(terzoResponsabile, proroga, utente);
			
			return getSigitMgr().proroga3ResponsabileLibretto(terzoResponsabile, proroga, utente);
			//return getSigitMgr().diventa3ResponsabileLibretto(resp, null, utente, Constants.ID_MOTIVO_CONSOLIDAMENTO_PROROGA_3_RESP);

			
		} catch (ManagerException e) {
			
			throw e;
		}
		finally
		{
			log.debug("[ConnectorMgr::proroga3Responsabile2019] END");
		}
		
		
	}

	public String revoca3Responsabile2019(DettaglioTerzoResponsabile dett3Resp, UtenteLoggato utente, CessazioneTerzaResponsabilita datiCessazione, Integer idContratto) throws ManagerException {
		log.debug("[ConnectorMgr::revoca3Responsabile] START");
		try {
			
			CodeDescription coppiaIdAccertamentoMailPA = getSigitMgr().revoca3Responsabile2019Now(dett3Resp.getCodImpianto(), utente.getRuolo().getDescRuolo(), idContratto, datiCessazione, utente.getCodiceFiscale());
			
			return getSigitMgr().revoca3ResponsabileLibretto2019(idContratto, dett3Resp.getCodImpianto(), utente.getRuolo(), utente, datiCessazione, dett3Resp.getIdPersonaGiuridica(), coppiaIdAccertamentoMailPA);
		}
		catch (ManagerException e) {
			
			throw e;
		}
		finally
		{
			log.debug("[ConnectorMgr::revoca3Responsabile] END");
		}

	}
	

	public ResultInvioMail caricaManutenzione(DettaglioManutenzione dettaglio, UtenteLoggato utente) throws ManagerException {
		log.debug("[ConnectorMgr::caricaManutenzione] BEGIN");
		ResultInvioMail resultInvioMail = null;
		try
		{
			DettaglioManutenzione dettaglioManutenzione = getSigitMgr().salvaManutenzioneTrans(dettaglio, utente);
			
			getSigitMgr().inviaAllegatoLibretto(dettaglio.getCodiceImpianto(), dettaglio.getIdPersonaGiuridica(), Constants.ID_MOTIVO_CONSOLIDAMENTO_CARICAMENTO_MANUT, utente, false);

			SigitVRicercaAllegatiDto vAllegato = getDbMgr().cercaSigitVRicercaAllegatiByIdAllegato(dettaglioManutenzione.getIdAllegato());

			List<SigitVRicerca3ResponsabileDto> list3RespAttiviImpianto = getDbMgr().cerca3ResponsabiliAttiviAllaDataByCodImpiantoComp(dettaglioManutenzione.getCodiceImpianto(), dettaglioManutenzione.getDataManut());

			PersonaGiuridica pg3Resp = null;
			if (list3RespAttiviImpianto != null && list3RespAttiviImpianto.size() > 0) {
				SigitVRicerca3ResponsabileDto vTot3Responsabile = list3RespAttiviImpianto.get(0);
				pg3Resp = getDbMgr().cercaPersonaGiuridicaById(vTot3Responsabile.getFkPg3Resp().intValue());
			}
			
			String emailResponsabile = getSigitMgr().cercaEMailResponsabileAttivoAllaDataByCodImpianto(dettaglioManutenzione.getCodiceImpianto(), dettaglioManutenzione.getDataManut());	

			SigitTPersonaGiuridicaDto manutentore = getDbMgr().cercaTPersonaGiuridicaById(dettaglioManutenzione.getIdPersonaGiuridica());

			resultInvioMail = getServiziMgr().sendMailInserisciManutenzione(vAllegato, manutentore, emailResponsabile, pg3Resp);

		}
		catch (Exception e) {

			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_SERVIZIO));
		}
		finally {
			log.debug("[ConnectorMgr::caricaManutenzione] END");
		}
		
		return resultInvioMail;
	}

	public ResultInvioMail annullaManutenzione(String idAllegato, UtenteLoggato utenteLoggato) throws ManagerException {
		log.debug("[ConnectorMgr::respingiAllegato] BEGIN");
		ResultInvioMail resultInvioMail = null;
		try
		{
			String cfUtenteMod = utenteLoggato.getCodiceFiscale();
			String motivoRespinto = Constants.MOTIVAZIONE_ANNULLA_MANUTENZIONE + " " + cfUtenteMod;
			getSigitMgr().annullaManutenzione(ConvertUtil.convertToBigDecimal(idAllegato), cfUtenteMod, motivoRespinto);
			
			resultInvioMail = getSigitMgr().annullaManutenzioneLibretto(idAllegato, utenteLoggato);

		}
		catch (Exception e) {

			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_SERVIZIO));
		}
		finally {
			log.debug("[ConnectorMgr::respingiAllegato] END");
		}
		return resultInvioMail;
	}
	
	
	
//	public void consolidaIspezione(DettaglioIspezione dettaglio, String cfUtenteLoggato) throws ManagerException {
//		log.debug("[ConnectorMgr::consolidaIspezione] BEGIN");
//		ResultInvioMail resultInvioMail = null;
//		try
//		{
//			getSigitMgr().consolidaIspezioneNow(dettaglio,
//					cfUtenteLoggato);
//			
//			getSigitMgr().inviaAllegatoLibretto(dettaglio.getCodiceImpianto(), null, Constants.ID_MOTIVO_CONSOLIDAMENTO_CARICAMENTO_ISP, cfUtenteLoggato, true);
//		}
//		catch (Exception e) {
//
//			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_SERVIZIO));
//		}
//		finally {
//			log.debug("[ConnectorMgr::consolidaIspezione] END");
//		}
//	}

//	public void annullaIspezione(DettaglioIspezione dettaglio, String cfUtenteLoggato) throws ManagerException {
//		log.debug("[ConnectorMgr::annullaIspezione] START");
//		try {
//			getSigitMgr().annullaIspezioneNow(dettaglio, cfUtenteLoggato);
//			getSigitMgr().inviaAllegatoLibretto(dettaglio.getCodiceImpianto(), null, Constants.ID_MOTIVO_CONSOLIDAMENTO_ANNULLAMENTO_ISP, cfUtenteLoggato, true);
//		}
//		catch (ManagerException e) {
//			
//			throw e;
//		}
//		finally
//		{
//			log.debug("[ConnectorMgr::annullaIspezione] END");
//		}
//
//	}

	public void concludiAccertamentoTrans(Accertamento accertamento, UtenteLoggato utenteLoggato)throws ManagerException {
		log.debug("[ConnectorMgr::concludiAccertamentoTrans] START");
		
		if (log.isDebugEnabled())
			GenericUtil.stampa(accertamento, true, 3);
		
		try {
			String cfUtenteLoggato = utenteLoggato.getCodiceFiscale();
			
			getSigitMgr().concludiAccertamento(accertamento, cfUtenteLoggato);
			
			// ** check che permette di rendere un accertamento sostitutivo di una ispezione ("Si tratta di ACCERTAMENTO sostitutivo dell'ispezione (attezione; se flaggato verra' riportato nella scheda 13 del libretto)") 
			if (ConvertUtil.convertToBooleanAllways(accertamento.getFlgSostIspezione()))
			{
				getSigitMgr().inviaAllegatoLibretto(accertamento.getCodiceImpianto(), null, Constants.ID_MOTIVO_CONSOLIDAMENTO_ISP_SOST_ACCERT, utenteLoggato, true);
			}
		}
		catch (ManagerException e) {
			
			throw e;
		}
		log.debug("[ConnectorMgr::concludiAccertamentoTrans] END");

	}

	public void storicizzaLog() throws ManagerException {
		log.debug("[ConnectorMgr::storicizzaLog] START");
		try {
			
			// Cancello i log vecchi da SigitWrkLogPrec
			getDbMgr().eliminaWrkLogPrecOld();
			
			// Recupero i libretti da SigitTLibretto da archiviare
			List<SigitWrkLogDto> logDaArch = getDbMgr().recuperaLogDaArchiviare();
			
			for (SigitWrkLogDto sigitWrkLogDto : logDaArch) {
				
				log.debug("Stampo il log da archiviare: "+sigitWrkLogDto.getIdLog());
				try
				{
					getSigitMgr().archiviaLogStorico(sigitWrkLogDto);
				}
				catch (ManagerException ex)
				{
					log.error("Si e' verificata un'eccezione sull'archiviazione del sigitWrkLogDto: "+sigitWrkLogDto.getIdLog());
					log.error(ex.getCause(), ex);
					// Stampo sui LOG l'eccezione ma proseguo con le eliminazioni
				}
			}
			

			
		}
		catch (ManagerException e) {
			
			throw e;
		}
		finally
		{
			log.debug("[ConnectorMgr::storicizzaLog] END");
		}

	}
	
	public void storicizzaLibretti() throws ManagerException {
		log.debug("[ConnectorMgr::storicizzaLibretti] START");
		try {
			
			// Cancello i libretti da SigitSLibretto
			List<SigitSLibrettoDto> libDaCanc = getDbMgr().recuperaLibrettiDaCancellare();
			
			log.debug("Stampo i libretti da cancellare: "+libDaCanc);
			
			for (SigitSLibrettoDto sigitSLibrettoDto : libDaCanc) {
				
				log.debug("Stampo il libretto da cancellare: "+sigitSLibrettoDto.getIdLibretto());
				try
				{
					getSigitMgr().eliminaLibrettoStorico(sigitSLibrettoDto);
				}
				catch (ManagerException ex)
				{
					log.error("Si e' verificata un'eccezione sulla cancellazione del sigitSLibrettoDto: "+sigitSLibrettoDto.getIdLibretto());
					log.error(ex.getCause(), ex);
					// Stampo sui LOG l'eccezione ma proseguo con le eliminazioni
				}
			}
			
			// Recupero i libretti da SigitTLibretto da archiviare
			List<SigitTLibrettoDto> libDaArch = getDbMgr().recuperaLibrettiDaArchiviare();
			
			for (SigitTLibrettoDto sigitTLibrettoDto : libDaArch) {
				
				log.debug("Stampo il libretto da archiviare: "+sigitTLibrettoDto.getIdLibretto());
				try
				{
					getSigitMgr().archiviaLibrettoStorico(sigitTLibrettoDto);
				}
				catch (ManagerException ex)
				{
					log.error("Si e' verificata un'eccezione sull'archiviazione del sigitTLibrettoDto: "+sigitTLibrettoDto.getIdLibretto());
					log.error(ex.getCause(), ex);
					// Stampo sui LOG l'eccezione ma proseguo con le eliminazioni
				}
			}
			

			
		}
		catch (ManagerException e) {
			
			throw e;
		}
		finally
		{
			log.debug("[ConnectorMgr::storicizzaLibretti] END");
		}

	}

	public void storicizzaLogAccesso() throws ManagerException {
		log.debug("[ConnectorMgr::storicizzaLogAccesso] START");
		
		// Cancello i log vecchi da SigitSAccesso
		getDbMgr().eliminaLogAccessoOld();
		
		// Recupero i log da SigitLAccesso da archiviare
		List<SigitLAccessoDto> listLogDaArch = getDbMgr().recuperaLogAccessoDaArchiviare();
		
		for (SigitLAccessoDto logDaArch : listLogDaArch) {
			
			log.debug("Stampo il log da archiviare: "+logDaArch.getDtAccesso() + " - " + logDaArch.getCodiceFiscale());
			try
			{
				getSigitMgr().archiviaLogAccessoStorico(logDaArch);
			}
			catch (ManagerException ex)
			{
				log.error("Si e' verificata un'eccezione sull'archiviazione del sigitLAccessoDto: "+logDaArch.getDtAccesso() + " - " + logDaArch.getCodiceFiscale());
				log.error(ex.getCause(), ex);
				// Stampo sui LOG l'eccezione ma proseguo con le eliminazioni
			}
		}			
	
		log.debug("[ConnectorMgr::storicizzaLogAccesso] END");
	}
	
	
	// METODI DI PROVA TRANSAZIONALITA'
		public void provaInviaAllegatoTrans()throws ManagerException {
			log.debug("[ConnectorMgr::provaInviaAllegatoTrans] START");
			try {
				
				log.debug("PRIMA di provaPrimoMetodoTrans() - DEVE FALLIRE");
				log.debug("PRIMA di getSigitMgr().provaPrimoMetodoTrans()");
				getSigitMgr().provaPrimoMetodoTrans();

				log.debug("DOPO di getSigitMgr().provaPrimoMetodoTrans()");
				
				log.debug("PRIMA di getSigitMgr().provaSecondoMetodoTrans()");

				getSigitMgr().provaSecondoMetodoTrans();

				log.debug("DOPO di getSigitMgr().provaSecondoMetodoTrans()");
			}
			catch (ManagerException e) {
				log.debug("#### SONO NELLA GESTIONE ECCEZIONE #### ");
				log.error(e.getCause(), e);
				throw e;
			}
			log.debug("[ConnectorMgr::provaInviaAllegatoTrans] END");
		}
		
	@Transactional
	public void provaPrimoMetodoTrans()throws ManagerException {
		log.debug("[ConnectorMgr::provaPrimoMetodoTrans] START");
		try {
			
//			 BEPPE - DA TOGLIERE - SERVE X SIMULARE TRANSAZIONALITA
			if (true)
				throw new ServiceException("PROVA BEPPE - provaPrimoMetodoTrans");
			
		} catch (ServiceException e) {
            log.debug("@@@@@@@@ ENTRO Exception @@@@@@@@");
			try
            {
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            }
            catch (Exception x)
            {
                log.debug("####### ENTRO Exception ROLLBACK #######");
                log.error(x);
                log.debug("####### ESCO Exception ROLLBACK #######");

            }
            log.debug("@@@@@@@@ DOPO ROLLBACK @@@@@@@@");
            
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_SERVIZIO));
		} 
		
		log.debug("[ConnectorMgr::provaPrimoMetodoTrans] END");
	}

	@Transactional
	public void provaSecondoMetodoTrans()throws ManagerException {
		log.debug("[ConnectorMgr::provaSecondoMetodoTrans] START");
		try {
			
//			 BEPPE - DA TOGLIERE - SERVE X SIMULARE TRANSAZIONALITA
			if (true)
				throw new ServiceException("PROVA BEPPE - provaSecondoMetodoTrans");
			
		} catch (ServiceException e) {
            log.debug("@@@@@@@@ ENTRO Exception @@@@@@@@");
			try
            {
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            }
            catch (Exception x)
            {
                log.debug("####### ENTRO Exception ROLLBACK #######");
                log.error(x);
                log.debug("####### ESCO Exception ROLLBACK #######");

            }
            log.debug("@@@@@@@@ DOPO ROLLBACK @@@@@@@@");

            throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_SERVIZIO));
		} 
		
		log.debug("[ConnectorMgr::provaSecondoMetodoTrans] END");
	}
}