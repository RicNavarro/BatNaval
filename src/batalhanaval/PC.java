package batalhanaval;
import java.awt.*; 
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class PC 
{
    private int posicaox = 0; 
    private int posicaoy = 0; 
    public void atiraPc(JButton navios[][], boolean atirou[][])
    {
        Random random = new Random();
        int foi = 1; 
        
        
        for(int i = 0; i < foi; i++)
        {
            posicaox = random.nextInt(10);
            posicaoy = random.nextInt(10);
            if(atirou[posicaox][posicaoy] == false)
            {
                navios[posicaox][posicaoy].setIcon(new ImageIcon("./vector-wave-008.jpg"));
                atirou[posicaox][posicaoy] = true; 
            }
            else
            {
                i = -1; 
            }
        }
        
        
        
    }
    
    
    
}
