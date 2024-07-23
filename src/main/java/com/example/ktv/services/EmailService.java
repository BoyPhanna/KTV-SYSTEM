package com.example.ktv.services;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

@Service
public class EmailService {
    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }
    @Value("${app.email.from}")
    private String from;



    public void send(String to, String subject, String html) {
        System.out.println("from email: "+from);
        MimeMessagePreparator message = mimeMessage -> {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(html, true);
        };
        mailSender.send(message);
    }

    public void sendVerifyCode(String email,String name,String verifyCode)throws IOException{
        String html;
        try {
            System.out.println("Try to read html file");
            html = readEmailTemplate("email-activate-user.html");
        } catch (IOException e) {

            throw e;
        }

        html = html.replace("${P_NAME}", name);
        html = html.replace("${VERIFY CODE}",  verifyCode);

        // prepare subject
        String subject = "Please activate your account";


        send(email, subject, html);
    }
    private String readEmailTemplate(String filename) throws IOException {
        File file;
        try {
            System.out.println("Dev path; ");
        file = ResourceUtils.getFile("classpath:email/" + filename);

        }catch (IOException e){
            System.out.println("Docker path: ");

        file = ResourceUtils.getFile("/email/" + filename);
        }
        System.out.println(" Debug path: "+ file.getAbsolutePath());
        return FileCopyUtils.copyToString(new FileReader(file));
    }

}
