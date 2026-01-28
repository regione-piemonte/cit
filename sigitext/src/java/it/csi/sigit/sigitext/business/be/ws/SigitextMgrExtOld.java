/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sigit.sigitext.business.be.ws;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import org.apache.log4j.Logger;

import it.csi.csi.wrapper.CSIException;
import it.csi.csi.wrapper.UnrecoverableException;
import it.csi.sigit.sigitext.business.SpringApplicationContextHelper;
import it.csi.sigit.sigitext.business.be.manager.SigitextManager;
import it.csi.sigit.sigitext.business.util.Constants;
import it.csi.sigit.sigitext.dto.sigitext.DettaglioPersonaGiuridica;
import it.csi.sigit.sigitext.dto.sigitext.Scheda1;
import it.csi.sigit.sigitext.exception.sigitext.SigitExcessiveResultsException;
import it.csi.sigit.sigitext.exception.sigitext.SigitextException;

@WebService(name = "sigitextSigitextOld", targetNamespace = "http://sigitext.interfacecsi.sigitext.sigit.csi.it", serviceName = "services")
//@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL)
@Remote(ISigitextMgrExtOld.class)
@Stateless(name = "SigitextSigitextSL")

public class SigitextMgrExtOld implements ISigitextMgrExtOld {

	private static final Logger logger = Logger.getLogger(Constants.APPLICATION_CODE);

	private SigitextManager getImplSigitextManager() {
		return (SigitextManager) SpringApplicationContextHelper.getBean("sigitextManager");
	}

	public it.csi.sigit.sigitext.dto.sigitext.CodiceDescrizione[] getFluidoCIT( 

	) 
			throws 
			it.csi.csi.wrapper.CSIException, 
			it.csi.csi.wrapper.UnrecoverableException 

