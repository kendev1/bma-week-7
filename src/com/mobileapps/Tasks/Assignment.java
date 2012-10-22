
package com.mobileapps.Tasks;
import com.mobileapps.TaskFilters.*;
import java.util.Calendar;

import java.text.SimpleDateFormat;
/***************************************************************************
 * 
 * 
 * 
 * Create Task Object - Define minimal repesentation of a Task, Create Abstract base class
 * for Task and create a medicine tracker which inherit from the base class.
 */


public class Assignment {

	/**
	 * @param args
	 */
	
	

	public static  void main(String[] args) {
		// TODO Auto-generated method stub
		
/*		System.out.println("Testing GetElements .........\n");
		System.out.println("Testing passing correct data- (index is 2, array size of string array is 6\n)");
		String[]TestArray = {"red", "blue", "indigo", "yellow", "green", "white"};
		String Elementresult = getElement(TestArray,2);
		System.out.println("Result of index search: " + Elementresult + ". It should be indigo\n");
		
		System.out.println("Testing passing incorrect data- (index is 18 and array size of string array is 6\n)");
	    Elementresult = getElement(TestArray,18);
		System.out.println("Result of index search: " + Elementresult + ". It should be NULL\n\n\n");
*/
		System.out.println("Testing Medical Tracker Task constructors by printing Task Objects .........\n");
		System.out.println("println Task() - WILL NOT WORK WITH JUST AN OBJECT ...");
		MedicalTrackerTask ATask_1 = new MedicalTrackerTask( );
//		System.out.println(ATask_1 + "\n");
		
		System.out.println("println Medical Tracker Task() - WILL WORK WITH REFERENCING MEMBERS OF OBJECT ...");
		System.out.println("Medicine Task Description, with no parms: " + ATask_1.TaskDescription + "\n");
		System.out.println("Medicine Task Start Date, with no parms: " + ATask_1.TaskStartDate + "\n");
		System.out.println("Medicine Task End Date  , with no parms: " + ATask_1.TaskEndDate + "\n\n");
		
		System.out.println("println Medical Tracker Task() - Testing passing constructor medicine, start and end date, dosage and amount...");
		MedicalTrackerTask ATask_2 = new MedicalTrackerTask("Ciprofloxacin", "01-12-2013", "01-19-2013", "20mg", 2 );
//		System.out.println(ATask_2 + "\n");
		
		System.out.println("println Medical Tracker Task() - WILL WORK WITH REFERENCING MEMBERS OF OBJECT ...");
		System.out.println("Medicine Task Desciption : " + ATask_2.TaskDescription + "\n");
		System.out.println("Medicine Task Start Date : " + ATask_2.TaskStartDate + "\n");
		System.out.println("Medicine Task End Date : " + ATask_2.TaskEndDate + "\n\n");
		System.out.println("Medicine Task Dosage : " + ATask_2.TaskDosage + "\n\n");
		System.out.println("Medicine Task Dosage Amount : " + ATask_2.TaskDosageAmount + "\n\n");
		
/*
 *  Testing TaskFilter interface and implementation
 */
TaskFilterImplem TaskFilterTest = new TaskFilterImplem();
Task[] tasks = new Task[50];
Task[] filteredtasks;
boolean dateflag = true;
boolean alphaflag = true;
// filter by date
filteredtasks = TaskFilterTest.sortbydate(tasks,dateflag);
filteredtasks = TaskFilterTest.sortbydoctor(tasks, alphaflag);
		
		
		
/*
 * Testing PrintTask functionality
 */

		MedicalTrackerTask TestPrintTask1 = new MedicalTrackerTask();
		printTask(TestPrintTask1);
		
		
		
		
		
		System.out.println("Testing Medicine Tracker Task Object .........\n");					
		
       	// Test Task with no parameters	
		MedicalTrackerTask ATask = new MedicalTrackerTask();
		String TaskVal = ATask.toString();
		System.out.println(TaskVal + "\n");
		
		
		// Test Task with one parameter - TaskTitle
		TaskVal = ATask.toString("Ibuprofen");
		System.out.println(TaskVal + "\n");
		

		
	
	}
	
	static String getElement(String[] values, int index) {
		String[] TaskArray;
		TaskArray = values;
		int Taskindex = index;
		if ((Taskindex < 0) || (Taskindex >= values.length)) {
			return null;	
		} else {
			return TaskArray[Taskindex];
		}
		
	}
	
