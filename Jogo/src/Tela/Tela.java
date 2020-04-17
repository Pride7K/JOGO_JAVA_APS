/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tela;

import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author gsant
 */
public class Tela {
    
    private JFrame tela;
    private Canvas canvas;
    
    private String titulo;
    private int largura;
    private int altura;
    
    public  Tela (String titulo,int largura,int altura)
    {
        this.titulo = titulo;
        this.largura = largura;
        this.altura = altura;
        
        criarTela();
        
    }
    
    private  void criarTela()
    {
            tela = new JFrame(titulo);
            tela.setSize(altura, largura);
            tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            tela.setResizable(false);
            tela.setLocationRelativeTo(null);
            tela.setVisible(true);
            
            canvas = new Canvas();
            canvas.setPreferredSize(new Dimension(altura, largura));
            canvas.setMaximumSize(new Dimension(altura, largura));
            canvas.setMinimumSize(new Dimension(altura, largura));
            // se não setar como false vai bugar o teclado
            canvas.setFocusable(false);
            
            tela.add(canvas);
            tela.pack();
            
    }
    
    public Canvas pegarCanvas()
    {
        return canvas;
    }
    public JFrame pegarTela()
    {
        return tela;
    }
    
}
