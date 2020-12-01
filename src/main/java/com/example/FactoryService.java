package com.example;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.WebMethod;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

@WebService
@SOAPBinding(style=Style.RPC)
public class FactoryService {
	DBHandler db = new DBHandler();
	
	@WebMethod
	public void addStock() {}
	
	@WebMethod
	public String getChocolate(){return null;}
	
	@WebMethod
	public void addNewChocolate(){}
	
	@WebMethod
	public void makeNewChocolate(){}
	
	@WebMethod
	public void changeStatus(){}
	
	@WebMethod
	public void addSaldo(){}
	
	@WebMethod
	public int getSaldo(){return 0;}
	
	@WebMethod
	public void addBahan(){}
}