	private static void  printTask(MedicalTrackerTask Task) {
		//Print out Description of instance variables
		
		System.out.println("The medicine is : " + Task.GetTaskDescription() + "\n");
		System.out.println("Start Date of taking medicine : " + Task.GetTaskStartDate() + "\n");
		System.out.println("End Date of taking medicine : " + Task.GetTaskEndDate() + "\n");
		System.out.println("The Dosage is : " + Task.GetTaskDosage() + "\n");
		System.out.println("The Dosage Amount is : " + Task.GetTaskDosageAmount() + "\n");
		
		
	}	

	
public static class Task {
		private String TaskDescription;
		private String TaskStartDate;
		private String TaskEndDate;
		public static final String Date_Format_Now = "MM-dd-yyyy";

/*********************************************************************************
 *      Constructers		
 */
		
 	    public  Task() {
 	    	SetTaskDescription("Complete Weekly Lecture");
 	    	Calendar taskcal = Calendar.getInstance();
 	    	SimpleDateFormat taskdf = new SimpleDateFormat(Date_Format_Now);
 	    	SetTaskStartDate(taskdf.format(taskcal.getTime()));
 	    	taskcal.add(Calendar.DATE, 7);
 	    	SetTaskEndDate(taskdf.format(taskcal.getTime()));	    	
 	    	String TaskInfo = "The Task is: " + this.TaskDescription + "\n" +"The Start Date for Task is: " + this.TaskStartDate + "\n" + "The End Date for Task is: " + this.TaskEndDate + "\n\n";
 
 	    }
 	    
 	    public  Task(String TaskTitle) {
 	    	SetTaskDescription(TaskTitle);
 	    	Calendar taskcal = Calendar.getInstance();
 	    	SimpleDateFormat taskdf = new SimpleDateFormat(Date_Format_Now);
 	    	SetTaskStartDate(taskdf.format(taskcal.getTime()));
 	    	taskcal.add(Calendar.DATE, 7);
 	    	SetTaskEndDate(taskdf.format(taskcal.getTime()));
 	    	String TaskInfo = "The Task is: " + this.TaskDescription + "\n" +"The Start Date for Task is: " + this.TaskStartDate + "\n" + "The End Date for Task is: " + this.TaskEndDate + "\n\n";
	
 	    }
 	    
 	    public Task(String TaskTitle,String TaskBeginDate, String TaskCompleteDate) {
 	    	SetTaskDescription(TaskTitle);
 	    	SetTaskStartDate(TaskBeginDate);
 	    	SetTaskEndDate(TaskCompleteDate);
 	    	String TaskInfo = "The Task is: " + this.TaskDescription + "\n" +"The Start Date for Task is: " + this.TaskStartDate + "\n" + "The End Date for Task is: " + this.TaskEndDate + "\n\n";
 	    }
 /*******
  * Getter and Setters for Task private instant variables	    
  */
 public String GetTaskDescription() {
	 return(TaskDescription);
 }
 
 public void SetTaskDescription( String TaskDescriptionVar) {
	 TaskDescription = TaskDescriptionVar;
 } 
 
 public String GetTaskStartDate() {
	 return(TaskStartDate);
 }
 
 public void SetTaskStartDate( String TaskStartDateVar) {
	 TaskStartDate = TaskStartDateVar;
 } 
 
 public String GetTaskEndDate() {
	 return(TaskEndDate);
 }
 
 public void SetTaskEndDate( String TaskEndDateVar) {
	 TaskEndDate = TaskEndDateVar;
 } 
 	    
 /***********************************************************************************************/	    
 // Case #1: Override toString class from Object superclass -                                   
 //	    Signature: No Parameters                                                                
 //     Return: TaskInfo - (String description of Task)	                                                    
 //	    Defaults: TaskDescription- "Complete Weekly Lecture                                     
 //               TaskStartDate - Current time when task is created                            
 //               TaskEndDate   - One week from Start Date                                       	    
 /***********************************************************************************************/	    
 	    
