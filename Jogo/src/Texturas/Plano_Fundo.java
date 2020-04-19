package Texturas;

import Inicializador.Acessar;
import Inicializador.Jogo;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Plano_Fundo {

    private int altura, largura;
    private int positionX, positionY;
    private int[][] planoFundo;
    private Acessar acessar;
    public Plano_Fundo(Acessar acessar,String caminho) {
        this.acessar = acessar;
        carregarIMG(caminho);
    }

    public void atualizar() {

    }

    public void renderizar(Graphics grafico) {
        // x e y inicial e final que da para ver na tela do player enquanto ele se movimenta
        // isso e para fazer com que renderize apenas o que o player vê
        
        //int xVisivelStart = (int) Math.max(0,jogo.pegarCamera().getX() / Texturas.largura_textura + 2),xVisivelFinal = largura;
        //int xVisivelStart = (int) Math.max(0,jogo.pegarCamera().getX() / Texturas.largura_textura),xVisivelFinal = (int) Math.min(largura, (jogo.pegarCamera().getX() + jogo.pegarLargura()) / Texturas.largura_textura);
        int xVisivelStart = (int) Math.max(0,acessar.pegarCamera().getX() / Texturas.largura_textura),xVisivelFinal = (int) Math.min(largura, (acessar.pegarCamera().getX() + acessar.pegarLargura()) / Texturas.largura_textura + 1);
        int yVisivelStart = (int) Math.max(0,acessar.pegarCamera().getY() / Texturas.altura_textura),yVisivelFinal = (int) Math.min(altura,(acessar.pegarCamera().getY() + acessar.pegarAltura()) / Texturas.altura_textura + 1);
        
        ///////////// //////////////////////////////////// ////////////// /////////////////// ///////////////
        
        
        for (int positionY = yVisivelStart; positionY < yVisivelFinal; positionY++) {
            for (int positionX = xVisivelStart; positionX < xVisivelFinal; positionX++) {
                //System.out.println(pegarTextura(positionX,positionY));
                pegarTextura(positionX, positionY).renderizar(grafico, (int) (positionX * Texturas.largura_textura - acessar.pegarCamera().getX()),(int)  (positionY * Texturas.altura_textura - acessar.pegarCamera().getY()));
            }
        }
        //System.out.println("saiu");
    }

    public Texturas pegarTextura(int x, int y) {
        if(x < 0 || x >= largura || y < 0 || y >= largura)
        {
            return Texturas.pedra;
        }
        Texturas texturaz = Texturas.texturas[planoFundo[x][y]];
        //System.out.println(planoFundo[x][y]);
        if (texturaz == null) {
            return Texturas.parede;
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
