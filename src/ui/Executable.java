package ui;


import java.util.Scanner;
import model.ControllerP;

public class Executable {

	private Scanner reader;
	private ControllerP controllerP;
	

	public Executable() {
		reader = new Scanner(System.in);
		controllerP= new ControllerP();
	}


	public static void main(String[] args) {

		Executable exe = new Executable();
		exe.menu();

	}

	// Incompleto
	public void menu() {
		System.out.println("\nWelcome to GreenSQA ");
		boolean cond=false;

		while(!cond){
            System.out.println("\n-  type a number  -");
            System.out.println("\n1. Create Project");
            System.out.println("2. Edit stages of a project");
            System.out.println("3. Complete stage of a project");
			System.out.println("4. register capsule");
			System.out.println("5. approve capsule");
			System.out.println("6. Check Capsules created");
			System.out.println("7. Post Capsule");
			System.out.println("8. General information");
			System.out.println("\n9. exit");
            int opcion=reader.nextInt();

            switch(opcion){
                case 1:
					registerProject();
                 break;

                case 2:
					editStage();
                break;

                case 3:
					CulminateStage();
                break;
      
                case 4:
					registerUnits();
                break;

				case 5:
					approveKnowledgeUnit();
				break;

				case 6:
					SearchPSU();
				break;

				case 7:
					publishKnowledgeUnit();
				break;

				case 8:
					numberTypeUnit();
				break;
					
				case 9:
				System.out.println("bye ");
                cond=true;
				break;


            }
        }
	}

	private void registerProject(){
		reader.nextLine();
		
		System.out.println("Enter the following information to create a project:");
		System.out.println("Enter the project name");
		String namePRO=reader.nextLine();
		System.out.println("Enter customer name");
		String nameClient=reader.nextLine();
		System.out.println("\n -PLANNED PROJECT START DATES-");
		System.out.println("Enter the day (In Numbers)");
		int diaI=reader.nextInt();
		System.out.println("Enter the month (In numbers)");
		int mesI=reader.nextInt();
		System.out.println("Enter the year (In numbers)");
		int añoI=reader.nextInt();

		System.out.println("\n-PLANNED END DATE-");
		System.out.println("Enter the day (In Numbers)");
		int diaFPlan=reader.nextInt();
		System.out.println("Enter the month (In numbers)");
		int mesFPlan=reader.nextInt();
		System.out.println("Enter the year (In numbers)");
		int añoFPlan=reader.nextInt();
		
		System.out.println("\nEnter the budget for the project");
		double budget=reader.nextDouble();
		reader.nextLine();
		System.out.println("Enter Green Manager Name");
		String managerName=reader.nextLine();
		System.out.println("Enter the phone number of Green's manager");
		String managerPhone=reader.nextLine();
		System.out.println("Enter the name of the client's manager");
		String managerCName=reader.nextLine();
		System.out.println("Enter the phone number of the client's manager");
		String managerCPhone=reader.nextLine();

		if (controllerP.registerProject(namePRO,nameClient,diaI,(mesI-1),añoI,diaFPlan,(mesFPlan-1),añoFPlan,budget,managerName,managerPhone,managerCName,managerCPhone)){
			System.out.println("\nProject successfully registered");
			System.out.println("First Stage START created with default values");
		}
		
	}

	private void editStage(){
		reader.nextLine();
		String Consulta=controllerP.showProjects();
		if(Consulta.equals("")){
			System.out.println("No projects created yet");
		}else{
			System.out.println("These are the projects created:");
			System.out.println(controllerP.showProjects());
			System.out.println("\nEnter with a number to which project you want to edit the stage ");
			int opcionStage=reader.nextInt();
			opcionStage=opcionStage-1;
			System.out.println("\n-This is the current stage of that project:");
			System.out.println(controllerP.showStagesActive(opcionStage)); 
		
			System.out.println("\n           -EDIT MODE-");
			System.out.println("Enter the number of months the stage will take");
			int meses=reader.nextInt();
	
			if(controllerP.editStage(opcionStage, meses)){
				System.out.println("\nstage edited successfully");
				System.out.println(controllerP.showStagesActive(opcionStage)); 
			}
		}
	

	}

	private void CulminateStage(){
		String Consulta=controllerP.showProjects();
		if(Consulta.equals("")){
			System.out.println("No projects created yet");
		}else{
			System.out.println("These are the projects created:");
			System.out.println(controllerP.showProjects());
			System.out.println("\nEnter with a number to which project you want to complete the stage ");
			int opcionStage=reader.nextInt();
			System.out.println("\n-This is the current stage of that project:");
			System.out.println(controllerP.showStagesActive(opcionStage-1)); 
			
			System.out.println("\n-CULMINATION SPACE");
			System.out.println("\nEnter the starting actual date");
			System.out.println("-Enter the day");
			int dateDIR=reader.nextInt();
			System.out.println("\n-enter the month");
			int dateMIR=reader.nextInt();
			System.out.println("\n-enter the year");
			int dateAIR=reader.nextInt();
	
			System.out.println("\nEnter actual end date");
			System.out.println("-Enter the day");
			int dateDFR=reader.nextInt();
			System.out.println("\n-enter the month");
			int dateMFR=reader.nextInt();
			System.out.println("\n-enter the year");
			int dateAFR=reader.nextInt();
	
	
			if (controllerP.CulminateStage((opcionStage-1), dateDIR, (dateMIR-1), dateAIR, dateDFR, (dateMFR-1), dateAFR)){
				System.out.println("\n  -Stage completed successfully-");
				System.out.println("    This is how the stage ended");
				System.out.println("\n"+controllerP.showLastStages(opcionStage-1));
				System.out.println("-The next stage is now available-");
			}
		}
	
	}
	

