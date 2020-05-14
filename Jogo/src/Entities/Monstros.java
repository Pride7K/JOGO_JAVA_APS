package Entities;

import Imagem.TransformarEmBuffered;
import Imagem.CarregarImagens;
import static Imagem.CarregarImagens.cortarImagem;
import Inicializador.Acessar;
import Inicializador.Jogo;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

public abstract class Monstros extends Entity {

    // final é como const do javascript
    public static final float velocidade_padrao = 7;
    public static final int largura_padrao = 50;
    public static final int altura_padrao = 50;
    protected Acessar acessar;
    protected float monstroPositionX;
    protected float monstroPositionY;

    private Inimigo inimigoT;
    private CarregarImagens imagens;

    private int mover = 1;
    private int moverBot = 1;

    private float lastX;
    private float lastY;

    protected int vida;
    protected float velocidade;

    public float testeX;

    public Monstros(Acessar acessar, float x, float y, int altura, int largura) {
        // esse super ira passar os parametros para a classe estendida
        super(acessar, x, y, altura, largura);
        this.acessar = acessar;
        velocidade = velocidade_padrao;
        monstroPositionX = 0;
        monstroPositionY = 0;
    }

    /*
    public void mover()
    {
        x+=monstroPositionX;
        y+=monstroPositionY;
    }
     */
    public void Mover(Jogador jogador) {
        if (!esbarrouComObjeto(monstroPositionX, 0f)) {
            MoverPosicaoX(jogador);
            //System.out.println("Jogador X = " + monstroPositionX);
        }
        if (!esbarrouComObjeto(0f, monstroPositionY)) {
            MoverPosicaoY(jogador);
            //System.out.println("Jogador Y = " + jogador.y);
        }
    }

    public void Mover(Pessoas pessoa) {
        if (!esbarrouComObjeto(monstroPositionX, 0f)) {

            for (int i = 0; i < acessar.pegarMundo().getGerarEntidades().getObjetosEntity().size(); i++) {
                Entity teste = acessar.pegarMundo().getGerarEntidades().getObjetosEntity().get(i);
                if (teste.isPlayer == true) {
                    float longitudeX1 = teste.x - pessoa.x;
                    float latitudeY1 = teste.y - pessoa.y;
                    if (pessoa.x != teste.x) {
                        MoverPosicaoX(pessoa, teste, longitudeX1);
                    }
                }
            }

        } else {
            float testeX = monstroPositionX - 1;
            System.out.println("caiu no else o X lol");
            if (!esbarrouComObjeto(testeX, 0f)) {
                pessoa.x = monstroPositionX - 1;
                System.out.println("X batendo na Esquerda");
            } else {
                testeX = monstroPositionX+ 1;
                if (!esbarrouComObjeto(testeX, 0f)) {
                    pessoa.x = monstroPositionX + 1;
                } else {
                    //System.out.println("X batendo na direita");
                }
            }
        }
        if (!esbarrouComObjeto(0f, monstroPositionY)) {
            for (int i = 0; i < acessar.pegarMundo().getGerarEntidades().getObjetosEntity().size(); i++) {
                Entity teste = acessar.pegarMundo().getGerarEntidades().getObjetosEntity().get(i);
                if (teste.isPlayer == true) {
                    float longitudeX1 = teste.x - pessoa.x;
                    float latitudeY1 = teste.y - pessoa.y;
                    if (pessoa.y != teste.y) {
                        MoverPosicaoY(pessoa, teste, latitudeY1);
                    }
                }

            }
        } else {
            float testeY = monstroPositionY+ 1;
            System.out.println("caiu no else o Y lol");
            if (!esbarrouComObjeto(testeY, 0f)) {
                pessoa.y = monstroPositionY+ 1;
                System.out.println("Y Cima");
            } else {
                testeY = monstroPositionY - 1;
                if (!esbarrouComObjeto(testeY, 0f)) {
                    pessoa.y = monstroPositionY - 1;
                } else {
                    //System.out.println("Y Baixo");
                }
            }
        }
    }

