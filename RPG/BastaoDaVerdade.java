public class BastaoDaVerdade extends Armas {
	private static final int DANO = 100;
	private static final int PRECO  = 2000;
	private String nome="Bastao da verdade";
	
	public BastaoDaVerdade() {
		super(DANO, PRECO);
	}
	
	@Override
	public String getNome() {
		return this.nome;
	}
}
