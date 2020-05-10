
package Paginas;

// extendes para herdar as classes e metodos que tem dentro de Metodos

import Entities.Jogador;
import Imagem.CarregarImagens;
import Inicializador.Acessar;
import Inicializador.Jogo;
import Texturas.Mundo;
import Texturas.Texturas_Mundo;
import java.awt.Graphics;

public class JogoPagina extends Metodos {

    //private Jogador jogador;
    private Mundo mundo;
    public JogoPagina(Acessar acessar)
    {
        super(acessar);
        mundo = new Mundo(acessar,"C:\\Users\\gsant\\Desktop\\APS_JAVA\\Jogo\\src\\Texturas\\GerarMundo.txt");
        acessar.setarMundo(mundo);
        //mundo = new Plano_Fundo(acessar.getJogo(),"C:\\Users\\gsant\\Desktop\\APS_JAVA\\Jogo\\src\\Texturas\\GerarMundo.txt");
        
    }
     
    @Override
    public void atualizar() {
        //System.out.println("caiu");
        mundo.atualizar();
        //acessar.pegarCamera().centralizar(jogador);
        //jogo.pegarCamera().mover(1, 1);
    }

    @Override
    public void renderizar(Graphics graficos) {
        //graficos.drawImage(SuaviazarCarregamentoImagem.imagem1, 0, 0, null);
        //graficos.drawImage(SuaviazarCarregamentoImagem.mapa, 0, 0,720,720,null);
        mundo.renderizar(graficos);
        //Texturas.texturas[1].renderizar(graficos, 65, 53);
    }
    
}
