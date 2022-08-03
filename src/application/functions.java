package application;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class functions {
	Connection c = null ;
	PreparedStatement st = null;
	
	
	public boolean check_db_connection() {
	
    try {
       Class.forName("org.postgresql.Driver");
       c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cmdb","postgres", "younes");
       
    } 
    catch (Exception e) {
       e.printStackTrace();
       System.err.println(e.getClass().getName()+": "+e.getMessage());
       System.exit(0);
    }
    
    if (c!= null) {
    	System.out.println("Opened database successfully");
    	return true;
    }else {
    	System.out.println("Can't reach database ");
    	return false; 
    }
    
	}
	
	public void add_contact(String f_name,String l_name, String ph_number , String email , String adrs , String city , String wlaya , String information ) {
		
		try {
		       Class.forName("org.postgresql.Driver");
		       c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cmdb","postgres", "younes");
		       
		    } 
		    catch (Exception e) {
		       e.printStackTrace();
		       System.err.println(e.getClass().getName()+": "+e.getMessage());
		       System.exit(0);
		    }
		
		String insert = "INSERT INTO contacts (first_name, last_name, phone_number, email, address, city, wilaya, information"
				+ " )VALUES(?,?,?,?,?,?,?,?)" ;
		try {
			st = c.prepareStatement(insert) ;
			st.setString(1, f_name);
			st.setString(2, l_name);
			st.setString(3, ph_number);
			st.setString(4, email);
			st.setString(5, adrs);
			st.setString(6, city);
			st.setString(7, wlaya);
			st.setString(8, information);
			st.execute();
			System.out.println("Insertion done with Success ");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void update_contact(int id ,String f_name,String l_name, String ph_number , String email , String adrs , String city , String wlaya , String information ) {
		
		try {
		       Class.forName("org.postgresql.Driver");
		       c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cmdb","postgres", "younes");
		       
		    } 
		    catch (Exception e) {
		       e.printStackTrace();
		       System.err.println(e.getClass().getName()+": "+e.getMessage());
		       System.exit(0);
		    }
		
		String update = "UPDATE contacts SET first_name = ?,last_name = ?, phone_number = ?,email = ?,address = ?,city = ?,"
				+ "wilaya = ? ,information = ? WHERE id = ?;";
		try {
			
			st = c.prepareStatement(update) ;
			st.setString(1, f_name);
			st.setString(2, l_name);
			st.setString(3, ph_number);
			st.setString(4, email);
			st.setString(5, adrs);
			st.setString(6, city);
			st.setString(7, wlaya);
			st.setString(8, information);
			st.setInt(9, id);
			st.execute();
			System.out.println("Udpate done  with Success ");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public ObservableList<Contact> getContact() {
        ObservableList<Contact> list = FXCollections.observableArrayList();
        ResultSet rs = null;
        String select = "SELECT * from contacts";
        
        try {
		       Class.forName("org.postgresql.Driver");
		       c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cmdb","postgres", "younes");
		       
		    } 
		    catch (Exception e) {
		       e.printStackTrace();
		       System.err.println(e.getClass().getName()+": "+e.getMessage());
		       System.exit(0);
		    }
        
        
            try {
				st = c.prepareStatement(select);
				rs = st.executeQuery();
				
				while (rs.next()) {
				    Contact contact = new Contact();
				    contact.setId(rs.getInt("id"));
				    contact.setFirst_name(rs.getString("first_name"));
				    contact.setLast_name(rs.getString("last_name"));
				    contact.setPhone_number(rs.getString("phone_number"));
				    contact.setEmail(rs.getString("email"));
				    contact.setAddress(rs.getString("address"));
				    contact.setCity(rs.getString("city"));
				    contact.setWilaya(rs.getString("wilaya"));
				    contact.setInformations(rs.getString("information"));
				    
				    list.add(contact);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        
        return list;
 
    }
	
	public void delete_contact(int id) {
		
		String delete = "DELETE from contacts WHERE id = ? ;";
		
		try {
		       Class.forName("org.postgresql.Driver");
		       c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cmdb","postgres", "younes");
		       
		    } 
		    catch (Exception e) {
		       e.printStackTrace();
		       System.err.println(e.getClass().getName()+": "+e.getMessage());
		       System.exit(0);
		    }
		
		try {
			st = c.prepareStatement(delete) ;
			st.setInt(1, id);
			st.execute();
			System.out.println("Delete done  with Success ");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
}
