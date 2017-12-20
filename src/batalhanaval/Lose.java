package batalhanaval;
import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*;

public class Lose extends JFrame implements ActionListener
{
    JButton reinicia = new JButton("Reiniciar Jogo"); 
    JButton novo = new JButton("Novo Jogo"); 
    JButton sair = new JButton("Sair do Jogo");
    BatalhaNaval antes; 
    Celulas j[][]; 
    Celulas pc[][]; 
    public int clicou = 0;
    
    public Lose(Celulas jogador[][], Celulas PC[][])
    {
        super("Perdeu");
        setSize(400,200); //Manda como parametro e cria um metodo que recebe como parametro denovo e dai é so dar dispose 
        setResizable(false);
        
        JPanel venceu = new JPanel();
        venceu.setBackground(Color.white);
        venceu.setLayout(new BoxLayout(venceu, BoxLayout.PAGE_AXIS));
        JLabel texto = new JLabel("Seus veiculos de ataque foram destruidos!");
        JLabel texto1 = new JLabel("Voce nao pode mais atacar!"); 
        this.setLocationRelativeTo(null);
        
        this.j = jogador; 
        this.pc = PC; 
        texto.setAlignmentX(Component.CENTER_ALIGNMENT);
        texto1.setAlignmentX(Component.CENTER_ALIGNMENT);
        reinicia.setAlignmentX(Component.CENTER_ALIGNMENT);
        novo.setAlignmentX(Component.CENTER_ALIGNMENT);
        sair.setAlignmentX(Component.CENTER_ALIGNMENT);
        
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
            setVisible(false); 
        }
        if(object == novo)
        {
            PaginaInicial novo = new PaginaInicial(); 
            setVisible(false); 
        }
        if(object == sair)
        {
           // System.out.println("funfa");
            System.exit(0);
        }
    }
    
    
}
