import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainRPG {
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_CYAN = "\u001B[1;36m";
	public static final String ANSI_SPEAK = "\u001B[38;5;123m";
	public static final String ANSI_ENTER = "\u001B[1;38;5;226m";
	
	public static void main(String[] args) throws IOException {
		BufferedReader bff = new BufferedReader(new InputStreamReader(System.in)); 
		LojaArmas loja = new LojaArmas();
		Mapa mapa = new Mapa(5,5);
		mapa.SetPosicaoMonstro();

		System.out.println(ANSI_CYAN  +"+----*------------------*------------------*--+");
		System.out.println("   *       O Caminho da Montanha             " );
		System.out.println("             Bem-vindo ao jogo        *     " );
		System.out.println("+-------------------**------------*----------*+"+ ANSI_RESET);
		exibirMontanha();

		System.out.print("Pressione 'I' para INICIAR  |     Pressione 'S' para SAIR'"+'\n');
		System.out.print(ANSI_ENTER + "DIGITE :" + ANSI_RESET);
        String resp = bff.readLine();
        resp = resp.toUpperCase();
		
			if(!resp.equals("S")) {
				System.out.println("+-------------------------+");
				System.out.println("   Crie seu personagem"    );
				System.out.println("+-------------------------+");
				System.out.print(ANSI_ENTER + " - Digite seu nome:" + ANSI_RESET);
				String nomePersonagem = bff.readLine();
				Jogador jogador = new Jogador(nomePersonagem, loja.armasPadrao());
				System.out.println();				
				ExibirComandos();
				
				System.out.println("    +~~~~~~~~~~~~~~~~~~[ HISTÓRIA ]~~~~~~~~~~~~~~~~~~+");
				System.out.println(ANSI_SPEAK  +"                      Bem-vindo "+nomePersonagem            );
				System.out.println("         \"Aqui você tem o mínimo de equipamentos    "+'\n'
							     + "          necessários para eliminar monstros, obter "+'\n'
							     + "           ouro e realizar melhorias na sua arma.\" "+ ANSI_RESET);
				System.out.println("    +~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~+"+'\n' );
		
				mapa.Exibir();
				
				while(!resp.equals("4")) {
					System.out.print(ANSI_ENTER + "DIGITE :" + ANSI_RESET);
					resp = bff.readLine();
					resp = resp.toUpperCase();
	
					switch(resp){
					case "0":
						ExibirComandos();
				    break;
					    
					case "1":
						loja.ascii_art();
						System.out.print(ANSI_ENTER + "ESCOLHA DA LOJA :" + ANSI_RESET);
						resp = bff.readLine();
						resp = resp.toUpperCase();
							if(resp.equals("M")) {
								jogador.Comprar(loja.martelo);
								System.out.println(jogador.ToString()+'\n');
							}
							else if(resp.equals("B")) {
								jogador.Comprar(loja.bastao);
								System.out.println(jogador.ToString()+'\n');
							}
					break;
						
					   case "2":
						   jogador.MostrarInventario();
					break;	
					
					   case "3":
						   jogador.EstadoArma();
					break;	
	
					case "W":
						jogador.Mover("W");
						mapa.SetPosicao(jogador, 'X');
						mapa.Exibir();
						System.out.println(nomePersonagem +" segue para o norte");
					break;	
						
					case "D":
						jogador.Mover("D");
						mapa.SetPosicao(jogador, 'X');
						mapa.Exibir();
						System.out.println(nomePersonagem +" segue para o leste");
						
					break;
						
					case "S":
						jogador.Mover("S");
						mapa.SetPosicao(jogador, 'X');
						mapa.Exibir();
						System.out.println(nomePersonagem +" segue para o sul");
					break;
						
					case "A":
						jogador.Mover("A");
						mapa.SetPosicao(jogador, 'X');
						mapa.Exibir();
						System.out.println(nomePersonagem +" segue para o oeste");
					break;
						
					case "5":
						fimMontanha();
						System.exit(0);
					break;

				}
			}
		}else {
			fimMontanha();
			System.exit(0);
			}
		}
	
	private static void ExibirComandos() {
		System.out.println("+-------------------[ COMANDOS-ÚTEIS ]------------------+"+'\n'+
		                   "                                                     "+'\n'+
				           " DIGITE para acessar:                                 "+'\n'+
				           " =>0  Comando Útil                                 "+'\n'+
				           " =>1  Loja                                          "+'\n'+
				           " =>2  Inventário                                      "+'\n'+
				           " =>3  Estatísticas                                     "+'\n'+
			               " =>   Movimentar-se no mapa = 'W'  |   'D'   |  'S'  |   'A'         "+'\n'+
                           "                              cima | direita | baixo | esquerda        "+'\n'+
                           " =>5  Fim de jogo                                       ");
        System.out.println("+-------------------------------------------------------+"+'\n');
	}

	private static void exibirMontanha() {
		System.out.println("        _    .  ,   .           .\r\n"
				+ "    *  / \\_ *  / \\_      _  *        *   /\\'__   *\r\n"
				+ "      /    \\  /    \\,   ((        .    _/  /  \\  *\r\n"
				+ " .   /\\/\\  /\\/ :' __ \\_  `          _^/  ^/    `-\r\n"
				+ "    /    \\/  \\  _/  \\-'\\      *    /.' ^_   \\_  \r\n"
				+ "  /\\  .-   `. \\/     \\ /==~=-=~=-=-;.  _/ \\ -. \\\r\n"
				+ " /  `-.__ ^   / .-'.--\\ =-=~_=-=~=^/  _ `--./ .-'  `\r\n"
				+ "/        `.  / /       `.~-^=-=~=^=.-'      '-._ `._"+"\n");
	}
	
	private static void fimMontanha() {
		System.out.println("           .          .           .     .                .     .\r\n"
				+ "  .      .      *           .       .          .                       .\r\n"
				+ "                 .       .   . *            \"você saiu?....por que..por quê?...               \r\n"
				+ "  .       ____     .      . .            .    Eu sempre vou lembrar, Adeus.\"\r\n"
				+ "         >>         .        .               .\r\n"
				+ " .   .  /WWWI; \\  .       .    .  ____               .         .     . \r\n"
				+ "  *    /WWWWII; \\=====;    .     /WI; \\   *    .        /\\_          \r\n"
				+ "  .   /WWWWWII;..      \\_  . ___/WI;:. \\     .        _/M; \\    .   .\r\n"
				+ "     /WWWWWIIIIi;..      \\__/WWWIIII:.. \\____ .   .  /MMI:  \\   * .  \r\n"
				+ " . _/WWWWWIIIi;;;:...:   ;\\WWWWWWIIIII;.     \\     /MMWII;   \\    .  \r\n"
				+ "  /WWWWWIWIiii;;;.:.. :   ;\\WWWWWIII;;;::     \\___/MMWIIII;   \\      \r\n"
				+ " /WWWWWIIIIiii;;::.... :   ;|WWWWWWII;;::.:      :;IMWIIIII;:   \\___   \r\n"
				+ "/WWWWWWWWWIIIIIWIIii;;::;..;\\WWWWWWIII;;;:::...    ;IMIII;;     ::  \\  \r\n"
				+ "WWWWWWWWWIIIIIIIIIii;;::.;..;\\WWWWWWWWIIIII;;..  :;IMIII;:::     :    \\\r\n"
				+ "WWWWWWWWWWWWWIIIIIIii;;::..;..;\\WWWWWWWWIIII;::; :::::::::.....::       \r\n"
				+ "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%X\r\n"
				+ "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%XXXX\r\n"
				+ "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%XXXXXXX\r\n");
	}
}