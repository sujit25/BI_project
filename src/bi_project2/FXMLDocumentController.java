/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bi_project2;

import java.io.File;
import java.net.URL;
import javafx.collections.ObservableList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import org.javafxdata.datasources.provider.CSVDataSource;
import org.javafxdata.datasources.reader.DataSourceReader;
import com.csvreader.CsvReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import javafx.collections.FXCollections;
/**
 * @author abhi9bakshi && sujit
 */

  public class FXMLDocumentController implements Initializable
  {
    
    private Classify obj ;    
    private File fileTraining, fileTesting;
    private DataSourceReader dsr1;
    private CSVDataSource ds1;
    private String resultFilePath;
    private CsvReader csvreader;
    private ObservableList<Student> student_result_list;
   
    @FXML
    private TextField textfield_training, textfield_testing;
    
    @FXML
    private Label label_title;
    @FXML
    private TableView<Student> disp_table;
    @FXML
    private TableColumn<Student, String> Sr_No   ;
    @FXML
    private TableColumn<Student, String> Branch  ;
    @FXML
    private TableColumn<Student, String> SSC  ; 
    @FXML
    private TableColumn<Student, String> HSC  ;
    @FXML
    private TableColumn<Student, String> FE_sem_1  ; 
    @FXML
    private TableColumn<Student, String> FE_sem_2  ;    
    @FXML
    private TableColumn<Student, String> SE_sem_1  ;
    @FXML
    private TableColumn<Student, String> SE_sem_2  ;    
    @FXML
    private TableColumn<Student, String> TE_sem_1  ;    
    @FXML
    private TableColumn<Student, String> TE_sem_2  ;    
    @FXML
    private TableColumn<Student, String> BE_sem_1  ;
    @FXML
    private TableColumn<Student, String> Aggregate  ;
    @FXML
    private TableColumn<Student, String> live_backlogs  ;
    @FXML
    private TableColumn<Student, String> dead_backlogs  ;
    @FXML
    private TableColumn<Student, String> years_down  ;
    @FXML
    private TableColumn<Student, String> Package  ;
    
    
    @FXML
    private void handleTrainingButtonAction(ActionEvent event)
    {
        Node node = (Node) event.getSource();
        FileChooser fileChooserTraining = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("CSV files (*.csv)", "*.csv");
        fileChooserTraining.getExtensionFilters().add(extFilter);
        fileTraining = fileChooserTraining.showOpenDialog(node.getScene().getWindow());
        textfield_training.setText(fileTraining.toString());
        System.out.println(fileTraining);
    }
    
    @FXML
    private void handleTestingButtonAction(ActionEvent event) {
        Node node = (Node) event.getSource();
        FileChooser fileChooserTesting = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("CSV files (*.csv)", "*.csv");
        fileChooserTesting.getExtensionFilters().add(extFilter);
        fileTesting = fileChooserTesting.showOpenDialog(node.getScene().getWindow());
        textfield_testing.setText(fileTesting.toString());
        System.out.println(fileTesting);
    }
    
    @FXML
    private void handleGenerateButtonAction(ActionEvent event)
    {
        if(fileTesting != null && fileTraining!= null)
        {
            obj.loadDataSet(fileTraining,fileTesting);
            obj.buildClassifier();
            obj.makePredictions();
            resultFilePath = obj.getPredictedResults();
            displayResults(); 
        }
        else
        {
            
        }    
    }
    
    public void displayResults()
    {
        try
        {    
            csvreader = new CsvReader(resultFilePath);
            csvreader.readHeaders();
            System.out.println("displaying results");
            int count =1;
            while(csvreader.readRecord())
            {   
                String branch= csvreader.get("Branch");
                String ssc = csvreader.get("SSC");
                String hsc= csvreader.get("HSC");
                String fe1 = csvreader.get("FE1");
                String fe2= csvreader.get("FE2");
                String se1 = csvreader.get("SE1");
                String se2= csvreader.get("SE2");
                String te1 = csvreader.get("TE1");
                String te2= csvreader.get("TE2");
                String be1 = csvreader.get("BE1");
                String aggr = csvreader.get("Agg.");    
                String num_live_backs= csvreader.get("LiveBacklogs");
                String num_dead_backs= csvreader.get("DeadBacklogs");
                String num_yrs_down = csvreader.get("NumYearsDown");
                String pack = csvreader.get("Package");
                
                student_result_list.add(new Student(String.valueOf(count),branch,ssc,hsc,fe1,fe2,se1,se2,te1,te2,be1,aggr,num_live_backs,num_dead_backs,num_yrs_down,pack));                
                count++;   
           }
        }
        catch(FileNotFoundException f)
        {
            System.out.println(f.getMessage());
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        } 
        disp_table.setItems(student_result_list);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        obj = new Classify();
        
        student_result_list = FXCollections.observableArrayList();
        //Sr_No.setCellValueFactory((new PropertyValueFactory<>("Sr_No")));
        
        
        Sr_No.setCellValueFactory((new PropertyValueFactory<>("Sr_no")));
        Branch.setCellValueFactory((new PropertyValueFactory<>("Branch")));
        SSC.setCellValueFactory((new PropertyValueFactory<>("SSC")));
        HSC.setCellValueFactory((new PropertyValueFactory<>("HSC")));
        FE_sem_1.setCellValueFactory((new PropertyValueFactory<>("FE_sem_1")));
        FE_sem_2.setCellValueFactory((new PropertyValueFactory<>("FE_sem_2")));
        SE_sem_1.setCellValueFactory((new PropertyValueFactory<>("SE_sem_1")));
        SE_sem_2.setCellValueFactory((new PropertyValueFactory<>("SE_sem_2"))); 
        TE_sem_1.setCellValueFactory((new PropertyValueFactory<>("TE_sem_1")));
        TE_sem_2.setCellValueFactory((new PropertyValueFactory<>("TE_sem_2")));
        BE_sem_1.setCellValueFactory((new PropertyValueFactory<>("BE_sem_1")));
        Aggregate.setCellValueFactory((new PropertyValueFactory<>("Aggregate")));
        live_backlogs.setCellValueFactory((new PropertyValueFactory<>("Num_live_backlogs")));
        dead_backlogs.setCellValueFactory((new PropertyValueFactory<>("Num_dead_backlogs")));
        years_down.setCellValueFactory((new PropertyValueFactory<>("Num_years_down")));
        Package.setCellValueFactory((new PropertyValueFactory<>("Package")));
        //student_result_list.add(new Student("1","2","3","4","5","6","7","8","9","10","11","12","13","14","15"));
        disp_table.setItems(student_result_list);
                
    }    
    
}
