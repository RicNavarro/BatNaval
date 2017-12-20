package batalhanaval;
import java.util.Random;

import javax.swing.JOptionPane;
import java.awt.*; 
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.*;

public class ModoJogo {
	private int jogo;
	private int aleatorio1;
	private int aleatorio2;
	private Celulas testequalunidade[][] = new Celulas[10][10];
	private Celulas tablequalunidade[][] = new Celulas[10][10];
	private boolean subcolocado = false;
	private boolean jatocolocado = false;
	private boolean esccolocado = false;
	private boolean portacolocado = false;
	private char vetorchar1[] = new char[4];
	private char vetorchar[];
	
	public ModoJogo(int tipo) {
		this.jogo = tipo;
		this.tipoJogo();
	}
	
	public void tipoJogo() {

		
		for(int i = 0; i < 10; i++)//Preenche matriz de botoes
	       {
	           for(int j = 0; j < 10; j++)
	           {
	        	   tablequalunidade[i][j] = new NaoCelula();
	        	   testequalunidade[i][j] = new NaoCelula();
	           }
	       }
		
		
			//Submarino
		Submarino1 s1inimigo = new Submarino1();//Celula1
                Submarino2 s2inimigo = new Submarino2();//Celula2
        
	        Random geradordealeatorio1sub = new Random();
	        setAleatorio1(geradordealeatorio1sub.nextInt(10));        
	        Random geradordealeatorio2sub = new Random();
	        setAleatorio2(geradordealeatorio2sub.nextInt(10));
	        
	        //coloca o submarino no pc
	        if(aleatorio2 == 9) {
	     	   aleatorio2--;
	        }
	        if(testequalunidade[aleatorio1][aleatorio2] instanceof NaoCelula) {
	        	testequalunidade[aleatorio1][aleatorio2] = new Submarino1();
	        	testequalunidade[aleatorio1][aleatorio2+1] = new Submarino2();
	        	subcolocado = true;
	        	//System.out.println("Submarino começa na posição: "+aleatorio1+"/"+aleatorio2);
	        }


	        //Jato
		Jato1 j1inimigo = new Jato1(); 
	    Jato2 j2inimigo = new Jato2();
	    
	    do {
	        Random geradordealeatorio1jato = new Random();
	        setAleatorio1(geradordealeatorio1jato.nextInt(10));        
	        Random geradordealeatorio2jato = new Random();
	        setAleatorio2(geradordealeatorio2jato.nextInt(10));
	        
	        //coloca o jato no jogador
	        if(aleatorio2 == 9) {
	     	   aleatorio2--;
	        }
	        if(testequalunidade[aleatorio1][aleatorio2] instanceof NaoCelula && testequalunidade[aleatorio1][aleatorio2+1] instanceof NaoCelula) {
	        	testequalunidade[aleatorio1][aleatorio2] = new Jato1();
	        	testequalunidade[aleatorio1][aleatorio2+1] = new Jato2();
	        	jatocolocado = true;
	        	//System.out.println("Jato começa na posição: "+aleatorio1+"/"+aleatorio2);
	        }	
        }while(jatocolocado == false);

	    
        //Escolta
	    Escolta1 e1inimigo = new Escolta1();
        Escolta2 e2inimigo = new Escolta2();
        Escolta3 e3inimigo = new Escolta3();
        do {
	        Random geradordealeatorio1escolta = new Random();
	        setAleatorio1(geradordealeatorio1escolta.nextInt(10));        
	        Random geradordealeatorio2escolta = new Random();
	        setAleatorio2(geradordealeatorio2escolta.nextInt(10));
	        
	        //coloca o navio de escolta no jogador
	        if(aleatorio2 == 9){
	        	aleatorio2 = aleatorio2 - 2;
	        }
	        if(aleatorio2 == 8) {
	        	aleatorio2--;
	        }
	        if(testequalunidade[aleatorio1][aleatorio2] instanceof NaoCelula && testequalunidade[aleatorio1][aleatorio2+1] instanceof NaoCelula && testequalunidade[aleatorio1][aleatorio2+2] instanceof NaoCelula) {
	        	testequalunidade[aleatorio1][aleatorio2] = new Escolta1();
	        	testequalunidade[aleatorio1][aleatorio2+1] = new Escolta2();
	        	testequalunidade[aleatorio1][aleatorio2+2] = new Escolta3();
	        	esccolocado = true;
	        	//System.out.println("Escolta começa na posição: "+aleatorio1+"/"+aleatorio2);
	        }	
        }while(esccolocado == false);
        

        	//Porta
        
        Porta1 p1inimigo = new Porta1(); //Celula1
        Porta2 p2inimigo = new Porta2(); //Celula2
        Porta3 p3inimigo = new Porta3(); //Celula3
        Porta4 p4inimigo = new Porta4(); //Celula4
        do {
	        Random geradordealeatorio1porta = new Random();
	        setAleatorio1(geradordealeatorio1porta.nextInt(10));        
	        Random geradordealeatorio2porta = new Random();
	        setAleatorio2(geradordealeatorio2porta.nextInt(10));
	        
	        //coloca o porta no jogador
	        if(aleatorio2 == 9){
	        	aleatorio2 = aleatorio2 - 3;
	        }
	        if(aleatorio2 == 8) {
	        	aleatorio2 = aleatorio2 - 2;
	        }
	        
	        if(aleatorio2 == 7) {
	        	aleatorio2--;
	        }
	        if(testequalunidade[aleatorio1][aleatorio2] instanceof NaoCelula && testequalunidade[aleatorio1][aleatorio2+1] instanceof NaoCelula && testequalunidade[aleatorio1][aleatorio2+2] instanceof NaoCelula && testequalunidade[aleatorio1][aleatorio2+3] instanceof NaoCelula) {
	        	testequalunidade[aleatorio1][aleatorio2] = new Porta1();
	        	testequalunidade[aleatorio1][aleatorio2+1] = new Porta2();
	        	testequalunidade[aleatorio1][aleatorio2+2] = new Porta3();
	        	testequalunidade[aleatorio1][aleatorio2+3] = new Porta4();
	        	portacolocado = true;
	        	//System.out.println("Porta avioes começa na posição: "+aleatorio1+"/"+aleatorio2);
	        }	
        }while(portacolocado == false);


		if(this.jogo == 0) {
			this.jogoAleatorio();
		}
		if(this.jogo == 1) {
			this.jogoPlanejado();
		}
		if(this.jogo == 2) {
			this.jogoArquivo();
		}
}
	public void jogoAleatorio() {
		//Submarino
				Submarino1 s1jogador = new Submarino1();//Celula1
		        Submarino2 s2jogador = new Submarino2();//Celula2
		        subcolocado = false;
		        jatocolocado = false;
		        esccolocado = false;
		        portacolocado = false;
			        Random geradordealeatorio1sub = new Random();
			        setAleatorio1(geradordealeatorio1sub.nextInt(10));        
			        Random geradordealeatorio2sub = new Random();
			        setAleatorio2(geradordealeatorio2sub.nextInt(10));
			        
			        //coloca o submarino no pc
			        if(aleatorio2 == 9) {
			     	   aleatorio2--;
			        }
			        if(tablequalunidade[aleatorio1][aleatorio2] instanceof NaoCelula) {
			        	tablequalunidade[aleatorio1][aleatorio2] = new Submarino1();
			        	tablequalunidade[aleatorio1][aleatorio2+1] = new Submarino2();
			        	//System.out.println("Submarino aliado começa na posição: "+aleatorio1+"/"+aleatorio2);
			        	subcolocado = true;
			        }


			        //Jato
				Jato1 j1jogador = new Jato1(); 
			    Jato2 j2jogador = new Jato2();
			    
			    do {
			        Random geradordealeatorio1jato = new Random();
			        setAleatorio1(geradordealeatorio1jato.nextInt(10));        
			        Random geradordealeatorio2jato = new Random();
			        setAleatorio2(geradordealeatorio2jato.nextInt(10));
			        
			        //coloca o jato no jogador
			        if(aleatorio2 == 9) {
			     	   aleatorio2--;
			        }
			        if(tablequalunidade[aleatorio1][aleatorio2] instanceof NaoCelula && tablequalunidade[aleatorio1][aleatorio2+1] instanceof NaoCelula) {
			        	tablequalunidade[aleatorio1][aleatorio2] = new Jato1();
			        	tablequalunidade[aleatorio1][aleatorio2+1] = new Jato2();
			        	jatocolocado = true;
			        	//System.out.println("Jato aliado começa na posição: "+aleatorio1+"/"+aleatorio2);
			        }	
		        }while(jatocolocado == false);

			    
		        //Escolta
			Escolta1 e1jogador = new Escolta1();
		        Escolta2 e2jogador = new Escolta2();
		        Escolta3 e3jogador = new Escolta3();
		        do {
			        Random geradordealeatorio1escolta = new Random();
			        setAleatorio1(geradordealeatorio1escolta.nextInt(10));        
			        Random geradordealeatorio2escolta = new Random();
			        setAleatorio2(geradordealeatorio2escolta.nextInt(10));
			        
			        //coloca o navio de escolta no jogador
			        if(aleatorio2 == 9){
			        	aleatorio2 = aleatorio2 - 2;
			        }
			        if(aleatorio2 == 8) {
			        	aleatorio2--;
			        }
			        if(tablequalunidade[aleatorio1][aleatorio2] instanceof NaoCelula && tablequalunidade[aleatorio1][aleatorio2+1] instanceof NaoCelula && tablequalunidade[aleatorio1][aleatorio2+2] instanceof NaoCelula) {
			        	tablequalunidade[aleatorio1][aleatorio2] = new Escolta1();
			        	tablequalunidade[aleatorio1][aleatorio2+1] = new Escolta2();
			        	tablequalunidade[aleatorio1][aleatorio2+2] = new Escolta3();
			        	esccolocado = true;
			        	//System.out.println("Escolta aliada começa na posição: "+aleatorio1+"/"+aleatorio2);
			        }	
		        }while(esccolocado == false);
		        

		        //Porta
		        Porta1 p1jogador = new Porta1(); //Celula1
		        Porta2 p2jogador = new Porta2(); //Celula2
		        Porta3 p3jogador = new Porta3(); //Celula3
		        Porta4 p4jogador = new Porta4(); //Celula4
		        do {
			        Random geradordealeatorio1porta = new Random();
			        setAleatorio1(geradordealeatorio1porta.nextInt(10));        
			        Random geradordealeatorio2porta = new Random();
			        setAleatorio2(geradordealeatorio2porta.nextInt(10));
			        
			        //coloca o submarino no jogador
			        if(aleatorio2 == 9){
			        	aleatorio2 = aleatorio2 - 3;
			        }
			        if(aleatorio2 == 8) {
			        	aleatorio2 = aleatorio2 - 2;
			        }
			        
			        if(aleatorio2 == 7) {
			        	aleatorio2--;
			        }
			        if(tablequalunidade[aleatorio1][aleatorio2] instanceof NaoCelula && tablequalunidade[aleatorio1][aleatorio2+1] instanceof NaoCelula && tablequalunidade[aleatorio1][aleatorio2+2] instanceof NaoCelula && tablequalunidade[aleatorio1][aleatorio2+3] instanceof NaoCelula) {
			        	tablequalunidade[aleatorio1][aleatorio2] = new Porta1();
			        	tablequalunidade[aleatorio1][aleatorio2+1] = new Porta2();
			        	tablequalunidade[aleatorio1][aleatorio2+2] = new Porta3();
			        	tablequalunidade[aleatorio1][aleatorio2+3] = new Porta4();
			        	portacolocado = true;
			        	//System.out.println("Porta avioes aliado começa na posição: "+aleatorio1+"/"+aleatorio2);
			        }	
		        }while(portacolocado == false);

		
		
		//Matriz do jogador criada de forma aleatÃƒÂ³ria
		//System.out.println(testequalunidade+"1");
		BatalhaNaval b = new BatalhaNaval(this.getTablequalunidade(),this.getTestequalunidade());	
	}

