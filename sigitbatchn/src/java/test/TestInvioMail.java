/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package test;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;


public class TestInvioMail {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("ENTRO");
		//sendMail();
	}

	private static void sendMail() {
		System.out.println("[TestInvioMail::sendMail] BEGIN");
		//GenericUtil.stampaVO(emailVO);	
        // Create a mail session
		try {
        java.util.Properties props = new java.util.Properties();        
        props.put("mail.smtp.host", "mailfarm-app.csi.it");
        props.put("mail.smtp.port", "25");
        Session session = Session.getDefaultInstance(props, null);

        System.out.println("Host: "+props.getProperty("mail.smtp.host"));
        System.out.println("Port: "+props.getProperty("mail.smtp.port"));
        
        //System.out.println("STAMPO session.getProperties(): "+session.getProperties());
        
        // Construct the message
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress("CIT Web <no-reply-energia@csi.it>"));
        
       
    	msg.addRecipient(Message.RecipientType.TO, new InternetAddress("giuseppe.todaro@csi.it"));

        msg.setSubject("Prova invio mail");
        MimeMultipart  mp = new MimeMultipart();

        System.out.println("Mittente: "+msg.getFrom()[0].toString());
        System.out.println("Destinatari: "+msg.getAllRecipients()[0].toString());
       
        MimeBodyPart html = new MimeBodyPart();
        html.setText("PROVA invio mail", "text/plain");                
        html.setContent("PROVA invio mail","text/html");
        
     // create the Multipart and its parts to it
        
        //mp.addBodyPart(text);
        mp.addBodyPart(html);
		
        
        // add the Multipart to the message
        msg.setContent(mp);        
        
        //addAttachments(emailVo.getAttachmentList(), msg);
        
        // Send the message
        Transport.send(msg);
		} catch (Exception e) {
			System.err.println("Errore nell'invio della mail: "+e);
		} finally {
			System.out.println("[TestInvioMail::sendMail] END");
		}
                
	}
}
