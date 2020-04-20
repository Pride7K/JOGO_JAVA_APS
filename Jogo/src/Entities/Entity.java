
package Entities;

import Inicializador.Acessar;
import Inicializador.Jogo;
import java.awt.Graphics;
import java.awt.Rectangle;



public abstract class Entity {
    // protected é como private só que apenas as classes que vão estender vao ter acesso
    protected Acessar acessar;
    protected float x,y;
    protected int largura,altura;
    protected Rectangle hitboxObjetos;
    
    // isso é para garantir que as posições vao receber valores
    public Entity(Acessar acessar,float x,float y,int largura,int altura)
    {
        this.acessar = acessar;
        this.x = x;
        this.y = y;
        this.largura = largura;
        this.altura = altura;
        
        hitboxObjetos = new Rectangle(0,0,largura,altura);
    }
    
    
    // esse metodo vai retornar toda a area em volta do retangulo para assim poder trabalhar com hitbox
    public Rectangle hitboxRetangulo(float x2,float y2)
    {
        //tem que converter em int se não o java não deixa
        return new Rectangle((int) (x2 + hitboxObjetos.x + x),(int)(y2 + hitboxObjetos.y + y),hitboxObjetos.width,hitboxObjetos.height);
    }
    
    
    // metodo parecido com o que tem na classe de textura
    public boolean esbarrouComObjeto(float x, float y)
    {
        // esse for é para que passe em cada objeto que tem no jogo e verificar se esbarrou
        for(int i =0; i< acessar.pegarMundo().getGerarEntidades().getObjetosEntity().size();i++)
        {
            Entity teste = acessar.pegarMundo().getGerarEntidades().getObjetosEntity().get(i);
            // este if é para garantir que não vai retornar true caso passe pelo objeto que está chamando esse metodo
            if(teste == this)
            {
                continue;
            }
            if(teste.hitboxRetangulo(0f,0f).intersects(hitboxRetangulo(x,y)) == true)
            {
                return true;
            }
        }
        return false;
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
