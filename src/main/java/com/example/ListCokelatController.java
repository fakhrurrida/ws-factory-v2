package com.example;

import java.sql.ResultSet;
import java.util.ArrayList;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.mysql.jdbc.Connection;

@WebService
public class ListCokelatController {
	
	@WebMethod
	public ArrayList<String> getListCokelat() {
		
		ArrayList<String> listCokelat = new ArrayList<String>(); 
		
		try {
			DBHandler db = new DBHandler();
			listCokelat = db.getListCokelat();
		}
		
		catch(Exception err) {
			err.printStackTrace();
		}		
		
		return listCokelat;
	}
}

