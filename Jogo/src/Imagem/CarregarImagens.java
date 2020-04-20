package Imagem;

import java.awt.image.BufferedImage;

public class CarregarImagens {
    
    private static final int largura = 32;
    private static final int altura = 32;
    
    public static BufferedImage jogador,pedra,mapaCompleto,parede,pedacoMapa,tijolo,arvore,teste1;
    
    public static void init()
    {
        String caminho = System.getProperty("user.dir");
        BufferedImage pedacoMapaImage = (TransformarEmBuffered.carregaImg(caminho + "\\coisas\\images\\tile_mapa.png"));
        BufferedImage tijoloImage = (TransformarEmBuffered.carregaImg(caminho + "\\coisas\\images\\tijolo.png"));
        BufferedImage pedraImage = (TransformarEmBuffered.carregaImg(caminho + "\\coisas\\images\\pedra.jpg"));
        BufferedImage arvoreImage = (TransformarEmBuffered.carregaImg(caminho + "\\coisas\\images\\arvore.png"));
        BufferedImage jogadorImage = (TransformarEmBuffered.carregaImg(caminho + "\\coisas\\images\\Jogador\\detetive_andando_direita_1.png"));
        arvore = cortarImagem(0, 0, 500, 500,arvoreImage);
        jogador = cortarImagem(0, 0, 27, 42,jogadorImage);
        pedacoMapa = cortarImagem(0, 0, 15, 15,pedacoMapaImage);
        tijolo = cortarImagem(0, 0, 522, 451,tijoloImage);
        pedra = cortarImagem(0, 0, 236, 236,pedraImage);
        
    }
    
    public static BufferedImage cortarImagem(int x, int y, int largura,int altura,BufferedImage sheet)
    {
        // isso vai retornar a minha imagem cortada
        return sheet.getSubimage(x, y, largura, altura);
    }
    
}
