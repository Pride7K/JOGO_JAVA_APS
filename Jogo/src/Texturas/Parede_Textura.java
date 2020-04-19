/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Texturas;

import Imagem.SuaviazarCarregamentoImagem;
import java.awt.image.BufferedImage;

/**
 *
 * @author gsant
 */
public class Parede_Textura extends Texturas {
    
    public Parede_Textura(int id) {
        super(SuaviazarCarregamentoImagem.parede, id);
    }
    
    public boolean possoEsbarrar()
    {
        return true;
    }
    
}
