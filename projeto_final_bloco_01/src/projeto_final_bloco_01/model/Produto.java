package projeto_final_bloco_01.model;

public abstract class Produto {
	
	private String nome;
	private int produto;
	private int cor;
	private int tamanho;
	private int material;
	private int numero;
	
	public Produto(String nome, int produto, int cor, int tamanho, int material, int numero) {
		super();
		this.nome = nome;
		this.produto = produto;
		this.cor = cor;
		this.tamanho = tamanho;
		this.material = material;
		this.numero = numero;
	}
	
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getProduto() {
		return produto;
	}

	public void setProduto(int produto) {
		this.produto = produto;
	}

	public int getCor() {
		return cor;
	}

	public void setCor(int cor) {
		this.cor = cor;
	}

	public int getTamanho() {
		return tamanho;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}

	public int getMaterial() {
		return material;
	}

	public void setMaterial(int material) {
		this.material = material;
	}
	
	public void visualizar() {
		
		String produto = "";

		switch (this.produto) {
		case 1 -> produto = "Biquini";
		case 2 -> produto = "Maiô";
		
		}
	
		String cor = "";
		switch (this.cor) {
		case 1 -> cor = "Verde";
		case 2 -> cor = "Preto";
		
		}
		String material = "";
		switch (this.material) {
		case 1 -> material = "Elastano";
		case 2 -> material = "Poliamida";
		
		}
		String tamanho = "";
		switch (this.tamanho) {
		case 1 -> tamanho = "P";
		case 2 -> tamanho = "M";
		case 3 -> tamanho = "G";
		
		}

		System.out.println("\n\n*************************************");
		System.out.println("           Dados do Pedido:           ");
		System.out.println("*************************************");
		System.out.println("Numero do Pedido: " + this.numero);
		System.out.println("Cliente: " + this.nome);
		System.out.println("Produto: " + produto);
		System.out.println("Cor: " + cor);
		System.out.println("Tamanho: " + tamanho);
		System.out.println("Material: " + material);
	}

	
	
	}
	


