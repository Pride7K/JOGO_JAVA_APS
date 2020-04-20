/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paginas;

import Imagem.CarregarImagens;
import Inicializador.Acessar;
import Inicializador.Jogo;
import java.awt.Graphics;

/**
 *
 * @author gsant
 */
public class MenuPagina extends Metodos{

    public MenuPagina(Acessar acessar)
    {
        super(acessar);
    }
    @Override
    public void atualizar() {
    }

    @Override
    public void renderizar(Graphics graficos) {
       // graficos.drawImage(SuaviazarCarregamentoImagem.imagem2, 0, 0, null);
    }
    
}
