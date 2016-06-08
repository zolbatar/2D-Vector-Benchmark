package pkg2dvectorbenchmarkjava2d;

import javax.swing.JPanel;
import java.awt.*;
import java.util.Random;

public class RenderPanel extends JPanel {
    private final Random r = new Random();
    private int frame = 0;
    
    public RenderPanel() {
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        frame++;
//                System.out.println(now);
        if (frame == 250) {
            System.exit(0);
        } else {
            Render(g);
        }
    }

    private void Render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHints(rh);
        
        g2d.clearRect(0, 0, Application.WIDTH, Application.HEIGHT);
        g2d.setStroke(new BasicStroke(1));
        for (int x = 0; x < 1000; x++) {
            g2d.setColor(new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256)));
            g2d.drawLine(
                    r.nextInt(Application.WIDTH * 2) - (Application.WIDTH / 2), 
                    r.nextInt(Application.HEIGHT * 2) - (Application.HEIGHT / 2), 
                    r.nextInt(Application.WIDTH * 2) - (Application.WIDTH / 2), 
                    r.nextInt(Application.HEIGHT * 2) - (Application.HEIGHT / 2));
        }
    }
}
