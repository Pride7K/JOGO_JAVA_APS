/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import Imagem.CarregarImagens;
import Inicializador.Acessar;
import Texturas.Texturas_Mundo;
import java.awt.Graphics;

/**
 *
 * @author gsant
 */
public class PedronaInvertida extends EntityParaObjetosStaticos {

    public PedronaInvertida(Acessar acessar, float x, float y) {
        super(acessar, x, y, Texturas_Mundo.largura_textura * 2, Texturas_Mundo.altura_textura * 2);
        this.acessar = acessar;
        this.possoAtacar = false;
    }

    @Override
    public void Morrer() {
        
    }

    @Override
    public void atualizar() {
        
    }

    @Override
    public void renderizar(Graphics grafico) {
        grafico.drawImage(CarregarImagens.pedronaInvertida,(int) (x - acessar.pegarCamera().getX()),(int) (y - acessar.pegarCamera().getY()), largura, altura, null);
    }
    
    
}
