package model;

import java.util.Calendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Project {
    
    private String namePRO;
    private String nameClient;
	private Calendar initialDate;
	private Calendar finalDate;
    private double budget;
    private String managerName;
    private String managerPhone;
    private String managerCName;
    private String managerCPhone;
    private Stage[] stages;

    
    private DateFormat formatter;

    public Project(String namePRO, String nameClient, Calendar initialDate ,Calendar finalDate,double budget, String managerName, String managerPhone,String managerCName, String managerCPhone){
        this.formatter = new SimpleDateFormat("dd/MM/yyyy");

        
        this.namePRO=namePRO;
        this.nameClient=nameClient;
        this.initialDate=initialDate;
        this.finalDate=finalDate;
        this.budget=budget;
        this.managerName=managerName;
        this.managerPhone=managerPhone;
        this.managerCName=managerCName;
        this.managerCPhone=managerCPhone;
        
        stages = new Stage[6];

        Calendar dateStagePI= Calendar.getInstance();
        Calendar dateStagePF=Calendar.getInstance();
        Calendar dateStageRI=Calendar.getInstance();
        Calendar dateStageRF=Calendar.getInstance();

        stages[0] = new Stage(TypeStage.INICIO,initialDate, dateStagePF, dateStageRI, dateStageRF, StatusStage.ACTIVA);
        stages[1] = new Stage(TypeStage.ANALISIS,dateStagePI, dateStagePF, dateStageRI, dateStageRF, StatusStage.INACTIVA);
        stages[2] = new Stage(TypeStage.DISEÑO,dateStagePI, dateStagePF, dateStageRI, dateStageRF, StatusStage.INACTIVA);
        stages[3] = new Stage(TypeStage.EJECUCION,dateStagePI, dateStagePF, dateStageRI, dateStageRF, StatusStage.INACTIVA);
        stages[4] = new Stage(TypeStage.CIERRE,dateStagePI, dateStagePF, dateStageRI, dateStageRF, StatusStage.INACTIVA);
        stages[5] = new Stage(TypeStage.SEGUIMIENTO,dateStagePI, dateStagePF, dateStageRI, dateStageRF, StatusStage.INACTIVA);

    }

    public Stage[] getStages(){
        return stages;
    }
    public String getnameProject(){
        return namePRO;
    }

    public void setnameProject(String nameProject){
        this.namePRO=nameProject;
    }

    public String getnameCustomer(String nameClient){
        return nameClient;
    }

    public void setnameCustomer(String nameClient){
        this.nameClient=nameClient;
    }

    public Calendar getinitialDate(){
        return initialDate;
    }

    public String getInitialDateFormated() {
		return formatter.format(this.initialDate.getTime());
	}

    public void setInitialDate(Calendar initialDate){
        this.initialDate=initialDate;
    }

	public Calendar getFinalDate(){
		return finalDate;
	}

	public String getFinalDateFormated(){
		return formatter.format(this.finalDate.getTime());
	}		


    public double getbudget(){
        return budget;
    }

    public void setbudget(double budget){
        this.budget=budget;
    }

    public String getmanagerGName(){
        return managerName;
    }

    public void setmanagerGname(String managerName){
        this.managerName=managerName;
    }

    public String getmanagerGPhone(){
        return managerPhone;
    }

    public void setmanagerGPhone(String managerPhone){
        this.managerPhone=managerPhone;
    }

    public String getmanagerCName(){
        return managerCName;
    }

    public void setmanagerCName(String managerCName){
        this.managerCName=managerCName;
    }

    public String getmanagerCPhone(){
        return managerCPhone;
    }

    public void setmanagerCPhone(String managerCPhone){
        this.managerCPhone=managerPhone;
    }

    public int getActiveStage(){
        int nActive=-1;
        for(int i=0; i<stages.length;i++){
            if(stages[i].getStatuStage()==StatusStage.ACTIVA){
                nActive=i;  
                return nActive;
            }
          
        }
        return nActive;
        
    }

    public String toStringProject(){
		String msg="";
		msg ="Project's name: "+ namePRO + "\nCustomer name: " + nameClient+ "\nplanned start date: "+ getInitialDateFormated() +"\nplanned end date: "+ getFinalDateFormated()+"\nPproject budget: "+budget+"\nManager name Green: "+managerName+"\nGreen manager phone: "+managerPhone+"\nClient manager name: "+managerCName+"\nCustomer manager phone: "+managerPhone;
		return msg;
	}

    public String toStringProjectminim(){
        String msg="";
        msg="Project's name: "+namePRO+"\nCustomer name: "+nameClient+"\nplanned start date: "+getInitialDateFormated()+"\nplanned end date: "+getFinalDateFormated()+"\nBudget: "+budget+"\n";
        return msg;
    }

    
}
