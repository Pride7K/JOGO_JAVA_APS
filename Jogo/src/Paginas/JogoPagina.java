
package Paginas;

// extendes para herdar as classes e metodos que tem dentro de Metodos

import Entities.Jogador;
import Imagem.SuaviazarCarregamentoImagem;
import Inicializador.Acessar;
import Inicializador.Jogo;
import Texturas.Plano_Fundo;
import Texturas.Texturas;
import java.awt.Graphics;

public class JogoPagina extends Metodos {

    private Jogador jogador;
    private Plano_Fundo mundo;
    public JogoPagina(Acessar acessar)
    {
        super(acessar);
        mundo = new Plano_Fundo(acessar,"C:\\Users\\gsant\\Desktop\\APS_JAVA\\Jogo\\src\\Texturas\\GerarMundo.txt");
        acessar.setarMundo(mundo);
        jogador = new Jogador(acessar,150,150);
        //mundo = new Plano_Fundo(acessar.getJogo(),"C:\\Users\\gsant\\Desktop\\APS_JAVA\\Jogo\\src\\Texturas\\GerarMundo.txt");
        
    }
     
    @Override
    public void atualizar() {
        //System.out.println("caiu");
        mundo.atualizar();
        jogador.atualizar();
        acessar.pegarCamera().centralizar(jogador);
        //jogo.pegarCamera().mover(1, 1);
    }

    @Override
    public void renderizar(Graphics graficos) {
        //graficos.drawImage(SuaviazarCarregamentoImagem.imagem1, 0, 0, null);
        //graficos.drawImage(SuaviazarCarregamentoImagem.mapa, 0, 0,720,720,null);
        mundo.renderizar(graficos);
        jogador.renderizar(graficos);
        //Texturas.texturas[1].renderizar(graficos, 65, 53);
    }
    
}
