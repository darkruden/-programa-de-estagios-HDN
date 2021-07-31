import java.sql.SQLException;
import java.util.ArrayList;
import java.util.TreeSet;

public class CatalogoDeHerois {
	DaoHeroi daoHeroi = new DaoHeroi();
	DaoPoder daoPoder = new DaoPoder();

	public boolean adicionar(Heroi heroi) throws ValorInvalido, SQLException, PoderNaoExistente, HeroiJaExistente {

		if (heroi.getNome() == null || heroi.getDescricao() == null || heroi.getPoderes() == null)
			throw new ValorInvalido();
		try {
			pesquisarHeroiPeloNome(heroi.getNome());
			throw new HeroiJaExistente();

		} catch (HeroiNaoExistente e) {
			daoHeroi.inserir(heroi);
			for (String poder : heroi.getPoderes()) {
				Poder aux = new Poder(heroi.getIdHeroi(), poder);
				daoPoder.inserir(aux);
			}

			return true;
		}

	}

	public boolean adicionarPoder(String heroi, String poder)
			throws SQLException, PoderNaoExistente, HeroiNaoExistente, PoderJaExistente {

		Heroi heroiAux = pesquisarHeroiPeloNome(heroi);
		try {

			daoPoder.recuperar(poder, heroiAux.getIdHeroi());
			throw new PoderJaExistente();

		} catch (PoderNaoExistente e) {
			Poder poderAux = new Poder(heroiAux.getIdHeroi(), poder);
			daoPoder.inserir(poderAux);
			return true;
		}

	}

// lembre-se de colocar os elementos inseridos em ordem crescente

	public boolean alterarNome(String nome, String NovoNome) throws HeroiNaoExistente, SQLException, PoderNaoExistente {
		Heroi heroi = pesquisarHeroiPeloNome(nome);
		daoHeroi.alterarNome(NovoNome, heroi.getIdHeroi());
		return true;

	}

	public boolean alterarDescricao(String nome, String descricao)
			throws HeroiNaoExistente, SQLException, PoderNaoExistente {
		Heroi heroi = pesquisarHeroiPeloNome(nome);
		daoHeroi.alterarDescricao(descricao, heroi.getIdHeroi());
		return true;

	}

	public boolean substituirPoder(String nome, String poder, String novoPoder)
			throws SQLException, HeroiNaoExistente, PoderNaoExistente {
		Heroi heroi = pesquisarHeroiPeloNome(nome);
		Poder poderObj = daoPoder.recuperar(poder, heroi.getIdHeroi());

		daoPoder.alterar(poderObj, novoPoder);
		return true;
	}

	public Heroi pesquisarHeroiPeloNome(String nome) throws HeroiNaoExistente, SQLException, PoderNaoExistente {
		ArrayList<Heroi> herois = daoHeroi.recuperarTodos();
		for (Heroi heroi : herois) {
			if (heroi.getNome().equals(nome))
				return heroi;
		}

		throw new HeroiNaoExistente();
	}

	public boolean removerPoder(String nome, String poder) throws SQLException, HeroiNaoExistente, PoderNaoExistente {
		Heroi heroi = pesquisarHeroiPeloNome(nome);
		daoPoder.remover(nome, heroi.getIdHeroi());
		return true;
	}

	public void removerTodos() throws SQLException {
		daoHeroi.removerTodos();
		daoPoder.removerTodos();
	}

	public String listarTodosOSHerois() throws SQLException, HeroiNaoExistente, PoderNaoExistente {
		ArrayList<Heroi> herois = daoHeroi.recuperarTodos();
		String heroisAux = new String();
		heroisAux = "Herois: \n";
		for (Heroi heroi : herois) {
			heroisAux += heroi.getNome() + "||";

		}

		return heroisAux;
	}

	public String listarHeroisComPoderesSimilares(TreeSet<String> aux2)
			throws SQLException, HeroiNaoExistente, PoderNaoExistente {
		ArrayList<Heroi> herois = daoHeroi.recuperarTodos();
		String heroisAux = null;
		ArrayList<String> aux1 = new ArrayList<>();
		for (String string : aux2) {
			aux1.add(string);
		}
		int cont = 0;
		heroisAux = "Herois: \n";
		for (Heroi heroi : herois) {

			cont = 0;

			for (int i = 0; i < aux2.size(); i++) {

				if (heroi.getPoderes().contains(aux1.get(i))) {
					cont++;
				}
			}
			if (cont != 0)
				heroisAux += heroi.getNome() + "||";

		}

		return heroisAux;
	}
	public boolean excluirHeroi(String heroi) throws HeroiNaoExistente, SQLException, PoderNaoExistente {
		Heroi heroiAux= pesquisarHeroiPeloNome(heroi);
		daoHeroi.remover(heroiAux.getIdHeroi());
		return true;
	}
}
