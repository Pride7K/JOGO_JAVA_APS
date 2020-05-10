
package Entities;

import Entities.Entity;
import Imagem.CarregarImagens;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import Inicializador.Acessar;
import Texturas.Texturas_Mundo;
import java.awt.Color;
/**
 *
 * @author gsant
 */



public class Arvore extends EntityParaObjetosStaticos{
   
    private Acessar acessar;

    public Arvore(Acessar acessar, float x, float y) {
        super(acessar, x, y, Texturas_Mundo.largura_textura * 2, Texturas_Mundo.altura_textura * 2);
        //super(acessar, x, y, largura, altura);
        //System.out.println(x);
        //System.out.println(y);
        this.acessar = acessar;
        this.possoPassar = true;
        
        // desenhar hitbox da arvore
        //hitboxObjetos.x = 0;
        //hitboxObjetos.y = 0;
        //hitboxObjetos.width = Texturas_Mundo.largura_textura * 2;
        //hitboxObjetos.height = Texturas_Mundo.altura_textura * 2;
        
    }
    
    

    @Override
    public void atualizar() {
        
    }

    @Override
    public void renderizar(Graphics grafico) {
        //System.out.println(grafico);
        //System.out.println(acessar.pegarCamera());
        grafico.drawImage(CarregarImagens.arvore,(int) (x - acessar.pegarCamera().getX()),(int) (y - acessar.pegarCamera().getY()), largura, altura, null);
        //grafico.setColor(Color.black);
        //grafico.fillRect((int) (x + hitboxObjetos.x - acessar.pegarCamera().getX()), (int) (y + hitboxObjetos.y - acessar.pegarCamera().getY()),
                //hitboxObjetos.width, hitboxObjetos.height);
    }

    @Override
    public void Morrer() {
        
    }
    
    
    
}
