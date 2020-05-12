package Entities;

import Imagem.CarregarImagens;
import Inicializador.Acessar;
import Inicializador.Jogo;
import Tela.Tela;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferStrategy;

public class Jogador extends Monstros {
    
    private BufferStrategy bs;
    private Tela tela;
    
    public Jogador(Acessar acessar,float x, float y) {
        super(acessar,x, y,Monstros.largura_padrao,Monstros.altura_padrao);
        // sem isso o jogo nao vai funcionar lol
        this.acessar = acessar;
        
        
        // desenhar hitbox no personagem
        hitboxObjetos.x = 12;
        hitboxObjetos.y = 15;
        hitboxObjetos.width = 27;
        hitboxObjetos.height = 52;
        
    }
    
    

    @Override
    public void atualizar() {
        String posicao = pegarEntradas();
        Mover(this);
        acessar.pegarCamera().centralizar(this);
        possoAtacar(posicao);
    }
    
    private void possoAtacar(String lado)
    {
        // isso é para criar uma hitbox de ataque
        // somando mais a hitbox do personagem
        Rectangle hitboxPersonagem = hitboxRetangulo(0, 0);
        Rectangle areaDeAtaque = new Rectangle();
        int areaHitbox = 50;
        
        areaDeAtaque.x = hitboxObjetos.x;
        areaDeAtaque.y = hitboxObjetos.y;
        areaDeAtaque.width = areaHitbox;
        areaDeAtaque.height = areaHitbox;
        
        if(acessar.pegarTeclado().ataque)
        {
         System.out.println(lado);
         if (lado == "Direita") {
            areaDeAtaque.x = hitboxPersonagem.y - areaHitbox;
            areaDeAtaque.y = hitboxPersonagem.y + hitboxPersonagem.height / 2 -  areaHitbox / 2 ;

        }
        if (lado == "Esquerda") {
            areaDeAtaque.x = hitboxPersonagem.y - areaHitbox;
            areaDeAtaque.y = hitboxPersonagem.y + hitboxPersonagem.height / 2  - areaHitbox / 2;

        }
        if (lado == "Cima") {
            areaDeAtaque.x = hitboxPersonagem.x + hitboxPersonagem.width / 2  -  areaHitbox / 2;
            areaDeAtaque.y = hitboxPersonagem.y - areaHitbox;

        }
        if (lado == "Baixo") {
            
            areaDeAtaque.x = hitboxPersonagem.x + hitboxPersonagem.width / 2 -  areaHitbox / 2;
            areaDeAtaque.y = hitboxPersonagem.y + areaHitbox;
            
        }
            
            /*
            bs = acessar.getJogo().getTela().pegarCanvas().getBufferStrategy();
            Graphics grafico;
            grafico = bs.getDrawGraphics();      
            grafico.setColor(Color.RED);
            grafico.fillRect((int) (x + areaDeAtaque.x - acessar.pegarCamera().getX()), (int) (y + areaDeAtaque.y - acessar.pegarCamera().getY()),
              areaDeAtaque.width, areaDeAtaque.height);
*/
        }
        
        else
        {
            return;
        }
        
        for(int i =0; i< acessar.pegarMundo().getGerarEntidades().getObjetosEntity().size();i++)
        {
            Entity teste = acessar.pegarMundo().getGerarEntidades().getObjetosEntity().get(i);
            if(teste == this)
            {
                continue;
            }
            if(teste.hitboxRetangulo(0f, 0f).intersects(areaDeAtaque))
            {
                System.out.println("caiu4");
                System.out.println(teste);
                teste.atacar(10);
                return; 
            }
        }
        
    }

    private String pegarEntradas()
    {
        monstroPositionX = 0;
        monstroPositionY = 0;
        Boolean validate = false;
        String posicao = "";
        if(acessar.pegarTeclado().w)
        {
            validate = true;
            monstroPositionY = -velocidade;
            posicao = "Cima";
        }
         if(acessar.pegarTeclado().a)
        {
            validate = true;
            monstroPositionX = -velocidade;
            posicao = "Esquerda";
        }
        if(acessar.pegarTeclado().s)
        {
            validate = true;
            monstroPositionY = +velocidade;
            posicao = "Baixo";
        }
        if(acessar.pegarTeclado().d)
        {
            validate = true;
            monstroPositionX = +velocidade;
            posicao = "Direita";
        }
        if(validate == false)
        {
            return "Cima";
        }
        else
        {
            return posicao;
        }
        
    }
    
   
    @Override
    public void renderizar(Graphics grafico) {
        grafico.drawImage(CarregarImagens.jogador, (int) (x - acessar.pegarCamera().getX()), (int) (y - acessar.pegarCamera().getY()), largura , altura , null);
        grafico.setColor(Color.RED);
        // se não somar o x com a hitbox a hitbox vai ficar colada longe do personagem
        // o mesmo vale para o y
        grafico.fillRect((int) (x + hitboxObjetos.x - acessar.pegarCamera().getX()), (int) (y + hitboxObjetos.y - acessar.pegarCamera().getY()),
              hitboxObjetos.width, hitboxObjetos.height);
        
    }

    @Override
    public void Morrer() {
        System.out.println("morreu");
    }
    

}
