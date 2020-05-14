
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
    protected int vida;
    protected boolean personagemVivo = true;
    protected boolean possoPassar = false;
    protected boolean possoAtacar = true;
    // tive que deixar em ingles se não ia confundir tudo
    protected boolean isPlayer = false;
    protected boolean isInimigo = false;
    protected boolean isBot = false;
    protected String imgBot = "";
    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }
    
    
    public void atacar(int vidaPerdida)
    {
        vida -= vidaPerdida;
        if(vida <= 0)
        {
            personagemVivo = false;
            Morrer();
        }
    }

    public boolean isPersonagemVivo() {
        return personagemVivo;
    }

    public void setPersonagemVivo(boolean personagemVivo) {
        this.personagemVivo = personagemVivo;
    }
    public static final int vida_padrao = 10;
    
    public abstract void Morrer();
    
    // isso é para garantir que as posições vao receber valores
    public Entity(Acessar acessar,float x,float y,int largura,int altura)
    {
        this.acessar = acessar;
        this.x = x;
        this.y = y;
        vida = vida_padrao;
        this.largura = largura;
        this.altura = altura;
        
        hitboxObjetos = new Rectangle(0,0,largura,altura);
    }
    
    
    // esse metodo vai retornar toda a area em volta do retangulo para assim poder trabalhar com hitbox dos objetos
    public Rectangle hitboxRetangulo(float x2,float y2)
    {
        //tem que converter em int se não o java não deixa
        //System.out.println((int) (y + hitboxObjetos.y + y2));
        //System.out.println((int) (x + hitboxObjetos.x + x2));
        return new Rectangle((int) (x + hitboxObjetos.x + x2),(int)(y + hitboxObjetos.y + y2),hitboxObjetos.width,hitboxObjetos.height);
    }
    
    
    // metodo parecido com o que tem na classe de textura
    public boolean esbarrouComObjeto(float xObject, float yObject)
    {
        // esse for é para que passe em cada objeto que tem no jogo e verificar se esbarrou
        for(int i =0; i< acessar.pegarMundo().getGerarEntidades().getObjetosEntity().size();i++)
        {
            Entity teste = acessar.pegarMundo().getGerarEntidades().getObjetosEntity().get(i);
            //System.out.println(teste);
            //System.out.println("");
            //System.out.println(this);
            // este if é para garantir que não vai retornar true caso passe pelo objeto que está chamando esse metodo
            if(teste == this)
            {
                //System.out.println("caiu wtf");
                //System.out.println("esbarrou em você mesmo");
                continue;
            }
            if(teste.hitboxRetangulo(0f,0f).intersects(hitboxRetangulo(xObject,yObject)))
            {
               //System.out.println(this);
               //System.out.println(hitboxRetangulo(x,y));
                
               if(teste.possoPassar == true)
               {
                   //System.out.println("mano wtf");
                //System.out.println(teste);
                //System.out.println(teste.possoPassar);
                return false;
               }

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
