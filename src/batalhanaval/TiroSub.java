package batalhanaval;


public class TiroSub extends Tiro
{
    public TiroSub(Submarino1 a, Submarino2 b)
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
