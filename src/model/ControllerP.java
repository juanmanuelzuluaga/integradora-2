package model;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class ControllerP {
    private Project[] projects;
    

    public ControllerP(){

        projects= new Project[10];
        projects[0]= new Project("Hola", "Hola1", Calendar.getInstance(), Calendar.getInstance(), 800.000, "3239","2832","4374329","94274");
    }

    public boolean registerProject(String namePRO, String nameClient, int diaI,int mesI,int añoI, int diaFPlan, int mesFPlan, int añoFPlan,  double budget, String managerGname, String managerPhone, String managerName, String managerCPhone){
        Calendar initialDate=createfecha(diaI, mesI, añoI);
        Calendar finalDate=createfecha(diaFPlan, mesFPlan, añoFPlan);
        Project nuevoproyecto= new Project(namePRO, nameClient, initialDate, finalDate,budget, managerGname, managerPhone, managerName, managerCPhone);

        boolean indicador1=false;
      
        for (int i=0; i<projects.length;i++){
        
            if (projects[i]==null && !indicador1){
                projects[i]=nuevoproyecto;
                indicador1=true;
        }
    }
        return indicador1;
    }

    public String showProjects(){
        String msg="";
        for (int i=0; i<projects.length;i++){
            if(projects[i] == null){
				return msg;
			} else {
				msg +="\n"+(i+1)+". "+ projects[i].toStringProjectminim();
			}
			} 
            return msg;
        }
        

    public boolean editStage(int opcionStage, int meses){
            boolean indicador3=false;
    
            if(indicador3==false){
                int StageActive=projects[opcionStage].getActiveStage();
                Calendar mesI=projects[opcionStage].getStages()[StageActive].getdateStagePI();
                Calendar mesF=new GregorianCalendar();
                mesF.setTime(mesI.getTime());
                mesF.add(Calendar.MONTH, meses);
                projects[opcionStage].getStages()[StageActive].setdateStagePF(mesF);
    
                indicador3=true;
            }
    
            return indicador3;
    
    }
    
    public boolean CulminateStage(int opcionStage, int dateDIR, int dateMIR, int dateAIR, int dateDFR,int dateMFR, int dateAFR){
        boolean indicador4=false;
            
    
        Calendar nuevafecharealI=createfecha(dateDIR, dateMIR,dateAIR);
        Calendar nuevafecharealF=createfecha(dateDFR, dateMFR, dateAFR);
    
        if (indicador4==false){
            int StageActive=projects[opcionStage].getActiveStage();
            projects[opcionStage].getStages()[StageActive].setdateStageRI(nuevafecharealI);
            projects[opcionStage].getStages()[StageActive].setdateStageRF(nuevafecharealF);
            projects[opcionStage].getStages()[StageActive].setStatusStage(StatusStage.INACTIVA);
            projects[opcionStage].getStages()[StageActive+1].setStatusStage(StatusStage.ACTIVA);
            indicador4=true;
        }

        return indicador4;
    }
        
    public String showStagesActive(int opcionStage){
        String msg="";
               
        int StageActive=projects[opcionStage].getActiveStage();
        msg=projects[opcionStage].getStages()[StageActive].toStringStage();
       
        return msg;
       }
    
       public String showLastStages(int opcionStage){
           String msg="";
           int StageActive=projects[opcionStage].getActiveStage();
           msg=projects[opcionStage].getStages()[StageActive-1].toStringStageMax();
    
           return msg;
       }

       public String showStagesHistorial(int opcionStage){
            String msg="";
            int StageActive=projects[opcionStage].getActiveStage();
            for (int i=0;i<StageActive+1;i++){
                msg+="\n"+(i+1)+"."+projects[opcionStage].getStages()[i].toStringStageMaxMin();
            }
            return msg;
       }
 

    public boolean registerUnit(String id, String description, int typeUnit, String learnedLessons, String namecolabo, String cargo, int opcionProject) {
        Project ProjectoUnit=projects[opcionProject];
        String ProjectoUnidad=ProjectoUnit.getnameProject();
        String Publicada="-NO";
        String URL="-Ninguno";
        boolean indicador5=false;
        int StageActive=projects[opcionProject].getActiveStage();
        for (int i=0; i<50;i++){
            if (projects[opcionProject].getStages()[StageActive].getUnits()[i]==null){
                if(typeUnit==1){
                    projects[opcionProject].getStages()[StageActive].getUnits()[i]=new Unit(id, description, TypeUnit.TECNICO, learnedLessons, namecolabo, cargo,StatusUnit.POR_DEFINIR, Calendar.getInstance(), ProjectoUnidad, Publicada, URL);
                } else if(typeUnit==2){
                    projects[opcionProject].getStages()[StageActive].getUnits()[i]=new Unit(id, description, TypeUnit.GESTION, learnedLessons, namecolabo, cargo,StatusUnit.POR_DEFINIR, Calendar.getInstance(), ProjectoUnidad, Publicada, URL);
                }else if(typeUnit==3){
                    projects[opcionProject].getStages()[StageActive].getUnits()[i]=new Unit(id, description, TypeUnit.DOMINIO, learnedLessons, namecolabo, cargo,StatusUnit.POR_DEFINIR, Calendar.getInstance(), ProjectoUnidad, Publicada, URL);
                }else{
                    projects[opcionProject].getStages()[StageActive].getUnits()[i]=new Unit(id, description, TypeUnit.EXPERIENCIAS, learnedLessons, namecolabo, cargo,StatusUnit.POR_DEFINIR, Calendar.getInstance(), ProjectoUnidad, Publicada, URL);
                }
                
                indicador5=true;
                return indicador5;
            }
            
        }
   
		
		return indicador5;
	}

    public String showAllUnit(int opcionProject){
        String msg="";
        int StageActive=projects[opcionProject].getActiveStage();
        for (int i=0; i<50; i++){
            if (projects[opcionProject].getStages()[StageActive].getUnits()[i]==null){
                return msg;
            }else{
                msg+="\n"+(i+1)+"."+projects[opcionProject].getStages()[StageActive].getUnits()[i].toStringUMm();
            }
        }
        return msg;
    }
    
    public String showLastUnit(int opcionProject){
        String msg="";
        int StageActive=projects[opcionProject].getActiveStage();
        for (int i=0; i<50; i++){
            if (i>0 && projects[opcionProject].getStages()[StageActive].getUnits()[i]==null){
                msg+=projects[opcionProject].getStages()[StageActive].getUnits()[i-1].toStringU();
                return msg;
            }
        }
        return msg;
    }

    public String showUnitSelect(int opcionProject, int numUnit){
        String msg="";
        int StageActive=projects[opcionProject].getActiveStage();
        msg=projects[opcionProject].getStages()[StageActive].getUnits()[numUnit].toStringUMmF();
        return msg;
    }

    public boolean approveKnowledgeUnit(int opcionProject, int opcionStage,int numUnit ) {
		boolean indicador=false;
        
        if(indicador==false){
            projects[opcionProject].getStages()[opcionStage].getUnits()[numUnit].setStatusUnit(StatusUnit.APROBADA);
            projects[opcionProject].getStages()[opcionStage].getUnits()[numUnit].setDateConfirm(Calendar.getInstance());;
            indicador=true;
        }

        return indicador;
	}

    public boolean publishKnowledgeUnit(int opcionProject, int opcionStage, int numUnit, String URL){
        boolean indicador=false;
        if(indicador==false){
            projects[opcionProject].getStages()[opcionStage].getUnits()[numUnit].setURL(URL);
            projects[opcionProject].getStages()[opcionStage].getUnits()[numUnit].setPublish("-SI");
            
            indicador=true;
        }
       return indicador;
    }

    public String showLastpublisUnit(int opcionProject, int opcionStage){
        String msg="";
        for(int i=0; i<50; i++){
            if(projects[opcionProject].getStages()[opcionStage].getUnits()[i]==null){
                return msg;
            }else{
                String consulta=projects[opcionProject].getStages()[opcionStage].getUnits()[i].getPublish();
                if(consulta.equals("-SI")){
                    msg=projects[opcionProject].getStages()[opcionStage].getUnits()[i].toStringUMmF();
                }
            }
        }
        return msg;
    }

    public String showApproveUnit(int opcionProject, int opcionStage){
        String msg="";
        boolean indicador=false;
        if(indicador==false){
            for(int i=0; i<50; i++){
                if(projects[opcionProject].getStages()[opcionStage].getUnits()[i]==null){
                    return msg;
                }else if(projects[opcionProject].getStages()[opcionStage].getUnits()[i].getStatusUnit()==StatusUnit.APROBADA){
                    msg+=(i+1)+". "+projects[opcionProject].getStages()[opcionStage].getUnits()[i].toStringUMmF();
                }else{
                    return msg;
                }     
            }
            indicador=true;
        }
        return msg;
    }


    public String searchPSU(String wordSearch){
        String msg="";
        for(int i=0; i<projects.length; i++){
            if(projects[i]!=null){
                for (int j=0; j<6;j++){
                        for(int s=0; s<50;s++){
                            if(projects[i].getStages()[j].getUnits()[s]!=null){
                                if(projects[i].getStages()[j].getUnits()[s].getDescription().contains(wordSearch)){
                                    msg+="\nword found in: \n";
                                    msg+="Project: "+projects[i].getnameProject()+"\n";
                                    msg+="Stage: "+projects[i].getStages()[j].getTypeStage()+"\n";
                                    msg+="Capsule identifier: "+projects[i].getStages()[j].getUnits()[s].getId()+"\n";
                                }
                            }
                        }
                    }
                    
        
                } 
        }
    
        return msg;
    }

    public String numberTypeUnit(){
        String msg="";
        int ContadorT=0;
        int ContadorG=0;
        int ContadorD=0;
        int ContadorE=0;

        for(int i=0; i<projects.length; i++){
            if(projects[i]!=null){
                for (int j=0; j<6;j++){
                        for(int s=0; s<50;s++){
                            if(projects[i].getStages()[j].getUnits()[s]!=null){
                                if(projects[i].getStages()[j].getUnits()[s].getTypeUnit()==TypeUnit.TECNICO){
                                   ContadorT++;
                                }else if(projects[i].getStages()[j].getUnits()[s].getTypeUnit()==TypeUnit.GESTION){
                                    ContadorG++;
                                }else if(projects[i].getStages()[j].getUnits()[s].getTypeUnit()==TypeUnit.EXPERIENCIAS){
                                    ContadorE++;
                                }else if(projects[i].getStages()[j].getUnits()[s].getTypeUnit()==TypeUnit.DOMINIO){
                                    ContadorD++;
                                }

                                msg+="\nCantidad Tipo de Capsulas creadas\n";
                                msg+="-Tecnico: "+ContadorT+"\n";
                                msg+="-Gestion: "+ContadorG+"\n";
                                msg+="-Dominio: "+ContadorD+"\n";
                                msg+="-Experiencias: "+ContadorE+"\n";
                            }
                        }
                    }
                    
        
                } 
        }
    
        return msg;
    }


    

    public static Calendar createfecha(int dia, int mes, int año){
        Calendar fecha = new GregorianCalendar(año,mes,dia);
        return fecha;
    }
}




