public abstract class Pocao {
	protected String name;
	protected int preco;
	protected int valor;
	
	public Pocao(int valor,int preco) {
		this.valor = valor;
		this.preco = preco;
	}
	
	abstract public String getNome();
}
