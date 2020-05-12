/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import Inicializador.Acessar;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author gsant
 */
public class GerarObjetos_No_Mapa {
    private Acessar acessar;
    private Jogador jogador;
    private ArrayList<Entity> ObjetosEntity;
    
    private Comparator<Entity> ordernarEntidades = new Comparator<Entity>() {
        
        // isso é para comparar o ponto Y entre duas entidades e evitar que as outras entidades
        // sobreponham a entidade de personagem
        @Override
        public int compare(Entity entidade1, Entity entidade2) {
            if(entidade1.getY() < entidade2.getY())
            {
                return -1;
            }
            else
            {
                return +1;
            }
        }
    };
    
    public GerarObjetos_No_Mapa(Acessar acessar,Jogador jogados)         
    {
        this.jogador = jogados;
        this.acessar = acessar;
        ObjetosEntity = new ArrayList<Entity>();
        
        adicionarObjeto(jogados);
    }
    
    public void atualizar()
    {
        for(int i =0;i < ObjetosEntity.size();i++)
        {
            Entity entidade = ObjetosEntity.get(i);
            //System.out.println(entidade);
            entidade.atualizar();
            if(entidade.personagemVivo == false)
            {
                ObjetosEntity.remove(entidade);
            }
        }
        //ObjetosEntity.sort(ordernarEntidades);
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
    }
    
    public void adicionarObjeto(Entity objeto)           
    {
        ObjetosEntity.add(objeto);
    }
    
    
    
}