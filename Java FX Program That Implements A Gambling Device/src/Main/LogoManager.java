/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.io.InputStream;
import javafx.scene.image.Image;


public class LogoManager {

    private static LogoManager instance;
    
    public static LogoManager getInstance(){
        if(instance == null){
            instance = new LogoManager();
        }
        return instance;
    }
    public Image getCard(int num) {
        InputStream icon_stream = getClass().getClassLoader().getResourceAsStream("resource/images/card/" + num + ".png");
        return new Image(icon_stream);
    }
    public String getURL(String location) {
        String path = getClass().getClassLoader().getResource(location).toExternalForm();
        return path;
    }
}
