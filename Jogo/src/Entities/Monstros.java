package Entities;

import Inicializador.Acessar;
import Inicializador.Jogo;
import java.awt.Graphics;

public abstract class Monstros extends Entity {

    // final é como const do javascript
    public static final int vida_padrao = 10;
    public static final float velocidade_padrao = 10;
    public static final int largura_padrao = 50;
    public static final int altura_padrao = 50;
    protected Acessar acessar;
    protected float monstroPositionX;
    protected float monstroPositionY;

    protected int vida;
    protected float velocidade;

    public Monstros(Acessar acessar, float x, float y, int altura, int largura) {
        // esse super ira passar os parametros para a classe estendida
        super(acessar, x, y, altura, largura);
        vida = vida_padrao;
        velocidade = velocidade_padrao;
        monstroPositionX = 0;
        monstroPositionY = 0;
    }

    /*
    public void mover()
    {
        x+=monstroPositionX;
        y+=monstroPositionY;
    }
     */
    public void Mover() {
        MoverPosicaoX();
        MoverPosicaoY();
    }

    public void MoverPosicaoX() {
        // se for maior que 0 quer dizer que esta se movendo para a direita
        // se for menor que 0 esta indo para a esquerda
        if (monstroPositionX > 0) {
            // conta para pegar o ultimo x da hitbox para assim saber se esta colidindo depois
            // x + monstroPositionX + hitboxPersonagem.x + hitboxPersonagem.width == lado direito do personagem
            // dividi pela largura da textura para obter um valor em tamanho de textura
            //System.out.println(x);
            //System.out.println(monstroPositionX);
            //System.out.println(hitboxPersonagem.width);
            int hitboxX = (int) (x + monstroPositionX + hitboxPersonagem.x + hitboxPersonagem.width) / Texturas.Texturas.largura_textura;
            //System.out.println(hitboxX);
            if (colidiuTextura(hitboxX, (int) (y + hitboxPersonagem.y) / Texturas.Texturas.altura_textura) == false && colidiuTextura(hitboxX, (int) (y + hitboxPersonagem.y + hitboxPersonagem.height) / Texturas.Texturas.altura_textura) == false) {
                x = x + monstroPositionX;
            }
        } else if (monstroPositionX < 0) {
            // x + monstroPositionX + hitboxPersonagem.x  == lado esquerdo do personagem
            int hitboxX = (int) (x + monstroPositionX + hitboxPersonagem.x) / Texturas.Texturas.largura_textura;
            if (colidiuTextura(hitboxX, (int) (y + hitboxPersonagem.y) / Texturas.Texturas.altura_textura) == false && colidiuTextura(hitboxX, (int) (y + hitboxPersonagem.y + hitboxPersonagem.height) / Texturas.Texturas.altura_textura) == false) {
                x = x + monstroPositionX;
            }
        }

    }

    public void MoverPosicaoY() {
        if (monstroPositionY > 0) {
            int hitboxY = (int) (y + monstroPositionY + hitboxPersonagem.y + hitboxPersonagem.height) / Texturas.Texturas.altura_textura;
            //System.out.println(hitboxX);
            if (colidiuTextura((int) (x + hitboxPersonagem.x) / Texturas.Texturas.largura_textura,hitboxY) == false) {
                y = y + monstroPositionY;
            }
        }
        else if (monstroPositionY < 0) {
         int hitboxY = (int) (y + monstroPositionY + hitboxPersonagem.y) / Texturas.Texturas.altura_textura;
            //System.out.println(hitboxX);
            if (colidiuTextura((int) (x + hitboxPersonagem.x) / Texturas.Texturas.largura_textura,hitboxY) == false) {
                y = y + monstroPositionY;
            }
        }
    }

    public boolean colidiuTextura(int x, int y) {
        return acessar.pegarMundo().pegarTextura(x, y).naoPossoEsbarrar();
    }

    public float getMonstroPositionX() {
        return monstroPositionX;
    }

    public void setMonstroPositionX(float monstroPositionX) {
        this.monstroPositionX = monstroPositionX;
    }

    public float getMonstroPositionY() {
        return monstroPositionY;
    }

    public void setMonstroPositionY(float monstroPositionY) {
        this.monstroPositionY = monstroPositionY;
    }

    public int getVida() {
        return vida;
    }

    public float getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(float velocidade) {
        this.velocidade = velocidade;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

}
