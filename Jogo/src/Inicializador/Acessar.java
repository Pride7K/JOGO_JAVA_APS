/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inicializador;

import Entities.GerarEntidades;
import Gerenciador_Teclado.Teclado;
import Tela.Camera;
import Texturas.Plano_Fundo;

/**
 *
 * @author gsant
 */
public class Acessar {
    
    private Jogo jogo;
    private Plano_Fundo mundo;

    
    public Plano_Fundo pegarMundo() {
        return mundo;
    }
    

    public void setarMundo(Plano_Fundo mundo) {
        this.mundo = mundo;
    }

    public Jogo getJogo() {
        return jogo;
    }

    public int pegarAltura()
    {
        return jogo.pegarAltura();
    }
    
    public Camera pegarCamera()
    {
        return jogo.pegarCamera();
    }
    
    public int pegarLargura()
    {
        return jogo.pegarLargura();
    }
    
    public Teclado pegarTeclado()
    {
        return jogo.pegarTeclado();
    }
    
    public void setJogo(Jogo jogo) {
        this.jogo = jogo;
    }
    
    public Acessar(Jogo jogo)
    {
        this.jogo = jogo;
    }
}
