package Texturas;

import Entities.Arvore;
import Entities.Casa;
import Entities.GerarObjetos_No_Mapa;
import Entities.Inimigo;
import Entities.Jogador;
import Entities.Pedrona;
import Entities.PedronaInvertida;
import Inicializador.Acessar;
import Inicializador.Jogo;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

public class Mundo {

    private int altura, largura;
    private int positionX, positionY;
    private int[][] planoFundo;
    private Acessar acessar;
    public int numeroSalvos = 0;
    public float tempoRestante = 60;
    
    
    public GerarObjetos_No_Mapa gerarEntidades;

    public Mundo(Acessar acessar, String caminho) {
        this.acessar = acessar;
        
        gerarEntidades = new GerarObjetos_No_Mapa(acessar,new Jogador(acessar,550,450));
        
        
        gerarEntidades.adicionarObjeto(new Arvore(acessar,2000,2189)); 
        gerarEntidades.adicionarObjeto(new Arvore(acessar,700,783)); 
        gerarEntidades.adicionarObjeto(new Arvore(acessar,1379,343)); 
        gerarEntidades.adicionarObjeto(new Arvore(acessar,1800,534)); 
        gerarEntidades.adicionarObjeto(new Arvore(acessar,450,789)); 
        gerarEntidades.adicionarObjeto(new Arvore(acessar,900,444)); 
        gerarEntidades.adicionarObjeto(new Arvore(acessar,1900,899)); 
        
        gerarEntidades.adicionarObjeto(new Casa(acessar,1789,1314)); 
        gerarEntidades.adicionarObjeto(new Casa(acessar,2350,632)); 
        gerarEntidades.adicionarObjeto(new Casa(acessar,2899,543)); 
        gerarEntidades.adicionarObjeto(new Casa(acessar,756,1732)); 
        gerarEntidades.adicionarObjeto(new Casa(acessar,890,322)); 
        
        
        gerarEntidades.adicionarObjeto(new Pedrona(acessar,1450,1550)); 
        gerarEntidades.adicionarObjeto(new Pedrona(acessar,1450,1650)); 
        gerarEntidades.adicionarObjeto(new Pedrona(acessar,1450,1750)); 
        gerarEntidades.adicionarObjeto(new Pedrona(acessar,1450,1850)); 
        gerarEntidades.adicionarObjeto(new Pedrona(acessar,1450,1950)); 
        gerarEntidades.adicionarObjeto(new Pedrona(acessar,1450,2050)); 
        gerarEntidades.adicionarObjeto(new Pedrona(acessar,1450,2150)); 
        gerarEntidades.adicionarObjeto(new Pedrona(acessar,1450,2250)); 
        gerarEntidades.adicionarObjeto(new Pedrona(acessar,1450,2350)); 
        gerarEntidades.adicionarObjeto(new Pedrona(acessar,1450,2450)); 
        gerarEntidades.adicionarObjeto(new Pedrona(acessar,1450,2550)); 
        gerarEntidades.adicionarObjeto(new Pedrona(acessar,1450,2650)); 
        gerarEntidades.adicionarObjeto(new Pedrona(acessar,1450,2750)); 
        gerarEntidades.adicionarObjeto(new Pedrona(acessar,1450,2850)); 
        gerarEntidades.adicionarObjeto(new Pedrona(acessar,1450,2950)); 
        gerarEntidades.adicionarObjeto(new Pedrona(acessar,1450,3050)); 
        gerarEntidades.adicionarObjeto(new Pedrona(acessar,1450,3150)); 
        gerarEntidades.adicionarObjeto(new Pedrona(acessar,1450,3250)); 
        gerarEntidades.adicionarObjeto(new Pedrona(acessar,1450,3350)); 
        gerarEntidades.adicionarObjeto(new Pedrona(acessar,1450,3450)); 
        gerarEntidades.adicionarObjeto(new Pedrona(acessar,1450,3550)); 
        gerarEntidades.adicionarObjeto(new Pedrona(acessar,1450,3650)); 
        gerarEntidades.adicionarObjeto(new Pedrona(acessar,1450,3750));    
        
        gerarEntidades.adicionarObjeto(new PedronaInvertida(acessar,2250,1550)); 
        gerarEntidades.adicionarObjeto(new PedronaInvertida(acessar,2250,1650)); 
        gerarEntidades.adicionarObjeto(new PedronaInvertida(acessar,2250,1750)); 
        gerarEntidades.adicionarObjeto(new PedronaInvertida(acessar,2250,1850)); 
        gerarEntidades.adicionarObjeto(new PedronaInvertida(acessar,2250,1950)); 
        gerarEntidades.adicionarObjeto(new PedronaInvertida(acessar,2250,2050)); 
        gerarEntidades.adicionarObjeto(new PedronaInvertida(acessar,2250,2150)); 
        gerarEntidades.adicionarObjeto(new PedronaInvertida(acessar,2250,2250)); 
        gerarEntidades.adicionarObjeto(new PedronaInvertida(acessar,2250,2350)); 
        gerarEntidades.adicionarObjeto(new PedronaInvertida(acessar,2250,2450)); 
        gerarEntidades.adicionarObjeto(new PedronaInvertida(acessar,2250,2550)); 
        gerarEntidades.adicionarObjeto(new PedronaInvertida(acessar,2250,2650)); 
        gerarEntidades.adicionarObjeto(new PedronaInvertida(acessar,2250,2750)); 
        gerarEntidades.adicionarObjeto(new PedronaInvertida(acessar,2250,2850)); 
        gerarEntidades.adicionarObjeto(new PedronaInvertida(acessar,2250,2950)); 
        gerarEntidades.adicionarObjeto(new PedronaInvertida(acessar,2250,3050)); 
        gerarEntidades.adicionarObjeto(new PedronaInvertida(acessar,2250,3150)); 
        gerarEntidades.adicionarObjeto(new PedronaInvertida(acessar,2250,3250)); 
        gerarEntidades.adicionarObjeto(new PedronaInvertida(acessar,2250,3350)); 
        gerarEntidades.adicionarObjeto(new PedronaInvertida(acessar,2250,3450)); 
        gerarEntidades.adicionarObjeto(new PedronaInvertida(acessar,2250,3550)); 
        gerarEntidades.adicionarObjeto(new PedronaInvertida(acessar,2250,3650));
        gerarEntidades.adicionarObjeto(new PedronaInvertida(acessar,2250,3750)); 
        //gerarEntidades.getJogador().setX(30);
        //gerarEntidades.getJogador().setY(30);
        carregarIMG(caminho);
        
        
    }

