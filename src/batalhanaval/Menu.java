package batalhanaval;
import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Menu extends JFrame implements ActionListener
{
    JButton reinicia = new JButton("Reiniciar Jogo"); 
    JButton novo = new JButton("Novo Jogo"); 
    JButton sair = new JButton("Sair do Jogo");
    Celulas j[][]; 
    Celulas pc[][]; 
    public int clicou = 0; 
    
    public Menu(Celulas jogador[][], Celulas PC[][])
    {
        super("Menu");
        setSize(400,200); 
        setResizable(false);
        
        JPanel menu = new JPanel();
        menu.setBackground(Color.white);
        menu.setLayout(new BoxLayout(menu, BoxLayout.PAGE_AXIS));
         
       
        
        this.j = jogador; 
        this.pc = PC; 
        
        reinicia.setAlignmentX(Component.CENTER_ALIGNMENT);
        novo.setAlignmentX(Component.CENTER_ALIGNMENT);
        sair.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.setLocationRelativeTo(null);
         
        menu.add(reinicia);
        menu.add(novo); 
        menu.add(sair);
        this.getContentPane().add(menu, BorderLayout.CENTER);
        setVisible(true);
        
        reinicia.addActionListener(this);
        novo.addActionListener(this);
        sair.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        Object object = ae.getSource(); 
        if(object == reinicia)
        {
            //fechaBN(b);
            BatalhaNaval reiniciou = new BatalhaNaval(this.j, this.pc); 
            setVisible(false); 
        }
        if(object == novo)
        {
            PaginaInicial novo = new PaginaInicial(); 
            setVisible(false); 
        }
        if(object == sair)
        {
            System.exit(0);
        }
    }
    
    
    public BatalhaNaval fechaBN(BatalhaNaval b)
    {
        return b;  
    }
    
    
}
