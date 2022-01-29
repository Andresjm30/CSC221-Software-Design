package DataProj;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.* ;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;


	public class DrawDesign extends Application {

		public Connection db; //Database connection variable
		public ComboBox comboBox; //Dropdown menu
		public ResultSet result; // Holds the output of a query
		public TextField textField; // Query line
		public TableView table; //Actual db table
		public Button E,
			 D,
			 S,
			 C,
			 BC,
			 H,
			 Process; //All buttons
		public Statement stmt; //Query statement variable
		public double CommRate;
		public String query; // query string variable
		public ObservableList < ObservableList > input =
		FXCollections.observableArrayList(); //List to add to table
		public String[] all = {
					 "Students",
					 "Courses",
					 "Classes",
					 "commissionEmployees",
					 "employees"
					 };
		String url = "jdbc:sqlite:C:\\Users\\good_\\Desktop\\Students.db";
		@Override
		public void start(Stage primaryStage) throws Exception {
		//DATABASE Connection
			 try {
				 Class.forName("org.sqlite.JDBC");
				 db = DriverManager.getConnection(url); //Establishing connection to Database
				 System.out.println("Connected to Tunngle"); //Successful message
			 }
			 catch(SQLException e) {
				 System.err.println("Connection Failed"); //Failure to connect
				 e.printStackTrace(); //Traces what went wrong in program
				 System.exit(1); //Exit program
			 }

		}
		
	}