	public void jogoPlanejado() {
		Planejado p = new Planejado(this.getTestequalunidade());
	}
	
	public void jogoArquivo( ){
		StringBuilder sb = new StringBuilder();
        BufferedReader br = null;
        boolean jasub=false;
        boolean jajato=false;
        boolean jaesc=false;
        boolean japorta=false;
        boolean finalizado=false; 
        try {
            br = new BufferedReader(new FileReader("./batalhanaval.txt"));
            String linha;
            while ((linha = br.readLine()) != null) {
            	if(jasub == true && jajato == true && jaesc == true && japorta == true) {
            		BatalhaNaval b = new BatalhaNaval(tablequalunidade,testequalunidade);
            	}
            	int tipounidade = Character.getNumericValue(linha.charAt(0));
            	int linhatable = Character.getNumericValue(linha.charAt(3));
            	int tamstring = linha.length();
            	vetorchar = linha.toCharArray();
            	if((tamstring!=5 || vetorchar[3]!='1' || vetorchar[4]!='0') && tamstring != 4) {
            		tipounidade = 8;
            	}
            	if(tamstring==5 && vetorchar[3]=='1' && vetorchar[4]=='0'){
            		linhatable = 10;
            	}
	            if(vetorchar[1]!=' ') {
	            	JOptionPane.showMessageDialog(null, "Dois 2, Um 3 e Um 4 serão lidos\nO formato a ser isnsrido é N LN,\nonde N é um número e L uma letra", "O formato não está correto", JOptionPane.ERROR_MESSAGE);
	            	linha = null;
	            	break;
	            }
            	int colunatable = 0;
            	finalizado=false;
            	vetorchar1 = vetorchar;
            		if(vetorchar[2] == 'A') {
	            			colunatable = 0;	            	
	            	}else
						if(vetorchar[2] == 'B') {
							colunatable = 1;
					}else            	
						if(vetorchar[2] == 'C') {
							colunatable = 2;	         
					}else
						if(vetorchar[2] == 'D') {
							colunatable = 3;	            
					}else
						if(vetorchar[2] == 'E') {
							colunatable = 4;	           
					}else
						if(vetorchar[2] == 'F') {
							colunatable = 5;	            	
					}else
						if(vetorchar[2] == 'G') {
							colunatable = 6;	          
					}else
						if(vetorchar[2] == 'H') {
							colunatable = 7;	            	
					}else
						if(vetorchar[2] == 'I') {
							colunatable = 8;	            	
	            	}else
						if(vetorchar[2] == 'J') {
							colunatable = 9;	          
						}	
	            	else {
	            		JOptionPane.showMessageDialog(null, "A letra inclusa deve estar entre A e J\nA letra deve estar maiúscula\nO formato a ser isnsrido é N LN,\nonde N é um número e L uma letra", "O formato não está correto", JOptionPane.ERROR_MESSAGE);
	            	}
	           
            	if(tipounidade == 2 && colunatable <9) {
            		if (jasub == false && finalizado == false){
            			linhatable--;
	            		if(tablequalunidade[linhatable][colunatable] instanceof NaoCelula) {
	            			tablequalunidade[linhatable][colunatable] = new Submarino1();
				        	tablequalunidade[linhatable][colunatable+1] = new Submarino2();
				        	//System.out.println("Submarino aliado começa na posição: "+linhatable+"/"+colunatable);
				        	jasub = true;
				        	finalizado = true;
	            		}	
			        }
	            	if(jasub == true && jajato == false && finalizado == false) {
	            		linhatable--;
	            		if(tablequalunidade[linhatable][colunatable] instanceof NaoCelula && tablequalunidade[linhatable][colunatable+1] instanceof NaoCelula) {
				        	tablequalunidade[linhatable][colunatable] = new Jato1();
				        	tablequalunidade[linhatable][colunatable+1] = new Jato2();
				        	//System.out.println("Jato aliado começa na posição: "+linhatable+"/"+colunatable);
				        	jajato = true;
				        	finalizado = true;
	                	}
	            	}
            	}else
            	if(tipounidade == 3 && jaesc == false && colunatable <8) {
            		linhatable--;
            		if(finalizado == false) {
            			 if(tablequalunidade[linhatable][colunatable] instanceof NaoCelula && tablequalunidade[linhatable][colunatable+1] instanceof NaoCelula && tablequalunidade[linhatable][colunatable+2] instanceof NaoCelula) {
     			        	tablequalunidade[linhatable][colunatable] = new Escolta1();
     			        	tablequalunidade[linhatable][colunatable+1] = new Escolta2();
     			        	tablequalunidade[linhatable][colunatable+2] = new Escolta3();
     			        	//System.out.println("Escolta aliada começa na posição: "+linhatable+"/"+colunatable);
     			        	jaesc = true;
     			        	finalizado = true;
     			        }
            		}
            		
            	}else
            	if(tipounidade == 4 && japorta == false && colunatable <7) {
            		linhatable--;
	            	if(finalizado == false) {
            			if(tablequalunidade[linhatable][colunatable] instanceof NaoCelula && tablequalunidade[linhatable][colunatable+1] instanceof NaoCelula && tablequalunidade[linhatable][colunatable+2] instanceof NaoCelula && tablequalunidade[linhatable][colunatable+3] instanceof NaoCelula ) {
				        	tablequalunidade[linhatable][colunatable] = new Porta1();
				        	tablequalunidade[linhatable][colunatable+1] = new Porta2();
				        	tablequalunidade[linhatable][colunatable+2] = new Porta3();
				        	tablequalunidade[linhatable][colunatable+3] = new Porta4();
				        	//System.out.println("Porta avioes aliado começa na posição: "+linhatable+"/"+colunatable);
				        	japorta = true;
				        	finalizado = true;
	            		}	
	            		
	            	}
            	}	
            	else {
            		String texto1;
            		String texto2;
            		if(tipounidade<2 || tipounidade>4) {
            			texto1 = "O número inicial deve estar entre 2 e 4\n";
            		}else {
            			texto1 = "/n";
            		}
            		if((tipounidade == 2 && colunatable<9) || (tipounidade == 2 && colunatable<9) || (tipounidade == 2 && colunatable<9))
            			texto2 = "Se uma unidade ocupa " +tipounidade+ " espaços\né necessário que ela esteja a no mínimo\n"+tipounidade+" espaços da borda presente em 10";
            		JOptionPane.showMessageDialog(null, "Se uma unidade ocupa "+tipounidade+" espaços\né necessário que ela esteja a no mínimo\n"+tipounidade+" espaços da borda presente no 10\nO formato a ser isnsrido é N LN,\nonde N é um número e L uma letra", "O formato não está correto", JOptionPane.ERROR_MESSAGE);
            		
            	}
            	
            	
                sb.append(linha);
            }
        } catch (IOException e) {
        	 //System.out.println("1a");
        	e.printStackTrace();
        } finally {
            try {
                if (br != null) {
					if(jasub == true && jajato == true && jaesc == true && japorta == true) {
                		BatalhaNaval b = new BatalhaNaval(this.getTablequalunidade(),this.getTestequalunidade());
                	}else {/*
                		System.out.println("jasub = "+jasub);
                		System.out.println("jajato = "+jajato);
                		System.out.println("jaesc = "+jaesc);
                		System.out.println("japorta = "+japorta);
                		System.out.println("vetorchar[1] ="+vetorchar[1]);
                		System.out.println("vetorchar1[1] = "+vetorchar1[1]);
                		*/
                		JOptionPane.showMessageDialog(null, "Não foram inseridas embarcações/aeronaves suficientes\nDois 2, Um 3 e Um 4 serão lidos\nO formato a ser inserido é N LN,\nonde N é um número e L uma letra", "O formato não está correto", JOptionPane.ERROR_MESSAGE);
                		//System.out.println("aqui");
                	}
                	
                		br.close();
                }
            } catch (IOException ex) {
                //System.out.println("1b");
            	ex.printStackTrace();
            }
        }
	}

	
	public int getAleatorio1() {
		return this.aleatorio1;
	}
	public int getAleatorio2() {
	   return this.aleatorio2;
	}
	public void setAleatorio1(int a) {
	   this.aleatorio1 = a;
	}
	public void setAleatorio2(int a) {
		this.aleatorio2 = a;
	}
	public Celulas[][] getTestequalunidade() {
		return testequalunidade;
	}
	public void setTestequalunidade(Celulas[][] testequalunidade) {
		this.testequalunidade = testequalunidade;
	}
	public Celulas[][] getTablequalunidade() {
		return tablequalunidade;
	}
	public void setTablequalunidade(Celulas[][] tablequalunidade) {
		this.tablequalunidade = tablequalunidade;
	}
}
