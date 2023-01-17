public class LojaArmas {
	Armas martelo = new Martelo();
	Armas bastao = new BastaoDaVerdade();
	Armas espada = new Espada();
	
	public double Preco(Armas a) {
		return a.preco;
	}
	
	public double Dano(Armas a) {
		return a.dano;
	}
	
	public Armas armasPadrao() {
		return this.espada;
	}

	
	public void ascii_art() {
	System.out.println(""
			+  "        +---------------[ A LOJA ]--------------+\n"+
			   "                                               \n"+
			   "         ENTRAR para acessar:                  \n"+
			   "                                               \n"+
			   "         => 'M' Martelo: " +martelo.preco+"$     \n"+
			   "                                               \n"+
			   "         => 'B' Bastao da verdade: " +bastao.preco+"$\n"+
			   "                                               \n"+
			   "          =>999 para Sair                     \n"+			  
			   "        +_________________________________________+\n"	
		);
	}
}
