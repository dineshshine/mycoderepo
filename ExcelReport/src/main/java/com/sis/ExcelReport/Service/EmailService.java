package com.sis.ExcelReport.Service;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.sis.ExcelReport.Model.EmailDetails;
import com.sis.ExcelReport.Model.MailIdEntry;
import com.sis.ExcelReport.dao.MailIdEntryDao;

@Service
public class EmailService {

	@Autowired
	JavaMailSender mail;
	@Autowired
	MailIdEntryDao maildao;
	
	 @Value("${spring.mail.username}") 
	 private String sender;
	 
	 Logger logger = LoggerFactory.getLogger(EmailService.class);
	
	public String sendSimpleMail(EmailDetails details)
    {  
		
	    // Creating a simple mail message
        SimpleMailMessage mailMessage
            = new SimpleMailMessage();

        // Setting up necessary details
        mailMessage.setFrom(sender);
        mailMessage.setTo(details.getRecipient());
        mailMessage.setText(details.getMsgBody());
        mailMessage.setSubject(details.getSubject());

        // Sending the mail
        mail.send(mailMessage);
        //System.out.println("Mail Sent Successfully...");
        return "Mail Sent Successfully...";
		
    }
	
	public String sendMailWithAttachments(EmailDetails details) throws IOException
    {  
		
		 // Creating a mime message
        MimeMessage mimeMessage
            = mail.createMimeMessage();
        MimeMessageHelper mimeMessageHelper;
 
        try {
 
            // Setting multipart as true for attachments to
            // be send
            mimeMessageHelper
                = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom(sender);
            //System.out.println("mail ---- "+details.getRecipient());
            mimeMessageHelper.setTo(details.getRecipient()); 
         //   mimeMessageHelper.setTo("dinesha123445@gmail.com");
            mimeMessageHelper.setText(details.getMsgBody());
            mimeMessageHelper.setSubject(
                details.getSubject());
           File file = new File(details.getAttachment());
           //System.out.println(details.getAttachment());
            // Adding the attachment
            FileSystemResource fileSource
                = new FileSystemResource(
                		file);
            //Multipart multipart = new MimeMultipart();
            mimeMessageHelper.addAttachment(
            		fileSource.getFilename(), fileSource);
           // MimeBodyPart attachementPart = new MimeBodyPart();
	       // attachementPart.attachFile(file);
	       // multipart.addBodyPart(attachementPart);
	      //  mimeMessageHelper.addat
            // Sending the mail
            mail.send(mimeMessage);
            fileSource.getOutputStream().close();
            //System.out.println(file.getAbsolutePath());
            logger.info(file.getAbsolutePath());
           // //System.out.println(FileDeleteStrategy.FORCE.deleteQuietly(file));
            //System.out.println("Mail sent Successfully");
            logger.info("Mail sent Successfully");
            return "Mail sent Successfully";
        }
 
        // Catch block to handle MessagingException
        catch (MessagingException e) {
         //System.out.println("Error while sending mail!!!");
            // Display message when exception occurred
            return "Error while sending mail!!!";
        }
		
    }
	
	public void sendMail(String msgbody, String sub, List<String> mailList, String path) {

		EmailDetails mail = new EmailDetails();

		mail.setMsgBody(msgbody);
		mail.setSubject(sub);
		//System.out.println("maillistt"+mailList.size());
		String[] arr = new String[mailList.size()];
		for (int i = 0; i < mailList.size(); i++) {
			arr[i] = mailList.get(i);
		}
		// arr[0] = "dinesha123445@gmail.com";
		mail.setRecipient(arr);
		mail.setAttachment(path);
		// emailService.sendSimpleMail(mail);
		//System.out.println("  iadojasjC "+mail.getRecipient()[0]);
		try {
			sendMailWithAttachments(mail);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	public void sendMail_Testing(String msgbody, String sub, List<String> mailList, String path) {

		mailList = Arrays.asList("dinesha123445@gmail.com");
		EmailDetails mail = new EmailDetails();

		mail.setMsgBody(msgbody);
		mail.setSubject(sub);
		//System.out.println("maillistt"+mailList.size());
		String[] arr = new String[mailList.size()];
		for (int i = 0; i < mailList.size(); i++) {
			arr[i] = mailList.get(i);
		}
		// arr[0] = "dinesha123445@gmail.com";
		mail.setRecipient(arr);
		mail.setAttachment(path);
		// emailService.sendSimpleMail(mail);
		//System.out.println("  iadojasjC "+mail.getRecipient()[0]);
		try {
			sendMailWithAttachments(mail);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public List<String> getCatList(String type){
		List<String> catlist = maildao.getCategories(type);
//		catlist.forEach((ele)->{
//			//System.out.println("cate "+ele);
//		});
		return catlist;
	}
	
	public List<MailIdEntry> getMailList(String type){
		List<MailIdEntry> catlist = maildao.getMailIdList(type);
		return catlist;
	}
	public List<String> getMailList(List<MailIdEntry> maillist,String div){
	//	List<MailIdEntry> catlist = maildao.getMailIdList(type);
		List<String> resultList = maillist.stream().filter(obj -> obj.getTemp1().equals(div))
				.map(e -> e.getMail_id()).collect(Collectors.toList());
		return resultList;
	}
}
