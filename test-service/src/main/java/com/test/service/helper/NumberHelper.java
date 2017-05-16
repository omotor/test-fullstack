package com.test.service.helper;

import java.math.BigInteger;

import org.apache.log4j.Logger;

public class NumberHelper {
	
	private static final String SYSTEM_NUMEROINVALIDO = "Numero invalido!";

	private static final String SYSTEM_VALIDO = "Numero valido!";
	
	private static Logger logger = Logger.getLogger(NumberHelper.class);

	public static boolean isNumber(String number) {
		try{
			BigInteger convert = new BigInteger(number);
			logger.info(String.format("%s : %s", convert, SYSTEM_VALIDO));
			
			return true;
		}catch(NumberFormatException ex){
			logger.warn(String.format("%s : %s", number, SYSTEM_NUMEROINVALIDO));
		}
		
		return false;
	}

}
