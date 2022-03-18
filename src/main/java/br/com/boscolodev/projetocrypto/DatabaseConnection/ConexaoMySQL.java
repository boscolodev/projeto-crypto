package br.com.boscolodev.projetocrypto.DatabaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMySQL {

	public static String status = "Não conectou";

	
	private static final String USUARIO = "root";
	private static final String SENHA = "123456";
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/crypto";
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

	public ConexaoMySQL() {
		
	}
	
	
	//Método de Conexão
	public static java.sql.Connection getConexaoMySQL() {
		
		
		Connection connection = null;
		
		try {
			
			//Carregar JDBC Driver
			Class.forName(DRIVER);
			
			connection = DriverManager.getConnection(URL,USUARIO,SENHA);
			
			//Testar a conexão
			if (connection != null) {
				status = ("STATUS ----> Conectado com Sucesso!");
			}else {
				status = ("STATUS ----> Falha na Conexão!");
			}
		
			return connection;
			
		}catch(ClassNotFoundException e) { //Em Caso de Driver Não encontrado
			System.out.println("O driver específicado não foi encontrado.");
			return null;
		}catch (SQLException e) {
			System.out.println("Não foi possível conectar ao banco de dados.");
			System.out.println("Exceção: "+e);
			return null;
		}
		
    }

	
	public static String statusConexao() {
		return status;
	}

	public static boolean fecharConexao() {
		try {
			ConexaoMySQL.getConexaoMySQL().close();
			return true;
		}catch (SQLException e) {
			return false;
		}
	}


}
	
/*	
	// Conectar ao banco
    public static Connection abrir() throws Exception {
        // Registrar o driver
        Class.forName(DRIVER);
        // Capturar a conexão
        Connection conn = DriverManager.getConnection(URL, USUARIO, SENHA);
        // Retorna a conexao aberta
        return conn;

    }
	*/
