package Entities;

import Imagem.CarregarImagens;
import Inicializador.Acessar;
import Inicializador.Jogo;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Jogador extends Monstros {
    
    
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
        pegarEntradas();
        Mover(this);
        acessar.pegarCamera().centralizar(this);
        possoAtacar();
    }
    
    private void possoAtacar()
    {
        Rectangle areaAoRedor = new Rectangle();
        int areaAoRedorArea = 20;
        areaAoRedor.width = 20;
        areaAoRedor.height = 20;
        
    }

    private void pegarEntradas()
    {
        monstroPositionX = 0;
        monstroPositionY = 0;
        
        if(acessar.pegarTeclado().w)
        {
            monstroPositionY = -velocidade;
        }
        if(acessar.pegarTeclado().a)
        {
            monstroPositionX = -velocidade;
        }
        if(acessar.pegarTeclado().s)
        {
            monstroPositionY = +velocidade;
        }
        if(acessar.pegarTeclado().d)
        {
            monstroPositionX = +velocidade;
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
