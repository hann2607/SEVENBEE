package com.sevenbee.service;

import com.sevenbee.entities.MailInfo;

import jakarta.mail.MessagingException;

public interface MailService {
	void send(MailInfo mail) throws MessagingException;

	void send(String to, String subject, String body) throws MessagingException;
	
	void queue(MailInfo mail);
	void queue(String to, String subject, String body);

}