    public GerarObjetos_No_Mapa getGerarEntidades() {
        return gerarEntidades;
    }

    public void setGerarEntidades(GerarObjetos_No_Mapa gerarEntidades) {
        this.gerarEntidades = gerarEntidades;
    }

    public void atualizar() {
        gerarEntidades.atualizar();
    }

    public void renderizar(Graphics grafico) {
        // x e y inicial e final que da para ver na tela do player enquanto ele se movimenta
        // isso e para fazer com que renderize apenas o que o player vê

        //int xVisivelStart = (int) Math.max(0,jogo.pegarCamera().getX() / Texturas.largura_textura + 2),xVisivelFinal = largura;
        //int xVisivelStart = (int) Math.max(0,jogo.pegarCamera().getX() / Texturas.largura_textura),xVisivelFinal = (int) Math.min(largura, (jogo.pegarCamera().getX() + jogo.pegarLargura()) / Texturas.largura_textura);
        int xVisivelStart = (int) Math.max(0, acessar.pegarCamera().getX() / Texturas_Mundo.largura_textura), xVisivelFinal = (int) Math.min(largura, (acessar.pegarCamera().getX() + acessar.pegarLargura()) / Texturas_Mundo.largura_textura + 1);
        int yVisivelStart = (int) Math.max(0, acessar.pegarCamera().getY() / Texturas_Mundo.altura_textura), yVisivelFinal = (int) Math.min(altura, (acessar.pegarCamera().getY() + acessar.pegarAltura()) / Texturas_Mundo.altura_textura + 1);

        ///////////// //////////////////////////////////// ////////////// /////////////////// ///////////////
        for (int positionY = yVisivelStart; positionY < yVisivelFinal; positionY++) {
            for (int positionX = xVisivelStart; positionX < xVisivelFinal; positionX++) {
                //System.out.println(pegarTextura(positionX,positionY));

                pegarTextura(positionX, positionY).renderizar(grafico, (int) (positionX * Texturas_Mundo.largura_textura - acessar.pegarCamera().getX()), (int) (positionY * Texturas_Mundo.altura_textura - acessar.pegarCamera().getY()));

            }
        }
        System.out.println("saiu");
        grafico.setColor(Color.red);
        grafico.setFont(new Font("TimesRoman", Font.PLAIN, 15));
        grafico.drawString("Tempo restante: " + tempoRestante ,(int) 500,(int) 50);
        grafico.drawString("Salvos: " + numeroSalvos,(int) 650,(int) 50);
        gerarEntidades.renderizar(grafico);
    }

