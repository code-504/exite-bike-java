package proyectoanimacion2d;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class ProyectoAnimacion2D extends JFrame implements Runnable {
    
    private JPanel p;
    private BufferedImage bff, bff2, bff3, bffMoto, bffR1, bffR2, bffR3, bffMalla, bffLuz, bffLuz2, bffLuz3;
    private Graphics2D gbff, gbR1, gbffLuz, gbffLuz2, gbffLuz3;
    private Nivel nivel;
    private Nivel2 nivel2;
    private Nivel3 nivel3;
    Curva curva;
    private int contador = 0;
    
    private BufferedImage[] bffMotos, bffMotos2, bffMotos3;
    private Moto[] motos, motos2, motos3;
    
    private int WIDTH = 1044;
    private int HEIGHT = 480;
    
    private int xT = 0;
    
    public ProyectoAnimacion2D() {
        super("Animación - Rubén Valdivia Pérez");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1020, HEIGHT);
        setLocationRelativeTo(null);
        
        bff = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
        bff2 = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
        bff3 = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
        gbff = (Graphics2D) bff.createGraphics();
        
        // Luz
        bffLuz = new BufferedImage(WIDTH, 85, BufferedImage.TYPE_INT_ARGB);
        gbffLuz = (Graphics2D) bffLuz.createGraphics();
        
        bffLuz2 = new BufferedImage(WIDTH, 85, BufferedImage.TYPE_INT_ARGB);
        gbffLuz2 = (Graphics2D) bffLuz2.createGraphics();
        
        bffLuz3 = new BufferedImage(WIDTH, 85, BufferedImage.TYPE_INT_ARGB);
        gbffLuz3 = (Graphics2D) bffLuz3.createGraphics();
        
        // Malla
        bffMalla = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
        
        // Buffer Rampa
        bffR1 = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
        bffR2 = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
        bffR3 = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
        gbR1 = (Graphics2D) bffR1.createGraphics();
        
        //gbff.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        
        bffMotos = new BufferedImage[10];
        bffMotos2 = new BufferedImage[10];
        bffMotos3 = new BufferedImage[10];
        
        for (int i = 0; i < 10; i++) {
            bffMotos[i] = new BufferedImage(110, 110, BufferedImage.TYPE_INT_ARGB);
            bffMotos2[i] = new BufferedImage(110, 110, BufferedImage.TYPE_INT_ARGB);
            bffMotos3[i] = new BufferedImage(110, 110, BufferedImage.TYPE_INT_ARGB);
        }
        
        //bffMoto = new BufferedImage(110, 110, BufferedImage.TYPE_INT_ARGB);
        //bffMoto2 = new BufferedImage(600, 600, BufferedImage.TYPE_INT_ARGB);
        
        
        nivel = new Nivel(bff, bffR1, bffLuz2);
        nivel2 = new Nivel2(bff2, bffR2, bffLuz3);
        nivel3 = new Nivel3(bff3, bffR3, bffMalla, bffLuz);
        
        motos = new Moto[10];
        motos2 = new Moto[10];
        motos3 = new Moto[10];
        
        int[][] posicionesSalida = {{170, 1}, {220, 1}, {170, 2}, {260, 2}, {170, 2}, {250, 4}, {250, 4}, {170, 2}, {260, 2}, {170, 2}};
        
        int[][] posicionesSalida2 = {{170, 5}, {220, 1}, {170, 2}, {260, 5}, {170, 2}, {250, 2}, {250, 2}, {170, 5}, {260, 2}, {300, 5}};
        
        int[][] posicionesSalida3 = {{260, 7}, {260, 1}, {170, 6}, {260, 7}, {170, 6}, {250, 2}, {305, 2}, {170, 6}, {260, 2}, {170, 6}};
        
        Color[][] posicionColor = new Color[10][2];
                
        Random random = new Random();
        
        // Asignar colores aleatorios a los elementos de la matriz
        for (int i = 0; i < posicionColor.length; i++) {
            for (int j = 0; j < posicionColor[i].length; j++) {
                int red = random.nextInt(256);
                int green = random.nextInt(256);
                int blue = random.nextInt(256);
                posicionColor[i][j] = new Color(red, green, blue);
            }
        }
        
        for (int i = 0; i < 10; i++) {
            motos[i] = new Moto(bffMotos[i], posicionColor[i][0], posicionColor[i][1], -90, posicionesSalida[i][0], posicionesSalida[i][1]);
            motos2[i] = new Moto(bffMotos2[i], posicionColor[i][0], posicionColor[i][1], -90, posicionesSalida2[i][0], posicionesSalida2[i][1]);
            motos3[i] = new Moto(bffMotos2[i], posicionColor[i][0], posicionColor[i][1], -90, posicionesSalida3[i][0], posicionesSalida3[i][1]);
        }
        
        int segundaRonda = 1800;
        int terceraRonda = 3600;
        
        p = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                 
                //gbff.clearRect(0, 0, WIDTH, HEIGHT);
                
                               
                //gbffLuz.setBackground(new Color(238,238,238));
                //gbffLuz.setComposite(AlphaComposite.Clear);
                //gbffLuz.fillRect(0, 0, bffLuz.getWidth(), bffLuz.getHeight());
                
                
                //gbffLuz.clearRect(0, 0, bffLuz.getWidth(), bffLuz.getHeight());
                
                
  //gbffLuz.clearRect(0, 0, WIDTH, HEIGHT);
                if (xT < 1800) {
                    gbffLuz2.setComposite(AlphaComposite.Clear);
                    gbffLuz2.fillRect(0, 0, bffLuz2.getWidth(), bffLuz2.getHeight());
                
                    nivel.dibujarNivel(xT, g, this);
                    
                    if (xT >= 100 && xT < xT + 1000) {
                        motos[0].animacion(g, this);
                        motos[6].animacion(g, this);
                    }

                    if (xT >= 300 && xT < xT + 1000) {
                        motos[7].animacion(g, this);
                        motos[1].animacion(g, this);
                    }

                    if (xT >= 600 && xT < xT + 1000) {
                        motos[2].animacion(g, this);
                    }
                    
                    if (xT >= 700 && xT < xT + 1000) {
                        motos[8].animacion(g, this);
                    }

                    if (xT >= 900 && xT < xT + 1000) {
                        motos[3].animacion(g, this);
                    }

                    if (xT >= 1200 && xT < xT + 1000) {
                        motos[4].animacion(g, this);
                    }

                    if (xT >= 1300 && xT < xT + 1000) {
                        motos[5].animacion(g, this);
                    }
                    
                    if (xT >= 1400 && xT < xT + 1000) {
                        motos[9].animacion(g, this);
                    }
                } else {
                    motos[0] = null;
                    motos[1] = null;
                    motos[2] = null;
                    motos[3] = null;
                    motos[4] = null;
                    motos[5] = null;
                    motos[6] = null;
                    motos[7] = null;
                    motos[8] = null;
                    motos[9] = null;
                    nivel = null;
                    if (gbffLuz2 != null)
                        gbffLuz2 = null;
                    
                    if (bffLuz2 != null)
                        bffLuz2.flush();
                    
                    bffLuz2 = null;
                }
                
                
                
                if (xT >=  segundaRonda && xT < terceraRonda) {
                    gbffLuz3.setComposite(AlphaComposite.Clear);
                    gbffLuz3.fillRect(0, 0, bffLuz3.getWidth(), bffLuz3.getHeight());
                    
                    nivel2.dibujarNivel(xT, g, this);
                    
                    if (xT >= segundaRonda + 100 && xT < xT + segundaRonda + 1000) {
                        motos2[0].animacion(g, this);
                        motos2[6].animacion(g, this);
                    }

                    if (xT >= segundaRonda + 300 && xT < xT + segundaRonda + + 1000) {
                        motos2[7].animacion(g, this);
                        motos2[1].animacion(g, this);
                    }

                    if (xT >= segundaRonda + 600 && xT < xT + segundaRonda + 1000) {
                        motos2[2].animacion(g, this);
                    }
                    
                    if (xT >= segundaRonda + 700 && xT < xT + segundaRonda + 1000) {
                        motos2[8].animacion(g, this);
                    }

                    if (xT >= segundaRonda + 900 && xT < xT + segundaRonda + + 1000) {
                        motos2[3].animacion(g, this);
                    }

                    if (xT >= segundaRonda + 1200 && xT < xT + segundaRonda + + 1000) {
                        motos2[4].animacion(g, this);
                    }

                    if (xT >= segundaRonda + 1300 && xT < xT + segundaRonda + + 1000) {
                        motos2[5].animacion(g, this);
                    }
                    
                    if (xT >= segundaRonda + 1400 && xT < xT + segundaRonda + + 1000) {
                        motos2[9].animacion(g, this);
                    }
                } else {
                    if (xT > 3600) {
                        motos2[0] = null;
                        motos2[1] = null;
                        motos2[2] = null;
                        motos2[3] = null;
                        motos2[4] = null;
                        motos2[5] = null;
                        motos2[6] = null;
                        motos2[7] = null;
                        motos2[8] = null;
                        motos2[9] = null;
                        nivel2 = null;
                        
                        if (gbffLuz3 != null)
                            gbffLuz3 = null;

                        if (bffLuz3 != null)
                            bffLuz3.flush();

                        bffLuz3 = null;
                    }
                }
                
                if (xT >=  terceraRonda)  {
                    gbffLuz.setComposite(AlphaComposite.Clear);
                    gbffLuz.fillRect(0, 0, bffLuz.getWidth(), bffLuz.getHeight());
                
                    nivel3.dibujarNivel(xT, g, this);
                    if (xT >= terceraRonda + 100 && xT < xT + terceraRonda + 1000) {
                        motos3[0].animacion(g, this);
                        motos3[6].animacion(g, this);
                    }

                    if (xT >= terceraRonda + 300 && xT < xT + terceraRonda + + 1000) {
                        motos3[7].animacion(g, this);
                        motos3[1].animacion(g, this);
                    }

                    if (xT >= terceraRonda + 600 && xT < xT + terceraRonda + 1000) {
                        motos3[2].animacion(g, this);
                    }
                    
                    if (xT >= terceraRonda + 700 && xT < xT + terceraRonda + 1000) {
                        motos3[8].animacion(g, this);
                    }

                    if (xT >= terceraRonda + 900 && xT < xT + terceraRonda + + 1000) {
                        motos3[3].animacion(g, this);
                    }

                    if (xT >= terceraRonda + 1200 && xT < xT + terceraRonda + + 1000) {
                        motos3[4].animacion(g, this);
                    }

                    if (xT >= terceraRonda + 1300 && xT < xT + terceraRonda + + 1000) {
                        motos3[5].animacion(g, this);
                    }
                    
                    if (xT >= terceraRonda + 1400 && xT < xT + terceraRonda + + 1000) {
                        motos3[9].animacion(g, this);
                    }
                } 
                
                /*if (xT > terceraRonda + 1800) {
                        motos3[0] = null;
                        motos3[1] = null;
                        motos3[2] = null;
                        motos3[3] = null;
                        motos3[4] = null;
                        motos3[5] = null;
                        motos3[6] = null;
                        motos3[7] = null;
                        motos3[8] = null;
                        motos3[9] = null;
                        //nivel3 = null;
                    }*/
                g.dispose();
            }
        };
        
        p.setPreferredSize(new Dimension(1020, HEIGHT));
        this.add(p);
        this.pack();
        setVisible(true);
    }

    public static void main(String[] args) throws IOException {
        
        ProyectoAnimacion2D v = new ProyectoAnimacion2D();
        Thread hilo = new Thread(v);
        hilo.start();
    }
    
    @Override
    public void run() {
              
        while (true) {
            try {
                
                xT += 1;
                
                Thread.sleep(16);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            p.repaint();
            //repaint();
        }
    }
    
}
