public abstract class Armas  {
	protected int dano;
	protected int preco;
	protected String nome;
	
	public Armas(int dano, int preco) {
		this.dano = dano;
		this.preco = preco;
	}

	public void ataque(Destruicao m) {
		m.hp -= this.dano ;
		if(m.hp <= 0) {
			System.out.println("VOCÊ O MATOU");
		}else {
		System.out.println(m.hp);
		}
	
	}
	
	abstract public String getNome();
}
