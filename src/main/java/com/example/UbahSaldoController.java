package com.example;

import java.util.ArrayList;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.mysql.jdbc.Connection;

@WebService
public class UbahSaldoController {
	
	@WebMethod
	public int ubahSaldo(int jml) {
		
		int result = 0;
		
		try {
			DBHandler db = new DBHandler();
			result = db.ubahSaldo(jml);
		}
		
		catch(Exception err) {
			err.printStackTrace();
		}		
		
		return result;
	}
}
