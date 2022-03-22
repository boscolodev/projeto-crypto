package br.com.boscolodev.projetocrypto.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.boscolodev.projetocrypto.DTO.ClientDTO;
import br.com.boscolodev.projetocrypto.DTO.ClientDetailDTO;
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
			preparedStatementClient.setString(2, clientDTO.getEmail());
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
			String clientSQL = "SELECT ID_CLIENT FROM CLIENT WHERE EMAIL = ?";

			PreparedStatement preparedStatement = connection.prepareStatement(clientSQL);
			preparedStatement.setString(1, clientDTO.getEmail());
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

	public void listarClient() {

		try {

			Connection connection = ConexaoMySQL.getConexaoMySQL();
			String sqlClient = "SELECT * FROM CLIENT";
			String sqlDetail = "SELECT * FROM CLIENT_DETAIL";

			PreparedStatement statementClient = connection.prepareStatement(sqlClient);
			PreparedStatement statementDetail = connection.prepareStatement(sqlDetail);

			ResultSet resultSetClient = statementClient.executeQuery();
			ResultSet resultSetDetail = statementDetail.executeQuery();

			while (resultSetClient.next() && resultSetDetail.next()) {
				ClientDTO clientDTO = new ClientDTO();
				clientDTO.setId(resultSetClient.getLong("ID_CLIENT"));
				clientDTO.setNome(resultSetClient.getString("NOME"));
				clientDTO.setEmail(resultSetClient.getString("EMAIL"));
				clientDTO.setId_Crypto(resultSetClient.getLong("ID_CLIENT_DETAIL"));
				clientDTO.setId_Carteira(resultSetClient.getLong("ID_CARTEIRA"));
				clientDTO.setDt_Cadastro(resultSetClient.getString("DT_CADASTRO"));

				System.out.println("Id Cliente: " + resultSetClient.getLong("ID_CLIENT") + " Nome: "
						+ resultSetClient.getNString("NOME") + " Email: " + resultSetClient.getNString("EMAIL")
						+ " ID Detalhe: " + resultSetClient.getLong("ID_CLIENT_DETAIL") + " ID Carteira: "
						+ resultSetClient.getLong("ID_CARTEIRA") + " DT_CADASTRO:"
						+ resultSetClient.getString("DT_CADASTRO"));

				ClientDetailDTO clientDetailDTO = new ClientDetailDTO();
				clientDetailDTO.setId(resultSetDetail.getLong("ID_CLIENT_DETAIL"));
				clientDetailDTO.setId_Client(resultSetDetail.getLong("ID_CLIENT"));
				clientDetailDTO.setId(resultSetDetail.getLong("ID_CARTEIRA"));
				clientDetailDTO.setId(resultSetDetail.getLong("ID_CRYPTO"));

				System.out.println(" ID Cliente Detail: " + resultSetDetail.getLong("ID_CLIENT_DETAIL")
						+ " ID Cliente Detail: " + resultSetDetail.getLong("ID_CLIENT") + " ID_Carteira Detail: "
						+ resultSetDetail.getLong("ID_CARTEIRA") + " ID Crypto Detail: "
						+ resultSetDetail.getLong("ID_CRYPTO"));

			}

			connection.close();
		} catch (

		Exception e) {
			e.printStackTrace();
		}
	}

}
