
package Texturas;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Texturas {
    
    public static Texturas[] texturas = new Texturas[256];
    public static Texturas pedaco_mapa = new Labirinto_Textura(0);
    public static Texturas parede = new Parede_Textura(1);
    public static Texturas tijolo = new Tijolo(2);
    public static Texturas pedra = new Pedra(3);
    
    protected BufferedImage textura;
    
    public static final int largura_textura = 80;
    public static final int altura_textura = 80;
    
    protected final int id;
    
    public Texturas(BufferedImage textura,int id)
    {
            
        this.textura = textura;
        this.id = id;
        
        texturas[id] = this;
    }
    
    public void atualizar()
    {
        
    }
    
    public boolean naoPossoEsbarrar()
    {
        return false;
    }
    
    public void renderizar(Graphics grafico,int x,int y)
    {
        grafico.drawImage(textura,x,y,largura_textura,altura_textura,null);
    }
    
    public int pegarId()
    {
        return id;
    }
    
}
