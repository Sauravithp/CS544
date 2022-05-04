package com.example.exercise13_1.jms;

public class EmailSenderServiceImpl implements EmailSenderService {
	String outgoingMailServer = "smtp.acme.com";

	public String getOutgoingMailServer() {
		return outgoingMailServer;
	}

	public void sendEmail (String email, String message){
		System.out.println("EmailSender: sending '"+message+"' to "+email );
	}
}