			, it.csi.sigit.sigitext.exception.sigitext.SigitextException { 
		try {

			logger.debug("[SigitextBean::getFluidoCIT()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("sigitext");
			// inizio misurazione
			watcher.start();

			it.csi.sigit.sigitext.dto.sigitext.CodiceDescrizione[] valueObjRet = getImplSigitextManager().getFluidoCIT();

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("SigitextBean", "getFluidoCIT()", "invocazione servizio [sigitext]::[getFluidoCIT]", "(valore input omesso)");
			logger.debug("[SigitextBean::getFluidoCIT()] - END");

			return valueObjRet;

		} catch (CSIException e) {

			throw e;
		} catch (Exception e) {

			throw new UnrecoverableException("Errore non recuperabile durante l'esecuzione del metodo:" + e, e);
		}
	}

	@Override
	public it.csi.sigit.sigitext.dto.sigitext.Impianto[] getImpiantoByCodiceJWT( 

			@WebParam(name = "in0") java.lang.Integer codiceImpianto, 

			@WebParam(name = "in1") java.lang.String tokenJWT 

	) 
			throws 
			it.csi.csi.wrapper.CSIException,  
			it.csi.csi.wrapper.UnrecoverableException 

			, it.csi.sigit.sigitext.exception.sigitext.SigitextException

			, it.csi.sigit.sigitext.exception.sigitext.SigitUserNotAuthorizedException { 
		try {

			logger.debug("[SigitextBean::getImpiantoByCodiceJWT()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("sigitext");
			// inizio misurazione
			watcher.start();

			it.csi.sigit.sigitext.dto.sigitext.Impianto[] valueObjRet = getImplSigitextManager().getImpiantoByCodiceJWT(

					codiceImpianto,

					tokenJWT

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("SigitextBean", "getImpiantoByCodiceJWT()", "invocazione servizio [sigitext]::[getImpiantoByCodiceJWT]", "(valore input omesso)");
			logger.debug("[SigitextBean::getImpiantoByCodiceJWT()] - END");

			return valueObjRet;

		} catch (CSIException e) {

			throw e;
		} catch (Exception e) {

			throw new UnrecoverableException("Errore non recuperabile durante l'esecuzione del metodo:" + e, e);
		}
	}

	@Override
	public it.csi.sigit.sigitext.dto.sigitext.Impianto[] getImpiantiByFiltroJWT( 

			@WebParam(name = "in0") it.csi.sigit.sigitext.dto.sigitext.ImpiantoFiltro impiantoFiltro, 

			@WebParam(name = "in1") java.lang.String tokenJWT 

	) 
			throws 
			it.csi.csi.wrapper.CSIException, 
			it.csi.csi.wrapper.UnrecoverableException 

			, it.csi.sigit.sigitext.exception.sigitext.SigitextException

			, it.csi.sigit.sigitext.exception.sigitext.SigitUserNotAuthorizedException { 
		try {

			logger.debug("[SigitextBean::getImpiantiByFiltroJWT()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("sigitext");
			// inizio misurazione
			watcher.start();

			it.csi.sigit.sigitext.dto.sigitext.Impianto[] valueObjRet = getImplSigitextManager().getImpiantiByFiltroJWT(

					impiantoFiltro,

					tokenJWT

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("SigitextBean", "getImpiantiByFiltroJWT()", "invocazione servizio [sigitext]::[getImpiantiByFiltroJWT]", "(valore input omesso)");
			logger.debug("[SigitextBean::getImpiantiByFiltroJWT()] - END");

			return valueObjRet;

		} catch (CSIException e) {

			throw e;
		} catch (Exception e) {

			throw new UnrecoverableException("Errore non recuperabile durante l'esecuzione del metodo:" + e, e);
		}
	}

	@Override
	public it.csi.sigit.sigitext.dto.sigitext.Impianto[] getImpiantoByPODJWT( 

			@WebParam(name = "in0") java.lang.String pod, 

			@WebParam(name = "in1") java.lang.String tokenJWT 

	) 
			throws 
			it.csi.csi.wrapper.CSIException, 
			it.csi.csi.wrapper.UnrecoverableException 

			, it.csi.sigit.sigitext.exception.sigitext.SigitextException

			, it.csi.sigit.sigitext.exception.sigitext.SigitUserNotAuthorizedException

			, it.csi.sigit.sigitext.exception.sigitext.SigitExcessiveResultsException { 
		try {

			logger.debug("[SigitextBean::getImpiantoByPODJWT()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("sigitext");
			// inizio misurazione
			watcher.start();

			it.csi.sigit.sigitext.dto.sigitext.Impianto[] valueObjRet = getImplSigitextManager().getImpiantoByPODJWT(

					pod,

					tokenJWT

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("SigitextBean", "getImpiantoByPODJWT()", "invocazione servizio [sigitext]::[getImpiantoByPODJWT]", "(valore input omesso)");
			logger.debug("[SigitextBean::getImpiantoByPODJWT()] - END");

			return valueObjRet;

		} catch (CSIException e) {

			throw e;
		} catch (Exception e) {

			throw new UnrecoverableException("Errore non recuperabile durante l'esecuzione del metodo:" + e, e);
		}
	}

	@Override
	public it.csi.sigit.sigitext.dto.sigitext.Impianto[] getImpiantoByPDRJWT( 

			@WebParam(name = "in0") java.lang.String pdr, 

			@WebParam(name = "in1") java.lang.String tokenJWT 

	) 
			throws 
			it.csi.csi.wrapper.CSIException, 
			it.csi.csi.wrapper.UnrecoverableException 

			, it.csi.sigit.sigitext.exception.sigitext.SigitextException

			, it.csi.sigit.sigitext.exception.sigitext.SigitUserNotAuthorizedException

			, it.csi.sigit.sigitext.exception.sigitext.SigitExcessiveResultsException { 
		try {
			logger.debug("[SigitextBean::getImpiantoByPDRJWT()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("sigitext");
			// inizio misurazione
			watcher.start();
			it.csi.sigit.sigitext.dto.sigitext.Impianto[] valueObjRet = getImplSigitextManager().getImpiantoByPDRJWT(pdr, tokenJWT);
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("SigitextBean", "getImpiantoByPDRJWT()", "invocazione servizio [sigitext]::[getImpiantoByPDRJWT]", "(valore input omesso)");
			logger.debug("[SigitextBean::getImpiantoByPDRJWT()] - END");

			return valueObjRet;

		} catch (CSIException e) {

			throw e;
		} catch (Exception e) {

			throw new UnrecoverableException("Errore non recuperabile durante l'esecuzione del metodo:" + e, e);
		}
	}

	@Override
	public it.csi.sigit.sigitext.dto.sigitext.Documento getLibrettoByUIDJWT( 

			@WebParam(name = "in0") java.lang.String uid, 

			@WebParam(name = "in1") java.lang.String tokenJWT 

	) 
			throws 
			it.csi.csi.wrapper.CSIException, 
			it.csi.csi.wrapper.UnrecoverableException 

			, it.csi.sigit.sigitext.exception.sigitext.SigitextException

			, it.csi.sigit.sigitext.exception.sigitext.SigitUserNotAuthorizedException { 
		try {

			logger.debug("[SigitextBean::getLibrettoByUIDJWT()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("sigitext");
			// inizio misurazione
			watcher.start();

			it.csi.sigit.sigitext.dto.sigitext.Documento valueObjRet = getImplSigitextManager().getLibrettoByUIDJWT(uid, tokenJWT);
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("SigitextBean", "getLibrettoByUIDJWT()", "invocazione servizio [sigitext]::[getLibrettoByUIDJWT]", "(valore input omesso)");
			logger.debug("[SigitextBean::getLibrettoByUIDJWT()] - END");
			return valueObjRet;
		} catch (CSIException e) {
			throw e;
		} catch (Exception e) {
			throw new UnrecoverableException("Errore non recuperabile durante l'esecuzione del metodo:" + e, e);
		}
	}

	@SuppressWarnings("finally")
	@Override
	public boolean isAliveExt() {
		// TODO Auto-generated method stub
		logger.debug("[SiceewsMgr::isAliveExt] BEGIN");

		boolean isAlive = false;
		try {

			isAlive = true;
		} catch (Exception e) {
			logger.error("[SiceewsMgr::isAliveExt] Errore ", e);
			//e.printStackTrace();

			throw e;
		} finally {
			logger.debug("[SiceewsMgr::isAliveExt] END");
			return isAlive;

		}

	}

	@Override
	public it.csi.sigit.sigitext.dto.sigitext.Documento getXMLLibrettoNowJWT( 

			@WebParam(name = "in0") java.lang.Integer codiceImpianto, 

			@WebParam(name = "in1") java.lang.Boolean isConsolidato, 

			@WebParam(name = "in2") java.lang.String tokenJWT 

	) 
			throws 
			it.csi.csi.wrapper.CSIException, 
			it.csi.csi.wrapper.UnrecoverableException 

			, it.csi.sigit.sigitext.exception.sigitext.SigitextException

			, it.csi.sigit.sigitext.exception.sigitext.SigitUserNotAuthorizedException { 
		try {

			logger.debug("[SigitextBean::getXMLLibrettoNowJWT()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("sigitext");
			// inizio misurazione
			watcher.start();

			it.csi.sigit.sigitext.dto.sigitext.Documento valueObjRet = getImplSigitextManager().getXMLLibrettoNowJWT(

					codiceImpianto,

					isConsolidato,

					tokenJWT

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("SigitextBean", "getXMLLibrettoNowJWT()", "invocazione servizio [sigitext]::[getXMLLibrettoNowJWT]", "(valore input omesso)");
			logger.debug("[SigitextBean::getXMLLibrettoNowJWT()] - END");

			return valueObjRet;

		} catch (Exception e) {

			throw new UnrecoverableException("Errore non recuperabile durante l'esecuzione del metodo:" + e, e);
		}
	}

	@Override
	public it.csi.sigit.sigitext.dto.sigitext.CodiceDescrizione[] getCombustibileCIT( 

	) 
			throws 
			it.csi.csi.wrapper.CSIException, 
			it.csi.csi.wrapper.UnrecoverableException 

			, it.csi.sigit.sigitext.exception.sigitext.SigitextException { 
		try {

			logger.debug("[SigitextBean::getCombustibileCIT()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("sigitext");
			// inizio misurazione
			watcher.start();

			it.csi.sigit.sigitext.dto.sigitext.CodiceDescrizione[] valueObjRet = getImplSigitextManager().getCombustibileCIT(

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("SigitextBean", "getCombustibileCIT()", "invocazione servizio [sigitext]::[getCombustibileCIT]", "(valore input omesso)");
			logger.debug("[SigitextBean::getCombustibileCIT()] - END");

			return valueObjRet;

		} catch (CSIException e) {

			throw e;
		} catch (Exception e) {

			throw new UnrecoverableException("Errore non recuperabile durante l'esecuzione del metodo:" + e, e);
		}
	}

	@Override
	public it.csi.sigit.sigitext.dto.sigitext.CodiceDescrizione[] getMarcaCIT( 

	) 
			throws 
			it.csi.csi.wrapper.CSIException, 
			it.csi.csi.wrapper.UnrecoverableException 

			, it.csi.sigit.sigitext.exception.sigitext.SigitextException { 
		try {

			logger.debug("[SigitextBean::getMarcaCIT()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("sigitext");
			// inizio misurazione
			watcher.start();

			it.csi.sigit.sigitext.dto.sigitext.CodiceDescrizione[] valueObjRet = getImplSigitextManager().getMarcaCIT(

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("SigitextBean", "getMarcaCIT()", "invocazione servizio [sigitext]::[getMarcaCIT]", "(valore input omesso)");
			logger.debug("[SigitextBean::getMarcaCIT()] - END");

			return valueObjRet;

		} catch (CSIException e) {

			throw e;
		} catch (Exception e) {

			throw new UnrecoverableException("Errore non recuperabile durante l'esecuzione del metodo:" + e, e);
		}
	}

	@Override
	public it.csi.sigit.sigitext.dto.sigitext.CodiceDescrizione[] getUnitaMisuraCIT( 

	) 
			throws 
			it.csi.csi.wrapper.CSIException, 
			it.csi.csi.wrapper.UnrecoverableException 

			, it.csi.sigit.sigitext.exception.sigitext.SigitextException { 
		try {

			logger.debug("[SigitextBean::getUnitaMisuraCIT()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("sigitext");
			// inizio misurazione
			watcher.start();

			it.csi.sigit.sigitext.dto.sigitext.CodiceDescrizione[] valueObjRet = getImplSigitextManager().getUnitaMisuraCIT(

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("SigitextBean", "getUnitaMisuraCIT()", "invocazione servizio [sigitext]::[getUnitaMisuraCIT]", "(valore input omesso)");
			logger.debug("[SigitextBean::getUnitaMisuraCIT()] - END");

			return valueObjRet;

		} catch (CSIException e) {

			throw e;
		} catch (Exception e) {

			throw new UnrecoverableException("Errore non recuperabile durante l'esecuzione del metodo:" + e, e);
		}
	}

	@Override
	public it.csi.sigit.sigitext.dto.sigitext.Libretto getLibrettoNowJWT( 

			@WebParam(name = "in0") java.lang.Integer codiceImpianto, 

			@WebParam(name = "in1") java.lang.Boolean isConsolidato, 

			@WebParam(name = "in2") java.lang.String tokenJWT 

	) 
			throws 
			it.csi.csi.wrapper.CSIException, 
			it.csi.csi.wrapper.UnrecoverableException 

			, it.csi.sigit.sigitext.exception.sigitext.SigitextException

			, it.csi.sigit.sigitext.exception.sigitext.SigitUserNotAuthorizedException { 
		try {

			logger.debug("[SigitextBean::getLibrettoNowJWT()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("sigitext");
			// inizio misurazione
			watcher.start();

			it.csi.sigit.sigitext.dto.sigitext.Libretto valueObjRet = getImplSigitextManager().getLibrettoNowJWT(

					codiceImpianto,

					isConsolidato,

					tokenJWT

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("SigitextBean", "getLibrettoNowJWT()", "invocazione servizio [sigitext]::[getLibrettoNowJWT]", "(valore input omesso)");
			logger.debug("[SigitextBean::getLibrettoNowJWT()] - END");

			return valueObjRet;

		} catch (CSIException e) {

			throw e;
		} catch (Exception e) {

			throw new UnrecoverableException("Errore non recuperabile durante l'esecuzione del metodo:" + e, e);
		}
	}
	
	@Override
	public Scheda1 getSchedaLibrettoJWT( 

			@WebParam(name = "in0") java.lang.Integer codiceImpianto, 

			@WebParam(name = "in2") java.lang.String tokenJWT 

	) 
			throws 
			it.csi.csi.wrapper.CSIException, 
			it.csi.csi.wrapper.UnrecoverableException 

			, it.csi.sigit.sigitext.exception.sigitext.SigitextException

			, it.csi.sigit.sigitext.exception.sigitext.SigitUserNotAuthorizedException { 
		try {

			logger.debug("[SigitextBean::getSchedaLibrettoJWT()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("sigitext");
			// inizio misurazione
			watcher.start();

			Scheda1 valueObjRet = getImplSigitextManager().getSchedaLibrettoJWT(

					codiceImpianto,

					tokenJWT

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("SigitextBean", "getSchedaLibrettoJWT()", "invocazione servizio [sigitext]::[getSchedaLibrettoJWT]", "(valore input omesso)");
			logger.debug("[SigitextBean::getSchedaLibrettoJWT()] - END");

			return valueObjRet;

		} catch (CSIException e) {

			throw e;
		} catch (Exception e) {

			throw new UnrecoverableException("Errore non recuperabile durante l'esecuzione del metodo:" + e, e);
		}
	}

	@Override
	public it.csi.sigit.sigitext.dto.sigitext.Documento getXMLLibrettoConsolidatoJWT( 
			@WebParam(name = "in0") java.lang.Integer codiceImpianto, 
			@WebParam(name = "in1") java.lang.String tokenJWT 
	) 
			throws 
			it.csi.csi.wrapper.CSIException, 
			it.csi.csi.wrapper.UnrecoverableException 
			, it.csi.sigit.sigitext.exception.sigitext.SigitextException, it.csi.sigit.sigitext.exception.sigitext.SigitUserNotAuthorizedException { 
		try {
			logger.debug("[SigitextBean::getXMLLibrettoConsolidatoJWT()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("sigitext");
			// inizio misurazione
			watcher.start();
			it.csi.sigit.sigitext.dto.sigitext.Documento valueObjRet = getImplSigitextManager().getXMLLibrettoConsolidatoJWT(codiceImpianto, tokenJWT);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("SigitextBean", "getXMLLibrettoConsolidatoJWT()", "invocazione servizio [sigitext]::[getXMLLibrettoConsolidatoJWT]", "(valore input omesso)");
			logger.debug("[SigitextBean::getXMLLibrettoConsolidatoJWT()] - END");

			return valueObjRet;

		} catch (CSIException e) {

			throw e;
		} catch (Exception e) {

			throw new UnrecoverableException("Errore non recuperabile durante l'esecuzione del metodo:" + e, e);
		}
	}

	@Override
	public void uploadXMLLibrettoJWT( 

			@WebParam(name = "in0") java.lang.Integer codiceImpianto, 

			@WebParam(name = "in1") byte[] xml, 

			@WebParam(name = "in2") java.lang.String tokenJWT 

	) 
			throws 
			it.csi.csi.wrapper.CSIException, 
			it.csi.csi.wrapper.UnrecoverableException 

			, it.csi.sigit.sigitext.exception.sigitext.SigitextException

			, it.csi.sigit.sigitext.exception.sigitext.SigitUserNotAuthorizedException { 
		try {

			logger.debug("[SigitextBean::uploadXMLLibrettoJWT()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("sigitext");
			// inizio misurazione
			watcher.start();

			getImplSigitextManager().uploadXMLLibrettoJWT(

					codiceImpianto,

					xml,

					tokenJWT

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("SigitextBean", "uploadXMLLibrettoJWT()", "invocazione servizio [sigitext]::[uploadXMLLibrettoJWT]", "(valore input omesso)");
			logger.debug("[SigitextBean::uploadXMLLibrettoJWT()] - END");

		} catch (CSIException e) {

			throw e;
		} catch (Exception e) {

			throw new UnrecoverableException("Errore non recuperabile durante l'esecuzione del metodo:" + e, e);
		}
	}

	@Override
	public int uploadXMLControlloJWT( 

			@WebParam(name = "in0")java.lang.Integer codiceImpianto, 

			@WebParam(name = "in1")java.lang.String tipoControllo, 

			@WebParam(name = "in2")byte[] xml, 

			@WebParam(name = "in3")java.lang.String tokenJWT 

	) 
			throws 
			it.csi.csi.wrapper.CSIException, 
			it.csi.csi.wrapper.UnrecoverableException 


			, it.csi.sigit.sigitext.exception.sigitext.SigitUserNotAuthorizedException { 
		try {

			logger.debug("[SigitextBean::uploadXMLControlloJWT()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("sigitext");
			// inizio misurazione
			watcher.start();

			int valueObjRet = getImplSigitextManager().uploadXMLControlloJWT(

					codiceImpianto,

					tipoControllo,
					
					xml,

					tokenJWT

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("SigitextBean", "uploadXMLControlloJWT()", "invocazione servizio [sigitext]::[uploadXMLControlloJWT]", "(valore input omesso)");
			logger.debug("[SigitextBean::uploadXMLControlloJWT()] - END");

			return valueObjRet;

		} catch (CSIException e) {

			throw e;
		} catch (Exception e) {

			throw new UnrecoverableException("Errore non recuperabile durante l'esecuzione del metodo:" + e, e);
		}
	}

	@Override
	public it.csi.sigit.sigitext.dto.sigitext.Impianto[] getImpiantoByIndirizzoJWT( 

			@WebParam(name = "in0")java.lang.String indirizzo, 

			@WebParam(name = "in1")java.lang.Integer civico, 

			@WebParam(name = "in2")java.lang.String istat, 

			@WebParam(name = "in3")java.lang.String tokenJWT 

	) 
			throws 
			it.csi.csi.wrapper.CSIException, 
			it.csi.csi.wrapper.UnrecoverableException 
			, it.csi.sigit.sigitext.exception.sigitext.SigitextException, it.csi.sigit.sigitext.exception.sigitext.SigitUserNotAuthorizedException { 
		try {

			logger.debug("[SigitextBean::getImpiantoByIndirizzoJWT()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("sigitext");
			// inizio misurazione
			watcher.start();
			it.csi.sigit.sigitext.dto.sigitext.Impianto[] valueObjRet = getImplSigitextManager().getImpiantoByIndirizzoJWT(indirizzo, civico, istat, tokenJWT);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("SigitextBean", "getImpiantoByIndirizzoJWT()", "invocazione servizio [sigitext]::[getImpiantoByIndirizzoJWT]", "(valore input omesso)");
			logger.debug("[SigitextBean::getImpiantoByIndirizzoJWT()] - END");

			return valueObjRet;

		} catch (CSIException e) {

			throw e;
		} catch (Exception e) {

			throw new UnrecoverableException("Errore non recuperabile durante l'esecuzione del metodo:" + e, e);
		}
	}

	@Override
	public it.csi.sigit.sigitext.dto.sigitext.Ruoli getRuoli( 

			@WebParam(name = "in0")java.lang.String codiceFiscale, 

			@WebParam(name = "in1")java.lang.String cognome, 

			@WebParam(name = "in2")java.lang.String nome 

	) 
			throws 
			it.csi.csi.wrapper.CSIException, 
			it.csi.csi.wrapper.UnrecoverableException 

			, it.csi.sigit.sigitext.exception.sigitext.SigitExcessiveResultsException

			, it.csi.sigit.sigitext.exception.sigitext.SigitextException

	{ 
		try {

			logger.debug("[SigitextBean::getRuoli()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("sigitext");
			// inizio misurazione
			watcher.start();

			it.csi.sigit.sigitext.dto.sigitext.Ruoli valueObjRet = getImplSigitextManager().getRuoli(
					codiceFiscale,
					cognome,
					nome
			);
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("SigitextBean", "getRuoli()", "invocazione servizio [sigitext]::[getRuoli]",
					"(valore input omesso)");
			logger.debug("[SigitextBean::getRuoli()] - END");

			return valueObjRet;

		} catch (CSIException e) {

			throw e;
		} catch (Exception e) {

			throw new UnrecoverableException("Errore non recuperabile durante l'esecuzione del metodo:" + e, e);
		}
	}
	
	
	@Override
	public String[] getComuniPGJWT(String tokenJWT) throws Exception {
		return getImplSigitextManager().getComuniPGJWT(tokenJWT);
	}
	
	@Override
	public DettaglioPersonaGiuridica[] getManutentoriJWT(String denominazione, String comune, String tokenJWT) throws SigitextException, SigitExcessiveResultsException {
		return getImplSigitextManager().getManutentoriJWT(denominazione, comune, tokenJWT);
	}
}
