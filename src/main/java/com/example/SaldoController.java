package com.example;

import java.util.ArrayList;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.mysql.jdbc.Connection;

@WebService
public class SaldoController {
	
	@WebMethod
	public int getSaldo() {
		
		int saldo = 0; 
		
		try {
			DBHandler db = new DBHandler();
			saldo = db.getSaldo();
		}
		
		catch(Exception err) {
			err.printStackTrace();
		}		
		
		return saldo;
	}
}
