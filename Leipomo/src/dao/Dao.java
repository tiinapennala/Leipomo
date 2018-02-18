package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.*;

public class Dao {
	
	private Connection yhdista() throws SQLException  , Exception {
    	Connection tietokantayhteys = null;
    	        	
    	String JDBCAjuri = "org.mariadb.jdbc.Driver";
    	String url = "jdbc:mariadb://localhost:3306/a1402802";
        	
    	
    	try {
	         Class.forName(JDBCAjuri); // ajurin m‰‰ritys
	        	    	 
	         // otetaan yhteys tietokantaan
	         tietokantayhteys = DriverManager.getConnection(url,"XXX", "XXX");
	
	        
	     }catch (SQLException sqlE){
	         System.err.println("Tietokantayhteyden avaaminen ei onnistunut. " +
	        		 url + "\n" +sqlE.getMessage() + " " + 
	        		 	sqlE.toString()+"\n");
	     				sqlE.printStackTrace();
	         throw( sqlE);
	     }catch (Exception e){
	         System.err.println("TIETOKANTALIITTYN VIRHETILANNE: " +
	            "JDBC:n omaa tietokanta-ajuria ei loydy.\n\n" + e.getMessage() +
	            		" " + e.toString() + "\n");
	        			e.printStackTrace();
	         System.out.print("\n");
	         throw (e);
	     }
	     return tietokantayhteys;
	}
	
	
	
