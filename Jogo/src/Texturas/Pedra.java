/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Texturas;

import Imagem.CarregarImagens;
import java.awt.image.BufferedImage;

/**
 *
 * @author gsant
 */
public class Pedra extends Texturas{
    
    public Pedra(int id) {
        super(CarregarImagens.pedra, id);
    }
    
    @Override
    public boolean naoPossoEsbarrar()
    {
        return true;
    }
}
