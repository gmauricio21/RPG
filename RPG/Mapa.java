import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ThreadLocalRandom;

public class Mapa {
    private int nbRow;
    private int nbColumn;
    private char [][] mapa;     
    
    public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_ENTER = "\u001B[38;5;226m";
	public static final String ANSI_WIN = "\u001B[38;5;40m";
	
    public Mapa(int l, int c) {        
        this.nbRow = l;
        this.nbColumn = c; 
       
        mapa = new char[nbRow][nbColumn];
    
        for(int i = 0; i < nbRow ; i++) {            
            for(int j = 0 ; j < nbColumn ; j++) {                
                mapa[i][j] = '.';
                mapa[4][0] = 'X';
            }
        }
     }
       
    public void Exibir() {  
		System.out.println("     ~x MAPA x~" );	
        for(int i = 0; i < nbRow ; i++) {            
            for(int j = 0 ; j < nbColumn ; j++) {
            	System.out.print(" | " + mapa[i][j]);
            }
            System.out.println(" | ");
        }
        System.out.println();
    }
    
    public void SetPosicao(Jogador jogador, char t) throws IOException {
    	Destruicao monstro = new Monstro();	 
    	for(int i = 0; i < nbRow ; i++) {
        	for(int j = 0 ; j < nbColumn ; j++) {
        		if(mapa[i][j] == 'X'){
        			mapa[i][j] = '.';
        			}
                }
            }
	
    	 if( jogador.getY() < 0 || jogador.getY() > nbColumn || jogador.getY() < 0 || jogador.getY() > nbColumn) {
    		 System.out.print("Erro de posicionamento!"+'\n');
    		 return;
    		 }
    	 
    	 if(mapa[jogador.getX()][jogador.getY()] == 'M') {

     	   	System.out.println("Você encontrou um monstro"+'\n');
     	    while(monstro.hp > 0) {			
     	    	System.out.println("+-------------------------+"+'\n'+
     	    					   "      Selecione a ação:"     +'\n'+
     	    					   "+-------------------------+");
     	        System.out.println("  1. Atacar  |  2. Fugir");
     	        System.out.print(ANSI_ENTER + "ENTER :" + ANSI_RESET);
     	        BufferedReader bff = new BufferedReader(new InputStreamReader(System.in)); 
     	        String acao = bff.readLine();
     	        acao  = acao.toUpperCase();
     	        
     	        switch(acao) {
     	        case "1":
     	        	System.out.println(jogador.getNome() +" atacou "+ monstro.getNome()+'\n');
         	    	jogador.Ataque(monstro);
     	        	break;
     	        case "2":
     	        	 monstro.hp = 0;
     	        	 System.out.println("Fugir...");
     	        	 break;
     	        default:    	        	 
     	        	monstro.hp = 0;
     	        	System.out.println("Fugir...");
     	        	break;
     	        }    	    	   	    	
     		 }
     	 }
    	 
    	 if(mapa[jogador.getX()][jogador.getY()] == '.' || mapa[jogador.getX()][jogador.getY()] == 'M') {
    		 mapa[jogador.getX()][jogador.getY()] = t;
    		 }else{
    			 System.out.print("Erro de posicionamento!"+'\n');
    			 return;
    		 }

        if(jogador.getX() == 0 && jogador.getY() == 4) {
        	 VoceVenceu();
        	 System.exit(0);
        }       
    }
    

    public void SetPosicaoMonstro(){
		for(int i = 0; i < 5; i++) {
			int randomCol = ThreadLocalRandom.current().nextInt(0, nbColumn);
			int randomRow = ThreadLocalRandom.current().nextInt(0, nbRow);
			if(mapa[randomRow][randomCol] != mapa[4][0]) {
				mapa[randomRow][randomCol] = 'M';
			}
			
        }		
    }

    private static void VoceVenceu() {
    	System.out.print(ANSI_WIN+"__   _____  _   _  __        _____ _   _   _ \r\n"
    			+ "\\ \\ / / _ \\| | | | \\ \\      / |_ _| | / | | |\r\n"
    			+ " \\ V | | | | | | |  \\ \\ /\\ / / | || |/  | | |\r\n"
    			+ "  | || |_| | |_| |   \\ V  V /  | ||  /| | |_|\r\n"
    			+ "  |_| \\___/ \\___/     \\_/\\_/  |___|_/ |_| (_)"+ANSI_RESET);
    }
}