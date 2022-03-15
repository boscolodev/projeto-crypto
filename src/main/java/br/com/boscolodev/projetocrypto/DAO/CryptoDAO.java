package br.com.boscolodev.projetocrypto.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.boscolodev.projetocrypto.DTO.CryptoDTO;
import br.com.boscolodev.projetocrypto.DatabaseConnection.ConexaoMySQL;

public class CryptoDAO {

	public void insertCrypto(CryptoDTO cryptoDTO) {
		Connection connection = ConexaoMySQL.getConexaoMySQL();
		try {

			// Sql de comando
			String sql = ("INSERT INTO CRYPTO(REDE, SIGLA)" + "VALUES(?,?)");

			// Realiza a execução do código SQL
			PreparedStatement statement = connection.prepareStatement(sql);

			// Informando os paremetros de posição e dados para ?
			statement.setString(1, cryptoDTO.getRede());
			statement.setString(2, cryptoDTO.getSigla());

			statement.execute();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteCrypto(Long id) {
		Connection connection = ConexaoMySQL.getConexaoMySQL();
		try {

			// Sql de comando
			String sql = ("DELETE FROM CRYPTO WHERE = ID = ?");

			// Realiza a execução do código SQL
			PreparedStatement statement = connection.prepareStatement(sql);

			// Informando os paremetros de posição e dados para ?
			statement.setLong(1, id);

			statement.execute();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<CryptoDTO> listAll() {
		List<CryptoDTO> cryptoDTO = new ArrayList<CryptoDTO>();

		try {

			Connection connection = ConexaoMySQL.getConexaoMySQL();
			String sql = "SELECT * FROM CRYPTO";

			PreparedStatement statement = connection.prepareStatement(sql);

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				CryptoDTO cryptoDTO1 = new CryptoDTO();
				cryptoDTO1.setRede(resultSet.getString("REDE"));
				cryptoDTO1.setSigla(resultSet.getString("SIGLA"));
				cryptoDTO1.setDt_cadastro(resultSet.getString("DT_CADASTRO"));
				cryptoDTO.add(cryptoDTO1);
			}
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cryptoDTO;
	}

	public Object listByName(String sigla) {
		CryptoDTO cryptoDTO = new CryptoDTO();

		try {

			Connection connection = ConexaoMySQL.getConexaoMySQL();
			String sql = "SELECT ID, REDE, SIGLA FROM CRYPTO WHERE SIGLA = ?";

			PreparedStatement statement = connection.prepareStatement(sql);

			ResultSet resultSet = statement.executeQuery();

			cryptoDTO.setRede(resultSet.getString("REDE"));
			cryptoDTO.setSigla(resultSet.getString("SIGLA"));
			cryptoDTO.setDt_cadastro(resultSet.getString("DT_CADASTRO"));
			statement.setString(1, sigla);

			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cryptoDTO;
	}

	public void updateCrypto(CryptoDTO cryptoDTO) {
		try {
			Connection connection = ConexaoMySQL.getConexaoMySQL();
			String sql = "UPDATE CRYPTO SET REDE = ?, SIGLA = ? WHERE ID = ?";

			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(1, cryptoDTO.getRede());
			statement.setString(2, cryptoDTO.getSigla());
			statement.setLong(3, cryptoDTO.getId());

			statement.execute();
			statement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
