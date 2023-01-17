public abstract class Destruicao {
	protected String nome;
	protected int hp;
	protected int ouro;
	
	public Destruicao(int hp, int ouro) {
		this.hp = hp;
		this.ouro = ouro;
	}

	abstract public String getNome();
}
