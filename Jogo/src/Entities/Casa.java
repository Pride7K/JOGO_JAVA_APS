/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import Imagem.CarregarImagens;
import Inicializador.Acessar;
import Texturas.Texturas_Mundo;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author gsant
 */
public class Casa extends EntityParaObjetosStaticos{

    public Casa(Acessar acessar, float x, float y) {
        super(acessar, x, y, Texturas_Mundo.largura_textura * 3, Texturas_Mundo.altura_textura * 3);
        this.acessar = acessar;
        this.possoPassar = false;
        // desenhar hitbox da casa
        hitboxObjetos.x = 0;
        hitboxObjetos.y = 0;
        hitboxObjetos.width = Texturas_Mundo.largura_textura * 3;
        hitboxObjetos.height = Texturas_Mundo.altura_textura * 3;
    }

    @Override
    public void Morrer() {
        
    }

    @Override
    public void atualizar() {
        
    }

    @Override
    public void renderizar(Graphics grafico) {
        grafico.drawImage(CarregarImagens.casa,(int) (x - acessar.pegarCamera().getX()),(int) (y - acessar.pegarCamera().getY()), largura, altura, null);
        //grafico.setColor(Color.YELLOW);
        //grafico.fillRect((int) (x + hitboxObjetos.x - acessar.pegarCamera().getX()), (int) (y + hitboxObjetos.y - acessar.pegarCamera().getY()),
                //hitboxObjetos.width, hitboxObjetos.height);
    }
    
}
