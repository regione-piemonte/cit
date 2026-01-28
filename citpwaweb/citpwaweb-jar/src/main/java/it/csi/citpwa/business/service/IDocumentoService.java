package it.csi.citpwa.business.service;

import it.csi.citpwa.exception.SvistaException;
import it.csi.citpwa.model.sigitext.Documento;
import it.csi.citpwa.model.sigitext.DocumentoPwa;
import it.csi.citpwa.model.sigitext.ResponseGetElencoDocumenti;

import java.io.IOException;

public interface IDocumentoService {
	
	String setDocumento(DocumentoPwa documento, Integer idContratto, String cfUtenteLoggato, Integer codiceImpianto, Integer idAzione, String tipoDoc, Integer fkIspezIspett, String dataControllo) throws SvistaException, IOException;
	ResponseGetElencoDocumenti getElencoDocumenti(Integer codiceImpianto, Integer idVerifica, Integer idAccertamento, Integer idIspezione2018) throws SvistaException, IOException;
	Documento getDocumentoByUid(String uidIndex) throws SvistaException, IOException;
	String deleteDocumento(String uidIndex) throws SvistaException, IOException;
	Object getTipoDocumento()  throws SvistaException, IOException ;
}
