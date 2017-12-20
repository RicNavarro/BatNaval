package batalhanaval;

public class TiroJat extends Tiro
{
     public TiroJat(Jato1 a, Jato2 b)
    {
        if(a.getVivo() == true || b.getVivo() == true)
        {
            this.permissaoparaatirar = true;        
        }
        else
        {
            this.permissaoparaatirar = false;
        }
    } 
}
