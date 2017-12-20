package batalhanaval;
import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*;

public class PaginaInicial extends JFrame implements ActionListener
{
    private JButton aleatorio = new JButton("Jogo Aleatório");
    private JButton planejado = new JButton("Monte seu Jogo"); 
    private JButton arquivo = new JButton("Ler Jogo via Arquivo"); ;
    private ImageIcon bg = new ImageIcon("./titulo.jpg"); 
    
    public PaginaInicial()
    {
        super("Batalha Naval"); 
        setSize(1280,720); 
        setResizable(true); 
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        /*JPanel paginainicial = new JPanel();
        paginainicial.setBackground(Color.white);
        paginainicial.setLayout(new GridLayout(1,1)); */
        
        JLabel imagem = new JLabel(bg); 
        imagem.setBackground(Color.white); 
        
        
        Fundo f = new Fundo("./titulo.jpg");
        this.getContentPane().setLayout(null);
        
        
        this.getContentPane().add(aleatorio);
        this.getContentPane().add(planejado);
        this.getContentPane().add(arquivo);
        this.getContentPane().add(f); 
        
        aleatorio.setBackground(Color.white);
        planejado.setBackground(Color.white);
        arquivo.setBackground(Color.white);
        
        aleatorio.setBounds(90,530,300,100);
        planejado.setBounds(90,430,300,100);
        arquivo.setBounds(90,330,300,100);
        //this.getContentPane().add(imagem, BorderLayout.CENTER); 
        
        
        
        this.setLocationRelativeTo(null);
        /*paginainicial.add(aleatorio);
        paginainicial.add(planejado);
        paginainicial.add(arquivo);*/
        
        //this.getContentPane().add(paginainicial, BorderLayout.SOUTH);
        setVisible(true);
        
        aleatorio.addActionListener(this);
        planejado.addActionListener(this);
        arquivo.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        Object object = ae.getSource();
        
        if(object == aleatorio) {
        	ModoJogo m = new ModoJogo(0); 
            this.dispose(); 
        }
        
        if(object == planejado){
            ModoJogo m = new ModoJogo(1); 
            this.dispose(); 
        }
        
        if(object == arquivo) {	
            ModoJogo m = new ModoJogo(2); 
            this.dispose(); 
        }
        
    }
    
   
            
}