package com.example.exercise12_1.logging;

public class Logger implements ILogger{

	public void log(String logstring) {
		java.util.logging.logger.getLogger("BankLogger").info(logstring);
	}

}
