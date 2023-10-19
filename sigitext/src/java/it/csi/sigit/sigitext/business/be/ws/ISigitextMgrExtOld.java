/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sigit.sigitext.business.be.ws;

import it.csi.csi.wrapper.CSIException;
import it.csi.csi.wrapper.UnrecoverableException;

import javax.jws.WebParam;

public interface ISigitextMgrExtOld {

	public boolean isAliveExt();

	public it.csi.sigit.sigitext.dto.sigitext.Impianto[] getImpiantiByFiltroJWT(@WebParam(name = "in0") it.csi.sigit.sigitext.dto.sigitext.ImpiantoFiltro impiantoFiltro, @WebParam(name = "in1") java.lang.String tokenJWT)
			throws it.csi.csi.wrapper.CSIException, it.csi.csi.wrapper.SystemException, it.csi.csi.wrapper.UnrecoverableException, it.csi.sigit.sigitext.exception.sigitext.SigitextException, it.csi.sigit.sigitext.exception.sigitext.SigitUserNotAuthorizedException;

	public it.csi.sigit.sigitext.dto.sigitext.Impianto[] getImpiantoByCodiceJWT(@WebParam(name = "in0") java.lang.Integer codiceImpianto, @WebParam(name = "in1") java.lang.String tokenJWT)
			throws it.csi.csi.wrapper.CSIException, it.csi.csi.wrapper.SystemException, it.csi.csi.wrapper.UnrecoverableException, it.csi.sigit.sigitext.exception.sigitext.SigitextException, it.csi.sigit.sigitext.exception.sigitext.SigitUserNotAuthorizedException;

	public it.csi.sigit.sigitext.dto.sigitext.Impianto[] getImpiantoByPODJWT(@WebParam(name = "in0") java.lang.String pod, @WebParam(name = "in1") java.lang.String tokenJWT)
			throws it.csi.csi.wrapper.CSIException, it.csi.csi.wrapper.SystemException, it.csi.csi.wrapper.UnrecoverableException, it.csi.sigit.sigitext.exception.sigitext.SigitextException, it.csi.sigit.sigitext.exception.sigitext.SigitUserNotAuthorizedException, it.csi.sigit.sigitext.exception.sigitext.SigitExcessiveResultsException;

	public it.csi.sigit.sigitext.dto.sigitext.Impianto[] getImpiantoByPDRJWT(@WebParam(name = "in0") java.lang.String pdr, @WebParam(name = "in1") java.lang.String tokenJWT)
			throws it.csi.csi.wrapper.CSIException, it.csi.csi.wrapper.SystemException, it.csi.csi.wrapper.UnrecoverableException, it.csi.sigit.sigitext.exception.sigitext.SigitextException, it.csi.sigit.sigitext.exception.sigitext.SigitUserNotAuthorizedException, it.csi.sigit.sigitext.exception.sigitext.SigitExcessiveResultsException;

	public it.csi.sigit.sigitext.dto.sigitext.Documento getLibrettoByUIDJWT(@WebParam(name = "in0") java.lang.String uid, @WebParam(name = "in1") java.lang.String tokenJWT)
			throws it.csi.csi.wrapper.CSIException, it.csi.csi.wrapper.SystemException, it.csi.csi.wrapper.UnrecoverableException, it.csi.sigit.sigitext.exception.sigitext.SigitextException, it.csi.sigit.sigitext.exception.sigitext.SigitUserNotAuthorizedException;

	public it.csi.sigit.sigitext.dto.sigitext.Documento getXMLLibrettoNowJWT(@WebParam(name = "in0") java.lang.Integer codiceImpianto, @WebParam(name = "in1") java.lang.Boolean isConsolidato, @WebParam(name = "in2") java.lang.String tokenJWT)
			throws it.csi.csi.wrapper.CSIException, it.csi.csi.wrapper.SystemException, it.csi.csi.wrapper.UnrecoverableException, it.csi.sigit.sigitext.exception.sigitext.SigitextException, it.csi.sigit.sigitext.exception.sigitext.SigitUserNotAuthorizedException;

	public it.csi.sigit.sigitext.dto.sigitext.CodiceDescrizione[] getCombustibileCIT()
			throws it.csi.csi.wrapper.CSIException, it.csi.csi.wrapper.SystemException, it.csi.csi.wrapper.UnrecoverableException, it.csi.sigit.sigitext.exception.sigitext.SigitextException;

