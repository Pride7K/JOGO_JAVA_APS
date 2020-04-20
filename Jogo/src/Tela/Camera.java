
package Tela;

import Entities.Entity;
import Inicializador.Acessar;
import Inicializador.Jogo;

/**
 *
 * @author gsant
 */
public class Camera {
    
    private float x,y; 
    private Acessar acessar;
    
    public Camera(Acessar acessar,float x , float y)
    {
        this.acessar = acessar;
        this.x = x;
        this.y = y;
    }

    public void centralizar(Entity personagem)
    {
        // centralizar camera no player
        x = personagem.getX() - acessar.pegarLargura() / 2 + personagem.getLargura()/ 2;
        y = personagem.getY() - acessar.pegarAltura() / 2 + personagem.getAltura()/ 2;
    }
    
    public void mover(float x2,float y2 )
    {
        x +=x2;
        y +=y2;
    }
    
    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
}
