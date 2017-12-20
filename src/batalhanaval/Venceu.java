package batalhanaval;
import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Venceu extends JFrame implements ActionListener
{
    JButton reinicia = new JButton("Reiniciar Jogo"); 
    JButton novo = new JButton("Novo Jogo"); 
    JButton sair = new JButton("Sair do Jogo");
    Celulas j[][]; 
    Celulas pc[][]; 
    public int clicou = 0; 
    
    public Venceu(Celulas jogador[][], Celulas PC[][])
    {
        super("Venceu");
        setSize(400,200); 
        setResizable(false);
        
        JPanel venceu = new JPanel();
        venceu.setBackground(Color.white);
        venceu.setLayout(new BoxLayout(venceu, BoxLayout.PAGE_AXIS));
        JLabel texto = new JLabel("Os veiculos de ataque do inimigo foram destruidos!");
        JLabel texto1 = new JLabel("Eles nao podem mais atacar!"); 
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        this.j = jogador; 
        this.pc = PC; 
        texto.setAlignmentX(Component.CENTER_ALIGNMENT); 
        texto1.setAlignmentX(Component.CENTER_ALIGNMENT);
        reinicia.setAlignmentX(Component.CENTER_ALIGNMENT);
        novo.setAlignmentX(Component.CENTER_ALIGNMENT);
        sair.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.setLocationRelativeTo(null);
        venceu.add(texto);
        venceu.add(texto1); 
        venceu.add(reinicia);
        venceu.add(novo); 
        venceu.add(sair);
        this.getContentPane().add(venceu, BorderLayout.CENTER);
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
            this.dispose();  
        }
        if(object == novo)
        {
            PaginaInicial novo = new PaginaInicial(); 
            this.dispose(); 
        }
        if(object == sair)
        {
           // System.out.println("funfa");
            System.exit(0);
        }
    }
    
    
    public BatalhaNaval fechaBN(BatalhaNaval b)
    {
        return b;  
    }
    
    
}
