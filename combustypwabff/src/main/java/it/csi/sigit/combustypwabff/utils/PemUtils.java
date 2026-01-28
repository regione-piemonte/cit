package it.csi.sigit.combustypwabff.utils;

import org.apache.log4j.Logger;
import org.bouncycastle.util.io.pem.PemObject;
import org.bouncycastle.util.io.pem.PemReader;

import java.io.IOException;
import java.io.Reader;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.EncodedKeySpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class PemUtils {

    protected static final Logger logger = Logger.getLogger(Constants.APPLICATION_NAME);

    private static byte[] parsePEMFile(Reader readerFile) throws IOException {
        if (readerFile == null) {
            System.out.println("Il readerFile e' nullo");
        }
        PemReader reader = new PemReader(readerFile);
        PemObject pemObject = reader.readPemObject();
        byte[] content = pemObject.getContent();
        reader.close();
        return content;
    }

    private static PublicKey getPublicKey(byte[] keyBytes, String algorithm) {
        PublicKey publicKey = null;
        try {
            KeyFactory kf = KeyFactory.getInstance(algorithm);
            EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
            publicKey = kf.generatePublic(keySpec);
        } catch (NoSuchAlgorithmException e) {
            logger.error("Could not reconstruct the public key, the given algorithm could not be found.", e);
        } catch (InvalidKeySpecException e) {
            logger.error("Could not reconstruct the public key", e);
        }

        return publicKey;
    }

    private static PrivateKey getPrivateKey(byte[] keyBytes, String algorithm) {
        PrivateKey privateKey = null;
        try {
            KeyFactory kf = KeyFactory.getInstance(algorithm);
            EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
            privateKey = kf.generatePrivate(keySpec);
        } catch (NoSuchAlgorithmException e) {
            logger.error("Could not reconstruct the private key, the given algorithm could not be found.", e);
        } catch (InvalidKeySpecException e) {
            logger.error("Could not reconstruct the private key", e);
        }

        return privateKey;
    }

    public static PublicKey readPublicKeyFromFile(Reader reader, String algorithm) throws IOException {
        byte[] bytes = PemUtils.parsePEMFile(reader);
        return PemUtils.getPublicKey(bytes, algorithm);
    }

    public static PrivateKey readPrivateKeyFromFile(Reader reader, String algorithm) throws IOException {
        byte[] bytes = PemUtils.parsePEMFile(reader);
        return PemUtils.getPrivateKey(bytes, algorithm);
    }
}