    public int getNumeroSalvos() {
        return numeroSalvos;
    }

    public void setNumeroSalvos(int numeroSalvos) {
        this.numeroSalvos = numeroSalvos;
    }

    public float getTempoRestante() {
        return tempoRestante;
    }

    public void setTempoRestante(float tempoRestante) {
        this.tempoRestante = tempoRestante;
    }

    public Texturas_Mundo pegarTextura(int x, int y) {
        if (x < 0 || x >= largura || y < 0 || y >= largura) {
            return Texturas_Mundo.pedra;
        }
        Texturas_Mundo texturaz = Texturas_Mundo.texturas[planoFundo[x][y]];
        //System.out.println(planoFundo[x][y]);
        if (texturaz == null) {
            return Texturas_Mundo.parede;
        }
        return texturaz;
    }

    private void carregarIMG(String caminho) {
        // cada pixel ocupa um espaço de 64 logo 64*15 da certo
        String arquivo = carregarTxt(caminho);
        // esse \\s+ faz com que cada vez que aja um espaço separe os numeros em outro indice
        String[] numeroPorLinha = arquivo.split("\\s+");
        /*
        for (int i = 0; i < numeroPorLinha.length; i++) {
            System.out.println(numeroPorLinha[i]);
        }
         */
        largura = converterTxt(numeroPorLinha[0]);
        altura = converterTxt(numeroPorLinha[1]);
        positionX = converterTxt(numeroPorLinha[2]);
        positionY = converterTxt(numeroPorLinha[3]);
        planoFundo = new int[largura][altura];

        for (int y = 0; y < altura; y++) {
            for (int x = 0; x < largura; x++) {
                // formula para achar a posição de um array apartir das posiçoes de uma matriz atual
                // + 4 porque as primeiras 4 posiçoes não fazem parte do mapa
                System.out.println(y);
                planoFundo[x][y] = converterTxt(numeroPorLinha[(x + y * largura) + 4]);
            }
        }

    }

    public static String carregarTxt(String caminho) {
        StringBuilder construtor = new StringBuilder();
        try {
            BufferedReader sla = new BufferedReader(new FileReader(caminho));
            String linha;
            while ((linha = sla.readLine()) != null) {
                construtor.append(linha + "\n");
            }
            sla.close();
        } catch (IOException ex) {

        }
        return construtor.toString();
    }

    public static int converterTxt(String numero) {
        try {
            return Integer.parseInt(numero);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

}
