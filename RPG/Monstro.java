public class Monstro extends Destruicao{
	private static final int HP = 25;
	private static final int OURO = 500;
	private String nome = "Mephisto";

	public Monstro() {
		super(HP,OURO);
	}

	@Override
	public String getNome() {
		return this.nome;
	}
}
