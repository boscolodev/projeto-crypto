package br.com.boscolodev.projetocrypto.DAO;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import br.com.boscolodev.projetocrypto.DTO.ClientDetailDTO;
import br.com.boscolodev.projetocrypto.DatabaseConnection.ConexaoMySQL;

public class ClientDetailDAO {

	public void insertDetail(ClientDetailDTO clientDetailDTO) {

		String option = "s";
		Scanner scan = Scanner(System.in);

		Connection connection = ConexaoMySQL.getConexaoMySQL();
		while (option != "n") {
			System.out.println("Deseja Inserir uma nova moeda ? (s/n) ");
			option = scan.next();
			try {
				// Sql Client_Detail
				String clientDetail = "INSERT INTO CLIENT_DETAIL (ID_CLIENT, ID_CARTEIRA, ID_CRYPTO) "
						+ "VALUES (?,?,?)";

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

	private Scanner Scanner(InputStream in) {
		// TODO Auto-generated method stub
		return null;
	}
}
