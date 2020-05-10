/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import Inicializador.Acessar;

/**
 *
 * @author gsant
 */
public abstract class EntityParaObjetosStaticos extends Entity {
    
    public EntityParaObjetosStaticos(Acessar acessar, float x, float y, int largura, int altura) {
        super(acessar, x, y, largura, altura);
    }
    
}
