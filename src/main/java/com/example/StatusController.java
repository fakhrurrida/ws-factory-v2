package com.example;

import java.util.ArrayList;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.mysql.jdbc.Connection;

@WebService
public class StatusController {
	
	@WebMethod
	public int changeStatus(int id) {
		
		int result = 0;
		
		try {
			DBHandler db = new DBHandler();
			result = db.changeStatus(id);
		}
		
		catch(Exception err) {
			err.printStackTrace();
		}		
		
		return result;
	}
}
