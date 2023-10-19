/*
 *
 *  * ******************************************************************************
 *  *  SPDX-License-Identifier: EUPL-1.2
 *  *  Copyright Regione Piemonte - 2021
 *  * *****************************************************************************
 *
 */

package it.csi.citpwa.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.JWTCreator.Builder;

import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTDecodeException;
import it.csi.citpwa.model.JWTModel;
import it.csi.citpwa.model.enums.JWTUserEnum;
import org.springframework.core.io.ClassPathResource;

import java.io.*;
import java.security.interfaces.RSAKey;
import java.security.interfaces.RSAPrivateKey;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class JWTUtil {

	private static final String PRIVATE_KEY = "/keystore/private_key.pem";

	public static JWTModel generaTokenFruitoreInterno(String codiceFiscalePF, String idPersonaGiuridica) {
		JWTModel jwtModel = new JWTModel(JWTUserEnum.FRUITORE_INTERNO);
		jwtModel.setCodApplFruitore(Constants.CODICE_FRUITORE_SIGITEXT_SIGIT);
		jwtModel.setCodFiscalePf(codiceFiscalePF);
		jwtModel.setIdPg(idPersonaGiuridica);
		jwtModel.setSubject(Constants.SUBJECT_JWT_FRUITORE);

		JWTUtil.createToken(jwtModel);

		return jwtModel;
	}

	public static void createToken(JWTModel dto) {
		String token = null;
		try {
			InputStream ioBf = new FileInputStream(new ClassPathResource(PRIVATE_KEY).getFile());
			Reader targetReader = new InputStreamReader(ioBf);
			RSAKey privRSA = (RSAKey) PemUtils.readPrivateKeyFromFile(targetReader, "RSA");
			Algorithm algorithmRS = Algorithm.RSA256(null, (RSAPrivateKey) privRSA);

			Date dtCreazioneToken = getCreazioneToken(new Date(),-10);
			Date dtScadenzaToken;

			Builder tokenBuilder = JWT.create().withIssuer(dto.getIssuer()).withSubject(dto.getSubject());

			dtScadenzaToken = getScadenzaToken(dtCreazioneToken, Calendar.DATE, 1);

			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:sss");

			if (dto.getIdPg() != null) {

				tokenBuilder = tokenBuilder.withClaim("idPg", dto.getIdPg());
			}

			tokenBuilder = tokenBuilder.withClaim("codiceFruitore", dto.getCodApplFruitore()).withClaim("codiceFiscalePersonaFisica", dto.getCodFiscalePf()).withIssuedAt(dtCreazioneToken)
					.withExpiresAt(dtScadenzaToken);

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

	public static Date getCreazioneToken(Date dataCreazione, int timeToSub) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dataCreazione);
		cal.add(Calendar.MINUTE, timeToSub);
		return cal.getTime();
	}

}
