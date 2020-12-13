/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;


public class Resource {

    public static int WINDOW_WIDTH;
    public static int WINDOW_HEIGHT;
    public static int SIDE_AREA_WIDTH;
    public static int RIGHT_AREA_WIDTH;
    public static int MAINVIEW_WIDTH;
    public static int ROW_HEIGHT = 40;
    public static int MAIN_BTN_WIDTH = 200;
    
    public static String TITLE = "Card Game";
    
        
    public static void initWindowSize() {
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
        WINDOW_WIDTH = (int)primaryScreenBounds.getWidth();
        WINDOW_HEIGHT = (int)primaryScreenBounds.getHeight();
        MAINVIEW_WIDTH = WINDOW_WIDTH / 2;
        SIDE_AREA_WIDTH = (int)(WINDOW_WIDTH * 0.135);
        RIGHT_AREA_WIDTH = (int)(WINDOW_WIDTH * 0.865);
    }
}
