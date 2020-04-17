package Entities;

import Imagem.SuaviazarCarregamentoImagem;
import Inicializador.Jogo;
import java.awt.Graphics;

public class Jogador extends Monstros {
    
    
    public Jogador(Jogo jogo,float x, float y) {
        super(jogo,x, y,Monstros.largura_padrao,Monstros.altura_padrao);
        // sem isso o jogo nao vai funcionar lol
        this.jogo = jogo;
    }

    @Override
    public void atualizar() {
        pegarEntradas();
        mover();
    }

    private void pegarEntradas()
    {
        monstroPositionX = 0;
        monstroPositionY = 0;
        
        if(jogo.pegarTeclado().w)
        {
            monstroPositionY = -velocidade;
        }
        if(jogo.pegarTeclado().a)
        {
            monstroPositionX = -velocidade;
        }
        if(jogo.pegarTeclado().s)
        {
            monstroPositionY = +velocidade;
        }
        if(jogo.pegarTeclado().d)
        {
            monstroPositionX = +velocidade;
        }
        
        
    }
   
    @Override
    public void renderizar(Graphics grafico) {
        grafico.drawImage(SuaviazarCarregamentoImagem.jogador, (int) (x - jogo.pegarCamera().getX()), (int) (y - jogo.pegarCamera().getY()), largura , altura , null);
    }

}
