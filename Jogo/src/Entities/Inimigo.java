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
import java.awt.Rectangle;

/**
 *
 * @author gsant
 */
public class Inimigo extends Monstros {

    public float xInimigo = 0;
    public float yInimigo = 0;

    public Inimigo(Acessar acessar, float x, float y) {
        super(acessar, x, y, Monstros.largura_padrao, Monstros.altura_padrao);
        // sem isso o jogo nao vai funcionar lol
        this.acessar = acessar;
        this.isInimigo = true;
        this.possoPassar = true;
        // desenhar hitbox no personagem
        hitboxObjetos.x = 12;
        hitboxObjetos.y = 15;
        hitboxObjetos.width = 27;
        hitboxObjetos.height = 52;

    }

    @Override
    public void atualizar() {
        Mover(this);
        possoAtacar();
    }

    private void possoAtacar() {
        // isso é para criar uma hitbox de ataque
        // somando mais a hitbox do personagem
        Rectangle hitboxPersonagem = hitboxRetangulo(0, 0);
        Rectangle areaDeAtaque = new Rectangle();

        int areaHitbox = 25;

        areaDeAtaque.x = hitboxObjetos.x;
        areaDeAtaque.y = hitboxObjetos.y;
        areaDeAtaque.width = areaHitbox;
        areaDeAtaque.height = areaHitbox;

        areaDeAtaque.x = hitboxPersonagem.x + hitboxPersonagem.width / 2 ;
        areaDeAtaque.y = hitboxPersonagem.y;

        //System.out.println("ataque area");

        for (int i = 0; i < acessar.pegarMundo().getGerarEntidades().getObjetosEntity().size(); i++) {
            Entity teste = acessar.pegarMundo().getGerarEntidades().getObjetosEntity().get(i);
            if (teste == this) {
                continue;
            }
            if (teste.hitboxRetangulo(0f, 0f).intersects(areaDeAtaque)) {
                if (teste.possoAtacar == false) {

                } else {
                    if (teste.isPlayer == true) {

                        teste.atacar(10);
                        return;
                    }
                    //System.out.println("caiu4");
                    //System.out.println(teste);
                }
            }
        }

    }

    @Override
    public void renderizar(Graphics grafico
    ) {
        grafico.drawImage(CarregarImagens.inimigo, (int) (x - acessar.pegarCamera().getX()), (int) (y - acessar.pegarCamera().getY()), largura, altura, null);
        //grafico.setColor(Color.RED);
        ///grafico.fillRect((int) (x + hitboxObjetos.x - acessar.pegarCamera().getX()), (int) (y + hitboxObjetos.y - acessar.pegarCamera().getY()),
        //   hitboxObjetos.width, hitboxObjetos.height);      
    }

    @Override
    public void Morrer() {
         System.out.println("Bot morreu");
    }

}
