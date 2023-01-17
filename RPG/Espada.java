public class Espada extends Armas{
	private static final int DANO = 10;
	private static final int PRECO = 10;
	private String nome = "Espada";
	
	public Espada() {
		super(DANO, PRECO);
	}

	@Override
	public String getNome() {
		return this.nome;
	}

}
