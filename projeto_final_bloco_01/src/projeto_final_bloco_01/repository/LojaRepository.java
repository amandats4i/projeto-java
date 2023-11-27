package projeto_final_bloco_01.repository;

import projeto_final_bloco_01.model.Produto;

public interface LojaRepository {
	
	public void procurarPorNumero (int numero);
	public void listarTodas();
	public void cadastrar (Produto numero);
	public void atualizar (Produto numero);
	public void deletar (int numero);

}
