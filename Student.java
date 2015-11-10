// ****************************************************************
//   Student.java 
//
//   Define a student class that stores name, score on test 1, and 
//   score on test 2.  Methods prompt for and read in grades, 
//   compute the average, and return a string containing student’s info. 
// ****************************************************************
import java.util.Scanner; 
import java.text.DecimalFormat;
public class Student {     
	private double t1g, t2g;
	private String name;
	private double avg;
	public static Scanner scan = new Scanner(System.in);
	public static DecimalFormat fmt = new DecimalFormat("####.00");
	//declare instance data    
	//-----------------------------------------------    
	//constructor     
	//-----------------------------------------------     
	public Student(String studentName)     {  
			name = studentName;
			}
			
	//-----------------------------------------------     
	//inputGrades: prompt for and read in student's grades for test1 and test2.     
	//Use name in prompts, e.g., "Enter's Joe's score for test1".    
	//-----------------------------------------------     
	public void inputGrades()     {  
		System.out.print("What is " + name + "'s grade for test1?: ");
		t1g = scan.nextDouble();
		System.out.print("\nWhat is " + name + "'s grade for test2?: ");
		t2g = scan.nextDouble();
		//add body of inputGrades    
		}    
	//-----------------------------------------------    
	//getAverage: compute and return the student's test average    
	//-----------------------------------------------    
	//add header for getAverage  
	public double getAverage() {
		avg = ((t1g + t2g) / 2);
		System.out.println(name + "'s average score is: " + fmt.format(avg) + ".");
		return avg;
	
	//add body of getAverage   
		}     
	//-----------------------------------------------     
	//getName: print the student's name    
	//-----------------------------------------------    
	//add header for printName    
	public String printName() {  
		System.out.println("The student's name is " + name);
		String sname = name;
		return sname;

		} 
	}
