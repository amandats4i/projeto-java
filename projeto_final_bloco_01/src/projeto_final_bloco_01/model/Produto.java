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
		String tipo = "";

		switch (this.produto) {
		case 1 -> tipo = "Biquini";
		case 2 -> tipo = "Maiô";
		
		}
	
		
		switch (this.cor) {
		case 1 -> tipo = "Verde";
		case 2 -> tipo = "Preto";
		
		}
		
		switch (this.produto) {
		case 1 -> tipo = "Biquini";
		case 2 -> tipo = "Maiô";
		
		}
		
		switch (this.tamanho) {
		case 1 -> tipo = "P";
		case 2 -> tipo = "M";
		case 3 -> tipo = "G";
		
		}

		System.out.println("\n\n*************************************");
		System.out.println("           Dados do Pedido:           ");
		System.out.println("*************************************");
		System.out.println("Numero do Pedido: " + this.numero);
		System.out.println("Cliente: " + this.nome);
		System.out.println("Produto: " + this.produto);
		System.out.println("Cor: " + this.cor);
		System.out.println("Tamanho: " + this.tamanho);
		System.out.println("Material: " + this.material);
	}
	
	}
	


