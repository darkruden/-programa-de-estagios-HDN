

import java.sql.SQLException;

import java.util.TreeSet;

import org.junit.jupiter.api.Test;

public class TesteCatalogoDeHEROI {
	CatalogoDeHerois catalogo = new CatalogoDeHerois();
@Test
public void testarCadastrarHeroi () throws SQLException, ValorInvalido, PoderNaoExistente, HeroiJaExistente {
	catalogo.removerTodos();
	Heroi heroi = new Heroi("Eduardo", "Lindo", 2);
	TreeSet<String> poderes = new TreeSet<String>();
	poderes.add("Agua");
	poderes.add("Vento");
	heroi.setPoderes(poderes);
	catalogo.adicionar(heroi);
	

	
}
@Test
public void testarCadastrarHeroiComOMesmoNome () throws SQLException, ValorInvalido, PoderNaoExistente, HeroiJaExistente {
	catalogo.removerTodos();
	Heroi heroi = new Heroi("Eduardo", "Lindo", 2);
	TreeSet<String> poderes = new TreeSet<String>();
	poderes.add("Agua");
	poderes.add("Vento");
	heroi.setPoderes(poderes);
	catalogo.adicionar(heroi);
	Heroi heroi2 = new Heroi("Eduardo", "Lindo", 3);
	TreeSet<String> poderes2 = new TreeSet<String>();
	try {
		poderes2.add("Agua");
		poderes2.add("Vento");
		heroi2.setPoderes(poderes2);
		catalogo.adicionar(heroi2);
		
	} catch (HeroiJaExistente e) {
		System.out.println("Teste passou");
	}
	

	
}
@Test
public void TestarCadastrarPoder() throws SQLException, ValorInvalido, PoderNaoExistente, HeroiJaExistente {
	catalogo.removerTodos();
	Heroi heroi = new Heroi("Eduardo", "Lindo", 2);
	TreeSet<String> poderes = new TreeSet<String>();
	poderes.add("Agua");
	poderes.add("Vento");
	poderes.add("Lança bosta");
	heroi.setPoderes(poderes);
	catalogo.adicionar(heroi);
	Poder poder = new Poder(2, "Fodao");
	catalogo.daoPoder.alterar(poder, "Lança bosta");
	
}
@Test
public void TestarAlterarNome() throws SQLException, ValorInvalido, HeroiNaoExistente, PoderNaoExistente, HeroiJaExistente {
	catalogo.removerTodos();
	Heroi heroi = new Heroi("Eduardo", "Lindo", 2);
	TreeSet<String> poderes = new TreeSet<String>();
	poderes.add("Agua");
	poderes.add("Vento");
	poderes.add("Lança bosta");
	heroi.setPoderes(poderes);
	catalogo.adicionar(heroi);
	catalogo.alterarNome("Eduardo", "Eduardooo");
}



}


