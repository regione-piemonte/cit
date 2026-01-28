/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitext.business.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.security.interfaces.RSAKey;
import java.security.interfaces.RSAPrivateKey;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator.Builder;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTDecodeException;

import it.csi.sigit.sigitext.business.pdf.BaseBuilder;
import it.csi.sigit.sigitext.dto.sigitext.JWTDto;
import it.csi.sigit.sigitext.exception.sigitext.SigitextException;

public class JWTUtil {

	protected static final Logger logger = Logger.getLogger(Constants.APPLICATION_CODE + ".SigitextManager==>");

	private static final String CODICE_FRUITORE_SIGITEXT_SIGIT = "SIGIT";
	private static final String PRIVATE_KEY = "/it/csi/sigit/sigitext/business/util/keystore/private_key.pem";

	public static JWTDto createToken(JWTDto dto) throws SigitextException {
		String token = null;
		try {
			InputStream ioBf = BaseBuilder.class.getResourceAsStream(PRIVATE_KEY);
			Reader targetReader = new InputStreamReader(ioBf);
			RSAKey privRSA = (RSAKey) PemUtils.readPrivateKeyFromFile(targetReader, "RSA");
			Algorithm algorithmRS = Algorithm.RSA256(null, (RSAPrivateKey) privRSA);

			Date dtCreazioneToken = new Date();
			Date dtScadenzaToken = getScadenzaToken(dtCreazioneToken, Calendar.MONTH, 3);

			Builder tokenBuilder = JWT.create().withIssuer(dto.getIssuer()).withSubject(dto.getSubject());
			switch (dto.getUserType()) {
			case FRUITORE:
				tokenBuilder = tokenBuilder.withClaim("codiceFruitore", dto.getCodApplFruitore())
						.withIssuedAt(dtCreazioneToken).withExpiresAt(dto.getDtScadenzaToken());
				break;
			case FRUITORE_INTERNO:
				dtScadenzaToken = getScadenzaToken(dtCreazioneToken, Calendar.DATE, 1);
				
				if (dto.getIdPg() != null) {
					
					tokenBuilder = tokenBuilder.withClaim("idPg", dto.getIdPg());
				}
				
				tokenBuilder =	tokenBuilder.withClaim("codiceFruitore", dto.getCodApplFruitore())
						.withClaim("codiceFiscalePersonaFisica", dto.getCodFiscalePf())
						.withIssuedAt(dtCreazioneToken)
						.withExpiresAt(dtScadenzaToken);
				break;
			case IMPRESA:
				tokenBuilder = tokenBuilder.withClaim("idPg", dto.getIdPg())
				.withIssuedAt(dtCreazioneToken)
						.withExpiresAt(dtScadenzaToken);
				break;
			default:
				throw new Exception("Invalid user for create Token");
			}

			token = tokenBuilder.sign(algorithmRS);			
			dto.setDtCreazioneToken(dtCreazioneToken);
			if (dto.getDtScadenzaToken() == null) {
				dto.setDtScadenzaToken(dtScadenzaToken);
			}
			dto.setToken(token);

			return dto;

		} catch (IOException e) {
			logger.error("Invalid token (IOException)", e);
			throw new SigitextException("Errore durante la creazione del token.", e);
		} catch (JWTDecodeException e) {
			// Invalid token
			logger.error("Invalid token (JWTDecodeException)", e);
			throw new SigitextException("Errore durante la creazione del token.", e);
		} catch (JWTCreationException e) {
			// Invalid Signing configuration / Couldn't convert Claims.
			logger.error("Invalid JWTCreationException", e);
			throw new SigitextException("Errore durante la creazione del token.", e);
		} catch (Exception e) {
			logger.error("Invalid token (Exception)", e);
			throw new SigitextException("Errore durante la creazione del token.", e);
		}
	}

	public static Date getScadenzaToken(Date dataCreazione, int calendar, int timeToAdd) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dataCreazione);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		cal.add(calendar, timeToAdd);
		return cal.getTime();
	}
	
}
