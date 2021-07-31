import java.sql.SQLException;
import java.util.Scanner;
import java.util.TreeSet;


public class AppHeroi {
	public static void main(String[] args) throws ValorInvalido, SQLException, HeroiNaoExistente, PoderNaoExistente,
			PoderJaExistente, HeroiJaExistente {
		CatalogoDeHerois catalogo = new CatalogoDeHerois();
		String nome;
		int id;
		String descricao;
		Scanner ler = new Scanner(System.in);
		String cmd = "1. Adicionar Heroi \n2. Listar todos os Herois \n3. Pesquisar Herois pelos poderes \n4. Editar Heroi \n5 Excluir Heroi \n6. Sair\n";
		int op = 0;
		while (op != 6) {
			System.out.print(cmd);
			op = ler.nextInt();
			switch (op) {
			// Cadastra um Herói com um ou mais poderes
			case 1:
				TreeSet<String> aux = new TreeSet<>();
				System.out.println("Digite um id para seu Heroi: ");
				id = ler.nextInt();
				ler = new Scanner(System.in);
				System.out.println("Digite o nome do Heroi: ");
				nome = ler.nextLine();
				System.out.println("Digite a descricao do heroi: ");
				descricao = ler.nextLine();

				System.out.println("Digite os poderes do heroi separados por virgula Ex: (Força,Inteligencia): ");
				String poderes = ler.nextLine();
				String[] AuxString = poderes.split(",");
				for (String string : AuxString) {
					aux.add(string);
				}

				Heroi heroi = new Heroi(nome, descricao, id);
				heroi.setPoderes(aux);
				catalogo.adicionar(heroi);

				break;
			// Lista todos os Herois cadastrados no Catálogo
			case 2:
				System.out.println(catalogo.listarTodosOSHerois());
				;

				break;
				// Lista todos os Herois com pelo menos um poder de semelhança
			case 3:
				TreeSet<String> aux2 = null;

				ler = new Scanner(System.in);
				aux2 = new TreeSet<>();
				System.out.println(
						"Por favor digite os poderes que dejesa encontrar nos herois (Separados por virgula EX:(Inteligencia,Gelo)): ");
				String nomeDoPoder = ler.nextLine();
				AuxString = nomeDoPoder.split(",");
				for (String string : AuxString) {
					aux2.add(string);
				}
				System.out.println(catalogo.listarHeroisComPoderesSimilares(aux2));
				break;
				//Possibilita alterar todos os dados do Heroi, exceto seu id.
			case 4:
				System.out.println("O que você deseja altearar no heroi: \n1. Nome. \n2. Descricao. \n3. Poderes.");
				op = ler.nextInt();
				if (op == 1) {
					System.out.println("Digite o nome do Heroi que você quer alterar: ");
					ler = new Scanner(System.in);
					String nomeAtual = ler.nextLine();
					System.out.println("Digite o novo nome: ");
					String NovoNome = ler.nextLine();
					catalogo.alterarNome(nomeAtual, NovoNome);
				} else if (op == 2) {
					System.out.println("Digite o nome do Heroi que você quer alterar: ");
					ler = new Scanner(System.in);
					String nomeAtual = ler.nextLine();
					System.out.println("Digite a nova descricao: ");
					String NovaDescricao = ler.nextLine();
					catalogo.alterarDescricao(nomeAtual, NovaDescricao);
				} else if (op == 3) {
					System.out.println("Digite o nome do Heroi que você quer alterar: ");
					ler = new Scanner(System.in);
					String nomeAtual = ler.nextLine();
					System.out.println("Voce deseja (1)remover, (2)substituir, ou (3)adicionar um novo poder? ");
					op = ler.nextInt();
					if (op == 1) {
						while (op != -1) {
							System.out.println("Digite o poder que deseja remover: ");
							ler = new Scanner(System.in);
							String poder = ler.nextLine();

							catalogo.removerPoder(nomeAtual, poder);

							System.out.println("Deseja remover mais um poder ?  (1)SIM (-1)NAO");
							op = ler.nextInt();
							if (op == 1) {
								continue;
							} else
								break;
						}
					} else if (op == 2) {
						while (op != -1) {
							System.out.println("Digite o poder que deseja substituir: ");
							ler = new Scanner(System.in);
							String poder = ler.nextLine();
							System.out.println("Digite o novo nome: ");
							String novoPoder = ler.nextLine();
							catalogo.substituirPoder(nomeAtual, poder, novoPoder);

							System.out.println("Deseja substituir mais um poder ?  (1)SIM (-1)NAO");
							op = ler.nextInt();
							if (op == 1) {
								continue;
							} else
								break;
						}
					} else if (op == 3) {
						while (op != -1) {
							System.out.println("Digite o poder que deseja adicionar: ");
							ler = new Scanner(System.in);
							String poder = ler.nextLine();

							catalogo.adicionarPoder(nomeAtual, poder);

							System.out.println("Deseja adicionar mais um poder ? (1)SIM (-1)NAO");
							op = ler.nextInt();
							if (op == 1) {
								continue;
							} else
								break;
						}

					}
				}
				break;
			case 5:
				System.out.println("Digite o nome do Heroi que deseja excluir:");
				ler= new Scanner(System.in);
				String nomeDoHeroi = ler.nextLine();
				if(catalogo.excluirHeroi(nomeDoHeroi))
					System.out.println("Heroi excluido com sucesso");
				break;
			case 6:
				break;
			default:
				break;
			}
		}
		ler.close();
	}
}
