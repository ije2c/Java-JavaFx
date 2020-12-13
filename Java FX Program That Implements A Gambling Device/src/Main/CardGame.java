/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import View.GameBoard;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;


public class CardGame extends Application {
    
    public static Stage mainStage;

    @Override
    public void start(Stage primaryStage) {
        Resource.initWindowSize();

        mainStage = primaryStage;

        Scene scene = new Scene(GameBoard.getInstance().getMainView());
        scene.getStylesheets().add(getClass().getClassLoader().getResource("resource/style/rootStyles.css").toExternalForm());
        mainStage.setScene(scene);
        //mainStage.setMaximized(true);
        mainStage.setResizable(true);
        mainStage.initStyle(StageStyle.DECORATED);
        mainStage.setTitle(Resource.TITLE);
        mainStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent event) {

            }
        });
        mainStage.show();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
