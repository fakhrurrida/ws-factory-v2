package com.example;

import java.sql.ResultSet;
import java.util.ArrayList;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.mysql.jdbc.Connection;

@WebService
public class NewChocolateController {
	
	@WebMethod
	public int addNewChocolate(String nama, ArrayList<String> bahan, ArrayList<Integer> jumlah, String url) {
		
		int listBahan = 0; 
		
		try {
			DBHandler db = new DBHandler();
			listBahan = db.addNewChocolate(nama, bahan, jumlah, url);
		}
		
		catch(Exception err) {
			err.printStackTrace();
		}		
		
		return listBahan;
	}
}
