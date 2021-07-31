import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.TreeSet;



public class DaoPoder {
	public void inserir(Poder a) throws SQLException {
		Connection con = Conexao.getConexao();
	
		String cmd = "insert into poder (id_heroi, poder) values (" + a.getId() + ", \'" + a.getPoder() + "\')";
		System.out.println(cmd);
		Statement st = con.createStatement();
		st.executeUpdate(cmd);
		st.close();
	}
	
	public void alterar(Poder a, String poder) throws SQLException {
		Connection con = Conexao.getConexao();
		
		String cmd = "update poder set poder = \'"+ a.getPoder()+ "\' where id_heroi = " + a.getId();
		Statement st = con.createStatement();
		
	    st.executeUpdate(cmd);
	    st.close();
	}
	public void remover(String poder,int n) throws SQLException {
		Connection con = Conexao.getConexao();
		String cmd = "delete from poder where id_heroi =" + n + "AND poder = "+ poder;
		System.out.println(cmd);
		Statement st = con.createStatement();
	    st.executeUpdate(cmd);
	    st.close();
	}
	@SuppressWarnings("unlikely-arg-type")
	public Poder recuperar(String poder ,int n) throws SQLException, PoderNaoExistente{
		Connection con = Conexao.getConexao();
	
		String cmd = "select * from poder where poder = \'" + poder + "\' AND id_heroi = "+n;
		System.out.println(cmd);
		Poder poderObj = null;
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(cmd);
		if (rs.next()) {
			String poderAux = rs.getString("poder");
			int id = rs.getInt("id_heroi");
			 poderObj = new Poder(id, poderAux);
		}
		st.close();
		if (poderObj == null || poderObj.equals(""))
			throw new PoderNaoExistente();
		return poderObj;
	
}
	@SuppressWarnings({ "unlikely-arg-type", "unused" })
	public TreeSet<String> recuperarTodos(int n) throws SQLException, PoderNaoExistente{
		Connection con = Conexao.getConexao();
	
		String cmd = "select * from poder where id_heroi = " + n;
		System.out.println(cmd);
		TreeSet<String> poderes =  new TreeSet<>();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(cmd);
		while (rs.next()) {
			String poder = rs.getString("poder");
			poderes.add(poder);
		}
		st.close();
		if (poderes == null || poderes.equals(""))
			throw new PoderNaoExistente();
		return poderes;
	
}
	@SuppressWarnings({ "unlikely-arg-type", "unused" })
	public TreeSet<String> recuperarTodosAbsoluto() throws SQLException, PoderNaoExistente{
		Connection con = Conexao.getConexao();
	
		String cmd = "select * from poder";
		System.out.println(cmd);
		TreeSet<String> poderes =  new TreeSet<>();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(cmd);
		while (rs.next()) {
			String poder = rs.getString("poder");
			poderes.add(poder);
		}
		st.close();
		if (poderes == null || poderes.equals(""))
			throw new PoderNaoExistente();
		return poderes;
	
}
	public void removerTodos() throws SQLException {
		Connection con = Conexao.getConexao();
		String cmd = "delete from poder";
		System.out.println(cmd);
		Statement st = con.createStatement();
	    st.executeUpdate(cmd);
	    st.close();
	}
}
