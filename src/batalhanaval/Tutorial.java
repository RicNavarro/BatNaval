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

public class Tutorial extends JFrame implements ActionListener{
	private Fundo tal1 = new Fundo("./tutorial1.png");
	private Fundo tal2 = new Fundo("./tutorial2.png");
	private Fundo tal3 = new Fundo("./tutorial3.png");
	private Fundo tal4 = new Fundo("./tutorial4.png");
	private Fundo tal5 = new Fundo("./tutorial5.png");
	private Fundo tal6 = new Fundo("./tutorial6.png");
	private Fundo tal7 = new Fundo("./tutorial7.png");
	private Fundo tal8 = new Fundo("./tutorial8.png");
	private Fundo tal9 = new Fundo("./tutorial9.png");
	private Fundo tal10 = new Fundo("./tutorial10.png");
	private Fundo tal11 = new Fundo("./tutorial11.png");
	private Fundo tal12 = new Fundo("./tutorial12.png");
	private Fundo tal13 = new Fundo("./tutorial13.png");
	private JButton avancar = new JButton("Avançar");
	private JButton pular = new JButton("Pular");
	private int cont = 1;
	
	public Tutorial(){
		super("Tutorial"); //Nome da janela
	       setSize(1280,720); //Resolucao
	       setResizable(false); //Nao pode diminuir ou aumentar a tela
	       setDefaultCloseOperation(EXIT_ON_CLOSE);//Para de rodar quando fecha a janela
	       this.setLocationRelativeTo(null);
	       
	       setVisible(true); //Deixa a janela visivel
	       
	       this.getContentPane().setLayout(null);
	       this.getContentPane().add(avancar);
	       this.getContentPane().add(pular);
	       avancar.setBounds(10,10,160,60);
	       pular.setBounds(10,620,160,60);
	       this.getContentPane().add(tal1);
	       this.getContentPane().add(tal2);
	       this.getContentPane().add(tal3);
	       this.getContentPane().add(tal4);
	       this.getContentPane().add(tal5);
	       this.getContentPane().add(tal6);
	       this.getContentPane().add(tal7);
	       this.getContentPane().add(tal8);
	       this.getContentPane().add(tal9);
	       this.getContentPane().add(tal10);
	       this.getContentPane().add(tal11);
	       this.getContentPane().add(tal12);
	       this.getContentPane().add(tal13);
	       avancar.addActionListener(this);
	       pular.addActionListener(this);
	      
	       
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		 Object object = e.getSource();
		 
		 if(object == pular) {
			 this.dispose();
			 PaginaInicial p = new PaginaInicial();
		 }
		 if(object == avancar && cont == 13) {
			 this.dispose();
			 PaginaInicial p = new PaginaInicial();
		 }
		 if(object == avancar && cont == 12) {
			 tal12.setVisible(false);
			 avancar.setBounds(10,620,160,60);
			 cont++;
		 }
		 if(object == avancar && cont == 11) {
			 tal11.setVisible(false);
			 avancar.setBounds(10,450,160,60);
			 cont++;
		 }
		 if(object == avancar && cont == 10) {
			 tal10.setVisible(false); 
			 cont++;
		 }
		 if(object == avancar && cont == 9) {
			 tal9.setVisible(false);
			 cont++;
		 }
		 if(object == avancar && cont == 8) {
			 tal8.setVisible(false);
			 cont++;
		 }
		 if(object == avancar && cont == 7) {
			 tal7.setVisible(false);
			 cont++;
		 }
		 if(object == avancar && cont == 6) {
			 tal6.setVisible(false);
			 cont++;
		 }
		 if(object == avancar && cont == 5) {
			 tal5.setVisible(false);
			 cont++;
		 }
		 if(object == avancar && cont == 4) {
			 tal4.setVisible(false);
			 cont++;
		 }
		 if(object == avancar && cont == 3) {
			 tal3.setVisible(false);
			 cont++;
		 }
		 if(object == avancar && cont == 2) {
			 //System.out.println("2");
			 tal2.setVisible(false);
			 cont++;
		 }
		 if(object == avancar && cont == 1) {
			 //System.out.println("1");
			 tal1.setVisible(false);
			 pular.setVisible(false);
			 avancar.setBounds(10,620,160,60);
			 cont++;
		 }	 
	}
	
	
}
