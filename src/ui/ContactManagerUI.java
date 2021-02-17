package ui;


import java.io.File;
import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import model.Contact;
import model.ContactManager;

public class ContactManagerUI{
	
	private ContactManager cManager;
	
	
	
    @FXML
    private Button addBtn;
	
    @FXML
    private VBox principalPane;

	  @FXML
	    private TextField txtName;

	    @FXML
	    private TextField txtEmail;

	    @FXML
	    private TableView<Contact> tblContact;  
	    
	    
	    


	    @FXML
	    private TableColumn<Contact, String> nameContactList;

	    @FXML
	    private TableColumn<Contact, String> emailContactList;
	    

	  	    public ContactManagerUI(ContactManager cm) {
	    	cManager =cm;
	    }




	  public void initialize() {
	    	
	    }
	    
		private void initializeTable() {
			ObservableList<Contact> contacts;
			contacts= FXCollections.observableArrayList(cManager.getContacts());			
		System.out.println(cManager.getContacts().size());	
			//asociar las columnas al modelo
			tblContact.setItems(contacts);
			nameContactList.setCellValueFactory(new PropertyValueFactory<Contact,String>("Name"));
			emailContactList.setCellValueFactory(new PropertyValueFactory<Contact,String>("Email"));

		}
	    

	
	
    @FXML
    void addContact(ActionEvent event) throws IOException {
    	
FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Add-Contact.fxml"));
		
		fxmlLoader.setController(this);    	
		Parent addRegisterPane = fxmlLoader.load();
    	
		principalPane.getChildren().setAll(addRegisterPane);
    	
    	
    
    	
  
  }

    @FXML
    void listContact(ActionEvent event) throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Contact-List.fxml"));
		
		fxmlLoader.setController(this);    	
		Parent addRegisterPane = fxmlLoader.load();
    	
		principalPane.getChildren().setAll(addRegisterPane);
    	initializeTable();
    	
    	
    	
    	
    	
//	FXMLLoader loader = new FXMLLoader(getClass().getResource("Contact-List.fxml"));
//    	
//		loader.setController(this);
//    	Parent addContactPane= loader.load();
//
//    	Scene scene= new Scene(addContactPane);
//    	Stage stage= new Stage();
//    	stage.initModality(Modality.APPLICATION_MODAL);
//    	
//    	stage.setScene(scene);
    	
    }
    

    @FXML
    void saveContact(ActionEvent event) {
    	
    	cManager.addContat(txtName.getText(), txtEmail.getText());
    	
    
 //  txtName.setText("");
   // txtEmail.setText("");
    	System.out.println("se ha registrado el usuario:"+txtName.getText());
    	System.out.println(txtEmail.getText());
    	
    //	Contact c = new Contact(txtName.getText(), txtEmail.getText());
    	 
    	 
//   	 if(!contacts.contains(c)) {
//    	
//    		 Alert alert = new Alert (Alert.AlertType.INFORMATION);
//    		 alert.setHeaderText(null);
//    		 alert.setTitle("informacion");
//    		 alert.setContentText("El contacto se ha añadido correctamente ");
//    		 alert.showAndWait();
//    		 
//    		 Stage stage =(Stage) addBtn.getScene().getWindow();
//    		 stage.close();
//    		 
//    	 }else {
//    		 Alert alert = new Alert (Alert.AlertType.INFORMATION);
//		 alert.setHeaderText(null);
//		 alert.setTitle("Error");
//		 alert.setContentText("La persona ya existe ");
//		 alert.showAndWait();
//    }
    }
    


    @FXML
   public void exportContact(ActionEvent event) {
    	FileChooser fileChooser = new FileChooser();
    	fileChooser.setTitle("Open Resource File");
    File f=	fileChooser.showSaveDialog(principalPane.getScene().getWindow());
    	
    	if(f!=null){
    		try {
    		Alert alert=new Alert(Alert.AlertType.INFORMATION);
   			alert.setTitle("Export Contacts");
    		cManager.importContacts(f.getAbsolutePath());
    		alert.setContentText("The contact data was exported succesfully");
			alert.showAndWait();
    		}catch(IOException e) {
    			Alert alert=new Alert(Alert.AlertType.ERROR);
       			alert.setTitle("Export Contacts");
        		alert.setContentText("The contacts data was not exported. An error ecurred");
    			alert.showAndWait();
    		}
    	}
    	
    	
    	
    }

    @FXML
    public void importContact(ActionEvent event) {
	FileChooser fileChooser = new FileChooser();
    	fileChooser.setTitle("Open Resource File");
    File f=	fileChooser.showOpenDialog(principalPane.getScene().getWindow());
    	
    	if(f!=null){
    		try {
    		Alert alert=new Alert(Alert.AlertType.INFORMATION);
   			alert.setTitle("Import Contacts");
    		cManager.importContacts(f.getAbsolutePath());
    		alert.setContentText("The contact data was imported succesfully");
			alert.showAndWait();
    		}catch(IOException e) {
    			Alert alert=new Alert(Alert.AlertType.ERROR);
       			alert.setTitle("Import Contacts");
        		alert.setContentText("The contacts data was not imported. An error ecurred");
    			alert.showAndWait();
    		}
    	}
    }


    



}
