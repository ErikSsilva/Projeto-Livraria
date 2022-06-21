package projetoConexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LeitorDAO {
	
	
	
	
	public Connection conectaDB () {
		Connection conexao = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexao = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "");
			
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("ErroDBC"+e);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		return conexao;
	}

}
