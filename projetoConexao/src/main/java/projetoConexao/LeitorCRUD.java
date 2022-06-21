package projetoConexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LeitorCRUD {
	
	static LeitorDAO dao = new LeitorDAO();
	static Connection conexao = dao.conectaDB();
	
	public static void main(String[] args) {
		//criarLeitor("joão");
		//atualizarLeitor(2, "John");
		excluirLeitor(2);
		
		listarLeitor();
	
		
	}

	public static void criarLeitor(String Leitor) {
		try {
			PreparedStatement prep = conexao.prepareStatement("INSERT INTO Leitor (idLeitor, nome, email, telefone) VALUES(null, ?, ?, ?)");
			prep.setString(1, Leitor);
			prep.setString(2, "J@gmail.com");
			prep.setString(3, "08397650964");
			prep.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
	}
	
	public static void listarLeitor() {
		ResultSet Leitor;
		try {
			Leitor = conexao.createStatement().executeQuery("SELECT * FROM Leitor");
			while(Leitor.next()) {
				System.out.println(Leitor.getInt("idLeitor")+ "/" +Leitor.getString("nome")+"/" +Leitor.getString("email")+"/" +Leitor.getString("telefone"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public static void atualizarLeitor(int id, String Leitor) {
		try {
			PreparedStatement prep = conexao.prepareStatement("UPDATE Leitor SET nome = ? WHERE idLeitor = ?;");
			prep.setString(1, Leitor);
			prep.setInt(2, id);
			prep.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		
	}


	public static void excluirLeitor(int id) {
		try {
			PreparedStatement prep = conexao.prepareStatement("DELETE FROM Leitor WHERE idLeitor = ?;");
			prep.setInt(1, id);
			prep.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	
	
	
}
