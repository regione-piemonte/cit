/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/

package it.csi.sigit.sigitweba.util.mail;

import it.csi.sigit.sigitweba.util.Constants;

import java.io.Serializable;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

// TODO: Auto-generated Javadoc
/**
 * The Class MailSender.
 *

 */
public class MailSender implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3596869004264743871L;
	
	/** The log. */
	protected static Logger log = Logger.getLogger(Constants.APPLICATION_CODE+ ".business");
	
	/**
	 * Send mail.
	 *
	 * @param emailVo the email vo
	 * @param doc the doc
	 * @throws Exception the exception
	 */
	public void sendMail(Mail emailVo) throws Exception {
		log.debug("[MailSender::sendMail] BEGIN");
		//GenericUtil.stampaVO(emailVO);	
        // Create a mail session
		try {
        java.util.Properties props = new java.util.Properties();        
        
		props.put("mail.smtp.host", emailVo.getHost());
		props.put("mail.smtp.port", emailVo.getPort());
		props.put("mail.smtp.auth", "true");
		props.put("mail.debug", "false");
		props.put("mail.smtp.socketFactory.port", emailVo.getPort());
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.socketFactory.fallback", "false");
		props.put("mail.smtp.ssl.protocols", "TLSv1.2");

		Authenticator auth = new SMTPAuthenticator(emailVo.getIdEmail(), emailVo.getPassword());
		Session session = null;
		
		/*
		// Test comparativo
		try
		{
			log.debug("@@@@ PRIMA DI getDefaultInstance @@@@");
			session = Session.getDefaultInstance(props, auth);
			log.debug("@@@@ DOPO DI getDefaultInstance @@@@");
		}
		catch (Exception e) {
			// TODO: handle exception
			log.error("Eccezione Session.getDefaultInstance: "+e);
		}
		
		log.debug("###############################################");
		
		try
		{
			log.debug("@@@@ PRIMA DI getInstance @@@@");
			session = Session.getInstance(props, auth);
			log.debug("@@@@ DOPO DI getInstance @@@@");
		}
		catch (Exception e) {
			// TODO: handle exception
			log.error("Eccezione Session.getInstance: "+e);
		}
        */
		// Impostato Session.getInstance invece di Session.getDefaultInstance
		session = Session.getInstance(props, auth);
		
		

        // Construct the message
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(emailVo.getMittente()));
        msg.setRecipient(Message.RecipientType.TO, new InternetAddress(emailVo.getDestinatario()));
        if(StringUtils.isNotEmpty(emailVo.getDestinatarioCC())){
        	msg.setRecipient(Message.RecipientType.CC, new InternetAddress(emailVo.getDestinatarioCC()));
        }
        msg.setSubject(emailVo.getOggetto());
        MimeMultipart  mp = new MimeMultipart();
        
       
        MimeBodyPart html = new MimeBodyPart();
        html.setText(emailVo.getTesto(), "text/plain");                
        html.setContent(emailVo.getHtml(),"text/html");
        
     // create the Multipart and its parts to it
        
        //mp.addBodyPart(text);
        mp.addBodyPart(html);
        
        // add the Multipart to the message
        msg.setContent(mp);        
        
        // Send the message
        Transport.send(msg);
		} catch (Exception e) {
			log.error("Errore nell'invio della mail", e);
			throw e;
		} finally {
			log.debug("[MailSender::sendMail] END");
		}
                
	}
	
	private class SMTPAuthenticator extends javax.mail.Authenticator {
		
		private String user;
		private String pwd;
		
		public SMTPAuthenticator(String user, String pwd)
		{
			this.user = user;
			this.pwd = pwd;
		}
		
		public PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(user, pwd);
		}
	}
	
}