	    public String toString() {
 		    this.TaskDescription = "Complete Weekly Lecture";
	    	Calendar taskcal = Calendar.getInstance();	    	
            SimpleDateFormat taskdf = new SimpleDateFormat(Date_Format_Now);
 	    	this.TaskStartDate = taskdf.format(taskcal.getTime());
 	    	taskcal.add(Calendar.DATE, 7);
 	    	this.TaskEndDate = taskdf.format(taskcal.getTime());
 	    	String TaskInfo = "The Task is: " + this.TaskDescription + "\n" +"The Start Date for Task is: " + this.TaskStartDate + "\n" + "The End Date for Task is: " + this.TaskEndDate + "\n\n";
 	    	return TaskInfo;
 	    }
	    
/***********************************************************************************************/	    
// Case #2: Override toString class from Object superclass -                                   
//	   Signature: TaskDescription = TaskTitle, TaskStartDate and TaskEndDate are defaulted   
//     Return: String description of Task
//	           TaskDescription = TaskTitle (first parameter) 
//     Defaults: TaskStartDate - Current time when task is created                             
//               TaskEndDate   - One week from Start Date                                      
/***********************************************************************************************/	   	    
 	    
	    public String toString(String TaskTitle) {
 	    	this.TaskDescription = TaskTitle;
 	    	Calendar taskcal = Calendar.getInstance();
 	    	SimpleDateFormat taskdf = new SimpleDateFormat(Date_Format_Now);
 	    	this.TaskStartDate = taskdf.format(taskcal.getTime());
 	    	taskcal.add(Calendar.DATE, 7);
 	    	this.TaskEndDate = taskdf.format(taskcal.getTime());
 	    	String TaskInfo = "The Task is: " + this.TaskDescription + "\n" +"The Start Date for Task is: " + this.TaskStartDate + "\n" + "The End Date for Task is: " + this.TaskEndDate + "\n\n";
 	    	return TaskInfo;
 	    }
	    
/***********************************************************************************************/	    
// Case #3: Override toString class from Object superclass -                                   
//	    Signature: TaskDescription = TaskTitle, TaskStartDate = TaskBeginDate and TaskEndDate=TaskCompleteDate                                                               
//      Return: TaskInfo - (String description of Task)	                                                    
//	    TaskDescription- TaskTitle (first parameter), TaskStartDate = TaskBeginDate (second parameter)
//                       TaskEndDate = TaskComplete (third parameter                                     
//      TaskStartDate - Current time when task is created                            
//      TaskEndDate   - One week from Start Date                                       	    
/***********************************************************************************************/	    
	    
	    public String toString(String TaskTitle, String TaskBeginDate, String TaskCompleteDate) {
 	    	this.TaskDescription = TaskTitle; 	    	
 	    	this.TaskStartDate = TaskBeginDate;	    	
 	    	this.TaskEndDate = TaskCompleteDate;
 	    	String TaskInfo = "The Task is: " + this.TaskDescription + "\n" +"The Start Date for Task is: " + this.TaskStartDate + "\n" + "The End Date for Task is: " + this.TaskEndDate + "\n\n";
 	    	return TaskInfo;
 	    }
 	    
		
	}

/*******************************************************************************/
/*  Class to keep track of your medicine and dosage
 * 
 */
	
private static class MedicalTrackerTask extends Task {
	private String TaskDescription;
	private String TaskStartDate;
	private String TaskEndDate;
	private String TaskDosage;
	private int TaskDosageAmount;
	private boolean TaskAlert;
	private Calendar[] TaskAlertTimes;
	private Calendar TaskRefillDate;
	public static final String Date_Format_Now = "MM-dd-yyyy";       	
	
	
	    public  MedicalTrackerTask() {
	    	Calendar[] TaskAlertTimesArray = new Calendar[100];
	    	
	    	Boolean StartAlert = new Boolean(true);
 	    	SetTaskDescription("Lipitor");
 //	    	System.out.println("Task Description: " + super.GetTaskDescription());
 	    	Calendar taskcal = Calendar.getInstance();
 	    	TaskAlertTimesArray[0] = taskcal;
 	    	SimpleDateFormat taskdf = new SimpleDateFormat(Date_Format_Now);
 	    	SetTaskStartDate(taskdf.format(taskcal.getTime()));
 	    	taskcal.add(Calendar.DATE, 7);
 	    	
 	    	SetTaskEndDate(taskdf.format(taskcal.getTime()));	    	
 	    	String TaskInfo = "The Task is: " + TaskDescription + "\n" +"The Start Date for Task is: " + TaskStartDate + "\n" + "The End Date for Task is: " + TaskEndDate + "\n\n";
 	    	SetTaskDosage("10 mg");
 	    	SetTaskDosageAmount(2);
 	    	SetTaskAlert(StartAlert);
 	    	SetTaskAlertTimes(TaskAlertTimesArray);
 	    	
 	    }
	    
