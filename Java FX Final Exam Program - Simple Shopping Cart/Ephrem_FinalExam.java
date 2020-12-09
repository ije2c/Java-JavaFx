package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;



public class Ephrem_FinalExam extends Application {
	double tax = 0;
    double tips = 0;
	float total = 0;
	
	


	
	@Override

	public void start(Stage primaryStage) {
		try {
			
			
			
			primaryStage.setTitle("Shopping Cart"); //set title of the window
			Button button1 = new Button("Calculate Cost");// create a button for calculating expenses
			
			
			
			Label Tax = new Label();
			Label Tip = new Label();
			Label Calculation = new Label();
			
			Label Beverages = new Label();
			Label Appetizers = new Label();
			Label MainMeal = new Label();
			
			Beverages.setText("Select Beverage");
			Appetizers.setText("Select Appetizer");
			MainMeal.setText("Select Main Course");
			
			ComboBox<String> BeverageComboBox = new ComboBox<String>(); /*create combo box for food */
			 BeverageComboBox.getItems().addAll(
			            "Soda 1.95",
			            "Tea 1.50",
			            "Coffee 1.25",
			            "Mineral Water 2.95",
			            "Juice 2.50",
			            "Milk 1.50"
			        );
			 
			 ComboBox<String> AppetizerComboBox = new ComboBox<String>(); /*create combo box for food */
			 AppetizerComboBox.getItems().addAll(
			            "Buffalo Wings 5.95",
			            "Buffalo Fingers 6.95",
			            "Potato Skins 8.95",
			            "Nachos 8.95",
			            "Mushroom Caps 10.95",
			            "Shrimp Cocktail 12.95",
			            "Chips and Salsa 6.95"
			        );
		
			 ComboBox<String> MainCourseComboBox = new ComboBox<String>(); /*create combo box for food */
			 MainCourseComboBox.getItems().addAll(
			            "Chicken Alfredo 13.95",
			            "Chicken Picatta 13.95",
			            "Turkey Club 11.95",
			            "Lobster Pie 19.95",
			            "Prime Rib 20.95",
			            "Shrimp Scampi 18.95",
			            "Turkey Dinner 13.95",
			            "Stuffed Chicken 14.95"
			        );
		 
			 
			 
			 
			 
			 
			 
			Pane root = new Pane();
			button1.setLayoutX(50);
		    button1.setLayoutY(320);
		    
		    Tax.setLayoutX(50);
			Tax.setLayoutY(390);
		    
			Tip.setLayoutX(50);
			Tip.setLayoutY(460);
		    
		    
		   Calculation.setLayoutX(50);
		   Calculation.setLayoutY(530);
		    
		    
		   
		   
		  
		   
		   BeverageComboBox.setLayoutX(150);
		   BeverageComboBox.setLayoutY(70);
		   
		   AppetizerComboBox.setLayoutX(150);
		   AppetizerComboBox.setLayoutY(140);
		   
		   MainCourseComboBox.setLayoutX(150);
		   MainCourseComboBox.setLayoutY(210);
		   
		   
		   Beverages.setLayoutX(0);
		   Beverages.setLayoutY(70);
		   
		   Appetizers.setLayoutX(0);
		   Appetizers.setLayoutY(140);
		   
		   MainMeal.setLayoutX(0);
		   MainMeal.setLayoutY(210);
		  
		  
		  button1.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
	            @Override
	            public void handle(ActionEvent e) {
	              
	         
	                if (BeverageComboBox.getValue().toString() == "Soda 1.95" ){	                	    
	                        total+= 1.95;   	             
	                    }   	  
	                else if (BeverageComboBox.getValue().toString() == "Tea 1.50" ){              	   
                        total+= 1.5;     
                    }   	  
	                else if (BeverageComboBox.getValue().toString() == "Coffee 1.25" ){                	   
                        total+= 1.25;                      
                    }   
	                

	                if (AppetizerComboBox.getValue().toString() == "Buffalo Wings 5.95" ){	                	    
	                        total+= 5.95;   	             
	                    }   	  
	                else if (AppetizerComboBox.getValue().toString() == "Buffalo Fingers 6.95" ){              	   
                        total+= 6.95;     
                    }   	  
	                else if (AppetizerComboBox.getValue().toString() == "Potato Skins 8.95" ){                	   
                        total+= 8.95;                      
                    }   
	                

	                if (MainCourseComboBox.getValue().toString() == "Chicken Alfredo 13.95" ){	                	    
	                        total+= 13.95;   	             
	                    }   	  
	                else if (MainCourseComboBox.getValue().toString() == "Chicken Picatta 13.95" ){              	   
                        total+= 13.95;     
                    }   	  
	                else if (MainCourseComboBox.getValue().toString() == "Turkey Club 11.95" ){                	   
                        total+= 11.95;                      
                    }   
	                
	                tips = 0.15 * total; 
	                tax = 0.07 * total;
	                
	                Tax.setText("Tax: " +tax +"\n");
	                Tip.setText("Tip: " +tips +"\n");	               
	                Calculation.setText("Total: " +total);
	                
	             }
	            }
	        );
		 
		 
		  
		 
		 
		    root.getChildren().add(Tax);
		    root.getChildren().add(Tip);
		    root.getChildren().add(Calculation);
		     
		  
		    root.getChildren().add(button1);

		    root.getChildren().add(Beverages);
		    root.getChildren().add(Appetizers);
		    root.getChildren().add(MainMeal);
		  
		    root.getChildren().add(BeverageComboBox);
		    root.getChildren().add(AppetizerComboBox);
		    root.getChildren().add(MainCourseComboBox);
			Scene scene = new Scene(root, 600, 450);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		launch(args);
		
		
		
		
	}
}
