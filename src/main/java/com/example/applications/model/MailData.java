package com.example.applications.model;

import org.springframework.stereotype.Component;

@Component
public class MailData {
	
	private String email;
	private String message;
	private String subject;
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "MailData [email=" + email + ", message=" + message + ", subject=" + subject + "]";
	}
	

}
