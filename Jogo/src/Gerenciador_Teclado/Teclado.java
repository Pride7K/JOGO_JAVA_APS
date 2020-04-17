
package Gerenciador_Teclado;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

// implements KeyListener para ter acesso aos metodos dessa classe e atributos
public class Teclado implements KeyListener {

    public boolean[] teclas;
    public boolean a,w,s,d;
    
    public void atualizar()
    {
        // passando as posiçoes do array de cada tecla
        a = teclas[KeyEvent.VK_A];
        w = teclas[KeyEvent.VK_W];
        s = teclas[KeyEvent.VK_S];
        d = teclas[KeyEvent.VK_D];
        
    }
    
    public Teclado()
    {
        //array de todas as teclas
        teclas = new boolean[256];
    }
    
    // quando apertar uma tecla cai aqui
    @Override
    public void keyTyped(KeyEvent e) {
        //pegar o id da tecla que foi apertada e setar como true
        //System.out.println(e.getKeyChar());
    }
    
    // quando soltar a tecla cai aqui
    @Override
    public void keyPressed(KeyEvent e) {
        //pegar o id da tecla que foi apertada e setar como false
        //System.out.println(e.getKeyChar());
        teclas[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
       teclas[e.getKeyCode()] = false;
    }
    
}
