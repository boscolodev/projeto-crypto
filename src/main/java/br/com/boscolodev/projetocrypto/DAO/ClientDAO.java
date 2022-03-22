package br.com.boscolodev.projetocrypto.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.boscolodev.projetocrypto.DTO.ClientDTO;
import br.com.boscolodev.projetocrypto.DatabaseConnection.ConexaoMySQL;

public class ClientDAO {

	public void insertClient(ClientDTO clientDTO) {

		Connection connection = ConexaoMySQL.getConexaoMySQL();

		try {

			connection.setAutoCommit(false);

			// Sql Client
			String clientSQL = "INSERT INTO CLIENT (NOME, EMAIL, ID_CARTEIRA, ID_CLIENT_DETAIL, "
					+ "DT_CADASTRO) VALUES (?,?,?,?,?)";

			PreparedStatement preparedStatementClient = connection.prepareStatement(clientSQL);

			preparedStatementClient.setString(1, clientDTO.getNome());
			preparedStatementClient.setString(2, clientDTO.getNome());
			preparedStatementClient.setLong(3, clientDTO.getId_Carteira());
			preparedStatementClient.setLong(4, clientDTO.getId_Crypto());
			preparedStatementClient.setString(5, clientDTO.getDt_Cadastro());

			preparedStatementClient.execute();
			connection.commit();
			connection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public Long retornoIdClient(ClientDTO clientDTO) {

		Connection connection = ConexaoMySQL.getConexaoMySQL();
		Long x = 0L;
		
		try {

			// Sql Client
			String clientSQL = "SELECT ID_CLIENT FROM CLIENT WHERE NOME = ?";

			PreparedStatement preparedStatement = connection.prepareStatement(clientSQL);
			preparedStatement.setString(1, clientDTO.getNome());
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				ClientDTO clientDTOID = new ClientDTO();
				clientDTOID.setId(resultSet.getLong("ID_CLIENT"));
				x = clientDTOID.getId();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return x;
	}

}
