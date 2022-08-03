package application;



//import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class MainController {
	
    @FXML
    private Button BtnAddContact;

    @FXML
    private Button BtnContacts;

    @FXML
    private Button BtnNotes;

    @FXML
    private Button BtnSettings;

    @FXML
    private Label lblStatus;

    @FXML
    private GridPane paneContacts;

    @FXML
    private AnchorPane  paneNotes;

    @FXML
    private AnchorPane  paneSettigns;

    @FXML
    private Pane paneStatus;
    
    @FXML
    private Button BtnConfirm;

    @FXML
    private TextArea txtareaInformations;

    @FXML
    private TextField txtfldAddress;

    @FXML
    private TextField txtfldCity;

    @FXML
    private TextField txtfldEmail;

    @FXML
    private TextField txtfldFName;

    @FXML
    private TextField txtfldLName;

    @FXML
    private TextField txtfldPNumber;

    @FXML
    private TextField txtfldWilaya;
    
    @FXML
    private TableColumn<Contact, String> colEmail= new TableColumn<>();

    @FXML
    private TableColumn<Contact, String> colID= new TableColumn<>();

    @FXML
    private TableColumn<Contact, String> colName= new TableColumn<>();

    @FXML
    private TableColumn<Contact, String> colPhone= new TableColumn<>();

    @FXML
    private TableColumn<Contact, String> colFName= new TableColumn<>();
    
    @FXML
    private TableView<Contact> tblTable = new TableView<Contact>();

    

    @FXML
    void initialize() {
    	 assert BtnAddContact != null : "fx:id=\"BtnAddContact\" was not injected: check your FXML file 'Main.fxml'.";
         assert BtnContacts != null : "fx:id=\"BtnContacts\" was not injected: check your FXML file 'Main.fxml'.";
         assert BtnNotes != null : "fx:id=\"BtnNotes\" was not injected: check your FXML file 'Main.fxml'.";
         assert BtnSettings != null : "fx:id=\"BtnSettings\" was not injected: check your FXML file 'Main.fxml'.";
         assert lblStatus != null : "fx:id=\"lblStatus\" was not injected: check your FXML file 'Main.fxml'.";
         assert paneContacts != null : "fx:id=\"paneContacts\" was not injected: check your FXML file 'Main.fxml'.";
         assert paneNotes != null : "fx:id=\"paneNotes\" was not injected: check your FXML file 'Main.fxml'.";
         assert paneStatus != null : "fx:id=\"paneStatus\" was not injected: check your FXML file 'Main.fxml'.";
         assert BtnConfirm != null : "fx:id=\"BtnConfirm\" was not injected: check your FXML file 'Add_window.fxml'.";
         assert txtareaInformations != null : "fx:id=\"txtareaInformations\" was not injected: check your FXML file 'Add_window.fxml'.";
         assert txtfldAddress != null : "fx:id=\"txtfldAddress\" was not injected: check your FXML file 'Add_window.fxml'.";
         assert txtfldCity != null : "fx:id=\"txtfldCity\" was not injected: check your FXML file 'Add_window.fxml'.";
         assert txtfldEmail != null : "fx:id=\"txtfldEmail\" was not injected: check your FXML file 'Add_window.fxml'.";
         assert txtfldFName != null : "fx:id=\"txtfldFName\" was not injected: check your FXML file 'Add_window.fxml'.";
         assert txtfldLName != null : "fx:id=\"txtfldLName\" was not injected: check your FXML file 'Add_window.fxml'.";
         assert txtfldPNumber != null : "fx:id=\"txtfldPNumber\" was not injected: check your FXML file 'Add_window.fxml'.";
         assert txtfldWilaya != null : "fx:id=\"txtfldWilaya\" was not injected: check your FXML file 'Add_window.fxml'.";
         assert tblTable != null : "fx:id=\"tblTable\" was not injected: check your FXML file 'Main.fxml'.";
         assert colEmail != null : "fx:id=\"colEmail\" was not injected: check your FXML file 'Main.fxml'.";
         assert colFName != null : "fx:id=\"colFName\" was not injected: check your FXML file 'Main.fxml'.";
         assert colID != null : "fx:id=\"colID\" was not injected: check your FXML file 'Main.fxml'.";
         assert colName != null : "fx:id=\"colName\" was not injected: check your FXML file 'Main.fxml'.";
         
    	
    	 showing();
    }

    @FXML
    private void clickhandle (ActionEvent event) {
    	
    	if (event.getSource() ==BtnContacts) {
    		lblStatus.setText("Contacts");
    		paneStatus.setBackground(new Background(new BackgroundFill(Color.rgb(63, 114, 175),CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));
    		paneContacts.toFront();
    		showing();
    	}
    	
    	if (event.getSource() ==BtnNotes) {
    		lblStatus.setText("Notes");
    		paneStatus.setBackground(new Background(new BackgroundFill(Color.rgb(127, 82, 131),CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));
    		paneNotes.toFront();
    	}
    	
    	if (event.getSource() ==BtnSettings) {
    		lblStatus.setText("Settings");
    		paneStatus.setBackground(new Background(new BackgroundFill(Color.rgb(5, 89, 91),CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));
    		paneSettigns.toFront();
    	}
    	
    	
    }
    
    @FXML
    private void open_add_window() {
    	
    	try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Add_window.fxml"));
			AnchorPane root = loader.load() ; 
			
    		Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			Stage newWindow = new Stage();
			newWindow.setScene(scene);
			newWindow.setTitle("New Contact");
			newWindow.showAndWait();
			showing();


		} catch(Exception e) {
			e.printStackTrace();
		}
    	
    	
    	
    }
    
    @FXML
    private void confirm_inputs(ActionEvent event) {
    	
    	String first_name = txtfldFName.getText();
     	String last_name   = txtfldLName.getText();
     	String phone_number = txtfldPNumber.getText();
     	String email = txtfldEmail.getText();
    	String address =txtfldAddress.getText();
    	String city = txtfldCity.getText();
    	String wilaya = txtfldWilaya.getText();
    	String informations = txtareaInformations.getText();
    	
    	functions f = new functions();
    	f.add_contact(first_name, last_name, phone_number, email, address, city, wilaya, informations);
    	
    	Stage stage = (Stage) BtnConfirm.getScene().getWindow();
    	stage.close();
    	  	
    	
    }
    
    
    protected void showing() {
    	functions f = new functions();
    	ObservableList<Contact> list = f.getContact();
    	
    	colID.setCellValueFactory(new PropertyValueFactory<Contact, String>("id"));
    	colName.setCellValueFactory(new PropertyValueFactory<Contact, String>("first_name"));
    	colFName.setCellValueFactory(new PropertyValueFactory<Contact, String>("last_name"));
    	colPhone.setCellValueFactory(new PropertyValueFactory<Contact, String>("phone_number"));
    	colEmail.setCellValueFactory(new PropertyValueFactory<Contact, String>("email"));
    	
    	
    	tblTable.setItems(list);
    	
    }
    
    @FXML
    void clickmousehandle(MouseEvent  event) {
    	
    	
    	Contact contact  = tblTable.getSelectionModel().getSelectedItem();
    	
    	int id = contact.getId();
    	String first_name = contact.getFirst_name();
     	String last_name   = contact.getLast_name();
     	String phone_number = contact.getPhone_number();
     	String email = contact.getEmail();
    	String address =contact.getAddress();
    	String city = contact.getCity();
    	String wilaya = contact.getWilaya();
    	String informations = contact.getInformations();
    	
    	try {
    		
    	       	
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Edit_window.fxml"));
			AnchorPane root = loader.load() ; 
			
			SecondController secondcontroller =loader.getController();
			secondcontroller.initwindowint(id, first_name, last_name, phone_number, email, address, city, wilaya, informations);
			
    		Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
			Stage newWindow = new Stage();
			
			newWindow.setScene(scene);
			newWindow.setTitle("Update Contact");
			newWindow.showAndWait();
	    	
	    	showing();


		} catch(Exception e) {
			e.printStackTrace();
		}
    	
    	
    }	
     	
    	
    }
    

