package pkg2dvectorbenchmarkjava2d;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class Application extends JFrame {
    public static final int WIDTH = 1024;
    public static final int HEIGHT = 768;

    public Application() {

        initUI();
    }

    private void initUI() {
        add(new RenderPanel());
        setSize(WIDTH, HEIGHT);
        setTitle("2D Vector Performance (Java2D)");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }    
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Application ex = new Application();
                ex.setVisible(true);
            }
        });
    }
    
}
