package pkg2dvectorbenchmarkjavafx;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;

public class Main extends Application {
    public static final int WIDTH = 1024;
    public static final int HEIGHT = 768;
    public static FXMLMainController controller;
    
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLMain.fxml"));
        Parent root = fxmlLoader.load();
        controller = (FXMLMainController)fxmlLoader.getController();
        stage.setTitle("2D Vector Performance (JavaFX)");
        stage.setWidth(WIDTH);
        stage.setHeight(HEIGHT);
        stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        stage.setScene(new Scene(root));
        stage.show();
        
        // Animation timer
        AnimationTimer timer = new AnimationTimer() {
            private int i = 0;
            
            @Override
            public void handle(long now) {
                i++;
//                System.out.println(now);
                if (i == 250) {
                    System.exit(0);
                } else {
                    controller.Render();
                }
            }
        };
        timer.start(); 
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