    public void Mover(Inimigo inimigo) {
        if (!esbarrouComObjeto(monstroPositionX, 0f)) {
            for (int i = 0; i < acessar.pegarMundo().getGerarEntidades().getObjetosEntity().size(); i++) {
                Entity teste = acessar.pegarMundo().getGerarEntidades().getObjetosEntity().get(i);
                if (teste.isBot == true && teste.possoAtacar == true) {
                    float longitudeX1 = teste.x - inimigo.x;
                    float latitudeY1 = teste.y - inimigo.y;
                    if (inimigo.x != teste.x) {
                        MoverPosicaoX(inimigo, teste, longitudeX1);
                    }
                }
            }
        }
        if (!esbarrouComObjeto(0f, monstroPositionY)) {
            for (int i = 0; i < acessar.pegarMundo().getGerarEntidades().getObjetosEntity().size(); i++) {
                Entity teste = acessar.pegarMundo().getGerarEntidades().getObjetosEntity().get(i);
                if (teste.isBot == true && teste.possoAtacar == true) {
                    float longitudeX1 = teste.x - inimigo.x;
                    float latitudeY1 = teste.y - inimigo.y;
                    if (inimigo.y != teste.y) {
                        MoverPosicaoY(inimigo, teste, latitudeY1);
                    }
                }
            }
        }

    }

    public void MoverPosicaoX(Pessoas pessoa, Entity jogador, float longitudeX1) {

        if (longitudeX1 <= 0) {
            int hitboxX = (int) (x + monstroPositionX + hitboxObjetos.x + hitboxObjetos.width) / Texturas.Texturas_Mundo.largura_textura;
            if (colidiuTextura(hitboxX, (int) (y + hitboxObjetos.y) / Texturas.Texturas_Mundo.altura_textura) == false && colidiuTextura(hitboxX, (int) (y + hitboxObjetos.y + hitboxObjetos.height) / Texturas.Texturas_Mundo.altura_textura) == false) {
                if (moverBot == 4) {
                    moverBot = 2;
                } else {
                    moverBot++;
                }
                //atualizarSprite(moverBot, "Esquerda", pessoa);
                pessoa.x = pessoa.x + 2;
            }
        } else if (longitudeX1 >= 0) {
            int hitboxX = (int) (x + monstroPositionX + hitboxObjetos.x) / Texturas.Texturas_Mundo.largura_textura;
            if (colidiuTextura(hitboxX, (int) (y + hitboxObjetos.y) / Texturas.Texturas_Mundo.altura_textura) == false && colidiuTextura(hitboxX, (int) (y + hitboxObjetos.y + hitboxObjetos.height) / Texturas.Texturas_Mundo.altura_textura) == false) {
                pessoa.x = pessoa.x - 2;
                if (moverBot == 4) {
                    moverBot = 1;
                } else {
                    moverBot++;
                }
                //atualizarSprite(moverBot, "Direita", pessoa);   
            }
        }

    }

    public void MoverPosicaoY(Pessoas pessoa, Entity jogador, float latitudeY1) {

        if (latitudeY1 <= 0) {
            int hitboxY = (int) (y + monstroPositionY + hitboxObjetos.y + hitboxObjetos.height) / Texturas.Texturas_Mundo.altura_textura;
            //System.out.println(hitboxX);
            if (colidiuTextura((int) (x + hitboxObjetos.x) / Texturas.Texturas_Mundo.largura_textura, hitboxY) == false) {

                if (moverBot == 4) {
                    moverBot = 1;
                } else {
                    moverBot++;
                }
                pessoa.y = pessoa.y + 2;
            }
        } else if (latitudeY1 >= 0) {
            int hitboxY = (int) (y + monstroPositionY + hitboxObjetos.y) / Texturas.Texturas_Mundo.altura_textura;
            //System.out.println(hitboxX);
            if (colidiuTextura((int) (x + hitboxObjetos.x) / Texturas.Texturas_Mundo.largura_textura, hitboxY) == false) {
                if (moverBot == 4) {
                    moverBot = 1;
                } else {
                    moverBot++;
                }
                //atualizarSprite(moverBot, "Baixo", pessoa);
                pessoa.y = pessoa.y - 2;
            }
        }

    }

