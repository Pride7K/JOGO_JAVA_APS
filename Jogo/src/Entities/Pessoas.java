/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import Imagem.CarregarImagens;
import static Imagem.CarregarImagens.cortarImagem;
import static Imagem.CarregarImagens.gramaComTrilha;
import Imagem.TransformarEmBuffered;
import Inicializador.Acessar;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 *
 * @author gsant
 */
public class Pessoas extends Monstros {

    public Pessoas(Acessar acessar, float x, float y) {
        super(acessar, x, y, Monstros.largura_padrao, Monstros.altura_padrao);
        // sem isso o jogo nao vai funcionar lol
        this.acessar = acessar;
        this.isBot = true;
        this.possoPassar = true;
        // desenhar hitbox no personagem
        hitboxObjetos.x = 0;
        hitboxObjetos.y = 0;
        hitboxObjetos.width = 40;
        hitboxObjetos.height = 53;

    }

    @Override
    public void atualizar() {
        Mover(this);
        //acessar.pegarCamera().centralizar(this);
      
    }

    @Override
    public void renderizar(Graphics grafico) {
        if (this.isBot == true && this.possoAtacar == false) {
            String caminho = System.getProperty("user.dir");
            BufferedImage pessoasImage = (TransformarEmBuffered.carregaImg(caminho + "\\coisas\\images\\Pessoas\\" + this.imgBot));
            BufferedImage pessoasImageFinal = cortarImagem(0, 0, 48, 54,pessoasImage);
            grafico.drawImage(pessoasImageFinal, (int) (x - acessar.pegarCamera().getX()), (int) (y - acessar.pegarCamera().getY()), largura, altura, null);
            //grafico.fillRect((int) (x + hitboxObjetos.x - acessar.pegarCamera().getX()), (int) (y + hitboxObjetos.y - acessar.pegarCamera().getY()),
              //      hitboxObjetos.width, hitboxObjetos.height);
        } else {
            grafico.drawImage(CarregarImagens.pessoas, (int) (x - acessar.pegarCamera().getX()), (int) (y - acessar.pegarCamera().getY()), largura, altura, null);
            // se não somar o x com a hitbox a hitbox vai ficar colada longe do personagem
            // o mesmo vale para o y
            //grafico.fillRect((int) (x + hitboxObjetos.x - acessar.pegarCamera().getX()), (int) (y + hitboxObjetos.y - acessar.pegarCamera().getY()),
              //      hitboxObjetos.width, hitboxObjetos.height);
        }
    }

    @Override
    public void Morrer() {
        System.out.println("Bot morreu");
    }


}
