package batalhanaval;
import java.awt.*; 
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Planejado extends JFrame implements ActionListener{
	
	private JButton table[][];//Matriz de botoes do player
	
	   private ImageIcon com = new ImageIcon("./confirmarcinza.png"); // Imagem do submarino
	   private JButton botaocom = new JButton(com); //Botao do tiro submarino
	
	   private ImageIcon sub = new ImageIcon("./submarino.png"); // Imagem do submarino
	   private JButton botaoS = new JButton(sub); //Botao do tiro submarino
	   
	   private ImageIcon jat = new ImageIcon("./jato.png");//Imagem do Jato
	   private JButton botaoJ = new JButton(jat); //Botao do tiro Jato
	   
	   private ImageIcon esc = new ImageIcon("./escolta.png"); //Imagem do Navio de escolta
	   private JButton botaoE = new JButton(esc); //Botao do tiro do Navio de escolta
	   
	   private ImageIcon porta = new ImageIcon("./portaavioes.png");//Imagem do porta avioes
	   private JButton botaoP = new JButton(porta); //Botao do tiro porta-avioes
	
	   private boolean colocadosub;
	   private boolean colocadojato;
	   private boolean colocadoesc;
	   private boolean colocadoporta;
	   
	   int cont=0;
	   
	private Celulas matrizcelulapc[][]; // matriz de celulas do pc
	private Celulas matrizcelulajogador[][]; // matriz de celulas do player
	
    private int qualunidade = 0;
	
    public Planejado(Celulas[][] MatrizPC) {
		super("Batalha Naval"); //Nome da janela
	    setSize(1100,1000); //Resolucao
	    setResizable(false); //Nao pode diminuir ou aumentar a tela
	    setDefaultCloseOperation(EXIT_ON_CLOSE);//Para de rodar quando fecha a janela
	    
	    this.matrizcelulapc = MatrizPC;
	    
	    this.matrizcelulajogador = new Celulas[10][10];
    
	    criarGrade(); //Cria o jogo
	    setVisible(true); //Deixa a janela visivel
	    
	    for(int i = 0; i < 10; i++)//Preenche matriz de botoes
	       {
	           for(int j = 0; j < 10; j++)
	           {
	        	   matrizcelulajogador[i][j] = new NaoCelula();
	           }
	       }
	}	
	
	private void criarGrade(){
	       
	       
	       ImageIcon icone = new ImageIcon("./vector-wave-009.jpg"); //Icone dos butoes
	       JPanel grade = new JPanel(); 
	       grade.setBackground(Color.white);//Setando o pano de fundo com a cor branca
	       grade.setLayout(new GridLayout(11,11));//Tamanho do Grid Layout (mod)
	       grade.setPreferredSize(new Dimension(100,23)); //faz merda nenhuma
	             
	       table = new JButton[10][10]; //Matriz de botoes do  jogador
	       
	       
	       for(int i = 0; i < 10; i++) //Preenche matriz de botoes
	       {
	           for(int j = 0; j < 10; j++)
	           {        
	              table[i][j] = new JButton(icone);  
	              table[i][j].setSize(new Dimension(328,328));
	              table[i][j].addActionListener(this);
	           }
	       }	       
	       
	       
	       //Coordenadas
	       grade.add(new Label("              "));
	       grade.add(new Label("       A "));  
	       grade.add(new Label("       B ")); 
	       grade.add(new Label("       C ")); 
	       grade.add(new Label("       D ")); 
	       grade.add(new Label("       E ")); 
	       grade.add(new Label("       F ")); 
	       grade.add(new Label("       G ")); 
	       grade.add(new Label("       H ")); 
	       grade.add(new Label("       I ")); 
	       grade.add(new Label("       J ")); 
	       
	       
	       //Matriz do jogador
	       grade.add(new Label("                          1"));
	    
	       for(int i=0; i<10; i++)    
	       {       
	            grade.add(table[0][i]);      
	       }
	        
	        grade.add(new Label("                          2"));
	        for(int i=0; i<10; i++)    
	        {    
	           grade.add(table[1][i]);
	        }
	        
	        grade.add(new Label("                          3"));
	        for(int i=0; i<10; i++)    
	        {    
	            grade.add(table[2][i]);
	        }
	        
	        grade.add(new Label("                          4"));
	        for(int i=0; i<10; i++)    
	        {    
	            grade.add(table[3][i]);
	        }
	        
	        grade.add(new Label("                          5"));
	        for(int i=0; i<10; i++)    
	        {    
	            grade.add(table[4][i]);
	        }
	        
	        grade.add(new Label("                          6"));
	        for(int i=0; i<10; i++)    
	        {    
	            grade.add(table[5][i]);
	        }
	        
	        grade.add(new Label("                          7"));
	        for(int i=0; i<10; i++)    
	        {    
	            grade.add(table[6][i]);
	        }
	        
	        grade.add(new Label("                          8"));
	        for(int i=0; i<10; i++)    
	        {    
	            grade.add(table[7][i]);
	        }
	        
	        grade.add(new Label("                          9"));
	        for(int i=0; i<10; i++)    
	        {    
	            grade.add(table[8][i]);
	        }
	        
	        grade.add(new Label("                          10"));
	        for(int i=0; i<10; i++)    
	        {    
	            grade.add(table[9][i]);
	        }

	        this.getContentPane().add(grade, BorderLayout.CENTER);
		    
	        JPanel navios = new JPanel();
		    navios.setLayout(new GridLayout(1,1));
		    
		    navios.add(botaoS);
		    botaoS.addActionListener(this);

		    navios.add(botaoJ);
		    botaoJ.addActionListener(this);
		    
		    navios.add(botaoE);
		    botaoE.addActionListener(this);

		    navios.add(botaoP);
		    botaoP.addActionListener(this);
	        
		    this.getContentPane().add(navios, BorderLayout.SOUTH);
		    
		    JPanel confirmar = new JPanel();
		    confirmar.setLayout(new GridLayout(1,1));
		    
		    confirmar.add(botaocom);
		    botaocom.addActionListener(this);
		    this.getContentPane().add(confirmar, BorderLayout.NORTH);
	     
	} 
	
	 public void actionPerformed(ActionEvent e) {//Esse soh o pc tem acesso 
	 	Object object = e.getSource();
	 

	 	
	 	if(object == botaoS)
	       {
	           botaoS.setIcon(new ImageIcon("./subclick.png"));
	           botaoJ.setIcon(new ImageIcon("./jato.png"));
	           botaoE.setIcon(new ImageIcon("./escolta.png"));
	           botaoP.setIcon(new ImageIcon("./portaavioes.png"));
	           cont = 1;
	       }
	       if(object == botaoJ)
	       {
	           botaoJ.setIcon(new ImageIcon("./jatclick.png"));
	           botaoE.setIcon(new ImageIcon("./escolta.png"));
	           botaoS.setIcon(new ImageIcon("./submarino.png"));
	           botaoP.setIcon(new ImageIcon("./portaavioes.png"));
	           cont = 2;
	       }
	       if(object == botaoE)
	       {
	           botaoE.setIcon(new ImageIcon("./escclick.png"));
	           botaoJ.setIcon(new ImageIcon("./jato.png"));
	           botaoS.setIcon(new ImageIcon("./submarino.png"));
	           botaoP.setIcon(new ImageIcon("./portaavioes.png"));
	           cont = 3;
	       }
	       
	       if(object == botaoP)
	       {
	           botaoE.setIcon(new ImageIcon("./escolta.png"));
	           botaoJ.setIcon(new ImageIcon("./jato.png"));
	           botaoS.setIcon(new ImageIcon("./submarino.png"));
	           botaoP.setIcon(new ImageIcon("./portaclick.png"));
	           cont = 4;
	       }
	 	
	       if(object == botaocom && qualunidade == 4) {
	    		this.dispose();
	    		BatalhaNaval b = new BatalhaNaval(matrizcelulajogador,matrizcelulapc);
	       }
	       
	 	for(int i = 0; i<10; i++) {
	 		for(int j = 0; j<10; j++) {
	 			if(object == table[i][j]) {
	 				if(j<9) {
		 				if(matrizcelulajogador[i][j] instanceof NaoCelula && matrizcelulajogador[i][j+1] instanceof NaoCelula && cont == 1 && colocadosub == false) {
		 					matrizcelulajogador[i][j] = new Submarino1();
		 					matrizcelulajogador[i][j+1] = new Submarino2();
		 					table[i][j].setIcon(new ImageIcon("./sub1.png"));
		 					table[i][j+1].setIcon(new ImageIcon("./sub2.png"));
		 					qualunidade++;
		 					colocadosub = true;
		 				}
		 				if(matrizcelulajogador[i][j] instanceof NaoCelula && matrizcelulajogador[i][j+1] instanceof NaoCelula  && cont == 2 && colocadojato == false) {
		 					matrizcelulajogador[i][j] = new Jato1();
		 					matrizcelulajogador[i][j+1] = new Jato2();
		 					table[i][j].setIcon(new ImageIcon("./jato1.png"));
		 					table[i][j+1].setIcon(new ImageIcon("./jato2.png"));;
		 					qualunidade++;
		 					colocadojato = true;
		 				}
		 				if(j<8) {
			 				if(matrizcelulajogador[i][j] instanceof NaoCelula && matrizcelulajogador[i][j+1] instanceof NaoCelula && matrizcelulajogador[i][j+2] instanceof NaoCelula  && cont == 3 && colocadoesc == false) {
			 					matrizcelulajogador[i][j] = new Escolta1();
								matrizcelulajogador[i][j+1] = new Escolta2(); 						
								matrizcelulajogador[i][j+2] = new Escolta3();
			 					table[i][j].setIcon(new ImageIcon("./esc1.png"));
			 					table[i][j+1].setIcon(new ImageIcon("./esc2.png"));
			 					table[i][j+2].setIcon(new ImageIcon("./esc3.png"));
			 					qualunidade++;
			 					colocadoesc = true;
			 				}
			 				if(j<7)
				 				if(matrizcelulajogador[i][j] instanceof NaoCelula && matrizcelulajogador[i][j+1] instanceof NaoCelula && matrizcelulajogador[i][j+2] instanceof NaoCelula && matrizcelulajogador[i][j+3] instanceof NaoCelula  && cont == 4 && colocadoporta == false) {
				 					matrizcelulajogador[i][j] = new Porta1();
									matrizcelulajogador[i][j+1] = new Porta2(); 						
									matrizcelulajogador[i][j+2] = new Porta3();
				 					matrizcelulajogador[i][j+3] = new Porta4();
				 					table[i][j].setIcon(new ImageIcon("./porta1.png"));
				 					table[i][j+1].setIcon(new ImageIcon("./porta2.png"));
				 					table[i][j+2].setIcon(new ImageIcon("./porta3.png"));
				 					table[i][j+3].setIcon(new ImageIcon("./porta4.png"));
				 					qualunidade++;
				 					colocadoporta = true;
				 				}
		 				}
	 				}
		 				if(qualunidade==4) {
		 					botaocom.setIcon(new ImageIcon("./confirmar.png"));
	 				}	
	 				
	 				else{
	 					if(j>=9 && cont == 1) {
	 						JOptionPane.showMessageDialog(null, "Espaço muito pequeno para o Submarino", "Posicionamento Inválido", JOptionPane.ERROR_MESSAGE);
	 					}
	 					if(j>=9 && cont == 2) {
	 						JOptionPane.showMessageDialog(null, "Espaço muito pequeno para o Jato", "Posicionamento Inválido", JOptionPane.ERROR_MESSAGE);
	 						
	 					}
	 					if(j>=8 && cont == 3) {
	 						JOptionPane.showMessageDialog(null, "Espaço muito pequeno para o Navio de Escolta", "Posicionamento Inválido", JOptionPane.ERROR_MESSAGE);
	 						
	 					}
	 					if(j>=7 && cont == 4) {
	 						JOptionPane.showMessageDialog(null, "Espaço muito pequeno para o Porta-aviões", "Posicionamento Inválido", JOptionPane.ERROR_MESSAGE);
	 					}	
	 				}
	 			}
	 		}
	 	}
	 	
	 
	 }
}
