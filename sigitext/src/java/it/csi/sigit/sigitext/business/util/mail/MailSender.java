/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/

package it.csi.sigit.sigitext.business.util.mail;

import it.csi.sigit.sigitext.business.util.Constants;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.*;
import java.util.ArrayList;

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
        
        Session session = Session.getInstance(props, auth);
        
        // Construct the message
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(emailVo.getMittente()));
        
        if (emailVo.getDestinatario() != null)
        {
        	// Nel caso di destinatario singolo
        	msg.setRecipient(Message.RecipientType.TO, new InternetAddress(emailVo.getDestinatario()));
        } 
        else if (emailVo.getDestinatari() != null && emailVo.getDestinatari().size() > 0)
        {
        	// Nel caso di destinatari multipli
        	for (String destinatarioSing : emailVo.getDestinatari()) {
        		msg.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatarioSing));
        	}
        }


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

        //	JIRA SIGIT-673
        // Questa collezione serve per tener traccia dei files da cancellare
        ArrayList<File> elencoFileAllegati = new ArrayList<File>();

        if (emailVo.getElencoAllegati().size() > 0)
        {
        	elencoFileAllegati = new ArrayList<File>();

        	ArrayList<Allegato> elencoAllegati = emailVo.getElencoAllegati();

        	for (Allegato allegato : elencoAllegati) {


        		// create and fill the second message part
        		if (allegato != null) {

        			MimeBodyPart attachmentPart = new MimeBodyPart();
        			final String contentType = allegato.getContentType();

        			// 
        			File file = File.createTempFile(allegato.getNomeFile(), allegato.getNomeFile());

        			elencoFileAllegati.add(file);

        			//log.debug("[MailSender::sendMail] file.getAbsolutePath(): "+file.getAbsolutePath());

        			OutputStream src = new FileOutputStream(file);
        			src.write(allegato.getFile());
        			src.close();

        			FileDataSource fileDataSource = new FileDataSource(file) {
        				@Override
        				public String getContentType() {
        					//return allegato.getContentType();
        					//return "application/pdf";
        					return contentType;

        				}
        			};

        			// Vecchio codice, non vengono cancellati i files temporanei
        			/*
				FileDataSource fileDataSource = new FileDataSource(createFileWithData(allegato.getNomeFile(), allegato.getFile())) {
					@Override
					public String getContentType() {
						//return allegato.getContentType();
						//return "application/pdf";
						return contentType;

					}
				};
        			 */

        			attachmentPart.setDataHandler(new DataHandler(fileDataSource));
        			attachmentPart.setFileName(allegato.getNomeFile());        	            
        			mp.addBodyPart(attachmentPart);

        		}
        		// create the Multipart and its parts to it	
        	}
        }

        // add the Multipart to the message
        msg.setContent(mp);        

        // Send the message
        Transport.send(msg);


        log.debug("elencoFileAllegati: "+elencoFileAllegati);
        if (elencoFileAllegati != null && elencoFileAllegati.size() > 0)
        {
        	for (File fileDel : elencoFileAllegati) {
        		//file2.deleteOnExit();
        		log.debug("Prima di cancellare");
        		boolean isDelete = fileDel.delete();
        		
        		if (log.isDebugEnabled())
        			log.debug("[MailSender::sendMail] "+fileDel+": file.delete(): "+isDelete);

        	}
        }

		} catch (Exception e) {
			log.error("Errore nell'invio della mail", e);
			throw e;
		} finally {
			log.debug("[MailSender::sendMail] END");
		}

	}
	
	private static File createFileWithData(String nome, byte[] doc) throws IOException
	{		
		int pos = nome.lastIndexOf(".");
		File file = File.createTempFile(nome, nome);
		file.deleteOnExit();
		//System.out.println("file.getAbsolutePath(): "+file.getAbsolutePath());
		OutputStream src = new FileOutputStream(file);
		src.write(doc);
		src.close();
		return file;
	}
	
	private class SMTPAuthenticator extends Authenticator {
		
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
