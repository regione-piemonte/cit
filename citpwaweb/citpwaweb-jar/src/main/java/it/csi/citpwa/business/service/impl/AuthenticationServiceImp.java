/*
 *
 *  * ******************************************************************************
 *  *  SPDX-License-Identifier: EUPL-1.2
 *  *  Copyright Regione Piemonte - 2021
 *  * *****************************************************************************
 *
 */

package it.csi.citpwa.business.service.impl;

import it.csi.citpwa.business.service.IAuthenticationService;
import it.csi.citpwa.business.service.ICitService;
import it.csi.citpwa.business.service.ValidationService;
import it.csi.citpwa.exception.SvistaException;
import it.csi.citpwa.exception.ValidationErrorException;
import it.csi.citpwa.model.sigitext.*;
import it.csi.citpwa.util.Constants;
import it.csi.sigit.sigitext.ws.service.client.SigitUserNotAuthorizedException;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class AuthenticationServiceImp implements IAuthenticationService {

	private static final Logger log = Logger.getLogger(Constants.COMPONENT_NAME);

	@Autowired
	private ICitService iCitService;
	@Autowired
	private ValidationService validationService;

	@Override
	public UtenteLoggato getCurrentUser(HttpServletRequest req) throws SvistaException, SocketTimeoutException, ValidationErrorException, SigitUserNotAuthorizedException {
		return (UtenteLoggato) req.getSession().getAttribute(Constants.USERINFO_SESSIONATTR);
	}

	@Override
	public void localLogout(HttpServletRequest req) {
		req.getSession().invalidate();
	}

	@Override
	public Ruoli getRuoliUtente(HttpServletRequest req) throws SvistaException, SigitUserNotAuthorizedException, SocketTimeoutException, ValidationErrorException {
		log.info(Constants.AUTHENTICATION_LOG + "getRuoloUtente - start");
		UtenteLoggato user = getCurrentUser(req);
		try {
			if (user.getPfLoggato().getCodiceFiscalePF() != null) {
				Ruoli ruoli = iCitService.getRuoliUtente(user.getPfLoggato().getCodiceFiscalePF(), user.getPfLoggato().getNomePF(), user.getPfLoggato().getCognomePF());

				if (ruoli != null && ruoli.getRuoliPA() != null) {
					List<RuoloPA> ruolipalist = new ArrayList<>(Arrays.asList(ruoli.getRuoliPA()));
					ruolipalist.removeIf(ruolopa -> ruolopa.getRuoloPA().equals(Constants.RUOLO_DISTRIBUTORE) || ruolopa.getRuoloPA().equals(Constants.CAT_RUOLO_DISTRIBUTORE) || ruolopa.getRuoloPA()
							.equals(Constants.RUOLO_CAT));
					ruoli.setRuoliPA(ruolipalist.toArray(new RuoloPA[0]));
				}

				if (ruoli != null && ruoli.getRuoliPG() != null) {
					List<RuoloPG> ruolipglist = new ArrayList<>(Arrays.asList(ruoli.getRuoliPG()));
					ruolipglist.removeIf(ruoloPG -> ruoloPG.getRuoloPG().equals(Constants.RUOLO_DISTRIBUTORE) || ruoloPG.getRuoloPG().equals(Constants.CAT_RUOLO_DISTRIBUTORE) || ruoloPG.getRuoloPG()
							.equals(Constants.RUOLO_CAT));
					ruoli.setRuoliPG(ruolipglist.toArray(new RuoloPG[0]));
				}
				return ruoli;
			} else
				throw new SigitUserNotAuthorizedException();
		} catch (Exception e) {
			log.error(Constants.AUTHENTICATION_LOG + "getRuoliUtente - error: ", e);
			throw new SvistaException("Errore recupero ruoli utente");
		} finally {
			log.info(Constants.AUTHENTICATION_LOG + "getRuoliUtente - end");
		}
	}

	@Override
	public UtenteLoggato setAccesso(HttpServletRequest req, UtenteLoggato utenteLoggato) throws SvistaException, SigitUserNotAuthorizedException {
		UtenteLoggato utenteLoggatoInvio = new UtenteLoggato();
		RuoloLoggato ruoloLoggatoInvio = new RuoloLoggato();
		PFLoggato pfLoggatoInvio = new PFLoggato();
		BeanUtils.copyProperties(utenteLoggato.getRuoloLoggato(), ruoloLoggatoInvio);
		BeanUtils.copyProperties(utenteLoggato.getPfLoggato(), pfLoggatoInvio);
		utenteLoggatoInvio.setPfLoggato(pfLoggatoInvio);
		utenteLoggatoInvio.setRuoloLoggato(ruoloLoggatoInvio);
		if (validationService.isStatoPGValido(utenteLoggatoInvio).equals(true)) {
			StringBuilder builder = new StringBuilder(utenteLoggatoInvio.getRuoloLoggato().getRuolo());
			builder.append(" (CITPWA)");
			if (utenteLoggatoInvio.getRuoloLoggato().getNumeroRea() != null)
				builder.append(" REA ").append(utenteLoggatoInvio.getRuoloLoggato().getSiglaRea()).append("-").append(utenteLoggatoInvio.getRuoloLoggato().getNumeroRea());
			utenteLoggatoInvio.getRuoloLoggato().setRuolo(builder.toString());
			String stato = iCitService.setAccesso(utenteLoggatoInvio);
			if (stato.equals(Constants.OK)) {
				utenteLoggato.getRuoloLoggato().setRuolo(utenteLoggato.getRuoloLoggato().getRuolo().replace(" (CITPWA)", ""));
				if (utenteLoggato.getRuoloLoggato().getRuolo().contains(Constants.CAT_RUOLO_PREFISSO)) {
					utenteLoggato.getRuoloLoggato().setRuolo(utenteLoggato.getRuoloLoggato().getRuolo().replace(Constants.CAT_RUOLO_PREFISSO, ""));
					utenteLoggato.getRuoloLoggato().setCat(true);
				} else {
					utenteLoggato.getRuoloLoggato().setCat(false);
				}
				req.getSession().setAttribute(Constants.USERINFO_SESSIONATTR, utenteLoggato);
				return utenteLoggato;
			} else {
				return null;
			}
		} else {
			throw new SigitUserNotAuthorizedException();
		}
	}

	@Override
	public String getDisponibilitaServizio(UtenteLoggato utenteLoggato) throws SvistaException {
		return iCitService.getDisponibilitaServizio(utenteLoggato);
	}

	@Override	public void ping() throws SvistaException, SocketTimeoutException {
		log.info(Constants.AUTHENTICATION_LOG + "ping - start");
		try {
			iCitService.ping();
		} catch (SocketTimeoutException e) {
			log.error(Constants.AUTHENTICATION_LOG + "ping - timeout: ", e);
			throw e;
		} finally {
			log.info(Constants.AUTHENTICATION_LOG + "ping - end");
		}
	}

}
