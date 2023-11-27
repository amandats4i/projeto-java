package projeto_final_bloco_01.controller;

import java.util.ArrayList;
import java.util.Optional;

import projeto_final_bloco_01.model.Produto;
import projeto_final_bloco_01.repository.LojaRepository;

public class LojaController implements LojaRepository {

	private ArrayList<Produto> listaProduto = new ArrayList<Produto>();

	int numero = 0;

	@Override
	public void procurarPorNumero(int numero) {

		Optional<Produto> produtos = buscarNaCollection(numero);

			if (produtos.isPresent())
				produtos.get().visualizar(); 
			else
				System.err.println("O pedido " + numero + " não foi encontrado.\n");

	}


	@Override
	public void listarTodas() {
		for (var produtos : listaProduto) {
			produtos.visualizar();
		}

	}

	@Override
	public void cadastrar(Produto produto) {
		listaProduto.add(produto);
		System.out.println("O Pedido número: " + produto.getNumero() + " foi criado com sucesso.");

	}

	@Override
	public void atualizar(Produto numero) {
		
		Optional<Produto> buscaProduto = buscarNaCollection(numero.getNumero());

		if (buscaProduto.isPresent()) {
			listaProduto.set((listaProduto.indexOf(buscaProduto.get())), numero);
			System.out.println("O pedido numero: " + numero.getNumero() + " foi atualizado com sucesso.\n");
		} else
			System.err.println("O pedido numero " + numero.getNumero() + " não foi encontrado.\n");

	}

	@Override
	public void deletar(int numero) {
		Optional<Produto> produtos = buscarNaCollection(numero);

		if (produtos.isPresent())
			
			if (listaProduto.remove(produtos.get()) == true)
				System.out.println("O pedido numero: " + numero + " foi excluído com sucesso.\n");
			else
				System.err.println("O pedido numero " + numero + " não foi encontrado.\n");

	}

	public int gerarNumero() {
		return ++numero;
	}

	public Optional<Produto> buscarNaCollection(int numero) {

		for (var produtos : listaProduto) {
			if (produtos.getNumero() == numero)
				return Optional.of(produtos);
		}
		return Optional.empty();

	}


	}




