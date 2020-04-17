
package Entities;

import Inicializador.Jogo;
import java.awt.Graphics;

public abstract class Monstros  extends Entity{

    // final é como const do javascript
    public static  final int vida_padrao = 10;
    public static final float velocidade_padrao = 10;
    public static final int largura_padrao = 50;
    public static final int altura_padrao = 50; 
    protected Jogo jogo;
    protected float monstroPositionX;
    protected float monstroPositionY;
    
    protected int vida;
    protected float velocidade;
    
    public Monstros(Jogo jogo,float x , float y,int altura,int largura)
    {
        // esse super ira passar os parametros para a classe estendida
        super(jogo,x,y,altura,largura);
        vida = vida_padrao;
        velocidade = velocidade_padrao;
        monstroPositionX = 0;
        monstroPositionY = 0;
    }
    
    public void mover()
    {
        x+=monstroPositionX;
        y+=monstroPositionY;
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
