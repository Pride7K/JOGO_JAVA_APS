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
public class Inimigo extends Monstros{
   
    public float xInimigo = 0;
    public float yInimigo = 0;
    
    public Inimigo(Acessar acessar, float x, float y,int largura,int altura) {
        super(acessar, x, y, Monstros.largura_padrao, Monstros.altura_padrao);
        this.acessar = acessar;
        // desenhar hitbox do inimigo
        
        
    }

   

    @Override
    public void renderizar(Graphics grafico) {
        grafico.drawImage(CarregarImagens.inimigo, (int) (x - acessar.pegarCamera().getX()), (int) (y - acessar.pegarCamera().getY()), largura , altura , null);

    }

    @Override
    public void Morrer() {
        
    }

    @Override
    public void atualizar() {
        
    }

    
    
}
