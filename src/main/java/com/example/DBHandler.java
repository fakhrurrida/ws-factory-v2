package com.example;
import java.sql.*;
import java.util.ArrayList;

public class DBHandler {
	private Connection connection;
	private static String DB_URL = "jdbc:mysql://localhost:3306/wsfactory";
	private static String DB_Username = "root";
	private static String DB_Password = "";
	
	public DBHandler() {
		try {
		 	System.out.println("Connecting to MYSQL DB");
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.connection = DriverManager.getConnection(DB_URL, DB_Username, DB_Password);
			System.out.println("Database connected!");
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error!");
		}
	}
	
	public Connection getConnection() {
		return this.connection;
	}
	
	public static int[] addX(int n, int arr[], int x) 
    { 
        int i; 
  
        // create a new array of size n+1 
        int newarr[] = new int[n + 1]; 
  
        // insert the elements from 
        // the old array into the new array 
        // insert all elements till n 
        // then insert x at n+1 
        for (i = 0; i < n; i++) 
            newarr[i] = arr[i]; 
  
        newarr[n] = x; 
  
        return newarr; 
    } 
	
	public int getSaldo() throws SQLException {
		int saldo = 0;
		
		try {
			DBHandler handler = new DBHandler();
			Connection conn = handler.getConnection();
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM saldo";
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				saldo = rs.getInt("saldo");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(saldo);
		return saldo;	
	}
	
	public ArrayList<String> getListCokelat() throws SQLException {
		ArrayList<String> listCokelat = new ArrayList<String>();
		
		try {
			DBHandler handler = new DBHandler();
			Connection conn = handler.getConnection();
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM cokelat_factory";
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				String record = "";
				String idCokelat = rs.getString("ID_cokelat");
				String jumlah = rs.getString("jumlah");
				String nama = rs.getString("nama_cokelat");
				String url = rs.getString("url_foto");
				
				record = idCokelat + "," + jumlah + "," + nama + "," + url;
				listCokelat.add(record);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(listCokelat);
		return listCokelat;
	}
	
	public ArrayList<String> getListBahan(int idCokelat) throws SQLException {
		ArrayList<String> listBahan = new ArrayList<String>();
		
		try {
			DBHandler handler = new DBHandler();
			Connection conn = handler.getConnection();
			Statement stmt = conn.createStatement();
			Statement secStmt = conn.createStatement();
			String sql = "SELECT * FROM resep";
			String sqlBahan = "SELECT * FROM bahan";
			ResultSet rs = stmt.executeQuery(sql);
			ResultSet rsBahan = secStmt.executeQuery(sqlBahan);
			
			
			while (rs.next()) {
				String id = rs.getString("ID_cokelat");
				String namaBhn = "";
				String jumlah = "";
				System.out.print("Ini id dari database: ");
				System.out.println(Integer.parseInt(id));
				System.out.print("Ini id yang diminta: ");
				System.out.println(idCokelat);
				
				if (Integer.parseInt(id) == idCokelat) {
					
					String idBahan =  rs.getString("ID_bahan");
					System.out.print("Ini id bahan dari tabel resep: ");
					System.out.println(Integer.parseInt(idBahan));
					
					while (rsBahan.next()) {
						String idBhn = rsBahan.getString("ID_bahan");
						System.out.print("Ini id bahan dari tabel bahan: ");
						System.out.println(Integer.parseInt(idBhn));
						if (Integer.parseInt(idBahan) == Integer.parseInt(idBhn)) {
							System.out.print("Masuk Pak Eko!");
			
							System.out.print("Ini nama bahan dari tabel bahan: ");
							
							namaBhn += rsBahan.getString("nama_bahan") + ",";
							String jml = rsBahan.getString("jumlah");
							String satuan = rsBahan.getString("satuan");
							jumlah += jml + " " + satuan + ",";
							
							System.out.println(namaBhn);
							listBahan.add(id);
							listBahan.add(namaBhn);
							listBahan.add(jumlah);
							
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(listBahan);
		return listBahan;
	}
	
	public int addNewChocolate(String nama, ArrayList<String> bahan, ArrayList<Integer> jumlah, String url) throws SQLException {
		int rs = 0; 
		int res = 0;
		
		try {
			
			DBHandler handler = new DBHandler();
			Connection conn = handler.getConnection();
			Statement stmt = conn.createStatement();
			String sql = String.format("INSERT INTO cokelat_factory (jumlah, nama_cokelat, url_foto) VALUES(%d, '%s', '%s')", 0, nama, url);
			
			ResultSet cekAda = stmt.executeQuery("SELECT * FROM cokelat_factory");
			boolean gaAda = true;
			
			while (cekAda.next()) {
				if (nama == cekAda.getString("nama_cokelat")) {
					System.out.println("Cokelatnya belom ada kok!");
					gaAda = false;
				}
				
			}
			
			if (gaAda) {
				System.out.println("Cokelatnya belom ada kok!");
				rs = stmt.executeUpdate(sql);
				
				ResultSet getId = stmt.executeQuery("SELECT * FROM cokelat_factory");
				int idCokelat = 0;
				while (getId.next()) {
					idCokelat = getId.getInt("ID_cokelat");
				}
				
				System.out.print("Ini ID cokelat yang mau ditambahin: ");
				System.out.println(idCokelat);
				
				Statement firstStmt = conn.createStatement();
				String firstSql = "SELECT * FROM bahan";
				ResultSet firstRs = firstStmt.executeQuery(firstSql);
				
				Statement secStmt = conn.createStatement();
				
				int i = 0;
				while (i < bahan.size()) {
					System.out.print("Ini bahan yang pertama: ");
					System.out.println(bahan.get(i));
					while (firstRs.next()) {
						String namaBahan = firstRs.getString("nama_bahan");
						System.out.print("Ini bahan yang ada di tabel bahan: ");
						System.out.println(namaBahan);
						if (bahan.get(i).equals(namaBahan)) {
							int idBahan = firstRs.getInt("ID_bahan");
							System.out.print("Ini ID bahan untuk membuat cokelatnya: ");
							System.out.println(idBahan);
							System.out.print("Jumlahnya: ");
							System.out.println(jumlah.get(i));
							String query = String.format("INSERT INTO resep VALUES(%d, %d, %d)", idCokelat, idBahan, jumlah.get(i));
							res = secStmt.executeUpdate(query);
						}	
					}
					i += 1;
				}
			} else {
				System.out.println("Cokelat sudah ada!");
			}
			
		}catch (Exception e){
			e.printStackTrace();
		}
		
		return res;
	}
	
	public int changeStatus(int id) {
		
		int result = 0;
		try {
			DBHandler db = new DBHandler();
			Connection conn = db.getConnection();
			Statement stmt = conn.createStatement();
			
			String query1 = "SELECT * FROM cokelat_factory";
			Statement stmt1 = conn.createStatement();
			ResultSet rs1 = stmt1.executeQuery(query1);
			
			String query2 = "SELECT * FROM request";
			ResultSet rs2 = stmt.executeQuery(query2);
			
			int jmlRequest = 0;
			int idCokelatBought = 0;
			
			while (rs2.next()) {
				int idRequest = rs2.getInt("ID_request");
				System.out.print("ID Request yang sekarang sedang dicek adalah: ");
				System.out.println(idRequest);
				if (idRequest == id) {
					jmlRequest = rs2.getInt("jumlah");
					idCokelatBought = rs2.getInt("ID_cokelat");
					System.out.print("Jumlah cokelat yang mau dibeli adalah: ");
					System.out.println(jmlRequest);
					
					System.out.print("ID cokelat yang mau dibeli adalah: ");
					System.out.println(idCokelatBought);
				}
			}
			
			int jmlTersedia = 0;
			
			while (rs1.next()) {
				int idCokelat = rs1.getInt("ID_cokelat");
				System.out.print("Ini ID cokelat yang mau diubah requestnya: ");
				System.out.println(idCokelat);
				if (idCokelat == idCokelatBought) {
					jmlTersedia = rs1.getInt("jumlah");
					System.out.print("Jumlah cokelat yang tersedia adalah: ");
					System.out.println(jmlTersedia);
				}
			}
			
			if (jmlTersedia >= jmlRequest) {
				String query3 = String.format("UPDATE request SET jml_pending=%d, jml_delivered=%d WHERE ID_request=%d", 0, 1, id);
				result = stmt.executeUpdate(query3);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public int ubahSaldo(int jml) throws SQLException {
		int result = 0;
		DBHandler db = new DBHandler();
		Connection conn = db.getConnection();
		Statement stmt = conn.createStatement();
		String query = String.format("UPDATE saldo SET saldo=%d WHERE saldo=(SELECT saldo FROM saldo)", jml);
		
		result = stmt.executeUpdate(query);	
		
		return result;
	}
	
	
	public int addStock(int id, int jml) throws SQLException {
		int result = 0;
		DBHandler db = new DBHandler();
		Connection conn = db.getConnection();
		Statement stmt = conn.createStatement();
		String query = String.format("UPDATE cokelat_factory SET jumlah=%d WHERE id=", jml);
		
		result = stmt.executeUpdate(query);	
		
		return result;
	}
	
}
