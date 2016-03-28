/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bi_project2;

/**
 *
 * @author abhi9bakshi
 */
import javafx.beans.property.SimpleStringProperty;
 
public class Student {
   private final SimpleStringProperty Sr_no;
   private final SimpleStringProperty Branch;
   private final SimpleStringProperty SSC ;
   private final SimpleStringProperty HSC;
   private final SimpleStringProperty FE_sem_1;
   private final SimpleStringProperty FE_sem_2 ;
   private final SimpleStringProperty SE_sem_1;
   private final SimpleStringProperty SE_sem_2 ;
   private final SimpleStringProperty TE_sem_1;
   private final SimpleStringProperty TE_sem_2 ;
   private final SimpleStringProperty BE_sem_1;
   private final SimpleStringProperty Aggregate;
   private final SimpleStringProperty Num_live_backlogs ;
   private final SimpleStringProperty Num_dead_backlogs ;
   private final SimpleStringProperty Num_years_down ;
   private final SimpleStringProperty Package ;
   
    public Student(String sr_no,String branch,String ssc,String hsc,String fe_sem1,String fe_sem2,String se_sem1,String se_sem2,String te_sem1,String te_sem2,String be_sem1,String num_live_backs,String num_dead_backs,String num_years_down,String aggregate,String pack)
   {
        Sr_no= new SimpleStringProperty(sr_no);
        Branch= new SimpleStringProperty(branch);
        SSC=   new SimpleStringProperty(ssc);
        HSC=new SimpleStringProperty(hsc);
        FE_sem_1=new SimpleStringProperty(fe_sem1);
        FE_sem_2=new SimpleStringProperty(fe_sem2);
        SE_sem_1=new SimpleStringProperty(se_sem1);
        SE_sem_2=new SimpleStringProperty(se_sem2);
        TE_sem_1=new SimpleStringProperty(te_sem1);
        TE_sem_2=new SimpleStringProperty(te_sem2);
        BE_sem_1=new SimpleStringProperty(be_sem1);
        Aggregate=new SimpleStringProperty(aggregate); 
        Num_live_backlogs=new SimpleStringProperty(num_live_backs);
        Num_dead_backlogs=new SimpleStringProperty(num_dead_backs);
        Num_years_down=new SimpleStringProperty(num_years_down);
        Package=new SimpleStringProperty(pack);
    }
    /*
    Student(String string, String string0, String string1, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9, String string10, String string11, String string12) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    */
    public String getSr_no()
    {
        return Sr_no.get();
    }
    public void setSr_no(String serial_num)
    {
        Sr_no.set(serial_num);
    }
    
    public String getBranch()
    {
        return Branch.get();
    }
    public void setBranch(String branch)
    {
        Branch.set(branch);
    }
    
    public String getSSC()
    {
        return SSC.get();
    }
    public void setSSC(String ssc)
    {
        SSC.set(ssc);
    }
    public String getHSC()
    {
        return HSC.get();
    }
    public void setHSC(String hsc)
    {
        HSC.set(hsc);
    }
    public String getFE_sem_1()
    {
        return FE_sem_1.get();
    }
    public void setFE_sem_1(String fe_sem1)
    {
        FE_sem_1.set(fe_sem1);
    }
    public String getFE_sem_2()
    {
        return FE_sem_2.get();
    }
    public void setFE_sem_2(String fe_sem2)
    {
        FE_sem_2.set(fe_sem2);
    }
    public String getSE_sem_1()
    {
        return SE_sem_1.get();
    }
    public void setSE_sem_1(String se_sem1)
    {
        SE_sem_1.set(se_sem1);
    }
    public String getSE_sem_2()
    {
        return SE_sem_2.get();
    }
    public void setSE_sem_2(String se_sem2)
    {
        SE_sem_2.set(se_sem2);
    }
    
    public String getTE_sem_1()
    {
        return SE_sem_1.get();
    }
    public void setTE_sem_1(String te_sem1)
    {
        TE_sem_1.set(te_sem1);
    }
    public String getTE_sem_2()
    {
        return TE_sem_2.get();
    }
    
    public String getBE_sem_1()
    {
        return BE_sem_1.get();
    }
    
    public void setBE_sem_1(String be_sem1)
    {
        BE_sem_1.set(be_sem1);
    }
    
    public String getAggregate()
    {
        return Aggregate.get();
    }
    
    public void setAggregate(String aggr) 
    {
        Aggregate.set(aggr);
    }
    
    public String getNum_live_backlogs()
    {
        return Num_live_backlogs.get();
    }
    
    public void setNum_live_backlogs(String num_live_backs) 
    {
        Num_live_backlogs.set(num_live_backs);
    }
    
    
    public String getNum_dead_backlogs()
    {
        return Num_dead_backlogs.get();
    }
    
    public void setNum_dead_backlogs(String num_dead_backs) 
    {
        Num_dead_backlogs.set(num_dead_backs);
    }
   
    
    public String getNum_years_down()
    {
        return Num_years_down.get();
    }
    
    public void setNum_years_down(String num_years_down) 
    {
        Num_years_down.set(num_years_down);
    }

    public String getPackage()
    {
        return Package.get();
    }
    
    public void setPackage(String fName) 
    {
        Package.set(fName);
    }
}