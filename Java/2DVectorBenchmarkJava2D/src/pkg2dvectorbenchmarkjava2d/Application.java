package pkg2dvectorbenchmarkjava2d;

import java.util.*;
import java.awt.*;
import java.awt.image.*;
import javax.swing.JFrame;

public class Application {
    public static final int WIDTH = 1024;
    public static final int HEIGHT = 768;
    private static int frame = 0;

    public static void main(String[] args) {
        
        // Create game window...
        JFrame app = new JFrame();
        //app.setSize(WIDTH, HEIGHT);
        app.setIgnoreRepaint(true);
        app.setTitle("2D Vector Performance (Java2D)");
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Canvas
        Canvas canvas = new Canvas();
        canvas.setIgnoreRepaint(true);
        canvas.setSize(WIDTH, HEIGHT);

        // Add canvas to game window...
        app.add(canvas);
        app.pack();
        app.setVisible(true);

        // Create BackBuffer...
        canvas.createBufferStrategy(2);
        BufferStrategy buffer = canvas.getBufferStrategy();

        // Get graphics configuration...
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = ge.getDefaultScreenDevice();
        GraphicsConfiguration gc = gd.getDefaultConfiguration();

        // Create off-screen drawing surface
        BufferedImage bi = gc.createCompatibleImage(WIDTH, HEIGHT);
    
        // Objects needed for rendering...
        Graphics graphics = null;
        Graphics2D g2d = null;
        Color background = Color.BLACK;
        Random r = new Random();
    
        // Variables for counting frames per seconds
        int fps = 0;
        int frames = 0;
        long totalTime = 0;
        long curTime = System.currentTimeMillis();
        long lastTime = curTime;
        while (true) {
            try {
                // clear back buffer...
                g2d = bi.createGraphics();
                g2d.setColor( background );

                // Draw some line
                g2d.setStroke(new BasicStroke(1));
                for (int x = 0; x < 1000; x++) {
                    g2d.setColor(new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256)));
                    g2d.drawLine(
                            r.nextInt(Application.WIDTH * 2) - (Application.WIDTH / 2), 
                            r.nextInt(Application.HEIGHT * 2) - (Application.HEIGHT / 2), 
                            r.nextInt(Application.WIDTH * 2) - (Application.WIDTH / 2), 
                            r.nextInt(Application.HEIGHT * 2) - (Application.HEIGHT / 2));
                }

                // Blit image and flip...
                graphics = buffer.getDrawGraphics();
                graphics.drawImage(bi, 0, 0, null);
                if(!buffer.contentsLost())
                    buffer.show();

                // Let the OS have a little time...
                Thread.yield();
            } finally {
                // release resources
                if(graphics != null) 
                    graphics.dispose();
                if(g2d != null) 
                    g2d.dispose();
            }
            frame++;
            if (frame == 250) {
                System.exit(0);
            }
        }
    }   
}
