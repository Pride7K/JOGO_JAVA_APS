package Inicializador;

import Gerenciador_Entradas.Mouse;
import Gerenciador_Entradas.Teclado;
import Imagem.TransformarEmBuffered;
import Imagem.CarregarImagens;
import Paginas.ConfiguracaoPagina;
import Paginas.JogoPagina;
import Paginas.MenuPagina;
import Paginas.Metodos;
import Tela.Camera;
import Tela.Tela;
import com.sun.javafx.iio.ImageLoader;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

// implements Runnable para possibilitar o uso de threads
// com o uso de threads é possivel atualizar variaveis
// e com isso atualizar o cenario e renderiza-lo
public class Jogo implements Runnable {

    private Tela tela;
    private boolean funcionando = false;
    private Thread thread;
    // buffer é uma tela invisivel que vai ser desenhada pelo meu canvas para
    // ir para a minha tela ou a tela do usuario
    private BufferStrategy bs;
    // graphics me permite desenhar no canvas
    private Graphics grafico;

    private Camera camera;

    //private BufferedImage imagem;
    //private Sprite imagemCortada;
    private String titulo;
    private int largura;
    private int altura;

    private Acessar acessar;

    // input para as teclas
    private Teclado teclado;
    
    private Mouse mouse;

    // paginas
    private Metodos jogoPagina;
    private Metodos menuPagina;
    private Metodos configuraPagina;

    private CarregarImagens carregar;

    public Jogo(String titulo, int largura, int altura) {
        this.titulo = titulo;
        this.largura = largura;
        this.altura = altura;
        teclado = new Teclado();
        mouse = new Mouse();
    }

    private void atualizar() {
        //System.out.println("caiuAtualizarJogo");
        teclado.atualizar();
        if (Metodos.pegarPaginaAtual() != null) {
            Metodos.pegarPaginaAtual().atualizar();
        }
    }

    public Mouse getMouse() {
        return mouse;
    }

    public void setMouse(Mouse mouse) {
        this.mouse = mouse;
    }

    private void renderizar() {
        // getBufferStategy é uma forma do computador desenhar o meu canvas na tela
        // ou seja o meu objeto ou personagem
        bs = tela.pegarCanvas().getBufferStrategy();
        if (bs == null) {
            tela.pegarCanvas().createBufferStrategy(2);
            return;
        }

        // esse get faz basicamente o meu objeto graphics usar o pincel
        // para desenho
        grafico = bs.getDrawGraphics();

        //desenhando
        // temos que limpar a tela para colocar outra coisa no lugar
        // primeiro parametro é a distancia do lado,segundo paramento é a distancia de cima
        // terceiro parametro é a largura e o ultimo a altura
        grafico.clearRect(0, 0, altura, largura);

        // desenhar um quadrado
        //grafico.drawRect(10, 50, 50, 70);
        // pintar um quadrado
        //grafico.setColor(Color.yellow);
        //grafico.fillRect(10, 50, 50, 70);
        //grafico.setColor(Color.red);
        //grafico.fillRect(0, 0, 10, 10);
        if (Metodos.pegarPaginaAtual() != null) {
            Metodos.pegarPaginaAtual().renderizar(grafico);
        }

        // colocar imagem na tela
        //grafico.drawImage(imagemCortada.cortarImagem(0, 0, 227, 222), 5, 5, null);
        //finalizando desenho
        bs.show();
        grafico.dispose();
    }

    public Tela getTela() {
        return tela;
    }

    public void setTela(Tela tela) {
        this.tela = tela;
    }

    private void init() {

        tela = new Tela(titulo, largura, altura);
        acessar = new Acessar(this);
        camera = new Camera(acessar, 5, 5);
        carregar.init();
        tela.pegarTela().addKeyListener(teclado);
        tela.pegarCanvas().addMouseListener(mouse);
        tela.pegarCanvas().addMouseMotionListener(mouse);
        // colocando esse this eu passo toda essa classe para as outras classes para ter acesso ao que tenho nessa classe
        jogoPagina = new JogoPagina(acessar);
        menuPagina = new MenuPagina(acessar);
        configuraPagina = new ConfiguracaoPagina(acessar);
        Metodos.setarPaginaAtual(jogoPagina);

        //imagem = carregarImagem.carregaImg("C:\\Users\\gsant\\Desktop\\APS_JAVA\\Jogo\\coisas\\images\\teste.png");
        //imagem = imagemCortada.cortarImagem(227, 0, 346, 219);
        //imagemCortada = new Sprite(imagem);
    }

    public Camera pegarCamera() {
        return camera;
    }

    public int pegarLargura() {
        return largura;
    }

    public int pegarAltura() {
        return altura;
    }

    public Teclado pegarTeclado() {
        return teclado;
    }

    public void run() {

        // iniciar o jogo
        init();

        // game loop para renderizar o jogo e atualizar variaveis
        // essas variaveis servem para colocar um tempo basicamente de atualização
        // e renderização do meu codigo
        int framesPorSegundo = 60;
        // esse numero gigantesco equivale a 1
        double tempoRenderizar = 1000000000 / framesPorSegundo;
        double delta = 0;
        long tempoAgora;
        long ultimoTempoAgora = System.nanoTime();
        long tempo = 0;
        long frames = 0;

        while (funcionando == true) {
            tempoAgora = System.nanoTime();
            delta += (tempoAgora - ultimoTempoAgora) / tempoRenderizar;
            tempo += tempoAgora - ultimoTempoAgora;
            ultimoTempoAgora = tempoAgora;

            if (delta >= 1) {
                atualizar();
                renderizar();
                frames++;
                delta--;
            }

            if (tempo >= 1000000000) {
                //System.out.println(frames);
                frames = 0;
                tempo = 0;
            }
        }

        parar();
    }

    public synchronized void iniciar() {
        // thread de inicialização
        if (funcionando == true) {
            return;
        }
        funcionando = true;
        thread = new Thread(this);
        // esse thread start vai chamar o metodo run
        // o metodo run vai iniciar o jogo
        thread.start();
    }

    public synchronized void parar() {
        // thread de parada
        if (funcionando == false) {
            return;
        }
        funcionando = false;
        try {
            thread.sleep(20);
            thread.join();
        } catch (InterruptedException e) {

        }
    }

}