	    public  MedicalTrackerTask(String MedicineVar) {
 	    	SetTaskDescription(MedicineVar);
 	    	Calendar taskcal = Calendar.getInstance();
 	    	SimpleDateFormat taskdf = new SimpleDateFormat(Date_Format_Now);
 	    	SetTaskStartDate(taskdf.format(taskcal.getTime()));
 	    	taskcal.add(Calendar.DATE, 7);
 	    	SetTaskEndDate(taskdf.format(taskcal.getTime()));	    	
 	    	String TaskInfo = "The Task is: " + TaskDescription + "\n" +"The Start Date for Task is: " + TaskStartDate + "\n" + "The End Date for Task is: " + TaskEndDate + "\n\n";
 
 	    }	 
	    
	    public  MedicalTrackerTask(String MedicineVar, String TaskBeginDate, String TaskCompleteDate, String TaskDosageV, int TaskDosageAmountV) {
 	    	SetTaskDescription(MedicineVar);
 /*	    	Calendar taskcal = Calendar.getInstance();
 	    	SimpleDateFormat taskdf = new SimpleDateFormat(Date_Format_Now);
 	    	SetTaskStartDate(taskdf.format(taskcal.getTime()));
 	    	taskcal.add(Calendar.DATE, 7);
 	    	SetTaskEndDate(taskdf.format(taskcal.getTime()));      */
 	    	SetTaskStartDate(TaskBeginDate);
 	    	SetTaskEndDate(TaskCompleteDate);
 	    	SetTaskDosage(TaskDosageV);
 	    	SetTaskDosageAmount(TaskDosageAmountV);
 	    	String TaskInfo = "The Task is: " + TaskDescription + "\n" +"The Start Date for Task is: " + TaskStartDate + "\n" + "The End Date for Task is: " + TaskEndDate + "\n\n";
 
 	    }	    	    
 	    
 
 /*******
  * Getter and Setters for Task private instant variables	    
  */
 public String GetTaskDescription() {
	 return(TaskDescription);
 }
 
 public void SetTaskDescription( String TaskDescriptionVar) {
	 TaskDescription = TaskDescriptionVar;
 } 
 
 public String GetTaskStartDate() {
	 return(TaskStartDate);
 }
 
 public void SetTaskStartDate( String TaskStartDateVar) {
	 TaskStartDate = TaskStartDateVar;
 } 
 
 public String GetTaskEndDate() {
	 return(TaskEndDate);
 }
 
 public void SetTaskEndDate( String TaskEndDateVar) {
	 TaskEndDate = TaskEndDateVar;
 } 	
 
 public String GetTaskDosage() {
	 return(TaskDosage);         //In milligrams
 }
 
 public void SetTaskDosage( String TaskDosageVar) {
	 TaskDosage = TaskDosageVar;    //In milligrams
 } 
 
 public int GetTaskDosageAmount() {
	 return(TaskDosageAmount);         //number of pills
 }
 
 public void SetTaskDosageAmount( int TaskDosageAmountVar) {
	 TaskDosageAmount = TaskDosageAmountVar;    //In milligrams
 } 	
 
 public Calendar[] GetTaskAlertTimes() {
	 return(TaskAlertTimes);         //get times for alerts morning,afternoon,night,etc.
 }
 
 public void SetTaskAlertTimes( Calendar[] TaskAlertTimesArray) {
	 TaskAlertTimes = TaskAlertTimesArray;    //set times for alerts morning,afternoon,night,etc.
 } 	
 
 public boolean GetTaskAlert() {
	 return(TaskAlert);         //get toggle alert alarm
 }
 
 public void SetTaskAlert( boolean TaskAlertVar) {
	 TaskAlert = TaskAlertVar;    //toggle alert alarm
 } 	
	
 public Calendar GetTaskRefillDate() {
	 return(TaskRefillDate);         //get toggle alert alarm
 }
 
