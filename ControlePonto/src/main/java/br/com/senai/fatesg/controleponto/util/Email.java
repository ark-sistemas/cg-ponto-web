package br.com.senai.fatesg.controleponto.util;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email {
	
	public static void enviarEmail(String email, String senha) {
		Properties props = new Properties();
//			configuração para HotMail
		props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.host", "smtp.live.com");
        props.put("mail.smtp.socketFactory.port", "587");
        props.put("mail.smtp.socketFactory.fallback", "false");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "587");
		
//        configuração para o GMAIL
//		props.put("mail.smtp.host", "smtp.gmail.com");
//		props.put("mail.smtp.socketFactory.port", "465");
//		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//		props.put("mail.smtp.auth", "true");
//		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("ark.organization@outlook.com", "ark123456");
			}
		});

		/** Ativa Debug para sessão */
		session.setDebug(true);
		
		try {
			 
		      Message message = new MimeMessage(session);
		      message.setFrom(new InternetAddress("ark.organization@outlook.com")); 
		      //Remetente
		 
		      Address[] toUser = InternetAddress //Destinatário(s)
		                 .parse(email);  
		 
		      message.setRecipients(Message.RecipientType.TO, toUser);
		      message.setSubject("Nova Senha");//Assunto
		      message.setText("Conforme solicitado segue a nova senha: "+senha);
		      /**Método para enviar a mensagem criada*/
		      Transport.send(message);
		      System.out.println("Email: "+ email);
		      System.out.println("Senha: "+ senha);
		      System.out.println("Feito!!!");
		 
		     } catch (MessagingException e) {
		        throw new RuntimeException(e);
		    }

	}

}
