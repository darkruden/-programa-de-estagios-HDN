import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.TreeSet;

public class DaoHeroi {
	public void inserir(Heroi a) throws SQLException {
		Connection con = Conexao.getConexao();

		String cmd = "insert into heroi (id_heroi, descricao, nome) values (" + a.getIdHeroi() + ", \'"
				+ a.getDescricao() + "\' , \'" + a.getNome() + "\')";
		System.out.println(cmd);
		Statement st = con.createStatement();
		st.executeUpdate(cmd);
		st.close();
	}

	public void alterarNome(String nome, int n) throws SQLException {
		Connection con = Conexao.getConexao();

		String cmd = "update heroi set nome = \'" + nome + "\' where id_heroi = " + n;
		Statement st = con.createStatement();
		st.executeUpdate(cmd);
		st.close();
	}

	public void alterarDescricao(String descricao, int n) throws SQLException {
		Connection con = Conexao.getConexao();

		String cmd = "update heroi set descricao = \'" + descricao + "\' where id_heroi = " + n;
		Statement st = con.createStatement();
		st.executeUpdate(cmd);
		st.close();
	}

	public void alterarPoderes(String descricao, int n) throws SQLException {
		Connection con = Conexao.getConexao();

		String cmd = "update heroi set descricao = \'" + descricao + "\' where id_heroi = " + n;
		Statement st = con.createStatement();
		st.executeUpdate(cmd);
		st.close();
	}

	public void remover(int n) throws SQLException {
		Connection con = Conexao.getConexao();
		String cmd = "delete from heroi where id_heroi = " + n;
		System.out.println(cmd);
		Statement st = con.createStatement();
		st.executeUpdate(cmd);
		st.close();
	}

	public void removerTodos() throws SQLException {
		Connection con = Conexao.getConexao();
		String cmd = "delete from heroi";
		System.out.println(cmd);
		Statement st = con.createStatement();
		st.executeUpdate(cmd);
		st.close();
	}

	@SuppressWarnings("unlikely-arg-type")
	public Heroi recuperar(int n) throws SQLException, HeroiNaoExistente, PoderNaoExistente {
		Connection con = Conexao.getConexao();
		// select * from associacao where numero = 2
		String cmd = "select * from heroi where id_heroi = " + n;
		System.out.println(cmd);
		Heroi a = null;
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(cmd);
		if (rs.next()) {
			int id = rs.getInt("id_heroi");
			String nome = rs.getString("nome");
			String descricao = rs.getString("descricao");
			a = new Heroi(nome, descricao, id);

		}
		st.close();
		if (a == null || a.equals(""))
			throw new HeroiNaoExistente();
		DaoPoder daoPoder = new DaoPoder();
		TreeSet<String> poderes = daoPoder.recuperarTodos(n);
		a.setPoderes(poderes);
		return a;
	}

	@SuppressWarnings({ "unlikely-arg-type" })
	public ArrayList<Heroi> recuperarTodos()  throws SQLException, HeroiNaoExistente, PoderNaoExistente {
		Connection con = Conexao.getConexao();
		String cmd = "select * from heroi";
		System.out.println(cmd);
		CatalogoDeHerois catalogo = new CatalogoDeHerois();
		Heroi a = null;
		TreeSet<String> poderes = new TreeSet<>();
		ArrayList<Heroi> heroisAux = new ArrayList<>();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(cmd);
		while (rs.next()) {
			int id = rs.getInt("id_heroi");
			String nome = rs.getString("nome");
			String descricao = rs.getString("descricao");
			a = new Heroi(nome, descricao, id);
			poderes = catalogo.daoPoder.recuperarTodos(id);
			a.setPoderes(poderes);
			heroisAux.add(a);

		}
		st.close();
		if (heroisAux == null || heroisAux.equals(""))
			throw new HeroiNaoExistente();

		return heroisAux;
	}

}
