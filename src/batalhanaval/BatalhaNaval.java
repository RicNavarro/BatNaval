package batalhanaval;
import java.awt.*; 
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BatalhaNaval extends JFrame implements ActionListener
{ 
   private JButton table[][];//Matriz de botoes do player
   private Celulas matrizcelulajogador[][]; // matriz de celulas do player
   private JButton teste[][];//matriz de botoes do pc
   private Celulas matrizcelulapc[][]; // matriz de celulas do pc
   
   private boolean jaclicou[][] = new boolean [10][10]; // Matriz de boolean do pc
   private boolean pcjaclicou[][] = new boolean [10][10]; //Matriz de boolean do player (Sim, esta ao contrario)
   
   private PC pc = new PC(); //PC 
 
   private int aleatorio1;
   private int aleatorio2;
   
   private int cont = 0; //Contador do botao
   private int contif = 0;
   private int contifJ = 0; 
   private int contifE = 0; 
   private int contadorsupremo = 0;
   private int contSPC = 0; 
   private int contJPC = 0; 
   private int contEPC = 0; 
   
   private ImageIcon sub = new ImageIcon("./submarino.png"); // Imagem do submarino
   private JButton botaoS = new JButton(sub); //Botao do tiro submarino
   
   private ImageIcon jat = new ImageIcon("./jato.png");//Imagem do Jato
   private JButton botaoJ = new JButton(jat); //Botao do tiro Jato
   
   private ImageIcon esc = new ImageIcon("./escolta.png"); //Imagem do Navio de escolta
   private JButton botaoE = new JButton(esc); //Botao do tiro do Navio de escolta
   
   private ImageIcon rein = new ImageIcon("./sair.png");//Imagem do porta avioes
   private JButton exit = new JButton(rein); //Botao do tiro porta-avioes

   private ImageIcon tip = new ImageIcon("./dica.png");//Imagem do porta avioes
   private JButton dica = new JButton(tip); //Botao do tiro porta-avioes
   
   private Submarino1 s1inimigo = new Submarino1();//Celula1 do submarino inimigo
   private Submarino2 s2inimigo = new Submarino2();//Celula2 do submarino inimigo
   
   private Jato1 j1inimigo = new Jato1(); //Celula1 do jato inimigo
   private Jato2 j2inimigo = new Jato2(); //Celula2 do jato inimigo
   
   private Escolta1 e1inimigo = new Escolta1();//Celula1 do navio de escolta inimigo
   private Escolta2 e2inimigo = new Escolta2();//Celula2 do navio de escolta inimigo
   private Escolta3 e3inimigo = new Escolta3();//Celula3 do navio de escolta inimigo
   
   private Porta1 p1inimigo = new Porta1(); //Celula1 do porta-avioes
   private Porta2 p2inimigo = new Porta2(); //Celula2 do porta-avioes
   private Porta3 p3inimigo = new Porta3(); //Celula3 do porta-avioes
   private Porta4 p4inimigo = new Porta4(); //Celula4 do porta-avioes
   
   private Submarino1 s1amigo = new Submarino1();//Celula1 do submarino inimigo
   private Submarino2 s2amigo = new Submarino2();//Celula2 do submarino inimigo
   
   private Jato1 j1amigo = new Jato1(); //Celula1 do jato inimigo
   private Jato2 j2amigo = new Jato2(); //Celula2 do jato inimigo
   
   private Escolta1 e1amigo = new Escolta1();//Celula1 do navio de escolta inimigo
   private Escolta2 e2amigo = new Escolta2();//Celula2 do navio de escolta inimigo
   private Escolta3 e3amigo = new Escolta3();//Celula3 do navio de escolta inimigo
   
   private Porta1 p1amigo = new Porta1(); //Celula1 do porta-avioes
   private Porta2 p2amigo = new Porta2(); //Celula2 do porta-avioes
   private Porta3 p3amigo = new Porta3(); //Celula3 do porta-avioes
   private Porta4 p4amigo = new Porta4(); //Celula4 do porta-avioes
   
   private ImageIcon sub1 = new ImageIcon("./sub1.jpg");
   private ImageIcon sub2 = new ImageIcon("./sub2.jpg"); 
   private ImageIcon jato1 = new ImageIcon("./jato1.jpg");
   private ImageIcon jato2 = new ImageIcon("./jato2.jpg");
   private ImageIcon esc1 = new ImageIcon("./esc1.jpg");
   private ImageIcon esc2 = new ImageIcon("./esc2.jpg");
   private ImageIcon esc3 = new ImageIcon("./esc3.jpg");
   private ImageIcon port1 = new ImageIcon("./port1.jpg");
   private ImageIcon port2 = new ImageIcon("./port2.jpg");
   private ImageIcon port3 = new ImageIcon("./port3.jpg");
   private ImageIcon port4 = new ImageIcon("./port4.jpg");
   private ImageIcon naocelula = new ImageIcon("./vector-wave-008.jpg");
   
   private boolean dicaativada = false;
   private int quantasdicas = 0;
   
   public BatalhaNaval(Celulas[][] MatrizJogador, Celulas[][] MatrizPC)
   {
       super("Batalha Naval"); //Nome da janela
       setSize(1280,720); //Resolucao
       setResizable(false); //Nao pode diminuir ou aumentar a tela
       setDefaultCloseOperation(EXIT_ON_CLOSE);//Para de rodar quando fecha a janela
       
       this.matrizcelulajogador = MatrizJogador;
       this.matrizcelulapc = MatrizPC;
       this.setLocationRelativeTo(null);
       
       criarGrade(); //Cria o jogo
       setVisible(true); //Deixa a janela visivel
   } 
   private void criarGrade(){
       
       
       ImageIcon icone = new ImageIcon("./vector-wave-009.jpg"); //Icone dos butoes
       JPanel grade = new JPanel(); 
       JPanel grade1 = new JPanel(); 
      // grade.setBackground();//Setando o pano de fundo com a cor branca
       grade.setLayout(new GridLayout(10,12));//Tamanho do Grid Layout (mod)
       grade1.setLayout(new GridLayout(10,12));
       //grade.setPreferredSize(new Dimension(100,23)); //faz merda nenhuma
             
       table = new JButton[10][10]; //Matriz de botoes do  jogador
       teste = new JButton[10][10]; //Matriz de botoes do PC
       
       
       for(int i = 0; i < 10; i++) //Preenche matriz de botoes
       {
           for(int j = 0; j < 10; j++)
           {        
              table[i][j] = new JButton(icone);  
              table[i][j].setSize(new Dimension(328,328));
              table[i][j].addActionListener(this);
           }
       }
       
       for(int i = 0; i < 10; i++)//Preenche matriz de botoes
       {
           for(int j = 0; j < 10; j++)
           {
            teste[i][j] = new JButton(icone);
            teste[i][j].setPreferredSize(new Dimension(328,328));
            teste[i][j].addActionListener(this);
           }
       }
       
       
       
       //Coordenadas
       /*grade.add(new Label("              "));
       grade.add(new Label("       A "));  
       grade.add(new Label("       B ")); 
       grade.add(new Label("       C ")); 
       grade.add(new Label("       D ")); 
       grade.add(new Label("       E ")); 
       grade.add(new Label("       F ")); 
       grade.add(new Label("       G ")); 
       grade.add(new Label("       H ")); 
       grade.add(new Label("       I ")); 
       grade.add(new Label("       J ")); */
       
       
       //Matriz do jogador
       //grade.add(new Label("                          1"));
    
       for(int i=0; i<10; i++)    
       {       
            grade.add(table[0][i]);      
       }
        
        //grade.add(new Label("                          2"));
        for(int i=0; i<10; i++)    
        {    
           grade.add(table[1][i]);
        }
        
        //grade.add(new Label("                          3"));
        for(int i=0; i<10; i++)    
        {    
            grade.add(table[2][i]);
        }
        
        //grade.add(new Label("                          4"));
        for(int i=0; i<10; i++)    
        {    
            grade.add(table[3][i]);
        }
        
        //grade.add(new Label("                          5"));
        for(int i=0; i<10; i++)    
        {    
            grade.add(table[4][i]);
        }
        
        //grade.add(new Label("                          6"));
        for(int i=0; i<10; i++)    
        {    
            grade.add(table[5][i]);
        }
        
        //grade.add(new Label("                          7"));
        for(int i=0; i<10; i++)    
        {    
            grade.add(table[6][i]);
        }
        
        //grade.add(new Label("                          8"));
        for(int i=0; i<10; i++)    
        {    
            grade.add(table[7][i]);
        }
        
        //grade.add(new Label("                          9"));
        for(int i=0; i<10; i++)    
        {    
            grade.add(table[8][i]);
        }
        
        //grade.add(new Label("                          10"));
        for(int i=0; i<10; i++)    
        {    
            grade.add(table[9][i]);
        }
      
        
        
        //Matriz inimiga 
        
        /*grade.add(new Label("              "));
        grade.add(new Label("       A "));  
        grade.add(new Label("       B ")); 
        grade.add(new Label("       C ")); 
        grade.add(new Label("       D ")); 
        grade.add(new Label("       E ")); 
        grade.add(new Label("       F ")); 
        grade.add(new Label("       G ")); 
        grade.add(new Label("       H ")); 
        grade.add(new Label("       I ")); 
        grade.add(new Label("       J ")); */
        
        //grade1.add(new Label("                          11"));
        for(int i=0; i<10; i++)    
        {    
            grade1.add(teste[0][i]);
        }
        
        //grade1.add(new Label("                          11"));
        for(int i = 0; i < 10; i++)
        {
            grade1.add(teste[1][i]);
        }
        
        //grade1.add(new Label("                          11"));
        for(int i = 0; i < 10; i++)
        {
            grade1.add(teste[2][i]);
        }
        
        //grade1.add(new Label("                          11"));
        for(int i = 0; i < 10; i++)
        {
            grade1.add(teste[3][i]);
        }
        
        //grade1.add(new Label("                          11"));
        for(int i = 0; i < 10; i++)
        {
            grade1.add(teste[4][i]);
        }
        
        //grade1.add(new Label("                          11"));
        for(int i = 0; i < 10; i++)
        {
            grade1.add(teste[5][i]);
        }
        
        //grade1.add(new Label("                          11"));
        for(int i = 0; i < 10; i++)
        {
            grade1.add(teste[6][i]);
        }
        
        //grade1.add(new Label("                          11"));
        for(int i = 0; i < 10; i++)
        {
            grade1.add(teste[7][i]);
        }
        
        //grade1.add(new Label("                          11"));
        for(int i = 0; i < 10; i++)
        {
            grade1.add(teste[8][i]);
        }
        
        //grade1.add(new Label("                          11"));
        for(int i = 0; i < 10; i++)
        {
            grade1.add(teste[9][i]);
        }

        Fundo f = new Fundo("./lab.png"); 
        Fundo fundo = new Fundo("./bg.png");
        
        
        
        this.getContentPane().setLayout(null);
        
         
        this.getContentPane().add(grade);
        this.getContentPane().add(grade1); 
        this.getContentPane().add(exit); 
        this.getContentPane().add(dica);
        this.getContentPane().add(botaoS);
        this.getContentPane().add(botaoJ);
        this.getContentPane().add(botaoE);
        dica.setBackground(Color.white); 
        exit.setBackground(Color.white); 
        botaoS.setBackground(Color.white);
        botaoJ.setBackground(Color.white);
        botaoE.setBackground(Color.white);
        
        
        
        fundo.setBounds(0, 0, 1100, 1000);
        grade.setBounds(820,35,430,300); 
        grade1.setBounds(820,370,430,300);
        dica.setBounds(20,220,250,100); 
        exit.setBounds(20,320,250,100);
        botaoS.setBounds(20,580,250,100);
        botaoJ.setBounds(270,580,250,100);
        botaoE.setBounds(520,580,260,100);
        
        this.getContentPane().add(fundo);
        this.getContentPane().add(f);
        
        /*this.getContentPane().add(f, BorderLayout.EAST);
        this.getContentPane().add(grade, BorderLayout.CENTER);
        this.getContentPane().add(fundo, BorderLayout.WEST); */
        
        
        // Background
        /*ImageIcon bg = new ImageIcon("./bg.png");         
        JLabel animegirl = new JLabel(bg); 
        animegirl.setBackground(Color.white);*/
        
        
        
         
        
        //Matriz clicou ou n do PC
        for(int i = 0; i < 10; i++)
        {
            for(int j = 0; j < 10; j++)
            {
                jaclicou[i][j] = false; 
            }
        }
        
        //Matriz clicou ou n Nossa
        for(int i = 0; i < 10; i++)
        {
            for(int j = 0; j < 10; j++)
            {
                pcjaclicou[i][j] = false; 
            }
        }
        
        //Bottom:
        
        //Tiro Submarino:
       
        
	for(int i=0; i<10; i++) {
            for(int j=0; j<10; j++) {
					
                if(this.matrizcelulapc[i][j] instanceof Submarino1) {
        		s1inimigo = (Submarino1) this.matrizcelulapc[i][j];
        		//System.out.println(s1inimigo);
        		s2inimigo = (Submarino2) this.matrizcelulapc[i][j+1];
        		
        		}
        	}	
        }

        botaoS.addActionListener(this);
        
        //Jato
      
       
        for(int i=0; i<10; i++) {
        	for(int j=0; j<10; j++) {
			
        		if(this.matrizcelulapc[i][j] instanceof Jato1) {
        			j1inimigo = (Jato1) this.matrizcelulapc[i][j];
        			
        			j2inimigo = (Jato2) this.matrizcelulapc[i][j+1];
        		
        		}
        	}	
        }
        botaoJ.addActionListener(this); 
        
  
        //Navio de Escolta
     
        
        for(int i=0; i<10; i++) {
        	for(int j1=0; j1<10; j1++) {
				
        		//System.out.println(matrizcelulapc[i][j]);
        		
        		if(this.matrizcelulapc[i][j1] instanceof Escolta1) {
        			e1inimigo = (Escolta1) this.matrizcelulapc[i][j1];
        			//System.out.println(s1inimigo);
        			e2inimigo = (Escolta2) this.matrizcelulapc[i][j1+1];
        			e3inimigo = (Escolta3) this.matrizcelulapc[i][j1+2];
        		}
        	}	
        }
        
        botaoE.addActionListener(this);
    
        dica.addActionListener(this);
        exit.addActionListener(this);
        //Porta-avioes
       
       
        for(int i=0; i<10; i++) {
        	for(int j1=0; j1<10; j1++) {
				
        		//System.out.println(matrizcelulapc[i][j]);
        		
        		if(this.matrizcelulapc[i][j1] instanceof Porta1) {

        			p1inimigo = (Porta1) this.matrizcelulapc[i][j1];
        			//System.out.println(s1inimigo);
        			p2inimigo = (Porta2) this.matrizcelulapc[i][j1+1];
        			p3inimigo = (Porta3) this.matrizcelulapc[i][j1+2];
        			p4inimigo = (Porta4) this.matrizcelulapc[i][j1+3];
        		}
        	}	
        }
       
        
        
        
        
        
        for(int i=0; i<10; i++) {
        	for(int j=0; j<10; j++) {
			
        		if(this.matrizcelulajogador[i][j] instanceof Submarino1) {
            		table[i][j].setIcon(new ImageIcon("./sub1.png"));
            		table[i][j+1].setIcon(new ImageIcon("./sub2.png"));
            	}	
        		if(this.matrizcelulajogador[i][j] instanceof Jato1) {
            		table[i][j].setIcon(new ImageIcon("./jato1.png"));
            		table[i][j+1].setIcon(new ImageIcon("./jato2.png"));
        		
        		}
        		if(this.matrizcelulajogador[i][j] instanceof Escolta1) {
        			table[i][j].setIcon(new ImageIcon("./esc1.png"));
            		table[i][j+1].setIcon(new ImageIcon("./esc2.png"));
            		table[i][j+2].setIcon(new ImageIcon("./esc3.png"));
        		}
        		
        		if(this.matrizcelulajogador[i][j] instanceof Porta1) {
                        table[i][j].setIcon(new ImageIcon("./porta1.png"));
            		table[i][j+1].setIcon(new ImageIcon("./porta2.png"));
            		table[i][j+2].setIcon(new ImageIcon("./porta3.png"));
            		table[i][j+3].setIcon(new ImageIcon("./porta4.png"));
        		}
        	}	
        }
        

   }
   
   @Override
   public void actionPerformed(ActionEvent e)
   { 
       Object object = e.getSource();
       int foi = 1;
       int posicaox, posicaoy; 
       Random random = new Random();
       int rand;

        
    
     
    if(contadorsupremo == 0) 
    {
        if(object == exit) 
        {
            Menu m = new Menu(matrizcelulajogador, matrizcelulapc);
        }
if(object == dica) 
{
        if(quantasdicas < 3 && quantasdicas==0) 
        {
                dicaativada = true;
                dica.setIcon(new ImageIcon("./clickdica.png"));
        }else
        if(quantasdicas < 3 && quantasdicas==1) 
        {
                dicaativada = true;
                dica.setIcon(new ImageIcon("./clickdica1.png"));
        }else
        if(quantasdicas < 3 && quantasdicas==2) 
        {
                dicaativada = true;
                dica.setIcon(new ImageIcon("./clickdica2.png"));
        }
        else 
        {
                JOptionPane.showMessageDialog(null, "S�o permitidas apenas 3 dicas por partida", "Limite excedido", JOptionPane.WARNING_MESSAGE);	
        }
        botaoE.setIcon(new ImageIcon("./escolta.png"));
        botaoJ.setIcon(new ImageIcon("./jato.png"));
        botaoS.setIcon(new ImageIcon("./submarino.png"));
        cont = 0;
}

for(int i4=0;i4<10;i4++) 
{
        for(int j4=0;j4<10;j4++) 
        {
                if(object == teste[i4][j4] && dicaativada == true) 
                {
                        dicaativada = false;
                        quantasdicas++;
                        for(int p=0;p<10;p++) 
                        {
                                if(matrizcelulapc[i4][p] instanceof Celulas && !(matrizcelulapc[i4][p] instanceof NaoCelula)) 
                                {
                                        JOptionPane.showMessageDialog(null, "Restam embacações nessa linha", "Dica", JOptionPane.INFORMATION_MESSAGE);
                                        dica.setIcon(new ImageIcon("./dica.png"));
                                        break;
                                }
                                else 
                                { 
                                        if (p==9)
                                        {
                                        JOptionPane.showMessageDialog(null, "Não restam embacações nessa linha", "Dica", JOptionPane.INFORMATION_MESSAGE);	
                                        dica.setIcon(new ImageIcon("./dica.png"));
                                        }
                }
        }	
}

}
}

       if(object == botaoS)
        {
           if(s1amigo.getVivo() == true || s2amigo.getVivo() == true)
           {
                botaoS.setIcon(new ImageIcon("./subclick.png"));
                botaoJ.setIcon(new ImageIcon("./jato.png"));
                botaoE.setIcon(new ImageIcon("./escolta.png"));
                cont = 1;
           }
           else
           {
               cont = 0; 
           }
           dica.setIcon(new ImageIcon("./dica.png")); 
           dicaativada = false; 
        }
       
       
       if(object == botaoJ)
       {
           if(j1amigo.getVivo() == true || j2amigo.getVivo() == true)
           {
               botaoJ.setIcon(new ImageIcon("./jatclick.png"));
               botaoE.setIcon(new ImageIcon("./escolta.png"));
               botaoS.setIcon(new ImageIcon("./submarino.png"));
               cont = 3;
           }
           else
           {
               cont = 0; 
           }
           dica.setIcon(new ImageIcon("./dica.png")); 
           dicaativada = false; 
       }
       if(object == botaoE)
       {
           if(e1amigo.getVivo() == true || e2amigo.getVivo() == true || e3amigo.getVivo() == true)
           {
               botaoE.setIcon(new ImageIcon("./escclick.png"));
               botaoJ.setIcon(new ImageIcon("./jato.png"));
               botaoS.setIcon(new ImageIcon("./submarino.png"));
               cont = 2;
           }
           else 
           {
               cont = 0;
           }
           dica.setIcon(new ImageIcon("./dica.png")); 
           dicaativada = false; 
       }
       
       
    }   
     
    if(cont == 1 && dicaativada == false)//Player clica
    { 
	for(int i = 0; i<10 ; i++)
        {
            for(int j = 0; j<10 ; j++)
            {
            	if(jaclicou[i][j] == false) 
                {
	            if(object == teste[i][j])
                    {
                        if(matrizcelulapc[i][j] instanceof Submarino1)
                        {
                            teste[i][j].setIcon(sub1);
                            s1inimigo.setVivo(false);
                        }
                        if(matrizcelulapc[i][j] instanceof Submarino2)
                        {
                            teste[i][j].setIcon(sub2);
                            s2inimigo.setVivo(false);
                        }
                        if(matrizcelulapc[i][j] instanceof Jato1)
                        {
                            teste[i][j].setIcon(jato1);
                            j1inimigo.setVivo(false);
                        }
                        if(matrizcelulapc[i][j] instanceof Jato2)
                        {
                            teste[i][j].setIcon(jato2);
                            j2inimigo.setVivo(false);
                        }
                        if(matrizcelulapc[i][j] instanceof Escolta1)
                        {
                            teste[i][j].setIcon(esc1);
                            e1inimigo.setVivo(false);
                        }
                        if(matrizcelulapc[i][j] instanceof Escolta2)
                        {
                            teste[i][j].setIcon(esc2);
                            e2inimigo.setVivo(false);
                        }
                        if(matrizcelulapc[i][j] instanceof Escolta3)
                        {
                            teste[i][j].setIcon(esc3);
                            e3inimigo.setVivo(false);
                        }
                        if(matrizcelulapc[i][j] instanceof Porta1)
                        {
                            teste[i][j].setIcon(port1);
                            p1inimigo.setVivo(false);
                        }
                        if(matrizcelulapc[i][j] instanceof Porta2)
                        {
                            teste[i][j].setIcon(port2);
                            p2inimigo.setVivo(false);
                        }
                        if(matrizcelulapc[i][j] instanceof Porta3)
                        {
                            teste[i][j].setIcon(port3);
                            p3inimigo.setVivo(false);
                        }
                        if(matrizcelulapc[i][j] instanceof Porta4)
                        {
                            teste[i][j].setIcon(port4); 
                            p4inimigo.setVivo(false);
                        }
                        if(matrizcelulapc[i][j] instanceof NaoCelula)
                        {
                            teste[i][j].setIcon(naocelula);
                        }
                        jaclicou[i][j] = true; 
                        if(s1inimigo.getVivo() == false && s2inimigo.getVivo() == false && j1inimigo.getVivo() == false && j2inimigo.getVivo() == false && e1inimigo.getVivo() == false && e2inimigo.getVivo() == false && e3inimigo.getVivo() == false)
                        {
                            win(); 
                        }
                        if(s1inimigo.getVivo() == false && s2inimigo.getVivo() == false)
                        {
                            contSPC = 1; 
                        }
                        if(j1inimigo.getVivo() == false && j2inimigo.getVivo() == false)
                        {
                            contJPC = 1; 
                        }
                        if(e1inimigo.getVivo() == false && e2inimigo.getVivo() == false && e3inimigo.getVivo() == false)
                        {
                            contEPC = 1; 
                        }
                        for(int k = 0; k < 1; k++) //Aqui
                        {
                            rand = random.nextInt(4);
                            if(rand == 1 && contSPC == 1){k = -1;}
                            if(rand == 2 && contEPC == 1){k = -1;}
                            if(rand == 3 && contJPC == 1){k = -1;}
                            if(rand != 0)
                            {
                               if(rand == 1 && contSPC == 0)
                               {
                                   for(int l = 0; l < 1; l++)
                                   {
                                       posicaox = random.nextInt(10);
                                       posicaoy = random.nextInt(10);
                                       if(pcjaclicou[posicaox][posicaoy] == false)
                                       {
                                           if(matrizcelulajogador[posicaox][posicaoy] instanceof Submarino1)
                                           {
                                               table[posicaox][posicaoy].setIcon(sub1);
                                               s1amigo.setVivo(false);
                                           }
                                           if(matrizcelulajogador[posicaox][posicaoy] instanceof Submarino2)
                                           {
                                               table[posicaox][posicaoy].setIcon(sub2);
                                               s2amigo.setVivo(false);
                                           }
                                           if(matrizcelulajogador[posicaox][posicaoy] instanceof Jato1)
                                           {
                                               table[posicaox][posicaoy].setIcon(jato1);
                                               j1amigo.setVivo(false);
                                           }
                                           if(matrizcelulajogador[posicaox][posicaoy] instanceof Jato2)
                                           {
                                               table[posicaox][posicaoy].setIcon(jato2);
                                               j2amigo.setVivo(false);
                                           }
                                           if(matrizcelulajogador[posicaox][posicaoy] instanceof Escolta1)
                                           {
                                               table[posicaox][posicaoy].setIcon(esc1);
                                               e1amigo.setVivo(false);
                                           }
                                           if(matrizcelulajogador[posicaox][posicaoy] instanceof Escolta2)
                                           {
                                               table[posicaox][posicaoy].setIcon(esc2);
                                               e2amigo.setVivo(false);
                                           }
                                           if(matrizcelulajogador[posicaox][posicaoy] instanceof Escolta3)
                                           {
                                               table[posicaox][posicaoy].setIcon(esc3);
                                               e3amigo.setVivo(false);
                                           }
                                           if(matrizcelulajogador[posicaox][posicaoy] instanceof Porta1)
                                           {
                                               table[posicaox][posicaoy].setIcon(port1);
                                               p1amigo.setVivo(false);
                                           }
                                           if(matrizcelulajogador[posicaox][posicaoy] instanceof Porta2)
                                           {
                                               table[posicaox][posicaoy].setIcon(port2);
                                               p2amigo.setVivo(false);
                                           }
                                           if(matrizcelulajogador[posicaox][posicaoy] instanceof Porta3)
                                           {
                                               table[posicaox][posicaoy].setIcon(port3);
                                               p3amigo.setVivo(false);
                                           }
                                           if(matrizcelulajogador[posicaox][posicaoy] instanceof Porta4)
                                           {
                                               table[posicaox][posicaoy].setIcon(port4); 
                                               p4amigo.setVivo(false);
                                           }
                                           if(matrizcelulajogador[posicaox][posicaoy] instanceof NaoCelula)
                                           {
                                               table[posicaox][posicaoy].setIcon(naocelula);
                                           }
                                           if(contif == 0)
                                            {
                                                 if(s1amigo.getVivo() == false && s2amigo.getVivo() == false)
                                                 {
                                                    botaoS.setBackground(Color.red);
                                                    botaoS.setIcon(new ImageIcon("./submarino.png"));
                                                    cont = 0; 
                                                    contif = 1;
                                                 }
                                            }
                                            if(contifJ == 0) //fazer o jato ficar vermelho
                                            {
                                                 if(j1amigo.getVivo() == false && j2amigo.getVivo() == false)
                                                 {
                                                    botaoJ.setBackground(Color.red);
                                                    botaoJ.setIcon(new ImageIcon("./jato.png"));
                                                    cont = 0; 
                                                    contifJ = 1;
                                                 }
                                            }
                                            if(contifE == 0) //fazer o escolta ficar vermelho
                                            {
                                                 if(e1amigo.getVivo() == false && e2amigo.getVivo() == false && e3amigo.getVivo() == false)
                                                 {
                                                    botaoE.setBackground(Color.red);
                                                    botaoE.setIcon(new ImageIcon("./escolta.png"));
                                                    cont = 0; 
                                                    contifE = 1;
                                                 }
                                            }
                                             if(s1inimigo.getVivo() == false && s2inimigo.getVivo() == false && j1inimigo.getVivo() == false && j2inimigo.getVivo() == false && e1inimigo.getVivo() == false && e2inimigo.getVivo() == false && e3inimigo.getVivo() == false)
                                                {
                                                    win();
                                                }
                                                pcjaclicou[posicaox][posicaoy] = true;
                                       }
                                       else
                                       {
                                           l = -1; 
                                       }
                                   }
                                }
                               if(rand == 2 && contEPC == 0) //ra
                               {
                                   for(int l = 0; l < 1; l++)
                                   {
                                       posicaox = random.nextInt(10);
                                       posicaoy = random.nextInt(10);
                                       if(pcjaclicou[posicaox][posicaoy] == false)
                                       {
                                           if(matrizcelulajogador[posicaox][posicaoy] instanceof Submarino1)
                                           {
                                               table[posicaox][posicaoy].setIcon(sub1);
                                               s1amigo.setVivo(false);
                                               
                                               table[posicaox][posicaoy + 1].setIcon(sub2);
                                               s2amigo.setVivo(false);     
                                           }
                                           if(matrizcelulajogador[posicaox][posicaoy] instanceof Submarino2)
                                           {
                                               table[posicaox][posicaoy].setIcon(sub2);
                                               s2amigo.setVivo(false);
                                               
                                               if(posicaoy + 1 < 10)
                                               {
                                                   if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof Jato1)
                                                   {
                                                       table[posicaox][posicaoy + 1].setIcon(jato1);
                                                       j1amigo.setVivo(false); 
                                                   }
                                                   if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof Escolta1)
                                                   {
                                                       table[posicaox][posicaoy + 1].setIcon(esc1);
                                                       e1amigo.setVivo(false); 
                                                   }
                                                   if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof Porta1)
                                                   {
                                                       table[posicaox][posicaoy + 1].setIcon(port1);
                                                       p1amigo.setVivo(false); 
                                                   }
                                                   if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof NaoCelula)
                                                   {
                                                       table[posicaox][posicaoy + 1].setIcon(naocelula); 
                                                   }
                                               }
                                           }
                                           if(matrizcelulajogador[posicaox][posicaoy] instanceof Jato1)
                                           {
                                               table[posicaox][posicaoy].setIcon(jato1);
                                               j1amigo.setVivo(false);
                                               
                                               table[posicaox][posicaoy + 1].setIcon(jato2);
                                               j2amigo.setVivo(false);  
                                           }
                                           if(matrizcelulajogador[posicaox][posicaoy] instanceof Jato2)
                                           {
                                               table[posicaox][posicaoy].setIcon(jato2);
                                               j2amigo.setVivo(false);
                                               
                                               if(posicaoy + 1 < 10)
                                               {
                                                   if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof Submarino1)
                                                   {
                                                       table[posicaox][posicaoy + 1].setIcon(sub1);
                                                       s1amigo.setVivo(false); 
                                                   }
                                                   if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof Escolta1)
                                                   {
                                                       table[posicaox][posicaoy + 1].setIcon(esc1);
                                                       e1amigo.setVivo(false); 
                                                   }
                                                   if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof Porta1)
                                                   {
                                                       table[posicaox][posicaoy + 1].setIcon(port1);
                                                       p1amigo.setVivo(false); 
                                                   }
                                                   if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof NaoCelula)
                                                   {
                                                       table[posicaox][posicaoy + 1].setIcon(naocelula); 
                                                   }
                                               }
                                           }
                                           if(matrizcelulajogador[posicaox][posicaoy] instanceof Escolta1)
                                           {
                                               table[posicaox][posicaoy].setIcon(esc1);
                                               e1amigo.setVivo(false);
                                               
                                               table[posicaox][posicaoy + 1].setIcon(esc2);
                                               e2amigo.setVivo(false);  
                                           }
                                           if(matrizcelulajogador[posicaox][posicaoy] instanceof Escolta2)
                                           {
                                               table[posicaox][posicaoy].setIcon(esc2);
                                               e2amigo.setVivo(false);
                                               
                                               table[posicaox][posicaoy + 1].setIcon(esc3);
                                               e3amigo.setVivo(false);  
                                           }//le
                                           if(matrizcelulajogador[posicaox][posicaoy] instanceof Escolta3)
                                           {
                                               table[posicaox][posicaoy].setIcon(esc3);
                                               e3amigo.setVivo(false);
                                               
                                               if(posicaoy + 1 < 10)
                                               {
                                                   if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof Submarino1)
                                                   {
                                                       table[posicaox][posicaoy + 1].setIcon(sub1);
                                                       s1amigo.setVivo(false); 
                                                   }
                                                   if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof Jato1)
                                                   {
                                                       table[posicaox][posicaoy + 1].setIcon(jato1);
                                                       j1amigo.setVivo(false); 
                                                   }
                                                   if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof Porta1)
                                                   {
                                                       table[posicaox][posicaoy + 1].setIcon(port1);
                                                       p1amigo.setVivo(false); 
                                                   }
                                                   if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof NaoCelula)
                                                   {
                                                       table[posicaox][posicaoy + 1].setIcon(naocelula); 
                                                   }
                                               }
                                           }
                                           if(matrizcelulajogador[posicaox][posicaoy] instanceof Porta1)
                                           {
                                               table[posicaox][posicaoy].setIcon(port1);
                                               p1amigo.setVivo(false);
                                               
                                               table[posicaox][posicaoy + 1].setIcon(port2);
                                               p2amigo.setVivo(false);  
                                           }
                                           if(matrizcelulajogador[posicaox][posicaoy] instanceof Porta2)
                                           {
                                               table[posicaox][posicaoy].setIcon(port2);
                                               p2amigo.setVivo(false);
                                               
                                               table[posicaox][posicaoy + 1].setIcon(port3);
                                               p3amigo.setVivo(false);  
                                           }
                                           if(matrizcelulajogador[posicaox][posicaoy] instanceof Porta3)
                                           {
                                               table[posicaox][posicaoy].setIcon(port3);
                                               p3amigo.setVivo(false);
                                               
                                               table[posicaox][posicaoy + 1].setIcon(port4); 
                                               p4amigo.setVivo(false);  
                                           }
                                           if(matrizcelulajogador[posicaox][posicaoy] instanceof Porta4)
                                           {
                                               table[posicaox][posicaoy].setIcon(port4); 
                                               p4amigo.setVivo(false);
                                               
                                               if(posicaoy + 1 < 10)
                                               {
                                                   if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof Submarino1)
                                                   {
                                                       table[posicaox][posicaoy + 1].setIcon(sub1);
                                                       s1amigo.setVivo(false); 
                                                   }
                                                   if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof Jato1)
                                                   {
                                                       table[posicaox][posicaoy + 1].setIcon(jato1);
                                                       j1amigo.setVivo(false); 
                                                   }
                                                   if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof Escolta1)
                                                   {
                                                       table[posicaox][posicaoy + 1].setIcon(esc1);
                                                       e1amigo.setVivo(false); 
                                                   }
                                                   if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof NaoCelula)
                                                   {
                                                       table[posicaox][posicaoy + 1].setIcon(naocelula); 
                                                   }
                                               }
                                           }
                                           if(matrizcelulajogador[posicaox][posicaoy] instanceof NaoCelula)
                                           {
                                               table[posicaox][posicaoy].setIcon(naocelula);                                                      
                                               if(posicaoy + 1 < 10)
                                               {
                                                   if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof Submarino1)
                                                   {
                                                       table[posicaox][posicaoy + 1].setIcon(sub1);
                                                       s1amigo.setVivo(false); 
                                                   }
                                                   if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof Jato1)
                                                   {
                                                       table[posicaox][posicaoy + 1].setIcon(jato1);
                                                       j1amigo.setVivo(false); 
                                                   }
                                                   if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof Escolta1)
                                                   {
                                                       table[posicaox][posicaoy + 1].setIcon(esc1);
                                                       e1amigo.setVivo(false); 
                                                   }
                                                   if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof Porta1)
                                                   {
                                                       table[posicaox][posicaoy + 1].setIcon(port1);
                                                       e1amigo.setVivo(false); 
                                                   }
                                                   if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof NaoCelula)
                                                   {
                                                       table[posicaox][posicaoy + 1].setIcon(naocelula); 
                                                   }
                                               }
                                           }
                                           if(contif == 0)
                                            {
                                                 if(s1amigo.getVivo() == false && s2amigo.getVivo() == false)
                                                 {
                                                    botaoS.setBackground(Color.red);
                                                    botaoS.setIcon(new ImageIcon("./submarino.png"));
                                                    cont = 0; 
                                                    contif = 1;
                                                 }
                                            }
                                            if(contifJ == 0) //fazer o jato ficar vermelho
                                            {
                                                 if(j1amigo.getVivo() == false && j2amigo.getVivo() == false)
                                                 {
                                                    botaoJ.setBackground(Color.red);
                                                    botaoJ.setIcon(new ImageIcon("./jato.png"));
                                                    cont = 0; 
                                                    contifJ = 1;
                                                 }
                                            }
                                            if(contifE == 0) //fazer o escolta ficar vermelho
                                            {
                                                 if(e1amigo.getVivo() == false && e2amigo.getVivo() == false && e3amigo.getVivo() == false)
                                                 {
                                                    botaoE.setBackground(Color.red);
                                                    botaoE.setIcon(new ImageIcon("./escolta.png"));
                                                    cont = 0; 
                                                    contifE = 1;
                                                 }
                                            }
                                            if(s1amigo.getVivo() == false && s2amigo.getVivo() == false && j1amigo.getVivo() == false && j2amigo.getVivo() == false && e1amigo.getVivo() == false && e2amigo.getVivo() == false && e3amigo.getVivo() == false)
                                           {
                                               loser(); 
                                           }
                                           pcjaclicou[posicaox][posicaoy] = true; 
                                           if(posicaoy + 1 < 10)
                                           {
                                               pcjaclicou[posicaox][posicaoy + 1] = true; 
                                           } 
                                       }
                                       else
                                       {
                                           l = -1; 
                                       }
                                   }
                               }
                               if(rand == 3 && contJPC == 0)
                               {
                                   for(int l = 0; l < 1; l++)
                                   {
                                       posicaox = random.nextInt(10);
                                       posicaoy = random.nextInt(10);
                                       if(pcjaclicou[posicaox][posicaoy] == false)//pa
                                       {
                                           if(matrizcelulajogador[posicaox][posicaoy] instanceof Submarino1)
                                           {
                                               table[posicaox][posicaoy].setIcon(sub1);
                                               s1amigo.setVivo(false);
                                               table[posicaox][posicaoy + 1].setIcon(sub2);
                                               s2amigo.setVivo(false);
                                               
                                               if(posicaoy - 1 >= 0)
                                               {
                                                    if(matrizcelulajogador[posicaox][posicaoy - 1] instanceof Jato2)
                                                    {
                                                        table[posicaox][posicaoy - 1].setIcon(jato2);
                                                        j2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox][posicaoy - 1] instanceof Escolta3)
                                                    {
                                                        table[posicaox][posicaoy - 1].setIcon(esc3);
                                                        e3amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox][posicaoy - 1] instanceof Porta4)
                                                    {
                                                        table[posicaox][posicaoy - 1].setIcon(port4); 
                                                        p4amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox][posicaoy - 1] instanceof NaoCelula)
                                                    {
                                                        table[posicaox][posicaoy - 1].setIcon(naocelula);
                                                    }
                                               }
                                               
                                               //em cima
                                               if(posicaox - 1 >= 0)
                                               {
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Jato1)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(jato1);
                                                        j1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Jato2)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(jato2);
                                                        j2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Escolta1)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(esc1);
                                                        e1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Escolta2)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(esc2);
                                                        e2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Escolta3)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(esc3);
                                                        e3amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Porta1)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(port1);
                                                        p1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Porta2)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(port2);
                                                        p2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Porta3)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(port3);
                                                        p3amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Porta4)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(port4); 
                                                        p4amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof NaoCelula)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(naocelula);
                                                    }
                                               }
                                               
                                               //em baixo
                                               if(posicaox + 1 < 10)
                                               {
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Jato1)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(jato1);
                                                        j1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Jato2)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(jato2);
                                                        j2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Escolta1)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(esc1);
                                                        e1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Escolta2)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(esc2);
                                                        e2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Escolta3)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(esc3);
                                                        e3amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Porta1)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(port1);
                                                        p1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Porta2)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(port2);
                                                        p2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Porta3)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(port3);
                                                        p3amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Porta4)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(port4); 
                                                        p4amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof NaoCelula)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(naocelula);
                                                    }
                                               }
                                           }
                                           if(matrizcelulajogador[posicaox][posicaoy] instanceof Submarino2)
                                           {
                                               table[posicaox][posicaoy].setIcon(sub2);
                                               s2amigo.setVivo(false);
                                               
                                               table[posicaox][posicaoy - 1].setIcon(sub1);
                                               s1amigo.setVivo(false);
                                               
                                               if(posicaoy + 1 < 10)
                                               {
                                                   if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof Jato1)
                                                    {
                                                        table[posicaox][posicaoy + 1].setIcon(jato1);
                                                        j1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof Escolta1)
                                                    {
                                                        table[posicaox][posicaoy + 1].setIcon(esc1);
                                                        e1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof Porta1)
                                                    {
                                                        table[posicaox][posicaoy + 1].setIcon(port1);
                                                        p1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof NaoCelula)
                                                    {
                                                        table[posicaox][posicaoy + 1].setIcon(naocelula);
                                                    }
                                               }
                                               
                                               //em cima
                                               if(posicaox - 1 >= 0)
                                               {
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Jato1)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(jato1);
                                                        j1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Jato2)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(jato2);
                                                        j2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Escolta1)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(esc1);
                                                        e1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Escolta2)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(esc2);
                                                        e2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Escolta3)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(esc3);
                                                        e3amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Porta1)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(port1);
                                                        p1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Porta2)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(port2);
                                                        p2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Porta3)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(port3);
                                                        p3amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Porta4)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(port4); 
                                                        p4amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof NaoCelula)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(naocelula);
                                                    }
                                               }
                                               
                                               //em baixo
                                               if(posicaox + 1 < 10)
                                               {
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Jato1)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(jato1);
                                                        j1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Jato2)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(jato2);
                                                        j2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Escolta1)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(esc1);
                                                        e1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Escolta2)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(esc2);
                                                        e2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Escolta3)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(esc3);
                                                        e3amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Porta1)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(port1);
                                                        p1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Porta2)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(port2);
                                                        p2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Porta3)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(port3);
                                                        p3amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Porta4)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(port4); 
                                                        p4amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof NaoCelula)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(naocelula);
                                                    }
                                               }
               
                                           }
                                           if(matrizcelulajogador[posicaox][posicaoy] instanceof Jato1)
                                           {
                                               table[posicaox][posicaoy].setIcon(jato1);
                                               j1amigo.setVivo(false);
                                               table[posicaox][posicaoy + 1].setIcon(jato2);
                                               j2amigo.setVivo(false);
                                               
                                               if(posicaoy - 1 >= 0)
                                               {
                                                    if(matrizcelulajogador[posicaox][posicaoy - 1] instanceof Submarino2)
                                                    {
                                                        table[posicaox][posicaoy - 1].setIcon(sub2);
                                                        s2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox][posicaoy - 1] instanceof Escolta3)
                                                    {
                                                        table[posicaox][posicaoy - 1].setIcon(esc3);
                                                        e3amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox][posicaoy - 1] instanceof Porta4)
                                                    {
                                                        table[posicaox][posicaoy - 1].setIcon(port4); 
                                                        p4amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox][posicaoy - 1] instanceof NaoCelula)
                                                    {
                                                        table[posicaox][posicaoy - 1].setIcon(naocelula);
                                                    }
                                               }
                                               
                                               //em cima
                                               if(posicaox - 1 >= 0)
                                               {
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Submarino1)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(sub1);
                                                        s1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Submarino2)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(sub2);
                                                        s2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Escolta1)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(esc1);
                                                        e1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Escolta2)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(esc2);
                                                        e2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Escolta3)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(esc3);
                                                        e3amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Porta1)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(port1);
                                                        p1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Porta2)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(port2);
                                                        p2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Porta3)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(port3);
                                                        p3amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Porta4)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(port4); 
                                                        p4amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof NaoCelula)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(naocelula);
                                                    }
                                               }
                                               
                                               //em baixo
                                               if(posicaox + 1 < 10)
                                               {
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Submarino1)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(sub1);
                                                        s1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Submarino2)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(sub2);
                                                        s2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Escolta1)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(esc1);
                                                        e1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Escolta2)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(esc2);
                                                        e2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Escolta3)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(esc3);
                                                        e3amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Porta1)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(port1);
                                                        p1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Porta2)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(port2);
                                                        p2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Porta3)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(port3);
                                                        p3amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Porta4)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(port4); 
                                                        p4amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof NaoCelula)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(naocelula);
                                                    }
                                               }
                                           }
                                           if(matrizcelulajogador[posicaox][posicaoy] instanceof Jato2)
                                           {
                                               table[posicaox][posicaoy].setIcon(jato2);
                                               j2amigo.setVivo(false);
                                               table[posicaox][posicaoy - 1].setIcon(jato1);
                                               j1amigo.setVivo(false);
                                               
                                               if(posicaoy + 1 < 10)
                                               {
                                                    if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof Submarino1)
                                                    {
                                                        table[posicaox][posicaoy + 1].setIcon(sub1);
                                                        s1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof Escolta1)
                                                    {
                                                        table[posicaox][posicaoy + 1].setIcon(esc1);
                                                        e1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof Porta1)
                                                    {
                                                        table[posicaox][posicaoy + 1].setIcon(port1);
                                                        p1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof NaoCelula)
                                                    {
                                                        table[posicaox][posicaoy + 1].setIcon(naocelula);
                                                    }
                                               }
                                               //em cima
                                               if(posicaox - 1 >= 0)
                                               {
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Submarino1)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(sub1);
                                                        s1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Submarino2)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(sub2);
                                                        s2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Escolta1)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(esc1);
                                                        e1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Escolta2)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(esc2);
                                                        e2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Escolta3)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(esc3);
                                                        e3amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Porta1)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(port1);
                                                        p1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Porta2)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(port2);
                                                        p2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Porta3)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(port3);
                                                        p3amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Porta4)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(port4); 
                                                        p4amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof NaoCelula)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(naocelula);
                                                    }
                                               }
                                               
                                               //em baixo
                                               if(posicaox + 1 < 10)
                                               {
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Submarino1)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(sub1);
                                                        s1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Submarino2)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(sub2);
                                                        s2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Escolta1)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(esc1);
                                                        e1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Escolta2)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(esc2);
                                                        e2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Escolta3)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(esc3);
                                                        e3amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Porta1)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(port1);
                                                        p1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Porta2)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(port2);
                                                        p2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Porta3)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(port3);
                                                        p3amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Porta4)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(port4); 
                                                        p4amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof NaoCelula)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(naocelula);
                                                    }
                                               }
                                               
                                           }
                                           if(matrizcelulajogador[posicaox][posicaoy] instanceof Escolta1)
                                           {
                                               table[posicaox][posicaoy].setIcon(esc1);
                                               e1amigo.setVivo(false);
                                               table[posicaox][posicaoy + 1].setIcon(esc2);
                                               e2amigo.setVivo(false);
                                               
                                               if(posicaoy - 1 >= 0)
                                               {
                                                    if(matrizcelulajogador[posicaox][posicaoy - 1] instanceof Submarino2)
                                                    {
                                                        table[posicaox][posicaoy - 1].setIcon(sub2);
                                                        s2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox][posicaoy - 1] instanceof Jato2)
                                                    {
                                                        table[posicaox][posicaoy - 1].setIcon(jato2);
                                                        j2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox][posicaoy - 1] instanceof Porta4)
                                                    {
                                                        table[posicaox][posicaoy - 1].setIcon(port4); 
                                                        p4amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox][posicaoy - 1] instanceof NaoCelula)
                                                    {
                                                        table[posicaox][posicaoy - 1].setIcon(naocelula);
                                                    }
                                               }
                                               //em cima
                                               if(posicaox - 1 >= 0)
                                               {
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Submarino1)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(sub1);
                                                        s1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Submarino2)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(sub2);
                                                        s2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Jato1)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(jato1);
                                                        j1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Jato2)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(jato2);
                                                        j2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Porta1)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(port1);
                                                        p1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Porta2)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(port2);
                                                        p2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Porta3)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(port3);
                                                        p3amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Porta4)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(port4); 
                                                        p4amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof NaoCelula)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(naocelula);
                                                    }
                                               }
                                               
                                               //em baixo
                                               if(posicaox + 1 < 10)
                                               {
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Submarino1)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(sub1);
                                                        s1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Submarino2)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(sub2);
                                                        s2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Jato1)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(jato1);
                                                        j1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Jato2)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(jato2);
                                                        j2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Porta1)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(port1);
                                                        p1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Porta2)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(port2);
                                                        p2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Porta3)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(port3);
                                                        p3amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Porta4)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(port4); 
                                                        p4amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof NaoCelula)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(naocelula);
                                                    }
                                               }
                                           }
                                           if(matrizcelulajogador[posicaox][posicaoy] instanceof Escolta2)
                                           {
                                               table[posicaox][posicaoy].setIcon(esc2);
                                               e2amigo.setVivo(false);
                                               table[posicaox][posicaoy - 1].setIcon(esc1);
                                               e1amigo.setVivo(false);
                                               table[posicaox][posicaoy + 1].setIcon(esc3);
                                               e3amigo.setVivo(false);
                                               
                                               //em cima
                                               if(posicaox - 1 >= 0)
                                               {
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Submarino1)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(sub1);
                                                        s1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Submarino2)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(sub2);
                                                        s2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Jato1)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(jato1);
                                                        j1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Jato2)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(jato2);
                                                        j2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Porta1)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(port1);
                                                        p1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Porta2)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(port2);
                                                        p2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Porta3)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(port3);
                                                        p3amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Porta4)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(port4); 
                                                        p4amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof NaoCelula)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(naocelula);
                                                    }
                                               }
                                               
                                               //em baixo
                                               if(posicaox + 1 < 10)
                                               {
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Submarino1)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(sub1);
                                                        s1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Submarino2)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(sub2);
                                                        s2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Jato1)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(jato1);
                                                        j1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Jato2)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(jato2);
                                                        j2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Porta1)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(port1);
                                                        p1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Porta2)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(port2);
                                                        p2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Porta3)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(port3);
                                                        p3amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Porta4)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(port4); 
                                                        p4amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof NaoCelula)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(naocelula);
                                                    }
                                               }
                                               
                                           }
                                           if(matrizcelulajogador[posicaox][posicaoy] instanceof Escolta3)
                                           {
                                               table[posicaox][posicaoy].setIcon(esc3);
                                               e3amigo.setVivo(false);
                                               table[posicaox][posicaoy - 1].setIcon(esc2);
                                               e2amigo.setVivo(false);
                                               
                                               if(posicaoy + 1 < 10)
                                               {
                                                    if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof Submarino1)
                                                    {
                                                        table[posicaox][posicaoy + 1].setIcon(sub1);
                                                        s1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof Jato1)
                                                    {
                                                        table[posicaox][posicaoy + 1].setIcon(jato1);
                                                        j1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof Porta1)
                                                    {
                                                        table[posicaox][posicaoy + 1].setIcon(port1);
                                                        p1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof NaoCelula)
                                                    {
                                                        table[posicaox][posicaoy + 1].setIcon(naocelula);
                                                    }
                                               }
                                               //em cima
                                               if(posicaox - 1 >= 0)
                                               {
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Submarino1)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(sub1);
                                                        s1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Submarino2)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(sub2);
                                                        s2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Jato1)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(jato1);
                                                        j1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Jato2)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(jato2);
                                                        j2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Porta1)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(port1);
                                                        p1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Porta2)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(port2);
                                                        p2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Porta3)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(port3);
                                                        p3amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Porta4)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(port4); 
                                                        p4amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof NaoCelula)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(naocelula);
                                                    }
                                               }
                                               
                                               //em baixo
                                               if(posicaox + 1 < 10)
                                               {
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Submarino1)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(sub1);
                                                        s1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Submarino2)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(sub2);
                                                        s2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Jato1)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(jato1);
                                                        j1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Jato2)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(jato2);
                                                        j2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Porta1)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(port1);
                                                        p1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Porta2)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(port2);
                                                        p2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Porta3)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(port3);
                                                        p3amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Porta4)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(port4); 
                                                        p4amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof NaoCelula)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(naocelula);
                                                    }
                                               }
                                               
                                           }
                                           if(matrizcelulajogador[posicaox][posicaoy] instanceof Porta1)
                                           {
                                               table[posicaox][posicaoy].setIcon(port1);
                                               p1amigo.setVivo(false);
                                               table[posicaox][posicaoy + 1].setIcon(port2);
                                               p2amigo.setVivo(false);
                                               
                                               if(posicaoy - 1 >= 0)
                                               {
                                                    if(matrizcelulajogador[posicaox][posicaoy - 1] instanceof Submarino2)
                                                    {
                                                        table[posicaox][posicaoy - 1].setIcon(sub2);
                                                        s2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox][posicaoy - 1] instanceof Jato2)
                                                    {
                                                        table[posicaox][posicaoy - 1].setIcon(jato2);
                                                        j2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox][posicaoy - 1] instanceof Escolta3)
                                                    {
                                                        table[posicaox][posicaoy - 1].setIcon(esc3);
                                                        e3amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox][posicaoy - 1] instanceof NaoCelula)
                                                    {
                                                        table[posicaox][posicaoy - 1].setIcon(naocelula);
                                                    }
                                               }
                                               //em cima
                                               if(posicaox - 1 >= 0)
                                               {
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Submarino1)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(sub1);
                                                        s1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Submarino2)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(sub2);
                                                        s2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Jato1)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(jato1);
                                                        j1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Jato2)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(jato2);
                                                        j2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Escolta1)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(esc1);
                                                        e1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Escolta2)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(esc2);
                                                        e2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Escolta3)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(esc3);
                                                        e3amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof NaoCelula)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(naocelula);
                                                    }
                                               }
                                               
                                               //em baixo
                                               if(posicaox + 1 < 10)
                                               {
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Submarino1)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(sub1);
                                                        s1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Submarino2)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(sub2);
                                                        s2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Jato1)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(jato1);
                                                        j1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Jato2)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(jato2);
                                                        j2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Escolta1)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(esc1);
                                                        e1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Escolta2)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(esc2);
                                                        e2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Escolta3)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(esc3);
                                                        e3amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof NaoCelula)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(naocelula);
                                                    }
                                               }
                                               
                                           }
                                           if(matrizcelulajogador[posicaox][posicaoy] instanceof Porta2)
                                           {
                                               table[posicaox][posicaoy].setIcon(port2);
                                               p2amigo.setVivo(false);
                                               table[posicaox][posicaoy - 1].setIcon(port1);
                                               p1amigo.setVivo(false);
                                               table[posicaox][posicaoy + 1].setIcon(port3);
                                               p3amigo.setVivo(false);
                                               
                                               //em cima
                                               if(posicaox - 1 >= 0)
                                               {
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Submarino1)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(sub1);
                                                        s1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Submarino2)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(sub2);
                                                        s2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Jato1)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(jato1);
                                                        j1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Jato2)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(jato2);
                                                        j2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Escolta1)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(esc1);
                                                        e1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Escolta2)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(esc2);
                                                        e2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Escolta3)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(esc3);
                                                        e3amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof NaoCelula)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(naocelula);
                                                    }
                                               }
                                               
                                               //em baixo
                                               if(posicaox + 1 < 10)
                                               {
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Submarino1)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(sub1);
                                                        s1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Submarino2)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(sub2);
                                                        s2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Jato1)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(jato1);
                                                        j1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Jato2)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(jato2);
                                                        j2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Escolta1)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(esc1);
                                                        e1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Escolta2)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(esc2);
                                                        e2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Escolta3)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(esc3);
                                                        e3amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof NaoCelula)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(naocelula);
                                                    }
                                               }
                                           }
                                           if(matrizcelulajogador[posicaox][posicaoy] instanceof Porta3)
                                           {
                                               table[posicaox][posicaoy].setIcon(port3);
                                               p3amigo.setVivo(false);
                                               table[posicaox][posicaoy - 1].setIcon(port2);
                                               p2amigo.setVivo(false);
                                               table[posicaox][posicaoy + 1].setIcon(port4); 
                                               p4amigo.setVivo(false);
                                               
                                               //em cima
                                               if(posicaox - 1 >= 0)
                                               {
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Submarino1)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(sub1);
                                                        s1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Submarino2)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(sub2);
                                                        s2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Jato1)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(jato1);
                                                        j1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Jato2)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(jato2);
                                                        j2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Escolta1)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(esc1);
                                                        e1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Escolta2)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(esc2);
                                                        e2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Escolta3)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(esc3);
                                                        e3amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof NaoCelula)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(naocelula);
                                                    }
                                               }
                                               
                                               //em baixo
                                               if(posicaox + 1 < 10)
                                               {
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Submarino1)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(sub1);
                                                        s1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Submarino2)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(sub2);
                                                        s2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Jato1)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(jato1);
                                                        j1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Jato2)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(jato2);
                                                        j2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Escolta1)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(esc1);
                                                        e1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Escolta2)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(esc2);
                                                        e2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Escolta3)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(esc3);
                                                        e3amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof NaoCelula)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(naocelula);
                                                    }
                                               }
                                           }
                                           if(matrizcelulajogador[posicaox][posicaoy] instanceof Porta4)
                                           {
                                               table[posicaox][posicaoy].setIcon(port4); 
                                               p4amigo.setVivo(false);
                                               table[posicaox][posicaoy - 1].setIcon(port3);
                                               p3amigo.setVivo(false);
                                               
                                               if(posicaoy + 1 < 10)
                                               {
                                                    if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof Submarino1)
                                                    {
                                                        table[posicaox][posicaoy + 1].setIcon(sub1);
                                                        s1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof Escolta1)
                                                    {
                                                        table[posicaox][posicaoy + 1].setIcon(esc1);
                                                        e1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof Jato1)
                                                    {
                                                        table[posicaox][posicaoy + 1].setIcon(jato1);
                                                        j1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof NaoCelula)
                                                    {
                                                        table[posicaox][posicaoy + 1].setIcon(naocelula);
                                                    }
                                               }
                                               //em cima
                                               if(posicaox - 1 >= 0)
                                               {
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Submarino1)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(sub1);
                                                        s1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Submarino2)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(sub2);
                                                        s2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Jato1)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(jato1);
                                                        j1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Jato2)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(jato2);
                                                        j2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Escolta1)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(esc1);
                                                        e1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Escolta2)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(esc2);
                                                        e2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Escolta3)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(esc3);
                                                        e3amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof NaoCelula)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(naocelula);
                                                    }
                                               }
                                               
                                               //em baixo
                                               if(posicaox + 1 < 10)
                                               {
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Submarino1)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(sub1);
                                                        s1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Submarino2)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(sub2);
                                                        s2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Jato1)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(jato1);
                                                        j1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Jato2)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(jato2);
                                                        j2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Escolta1)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(esc1);
                                                        e1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Escolta2)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(esc2);
                                                        e2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Escolta3)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(esc3);
                                                        e3amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof NaoCelula)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(naocelula);
                                                    }
                                               }
                                           }
                                           if(matrizcelulajogador[posicaox][posicaoy] instanceof NaoCelula)
                                           {
                                               table[posicaox][posicaoy].setIcon(naocelula);
                                               
                                               //Direita
                                               if(posicaoy + 1 < 10)
                                               {
                                                    if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof Submarino1)
                                                    {
                                                        table[posicaox][posicaoy + 1].setIcon(sub1);
                                                        s1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof Jato1)
                                                    {
                                                        table[posicaox][posicaoy + 1].setIcon(jato1);
                                                        j1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof Escolta1)
                                                    {
                                                        table[posicaox][posicaoy + 1].setIcon(esc1);
                                                        e1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof Porta1)
                                                    {
                                                        table[posicaox][posicaoy + 1].setIcon(port1);
                                                        p1amigo.setVivo(false);
                                                    } //ola
                                                    if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof NaoCelula)
                                                    {
                                                        table[posicaox][posicaoy + 1].setIcon(naocelula);
                                                    }
                                               }
                                               
                                               if(posicaoy - 1 >= 0)
                                               {
                                                    if(matrizcelulajogador[posicaox][posicaoy - 1] instanceof Submarino2)
                                                    {
                                                        table[posicaox][posicaoy - 1].setIcon(sub2);
                                                        s2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox][posicaoy - 1] instanceof Jato2)
                                                    {
                                                        table[posicaox][posicaoy - 1].setIcon(jato2);
                                                        j2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox][posicaoy - 1] instanceof Escolta3)
                                                    {
                                                        table[posicaox][posicaoy - 1].setIcon(esc3);
                                                        e3amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox][posicaoy - 1] instanceof Porta4)
                                                    {
                                                        table[posicaox][posicaoy - 1].setIcon(port4); 
                                                        p4amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox][posicaoy - 1] instanceof NaoCelula)
                                                    {
                                                        table[posicaox][posicaoy - 1].setIcon(naocelula);
                                                    }
                                               }
                                               
                                               //em cima
                                               if(posicaox - 1 >= 0)
                                               {
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Submarino1)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(sub1);
                                                        s1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Submarino2)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(sub2);
                                                        s2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Jato1)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(jato1);
                                                        j1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Jato2)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(jato2);
                                                        j2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Escolta1)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(esc1);
                                                        e1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Escolta2)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(esc2);
                                                        e2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Escolta3)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(esc3);
                                                        e3amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Porta1)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(port1);
                                                        p1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Porta2)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(port2);
                                                        p2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Porta3)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(port3);
                                                        p3amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Porta4)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(port4); 
                                                        p4amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof NaoCelula)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(naocelula);
                                                    }
                                               }
                                               
                                               //em baixo
                                               if(posicaox + 1 < 10)
                                               {
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Submarino1)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(sub1);
                                                        s1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Submarino2)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(sub2);
                                                        s2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Jato1)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(jato1);
                                                        j1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Jato2)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(jato2);
                                                        j2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Escolta1)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(esc1);
                                                        e1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Escolta2)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(esc2);
                                                        e2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Escolta3)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(esc3);
                                                        e3amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Porta1)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(port1);
                                                        p1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Porta2)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(port2);
                                                        p2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Porta3)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(port3);
                                                        p3amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Porta4)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(port4); 
                                                        p4amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof NaoCelula)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(naocelula);
                                                    }
                                                    
                                               }
                                           }
                                           if(contif == 0)
                                                {
                                                     if(s1amigo.getVivo() == false && s2amigo.getVivo() == false)
                                                     {
                                                        botaoS.setBackground(Color.red);
                                                        botaoS.setIcon(new ImageIcon("./submarino.png"));
                                                        cont = 0; 
                                                        contif = 1;
                                                     }
                                                }
                                                if(contifJ == 0) //fazer o jato ficar vermelho
                                                {
                                                     if(j1amigo.getVivo() == false && j2amigo.getVivo() == false)
                                                     {
                                                        botaoJ.setBackground(Color.red);
                                                        botaoJ.setIcon(new ImageIcon("./jato.png"));
                                                        cont = 0; 
                                                        contifJ = 1;
                                                     }
                                                }
                                                if(contifE == 0) //fazer o escolta ficar vermelho
                                                {
                                                     if(e1amigo.getVivo() == false && e2amigo.getVivo() == false && e3amigo.getVivo() == false)
                                                     {
                                                        botaoE.setBackground(Color.red);
                                                        botaoE.setIcon(new ImageIcon("./escolta.png"));
                                                        cont = 0; 
                                                        contifE = 1;
                                                     }
                                                }
                                                if(s1amigo.getVivo() == false && s2amigo.getVivo() == false && j1amigo.getVivo() == false && j2amigo.getVivo() == false && e1amigo.getVivo() == false && e2amigo.getVivo() == false && e3amigo.getVivo() == false)
                                                {
                                                    loser(); 
                                                }
                                                pcjaclicou[posicaox][posicaoy] = true;
                                                if(posicaoy - 1 >= 0)
                                                {
                                                    pcjaclicou[posicaox][posicaoy - 1] = true;
                                                }
                                                if(posicaox - 1 >= 0)
                                                {
                                                    pcjaclicou[posicaox - 1] [posicaoy] = true;
                                                }
                                                if(posicaox + 1 < 10)
                                                {
                                                    pcjaclicou[posicaox + 1] [posicaoy] = true;
                                                }
                                                if(posicaoy + 1 < 10)
                                                {
                                                    pcjaclicou[posicaox][posicaoy + 1] = true;
                                                }
                                       }
                                       else
                                       {
                                           l = -1; 
                                       }
                                   }
                               }
                            }
                            else
                            {
                                k = -1; 
                            }
                        }    
                   }       
	        }
            }
        }
      
    }
    
    if(cont == 2 && dicaativada == false)//Player ataca
    {   
        for(int i = 0; i<10 ; i++)
        {
            for(int j = 0; j<10 ; j++)
            {
                if(jaclicou[i][j] == false)
                {
                    if(object == teste[i][j])
                    {   
                        if(matrizcelulapc[i][j] instanceof Submarino1)
                        {
                            teste[i][j].setIcon(sub1);
                            s1inimigo.setVivo(false);
                            
                            teste[i][j+1].setIcon(sub2);
                            s2inimigo.setVivo(false);
                        }
                        if(matrizcelulapc[i][j] instanceof Submarino2)
                        {
                            teste[i][j].setIcon(sub2);
                            s2inimigo.setVivo(false);
                            
                            if(j+1 < 10){
                            if(matrizcelulapc[i][j+1] instanceof NaoCelula)
                            {
                                teste[i][j+1].setIcon(naocelula);
                            }
                            if(matrizcelulapc[i][j+1] instanceof Jato1)
                            {
                                teste[i][j+1].setIcon(jato1);
                                j1inimigo.setVivo(false);
                            }
                            if(matrizcelulapc[i][j+1] instanceof Escolta1)
                            {
                                teste[i][j+1].setIcon(esc1);
                                e1inimigo.setVivo(false);
                            }
                            if(matrizcelulapc[i][j+1] instanceof Porta1)
                            {
                                teste[i][j+1].setIcon(port1);
                                p1inimigo.setVivo(false);
                            }}
                        }
                        if(matrizcelulapc[i][j] instanceof Jato1)
                        {
                            teste[i][j].setIcon(jato1);
                            j1inimigo.setVivo(false);
                            
                            teste[i][j+1].setIcon(jato2);
                            j2inimigo.setVivo(false);
                        }
                        if(matrizcelulapc[i][j] instanceof Jato2)
                        {
                            teste[i][j].setIcon(jato2);
                            j2inimigo.setVivo(false);
                            
                            if(j+1 < 10){
                            if(matrizcelulapc[i][j+1] instanceof NaoCelula)
                            {
                                teste[i][j+1].setIcon(naocelula);
                            }
                            if(matrizcelulapc[i][j+1] instanceof Submarino1)
                            {
                                teste[i][j+1].setIcon(sub1);
                                s1inimigo.setVivo(false); 
                            }
                            if(matrizcelulapc[i][j+1] instanceof Escolta1)
                            {
                                teste[i][j+1].setIcon(esc1);
                                e1inimigo.setVivo(false); 
                            }
                            if(matrizcelulapc[i][j+1] instanceof Porta1)
                            {
                                teste[i][j+1].setIcon(port1);
                                p1inimigo.setVivo(false); 
                            }}
                        }
                        if(matrizcelulapc[i][j] instanceof Escolta1)
                        {
                            teste[i][j].setIcon(esc1);
                            e1inimigo.setVivo(false);
                            
                            teste[i][j+1].setIcon(esc2);
                            e2inimigo.setVivo(false);
                        }
                        if(matrizcelulapc[i][j] instanceof Escolta2)
                        {
                            teste[i][j].setIcon(esc2);
                            e2inimigo.setVivo(false);
                            
                            teste[i][j+1].setIcon(esc3);
                            e3inimigo.setVivo(false);
                        }
                        if(matrizcelulapc[i][j] instanceof Escolta3)
                        {
                            teste[i][j].setIcon(esc3);
                            e3inimigo.setVivo(false);
                            
                            if(j+1 < 10){
                            if(matrizcelulapc[i][j+1] instanceof NaoCelula)
                            {
                                teste[i][j+1].setIcon(naocelula);
                            }
                            if(matrizcelulapc[i][j+1] instanceof Submarino1)
                            {
                                teste[i][j+1].setIcon(sub1);
                                s1inimigo.setVivo(false); 
                            }
                            if(matrizcelulapc[i][j+1] instanceof Jato1)
                            {
                                teste[i][j+1].setIcon(jato1);
                                j1inimigo.setVivo(false); 
                            }
                            if(matrizcelulapc[i][j+1] instanceof Porta1)
                            {
                                teste[i][j+1].setIcon(port1);
                                p1inimigo.setVivo(false); 
                            }}
                        }
                        if(matrizcelulapc[i][j] instanceof Porta1)
                        {
                            teste[i][j].setIcon(port1);
                            p1inimigo.setVivo(false);
                            
                            teste[i][j+1].setIcon(port2);
                            p2inimigo.setVivo(false);
                        }
                        if(matrizcelulapc[i][j] instanceof Porta2)
                        {
                            teste[i][j].setIcon(port2);
                            p2inimigo.setVivo(false);
                            
                            teste[i][j+1].setIcon(port3);
                            p3inimigo.setVivo(false);
                        }
                        if(matrizcelulapc[i][j] instanceof Porta3)
                        {
                            teste[i][j].setIcon(port3);
                            p3inimigo.setVivo(false);
                            
                            teste[i][j+1].setIcon(port4); 
                            p4inimigo.setVivo(false);
                        }
                        if(matrizcelulapc[i][j] instanceof Porta4)
                        {
                            teste[i][j].setIcon(port4); 
                            p4inimigo.setVivo(false);
                            
                            if(j+1 < 10){
                            if(matrizcelulapc[i][j+1] instanceof NaoCelula)
                            {
                                teste[i][j+1].setIcon(naocelula);
                            }
                            if(matrizcelulapc[i][j+1] instanceof Submarino1)
                            {
                                teste[i][j+1].setIcon(sub1);
                                s1inimigo.setVivo(false); 
                            }
                            if(matrizcelulapc[i][j+1] instanceof Jato1)
                            {
                                teste[i][j+1].setIcon(jato1);
                                j1inimigo.setVivo(false); 
                            }
                            if(matrizcelulapc[i][j+1] instanceof Escolta1)
                            {
                                teste[i][j+1].setIcon(esc1);
                                e1inimigo.setVivo(false); 
                            }}
                        }
                        if(matrizcelulapc[i][j] instanceof NaoCelula)
                        {
                            teste[i][j].setIcon(naocelula);
                            if(j+1 < 10){
                            if(matrizcelulapc[i][j+1] instanceof Submarino1)
                            {
                                teste[i][j+1].setIcon(sub1);
                                s1inimigo.setVivo(false); 
                            }
                            if(matrizcelulapc[i][j+1] instanceof Jato1)
                            {
                                teste[i][j+1].setIcon(jato1);
                                j1inimigo.setVivo(false); 
                            }
                            if(matrizcelulapc[i][j+1] instanceof Escolta1)
                            {
                                teste[i][j+1].setIcon(esc1);
                                e1inimigo.setVivo(false); 
                            }
                            if(matrizcelulapc[i][j+1] instanceof Porta1)
                            {
                                teste[i][j+1].setIcon(port1);
                                p1inimigo.setVivo(false); 
                            }
                            if(matrizcelulapc[i][j+1] instanceof NaoCelula)
                            {
                                teste[i][j+1].setIcon(naocelula);
                            }}
                        }
                        jaclicou[i][j] = true;
                        if(j+1 < 10){
                        jaclicou[i][j+1] = true;}
                        if(s1inimigo.getVivo() == false && s2inimigo.getVivo() == false && j1inimigo.getVivo() == false && j2inimigo.getVivo() == false && e1inimigo.getVivo() == false && e2inimigo.getVivo() == false && e3inimigo.getVivo() == false)
                        {
                            win(); 
                        }
                        if(s1inimigo.getVivo() == false && s2inimigo.getVivo() == false)
                        {
                            contSPC = 1; 
                        }
                        if(j1inimigo.getVivo() == false && j2inimigo.getVivo() == false)
                        {
                            contJPC = 1; 
                        }
                        if(e1inimigo.getVivo() == false && e2inimigo.getVivo() == false && e3inimigo.getVivo() == false)
                        {
                            contEPC = 1; 
                        }
                        //PC Ataca
                        for(int k = 0; k < foi; k++)
                        {
                            rand = random.nextInt(4);
                            if(rand == 1 && contSPC == 1){k = -1;}
                            if(rand == 2 && contEPC == 1){k = -1;}
                            if(rand == 3 && contJPC == 1){k = -1;}
                            if(rand != 0)
                            {
                               if(rand == 1 && contSPC == 0)
                               {
                                   for(int l = 0; l < 1; l++)
                                   {
                                       posicaox = random.nextInt(10);
                                       posicaoy = random.nextInt(10);
                                       if(pcjaclicou[posicaox][posicaoy] == false)
                                       {
                                           if(matrizcelulajogador[posicaox][posicaoy] instanceof Submarino1)
                                           {
                                               table[posicaox][posicaoy].setIcon(sub1);
                                               s1amigo.setVivo(false);
                                           }
                                           if(matrizcelulajogador[posicaox][posicaoy] instanceof Submarino2)
                                           {
                                               table[posicaox][posicaoy].setIcon(sub2);
                                               s2amigo.setVivo(false);
                                           }
                                           if(matrizcelulajogador[posicaox][posicaoy] instanceof Jato1)
                                           {
                                               table[posicaox][posicaoy].setIcon(jato1);
                                               j1amigo.setVivo(false);
                                           }
                                           if(matrizcelulajogador[posicaox][posicaoy] instanceof Jato2)
                                           {
                                               table[posicaox][posicaoy].setIcon(jato2);
                                               j2amigo.setVivo(false);
                                           }
                                           if(matrizcelulajogador[posicaox][posicaoy] instanceof Escolta1)
                                           {
                                               table[posicaox][posicaoy].setIcon(esc1);
                                               e1amigo.setVivo(false);
                                           }
                                           if(matrizcelulajogador[posicaox][posicaoy] instanceof Escolta2)
                                           {
                                               table[posicaox][posicaoy].setIcon(esc2);
                                               e2amigo.setVivo(false);
                                           }
                                           if(matrizcelulajogador[posicaox][posicaoy] instanceof Escolta3)
                                           {
                                               table[posicaox][posicaoy].setIcon(esc3);
                                               e3amigo.setVivo(false);
                                           }
                                           if(matrizcelulajogador[posicaox][posicaoy] instanceof Porta1)
                                           {
                                               table[posicaox][posicaoy].setIcon(port1);
                                               p1amigo.setVivo(false);
                                           }
                                           if(matrizcelulajogador[posicaox][posicaoy] instanceof Porta2)
                                           {
                                               table[posicaox][posicaoy].setIcon(port2);
                                               p2amigo.setVivo(false);
                                           }
                                           if(matrizcelulajogador[posicaox][posicaoy] instanceof Porta3)
                                           {
                                               table[posicaox][posicaoy].setIcon(port3);
                                               p3amigo.setVivo(false);
                                           }
                                           if(matrizcelulajogador[posicaox][posicaoy] instanceof Porta4)
                                           {
                                               table[posicaox][posicaoy].setIcon(port4); 
                                               p4amigo.setVivo(false);
                                           }
                                           if(matrizcelulajogador[posicaox][posicaoy] instanceof NaoCelula)
                                           {
                                               table[posicaox][posicaoy].setIcon(naocelula);
                                           }//Vempla
                                           if(contif == 0)
                                            {
                                                 if(s1amigo.getVivo() == false && s2amigo.getVivo() == false)
                                                 {
                                                    botaoS.setBackground(Color.red);
                                                    botaoS.setIcon(new ImageIcon("./submarino.png"));
                                                    cont = 0; 
                                                    contif = 1;
                                                 }
                                            }
                                            if(contifJ == 0) //fazer o jato ficar vermelho
                                            {
                                                 if(j1amigo.getVivo() == false && j2amigo.getVivo() == false)
                                                 {
                                                    botaoJ.setBackground(Color.red);
                                                    botaoJ.setIcon(new ImageIcon("./jato.png"));
                                                    cont = 0; 
                                                    contifJ = 1;
                                                 }
                                            }
                                            if(contifE == 0) //fazer o escolta ficar vermelho
                                            {
                                                 if(e1amigo.getVivo() == false && e2amigo.getVivo() == false && e3amigo.getVivo() == false)
                                                 {
                                                    botaoE.setBackground(Color.red);
                                                    botaoE.setIcon(new ImageIcon("./escolta.png"));
                                                    cont = 0; 
                                                    contifE = 1;
                                                 }
                                            }
                                           if(s1amigo.getVivo() == false && s2amigo.getVivo() == false && j1amigo.getVivo() == false && j2amigo.getVivo() == false && e1amigo.getVivo() == false && e2amigo.getVivo() == false && e3amigo.getVivo() == false)
                                           {
                                               loser();
                                           }
                                           pcjaclicou[posicaox][posicaoy] = true; 
                                       }
                                       else
                                       {
                                           l = -1; 
                                       }
                                   }

                               }
                               if(rand == 2 && contEPC == 0)//re
                               {
                                   for(int l = 0; l < 1; l++)
                                   {
                                       posicaox = random.nextInt(10);
                                       posicaoy = random.nextInt(10);

                                       if(pcjaclicou[posicaox][posicaoy] == false)
                                       {
                                           if(matrizcelulajogador[posicaox][posicaoy] instanceof Submarino1)
                                           {
                                               table[posicaox][posicaoy].setIcon(sub1);
                                               s1amigo.setVivo(false);
                                               
                                               table[posicaox][posicaoy + 1].setIcon(sub2);
                                               s2amigo.setVivo(false);     
                                           }
                                           if(matrizcelulajogador[posicaox][posicaoy] instanceof Submarino2)
                                           {
                                               table[posicaox][posicaoy].setIcon(sub2);
                                               s2amigo.setVivo(false);
                                               
                                               if(posicaoy + 1 < 10)
                                               {
                                                   if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof Jato1)
                                                   {
                                                       table[posicaox][posicaoy + 1].setIcon(jato1);
                                                       j1amigo.setVivo(false); 
                                                   }
                                                   if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof Escolta1)
                                                   {
                                                       table[posicaox][posicaoy + 1].setIcon(esc1);
                                                       e1amigo.setVivo(false); 
                                                   }
                                                   if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof Porta1)
                                                   {
                                                       table[posicaox][posicaoy + 1].setIcon(port1);
                                                       p1amigo.setVivo(false); 
                                                   }
                                                   if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof NaoCelula)
                                                   {
                                                       table[posicaox][posicaoy + 1].setIcon(naocelula); 
                                                   }
                                               }
                                           }
                                           if(matrizcelulajogador[posicaox][posicaoy] instanceof Jato1)
                                           {
                                               table[posicaox][posicaoy].setIcon(jato1);
                                               j1amigo.setVivo(false);
                                               
                                               table[posicaox][posicaoy + 1].setIcon(jato2);
                                               j2amigo.setVivo(false);  
                                           }
                                           if(matrizcelulajogador[posicaox][posicaoy] instanceof Jato2)
                                           {
                                               table[posicaox][posicaoy].setIcon(jato2);
                                               j2amigo.setVivo(false);
                                               
                                               if(posicaoy + 1 < 10)
                                               {
                                                   if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof Submarino1)
                                                   {
                                                       table[posicaox][posicaoy + 1].setIcon(sub1);
                                                       s1amigo.setVivo(false); 
                                                   }
                                                   if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof Escolta1)
                                                   {
                                                       table[posicaox][posicaoy + 1].setIcon(esc1);
                                                       e1amigo.setVivo(false); 
                                                   }
                                                   if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof Porta1)
                                                   {
                                                       table[posicaox][posicaoy + 1].setIcon(port1);
                                                       p1amigo.setVivo(false); 
                                                   }
                                                   if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof NaoCelula)
                                                   {
                                                       table[posicaox][posicaoy + 1].setIcon(naocelula); 
                                                   }
                                               }
                                           }
                                           if(matrizcelulajogador[posicaox][posicaoy] instanceof Escolta1)
                                           {
                                               table[posicaox][posicaoy].setIcon(esc1);
                                               e1amigo.setVivo(false);
                                               
                                               table[posicaox][posicaoy + 1].setIcon(esc2);
                                               e2amigo.setVivo(false);  
                                           }
                                           if(matrizcelulajogador[posicaox][posicaoy] instanceof Escolta2)
                                           {
                                               table[posicaox][posicaoy].setIcon(esc2);
                                               e2amigo.setVivo(false);
                                               
                                               table[posicaox][posicaoy + 1].setIcon(esc3);
                                               e3amigo.setVivo(false);  
                                           }
                                           if(matrizcelulajogador[posicaox][posicaoy] instanceof Escolta3)
                                           {
                                               table[posicaox][posicaoy].setIcon(esc3);
                                               e3amigo.setVivo(false);
                                               
                                               if(posicaoy + 1 < 10)
                                               {
                                                   if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof Submarino1)
                                                   {
                                                       table[posicaox][posicaoy + 1].setIcon(sub1);
                                                       s1amigo.setVivo(false); 
                                                   }
                                                   if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof Jato1)
                                                   {
                                                       table[posicaox][posicaoy + 1].setIcon(jato1);
                                                       j1amigo.setVivo(false); 
                                                   }
                                                   if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof Porta1)
                                                   {
                                                       table[posicaox][posicaoy + 1].setIcon(port1);
                                                       p1amigo.setVivo(false); 
                                                   }
                                                   if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof NaoCelula)
                                                   {
                                                       table[posicaox][posicaoy + 1].setIcon(naocelula); 
                                                   }
                                               }
                                           }
                                           if(matrizcelulajogador[posicaox][posicaoy] instanceof Porta1)//la
                                           {
                                               table[posicaox][posicaoy].setIcon(port1);
                                               p1amigo.setVivo(false);
                                               
                                               table[posicaox][posicaoy + 1].setIcon(port2);
                                               p2amigo.setVivo(false);  
                                           }
                                           if(matrizcelulajogador[posicaox][posicaoy] instanceof Porta2)
                                           {
                                               table[posicaox][posicaoy].setIcon(port2);
                                               p2amigo.setVivo(false);
                                               
                                               table[posicaox][posicaoy + 1].setIcon(port3);
                                               p3amigo.setVivo(false);  
                                           }
                                           if(matrizcelulajogador[posicaox][posicaoy] instanceof Porta3)
                                           {
                                               table[posicaox][posicaoy].setIcon(port3);
                                               p3amigo.setVivo(false);
                                               
                                               table[posicaox][posicaoy + 1].setIcon(port4); 
                                               p4amigo.setVivo(false);  
                                           }
                                           if(matrizcelulajogador[posicaox][posicaoy] instanceof Porta4)
                                           {
                                               table[posicaox][posicaoy].setIcon(port4); 
                                               p4amigo.setVivo(false);
                                               
                                               if(posicaoy + 1 < 10)
                                               {
                                                   if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof Submarino1)
                                                   {
                                                       table[posicaox][posicaoy + 1].setIcon(sub1);
                                                       s1amigo.setVivo(false); 
                                                   }
                                                   if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof Jato1)
                                                   {
                                                       table[posicaox][posicaoy + 1].setIcon(jato1);
                                                       j1amigo.setVivo(false); 
                                                   }
                                                   if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof Escolta1)
                                                   {
                                                       table[posicaox][posicaoy + 1].setIcon(esc1);
                                                       e1amigo.setVivo(false); 
                                                   }
                                                   if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof NaoCelula)
                                                   {
                                                       table[posicaox][posicaoy + 1].setIcon(naocelula); 
                                                   }
                                               }
                                           }
                                           if(matrizcelulajogador[posicaox][posicaoy] instanceof NaoCelula)
                                           {
                                               table[posicaox][posicaoy].setIcon(naocelula);                                                      
                                               if(posicaoy + 1 < 10)
                                               {
                                                   if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof Submarino1)
                                                   {
                                                       table[posicaox][posicaoy + 1].setIcon(sub1);
                                                       s1amigo.setVivo(false); 
                                                   }
                                                   if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof Jato1)
                                                   {
                                                       table[posicaox][posicaoy + 1].setIcon(jato1);
                                                       j1amigo.setVivo(false); 
                                                   }
                                                   if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof Escolta1)
                                                   {
                                                       table[posicaox][posicaoy + 1].setIcon(esc1);
                                                       e1amigo.setVivo(false); 
                                                   }
                                                   if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof Porta1)
                                                   {
                                                       table[posicaox][posicaoy + 1].setIcon(port1);
                                                       e1amigo.setVivo(false); 
                                                   }
                                                   if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof NaoCelula)
                                                   {
                                                       table[posicaox][posicaoy + 1].setIcon(naocelula); 
                                                   }
                                               }
                                           }
                                           if(contif == 0)
                                            {
                                                 if(s1amigo.getVivo() == false && s2amigo.getVivo() == false)
                                                 {
                                                    botaoS.setBackground(Color.red);
                                                    botaoS.setIcon(new ImageIcon("./submarino.png"));
                                                    cont = 0; 
                                                    contif = 1;
                                                 }
                                            }
                                            if(contifJ == 0) //fazer o jato ficar vermelho
                                            {
                                                 if(j1amigo.getVivo() == false && j2amigo.getVivo() == false)
                                                 {
                                                    botaoJ.setBackground(Color.red);
                                                    botaoJ.setIcon(new ImageIcon("./jato.png"));
                                                    cont = 0; 
                                                    contifJ = 1;
                                                 }
                                            }
                                            if(contifE == 0) //fazer o escolta ficar vermelho
                                            {
                                                 if(e1amigo.getVivo() == false && e2amigo.getVivo() == false && e3amigo.getVivo() == false)
                                                 {
                                                    botaoE.setBackground(Color.red);
                                                    botaoE.setIcon(new ImageIcon("./escolta.png"));
                                                    cont = 0; 
                                                    contifE = 1;
                                                 }
                                            }
                                           if(s1amigo.getVivo() == false && s2amigo.getVivo() == false && j1amigo.getVivo() == false && j2amigo.getVivo() == false && e1amigo.getVivo() == false && e2amigo.getVivo() == false && e3amigo.getVivo() == false)
                                           {
                                                loser();
                                           }
                                           
                                           pcjaclicou[posicaox][posicaoy] = true; 
                                           if(posicaoy + 1 < 10)
                                           {
                                               pcjaclicou[posicaox][posicaoy + 1] = true; 
                                           }
                                       }
                                       else
                                       {
                                           l = -1; 
                                       }
                                   } 
                               }
                               if(rand == 3 && contJPC == 0)
                               {
                                   for(int l = 0; l < 1; l++)
                                   {
                                       posicaox = random.nextInt(10);
                                       posicaoy = random.nextInt(10);

                                       if(pcjaclicou[posicaox][posicaoy] == false)//pe
                                       {
                                           if(matrizcelulajogador[posicaox][posicaoy] instanceof Submarino1)
                                           {
                                               table[posicaox][posicaoy].setIcon(sub1);
                                               s1amigo.setVivo(false);
                                               table[posicaox][posicaoy + 1].setIcon(sub2);
                                               s2amigo.setVivo(false);
                                               
                                               if(posicaoy - 1 >= 0)
                                               {
                                                    if(matrizcelulajogador[posicaox][posicaoy - 1] instanceof Jato2)
                                                    {
                                                        table[posicaox][posicaoy - 1].setIcon(jato2);
                                                        j2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox][posicaoy - 1] instanceof Escolta3)
                                                    {
                                                        table[posicaox][posicaoy - 1].setIcon(esc3);
                                                        e3amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox][posicaoy - 1] instanceof Porta4)
                                                    {
                                                        table[posicaox][posicaoy - 1].setIcon(port4); 
                                                        p4amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox][posicaoy - 1] instanceof NaoCelula)
                                                    {
                                                        table[posicaox][posicaoy - 1].setIcon(naocelula);
                                                    }
                                               }
                                               
                                               //em cima
                                               if(posicaox - 1 >= 0)
                                               {
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Jato1)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(jato1);
                                                        j1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Jato2)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(jato2);
                                                        j2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Escolta1)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(esc1);
                                                        e1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Escolta2)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(esc2);
                                                        e2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Escolta3)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(esc3);
                                                        e3amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Porta1)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(port1);
                                                        p1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Porta2)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(port2);
                                                        p2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Porta3)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(port3);
                                                        p3amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Porta4)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(port4); 
                                                        p4amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof NaoCelula)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(naocelula);
                                                    }
                                               }
                                               
                                               //em baixo
                                               if(posicaox + 1 < 10)
                                               {
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Jato1)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(jato1);
                                                        j1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Jato2)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(jato2);
                                                        j2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Escolta1)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(esc1);
                                                        e1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Escolta2)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(esc2);
                                                        e2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Escolta3)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(esc3);
                                                        e3amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Porta1)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(port1);
                                                        p1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Porta2)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(port2);
                                                        p2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Porta3)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(port3);
                                                        p3amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Porta4)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(port4); 
                                                        p4amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof NaoCelula)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(naocelula);
                                                    }
                                               }
                                           }
                                           if(matrizcelulajogador[posicaox][posicaoy] instanceof Submarino2)
                                           {
                                               table[posicaox][posicaoy].setIcon(sub2);
                                               s2amigo.setVivo(false);
                                               
                                               table[posicaox][posicaoy - 1].setIcon(sub1);
                                               s1amigo.setVivo(false);
                                               
                                               if(posicaoy + 1 < 10)
                                               {
                                                   if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof Jato1)
                                                    {
                                                        table[posicaox][posicaoy + 1].setIcon(jato1);
                                                        j1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof Escolta1)
                                                    {
                                                        table[posicaox][posicaoy + 1].setIcon(esc1);
                                                        e1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof Porta1)
                                                    {
                                                        table[posicaox][posicaoy + 1].setIcon(port1);
                                                        p1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof NaoCelula)
                                                    {
                                                        table[posicaox][posicaoy + 1].setIcon(naocelula);
                                                    }
                                               }
                                               
                                               //em cima
                                               if(posicaox - 1 >= 0)
                                               {
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Jato1)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(jato1);
                                                        j1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Jato2)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(jato2);
                                                        j2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Escolta1)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(esc1);
                                                        e1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Escolta2)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(esc2);
                                                        e2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Escolta3)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(esc3);
                                                        e3amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Porta1)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(port1);
                                                        p1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Porta2)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(port2);
                                                        p2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Porta3)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(port3);
                                                        p3amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Porta4)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(port4); 
                                                        p4amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof NaoCelula)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(naocelula);
                                                    }
                                               }
                                               
                                               //em baixo
                                               if(posicaox + 1 < 10)
                                               {
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Jato1)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(jato1);
                                                        j1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Jato2)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(jato2);
                                                        j2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Escolta1)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(esc1);
                                                        e1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Escolta2)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(esc2);
                                                        e2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Escolta3)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(esc3);
                                                        e3amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Porta1)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(port1);
                                                        p1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Porta2)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(port2);
                                                        p2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Porta3)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(port3);
                                                        p3amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Porta4)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(port4); 
                                                        p4amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof NaoCelula)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(naocelula);
                                                    }
                                               }
               
                                           }
                                           if(matrizcelulajogador[posicaox][posicaoy] instanceof Jato1)
                                           {
                                               table[posicaox][posicaoy].setIcon(jato1);
                                               j1amigo.setVivo(false);
                                               table[posicaox][posicaoy + 1].setIcon(jato2);
                                               j2amigo.setVivo(false);
                                               
                                               if(posicaoy - 1 >= 0)
                                               {
                                                    if(matrizcelulajogador[posicaox][posicaoy - 1] instanceof Submarino2)
                                                    {
                                                        table[posicaox][posicaoy - 1].setIcon(sub2);
                                                        s2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox][posicaoy - 1] instanceof Escolta3)
                                                    {
                                                        table[posicaox][posicaoy - 1].setIcon(esc3);
                                                        e3amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox][posicaoy - 1] instanceof Porta4)
                                                    {
                                                        table[posicaox][posicaoy - 1].setIcon(port4); 
                                                        p4amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox][posicaoy - 1] instanceof NaoCelula)
                                                    {
                                                        table[posicaox][posicaoy - 1].setIcon(naocelula);
                                                    }
                                               }
                                               
                                               //em cima
                                               if(posicaox - 1 >= 0)
                                               {
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Submarino1)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(sub1);
                                                        s1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Submarino2)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(sub2);
                                                        s2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Escolta1)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(esc1);
                                                        e1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Escolta2)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(esc2);
                                                        e2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Escolta3)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(esc3);
                                                        e3amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Porta1)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(port1);
                                                        p1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Porta2)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(port2);
                                                        p2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Porta3)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(port3);
                                                        p3amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Porta4)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(port4); 
                                                        p4amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof NaoCelula)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(naocelula);
                                                    }
                                               }
                                               
                                               //em baixo
                                               if(posicaox + 1 < 10)
                                               {
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Submarino1)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(sub1);
                                                        s1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Submarino2)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(sub2);
                                                        s2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Escolta1)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(esc1);
                                                        e1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Escolta2)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(esc2);
                                                        e2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Escolta3)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(esc3);
                                                        e3amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Porta1)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(port1);
                                                        p1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Porta2)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(port2);
                                                        p2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Porta3)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(port3);
                                                        p3amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Porta4)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(port4); 
                                                        p4amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof NaoCelula)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(naocelula);
                                                    }
                                               }
                                           }
                                           if(matrizcelulajogador[posicaox][posicaoy] instanceof Jato2)
                                           {
                                               table[posicaox][posicaoy].setIcon(jato2);
                                               j2amigo.setVivo(false);
                                               table[posicaox][posicaoy - 1].setIcon(jato1);
                                               j1amigo.setVivo(false);
                                               
                                               if(posicaoy + 1 < 10)
                                               {
                                                    if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof Submarino1)
                                                    {
                                                        table[posicaox][posicaoy + 1].setIcon(sub1);
                                                        s1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof Escolta1)
                                                    {
                                                        table[posicaox][posicaoy + 1].setIcon(esc1);
                                                        e1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof Porta1)
                                                    {
                                                        table[posicaox][posicaoy + 1].setIcon(port1);
                                                        p1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof NaoCelula)
                                                    {
                                                        table[posicaox][posicaoy + 1].setIcon(naocelula);
                                                    }
                                               }
                                               //em cima
                                               if(posicaox - 1 >= 0)
                                               {
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Submarino1)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(sub1);
                                                        s1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Submarino2)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(sub2);
                                                        s2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Escolta1)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(esc1);
                                                        e1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Escolta2)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(esc2);
                                                        e2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Escolta3)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(esc3);
                                                        e3amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Porta1)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(port1);
                                                        p1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Porta2)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(port2);
                                                        p2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Porta3)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(port3);
                                                        p3amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Porta4)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(port4); 
                                                        p4amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof NaoCelula)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(naocelula);
                                                    }
                                               }
                                               
                                               //em baixo
                                               if(posicaox + 1 < 10)
                                               {
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Submarino1)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(sub1);
                                                        s1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Submarino2)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(sub2);
                                                        s2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Escolta1)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(esc1);
                                                        e1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Escolta2)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(esc2);
                                                        e2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Escolta3)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(esc3);
                                                        e3amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Porta1)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(port1);
                                                        p1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Porta2)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(port2);
                                                        p2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Porta3)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(port3);
                                                        p3amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Porta4)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(port4); 
                                                        p4amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof NaoCelula)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(naocelula);
                                                    }
                                               }
                                               
                                           }
                                           if(matrizcelulajogador[posicaox][posicaoy] instanceof Escolta1)
                                           {
                                               table[posicaox][posicaoy].setIcon(esc1);
                                               e1amigo.setVivo(false);
                                               table[posicaox][posicaoy + 1].setIcon(esc2);
                                               e2amigo.setVivo(false);
                                               
                                               if(posicaoy - 1 >= 0)
                                               {
                                                    if(matrizcelulajogador[posicaox][posicaoy - 1] instanceof Submarino2)
                                                    {
                                                        table[posicaox][posicaoy - 1].setIcon(sub2);
                                                        s2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox][posicaoy - 1] instanceof Jato2)
                                                    {
                                                        table[posicaox][posicaoy - 1].setIcon(jato2);
                                                        j2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox][posicaoy - 1] instanceof Porta4)
                                                    {
                                                        table[posicaox][posicaoy - 1].setIcon(port4); 
                                                        p4amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox][posicaoy - 1] instanceof NaoCelula)
                                                    {
                                                        table[posicaox][posicaoy - 1].setIcon(naocelula);
                                                    }
                                               }
                                               //em cima
                                               if(posicaox - 1 >= 0)
                                               {
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Submarino1)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(sub1);
                                                        s1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Submarino2)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(sub2);
                                                        s2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Jato1)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(jato1);
                                                        j1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Jato2)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(jato2);
                                                        j2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Porta1)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(port1);
                                                        p1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Porta2)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(port2);
                                                        p2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Porta3)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(port3);
                                                        p3amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Porta4)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(port4); 
                                                        p4amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof NaoCelula)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(naocelula);
                                                    }
                                               }
                                               
                                               //em baixo
                                               if(posicaox + 1 < 10)
                                               {
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Submarino1)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(sub1);
                                                        s1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Submarino2)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(sub2);
                                                        s2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Jato1)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(jato1);
                                                        j1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Jato2)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(jato2);
                                                        j2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Porta1)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(port1);
                                                        p1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Porta2)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(port2);
                                                        p2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Porta3)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(port3);
                                                        p3amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Porta4)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(port4); 
                                                        p4amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof NaoCelula)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(naocelula);
                                                    }
                                               }
                                           }
                                           if(matrizcelulajogador[posicaox][posicaoy] instanceof Escolta2)
                                           {
                                               table[posicaox][posicaoy].setIcon(esc2);
                                               e2amigo.setVivo(false);
                                               table[posicaox][posicaoy - 1].setIcon(esc1);
                                               e1amigo.setVivo(false);
                                               table[posicaox][posicaoy + 1].setIcon(esc3);
                                               e3amigo.setVivo(false);
                                               
                                               //em cima
                                               if(posicaox - 1 >= 0)
                                               {
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Submarino1)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(sub1);
                                                        s1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Submarino2)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(sub2);
                                                        s2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Jato1)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(jato1);
                                                        j1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Jato2)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(jato2);
                                                        j2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Porta1)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(port1);
                                                        p1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Porta2)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(port2);
                                                        p2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Porta3)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(port3);
                                                        p3amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Porta4)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(port4); 
                                                        p4amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof NaoCelula)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(naocelula);
                                                    }
                                               }
                                               
                                               //em baixo
                                               if(posicaox + 1 < 10)
                                               {
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Submarino1)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(sub1);
                                                        s1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Submarino2)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(sub2);
                                                        s2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Jato1)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(jato1);
                                                        j1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Jato2)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(jato2);
                                                        j2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Porta1)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(port1);
                                                        p1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Porta2)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(port2);
                                                        p2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Porta3)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(port3);
                                                        p3amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Porta4)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(port4); 
                                                        p4amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof NaoCelula)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(naocelula);
                                                    }
                                               }
                                               
                                           }
                                           if(matrizcelulajogador[posicaox][posicaoy] instanceof Escolta3)
                                           {
                                               table[posicaox][posicaoy].setIcon(esc3);
                                               e3amigo.setVivo(false);
                                               table[posicaox][posicaoy - 1].setIcon(esc2);
                                               e2amigo.setVivo(false);
                                               
                                               if(posicaoy + 1 < 10)
                                               {
                                                    if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof Submarino1)
                                                    {
                                                        table[posicaox][posicaoy + 1].setIcon(sub1);
                                                        s1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof Jato1)
                                                    {
                                                        table[posicaox][posicaoy + 1].setIcon(jato1);
                                                        j1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof Porta1)
                                                    {
                                                        table[posicaox][posicaoy + 1].setIcon(port1);
                                                        p1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof NaoCelula)
                                                    {
                                                        table[posicaox][posicaoy + 1].setIcon(naocelula);
                                                    }
                                               }
                                               //em cima
                                               if(posicaox - 1 >= 0)
                                               {
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Submarino1)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(sub1);
                                                        s1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Submarino2)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(sub2);
                                                        s2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Jato1)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(jato1);
                                                        j1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Jato2)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(jato2);
                                                        j2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Porta1)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(port1);
                                                        p1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Porta2)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(port2);
                                                        p2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Porta3)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(port3);
                                                        p3amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Porta4)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(port4); 
                                                        p4amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof NaoCelula)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(naocelula);
                                                    }
                                               }
                                               
                                               //em baixo
                                               if(posicaox + 1 < 10)
                                               {
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Submarino1)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(sub1);
                                                        s1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Submarino2)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(sub2);
                                                        s2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Jato1)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(jato1);
                                                        j1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Jato2)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(jato2);
                                                        j2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Porta1)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(port1);
                                                        p1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Porta2)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(port2);
                                                        p2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Porta3)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(port3);
                                                        p3amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Porta4)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(port4); 
                                                        p4amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof NaoCelula)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(naocelula);
                                                    }
                                               }
                                               
                                           }
                                           if(matrizcelulajogador[posicaox][posicaoy] instanceof Porta1)
                                           {
                                               table[posicaox][posicaoy].setIcon(port1);
                                               p1amigo.setVivo(false);
                                               table[posicaox][posicaoy + 1].setIcon(port2);
                                               p2amigo.setVivo(false);
                                               
                                               if(posicaoy - 1 >= 0)
                                               {
                                                    if(matrizcelulajogador[posicaox][posicaoy - 1] instanceof Submarino2)
                                                    {
                                                        table[posicaox][posicaoy - 1].setIcon(sub2);
                                                        s2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox][posicaoy - 1] instanceof Jato2)
                                                    {
                                                        table[posicaox][posicaoy - 1].setIcon(jato2);
                                                        j2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox][posicaoy - 1] instanceof Escolta3)
                                                    {
                                                        table[posicaox][posicaoy - 1].setIcon(esc3);
                                                        e3amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox][posicaoy - 1] instanceof NaoCelula)
                                                    {
                                                        table[posicaox][posicaoy - 1].setIcon(naocelula);
                                                    }
                                               }
                                               //em cima
                                               if(posicaox - 1 >= 0)
                                               {
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Submarino1)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(sub1);
                                                        s1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Submarino2)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(sub2);
                                                        s2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Jato1)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(jato1);
                                                        j1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Jato2)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(jato2);
                                                        j2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Escolta1)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(esc1);
                                                        e1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Escolta2)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(esc2);
                                                        e2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Escolta3)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(esc3);
                                                        e3amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof NaoCelula)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(naocelula);
                                                    }
                                               }
                                               
                                               //em baixo
                                               if(posicaox + 1 < 10)
                                               {
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Submarino1)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(sub1);
                                                        s1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Submarino2)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(sub2);
                                                        s2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Jato1)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(jato1);
                                                        j1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Jato2)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(jato2);
                                                        j2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Escolta1)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(esc1);
                                                        e1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Escolta2)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(esc2);
                                                        e2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Escolta3)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(esc3);
                                                        e3amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof NaoCelula)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(naocelula);
                                                    }
                                               }
                                               
                                           }
                                           if(matrizcelulajogador[posicaox][posicaoy] instanceof Porta2)
                                           {
                                               table[posicaox][posicaoy].setIcon(port2);
                                               p2amigo.setVivo(false);
                                               table[posicaox][posicaoy - 1].setIcon(port1);
                                               p1amigo.setVivo(false);
                                               table[posicaox][posicaoy + 1].setIcon(port3);
                                               p3amigo.setVivo(false);
                                               
                                               //em cima
                                               if(posicaox - 1 >= 0)
                                               {
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Submarino1)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(sub1);
                                                        s1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Submarino2)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(sub2);
                                                        s2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Jato1)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(jato1);
                                                        j1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Jato2)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(jato2);
                                                        j2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Escolta1)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(esc1);
                                                        e1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Escolta2)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(esc2);
                                                        e2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Escolta3)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(esc3);
                                                        e3amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof NaoCelula)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(naocelula);
                                                    }
                                               }
                                               
                                               //em baixo
                                               if(posicaox + 1 < 10)
                                               {
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Submarino1)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(sub1);
                                                        s1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Submarino2)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(sub2);
                                                        s2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Jato1)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(jato1);
                                                        j1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Jato2)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(jato2);
                                                        j2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Escolta1)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(esc1);
                                                        e1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Escolta2)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(esc2);
                                                        e2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Escolta3)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(esc3);
                                                        e3amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof NaoCelula)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(naocelula);
                                                    }
                                               }
                                           }
                                           if(matrizcelulajogador[posicaox][posicaoy] instanceof Porta3)
                                           {
                                               table[posicaox][posicaoy].setIcon(port3);
                                               p3amigo.setVivo(false);
                                               table[posicaox][posicaoy - 1].setIcon(port2);
                                               p2amigo.setVivo(false);
                                               table[posicaox][posicaoy + 1].setIcon(port4); 
                                               p4amigo.setVivo(false);
                                               
                                               //em cima
                                               if(posicaox - 1 >= 0)
                                               {
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Submarino1)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(sub1);
                                                        s1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Submarino2)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(sub2);
                                                        s2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Jato1)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(jato1);
                                                        j1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Jato2)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(jato2);
                                                        j2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Escolta1)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(esc1);
                                                        e1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Escolta2)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(esc2);
                                                        e2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Escolta3)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(esc3);
                                                        e3amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof NaoCelula)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(naocelula);
                                                    }
                                               }
                                               
                                               //em baixo
                                               if(posicaox + 1 < 10)
                                               {
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Submarino1)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(sub1);
                                                        s1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Submarino2)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(sub2);
                                                        s2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Jato1)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(jato1);
                                                        j1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Jato2)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(jato2);
                                                        j2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Escolta1)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(esc1);
                                                        e1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Escolta2)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(esc2);
                                                        e2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Escolta3)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(esc3);
                                                        e3amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof NaoCelula)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(naocelula);
                                                    }
                                               }
                                           }
                                           if(matrizcelulajogador[posicaox][posicaoy] instanceof Porta4)
                                           {
                                               table[posicaox][posicaoy].setIcon(port4); 
                                               p4amigo.setVivo(false);
                                               table[posicaox][posicaoy - 1].setIcon(port3);
                                               p3amigo.setVivo(false);
                                               
                                               if(posicaoy + 1 < 10)
                                               {
                                                    if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof Submarino1)
                                                    {
                                                        table[posicaox][posicaoy + 1].setIcon(sub1);
                                                        s1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof Escolta1)
                                                    {
                                                        table[posicaox][posicaoy + 1].setIcon(esc1);
                                                        e1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof Jato1)
                                                    {
                                                        table[posicaox][posicaoy + 1].setIcon(jato1);
                                                        j1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof NaoCelula)
                                                    {
                                                        table[posicaox][posicaoy + 1].setIcon(naocelula);
                                                    }
                                               }
                                               //em cima
                                               if(posicaox - 1 >= 0)
                                               {
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Submarino1)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(sub1);
                                                        s1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Submarino2)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(sub2);
                                                        s2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Jato1)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(jato1);
                                                        j1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Jato2)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(jato2);
                                                        j2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Escolta1)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(esc1);
                                                        e1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Escolta2)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(esc2);
                                                        e2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Escolta3)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(esc3);
                                                        e3amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof NaoCelula)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(naocelula);
                                                    }
                                               }
                                               
                                               //em baixo
                                               if(posicaox + 1 < 10)
                                               {
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Submarino1)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(sub1);
                                                        s1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Submarino2)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(sub2);
                                                        s2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Jato1)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(jato1);
                                                        j1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Jato2)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(jato2);
                                                        j2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Escolta1)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(esc1);
                                                        e1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Escolta2)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(esc2);
                                                        e2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Escolta3)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(esc3);
                                                        e3amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof NaoCelula)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(naocelula);
                                                    }
                                               }
                                           }
                                           if(matrizcelulajogador[posicaox][posicaoy] instanceof NaoCelula)
                                           {
                                               table[posicaox][posicaoy].setIcon(naocelula);
                                               
                                               //Direita
                                               if(posicaoy + 1 < 10)
                                               {
                                                    if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof Submarino1)
                                                    {
                                                        table[posicaox][posicaoy + 1].setIcon(sub1);
                                                        s1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof Jato1)
                                                    {
                                                        table[posicaox][posicaoy + 1].setIcon(jato1);
                                                        j1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof Escolta1)
                                                    {
                                                        table[posicaox][posicaoy + 1].setIcon(esc1);
                                                        e1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof Porta1)
                                                    {
                                                        table[posicaox][posicaoy + 1].setIcon(port1);
                                                        p1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof NaoCelula)
                                                    {
                                                        table[posicaox][posicaoy + 1].setIcon(naocelula);
                                                    }
                                               }
                                               
                                               if(posicaoy - 1 >= 0)
                                               {
                                                    if(matrizcelulajogador[posicaox][posicaoy - 1] instanceof Submarino2)
                                                    {
                                                        table[posicaox][posicaoy - 1].setIcon(sub2);
                                                        s2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox][posicaoy - 1] instanceof Jato2)
                                                    {
                                                        table[posicaox][posicaoy - 1].setIcon(jato2);
                                                        j2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox][posicaoy - 1] instanceof Escolta3)
                                                    {
                                                        table[posicaox][posicaoy - 1].setIcon(esc3);
                                                        e3amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox][posicaoy - 1] instanceof Porta4)
                                                    {
                                                        table[posicaox][posicaoy - 1].setIcon(port4); 
                                                        p4amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox][posicaoy - 1] instanceof NaoCelula)
                                                    {
                                                        table[posicaox][posicaoy - 1].setIcon(naocelula);
                                                    }
                                               }
                                               
                                               //em cima
                                               if(posicaox - 1 >= 0)
                                               {
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Submarino1)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(sub1);
                                                        s1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Submarino2)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(sub2);
                                                        s2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Jato1)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(jato1);
                                                        j1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Jato2)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(jato2);
                                                        j2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Escolta1)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(esc1);
                                                        e1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Escolta2)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(esc2);
                                                        e2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Escolta3)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(esc3);
                                                        e3amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Porta1)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(port1);
                                                        p1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Porta2)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(port2);
                                                        p2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Porta3)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(port3);
                                                        p3amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Porta4)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(port4); 
                                                        p4amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof NaoCelula)
                                                    {
                                                        table[posicaox - 1][posicaoy].setIcon(naocelula);
                                                    }
                                               }
                                               
                                               //em baixo
                                               if(posicaox + 1 < 10)
                                               {
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Submarino1)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(sub1);
                                                        s1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Submarino2)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(sub2);
                                                        s2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Jato1)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(jato1);
                                                        j1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Jato2)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(jato2);
                                                        j2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Escolta1)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(esc1);
                                                        e1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Escolta2)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(esc2);
                                                        e2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Escolta3)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(esc3);
                                                        e3amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Porta1)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(port1);
                                                        p1amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Porta2)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(port2);
                                                        p2amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Porta3)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(port3);
                                                        p3amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Porta4)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(port4); 
                                                        p4amigo.setVivo(false);
                                                    }
                                                    if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof NaoCelula)
                                                    {
                                                        table[posicaox + 1][posicaoy].setIcon(naocelula);
                                                    }
                                               }
                                           }//ta
                                           
                                           if(contif == 0)
                                            {
                                                 if(s1amigo.getVivo() == false && s2amigo.getVivo() == false)
                                                 {
                                                    botaoS.setBackground(Color.red);
                                                    botaoS.setIcon(new ImageIcon("./submarino.png"));
                                                    cont = 0; 
                                                    contif = 1;
                                                 }
                                            }
                                            if(contifJ == 0) //fazer o jato ficar vermelho
                                            {
                                                 if(j1amigo.getVivo() == false && j2amigo.getVivo() == false)
                                                 {
                                                    botaoJ.setBackground(Color.red);
                                                    botaoJ.setIcon(new ImageIcon("./jato.png"));
                                                    cont = 0; 
                                                    contifJ = 1;
                                                 }
                                            }
                                            if(contifE == 0) //fazer o escolta ficar vermelho
                                            {
                                                 if(e1amigo.getVivo() == false && e2amigo.getVivo() == false && e3amigo.getVivo() == false)
                                                 {
                                                    botaoE.setBackground(Color.red);
                                                    botaoE.setIcon(new ImageIcon("./escolta.png"));
                                                    cont = 0; 
                                                    contifE = 1;
                                                 }
                                            }
                                            if(s1amigo.getVivo() == false && s2amigo.getVivo() == false && j1amigo.getVivo() == false && j2amigo.getVivo() == false && e1amigo.getVivo() == false && e2amigo.getVivo() == false && e3amigo.getVivo() == false)
                                            {
                                                loser(); 
                                            }
                                            pcjaclicou[posicaox][posicaoy] = true;
                                            if(posicaoy - 1 >= 0)
                                            {
                                                pcjaclicou[posicaox][posicaoy - 1] = true;
                                            }
                                            if(posicaox - 1 >= 0)
                                            {
                                                pcjaclicou[posicaox - 1] [posicaoy] = true;
                                            }
                                            if(posicaox + 1 < 10)
                                            {
                                                pcjaclicou[posicaox + 1] [posicaoy] = true;
                                            }
                                            if(posicaoy + 1 < 10)
                                            {
                                                pcjaclicou[posicaox][posicaoy + 1] = true;
                                            }
                                       }
                                       else
                                       {
                                           l = -1; 
                                       }
                                   }
                               }
                            }
                            else
                            {
                                k = -1; 
                            }
                        }
                    }
                }
            }
        }
    }
    if(cont == 3 && dicaativada == false)
    {
        for(int i = 0; i<10 ; i++)
        {
            for(int j = 0; j<10 ; j++)
            {
                if(jaclicou[i][j] == false)
                {
                    if(object == teste[i][j])
                    {
                        if(jaclicou[i][j] == false)
                        {
                            if(matrizcelulapc[i][j] instanceof Submarino1)
                            {
                                teste[i][j].setIcon(sub1);
                                s1inimigo.setVivo(false);
                                teste[i][j + 1].setIcon(sub2);
                                s2inimigo.setVivo(false);

                                if(j - 1 >= 0)
                                {
                                     if(matrizcelulapc[i][j - 1] instanceof Jato2)
                                     {
                                         teste[i][j - 1].setIcon(jato2);
                                         j2inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i][j - 1] instanceof Escolta3)
                                     {
                                         teste[i][j - 1].setIcon(esc3);
                                         e3inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i][j - 1] instanceof Porta4)
                                     {
                                         teste[i][j - 1].setIcon(port4); 
                                         p4inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i][j - 1] instanceof NaoCelula)
                                     {
                                         teste[i][j - 1].setIcon(naocelula);
                                     }
                                }

                                //em cima
                                if(i - 1 >= 0)
                                {
                                     if(matrizcelulapc[i - 1][j] instanceof Jato1)
                                     {
                                         teste[i - 1][j].setIcon(jato1);
                                         j1inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i - 1][j] instanceof Jato2)
                                     {
                                         teste[i - 1][j].setIcon(jato2);
                                         j2inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i - 1][j] instanceof Escolta1)
                                     {
                                         teste[i - 1][j].setIcon(esc1);
                                         e1inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i - 1][j] instanceof Escolta2)
                                     {
                                         teste[i - 1][j].setIcon(esc2);
                                         e2inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i - 1][j] instanceof Escolta3)
                                     {
                                         teste[i - 1][j].setIcon(esc3);
                                         e3inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i - 1][j] instanceof Porta1)
                                     {
                                         teste[i - 1][j].setIcon(port1);
                                         p1inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i - 1][j] instanceof Porta2)
                                     {
                                         teste[i - 1][j].setIcon(port2);
                                         p2inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i - 1][j] instanceof Porta3)
                                     {
                                         teste[i - 1][j].setIcon(port3);
                                         p3inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i - 1][j] instanceof Porta4)
                                     {
                                         teste[i - 1][j].setIcon(port4); 
                                         p4inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i - 1][j] instanceof NaoCelula)
                                     {
                                         teste[i - 1][j].setIcon(naocelula);
                                     }
                                }

                                //em baixo
                                if(i + 1 < 10)
                                {
                                     if(matrizcelulapc[i + 1][j] instanceof Jato1)
                                     {
                                         teste[i + 1][j].setIcon(jato1);
                                         j1inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i + 1][j] instanceof Jato2)
                                     {
                                         teste[i + 1][j].setIcon(jato2);
                                         j2inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i + 1][j] instanceof Escolta1)
                                     {
                                         teste[i + 1][j].setIcon(esc1);
                                         e1inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i + 1][j] instanceof Escolta2)
                                     {
                                         teste[i + 1][j].setIcon(esc2);
                                         e2inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i + 1][j] instanceof Escolta3)
                                     {
                                         teste[i + 1][j].setIcon(esc3);
                                         e3inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i + 1][j] instanceof Porta1)
                                     {
                                         teste[i + 1][j].setIcon(port1);
                                         p1inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i + 1][j] instanceof Porta2)
                                     {
                                         teste[i + 1][j].setIcon(port2);
                                         p2inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i + 1][j] instanceof Porta3)
                                     {
                                         teste[i + 1][j].setIcon(port3);
                                         p3inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i + 1][j] instanceof Porta4)
                                     {
                                         teste[i + 1][j].setIcon(port4); 
                                         p4inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i + 1][j] instanceof NaoCelula)
                                     {
                                         teste[i + 1][j].setIcon(naocelula);
                                     }
                                }
                            }
                            if(matrizcelulapc[i][j] instanceof Submarino2)
                            {
                                teste[i][j].setIcon(sub2);
                                s2inimigo.setVivo(false);

                                teste[i][j - 1].setIcon(sub1);
                                s1inimigo.setVivo(false);

                                if(j + 1 < 10)
                                {
                                    if(matrizcelulapc[i][j + 1] instanceof Jato1)
                                     {
                                         teste[i][j + 1].setIcon(jato1);
                                         j1inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i][j + 1] instanceof Escolta1)
                                     {
                                         teste[i][j + 1].setIcon(esc1);
                                         e1inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i][j + 1] instanceof Porta1)
                                     {
                                         teste[i][j + 1].setIcon(port1);
                                         p1inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i][j + 1] instanceof NaoCelula)
                                     {
                                         teste[i][j + 1].setIcon(naocelula);
                                     }
                                }

                                //em cima
                                if(i - 1 >= 0)
                                {
                                     if(matrizcelulapc[i - 1][j] instanceof Jato1)
                                     {
                                         teste[i - 1][j].setIcon(jato1);
                                         j1inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i - 1][j] instanceof Jato2)
                                     {
                                         teste[i - 1][j].setIcon(jato2);
                                         j2inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i - 1][j] instanceof Escolta1)
                                     {
                                         teste[i - 1][j].setIcon(esc1);
                                         e1inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i - 1][j] instanceof Escolta2)
                                     {
                                         teste[i - 1][j].setIcon(esc2);
                                         e2inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i - 1][j] instanceof Escolta3)
                                     {
                                         teste[i - 1][j].setIcon(esc3);
                                         e3inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i - 1][j] instanceof Porta1)
                                     {
                                         teste[i - 1][j].setIcon(port1);
                                         p1inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i - 1][j] instanceof Porta2)
                                     {
                                         teste[i - 1][j].setIcon(port2);
                                         p2inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i - 1][j] instanceof Porta3)
                                     {
                                         teste[i - 1][j].setIcon(port3);
                                         p3inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i - 1][j] instanceof Porta4)
                                     {
                                         teste[i - 1][j].setIcon(port4); 
                                         p4inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i - 1][j] instanceof NaoCelula)
                                     {
                                         teste[i - 1][j].setIcon(naocelula);
                                     }
                                }

                                //em baixo
                                if(i + 1 < 10)
                                {
                                     if(matrizcelulapc[i + 1][j] instanceof Jato1)
                                     {
                                         teste[i + 1][j].setIcon(jato1);
                                         j1inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i + 1][j] instanceof Jato2)
                                     {
                                         teste[i + 1][j].setIcon(jato2);
                                         j2inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i + 1][j] instanceof Escolta1)
                                     {
                                         teste[i + 1][j].setIcon(esc1);
                                         e1inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i + 1][j] instanceof Escolta2)
                                     {
                                         teste[i + 1][j].setIcon(esc2);
                                         e2inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i + 1][j] instanceof Escolta3)
                                     {
                                         teste[i + 1][j].setIcon(esc3);
                                         e3inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i + 1][j] instanceof Porta1)
                                     {
                                         teste[i + 1][j].setIcon(port1);
                                         p1inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i + 1][j] instanceof Porta2)
                                     {
                                         teste[i + 1][j].setIcon(port2);
                                         p2inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i + 1][j] instanceof Porta3)
                                     {
                                         teste[i + 1][j].setIcon(port3);
                                         p3inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i + 1][j] instanceof Porta4)
                                     {
                                         teste[i + 1][j].setIcon(port4); 
                                         p4inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i + 1][j] instanceof NaoCelula)
                                     {
                                         teste[i + 1][j].setIcon(naocelula);
                                     }
                                }

                            }
                            if(matrizcelulapc[i][j] instanceof Jato1)
                            {
                                teste[i][j].setIcon(jato1);
                                j1inimigo.setVivo(false);
                                teste[i][j + 1].setIcon(jato2);
                                j2inimigo.setVivo(false);

                                if(j - 1 >= 0)
                                {
                                     if(matrizcelulapc[i][j - 1] instanceof Submarino2)
                                     {
                                         teste[i][j - 1].setIcon(sub2);
                                         s2inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i][j - 1] instanceof Escolta3)
                                     {
                                         teste[i][j - 1].setIcon(esc3);
                                         e3inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i][j - 1] instanceof Porta4)
                                     {
                                         teste[i][j - 1].setIcon(port4); 
                                         p4inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i][j - 1] instanceof NaoCelula)
                                     {
                                         teste[i][j - 1].setIcon(naocelula);
                                     }
                                }

                                //em cima
                                if(i - 1 >= 0)
                                {
                                     if(matrizcelulapc[i - 1][j] instanceof Submarino1)
                                     {
                                         teste[i - 1][j].setIcon(sub1);
                                         s1inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i - 1][j] instanceof Submarino2)
                                     {
                                         teste[i - 1][j].setIcon(sub2);
                                         s2inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i - 1][j] instanceof Escolta1)
                                     {
                                         teste[i - 1][j].setIcon(esc1);
                                         e1inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i - 1][j] instanceof Escolta2)
                                     {
                                         teste[i - 1][j].setIcon(esc2);
                                         e2inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i - 1][j] instanceof Escolta3)
                                     {
                                         teste[i - 1][j].setIcon(esc3);
                                         e3inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i - 1][j] instanceof Porta1)
                                     {
                                         teste[i - 1][j].setIcon(port1);
                                         p1inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i - 1][j] instanceof Porta2)
                                     {
                                         teste[i - 1][j].setIcon(port2);
                                         p2inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i - 1][j] instanceof Porta3)
                                     {
                                         teste[i - 1][j].setIcon(port3);
                                         p3inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i - 1][j] instanceof Porta4)
                                     {
                                         teste[i - 1][j].setIcon(port4); 
                                         p4inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i - 1][j] instanceof NaoCelula)
                                     {
                                         teste[i - 1][j].setIcon(naocelula);
                                     }
                                }

                                //em baixo
                                if(i + 1 < 10)
                                {
                                     if(matrizcelulapc[i + 1][j] instanceof Submarino1)
                                     {
                                         teste[i + 1][j].setIcon(sub1);
                                         s1inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i + 1][j] instanceof Submarino2)
                                     {
                                         teste[i + 1][j].setIcon(sub2);
                                         s2inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i + 1][j] instanceof Escolta1)
                                     {
                                         teste[i + 1][j].setIcon(esc1);
                                         e1inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i + 1][j] instanceof Escolta2)
                                     {
                                         teste[i + 1][j].setIcon(esc2);
                                         e2inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i + 1][j] instanceof Escolta3)
                                     {
                                         teste[i + 1][j].setIcon(esc3);
                                         e3inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i + 1][j] instanceof Porta1)
                                     {
                                         teste[i + 1][j].setIcon(port1);
                                         p1inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i + 1][j] instanceof Porta2)
                                     {
                                         teste[i + 1][j].setIcon(port2);
                                         p2inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i + 1][j] instanceof Porta3)
                                     {
                                         teste[i + 1][j].setIcon(port3);
                                         p3inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i + 1][j] instanceof Porta4)
                                     {
                                         teste[i + 1][j].setIcon(port4); 
                                         p4inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i + 1][j] instanceof NaoCelula)
                                     {
                                         teste[i + 1][j].setIcon(naocelula);
                                     }
                                }
                            }
                            if(matrizcelulapc[i][j] instanceof Jato2)
                            {
                                teste[i][j].setIcon(jato2);
                                j2inimigo.setVivo(false);
                                teste[i][j - 1].setIcon(jato1);
                                j1inimigo.setVivo(false);

                                if(j + 1 < 10)
                                {
                                     if(matrizcelulapc[i][j + 1] instanceof Submarino1)
                                     {
                                         teste[i][j + 1].setIcon(sub1);
                                         s1inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i][j + 1] instanceof Escolta1)
                                     {
                                         teste[i][j + 1].setIcon(esc1);
                                         e1inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i][j + 1] instanceof Porta1)
                                     {
                                         teste[i][j + 1].setIcon(port1);
                                         p1inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i][j + 1] instanceof NaoCelula)
                                     {
                                         teste[i][j + 1].setIcon(naocelula);
                                     }
                                }
                                //em cima
                                if(i - 1 >= 0)
                                {
                                     if(matrizcelulapc[i - 1][j] instanceof Submarino1)
                                     {
                                         teste[i - 1][j].setIcon(sub1);
                                         s1inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i - 1][j] instanceof Submarino2)
                                     {
                                         teste[i - 1][j].setIcon(sub2);
                                         s2inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i - 1][j] instanceof Escolta1)
                                     {
                                         teste[i - 1][j].setIcon(esc1);
                                         e1inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i - 1][j] instanceof Escolta2)
                                     {
                                         teste[i - 1][j].setIcon(esc2);
                                         e2inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i - 1][j] instanceof Escolta3)
                                     {
                                         teste[i - 1][j].setIcon(esc3);
                                         e3inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i - 1][j] instanceof Porta1)
                                     {
                                         teste[i - 1][j].setIcon(port1);
                                         p1inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i - 1][j] instanceof Porta2)
                                     {
                                         teste[i - 1][j].setIcon(port2);
                                         p2inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i - 1][j] instanceof Porta3)
                                     {
                                         teste[i - 1][j].setIcon(port3);
                                         p3inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i - 1][j] instanceof Porta4)
                                     {
                                         teste[i - 1][j].setIcon(port4); 
                                         p4inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i - 1][j] instanceof NaoCelula)
                                     {
                                         teste[i - 1][j].setIcon(naocelula);
                                     }
                                }

                                //em baixo
                                if(i + 1 < 10)
                                {
                                     if(matrizcelulapc[i + 1][j] instanceof Submarino1)
                                     {
                                         teste[i + 1][j].setIcon(sub1);
                                         s1inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i + 1][j] instanceof Submarino2)
                                     {
                                         teste[i + 1][j].setIcon(sub2);
                                         s2inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i + 1][j] instanceof Escolta1)
                                     {
                                         teste[i + 1][j].setIcon(esc1);
                                         e1inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i + 1][j] instanceof Escolta2)
                                     {
                                         teste[i + 1][j].setIcon(esc2);
                                         e2inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i + 1][j] instanceof Escolta3)
                                     {
                                         teste[i + 1][j].setIcon(esc3);
                                         e3inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i + 1][j] instanceof Porta1)
                                     {
                                         teste[i + 1][j].setIcon(port1);
                                         p1inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i + 1][j] instanceof Porta2)
                                     {
                                         teste[i + 1][j].setIcon(port2);
                                         p2inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i + 1][j] instanceof Porta3)
                                     {
                                         teste[i + 1][j].setIcon(port3);
                                         p3inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i + 1][j] instanceof Porta4)
                                     {
                                         teste[i + 1][j].setIcon(port4); 
                                         p4inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i + 1][j] instanceof NaoCelula)
                                     {
                                         teste[i + 1][j].setIcon(naocelula);
                                     }
                                }

                            }
                            if(matrizcelulapc[i][j] instanceof Escolta1)
                            {
                                teste[i][j].setIcon(esc1);
                                e1inimigo.setVivo(false);
                                teste[i][j + 1].setIcon(esc2);
                                e2inimigo.setVivo(false);

                                if(j - 1 >= 0)
                                {
                                     if(matrizcelulapc[i][j - 1] instanceof Submarino2)
                                     {
                                         teste[i][j - 1].setIcon(sub2);
                                         s2inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i][j - 1] instanceof Jato2)
                                     {
                                         teste[i][j - 1].setIcon(jato2);
                                         j2inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i][j - 1] instanceof Porta4)
                                     {
                                         teste[i][j - 1].setIcon(port4); 
                                         p4inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i][j - 1] instanceof NaoCelula)
                                     {
                                         teste[i][j - 1].setIcon(naocelula);
                                     }
                                }
                                //em cima
                                if(i - 1 >= 0)
                                {
                                     if(matrizcelulapc[i - 1][j] instanceof Submarino1)
                                     {
                                         teste[i - 1][j].setIcon(sub1);
                                         s1inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i - 1][j] instanceof Submarino2)
                                     {
                                         teste[i - 1][j].setIcon(sub2);
                                         s2inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i - 1][j] instanceof Jato1)
                                     {
                                         teste[i - 1][j].setIcon(jato1);
                                         j1inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i - 1][j] instanceof Jato2)
                                     {
                                         teste[i - 1][j].setIcon(jato2);
                                         j2inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i - 1][j] instanceof Porta1)
                                     {
                                         teste[i - 1][j].setIcon(port1);
                                         p1inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i - 1][j] instanceof Porta2)
                                     {
                                         teste[i - 1][j].setIcon(port2);
                                         p2inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i - 1][j] instanceof Porta3)
                                     {
                                         teste[i - 1][j].setIcon(port3);
                                         p3inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i - 1][j] instanceof Porta4)
                                     {
                                         teste[i - 1][j].setIcon(port4); 
                                         p4inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i - 1][j] instanceof NaoCelula)
                                     {
                                         teste[i - 1][j].setIcon(naocelula);
                                     }
                                }

                                //em baixo
                                if(i + 1 < 10)
                                {
                                     if(matrizcelulapc[i + 1][j] instanceof Submarino1)
                                     {
                                         teste[i + 1][j].setIcon(sub1);
                                         s1inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i + 1][j] instanceof Submarino2)
                                     {
                                         teste[i + 1][j].setIcon(sub2);
                                         s2inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i + 1][j] instanceof Jato1)
                                     {
                                         teste[i + 1][j].setIcon(jato1);
                                         j1inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i + 1][j] instanceof Jato2)
                                     {
                                         teste[i + 1][j].setIcon(jato2);
                                         j2inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i + 1][j] instanceof Porta1)
                                     {
                                         teste[i + 1][j].setIcon(port1);
                                         p1inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i + 1][j] instanceof Porta2)
                                     {
                                         teste[i + 1][j].setIcon(port2);
                                         p2inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i + 1][j] instanceof Porta3)
                                     {
                                         teste[i + 1][j].setIcon(port3);
                                         p3inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i + 1][j] instanceof Porta4)
                                     {
                                         teste[i + 1][j].setIcon(port4); 
                                         p4inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i + 1][j] instanceof NaoCelula)
                                     {
                                         teste[i + 1][j].setIcon(naocelula);
                                     }
                                }
                            }
                            if(matrizcelulapc[i][j] instanceof Escolta2)
                            {
                                teste[i][j].setIcon(esc2);
                                e2inimigo.setVivo(false);
                                teste[i][j - 1].setIcon(esc1);
                                e1inimigo.setVivo(false);
                                teste[i][j + 1].setIcon(esc3);
                                e3inimigo.setVivo(false);

                                //em cima
                                if(i - 1 >= 0)
                                {
                                     if(matrizcelulapc[i - 1][j] instanceof Submarino1)
                                     {
                                         teste[i - 1][j].setIcon(sub1);
                                         s1inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i - 1][j] instanceof Submarino2)
                                     {
                                         teste[i - 1][j].setIcon(sub2);
                                         s2inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i - 1][j] instanceof Jato1)
                                     {
                                         teste[i - 1][j].setIcon(jato1);
                                         j1inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i - 1][j] instanceof Jato2)
                                     {
                                         teste[i - 1][j].setIcon(jato2);
                                         j2inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i - 1][j] instanceof Porta1)
                                     {
                                         teste[i - 1][j].setIcon(port1);
                                         p1inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i - 1][j] instanceof Porta2)
                                     {
                                         teste[i - 1][j].setIcon(port2);
                                         p2inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i - 1][j] instanceof Porta3)
                                     {
                                         teste[i - 1][j].setIcon(port3);
                                         p3inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i - 1][j] instanceof Porta4)
                                     {
                                         teste[i - 1][j].setIcon(port4); 
                                         p4inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i - 1][j] instanceof NaoCelula)
                                     {
                                         teste[i - 1][j].setIcon(naocelula);
                                     }
                                }

                                //em baixo
                                if(i + 1 < 10)
                                {
                                     if(matrizcelulapc[i + 1][j] instanceof Submarino1)
                                     {
                                         teste[i + 1][j].setIcon(sub1);
                                         s1inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i + 1][j] instanceof Submarino2)
                                     {
                                         teste[i + 1][j].setIcon(sub2);
                                         s2inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i + 1][j] instanceof Jato1)
                                     {
                                         teste[i + 1][j].setIcon(jato1);
                                         j1inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i + 1][j] instanceof Jato2)
                                     {
                                         teste[i + 1][j].setIcon(jato2);
                                         j2inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i + 1][j] instanceof Porta1)
                                     {
                                         teste[i + 1][j].setIcon(port1);
                                         p1inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i + 1][j] instanceof Porta2)
                                     {
                                         teste[i + 1][j].setIcon(port2);
                                         p2inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i + 1][j] instanceof Porta3)
                                     {
                                         teste[i + 1][j].setIcon(port3);
                                         p3inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i + 1][j] instanceof Porta4)
                                     {
                                         teste[i + 1][j].setIcon(port4); 
                                         p4inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i + 1][j] instanceof NaoCelula)
                                     {
                                         teste[i + 1][j].setIcon(naocelula);
                                     }
                                }

                            }
                            if(matrizcelulapc[i][j] instanceof Escolta3)
                            {
                                teste[i][j].setIcon(esc3);
                                e3inimigo.setVivo(false);
                                teste[i][j - 1].setIcon(esc2);
                                e2inimigo.setVivo(false);

                                if(j + 1 < 10)
                                {
                                     if(matrizcelulapc[i][j + 1] instanceof Submarino1)
                                     {
                                         teste[i][j + 1].setIcon(sub1);
                                         s1inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i][j + 1] instanceof Jato1)
                                     {
                                         teste[i][j + 1].setIcon(jato1);
                                         j1inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i][j + 1] instanceof Porta1)
                                     {
                                         teste[i][j + 1].setIcon(port1);
                                         p1inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i][j + 1] instanceof NaoCelula)
                                     {
                                         teste[i][j + 1].setIcon(naocelula);
                                     }
                                }
                                //em cima
                                if(i - 1 >= 0)
                                {
                                     if(matrizcelulapc[i - 1][j] instanceof Submarino1)
                                     {
                                         teste[i - 1][j].setIcon(sub1);
                                         s1inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i - 1][j] instanceof Submarino2)
                                     {
                                         teste[i - 1][j].setIcon(sub2);
                                         s2inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i - 1][j] instanceof Jato1)
                                     {
                                         teste[i - 1][j].setIcon(jato1);
                                         j1inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i - 1][j] instanceof Jato2)
                                     {
                                         teste[i - 1][j].setIcon(jato2);
                                         j2inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i - 1][j] instanceof Porta1)
                                     {
                                         teste[i - 1][j].setIcon(port1);
                                         p1inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i - 1][j] instanceof Porta2)
                                     {
                                         teste[i - 1][j].setIcon(port2);
                                         p2inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i - 1][j] instanceof Porta3)
                                     {
                                         teste[i - 1][j].setIcon(port3);
                                         p3inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i - 1][j] instanceof Porta4)
                                     {
                                         teste[i - 1][j].setIcon(port4); 
                                         p4inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i - 1][j] instanceof NaoCelula)
                                     {
                                         teste[i - 1][j].setIcon(naocelula);
                                     }
                                }

                                //em baixo
                                if(i + 1 < 10)
                                {
                                     if(matrizcelulapc[i + 1][j] instanceof Submarino1)
                                     {
                                         teste[i + 1][j].setIcon(sub1);
                                         s1inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i + 1][j] instanceof Submarino2)
                                     {
                                         teste[i + 1][j].setIcon(sub2);
                                         s2inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i + 1][j] instanceof Jato1)
                                     {
                                         teste[i + 1][j].setIcon(jato1);
                                         j1inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i + 1][j] instanceof Jato2)
                                     {
                                         teste[i + 1][j].setIcon(jato2);
                                         j2inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i + 1][j] instanceof Porta1)
                                     {
                                         teste[i + 1][j].setIcon(port1);
                                         p1inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i + 1][j] instanceof Porta2)
                                     {
                                         teste[i + 1][j].setIcon(port2);
                                         p2inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i + 1][j] instanceof Porta3)
                                     {
                                         teste[i + 1][j].setIcon(port3);
                                         p3inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i + 1][j] instanceof Porta4)
                                     {
                                         teste[i + 1][j].setIcon(port4); 
                                         p4inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i + 1][j] instanceof NaoCelula)
                                     {
                                         teste[i + 1][j].setIcon(naocelula);
                                     }
                                }

                            }
                            if(matrizcelulapc[i][j] instanceof Porta1)
                            {
                                teste[i][j].setIcon(port1);
                                p1inimigo.setVivo(false);
                                teste[i][j + 1].setIcon(port2);
                                p2inimigo.setVivo(false);

                                if(j - 1 >= 0)
                                {
                                     if(matrizcelulapc[i][j - 1] instanceof Submarino2)
                                     {
                                         teste[i][j - 1].setIcon(sub2);
                                         s2inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i][j - 1] instanceof Jato2)
                                     {
                                         teste[i][j - 1].setIcon(jato2);
                                         j2inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i][j - 1] instanceof Escolta3)
                                     {
                                         teste[i][j - 1].setIcon(esc3);
                                         e3inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i][j - 1] instanceof NaoCelula)
                                     {
                                         teste[i][j - 1].setIcon(naocelula);
                                     }
                                }
                                //em cima
                                if(i - 1 >= 0)
                                {
                                     if(matrizcelulapc[i - 1][j] instanceof Submarino1)
                                     {
                                         teste[i - 1][j].setIcon(sub1);
                                         s1inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i - 1][j] instanceof Submarino2)
                                     {
                                         teste[i - 1][j].setIcon(sub2);
                                         s2inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i - 1][j] instanceof Jato1)
                                     {
                                         teste[i - 1][j].setIcon(jato1);
                                         j1inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i - 1][j] instanceof Jato2)
                                     {
                                         teste[i - 1][j].setIcon(jato2);
                                         j2inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i - 1][j] instanceof Escolta1)
                                     {
                                         teste[i - 1][j].setIcon(esc1);
                                         e1inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i - 1][j] instanceof Escolta2)
                                     {
                                         teste[i - 1][j].setIcon(esc2);
                                         e2inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i - 1][j] instanceof Escolta3)
                                     {
                                         teste[i - 1][j].setIcon(esc3);
                                         e3inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i - 1][j] instanceof NaoCelula)
                                     {
                                         teste[i - 1][j].setIcon(naocelula);
                                     }
                                }

                                //em baixo
                                if(i + 1 < 10)
                                {
                                     if(matrizcelulapc[i + 1][j] instanceof Submarino1)
                                     {
                                         teste[i + 1][j].setIcon(sub1);
                                         s1inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i + 1][j] instanceof Submarino2)
                                     {
                                         teste[i + 1][j].setIcon(sub2);
                                         s2inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i + 1][j] instanceof Jato1)
                                     {
                                         teste[i + 1][j].setIcon(jato1);
                                         j1inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i + 1][j] instanceof Jato2)
                                     {
                                         teste[i + 1][j].setIcon(jato2);
                                         j2inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i + 1][j] instanceof Escolta1)
                                     {
                                         teste[i + 1][j].setIcon(esc1);
                                         e1inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i + 1][j] instanceof Escolta2)
                                     {
                                         teste[i + 1][j].setIcon(esc2);
                                         e2inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i + 1][j] instanceof Escolta3)
                                     {
                                         teste[i + 1][j].setIcon(esc3);
                                         e3inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i + 1][j] instanceof NaoCelula)
                                     {
                                         teste[i + 1][j].setIcon(naocelula);
                                     }
                                }

                            }
                            if(matrizcelulapc[i][j] instanceof Porta2)
                            {
                                teste[i][j].setIcon(port2);
                                p2inimigo.setVivo(false);
                                teste[i][j - 1].setIcon(port1);
                                p1inimigo.setVivo(false);
                                teste[i][j + 1].setIcon(port3);
                                p3inimigo.setVivo(false);

                                //em cima
                                if(i - 1 >= 0)
                                {
                                     if(matrizcelulapc[i - 1][j] instanceof Submarino1)
                                     {
                                         teste[i - 1][j].setIcon(sub1);
                                         s1inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i - 1][j] instanceof Submarino2)
                                     {
                                         teste[i - 1][j].setIcon(sub2);
                                         s2inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i - 1][j] instanceof Jato1)
                                     {
                                         teste[i - 1][j].setIcon(jato1);
                                         j1inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i - 1][j] instanceof Jato2)
                                     {
                                         teste[i - 1][j].setIcon(jato2);
                                         j2inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i - 1][j] instanceof Escolta1)
                                     {
                                         teste[i - 1][j].setIcon(esc1);
                                         e1inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i - 1][j] instanceof Escolta2)
                                     {
                                         teste[i - 1][j].setIcon(esc2);
                                         e2inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i - 1][j] instanceof Escolta3)
                                     {
                                         teste[i - 1][j].setIcon(esc3);
                                         e3inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i - 1][j] instanceof NaoCelula)
                                     {
                                         teste[i - 1][j].setIcon(naocelula);
                                     }
                                }

                                //em baixo
                                if(i + 1 < 10)
                                {
                                     if(matrizcelulapc[i + 1][j] instanceof Submarino1)
                                     {
                                         teste[i + 1][j].setIcon(sub1);
                                         s1inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i + 1][j] instanceof Submarino2)
                                     {
                                         teste[i + 1][j].setIcon(sub2);
                                         s2inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i + 1][j] instanceof Jato1)
                                     {
                                         teste[i + 1][j].setIcon(jato1);
                                         j1inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i + 1][j] instanceof Jato2)
                                     {
                                         teste[i + 1][j].setIcon(jato2);
                                         j2inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i + 1][j] instanceof Escolta1)
                                     {
                                         teste[i + 1][j].setIcon(esc1);
                                         e1inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i + 1][j] instanceof Escolta2)
                                     {
                                         teste[i + 1][j].setIcon(esc2);
                                         e2inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i + 1][j] instanceof Escolta3)
                                     {
                                         teste[i + 1][j].setIcon(esc3);
                                         e3inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i + 1][j] instanceof NaoCelula)
                                     {
                                         teste[i + 1][j].setIcon(naocelula);
                                     }
                                }
                            }
                            if(matrizcelulapc[i][j] instanceof Porta3)
                            {
                                teste[i][j].setIcon(port3);
                                p3inimigo.setVivo(false);
                                teste[i][j - 1].setIcon(port2);
                                p2inimigo.setVivo(false);
                                teste[i][j + 1].setIcon(port4); 
                                p4inimigo.setVivo(false);

                                //em cima
                                if(i - 1 >= 0)
                                {
                                     if(matrizcelulapc[i - 1][j] instanceof Submarino1)
                                     {
                                         teste[i - 1][j].setIcon(sub1);
                                         s1inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i - 1][j] instanceof Submarino2)
                                     {
                                         teste[i - 1][j].setIcon(sub2);
                                         s2inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i - 1][j] instanceof Jato1)
                                     {
                                         teste[i - 1][j].setIcon(jato1);
                                         j1inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i - 1][j] instanceof Jato2)
                                     {
                                         teste[i - 1][j].setIcon(jato2);
                                         j2inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i - 1][j] instanceof Escolta1)
                                     {
                                         teste[i - 1][j].setIcon(esc1);
                                         e1inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i - 1][j] instanceof Escolta2)
                                     {
                                         teste[i - 1][j].setIcon(esc2);
                                         e2inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i - 1][j] instanceof Escolta3)
                                     {
                                         teste[i - 1][j].setIcon(esc3);
                                         e3inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i - 1][j] instanceof NaoCelula)
                                     {
                                         teste[i - 1][j].setIcon(naocelula);
                                     }
                                }

                                //em baixo
                                if(i + 1 < 10)
                                {
                                     if(matrizcelulapc[i + 1][j] instanceof Submarino1)
                                     {
                                         teste[i + 1][j].setIcon(sub1);
                                         s1inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i + 1][j] instanceof Submarino2)
                                     {
                                         teste[i + 1][j].setIcon(sub2);
                                         s2inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i + 1][j] instanceof Jato1)
                                     {
                                         teste[i + 1][j].setIcon(jato1);
                                         j1inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i + 1][j] instanceof Jato2)
                                     {
                                         teste[i + 1][j].setIcon(jato2);
                                         j2inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i + 1][j] instanceof Escolta1)
                                     {
                                         teste[i + 1][j].setIcon(esc1);
                                         e1inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i + 1][j] instanceof Escolta2)
                                     {
                                         teste[i + 1][j].setIcon(esc2);
                                         e2inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i + 1][j] instanceof Escolta3)
                                     {
                                         teste[i + 1][j].setIcon(esc3);
                                         e3inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i + 1][j] instanceof NaoCelula)
                                     {
                                         teste[i + 1][j].setIcon(naocelula);
                                     }
                                }
                            }
                            if(matrizcelulapc[i][j] instanceof Porta4)
                            {
                                teste[i][j].setIcon(port4); 
                                p4inimigo.setVivo(false);
                                teste[i][j - 1].setIcon(port3);
                                p3inimigo.setVivo(false);

                                if(j + 1 < 10)
                                {
                                     if(matrizcelulapc[i][j + 1] instanceof Submarino1)
                                     {
                                         teste[i][j + 1].setIcon(sub1);
                                         s1inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i][j + 1] instanceof Escolta1)
                                     {
                                         teste[i][j + 1].setIcon(esc1);
                                         e1inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i][j + 1] instanceof Jato1)
                                     {
                                         teste[i][j + 1].setIcon(jato1);
                                         j1inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i][j + 1] instanceof NaoCelula)
                                     {
                                         teste[i][j + 1].setIcon(naocelula);
                                     }
                                }
                                //em cima
                                if(i - 1 >= 0)
                                {
                                     if(matrizcelulapc[i - 1][j] instanceof Submarino1)
                                     {
                                         teste[i - 1][j].setIcon(sub1);
                                         s1inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i - 1][j] instanceof Submarino2)
                                     {
                                         teste[i - 1][j].setIcon(sub2);
                                         s2inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i - 1][j] instanceof Jato1)
                                     {
                                         teste[i - 1][j].setIcon(jato1);
                                         j1inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i - 1][j] instanceof Jato2)
                                     {
                                         teste[i - 1][j].setIcon(jato2);
                                         j2inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i - 1][j] instanceof Escolta1)
                                     {
                                         teste[i - 1][j].setIcon(esc1);
                                         e1inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i - 1][j] instanceof Escolta2)
                                     {
                                         teste[i - 1][j].setIcon(esc2);
                                         e2inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i - 1][j] instanceof Escolta3)
                                     {
                                         teste[i - 1][j].setIcon(esc3);
                                         e3inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i - 1][j] instanceof NaoCelula)
                                     {
                                         teste[i - 1][j].setIcon(naocelula);
                                     }
                                }

                                //em baixo
                                if(i + 1 < 10)
                                {
                                     if(matrizcelulapc[i + 1][j] instanceof Submarino1)
                                     {
                                         teste[i + 1][j].setIcon(sub1);
                                         s1inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i + 1][j] instanceof Submarino2)
                                     {
                                         teste[i + 1][j].setIcon(sub2);
                                         s2inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i + 1][j] instanceof Jato1)
                                     {
                                         teste[i + 1][j].setIcon(jato1);
                                         j1inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i + 1][j] instanceof Jato2)
                                     {
                                         teste[i + 1][j].setIcon(jato2);
                                         j2inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i + 1][j] instanceof Escolta1)
                                     {
                                         teste[i + 1][j].setIcon(esc1);
                                         e1inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i + 1][j] instanceof Escolta2)
                                     {
                                         teste[i + 1][j].setIcon(esc2);
                                         e2inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i + 1][j] instanceof Escolta3)
                                     {
                                         teste[i + 1][j].setIcon(esc3);
                                         e3inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i + 1][j] instanceof NaoCelula)
                                     {
                                         teste[i + 1][j].setIcon(naocelula);
                                     }
                                }
                            }
                            if(matrizcelulapc[i][j] instanceof NaoCelula)
                            {
                                teste[i][j].setIcon(naocelula);

                                //Direita
                                if(j + 1 < 10)
                                {
                                     if(matrizcelulapc[i][j + 1] instanceof Submarino1)
                                     {
                                         teste[i][j + 1].setIcon(sub1);
                                         s1inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i][j + 1] instanceof Jato1)
                                     {
                                         teste[i][j + 1].setIcon(jato1);
                                         j1inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i][j + 1] instanceof Escolta1)
                                     {
                                         teste[i][j + 1].setIcon(esc1);
                                         e1inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i][j + 1] instanceof Porta1)
                                     {
                                         teste[i][j + 1].setIcon(port1);
                                         p1inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i][j + 1] instanceof NaoCelula)
                                     {
                                         teste[i][j + 1].setIcon(naocelula);
                                     }
                                }

                                if(j - 1 >= 0)
                                {
                                     if(matrizcelulapc[i][j - 1] instanceof Submarino2)
                                     {
                                         teste[i][j - 1].setIcon(sub2);
                                         s2inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i][j - 1] instanceof Jato2)
                                     {
                                         teste[i][j - 1].setIcon(jato2);
                                         j2inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i][j - 1] instanceof Escolta3)
                                     {
                                         teste[i][j - 1].setIcon(esc3);
                                         e3inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i][j - 1] instanceof Porta4)
                                     {
                                         teste[i][j - 1].setIcon(port4); 
                                         p4inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i][j - 1] instanceof NaoCelula)
                                     {
                                         teste[i][j - 1].setIcon(naocelula);
                                     }
                                }

                                //em cima
                                if(i - 1 >= 0)
                                {
                                     if(matrizcelulapc[i - 1][j] instanceof Submarino1)
                                     {
                                         teste[i - 1][j].setIcon(sub1);
                                         s1inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i - 1][j] instanceof Submarino2)
                                     {
                                         teste[i - 1][j].setIcon(sub2);
                                         s2inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i - 1][j] instanceof Jato1)
                                     {
                                         teste[i - 1][j].setIcon(jato1);
                                         j1inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i - 1][j] instanceof Jato2)
                                     {
                                         teste[i - 1][j].setIcon(jato2);
                                         j2inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i - 1][j] instanceof Escolta1)
                                     {
                                         teste[i - 1][j].setIcon(esc1);
                                         e1inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i - 1][j] instanceof Escolta2)
                                     {
                                         teste[i - 1][j].setIcon(esc2);
                                         e2inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i - 1][j] instanceof Escolta3)
                                     {
                                         teste[i - 1][j].setIcon(esc3);
                                         e3inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i - 1][j] instanceof Porta1)
                                     {
                                         teste[i - 1][j].setIcon(port1);
                                         p1inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i - 1][j] instanceof Porta2)
                                     {
                                         teste[i - 1][j].setIcon(port2);
                                         p2inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i - 1][j] instanceof Porta3)
                                     {
                                         teste[i - 1][j].setIcon(port3);
                                         p3inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i - 1][j] instanceof Porta4)
                                     {
                                         teste[i - 1][j].setIcon(port4); 
                                         p4inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i - 1][j] instanceof NaoCelula)
                                     {
                                         teste[i - 1][j].setIcon(naocelula);
                                     }
                                }

                                //em baixo
                                if(i + 1 < 10)
                                {
                                     if(matrizcelulapc[i + 1][j] instanceof Submarino1)
                                     {
                                         teste[i + 1][j].setIcon(sub1);
                                         s1inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i + 1][j] instanceof Submarino2)
                                     {
                                         teste[i + 1][j].setIcon(sub2);
                                         s2inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i + 1][j] instanceof Jato1)
                                     {
                                         teste[i + 1][j].setIcon(jato1);
                                         j1inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i + 1][j] instanceof Jato2)
                                     {
                                         teste[i + 1][j].setIcon(jato2);
                                         j2inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i + 1][j] instanceof Escolta1)
                                     {
                                         teste[i + 1][j].setIcon(esc1);
                                         e1inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i + 1][j] instanceof Escolta2)
                                     {
                                         teste[i + 1][j].setIcon(esc2);
                                         e2inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i + 1][j] instanceof Escolta3)
                                     {
                                         teste[i + 1][j].setIcon(esc3);
                                         e3inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i + 1][j] instanceof Porta1)
                                     {
                                         teste[i + 1][j].setIcon(port1);
                                         p1inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i + 1][j] instanceof Porta2)
                                     {
                                         teste[i + 1][j].setIcon(port2);
                                         p2inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i + 1][j] instanceof Porta3)
                                     {
                                         teste[i + 1][j].setIcon(port3);
                                         p3inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i + 1][j] instanceof Porta4)
                                     {
                                         teste[i + 1][j].setIcon(port4); 
                                         p4inimigo.setVivo(false);
                                     }
                                     if(matrizcelulapc[i + 1][j] instanceof NaoCelula)
                                     {
                                         teste[i + 1][j].setIcon(naocelula);
                                     }
                                }
                            }
                             if(s1inimigo.getVivo() == false && s2inimigo.getVivo() == false && j1inimigo.getVivo() == false && j2inimigo.getVivo() == false && e1inimigo.getVivo() == false && e2inimigo.getVivo() == false && e3inimigo.getVivo() == false)
                             {
                                 win();
                             }
                             jaclicou[i][j] = true;
                             if(j - 1 >= 0)
                             {
                                 jaclicou[i][j - 1] = true;
                             }
                             if(i - 1 >= 0)
                             {
                                 jaclicou[i - 1][j] = true;
                             }
                             if(i + 1 < 10)
                             {
                                 jaclicou[i + 1][j] = true;
                             }
                             if(j + 1 < 10)
                             {
                                 jaclicou[i][j + 1] = true;
                             }
                             if(s1inimigo.getVivo() == false && s2inimigo.getVivo() == false)
                             {
                                 contSPC = 1; 
                             }
                             if(j1inimigo.getVivo() == false && j2inimigo.getVivo() == false)
                             {
                                 contJPC = 1; 
                             }
                             if(e1inimigo.getVivo() == false && e2inimigo.getVivo() == false && e3inimigo.getVivo() == false)
                             {
                                 contEPC = 1; 
                             }
                             for(int p = 0; p < 1; p++)
                             {
                                rand = random.nextInt(4); 
                                if(rand == 1 && contSPC == 1){p = -1;}
                                if(rand == 2 && contEPC == 1){p = -1;}
                                if(rand == 3 && contJPC == 1){p = -1;}
                                if(rand != 0)
                                {
                                    if(rand == 1 && contSPC == 0)
                                    {
                                        for(int t = 0; t < 1; t++)
                                        {
                                            posicaox = random.nextInt(10);
                                            posicaoy = random.nextInt(10);
                                            if(pcjaclicou[posicaox][posicaoy] == false)
                                            {
                                            if(matrizcelulajogador[posicaox][posicaoy] instanceof Submarino1)
                                            {
                                               table[posicaox][posicaoy].setIcon(sub1);
                                               s1amigo.setVivo(false);
                                            }
                                            if(matrizcelulajogador[posicaox][posicaoy] instanceof Submarino2)
                                            {
                                               table[posicaox][posicaoy].setIcon(sub2);
                                               s2amigo.setVivo(false);
                                            }
                                            if(matrizcelulajogador[posicaox][posicaoy] instanceof Jato1)
                                            {
                                               table[posicaox][posicaoy].setIcon(jato1);
                                               j1amigo.setVivo(false);
                                            }
                                            if(matrizcelulajogador[posicaox][posicaoy] instanceof Jato2)
                                            {
                                               table[posicaox][posicaoy].setIcon(jato2);
                                               j2amigo.setVivo(false);
                                            }
                                            if(matrizcelulajogador[posicaox][posicaoy] instanceof Escolta1)
                                            {
                                               table[posicaox][posicaoy].setIcon(esc1);
                                               e1amigo.setVivo(false);
                                            }
                                            if(matrizcelulajogador[posicaox][posicaoy] instanceof Escolta2)
                                            {
                                               table[posicaox][posicaoy].setIcon(esc2);
                                               e2amigo.setVivo(false);
                                            }
                                            if(matrizcelulajogador[posicaox][posicaoy] instanceof Escolta3)
                                            {
                                               table[posicaox][posicaoy].setIcon(esc3);
                                               e3amigo.setVivo(false);
                                            }
                                            if(matrizcelulajogador[posicaox][posicaoy] instanceof Porta1)
                                            {
                                               table[posicaox][posicaoy].setIcon(port1);
                                               p1amigo.setVivo(false);
                                            }
                                            if(matrizcelulajogador[posicaox][posicaoy] instanceof Porta2)
                                            {
                                               table[posicaox][posicaoy].setIcon(port2);
                                               p2amigo.setVivo(false);
                                            }
                                            if(matrizcelulajogador[posicaox][posicaoy] instanceof Porta3)
                                            {
                                               table[posicaox][posicaoy].setIcon(port3);
                                               p3amigo.setVivo(false);
                                            }
                                            if(matrizcelulajogador[posicaox][posicaoy] instanceof Porta4)
                                            {
                                               table[posicaox][posicaoy].setIcon(port4); 
                                               p4amigo.setVivo(false);
                                            }
                                            if(matrizcelulajogador[posicaox][posicaoy] instanceof NaoCelula)
                                            {
                                               table[posicaox][posicaoy].setIcon(naocelula);
                                            }
                                            if(contif == 0)
                                            {
                                                 if(s1amigo.getVivo() == false && s2amigo.getVivo() == false)
                                                 {
                                                    botaoS.setBackground(Color.red);
                                                    botaoS.setIcon(new ImageIcon("./submarino.png"));
                                                    cont = 0; 
                                                    contif = 1;
                                                 }
                                            }
                                            if(contifJ == 0) //fazer o jato ficar vermelho
                                            {
                                                 if(j1amigo.getVivo() == false && j2amigo.getVivo() == false)
                                                 {
                                                    botaoJ.setBackground(Color.red);
                                                    botaoJ.setIcon(new ImageIcon("./jato.png"));
                                                    cont = 0; 
                                                    contifJ = 1;
                                                 }
                                            }
                                            if(contifE == 0) //fazer o escolta ficar vermelho
                                            {
                                                 if(e1amigo.getVivo() == false && e2amigo.getVivo() == false && e3amigo.getVivo() == false)
                                                 {
                                                    botaoE.setBackground(Color.red);
                                                    botaoE.setIcon(new ImageIcon("./escolta.png"));
                                                    cont = 0; 
                                                    contifE = 1;
                                                 }
                                            }
                                            if(s1amigo.getVivo() == false && s2amigo.getVivo() == false && j1amigo.getVivo() == false && j2amigo.getVivo() == false && e1amigo.getVivo() == false && e2amigo.getVivo() == false && e3amigo.getVivo() == false)
                                            {
                                                loser(); 
                                            }
                                            pcjaclicou[posicaox][posicaoy] = true; 
                                            }
                                            else
                                            {
                                                t = -1; 
                                            }
                                        }
                                    }
                                    if(rand == 2 && contEPC == 0)
                                    {
                                        for(int t = 0; t < 1; t++)
                                        {
                                           posicaox = random.nextInt(10);
                                           posicaoy = random.nextInt(10);

                                           if(pcjaclicou[posicaox][posicaoy] == false)
                                           {
                                               if(matrizcelulajogador[posicaox][posicaoy] instanceof Submarino1)
                                               {
                                                   table[posicaox][posicaoy].setIcon(sub1);
                                                   s1amigo.setVivo(false);

                                                   table[posicaox][posicaoy + 1].setIcon(sub2);
                                                   s2amigo.setVivo(false);     
                                               }
                                               if(matrizcelulajogador[posicaox][posicaoy] instanceof Submarino2)
                                               {
                                                   table[posicaox][posicaoy].setIcon(sub2);
                                                   s2amigo.setVivo(false);

                                                   if(posicaoy + 1 < 10)
                                                   {
                                                       if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof Jato1)
                                                       {
                                                           table[posicaox][posicaoy + 1].setIcon(jato1);
                                                           j1amigo.setVivo(false); 
                                                       }
                                                       if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof Escolta1)
                                                       {
                                                           table[posicaox][posicaoy + 1].setIcon(esc1);
                                                           e1amigo.setVivo(false); 
                                                       }
                                                       if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof Porta1)
                                                       {
                                                           table[posicaox][posicaoy + 1].setIcon(port1);
                                                           p1amigo.setVivo(false); 
                                                       }
                                                       if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof NaoCelula)
                                                       {
                                                           table[posicaox][posicaoy + 1].setIcon(naocelula); 
                                                       }
                                                   }
                                               }
                                               if(matrizcelulajogador[posicaox][posicaoy] instanceof Jato1)
                                               {
                                                   table[posicaox][posicaoy].setIcon(jato1);
                                                   j1amigo.setVivo(false);

                                                   table[posicaox][posicaoy + 1].setIcon(jato2);
                                                   j2amigo.setVivo(false);  
                                               }
                                               if(matrizcelulajogador[posicaox][posicaoy] instanceof Jato2)
                                               {
                                                   table[posicaox][posicaoy].setIcon(jato2);
                                                   j2amigo.setVivo(false);

                                                   if(posicaoy + 1 < 10)
                                                   {
                                                       if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof Submarino1)
                                                       {
                                                           table[posicaox][posicaoy + 1].setIcon(sub1);
                                                           s1amigo.setVivo(false); 
                                                       }
                                                       if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof Escolta1)
                                                       {
                                                           table[posicaox][posicaoy + 1].setIcon(esc1);
                                                           e1amigo.setVivo(false); 
                                                       }
                                                       if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof Porta1)
                                                       {
                                                           table[posicaox][posicaoy + 1].setIcon(port1);
                                                           p1amigo.setVivo(false); 
                                                       }
                                                       if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof NaoCelula)
                                                       {
                                                           table[posicaox][posicaoy + 1].setIcon(naocelula); 
                                                       }
                                                   }
                                               }
                                               if(matrizcelulajogador[posicaox][posicaoy] instanceof Escolta1)
                                               {
                                                   table[posicaox][posicaoy].setIcon(esc1);
                                                   e1amigo.setVivo(false);

                                                   table[posicaox][posicaoy + 1].setIcon(esc2);
                                                   e2amigo.setVivo(false);  
                                               }
                                               if(matrizcelulajogador[posicaox][posicaoy] instanceof Escolta2)
                                               {
                                                   table[posicaox][posicaoy].setIcon(esc2);
                                                   e2amigo.setVivo(false);

                                                   table[posicaox][posicaoy + 1].setIcon(esc3);
                                                   e3amigo.setVivo(false);  
                                               }
                                               if(matrizcelulajogador[posicaox][posicaoy] instanceof Escolta3)
                                               {
                                                   table[posicaox][posicaoy].setIcon(esc3);
                                                   e3amigo.setVivo(false);

                                                   if(posicaoy + 1 < 10)
                                                   {
                                                       if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof Submarino1)
                                                       {
                                                           table[posicaox][posicaoy + 1].setIcon(sub1);
                                                           s1amigo.setVivo(false); 
                                                       }
                                                       if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof Jato1)
                                                       {
                                                           table[posicaox][posicaoy + 1].setIcon(jato1);
                                                           j1amigo.setVivo(false); 
                                                       }
                                                       if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof Porta1)
                                                       {
                                                           table[posicaox][posicaoy + 1].setIcon(port1);
                                                           p1amigo.setVivo(false); 
                                                       }
                                                       if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof NaoCelula)
                                                       {
                                                           table[posicaox][posicaoy + 1].setIcon(naocelula); 
                                                       }
                                                   }
                                               }
                                               if(matrizcelulajogador[posicaox][posicaoy] instanceof Porta1)
                                               {
                                                   table[posicaox][posicaoy].setIcon(port1);
                                                   p1amigo.setVivo(false);

                                                   table[posicaox][posicaoy + 1].setIcon(port2);
                                                   p2amigo.setVivo(false);  
                                               }
                                               if(matrizcelulajogador[posicaox][posicaoy] instanceof Porta2)
                                               {
                                                   table[posicaox][posicaoy].setIcon(port2);
                                                   p2amigo.setVivo(false);

                                                   table[posicaox][posicaoy + 1].setIcon(port3);
                                                   p3amigo.setVivo(false);  
                                               }
                                               if(matrizcelulajogador[posicaox][posicaoy] instanceof Porta3)
                                               {
                                                   table[posicaox][posicaoy].setIcon(port3);
                                                   p3amigo.setVivo(false);

                                                   table[posicaox][posicaoy + 1].setIcon(port4); 
                                                   p4amigo.setVivo(false);  
                                               }
                                               if(matrizcelulajogador[posicaox][posicaoy] instanceof Porta4)
                                               {
                                                   table[posicaox][posicaoy].setIcon(port4); 
                                                   p4amigo.setVivo(false);

                                                   if(posicaoy + 1 < 10)
                                                   {
                                                       if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof Submarino1)
                                                       {
                                                           table[posicaox][posicaoy + 1].setIcon(sub1);
                                                           s1amigo.setVivo(false); 
                                                       }
                                                       if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof Jato1)
                                                       {
                                                           table[posicaox][posicaoy + 1].setIcon(jato1);
                                                           j1amigo.setVivo(false); 
                                                       }
                                                       if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof Escolta1)
                                                       {
                                                           table[posicaox][posicaoy + 1].setIcon(esc1);
                                                           e1amigo.setVivo(false); 
                                                       }
                                                       if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof NaoCelula)
                                                       {
                                                           table[posicaox][posicaoy + 1].setIcon(naocelula); 
                                                       }
                                                   }
                                               }
                                               if(matrizcelulajogador[posicaox][posicaoy] instanceof NaoCelula)
                                               {
                                                   table[posicaox][posicaoy].setIcon(naocelula);                                                      
                                                   if(posicaoy + 1 < 10)
                                                   {
                                                       if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof Submarino1)
                                                       {
                                                           table[posicaox][posicaoy + 1].setIcon(sub1);
                                                           s1amigo.setVivo(false); 
                                                       }
                                                       if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof Jato1)
                                                       {
                                                           table[posicaox][posicaoy + 1].setIcon(jato1);
                                                           j1amigo.setVivo(false); 
                                                       }
                                                       if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof Escolta1)
                                                       {
                                                           table[posicaox][posicaoy + 1].setIcon(esc1);
                                                           e1amigo.setVivo(false); 
                                                       }
                                                       if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof Porta1)
                                                       {
                                                           table[posicaox][posicaoy + 1].setIcon(port1);
                                                           e1amigo.setVivo(false); 
                                                       }
                                                       if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof NaoCelula)
                                                       {
                                                           table[posicaox][posicaoy + 1].setIcon(naocelula); 
                                                       }
                                                   }
                                               }
                                               if(contif == 0)
                                                {
                                                     if(s1amigo.getVivo() == false && s2amigo.getVivo() == false)
                                                     {
                                                        botaoS.setBackground(Color.red);
                                                        botaoS.setIcon(new ImageIcon("./submarino.png"));
                                                        cont = 0; 
                                                        contif = 1;
                                                     }
                                                }
                                                if(contifJ == 0) //fazer o jato ficar vermelho
                                                {
                                                     if(j1amigo.getVivo() == false && j2amigo.getVivo() == false)
                                                     {
                                                        botaoJ.setBackground(Color.red);
                                                        botaoJ.setIcon(new ImageIcon("./jato.png"));
                                                        cont = 0; 
                                                        contifJ = 1;
                                                     }
                                                }
                                                if(contifE == 0) //fazer o escolta ficar vermelho
                                                {
                                                     if(e1amigo.getVivo() == false && e2amigo.getVivo() == false && e3amigo.getVivo() == false)
                                                     {
                                                        botaoE.setBackground(Color.red);
                                                        botaoE.setIcon(new ImageIcon("./escolta.png"));
                                                        cont = 0; 
                                                        contifE = 1;
                                                     }
                                                }
                                               if(s1amigo.getVivo() == false && s2amigo.getVivo() == false && j1amigo.getVivo() == false && j2amigo.getVivo() == false && e1amigo.getVivo() == false && e2amigo.getVivo() == false && e3amigo.getVivo() == false)
                                               {
                                                    loser();
                                               }

                                               pcjaclicou[posicaox][posicaoy] = true; 
                                               if(posicaoy + 1 < 10)
                                               {
                                                   pcjaclicou[posicaox][posicaoy + 1] = true; 
                                               }
                                            }
                                            else
                                            {
                                               t = -1; 
                                            }
                                        } 
                                    }
                                    if(rand == 3 && contJPC == 0)
                                    {
                                        for(int t = 0; t < 1; t++)
                                        {
                                            posicaox = random.nextInt(10);
                                            posicaoy = random.nextInt(10);

                                            if(pcjaclicou[posicaox][posicaoy] == false)
                                            {
                                                if(matrizcelulajogador[posicaox][posicaoy] instanceof Submarino1)
                                                {
                                                   table[posicaox][posicaoy].setIcon(sub1);
                                                   s1amigo.setVivo(false);
                                                   table[posicaox][posicaoy + 1].setIcon(sub2);
                                                   s2amigo.setVivo(false);
                                                   
                                                   if(posicaoy - 1 >= 0)
                                                   {
                                                        if(matrizcelulajogador[posicaox][posicaoy - 1] instanceof Jato2)
                                                        {
                                                            table[posicaox][posicaoy - 1].setIcon(jato2);
                                                            j2amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox][posicaoy - 1] instanceof Escolta3)
                                                        {
                                                            table[posicaox][posicaoy - 1].setIcon(esc3);
                                                            e3amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox][posicaoy - 1] instanceof Porta4)
                                                        {
                                                            table[posicaox][posicaoy - 1].setIcon(port4); 
                                                            p4amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox][posicaoy - 1] instanceof NaoCelula)
                                                        {
                                                            table[posicaox][posicaoy - 1].setIcon(naocelula);
                                                        }
                                                   }
                                                   
                                                   //em cima
                                                   if(posicaox - 1 >= 0)
                                                   {
                                                        if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Jato1)
                                                        {
                                                            table[posicaox - 1][posicaoy].setIcon(jato1);
                                                            j1amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Jato2)
                                                        {
                                                            table[posicaox - 1][posicaoy].setIcon(jato2);
                                                            j2amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Escolta1)
                                                        {
                                                            table[posicaox - 1][posicaoy].setIcon(esc1);
                                                            e1amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Escolta2)
                                                        {
                                                            table[posicaox - 1][posicaoy].setIcon(esc2);
                                                            e2amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Escolta3)
                                                        {
                                                            table[posicaox - 1][posicaoy].setIcon(esc3);
                                                            e3amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Porta1)
                                                        {
                                                            table[posicaox - 1][posicaoy].setIcon(port1);
                                                            p1amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Porta2)
                                                        {
                                                            table[posicaox - 1][posicaoy].setIcon(port2);
                                                            p2amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Porta3)
                                                        {
                                                            table[posicaox - 1][posicaoy].setIcon(port3);
                                                            p3amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Porta4)
                                                        {
                                                            table[posicaox - 1][posicaoy].setIcon(port4); 
                                                            p4amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof NaoCelula)
                                                        {
                                                            table[posicaox - 1][posicaoy].setIcon(naocelula);
                                                        }
                                                   }
                                                   
                                                   //em baixo
                                                   if(posicaox + 1 < 10)
                                                   {
                                                        if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Jato1)
                                                        {
                                                            table[posicaox + 1][posicaoy].setIcon(jato1);
                                                            j1amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Jato2)
                                                        {
                                                            table[posicaox + 1][posicaoy].setIcon(jato2);
                                                            j2amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Escolta1)
                                                        {
                                                            table[posicaox + 1][posicaoy].setIcon(esc1);
                                                            e1amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Escolta2)
                                                        {
                                                            table[posicaox + 1][posicaoy].setIcon(esc2);
                                                            e2amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Escolta3)
                                                        {
                                                            table[posicaox + 1][posicaoy].setIcon(esc3);
                                                            e3amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Porta1)
                                                        {
                                                            table[posicaox + 1][posicaoy].setIcon(port1);
                                                            p1amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Porta2)
                                                        {
                                                            table[posicaox + 1][posicaoy].setIcon(port2);
                                                            p2amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Porta3)
                                                        {
                                                            table[posicaox + 1][posicaoy].setIcon(port3);
                                                            p3amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Porta4)
                                                        {
                                                            table[posicaox + 1][posicaoy].setIcon(port4); 
                                                            p4amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof NaoCelula)
                                                        {
                                                            table[posicaox + 1][posicaoy].setIcon(naocelula);
                                                        }
                                                   }
                                                }
                                                if(matrizcelulajogador[posicaox][posicaoy] instanceof Submarino2)
                                                {
                                                   table[posicaox][posicaoy].setIcon(sub2);
                                                   s2amigo.setVivo(false);
                                                   
                                                   table[posicaox][posicaoy - 1].setIcon(sub1);
                                                   s1amigo.setVivo(false);
                                                   
                                                   if(posicaoy + 1 < 10)
                                                   {
                                                       if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof Jato1)
                                                        {
                                                            table[posicaox][posicaoy + 1].setIcon(jato1);
                                                            j1amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof Escolta1)
                                                        {
                                                            table[posicaox][posicaoy + 1].setIcon(esc1);
                                                            e1amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof Porta1)
                                                        {
                                                            table[posicaox][posicaoy + 1].setIcon(port1);
                                                            p1amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof NaoCelula)
                                                        {
                                                            table[posicaox][posicaoy + 1].setIcon(naocelula);
                                                        }
                                                   }
                                                   
                                                   //em cima
                                                   if(posicaox - 1 >= 0)
                                                   {
                                                        if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Jato1)
                                                        {
                                                            table[posicaox - 1][posicaoy].setIcon(jato1);
                                                            j1amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Jato2)
                                                        {
                                                            table[posicaox - 1][posicaoy].setIcon(jato2);
                                                            j2amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Escolta1)
                                                        {
                                                            table[posicaox - 1][posicaoy].setIcon(esc1);
                                                            e1amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Escolta2)
                                                        {
                                                            table[posicaox - 1][posicaoy].setIcon(esc2);
                                                            e2amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Escolta3)
                                                        {
                                                            table[posicaox - 1][posicaoy].setIcon(esc3);
                                                            e3amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Porta1)
                                                        {
                                                            table[posicaox - 1][posicaoy].setIcon(port1);
                                                            p1amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Porta2)
                                                        {
                                                            table[posicaox - 1][posicaoy].setIcon(port2);
                                                            p2amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Porta3)
                                                        {
                                                            table[posicaox - 1][posicaoy].setIcon(port3);
                                                            p3amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Porta4)
                                                        {
                                                            table[posicaox - 1][posicaoy].setIcon(port4); 
                                                            p4amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof NaoCelula)
                                                        {
                                                            table[posicaox - 1][posicaoy].setIcon(naocelula);
                                                        }
                                                   }
                                                   
                                                   //em baixo
                                                   if(posicaox + 1 < 10)
                                                   {
                                                        if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Jato1)
                                                        {
                                                            table[posicaox + 1][posicaoy].setIcon(jato1);
                                                            j1amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Jato2)
                                                        {
                                                            table[posicaox + 1][posicaoy].setIcon(jato2);
                                                            j2amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Escolta1)
                                                        {
                                                            table[posicaox + 1][posicaoy].setIcon(esc1);
                                                            e1amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Escolta2)
                                                        {
                                                            table[posicaox + 1][posicaoy].setIcon(esc2);
                                                            e2amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Escolta3)
                                                        {
                                                            table[posicaox + 1][posicaoy].setIcon(esc3);
                                                            e3amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Porta1)
                                                        {
                                                            table[posicaox + 1][posicaoy].setIcon(port1);
                                                            p1amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Porta2)
                                                        {
                                                            table[posicaox + 1][posicaoy].setIcon(port2);
                                                            p2amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Porta3)
                                                        {
                                                            table[posicaox + 1][posicaoy].setIcon(port3);
                                                            p3amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Porta4)
                                                        {
                                                            table[posicaox + 1][posicaoy].setIcon(port4); 
                                                            p4amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof NaoCelula)
                                                        {
                                                            table[posicaox + 1][posicaoy].setIcon(naocelula);
                                                        }
                                                   }
                                                }
                                                if(matrizcelulajogador[posicaox][posicaoy] instanceof Jato1)
                                                {
                                                   table[posicaox][posicaoy].setIcon(jato1);
                                                   j1amigo.setVivo(false);
                                                   table[posicaox][posicaoy + 1].setIcon(jato2);
                                                   j2amigo.setVivo(false);
                                                   
                                                   if(posicaoy - 1 >= 0)
                                                   {
                                                        if(matrizcelulajogador[posicaox][posicaoy - 1] instanceof Submarino2)
                                                        {
                                                            table[posicaox][posicaoy - 1].setIcon(sub2);
                                                            s2amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox][posicaoy - 1] instanceof Escolta3)
                                                        {
                                                            table[posicaox][posicaoy - 1].setIcon(esc3);
                                                            e3amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox][posicaoy - 1] instanceof Porta4)
                                                        {
                                                            table[posicaox][posicaoy - 1].setIcon(port4); 
                                                            p4amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox][posicaoy - 1] instanceof NaoCelula)
                                                        {
                                                            table[posicaox][posicaoy - 1].setIcon(naocelula);
                                                        }
                                                   }
                                                   
                                                   //em cima
                                                   if(posicaox - 1 >= 0)
                                                   {
                                                        if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Submarino1)
                                                        {
                                                            table[posicaox - 1][posicaoy].setIcon(sub1);
                                                            s1amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Submarino2)
                                                        {
                                                            table[posicaox - 1][posicaoy].setIcon(sub2);
                                                            s2amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Escolta1)
                                                        {
                                                            table[posicaox - 1][posicaoy].setIcon(esc1);
                                                            e1amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Escolta2)
                                                        {
                                                            table[posicaox - 1][posicaoy].setIcon(esc2);
                                                            e2amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Escolta3)
                                                        {
                                                            table[posicaox - 1][posicaoy].setIcon(esc3);
                                                            e3amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Porta1)
                                                        {
                                                            table[posicaox - 1][posicaoy].setIcon(port1);
                                                            p1amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Porta2)
                                                        {
                                                            table[posicaox - 1][posicaoy].setIcon(port2);
                                                            p2amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Porta3)
                                                        {
                                                            table[posicaox - 1][posicaoy].setIcon(port3);
                                                            p3amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Porta4)
                                                        {
                                                            table[posicaox - 1][posicaoy].setIcon(port4); 
                                                            p4amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof NaoCelula)
                                                        {
                                                            table[posicaox - 1][posicaoy].setIcon(naocelula);
                                                        }
                                                   }
                                                   
                                                   //em baixo
                                                   if(posicaox + 1 < 10)
                                                   {
                                                        if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Submarino1)
                                                        {
                                                            table[posicaox + 1][posicaoy].setIcon(sub1);
                                                            s1amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Submarino2)
                                                        {
                                                            table[posicaox + 1][posicaoy].setIcon(sub2);
                                                            s2amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Escolta1)
                                                        {
                                                            table[posicaox + 1][posicaoy].setIcon(esc1);
                                                            e1amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Escolta2)
                                                        {
                                                            table[posicaox + 1][posicaoy].setIcon(esc2);
                                                            e2amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Escolta3)
                                                        {
                                                            table[posicaox + 1][posicaoy].setIcon(esc3);
                                                            e3amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Porta1)
                                                        {
                                                            table[posicaox + 1][posicaoy].setIcon(port1);
                                                            p1amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Porta2)
                                                        {
                                                            table[posicaox + 1][posicaoy].setIcon(port2);
                                                            p2amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Porta3)
                                                        {
                                                            table[posicaox + 1][posicaoy].setIcon(port3);
                                                            p3amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Porta4)
                                                        {
                                                            table[posicaox + 1][posicaoy].setIcon(port4); 
                                                            p4amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof NaoCelula)
                                                        {
                                                            table[posicaox + 1][posicaoy].setIcon(naocelula);
                                                        }
                                                   }
                                                }
                                                if(matrizcelulajogador[posicaox][posicaoy] instanceof Jato2)
                                                {
                                                   table[posicaox][posicaoy].setIcon(jato2);
                                                   j2amigo.setVivo(false);
                                                   table[posicaox][posicaoy - 1].setIcon(jato1);
                                                   j1amigo.setVivo(false);
                                                   
                                                   if(posicaoy + 1 < 10)
                                                   {
                                                        if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof Submarino1)
                                                        {
                                                            table[posicaox][posicaoy + 1].setIcon(sub1);
                                                            s1amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof Escolta1)
                                                        {
                                                            table[posicaox][posicaoy + 1].setIcon(esc1);
                                                            e1amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof Porta1)
                                                        {
                                                            table[posicaox][posicaoy + 1].setIcon(port1);
                                                            p1amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof NaoCelula)
                                                        {
                                                            table[posicaox][posicaoy + 1].setIcon(naocelula);
                                                        }
                                                   }
                                                   //em cima
                                                   if(posicaox - 1 >= 0)
                                                   {
                                                        if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Submarino1)
                                                        {
                                                            table[posicaox - 1][posicaoy].setIcon(sub1);
                                                            s1amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Submarino2)
                                                        {
                                                            table[posicaox - 1][posicaoy].setIcon(sub2);
                                                            s2amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Escolta1)
                                                        {
                                                            table[posicaox - 1][posicaoy].setIcon(esc1);
                                                            e1amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Escolta2)
                                                        {
                                                            table[posicaox - 1][posicaoy].setIcon(esc2);
                                                            e2amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Escolta3)
                                                        {
                                                            table[posicaox - 1][posicaoy].setIcon(esc3);
                                                            e3amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Porta1)
                                                        {
                                                            table[posicaox - 1][posicaoy].setIcon(port1);
                                                            p1amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Porta2)
                                                        {
                                                            table[posicaox - 1][posicaoy].setIcon(port2);
                                                            p2amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Porta3)
                                                        {
                                                            table[posicaox - 1][posicaoy].setIcon(port3);
                                                            p3amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Porta4)
                                                        {
                                                            table[posicaox - 1][posicaoy].setIcon(port4); 
                                                            p4amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof NaoCelula)
                                                        {
                                                            table[posicaox - 1][posicaoy].setIcon(naocelula);
                                                        }
                                                   }
                                                   
                                                   //em baixo
                                                   if(posicaox + 1 < 10)
                                                   {
                                                        if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Submarino1)
                                                        {
                                                            table[posicaox + 1][posicaoy].setIcon(sub1);
                                                            s1amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Submarino2)
                                                        {
                                                            table[posicaox + 1][posicaoy].setIcon(sub2);
                                                            s2amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Escolta1)
                                                        {
                                                            table[posicaox + 1][posicaoy].setIcon(esc1);
                                                            e1amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Escolta2)
                                                        {
                                                            table[posicaox + 1][posicaoy].setIcon(esc2);
                                                            e2amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Escolta3)
                                                        {
                                                            table[posicaox + 1][posicaoy].setIcon(esc3);
                                                            e3amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Porta1)
                                                        {
                                                            table[posicaox + 1][posicaoy].setIcon(port1);
                                                            p1amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Porta2)
                                                        {
                                                            table[posicaox + 1][posicaoy].setIcon(port2);
                                                            p2amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Porta3)
                                                        {
                                                            table[posicaox + 1][posicaoy].setIcon(port3);
                                                            p3amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Porta4)
                                                        {
                                                            table[posicaox + 1][posicaoy].setIcon(port4); 
                                                            p4amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof NaoCelula)
                                                        {
                                                            table[posicaox + 1][posicaoy].setIcon(naocelula);
                                                        }
                                                   }   
                                                }
                                                    
                                               if(matrizcelulajogador[posicaox][posicaoy] instanceof Escolta1)
                                               {
                                                   table[posicaox][posicaoy].setIcon(esc1);
                                                   e1amigo.setVivo(false);
                                                   table[posicaox][posicaoy + 1].setIcon(esc2);
                                                   e2amigo.setVivo(false);
                                                   
                                                   if(posicaoy - 1 >= 0)
                                                   {
                                                        if(matrizcelulajogador[posicaox][posicaoy - 1] instanceof Submarino2)
                                                        {
                                                            table[posicaox][posicaoy - 1].setIcon(sub2);
                                                            s2amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox][posicaoy - 1] instanceof Jato2)
                                                        {
                                                            table[posicaox][posicaoy - 1].setIcon(jato2);
                                                            j2amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox][posicaoy - 1] instanceof Porta4)
                                                        {
                                                            table[posicaox][posicaoy - 1].setIcon(port4); 
                                                            p4amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox][posicaoy - 1] instanceof NaoCelula)
                                                        {
                                                            table[posicaox][posicaoy - 1].setIcon(naocelula);
                                                        }
                                                   }
                                                   //em cima
                                                   if(posicaox - 1 >= 0)
                                                   {
                                                        if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Submarino1)
                                                        {
                                                            table[posicaox - 1][posicaoy].setIcon(sub1);
                                                            s1amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Submarino2)
                                                        {
                                                            table[posicaox - 1][posicaoy].setIcon(sub2);
                                                            s2amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Jato1)
                                                        {
                                                            table[posicaox - 1][posicaoy].setIcon(jato1);
                                                            j1amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Jato2)
                                                        {
                                                            table[posicaox - 1][posicaoy].setIcon(jato2);
                                                            j2amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Porta1)
                                                        {
                                                            table[posicaox - 1][posicaoy].setIcon(port1);
                                                            p1amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Porta2)
                                                        {
                                                            table[posicaox - 1][posicaoy].setIcon(port2);
                                                            p2amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Porta3)
                                                        {
                                                            table[posicaox - 1][posicaoy].setIcon(port3);
                                                            p3amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Porta4)
                                                        {
                                                            table[posicaox - 1][posicaoy].setIcon(port4); 
                                                            p4amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof NaoCelula)
                                                        {
                                                            table[posicaox - 1][posicaoy].setIcon(naocelula);
                                                        }
                                                   }
                                                   
                                                   //em baixo
                                                   if(posicaox + 1 < 10)
                                                   {
                                                        if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Submarino1)
                                                        {
                                                            table[posicaox + 1][posicaoy].setIcon(sub1);
                                                            s1amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Submarino2)
                                                        {
                                                            table[posicaox + 1][posicaoy].setIcon(sub2);
                                                            s2amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Jato1)
                                                        {
                                                            table[posicaox + 1][posicaoy].setIcon(jato1);
                                                            j1amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Jato2)
                                                        {
                                                            table[posicaox + 1][posicaoy].setIcon(jato2);
                                                            j2amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Porta1)
                                                        {
                                                            table[posicaox + 1][posicaoy].setIcon(port1);
                                                            p1amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Porta2)
                                                        {
                                                            table[posicaox + 1][posicaoy].setIcon(port2);
                                                            p2amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Porta3)
                                                        {
                                                            table[posicaox + 1][posicaoy].setIcon(port3);
                                                            p3amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Porta4)
                                                        {
                                                            table[posicaox + 1][posicaoy].setIcon(port4); 
                                                            p4amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof NaoCelula)
                                                        {
                                                            table[posicaox + 1][posicaoy].setIcon(naocelula);
                                                        }
                                                   }
                                               }
                                               if(matrizcelulajogador[posicaox][posicaoy] instanceof Escolta2)
                                               {
                                                   table[posicaox][posicaoy].setIcon(esc2);
                                                   e2amigo.setVivo(false);
                                                   table[posicaox][posicaoy - 1].setIcon(esc1);
                                                   e1amigo.setVivo(false);
                                                   table[posicaox][posicaoy + 1].setIcon(esc3);
                                                   e3amigo.setVivo(false);
                                                   
                                                   //em cima
                                                   if(posicaox - 1 >= 0)
                                                   {
                                                        if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Submarino1)
                                                        {
                                                            table[posicaox - 1][posicaoy].setIcon(sub1);
                                                            s1amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Submarino2)
                                                        {
                                                            table[posicaox - 1][posicaoy].setIcon(sub2);
                                                            s2amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Jato1)
                                                        {
                                                            table[posicaox - 1][posicaoy].setIcon(jato1);
                                                            j1amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Jato2)
                                                        {
                                                            table[posicaox - 1][posicaoy].setIcon(jato2);
                                                            j2amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Porta1)
                                                        {
                                                            table[posicaox - 1][posicaoy].setIcon(port1);
                                                            p1amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Porta2)
                                                        {
                                                            table[posicaox - 1][posicaoy].setIcon(port2);
                                                            p2amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Porta3)
                                                        {
                                                            table[posicaox - 1][posicaoy].setIcon(port3);
                                                            p3amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Porta4)
                                                        {
                                                            table[posicaox - 1][posicaoy].setIcon(port4); 
                                                            p4amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof NaoCelula)
                                                        {
                                                            table[posicaox - 1][posicaoy].setIcon(naocelula);
                                                        }
                                                   }
                                                   
                                                   //em baixo
                                                   if(posicaox + 1 < 10)
                                                   {
                                                        if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Submarino1)
                                                        {
                                                            table[posicaox + 1][posicaoy].setIcon(sub1);
                                                            s1amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Submarino2)
                                                        {
                                                            table[posicaox + 1][posicaoy].setIcon(sub2);
                                                            s2amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Jato1)
                                                        {
                                                            table[posicaox + 1][posicaoy].setIcon(jato1);
                                                            j1amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Jato2)
                                                        {
                                                            table[posicaox + 1][posicaoy].setIcon(jato2);
                                                            j2amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Porta1)
                                                        {
                                                            table[posicaox + 1][posicaoy].setIcon(port1);
                                                            p1amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Porta2)
                                                        {
                                                            table[posicaox + 1][posicaoy].setIcon(port2);
                                                            p2amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Porta3)
                                                        {
                                                            table[posicaox + 1][posicaoy].setIcon(port3);
                                                            p3amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Porta4)
                                                        {
                                                            table[posicaox + 1][posicaoy].setIcon(port4); 
                                                            p4amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof NaoCelula)
                                                        {
                                                            table[posicaox + 1][posicaoy].setIcon(naocelula);
                                                        }
                                                   }
                                                   
                                               }
                                               if(matrizcelulajogador[posicaox][posicaoy] instanceof Escolta3)
                                               {
                                                   table[posicaox][posicaoy].setIcon(esc3);
                                                   e3amigo.setVivo(false);
                                                   table[posicaox][posicaoy - 1].setIcon(esc2);
                                                   e2amigo.setVivo(false);
                                                   
                                                   if(posicaoy + 1 < 10)
                                                   {
                                                        if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof Submarino1)
                                                        {
                                                            table[posicaox][posicaoy + 1].setIcon(sub1);
                                                            s1amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof Jato1)
                                                        {
                                                            table[posicaox][posicaoy + 1].setIcon(jato1);
                                                            j1amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof Porta1)
                                                        {
                                                            table[posicaox][posicaoy + 1].setIcon(port1);
                                                            p1amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof NaoCelula)
                                                        {
                                                            table[posicaox][posicaoy + 1].setIcon(naocelula);
                                                        }
                                                   }
                                                   //em cima
                                                   if(posicaox - 1 >= 0)
                                                   {
                                                        if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Submarino1)
                                                        {
                                                            table[posicaox - 1][posicaoy].setIcon(sub1);
                                                            s1amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Submarino2)
                                                        {
                                                            table[posicaox - 1][posicaoy].setIcon(sub2);
                                                            s2amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Jato1)
                                                        {
                                                            table[posicaox - 1][posicaoy].setIcon(jato1);
                                                            j1amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Jato2)
                                                        {
                                                            table[posicaox - 1][posicaoy].setIcon(jato2);
                                                            j2amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Porta1)
                                                        {
                                                            table[posicaox - 1][posicaoy].setIcon(port1);
                                                            p1amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Porta2)
                                                        {
                                                            table[posicaox - 1][posicaoy].setIcon(port2);
                                                            p2amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Porta3)
                                                        {
                                                            table[posicaox - 1][posicaoy].setIcon(port3);
                                                            p3amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Porta4)
                                                        {
                                                            table[posicaox - 1][posicaoy].setIcon(port4); 
                                                            p4amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof NaoCelula)
                                                        {
                                                            table[posicaox - 1][posicaoy].setIcon(naocelula);
                                                        }
                                                   }
                                                   
                                                   //em baixo
                                                   if(posicaox + 1 < 10)
                                                   {
                                                        if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Submarino1)
                                                        {
                                                            table[posicaox + 1][posicaoy].setIcon(sub1);
                                                            s1amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Submarino2)
                                                        {
                                                            table[posicaox + 1][posicaoy].setIcon(sub2);
                                                            s2amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Jato1)
                                                        {
                                                            table[posicaox + 1][posicaoy].setIcon(jato1);
                                                            j1amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Jato2)
                                                        {
                                                            table[posicaox + 1][posicaoy].setIcon(jato2);
                                                            j2amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Porta1)
                                                        {
                                                            table[posicaox + 1][posicaoy].setIcon(port1);
                                                            p1amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Porta2)
                                                        {
                                                            table[posicaox + 1][posicaoy].setIcon(port2);
                                                            p2amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Porta3)
                                                        {
                                                            table[posicaox + 1][posicaoy].setIcon(port3);
                                                            p3amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Porta4)
                                                        {
                                                            table[posicaox + 1][posicaoy].setIcon(port4); 
                                                            p4amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof NaoCelula)
                                                        {
                                                            table[posicaox + 1][posicaoy].setIcon(naocelula);
                                                        }
                                                   }
                                                   
                                                }
                                                if(matrizcelulajogador[posicaox][posicaoy] instanceof Porta1)
                                               {
                                                   table[posicaox][posicaoy].setIcon(port1);
                                                   p1amigo.setVivo(false);
                                                   table[posicaox][posicaoy + 1].setIcon(port2);
                                                   p2amigo.setVivo(false);
                                                   
                                                   if(posicaoy - 1 >= 0)
                                                   {
                                                        if(matrizcelulajogador[posicaox][posicaoy - 1] instanceof Submarino2)
                                                        {
                                                            table[posicaox][posicaoy - 1].setIcon(sub2);
                                                            s2amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox][posicaoy - 1] instanceof Jato2)
                                                        {
                                                            table[posicaox][posicaoy - 1].setIcon(jato2);
                                                            j2amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox][posicaoy - 1] instanceof Escolta3)
                                                        {
                                                            table[posicaox][posicaoy - 1].setIcon(esc3);
                                                            e3amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox][posicaoy - 1] instanceof NaoCelula)
                                                        {
                                                            table[posicaox][posicaoy - 1].setIcon(naocelula);
                                                        }
                                                   }
                                                   //em cima
                                                   if(posicaox - 1 >= 0)
                                                   {
                                                        if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Submarino1)
                                                        {
                                                            table[posicaox - 1][posicaoy].setIcon(sub1);
                                                            s1amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Submarino2)
                                                        {
                                                            table[posicaox - 1][posicaoy].setIcon(sub2);
                                                            s2amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Jato1)
                                                        {
                                                            table[posicaox - 1][posicaoy].setIcon(jato1);
                                                            j1amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Jato2)
                                                        {
                                                            table[posicaox - 1][posicaoy].setIcon(jato2);
                                                            j2amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Escolta1)
                                                        {
                                                            table[posicaox - 1][posicaoy].setIcon(esc1);
                                                            e1amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Escolta2)
                                                        {
                                                            table[posicaox - 1][posicaoy].setIcon(esc2);
                                                            e2amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Escolta3)
                                                        {
                                                            table[posicaox - 1][posicaoy].setIcon(esc3);
                                                            e3amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof NaoCelula)
                                                        {
                                                            table[posicaox - 1][posicaoy].setIcon(naocelula);
                                                        }
                                                   }
                                                   
                                                   //em baixo
                                                   if(posicaox + 1 < 10)
                                                   {
                                                        if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Submarino1)
                                                        {
                                                            table[posicaox + 1][posicaoy].setIcon(sub1);
                                                            s1amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Submarino2)
                                                        {
                                                            table[posicaox + 1][posicaoy].setIcon(sub2);
                                                            s2amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Jato1)
                                                        {
                                                            table[posicaox + 1][posicaoy].setIcon(jato1);
                                                            j1amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Jato2)
                                                        {
                                                            table[posicaox + 1][posicaoy].setIcon(jato2);
                                                            j2amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Escolta1)
                                                        {
                                                            table[posicaox + 1][posicaoy].setIcon(esc1);
                                                            e1amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Escolta2)
                                                        {
                                                            table[posicaox + 1][posicaoy].setIcon(esc2);
                                                            e2amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Escolta3)
                                                        {
                                                            table[posicaox + 1][posicaoy].setIcon(esc3);
                                                            e3amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof NaoCelula)
                                                        {
                                                            table[posicaox + 1][posicaoy].setIcon(naocelula);
                                                        }
                                                   }
                                                   
                                               }
                                               if(matrizcelulajogador[posicaox][posicaoy] instanceof Porta2)
                                               {
                                                   table[posicaox][posicaoy].setIcon(port2);
                                                   p2amigo.setVivo(false);
                                                   table[posicaox][posicaoy - 1].setIcon(port1);
                                                   p1amigo.setVivo(false);
                                                   table[posicaox][posicaoy + 1].setIcon(port3);
                                                   p3amigo.setVivo(false);
                                                   
                                                   //em cima
                                                   if(posicaox - 1 >= 0)
                                                   {
                                                        if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Submarino1)
                                                        {
                                                            table[posicaox - 1][posicaoy].setIcon(sub1);
                                                            s1amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Submarino2)
                                                        {
                                                            table[posicaox - 1][posicaoy].setIcon(sub2);
                                                            s2amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Jato1)
                                                        {
                                                            table[posicaox - 1][posicaoy].setIcon(jato1);
                                                            j1amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Jato2)
                                                        {
                                                            table[posicaox - 1][posicaoy].setIcon(jato2);
                                                            j2amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Escolta1)
                                                        {
                                                            table[posicaox - 1][posicaoy].setIcon(esc1);
                                                            e1amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Escolta2)
                                                        {
                                                            table[posicaox - 1][posicaoy].setIcon(esc2);
                                                            e2amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Escolta3)
                                                        {
                                                            table[posicaox - 1][posicaoy].setIcon(esc3);
                                                            e3amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof NaoCelula)
                                                        {
                                                            table[posicaox - 1][posicaoy].setIcon(naocelula);
                                                        }
                                                   }
                                                   
                                                   //em baixo
                                                   if(posicaox + 1 < 10)
                                                   {
                                                        if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Submarino1)
                                                        {
                                                            table[posicaox + 1][posicaoy].setIcon(sub1);
                                                            s1amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Submarino2)
                                                        {
                                                            table[posicaox + 1][posicaoy].setIcon(sub2);
                                                            s2amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Jato1)
                                                        {
                                                            table[posicaox + 1][posicaoy].setIcon(jato1);
                                                            j1amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Jato2)
                                                        {
                                                            table[posicaox + 1][posicaoy].setIcon(jato2);
                                                            j2amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Escolta1)
                                                        {
                                                            table[posicaox + 1][posicaoy].setIcon(esc1);
                                                            e1amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Escolta2)
                                                        {
                                                            table[posicaox + 1][posicaoy].setIcon(esc2);
                                                            e2amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Escolta3)
                                                        {
                                                            table[posicaox + 1][posicaoy].setIcon(esc3);
                                                            e3amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof NaoCelula)
                                                        {
                                                            table[posicaox + 1][posicaoy].setIcon(naocelula);
                                                        }
                                                   }
                                                }
                                                if(matrizcelulajogador[posicaox][posicaoy] instanceof Porta3)
                                               {
                                                   table[posicaox][posicaoy].setIcon(port3);
                                                   p3amigo.setVivo(false);
                                                   table[posicaox][posicaoy - 1].setIcon(port2);
                                                   p2amigo.setVivo(false);
                                                   table[posicaox][posicaoy + 1].setIcon(port4); 
                                                   p4amigo.setVivo(false);
                                                   
                                                   //em cima
                                                   if(posicaox - 1 >= 0)
                                                   {
                                                        if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Submarino1)
                                                        {
                                                            table[posicaox - 1][posicaoy].setIcon(sub1);
                                                            s1amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Submarino2)
                                                        {
                                                            table[posicaox - 1][posicaoy].setIcon(sub2);
                                                            s2amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Jato1)
                                                        {
                                                            table[posicaox - 1][posicaoy].setIcon(jato1);
                                                            j1amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Jato2)
                                                        {
                                                            table[posicaox - 1][posicaoy].setIcon(jato2);
                                                            j2amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Escolta1)
                                                        {
                                                            table[posicaox - 1][posicaoy].setIcon(esc1);
                                                            e1amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Escolta2)
                                                        {
                                                            table[posicaox - 1][posicaoy].setIcon(esc2);
                                                            e2amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Escolta3)
                                                        {
                                                            table[posicaox - 1][posicaoy].setIcon(esc3);
                                                            e3amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof NaoCelula)
                                                        {
                                                            table[posicaox - 1][posicaoy].setIcon(naocelula);
                                                        }
                                                   }
                                                   
                                                   //em baixo
                                                   if(posicaox + 1 < 10)
                                                   {
                                                        if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Submarino1)
                                                        {
                                                            table[posicaox + 1][posicaoy].setIcon(sub1);
                                                            s1amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Submarino2)
                                                        {
                                                            table[posicaox + 1][posicaoy].setIcon(sub2);
                                                            s2amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Jato1)
                                                        {
                                                            table[posicaox + 1][posicaoy].setIcon(jato1);
                                                            j1amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Jato2)
                                                        {
                                                            table[posicaox + 1][posicaoy].setIcon(jato2);
                                                            j2amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Escolta1)
                                                        {
                                                            table[posicaox + 1][posicaoy].setIcon(esc1);
                                                            e1amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Escolta2)
                                                        {
                                                            table[posicaox + 1][posicaoy].setIcon(esc2);
                                                            e2amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Escolta3)
                                                        {
                                                            table[posicaox + 1][posicaoy].setIcon(esc3);
                                                            e3amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof NaoCelula)
                                                        {
                                                            table[posicaox + 1][posicaoy].setIcon(naocelula);
                                                        }
                                                   }
                                               }
                                               if(matrizcelulajogador[posicaox][posicaoy] instanceof Porta4)
                                               {
                                                   table[posicaox][posicaoy].setIcon(port4); 
                                                   p4amigo.setVivo(false);
                                                   table[posicaox][posicaoy - 1].setIcon(port3);
                                                   p3amigo.setVivo(false);
                                                   
                                                   if(posicaoy + 1 < 10)
                                                   {
                                                        if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof Submarino1)
                                                        {
                                                            table[posicaox][posicaoy + 1].setIcon(sub1);
                                                            s1amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof Escolta1)
                                                        {
                                                            table[posicaox][posicaoy + 1].setIcon(esc1);
                                                            e1amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof Jato1)
                                                        {
                                                            table[posicaox][posicaoy + 1].setIcon(jato1);
                                                            j1amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof NaoCelula)
                                                        {
                                                            table[posicaox][posicaoy + 1].setIcon(naocelula);
                                                        }
                                                   }
                                                   //em cima
                                                   if(posicaox - 1 >= 0)
                                                   {
                                                        if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Submarino1)
                                                        {
                                                            table[posicaox - 1][posicaoy].setIcon(sub1);
                                                            s1amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Submarino2)
                                                        {
                                                            table[posicaox - 1][posicaoy].setIcon(sub2);
                                                            s2amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Jato1)
                                                        {
                                                            table[posicaox - 1][posicaoy].setIcon(jato1);
                                                            j1amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Jato2)
                                                        {
                                                            table[posicaox - 1][posicaoy].setIcon(jato2);
                                                            j2amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Escolta1)
                                                        {
                                                            table[posicaox - 1][posicaoy].setIcon(esc1);
                                                            e1amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Escolta2)
                                                        {
                                                            table[posicaox - 1][posicaoy].setIcon(esc2);
                                                            e2amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Escolta3)
                                                        {
                                                            table[posicaox - 1][posicaoy].setIcon(esc3);
                                                            e3amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof NaoCelula)
                                                        {
                                                            table[posicaox - 1][posicaoy].setIcon(naocelula);
                                                        }
                                                   }
                                                   
                                                   //em baixo
                                                   if(posicaox + 1 < 10)
                                                   {
                                                        if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Submarino1)
                                                        {
                                                            table[posicaox + 1][posicaoy].setIcon(sub1);
                                                            s1amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Submarino2)
                                                        {
                                                            table[posicaox + 1][posicaoy].setIcon(sub2);
                                                            s2amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Jato1)
                                                        {
                                                            table[posicaox + 1][posicaoy].setIcon(jato1);
                                                            j1amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Jato2)
                                                        {
                                                            table[posicaox + 1][posicaoy].setIcon(jato2);
                                                            j2amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Escolta1)
                                                        {
                                                            table[posicaox + 1][posicaoy].setIcon(esc1);
                                                            e1amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Escolta2)
                                                        {
                                                            table[posicaox + 1][posicaoy].setIcon(esc2);
                                                            e2amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Escolta3)
                                                        {
                                                            table[posicaox + 1][posicaoy].setIcon(esc3);
                                                            e3amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof NaoCelula)
                                                        {
                                                            table[posicaox + 1][posicaoy].setIcon(naocelula);
                                                        }
                                                   }
                                                }
                                                if(matrizcelulajogador[posicaox][posicaoy] instanceof NaoCelula)
                                                {
                                                   table[posicaox][posicaoy].setIcon(naocelula);
                                                   
                                                   //Direita
                                                   if(posicaoy + 1 < 10)
                                                   {
                                                        if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof Submarino1)
                                                        {
                                                            table[posicaox][posicaoy + 1].setIcon(sub1);
                                                            s1amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof Jato1)
                                                        {
                                                            table[posicaox][posicaoy + 1].setIcon(jato1);
                                                            j1amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof Escolta1)
                                                        {
                                                            table[posicaox][posicaoy + 1].setIcon(esc1);
                                                            e1amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof Porta1)
                                                        {
                                                            table[posicaox][posicaoy + 1].setIcon(port1);
                                                            p1amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox][posicaoy + 1] instanceof NaoCelula)
                                                        {
                                                            table[posicaox][posicaoy + 1].setIcon(naocelula);
                                                        }
                                                   }
                                                   
                                                   if(posicaoy - 1 >= 0)
                                                   {
                                                        if(matrizcelulajogador[posicaox][posicaoy - 1] instanceof Submarino2)
                                                        {
                                                            table[posicaox][posicaoy - 1].setIcon(sub2);
                                                            s2amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox][posicaoy - 1] instanceof Jato2)
                                                        {
                                                            table[posicaox][posicaoy - 1].setIcon(jato2);
                                                            j2amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox][posicaoy - 1] instanceof Escolta3)
                                                        {
                                                            table[posicaox][posicaoy - 1].setIcon(esc3);
                                                            e3amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox][posicaoy - 1] instanceof Porta4)
                                                        {
                                                            table[posicaox][posicaoy - 1].setIcon(port4); 
                                                            p4amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox][posicaoy - 1] instanceof NaoCelula)
                                                        {
                                                            table[posicaox][posicaoy - 1].setIcon(naocelula);
                                                        }
                                                   }
                                                   
                                                   //em cima
                                                   if(posicaox - 1 >= 0)
                                                   {
                                                        if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Submarino1)
                                                        {
                                                            table[posicaox - 1][posicaoy].setIcon(sub1);
                                                            s1amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Submarino2)
                                                        {
                                                            table[posicaox - 1][posicaoy].setIcon(sub2);
                                                            s2amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Jato1)
                                                        {
                                                            table[posicaox - 1][posicaoy].setIcon(jato1);
                                                            j1amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Jato2)
                                                        {
                                                            table[posicaox - 1][posicaoy].setIcon(jato2);
                                                            j2amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Escolta1)
                                                        {
                                                            table[posicaox - 1][posicaoy].setIcon(esc1);
                                                            e1amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Escolta2)
                                                        {
                                                            table[posicaox - 1][posicaoy].setIcon(esc2);
                                                            e2amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Escolta3)
                                                        {
                                                            table[posicaox - 1][posicaoy].setIcon(esc3);
                                                            e3amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Porta1)
                                                        {
                                                            table[posicaox - 1][posicaoy].setIcon(port1);
                                                            p1amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Porta2)
                                                        {
                                                            table[posicaox - 1][posicaoy].setIcon(port2);
                                                            p2amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Porta3)
                                                        {
                                                            table[posicaox - 1][posicaoy].setIcon(port3);
                                                            p3amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof Porta4)
                                                        {
                                                            table[posicaox - 1][posicaoy].setIcon(port4); 
                                                            p4amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox - 1][posicaoy] instanceof NaoCelula)
                                                        {
                                                            table[posicaox - 1][posicaoy].setIcon(naocelula);
                                                        }
                                                   }
                                                   
                                                   //em baixo
                                                   if(posicaox + 1 < 10)
                                                   {
                                                        if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Submarino1)
                                                        {
                                                            table[posicaox + 1][posicaoy].setIcon(sub1);
                                                            s1amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Submarino2)
                                                        {
                                                            table[posicaox + 1][posicaoy].setIcon(sub2);
                                                            s2amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Jato1)
                                                        {
                                                            table[posicaox + 1][posicaoy].setIcon(jato1);
                                                            j1amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Jato2)
                                                        {
                                                            table[posicaox + 1][posicaoy].setIcon(jato2);
                                                            j2amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Escolta1)
                                                        {
                                                            table[posicaox + 1][posicaoy].setIcon(esc1);
                                                            e1amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Escolta2)
                                                        {
                                                            table[posicaox + 1][posicaoy].setIcon(esc2);
                                                            e2amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Escolta3)
                                                        {
                                                            table[posicaox + 1][posicaoy].setIcon(esc3);
                                                            e3amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Porta1)
                                                        {
                                                            table[posicaox + 1][posicaoy].setIcon(port1);
                                                            p1amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Porta2)
                                                        {
                                                            table[posicaox + 1][posicaoy].setIcon(port2);
                                                            p2amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Porta3)
                                                        {
                                                            table[posicaox + 1][posicaoy].setIcon(port3);
                                                            p3amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof Porta4)
                                                        {
                                                            table[posicaox + 1][posicaoy].setIcon(port4); 
                                                            p4amigo.setVivo(false);
                                                        }
                                                        if(matrizcelulajogador[posicaox + 1][posicaoy] instanceof NaoCelula)
                                                        {
                                                            table[posicaox + 1][posicaoy].setIcon(naocelula);
                                                        }
                                                   }
                                                }
                                                if(contif == 0)
                                                {
                                                     if(s1amigo.getVivo() == false && s2amigo.getVivo() == false)
                                                     {
                                                        botaoS.setBackground(Color.red);
                                                        botaoS.setIcon(new ImageIcon("./submarino.png"));
                                                        cont = 0; 
                                                        contif = 1;
                                                     }
                                                }
                                                if(contifJ == 0) //fazer o jato ficar vermelho
                                                {
                                                     if(j1amigo.getVivo() == false && j2amigo.getVivo() == false)
                                                     {
                                                        botaoJ.setBackground(Color.red);
                                                        botaoJ.setIcon(new ImageIcon("./jato.png"));
                                                        cont = 0; 
                                                        contifJ = 1;
                                                     }
                                                }
                                                if(contifE == 0) //fazer o escolta ficar vermelho
                                                {
                                                     if(e1amigo.getVivo() == false && e2amigo.getVivo() == false && e3amigo.getVivo() == false)
                                                     {
                                                        botaoE.setBackground(Color.red);
                                                        botaoE.setIcon(new ImageIcon("./escolta.png"));
                                                        cont = 0; 
                                                        contifE = 1;
                                                     }
                                                }
                                                if(s1amigo.getVivo() == false && s2amigo.getVivo() == false && j1amigo.getVivo() == false && j2amigo.getVivo() == false && e1amigo.getVivo() == false && e2amigo.getVivo() == false && e3amigo.getVivo() == false)
                                                {
                                                    loser(); 
                                                }
                                                pcjaclicou[posicaox][posicaoy] = true;
                                                if(posicaoy - 1 >= 0)
                                                {
                                                    pcjaclicou[posicaox][posicaoy - 1] = true;
                                                }
                                                if(posicaox - 1 >= 0)
                                                {
                                                    pcjaclicou[posicaox - 1] [posicaoy] = true;
                                                }
                                                if(posicaox + 1 < 10)
                                                {
                                                    pcjaclicou[posicaox + 1] [posicaoy] = true;
                                                }
                                                if(posicaoy + 1 < 10)
                                                {
                                                    pcjaclicou[posicaox][posicaoy + 1] = true;
                                                }
                                            }
                                            else
                                            {
                                                t = -1; 
                                            }
                                        }
                                    }
                                }
                                else
                                {
                                   p = -1; 
                                }
                             }
                        }
                    }
                }
            }
        }
    }
    
}
   
   public void win()
   {
      // System.out.println("Morreu memo");
                                 p1inimigo.setVivo(true);
                                 p2inimigo.setVivo(true);
                                 p3inimigo.setVivo(true);
                                 p4inimigo.setVivo(true);
                                 s1inimigo.setVivo(true);
                                 s2inimigo.setVivo(true);
                                 j1inimigo.setVivo(true);
                                 j2inimigo.setVivo(true);
                                 e1inimigo.setVivo(true);
                                 e2inimigo.setVivo(true);
                                 e3inimigo.setVivo(true);

                                 p1inimigo.setVivo(true);
                                 p2inimigo.setVivo(true);
                                 p3inimigo.setVivo(true);
                                 p4inimigo.setVivo(true);
                                 s1inimigo.setVivo(true);
                                 s2inimigo.setVivo(true);
                                 j1inimigo.setVivo(true);
                                 j2inimigo.setVivo(true);
                                 e1inimigo.setVivo(true);
                                 e2inimigo.setVivo(true);
                                 e3inimigo.setVivo(true);


                                 Venceu win = new Venceu(matrizcelulajogador, matrizcelulapc);
                                 this.dispose();
                                 contadorsupremo = 1; 
                                 cont = 0; 
   }
   
   public void loser()
   {
        //System.out.println("Morreu memo");
                                                p1inimigo.setVivo(true);
                                                p2inimigo.setVivo(true);
                                                p3inimigo.setVivo(true);
                                                p4inimigo.setVivo(true);
                                                s1inimigo.setVivo(true);
                                                s2inimigo.setVivo(true);
                                                j1inimigo.setVivo(true);
                                                j2inimigo.setVivo(true);
                                                e1inimigo.setVivo(true);
                                                e2inimigo.setVivo(true);
                                                e3inimigo.setVivo(true);

                                                p1amigo.setVivo(true);
                                                p2amigo.setVivo(true);
                                                p3amigo.setVivo(true);
                                                p4amigo.setVivo(true);
                                                s1amigo.setVivo(true);
                                                s2amigo.setVivo(true);
                                                j1amigo.setVivo(true);
                                                j2amigo.setVivo(true);
                                                e1amigo.setVivo(true);
                                                e2amigo.setVivo(true);
                                                e3amigo.setVivo(true);
                                                
                                                
                                                Lose perdeu = new Lose(matrizcelulajogador, matrizcelulapc); 
                                                // perdeu.meFeche(this);
                                                this.dispose();
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
}
   
