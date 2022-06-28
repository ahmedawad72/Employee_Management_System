
package projectds;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import projectds.EmployeeArray;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class FXMLDocumentController implements Initializable {
    public static EmployeeArray array;
    public static EmployeeLinkedList List;
    //Scanner sc = new Scanner(System.in());
    public static boolean itisarray;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        array = new EmployeeArray();
        List=new EmployeeLinkedList();
        name.setCellValueFactory(new PropertyValueFactory<Employee,String>("name"));
        id.setCellValueFactory(new PropertyValueFactory<Employee,Integer>("id"));
        department.setCellValueFactory(new PropertyValueFactory<Employee,String>("department"));
        salary.setCellValueFactory(new PropertyValueFactory<Employee,Integer>("salary"));
        dob.setCellValueFactory(new PropertyValueFactory<Employee,String>("DOB"));
        
        for(int i=0 ; i<array.size() ; i++){
            table.getItems().add(array.getEmployee(i));
        }  
        
        if(itisarray==true){
            mychoice.getItems().addAll(sort);
            mychoice.setOnAction(this::getSort);
            mychoice2.getItems().addAll(sort);
            mychoice2.setOnAction(this::getSortid);
        }
        else{
            mychoice.getItems().addAll(sort2);
            mychoice.setOnAction(this::getSort);
            mychoice2.getItems().addAll(sort2);
            mychoice2.setOnAction(this::getSortid);
        }
        
        
        read("F:\\empployee\\projectDS\\input.txt",array);
        read("F:\\empployee\\projectDS\\output.txt",List);
        
    }    
    
    @FXML
    private TableView<Employee> table;

    @FXML
    private TableColumn<Employee, Integer> id;

    @FXML
    private TableColumn<Employee, String> name;

    @FXML
    private TableColumn<Employee, String> department;

    @FXML
    private TableColumn<Employee, Integer> salary;

    @FXML
    private TableColumn<Employee, String> dob;
      
    @FXML
    TextField textbox;
    public void delete (ActionEvent x){
        //work well
        if(itisarray==true){
            array.delete(textbox.getText());
            table.getItems().clear();
            for(int i=0 ; i<array.size() ; i++){
            table.getItems().add(array.getEmployee(i));
            }
        }
        else {
            List.delete(textbox.getText());
            table.getItems().clear();
            for(int i=0 ; i<List.size() ; i++){
                table.getItems().add(List.get(i));
            }
        }
    }
    
    @FXML
    Button linear;
    public void LinearSearch(ActionEvent z){
        //well well
        Employee x=new Employee();
        if(itisarray==true)
            x=array.linear_search_by_name(textbox.getText());
        else
            x=List.linear_search(textbox.getText());
        
        table.getItems().clear();
        table.getItems().add(x);
    }
   
    @FXML
    Button binarysearch;
    public void BinarySearch(ActionEvent y){
        //well welly
        Employee x=new Employee();
        if(itisarray==true){
            array.insertion_ascending_sort_by_name();
            x=array.binary_search_by_name(textbox.getText());
        }
        else{
            x=List.linear_search(textbox.getText());
        }
        table.getItems().clear();
        table.getItems().add(x);
    }
    
    @FXML
    private Button load;
    public void loading (ActionEvent j){
        if(itisarray==true){
            table.getItems().clear();
            for(int i=0 ; i<array.size() ; i++){
                table.getItems().add(array.getEmployee(i));
            }
        }
        else{
            table.getItems().clear();
            for(int i=0 ; i<List.size() ; i++){
                table.getItems().add(List.get(i));
            }
        }
    }
    
    @FXML
    private Button add;
    public static Stage window;
    private Stage stage;
    private Scene scene;
    private Parent root;
    public void addemployee(ActionEvent r) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("addmemeber.fxml"));
        stage = (Stage)((Node)r.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
    }
    
    
    
    @FXML
    private ChoiceBox<String> mychoice;
    
    private String [] sort2={"Bubble Sort ascending" , "Selection Sort ascending"
    , "Bubble Sort descending" , "Selection Sort descending"  };
    
    private String [] sort={"Bubble Sort ascending" , "Merge Sort ascending" , "Insertion Sort ascending" , "Selection Sort ascending"
    , "Bubble Sort descending" , "Merge Sort descending" , "Insertion Sort descending" , "Selection Sort descending"  };
    public void getSort(ActionEvent event){
        String mysort =mychoice.getValue();
        if(mysort=="Bubble Sort ascending" ){
            if(itisarray==true){
                array.bubble_ascending_sort_by_name();
                
            }
            else{
                List.bubble_ascending_sort_by_name();
                
            }
        }
        else if(mysort=="Merge Sort ascending"){
            if(itisarray==true){
                array.merge_sort_by_name(1, 0, array.size()-1);
                
            }
            
        }
        else if(mysort=="Insertion Sort ascending"){
            if(itisarray==true){
                array.insertion_ascending_sort_by_name();
                
            }
            else{
                
            }
        }
        else if (mysort=="Selection Sort ascending"){
            if(itisarray==true){
                array.selection_ascending_sort_byName();
                
            }
            else{
                List.selection_ascending_sort_by_name();
                
            }
        }
        else if(mysort=="Bubble Sort descending"){
            if(itisarray==true){
                array.bubble_descending_sort_by_name();
                
            }
            else{
                List.bubble_descending_sort_by_name();
                
            }
        }
        else if(mysort=="Merge Sort descending"){
            if(itisarray==true){
                array.merge_sort_by_name(-1, 0, array.size()-1);
                
            }
            
        }
        else if(mysort=="Insertion Sort descending"){
            if(itisarray==true){
                array.insertion_descending_sort_by_name();
                
            }
            
        }
        else{
            if(itisarray==true){
                array.selection_descending_sort_byName();
                
            }
            else{
                List.selection_descending_sort_by_name();
                
            }
        } 
        table.getItems().clear();
        if(itisarray==true){
            for(int i=0 ; i<array.size() ; i++){
                table.getItems().add(array.getEmployee(i));
            }
        }
        else{
            for(int i=0 ; i<List.size() ; i++){
                table.getItems().add(List.get(i));
            }
        }
    }
    
    
    @FXML
    private ChoiceBox<String> mychoice2;
    public void getSortid(ActionEvent event){
        String mysort =mychoice2.getValue();
        if(mysort=="Bubble Sort ascending" ){
            if(itisarray==true){
                array.bubble_ascending_sort_by_ID();
                
            }
            else{
                List.bubble_ascending_sort_by_ID();
                
            }
        }
        else if(mysort=="Merge Sort ascending"){
            if(itisarray==true){
                array.merge_sort_by_ID(1, 0, array.size()-1);
                
            }
            
        }
        else if(mysort=="Insertion Sort ascending"){
            if(itisarray==true){
                array.insertion_ascending_sort_by_ID();
                
            }
            
        }
        else if (mysort=="Selection Sort ascending"){
            if(itisarray==true){
                array.selection_ascending_sort_byID();
                
            }
            else{
                List.selection_ascending_sort_by_ID();
                
            }
       }
        else if(mysort=="Bubble Sort descending"){
            if(itisarray==true){
                array.bubble_descending_sort_by_ID();
                            }
            else{
                List.bubble_descending_sort_by_ID();
                
            }
        }
        else if(mysort=="Merge Sort descending"){
            if(itisarray==true){
                array.merge_sort_by_ID(-1, 0, array.size()-1);
                
            }
            
        }
        else if(mysort=="Insertion Sort descending"){
            if(itisarray==true){
                array.insertion_descending_sort_by_ID();
                
            }
            
        }
        else{
            if(itisarray==true){
                array.selection_descending_sort_byID();
                
            }
            else{
                List.selection_descending_sort_by_ID();
                
            }
        }
        table.getItems().clear();
        if(itisarray==true){
            for(int i=0 ; i<array.size() ; i++){
                table.getItems().add(array.getEmployee(i));
            } 
        }
        else{
           for(int i=0 ; i<List.size() ; i++){
                table.getItems().add(List.get(i));
            }  
        }

    }
   
    @FXML
    private RadioButton arrbutton;
    public void bool(ActionEvent event){
        itisarray=true;
        System.out.println(itisarray==true);
    } 

    @FXML
    private RadioButton linkbutton;
    public void booll(ActionEvent event){
        itisarray=false;
        System.out.println(itisarray==true);
    }
    
    @FXML
    private  void saveData(){
        if(itisarray==true)
            write("F:\\empployee\\projectDS\\input.txt",array);
        else
            write("F:\\empployee\\projectDS\\output.txt",List);
    } 
    public static boolean write(String path, EmployeeArray array) {
        try {
            File file = new File(path);
            FileWriter writer = new FileWriter(file);

            for(int index = 0; index < array.size(); index++)
                writer.write(array.getEmployee(index).line() + "\n");

            writer.close();
            return true;
        } catch (Exception e) {
            System.out.println("ERROR WRITING FILE");
            return false;
        }
    }
    public static boolean read(String path, EmployeeArray array) {
        try {
            File file = new File(path);
            Scanner reader = new Scanner(file);

            while(reader.hasNextLine()) {
                String[] splited = reader.nextLine().split("-");
                Employee first =new Employee();
                first.setName(splited[0]);
                first.setSalary(Integer.parseInt(splited[1]));
                first.setDepartment(splited[2]);
                first.setId(Integer.parseInt(splited[4]));
                String[] Dob=splited[3].split("/");
                first.setDOB(Integer.parseInt(Dob[0]), Integer.parseInt(Dob[1]), Integer.parseInt(Dob[2]));
                array.insert(first);
            }

            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("ERROR READING FILE");
            return false;
        }
    }
    
    
    public static boolean read(String path, EmployeeLinkedList array) {
        try {
            File file = new File(path);
            Scanner reader = new Scanner(file);

            while(reader.hasNextLine()) {
                String[] splited = reader.nextLine().split("-");
                Employee first =new Employee();
                first.setName(splited[0]);
                first.setSalary(Integer.parseInt(splited[1]));
                first.setDepartment(splited[2]);
                first.setId(Integer.parseInt(splited[4]));
                String[] Dob=splited[3].split("/");
                first.setDOB(Integer.parseInt(Dob[0]), Integer.parseInt(Dob[1]), Integer.parseInt(Dob[2]));
                array.insert(first);
            }
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("ERROR READING FILE");
            return false;
        }
    }
    public static boolean write(String path, EmployeeLinkedList List) {
        try {
            File file = new File(path);
            FileWriter writer = new FileWriter(file);

            for(int index = 0; index < List.size(); index++)
                writer.write(List.get(index).line() + "\n");

            writer.close();
            return true;
        } catch (Exception e) {
            System.out.println("ERROR WRITING FILE");
            return false;
        }
    }

}
