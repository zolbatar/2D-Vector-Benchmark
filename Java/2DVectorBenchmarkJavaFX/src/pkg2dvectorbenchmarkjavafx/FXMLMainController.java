package pkg2dvectorbenchmarkjavafx;

import java.util.Random;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class FXMLMainController implements Initializable {
    @FXML private Canvas canvas;
    private final Random r = new Random();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    
    public void Render() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, Main.WIDTH, Main.HEIGHT);
        gc.setLineWidth(1.0);
        for (int x = 0; x < 1000; x++) {
            Color a = Color.rgb(r.nextInt(256), r.nextInt(256), r.nextInt(256));
            gc.setStroke(a);
            gc.strokeLine(r.nextInt(Main.WIDTH * 2) - (Main.WIDTH / 2), r.nextInt(Main.HEIGHT * 2) - (Main.HEIGHT / 2), r.nextInt(Main.WIDTH * 2) - (Main.WIDTH / 2), r.nextInt(Main.HEIGHT * 2) - (Main.HEIGHT / 2));
        }
    }
}
