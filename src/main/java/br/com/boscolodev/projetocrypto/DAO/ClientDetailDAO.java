package br.com.boscolodev.projetocrypto.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import br.com.boscolodev.projetocrypto.DTO.ClientDetailDTO;
import br.com.boscolodev.projetocrypto.DatabaseConnection.ConexaoMySQL;

public class ClientDetailDAO {

	public void insertDetail(ClientDetailDTO clientDetailDTO) {

		Connection connection = ConexaoMySQL.getConexaoMySQL();

		try {
			// Sql Client_Detail
			String clientDetail = "INSERT INTO CLIENT_DETAIL (ID_CLIENT, ID_CARTEIRA, ID_CRYPTO) " + "VALUES (?,?,?)";

			PreparedStatement preparedStatementDetail = connection.prepareStatement(clientDetail);
			preparedStatementDetail.setLong(1, clientDetailDTO.getId_Client());
			preparedStatementDetail.setLong(2, clientDetailDTO.getId_Carteira());
			preparedStatementDetail.setLong(3, clientDetailDTO.getId_Crypto());

			preparedStatementDetail.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