	private void registerUnits() {
		String Consulta=controllerP.showProjects();
		if (Consulta.equals("")){
			System.out.println("No projects created yet");
		}else{
			System.out.println("\n- Enter the following information:");
			System.out.println(controllerP.showProjects());
			System.out.println("To which project do you want to register the capsule?");
			int opcionProject=reader.nextInt();
			System.out.println("\nThe capsule will be registered to the next stage:");
			System.out.println(controllerP.showStagesActive((opcionProject-1)));
			System.out.println("\nKNOWLEDGE CAPSULE CREATION");
			System.out.println("Enter the capsule identifier (ej B06)");
			reader.nextLine();
			String id=reader.nextLine();
			System.out.println("Add a description of the capsule");
			System.out.println("Mark with a ¨#¨ at the beginning and end of each keyword");
			String description=reader.nextLine();
			System.out.println("\nEnter the type of capsule with a number");
			System.out.println("1.technical\n2.management\n3.domain\n4.experiences");
			int typeUnit=reader.nextInt();
			reader.nextLine();
			System.out.println("Enter learning obtained");
			System.out.println("Mark with a ¨#¨ at the beginning and end of each keyword");
			String learnedLessons=reader.nextLine();
			System.out.println("Enter the name of the collaborator");
			String nameColabo=reader.nextLine();
			System.out.println("Enter the charge for "+nameColabo);
			String cargo=reader.nextLine();
			

			if (controllerP.registerUnit(id, description, typeUnit, learnedLessons,nameColabo,cargo, opcionProject-1)){
				System.out.println("\n-Capsule registered successfully-");
				System.out.println("     -This is how your capsule was-");
				System.out.println("\n"+controllerP.showLastUnit(opcionProject-1)); 
			}
		}


	}	

	private void approveKnowledgeUnit() {
		String consulta= controllerP.showProjects();
		

		if(consulta.equals("")){
            System.out.println("there is nothing created");
        }else{
			System.out.println("\n- Enter the following information:");
			System.out.println(controllerP.showProjects());
			System.out.println("What project do you want to approve the capsule for?");
			int opcionProject=reader.nextInt();
			System.out.println(controllerP.showStagesHistorial(opcionProject-1));
			System.out.println("At what stage do you want to approve the capsule?");
			int opcionStage=reader.nextInt();
			String consulta1=controllerP.showAllUnit(opcionProject-1);
			if(consulta1.equals("")){
				System.out.println("\nThis stage has no registered capsules");
			}else{
				System.out.println(controllerP.showAllUnit(opcionProject-1));
			System.out.println("\nWhat capsule do you want to approve?");
			int numUnit=reader.nextInt();
			reader.nextLine();
            
            if(controllerP.approveKnowledgeUnit(opcionProject-1, opcionStage-1,numUnit-1)){
				System.out.println("\n-Capsule edited correctly-");
				System.out.println("    This is how your capsule was:");
			System.out.println("\n"+controllerP.showUnitSelect(opcionProject-1, numUnit-1));
			}
			}
			
        }

	}

	private void publishKnowledgeUnit(){
		String consulta= controllerP.showProjects();
		if(consulta.equals("")){
            System.out.println("there is nothing created");
        }else{
			System.out.println("\n- Enter the following information:");
			System.out.println(controllerP.showProjects());
			System.out.println("What project is the capsule in?");
			int opcionProject=reader.nextInt();
			System.out.println(controllerP.showStagesHistorial(opcionProject-1));
			System.out.println("What stage is the capsule in?");
			int opcionStage=reader.nextInt();
			String consulta1=controllerP.showApproveUnit(opcionProject-1, opcionStage-1);
			if(consulta1.equals("")){
				System.out.println("That stage does not have approved capsules");
			}else{
				System.out.println("\n"+controllerP.showApproveUnit(opcionProject-1, opcionStage-1));
			System.out.println("\nWhat capsule do you want to publish?");
			int numUnit=reader.nextInt();
			reader.nextLine();
			System.out.println("Enter URL");
			String URL=reader.nextLine();
			if(controllerP.publishKnowledgeUnit(opcionProject-1, opcionStage-1, numUnit-1, URL)){
				System.out.println("\n-Capsule published correctly-");
				System.out.println("This is how your capsule was:");
				System.out.println("\n"+controllerP.showLastpublisUnit(opcionProject-1, opcionStage-1));
			}
		
        }
	}
	}


	private void SearchPSU() {
		System.out.println("Please enter the word to search for");
		reader.nextLine();
		String wordSearch=reader.nextLine();
		String consulta=controllerP.searchPSU(wordSearch);
        if(consulta.equals("")){
            System.out.println("-Can't find that word-");
        }else{
            System.out.println(controllerP.searchPSU(wordSearch));
        }
	}

	private void numberTypeUnit(){
		String Consulta=controllerP.numberTypeUnit();

		if(Consulta.equals("")){
			System.out.println("No capsules created");
		}else{
			System.out.println(controllerP.numberTypeUnit());
		}
	}

}