    public void MoverPosicaoX(Inimigo inimigo, Entity jogador, float longitudeX1) {
        //System.out.println("caiu");
        //System.out.println(inimigo.x);

        if (longitudeX1 <= 0) {
            int hitboxX = (int) (x + monstroPositionX + hitboxObjetos.x + hitboxObjetos.width) / Texturas.Texturas_Mundo.largura_textura;
            if (colidiuTextura(hitboxX, (int) (y + hitboxObjetos.y) / Texturas.Texturas_Mundo.altura_textura) == false && colidiuTextura(hitboxX, (int) (y + hitboxObjetos.y + hitboxObjetos.height) / Texturas.Texturas_Mundo.altura_textura) == false) {
                inimigo.x = inimigo.x - 1;
            }
        } else if (longitudeX1 >= 0) {
            int hitboxX = (int) (x + monstroPositionX + hitboxObjetos.x) / Texturas.Texturas_Mundo.largura_textura;
            if (colidiuTextura(hitboxX, (int) (y + hitboxObjetos.y) / Texturas.Texturas_Mundo.altura_textura) == false && colidiuTextura(hitboxX, (int) (y + hitboxObjetos.y + hitboxObjetos.height) / Texturas.Texturas_Mundo.altura_textura) == false) {
                inimigo.x = inimigo.x + 1;
            }
        }
        /*
        if (longitudeX1 <= 0) {
            inimigo.x = inimigo.x - 2;
        } else if (longitudeX1 >= 0) {
            inimigo.x = inimigo.x + 2;
        }
         */
    }

    public void MoverPosicaoY(Inimigo inimigo, Entity jogador, float latitudeY1) {

        if (latitudeY1 <= 0) {
            int hitboxY = (int) (y + monstroPositionY + hitboxObjetos.y + hitboxObjetos.height) / Texturas.Texturas_Mundo.altura_textura;
            //System.out.println(hitboxX);
            if (colidiuTextura((int) (x + hitboxObjetos.x) / Texturas.Texturas_Mundo.largura_textura, hitboxY) == false) {
                inimigo.y = inimigo.y - 1;
            }
        } else if (monstroPositionY >= 0) {
            int hitboxY = (int) (y + monstroPositionY + hitboxObjetos.y) / Texturas.Texturas_Mundo.altura_textura;
            //System.out.println(hitboxX);
            if (colidiuTextura((int) (x + hitboxObjetos.x) / Texturas.Texturas_Mundo.largura_textura, hitboxY) == false) {
                inimigo.y = inimigo.y + 1;
            }
        }
        /*
        //System.out.println(latitudeY1);
        if (latitudeY1 <= 0) {
            inimigo.y = inimigo.y - 2;
        } else if (latitudeY1 >= 0) {
            inimigo.y = inimigo.y + 2;
        }
         */
    }

    public void MoverPosicaoX(Jogador jogador) {
        // se for maior que 0 quer dizer que esta se movendo para a direita
        // se for menor que 0 esta indo para a esquerda
        if (monstroPositionX > 0) {
            // conta para pegar o ultimo x da hitbox para assim saber se esta colidindo depois
            // x + monstroPositionX + hitboxPersonagem.x + hitboxPersonagem.width == lado direito do personagem
            // dividi pela largura da textura para obter um valor em tamanho de textura
            //System.out.println(x);
            //System.out.println(monstroPositionX);
            //System.out.println(hitboxPersonagem.width);
            int hitboxX = (int) (x + monstroPositionX + hitboxObjetos.x + hitboxObjetos.width) / Texturas.Texturas_Mundo.largura_textura;
            //System.out.println(hitboxX);
            if (colidiuTextura(hitboxX, (int) (y + hitboxObjetos.y) / Texturas.Texturas_Mundo.altura_textura) == false && colidiuTextura(hitboxX, (int) (y + hitboxObjetos.y + hitboxObjetos.height) / Texturas.Texturas_Mundo.altura_textura) == false) {
                x = x + monstroPositionX;
                if (mover == 4) {
                    mover = 1;
                } else {
                    mover++;
                }
                atualizarSprite(mover, "Direita", jogador);
            }
        } else if (monstroPositionX < 0) {
            // x + monstroPositionX + hitboxPersonagem.x  == lado esquerdo do personagem
            int hitboxX = (int) (x + monstroPositionX + hitboxObjetos.x) / Texturas.Texturas_Mundo.largura_textura;
            if (colidiuTextura(hitboxX, (int) (y + hitboxObjetos.y) / Texturas.Texturas_Mundo.altura_textura) == false && colidiuTextura(hitboxX, (int) (y + hitboxObjetos.y + hitboxObjetos.height) / Texturas.Texturas_Mundo.altura_textura) == false) {
                x = x + monstroPositionX;
                if (mover == 4) {
                    mover = 1;
                } else {
                    mover++;
                }
                atualizarSprite(mover, "Esquerda", jogador);
            }
        }

    }