	public it.csi.sigit.sigitext.dto.sigitext.CodiceDescrizione[] getMarcaCIT()
			throws it.csi.csi.wrapper.CSIException, it.csi.csi.wrapper.SystemException, it.csi.csi.wrapper.UnrecoverableException, it.csi.sigit.sigitext.exception.sigitext.SigitextException;

	public it.csi.sigit.sigitext.dto.sigitext.CodiceDescrizione[] getUnitaMisuraCIT()
			throws it.csi.csi.wrapper.CSIException, it.csi.csi.wrapper.SystemException, it.csi.csi.wrapper.UnrecoverableException, it.csi.sigit.sigitext.exception.sigitext.SigitextException;

	public it.csi.sigit.sigitext.dto.sigitext.Libretto getLibrettoNowJWT(@WebParam(name = "in0") java.lang.Integer codiceImpianto, @WebParam(name = "in1") java.lang.Boolean isConsolidato, @WebParam(name = "in2") java.lang.String tokenJWT)
			throws it.csi.csi.wrapper.CSIException, it.csi.csi.wrapper.SystemException, it.csi.csi.wrapper.UnrecoverableException, it.csi.sigit.sigitext.exception.sigitext.SigitextException, it.csi.sigit.sigitext.exception.sigitext.SigitUserNotAuthorizedException;

	public it.csi.sigit.sigitext.dto.sigitext.Documento getXMLLibrettoConsolidatoJWT(@WebParam(name = "in0") java.lang.Integer codiceImpianto, @WebParam(name = "in1") java.lang.String tokenJWT)
			throws it.csi.csi.wrapper.CSIException, it.csi.csi.wrapper.SystemException, it.csi.csi.wrapper.UnrecoverableException, it.csi.sigit.sigitext.exception.sigitext.SigitextException, it.csi.sigit.sigitext.exception.sigitext.SigitUserNotAuthorizedException;

	public void uploadXMLLibrettoJWT(@WebParam(name = "in0") java.lang.Integer codiceImpianto, @WebParam(name = "in1") byte[] xml, @WebParam(name = "in2") java.lang.String tokenJWT)
			throws it.csi.csi.wrapper.CSIException, it.csi.csi.wrapper.SystemException, it.csi.csi.wrapper.UnrecoverableException, it.csi.sigit.sigitext.exception.sigitext.SigitextException, it.csi.sigit.sigitext.exception.sigitext.SigitUserNotAuthorizedException;

	public int uploadXMLControlloJWT(@WebParam(name = "in0") java.lang.Integer codiceImpianto, @WebParam(name = "in1") java.lang.String tipoControllo, @WebParam(name = "in2") byte[] xml, @WebParam(name = "in3") java.lang.String tokenJWT)
			throws it.csi.csi.wrapper.CSIException, it.csi.csi.wrapper.SystemException, it.csi.csi.wrapper.UnrecoverableException, it.csi.sigit.sigitext.exception.sigitext.SigitextException, it.csi.sigit.sigitext.exception.sigitext.SigitUserNotAuthorizedException;

	public it.csi.sigit.sigitext.dto.sigitext.Impianto[] getImpiantoByIndirizzoJWT(@WebParam(name = "in0") java.lang.String indirizzo, @WebParam(name = "in1") java.lang.Integer civico, @WebParam(name = "in2") java.lang.String istat, @WebParam(name = "in3") java.lang.String tokenJWT)
			throws it.csi.csi.wrapper.CSIException, it.csi.csi.wrapper.SystemException, it.csi.csi.wrapper.UnrecoverableException, it.csi.sigit.sigitext.exception.sigitext.SigitextException, it.csi.sigit.sigitext.exception.sigitext.SigitUserNotAuthorizedException;

	public it.csi.sigit.sigitext.dto.sigitext.Ruoli getRuoli(@WebParam(name = "in0") java.lang.String codiceFiscale, @WebParam(name = "in1") java.lang.String cognome, @WebParam(name = "in2") java.lang.String nome)
			throws it.csi.csi.wrapper.CSIException, it.csi.csi.wrapper.SystemException, it.csi.csi.wrapper.UnrecoverableException, it.csi.sigit.sigitext.exception.sigitext.SigitExcessiveResultsException, it.csi.sigit.sigitext.exception.sigitext.SigitextException;
}