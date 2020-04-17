
package Entities;

import Inicializador.Jogo;
import java.awt.Graphics;

public abstract class Entity {
    // protected é como private só que apenas as classes que vão estender vao ter acesso
    protected Jogo jogo;
    protected float x,y;
    protected int largura,altura;
    
    // isso é para garantir que as posições vao receber valores
    public Entity(Jogo jogo,float x,float y,int largura,int altura)
    {
        this.jogo = jogo;
        this.x = x;
        this.y = y;
        this.largura = largura;
        this.altura = altura;
    }

    //acessar e manipular variaveis do tipo private e protected atraves de outras
    // classes  
    
    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getLargura() {
        return largura;
    }

    public void setLargura(int largura) {
        this.largura = largura;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }
    
    
    public abstract void atualizar();
    
    public abstract void renderizar(Graphics grafico);
    
}
