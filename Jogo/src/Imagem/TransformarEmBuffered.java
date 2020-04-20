
package Imagem;

import com.sun.javafx.iio.ImageLoader;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class TransformarEmBuffered {
    public static BufferedImage carregaImg(String caminho)
    {
        try
        {
          return ImageIO.read(new File(caminho));   
        }
        catch(IOException e)
        {
            e.printStackTrace();
            // finalizar o jogo se a imagem não carregar
            System.exit(1);
        }
        return null;
    }
}
