package projeto_final_bloco_01.model;

public class Biquini extends Produto{
	
	private int modelo;

	public int getModelo() {
		return modelo;
	}

	public void setModelo(int modelo) {
		this.modelo = modelo;
	}

	public Biquini(String nome, int produto, int cor, int tamanho, int material, int numero, int modelo) {
		super(nome, produto, cor, tamanho, material, numero);
		
		this.modelo = modelo;
		
	}
	
	public void visualizar() {
	String tipo = "";
	
	switch (this.modelo) {
	case 1 -> tipo = "Cortininha";
	case 2 -> tipo = "Meia-taça";
	
	}
	
	

}
}
