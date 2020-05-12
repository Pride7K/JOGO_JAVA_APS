/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gerenciador_Entradas;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 *
 * @author gsant
 */
public class Mouse implements MouseListener,MouseMotionListener {

    
    private Boolean botaoEsquerdo;
    private int x,y;
    
    public boolean botaoEsquerdoFoiClicado()
    {
        return botaoEsquerdo;
    }

    public int getXMouse() {
        return x;
    }

    public void setXMouse(int x) {
        this.x = x;
    }

    public int getYMouse() {
        return y;
    }

    public void setYMouse(int y) {
        this.y = y;
    }
    
    public Mouse()
    {
        
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1)
        {
            botaoEsquerdo = true;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1)
        {
            botaoEsquerdo = false;
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
       
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        x = e.getX();
        y = e.getY();
    }
    
}
