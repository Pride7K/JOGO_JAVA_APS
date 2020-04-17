package Imagem;

import java.awt.image.BufferedImage;

public class SuaviazarCarregamentoImagem {
    
    private static final int largura = 32;
    private static final int altura = 32;
    
    public static BufferedImage jogador,pedra,mapaCompleto,parede,pedacoMapa,tijolo;
    
    public static void init()
    {
        Sprite sprite = new Sprite(CarregarImagem.carregaImg("C:\\Users\\gsant\\Desktop\\APS_JAVA\\Jogo\\coisas\\images\\teste2.png"));
        Sprite mapaSprite = new Sprite(CarregarImagem.carregaImg("C:\\Users\\gsant\\Desktop\\APS_JAVA\\Jogo\\coisas\\images\\mapa.png"));
        Sprite paredeSprite = new Sprite(CarregarImagem.carregaImg("C:\\Users\\gsant\\Desktop\\APS_JAVA\\Jogo\\coisas\\images\\parede.png"));
        Sprite pedacoMapaSprite = new Sprite(CarregarImagem.carregaImg("C:\\Users\\gsant\\Desktop\\APS_JAVA\\Jogo\\coisas\\images\\tile_mapa.png"));
        Sprite tijoloSprite = new Sprite(CarregarImagem.carregaImg("C:\\Users\\gsant\\Desktop\\APS_JAVA\\Jogo\\coisas\\images\\tijolo.png"));
        Sprite pedraSprite = new Sprite(CarregarImagem.carregaImg("C:\\Users\\gsant\\Desktop\\APS_JAVA\\Jogo\\coisas\\images\\pedra.jpg"));
        jogador = sprite.cortarImagem(largura, 0, largura, altura);
        mapaCompleto = mapaSprite.cortarImagem(0, 0, 720, 797);
        parede = paredeSprite.cortarImagem(0,0, 77, 53);
        pedacoMapa = pedacoMapaSprite.cortarImagem(0, 0, 15, 15);
        tijolo = tijoloSprite.cortarImagem(0, 0, 522, 451);
        pedra = pedraSprite.cortarImagem(0, 0, 236, 236);
    }
}
