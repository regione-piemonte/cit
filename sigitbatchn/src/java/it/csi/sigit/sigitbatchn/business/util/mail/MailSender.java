/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/

package it.csi.sigit.sigitbatchn.business.util.mail;


import it.csi.sigit.sigitbatchn.business.manager.util.Messages;
import it.csi.sigit.sigitbatchn.business.manager.util.ServiceException;
import it.csi.sigit.sigitbatchn.business.util.Constants;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.soap.util.mime.ByteArrayDataSource;

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
	 * Server mail da utilizzare
	 */
	//private MailServer mailServer = null;
	
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
//		props.put("mail.transport.protocol", "smtp");
//		props.put("mail.smtp.host", emailVo.getHost());
//        props.put("mail.smtp.port", emailVo.getPort());
//		props.put("mail.smtp.auth", "true");
//		props.put("mail.smtp.starttls.enable", "true");
		
		props.put("mail.smtp.host", emailVo.getHost());
		props.put("mail.smtp.port", emailVo.getPort());
		props.put("mail.smtp.auth", "true");
		props.put("mail.debug", "false");
		props.put("mail.smtp.socketFactory.port", emailVo.getPort());
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.socketFactory.fallback", "false");
		props.put("mail.smtp.ssl.protocols", "TLSv1.2");

		log.debug("Host: "+emailVo.getHost());
		log.debug("Port: "+emailVo.getPort());
//		log.debug("IdMail: "+emailVo.getIdEmail());
//		log.debug("Password: "+emailVo.getPassword());
		
		Authenticator auth = new SMTPAuthenticator(emailVo.getIdEmail(), emailVo.getPassword());
        
        Session session = Session.getInstance(props, auth);

        
        log.debug("Session: "+session);
        
        //log.debug("Host: "+emailVo.getHost());
        //log.debug("Port: "+emailVo.getPort());
        
        //System.out.println("STAMPO session.getProperties(): "+session.getProperties());
        
        // Construct the message
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(emailVo.getMittente()));

        if (emailVo.getDestinatari() != null && emailVo.getDestinatari().size() > 0)
        {
        	// Ci sono più destinatari
        	ArrayList<String> destinatari = emailVo.getDestinatari();
            for (String destinatario : destinatari) {
            	msg.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
    		}
        }
        else
        {
        	// C'è un solo destinatario
        	msg.setRecipient(Message.RecipientType.TO, new InternetAddress(emailVo.getDestinatario()));
        }
        
        
        if(StringUtils.isNotEmpty(emailVo.getDestinatarioCC())){
        	msg.setRecipient(Message.RecipientType.CC, new InternetAddress(emailVo.getDestinatarioCC()));
        }
        msg.setSubject(emailVo.getOggetto());
        MimeMultipart  mp = new MimeMultipart();
        
        log.debug("Mittente: "+msg.getFrom());
        log.debug("Destinatari: "+msg.getAllRecipients());
        
       
        MimeBodyPart html = new MimeBodyPart();
        html.setText(emailVo.getTesto(), "text/plain");                
        html.setContent(emailVo.getHtml(),"text/html");
        
     // create the Multipart and its parts to it
        
        //mp.addBodyPart(text);
        mp.addBodyPart(html);
		
        
        if (emailVo.getAttachmentList() != null)
        {
	        MimeBodyPart messageBodyPart = null;
			DataSource attachmentSource = null;

	        //String attachmentList = emailVo.getAttachmentList();
	        for(String attachmentFileName : emailVo.getAttachmentList().keySet()) {
				messageBodyPart = new MimeBodyPart();
				
				attachmentSource = new ByteArrayDataSource(emailVo.getAttachmentList().get(attachmentFileName).toByteArray(), "application/pdf");

				messageBodyPart.setDataHandler(new DataHandler(attachmentSource));
				messageBodyPart.setFileName(attachmentFileName);
				mp.addBodyPart(messageBodyPart);
				
				
			}
        }
        // add the Multipart to the message
        msg.setContent(mp);        
        
        //addAttachments(emailVo.getAttachmentList(), msg);
        
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
	
	/**
	 * Aggiunge gli allegati
	 * 
	 * @param attachmentList Lista degli allegati da aggiungere
	 * @param message Messaggio a cui aggiungere gli allegati
	 * @throws MailSenderException Errore durante l'aggiunta degli allegati
	 */
	/*
	private void addAttachments(Hashtable<String, InputStream> attachmentList, Message message) throws Exception {
		MimeBodyPart messageBodyPart = null;
		MimeMultipart multipart = null;
		DataSource attachmentSource = null;

		// Aggiunta degli allegati
		if(attachmentList != null) {
			
			multipart = new MimeMultipart();
			try {
				
				System.out.println("\n\nmessage.getContentType(): "+message.getContentType());
				System.out.println("message.getContent(): "+message.getContent());
				if(message.getContentType().equalsIgnoreCase("text/html")){ 
					MimeBodyPart messageBodyPart1 = new MimeBodyPart();
					messageBodyPart1.setText((String)message.getContent());
					multipart.addBodyPart(messageBodyPart1);
					
				     //String content = (String)message.getContent();  
				     //And am writing some logic to put it as CLOB field in DB.  
				}
				
				for(String attachmentFileName : attachmentList.keySet()) {
					messageBodyPart = new MimeBodyPart();
					attachmentSource = new ByteArrayDataSource(attachmentList.get(attachmentFileName), "application/pdf");
					messageBodyPart.setDataHandler(new DataHandler(attachmentSource));
					messageBodyPart.setFileName(attachmentFileName);
					
					multipart.addBodyPart(messageBodyPart);
				}
				//System.out.println("Il messaggio prima del multipart: "+message.gett);
				message.setContent(multipart);
			}
			catch(IOException e) {
				new ServiceException(e, new Message(Messages.ERROR_INVIO_MAIL));
			}
			catch(MessagingException e) {
				new ServiceException(e, new Message(Messages.ERROR_INVIO_MAIL));
			}
		}
	}
	*/
	/**
	 * Restituisce il server di posta utilizzato per iviare le mail
	 * 
	 * @return Server di posta
	 */
//	public MailServer getMailServer() {
//		return mailServer;
//	}

	/**
	 * Imposta il server di posta utilizzato per inviare le mail
	 * 
	 * @param mailServer Server di posta
	 */
//	public void setMailServer(MailServer mailServer) {
//		this.mailServer = mailServer;
//	}
}
