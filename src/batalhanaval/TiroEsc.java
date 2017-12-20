package batalhanaval;

public class TiroEsc extends Tiro
{
    public TiroEsc(Escolta1 a, Escolta2 b, Escolta3 c)
    {
        if(a.getVivo() == true || b.getVivo() == true || c.getVivo() == true)
        {
            this.permissaoparaatirar = true;        
        }
        else
        {
            this.permissaoparaatirar = false;
        }
    } 
}
