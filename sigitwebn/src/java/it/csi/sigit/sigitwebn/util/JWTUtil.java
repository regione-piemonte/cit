/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitwebn.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.security.interfaces.RSAKey;
import java.security.interfaces.RSAPrivateKey;
import java.util.Calendar;
import java.util.Date;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator.Builder;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTDecodeException;

import it.csi.sigit.sigitwebn.business.pdf.BaseBuilder;
import it.csi.sigit.sigitwebn.util.enumutil.JWTUserEnum;

public class JWTUtil {

	private static final String PRIVATE_KEY = "/it/csi/sigit/sigitwebn/util/keystore/private_key.pem";

	public static void createToken(JWTDto dto) {
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

		} catch (IOException exception) {
			System.err.println("Invalid token (IOException): " + exception);
		} catch (JWTDecodeException exception) {
			// Invalid token
			System.err.println("Invalid token (JWTDecodeException): " + exception);
		} catch (JWTCreationException exception) {
			// Invalid Signing configuration / Couldn't convert Claims.
			System.err.println("Invalid JWTCreationException: " + exception);
		} catch (Exception exception) {
			System.err.println("Invalid token (Exception): " + exception);
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
	
	public static JWTDto generaTokenFruitoreInterno(String codiceFiscalePF, String idPersonaGiuridica) {
		JWTDto jwtDto = new JWTDto(JWTUserEnum.FRUITORE_INTERNO);
		jwtDto.setCodApplFruitore(Constants.CODICE_FRUITORE_SIGITEXT_SIGIT);
		jwtDto.setCodFiscalePf(codiceFiscalePF);
		jwtDto.setIdPg(idPersonaGiuridica);
		
		JWTUtil.createToken(jwtDto);
		
		return jwtDto;
	}
}
