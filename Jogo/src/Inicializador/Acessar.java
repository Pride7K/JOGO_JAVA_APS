/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inicializador;

import Entities.GerarObjetos_No_Mapa;
import Gerenciador_Entradas.Mouse;
import Gerenciador_Entradas.Teclado;
import Tela.Camera;
import Texturas.Mundo;

/**
 *
 * @author gsant
 */
public class Acessar {
    
    private Jogo jogo;
    private Mundo mundo;
    
    
    public Mundo pegarMundo() {
        return mundo;
    }
    

    public void setarMundo(Mundo mundo) {
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
    
    public Mouse pegarMouse()
    {
        return jogo.getMouse();
    }
    
    public Mouse setarMouse()
    {
        return jogo.getMouse();
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