 public void SetTaskAlert( Calendar TaskRefillDateVar) {
	 TaskRefillDate = TaskRefillDateVar;    //toggle alert alarm
 } 	
 
 /***********************************************************************************************/	    
 // Case #1: Override toString class from Object superclass -                                   
 //	    Signature: No Parameters                                                                
 //     Return: TaskInfo - (String description of Task)	                                                    
 //	    Defaults: TaskDescription- "Complete Weekly Lecture                                     
 //               TaskStartDate - Current time when task is created                            
 //               TaskEndDate   - One week from Start Date                                       	    
 /***********************************************************************************************/	    
 	    
	    public String toString() {
 		    TaskDescription = "Lipitor";
	    	Calendar taskcal = Calendar.getInstance();	    	
            SimpleDateFormat taskdf = new SimpleDateFormat(Date_Format_Now);
 	    	TaskStartDate = taskdf.format(taskcal.getTime());
 	    	taskcal.add(Calendar.DATE, 7);
 	    	TaskEndDate = taskdf.format(taskcal.getTime());
 	    	String TaskInfo = "The Task is: " + TaskDescription + "\n" +"The Start Date for Task is: " + this.TaskStartDate + "\n" + "The End Date for Task is: " + this.TaskEndDate + "\n\n";
 	    	return TaskInfo;
 	    }
 
 
 
 
 /***********************************************************************************************/	    
//Case #2: Override toString class from Object superclass -                                   
//	   Signature: TaskDescription = TaskTitle, TaskStartDate and TaskEndDate are defaulted   
//   Return: String description of Task
//	           TaskDescription = TaskTitle (first parameter) 
//   Defaults: TaskStartDate - Current time when task is created                             
//             TaskEndDate   - One week from Start Date                                      
/***********************************************************************************************/	   	    
	    
	    public String toString(String TaskTitle) {
	    	TaskDescription = TaskTitle;
	    	Calendar taskcal = Calendar.getInstance();
	    	SimpleDateFormat taskdf = new SimpleDateFormat(Date_Format_Now);
	    	TaskStartDate = taskdf.format(taskcal.getTime());
	    	taskcal.add(Calendar.DATE, 7);
	    	TaskEndDate = taskdf.format(taskcal.getTime());
	    	String TaskInfo = "The Task is: " + TaskDescription + "\n" +"The Start Date for Task is: " + TaskStartDate + "\n" + "The End Date for Task is: " + TaskEndDate + "\n\n";
	    	return TaskInfo;
	    }
	    
/***********************************************************************************************/	    
//Case #3: Override toString class from Object superclass -                                   
//	    Signature: TaskDescription = TaskTitle, TaskStartDate = TaskBeginDate and TaskEndDate=TaskCompleteDate                                                               
//    Return: TaskInfo - (String description of Task)	                                                    
//	    TaskDescription- TaskTitle (first parameter), TaskStartDate = TaskBeginDate (second parameter)
//                     TaskEndDate = TaskComplete (third parameter                                     
//    TaskStartDate - Current time when task is created                            
//    TaskEndDate   - One week from Start Date                                       	    
/***********************************************************************************************/	    
	    
	    public String toString(String TaskTitle, String TaskBeginDate, String TaskCompleteDate) {
	    	TaskDescription = TaskTitle; 	    	
	    	TaskStartDate = TaskBeginDate;	    	
	    	TaskEndDate = TaskCompleteDate;
	    	String TaskInfo = "The Task is: " + TaskDescription + "\n" +"The Start Date for Task is: " + TaskStartDate + "\n" + "The End Date for Task is: " + TaskEndDate + "\n\n";
	    	return TaskInfo;
	    }
	    

	
	
	

 
 
}


/**************
 *  Implement A TaskFilters interface class
 */
	    
public static class TaskFilterImplem implements TaskFilter {
	
	public Task[] sortbydate( Task[] tasks, boolean dataflag) {
		System.out.println("In sortbydate of TaskFilterImplem method" + "\n");
		return(tasks);
	}
		
	public Task[] sortbydoctor( Task[] tasks, boolean alphaflag) {
		System.out.println("In sortbydoctor of TaskFilterImplem method" + "\n");
		return(tasks);
		
	}
	
}	


}




