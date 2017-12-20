package batalhanaval;
import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*;

public class Inicio extends JFrame implements ActionListener
{
    private JButton jogar  = new JButton("Jogar"); 
    private ImageIcon bg = new ImageIcon("./titulo.jpg"); 
    
    public Inicio()
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
        
        
        this.getContentPane().add(jogar);

        this.getContentPane().add(f); 
        
        jogar.setBackground(Color.white);
        
        jogar.setBounds(90,530,300,100);
        //this.getContentPane().add(imagem, BorderLayout.CENTER); 
        
        
        
        this.setLocationRelativeTo(null);
        /*paginainicial.add(jogar);
        paginainicial.add(planejado);
        paginainicial.add(arquivo);*/
        
        //this.getContentPane().add(paginainicial, BorderLayout.SOUTH);
        setVisible(true);
        
        jogar.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        Object object = ae.getSource();
        
        if(object == jogar) {
        	Tutorial t = new Tutorial(); 
            this.dispose(); 
        }
    }
    
   
            
}