	public Tuote haeTuote(int tuotenro){
		Tuote tuote = null;
		String sql = "SELECT * FROM tuotteet WHERE tuotenro=?";
		Connection conn=null;
		ResultSet rs=null;
		try {
			conn = yhdista();	
			PreparedStatement stmtPrep=conn.prepareStatement(sql);   
			stmtPrep.setInt(1, tuotenro);
			rs = stmtPrep.executeQuery();
		    conn.close();
		    if (rs.next()) {
				tuote = new Tuote();
				tuote.setTuotenro(tuotenro);
				tuote.setNimi(rs.getString("nimi"));
				tuote.setTyyppi(rs.getString("tyyppi"));
				tuote.setHinta(rs.getDouble("hinta"));
				tuote.setKuvaus(rs.getString("kuvaus"));
				tuote.setLopetettu(rs.getBoolean("lopetettu"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tuote;
	}

	
	public ArrayList<Tuote> etsiTuotteet(String hakusana) throws SQLException, Exception{
		ArrayList<Tuote> tuotteet=null;
		String sql = "SELECT * FROM tuotteet WHERE nimi LIKE ? and lopetettu=0";
		ResultSet rs = null; // SQL-kyselyn tulokset
        Connection conn=null;
        System.out.println(hakusana);
		try {
			conn = yhdista();
			if (conn != null) {
				PreparedStatement stmtPrep=conn.prepareStatement(sql);   
    			stmtPrep.setString(1, "%" + hakusana + "%" );   
        		rs = stmtPrep.executeQuery(); 
        		if (rs != null) {
        			conn.close(); // sulje yhteys kantaan
        			while(rs.next()){
        				Tuote tuote = new Tuote();
        				tuote.setTuotenro(rs.getInt("tuotenro"));
    					tuote.setNimi(rs.getString("nimi"));
    					tuote.setTyyppi(rs.getString("tyyppi"));
    					tuote.setHinta(rs.getDouble("hinta"));
    					tuote.setKuvaus(rs.getString("kuvaus"));
    					tuote.setLopetettu(rs.getBoolean("lopetettu"));
    					    					
    					if (tuotteet == null) {
    						tuotteet = new ArrayList<Tuote>();
    					}	
    					tuotteet.add(tuote);
        			}
        			rs.close();
				} else{
					conn.close();
					tuotteet = null;
				}	
			}
		} catch (SQLException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		} finally {
			if (conn != null &&  conn.isClosed() == false) {
				try {
					conn.close();     // yhteys poikki
				} catch(Exception e) {
					throw  e;
				}
			}
		}
		return tuotteet;
        
	}
	
	
	public ArrayList<Tuote> etsiTyyppi(String hakusana) throws SQLException, Exception{
		ArrayList<Tuote> tuotteet=null;
		String sql = "SELECT * FROM tuotteet WHERE tyyppi LIKE ? and lopetettu=0";
		ResultSet rs = null; // SQL-kyselyn tulokset
        Connection conn=null;
        System.out.println(hakusana);
		try {
			conn = yhdista();
			if (conn != null) {
				PreparedStatement stmtPrep=conn.prepareStatement(sql);   
    			stmtPrep.setString(1, "%" + hakusana + "%" );   
        		rs = stmtPrep.executeQuery(); 
        		if (rs != null) {
        			conn.close(); // sulje yhteys kantaan
        			while(rs.next()){
        				Tuote tuote = new Tuote();
        				tuote.setTuotenro(rs.getInt("tuotenro"));
    					tuote.setNimi(rs.getString("nimi"));
    					tuote.setTyyppi(rs.getString("tyyppi"));
    					tuote.setHinta(rs.getDouble("hinta"));
    					tuote.setKuvaus(rs.getString("kuvaus"));
    					tuote.setLopetettu(rs.getBoolean("lopetettu"));
    					    					
    					if (tuotteet == null) {
    						tuotteet = new ArrayList<Tuote>();
    					}	
    					tuotteet.add(tuote);
        			}
        			rs.close();
				} else{
					conn.close();
					tuotteet = null;
				}	
			}
		} catch (SQLException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		} finally {
			if (conn != null &&  conn.isClosed() == false) {
				try {
					conn.close();     // yhteys poikki
				} catch(Exception e) {
					throw  e;
				}
			}
		}
		return tuotteet;
	}
	
	
	
	public void lisaaTuote(Tuote tuote){
		String sql = "INSERT INTO tuotteet (nimi, hinta, tyyppi, kuvaus)"
				+ " VALUES(?,?,?,?)";
		Connection conn=null;
		try {
			conn = yhdista();	
			PreparedStatement stmtPrep=conn.prepareStatement(sql);   
			stmtPrep.setString(1, tuote.getNimi());
			stmtPrep.setDouble(2, tuote.getHinta());
			stmtPrep.setString(3, tuote.getTyyppi());
			stmtPrep.setString(4, tuote.getKuvaus());
			stmtPrep.executeUpdate();
		    conn.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	public void muutaTuote(Tuote tuote, int vanhaTuotenro){
		String sql = "UPDATE tuotteet SET nimi=?, tyyppi=?, hinta=?, kuvaus=? WHERE tuotenro=?";
		Connection conn=null;
		System.out.println(tuote);
		try {
			conn = yhdista();	
			PreparedStatement stmtPrep=conn.prepareStatement(sql); 
			stmtPrep.setString(1, tuote.getNimi());
			stmtPrep.setString(2, tuote.getTyyppi());
			stmtPrep.setDouble(3, tuote.getHinta());
			stmtPrep.setString(4, tuote.getKuvaus());
			stmtPrep.setInt(5, vanhaTuotenro);
	        stmtPrep.executeUpdate();
	        conn.close();
		}catch (Exception e) {
        	System.out.println(e.getMessage());
        }
	}
	
	
	public void poistaTuote(int poistaTuotenro){
		String sql = "UPDATE tuotteet SET lopetettu=1 WHERE tuotenro=?";
		Connection conn=null;
		try {
			conn = yhdista();	
			PreparedStatement stmtPrep=conn.prepareStatement(sql); 
			stmtPrep.setInt(1, poistaTuotenro);
	        stmtPrep.executeUpdate();
	        conn.close();
		}catch (Exception e) {
        	System.out.println(e.getMessage());
        }
	}
	
	
}


