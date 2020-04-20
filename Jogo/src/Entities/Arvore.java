
package Entities;

import Entities.Entity;
import Imagem.CarregarImagens;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import Inicializador.Acessar;
import Texturas.Texturas;
import java.awt.Color;
/**
 *
 * @author gsant
 */



public class Arvore extends Entity{
   
    private Acessar acessar;
    

    public Arvore(Acessar acessar, float x, float y, int largura, int altura) {
        super(acessar, x, y, Texturas.largura_textura, Texturas.largura_textura * 2);
        this.acessar = acessar;
        
        
        
    }
    
    

    @Override
    public void atualizar() {
        
    }

    @Override
    public void renderizar(Graphics grafico) {
        //System.out.println(grafico);
        System.out.println(acessar.pegarCamera());
        grafico.drawImage(CarregarImagens.arvore,(int) (x - acessar.pegarCamera().getX()),(int) (y - acessar.pegarCamera().getY()), largura, altura, null);
        //grafico.setColor(Color.blue);
        //grafico.fillRect((int) (x + hitboxObjetos.x - acessar.pegarCamera().getX()), (int) (y + hitboxObjetos.y - acessar.pegarCamera().getY()),
              //  hitboxObjetos.width, hitboxObjetos.height);
    }
    
    
    
}
