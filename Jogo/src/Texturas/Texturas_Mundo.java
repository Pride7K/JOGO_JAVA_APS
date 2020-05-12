
package Texturas;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Texturas_Mundo {
    
    public static Texturas_Mundo[] texturas = new Texturas_Mundo[256];
    public static Texturas_Mundo pedaco_mapa = new Labirinto_Textura(0);
    public static Texturas_Mundo parede = new Parede_Textura(1);
    public static Texturas_Mundo tijolo = new Tijolo(2);
    public static Texturas_Mundo pedra = new Pedra(3);
    public static Texturas_Mundo terra = new Terra(4);
    public static Texturas_Mundo grama = new Grama(5);
    public static Texturas_Mundo gramaComTrilha = new GramaComTrilha(6);
    protected BufferedImage textura;
    
    public static final int largura_textura = 80;
    public static final int altura_textura = 80;
    
    protected final int id;
    
    public Texturas_Mundo(BufferedImage textura,int id)
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
