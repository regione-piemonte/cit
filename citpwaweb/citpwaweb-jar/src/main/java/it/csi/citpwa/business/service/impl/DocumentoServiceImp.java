package it.csi.citpwa.business.service.impl;

import it.csi.citpwa.business.service.ICitService;
import it.csi.citpwa.business.service.IDocumentoService;
import it.csi.citpwa.exception.SvistaException;
import it.csi.citpwa.model.sigitext.Documento;
import it.csi.citpwa.model.sigitext.DocumentoPwa;
import it.csi.citpwa.model.sigitext.ResponseGetElencoDocumenti;
import it.csi.citpwa.util.Constants;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.ws.rs.NotFoundException;
import java.io.IOException;

@Service
public class DocumentoServiceImp implements IDocumentoService {
    
    @Autowired
    private ICitService citService;
    
    
    private static final Logger log = Logger.getLogger(Constants.COMPONENT_NAME);

    @Override
	public String setDocumento(DocumentoPwa documento, Integer idContratto, String cfUtenteLoggato, Integer codiceImpianto, Integer idAzione, String tipoDoc, Integer fkIspezIspett, String dataControllo) throws SvistaException, IOException {
        try {
            
            return citService.setDocumento(documento, idContratto, cfUtenteLoggato, codiceImpianto, idAzione, tipoDoc, fkIspezIspett, dataControllo);
        } catch (NotFoundException e) {
            log.error(Constants.DOCUMENTO_LOG + "setDocumento - error: ", e);
            throw new NotFoundException();
        } catch (Exception e) {
            log.error(Constants.DOCUMENTO_LOG + "setDocumento - error: ", e);
            throw e;
        }
    }

    @Override

	public ResponseGetElencoDocumenti getElencoDocumenti(Integer codiceImpianto, Integer idVerifica, Integer idAccertamento, Integer idIspezione2018) throws SvistaException, IOException{
        try {
            return citService.getElencoDocumenti(codiceImpianto, idVerifica, idAccertamento, idIspezione2018);
        } catch (NotFoundException e) {
            log.error(Constants.DOCUMENTO_LOG + "getElencoDocumenti - error: ", e);
            throw new NotFoundException();
        } catch (Exception e) {
            log.error(Constants.DOCUMENTO_LOG + "getElencoDocumenti - error: ", e);
            throw e;
        }
    }

    @Override
	public Documento getDocumentoByUid(String uidIndex) throws SvistaException, IOException{
        try {
            return citService.getDocumentoByUid(uidIndex);
        } catch (NotFoundException e) {
            log.error(Constants.DOCUMENTO_LOG + "getDocumentoByUid - error: ", e);
            throw new NotFoundException();
        } catch (Exception e) {
            log.error(Constants.DOCUMENTO_LOG + "getDocumentoByUid - error: ", e);
            throw e;
        }
    }

    @Override
	public String deleteDocumento(String uidIndex) throws SvistaException, IOException{
        try {
            return citService.deleteDocumento(uidIndex);
        } catch (NotFoundException e) {
            log.error(Constants.DOCUMENTO_LOG + "deleteDocumento - error: ", e);
            throw new NotFoundException();
        } catch (Exception e) {
            log.error(Constants.DOCUMENTO_LOG + "deleteDocumento - error: ", e);
            throw e;
        }
    }

    @Override
    public Object getTipoDocumento() throws SvistaException, IOException {
        try {
            return citService.getTipoDocumento();
        } catch (NotFoundException e) {
            log.error(Constants.DOCUMENTO_LOG + "getTipoDocumento - error: ", e);
            throw new NotFoundException();
        } catch (Exception e) {
            log.error(Constants.DOCUMENTO_LOG + "getTipoDocumento - error: ", e);
            throw e;
        }
    }
}
