public class PocaoCura extends Pocao {
	private String nome = "Poção de cura";
	private final static int PRECO = 500;
	private final static int VALOR = 10;
	
	public PocaoCura() {
		super(VALOR,PRECO);
	}

	@Override
	public String getNome() {	
		return this.nome;
	}
}
