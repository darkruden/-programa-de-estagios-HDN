
import java.util.TreeSet;

public class Heroi {
private String nome;
private String descricao;
private int idHeroi;
private TreeSet<String> poderes;
public void setNome(String nome) {
	this.nome = nome;
	poderes = null;
}

public Heroi(String nome, String descricao, int idHeroi) {
	super();
	this.nome = nome;
	this.descricao = descricao;
	this.idHeroi = idHeroi;
}

public String getNome() {
	return nome;
}
public String getDescricao() {
	return descricao;
}
public void setDescricao(String descricao) {
	this.descricao = descricao;
}
public TreeSet<String> getPoderes() {
	return poderes;
}
public void setPoderes(TreeSet<String> poderes) {
	this.poderes = poderes;
}
public int getIdHeroi() {
	return idHeroi;
}
public void setIdHeroi(int idHeroi) {
	this.idHeroi = idHeroi;
}

}
