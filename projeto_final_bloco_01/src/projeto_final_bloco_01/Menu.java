package projeto_final_bloco_01;

import java.io.IOException;
import java.util.Optional;
import java.util.Scanner;

import projeto_final_bloco_01.model.Produto;
import projeto_final_bloco_01.model.Biquini;
import projeto_final_bloco_01.model.Maio;
import projeto_final_bloco_01.controller.LojaController;

public class Menu {

	static Scanner leia = new Scanner(System.in);

	public static void main(String[] args) {

		int opcao, produto, modelo, cor, tamanho, material, numero;
		String nome;

		LojaController produtos = new LojaController();
		Biquini b1 = new Biquini ("Maria", 1, 1, 1, 1, 1,1);
		b1.visualizar();
		produtos.cadastrar(b1);
		

		while (true) {

			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("                BIQUINIS SONNEN LTDA.                ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("            1 - Criar Pedido                          ");
			System.out.println("            2 - Listar todos os Pedidos               ");
			System.out.println("            3 - Buscar Pedido por Numero              ");
			System.out.println("            4 - Atualizar Pedido                      ");
			System.out.println("     	    5 - Deletar Pedido                        ");
			System.out.println("            6 - Sair                                  ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("Por favor, digite a opção desejada:                  ");

			opcao = leia.nextInt();

			if (opcao == 6) {
				System.out.println("\nAtendimento encerrado. Obrigada por escolher a BIQUINIS SONNEN LTDA.");
				sobre();
				leia.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:

				System.out.println("CRIAR PEDIDO: ");

				System.out.println("Digite seu nome completo: ");
				nome = leia.next();

				System.out.println("Digite o produto desejado: 1 - Biquini  | 2 - Maiô");
				produto = leia.nextInt();
				


				System.out.println("Digite a cor da peça:  1 - Verde | 2 - Preto");
				cor = leia.nextInt();

				System.out.println("Digite o tamanho da peça: 1 - P | 2 - M | 3 - G");
				tamanho = leia.nextInt();

				System.out.println("Por último, digite o material da peça: 1 - Elastano | 2 - Poliamida");
				material = leia.nextInt();

				switch (produto) {
				
				case 1 -> { 
					System.out.println("Digite o modelo de biquini desejado: 1 - Cortininha  |  2 - Meia-Taça");
					modelo = leia.nextInt();
					produtos.cadastrar(new Biquini (nome, produto,  cor,  tamanho,  material, produtos.gerarNumero(),  modelo));
				}
				
				case 2 -> {
					produtos.cadastrar(new Maio (nome, produto,  cor,  tamanho,  material, produtos.gerarNumero()));
				}
				}
				
				System.out.println("Pedido adicionado com sucesso <3");
				
				
				
				keyPress();
				break;

			case 2:
				System.out.println("Listar todos os Pedidos\n\n");
				produtos.listarTodas();
				keyPress();
				break;

			case 3:
				System.out.println("Consultar dados do Pedido - por número\n\n");
				System.out.println("Digite o numero do Pedido: ");
				numero = leia.nextInt();
				produtos.procurarPorNumero(numero);
				keyPress();
				break;

			case 4:
				System.out.println("Atualizar dados da Conta\n\n");
				System.out.println("Digite do numero do pedido: ");
				numero = leia.nextInt();
				
				Optional<Produto> buscaProduto = produtos.buscarNaCollection(numero);

				if (buscaProduto.isPresent()) {

					System.out.println("Digite seu nome: ");
					leia.skip("\\R");
					nome = leia.nextLine();
					
					tamanho = buscaProduto.get().getNumero();
					
					produto = buscaProduto.get().getProduto();
					
					cor = buscaProduto.get().getCor();
					
					material = buscaProduto.get().getMaterial();
					
					System.out.println("Digite o modelo desejado: 1 - Cortininha  |  2 - Meia-Taça");
					modelo = leia.nextInt();
					
					switch (tamanho) {
					case 1 -> {
						System.out.println("Digite o tamanho desejado: ");
						tamanho = leia.nextInt();
						produtos.atualizar(new Biquini(nome, produto, cor, tamanho, material, numero, modelo));
					}
					case 2 -> {
						System.out.println("Digite a cor desejada: ");
						cor = leia.nextInt();
						produtos.atualizar(new Biquini(nome, produto, cor, tamanho, material, numero, modelo));
					}
					}

				} else
					System.err.println("O pedido numero: " + numero + " nao foi encontrado.");

				keyPress();
				break;

			case 5:
				System.out.println("Deletar Pedido\n\n");
				System.out.println("Digite do numero do pedido: ");
				numero = leia.nextInt();
				produtos.deletar(numero);
				keyPress();
				break;

			default:
				System.out.println("\nOpção Inválida!\n");
				keyPress();
				break;
			}

		}

	}

	public static void sobre() {
		System.out.println("**********************************");
		System.out.println("Projeto desenvolvido por: Amanda Tsai");
		System.out.println("Contato: amandatsai16@gmail.com");
		System.out.println("https://github.com/amandats4i");
		System.out.println("**********************************");
	}

	public static void keyPress() {

		try {
			System.out.println("Pressione ENTER para continuar.");
			System.in.read();
		} catch (IOException e) {
			System.out.println("Você pressionou uma tecla inválida.");
		}

	}

}
