package it.csi.sigit.combustypwabff.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTDecodeException;
import it.csi.sigit.combustypwabff.model.JWTModel;
import it.csi.sigit.combustypwabff.model.enums.JWTUserEnum;
import it.csi.sigit.combustypwabff.utils.Constants;
import it.csi.sigit.combustypwabff.utils.PemUtils;
import jakarta.enterprise.context.ApplicationScoped;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.security.interfaces.RSAKey;
import java.security.interfaces.RSAPrivateKey;
import java.util.Calendar;
import java.util.Date;

@ApplicationScoped
public class JwtService {

    private static final String PRIVATE_KEY = "/keystore/private_key.pem";

    protected static final Logger log = Logger.getLogger(Constants.APPLICATION_NAME);

    public JWTModel generaTokenFruitoreInterno(String codiceFiscalePF, String idPersonaGiuridica) {
        JWTModel jwtModel = new JWTModel(JWTUserEnum.FRUITORE_INTERNO);
        jwtModel.setCodApplFruitore(Constants.CODICE_FRUITORE_SIGITEXT_SIGIT);
        jwtModel.setCodFiscalePf(codiceFiscalePF);
        jwtModel.setIdPg(idPersonaGiuridica);
        jwtModel.setSubject(Constants.SUBJECT_JWT_FRUITORE);

        createToken(jwtModel);

        return jwtModel;
    }

    public void createToken(JWTModel dto) {
        String token = null;
        try (InputStream ioBf = getClass().getResourceAsStream(PRIVATE_KEY)) {
            Reader targetReader = new InputStreamReader(ioBf);
            RSAKey privRSA = (RSAKey) PemUtils.readPrivateKeyFromFile(targetReader, "RSA");
            Algorithm algorithmRS = Algorithm.RSA256(null, (RSAPrivateKey) privRSA);

            Date dtCreazioneToken = getCreazioneToken(new Date(),-10);
            Date dtScadenzaToken;

            JWTCreator.Builder tokenBuilder = JWT.create().withIssuer(dto.getIssuer()).withSubject(dto.getSubject());

            dtScadenzaToken = getScadenzaToken(dtCreazioneToken, Calendar.DATE, 1);

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
            log.error("Invalid token (IOException): " + exception);
        } catch (JWTDecodeException exception) {
            // Invalid token
            log.error("Invalid token (JWTDecodeException): " + exception);
        } catch (JWTCreationException exception) {
            // Invalid Signing configuration / Couldn't convert Claims.
            log.error("Invalid JWTCreationException: " + exception);
        } catch (Exception exception) {
            log.error("Invalid token (Exception): " + exception);
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