    public void atualizarSprite(int mover, String lado, Pessoas pessoa) {
        String caminho = System.getProperty("user.dir");
        if (lado == "Direita") {
            BufferedImage sprite = (TransformarEmBuffered.carregaImg(caminho + "\\coisas\\images\\Pessoas\\direito.png"));
            imagens.pessoas = cortarImagem(0, 0, 40, 53, sprite);
        }
        if (lado == "Esquerda") {
            BufferedImage sprite = (TransformarEmBuffered.carregaImg(caminho + "\\coisas\\images\\Pessoas\\direito.png"));
            imagens.pessoas = cortarImagem(0, 0, 40, 53, sprite);
        }
        if (lado == "Cima") {
            BufferedImage sprite = (TransformarEmBuffered.carregaImg(caminho + "\\coisas\\images\\Pessoas\\direito.png"));
            imagens.pessoas = cortarImagem(0, 0, 40, 53, sprite);
        }
        if (lado == "Baixo") {

            BufferedImage sprite = (TransformarEmBuffered.carregaImg(caminho + "\\coisas\\images\\Pessoas\\direito.png"));
            imagens.pessoas = cortarImagem(0, 0, 40, 53, sprite);
        }
    }

    public void atualizarSprite(int mover, String lado, Jogador jogador) {
        String caminho = System.getProperty("user.dir");
        //System.out.println(caminho);
        if (lado == "Direita") {
            //System.out.println("caiu lol");
            //System.out.println(mover);
            BufferedImage sprite = (TransformarEmBuffered.carregaImg(caminho + "\\coisas\\images\\Jogador\\detetive_andando_direita_" + mover + ".png"));
            imagens.jogador = cortarImagem(0, 0, 27, 42, sprite);
        }
        if (lado == "Esquerda") {
            //System.out.println("caiu lol");
            //System.out.println(mover);
            BufferedImage sprite = (TransformarEmBuffered.carregaImg(caminho + "\\coisas\\images\\Jogador\\detetive__andando_esquerda_" + mover + ".png"));
            imagens.jogador = cortarImagem(0, 0, 27, 42, sprite);
        }
        if (lado == "Cima") {
            //System.out.println("caiu lol");
            //System.out.println(mover);
            BufferedImage sprite = (TransformarEmBuffered.carregaImg(caminho + "\\coisas\\images\\Jogador\\detetive_andando_de_costas_" + mover + ".png"));
            imagens.jogador = cortarImagem(0, 0, 27, 42, sprite);
        }
        if (lado == "Baixo") {
            //System.out.println("caiu lol");
            //System.out.println(mover);
            BufferedImage sprite = (TransformarEmBuffered.carregaImg(caminho + "\\coisas\\images\\Jogador\\detetive_andando_pra_frente_" + mover + ".png"));
            imagens.jogador = cortarImagem(0, 0, 27, 42, sprite);
        }
    }

    public void MoverPosicaoY(Jogador jogador) {
        if (monstroPositionY > 0) {
            int hitboxY = (int) (y + monstroPositionY + hitboxObjetos.y + hitboxObjetos.height) / Texturas.Texturas_Mundo.altura_textura;
            //System.out.println(hitboxX);
            if (colidiuTextura((int) (x + hitboxObjetos.x) / Texturas.Texturas_Mundo.largura_textura, hitboxY) == false) {
                y = y + monstroPositionY;
                if (mover == 4) {
                    mover = 1;
                } else {
                    mover++;
                }
                atualizarSprite(mover, "Baixo", jogador);
            }
        } else if (monstroPositionY < 0) {
            int hitboxY = (int) (y + monstroPositionY + hitboxObjetos.y) / Texturas.Texturas_Mundo.altura_textura;
            //System.out.println(hitboxX);
            if (colidiuTextura((int) (x + hitboxObjetos.x) / Texturas.Texturas_Mundo.largura_textura, hitboxY) == false) {
                y = y + monstroPositionY;
                if (mover == 4) {
                    mover = 1;
                } else {
                    mover++;
                }
                atualizarSprite(mover, "Cima", jogador);
            }
        }
    }

    public boolean colidiuTextura(int x, int y) {
        return acessar.pegarMundo().pegarTextura(x, y).naoPossoEsbarrar();
    }

    public float getMonstroPositionX() {
        return monstroPositionX;
    }

    public void setMonstroPositionX(float monstroPositionX) {
        this.monstroPositionX = monstroPositionX;
    }

    public float getMonstroPositionY() {
        return monstroPositionY;
    }

    public void setMonstroPositionY(float monstroPositionY) {
        this.monstroPositionY = monstroPositionY;
    }

    public int getVida() {
        return vida;
    }

    public float getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(float velocidade) {
        this.velocidade = velocidade;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

}
