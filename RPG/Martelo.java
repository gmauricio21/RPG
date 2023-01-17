public class Martelo extends Armas{
	private static final int DANO = 50;
	private static final int PRECO = 1000;
	private String nome = "Martelo";
	
	public Martelo() {
		super(DANO, PRECO);
	}
	
	@Override
	public String getNome() {
		return this.nome;
	}
}
