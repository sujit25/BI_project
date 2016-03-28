/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bi_project2;
import weka.classifiers.functions.SMOreg;
import weka.core.Instances;
import weka.core.Instance;
import weka.core.converters.ConverterUtils.DataSource;
import java.io.File;
import java.io.IOException;
import weka.core.converters.CSVSaver;

//import java.io.IOException;

public class Classify
{
	private static  Instances testDataSet;  //test dataset
	private static  Instances trainDataSet; //train dataset
        private static  Instances resultDataSet; // result dataset
        private static  Instance instanceVal;   //current instance
	private static  SMOreg smo;          // classifier
        private static  CSVSaver saver;        //csv saver
        
        private static  String destination_path;
        
        public Classify()
        {
            saver = new CSVSaver();        
	    smo = new SMOreg(); // create a new SMO classifier-create
        }
	// step1: load dataSet
	public void loadDataSet(File Training, File Testing) 
	{
		try 
		{
			// load the training dataset
			DataSource datasource = new DataSource(Training.toString());
			trainDataSet = datasource.getDataSet();
			// set class index
			trainDataSet.setClassIndex(trainDataSet.numAttributes() - 1);
			DataSource newdatasource = new DataSource(Testing.toString());
			testDataSet = newdatasource.getDataSet();
			// set class index
			testDataSet.setClassIndex(testDataSet.numAttributes() - 1);
	        }
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
                destination_path = Testing.getParent();
                System.out.println("destionation path is" + destination_path);
                System.out.println("successfully loaded test and training files");
	}

	//build classifier
	public void buildClassifier()
        {
		try 
                {
			smo.buildClassifier(trainDataSet); // supply instances to	model									// Classifier--build model
			System.out.println(smo.toString());
		}
                catch (Exception e)
                {
			System.out.println(e.getMessage());
		}
                System.out.print("Successfully build classifier");
	}

	// make predictions on test dataset
	public void makePredictions() 
        {
            
            resultDataSet = new Instances(testDataSet);
            for(int i=0;i<testDataSet.numInstances();i++) 
            { 
                instanceVal = testDataSet.instance(i);
                double predict_smo_val=0; 
                try 
                { 
                    predict_smo_val = smo.classifyInstance(instanceVal);
                    resultDataSet.instance(i).setClassValue(predict_smo_val);
                } 
                catch(Exception e)
                {
                    System.out.println("exception thrown !!"); 
                }    
            }	
            
            saver.setInstances(resultDataSet);
            try
            {    
                saver.setFile(new File(destination_path+"/result.csv"));
                saver.writeBatch();
                System.out.println("Successfully wrote results to file: "+ destination_path+"/result.csv");
            }
            catch(IOException e1)
            {
                System.out.println(e1.getMessage());
            }
	}
        
        public String getPredictedResults()
        {
            return destination_path+"/result.csv";
        }
}