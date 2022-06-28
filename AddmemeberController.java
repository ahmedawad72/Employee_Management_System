
package projectds;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import static projectds.FXMLDocumentController.List;
import static projectds.FXMLDocumentController.array;
import static projectds.FXMLDocumentController.write;


public class AddmemeberController implements Initializable {

    
    Employee first;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        first = new Employee();
    }    
    
    @FXML
    private Button addmember1;
    public void addmember(ActionEvent event1){
        
        if(FXMLDocumentController.itisarray==true){
            FXMLDocumentController.array.insert(first);
            write("F:\\empployee\\projectDS\\input.txt",array);
        }
        else{
            FXMLDocumentController.List.insert(first);
            write("F:\\empployee\\projectDS\\output.txt",List);
        }
    }
    
    @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;
    private Button cancel;
    public void back(ActionEvent r) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        stage = (Stage)((Node)r.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
    }
    
    @FXML
    private TextField name;
    public void setname (ActionEvent event){
        String s=name.getText();
        first.setName(s);
    }

    @FXML
    private TextField salary;
    public void setsalary(ActionEvent event){
        int x=Integer.parseInt(salary.getText());
        first.setSalary(x);
    }

    @FXML
    private TextField department;
    public void setdepartment (ActionEvent event){
        String s=department.getText();
        first.setDepartment(s);
    }
    
    @FXML
    private TextField year;
    
    @FXML
    private TextField month;
    
    @FXML
    private TextField day;
    public void setdat(ActionEvent event){
        first.setDOB(Integer.parseInt(year.getText()),Integer.parseInt(month.getText()), Integer.parseInt(day.getText()));
        first.display();
    }
      
}
