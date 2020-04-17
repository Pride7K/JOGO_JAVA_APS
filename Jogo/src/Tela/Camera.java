
package Tela;

import Entities.Entity;
import Inicializador.Jogo;

/**
 *
 * @author gsant
 */
public class Camera {
    
    private float x,y; 
    private Jogo jogo;
    
    public Camera(Jogo jogo,float x , float y)
    {
        this.jogo = jogo;
        this.x = x;
        this.y = y;
    }

    public void centralizar(Entity personagem)
    {
        // centralizar camera no player
        x = personagem.getX() - jogo.pegarLargura() / 2 + personagem.getLargura()/ 2;
        y = personagem.getY() - jogo.pegarAltura() / 2 + personagem.getAltura()/ 2;
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
