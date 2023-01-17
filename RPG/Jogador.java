import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Jogador {
	private String nome;
	private Armas a;
	private int carteira = 60000;
	private int x=4;
	private int y=0;
	private int hp = 100;
	ArrayList<Armas> minhasArmas = new ArrayList<Armas>();
	ArrayList<Pocao> minhasPocoes = new ArrayList<Pocao>();
	
    public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_ENTER = "\u001B[1;38;5;226m";
	public static final String ANSI_KILL = "\u001B[38;5;196m";
	public static final String ANSI_INF = "\u001B[38;5;208m";
	
	public Jogador(String nome, Armas a) {
		this.nome = nome;
		this.a = a;

	}
	
	public void SaquearItem() {
        Pocao pocao = new PocaoCura();
        this.minhasPocoes.add(pocao);
        System.out.println("Você saqueou " + pocao.getNome()+"\n");
	}

	public String getNome() {
		return this.nome;
	}
	
	//posição
    public int getX() {      
        return this.x;
    }   
    public int getY() {
    	return this.y;
    }
    
    public int getHp() {      
        return this.hp;
    } 
    
    
	public void Ataque(Destruicao m) {
		m.hp -= this.a.dano  ;
		if(m.hp <= 0) {
			System.out.println(ANSI_KILL+ "VOCÊ O MATOU"+ ANSI_RESET);
			System.out.println("Você ganha : " + m.ouro);
			SaquearItem();
			this.carteira += m.ouro;
		}else {
		System.out.println(m.hp +"HP restante (Monstro)");
		}
	}	
	
	public void MudarArma(Armas a) {
		this.a = a;
	}
	
	public void UsarPocao(Pocao p) {
		this.hp += p.valor;
	}
	
	public void soltarArma(Armas a) {
		this.minhasArmas.remove(a);
	}
	
	public void MostrarInventario() throws IOException {		
		System.out.println("Inventário:" + "\n"
					      +"Ouro  : " + this.carteira  +"\n");
		SelecioneAcao();
	}
	
	public void EstadoArma() {
		System.out.println("Estatisticas:") ;
		System.out.println("Poder de ataque da arma: "+ this.a.dano +"\n");
	}
	
	public void Comprar(Armas a) {
		if(this.carteira >= a.preco) {
			this.carteira -= a.preco;
			minhasArmas.add(a);			
			System.out.println("Você comprou um "+ a.getNome());
		}else {
			System.out.println("Você não tem ouro suficiente") ;
		}
	}
	
	public String ToString() {
		return 				
		"+~~~~~~~~~~~~~~[ SEU PERSONAGEM ]~~~~~~~~~~+"+'\n'+
		"  Nome: "+this.nome+" | "+"HP: "+this.hp +" | "+"Arma: "+this.a.getNome()+'\n'+
		"+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~+"+'\n';							
	}
	


	public void Mover(String direcao) {  

		 switch(direcao) {        
	        case "S":
	        	this.x++; 
	        	if(this.x > 4) {
	        		System.out.println("Posição inválida\nTente novamente");
	            	this.x--;
	        	}

	        	break;            
	        case "W":
	        	this.x--;
	        	if(this.x < 0) {
	        		System.out.println("Posição inválida\nTente novamente");
	            	this.x++;
	        	}

	        	break;  
	        	
	        case "D": 
	            this.y++;
	        	if(y > 4) {
	        		System.out.println("Posição inválida\nTente novamente");
	            	this.y--;
	        	}
	        		
	            break;          
	        case "A":   
	        	this.y--;
	        	if(this.y < 0) {
	        		System.out.println("Posição inválida\nTente novamente");
	            	this.y++;
	        	}
	       
	            break;
	        default:
	        	System.out.println("Posição inválida");
	        }		 
	}
	
	
	private void SelecioneAcao() throws IOException {

        System.out.println("+~~~~~~~~~~~~~~[ INVENTÁRIO ]~~~~~~~~~~~~~~+");
		for(int i = 0; i < minhasArmas.size(); i++) {
		System.out.print("-"+ i + " " + minhasArmas.get(i).getNome() + " | ");
		}
		System.out.println();
		for(int i = 0; i < minhasPocoes.size(); i++) {
			System.out.print("-"+ i + " " + minhasPocoes.get(i).getNome() + " | ");
		}
		System.out.println();
        System.out.println("+------------[ MENU DO INVENTÁRIO ]----------+");
        System.out.println(" DIGITE para acessar:                 \n"+
			  			   " =>1  Selecione uma arma              \n"+
						   " =>2  Use uma Poção                   \n"+
						   "                                      \n"+
						   " =>999 para Sair                      \n");	
		System.out.println("+---------------------------------------+");

		    System.out.print("\n" + ANSI_ENTER + "DIGITE:" + ANSI_RESET);   
	        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
	        int digitar = Integer.parseInt(reader.readLine());  
	        
		        switch(digitar) {
		        case 1:
		        	System.out.print("\n" + ANSI_ENTER + "Troque sua arma digitando o número dela:" + ANSI_RESET);
		        	int digitar2 = Integer.parseInt(reader.readLine());
						for(int i = 0; i < minhasArmas.size(); i++) {
							if(i == digitar2) {
								MudarArma(minhasArmas.get(i));
								System.out.println(ANSI_INF +"Você mudou sua arma!" + ANSI_RESET);
							}else {
								System.out.println("Número errado");
							}
						}		        	
		        break;
		        case 2:
		        	System.out.print("\n" + ANSI_ENTER + "Use a poção digitando o número dela:" + ANSI_RESET);
		        	int digitar3 = Integer.parseInt(reader.readLine());
						for(int i = 0; i < minhasPocoes.size(); i++) {
							if(i == digitar3) {
								UsarPocao(minhasPocoes.get(i));
								System.out.println(ANSI_INF + "Você usou "+ minhasPocoes.get(digitar3).getNome() + ANSI_RESET );
							}else {
								System.out.println("Número Errado");
							}
						}					        
		        break;
		        
	        }
	        System.out.println(this.ToString()+'\n');
	}
}