/************************************************
 *  File:		Ch4Demo
 *  Author:		J.Foy
 *  Created:	7/14/2015
 *  Demos several Chapter 4 concepts
 *  Revision History
 *  	Rev 0:	Initial Release
 *  
 */

// Explorations:
// Number 1: in file LNStudent, change the second constructor so it
//        has your name, ID in it
// Number 2: in file LNStudent, comment out the "toString" method, then
//        run the program
// Number 3: Write four lines of code at the end, with a header, which
//        print student name and year.  Use methods in LNStudent
// 

import java.util.*;


public class Ch4Demo 
{

	public static void main(String[] args) 
	{
	LNStudent s1, s2, s3, s4;
	
	
	// following objects created with one constructor
	s1 = new LNStudent("Katy Perry", "S745592", 2017, "865-406-3345");
	s2 = new LNStudent("No Body", "S000000", 1111, "865-215-4532");
	s3 = new LNStudent("George Louis", "S42000", 2027, "44-200-312-06601");
  
	// object s4 created with the second constructor
	s4 = new LNStudent("Patrick Wooden", "S960339", 2015, "867-5309");
	
	System.out.println("Phone number for " + s3.getName());
	System.out.println(s3.getPhNr());
	s3.setPhNr("44-201-313-5571");
	System.out.println("Updated phone number for " + s3.getName());
	System.out.println(s3.getPhNr());
	
	System.out.println("Student ID for " +s1.getName() + " is "+ s1.getID());
	
	// print out the four students
	System.out.println(s1);
	System.out.println(s2);
	System.out.println(s3);
	System.out.println(s4);
	
	// Exploration number 3 code goes below this line...
	System.out.println("Name\t\tYear");
	System.out.println("-----------\t------");
	System.out.println(s4.getName() + "\t" +  s4.getYear());
	System.out.println(s1.getName() + "\t" +  s1.getYear());
	System.out.println(s2.getName() + "\t\t" +  s2.getYear());
	System.out.println(s3.getName() + "\t" +  s3.getYear());
	
	} // end of main

}  // end of class
