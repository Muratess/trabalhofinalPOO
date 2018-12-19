package swing.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProfessorDAO implements GenericDAO<Aluno> {

	public Connection getConnection() throws SQLException {
		// url do banco
		String url = "jdbc:h2:C:\\Users\\Usuário\\eclipse-workspace\\Swing\\lib\\database";

		// usuário do banco
		// String user = "";
		// Senha do banco
		// String password = "";

		// Class.forName("org.h2.Driver");
		return DriverManager.getConnection(url);
	}

	@Override
	public void insert(Aluno e) {
		// TODO Auto-generated method stub

		try (Connection con = getConnection()) {
			String sql = "insert into contato (nome, telefone, endereco, modalidade, cpf) values (?, ?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, e.getNome());
			ps.setString(2, e.getTelefone());
			ps.setString(3, e.getEndereco());
			ps.setString(4, e.getModalidade());
			ps.setString(5, e.getCpf());
			ps.executeUpdate();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public Aluno select(long id) {

		String sql = "select * from aluno where id = ?";

		try (Connection con = getConnection()) {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, id);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				Aluno c = new Aluno();
				c.setId(rs.getLong("id"));
				c.setNome(rs.getString("nome"));
				c.setTelefone(rs.getString("telefone"));
				c.setEndereco(rs.getString("endereco"));
				c.setModalidade(rs.getString("modalidade"));
				c.setCpf(rs.getString("cpf"));
				return c;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<Aluno> select() {
		ArrayList<Aluno> lista = new ArrayList<Aluno>();

		String sql = "select * from contato";

		try (Connection con = getConnection()) {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Aluno c = new Aluno();
				c.setId(rs.getLong("id"));
				c.setNome(rs.getString("nome"));
				c.setTelefone(rs.getString("telefone"));
				c.setEndereco(rs.getString("endereco"));
				c.setModalidade(rs.getString("modalidade"));
				c.setCpf(rs.getString("cpf"));
				lista.add(c);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lista;
	}

	@Override
	public void update(Aluno e) {
		String sql = "update aluno " + "set nome = ?, telefone = ?, set cpf = ?, set modalidade = ?, set endereco =? " + "where id = ?";
		try (Connection con = getConnection()) {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, e.getNome());
			ps.setString(2, e.getTelefone());
			ps.setLong(3, e.getId());
			ps.setString(4, e.getEndereco());
			ps.setString(5, e.getModalidade());
			ps.setString(6, e.getCpf());
			ps.executeUpdate();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

	}

	@Override
	public void delete(Aluno e) {
		String sql = "delete from aluno where id = ?";
		try (Connection con = getConnection()) {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, e.getId());
			ps.executeUpdate();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

}
