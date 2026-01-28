/*
 *
 *  * ******************************************************************************
 *  *  SPDX-License-Identifier: EUPL-1.2
 *  *  Copyright Regione Piemonte - 2021
 *  * *****************************************************************************
 *
 */

package it.csi.citpwa.business.service.impl;

import it.csi.citpwa.business.service.ICitService;
import it.csi.citpwa.business.service.IComponentService;
import it.csi.citpwa.exception.SigitExtException;
import it.csi.citpwa.exception.SvistaException;
import it.csi.citpwa.exception.ValidationErrorException;
import it.csi.citpwa.model.DatiCGModel;
import it.csi.citpwa.model.DatiGFModel;
import it.csi.citpwa.model.DatiGTModel;
import it.csi.citpwa.model.DatiSCModel;
import it.csi.citpwa.model.sigitext.*;
import it.csi.citpwa.util.Constants;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.NotFoundException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class ComponentServiceImp implements IComponentService {

	@Autowired
	ICitService citService;

	private static final Logger log = Logger.getLogger(Constants.COMPONENT_NAME);

	@Override
	public List<DatiGTModel> getGT(UtenteLoggato user, String codiceImpianto, Integer progressivo) throws SvistaException {
		log.info(Constants.COMPONENT_LOG + "getGT - start");
		try {
			DatiGT[] datiGTArray = citService.getGT(codiceImpianto, progressivo, null);
			if (datiGTArray != null && datiGTArray.length != 0)
				return DatiGTModel.dtoToModel.convert(Arrays.asList(datiGTArray));
			else
				throw new NotFoundException();
		} catch (NotFoundException e) {
			log.error(Constants.COMPONENT_LOG + "getGT - nessun componente trovato: ", e);
			throw new NotFoundException();
		} catch (Exception e) {
			log.error(Constants.COMPONENT_LOG + "getGT - error: ", e);
			throw new SvistaException("Errore recupero componente GT");
		} finally {
			log.info(Constants.COMPONENT_LOG + "getGT - end");
		}
	}

	@Override
	public List<DatiGFModel> getGF(UtenteLoggato user, String codiceImpianto, Integer progressivo) throws SvistaException {
		log.info(Constants.COMPONENT_LOG + "getGF - start");
		try {
			DatiGF[] datiGTArray = citService.getGF(codiceImpianto, progressivo, null);
			if (datiGTArray != null && datiGTArray.length != 0)
				return DatiGFModel.dtoToModel.convert(Arrays.asList(datiGTArray));
			else
				throw new NotFoundException();
		} catch (NotFoundException e) {
			log.error(Constants.COMPONENT_LOG + "getGF - nessun componente trovato: ", e);
			throw new NotFoundException();
		} catch (Exception e) {
			log.error(Constants.COMPONENT_LOG + "getGF - error: ", e);
			throw new SvistaException("Errore recupero componente GF");
		} finally {
			log.info(Constants.COMPONENT_LOG + "getGT - end");
		}
	}

	@Override
	public List<DatiSCModel> getSC(UtenteLoggato user, String codiceImpianto, Integer progressivo) throws SvistaException {
		log.info(Constants.COMPONENT_LOG + "getSC - start");
		try {
			DatiSC[] datiGTArray = citService.getSC(codiceImpianto, progressivo, null);
			if (datiGTArray != null && datiGTArray.length != 0)
				return DatiSCModel.dtoToModel.convert(Arrays.asList(datiGTArray));
			else
				throw new NotFoundException();
		} catch (NotFoundException e) {
			log.error(Constants.COMPONENT_LOG + "getSC - nessun componente trovato: ", e);
			throw new NotFoundException();
		} catch (Exception e) {
			log.error(Constants.COMPONENT_LOG + "getSC - error: ", e);
			throw new SvistaException("Errore recupero componente SC");
		} finally {
			log.info(Constants.COMPONENT_LOG + "getSC - end");
		}
	}

	@Override
	public List<DatiCGModel> getCG(UtenteLoggato user, String codiceImpianto, Integer progressivo) throws SvistaException {
		log.info(Constants.COMPONENT_LOG + "getCG - start");
		try {
			DatiCG[] datiGTArray = citService.getCG(codiceImpianto, progressivo, null);
			if (datiGTArray != null && datiGTArray.length != 0)
				return DatiCGModel.dtoToModel.convert(Arrays.asList(datiGTArray));
			else
				throw new NotFoundException();
		} catch (NotFoundException e) {
			log.error(Constants.COMPONENT_LOG + "getCG - nessun componente trovato: ", e);
			throw new NotFoundException();
		} catch (Exception e) {
			log.error(Constants.COMPONENT_LOG + "getCG - error: ", e);
			throw new SvistaException("Errore recupero componente CG");
		} finally {
			log.info(Constants.COMPONENT_LOG + "getCG - end");
		}
	}

	@Override
	public CodiceDescrizione[] getMarcaCIT() throws SvistaException {
		log.info(Constants.COMPONENT_LOG + "getMarcaCIT - start");
		try {
			return citService.getMarcaCIT();
		} catch (Exception e) {
			log.error(Constants.COMPONENT_LOG + "getMarcaCIT - error: ", e);
			throw new SvistaException(Constants.COMPONENT_SERVICE_ERRORE_RECUPERO_DATI);
		} finally {
			log.info(Constants.COMPONENT_LOG + "getMarcaCIT - end");
		}
	}

	@Override
	public CodiceDescrizione[] getCombustibileCIT() throws SvistaException {
		log.info(Constants.COMPONENT_LOG + "getCombustibileCIT - start");
		try {
			return citService.getCombustibileCIT();
		} catch (Exception e) {
			log.error(Constants.COMPONENT_LOG + "getCombustibileCIT - error: ", e);
			throw new SvistaException(Constants.COMPONENT_SERVICE_ERRORE_RECUPERO_DATI);
		} finally {
			log.info(Constants.COMPONENT_LOG + "getCombustibileCIT - end");
		}
	}

	@Override
	public CodiceDescrizione[] getClassDpr66096CIT() throws SvistaException {
		log.info(Constants.COMPONENT_LOG + "getClassDpr66096CIT - start");
		try {
			return citService.getClassDpr66096CIT();
		} catch (Exception e) {
			log.error(Constants.COMPONENT_LOG + "getClassDpr66096CIT - error: ", e);
			throw new SvistaException(Constants.COMPONENT_SERVICE_ERRORE_RECUPERO_DATI);
		} finally {
			log.info(Constants.COMPONENT_LOG + "getClassDpr66096CIT - end");
		}
	}

	@Override
	public CodiceDescrizione[] getFrequenzaManutCIT() throws SvistaException {
		log.info(Constants.COMPONENT_LOG + "getFrequenzaManutCIT - start");
		try {
			return citService.getFrequenzaManutCIT();
		} catch (Exception e) {
			log.error(Constants.COMPONENT_LOG + "getFrequenzaManutCIT - error: ", e);
			throw new SvistaException(Constants.COMPONENT_SERVICE_ERRORE_RECUPERO_DATI);
		} finally {
			log.info(Constants.COMPONENT_LOG + "getFrequenzaManutCIT - end");
		}
	}

	@Override
	public CodiceDescrizione[] getFluidoCIT() throws SvistaException {
		log.info(Constants.COMPONENT_LOG + "getFluidoCIT - start");
		try {
			return citService.getFluidoCIT();
		} catch (Exception e) {
			log.error(Constants.COMPONENT_LOG + "getFluidoCIT - error: ", e);
			throw new SvistaException(Constants.COMPONENT_SERVICE_ERRORE_RECUPERO_DATI);
		} finally {
			log.info(Constants.COMPONENT_LOG + "getFluidoCIT - end");
		}
	}

	@Override
	public CodiceDescrizione[] getTipologiaGT() throws SvistaException {
		log.info(Constants.COMPONENT_LOG + "getTipologiaGT - start");
		try {
			return citService.getTipologiaGT();
		} catch (Exception e) {
			log.error(Constants.COMPONENT_LOG + "getTipologiaGT - error: ", e);
			throw new SvistaException(Constants.COMPONENT_SERVICE_ERRORE_RECUPERO_DATI);
		} finally {
			log.info(Constants.COMPONENT_LOG + "getTipologiaGT - end");
		}
	}

	@Override
	public CodiceDescrizione[] getTipologiaGF() throws SvistaException {
		log.info(Constants.COMPONENT_LOG + "getTipologiaGF - start");
		try {
			return citService.getTipologiaGF();
		} catch (Exception e) {
			log.error(Constants.COMPONENT_LOG + "getTipologiaGF - error: ", e);
			throw new SvistaException(Constants.COMPONENT_SERVICE_ERRORE_RECUPERO_DATI);
		} finally {
			log.info(Constants.COMPONENT_LOG + "getTipologiaGF - end");
		}
	}
	@Override
	public CodiceDescrizione[] getFonteCIT() throws SvistaException {
		log.info(Constants.COMPONENT_LOG + "getFonteCIT - start");
		try {
			return citService.getFonteCIT();
		} catch (Exception e) {
			log.error(Constants.COMPONENT_LOG + "getFonteCIT - error: ", e);
			throw new SvistaException(Constants.COMPONENT_SERVICE_ERRORE_RECUPERO_DATI);
		} finally {
			log.info(Constants.COMPONENT_LOG + "getFonteCIT - end");
		}
	}

	@Override
	public CodiceDescrizione[] getTipoCannaFumaria() throws SvistaException {
		log.info(Constants.COMPONENT_LOG + "getTipologiaCannaFumaria - start");
		try {
			return citService.getTipoCannaFumaria();
		} catch (Exception e) {
			log.error(Constants.COMPONENT_LOG + "getTipologiaCannaFumaria - error: ", e);
			throw new SvistaException(Constants.COMPONENT_SERVICE_ERRORE_RECUPERO_DATI);
		} finally {
			log.info(Constants.COMPONENT_LOG + "getTipologiaCannaFumaria - end");
		}
	}

	@Override
	public Esito updateGT(String codiceImpianto, List<DatiGT> datiGT, UtenteLoggato user, Integer idImpresaSelez) throws SvistaException {
		log.info(Constants.COMPONENT_LOG + "updateGT - start");
		try {
			UpdateGtModel updateGtModel = new UpdateGtModel();
			updateGtModel.setCodiceImpianto(codiceImpianto);
			updateGtModel.setDatiGTList(datiGT);
			updateGtModel.setUtenteLoggato(user);
			return citService.updateGT(updateGtModel, idImpresaSelez);
		} catch (NotFoundException e) {
			log.error(Constants.COMPONENT_LOG + "updateGT - nessuna persona giuridica associata al componente: ", e);
			throw new NotFoundException();
		} catch (Exception e) {
			log.error(Constants.COMPONENT_LOG + "updateGT - error: ", e);
			throw new SvistaException("Errore aggiornamento componente GT");
		} finally {
			log.info(Constants.COMPONENT_LOG + "updatetGT - end");
		}
	}

	@Override
	public Esito updateGF(String codiceImpianto, List<DatiGF> datiGF, UtenteLoggato user, Integer idImpresaSelez) throws SvistaException {
		log.info(Constants.COMPONENT_LOG + "updateGF - start");
		try {
			UpdateGfModel updateGfModel = new UpdateGfModel();
			updateGfModel.setCodiceImpianto(codiceImpianto);
			updateGfModel.setDatiGFList(datiGF);
			updateGfModel.setUtenteLoggato(user);
			return citService.updateGF(updateGfModel, idImpresaSelez);
		} catch (NotFoundException e) {
			log.error(Constants.COMPONENT_LOG + "updateGF - nessuna persona giuridica associata al componente: ", e);
			throw new NotFoundException();
		} catch (Exception e) {
			log.error(Constants.COMPONENT_LOG + "updateGF - error: ", e);
			throw new SvistaException("Errore aggiornamento componente GF");
		} finally {
			log.info(Constants.COMPONENT_LOG + "updatetGF - end");
		}
	}

	@Override
	public Esito updateSC(String codiceImpianto, List<DatiSC> datiSC, UtenteLoggato user, Integer idImpresaSelez) throws SvistaException {
		log.info(Constants.COMPONENT_LOG + "updateSC - start");
		try {
			UpdateScModel updateScModel = new UpdateScModel();
			updateScModel.setCodiceImpianto(codiceImpianto);
			updateScModel.setDatiSCList(datiSC);
			updateScModel.setUtenteLoggato(user);
			return citService.updateSC(updateScModel, idImpresaSelez);
		} catch (NotFoundException e) {
			log.error(Constants.COMPONENT_LOG + "updateSC - nessuna persona giuridica associata al componente: ", e);
			throw new NotFoundException();
		} catch (Exception e) {
			log.error(Constants.COMPONENT_LOG + "updateSC - error: ", e);
			throw new SvistaException("Errore aggiornamento componente SC");
		} finally {
			log.info(Constants.COMPONENT_LOG + "updatetSC - end");
		}
	}

	@Override
	public Esito updateCG(String codiceImpianto, List<DatiCG> datiCG, UtenteLoggato user, Integer idImpresaSelez) throws SvistaException {
		log.info(Constants.COMPONENT_LOG + "updateCG - start");
		try {
			UpdateCgModel updateCgModel = new UpdateCgModel();
			updateCgModel.setCodiceImpianto(codiceImpianto);
			updateCgModel.setDatiCGList(datiCG);
			updateCgModel.setUtenteLoggato(user);
			return citService.updateCG(updateCgModel, idImpresaSelez);
		} catch (NotFoundException e) {
			log.error(Constants.COMPONENT_LOG + "updateCG - nessuna persona giuridica associata al componente: ", e);
			throw new NotFoundException();
		} catch (Exception e) {
			log.error(Constants.COMPONENT_LOG + "updateCG - error: ", e);
			throw new SvistaException("Errore aggiornamento componente CG");
		} finally {
			log.info(Constants.COMPONENT_LOG + "updatetCG - end");
		}
	}

	@Override
	public Esito chekDismettiSostituisci(String dataMinima, String dataMassima, String dataDismiss) throws SvistaException {
		log.info(Constants.COMPONENT_LOG + "checkDismettiSostituisci - start");
		try {
			Date dataMassimaDate = null;
			Date dataDismissDate = null;
			SimpleDateFormat dateFormat = new SimpleDateFormat(Constants.FORMAT);
			if (dataMassima != null)
				dataMassimaDate = dateFormat.parse(dataMassima);
			if (dataDismiss != null)
				dataDismissDate = dateFormat.parse(dataDismiss);
			if ((dataMassimaDate != null) && (dataDismissDate == null || dataDismissDate.before(dataMassimaDate))){
					throw new ValidationErrorException();
			}
			return new Esito(Constants.OK, "");
		} catch (ValidationErrorException e) {
			log.error(Constants.COMPONENT_LOG + "checkDismettiSostituisci - error: ", e);
			throw new ValidationErrorException("Impossibile completare l'operazione: il compomente attivo contiene dei controlli attivi.");
		} catch (Exception e) {
			log.error(Constants.COMPONENT_LOG + "getGT - error: ", e);
			throw new SvistaException("Errore controllo GT");
		} finally {
			log.info(Constants.COMPONENT_LOG + "checkDismettiSostituisci - end");
		}
	}

	@Override
	public Esito delComponente(String codiceImpianto, String tipo, Integer progressivo, UtenteLoggato user) throws SvistaException {
		log.info(Constants.COMPONENT_LOG + "delComponente - start");
		try {
			return citService.delComponente(codiceImpianto, tipo, progressivo,user.getPfLoggato().getCodiceFiscalePF());
		} catch (SigitExtException e) {
			log.error(Constants.COMPONENT_LOG + "delComponente - error: ", e);
			throw e;
		} catch (Exception e) {
			log.error(Constants.COMPONENT_LOG + "delComponente - error: ", e);
			throw new SvistaException("Errore cancellazione componente");
		} finally {
			log.info(Constants.COMPONENT_LOG + "delComponente - end");
		}
	}
}
