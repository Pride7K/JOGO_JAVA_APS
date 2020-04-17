
package Imagem;

import java.awt.image.BufferedImage;

public class Sprite {
    
    private BufferedImage sheet;
    
    public Sprite(BufferedImage sheet)
    {
        this.sheet = sheet;
    }
    
    public BufferedImage cortarImagem(int x, int y, int largura,int altura)
    {
        // isso vai retornar a minha imagem cortada
        return sheet.getSubimage(x, y, largura, altura);
    }
    
}
