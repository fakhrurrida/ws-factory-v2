package com.example;

import java.sql.ResultSet;
import java.util.ArrayList;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.mysql.jdbc.Connection;

@WebService
public class ListBahanController {
	
	@WebMethod
	public ArrayList<String> getListBahan(int id) {
		
		ArrayList<String> listBahan = new ArrayList<String>(); 
		
		try {
			DBHandler db = new DBHandler();
			listBahan = db.getListBahan(id);
		}
		
		catch(Exception err) {
			err.printStackTrace();
		}		
		
		return listBahan;
	}
}
