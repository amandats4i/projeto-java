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

		Optional<Produto> produto = buscarNaCollection(numero);

		for (var p : listaProduto)
			if (produto.isPresent())
				produto.get().visualizar(); 
			else
				System.err.println("O pedido " + numero + " não foi encontrado.\n");

	}


	@Override
	public void listarTodas() {
		for (var produto : listaProduto) {
			produto.visualizar();
		}

	}

	@Override
	public void cadastrar(Produto numero) {
		listaProduto.add(numero);
		System.out.println("O Pedido número: " + numero.getNumero() + " foi criado com sucesso.");

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
		Optional<Produto> produto = buscarNaCollection(numero);

		if (produto.isPresent())
			
			if (listaProduto.remove(produto.get()) == true)
				System.out.println("O pedido numero: " + numero + " foi excluído com sucesso.\n");
			else
				System.err.println("O pedido numero " + numero + " não foi encontrado.\n");

	}

	public int gerarNumero() {
		return ++numero;
	}

	public Optional<Produto> buscarNaCollection(int numero) {

		for (var produto : listaProduto) {
			if (produto.getNumero() == numero)
				return Optional.of(produto);
		}
		return Optional.empty();

	}

}
