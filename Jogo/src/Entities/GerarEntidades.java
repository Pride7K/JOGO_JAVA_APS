/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import Inicializador.Acessar;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author gsant
 */
public class GerarEntidades {
    private Acessar acessar;
    private Jogador jogador;
    private ArrayList<Entity> ObjetosEntity;
    
    public GerarEntidades(Acessar acessar,Jogador jogados)         
    {
        this.jogador = jogados;
        this.acessar = acessar;
        ObjetosEntity = new ArrayList<Entity>();
    }
    
    public void atualizar()
    {
        for(int i =0;i < ObjetosEntity.size();i++)
        {
            Entity entidade = ObjetosEntity.get(i);
            System.out.println(entidade);
            entidade.atualizar();
        }
        jogador.atualizar();
    }


    
    public Acessar getAcessar() {
        return acessar;
    }

    public void setAcessar(Acessar acessar) {
        this.acessar = acessar;
    }

    public Jogador getJogador() {
        return jogador;
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }

    public ArrayList<Entity> getObjetosEntity() {
        return ObjetosEntity;
    }

    public void setObjetosEntity(ArrayList<Entity> ObjetosEntity) {
        this.ObjetosEntity = ObjetosEntity;
    }
    
    public void renderizar(Graphics grafico)
    {
        for(int i =0;i < ObjetosEntity.size();i++)
        {
            Entity entidade = ObjetosEntity.get(i);
            entidade.renderizar(grafico);
        }
        jogador.renderizar(grafico);
    }
    
    public void adicionarObjeto(Entity objeto)           
    {
        ObjetosEntity.add(objeto);
    }
    
    
    
}
