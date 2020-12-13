/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Main.Resource;
import java.io.File;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class GameBoard {

    BorderPane main_pane;
    BorderPane main_groue_pane;
    ScrollPane main_scroll_pane;

    VBox mainBox;

    public ImageView card_view_1;
    public ImageView card_view_2;
    public ImageView card_view_3;
    public ImageView card_view_4;

    public TextField amount_view;

    public Label total_amount;
    public Label win_amount;
    public Label spend_amount;

    Button spin_btn;

    double IMAGE_WIDTH = 72;
    double IMAGE_HEIGHT = 96;
    
    GameAdapter adapter;
    private static GameBoard instance;

    public static GameBoard getInstance() {
        if (instance == null) {
            instance = new GameBoard();
        }
        return instance;
    }
    
    public GameBoard() {
        adapter = new GameAdapter();
        initView();
    }

    public void initView() {
        main_pane = new BorderPane();
        main_pane.setId("main_area");
        //main_pane.setPrefWidth(Resource.WINDOW_WIDTH * 0.8);
        //main_pane.setPrefHeight(Resource.WINDOW_HEIGHT - 40);
        formUI();
        BorderPane.setMargin(main_groue_pane, new Insets(20, 20, 20, 20));
        main_pane.setCenter(main_groue_pane);
    }

    public BorderPane getMainView() {
        return main_pane;
    }
    /**
     * form Game board
     */
    private void formUI() {
        main_groue_pane = new BorderPane();

        mainBox = makeVBox(15);
        
        //initialize card  image views
        card_view_1 = new ImageView();
        card_view_1.setFitWidth(IMAGE_WIDTH);
        card_view_1.setFitHeight(IMAGE_HEIGHT);
        
        card_view_2 = new ImageView();
        card_view_2.setFitWidth(IMAGE_WIDTH);
        card_view_2.setFitHeight(IMAGE_HEIGHT);

        card_view_3 = new ImageView();
        card_view_3.setFitWidth(IMAGE_WIDTH);
        card_view_3.setFitHeight(IMAGE_HEIGHT);

        card_view_4 = new ImageView();
        card_view_4.setFitWidth(IMAGE_WIDTH);
        card_view_4.setFitHeight(IMAGE_HEIGHT);

        HBox cardBox = makeHBox(20);
        cardBox.getChildren().addAll(card_view_1, card_view_2, card_view_3, card_view_4);
        
        //initialize inserted amount area
        Label amount_insert_label = new Label();
        amount_insert_label.setId("label_3");
        amount_insert_label.setText("Amount Inserted($): ");

        amount_view = new TextField();
        amount_view.setId("field_2");
        
        HBox insertBox = makeHBox(30);
        insertBox.getChildren().addAll(amount_insert_label, amount_view);
        
        //initialize win amount area
        Label amount_win_label = new Label();
        amount_win_label.setId("label_3");
        amount_win_label.setText("Amount Won This Spin($): ");

        win_amount = new Label("0.00");
        win_amount.setId("label_3");
        
        HBox winBox = makeHBox(30);
        winBox.getChildren().addAll(amount_win_label, win_amount);

        //initialize total amount area
        Label total_amount_label = new Label();
        total_amount_label.setId("label_3");
        total_amount_label.setText("Toal Amount Won($): ");

        total_amount = new Label("0.00");
        total_amount.setId("label_3");

        HBox totalBox = makeHBox(30);
        totalBox.getChildren().addAll(total_amount_label, total_amount);
        
        //initialize sepnd amount area
        Label spend_amount_label = new Label();
        spend_amount_label.setId("label_3");
        spend_amount_label.setText("So far you spend($): ");

        spend_amount = new Label("0.00");
        spend_amount.setId("label_3");

        HBox spendBox = makeHBox(30);
        spendBox.getChildren().addAll(spend_amount_label, spend_amount);
        
        //initialize button
        spin_btn = new Button("Spin");
        spin_btn.setId("btn_1");
        spin_btn.setPadding(new Insets(8, 30, 8, 30));
        spin_btn.setCursor(Cursor.HAND);
        
        Label guide_label = new Label();
        guide_label.setId("label_4");
        guide_label.setText("Insert an amount to play");
        
        VBox.setMargin(cardBox, new Insets(0, 0, 40, 0));
        mainBox.getChildren().addAll(cardBox, insertBox, winBox, totalBox, spendBox, spin_btn, guide_label);
        
        initAction();
        
        StackPane area_stack = new StackPane();
        area_stack.setId("main_register_area");
        StackPane.setMargin(mainBox, new Insets(15, 25, 15, 25));
        area_stack.getChildren().addAll(mainBox);
        DropShadow e = new DropShadow();
        e.setWidth(5);
        e.setHeight(5);
        e.setOffsetX(3);
        e.setOffsetY(3);
        e.setBlurType(BlurType.THREE_PASS_BOX);
        e.setRadius(0);
        area_stack.setEffect(e);

        main_groue_pane.setCenter(area_stack);
    }

    private void initAction() {
        spin_btn.setOnAction((evt) -> {
            adapter.spin();
        });
    }

    private HBox makeHBox(double space) {
        HBox box = new HBox();
        box.setAlignment(Pos.CENTER);
        box.setSpacing(space);
        return box;
    }

    private VBox makeVBox(double space) {
        VBox box = new VBox();
        box.setAlignment(Pos.CENTER);
        box.setSpacing(space);
        return box;
    }
    
    
}
