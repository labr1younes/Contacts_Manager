package application;

import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class SecondController {

	@FXML
    private Button BtnConfirmUpdate;
	@FXML
    private Button BtnDelete;

    @FXML
    private TextField updateAddress = new TextField();

    @FXML
    private TextField updateCity= new TextField();

    @FXML
    private TextField updateEmail= new TextField();

    @FXML
    private TextField updateFName= new TextField();

    @FXML
    private TextArea updateInformations= new TextArea();

    @FXML
    private TextField updateLName= new TextField();

    @FXML
    private TextField updatePNumber= new TextField();

    @FXML
    private TextField updateWilaya= new TextField();
    
    @FXML
    private Label labelID = new Label();
    
    @FXML
    private TableView<Contact> tblTable = new TableView<Contact>();
    
    @FXML
    void initialize() {
    	 }
    
    @FXML
    void confirm_change(ActionEvent event) {
    	
    	String first_name = updateFName.getText();
     	String last_name   = updateLName.getText();
     	String phone_number = updatePNumber.getText();
     	String email = updateEmail.getText();
    	String address =updateAddress.getText();
    	String city = updateCity.getText();
    	String wilaya = updateWilaya.getText();
    	String informations = updateInformations.getText();
    	int id = Integer.parseInt(labelID.getText()) ;
    	
    	functions f = new functions();
    	f.update_contact(id,first_name, last_name, phone_number, email, address, city, wilaya, informations);
    	
    	Stage stage = (Stage) BtnConfirmUpdate.getScene().getWindow();
    	stage.close();
    }
    

     
     @FXML 
     void confirm_delete(){
    	
    	 Alert alert = new Alert(AlertType.CONFIRMATION);
    	 alert.setContentText("Do you want to delete this contact  ?");
    	 alert.setTitle("Delete Contact ");
    	 functions f = new functions();
    	 Stage stage = (Stage) BtnDelete.getScene().getWindow();
    	 
    	 Optional<ButtonType> result = alert.showAndWait();
    	  	 

    	 if (result.isPresent() && result.get() == ButtonType.OK) {
    		 
    		 f.delete_contact(Integer.parseInt(labelID.getText()));
    		 stage.close();
    	 }
    	 
    	 
     }
     
     void initwindowint(int id,String f_name,String l_name, String ph_number, String email, String adrs, String city, String wlaya, String information) {
     	
    	labelID.setText(""+id) ;
    	updateFName.setText(f_name);
     	updateLName.setText(l_name);
     	updatePNumber.setText(ph_number);
     	updateEmail.setText(email);
    	updateAddress.setText(adrs);
    	updateCity.setText(city);
    	updateWilaya.setText(wlaya);
    	updateInformations.setText(information);
    	
    	
    }
   
}
