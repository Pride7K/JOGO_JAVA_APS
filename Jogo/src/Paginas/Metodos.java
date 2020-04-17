
package Paginas;

import Inicializador.Acessar;
import Inicializador.Jogo;
import java.awt.Graphics;

public abstract class Metodos {
    
    
    protected Acessar acessar;
    
    public Metodos(Acessar acessar)
    {
        this.acessar = acessar;
    }
    
    private static Metodos  paginaAtual = null;
    
    public static void setarPaginaAtual(Metodos pagina)
    {
        paginaAtual = pagina;
    }
    
    public static Metodos pegarPaginaAtual()
    {
        return paginaAtual;
    }
    
    // metodos genericos que iram ser utilizados e sobreescrevidos
    // quando chamados em outras classes
    public abstract void atualizar();
    
    public abstract void renderizar(Graphics graficos);
    
}
