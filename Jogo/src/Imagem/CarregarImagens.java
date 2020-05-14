package Imagem;

import java.awt.image.BufferedImage;

public class CarregarImagens {
    
    private static final int largura = 32;
    private static final int altura = 32;
    
    public static BufferedImage jogador,pedra,mapaCompleto,parede,pedacoMapa,tijolo,arvore,teste1,inimigo,casa,grama,gramaComTrilha,terra,pedrona,pedronaInvertida,pessoas;
    
    public static void init()
    {
        String caminho = System.getProperty("user.dir");
        BufferedImage pedacoMapaImage = (TransformarEmBuffered.carregaImg(caminho + "\\coisas\\images\\tile_mapa.png"));
        BufferedImage tijoloImage = (TransformarEmBuffered.carregaImg(caminho + "\\coisas\\images\\tijolo.png"));
        BufferedImage pedraImage = (TransformarEmBuffered.carregaImg(caminho + "\\coisas\\images\\pedra.jpg"));
        BufferedImage arvoreImage = (TransformarEmBuffered.carregaImg(caminho + "\\coisas\\images\\arvore.png"));
        BufferedImage casaImage = (TransformarEmBuffered.carregaImg(caminho + "\\coisas\\images\\casa.png"));
        BufferedImage jogadorImage = (TransformarEmBuffered.carregaImg(caminho + "\\coisas\\images\\Jogador\\detetive_andando_direita_1.png"));
        BufferedImage inimigoImage = (TransformarEmBuffered.carregaImg(caminho + "\\coisas\\images\\Inimigo\\baixo1.png"));
        BufferedImage gramaImage = (TransformarEmBuffered.carregaImg(caminho + "\\coisas\\images\\grama2.png"));
        BufferedImage pedronaImage = (TransformarEmBuffered.carregaImg(caminho + "\\coisas\\images\\pedrona.png"));
        BufferedImage pedronaInvertidaImage = (TransformarEmBuffered.carregaImg(caminho + "\\coisas\\images\\pedrona2.png"));
        BufferedImage gramaComTrilhaImage = (TransformarEmBuffered.carregaImg(caminho + "\\coisas\\images\\grama.jpg"));
        BufferedImage terraImage = (TransformarEmBuffered.carregaImg(caminho + "\\coisas\\images\\terra.png"));
        BufferedImage pessoasImage = (TransformarEmBuffered.carregaImg(caminho + "\\coisas\\images\\Pessoas\\frente.png"));
        arvore = cortarImagem(0, 0, 500, 500,arvoreImage);
        jogador = cortarImagem(0, 0, 27, 42,jogadorImage);
        pedacoMapa = cortarImagem(0, 0, 15, 15,pedacoMapaImage);
        tijolo = cortarImagem(0, 0, 522, 451,tijoloImage);
        pedra = cortarImagem(0, 0, 236, 236,pedraImage);
        inimigo = cortarImagem(0, 0, 500, 500,inimigoImage);
        pessoas = cortarImagem(0, 0, 40, 53,pessoasImage);
        casa = cortarImagem(0, 0, 768, 1140,casaImage);
        terra = cortarImagem(0, 0, 207, 210,terraImage);
        pedrona = cortarImagem(0, 0, 540, 462,pedronaImage);
        pedronaInvertida = cortarImagem(0, 0, 540, 462,pedronaInvertidaImage);
        grama = cortarImagem(0, 0, 227, 249,gramaImage);
        gramaComTrilha = cortarImagem(0, 0, 512, 512,gramaComTrilhaImage);
    }
    
    public static BufferedImage cortarImagem(int x, int y, int largura,int altura,BufferedImage sheet)
    {
        // isso vai retornar a minha imagem cortada
        return sheet.getSubimage(x, y, largura, altura);
    }
    
}
