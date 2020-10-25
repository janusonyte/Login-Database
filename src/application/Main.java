package application;

import java.util.ArrayList;
import java.util.Optional;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;


public class Main extends Application 
{	
	Controller c = new Controller();//instance of controller class


	@Override
	public void start(Stage primaryStage) 
	{
		try 
		{
			GridPane grid = new GridPane();
			grid.setAlignment(Pos.CENTER);
			grid.setHgap(10);
			grid.setVgap(10);
			grid.setPadding(new Insets(25,25,25,25));

			Text scenetitle = new Text("Code Division");
			scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
			grid.add(scenetitle, 0, 0, 2, 1);

			Label userName = new Label("User Name: ");
			grid.add(userName, 0, 1);
			TextField userTextField =  new TextField();
			grid.add(userTextField, 1, 1);

			Label pw = new Label("Password: ");
			grid.add(pw, 0, 2);
			PasswordField pwField =  new PasswordField();
			grid.add(pwField, 1, 2);

			Button signIn = new Button("Sign In");
			Button signUp = new Button("Sign Up");
			HBox hbBtn = new HBox(10);
			hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
			hbBtn.getChildren().add(signIn);
			hbBtn.getChildren().add(signUp);
			grid.add(hbBtn, 1, 4);

			//			
			//			HBox hbBtn0 = new HBox(10);
			//			hbBtn0.setAlignment(Pos.BOTTOM_RIGHT);
			//			hbBtn0.getChildren().add(signUp);
			//			grid.add(hbBtn0, 1, 4);

			final Text caution = new Text();
			grid.add(caution, 1, 6);


			//code for scene 1 - sign UP
			//setting grid
			GridPane grid1 = new GridPane();
			grid1.setAlignment(Pos.CENTER);
			grid1.setHgap(10);
			grid1.setVgap(10);
			grid1.setPadding(new Insets(25,25,25,25));

			//setting scene
			Text scenetitle1 = new Text("Code Division");
			scenetitle1.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
			grid1.add(scenetitle1, 0, 0, 2, 1);

			//first name
			Label firstName = new Label("First Name: ");
			grid1.add(firstName, 0, 1);
			TextField fnTextField =  new TextField();
			grid1.add(fnTextField, 1, 1);

			//last name
			Label lastName = new Label("Last Name: ");
			grid1.add(lastName, 0, 2);
			TextField lnTextField =  new TextField();
			grid1.add(lnTextField, 1, 2);

			//username
			Label userName1 = new Label("User Name: ");
			grid1.add(userName1, 0, 3);
			TextField userTextField1 =  new TextField();
			grid1.add(userTextField1, 1, 3);

			//password
			Label pw1 = new Label("Password: ");
			grid1.add(pw1, 0, 4);
			PasswordField pwField1 =  new PasswordField();
			grid1.add(pwField1, 1, 4);

			//register and back buttons
			Button register = new Button("Register");
			Button back = new Button("Back");
			HBox hbBtn1 = new HBox(10);
			hbBtn1.setAlignment(Pos.BOTTOM_RIGHT);
			hbBtn1.getChildren().add(back);
			hbBtn1.getChildren().add(register);
			grid1.add(hbBtn1, 1, 5);


			//code for scene 2 - USER INFORMATION
			//setting grid
			GridPane grid2 = new GridPane();
			grid2.setAlignment(Pos.CENTER);
			grid2.setHgap(10);
			grid2.setVgap(10);
			grid2.setPadding(new Insets(25,25,25,25));

			//setting scene
			Text scenetitle2 = new Text("Welcome, " + userTextField.getText());
			scenetitle2.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
			scenetitle2.setTextAlignment(TextAlignment.CENTER);
			grid2.add(scenetitle2, 0, 0, 2, 1);

			//retrieved first name
			Label retrievedFirstName = new Label("First Name: " );
			//			retrievedFirstName.setTextAlignment(TextAlignment.CENTER);
			retrievedFirstName.setContentDisplay(ContentDisplay.TOP);
			grid2.add(retrievedFirstName, 1, 1);
			//			TextField fnTextField =  new TextField();
			//			grid1.add(fnTextField, 1, 1);

			//retrieved last name
			Label retrievedLastName = new Label("Last Name: ");
			grid2.add(retrievedLastName, 1, 2);
			retrievedLastName.setTextAlignment(TextAlignment.CENTER);
			//			TextField lnTextField =  new TextField();
			//			grid1.add(lnTextField, 1, 2);

			//retrieved username
			Label retrievedUserName = new Label("User Name: ");
			grid2.add(retrievedUserName, 1, 3);
			retrievedUserName.setTextAlignment(TextAlignment.CENTER);
			//			TextField userTextField1 =  new TextField();
			//			grid1.add(userTextField1, 1, 3);

			//retrieved password
			Label retrievedPassword = new Label("Password: ");
			grid2.add(retrievedPassword, 1, 4);
			retrievedPassword.setTextAlignment(TextAlignment.CENTER);
			//			PasswordField pwField1 =  new PasswordField();
			//grid1.add(pwField1, 1, 4);

			//UPDATE, LOG OFF, DELETE PROFILE buttons
			Button settings = new Button("Settings");
			Button logoff = new Button("Log Off");
			HBox hbBtn2 = new HBox(10);
			hbBtn2.setAlignment(Pos.BOTTOM_CENTER);
			hbBtn2.getChildren().add(logoff);
			hbBtn2.getChildren().add(settings);
			grid2.add(hbBtn2, 1, 6);

			//code for scene 3 - UPDATING USER INFORMATION
			//setting grid
			GridPane grid3 = new GridPane();
			grid3.setAlignment(Pos.CENTER);
			grid3.setHgap(10);
			grid3.setVgap(10);
			grid3.setPadding(new Insets(25,25,25,25));

			//setting scene
			Text scenetitle3 = new Text("Updating your profile");
			scenetitle3.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
			scenetitle3.setTextAlignment(TextAlignment.CENTER);
			grid3.add(scenetitle3, 0, 0, 2, 1);

			//update retrieved first name
			Label updateFirstName = new Label("First Name: " );
			grid3.add(updateFirstName, 0, 1);
			TextField updateFnTextField =  new TextField();
			grid3.add(updateFnTextField, 1, 1);

			//update retrieved last name
			Label updateLastName = new Label("Last Name: ");
			grid3.add(updateLastName, 0, 2);
			TextField updateLnTextField =  new TextField();
			grid3.add(updateLnTextField, 1, 2);

			//update retrieved username
			Label updateUserName = new Label("User Name: ");
			grid3.add(updateUserName, 0, 3);
			TextField updateUnTextField =  new TextField();
			grid3.add(updateUnTextField, 1, 3);

			//update retrieved password
			Label updatePassword = new Label("Password: ");
			grid3.add(updatePassword, 0, 4);
			PasswordField updatePwField =  new PasswordField();
			grid3.add(updatePwField, 1, 4);

			//UPDATE, LOG OFF, DELETE PROFILE buttons
			Button update = new Button("Update details");
			Button delete = new Button("Delete Profile");
			Button back1 = new Button("Back to profile");
			Button logoff1 = new Button("Log Off");
			HBox hbBtn3 = new HBox(10);
			hbBtn3.setAlignment(Pos.BOTTOM_CENTER);
			hbBtn3.getChildren().add(update);
			hbBtn3.getChildren().add(logoff1);
			hbBtn3.getChildren().add(delete);
			hbBtn3.getChildren().add(back1);
			grid3.add(hbBtn3, 1, 6);


			Scene scene = new Scene(grid, 300, 275);//login/register welcome scene
			Scene scene1 = new Scene(grid1, 400, 300);//sign up scene
			Scene scene2 = new Scene(grid2, 500, 275);//user information scene
			Scene scene3 = new Scene(grid3, 600, 400); //go to update/delete scene

			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Code Division");
			primaryStage.show();


			//sign up action for button
			signUp.setOnAction(new EventHandler<ActionEvent>() 
			{
				public void handle(ActionEvent e)
				{
					primaryStage.setScene(scene1);
				}
			});

			//back action for button //back to sign in
			back.setOnAction(new EventHandler<ActionEvent>() 
			{
				public void handle(ActionEvent e)
				{

					primaryStage.setScene(scene);
				}
			});

			//register action for button
			register.setOnAction(new EventHandler<ActionEvent>() 
			{
				public void handle(ActionEvent e)
				{


					//					primaryStage.setScene(scene);
					c.setInput(fnTextField.getText(), lnTextField.getText(), userTextField1.getText(), pwField1.getText());
					if(c.getValid()== true)
					{
						c.setUser(fnTextField.getText(), lnTextField.getText(), userTextField1.getText(), pwField1.getText());

						userTextField1.setText("");
						pwField1.setText("");
						fnTextField.setText("");
						lnTextField.setText("");
						Alert registerAlert = new Alert(AlertType.INFORMATION);
						registerAlert.setContentText("Registration Successful");
						registerAlert.show();
					}
					else 
					{
						Alert registerError = new Alert(AlertType.ERROR);
						registerError.setContentText("Registration failed, please check details");
						registerError.show();
					}

				}
			});

			signIn.setOnAction(new EventHandler<ActionEvent>() 
			{
				public void handle(ActionEvent e)
				{
					boolean userInDb = c.checkUser(userTextField.getText(), pwField.getText());
					if(userInDb == true)
					{
						primaryStage.setScene(scene2);
						System.out.println("user returned to main");
						ArrayList<String> ret = c.getUser(userTextField.getText(), pwField.getText());
						scenetitle2.setText("Welcome, " + ret.get(0));
						retrievedFirstName.setText("First Name: " + ret.get(0));
						retrievedLastName.setText("Last Name: " + ret.get(1));
						retrievedUserName.setText("Username: " + ret.get(2));
						retrievedPassword.setText("Password: " + ret.get(3));

					}
					else
					{
						caution.setFill(Color.FIREBRICK);
						caution.setText("User not found");	
					}


				}
			});

			//Log Off button
			logoff.setOnAction(new EventHandler<ActionEvent>() 
			{
				public void handle(ActionEvent e)
				{
					userTextField.setText("");
					pwField.setText("");
					primaryStage.setScene(scene);

				}
			});

			//Log Off button
			logoff1.setOnAction(new EventHandler<ActionEvent>() 
			{
				public void handle(ActionEvent e)
				{
					userTextField.setText("");
					pwField.setText("");
					primaryStage.setScene(scene);

				}
			});

			back1.setOnAction(new EventHandler<ActionEvent>() //back to user profile
					{
				public void handle(ActionEvent e)
				{

					primaryStage.setScene(scene2);
				}
					});

			settings.setOnAction(new EventHandler<ActionEvent>() //go to Update/delete scene
					{
				public void handle(ActionEvent e)
				{

					primaryStage.setScene(scene3);
				}
					});


			delete.setOnAction(new EventHandler<ActionEvent>() //delete user profile
					{
				public void handle(ActionEvent e)
				{
					//insert code to delete user details
					boolean userInDb = c.checkUser(userTextField.getText(), pwField.getText());
					if(userInDb == true)
					{
						Alert deleteAlert = new Alert(AlertType.CONFIRMATION);
						deleteAlert.setTitle("Deleting profile");
						deleteAlert.setHeaderText("Your profile is about to be deleted");
						deleteAlert.setContentText("Click OK if you wish to delete your profile");
						Optional<ButtonType> result = deleteAlert.showAndWait();
						
						if (result.get() == ButtonType.OK)
						{
							c.deleteProfile(userTextField.getText(), pwField.getText());
							Alert deleteSuccess = new Alert(AlertType.INFORMATION);
							deleteSuccess.setContentText("Profile deleted");
							deleteSuccess.show();
							primaryStage.setScene(scene);
							
							userTextField.setText("");
							pwField.setText("");
						} 
						else
						{
							System.out.println("Profile was not deleted - user clicked cancel");
						}			
					}
					else
					{
						Alert deleteError = new Alert(AlertType.ERROR);
						deleteError.setContentText("Delete failed");
						deleteError.show();
					}
				}
					});

			update.setOnAction(new EventHandler<ActionEvent>() //update user profile
					{
				public void handle(ActionEvent e)
				{
					//insert code to update user details

					boolean userInDb = c.checkUser(userTextField.getText(), pwField.getText());
					if(userInDb == true)
					{
						//System.out.println("user update returned to main");

						c.setInput(updateFnTextField.getText(), updateLnTextField.getText(), updateUnTextField.getText(), updatePwField.getText());
						if(c.getValid()== true)
						{
							c.updateDetails(userTextField.getText(), pwField.getText(),updateFnTextField.getText(), updateLnTextField.getText(), updateUnTextField.getText(), updatePwField.getText());

							Alert updateAlert = new Alert(AlertType.INFORMATION);
							updateAlert.setContentText("Profile details updated");
							updateAlert.show();
							
							ArrayList<String> ret = c.getUser(updateUnTextField.getText(), updatePwField.getText());
							scenetitle2.setText("Welcome, " + ret.get(0));
							retrievedFirstName.setText("First Name: " + ret.get(0));
							retrievedLastName.setText("Last Name: " + ret.get(1));
							retrievedUserName.setText("Username: " + ret.get(2));
							retrievedPassword.setText("Password: " + ret.get(3));
							
							updateFnTextField.setText("");
							updateLnTextField.setText("");
							updateUnTextField.setText("");
							updatePwField.setText("");
						}
						else 
						{
							Alert updateError = new Alert(AlertType.ERROR);
							updateError.setContentText("Update failed, please fill all fields.");
							updateError.show();
						}
					}
					else
					{
						caution.setFill(Color.FIREBRICK);
						caution.setText("User not found");	
					}
				}
					});


		} 
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}

	public static void main(String[] args) 
	{
		launch(args);
	}
}//end of class
