package com.example.exercise13_1.jms;

public interface EmailSenderService {
	public void sendEmail(String email, String message);
	public String getOutgoingMailServer();
}